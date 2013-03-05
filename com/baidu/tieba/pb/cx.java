package com.baidu.tieba.pb;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cx implements View.OnClickListener {
    final /* synthetic */ SubPbActivity a;
    private final /* synthetic */ int b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(SubPbActivity subPbActivity, int i, String str) {
        this.a = subPbActivity;
        this.b = i;
        this.c = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        this.a.b(this.b, this.c);
        dialog = this.a.O;
        dialog.dismiss();
    }
}
