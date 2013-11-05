package com.baidu.tieba.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ au f2432a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(au auVar) {
        this.f2432a = auVar;
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        Context context;
        int i;
        String str2;
        MediaScannerConnection mediaScannerConnection;
        be.b(getClass().getName(), "MediaScannerConnectionClient", "onScanCompleted");
        au auVar = this.f2432a;
        context = au.e;
        i = this.f2432a.c;
        str2 = this.f2432a.d;
        auVar.a(context, i, str2, uri);
        mediaScannerConnection = this.f2432a.h;
        mediaScannerConnection.disconnect();
        this.f2432a.h = null;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        MediaScannerConnection mediaScannerConnection;
        File file;
        be.b(getClass().getName(), "MediaScannerConnectionClient", "onMediaScannerConnected");
        mediaScannerConnection = this.f2432a.h;
        file = this.f2432a.b;
        mediaScannerConnection.scanFile(file.getPath(), "image/*");
    }
}
