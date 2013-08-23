package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f1479a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(ImagePbActivity imagePbActivity) {
        this.f1479a = imagePbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            com.baidu.tieba.write.ba.a(this.f1479a);
        } else {
            com.baidu.tieba.write.ba.b(this.f1479a);
        }
    }
}
