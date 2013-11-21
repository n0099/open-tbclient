package com.baidu.tieba.media;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class d implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaPlayerActivity f1819a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaPlayerActivity mediaPlayerActivity) {
        this.f1819a = mediaPlayerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1819a.b();
    }
}
