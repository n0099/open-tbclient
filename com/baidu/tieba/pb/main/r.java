package com.baidu.tieba.pb.main;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class r implements DialogInterface.OnClickListener {
    final /* synthetic */ PbActivity bAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PbActivity pbActivity) {
        this.bAT = pbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.bAT.bAR != null) {
            if (i == 0) {
                this.bAT.bAR.az(this.bAT.getPageContext().getPageActivity());
                this.bAT.bAR = null;
            } else if (i == 1) {
                this.bAT.a(this.bAT.bAR);
            }
        }
    }
}
