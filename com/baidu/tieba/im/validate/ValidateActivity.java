package com.baidu.tieba.im.validate;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.groupInfo.RequestAddGroupUserMessage;
import com.baidu.tieba.im.groupInfo.RequestDelSystemMessage;
import com.baidu.tieba.y;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class ValidateActivity extends BaseActivity implements aa {
    public static boolean isOpen = false;
    private AlertDialog bcb;
    private com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> bcc;
    private r biZ;
    private com.baidu.tieba.im.a<Boolean> bja;
    private ValidateItemData bjb;
    private com.baidu.tieba.im.a<Integer> bje;
    private boolean isLoading;
    private int offset;
    private int totalCount;
    private boolean bjc = false;
    private int bjd = 20;
    private com.baidu.adp.framework.listener.e ayS = new a(this, 0);
    private CustomMessageListener mCustomListener = new b(this, 2001129);

    public static void ae(Context context) {
        if (context != null) {
            context.startActivity(new Intent(context, ValidateActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.biZ = new r(this);
        Pf();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        isOpen = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.coreExtra.messageCenter.a.oD().bY(1);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new com.baidu.tbadk.live.message.a("-1003", -4)));
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        isOpen = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        g RV;
        super.onStop();
        isOpen = false;
        if (this.biZ != null && (RV = this.biZ.RV()) != null) {
            l.ad(RV.getDatas());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    private void Pf() {
        this.bja = new c(this);
        this.bcc = new d(this);
        this.bje = new e(this);
        registerListener(103111, this.ayS);
        registerListener(202004, this.ayS);
        registerListener(this.mCustomListener);
        this.biZ.dg(true);
        l.d(this.bje);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.biZ != null) {
            this.biZ.destroy();
        }
        this.bjb = null;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.biZ != null && view.equals(this.biZ.RU())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.biZ != null) {
            this.biZ.onChangeSkinType(i);
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
            this.bjb = validateItemData;
            if (this.bcb == null) {
                Pg();
            }
            com.baidu.adp.lib.g.j.a(this.bcb, this);
        }
    }

    private void Pg() {
        String string = getString(y.delete_user_chat);
        f fVar = new f(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(y.operation);
        builder.setItems(new String[]{string}, fVar);
        this.bcb = builder.create();
        this.bcb.setCanceledOnTouchOutside(true);
    }

    private void c(ValidateItemData validateItemData) {
        if (validateItemData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this, validateItemData.getUserId(), validateItemData.getUserName())));
        }
    }

    private void d(ValidateItemData validateItemData) {
        if (!com.baidu.adp.lib.util.j.fh()) {
            showToast(y.neterror);
        } else if (validateItemData != null && !validateItemData.isPass() && !this.bjc) {
            try {
                validateItemData.setShown(true);
                this.biZ.dg(true);
                RequestAddGroupUserMessage requestAddGroupUserMessage = new RequestAddGroupUserMessage();
                requestAddGroupUserMessage.setInviterUserId(validateItemData.getInviterUserId());
                requestAddGroupUserMessage.setJoinType(validateItemData.getJoinType());
                requestAddGroupUserMessage.setUserIds(validateItemData.getUserId());
                requestAddGroupUserMessage.setGroupId(com.baidu.adp.lib.g.c.f(validateItemData.getGroupId(), 0));
                requestAddGroupUserMessage.setNotice_id(validateItemData.getNotice_id());
                String notice_id = validateItemData.getNotice_id();
                String Rs = com.baidu.tieba.im.pushNotify.f.Rq().Rs();
                if (!TextUtils.isEmpty(notice_id) && !TextUtils.isEmpty(Rs) && TextUtils.isDigitsOnly(notice_id) && TextUtils.isDigitsOnly(Rs)) {
                    requestAddGroupUserMessage.setSysGroupId(com.baidu.adp.lib.g.c.f(Rs, 0));
                    requestAddGroupUserMessage.setSysMsgId(String.valueOf(com.baidu.adp.lib.g.c.a(notice_id, 0L) / 100));
                    requestAddGroupUserMessage.setDecision(1);
                    this.bjc = true;
                    MessageManager.getInstance().sendMessage(requestAddGroupUserMessage);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0037: ARITH  (r1v5 long A[REMOVE]) = (wrap: long : 0x002c: INVOKE  (r1v4 long A[REMOVE]) = 
      (wrap: java.lang.String : 0x0028: INVOKE  (r1v3 java.lang.String A[REMOVE]) = (r8v0 com.baidu.tieba.im.validate.ValidateItemData) type: VIRTUAL call: com.baidu.tieba.im.validate.ValidateItemData.getNotice_id():java.lang.String)
     type: STATIC call: java.lang.Long.parseLong(java.lang.String):long) / (100 long))] */
    /* JADX INFO: Access modifiers changed from: private */
    public void e(ValidateItemData validateItemData) {
        if (!com.baidu.adp.lib.util.j.fh()) {
            showToast(y.neterror);
        } else if (validateItemData != null) {
            this.biZ.dg(true);
            RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
            requestDelSystemMessage.setGroupId(Integer.parseInt(com.baidu.tieba.im.pushNotify.f.Rq().Rs()));
            requestDelSystemMessage.setMsgIds(new StringBuilder().append(Long.parseLong(validateItemData.getNotice_id()) / 100).toString());
            this.bjc = true;
            MessageManager.getInstance().sendMessage(requestDelSystemMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ValidateItemData gI(String str) {
        if (str == null) {
            return null;
        }
        List<ValidateItemData> datas = this.biZ.RV().getDatas();
        if (datas != null) {
            for (ValidateItemData validateItemData : datas) {
                if (str.equals(validateItemData.getNotice_id())) {
                    return validateItemData;
                }
            }
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.aa
    public void hQ() {
        if (!this.isLoading && this.offset < this.totalCount) {
            this.isLoading = true;
            l.a(this.bjd, this.offset, this.bcc);
        }
    }
}
