package com.baidu.tieba.nearby;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewNearbyActivity f1158a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(NewNearbyActivity newNearbyActivity) {
        this.f1158a = newNearbyActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            com.baidu.tieba.write.bb.a(this.f1158a);
        } else if (i == 1) {
            com.baidu.tieba.write.bb.b(this.f1158a);
        }
    }
}
