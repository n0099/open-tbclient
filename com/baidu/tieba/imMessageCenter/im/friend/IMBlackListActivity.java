package com.baidu.tieba.imMessageCenter.im.friend;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.BlackListItemData;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private com.baidu.tbadk.core.dialog.a LG;
    private com.baidu.adp.framework.listener.e cME = new a(this, 0);
    private BlackListModel div;
    private h diw;
    private BlackListItemData dix;

    private void initView() {
        this.diw = new h(this);
    }

    private void bj() {
        this.div = new BlackListModel(getPageContext());
        this.div.setUniqueId(getUniqueId());
    }

    private void Oc() {
        this.div.loadBlackList();
        this.diw.Eu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.cME);
        registerListener(104102, this.cME);
        initView();
        bj();
        Oc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.div != null) {
            this.div.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auv() {
        showLoadingDialog((String) null, new b(this));
    }

    private void a(BlackListItemData blackListItemData) {
        la(String.format(getPageContext().getString(w.l.black_list_ensure_toremove_text), blackListItemData.getUserName()));
        this.LG.tQ();
    }

    private void la(String str) {
        this.LG = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.LG.cE(str);
        this.LG.a(w.l.confirm, new c(this));
        this.LG.b(w.l.alert_no_button, new d(this));
        this.LG.b(getPageContext());
    }

    public void a(View view, BlackListItemData blackListItemData) {
        if (blackListItemData != null && blackListItemData.getUserId() > 0) {
            this.dix = blackListItemData;
            a(blackListItemData);
        }
    }
}
