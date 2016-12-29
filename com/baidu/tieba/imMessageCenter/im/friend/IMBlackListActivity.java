package com.baidu.tieba.imMessageCenter.im.friend;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private com.baidu.tbadk.core.dialog.a FG;
    private com.baidu.adp.framework.listener.e bUf = new a(this, 0);
    private BlackListModel dap;
    private h daq;
    private com.baidu.tieba.im.data.a dar;

    private void initView() {
        this.daq = new h(this);
    }

    private void aa() {
        this.dap = new BlackListModel(getPageContext());
        this.dap.setUniqueId(getUniqueId());
    }

    private void Tj() {
        this.dap.loadBlackList();
        this.daq.DI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.bUf);
        registerListener(104102, this.bUf);
        initView();
        aa();
        Tj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dap != null) {
            this.dap.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aub() {
        showLoadingDialog((String) null, new b(this));
    }

    private void a(com.baidu.tieba.im.data.a aVar) {
        lg(String.format(getPageContext().getString(r.j.black_list_ensure_toremove_text), aVar.getUserName()));
        this.FG.tb();
    }

    private void lg(String str) {
        this.FG = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.FG.cG(str);
        this.FG.a(r.j.confirm, new c(this));
        this.FG.b(r.j.alert_no_button, new d(this));
        this.FG.b(getPageContext());
    }

    public void a(View view, com.baidu.tieba.im.data.a aVar) {
        if (aVar != null && aVar.getUserId() > 0) {
            this.dar = aVar;
            a(aVar);
        }
    }
}
