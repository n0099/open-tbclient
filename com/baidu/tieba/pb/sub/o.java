package com.baidu.tieba.pb.sub;

import android.content.DialogInterface;
import android.os.Handler;
import android.view.View;
/* loaded from: classes.dex */
class o implements DialogInterface.OnClickListener {
    final /* synthetic */ n a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;
    private final /* synthetic */ View d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, String str, int i, View view) {
        this.a = nVar;
        this.b = str;
        this.c = i;
        this.d = view;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        new Handler().postDelayed(new p(this, this.b, this.c, this.d), 200L);
    }
}
