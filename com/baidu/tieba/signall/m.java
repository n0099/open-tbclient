package com.baidu.tieba.signall;

import android.app.PendingIntent;
import android.content.Intent;
import com.baidu.tieba.signall.w;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class m implements w.a {
    final /* synthetic */ SignAllForumActivity egh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SignAllForumActivity signAllForumActivity) {
        this.egh = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.w.a
    public void jk(String str) {
        this.egh.nz(str);
    }

    @Override // com.baidu.tieba.signall.w.a
    public void b(u uVar) {
        af afVar;
        boolean z;
        af afVar2;
        af afVar3;
        com.baidu.tbadk.core.dialog.a aVar;
        boolean z2;
        a aPz = uVar.aPz();
        if (aPz != null && aPz.getErrorNumber() == 0) {
            afVar = this.egh.efZ;
            c aQm = afVar.aQm();
            aQm.a(uVar);
            z = this.egh.egc;
            if (z) {
                Intent intent = new Intent(this.egh.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                this.egh.a(this.egh.getPageContext().getPageActivity().getString(t.j.signallforum_back_finish, new Object[]{Integer.valueOf(aQm.aPG()), Integer.valueOf(aQm.aPH())}), PendingIntent.getActivity(this.egh.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                z2 = this.egh.egd;
                if (z2) {
                    return;
                }
            }
            afVar2 = this.egh.efZ;
            afVar2.aQn().notifyDataSetChanged();
            afVar3 = this.egh.efZ;
            x aQk = afVar3.aQk();
            if (!aQm.aPF()) {
                if (uVar.aPX() == 0) {
                    if (uVar.aPZ() != 0) {
                        this.egh.showToast(uVar.aQa());
                    } else {
                        this.egh.showToast(t.j.signallforum_error);
                    }
                } else {
                    this.egh.nA(uVar.aPx());
                    aVar = this.egh.My;
                    aVar.up();
                }
            }
            aQk.aQe();
            this.egh.b(aQm);
            return;
        }
        this.egh.nz(aPz.getUserMsg());
    }
}
