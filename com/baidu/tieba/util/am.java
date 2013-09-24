package com.baidu.tieba.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ al f1902a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar) {
        this.f1902a = alVar;
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        Context context;
        int i;
        String str2;
        MediaScannerConnection mediaScannerConnection;
        av.b(getClass().getName(), "MediaScannerConnectionClient", "onScanCompleted");
        al alVar = this.f1902a;
        context = al.e;
        i = this.f1902a.c;
        str2 = this.f1902a.d;
        alVar.a(context, i, str2, uri);
        mediaScannerConnection = this.f1902a.h;
        mediaScannerConnection.disconnect();
        this.f1902a.h = null;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        MediaScannerConnection mediaScannerConnection;
        File file;
        av.b(getClass().getName(), "MediaScannerConnectionClient", "onMediaScannerConnected");
        mediaScannerConnection = this.f1902a.h;
        file = this.f1902a.b;
        mediaScannerConnection.scanFile(file.getPath(), "image/*");
    }
}
