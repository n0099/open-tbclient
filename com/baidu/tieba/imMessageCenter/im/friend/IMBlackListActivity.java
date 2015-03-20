package com.baidu.tieba.imMessageCenter.im.friend;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.model.BlackListModel;
/* loaded from: classes.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private com.baidu.tbadk.core.dialog.a Lr;
    private BlackListModel bsb;
    private i bsc;
    private com.baidu.tieba.im.data.a bsd;
    private com.baidu.adp.framework.listener.e mListener = new a(this, 0);

    private void initView() {
        this.bsc = new i(this);
    }

    private void FS() {
        this.bsb = new BlackListModel(this);
        this.bsb.setUniqueId(getUniqueId());
    }

    private void Id() {
        this.bsb.loadBlackList();
        this.bsc.Vl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.mListener);
        registerListener(104102, this.mListener);
        initView();
        FS();
        Id();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bsb != null) {
            this.bsb.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vj() {
        showLoadingDialog(null, new b(this));
    }

    private void a(com.baidu.tieba.im.data.a aVar) {
        hm(String.format(getPageContext().getString(com.baidu.tieba.y.black_list_ensure_toremove_text), aVar.getUserName()));
        this.Lr.re();
    }

    private void hm(String str) {
        this.Lr = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.Lr.bw(com.baidu.tieba.y.confirm_title);
        this.Lr.ca(str);
        this.Lr.a(com.baidu.tieba.y.confirm, new c(this));
        this.Lr.b(com.baidu.tieba.y.alert_no_button, new d(this));
        this.Lr.b(getPageContext());
    }

    public void a(View view, com.baidu.tieba.im.data.a aVar) {
        if (aVar != null && aVar.getUserId() > 0) {
            this.bsd = aVar;
            a(aVar);
        }
    }
}
