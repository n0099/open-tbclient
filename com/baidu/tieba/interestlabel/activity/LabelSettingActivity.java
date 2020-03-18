package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.b.b;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.tieba.interestlabel.model.a;
import com.baidu.tieba.interestlabel.view.LabelSettingView;
import java.util.List;
/* loaded from: classes10.dex */
public class LabelSettingActivity extends BaseActivity<LabelSettingActivity> implements a {
    private LabelSettingView hWb;
    private LabelSettingModel hWc;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hWb = new LabelSettingView(getPageContext(), this);
        this.hWc = new LabelSettingModel(getPageContext());
        setContentView(this.hWb);
        this.hWc.a(this);
        cbo();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void cbo() {
        if (!j.isNetworkAvailableForImmediately()) {
            this.hWb.hideLoadingView();
            this.hWb.kS(true);
            return;
        }
        this.hWb.bcC();
        this.hWb.eN(true);
        this.hWc.cbu();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void dg(List<Integer> list) {
        if (!j.isNetworkAvailableForImmediately()) {
            showToast(R.string.neterror);
        } else {
            this.hWc.dh(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.hWb.hideLoadingView();
                if (bVar == null || v.isEmpty(bVar.cbs())) {
                    this.hWb.kS(true);
                    return;
                }
                this.hWb.bcC();
                this.hWb.setData(bVar);
                return;
            case SUB_LABEL:
                if (i == 0) {
                    com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
                    finish();
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hWb.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.hWb != null && this.hWb.cbE()) {
            this.hWb.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
