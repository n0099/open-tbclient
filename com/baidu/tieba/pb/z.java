package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f2154a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(ImagePbActivity imagePbActivity) {
        this.f2154a = imagePbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            com.baidu.tieba.write.bg.a(this.f2154a);
        } else {
            com.baidu.tieba.write.bg.b(this.f2154a);
        }
    }
}
