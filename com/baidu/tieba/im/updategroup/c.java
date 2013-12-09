package com.baidu.tieba.im.updategroup;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class c implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateGroupActivity f1887a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(UpdateGroupActivity updateGroupActivity) {
        this.f1887a = updateGroupActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1887a.setResult(0);
        this.f1887a.finish();
    }
}
