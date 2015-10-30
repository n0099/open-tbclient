package com.baidu.tieba.imMessageCenter.im.friend;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.i;
import com.baidu.tieba.im.model.BlackListModel;
/* loaded from: classes.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private com.baidu.tbadk.core.dialog.a Lu;
    private BlackListModel bMR;
    private h bMS;
    private com.baidu.tieba.im.data.a bMT;
    private com.baidu.adp.framework.listener.e mListener = new a(this, 0);

    private void initView() {
        this.bMS = new h(this);
    }

    private void Hu() {
        this.bMR = new BlackListModel(this);
        this.bMR.setUniqueId(getUniqueId());
    }

    private void JD() {
        this.bMR.loadBlackList();
        this.bMS.BO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.mListener);
        registerListener(104102, this.mListener);
        initView();
        Hu();
        JD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bMR != null) {
            this.bMR.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zb() {
        showLoadingDialog((String) null, new b(this));
    }

    private void a(com.baidu.tieba.im.data.a aVar) {
        iI(String.format(getPageContext().getString(i.h.black_list_ensure_toremove_text), aVar.getUserName()));
        this.Lu.sO();
    }

    private void iI(String str) {
        this.Lu = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.Lu.cu(str);
        this.Lu.a(i.h.confirm, new c(this));
        this.Lu.b(i.h.alert_no_button, new d(this));
        this.Lu.b(getPageContext());
    }

    public void a(View view, com.baidu.tieba.im.data.a aVar) {
        if (aVar != null && aVar.getUserId() > 0) {
            this.bMT = aVar;
            a(aVar);
        }
    }
}
