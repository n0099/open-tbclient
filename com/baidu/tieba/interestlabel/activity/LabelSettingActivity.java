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
    private LabelSettingView fcB;
    private LabelSettingModel fcC;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fcB = new LabelSettingView(getPageContext(), this);
        this.fcC = new LabelSettingModel(getPageContext());
        setContentView(this.fcB);
        this.fcC.a(this);
        aVg();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void aVg() {
        if (!j.kK()) {
            this.fcB.hideLoadingView();
            this.fcB.jm(true);
            return;
        }
        this.fcB.ZS();
        this.fcB.showLoadingView(true);
        this.fcC.aVm();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void cK(List<Integer> list) {
        if (!j.kK()) {
            showToast(e.j.neterror);
        } else {
            this.fcC.cL(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.fcB.hideLoadingView();
                if (bVar == null || v.I(bVar.aVk())) {
                    this.fcB.jm(true);
                    return;
                }
                this.fcB.ZS();
                this.fcB.setData(bVar);
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
        this.fcB.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.fcB != null && this.fcB.aVw()) {
            this.fcB.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
