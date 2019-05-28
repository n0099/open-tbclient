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
    private LabelSettingView gUt;
    private LabelSettingModel gUu;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gUt = new LabelSettingView(getPageContext(), this);
        this.gUu = new LabelSettingModel(getPageContext());
        setContentView(this.gUt);
        this.gUu.a(this);
        bGB();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void bGB() {
        if (!j.jG()) {
            this.gUt.hideLoadingView();
            this.gUt.jk(true);
            return;
        }
        this.gUt.aHK();
        this.gUt.cV(true);
        this.gUu.bGH();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void dh(List<Integer> list) {
        if (!j.jG()) {
            showToast(R.string.neterror);
        } else {
            this.gUu.di(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.gUt.hideLoadingView();
                if (bVar == null || v.aa(bVar.bGF())) {
                    this.gUt.jk(true);
                    return;
                }
                this.gUt.aHK();
                this.gUt.setData(bVar);
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
        this.gUt.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.gUt != null && this.gUt.bGR()) {
            this.gUt.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
