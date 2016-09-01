package com.baidu.tieba.imMessageCenter.im.friend;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private com.baidu.tbadk.core.dialog.a FD;
    private com.baidu.adp.framework.listener.e cjp = new a(this, 0);
    private BlackListModel dqo;
    private h dqp;
    private com.baidu.tieba.im.data.a dqq;

    private void initView() {
        this.dqp = new h(this);
    }

    private void aa() {
        this.dqo = new BlackListModel(getPageContext());
        this.dqo.setUniqueId(getUniqueId());
    }

    private void Rt() {
        this.dqo.loadBlackList();
        this.dqp.DV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.cjp);
        registerListener(104102, this.cjp);
        initView();
        aa();
        Rt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dqo != null) {
            this.dqo.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayk() {
        showLoadingDialog((String) null, new b(this));
    }

    private void a(com.baidu.tieba.im.data.a aVar) {
        mr(String.format(getPageContext().getString(t.j.black_list_ensure_toremove_text), aVar.getUserName()));
        this.FD.sX();
    }

    private void mr(String str) {
        this.FD = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.FD.cB(str);
        this.FD.a(t.j.confirm, new c(this));
        this.FD.b(t.j.alert_no_button, new d(this));
        this.FD.b(getPageContext());
    }

    public void a(View view, com.baidu.tieba.im.data.a aVar) {
        if (aVar != null && aVar.getUserId() > 0) {
            this.dqq = aVar;
            a(aVar);
        }
    }
}
