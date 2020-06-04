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
/* loaded from: classes9.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private com.baidu.tbadk.core.dialog.a Zw;
    private BlackListModel iNt;
    private b iNu;
    private BlackListItemData iNv;
    private com.baidu.adp.framework.listener.c isB = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            IMBlackListActivity.this.iNu.cqo();
            IMBlackListActivity.this.closeLoadingDialog();
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 104103 && (socketResponsedMessage instanceof ResponseGetMaskInfoMessage)) {
                    ResponseGetMaskInfoMessage responseGetMaskInfoMessage = (ResponseGetMaskInfoMessage) socketResponsedMessage;
                    if (responseGetMaskInfoMessage.getError() == 0) {
                        if (IMBlackListActivity.this.Zw != null) {
                            IMBlackListActivity.this.Zw.dismiss();
                        }
                        IMBlackListActivity.this.iNu.ax(responseGetMaskInfoMessage.getBlackList());
                        return;
                    }
                    IMBlackListActivity.this.showToast(StringUtils.isNull(responseGetMaskInfoMessage.getErrorString()) ? IMBlackListActivity.this.getResources().getString(R.string.neterror) : responseGetMaskInfoMessage.getErrorString());
                    if (j.isNetWorkAvailable()) {
                        IMBlackListActivity.this.iNu.refreshData();
                    }
                } else if (socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage) && ((RequestUpdateMaskInfoMessage) orginalMessage).getMaskType() == 10) {
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (IMBlackListActivity.this.Zw != null) {
                            IMBlackListActivity.this.Zw.dismiss();
                        }
                        IMBlackListActivity.this.showToast(IMBlackListActivity.this.getPageContext().getString(R.string.black_list_remove_success));
                        if (IMBlackListActivity.this.iNv != null) {
                            IMBlackListActivity.this.iNu.b(IMBlackListActivity.this.iNv);
                            IMBlackListActivity.this.iNv = null;
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
        this.iNu = new b(this);
    }

    private void AC() {
        this.iNt = new BlackListModel(getPageContext());
        this.iNt.setUniqueId(getUniqueId());
    }

    private void loadData() {
        this.iNt.loadBlackList();
        this.iNu.beh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(CmdConfigSocket.CMD_GET_MASK_INFO, this.isB);
        registerListener(CmdConfigSocket.CMD_UPDATE_MASK_INFO, this.isB);
        initView();
        AC();
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.iNt != null) {
            this.iNt.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog() {
        showLoadingDialog((String) null, new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (IMBlackListActivity.this.iNt != null) {
                    IMBlackListActivity.this.iNt.cancelLoadData();
                    IMBlackListActivity.this.iNv = null;
                }
            }
        });
    }

    private void a(BlackListItemData blackListItemData) {
        Ha(String.format(getPageContext().getString(R.string.black_list_ensure_toremove_text), blackListItemData.bba()));
        this.Zw.aST();
    }

    private void Ha(String str) {
        this.Zw = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.Zw.vO(str);
        this.Zw.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.aST();
                if (IMBlackListActivity.this.iNv != null) {
                    IMBlackListActivity.this.showLoadingDialog();
                    IMBlackListActivity.this.iNt.removeFromBlackList(IMBlackListActivity.this.iNv.getUserId());
                }
            }
        });
        this.Zw.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.Zw.b(getPageContext());
    }

    public void a(View view, BlackListItemData blackListItemData) {
        if (blackListItemData != null && blackListItemData.getUserId() > 0) {
            this.iNv = blackListItemData;
            a(blackListItemData);
        }
    }
}
