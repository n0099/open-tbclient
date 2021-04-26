package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.BlackListItemData;
import com.baidu.tieba.im.message.ResponseGetMaskInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import d.a.c.e.p.j;
import d.a.i0.r.s.a;
/* loaded from: classes4.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    public d.a.i0.r.s.a mDialog;
    public d.a.c.c.g.c mListener = new a(0);
    public BlackListModel mModel;
    public BlackListItemData mNeedRemovedData;
    public d.a.j0.f1.a.c.b mView;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.c {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            IMBlackListActivity.this.mView.e();
            IMBlackListActivity.this.closeLoadingDialog();
            if (socketResponsedMessage == null) {
                return;
            }
            if (socketResponsedMessage.getCmd() == 104103 && (socketResponsedMessage instanceof ResponseGetMaskInfoMessage)) {
                ResponseGetMaskInfoMessage responseGetMaskInfoMessage = (ResponseGetMaskInfoMessage) socketResponsedMessage;
                if (responseGetMaskInfoMessage.getError() == 0) {
                    if (IMBlackListActivity.this.mDialog != null) {
                        IMBlackListActivity.this.mDialog.dismiss();
                    }
                    IMBlackListActivity.this.mView.j(responseGetMaskInfoMessage.getBlackList());
                    return;
                }
                IMBlackListActivity.this.showToast(StringUtils.isNull(responseGetMaskInfoMessage.getErrorString()) ? IMBlackListActivity.this.getResources().getString(R.string.neterror) : responseGetMaskInfoMessage.getErrorString());
                if (j.z()) {
                    IMBlackListActivity.this.mView.h();
                }
            } else if (socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage) && ((RequestUpdateMaskInfoMessage) orginalMessage).getMaskType() == 10) {
                if (responseUpdateMaskInfoMessage.getError() == 0) {
                    if (IMBlackListActivity.this.mDialog != null) {
                        IMBlackListActivity.this.mDialog.dismiss();
                    }
                    IMBlackListActivity iMBlackListActivity = IMBlackListActivity.this;
                    iMBlackListActivity.showToast(iMBlackListActivity.getPageContext().getString(R.string.black_list_remove_success));
                    if (IMBlackListActivity.this.mNeedRemovedData != null) {
                        IMBlackListActivity.this.mView.k(IMBlackListActivity.this.mNeedRemovedData);
                        IMBlackListActivity.this.mNeedRemovedData = null;
                        return;
                    }
                    return;
                }
                IMBlackListActivity.this.showToast(responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements DialogInterface.OnCancelListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (IMBlackListActivity.this.mModel != null) {
                IMBlackListActivity.this.mModel.cancelLoadData();
                IMBlackListActivity.this.mNeedRemovedData = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            aVar.show();
            if (IMBlackListActivity.this.mNeedRemovedData != null) {
                IMBlackListActivity.this.showLoadingDialog();
                IMBlackListActivity.this.mModel.removeFromBlackList(IMBlackListActivity.this.mNeedRemovedData.getUserId());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {
        public d() {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    private void createDialog(String str) {
        d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(getPageContext().getPageActivity());
        this.mDialog = aVar;
        aVar.setMessage(str);
        this.mDialog.setPositiveButton(R.string.confirm, new c());
        this.mDialog.setNegativeButton(R.string.cancel, new d());
        this.mDialog.create(getPageContext());
    }

    private void initModel() {
        BlackListModel blackListModel = new BlackListModel(getPageContext());
        this.mModel = blackListModel;
        blackListModel.setUniqueId(getUniqueId());
    }

    private void initView() {
        this.mView = new d.a.j0.f1.a.c.b(this);
    }

    private void loadData() {
        this.mModel.loadBlackList();
        this.mView.g();
    }

    private void showDialog(BlackListItemData blackListItemData) {
        createDialog(String.format(getPageContext().getString(R.string.black_list_ensure_toremove_text), blackListItemData.t()));
        this.mDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog() {
        showLoadingDialog((String) null, new b());
    }

    public void handler(View view, BlackListItemData blackListItemData) {
        if (blackListItemData == null || blackListItemData.getUserId() <= 0) {
            return;
        }
        this.mNeedRemovedData = blackListItemData;
        showDialog(blackListItemData);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.mListener);
        registerListener(104102, this.mListener);
        initView();
        initModel();
        loadData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        BlackListModel blackListModel = this.mModel;
        if (blackListModel != null) {
            blackListModel.cancelLoadData();
        }
    }
}
