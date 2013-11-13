package com.baidu.tieba.media;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaDownloadHelper f1830a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MediaDownloadHelper mediaDownloadHelper) {
        this.f1830a = mediaDownloadHelper;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1830a.d();
    }
}
