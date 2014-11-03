package com.baidu.tieba.signall;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Intent;
/* loaded from: classes.dex */
class m implements v {
    final /* synthetic */ SignAllForumActivity bLc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SignAllForumActivity signAllForumActivity) {
        this.bLc = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.v
    public void fw(String str) {
        this.bLc.hq(str);
    }

    @Override // com.baidu.tieba.signall.v
    public void b(s sVar) {
        ab abVar;
        boolean z;
        ab abVar2;
        ab abVar3;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        AlertDialog alertDialog3;
        boolean z2;
        com.baidu.tieba.home.t acB = sVar.acB();
        if (acB != null && acB.getErrorNumber() == 0) {
            abVar = this.bLc.bKV;
            b adj = abVar.adj();
            adj.a(sVar);
            z = this.bLc.bKY;
            if (z) {
                Intent intent = new Intent(this.bLc, SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                this.bLc.a(this.bLc.getString(com.baidu.tieba.y.signallforum_back_finish, new Object[]{Integer.valueOf(adj.acI()), Integer.valueOf(adj.acJ())}), PendingIntent.getActivity(this.bLc, 0, intent, 134217728), false);
                z2 = this.bLc.aFY;
                if (z2) {
                    return;
                }
            }
            abVar2 = this.bLc.bKV;
            abVar2.adk().notifyDataSetChanged();
            abVar3 = this.bLc.bKV;
            x adh = abVar3.adh();
            if (!adj.acH()) {
                if (sVar.acY() != 0) {
                    alertDialog = this.bLc.Bf;
                    alertDialog.setMessage(sVar.acz());
                    alertDialog2 = this.bLc.Bf;
                    if (!alertDialog2.isShowing()) {
                        alertDialog3 = this.bLc.Bf;
                        com.baidu.adp.lib.g.j.a(alertDialog3, this.bLc);
                    }
                } else if (sVar.ada() != 0) {
                    this.bLc.showToast(sVar.adb());
                } else {
                    this.bLc.showToast(com.baidu.tieba.y.signallforum_error);
                }
            }
            adh.adf();
            return;
        }
        this.bLc.hq(acB.getUserMsg());
    }
}
