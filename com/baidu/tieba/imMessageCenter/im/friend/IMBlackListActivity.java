package com.baidu.tieba.imMessageCenter.im.friend;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private com.baidu.tbadk.core.dialog.a FF;
    private com.baidu.adp.framework.listener.e coV = new a(this, 0);
    private BlackListModel dxs;
    private h dxt;
    private com.baidu.tieba.im.data.a dxu;

    private void initView() {
        this.dxt = new h(this);
    }

    private void aa() {
        this.dxs = new BlackListModel(getPageContext());
        this.dxs.setUniqueId(getUniqueId());
    }

    private void SN() {
        this.dxs.loadBlackList();
        this.dxt.Ea();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.coV);
        registerListener(104102, this.coV);
        initView();
        aa();
        SN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dxs != null) {
            this.dxs.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAF() {
        showLoadingDialog((String) null, new b(this));
    }

    private void a(com.baidu.tieba.im.data.a aVar) {
        mR(String.format(getPageContext().getString(r.j.black_list_ensure_toremove_text), aVar.getUserName()));
        this.FF.tq();
    }

    private void mR(String str) {
        this.FF = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.FF.cF(str);
        this.FF.a(r.j.confirm, new c(this));
        this.FF.b(r.j.alert_no_button, new d(this));
        this.FF.b(getPageContext());
    }

    public void a(View view, com.baidu.tieba.im.data.a aVar) {
        if (aVar != null && aVar.getUserId() > 0) {
            this.dxu = aVar;
            a(aVar);
        }
    }
}
