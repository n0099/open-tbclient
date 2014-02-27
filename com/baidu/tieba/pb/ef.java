package com.baidu.tieba.pb;

import android.content.DialogInterface;
import android.os.Handler;
import android.view.View;
/* loaded from: classes.dex */
final class ef implements DialogInterface.OnClickListener {
    final /* synthetic */ ee a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;
    private final /* synthetic */ View d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ef(ee eeVar, String str, int i, View view) {
        this.a = eeVar;
        this.b = str;
        this.c = i;
        this.d = view;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        new Handler().postDelayed(new eg(this, this.b, this.c, this.d), 200L);
    }
}
