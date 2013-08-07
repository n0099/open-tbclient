package com.baidu.tieba.mention;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ x f1313a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.f1313a = xVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        PostActivity postActivity;
        postActivity = this.f1313a.b;
        postActivity.d();
    }
}
