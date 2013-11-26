package com.baidu.tieba.media;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class e implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaPlayerActivity f1820a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaPlayerActivity mediaPlayerActivity) {
        this.f1820a = mediaPlayerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1820a.finish();
    }
}
