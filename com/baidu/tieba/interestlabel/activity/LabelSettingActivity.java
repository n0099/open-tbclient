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
    private LabelSettingView kOG;
    private LabelSettingModel kOH;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kOG = new LabelSettingView(getPageContext(), this);
        this.kOH = new LabelSettingModel(getPageContext());
        setContentView(this.kOG);
        this.kOH.a(this);
        dcL();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void dcL() {
        if (!j.isNetworkAvailableForImmediately()) {
            this.kOG.hideLoadingView();
            this.kOG.px(true);
            return;
        }
        this.kOG.Yb();
        this.kOG.ib(true);
        this.kOH.dcR();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void eF(List<Integer> list) {
        if (!j.isNetworkAvailableForImmediately()) {
            showToast(R.string.neterror);
        } else {
            this.kOH.eG(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.kOG.hideLoadingView();
                if (bVar == null || y.isEmpty(bVar.dcP())) {
                    this.kOG.px(true);
                    return;
                }
                this.kOG.Yb();
                this.kOG.setData(bVar);
                return;
            case SUB_LABEL:
                if (i == 0) {
                    com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
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
        this.kOG.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.kOG != null && this.kOG.ddb()) {
            this.kOG.RU();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
