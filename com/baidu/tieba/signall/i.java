package com.baidu.tieba.signall;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
final class i implements s {
    final /* synthetic */ SignAllForumActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(SignAllForumActivity signAllForumActivity) {
        this.a = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.s
    public final void a(String str) {
        SignAllForumActivity.a(this.a, str);
    }

    @Override // com.baidu.tieba.signall.s
    public final void a(p pVar) {
        y yVar;
        boolean z;
        y yVar2;
        y yVar3;
        y yVar4;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        AlertDialog alertDialog3;
        boolean z2;
        com.baidu.tieba.home.q c = pVar.c();
        if (c != null && c.a() == 0) {
            yVar = this.a.a;
            a g = yVar.g();
            g.a(pVar);
            int size = g.j().size();
            int size2 = g.l().size();
            z = this.a.e;
            if (z) {
                Intent intent = new Intent(this.a, SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                this.a.a(this.a.getString(com.baidu.tieba.a.k.signallforum_back_finish, new Object[]{Integer.valueOf(size2), Integer.valueOf(size - size2)}), PendingIntent.getActivity(this.a, 0, intent, 134217728), 16);
                z2 = this.a.f;
                if (z2) {
                    return;
                }
            }
            yVar2 = this.a.a;
            yVar2.h().notifyDataSetChanged();
            yVar3 = this.a.a;
            yVar3.i().setText(this.a.getString(com.baidu.tieba.a.k.signallforum_res, new Object[]{Integer.valueOf(size2), Integer.valueOf(size - size2)}));
            yVar4 = this.a.a;
            u e = yVar4.e();
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
                    com.baidu.adp.lib.util.i.a((Context) this.a, pVar.f());
                } else {
                    this.a.showToast(com.baidu.tieba.a.k.signallforum_error);
                }
            }
            e.a();
            return;
        }
        SignAllForumActivity.a(this.a, c.b());
    }
}
