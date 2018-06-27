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
    private LabelSettingView eIo;
    private LabelSettingModel eIp;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eIo = new LabelSettingView(getPageContext(), this);
        this.eIp = new LabelSettingModel(getPageContext());
        setContentView(this.eIo);
        this.eIp.a(this);
        aPk();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void aPk() {
        if (!j.jr()) {
            this.eIo.hideLoadingView();
            this.eIo.ij(true);
            return;
        }
        this.eIo.Uc();
        this.eIo.gR(true);
        this.eIp.aPq();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void cw(List<Integer> list) {
        if (!j.jr()) {
            showToast(d.k.neterror);
        } else {
            this.eIp.cx(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.eIo.hideLoadingView();
                if (bVar == null || w.A(bVar.aPo())) {
                    this.eIo.ij(true);
                    return;
                }
                this.eIo.Uc();
                this.eIo.setData(bVar);
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
        this.eIo.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.eIo != null && this.eIo.aPA()) {
            this.eIo.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
