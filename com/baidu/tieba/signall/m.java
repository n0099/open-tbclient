package com.baidu.tieba.signall;

import android.app.PendingIntent;
import android.content.Intent;
import com.baidu.tieba.n;
import com.baidu.tieba.signall.w;
/* loaded from: classes.dex */
class m implements w.a {
    final /* synthetic */ SignAllForumActivity dxE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SignAllForumActivity signAllForumActivity) {
        this.dxE = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.w.a
    public void iz(String str) {
        this.dxE.lX(str);
    }

    @Override // com.baidu.tieba.signall.w.a
    public void b(u uVar) {
        ae aeVar;
        boolean z;
        ae aeVar2;
        ae aeVar3;
        com.baidu.tbadk.core.dialog.a aVar;
        boolean z2;
        a aBC = uVar.aBC();
        if (aBC != null && aBC.getErrorNumber() == 0) {
            aeVar = this.dxE.dxw;
            c aCn = aeVar.aCn();
            aCn.a(uVar);
            z = this.dxE.dxz;
            if (z) {
                Intent intent = new Intent(this.dxE.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                this.dxE.a(this.dxE.getPageContext().getPageActivity().getString(n.j.signallforum_back_finish, new Object[]{Integer.valueOf(aCn.aBJ()), Integer.valueOf(aCn.aBK())}), PendingIntent.getActivity(this.dxE.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                z2 = this.dxE.dxA;
                if (z2) {
                    return;
                }
            }
            aeVar2 = this.dxE.dxw;
            aeVar2.aCo().notifyDataSetChanged();
            aeVar3 = this.dxE.dxw;
            x aCl = aeVar3.aCl();
            if (!aCn.aBI()) {
                if (uVar.aCa() == 0) {
                    if (uVar.aCc() != 0) {
                        this.dxE.showToast(uVar.aCd());
                    } else {
                        this.dxE.showToast(n.j.signallforum_error);
                    }
                } else {
                    this.dxE.lY(uVar.aBA());
                    aVar = this.dxE.Md;
                    aVar.tf();
                }
            }
            aCl.aCh();
            this.dxE.b(aCn);
            return;
        }
        this.dxE.lX(aBC.getUserMsg());
    }
}
