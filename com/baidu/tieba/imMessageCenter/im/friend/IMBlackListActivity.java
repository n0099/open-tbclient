package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
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
    private com.baidu.tbadk.core.dialog.a Kj;
    private b dKA;
    private BlackListItemData dKB;
    private BlackListModel dKz;
    private com.baidu.adp.framework.listener.c doT = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            IMBlackListActivity.this.dKA.aBc();
            IMBlackListActivity.this.closeLoadingDialog();
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 104103 && (socketResponsedMessage instanceof ResponseGetMaskInfoMessage)) {
                    ResponseGetMaskInfoMessage responseGetMaskInfoMessage = (ResponseGetMaskInfoMessage) socketResponsedMessage;
                    if (responseGetMaskInfoMessage.getError() == 0) {
                        if (IMBlackListActivity.this.Kj != null) {
                            IMBlackListActivity.this.Kj.dismiss();
                        }
                        IMBlackListActivity.this.dKA.T(responseGetMaskInfoMessage.getBlackList());
                        return;
                    }
                    IMBlackListActivity.this.showToast(StringUtils.isNull(responseGetMaskInfoMessage.getErrorString()) ? IMBlackListActivity.this.getResources().getString(d.l.neterror) : responseGetMaskInfoMessage.getErrorString());
                    if (i.hi()) {
                        IMBlackListActivity.this.dKA.refreshData();
                    }
                } else if (socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage) && ((RequestUpdateMaskInfoMessage) orginalMessage).getMaskType() == 10) {
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (IMBlackListActivity.this.Kj != null) {
                            IMBlackListActivity.this.Kj.dismiss();
                        }
                        IMBlackListActivity.this.showToast(IMBlackListActivity.this.getPageContext().getString(d.l.black_list_remove_success));
                        if (IMBlackListActivity.this.dKB != null) {
                            IMBlackListActivity.this.dKA.b(IMBlackListActivity.this.dKB);
                            IMBlackListActivity.this.dKB = null;
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
        this.dKA = new b(this);
    }

    private void bj() {
        this.dKz = new BlackListModel(getPageContext());
        this.dKz.setUniqueId(getUniqueId());
    }

    private void PN() {
        this.dKz.loadBlackList();
        this.dKA.Ed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.doT);
        registerListener(104102, this.doT);
        initView();
        bj();
        PN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dKz != null) {
            this.dKz.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog() {
        showLoadingDialog((String) null, new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (IMBlackListActivity.this.dKz != null) {
                    IMBlackListActivity.this.dKz.cancelLoadData();
                    IMBlackListActivity.this.dKB = null;
                }
            }
        });
    }

    private void a(BlackListItemData blackListItemData) {
        nh(String.format(getPageContext().getString(d.l.black_list_ensure_toremove_text), blackListItemData.getUserName()));
        this.Kj.to();
    }

    private void nh(String str) {
        this.Kj = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.Kj.cM(str);
        this.Kj.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.to();
                if (IMBlackListActivity.this.dKB != null) {
                    IMBlackListActivity.this.showLoadingDialog();
                    IMBlackListActivity.this.dKz.removeFromBlackList(IMBlackListActivity.this.dKB.getUserId());
                }
            }
        });
        this.Kj.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.Kj.b(getPageContext());
    }

    public void a(View view, BlackListItemData blackListItemData) {
        if (blackListItemData != null && blackListItemData.getUserId() > 0) {
            this.dKB = blackListItemData;
            a(blackListItemData);
        }
    }
}
