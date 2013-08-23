package com.baidu.tieba.mention;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ y f1348a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.f1348a = yVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        PostActivity postActivity;
        postActivity = this.f1348a.b;
        postActivity.d();
    }
}
