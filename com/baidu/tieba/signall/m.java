package com.baidu.tieba.signall;

import android.app.PendingIntent;
import android.content.Intent;
/* loaded from: classes.dex */
class m implements v {
    final /* synthetic */ SignAllForumActivity cis;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SignAllForumActivity signAllForumActivity) {
        this.cis = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.v
    public void he(String str) {
        this.cis.jg(str);
    }

    @Override // com.baidu.tieba.signall.v
    public void b(s sVar) {
        ae aeVar;
        boolean z;
        ae aeVar2;
        ae aeVar3;
        com.baidu.tbadk.core.dialog.a aVar;
        boolean z2;
        a akn = sVar.akn();
        if (akn != null && akn.getErrorNumber() == 0) {
            aeVar = this.cis.cik;
            c akX = aeVar.akX();
            akX.a(sVar);
            z = this.cis.cin;
            if (z) {
                Intent intent = new Intent(this.cis.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                this.cis.a(this.cis.getPageContext().getPageActivity().getString(com.baidu.tieba.t.signallforum_back_finish, new Object[]{Integer.valueOf(akX.aku()), Integer.valueOf(akX.akv())}), PendingIntent.getActivity(this.cis.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                z2 = this.cis.cio;
                if (z2) {
                    return;
                }
            }
            aeVar2 = this.cis.cik;
            aeVar2.akY().notifyDataSetChanged();
            aeVar3 = this.cis.cik;
            x akV = aeVar3.akV();
            if (!akX.akt()) {
                if (sVar.akK() == 0) {
                    if (sVar.akM() != 0) {
                        this.cis.showToast(sVar.akN());
                    } else {
                        this.cis.showToast(com.baidu.tieba.t.signallforum_error);
                    }
                } else {
                    this.cis.jh(sVar.akl());
                    aVar = this.cis.Ll;
                    aVar.rL();
                }
            }
            akV.akR();
            return;
        }
        this.cis.jg(akn.getUserMsg());
    }
}
