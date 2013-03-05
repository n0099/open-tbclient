package com.baidu.tieba.pb;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements View.OnClickListener {
    final /* synthetic */ PbActivity a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(PbActivity pbActivity, String str) {
        this.a = pbActivity;
        this.b = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        this.a.c(this.b);
        dialog = this.a.K;
        dialog.dismiss();
    }
}
