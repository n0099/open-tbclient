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
    private com.baidu.tbadk.core.dialog.a acq;
    private BlackListModel kFZ;
    private b kGa;
    private BlackListItemData kGb;
    private com.baidu.adp.framework.listener.c kjh = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            IMBlackListActivity.this.kGa.daN();
            IMBlackListActivity.this.closeLoadingDialog();
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 104103 && (socketResponsedMessage instanceof ResponseGetMaskInfoMessage)) {
                    ResponseGetMaskInfoMessage responseGetMaskInfoMessage = (ResponseGetMaskInfoMessage) socketResponsedMessage;
                    if (responseGetMaskInfoMessage.getError() == 0) {
                        if (IMBlackListActivity.this.acq != null) {
                            IMBlackListActivity.this.acq.dismiss();
                        }
                        IMBlackListActivity.this.kGa.aL(responseGetMaskInfoMessage.getBlackList());
                        return;
                    }
                    IMBlackListActivity.this.showToast(StringUtils.isNull(responseGetMaskInfoMessage.getErrorString()) ? IMBlackListActivity.this.getResources().getString(R.string.neterror) : responseGetMaskInfoMessage.getErrorString());
                    if (j.isNetWorkAvailable()) {
                        IMBlackListActivity.this.kGa.refreshData();
                    }
                } else if (socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage) && ((RequestUpdateMaskInfoMessage) orginalMessage).getMaskType() == 10) {
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (IMBlackListActivity.this.acq != null) {
                            IMBlackListActivity.this.acq.dismiss();
                        }
                        IMBlackListActivity.this.showToast(IMBlackListActivity.this.getPageContext().getString(R.string.black_list_remove_success));
                        if (IMBlackListActivity.this.kGb != null) {
                            IMBlackListActivity.this.kGa.b(IMBlackListActivity.this.kGb);
                            IMBlackListActivity.this.kGb = null;
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
        this.kGa = new b(this);
    }

    private void KR() {
        this.kFZ = new BlackListModel(getPageContext());
        this.kFZ.setUniqueId(getUniqueId());
    }

    private void loadData() {
        this.kFZ.loadBlackList();
        this.kGa.bDG();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(CmdConfigSocket.CMD_GET_MASK_INFO, this.kjh);
        registerListener(CmdConfigSocket.CMD_UPDATE_MASK_INFO, this.kjh);
        initView();
        KR();
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.kFZ != null) {
            this.kFZ.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog() {
        showLoadingDialog((String) null, new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (IMBlackListActivity.this.kFZ != null) {
                    IMBlackListActivity.this.kFZ.cancelLoadData();
                    IMBlackListActivity.this.kGb = null;
                }
            }
        });
    }

    private void a(BlackListItemData blackListItemData) {
        NZ(String.format(getPageContext().getString(R.string.black_list_ensure_toremove_text), blackListItemData.bAh()));
        this.acq.brv();
    }

    private void NZ(String str) {
        this.acq = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.acq.Bq(str);
        this.acq.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.brv();
                if (IMBlackListActivity.this.kGb != null) {
                    IMBlackListActivity.this.showLoadingDialog();
                    IMBlackListActivity.this.kFZ.removeFromBlackList(IMBlackListActivity.this.kGb.getUserId());
                }
            }
        });
        this.acq.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.acq.b(getPageContext());
    }

    public void a(View view, BlackListItemData blackListItemData) {
        if (blackListItemData != null && blackListItemData.getUserId() > 0) {
            this.kGb = blackListItemData;
            a(blackListItemData);
        }
    }
}
