package com.baidu.tieba.imMessageCenter.im.friend;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.i;
import com.baidu.tieba.im.model.BlackListModel;
/* loaded from: classes.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private com.baidu.tbadk.core.dialog.a Lt;
    private BlackListModel bJB;
    private h bJC;
    private com.baidu.tieba.im.data.a bJD;
    private com.baidu.adp.framework.listener.e mListener = new a(this, 0);

    private void initView() {
        this.bJC = new h(this);
    }

    private void HE() {
        this.bJB = new BlackListModel(this);
        this.bJB.setUniqueId(getUniqueId());
    }

    private void JM() {
        this.bJB.loadBlackList();
        this.bJC.Ce();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.mListener);
        registerListener(104102, this.mListener);
        initView();
        HE();
        JM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bJB != null) {
            this.bJB.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yx() {
        showLoadingDialog(null, new b(this));
    }

    private void a(com.baidu.tieba.im.data.a aVar) {
        iE(String.format(getPageContext().getString(i.h.black_list_ensure_toremove_text), aVar.getUserName()));
        this.Lt.sU();
    }

    private void iE(String str) {
        this.Lt = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.Lt.ct(str);
        this.Lt.a(i.h.confirm, new c(this));
        this.Lt.b(i.h.alert_no_button, new d(this));
        this.Lt.b(getPageContext());
    }

    public void a(View view, com.baidu.tieba.im.data.a aVar) {
        if (aVar != null && aVar.getUserId() > 0) {
            this.bJD = aVar;
            a(aVar);
        }
    }
}
