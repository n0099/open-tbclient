package com.baidu.tieba.media;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaPlayerActivity f1933a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaPlayerActivity mediaPlayerActivity) {
        this.f1933a = mediaPlayerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1933a.finish();
    }
}
