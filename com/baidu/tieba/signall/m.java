package com.baidu.tieba.signall;

import android.app.PendingIntent;
import android.content.Intent;
import com.baidu.tieba.signall.w;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class m implements w.a {
    final /* synthetic */ SignAllForumActivity ejs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SignAllForumActivity signAllForumActivity) {
        this.ejs = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.w.a
    public void jm(String str) {
        this.ejs.ny(str);
    }

    @Override // com.baidu.tieba.signall.w.a
    public void b(u uVar) {
        af afVar;
        boolean z;
        af afVar2;
        af afVar3;
        com.baidu.tbadk.core.dialog.a aVar;
        boolean z2;
        a aPP = uVar.aPP();
        if (aPP != null && aPP.getErrorNumber() == 0) {
            afVar = this.ejs.ejk;
            c aQF = afVar.aQF();
            aQF.a(uVar);
            z = this.ejs.ejn;
            if (z) {
                Intent intent = new Intent(this.ejs.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                this.ejs.a(this.ejs.getPageContext().getPageActivity().getString(t.j.signallforum_back_finish, new Object[]{Integer.valueOf(aQF.aPW()), Integer.valueOf(aQF.aPX())}), PendingIntent.getActivity(this.ejs.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                z2 = this.ejs.ejo;
                if (z2) {
                    return;
                }
            }
            afVar2 = this.ejs.ejk;
            afVar2.aQG().notifyDataSetChanged();
            afVar3 = this.ejs.ejk;
            x aQD = afVar3.aQD();
            if (!aQF.aPV()) {
                if (uVar.aQo() == 0) {
                    if (uVar.aQq() != 0) {
                        this.ejs.showToast(uVar.aQr());
                    } else {
                        this.ejs.showToast(t.j.signallforum_error);
                    }
                } else {
                    this.ejs.nz(uVar.aPN());
                    aVar = this.ejs.CP;
                    aVar.rU();
                }
            }
            aQD.aQx();
            this.ejs.b(aQF);
            return;
        }
        this.ejs.ny(aPP.getUserMsg());
    }
}
