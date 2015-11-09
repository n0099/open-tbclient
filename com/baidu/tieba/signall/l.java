package com.baidu.tieba.signall;

import android.app.PendingIntent;
import android.content.Intent;
import com.baidu.tieba.i;
import com.baidu.tieba.signall.r;
/* loaded from: classes.dex */
class l implements r.a {
    final /* synthetic */ SignAllForumActivity cRT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SignAllForumActivity signAllForumActivity) {
        this.cRT = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.r.a
    public void hS(String str) {
        this.cRT.lm(str);
    }

    @Override // com.baidu.tieba.signall.r.a
    public void b(p pVar) {
        z zVar;
        boolean z;
        z zVar2;
        z zVar3;
        com.baidu.tbadk.core.dialog.a aVar;
        boolean z2;
        a atT = pVar.atT();
        if (atT != null && atT.getErrorNumber() == 0) {
            zVar = this.cRT.cRL;
            c auD = zVar.auD();
            auD.a(pVar);
            z = this.cRT.cRO;
            if (z) {
                Intent intent = new Intent(this.cRT.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                this.cRT.a(this.cRT.getPageContext().getPageActivity().getString(i.h.signallforum_back_finish, new Object[]{Integer.valueOf(auD.aua()), Integer.valueOf(auD.aub())}), PendingIntent.getActivity(this.cRT.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                z2 = this.cRT.cRP;
                if (z2) {
                    return;
                }
            }
            zVar2 = this.cRT.cRL;
            zVar2.auE().notifyDataSetChanged();
            zVar3 = this.cRT.cRL;
            s auB = zVar3.auB();
            if (!auD.atZ()) {
                if (pVar.auq() == 0) {
                    if (pVar.aus() != 0) {
                        this.cRT.showToast(pVar.aut());
                    } else {
                        this.cRT.showToast(i.h.signallforum_error);
                    }
                } else {
                    this.cRT.ln(pVar.atR());
                    aVar = this.cRT.Lv;
                    aVar.sR();
                }
            }
            auB.aux();
            return;
        }
        this.cRT.lm(atT.getUserMsg());
    }
}
