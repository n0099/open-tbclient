package com.baidu.tieba.pb.main;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class q implements DialogInterface.OnClickListener {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PbActivity pbActivity) {
        this.bzj = pbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.bzj.bzh != null) {
            if (i == 0) {
                this.bzj.bzh.ay(this.bzj.getPageContext().getPageActivity());
                this.bzj.bzh = null;
            } else if (i == 1) {
                this.bzj.a(this.bzj.bzh);
            }
        }
    }
}
