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
    private LabelSettingView haG;
    private LabelSettingModel haH;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.haG = new LabelSettingView(getPageContext(), this);
        this.haH = new LabelSettingModel(getPageContext());
        setContentView(this.haG);
        this.haH.a(this);
        bJj();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void bJj() {
        if (!j.jQ()) {
            this.haG.hideLoadingView();
            this.haG.ju(true);
            return;
        }
        this.haG.aJh();
        this.haG.cY(true);
        this.haH.bJp();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void dj(List<Integer> list) {
        if (!j.jQ()) {
            showToast(R.string.neterror);
        } else {
            this.haH.dk(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.haG.hideLoadingView();
                if (bVar == null || v.aa(bVar.bJn())) {
                    this.haG.ju(true);
                    return;
                }
                this.haG.aJh();
                this.haG.setData(bVar);
                return;
            case SUB_LABEL:
                if (i == 0) {
                    com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("set_recommend_label", true);
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
        this.haG.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.haG != null && this.haG.bJz()) {
            this.haG.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
