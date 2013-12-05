package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f2287a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(ImagePbActivity imagePbActivity) {
        this.f2287a = imagePbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            com.baidu.tieba.write.bd.a(this.f2287a);
        } else {
            com.baidu.tieba.write.bd.b(this.f2287a);
        }
    }
}
