package com.baidu.tieba.signall;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Intent;
/* loaded from: classes.dex */
class m implements v {
    final /* synthetic */ SignAllForumActivity bPs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SignAllForumActivity signAllForumActivity) {
        this.bPs = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.v
    public void gF(String str) {
        this.bPs.hP(str);
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
        com.baidu.tieba.home.u acW = sVar.acW();
        if (acW != null && acW.getErrorNumber() == 0) {
            adVar = this.bPs.bPl;
            b adH = adVar.adH();
            adH.a(sVar);
            z = this.bPs.bPo;
            if (z) {
                Intent intent = new Intent(this.bPs.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                this.bPs.a(this.bPs.getPageContext().getPageActivity().getString(com.baidu.tieba.z.signallforum_back_finish, new Object[]{Integer.valueOf(adH.add()), Integer.valueOf(adH.ade())}), PendingIntent.getActivity(this.bPs.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                z2 = this.bPs.aHD;
                if (z2) {
                    return;
                }
            }
            adVar2 = this.bPs.bPl;
            adVar2.adI().notifyDataSetChanged();
            adVar3 = this.bPs.bPl;
            x adF = adVar3.adF();
            if (!adH.adc()) {
                if (sVar.adu() != 0) {
                    alertDialog = this.bPs.mDialog;
                    alertDialog.setMessage(sVar.acU());
                    alertDialog2 = this.bPs.mDialog;
                    if (!alertDialog2.isShowing()) {
                        alertDialog3 = this.bPs.mDialog;
                        com.baidu.adp.lib.g.k.a(alertDialog3, this.bPs.getPageContext());
                    }
                } else if (sVar.adw() != 0) {
                    this.bPs.showToast(sVar.adx());
                } else {
                    this.bPs.showToast(com.baidu.tieba.z.signallforum_error);
                }
            }
            adF.adB();
            return;
        }
        this.bPs.hP(acW.getUserMsg());
    }
}
