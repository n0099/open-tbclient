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
    private LabelSettingView fbh;
    private LabelSettingModel fbi;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fbh = new LabelSettingView(getPageContext(), this);
        this.fbi = new LabelSettingModel(getPageContext());
        setContentView(this.fbh);
        this.fbi.a(this);
        aVJ();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void aVJ() {
        if (!j.kM()) {
            this.fbh.hideLoadingView();
            this.fbh.jc(true);
            return;
        }
        this.fbh.ZI();
        this.fbh.hK(true);
        this.fbi.aVP();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void cM(List<Integer> list) {
        if (!j.kM()) {
            showToast(e.j.neterror);
        } else {
            this.fbi.cN(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.fbh.hideLoadingView();
                if (bVar == null || v.J(bVar.aVN())) {
                    this.fbh.jc(true);
                    return;
                }
                this.fbh.ZI();
                this.fbh.setData(bVar);
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
        this.fbh.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.fbh != null && this.fbh.aVZ()) {
            this.fbh.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
