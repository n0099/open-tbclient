package com.baidu.tieba.signall;

import android.app.PendingIntent;
import android.content.Intent;
import com.baidu.tieba.n;
import com.baidu.tieba.signall.r;
/* loaded from: classes.dex */
class l implements r.a {
    final /* synthetic */ SignAllForumActivity dqq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SignAllForumActivity signAllForumActivity) {
        this.dqq = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.r.a
    public void in(String str) {
        this.dqq.ma(str);
    }

    @Override // com.baidu.tieba.signall.r.a
    public void b(p pVar) {
        z zVar;
        boolean z;
        z zVar2;
        z zVar3;
        com.baidu.tbadk.core.dialog.a aVar;
        boolean z2;
        a azv = pVar.azv();
        if (azv != null && azv.getErrorNumber() == 0) {
            zVar = this.dqq.dqi;
            c aAf = zVar.aAf();
            aAf.a(pVar);
            z = this.dqq.dql;
            if (z) {
                Intent intent = new Intent(this.dqq.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                this.dqq.a(this.dqq.getPageContext().getPageActivity().getString(n.i.signallforum_back_finish, new Object[]{Integer.valueOf(aAf.azC()), Integer.valueOf(aAf.azD())}), PendingIntent.getActivity(this.dqq.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                z2 = this.dqq.dqm;
                if (z2) {
                    return;
                }
            }
            zVar2 = this.dqq.dqi;
            zVar2.aAg().notifyDataSetChanged();
            zVar3 = this.dqq.dqi;
            s aAd = zVar3.aAd();
            if (!aAf.azB()) {
                if (pVar.azS() == 0) {
                    if (pVar.azU() != 0) {
                        this.dqq.showToast(pVar.azV());
                    } else {
                        this.dqq.showToast(n.i.signallforum_error);
                    }
                } else {
                    this.dqq.mb(pVar.azt());
                    aVar = this.dqq.LN;
                    aVar.tv();
                }
            }
            aAd.azZ();
            return;
        }
        this.dqq.ma(azv.getUserMsg());
    }
}
