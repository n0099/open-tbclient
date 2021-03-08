package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.b.b;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.tieba.interestlabel.model.a;
import com.baidu.tieba.interestlabel.view.LabelSettingView;
import java.util.List;
/* loaded from: classes7.dex */
public class LabelSettingActivity extends BaseActivity<LabelSettingActivity> implements a {
    private LabelSettingView kZY;
    private LabelSettingModel kZZ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kZY = new LabelSettingView(getPageContext(), this);
        this.kZZ = new LabelSettingModel(getPageContext());
        setContentView(this.kZY);
        this.kZZ.a(this);
        daS();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void daS() {
        if (!j.isNetworkAvailableForImmediately()) {
            this.kZY.hideLoadingView();
            this.kZY.qa(true);
            return;
        }
        this.kZY.Xc();
        this.kZY.ir(true);
        this.kZZ.daY();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void eD(List<Integer> list) {
        if (!j.isNetworkAvailableForImmediately()) {
            showToast(R.string.neterror);
        } else {
            this.kZZ.eE(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.kZY.hideLoadingView();
                if (bVar == null || y.isEmpty(bVar.daW())) {
                    this.kZY.qa(true);
                    return;
                }
                this.kZY.Xc();
                this.kZY.setData(bVar);
                return;
            case SUB_LABEL:
                if (i == 0) {
                    com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
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
        this.kZY.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.kZY != null && this.kZY.dbi()) {
            this.kZY.QH();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
