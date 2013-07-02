package com.baidu.tieba.media;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnClickListener {
    final /* synthetic */ MediaDownloadHelper a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MediaDownloadHelper mediaDownloadHelper) {
        this.a = mediaDownloadHelper;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.g();
    }
}
