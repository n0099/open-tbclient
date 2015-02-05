package com.baidu.tieba.signall;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Intent;
/* loaded from: classes.dex */
class m implements v {
    final /* synthetic */ SignAllForumActivity bRb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SignAllForumActivity signAllForumActivity) {
        this.bRb = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.v
    public void gH(String str) {
        this.bRb.hU(str);
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
        com.baidu.tieba.home.t adv = sVar.adv();
        if (adv != null && adv.getErrorNumber() == 0) {
            adVar = this.bRb.bQU;
            b aeg = adVar.aeg();
            aeg.a(sVar);
            z = this.bRb.bQX;
            if (z) {
                Intent intent = new Intent(this.bRb.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                this.bRb.a(this.bRb.getPageContext().getPageActivity().getString(com.baidu.tieba.z.signallforum_back_finish, new Object[]{Integer.valueOf(aeg.adC()), Integer.valueOf(aeg.adD())}), PendingIntent.getActivity(this.bRb.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                z2 = this.bRb.aIK;
                if (z2) {
                    return;
                }
            }
            adVar2 = this.bRb.bQU;
            adVar2.aeh().notifyDataSetChanged();
            adVar3 = this.bRb.bQU;
            x aee = adVar3.aee();
            if (!aeg.adB()) {
                if (sVar.adT() != 0) {
                    alertDialog = this.bRb.mDialog;
                    alertDialog.setMessage(sVar.adt());
                    alertDialog2 = this.bRb.mDialog;
                    if (!alertDialog2.isShowing()) {
                        alertDialog3 = this.bRb.mDialog;
                        com.baidu.adp.lib.g.k.a(alertDialog3, this.bRb.getPageContext());
                    }
                } else if (sVar.adV() != 0) {
                    this.bRb.showToast(sVar.adW());
                } else {
                    this.bRb.showToast(com.baidu.tieba.z.signallforum_error);
                }
            }
            aee.aea();
            return;
        }
        this.bRb.hU(adv.getUserMsg());
    }
}
