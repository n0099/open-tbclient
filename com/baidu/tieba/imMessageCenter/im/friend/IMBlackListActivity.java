package com.baidu.tieba.imMessageCenter.im.friend;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.model.BlackListModel;
/* loaded from: classes.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private com.baidu.tbadk.core.dialog.a Lt;
    private BlackListModel bsr;
    private i bss;
    private com.baidu.tieba.im.data.a bst;
    private com.baidu.adp.framework.listener.e mListener = new a(this, 0);

    private void initView() {
        this.bss = new i(this);
    }

    private void FY() {
        this.bsr = new BlackListModel(this);
        this.bsr.setUniqueId(getUniqueId());
    }

    private void Ij() {
        this.bsr.loadBlackList();
        this.bss.Vy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.mListener);
        registerListener(104102, this.mListener);
        initView();
        FY();
        Ij();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bsr != null) {
            this.bsr.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vw() {
        showLoadingDialog(null, new b(this));
    }

    private void a(com.baidu.tieba.im.data.a aVar) {
        hp(String.format(getPageContext().getString(com.baidu.tieba.y.black_list_ensure_toremove_text), aVar.getUserName()));
        this.Lt.re();
    }

    private void hp(String str) {
        this.Lt = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.Lt.bw(com.baidu.tieba.y.confirm_title);
        this.Lt.ca(str);
        this.Lt.a(com.baidu.tieba.y.confirm, new c(this));
        this.Lt.b(com.baidu.tieba.y.alert_no_button, new d(this));
        this.Lt.b(getPageContext());
    }

    public void a(View view, com.baidu.tieba.im.data.a aVar) {
        if (aVar != null && aVar.getUserId() > 0) {
            this.bst = aVar;
            a(aVar);
        }
    }
}
