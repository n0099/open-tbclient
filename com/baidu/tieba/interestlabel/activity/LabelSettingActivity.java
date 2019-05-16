package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.adp.lib.util.j;
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
    private LabelSettingView gUq;
    private LabelSettingModel gUr;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gUq = new LabelSettingView(getPageContext(), this);
        this.gUr = new LabelSettingModel(getPageContext());
        setContentView(this.gUq);
        this.gUr.a(this);
        bGy();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void bGy() {
        if (!j.jG()) {
            this.gUq.hideLoadingView();
            this.gUq.jk(true);
            return;
        }
        this.gUq.aHH();
        this.gUq.cV(true);
        this.gUr.bGE();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void dh(List<Integer> list) {
        if (!j.jG()) {
            showToast(R.string.neterror);
        } else {
            this.gUr.di(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.gUq.hideLoadingView();
                if (bVar == null || v.aa(bVar.bGC())) {
                    this.gUq.jk(true);
                    return;
                }
                this.gUq.aHH();
                this.gUq.setData(bVar);
                return;
            case SUB_LABEL:
                if (i == 0) {
                    com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("set_recommend_label", true);
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
        this.gUq.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.gUq != null && this.gUq.bGO()) {
            this.gUq.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
