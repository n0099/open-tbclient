package com.baidu.tieba.im.validate;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.RequestAddGroupUserMessage;
import com.baidu.tieba.im.message.RequestDelSystemMessage;
import com.baidu.tieba.im.model.ValidateModel;
import com.baidu.tieba.y;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class ValidateActivity extends BaseActivity<ValidateActivity> implements x {
    private boolean amT;
    private p bnA;
    private com.baidu.tieba.im.g<Boolean> bnB;
    private ValidateItemData bnC;
    private com.baidu.tieba.im.g<Integer> bnF;
    private com.baidu.tbadk.core.dialog.e deleteItemDialog;
    private com.baidu.tieba.im.g<LinkedList<GroupNewsPojo>> getDataCallBack;
    private int offset;
    private int totalCount;
    private boolean bnD = false;
    private int bnE = 20;
    private com.baidu.adp.framework.listener.e mListener = new a(this, 0);
    private CustomMessageListener mCustomListener = new b(this, 2001129);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bnA = new p(this);
        initDataCallBack();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        ChatStatusManager.getInst().setIsOpen(7, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.coreExtra.messageCenter.a.uT().cD(1);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new com.baidu.tbadk.live.message.a("-1003", -4)));
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        ChatStatusManager.getInst().setIsOpen(7, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        h TE;
        super.onStop();
        ChatStatusManager.getInst().setIsOpen(7, false);
        if (this.bnA != null && (TE = this.bnA.TE()) != null) {
            ValidateModel.markShown(TE.getDatas());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    private void initDataCallBack() {
        this.bnB = new c(this);
        this.getDataCallBack = new d(this);
        this.bnF = new e(this);
        registerListener(103111, this.mListener);
        registerListener(202004, this.mListener);
        registerListener(this.mCustomListener);
        this.bnA.setLoadProgressBarVisable(true);
        ValidateModel.requestValidateDataCountFromDB(this.bnF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bnA != null) {
            this.bnA.destroy();
        }
        this.bnC = null;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.bnA != null && view.equals(this.bnA.TD())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bnA != null) {
            this.bnA.onChangeSkinType(i);
        }
    }

    public void a(View view, int i, int i2, long j, ValidateItemData validateItemData) {
        if (validateItemData != null) {
            if (100 == i) {
                d(validateItemData);
            } else if (101 == i) {
                c(validateItemData);
            }
        }
    }

    public void b(View view, int i, int i2, long j, ValidateItemData validateItemData) {
        if (view != null && validateItemData != null && 200 == i) {
            this.bnC = validateItemData;
            if (this.deleteItemDialog == null) {
                initDeleteDialog();
            }
            this.deleteItemDialog.rg();
        }
    }

    private void initDeleteDialog() {
        String string = getPageContext().getString(y.delete_user_chat);
        f fVar = new f(this);
        this.deleteItemDialog = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
        this.deleteItemDialog.by(y.operation);
        this.deleteItemDialog.a(new String[]{string}, fVar);
        this.deleteItemDialog.d(getPageContext());
    }

    private void c(ValidateItemData validateItemData) {
        if (validateItemData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), validateItemData.getUserId(), validateItemData.getUserName())));
        }
    }

    private void d(ValidateItemData validateItemData) {
        if (!com.baidu.adp.lib.util.k.iH()) {
            showToast(y.neterror);
        } else if (validateItemData != null && !validateItemData.isPass() && !this.bnD) {
            try {
                validateItemData.setShown(true);
                this.bnA.setLoadProgressBarVisable(true);
                RequestAddGroupUserMessage requestAddGroupUserMessage = new RequestAddGroupUserMessage();
                requestAddGroupUserMessage.setInviterUserId(validateItemData.getInviterUserId());
                requestAddGroupUserMessage.setJoinType(validateItemData.getJoinType());
                requestAddGroupUserMessage.setUserIds(validateItemData.getUserId());
                requestAddGroupUserMessage.setGroupId(com.baidu.adp.lib.g.c.toInt(validateItemData.getGroupId(), 0));
                requestAddGroupUserMessage.setNotice_id(validateItemData.getNotice_id());
                String notice_id = validateItemData.getNotice_id();
                String Ta = com.baidu.tieba.im.pushNotify.d.SY().Ta();
                if (!TextUtils.isEmpty(notice_id) && !TextUtils.isEmpty(Ta) && TextUtils.isDigitsOnly(notice_id) && TextUtils.isDigitsOnly(Ta)) {
                    requestAddGroupUserMessage.setSysGroupId(com.baidu.adp.lib.g.c.toInt(Ta, 0));
                    requestAddGroupUserMessage.setSysMsgId(String.valueOf(com.baidu.adp.lib.g.c.a(notice_id, 0L) / 100));
                    requestAddGroupUserMessage.setDecision(1);
                    this.bnD = true;
                    MessageManager.getInstance().sendMessage(requestAddGroupUserMessage);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0037: ARITH  (r1v5 long A[REMOVE]) = (wrap: long : 0x002c: INVOKE  (r1v4 long A[REMOVE]) = 
      (wrap: java.lang.String : 0x0028: INVOKE  (r1v3 java.lang.String A[REMOVE]) = (r8v0 com.baidu.tieba.im.data.ValidateItemData) type: VIRTUAL call: com.baidu.tieba.im.data.ValidateItemData.getNotice_id():java.lang.String)
     type: STATIC call: java.lang.Long.parseLong(java.lang.String):long) / (100 long))] */
    /* JADX INFO: Access modifiers changed from: private */
    public void e(ValidateItemData validateItemData) {
        if (!com.baidu.adp.lib.util.k.iH()) {
            showToast(y.neterror);
        } else if (validateItemData != null) {
            this.bnA.setLoadProgressBarVisable(true);
            RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
            requestDelSystemMessage.setGroupId(Integer.parseInt(com.baidu.tieba.im.pushNotify.d.SY().Ta()));
            requestDelSystemMessage.setMsgIds(new StringBuilder().append(Long.parseLong(validateItemData.getNotice_id()) / 100).toString());
            this.bnD = true;
            MessageManager.getInstance().sendMessage(requestDelSystemMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ValidateItemData gW(String str) {
        if (str == null) {
            return null;
        }
        List<ValidateItemData> datas = this.bnA.TE().getDatas();
        if (datas != null) {
            for (ValidateItemData validateItemData : datas) {
                if (str.equals(validateItemData.getNotice_id())) {
                    return validateItemData;
                }
            }
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        if (!this.amT && this.offset < this.totalCount) {
            this.amT = true;
            ValidateModel.requestValidateDataFromDB(this.bnE, this.offset, this.getDataCallBack);
        }
    }
}
