package com.baidu.tieba.imMessageCenter.im.friend;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private com.baidu.tbadk.core.dialog.a FD;
    private com.baidu.adp.framework.listener.e cjN = new a(this, 0);
    private BlackListModel drL;
    private h drM;
    private com.baidu.tieba.im.data.a drN;

    private void initView() {
        this.drM = new h(this);
    }

    private void aa() {
        this.drL = new BlackListModel(getPageContext());
        this.drL.setUniqueId(getUniqueId());
    }

    private void RL() {
        this.drL.loadBlackList();
        this.drM.DV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.cjN);
        registerListener(104102, this.cjN);
        initView();
        aa();
        RL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.drL != null) {
            this.drL.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayI() {
        showLoadingDialog((String) null, new b(this));
    }

    private void a(com.baidu.tieba.im.data.a aVar) {
        mE(String.format(getPageContext().getString(r.j.black_list_ensure_toremove_text), aVar.getUserName()));
        this.FD.tm();
    }

    private void mE(String str) {
        this.FD = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.FD.cD(str);
        this.FD.a(r.j.confirm, new c(this));
        this.FD.b(r.j.alert_no_button, new d(this));
        this.FD.b(getPageContext());
    }

    public void a(View view, com.baidu.tieba.im.data.a aVar) {
        if (aVar != null && aVar.getUserId() > 0) {
            this.drN = aVar;
            a(aVar);
        }
    }
}
