package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class aa implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w f1969a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(w wVar) {
        this.f1969a = wVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                com.baidu.tieba.d.a.a().a(0);
                break;
            case 1:
                com.baidu.tieba.d.a.a().a(1);
                break;
            case 2:
                com.baidu.tieba.d.a.a().a(2);
                break;
        }
        this.f1969a.s();
        this.f1969a.q();
    }
}
