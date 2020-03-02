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
    private LabelSettingView hUp;
    private LabelSettingModel hUq;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hUp = new LabelSettingView(getPageContext(), this);
        this.hUq = new LabelSettingModel(getPageContext());
        setContentView(this.hUp);
        this.hUq.a(this);
        caU();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void caU() {
        if (!j.isNetworkAvailableForImmediately()) {
            this.hUp.hideLoadingView();
            this.hUp.kN(true);
            return;
        }
        this.hUp.bcx();
        this.hUp.eM(true);
        this.hUq.cba();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void dg(List<Integer> list) {
        if (!j.isNetworkAvailableForImmediately()) {
            showToast(R.string.neterror);
        } else {
            this.hUq.dh(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.hUp.hideLoadingView();
                if (bVar == null || v.isEmpty(bVar.caY())) {
                    this.hUp.kN(true);
                    return;
                }
                this.hUp.bcx();
                this.hUp.setData(bVar);
                return;
            case SUB_LABEL:
                if (i == 0) {
                    com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
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
        this.hUp.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.hUp != null && this.hUp.cbk()) {
            this.hUp.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
