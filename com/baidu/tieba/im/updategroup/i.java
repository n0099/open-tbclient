package com.baidu.tieba.im.updategroup;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class i implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f1801a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.f1801a = gVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        DialogInterface.OnClickListener onClickListener;
        DialogInterface.OnClickListener onClickListener2;
        onClickListener = this.f1801a.p;
        if (onClickListener != null) {
            onClickListener2 = this.f1801a.p;
            onClickListener2.onClick(dialogInterface, i);
        }
    }
}
