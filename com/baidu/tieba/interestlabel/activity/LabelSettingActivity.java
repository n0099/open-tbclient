package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.interestlabel.b.b;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.tieba.interestlabel.model.a;
import com.baidu.tieba.interestlabel.view.LabelSettingView;
import java.util.List;
/* loaded from: classes3.dex */
public class LabelSettingActivity extends BaseActivity<LabelSettingActivity> implements a {
    private LabelSettingView fnf;
    private LabelSettingModel fng;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fnf = new LabelSettingView(getPageContext(), this);
        this.fng = new LabelSettingModel(getPageContext());
        setContentView(this.fnf);
        this.fng.a(this);
        aYl();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void aYl() {
        if (!j.kK()) {
            this.fnf.hideLoadingView();
            this.fnf.js(true);
            return;
        }
        this.fnf.abx();
        this.fnf.showLoadingView(true);
        this.fng.aYr();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void cQ(List<Integer> list) {
        if (!j.kK()) {
            showToast(e.j.neterror);
        } else {
            this.fng.cR(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.fnf.hideLoadingView();
                if (bVar == null || v.I(bVar.aYp())) {
                    this.fnf.js(true);
                    return;
                }
                this.fnf.abx();
                this.fnf.setData(bVar);
                return;
            case SUB_LABEL:
                if (i == 0) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("set_recommend_label", true);
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
        this.fnf.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.fnf != null && this.fnf.aYB()) {
            this.fnf.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
