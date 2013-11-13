package com.baidu.tieba.media;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f1826a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f1826a = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f1826a.b = null;
    }
}
