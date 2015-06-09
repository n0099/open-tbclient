package com.baidu.tieba.imMessageCenter.im.friend;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.model.BlackListModel;
/* loaded from: classes.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private com.baidu.tbadk.core.dialog.a Ll;
    private BlackListModel bve;
    private i bvf;
    private com.baidu.tieba.im.data.a bvg;
    private com.baidu.adp.framework.listener.e mListener = new a(this, 0);

    private void initView() {
        this.bvf = new i(this);
    }

    private void GZ() {
        this.bve = new BlackListModel(this);
        this.bve.setUniqueId(getUniqueId());
    }

    private void Jk() {
        this.bve.loadBlackList();
        this.bvf.WR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.mListener);
        registerListener(104102, this.mListener);
        initView();
        GZ();
        Jk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bve != null) {
            this.bve.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WP() {
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
            this.bvg = aVar;
            a(aVar);
        }
    }
}
