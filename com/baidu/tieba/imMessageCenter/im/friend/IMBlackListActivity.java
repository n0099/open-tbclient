package com.baidu.tieba.imMessageCenter.im.friend;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private com.baidu.tbadk.core.dialog.a Ms;
    private com.baidu.adp.framework.listener.e ber = new a(this, 0);
    private BlackListModel ckQ;
    private h ckR;
    private com.baidu.tieba.im.data.a ckS;

    private void initView() {
        this.ckR = new h(this);
    }

    private void agU() {
        this.ckQ = new BlackListModel(getPageContext());
        this.ckQ.setUniqueId(getUniqueId());
    }

    private void Me() {
        this.ckQ.loadBlackList();
        this.ckR.DN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.ber);
        registerListener(104102, this.ber);
        initView();
        agU();
        Me();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.ckQ != null) {
            this.ckQ.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agV() {
        showLoadingDialog((String) null, new b(this));
    }

    private void a(com.baidu.tieba.im.data.a aVar) {
        jw(String.format(getPageContext().getString(t.j.black_list_ensure_toremove_text), aVar.getUserName()));
        this.Ms.uj();
    }

    private void jw(String str) {
        this.Ms = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.Ms.cE(str);
        this.Ms.a(t.j.confirm, new c(this));
        this.Ms.b(t.j.alert_no_button, new d(this));
        this.Ms.b(getPageContext());
    }

    public void a(View view, com.baidu.tieba.im.data.a aVar) {
        if (aVar != null && aVar.getUserId() > 0) {
            this.ckS = aVar;
            a(aVar);
        }
    }
}
