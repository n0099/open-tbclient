package com.baidu.tieba.more;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w f2107a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar) {
        this.f2107a = wVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                com.baidu.tieba.d.a.a().a(true);
                com.baidu.tieba.d.a.a().c(0);
                break;
            case 1:
                com.baidu.tieba.d.a.a().a(true);
                com.baidu.tieba.d.a.a().c(1);
                break;
            case 2:
                com.baidu.tieba.d.a.a().a(true);
                com.baidu.tieba.d.a.a().c(2);
                break;
            case 3:
                com.baidu.tieba.d.a.a().a(false);
                break;
        }
        this.f2107a.B();
        this.f2107a.q();
    }
}
