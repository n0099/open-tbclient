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
/* loaded from: classes8.dex */
public class LabelSettingActivity extends BaseActivity<LabelSettingActivity> implements a {
    private LabelSettingView hSp;
    private LabelSettingModel hSq;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hSp = new LabelSettingView(getPageContext(), this);
        this.hSq = new LabelSettingModel(getPageContext());
        setContentView(this.hSp);
        this.hSq.a(this);
        bZr();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void bZr() {
        if (!j.isNetworkAvailableForImmediately()) {
            this.hSp.hideLoadingView();
            this.hSp.kJ(true);
            return;
        }
        this.hSp.baf();
        this.hSp.eF(true);
        this.hSq.bZx();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void dk(List<Integer> list) {
        if (!j.isNetworkAvailableForImmediately()) {
            showToast(R.string.neterror);
        } else {
            this.hSq.dl(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.hSp.hideLoadingView();
                if (bVar == null || v.isEmpty(bVar.bZv())) {
                    this.hSp.kJ(true);
                    return;
                }
                this.hSp.baf();
                this.hSp.setData(bVar);
                return;
            case SUB_LABEL:
                if (i == 0) {
                    com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
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
        this.hSp.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.hSp != null && this.hSp.bZH()) {
            this.hSp.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
