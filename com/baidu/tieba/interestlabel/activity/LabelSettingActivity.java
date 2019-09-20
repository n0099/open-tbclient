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
    private LabelSettingView hds;
    private LabelSettingModel hdt;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hds = new LabelSettingView(getPageContext(), this);
        this.hdt = new LabelSettingModel(getPageContext());
        setContentView(this.hds);
        this.hdt.a(this);
        bKk();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void bKk() {
        if (!j.jQ()) {
            this.hds.hideLoadingView();
            this.hds.jx(true);
            return;
        }
        this.hds.aJN();
        this.hds.cY(true);
        this.hdt.bKq();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void di(List<Integer> list) {
        if (!j.jQ()) {
            showToast(R.string.neterror);
        } else {
            this.hdt.dj(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.hds.hideLoadingView();
                if (bVar == null || v.aa(bVar.bKo())) {
                    this.hds.jx(true);
                    return;
                }
                this.hds.aJN();
                this.hds.setData(bVar);
                return;
            case SUB_LABEL:
                if (i == 0) {
                    com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("set_recommend_label", true);
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
        this.hds.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.hds != null && this.hds.bKA()) {
            this.hds.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
