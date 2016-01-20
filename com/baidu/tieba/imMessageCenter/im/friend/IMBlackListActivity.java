package com.baidu.tieba.imMessageCenter.im.friend;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private com.baidu.tbadk.core.dialog.a Md;
    private BlackListModel cgq;
    private h cgr;
    private com.baidu.tieba.im.data.a cgs;
    private com.baidu.adp.framework.listener.e mListener = new a(this, 0);

    private void initView() {
        this.cgr = new h(this);
    }

    private void Jb() {
        this.cgq = new BlackListModel(getPageContext());
        this.cgq.setUniqueId(getUniqueId());
    }

    private void Kn() {
        this.cgq.loadBlackList();
        this.cgr.Cx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.mListener);
        registerListener(104102, this.mListener);
        initView();
        Jb();
        Kn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cgq != null) {
            this.cgq.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adL() {
        showLoadingDialog((String) null, new b(this));
    }

    private void a(com.baidu.tieba.im.data.a aVar) {
        js(String.format(getPageContext().getString(n.j.black_list_ensure_toremove_text), aVar.getUserName()));
        this.Md.tf();
    }

    private void js(String str) {
        this.Md = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.Md.cF(str);
        this.Md.a(n.j.confirm, new c(this));
        this.Md.b(n.j.alert_no_button, new d(this));
        this.Md.b(getPageContext());
    }

    public void a(View view, com.baidu.tieba.im.data.a aVar) {
        if (aVar != null && aVar.getUserId() > 0) {
            this.cgs = aVar;
            a(aVar);
        }
    }
}
