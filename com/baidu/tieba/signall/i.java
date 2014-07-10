package com.baidu.tieba.signall;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class i implements r {
    final /* synthetic */ SignAllForumActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(SignAllForumActivity signAllForumActivity) {
        this.a = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.r
    public void a(String str) {
        this.a.a(str);
    }

    @Override // com.baidu.tieba.signall.r
    public void a(o oVar) {
        x xVar;
        boolean z;
        x xVar2;
        x xVar3;
        x xVar4;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        AlertDialog alertDialog3;
        boolean z2;
        com.baidu.tieba.home.r c = oVar.c();
        if (c != null && c.a() == 0) {
            xVar = this.a.a;
            a f = xVar.f();
            f.a(oVar);
            int size = f.j().size();
            int size2 = f.l().size();
            z = this.a.e;
            if (z) {
                Intent intent = new Intent(this.a, SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                this.a.a(this.a.getString(com.baidu.tieba.y.signallforum_back_finish, new Object[]{Integer.valueOf(size2), Integer.valueOf(size - size2)}), PendingIntent.getActivity(this.a, 0, intent, 134217728), false);
                z2 = this.a.f;
                if (z2) {
                    return;
                }
            }
            xVar2 = this.a.a;
            xVar2.g().notifyDataSetChanged();
            xVar3 = this.a.a;
            xVar3.h().setText(this.a.getString(com.baidu.tieba.y.signallforum_res, new Object[]{Integer.valueOf(size2), Integer.valueOf(size - size2)}));
            xVar4 = this.a.a;
            t c2 = xVar4.c();
            if (size != size2) {
                if (oVar.a() != 0) {
                    alertDialog = this.a.c;
                    alertDialog.setMessage(oVar.b());
                    alertDialog2 = this.a.c;
                    if (!alertDialog2.isShowing()) {
                        alertDialog3 = this.a.c;
                        alertDialog3.show();
                    }
                } else if (oVar.e() != 0) {
                    com.baidu.adp.lib.util.j.a((Context) this.a, oVar.f());
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
