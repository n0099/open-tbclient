package com.baidu.tieba.imMessageCenter.im.friend;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.BlackListItemData;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private com.baidu.tbadk.core.dialog.a ER;
    private com.baidu.adp.framework.listener.e caD = new a(this, 0);
    private BlackListModel dhE;
    private h dhF;
    private BlackListItemData dhG;

    private void initView() {
        this.dhF = new h(this);
    }

    private void aa() {
        this.dhE = new BlackListModel(getPageContext());
        this.dhE.setUniqueId(getUniqueId());
    }

    private void MR() {
        this.dhE.loadBlackList();
        this.dhF.DD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.caD);
        registerListener(104102, this.caD);
        initView();
        aa();
        MR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dhE != null) {
            this.dhE.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avh() {
        showLoadingDialog((String) null, new b(this));
    }

    private void a(BlackListItemData blackListItemData) {
        lt(String.format(getPageContext().getString(r.l.black_list_ensure_toremove_text), blackListItemData.getUserName()));
        this.ER.sV();
    }

    private void lt(String str) {
        this.ER = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.ER.cE(str);
        this.ER.a(r.l.confirm, new c(this));
        this.ER.b(r.l.alert_no_button, new d(this));
        this.ER.b(getPageContext());
    }

    public void a(View view, BlackListItemData blackListItemData) {
        if (blackListItemData != null && blackListItemData.getUserId() > 0) {
            this.dhG = blackListItemData;
            a(blackListItemData);
        }
    }
}
