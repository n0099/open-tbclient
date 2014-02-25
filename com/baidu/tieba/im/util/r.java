package com.baidu.tieba.im.util;

import android.content.Context;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements DialogInterface.OnClickListener {
    private final /* synthetic */ Context a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(Context context, String str, String str2) {
        this.a = context;
        this.b = str;
        this.c = str2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        q.b(this.a, this.b, this.c);
    }
}
