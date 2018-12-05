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
import com.baidu.tieba.e;
import com.baidu.tieba.im.data.BlackListItemData;
import com.baidu.tieba.im.message.ResponseGetMaskInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
/* loaded from: classes4.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private com.baidu.tbadk.core.dialog.a Td;
    private com.baidu.adp.framework.listener.c eHa = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            IMBlackListActivity.this.fbT.aUX();
            IMBlackListActivity.this.closeLoadingDialog();
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 104103 && (socketResponsedMessage instanceof ResponseGetMaskInfoMessage)) {
                    ResponseGetMaskInfoMessage responseGetMaskInfoMessage = (ResponseGetMaskInfoMessage) socketResponsedMessage;
                    if (responseGetMaskInfoMessage.getError() == 0) {
                        if (IMBlackListActivity.this.Td != null) {
                            IMBlackListActivity.this.Td.dismiss();
                        }
                        IMBlackListActivity.this.fbT.Y(responseGetMaskInfoMessage.getBlackList());
                        return;
                    }
                    IMBlackListActivity.this.showToast(StringUtils.isNull(responseGetMaskInfoMessage.getErrorString()) ? IMBlackListActivity.this.getResources().getString(e.j.neterror) : responseGetMaskInfoMessage.getErrorString());
                    if (j.kV()) {
                        IMBlackListActivity.this.fbT.refreshData();
                    }
                } else if (socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage) && ((RequestUpdateMaskInfoMessage) orginalMessage).getMaskType() == 10) {
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (IMBlackListActivity.this.Td != null) {
                            IMBlackListActivity.this.Td.dismiss();
                        }
                        IMBlackListActivity.this.showToast(IMBlackListActivity.this.getPageContext().getString(e.j.black_list_remove_success));
                        if (IMBlackListActivity.this.fbU != null) {
                            IMBlackListActivity.this.fbT.b(IMBlackListActivity.this.fbU);
                            IMBlackListActivity.this.fbU = null;
                            return;
                        }
                        return;
                    }
                    IMBlackListActivity.this.showToast(responseUpdateMaskInfoMessage.getErrorString());
                }
            }
        }
    };
    private BlackListModel fbS;
    private b fbT;
    private BlackListItemData fbU;

    private void initView() {
        this.fbT = new b(this);
    }

    private void fc() {
        this.fbS = new BlackListModel(getPageContext());
        this.fbS.setUniqueId(getUniqueId());
    }

    private void loadData() {
        this.fbS.loadBlackList();
        this.fbT.Ne();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.eHa);
        registerListener(104102, this.eHa);
        initView();
        fc();
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fbS != null) {
            this.fbS.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog() {
        showLoadingDialog((String) null, new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (IMBlackListActivity.this.fbS != null) {
                    IMBlackListActivity.this.fbS.cancelLoadData();
                    IMBlackListActivity.this.fbU = null;
                }
            }
        });
    }

    private void a(BlackListItemData blackListItemData) {
        qG(String.format(getPageContext().getString(e.j.black_list_ensure_toremove_text), blackListItemData.Kd()));
        this.Td.BF();
    }

    private void qG(String str) {
        this.Td = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.Td.eB(str);
        this.Td.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.BF();
                if (IMBlackListActivity.this.fbU != null) {
                    IMBlackListActivity.this.showLoadingDialog();
                    IMBlackListActivity.this.fbS.removeFromBlackList(IMBlackListActivity.this.fbU.getUserId());
                }
            }
        });
        this.Td.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.Td.b(getPageContext());
    }

    public void a(View view, BlackListItemData blackListItemData) {
        if (blackListItemData != null && blackListItemData.getUserId() > 0) {
            this.fbU = blackListItemData;
            a(blackListItemData);
        }
    }
}
