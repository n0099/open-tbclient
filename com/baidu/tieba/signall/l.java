package com.baidu.tieba.signall;

import android.app.PendingIntent;
import android.content.Intent;
import com.baidu.tieba.i;
import com.baidu.tieba.signall.r;
/* loaded from: classes.dex */
class l implements r.a {
    final /* synthetic */ SignAllForumActivity cQx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SignAllForumActivity signAllForumActivity) {
        this.cQx = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.r.a
    public void hQ(String str) {
        this.cQx.li(str);
    }

    @Override // com.baidu.tieba.signall.r.a
    public void b(p pVar) {
        z zVar;
        boolean z;
        z zVar2;
        z zVar3;
        com.baidu.tbadk.core.dialog.a aVar;
        boolean z2;
        a atn = pVar.atn();
        if (atn != null && atn.getErrorNumber() == 0) {
            zVar = this.cQx.cQp;
            c atX = zVar.atX();
            atX.a(pVar);
            z = this.cQx.cQs;
            if (z) {
                Intent intent = new Intent(this.cQx.getPageContext().getPageActivity(), SignAllForumActivity.class);
                intent.addFlags(805306368);
                intent.putExtra("signall_noyify_click", true);
                this.cQx.a(this.cQx.getPageContext().getPageActivity().getString(i.h.signallforum_back_finish, new Object[]{Integer.valueOf(atX.atu()), Integer.valueOf(atX.atv())}), PendingIntent.getActivity(this.cQx.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                z2 = this.cQx.cQt;
                if (z2) {
                    return;
                }
            }
            zVar2 = this.cQx.cQp;
            zVar2.atY().notifyDataSetChanged();
            zVar3 = this.cQx.cQp;
            s atV = zVar3.atV();
            if (!atX.att()) {
                if (pVar.atK() == 0) {
                    if (pVar.atM() != 0) {
                        this.cQx.showToast(pVar.atN());
                    } else {
                        this.cQx.showToast(i.h.signallforum_error);
                    }
                } else {
                    this.cQx.lj(pVar.atl());
                    aVar = this.cQx.Lu;
                    aVar.sO();
                }
            }
            atV.atR();
            return;
        }
        this.cQx.li(atn.getUserMsg());
    }
}
