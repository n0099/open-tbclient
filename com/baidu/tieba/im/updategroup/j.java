package com.baidu.tieba.im.updategroup;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class j implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f1802a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.f1802a = gVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        DialogInterface.OnClickListener onClickListener;
        DialogInterface.OnClickListener onClickListener2;
        onClickListener = this.f1802a.f1799a;
        if (onClickListener != null) {
            onClickListener2 = this.f1802a.f1799a;
            onClickListener2.onClick(dialogInterface, i);
        }
    }
}
