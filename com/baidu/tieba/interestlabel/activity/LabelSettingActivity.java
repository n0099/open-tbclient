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
    private LabelSettingView kOE;
    private LabelSettingModel kOF;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kOE = new LabelSettingView(getPageContext(), this);
        this.kOF = new LabelSettingModel(getPageContext());
        setContentView(this.kOE);
        this.kOF.a(this);
        dcK();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void dcK() {
        if (!j.isNetworkAvailableForImmediately()) {
            this.kOE.hideLoadingView();
            this.kOE.px(true);
            return;
        }
        this.kOE.Yb();
        this.kOE.ib(true);
        this.kOF.dcQ();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void eF(List<Integer> list) {
        if (!j.isNetworkAvailableForImmediately()) {
            showToast(R.string.neterror);
        } else {
            this.kOF.eG(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.kOE.hideLoadingView();
                if (bVar == null || y.isEmpty(bVar.dcO())) {
                    this.kOE.px(true);
                    return;
                }
                this.kOE.Yb();
                this.kOE.setData(bVar);
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
        this.kOE.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.kOE != null && this.kOE.dda()) {
            this.kOE.RU();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
