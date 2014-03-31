package com.baidu.tieba.im.validate;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.tbadk.core.b.ag;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortool.aa;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.groupInfo.ak;
import com.baidu.tieba.im.groupInfo.al;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class ValidateActivity extends com.baidu.tbadk.a implements AbsListView.OnScrollListener, com.baidu.adp.widget.ListView.t {
    public static boolean a = false;
    private t b;
    private com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> c;
    private com.baidu.tieba.im.a<Boolean> d;
    private AlertDialog e;
    private ValidateItemData f;
    private Runnable g;
    private aa h;
    private int j;
    private int l;
    private boolean m;
    private com.baidu.tieba.im.a<Integer> n;
    private boolean i = false;
    private int k = 20;
    private com.baidu.adp.framework.c.g o = new a(this, 0);
    private com.baidu.adp.framework.c.a p = new b(this, 2001129);

    public static void a(Context context) {
        if (context != null) {
            context.startActivity(new Intent(context, ValidateActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.h = new aa(this);
        this.h.a(false);
        this.b = new t(this);
        this.d = new c(this);
        this.c = new d(this);
        this.n = new e(this);
        com.baidu.adp.framework.c.a().a(103111, this.o);
        com.baidu.adp.framework.c.a().a(202004, this.o);
        com.baidu.adp.framework.c.a().a(this.p);
        this.b.a(true);
        com.baidu.tieba.im.s.a(new s(), this.n);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.coreExtra.messageCenter.a.a().a(1);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onStop() {
        h e;
        List<ValidateItemData> b;
        super.onStop();
        a = false;
        if (this.b != null && (e = this.b.e()) != null && (b = e.b()) != null && !b.isEmpty()) {
            ImMessageCenterShowItemData f = com.baidu.tieba.im.pushNotify.a.d().f();
            LinkedList linkedList = new LinkedList();
            int size = b.size();
            for (int i = 0; i < size; i++) {
                ValidateItemData validateItemData = b.get(i);
                if (validateItemData != null && !validateItemData.isShown()) {
                    validateItemData.setShown(true);
                    linkedList.add(new GroupNewsPojo(validateItemData));
                    f.setUnReadCount(f.getUnReadCount() - 1);
                }
            }
            new p(linkedList).execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.b != null) {
            this.b.c();
        }
        this.f = null;
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.b != null && view.equals(this.b.a())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.b != null) {
            this.b.a(i);
        }
    }

    public final void a(int i, ValidateItemData validateItemData) {
        if (validateItemData != null) {
            if (100 == i) {
                if (!UtilHelper.a()) {
                    showToast(com.baidu.tieba.im.j.neterror);
                } else if (validateItemData == null || validateItemData.isPass() || this.i) {
                } else {
                    try {
                        validateItemData.setShown(true);
                        ImMessageCenterShowItemData f = com.baidu.tieba.im.pushNotify.a.d().f();
                        f.setUnReadCount(f.getUnReadCount() - 1);
                        n.a(this.d, validateItemData);
                        this.b.a(true);
                        ak akVar = new ak();
                        akVar.b(validateItemData.getInviterUserId());
                        akVar.d(validateItemData.getJoinType());
                        akVar.a(validateItemData.getUserId());
                        akVar.e(com.baidu.adp.lib.f.b.a(validateItemData.getGroupId(), 0));
                        akVar.b(validateItemData.getNotice_id());
                        String notice_id = validateItemData.getNotice_id();
                        String e = com.baidu.tieba.im.pushNotify.o.a().e();
                        if (TextUtils.isEmpty(notice_id) || TextUtils.isEmpty(e) || !TextUtils.isDigitsOnly(notice_id) || !TextUtils.isDigitsOnly(e)) {
                            return;
                        }
                        akVar.f(com.baidu.adp.lib.f.b.a(e, 0));
                        akVar.c(String.valueOf(com.baidu.adp.lib.f.b.a(notice_id, 0L) / 100));
                        akVar.h(1);
                        com.baidu.adp.lib.util.f.e("pass apply: userid:" + akVar.j() + "  groupId:" + akVar.i() + " sysGid" + e + " mid:" + akVar.m());
                        this.i = true;
                        com.baidu.adp.framework.c.a().a(akVar);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } else if (101 != i || validateItemData == null) {
            } else {
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001003, new ag(this, validateItemData.getUserId(), validateItemData.getUserName())));
            }
        }
    }

    public final void a(View view, int i, ValidateItemData validateItemData) {
        if (view != null && validateItemData != null) {
            this.f = validateItemData;
            if (this.e == null) {
                String string = getString(com.baidu.tieba.im.j.delete_user_chat);
                f fVar = new f(this);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(com.baidu.tieba.im.j.operation);
                builder.setItems(new String[]{string}, fVar);
                this.e = builder.create();
                this.e.setCanceledOnTouchOutside(true);
            }
            this.e.show();
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0037: ARITH  (r1v5 long A[REMOVE]) = (wrap: long : 0x002c: INVOKE  (r1v4 long A[REMOVE]) = 
      (wrap: java.lang.String : 0x0028: INVOKE  (r1v3 java.lang.String A[REMOVE]) = (r8v0 com.baidu.tieba.im.validate.ValidateItemData) type: VIRTUAL call: com.baidu.tieba.im.validate.ValidateItemData.getNotice_id():java.lang.String)
     type: STATIC call: java.lang.Long.parseLong(java.lang.String):long) / (100 long))] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ValidateActivity validateActivity, ValidateItemData validateItemData) {
        if (!UtilHelper.a()) {
            validateActivity.showToast(com.baidu.tieba.im.j.neterror);
        } else if (validateItemData != null) {
            validateActivity.b.a(true);
            al alVar = new al();
            alVar.d(Integer.parseInt(com.baidu.tieba.im.pushNotify.o.a().e()));
            alVar.a(new StringBuilder().append(Long.parseLong(validateItemData.getNotice_id()) / 100).toString());
            com.baidu.adp.lib.util.f.e("del group info request: gid" + validateItemData.getGroupId() + " msgid:" + validateItemData.getNotice_id() + " systemGid:" + alVar.i());
            validateActivity.i = true;
            com.baidu.adp.framework.c.a().a(alVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ValidateItemData a(ValidateActivity validateActivity, String str) {
        List<ValidateItemData> b;
        if (str != null && (b = validateActivity.b.e().b()) != null) {
            for (ValidateItemData validateItemData : b) {
                if (str.equals(validateItemData.getNotice_id())) {
                    return validateItemData;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.b.d() != null) {
            if (this.g == null) {
                this.g = new g(this);
            }
            this.b.d().removeCallbacks(this.g);
            this.b.d().post(this.g);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            c();
        }
    }

    public final aa a() {
        return this.h;
    }

    @Override // com.baidu.adp.widget.ListView.t
    public final void b() {
        if (!this.m && this.l < this.j) {
            this.m = true;
            n.a(this.k, this.l, this.c);
        }
    }
}
