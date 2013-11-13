package com.baidu.tieba.im.updategroup;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class b implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateGroupActivity f1795a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(UpdateGroupActivity updateGroupActivity) {
        this.f1795a = updateGroupActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1795a.c();
    }
}
