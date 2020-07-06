package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.b.b;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.tieba.interestlabel.model.a;
import com.baidu.tieba.interestlabel.view.LabelSettingView;
import java.util.List;
/* loaded from: classes10.dex */
public class LabelSettingActivity extends BaseActivity<LabelSettingActivity> implements a {
    private LabelSettingView jmW;
    private LabelSettingModel jmX;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jmW = new LabelSettingView(getPageContext(), this);
        this.jmX = new LabelSettingModel(getPageContext());
        setContentView(this.jmW);
        this.jmX.a(this);
        cwq();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void cwq() {
        if (!j.isNetworkAvailableForImmediately()) {
            this.jmW.hideLoadingView();
            this.jmW.mB(true);
            return;
        }
        this.jmW.btO();
        this.jmW.ga(true);
        this.jmX.cww();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void dE(List<Integer> list) {
        if (!j.isNetworkAvailableForImmediately()) {
            showToast(R.string.neterror);
        } else {
            this.jmX.dF(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.jmW.hideLoadingView();
                if (bVar == null || w.isEmpty(bVar.cwu())) {
                    this.jmW.mB(true);
                    return;
                }
                this.jmW.btO();
                this.jmW.setData(bVar);
                return;
            case SUB_LABEL:
                if (i == 0) {
                    com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
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
        this.jmW.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.jmW != null && this.jmW.cwG()) {
            this.jmW.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
