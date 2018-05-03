package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.interestlabel.b.b;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.tieba.interestlabel.model.a;
import com.baidu.tieba.interestlabel.view.LabelSettingView;
import java.util.List;
/* loaded from: classes3.dex */
public class LabelSettingActivity extends BaseActivity<LabelSettingActivity> implements a {
    private LabelSettingView erZ;
    private LabelSettingModel esa;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.erZ = new LabelSettingView(getPageContext(), this);
        this.esa = new LabelSettingModel(getPageContext());
        setContentView(this.erZ);
        this.esa.a(this);
        aJJ();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void aJJ() {
        if (!j.gD()) {
            this.erZ.Ou();
            this.erZ.hS(true);
            return;
        }
        this.erZ.Qn();
        this.erZ.gA(true);
        this.esa.aJP();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void ck(List<Integer> list) {
        if (!j.gD()) {
            showToast(d.k.neterror);
        } else {
            this.esa.cl(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.erZ.Ou();
                if (bVar == null || v.w(bVar.aJN())) {
                    this.erZ.hS(true);
                    return;
                }
                this.erZ.Qn();
                this.erZ.setData(bVar);
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
        this.erZ.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.erZ != null && this.erZ.aJZ()) {
            this.erZ.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
