package com.baidu.tieba.im.updategroup;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class c implements DialogInterface.OnClickListener {
    final /* synthetic */ UpdateGroupActivity biN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(UpdateGroupActivity updateGroupActivity) {
        this.biN = updateGroupActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.biN.setResult(0);
        this.biN.finish();
    }
}
