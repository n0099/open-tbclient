package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.b.b;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.tieba.interestlabel.model.a;
import com.baidu.tieba.interestlabel.view.LabelSettingView;
import java.util.List;
/* loaded from: classes10.dex */
public class LabelSettingActivity extends BaseActivity<LabelSettingActivity> implements a {
    private LabelSettingView iFS;
    private LabelSettingModel iFT;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iFS = new LabelSettingView(getPageContext(), this);
        this.iFT = new LabelSettingModel(getPageContext());
        setContentView(this.iFS);
        this.iFT.a(this);
        clP();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void clP() {
        if (!j.isNetworkAvailableForImmediately()) {
            this.iFS.hideLoadingView();
            this.iFS.lV(true);
            return;
        }
        this.iFS.blt();
        this.iFS.fK(true);
        this.iFT.clV();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void dr(List<Integer> list) {
        if (!j.isNetworkAvailableForImmediately()) {
            showToast(R.string.neterror);
        } else {
            this.iFT.ds(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.iFS.hideLoadingView();
                if (bVar == null || v.isEmpty(bVar.clT())) {
                    this.iFS.lV(true);
                    return;
                }
                this.iFS.blt();
                this.iFS.setData(bVar);
                return;
            case SUB_LABEL:
                if (i == 0) {
                    com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
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
        this.iFS.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.iFS != null && this.iFS.cmf()) {
            this.iFS.showDialog();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
