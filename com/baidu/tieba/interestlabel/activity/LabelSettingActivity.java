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
import com.baidu.tieba.interestlabel.view.d;
import java.util.List;
/* loaded from: classes3.dex */
public class LabelSettingActivity extends BaseActivity<LabelSettingActivity> implements a {
    private d eXg;
    private LabelSettingModel eXh;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eXg = new d(getPageContext(), this);
        this.eXh = new LabelSettingModel(getPageContext());
        setContentView(this.eXg);
        this.eXh.a(this);
        aOG();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void aOG() {
        if (!j.ox()) {
            this.eXg.VU();
            this.eXg.ip(true);
            return;
        }
        this.eXg.XM();
        this.eXg.gU(true);
        this.eXh.aOM();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void cr(List<Integer> list) {
        if (!j.ox()) {
            showToast(d.j.neterror);
        } else {
            this.eXh.cs(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.eXg.VU();
                if (bVar == null || v.E(bVar.aOK())) {
                    this.eXg.ip(true);
                    return;
                }
                this.eXg.XM();
                this.eXg.setData(bVar);
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
        this.eXg.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.eXg != null && this.eXg.aOW()) {
            this.eXg.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
