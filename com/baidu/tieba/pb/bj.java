package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bj implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2094a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(NewPbActivity newPbActivity) {
        this.f2094a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f2094a.b != null) {
            if (i == 0) {
                this.f2094a.b.c(this.f2094a);
                this.f2094a.b = null;
            } else if (i == 1) {
                this.f2094a.a(this.f2094a.b);
            }
        }
    }
}
