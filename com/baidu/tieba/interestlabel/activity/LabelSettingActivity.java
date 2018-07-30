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
    private LabelSettingView eMi;
    private LabelSettingModel eMj;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eMi = new LabelSettingView(getPageContext(), this);
        this.eMj = new LabelSettingModel(getPageContext());
        setContentView(this.eMi);
        this.eMj.a(this);
        aQk();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void aQk() {
        if (!j.js()) {
            this.eMi.hideLoadingView();
            this.eMi.im(true);
            return;
        }
        this.eMi.Uk();
        this.eMi.gU(true);
        this.eMj.aQq();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void cw(List<Integer> list) {
        if (!j.js()) {
            showToast(d.j.neterror);
        } else {
            this.eMj.cx(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.eMi.hideLoadingView();
                if (bVar == null || w.z(bVar.aQo())) {
                    this.eMi.im(true);
                    return;
                }
                this.eMi.Uk();
                this.eMi.setData(bVar);
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
        this.eMi.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.eMi != null && this.eMi.aQA()) {
            this.eMi.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
