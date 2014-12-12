package com.baidu.tieba.im.validate;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.RequestAddGroupUserMessage;
import com.baidu.tieba.im.message.RequestDelSystemMessage;
import com.baidu.tieba.im.model.ValidateModel;
import com.baidu.tieba.z;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class ValidateActivity extends BaseActivity<ValidateActivity> implements ab {
    private boolean aef;
    private m bon;
    private com.baidu.tieba.im.g<Boolean> boo;
    private ValidateItemData bop;
    private com.baidu.tieba.im.g<Integer> bos;
    private AlertDialog deleteItemDialog;
    private com.baidu.tieba.im.g<LinkedList<GroupNewsPojo>> getDataCallBack;
    private int offset;
    private int totalCount;
    private boolean boq = false;
    private int bor = 20;
    private com.baidu.adp.framework.listener.e mListener = new a(this, 0);
    private CustomMessageListener mCustomListener = new b(this, 2001129);

    static {
        Kv();
    }

    private static void Kv() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008021, new c());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bon = new m(this);
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
        com.baidu.tbadk.coreExtra.messageCenter.a.rI().cx(1);
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
        h Tn;
        super.onStop();
        ChatStatusManager.getInst().setIsOpen(7, false);
        if (this.bon != null && (Tn = this.bon.Tn()) != null) {
            ValidateModel.markShown(Tn.getDatas());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    private void initDataCallBack() {
        this.boo = new d(this);
        this.getDataCallBack = new e(this);
        this.bos = new f(this);
        registerListener(103111, this.mListener);
        registerListener(202004, this.mListener);
        registerListener(this.mCustomListener);
        this.bon.setLoadProgressBarVisable(true);
        ValidateModel.requestValidateDataCountFromDB(this.bos);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bon != null) {
            this.bon.destroy();
        }
        this.bop = null;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.bon != null && view.equals(this.bon.Tm())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bon != null) {
            this.bon.onChangeSkinType(i);
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
            this.bop = validateItemData;
            if (this.deleteItemDialog == null) {
                initDeleteDialog();
            }
            com.baidu.adp.lib.g.k.a(this.deleteItemDialog, getPageContext());
        }
    }

    private void initDeleteDialog() {
        String string = getPageContext().getString(z.delete_user_chat);
        g gVar = new g(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(getPageContext().getPageActivity());
        builder.setTitle(z.operation);
        builder.setItems(new String[]{string}, gVar);
        this.deleteItemDialog = builder.create();
        this.deleteItemDialog.setCanceledOnTouchOutside(true);
    }

    private void c(ValidateItemData validateItemData) {
        if (validateItemData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), validateItemData.getUserId(), validateItemData.getUserName())));
        }
    }

    private void d(ValidateItemData validateItemData) {
        if (!com.baidu.adp.lib.util.i.fg()) {
            showToast(z.neterror);
        } else if (validateItemData != null && !validateItemData.isPass() && !this.boq) {
            try {
                validateItemData.setShown(true);
                this.bon.setLoadProgressBarVisable(true);
                RequestAddGroupUserMessage requestAddGroupUserMessage = new RequestAddGroupUserMessage();
                requestAddGroupUserMessage.setInviterUserId(validateItemData.getInviterUserId());
                requestAddGroupUserMessage.setJoinType(validateItemData.getJoinType());
                requestAddGroupUserMessage.setUserIds(validateItemData.getUserId());
                requestAddGroupUserMessage.setGroupId(com.baidu.adp.lib.g.c.toInt(validateItemData.getGroupId(), 0));
                requestAddGroupUserMessage.setNotice_id(validateItemData.getNotice_id());
                String notice_id = validateItemData.getNotice_id();
                String RM = com.baidu.tieba.im.pushNotify.d.RK().RM();
                if (!TextUtils.isEmpty(notice_id) && !TextUtils.isEmpty(RM) && TextUtils.isDigitsOnly(notice_id) && TextUtils.isDigitsOnly(RM)) {
                    requestAddGroupUserMessage.setSysGroupId(com.baidu.adp.lib.g.c.toInt(RM, 0));
                    requestAddGroupUserMessage.setSysMsgId(String.valueOf(com.baidu.adp.lib.g.c.a(notice_id, 0L) / 100));
                    requestAddGroupUserMessage.setDecision(1);
                    this.boq = true;
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
        if (!com.baidu.adp.lib.util.i.fg()) {
            showToast(z.neterror);
        } else if (validateItemData != null) {
            this.bon.setLoadProgressBarVisable(true);
            RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
            requestDelSystemMessage.setGroupId(Integer.parseInt(com.baidu.tieba.im.pushNotify.d.RK().RM()));
            requestDelSystemMessage.setMsgIds(new StringBuilder().append(Long.parseLong(validateItemData.getNotice_id()) / 100).toString());
            this.boq = true;
            MessageManager.getInstance().sendMessage(requestDelSystemMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ValidateItemData hn(String str) {
        if (str == null) {
            return null;
        }
        List<ValidateItemData> datas = this.bon.Tn().getDatas();
        if (datas != null) {
            for (ValidateItemData validateItemData : datas) {
                if (str.equals(validateItemData.getNotice_id())) {
                    return validateItemData;
                }
            }
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.ab
    public void onScrollToBottom() {
        if (!this.aef && this.offset < this.totalCount) {
            this.aef = true;
            ValidateModel.requestValidateDataFromDB(this.bor, this.offset, this.getDataCallBack);
        }
    }
}
