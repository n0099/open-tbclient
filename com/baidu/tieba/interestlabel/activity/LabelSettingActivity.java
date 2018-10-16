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
    private LabelSettingView fbg;
    private LabelSettingModel fbh;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fbg = new LabelSettingView(getPageContext(), this);
        this.fbh = new LabelSettingModel(getPageContext());
        setContentView(this.fbg);
        this.fbh.a(this);
        aVJ();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void aVJ() {
        if (!j.kM()) {
            this.fbg.hideLoadingView();
            this.fbg.jc(true);
            return;
        }
        this.fbg.ZH();
        this.fbg.hK(true);
        this.fbh.aVP();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void cM(List<Integer> list) {
        if (!j.kM()) {
            showToast(e.j.neterror);
        } else {
            this.fbh.cN(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.fbg.hideLoadingView();
                if (bVar == null || v.J(bVar.aVN())) {
                    this.fbg.jc(true);
                    return;
                }
                this.fbg.ZH();
                this.fbg.setData(bVar);
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
        this.fbg.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.fbg != null && this.fbg.aVZ()) {
            this.fbg.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
