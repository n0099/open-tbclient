package com.baidu.tieba.imMessageCenter.im.friend;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private com.baidu.tbadk.core.dialog.a LN;
    private BlackListModel ccq;
    private h ccr;
    private com.baidu.tieba.im.data.a ccs;
    private com.baidu.adp.framework.listener.e mListener = new a(this, 0);

    private void initView() {
        this.ccr = new h(this);
    }

    private void IK() {
        this.ccq = new BlackListModel(getPageContext());
        this.ccq.setUniqueId(getUniqueId());
    }

    private void JU() {
        this.ccq.loadBlackList();
        this.ccr.CI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.mListener);
        registerListener(104102, this.mListener);
        initView();
        IK();
        JU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.ccq != null) {
            this.ccq.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acC() {
        showLoadingDialog((String) null, new b(this));
    }

    private void a(com.baidu.tieba.im.data.a aVar) {
        je(String.format(getPageContext().getString(n.i.black_list_ensure_toremove_text), aVar.getUserName()));
        this.LN.tv();
    }

    private void je(String str) {
        this.LN = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.LN.cC(str);
        this.LN.a(n.i.confirm, new c(this));
        this.LN.b(n.i.alert_no_button, new d(this));
        this.LN.b(getPageContext());
    }

    public void a(View view, com.baidu.tieba.im.data.a aVar) {
        if (aVar != null && aVar.getUserId() > 0) {
            this.ccs = aVar;
            a(aVar);
        }
    }
}
