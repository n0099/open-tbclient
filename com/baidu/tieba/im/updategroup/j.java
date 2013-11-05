package com.baidu.tieba.im.updategroup;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class j implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f1715a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.f1715a = gVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        DialogInterface.OnClickListener onClickListener;
        DialogInterface.OnClickListener onClickListener2;
        onClickListener = this.f1715a.f1712a;
        if (onClickListener != null) {
            onClickListener2 = this.f1715a.f1712a;
            onClickListener2.onClick(dialogInterface, i);
        }
    }
}
