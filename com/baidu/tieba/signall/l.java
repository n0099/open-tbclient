package com.baidu.tieba.signall;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Intent;
/* loaded from: classes.dex */
class l implements u {
    final /* synthetic */ SignAllForumActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SignAllForumActivity signAllForumActivity) {
        this.a = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.u
    public void a(String str) {
        this.a.a(str);
    }

    @Override // com.baidu.tieba.signall.u
    public void a(r rVar) {
        aa aaVar;
        boolean z;
        aa aaVar2;
        aa aaVar3;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        AlertDialog alertDialog3;
        boolean z2;
        com.baidu.tieba.home.r c = rVar.c();
        if (c != null && c.a() == 0) {
            aaVar = this.a.a;
            b f = aaVar.f();
            f.a(rVar);
            int size = f.i().size();
            int size2 = f.k().size();
            z = this.a.e;
            if (z) {
                Intent intent = new Intent(this.a, SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                this.a.a(this.a.getString(com.baidu.tieba.x.signallforum_back_finish, new Object[]{Integer.valueOf(size2), Integer.valueOf(size - size2)}), PendingIntent.getActivity(this.a, 0, intent, 134217728), false);
                z2 = this.a.f;
                if (z2) {
                    return;
                }
            }
            aaVar2 = this.a.a;
            aaVar2.g().notifyDataSetChanged();
            aaVar3 = this.a.a;
            w c2 = aaVar3.c();
            if (!f.q()) {
                if (rVar.a() != 0) {
                    alertDialog = this.a.c;
                    alertDialog.setMessage(rVar.b());
                    alertDialog2 = this.a.c;
                    if (!alertDialog2.isShowing()) {
                        alertDialog3 = this.a.c;
                        com.baidu.adp.lib.e.d.a(alertDialog3, this.a);
                    }
                } else if (rVar.e() != 0) {
                    this.a.showToast(rVar.f());
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
