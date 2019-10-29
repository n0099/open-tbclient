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
    private LabelSettingView hbv;
    private LabelSettingModel hbw;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hbv = new LabelSettingView(getPageContext(), this);
        this.hbw = new LabelSettingModel(getPageContext());
        setContentView(this.hbv);
        this.hbw.a(this);
        bGU();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void bGU() {
        if (!j.isNetworkAvailableForImmediately()) {
            this.hbv.hideLoadingView();
            this.hbv.jm(true);
            return;
        }
        this.hbv.aJo();
        this.hbv.dp(true);
        this.hbw.bHa();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void dv(List<Integer> list) {
        if (!j.isNetworkAvailableForImmediately()) {
            showToast(R.string.neterror);
        } else {
            this.hbw.dw(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.hbv.hideLoadingView();
                if (bVar == null || v.isEmpty(bVar.bGY())) {
                    this.hbv.jm(true);
                    return;
                }
                this.hbv.aJo();
                this.hbv.setData(bVar);
                return;
            case SUB_LABEL:
                if (i == 0) {
                    com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
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
        this.hbv.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.hbv != null && this.hbv.bHk()) {
            this.hbv.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
