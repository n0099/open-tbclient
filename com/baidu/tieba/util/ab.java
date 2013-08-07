package com.baidu.tieba.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aa f1745a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.f1745a = aaVar;
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        Context context;
        int i;
        String str2;
        MediaScannerConnection mediaScannerConnection;
        aj.b(getClass().getName(), "MediaScannerConnectionClient", "onScanCompleted");
        aa aaVar = this.f1745a;
        context = aa.e;
        i = this.f1745a.c;
        str2 = this.f1745a.d;
        aaVar.a(context, i, str2, uri);
        mediaScannerConnection = this.f1745a.h;
        mediaScannerConnection.disconnect();
        this.f1745a.h = null;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        MediaScannerConnection mediaScannerConnection;
        File file;
        aj.b(getClass().getName(), "MediaScannerConnectionClient", "onMediaScannerConnected");
        mediaScannerConnection = this.f1745a.h;
        file = this.f1745a.b;
        mediaScannerConnection.scanFile(file.getPath(), "image/*");
    }
}
