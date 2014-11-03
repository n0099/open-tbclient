package com.baidu.tieba.pb.main;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class p implements DialogInterface.OnClickListener {
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.bvu = pbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.bvu.bvs != null) {
            if (i == 0) {
                this.bvu.bvs.Q(this.bvu);
                this.bvu.bvs = null;
            } else if (i == 1) {
                this.bvu.b(this.bvu.bvs);
            }
        }
    }
}
