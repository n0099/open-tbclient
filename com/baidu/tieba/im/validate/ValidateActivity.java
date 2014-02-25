package com.baidu.tieba.im.validate;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.tieba.data.chat.ImMessageCenterShowItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.groupInfo.af;
import com.baidu.tieba.im.groupInfo.ag;
import com.baidu.tieba.im.groupInfo.aj;
import com.baidu.tieba.im.message.aa;
import com.baidu.tieba.im.message.da;
import com.baidu.tieba.mention.v;
import com.baidu.tieba.person.cm;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class ValidateActivity extends com.baidu.tieba.f implements AbsListView.OnScrollListener, com.baidu.adp.widget.ListView.r, com.baidu.tieba.im.messageCenter.g {
    public static boolean a = false;
    private r b;
    private com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> c;
    private com.baidu.tieba.im.a<Boolean> d;
    private AlertDialog e;
    private ValidateItemData f;
    private Runnable g;
    private com.baidu.tieba.util.i h;
    private int j;
    private int l;
    private boolean m;
    private com.baidu.tieba.im.a<Integer> n;
    private boolean i = false;
    private int k = 20;

    public static void a(Context context) {
        if (context != null) {
            context.startActivity(new Intent(context, ValidateActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.h = new com.baidu.tieba.util.i(this);
        this.h.d(false);
        this.b = new r(this);
        c();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        v.a().a(1);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onStop() {
        f g;
        super.onStop();
        a = false;
        if (this.b != null && (g = this.b.g()) != null) {
            l.a(g.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    private void c() {
        this.d = new a(this);
        this.c = new b(this);
        this.n = new c(this);
        com.baidu.tieba.im.messageCenter.e.a().a(103111, this);
        com.baidu.tieba.im.messageCenter.e.a().a(202004, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-129, this);
        this.b.a(true);
        l.a(this.n);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.messageCenter.e.a().a(this);
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
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.b != null) {
            this.b.a(i);
        }
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
                d();
            }
            this.e.show();
        }
    }

    private void d() {
        String string = getString(R.string.delete_user_chat);
        d dVar = new d(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.operation);
        builder.setItems(new String[]{string}, dVar);
        this.e = builder.create();
        this.e.setCanceledOnTouchOutside(true);
    }

    private void a(ValidateItemData validateItemData) {
        if (validateItemData != null) {
            cm.a(this, validateItemData.getUserId(), validateItemData.getUserName());
        }
    }

    private void b(ValidateItemData validateItemData) {
        if (!UtilHelper.b()) {
            showToast(R.string.neterror);
        } else if (validateItemData != null && !validateItemData.isPass() && !this.i) {
            try {
                validateItemData.setShown(true);
                ImMessageCenterShowItemData j = com.baidu.tieba.im.c.a.f().j();
                j.setUnReadCount(j.getUnReadCount() - 1);
                l.a(this.d, validateItemData);
                this.b.a(true);
                af afVar = new af();
                afVar.a(validateItemData.getInviterUserId());
                afVar.a(validateItemData.getJoinType());
                afVar.a(validateItemData.getUserId());
                afVar.b(com.baidu.adp.lib.f.b.a(validateItemData.getGroupId(), 0));
                afVar.b(validateItemData.getNotice_id());
                String notice_id = validateItemData.getNotice_id();
                String e = com.baidu.tieba.im.c.j.a().e();
                if (!TextUtils.isEmpty(notice_id) && !TextUtils.isEmpty(e) && TextUtils.isDigitsOnly(notice_id) && TextUtils.isDigitsOnly(e)) {
                    afVar.c(com.baidu.adp.lib.f.b.a(e, 0));
                    afVar.c(String.valueOf(com.baidu.adp.lib.f.b.a(notice_id, 0L) / 100));
                    afVar.d(1);
                    com.baidu.adp.lib.util.f.e("pass apply: userid:" + afVar.e() + "  groupId:" + afVar.d() + " sysGid" + e + " mid:" + afVar.h());
                    this.i = true;
                    com.baidu.tieba.im.messageCenter.e.a().a(afVar);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0038: ARITH  (r1v5 long A[REMOVE]) = (wrap: long : 0x002d: INVOKE  (r1v4 long A[REMOVE]) = 
      (wrap: java.lang.String : 0x0029: INVOKE  (r1v3 java.lang.String A[REMOVE]) = (r8v0 com.baidu.tieba.im.validate.ValidateItemData) type: VIRTUAL call: com.baidu.tieba.im.validate.ValidateItemData.getNotice_id():java.lang.String)
     type: STATIC call: java.lang.Long.parseLong(java.lang.String):long) / (100 long))] */
    /* JADX INFO: Access modifiers changed from: private */
    public void c(ValidateItemData validateItemData) {
        if (!UtilHelper.b()) {
            showToast(R.string.neterror);
        } else if (validateItemData != null) {
            this.b.a(true);
            ag agVar = new ag();
            agVar.a(Integer.parseInt(com.baidu.tieba.im.c.j.a().e()));
            agVar.a(new StringBuilder().append(Long.parseLong(validateItemData.getNotice_id()) / 100).toString());
            com.baidu.adp.lib.util.f.e("del group info request: gid" + validateItemData.getGroupId() + " msgid:" + validateItemData.getNotice_id() + " systemGid:" + agVar.b());
            this.i = true;
            com.baidu.tieba.im.messageCenter.e.a().a(agVar);
        }
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.s sVar) {
        this.b.a(false);
        this.i = false;
        if (sVar != null && (sVar instanceof da)) {
            int w = sVar.w();
            if (w == 103111) {
                da daVar = (da) sVar;
                af afVar = (af) daVar.o();
                if (daVar.l()) {
                    if (afVar != null) {
                        int m = daVar.m();
                        String n = daVar.n();
                        if (TextUtils.isEmpty(n)) {
                            showToast(R.string.validate_fail);
                        } else {
                            showToast(n);
                        }
                        com.baidu.adp.lib.util.f.e("errCode:" + m + "errMsg:" + n);
                        ValidateItemData a2 = a(afVar.f());
                        if (a2 != null) {
                            a2.setPass(false);
                            a2.setShown(true);
                            l.a(this.d, a2);
                            this.b.g().notifyDataSetChanged();
                            com.baidu.adp.lib.util.f.e("apply add group" + sVar.toString() + "err:" + m + " " + n);
                            return;
                        }
                        return;
                    }
                    return;
                }
                ValidateItemData a3 = a(afVar.f());
                if (a3 != null) {
                    a3.setPass(true);
                    a3.setShown(true);
                    l.a(this.d, a3);
                    if (TextUtils.isEmpty(daVar.n())) {
                        showToast(R.string.validate_succ);
                    } else {
                        showToast(daVar.n());
                    }
                    this.b.g().notifyDataSetChanged();
                    com.baidu.adp.lib.util.f.e("apply add group" + sVar.toString());
                }
            } else if (202004 == w) {
                aj ajVar = (aj) sVar;
                ag agVar = (ag) ajVar.o();
                if (ajVar.l()) {
                    com.baidu.adp.lib.util.f.b("del group info err:" + ajVar.n());
                    return;
                }
                com.baidu.adp.lib.util.f.e("del group info: gid" + agVar.b() + " msgid:" + agVar.c());
                l.a(this.f, this.d);
                this.l--;
                this.j--;
                f g = this.b.g();
                g.b().remove(this.f);
                g.notifyDataSetChanged();
                com.baidu.tieba.im.c.a.a((com.baidu.tieba.im.a<Void>) null);
            } else if (-129 == w && (sVar instanceof aa)) {
                GroupNewsPojo a4 = ((aa) sVar).a();
                this.l++;
                this.j++;
                this.b.g().b().add(0, l.a(a4));
                this.b.g().notifyDataSetChanged();
            }
        }
    }

    private ValidateItemData a(String str) {
        if (str == null) {
            return null;
        }
        List<ValidateItemData> b = this.b.g().b();
        if (b != null) {
            for (ValidateItemData validateItemData : b) {
                if (str.equals(validateItemData.getNotice_id())) {
                    return validateItemData;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.b.f() != null) {
            f();
            this.b.f().removeCallbacks(this.g);
            this.b.f().post(this.g);
        }
    }

    private void f() {
        if (this.g == null) {
            this.g = new e(this);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            e();
        }
    }

    public com.baidu.tieba.util.i b() {
        return this.h;
    }

    @Override // com.baidu.adp.widget.ListView.r
    public void a() {
        if (!this.m && this.l < this.j) {
            this.m = true;
            l.a(this.k, this.l, this.c);
        }
    }
}
