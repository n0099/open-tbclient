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
    private LabelSettingView fmk;
    private LabelSettingModel fml;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fmk = new LabelSettingView(getPageContext(), this);
        this.fml = new LabelSettingModel(getPageContext());
        setContentView(this.fmk);
        this.fml.a(this);
        aXL();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void aXL() {
        if (!j.kK()) {
            this.fmk.hideLoadingView();
            this.fmk.js(true);
            return;
        }
        this.fmk.aba();
        this.fmk.showLoadingView(true);
        this.fml.aXR();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void cP(List<Integer> list) {
        if (!j.kK()) {
            showToast(e.j.neterror);
        } else {
            this.fml.cQ(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.fmk.hideLoadingView();
                if (bVar == null || v.I(bVar.aXP())) {
                    this.fmk.js(true);
                    return;
                }
                this.fmk.aba();
                this.fmk.setData(bVar);
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
        this.fmk.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.fmk != null && this.fmk.aYb()) {
            this.fmk.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
