package com.baidu.tieba.pb;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements View.OnClickListener {
    final /* synthetic */ PbActivity a;
    private final /* synthetic */ int b;
    private final /* synthetic */ String c;
    private final /* synthetic */ int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(PbActivity pbActivity, int i, String str, int i2) {
        this.a = pbActivity;
        this.b = i;
        this.c = str;
        this.d = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        this.a.b(this.b, this.c, this.d);
        dialog = this.a.F;
        dialog.dismiss();
    }
}
