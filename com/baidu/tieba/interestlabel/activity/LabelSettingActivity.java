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
/* loaded from: classes10.dex */
public class LabelSettingActivity extends BaseActivity<LabelSettingActivity> implements a {
    private LabelSettingView iUW;
    private LabelSettingModel iUX;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iUW = new LabelSettingView(getPageContext(), this);
        this.iUX = new LabelSettingModel(getPageContext());
        setContentView(this.iUW);
        this.iUX.a(this);
        csq();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void csq() {
        if (!j.isNetworkAvailableForImmediately()) {
            this.iUW.hideLoadingView();
            this.iUW.mq(true);
            return;
        }
        this.iUW.bqO();
        this.iUW.fV(true);
        this.iUX.csw();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void dp(List<Integer> list) {
        if (!j.isNetworkAvailableForImmediately()) {
            showToast(R.string.neterror);
        } else {
            this.iUX.dq(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.iUW.hideLoadingView();
                if (bVar == null || v.isEmpty(bVar.csu())) {
                    this.iUW.mq(true);
                    return;
                }
                this.iUW.bqO();
                this.iUW.setData(bVar);
                return;
            case SUB_LABEL:
                if (i == 0) {
                    com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
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
        this.iUW.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.iUW != null && this.iUW.csG()) {
            this.iUW.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
