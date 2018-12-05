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
    private LabelSettingView fjt;
    private LabelSettingModel fju;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fjt = new LabelSettingView(getPageContext(), this);
        this.fju = new LabelSettingModel(getPageContext());
        setContentView(this.fjt);
        this.fju.a(this);
        aWY();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void aWY() {
        if (!j.kK()) {
            this.fjt.hideLoadingView();
            this.fjt.jp(true);
            return;
        }
        this.fjt.aaY();
        this.fjt.showLoadingView(true);
        this.fju.aXe();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void cO(List<Integer> list) {
        if (!j.kK()) {
            showToast(e.j.neterror);
        } else {
            this.fju.cP(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.fjt.hideLoadingView();
                if (bVar == null || v.I(bVar.aXc())) {
                    this.fjt.jp(true);
                    return;
                }
                this.fjt.aaY();
                this.fjt.setData(bVar);
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
        this.fjt.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.fjt != null && this.fjt.aXo()) {
            this.fjt.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
