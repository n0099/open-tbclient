package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.b.b;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.tieba.interestlabel.model.a;
import com.baidu.tieba.interestlabel.view.LabelSettingView;
import java.util.List;
/* loaded from: classes22.dex */
public class LabelSettingActivity extends BaseActivity<LabelSettingActivity> implements a {
    private LabelSettingView jTF;
    private LabelSettingModel jTG;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jTF = new LabelSettingView(getPageContext(), this);
        this.jTG = new LabelSettingModel(getPageContext());
        setContentView(this.jTF);
        this.jTG.a(this);
        cON();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void cON() {
        if (!j.isNetworkAvailableForImmediately()) {
            this.jTF.hideLoadingView();
            this.jTF.nS(true);
            return;
        }
        this.jTF.bHn();
        this.jTF.gR(true);
        this.jTG.cOT();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void ea(List<Integer> list) {
        if (!j.isNetworkAvailableForImmediately()) {
            showToast(R.string.neterror);
        } else {
            this.jTG.eb(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.jTF.hideLoadingView();
                if (bVar == null || y.isEmpty(bVar.cOR())) {
                    this.jTF.nS(true);
                    return;
                }
                this.jTF.bHn();
                this.jTF.setData(bVar);
                return;
            case SUB_LABEL:
                if (i == 0) {
                    com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
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
        this.jTF.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.jTF != null && this.jTF.cPd()) {
            this.jTF.NY();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
