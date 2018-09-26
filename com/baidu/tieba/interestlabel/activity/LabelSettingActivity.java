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
    private LabelSettingView eTy;
    private LabelSettingModel eTz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eTy = new LabelSettingView(getPageContext(), this);
        this.eTz = new LabelSettingModel(getPageContext());
        setContentView(this.eTy);
        this.eTz.a(this);
        aSv();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void aSv() {
        if (!j.ky()) {
            this.eTy.hideLoadingView();
            this.eTy.iK(true);
            return;
        }
        this.eTy.Wa();
        this.eTy.hs(true);
        this.eTz.aSB();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void cx(List<Integer> list) {
        if (!j.ky()) {
            showToast(e.j.neterror);
        } else {
            this.eTz.cy(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.eTy.hideLoadingView();
                if (bVar == null || v.z(bVar.aSz())) {
                    this.eTy.iK(true);
                    return;
                }
                this.eTy.Wa();
                this.eTy.setData(bVar);
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
        this.eTy.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.eTy != null && this.eTy.aSL()) {
            this.eTy.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
