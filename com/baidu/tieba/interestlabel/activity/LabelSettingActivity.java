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
    private LabelSettingView gDk;
    private LabelSettingModel gDl;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gDk = new LabelSettingView(getPageContext(), this);
        this.gDl = new LabelSettingModel(getPageContext());
        setContentView(this.gDk);
        this.gDl.a(this);
        byR();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void byR() {
        if (!j.kM()) {
            this.gDk.hideLoadingView();
            this.gDk.iD(true);
            return;
        }
        this.gDk.aBt();
        this.gDk.cE(true);
        this.gDl.byX();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void dc(List<Integer> list) {
        if (!j.kM()) {
            showToast(d.j.neterror);
        } else {
            this.gDl.dd(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.gDk.hideLoadingView();
                if (bVar == null || v.T(bVar.byV())) {
                    this.gDk.iD(true);
                    return;
                }
                this.gDk.aBt();
                this.gDk.setData(bVar);
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
        this.gDk.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.gDk != null && this.gDk.bzh()) {
            this.gDk.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
