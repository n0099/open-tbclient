package com.baidu.tieba.pb;

import android.content.DialogInterface;
import android.os.Handler;
import android.view.View;
/* loaded from: classes.dex */
class eg implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2253a;
    final /* synthetic */ int b;
    final /* synthetic */ View c;
    final /* synthetic */ ef d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eg(ef efVar, String str, int i, View view) {
        this.d = efVar;
        this.f2253a = str;
        this.b = i;
        this.c = view;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        new Handler().postDelayed(new eh(this), 200L);
    }
}
