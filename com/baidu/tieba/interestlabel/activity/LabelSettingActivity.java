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
    private LabelSettingView iVJ;
    private LabelSettingModel iVK;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iVJ = new LabelSettingView(getPageContext(), this);
        this.iVK = new LabelSettingModel(getPageContext());
        setContentView(this.iVJ);
        this.iVK.a(this);
        csz();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void csz() {
        if (!j.isNetworkAvailableForImmediately()) {
            this.iVJ.hideLoadingView();
            this.iVJ.mq(true);
            return;
        }
        this.iVJ.bqQ();
        this.iVJ.fV(true);
        this.iVK.csF();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void dq(List<Integer> list) {
        if (!j.isNetworkAvailableForImmediately()) {
            showToast(R.string.neterror);
        } else {
            this.iVK.dr(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.iVJ.hideLoadingView();
                if (bVar == null || v.isEmpty(bVar.csD())) {
                    this.iVJ.mq(true);
                    return;
                }
                this.iVJ.bqQ();
                this.iVJ.setData(bVar);
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
        this.iVJ.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.iVJ != null && this.iVJ.csP()) {
            this.iVJ.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
