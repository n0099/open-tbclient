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
/* loaded from: classes7.dex */
public class LabelSettingActivity extends BaseActivity<LabelSettingActivity> implements a {
    private LabelSettingView hOM;
    private LabelSettingModel hON;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hOM = new LabelSettingView(getPageContext(), this);
        this.hON = new LabelSettingModel(getPageContext());
        setContentView(this.hOM);
        this.hON.a(this);
        bYi();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void bYi() {
        if (!j.isNetworkAvailableForImmediately()) {
            this.hOM.hideLoadingView();
            this.hOM.ky(true);
            return;
        }
        this.hOM.aZK();
        this.hOM.eA(true);
        this.hON.bYo();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void dk(List<Integer> list) {
        if (!j.isNetworkAvailableForImmediately()) {
            showToast(R.string.neterror);
        } else {
            this.hON.dl(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.hOM.hideLoadingView();
                if (bVar == null || v.isEmpty(bVar.bYm())) {
                    this.hOM.ky(true);
                    return;
                }
                this.hOM.aZK();
                this.hOM.setData(bVar);
                return;
            case SUB_LABEL:
                if (i == 0) {
                    com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
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
        this.hOM.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.hOM != null && this.hOM.bYy()) {
            this.hOM.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
