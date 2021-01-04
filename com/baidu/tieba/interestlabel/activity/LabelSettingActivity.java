package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.b.b;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.tieba.interestlabel.model.a;
import com.baidu.tieba.interestlabel.view.LabelSettingView;
import java.util.List;
/* loaded from: classes8.dex */
public class LabelSettingActivity extends BaseActivity<LabelSettingActivity> implements a {
    private LabelSettingView kUl;
    private LabelSettingModel kUm;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kUl = new LabelSettingView(getPageContext(), this);
        this.kUm = new LabelSettingModel(getPageContext());
        setContentView(this.kUl);
        this.kUm.a(this);
        dcv();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void dcv() {
        if (!j.isNetworkAvailableForImmediately()) {
            this.kUl.hideLoadingView();
            this.kUl.pU(true);
            return;
        }
        this.kUl.Zi();
        this.kUl.it(true);
        this.kUm.dcB();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void eF(List<Integer> list) {
        if (!j.isNetworkAvailableForImmediately()) {
            showToast(R.string.neterror);
        } else {
            this.kUm.eG(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.kUl.hideLoadingView();
                if (bVar == null || x.isEmpty(bVar.dcz())) {
                    this.kUl.pU(true);
                    return;
                }
                this.kUl.Zi();
                this.kUl.setData(bVar);
                return;
            case SUB_LABEL:
                if (i == 0) {
                    com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
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
        this.kUl.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.kUl != null && this.kUl.dcL()) {
            this.kUl.SY();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
