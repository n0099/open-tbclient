package com.baidu.tieba.imMessageCenter.im.friend;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private com.baidu.tbadk.core.dialog.a CP;
    private com.baidu.adp.framework.listener.e bfe = new a(this, 0);
    private BlackListModel cwt;
    private h cwu;
    private com.baidu.tieba.im.data.a cwv;

    private void initView() {
        this.cwu = new h(this);
    }

    private void aku() {
        this.cwt = new BlackListModel(getPageContext());
        this.cwt.setUniqueId(getUniqueId());
    }

    private void MC() {
        this.cwt.loadBlackList();
        this.cwu.Cs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.bfe);
        registerListener(104102, this.bfe);
        initView();
        aku();
        MC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cwt != null) {
            this.cwt.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akv() {
        showLoadingDialog((String) null, new b(this));
    }

    private void a(com.baidu.tieba.im.data.a aVar) {
        ki(String.format(getPageContext().getString(t.j.black_list_ensure_toremove_text), aVar.getUserName()));
        this.CP.rU();
    }

    private void ki(String str) {
        this.CP = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.CP.cA(str);
        this.CP.a(t.j.confirm, new c(this));
        this.CP.b(t.j.alert_no_button, new d(this));
        this.CP.b(getPageContext());
    }

    public void a(View view, com.baidu.tieba.im.data.a aVar) {
        if (aVar != null && aVar.getUserId() > 0) {
            this.cwv = aVar;
            a(aVar);
        }
    }
}
