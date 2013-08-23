package com.baidu.tieba.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ah f1783a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.f1783a = ahVar;
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        Context context;
        int i;
        String str2;
        MediaScannerConnection mediaScannerConnection;
        aq.b(getClass().getName(), "MediaScannerConnectionClient", "onScanCompleted");
        ah ahVar = this.f1783a;
        context = ah.e;
        i = this.f1783a.c;
        str2 = this.f1783a.d;
        ahVar.a(context, i, str2, uri);
        mediaScannerConnection = this.f1783a.h;
        mediaScannerConnection.disconnect();
        this.f1783a.h = null;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        MediaScannerConnection mediaScannerConnection;
        File file;
        aq.b(getClass().getName(), "MediaScannerConnectionClient", "onMediaScannerConnected");
        mediaScannerConnection = this.f1783a.h;
        file = this.f1783a.b;
        mediaScannerConnection.scanFile(file.getPath(), "image/*");
    }
}
