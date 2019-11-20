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
/* loaded from: classes5.dex */
public class LabelSettingActivity extends BaseActivity<LabelSettingActivity> implements a {
    private LabelSettingView haE;
    private LabelSettingModel haF;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.haE = new LabelSettingView(getPageContext(), this);
        this.haF = new LabelSettingModel(getPageContext());
        setContentView(this.haE);
        this.haF.a(this);
        bGS();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void bGS() {
        if (!j.isNetworkAvailableForImmediately()) {
            this.haE.hideLoadingView();
            this.haE.jm(true);
            return;
        }
        this.haE.aJm();
        this.haE.dp(true);
        this.haF.bGY();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void dv(List<Integer> list) {
        if (!j.isNetworkAvailableForImmediately()) {
            showToast(R.string.neterror);
        } else {
            this.haF.dw(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.haE.hideLoadingView();
                if (bVar == null || v.isEmpty(bVar.bGW())) {
                    this.haE.jm(true);
                    return;
                }
                this.haE.aJm();
                this.haE.setData(bVar);
                return;
            case SUB_LABEL:
                if (i == 0) {
                    com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
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
        this.haE.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.haE != null && this.haE.bHi()) {
            this.haE.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
