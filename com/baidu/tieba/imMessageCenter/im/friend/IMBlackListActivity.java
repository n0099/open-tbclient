package com.baidu.tieba.imMessageCenter.im.friend;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.i;
import com.baidu.tieba.im.model.BlackListModel;
/* loaded from: classes.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private com.baidu.tbadk.core.dialog.a Lt;
    private BlackListModel bIU;
    private h bIV;
    private com.baidu.tieba.im.data.a bIW;
    private com.baidu.adp.framework.listener.e mListener = new a(this, 0);

    private void initView() {
        this.bIV = new h(this);
    }

    private void HQ() {
        this.bIU = new BlackListModel(this);
        this.bIU.setUniqueId(getUniqueId());
    }

    private void JY() {
        this.bIU.loadBlackList();
        this.bIV.BQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.mListener);
        registerListener(104102, this.mListener);
        initView();
        HQ();
        JY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bIU != null) {
            this.bIU.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yv() {
        showLoadingDialog(null, new b(this));
    }

    private void a(com.baidu.tieba.im.data.a aVar) {
        iv(String.format(getPageContext().getString(i.C0057i.black_list_ensure_toremove_text), aVar.getUserName()));
        this.Lt.sP();
    }

    private void iv(String str) {
        this.Lt = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.Lt.cn(str);
        this.Lt.a(i.C0057i.confirm, new c(this));
        this.Lt.b(i.C0057i.alert_no_button, new d(this));
        this.Lt.b(getPageContext());
    }

    public void a(View view, com.baidu.tieba.im.data.a aVar) {
        if (aVar != null && aVar.getUserId() > 0) {
            this.bIW = aVar;
            a(aVar);
        }
    }
}
