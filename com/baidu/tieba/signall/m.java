package com.baidu.tieba.signall;

import android.app.PendingIntent;
import android.content.Intent;
/* loaded from: classes.dex */
class m implements v {
    final /* synthetic */ SignAllForumActivity cir;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SignAllForumActivity signAllForumActivity) {
        this.cir = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.v
    public void he(String str) {
        this.cir.jg(str);
    }

    @Override // com.baidu.tieba.signall.v
    public void b(s sVar) {
        ae aeVar;
        boolean z;
        ae aeVar2;
        ae aeVar3;
        com.baidu.tbadk.core.dialog.a aVar;
        boolean z2;
        a akm = sVar.akm();
        if (akm != null && akm.getErrorNumber() == 0) {
            aeVar = this.cir.cij;
            c akW = aeVar.akW();
            akW.a(sVar);
            z = this.cir.cim;
            if (z) {
                Intent intent = new Intent(this.cir.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                this.cir.a(this.cir.getPageContext().getPageActivity().getString(com.baidu.tieba.t.signallforum_back_finish, new Object[]{Integer.valueOf(akW.akt()), Integer.valueOf(akW.aku())}), PendingIntent.getActivity(this.cir.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                z2 = this.cir.cin;
                if (z2) {
                    return;
                }
            }
            aeVar2 = this.cir.cij;
            aeVar2.akX().notifyDataSetChanged();
            aeVar3 = this.cir.cij;
            x akU = aeVar3.akU();
            if (!akW.aks()) {
                if (sVar.akJ() == 0) {
                    if (sVar.akL() != 0) {
                        this.cir.showToast(sVar.akM());
                    } else {
                        this.cir.showToast(com.baidu.tieba.t.signallforum_error);
                    }
                } else {
                    this.cir.jh(sVar.akk());
                    aVar = this.cir.Ll;
                    aVar.rL();
                }
            }
            akU.akQ();
            return;
        }
        this.cir.jg(akm.getUserMsg());
    }
}
