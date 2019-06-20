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
    private LabelSettingView gUv;
    private LabelSettingModel gUw;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gUv = new LabelSettingView(getPageContext(), this);
        this.gUw = new LabelSettingModel(getPageContext());
        setContentView(this.gUv);
        this.gUw.a(this);
        bGC();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void bGC() {
        if (!j.jG()) {
            this.gUv.hideLoadingView();
            this.gUv.jk(true);
            return;
        }
        this.gUv.aHK();
        this.gUv.cV(true);
        this.gUw.bGI();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void dh(List<Integer> list) {
        if (!j.jG()) {
            showToast(R.string.neterror);
        } else {
            this.gUw.di(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.gUv.hideLoadingView();
                if (bVar == null || v.aa(bVar.bGG())) {
                    this.gUv.jk(true);
                    return;
                }
                this.gUv.aHK();
                this.gUv.setData(bVar);
                return;
            case SUB_LABEL:
                if (i == 0) {
                    com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("set_recommend_label", true);
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
        this.gUv.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.gUv != null && this.gUv.bGS()) {
            this.gUv.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
