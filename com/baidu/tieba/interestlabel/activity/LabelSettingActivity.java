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
/* loaded from: classes17.dex */
public class LabelSettingActivity extends BaseActivity<LabelSettingActivity> implements a {
    private LabelSettingView jLd;
    private LabelSettingModel jLe;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jLd = new LabelSettingView(getPageContext(), this);
        this.jLe = new LabelSettingModel(getPageContext());
        setContentView(this.jLd);
        this.jLe.a(this);
        cLh();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void cLh() {
        if (!j.isNetworkAvailableForImmediately()) {
            this.jLd.hideLoadingView();
            this.jLd.nM(true);
            return;
        }
        this.jLd.bFX();
        this.jLd.gT(true);
        this.jLe.cLn();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void dS(List<Integer> list) {
        if (!j.isNetworkAvailableForImmediately()) {
            showToast(R.string.neterror);
        } else {
            this.jLe.dT(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.jLd.hideLoadingView();
                if (bVar == null || y.isEmpty(bVar.cLl())) {
                    this.jLd.nM(true);
                    return;
                }
                this.jLd.bFX();
                this.jLd.setData(bVar);
                return;
            case SUB_LABEL:
                if (i == 0) {
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
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
        this.jLd.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.jLd != null && this.jLd.cLx()) {
            this.jLd.Nv();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
