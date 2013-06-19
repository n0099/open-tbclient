package com.baidu.tieba.media;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements DialogInterface.OnClickListener {
    final /* synthetic */ MediaPlayerActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(MediaPlayerActivity mediaPlayerActivity) {
        this.a = mediaPlayerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.finish();
    }
}
