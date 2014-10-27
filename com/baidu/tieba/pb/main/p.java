package com.baidu.tieba.pb.main;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class p implements DialogInterface.OnClickListener {
    final /* synthetic */ PbActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.bvg = pbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.bvg.bve != null) {
            if (i == 0) {
                this.bvg.bve.Q(this.bvg);
                this.bvg.bve = null;
            } else if (i == 1) {
                this.bvg.b(this.bvg.bve);
            }
        }
    }
}
