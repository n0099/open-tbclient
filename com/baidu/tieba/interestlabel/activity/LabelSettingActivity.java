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
/* loaded from: classes5.dex */
public class LabelSettingActivity extends BaseActivity<LabelSettingActivity> implements a {
    private LabelSettingView gCZ;
    private LabelSettingModel gDa;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gCZ = new LabelSettingView(getPageContext(), this);
        this.gDa = new LabelSettingModel(getPageContext());
        setContentView(this.gCZ);
        this.gDa.a(this);
        byO();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void byO() {
        if (!j.kM()) {
            this.gCZ.hideLoadingView();
            this.gCZ.iD(true);
            return;
        }
        this.gCZ.aBq();
        this.gCZ.cE(true);
        this.gDa.byU();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void cZ(List<Integer> list) {
        if (!j.kM()) {
            showToast(d.j.neterror);
        } else {
            this.gDa.da(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.gCZ.hideLoadingView();
                if (bVar == null || v.T(bVar.byS())) {
                    this.gCZ.iD(true);
                    return;
                }
                this.gCZ.aBq();
                this.gCZ.setData(bVar);
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
        this.gCZ.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.gCZ != null && this.gCZ.bze()) {
            this.gCZ.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
