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
    private com.baidu.tbadk.core.dialog.a KN;
    private BlackListModel dAH;
    private b dAI;
    private BlackListItemData dAJ;
    private com.baidu.adp.framework.listener.c dfa = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            IMBlackListActivity.this.dAI.ayA();
            IMBlackListActivity.this.closeLoadingDialog();
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 104103 && (socketResponsedMessage instanceof ResponseGetMaskInfoMessage)) {
                    ResponseGetMaskInfoMessage responseGetMaskInfoMessage = (ResponseGetMaskInfoMessage) socketResponsedMessage;
                    if (responseGetMaskInfoMessage.getError() == 0) {
                        if (IMBlackListActivity.this.KN != null) {
                            IMBlackListActivity.this.KN.dismiss();
                        }
                        IMBlackListActivity.this.dAI.T(responseGetMaskInfoMessage.getBlackList());
                        return;
                    }
                    IMBlackListActivity.this.showToast(StringUtils.isNull(responseGetMaskInfoMessage.getErrorString()) ? IMBlackListActivity.this.getResources().getString(d.l.neterror) : responseGetMaskInfoMessage.getErrorString());
                    if (i.hh()) {
                        IMBlackListActivity.this.dAI.refreshData();
                    }
                } else if (socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage) && ((RequestUpdateMaskInfoMessage) orginalMessage).getMaskType() == 10) {
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (IMBlackListActivity.this.KN != null) {
                            IMBlackListActivity.this.KN.dismiss();
                        }
                        IMBlackListActivity.this.showToast(IMBlackListActivity.this.getPageContext().getString(d.l.black_list_remove_success));
                        if (IMBlackListActivity.this.dAJ != null) {
                            IMBlackListActivity.this.dAI.b(IMBlackListActivity.this.dAJ);
                            IMBlackListActivity.this.dAJ = null;
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
        this.dAI = new b(this);
    }

    private void bj() {
        this.dAH = new BlackListModel(getPageContext());
        this.dAH.setUniqueId(getUniqueId());
    }

    private void Pm() {
        this.dAH.loadBlackList();
        this.dAI.DY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.dfa);
        registerListener(104102, this.dfa);
        initView();
        bj();
        Pm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dAH != null) {
            this.dAH.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QS() {
        showLoadingDialog((String) null, new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (IMBlackListActivity.this.dAH != null) {
                    IMBlackListActivity.this.dAH.cancelLoadData();
                    IMBlackListActivity.this.dAJ = null;
                }
            }
        });
    }

    private void a(BlackListItemData blackListItemData) {
        mC(String.format(getPageContext().getString(d.l.black_list_ensure_toremove_text), blackListItemData.getUserName()));
        this.KN.th();
    }

    private void mC(String str) {
        this.KN = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.KN.cN(str);
        this.KN.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.th();
                if (IMBlackListActivity.this.dAJ != null) {
                    IMBlackListActivity.this.QS();
                    IMBlackListActivity.this.dAH.removeFromBlackList(IMBlackListActivity.this.dAJ.getUserId());
                }
            }
        });
        this.KN.b(d.l.alert_no_button, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.KN.b(getPageContext());
    }

    public void a(View view, BlackListItemData blackListItemData) {
        if (blackListItemData != null && blackListItemData.getUserId() > 0) {
            this.dAJ = blackListItemData;
            a(blackListItemData);
        }
    }
}
