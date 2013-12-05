package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bl implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2186a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(NewPbActivity newPbActivity) {
        this.f2186a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f2186a.b != null) {
            if (i == 0) {
                this.f2186a.b.c(this.f2186a);
                this.f2186a.b = null;
            } else if (i == 1) {
                this.f2186a.a(this.f2186a.b);
            }
        }
    }
}
