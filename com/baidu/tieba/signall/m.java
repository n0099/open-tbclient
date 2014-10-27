package com.baidu.tieba.signall;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Intent;
/* loaded from: classes.dex */
class m implements v {
    final /* synthetic */ SignAllForumActivity bKN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SignAllForumActivity signAllForumActivity) {
        this.bKN = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.v
    public void fw(String str) {
        this.bKN.hq(str);
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
        com.baidu.tieba.home.t acy = sVar.acy();
        if (acy != null && acy.getErrorNumber() == 0) {
            abVar = this.bKN.bKG;
            b adg = abVar.adg();
            adg.a(sVar);
            z = this.bKN.bKJ;
            if (z) {
                Intent intent = new Intent(this.bKN, SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                this.bKN.a(this.bKN.getString(com.baidu.tieba.y.signallforum_back_finish, new Object[]{Integer.valueOf(adg.acF()), Integer.valueOf(adg.acG())}), PendingIntent.getActivity(this.bKN, 0, intent, 134217728), false);
                z2 = this.bKN.aFO;
                if (z2) {
                    return;
                }
            }
            abVar2 = this.bKN.bKG;
            abVar2.adh().notifyDataSetChanged();
            abVar3 = this.bKN.bKG;
            x ade = abVar3.ade();
            if (!adg.acE()) {
                if (sVar.acV() != 0) {
                    alertDialog = this.bKN.Bf;
                    alertDialog.setMessage(sVar.acw());
                    alertDialog2 = this.bKN.Bf;
                    if (!alertDialog2.isShowing()) {
                        alertDialog3 = this.bKN.Bf;
                        com.baidu.adp.lib.g.j.a(alertDialog3, this.bKN);
                    }
                } else if (sVar.acX() != 0) {
                    this.bKN.showToast(sVar.acY());
                } else {
                    this.bKN.showToast(com.baidu.tieba.y.signallforum_error);
                }
            }
            ade.adc();
            return;
        }
        this.bKN.hq(acy.getUserMsg());
    }
}
