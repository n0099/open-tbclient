package com.baidu.tieba.signall;

import android.app.PendingIntent;
import android.content.Intent;
/* loaded from: classes.dex */
class m implements v {
    final /* synthetic */ SignAllForumActivity cem;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SignAllForumActivity signAllForumActivity) {
        this.cem = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.v
    public void gB(String str) {
        this.cem.in(str);
    }

    @Override // com.baidu.tieba.signall.v
    public void b(s sVar) {
        ae aeVar;
        boolean z;
        ae aeVar2;
        ae aeVar3;
        com.baidu.tbadk.core.dialog.a aVar;
        boolean z2;
        a aiC = sVar.aiC();
        if (aiC != null && aiC.getErrorNumber() == 0) {
            aeVar = this.cem.cee;
            c ajm = aeVar.ajm();
            ajm.a(sVar);
            z = this.cem.ceh;
            if (z) {
                Intent intent = new Intent(this.cem.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                this.cem.a(this.cem.getPageContext().getPageActivity().getString(com.baidu.tieba.y.signallforum_back_finish, new Object[]{Integer.valueOf(ajm.aiJ()), Integer.valueOf(ajm.aiK())}), PendingIntent.getActivity(this.cem.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                z2 = this.cem.cei;
                if (z2) {
                    return;
                }
            }
            aeVar2 = this.cem.cee;
            aeVar2.ajn().notifyDataSetChanged();
            aeVar3 = this.cem.cee;
            x ajk = aeVar3.ajk();
            if (!ajm.aiI()) {
                if (sVar.aiZ() == 0) {
                    if (sVar.ajb() != 0) {
                        this.cem.showToast(sVar.ajc());
                    } else {
                        this.cem.showToast(com.baidu.tieba.y.signallforum_error);
                    }
                } else {
                    this.cem.io(sVar.aiA());
                    aVar = this.cem.Lt;
                    aVar.re();
                }
            }
            ajk.ajg();
            return;
        }
        this.cem.in(aiC.getUserMsg());
    }
}
