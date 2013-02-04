package com.baidu.tieba.pb;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ct implements View.OnClickListener {
    final /* synthetic */ SubPbActivity a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(SubPbActivity subPbActivity, String str) {
        this.a = subPbActivity;
        this.b = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        this.a.d(this.b);
        dialog = this.a.R;
        dialog.dismiss();
    }
}
