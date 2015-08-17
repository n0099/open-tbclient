package com.baidu.tieba.signall;

import android.app.PendingIntent;
import android.content.Intent;
import com.baidu.tieba.i;
import com.baidu.tieba.signall.r;
/* loaded from: classes.dex */
class l implements r.a {
    final /* synthetic */ SignAllForumActivity cAF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SignAllForumActivity signAllForumActivity) {
        this.cAF = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.r.a
    public void hD(String str) {
        this.cAF.kc(str);
    }

    @Override // com.baidu.tieba.signall.r.a
    public void b(p pVar) {
        z zVar;
        boolean z;
        z zVar2;
        z zVar3;
        com.baidu.tbadk.core.dialog.a aVar;
        boolean z2;
        a amO = pVar.amO();
        if (amO != null && amO.getErrorNumber() == 0) {
            zVar = this.cAF.cAx;
            c any = zVar.any();
            any.a(pVar);
            z = this.cAF.cAA;
            if (z) {
                Intent intent = new Intent(this.cAF.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                this.cAF.a(this.cAF.getPageContext().getPageActivity().getString(i.C0057i.signallforum_back_finish, new Object[]{Integer.valueOf(any.amV()), Integer.valueOf(any.amW())}), PendingIntent.getActivity(this.cAF.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                z2 = this.cAF.cAB;
                if (z2) {
                    return;
                }
            }
            zVar2 = this.cAF.cAx;
            zVar2.anz().notifyDataSetChanged();
            zVar3 = this.cAF.cAx;
            s anw = zVar3.anw();
            if (!any.amU()) {
                if (pVar.anl() == 0) {
                    if (pVar.ann() != 0) {
                        this.cAF.showToast(pVar.ano());
                    } else {
                        this.cAF.showToast(i.C0057i.signallforum_error);
                    }
                } else {
                    this.cAF.kd(pVar.amM());
                    aVar = this.cAF.Lt;
                    aVar.sP();
                }
            }
            anw.ans();
            return;
        }
        this.cAF.kc(amO.getUserMsg());
    }
}
