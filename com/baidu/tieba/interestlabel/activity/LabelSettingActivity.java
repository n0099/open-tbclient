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
/* loaded from: classes17.dex */
public class LabelSettingActivity extends BaseActivity<LabelSettingActivity> implements a {
    private LabelSettingView jKX;
    private LabelSettingModel jKY;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jKX = new LabelSettingView(getPageContext(), this);
        this.jKY = new LabelSettingModel(getPageContext());
        setContentView(this.jKX);
        this.jKY.a(this);
        cLg();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void cLg() {
        if (!j.isNetworkAvailableForImmediately()) {
            this.jKX.hideLoadingView();
            this.jKX.nK(true);
            return;
        }
        this.jKX.bFW();
        this.jKX.gS(true);
        this.jKY.cLm();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void dS(List<Integer> list) {
        if (!j.isNetworkAvailableForImmediately()) {
            showToast(R.string.neterror);
        } else {
            this.jKY.dT(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.jKX.hideLoadingView();
                if (bVar == null || y.isEmpty(bVar.cLk())) {
                    this.jKX.nK(true);
                    return;
                }
                this.jKX.bFW();
                this.jKX.setData(bVar);
                return;
            case SUB_LABEL:
                if (i == 0) {
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
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
        this.jKX.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.jKX != null && this.jKX.cLw()) {
            this.jKX.Nv();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
