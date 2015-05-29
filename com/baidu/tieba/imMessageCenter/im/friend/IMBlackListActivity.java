package com.baidu.tieba.imMessageCenter.im.friend;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.model.BlackListModel;
/* loaded from: classes.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private com.baidu.tbadk.core.dialog.a Ll;
    private BlackListModel bvd;
    private i bve;
    private com.baidu.tieba.im.data.a bvf;
    private com.baidu.adp.framework.listener.e mListener = new a(this, 0);

    private void initView() {
        this.bve = new i(this);
    }

    private void GY() {
        this.bvd = new BlackListModel(this);
        this.bvd.setUniqueId(getUniqueId());
    }

    private void Jj() {
        this.bvd.loadBlackList();
        this.bve.WQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.mListener);
        registerListener(104102, this.mListener);
        initView();
        GY();
        Jj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bvd != null) {
            this.bvd.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WO() {
        showLoadingDialog(null, new b(this));
    }

    private void a(com.baidu.tieba.im.data.a aVar) {
        hS(String.format(getPageContext().getString(com.baidu.tieba.t.black_list_ensure_toremove_text), aVar.getUserName()));
        this.Ll.rL();
    }

    private void hS(String str) {
        this.Ll = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.Ll.cn(str);
        this.Ll.a(com.baidu.tieba.t.confirm, new c(this));
        this.Ll.b(com.baidu.tieba.t.alert_no_button, new d(this));
        this.Ll.b(getPageContext());
    }

    public void a(View view, com.baidu.tieba.im.data.a aVar) {
        if (aVar != null && aVar.getUserId() > 0) {
            this.bvf = aVar;
            a(aVar);
        }
    }
}
