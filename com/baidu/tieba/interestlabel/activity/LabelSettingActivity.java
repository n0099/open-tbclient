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
/* loaded from: classes8.dex */
public class LabelSettingActivity extends BaseActivity<LabelSettingActivity> implements a {
    private LabelSettingView kXI;
    private LabelSettingModel kXJ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kXI = new LabelSettingView(getPageContext(), this);
        this.kXJ = new LabelSettingModel(getPageContext());
        setContentView(this.kXI);
        this.kXJ.a(this);
        daC();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void daC() {
        if (!j.isNetworkAvailableForImmediately()) {
            this.kXI.hideLoadingView();
            this.kXI.qa(true);
            return;
        }
        this.kXI.WZ();
        this.kXI.ir(true);
        this.kXJ.daI();
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void eD(List<Integer> list) {
        if (!j.isNetworkAvailableForImmediately()) {
            showToast(R.string.neterror);
        } else {
            this.kXJ.eE(list);
        }
    }

    @Override // com.baidu.tieba.interestlabel.model.a
    public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        switch (labelRequestEnum) {
            case GET_LABEL:
                this.kXI.hideLoadingView();
                if (bVar == null || y.isEmpty(bVar.daG())) {
                    this.kXI.qa(true);
                    return;
                }
                this.kXI.WZ();
                this.kXI.setData(bVar);
                return;
            case SUB_LABEL:
                if (i == 0) {
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
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
        this.kXI.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.kXI != null && this.kXI.daS()) {
            this.kXI.QE();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
