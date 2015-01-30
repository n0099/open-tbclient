package com.baidu.tieba.signall;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Intent;
/* loaded from: classes.dex */
class m implements v {
    final /* synthetic */ SignAllForumActivity bRc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SignAllForumActivity signAllForumActivity) {
        this.bRc = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.v
    public void gK(String str) {
        this.bRc.hW(str);
    }

    @Override // com.baidu.tieba.signall.v
    public void b(s sVar) {
        ad adVar;
        boolean z;
        ad adVar2;
        ad adVar3;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        AlertDialog alertDialog3;
        boolean z2;
        com.baidu.tieba.home.t adA = sVar.adA();
        if (adA != null && adA.getErrorNumber() == 0) {
            adVar = this.bRc.bQV;
            b ael = adVar.ael();
            ael.a(sVar);
            z = this.bRc.bQY;
            if (z) {
                Intent intent = new Intent(this.bRc.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                this.bRc.a(this.bRc.getPageContext().getPageActivity().getString(com.baidu.tieba.z.signallforum_back_finish, new Object[]{Integer.valueOf(ael.adH()), Integer.valueOf(ael.adI())}), PendingIntent.getActivity(this.bRc.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                z2 = this.bRc.aIN;
                if (z2) {
                    return;
                }
            }
            adVar2 = this.bRc.bQV;
            adVar2.aem().notifyDataSetChanged();
            adVar3 = this.bRc.bQV;
            x aej = adVar3.aej();
            if (!ael.adG()) {
                if (sVar.adY() != 0) {
                    alertDialog = this.bRc.mDialog;
                    alertDialog.setMessage(sVar.ady());
                    alertDialog2 = this.bRc.mDialog;
                    if (!alertDialog2.isShowing()) {
                        alertDialog3 = this.bRc.mDialog;
                        com.baidu.adp.lib.g.k.a(alertDialog3, this.bRc.getPageContext());
                    }
                } else if (sVar.aea() != 0) {
                    this.bRc.showToast(sVar.aeb());
                } else {
                    this.bRc.showToast(com.baidu.tieba.z.signallforum_error);
                }
            }
            aej.aef();
            return;
        }
        this.bRc.hW(adA.getUserMsg());
    }
}
