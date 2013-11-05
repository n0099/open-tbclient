package com.baidu.tieba.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2633a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(WriteActivity writeActivity) {
        this.f2633a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        au auVar;
        au auVar2;
        this.f2633a.i();
        auVar = this.f2633a.y;
        if (auVar != null) {
            auVar2 = this.f2633a.y;
            auVar2.cancel();
        }
    }
}
