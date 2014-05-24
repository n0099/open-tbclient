package com.baidu.tieba.signall;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class i implements s {
    final /* synthetic */ SignAllForumActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(SignAllForumActivity signAllForumActivity) {
        this.a = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.s
    public void a(String str) {
        this.a.a(str);
    }

    @Override // com.baidu.tieba.signall.s
    public void a(p pVar) {
        y yVar;
        boolean z;
        y yVar2;
        y yVar3;
        y yVar4;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        AlertDialog alertDialog3;
        boolean z2;
        com.baidu.tieba.home.s c = pVar.c();
        if (c != null && c.a() == 0) {
            yVar = this.a.a;
            a e = yVar.e();
            e.a(pVar);
            int size = e.j().size();
            int size2 = e.l().size();
            z = this.a.e;
            if (z) {
                Intent intent = new Intent(this.a, SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                this.a.a(this.a.getString(com.baidu.tieba.y.signallforum_back_finish, new Object[]{Integer.valueOf(size2), Integer.valueOf(size - size2)}), PendingIntent.getActivity(this.a, 0, intent, 134217728), 16);
                z2 = this.a.f;
                if (z2) {
                    return;
                }
            }
            yVar2 = this.a.a;
            yVar2.f().notifyDataSetChanged();
            yVar3 = this.a.a;
            yVar3.g().setText(this.a.getString(com.baidu.tieba.y.signallforum_res, new Object[]{Integer.valueOf(size2), Integer.valueOf(size - size2)}));
            yVar4 = this.a.a;
            u c2 = yVar4.c();
            if (size != size2) {
                if (pVar.a() != 0) {
                    alertDialog = this.a.c;
                    alertDialog.setMessage(pVar.b());
                    alertDialog2 = this.a.c;
                    if (!alertDialog2.isShowing()) {
                        alertDialog3 = this.a.c;
                        alertDialog3.show();
                    }
                } else if (pVar.e() != 0) {
                    com.baidu.adp.lib.util.k.a((Context) this.a, pVar.f());
                } else {
                    this.a.showToast(com.baidu.tieba.y.signallforum_error);
                }
            }
            c2.a();
            return;
        }
        this.a.a(c.b());
    }
}
