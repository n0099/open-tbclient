package com.baidu.tieba.imMessageCenter.im.friend;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private com.baidu.tbadk.core.dialog.a CQ;
    private com.baidu.adp.framework.listener.e bBq = new a(this, 0);
    private BlackListModel dbJ;
    private h dbK;
    private com.baidu.tieba.im.data.a dbL;

    private void initView() {
        this.dbK = new h(this);
    }

    private void MG() {
        this.dbJ = new BlackListModel(getPageContext());
        this.dbJ.setUniqueId(getUniqueId());
    }

    private void MJ() {
        this.dbJ.loadBlackList();
        this.dbK.CB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.bBq);
        registerListener(104102, this.bBq);
        initView();
        MG();
        MJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dbJ != null) {
            this.dbJ.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asK() {
        showLoadingDialog((String) null, new b(this));
    }

    private void a(com.baidu.tieba.im.data.a aVar) {
        lB(String.format(getPageContext().getString(u.j.black_list_ensure_toremove_text), aVar.getUserName()));
        this.CQ.rT();
    }

    private void lB(String str) {
        this.CQ = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.CQ.cz(str);
        this.CQ.a(u.j.confirm, new c(this));
        this.CQ.b(u.j.alert_no_button, new d(this));
        this.CQ.b(getPageContext());
    }

    public void a(View view, com.baidu.tieba.im.data.a aVar) {
        if (aVar != null && aVar.getUserId() > 0) {
            this.dbL = aVar;
            a(aVar);
        }
    }
}
