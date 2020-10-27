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
    private LabelSettingView kvc;
    private LabelSettingModel kvd;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kvc = new LabelSettingView(getPageContext(), this);
        this.kvd = new LabelSettingModel(getPageContext());
        setContentView(this.kvc);
        this.kvd.a(this);
        cVC();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void cVC() {
        if (!j.isNetworkAvailableForImmediately()) {
            this.kvc.hideLoadingView();
            this.kvc.oP(true);
            return;
        }
        this.kvc.TK();
        this.kvc.hA(true);
        this.kvd.cVI();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void em(List<Integer> list) {
        if (!j.isNetworkAvailableForImmediately()) {
            showToast(R.string.neterror);
        } else {
            this.kvd.en(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.kvc.hideLoadingView();
                if (bVar == null || y.isEmpty(bVar.cVG())) {
                    this.kvc.oP(true);
                    return;
                }
                this.kvc.TK();
                this.kvc.setData(bVar);
                return;
            case SUB_LABEL:
                if (i == 0) {
                    com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
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
        this.kvc.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.kvc != null && this.kvc.cVS()) {
            this.kvc.PJ();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
