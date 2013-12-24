package com.baidu.tieba.im.updategroup;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class b implements DialogInterface.OnClickListener {
    final /* synthetic */ UpdateGroupActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(UpdateGroupActivity updateGroupActivity) {
        this.a = updateGroupActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.c();
    }
}
