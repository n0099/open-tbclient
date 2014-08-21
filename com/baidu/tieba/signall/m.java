package com.baidu.tieba.signall;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Intent;
/* loaded from: classes.dex */
class m implements v {
    final /* synthetic */ SignAllForumActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SignAllForumActivity signAllForumActivity) {
        this.a = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.v
    public void a(String str) {
        this.a.a(str);
    }

    @Override // com.baidu.tieba.signall.v
    public void a(s sVar) {
        ab abVar;
        boolean z;
        ab abVar2;
        ab abVar3;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        AlertDialog alertDialog3;
        boolean z2;
        com.baidu.tieba.home.r c = sVar.c();
        if (c != null && c.a() == 0) {
            abVar = this.a.a;
            b f = abVar.f();
            f.a(sVar);
            z = this.a.e;
            if (z) {
                Intent intent = new Intent(this.a, SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                this.a.a(this.a.getString(com.baidu.tieba.x.signallforum_back_finish, new Object[]{Integer.valueOf(f.r()), Integer.valueOf(f.s())}), PendingIntent.getActivity(this.a, 0, intent, 134217728), false);
                z2 = this.a.f;
                if (z2) {
                    return;
                }
            }
            abVar2 = this.a.a;
            abVar2.g().notifyDataSetChanged();
            abVar3 = this.a.a;
            x c2 = abVar3.c();
            if (!f.q()) {
                if (sVar.a() != 0) {
                    alertDialog = this.a.c;
                    alertDialog.setMessage(sVar.b());
                    alertDialog2 = this.a.c;
                    if (!alertDialog2.isShowing()) {
                        alertDialog3 = this.a.c;
                        com.baidu.adp.lib.e.e.a(alertDialog3, this.a);
                    }
                } else if (sVar.e() != 0) {
                    this.a.showToast(sVar.f());
                } else {
                    this.a.showToast(com.baidu.tieba.x.signallforum_error);
                }
            }
            c2.b();
            return;
        }
        this.a.a(c.b());
    }
}
