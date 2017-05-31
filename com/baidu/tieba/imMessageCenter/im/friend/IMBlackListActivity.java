package com.baidu.tieba.imMessageCenter.im.friend;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.BlackListItemData;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private com.baidu.tbadk.core.dialog.a KO;
    private com.baidu.adp.framework.listener.e cOw = new a(this, 0);
    private BlackListModel dkj;
    private h dkk;
    private BlackListItemData dkl;

    private void initView() {
        this.dkk = new h(this);
    }

    private void bj() {
        this.dkj = new BlackListModel(getPageContext());
        this.dkj.setUniqueId(getUniqueId());
    }

    private void NJ() {
        this.dkj.loadBlackList();
        this.dkk.Ds();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.cOw);
        registerListener(104102, this.cOw);
        initView();
        bj();
        NJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dkj != null) {
            this.dkj.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pd() {
        showLoadingDialog((String) null, new b(this));
    }

    private void a(BlackListItemData blackListItemData) {
        lp(String.format(getPageContext().getString(w.l.black_list_ensure_toremove_text), blackListItemData.getUserName()));
        this.KO.tc();
    }

    private void lp(String str) {
        this.KO = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.KO.cB(str);
        this.KO.a(w.l.confirm, new c(this));
        this.KO.b(w.l.alert_no_button, new d(this));
        this.KO.b(getPageContext());
    }

    public void a(View view, BlackListItemData blackListItemData) {
        if (blackListItemData != null && blackListItemData.getUserId() > 0) {
            this.dkl = blackListItemData;
            a(blackListItemData);
        }
    }
}
