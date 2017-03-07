package com.baidu.tieba.imMessageCenter.im.friend;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.data.BlackListItemData;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private com.baidu.tbadk.core.dialog.a Mf;
    private com.baidu.adp.framework.listener.e cOh = new a(this, 0);
    private BlackListModel djW;
    private h djX;
    private BlackListItemData djY;

    private void initView() {
        this.djX = new h(this);
    }

    private void bk() {
        this.djW = new BlackListModel(getPageContext());
        this.djW.setUniqueId(getUniqueId());
    }

    private void NE() {
        this.djW.loadBlackList();
        this.djX.DW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.cOh);
        registerListener(104102, this.cOh);
        initView();
        bk();
        NE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.djW != null) {
            this.djW.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auC() {
        showLoadingDialog((String) null, new b(this));
    }

    private void a(BlackListItemData blackListItemData) {
        kU(String.format(getPageContext().getString(w.l.black_list_ensure_toremove_text), blackListItemData.getUserName()));
        this.Mf.ts();
    }

    private void kU(String str) {
        this.Mf = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.Mf.cx(str);
        this.Mf.a(w.l.confirm, new c(this));
        this.Mf.b(w.l.alert_no_button, new d(this));
        this.Mf.b(getPageContext());
    }

    public void a(View view, BlackListItemData blackListItemData) {
        if (blackListItemData != null && blackListItemData.getUserId() > 0) {
            this.djY = blackListItemData;
            a(blackListItemData);
        }
    }
}
