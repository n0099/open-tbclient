package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.BlackListItemData;
import com.baidu.tieba.im.message.ResponseGetMaskInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
/* loaded from: classes2.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private com.baidu.tbadk.core.dialog.a KB;
    private BlackListModel dHv;
    private b dHw;
    private BlackListItemData dHx;
    private com.baidu.adp.framework.listener.c dlQ = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            IMBlackListActivity.this.dHw.azT();
            IMBlackListActivity.this.closeLoadingDialog();
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 104103 && (socketResponsedMessage instanceof ResponseGetMaskInfoMessage)) {
                    ResponseGetMaskInfoMessage responseGetMaskInfoMessage = (ResponseGetMaskInfoMessage) socketResponsedMessage;
                    if (responseGetMaskInfoMessage.getError() == 0) {
                        if (IMBlackListActivity.this.KB != null) {
                            IMBlackListActivity.this.KB.dismiss();
                        }
                        IMBlackListActivity.this.dHw.R(responseGetMaskInfoMessage.getBlackList());
                        return;
                    }
                    IMBlackListActivity.this.showToast(StringUtils.isNull(responseGetMaskInfoMessage.getErrorString()) ? IMBlackListActivity.this.getResources().getString(d.l.neterror) : responseGetMaskInfoMessage.getErrorString());
                    if (j.hh()) {
                        IMBlackListActivity.this.dHw.refreshData();
                    }
                } else if (socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage) && ((RequestUpdateMaskInfoMessage) orginalMessage).getMaskType() == 10) {
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (IMBlackListActivity.this.KB != null) {
                            IMBlackListActivity.this.KB.dismiss();
                        }
                        IMBlackListActivity.this.showToast(IMBlackListActivity.this.getPageContext().getString(d.l.black_list_remove_success));
                        if (IMBlackListActivity.this.dHx != null) {
                            IMBlackListActivity.this.dHw.b(IMBlackListActivity.this.dHx);
                            IMBlackListActivity.this.dHx = null;
                            return;
                        }
                        return;
                    }
                    IMBlackListActivity.this.showToast(responseUpdateMaskInfoMessage.getErrorString());
                }
            }
        }
    };

    private void initView() {
        this.dHw = new b(this);
    }

    private void bj() {
        this.dHv = new BlackListModel(getPageContext());
        this.dHv.setUniqueId(getUniqueId());
    }

    private void Qf() {
        this.dHv.loadBlackList();
        this.dHw.DB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.dlQ);
        registerListener(104102, this.dlQ);
        initView();
        bj();
        Qf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dHv != null) {
            this.dHv.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog() {
        showLoadingDialog((String) null, new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (IMBlackListActivity.this.dHv != null) {
                    IMBlackListActivity.this.dHv.cancelLoadData();
                    IMBlackListActivity.this.dHx = null;
                }
            }
        });
    }

    private void a(BlackListItemData blackListItemData) {
        mM(String.format(getPageContext().getString(d.l.black_list_ensure_toremove_text), blackListItemData.getUserName()));
        this.KB.tb();
    }

    private void mM(String str) {
        this.KB = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.KB.cL(str);
        this.KB.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.tb();
                if (IMBlackListActivity.this.dHx != null) {
                    IMBlackListActivity.this.showLoadingDialog();
                    IMBlackListActivity.this.dHv.removeFromBlackList(IMBlackListActivity.this.dHx.getUserId());
                }
            }
        });
        this.KB.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.KB.b(getPageContext());
    }

    public void a(View view, BlackListItemData blackListItemData) {
        if (blackListItemData != null && blackListItemData.getUserId() > 0) {
            this.dHx = blackListItemData;
            a(blackListItemData);
        }
    }
}
