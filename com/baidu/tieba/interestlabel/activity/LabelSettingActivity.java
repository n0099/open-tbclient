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
    private LabelSettingView gCY;
    private LabelSettingModel gCZ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gCY = new LabelSettingView(getPageContext(), this);
        this.gCZ = new LabelSettingModel(getPageContext());
        setContentView(this.gCY);
        this.gCZ.a(this);
        byO();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void byO() {
        if (!j.kM()) {
            this.gCY.hideLoadingView();
            this.gCY.iD(true);
            return;
        }
        this.gCY.aBq();
        this.gCY.cE(true);
        this.gCZ.byU();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void cZ(List<Integer> list) {
        if (!j.kM()) {
            showToast(d.j.neterror);
        } else {
            this.gCZ.da(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.gCY.hideLoadingView();
                if (bVar == null || v.T(bVar.byS())) {
                    this.gCY.iD(true);
                    return;
                }
                this.gCY.aBq();
                this.gCY.setData(bVar);
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
        this.gCY.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.gCY != null && this.gCY.bze()) {
            this.gCY.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
