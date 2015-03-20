package com.baidu.tieba.signall;

import android.app.PendingIntent;
import android.content.Intent;
/* loaded from: classes.dex */
class m implements v {
    final /* synthetic */ SignAllForumActivity cdX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SignAllForumActivity signAllForumActivity) {
        this.cdX = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.v
    public void gy(String str) {
        this.cdX.ik(str);
    }

    @Override // com.baidu.tieba.signall.v
    public void b(s sVar) {
        ae aeVar;
        boolean z;
        ae aeVar2;
        ae aeVar3;
        com.baidu.tbadk.core.dialog.a aVar;
        boolean z2;
        a ain = sVar.ain();
        if (ain != null && ain.getErrorNumber() == 0) {
            aeVar = this.cdX.cdP;
            c aiX = aeVar.aiX();
            aiX.a(sVar);
            z = this.cdX.cdS;
            if (z) {
                Intent intent = new Intent(this.cdX.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                this.cdX.a(this.cdX.getPageContext().getPageActivity().getString(com.baidu.tieba.y.signallforum_back_finish, new Object[]{Integer.valueOf(aiX.aiu()), Integer.valueOf(aiX.aiv())}), PendingIntent.getActivity(this.cdX.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                z2 = this.cdX.cdT;
                if (z2) {
                    return;
                }
            }
            aeVar2 = this.cdX.cdP;
            aeVar2.aiY().notifyDataSetChanged();
            aeVar3 = this.cdX.cdP;
            x aiV = aeVar3.aiV();
            if (!aiX.ait()) {
                if (sVar.aiK() == 0) {
                    if (sVar.aiM() != 0) {
                        this.cdX.showToast(sVar.aiN());
                    } else {
                        this.cdX.showToast(com.baidu.tieba.y.signallforum_error);
                    }
                } else {
                    this.cdX.il(sVar.ail());
                    aVar = this.cdX.Lr;
                    aVar.re();
                }
            }
            aiV.aiR();
            return;
        }
        this.cdX.ik(ain.getUserMsg());
    }
}
