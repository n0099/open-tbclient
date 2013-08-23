package com.baidu.tieba;

import android.app.AlertDialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MainTabActivity f1952a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(MainTabActivity mainTabActivity) {
        this.f1952a = mainTabActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        boolean z;
        AlertDialog alertDialog;
        boolean z2;
        if (i == -2) {
            alertDialog = this.f1952a.u;
            alertDialog.dismiss();
            TiebaApplication g = TiebaApplication.g();
            z2 = this.f1952a.x;
            g.a(false, z2);
            return;
        }
        TiebaApplication g2 = TiebaApplication.g();
        z = this.f1952a.x;
        g2.a(true, z);
    }
}
