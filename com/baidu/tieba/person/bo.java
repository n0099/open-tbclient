package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.DialogInterface;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonChangeActivity a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(PersonChangeActivity personChangeActivity, String str, String str2) {
        this.a = personChangeActivity;
        this.b = str;
        this.c = str2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        TextView textView;
        Dialog dialog;
        TextView textView2;
        if (i == 0) {
            this.a.D = 1;
            textView2 = this.a.k;
            textView2.setText(this.b);
        } else if (i == 1) {
            this.a.D = 2;
            textView = this.a.k;
            textView.setText(this.c);
        }
        this.a.c();
        dialog = this.a.B;
        com.baidu.adp.lib.e.e.b(dialog, this.a);
    }
}
