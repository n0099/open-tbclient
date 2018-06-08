package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.interestlabel.b.b;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.tieba.interestlabel.model.a;
import com.baidu.tieba.interestlabel.view.LabelSettingView;
import java.util.List;
/* loaded from: classes3.dex */
public class LabelSettingActivity extends BaseActivity<LabelSettingActivity> implements a {
    private LabelSettingView eEy;
    private LabelSettingModel eEz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eEy = new LabelSettingView(getPageContext(), this);
        this.eEz = new LabelSettingModel(getPageContext());
        setContentView(this.eEy);
        this.eEz.a(this);
        aOE();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void aOE() {
        if (!j.jr()) {
            this.eEy.hideLoadingView();
            this.eEy.hZ(true);
            return;
        }
        this.eEy.TI();
        this.eEy.gH(true);
        this.eEz.aOK();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void cs(List<Integer> list) {
        if (!j.jr()) {
            showToast(d.k.neterror);
        } else {
            this.eEz.ct(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.eEy.hideLoadingView();
                if (bVar == null || w.z(bVar.aOI())) {
                    this.eEy.hZ(true);
                    return;
                }
                this.eEy.TI();
                this.eEy.setData(bVar);
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
        this.eEy.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.eEy != null && this.eEy.aOU()) {
            this.eEy.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
