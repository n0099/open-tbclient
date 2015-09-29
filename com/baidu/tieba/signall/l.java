package com.baidu.tieba.signall;

import android.app.PendingIntent;
import android.content.Intent;
import com.baidu.tieba.i;
import com.baidu.tieba.signall.r;
/* loaded from: classes.dex */
class l implements r.a {
    final /* synthetic */ SignAllForumActivity cPY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SignAllForumActivity signAllForumActivity) {
        this.cPY = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.r.a
    public void hQ(String str) {
        this.cPY.lf(str);
    }

    @Override // com.baidu.tieba.signall.r.a
    public void b(p pVar) {
        z zVar;
        boolean z;
        z zVar2;
        z zVar3;
        com.baidu.tbadk.core.dialog.a aVar;
        boolean z2;
        a atl = pVar.atl();
        if (atl != null && atl.getErrorNumber() == 0) {
            zVar = this.cPY.cPQ;
            c atV = zVar.atV();
            atV.a(pVar);
            z = this.cPY.cPT;
            if (z) {
                Intent intent = new Intent(this.cPY.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                this.cPY.a(this.cPY.getPageContext().getPageActivity().getString(i.h.signallforum_back_finish, new Object[]{Integer.valueOf(atV.ats()), Integer.valueOf(atV.att())}), PendingIntent.getActivity(this.cPY.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                z2 = this.cPY.cPU;
                if (z2) {
                    return;
                }
            }
            zVar2 = this.cPY.cPQ;
            zVar2.atW().notifyDataSetChanged();
            zVar3 = this.cPY.cPQ;
            s atT = zVar3.atT();
            if (!atV.atr()) {
                if (pVar.atI() == 0) {
                    if (pVar.atK() != 0) {
                        this.cPY.showToast(pVar.atL());
                    } else {
                        this.cPY.showToast(i.h.signallforum_error);
                    }
                } else {
                    this.cPY.lg(pVar.atj());
                    aVar = this.cPY.Lt;
                    aVar.sR();
                }
            }
            atT.atP();
            return;
        }
        this.cPY.lf(atl.getUserMsg());
    }
}
