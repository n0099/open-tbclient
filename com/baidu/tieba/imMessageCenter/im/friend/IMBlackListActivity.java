package com.baidu.tieba.imMessageCenter.im.friend;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.i;
import com.baidu.tieba.im.model.BlackListModel;
/* loaded from: classes.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private com.baidu.tbadk.core.dialog.a Lv;
    private BlackListModel bNm;
    private h bNn;
    private com.baidu.tieba.im.data.a bNo;
    private com.baidu.adp.framework.listener.e mListener = new a(this, 0);

    private void initView() {
        this.bNn = new h(this);
    }

    private void Hr() {
        this.bNm = new BlackListModel(this);
        this.bNm.setUniqueId(getUniqueId());
    }

    private void JT() {
        this.bNm.loadBlackList();
        this.bNn.BH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.mListener);
        registerListener(104102, this.mListener);
        initView();
        Hr();
        JT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bNm != null) {
            this.bNm.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zw() {
        showLoadingDialog((String) null, new b(this));
    }

    private void a(com.baidu.tieba.im.data.a aVar) {
        iK(String.format(getPageContext().getString(i.h.black_list_ensure_toremove_text), aVar.getUserName()));
        this.Lv.sR();
    }

    private void iK(String str) {
        this.Lv = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.Lv.cu(str);
        this.Lv.a(i.h.confirm, new c(this));
        this.Lv.b(i.h.alert_no_button, new d(this));
        this.Lv.b(getPageContext());
    }

    public void a(View view, com.baidu.tieba.im.data.a aVar) {
        if (aVar != null && aVar.getUserId() > 0) {
            this.bNo = aVar;
            a(aVar);
        }
    }
}
