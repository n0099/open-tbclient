package com.baidu.tieba.media;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements DialogInterface.OnClickListener {
    final /* synthetic */ MediaDownloadHelper a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MediaDownloadHelper mediaDownloadHelper) {
        this.a = mediaDownloadHelper;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.d();
    }
}
