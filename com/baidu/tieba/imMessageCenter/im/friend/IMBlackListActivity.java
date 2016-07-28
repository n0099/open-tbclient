package com.baidu.tieba.imMessageCenter.im.friend;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private com.baidu.tbadk.core.dialog.a Dq;
    private com.baidu.adp.framework.listener.e bYf = new a(this, 0);
    private BlackListModel deH;
    private h deI;
    private com.baidu.tieba.im.data.a deJ;

    private void initView() {
        this.deI = new h(this);
    }

    private void MF() {
        this.deH = new BlackListModel(getPageContext());
        this.deH.setUniqueId(getUniqueId());
    }

    private void MI() {
        this.deH.loadBlackList();
        this.deI.CA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.bYf);
        registerListener(104102, this.bYf);
        initView();
        MF();
        MI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.deH != null) {
            this.deH.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atw() {
        showLoadingDialog((String) null, new b(this));
    }

    private void a(com.baidu.tieba.im.data.a aVar) {
        lI(String.format(getPageContext().getString(u.j.black_list_ensure_toremove_text), aVar.getUserName()));
        this.Dq.rS();
    }

    private void lI(String str) {
        this.Dq = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.Dq.cz(str);
        this.Dq.a(u.j.confirm, new c(this));
        this.Dq.b(u.j.alert_no_button, new d(this));
        this.Dq.b(getPageContext());
    }

    public void a(View view, com.baidu.tieba.im.data.a aVar) {
        if (aVar != null && aVar.getUserId() > 0) {
            this.deJ = aVar;
            a(aVar);
        }
    }
}
