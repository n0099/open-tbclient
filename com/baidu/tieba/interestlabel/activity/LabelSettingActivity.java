package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.f;
import com.baidu.tieba.interestlabel.b.b;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.tieba.interestlabel.model.a;
import com.baidu.tieba.interestlabel.view.LabelSettingView;
import java.util.List;
/* loaded from: classes3.dex */
public class LabelSettingActivity extends BaseActivity<LabelSettingActivity> implements a {
    private LabelSettingView eMd;
    private LabelSettingModel eMe;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eMd = new LabelSettingView(getPageContext(), this);
        this.eMe = new LabelSettingModel(getPageContext());
        setContentView(this.eMd);
        this.eMe.a(this);
        aQh();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void aQh() {
        if (!j.js()) {
            this.eMd.hideLoadingView();
            this.eMd.im(true);
            return;
        }
        this.eMd.Un();
        this.eMd.gU(true);
        this.eMe.aQn();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void cw(List<Integer> list) {
        if (!j.js()) {
            showToast(f.j.neterror);
        } else {
            this.eMe.cx(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.eMd.hideLoadingView();
                if (bVar == null || w.z(bVar.aQl())) {
                    this.eMd.im(true);
                    return;
                }
                this.eMd.Un();
                this.eMd.setData(bVar);
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
        this.eMd.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.eMd != null && this.eMd.aQx()) {
            this.eMd.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
