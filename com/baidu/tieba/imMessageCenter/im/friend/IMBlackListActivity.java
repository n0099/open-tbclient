package com.baidu.tieba.imMessageCenter.im.friend;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.BlackListItemData;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private com.baidu.tbadk.core.dialog.a KN;
    private com.baidu.adp.framework.listener.e cWs = new a(this, 0);
    private BlackListModel dsf;
    private h dsg;
    private BlackListItemData dsh;

    private void initView() {
        this.dsg = new h(this);
    }

    private void bj() {
        this.dsf = new BlackListModel(getPageContext());
        this.dsf.setUniqueId(getUniqueId());
    }

    private void OZ() {
        this.dsf.loadBlackList();
        this.dsg.DM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.cWs);
        registerListener(104102, this.cWs);
        initView();
        bj();
        OZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dsf != null) {
            this.dsf.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qx() {
        showLoadingDialog((String) null, new b(this));
    }

    private void a(BlackListItemData blackListItemData) {
        mm(String.format(getPageContext().getString(w.l.black_list_ensure_toremove_text), blackListItemData.getUserName()));
        this.KN.ta();
    }

    private void mm(String str) {
        this.KN = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.KN.cI(str);
        this.KN.a(w.l.confirm, new c(this));
        this.KN.b(w.l.alert_no_button, new d(this));
        this.KN.b(getPageContext());
    }

    public void a(View view, BlackListItemData blackListItemData) {
        if (blackListItemData != null && blackListItemData.getUserId() > 0) {
            this.dsh = blackListItemData;
            a(blackListItemData);
        }
    }
}
