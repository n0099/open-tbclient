package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bl implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2079a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(NewPbActivity newPbActivity) {
        this.f2079a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f2079a.b != null) {
            if (i == 0) {
                this.f2079a.b.c(this.f2079a);
                this.f2079a.b = null;
            } else if (i == 1) {
                this.f2079a.a(this.f2079a.b);
            }
        }
    }
}
