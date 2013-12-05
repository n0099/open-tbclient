package com.baidu.tieba.im.updategroup;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class i implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f1891a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.f1891a = gVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        DialogInterface.OnClickListener onClickListener;
        DialogInterface.OnClickListener onClickListener2;
        onClickListener = this.f1891a.p;
        if (onClickListener != null) {
            onClickListener2 = this.f1891a.p;
            onClickListener2.onClick(dialogInterface, i);
        }
    }
}
