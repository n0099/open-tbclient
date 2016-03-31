package com.baidu.tieba.imMessageCenter.im.friend;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private com.baidu.tbadk.core.dialog.a My;
    private com.baidu.adp.framework.listener.e bje = new a(this, 0);
    private BlackListModel cvw;
    private h cvx;
    private com.baidu.tieba.im.data.a cvy;

    private void initView() {
        this.cvx = new h(this);
    }

    private void ako() {
        this.cvw = new BlackListModel(getPageContext());
        this.cvw.setUniqueId(getUniqueId());
    }

    private void NS() {
        this.cvw.loadBlackList();
        this.cvx.Ez();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.bje);
        registerListener(104102, this.bje);
        initView();
        ako();
        NS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cvw != null) {
            this.cvw.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akp() {
        showLoadingDialog((String) null, new b(this));
    }

    private void a(com.baidu.tieba.im.data.a aVar) {
        kf(String.format(getPageContext().getString(t.j.black_list_ensure_toremove_text), aVar.getUserName()));
        this.My.up();
    }

    private void kf(String str) {
        this.My = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.My.cC(str);
        this.My.a(t.j.confirm, new c(this));
        this.My.b(t.j.alert_no_button, new d(this));
        this.My.b(getPageContext());
    }

    public void a(View view, com.baidu.tieba.im.data.a aVar) {
        if (aVar != null && aVar.getUserId() > 0) {
            this.cvy = aVar;
            a(aVar);
        }
    }
}
