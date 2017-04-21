package com.baidu.tieba.imMessageCenter.im.friend;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.BlackListItemData;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private com.baidu.tbadk.core.dialog.a LI;
    private com.baidu.adp.framework.listener.e cOV = new a(this, 0);
    private BlackListModel dkM;
    private h dkN;
    private BlackListItemData dkO;

    private void initView() {
        this.dkN = new h(this);
    }

    private void bj() {
        this.dkM = new BlackListModel(getPageContext());
        this.dkM.setUniqueId(getUniqueId());
    }

    private void Ol() {
        this.dkM.loadBlackList();
        this.dkN.Eu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.cOV);
        registerListener(104102, this.cOV);
        initView();
        bj();
        Ol();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dkM != null) {
            this.dkM.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avw() {
        showLoadingDialog((String) null, new b(this));
    }

    private void a(BlackListItemData blackListItemData) {
        lb(String.format(getPageContext().getString(w.l.black_list_ensure_toremove_text), blackListItemData.getUserName()));
        this.LI.tQ();
    }

    private void lb(String str) {
        this.LI = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.LI.cE(str);
        this.LI.a(w.l.confirm, new c(this));
        this.LI.b(w.l.alert_no_button, new d(this));
        this.LI.b(getPageContext());
    }

    public void a(View view, BlackListItemData blackListItemData) {
        if (blackListItemData != null && blackListItemData.getUserId() > 0) {
            this.dkO = blackListItemData;
            a(blackListItemData);
        }
    }
}
