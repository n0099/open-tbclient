package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.BlackListItemData;
import com.baidu.tieba.im.message.ResponseGetMaskInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
/* loaded from: classes22.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private com.baidu.tbadk.core.dialog.a abn;
    private com.baidu.adp.framework.listener.c jUQ = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            IMBlackListActivity.this.krT.cVU();
            IMBlackListActivity.this.closeLoadingDialog();
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 104103 && (socketResponsedMessage instanceof ResponseGetMaskInfoMessage)) {
                    ResponseGetMaskInfoMessage responseGetMaskInfoMessage = (ResponseGetMaskInfoMessage) socketResponsedMessage;
                    if (responseGetMaskInfoMessage.getError() == 0) {
                        if (IMBlackListActivity.this.abn != null) {
                            IMBlackListActivity.this.abn.dismiss();
                        }
                        IMBlackListActivity.this.krT.aI(responseGetMaskInfoMessage.getBlackList());
                        return;
                    }
                    IMBlackListActivity.this.showToast(StringUtils.isNull(responseGetMaskInfoMessage.getErrorString()) ? IMBlackListActivity.this.getResources().getString(R.string.neterror) : responseGetMaskInfoMessage.getErrorString());
                    if (j.isNetWorkAvailable()) {
                        IMBlackListActivity.this.krT.refreshData();
                    }
                } else if (socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage) && ((RequestUpdateMaskInfoMessage) orginalMessage).getMaskType() == 10) {
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (IMBlackListActivity.this.abn != null) {
                            IMBlackListActivity.this.abn.dismiss();
                        }
                        IMBlackListActivity.this.showToast(IMBlackListActivity.this.getPageContext().getString(R.string.black_list_remove_success));
                        if (IMBlackListActivity.this.krU != null) {
                            IMBlackListActivity.this.krT.b(IMBlackListActivity.this.krU);
                            IMBlackListActivity.this.krU = null;
                            return;
                        }
                        return;
                    }
                    IMBlackListActivity.this.showToast(responseUpdateMaskInfoMessage.getErrorString());
                }
            }
        }
    };
    private BlackListModel krS;
    private b krT;
    private BlackListItemData krU;

    private void initView() {
        this.krT = new b(this);
    }

    private void Jz() {
        this.krS = new BlackListModel(getPageContext());
        this.krS.setUniqueId(getUniqueId());
    }

    private void loadData() {
        this.krS.loadBlackList();
        this.krT.bAQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(CmdConfigSocket.CMD_GET_MASK_INFO, this.jUQ);
        registerListener(CmdConfigSocket.CMD_UPDATE_MASK_INFO, this.jUQ);
        initView();
        Jz();
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.krS != null) {
            this.krS.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog() {
        showLoadingDialog((String) null, new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (IMBlackListActivity.this.krS != null) {
                    IMBlackListActivity.this.krS.cancelLoadData();
                    IMBlackListActivity.this.krU = null;
                }
            }
        });
    }

    private void a(BlackListItemData blackListItemData) {
        Nq(String.format(getPageContext().getString(R.string.black_list_ensure_toremove_text), blackListItemData.bxr()));
        this.abn.bpc();
    }

    private void Nq(String str) {
        this.abn = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.abn.Bo(str);
        this.abn.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.bpc();
                if (IMBlackListActivity.this.krU != null) {
                    IMBlackListActivity.this.showLoadingDialog();
                    IMBlackListActivity.this.krS.removeFromBlackList(IMBlackListActivity.this.krU.getUserId());
                }
            }
        });
        this.abn.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.abn.b(getPageContext());
    }

    public void a(View view, BlackListItemData blackListItemData) {
        if (blackListItemData != null && blackListItemData.getUserId() > 0) {
            this.krU = blackListItemData;
            a(blackListItemData);
        }
    }
}
