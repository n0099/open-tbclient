package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.b.b;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.tieba.interestlabel.model.a;
import com.baidu.tieba.interestlabel.view.LabelSettingView;
import java.util.List;
/* loaded from: classes17.dex */
public class LabelSettingActivity extends BaseActivity<LabelSettingActivity> implements a {
    private LabelSettingView jvA;
    private LabelSettingModel jvB;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jvA = new LabelSettingView(getPageContext(), this);
        this.jvB = new LabelSettingModel(getPageContext());
        setContentView(this.jvA);
        this.jvB.a(this);
        cAo();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void cAo() {
        if (!j.isNetworkAvailableForImmediately()) {
            this.jvA.hideLoadingView();
            this.jvA.ng(true);
            return;
        }
        this.jvA.bwX();
        this.jvA.gw(true);
        this.jvB.cAu();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void dL(List<Integer> list) {
        if (!j.isNetworkAvailableForImmediately()) {
            showToast(R.string.neterror);
        } else {
            this.jvB.dM(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.jvA.hideLoadingView();
                if (bVar == null || x.isEmpty(bVar.cAs())) {
                    this.jvA.ng(true);
                    return;
                }
                this.jvA.bwX();
                this.jvA.setData(bVar);
                return;
            case SUB_LABEL:
                if (i == 0) {
                    com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
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
        this.jvA.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.jvA != null && this.jvA.cAE()) {
            this.jvA.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
