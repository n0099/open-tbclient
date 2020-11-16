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
    private LabelSettingView kBm;
    private LabelSettingModel kBn;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kBm = new LabelSettingView(getPageContext(), this);
        this.kBn = new LabelSettingModel(getPageContext());
        setContentView(this.kBm);
        this.kBn.a(this);
        cXz();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void cXz() {
        if (!j.isNetworkAvailableForImmediately()) {
            this.kBm.hideLoadingView();
            this.kBm.pb(true);
            return;
        }
        this.kBm.VB();
        this.kBm.hM(true);
        this.kBn.cXF();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void eu(List<Integer> list) {
        if (!j.isNetworkAvailableForImmediately()) {
            showToast(R.string.neterror);
        } else {
            this.kBn.ev(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.kBm.hideLoadingView();
                if (bVar == null || y.isEmpty(bVar.cXD())) {
                    this.kBm.pb(true);
                    return;
                }
                this.kBm.VB();
                this.kBm.setData(bVar);
                return;
            case SUB_LABEL:
                if (i == 0) {
                    com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
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
        this.kBm.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.kBm != null && this.kBm.cXP()) {
            this.kBm.PA();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
