package com.baidu.tieba.imMessageCenter.im.friend;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.BlackListItemData;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private com.baidu.tbadk.core.dialog.a La;
    private com.baidu.adp.framework.listener.e cIY = new a(this, 0);
    private BlackListModel deP;
    private h deQ;
    private BlackListItemData deR;

    private void initView() {
        this.deQ = new h(this);
    }

    private void bj() {
        this.deP = new BlackListModel(getPageContext());
        this.deP.setUniqueId(getUniqueId());
    }

    private void NA() {
        this.deP.loadBlackList();
        this.deQ.Dy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.cIY);
        registerListener(104102, this.cIY);
        initView();
        bj();
        NA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.deP != null) {
            this.deP.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asr() {
        showLoadingDialog((String) null, new b(this));
    }

    private void a(BlackListItemData blackListItemData) {
        lf(String.format(getPageContext().getString(w.l.black_list_ensure_toremove_text), blackListItemData.getUserName()));
        this.La.td();
    }

    private void lf(String str) {
        this.La = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.La.cC(str);
        this.La.a(w.l.confirm, new c(this));
        this.La.b(w.l.alert_no_button, new d(this));
        this.La.b(getPageContext());
    }

    public void a(View view, BlackListItemData blackListItemData) {
        if (blackListItemData != null && blackListItemData.getUserId() > 0) {
            this.deR = blackListItemData;
            a(blackListItemData);
        }
    }
}
