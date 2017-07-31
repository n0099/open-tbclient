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
    private com.baidu.tbadk.core.dialog.a Ml;
    private BlackListModel dBY;
    private b dBZ;
    private BlackListItemData dCa;
    private com.baidu.adp.framework.listener.c dgs = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            IMBlackListActivity.this.dBZ.ayL();
            IMBlackListActivity.this.closeLoadingDialog();
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 104103 && (socketResponsedMessage instanceof ResponseGetMaskInfoMessage)) {
                    ResponseGetMaskInfoMessage responseGetMaskInfoMessage = (ResponseGetMaskInfoMessage) socketResponsedMessage;
                    if (responseGetMaskInfoMessage.getError() == 0) {
                        if (IMBlackListActivity.this.Ml != null) {
                            IMBlackListActivity.this.Ml.dismiss();
                        }
                        IMBlackListActivity.this.dBZ.T(responseGetMaskInfoMessage.getBlackList());
                        return;
                    }
                    IMBlackListActivity.this.showToast(StringUtils.isNull(responseGetMaskInfoMessage.getErrorString()) ? IMBlackListActivity.this.getResources().getString(d.l.neterror) : responseGetMaskInfoMessage.getErrorString());
                    if (i.hr()) {
                        IMBlackListActivity.this.dBZ.refreshData();
                    }
                } else if (socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage) && ((RequestUpdateMaskInfoMessage) orginalMessage).getMaskType() == 10) {
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (IMBlackListActivity.this.Ml != null) {
                            IMBlackListActivity.this.Ml.dismiss();
                        }
                        IMBlackListActivity.this.showToast(IMBlackListActivity.this.getPageContext().getString(d.l.black_list_remove_success));
                        if (IMBlackListActivity.this.dCa != null) {
                            IMBlackListActivity.this.dBZ.b(IMBlackListActivity.this.dCa);
                            IMBlackListActivity.this.dCa = null;
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
        this.dBZ = new b(this);
    }

    private void bu() {
        this.dBY = new BlackListModel(getPageContext());
        this.dBY.setUniqueId(getUniqueId());
    }

    private void Pr() {
        this.dBY.loadBlackList();
        this.dBZ.Eg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.dgs);
        registerListener(104102, this.dgs);
        initView();
        bu();
        Pr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dBY != null) {
            this.dBY.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QX() {
        showLoadingDialog((String) null, new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (IMBlackListActivity.this.dBY != null) {
                    IMBlackListActivity.this.dBY.cancelLoadData();
                    IMBlackListActivity.this.dCa = null;
                }
            }
        });
    }

    private void a(BlackListItemData blackListItemData) {
        mG(String.format(getPageContext().getString(d.l.black_list_ensure_toremove_text), blackListItemData.getUserName()));
        this.Ml.tr();
    }

    private void mG(String str) {
        this.Ml = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.Ml.cT(str);
        this.Ml.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.tr();
                if (IMBlackListActivity.this.dCa != null) {
                    IMBlackListActivity.this.QX();
                    IMBlackListActivity.this.dBY.removeFromBlackList(IMBlackListActivity.this.dCa.getUserId());
                }
            }
        });
        this.Ml.b(d.l.alert_no_button, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.Ml.b(getPageContext());
    }

    public void a(View view, BlackListItemData blackListItemData) {
        if (blackListItemData != null && blackListItemData.getUserId() > 0) {
            this.dCa = blackListItemData;
            a(blackListItemData);
        }
    }
}
