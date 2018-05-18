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
/* loaded from: classes3.dex */
public class LabelSettingActivity extends BaseActivity<LabelSettingActivity> implements a {
    private LabelSettingView eti;
    private LabelSettingModel etj;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eti = new LabelSettingView(getPageContext(), this);
        this.etj = new LabelSettingModel(getPageContext());
        setContentView(this.eti);
        this.etj.a(this);
        aJI();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void aJI() {
        if (!j.gD()) {
            this.eti.Os();
            this.eti.hT(true);
            return;
        }
        this.eti.Qk();
        this.eti.gB(true);
        this.etj.aJO();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void cn(List<Integer> list) {
        if (!j.gD()) {
            showToast(d.k.neterror);
        } else {
            this.etj.co(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.eti.Os();
                if (bVar == null || v.w(bVar.aJM())) {
                    this.eti.hT(true);
                    return;
                }
                this.eti.Qk();
                this.eti.setData(bVar);
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
        this.eti.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.eti != null && this.eti.aJY()) {
            this.eti.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
