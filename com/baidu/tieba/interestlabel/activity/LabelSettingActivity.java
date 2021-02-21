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
/* loaded from: classes8.dex */
public class LabelSettingActivity extends BaseActivity<LabelSettingActivity> implements a {
    private LabelSettingView kXW;
    private LabelSettingModel kXX;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kXW = new LabelSettingView(getPageContext(), this);
        this.kXX = new LabelSettingModel(getPageContext());
        setContentView(this.kXW);
        this.kXX.a(this);
        daJ();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void daJ() {
        if (!j.isNetworkAvailableForImmediately()) {
            this.kXW.hideLoadingView();
            this.kXW.qa(true);
            return;
        }
        this.kXW.WZ();
        this.kXW.ir(true);
        this.kXX.daP();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void eD(List<Integer> list) {
        if (!j.isNetworkAvailableForImmediately()) {
            showToast(R.string.neterror);
        } else {
            this.kXX.eE(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.kXW.hideLoadingView();
                if (bVar == null || y.isEmpty(bVar.daN())) {
                    this.kXW.qa(true);
                    return;
                }
                this.kXW.WZ();
                this.kXW.setData(bVar);
                return;
            case SUB_LABEL:
                if (i == 0) {
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
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
        this.kXW.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.kXW != null && this.kXW.daZ()) {
            this.kXW.QE();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
