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
        a aPS = uVar.aPS();
        if (aPS != null && aPS.getErrorNumber() == 0) {
            afVar = this.ejs.ejk;
            c aQI = afVar.aQI();
            aQI.a(uVar);
            z = this.ejs.ejn;
            if (z) {
                Intent intent = new Intent(this.ejs.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                this.ejs.a(this.ejs.getPageContext().getPageActivity().getString(t.j.signallforum_back_finish, new Object[]{Integer.valueOf(aQI.aPZ()), Integer.valueOf(aQI.aQa())}), PendingIntent.getActivity(this.ejs.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                z2 = this.ejs.ejo;
                if (z2) {
                    return;
                }
            }
            afVar2 = this.ejs.ejk;
            afVar2.aQJ().notifyDataSetChanged();
            afVar3 = this.ejs.ejk;
            x aQG = afVar3.aQG();
            if (!aQI.aPY()) {
                if (uVar.aQr() == 0) {
                    if (uVar.aQt() != 0) {
                        this.ejs.showToast(uVar.aQu());
                    } else {
                        this.ejs.showToast(t.j.signallforum_error);
                    }
                } else {
                    this.ejs.nz(uVar.aPQ());
                    aVar = this.ejs.CP;
                    aVar.rV();
                }
            }
            aQG.aQA();
            this.ejs.b(aQI);
            return;
        }
        this.ejs.ny(aPS.getUserMsg());
    }
}
