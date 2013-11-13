package com.baidu.tieba.im.validate;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.groupInfo.RequestAddGroupUserMessage;
import com.baidu.tieba.im.groupInfo.RequestDelSystemMessage;
import com.baidu.tieba.im.groupInfo.ResponseDelSystemMessage;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponsedMessage;
import com.baidu.tieba.mention.t;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ValidateActivity extends com.baidu.tieba.j implements AbsListView.OnScrollListener, com.baidu.tieba.im.messageCenter.h, com.baidu.tieba.im.pushNotify.m {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f1803a = false;
    private m b;
    private com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> c;
    private com.baidu.tieba.im.a<Boolean> d;
    private AlertDialog e;
    private ValidateItemData f;
    private Runnable g;
    private com.baidu.tieba.util.i h;
    private boolean i = false;

    public static void a(Context context) {
        if (context != null) {
            context.startActivity(new Intent(context, ValidateActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.h = new com.baidu.tieba.util.i(this);
        this.h.d(false);
        this.b = new m(this);
        b();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        f1803a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        t.a().a(1);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        f1803a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        e g;
        super.onStop();
        f1803a = false;
        if (this.b != null && (g = this.b.g()) != null) {
            k.a(g.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    private void b() {
        this.d = new a(this);
        this.c = new b(this);
        com.baidu.tieba.im.messageCenter.f.a().a(103111, this);
        com.baidu.tieba.im.messageCenter.f.a().a(202004, this);
        com.baidu.tieba.im.pushNotify.n.a().a("apply_join_group", this);
        this.b.a(true);
        k.a(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.messageCenter.f.a().a(this);
        com.baidu.tieba.im.pushNotify.n.a().a(this);
        if (this.b != null) {
            this.b.c();
        }
        this.f = null;
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.b != null && view.equals(this.b.e())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.b != null) {
            this.b.a(i);
        }
    }

    @Override // com.baidu.tieba.im.pushNotify.m
    public void a(GroupNewsPojo groupNewsPojo) {
        k.a(this.c);
    }

    public void a(View view, int i, int i2, long j, ValidateItemData validateItemData) {
        if (validateItemData != null) {
            if (100 == i) {
                b(validateItemData);
            } else if (101 == i) {
                a(validateItemData);
            }
        }
    }

    public void b(View view, int i, int i2, long j, ValidateItemData validateItemData) {
        if (view != null && validateItemData != null && 200 == i) {
            this.f = validateItemData;
            if (this.e == null) {
                c();
            }
            this.e.show();
        }
    }

    private void c() {
        String string = getString(R.string.delete_user_chat);
        c cVar = new c(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.operation);
        builder.setItems(new String[]{string}, cVar);
        this.e = builder.create();
        this.e.setCanceledOnTouchOutside(true);
    }

    private void a(ValidateItemData validateItemData) {
        if (validateItemData != null) {
            PersonInfoActivity.a(this, validateItemData.getUserId(), validateItemData.getUserName());
        }
    }

    private void b(ValidateItemData validateItemData) {
        if (!UtilHelper.b()) {
            showToast(R.string.neterror);
        } else if (validateItemData != null && !validateItemData.isPass() && !this.i) {
            try {
                validateItemData.setShown(true);
                k.a(this.d, validateItemData);
                k.a(this.c);
                this.b.a(true);
                RequestAddGroupUserMessage requestAddGroupUserMessage = new RequestAddGroupUserMessage();
                requestAddGroupUserMessage.setUserIds(validateItemData.getUserId());
                requestAddGroupUserMessage.setGroupId(Long.parseLong(validateItemData.getGroupId()));
                requestAddGroupUserMessage.setNotice_id(validateItemData.getNotice_id());
                String notice_id = validateItemData.getNotice_id();
                String d = com.baidu.tieba.im.pushNotify.n.a().d();
                if (!TextUtils.isEmpty(notice_id) && !TextUtils.isEmpty(d) && TextUtils.isDigitsOnly(notice_id) && TextUtils.isDigitsOnly(d)) {
                    requestAddGroupUserMessage.setSysGroupId(d);
                    requestAddGroupUserMessage.setSysMsgId(String.valueOf(Long.parseLong(notice_id) / 100));
                    requestAddGroupUserMessage.setDecision(SocialConstants.TRUE);
                    com.baidu.adp.lib.h.d.d("pass apply: userid:" + requestAddGroupUserMessage.getUserIds() + "  groupId:" + requestAddGroupUserMessage.getGroupId() + " sysGid" + d + " mid:" + requestAddGroupUserMessage.getSysMsgId());
                    this.i = true;
                    com.baidu.tieba.im.messageCenter.f.a().a(requestAddGroupUserMessage);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ValidateItemData validateItemData) {
        if (!UtilHelper.b()) {
            showToast(R.string.neterror);
        } else if (validateItemData != null) {
            this.b.a(true);
            RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
            requestDelSystemMessage.setGroupId(Long.parseLong(com.baidu.tieba.im.pushNotify.n.a().d()));
            requestDelSystemMessage.setMsgIds("" + (Long.parseLong(validateItemData.getNotice_id()) / 100));
            com.baidu.adp.lib.h.d.d("del group info request: gid" + validateItemData.getGroupId() + " msgid:" + validateItemData.getNotice_id() + " systemGid:" + requestDelSystemMessage.getGroupId());
            this.i = true;
            com.baidu.tieba.im.messageCenter.f.a().a(requestDelSystemMessage);
        }
    }

    @Override // com.baidu.tieba.im.messageCenter.h
    public void a(Message message) {
        this.b.a(false);
        this.i = false;
        if (message != null && (message instanceof ResponsedMessage)) {
            int cmd = message.getCmd();
            if (cmd == 103111) {
                ResponsedMessage responsedMessage = (ResponsedMessage) message;
                RequestAddGroupUserMessage requestAddGroupUserMessage = (RequestAddGroupUserMessage) responsedMessage.getOrginalMessage();
                if (responsedMessage.hasError()) {
                    if (requestAddGroupUserMessage != null) {
                        int errNo = responsedMessage.getErrNo();
                        String errMsg = responsedMessage.getErrMsg();
                        if (TextUtils.isEmpty(errMsg)) {
                            showToast(R.string.validate_fail);
                        } else {
                            showToast(errMsg);
                        }
                        com.baidu.adp.lib.h.d.d("errCode:" + errNo + "errMsg:" + errMsg);
                        ValidateItemData a2 = k.a(requestAddGroupUserMessage.getNotice_id());
                        if (a2 != null) {
                            a2.setPass(false);
                            a2.setShown(true);
                            k.a(this.d, a2);
                            k.a(this.c);
                            com.baidu.adp.lib.h.d.d("apply add group" + message.toString() + "err:" + errNo + " " + errMsg);
                            return;
                        }
                        return;
                    }
                    return;
                }
                ValidateItemData a3 = k.a(requestAddGroupUserMessage.getNotice_id());
                if (a3 != null) {
                    a3.setPass(true);
                    a3.setShown(true);
                }
                k.a(this.d, a3);
                if (TextUtils.isEmpty(responsedMessage.getErrMsg())) {
                    showToast(R.string.validate_succ);
                } else {
                    showToast(responsedMessage.getErrMsg());
                }
                k.a(this.c);
                com.baidu.adp.lib.h.d.d("apply add group" + message.toString());
            } else if (202004 == cmd) {
                ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) message;
                RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
                if (responseDelSystemMessage.hasError()) {
                    com.baidu.adp.lib.h.d.a("del group info err:" + responseDelSystemMessage.getErrMsg());
                    return;
                }
                com.baidu.adp.lib.h.d.d("del group info: gid" + requestDelSystemMessage.getGroupId() + " msgid:" + requestDelSystemMessage.getMsgIds());
                k.a(this.f, this.d);
                k.a(this.c);
                com.baidu.tieba.im.pushNotify.a.a((com.baidu.tieba.im.a<Void>) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.b.f() != null) {
            e();
            this.b.f().removeCallbacks(this.g);
            this.b.f().post(this.g);
        }
    }

    private void e() {
        if (this.g == null) {
            this.g = new d(this);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            d();
        }
    }

    public com.baidu.tieba.util.i a() {
        return this.h;
    }
}
