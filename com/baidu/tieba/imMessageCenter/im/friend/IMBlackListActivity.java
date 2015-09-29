package com.baidu.tieba.imMessageCenter.im.friend;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.i;
import com.baidu.tieba.im.model.BlackListModel;
/* loaded from: classes.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private com.baidu.tbadk.core.dialog.a Lt;
    private BlackListModel bMG;
    private h bMH;
    private com.baidu.tieba.im.data.a bMI;
    private com.baidu.adp.framework.listener.e mListener = new a(this, 0);

    private void initView() {
        this.bMH = new h(this);
    }

    private void Hy() {
        this.bMG = new BlackListModel(this);
        this.bMG.setUniqueId(getUniqueId());
    }

    private void JH() {
        this.bMG.loadBlackList();
        this.bMH.BR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.mListener);
        registerListener(104102, this.mListener);
        initView();
        Hy();
        JH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bMG != null) {
            this.bMG.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zf() {
        showLoadingDialog((String) null, new b(this));
    }

    private void a(com.baidu.tieba.im.data.a aVar) {
        iI(String.format(getPageContext().getString(i.h.black_list_ensure_toremove_text), aVar.getUserName()));
        this.Lt.sR();
    }

    private void iI(String str) {
        this.Lt = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.Lt.ct(str);
        this.Lt.a(i.h.confirm, new c(this));
        this.Lt.b(i.h.alert_no_button, new d(this));
        this.Lt.b(getPageContext());
    }

    public void a(View view, com.baidu.tieba.im.data.a aVar) {
        if (aVar != null && aVar.getUserId() > 0) {
            this.bMI = aVar;
            a(aVar);
        }
    }
}
