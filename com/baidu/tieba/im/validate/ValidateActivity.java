package com.baidu.tieba.im.validate;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tieba.data.chat.RecentChatFriendData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.groupInfo.ae;
import com.baidu.tieba.im.groupInfo.af;
import com.baidu.tieba.im.groupInfo.ai;
import com.baidu.tieba.im.message.cr;
import com.baidu.tieba.im.message.q;
import com.baidu.tieba.mention.s;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class ValidateActivity extends com.baidu.tieba.j implements AbsListView.OnScrollListener, r, com.baidu.tieba.im.c.l, com.baidu.tieba.im.messageCenter.g {
    public static boolean a = false;
    private n b;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int a(ValidateActivity validateActivity, int i) {
        int i2 = validateActivity.l + i;
        validateActivity.l = i2;
        return i2;
    }

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
        this.b = new n(this);
        c();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        s.a().a(1);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        f g;
        super.onStop();
        a = false;
        if (this.b != null && (g = this.b.g()) != null) {
            l.a(g.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    private void c() {
        this.d = new a(this);
        this.c = new b(this);
        this.n = new c(this);
        com.baidu.tieba.im.messageCenter.e.a().a(103111, this);
        com.baidu.tieba.im.messageCenter.e.a().a(202004, this);
        com.baidu.tieba.im.c.m.a().a("apply_join_group", this);
        this.b.a(true);
        l.a(this.n);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.messageCenter.e.a().a(this);
        com.baidu.tieba.im.c.m.a().a(this);
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

    @Override // com.baidu.tieba.im.c.l
    public void a(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            this.l++;
            this.j++;
            this.b.g().b().add(0, l.a(groupNewsPojo));
            this.b.g().notifyDataSetChanged();
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
            PersonInfoActivity.a(this, validateItemData.getUserId(), validateItemData.getUserName());
        }
    }

    private void b(ValidateItemData validateItemData) {
        if (!UtilHelper.b()) {
            showToast(R.string.neterror);
        } else if (validateItemData != null && !validateItemData.isPass() && !this.i) {
            try {
                validateItemData.setShown(true);
                RecentChatFriendData l = com.baidu.tieba.im.c.a.h().l();
                l.setUnReadCount(l.getUnReadCount() - 1);
                com.baidu.tieba.im.c.a.h().a(l.getUnReadCount());
                l.a(this.d, validateItemData);
                this.b.a(true);
                ae aeVar = new ae();
                aeVar.a(validateItemData.getInviterUserId());
                aeVar.a(validateItemData.getJoinType());
                aeVar.a(validateItemData.getUserId());
                aeVar.b(com.baidu.adp.lib.f.b.a(validateItemData.getGroupId(), 0));
                aeVar.b(validateItemData.getNotice_id());
                String notice_id = validateItemData.getNotice_id();
                String d = com.baidu.tieba.im.c.m.a().d();
                if (!TextUtils.isEmpty(notice_id) && !TextUtils.isEmpty(d) && TextUtils.isDigitsOnly(notice_id) && TextUtils.isDigitsOnly(d)) {
                    aeVar.c(com.baidu.adp.lib.f.b.a(d, 0));
                    aeVar.c(String.valueOf(com.baidu.adp.lib.f.b.a(notice_id, 0L) / 100));
                    aeVar.d(1);
                    com.baidu.adp.lib.g.e.d("pass apply: userid:" + aeVar.e() + "  groupId:" + aeVar.d() + " sysGid" + d + " mid:" + aeVar.h());
                    this.i = true;
                    com.baidu.tieba.im.messageCenter.e.a().a(aeVar);
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
            af afVar = new af();
            afVar.a(Integer.parseInt(com.baidu.tieba.im.c.m.a().d()));
            afVar.a("" + (Long.parseLong(validateItemData.getNotice_id()) / 100));
            com.baidu.adp.lib.g.e.d("del group info request: gid" + validateItemData.getGroupId() + " msgid:" + validateItemData.getNotice_id() + " systemGid:" + afVar.b());
            this.i = true;
            com.baidu.tieba.im.messageCenter.e.a().a(afVar);
        }
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(q qVar) {
        this.b.a(false);
        this.i = false;
        if (qVar != null && (qVar instanceof cr)) {
            int w = qVar.w();
            if (w == 103111) {
                cr crVar = (cr) qVar;
                ae aeVar = (ae) crVar.n();
                if (crVar.k()) {
                    if (aeVar != null) {
                        int l = crVar.l();
                        String m = crVar.m();
                        if (TextUtils.isEmpty(m)) {
                            showToast(R.string.validate_fail);
                        } else {
                            showToast(m);
                        }
                        com.baidu.adp.lib.g.e.d("errCode:" + l + "errMsg:" + m);
                        ValidateItemData a2 = a(aeVar.f());
                        if (a2 != null) {
                            a2.setPass(false);
                            a2.setShown(true);
                            l.a(this.d, a2);
                            this.b.g().notifyDataSetChanged();
                            com.baidu.adp.lib.g.e.d("apply add group" + qVar.toString() + "err:" + l + " " + m);
                            return;
                        }
                        return;
                    }
                    return;
                }
                ValidateItemData a3 = a(aeVar.f());
                if (a3 != null) {
                    a3.setPass(true);
                    a3.setShown(true);
                    l.a(this.d, a3);
                    if (TextUtils.isEmpty(crVar.m())) {
                        showToast(R.string.validate_succ);
                    } else {
                        showToast(crVar.m());
                    }
                    this.b.g().notifyDataSetChanged();
                    com.baidu.adp.lib.g.e.d("apply add group" + qVar.toString());
                }
            } else if (202004 == w) {
                ai aiVar = (ai) qVar;
                af afVar = (af) aiVar.n();
                if (aiVar.k()) {
                    com.baidu.adp.lib.g.e.a("del group info err:" + aiVar.m());
                    return;
                }
                com.baidu.adp.lib.g.e.d("del group info: gid" + afVar.b() + " msgid:" + afVar.c());
                l.a(this.f, this.d);
                this.l--;
                this.j--;
                f g = this.b.g();
                g.b().remove(this.f);
                g.notifyDataSetChanged();
                com.baidu.tieba.im.c.a.a((com.baidu.tieba.im.a<Void>) null);
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
