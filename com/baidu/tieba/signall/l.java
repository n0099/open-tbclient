package com.baidu.tieba.signall;

import android.app.PendingIntent;
import android.content.Intent;
import com.baidu.tieba.i;
import com.baidu.tieba.signall.r;
/* loaded from: classes.dex */
class l implements r.a {
    final /* synthetic */ SignAllForumActivity cJd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SignAllForumActivity signAllForumActivity) {
        this.cJd = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.r.a
    public void hM(String str) {
        this.cJd.kH(str);
    }

    @Override // com.baidu.tieba.signall.r.a
    public void b(p pVar) {
        z zVar;
        boolean z;
        z zVar2;
        z zVar3;
        com.baidu.tbadk.core.dialog.a aVar;
        boolean z2;
        a aqX = pVar.aqX();
        if (aqX != null && aqX.getErrorNumber() == 0) {
            zVar = this.cJd.cIV;
            c arH = zVar.arH();
            arH.a(pVar);
            z = this.cJd.cIY;
            if (z) {
                Intent intent = new Intent(this.cJd.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                this.cJd.a(this.cJd.getPageContext().getPageActivity().getString(i.h.signallforum_back_finish, new Object[]{Integer.valueOf(arH.are()), Integer.valueOf(arH.arf())}), PendingIntent.getActivity(this.cJd.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                z2 = this.cJd.cIZ;
                if (z2) {
                    return;
                }
            }
            zVar2 = this.cJd.cIV;
            zVar2.arI().notifyDataSetChanged();
            zVar3 = this.cJd.cIV;
            s arF = zVar3.arF();
            if (!arH.ard()) {
                if (pVar.aru() == 0) {
                    if (pVar.arw() != 0) {
                        this.cJd.showToast(pVar.arx());
                    } else {
                        this.cJd.showToast(i.h.signallforum_error);
                    }
                } else {
                    this.cJd.kI(pVar.aqV());
                    aVar = this.cJd.Lt;
                    aVar.sU();
                }
            }
            arF.arB();
            return;
        }
        this.cJd.kH(aqX.getUserMsg());
    }
}
