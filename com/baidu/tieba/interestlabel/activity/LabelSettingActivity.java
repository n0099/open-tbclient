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
    private LabelSettingView kAX;
    private LabelSettingModel kAY;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kAX = new LabelSettingView(getPageContext(), this);
        this.kAY = new LabelSettingModel(getPageContext());
        setContentView(this.kAX);
        this.kAY.a(this);
        cYd();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void cYd() {
        if (!j.isNetworkAvailableForImmediately()) {
            this.kAX.hideLoadingView();
            this.kAX.oY(true);
            return;
        }
        this.kAX.Wk();
        this.kAX.hJ(true);
        this.kAY.cYj();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void eu(List<Integer> list) {
        if (!j.isNetworkAvailableForImmediately()) {
            showToast(R.string.neterror);
        } else {
            this.kAY.ev(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.kAX.hideLoadingView();
                if (bVar == null || y.isEmpty(bVar.cYh())) {
                    this.kAX.oY(true);
                    return;
                }
                this.kAX.Wk();
                this.kAX.setData(bVar);
                return;
            case SUB_LABEL:
                if (i == 0) {
                    com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
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
        this.kAX.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.kAX != null && this.kAX.cYt()) {
            this.kAX.Qj();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
