package com.baidu.tieba.signall;

import android.app.PendingIntent;
import android.content.Intent;
import com.baidu.tieba.signall.w;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class m implements w.a {
    final /* synthetic */ SignAllForumActivity dNI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SignAllForumActivity signAllForumActivity) {
        this.dNI = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.w.a
    public void iB(String str) {
        this.dNI.mo(str);
    }

    @Override // com.baidu.tieba.signall.w.a
    public void b(u uVar) {
        af afVar;
        boolean z;
        af afVar2;
        af afVar3;
        com.baidu.tbadk.core.dialog.a aVar;
        boolean z2;
        a aIJ = uVar.aIJ();
        if (aIJ != null && aIJ.getErrorNumber() == 0) {
            afVar = this.dNI.dNA;
            c aJv = afVar.aJv();
            aJv.a(uVar);
            z = this.dNI.dND;
            if (z) {
                Intent intent = new Intent(this.dNI.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                this.dNI.a(this.dNI.getPageContext().getPageActivity().getString(t.j.signallforum_back_finish, new Object[]{Integer.valueOf(aJv.aIQ()), Integer.valueOf(aJv.aIR())}), PendingIntent.getActivity(this.dNI.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                z2 = this.dNI.dNE;
                if (z2) {
                    return;
                }
            }
            afVar2 = this.dNI.dNA;
            afVar2.aJw().notifyDataSetChanged();
            afVar3 = this.dNI.dNA;
            x aJt = afVar3.aJt();
            if (!aJv.aIP()) {
                if (uVar.aJh() == 0) {
                    if (uVar.aJj() != 0) {
                        this.dNI.showToast(uVar.aJk());
                    } else {
                        this.dNI.showToast(t.j.signallforum_error);
                    }
                } else {
                    this.dNI.mp(uVar.aIH());
                    aVar = this.dNI.Ms;
                    aVar.uj();
                }
            }
            aJt.aJo();
            this.dNI.b(aJv);
            return;
        }
        this.dNI.mo(aIJ.getUserMsg());
    }
}
