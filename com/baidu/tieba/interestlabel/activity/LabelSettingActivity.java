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
/* loaded from: classes23.dex */
public class LabelSettingActivity extends BaseActivity<LabelSettingActivity> implements a {
    private LabelSettingView kiF;
    private LabelSettingModel kiG;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kiF = new LabelSettingView(getPageContext(), this);
        this.kiG = new LabelSettingModel(getPageContext());
        setContentView(this.kiF);
        this.kiG.a(this);
        cSv();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void cSv() {
        if (!j.isNetworkAvailableForImmediately()) {
            this.kiF.hideLoadingView();
            this.kiF.ox(true);
            return;
        }
        this.kiF.SK();
        this.kiF.hn(true);
        this.kiG.cSB();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void ed(List<Integer> list) {
        if (!j.isNetworkAvailableForImmediately()) {
            showToast(R.string.neterror);
        } else {
            this.kiG.ee(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.kiF.hideLoadingView();
                if (bVar == null || y.isEmpty(bVar.cSz())) {
                    this.kiF.ox(true);
                    return;
                }
                this.kiF.SK();
                this.kiF.setData(bVar);
                return;
            case SUB_LABEL:
                if (i == 0) {
                    com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
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
        this.kiF.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.kiF != null && this.kiF.cSL()) {
            this.kiF.Pd();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
