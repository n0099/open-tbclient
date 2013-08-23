package com.baidu.tieba.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
/* loaded from: classes.dex */
public class u implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a  reason: collision with root package name */
    private MediaScannerConnection f1809a;
    private Context b;
    private String c;
    private String d;

    public u(Context context) {
        this.b = context;
    }

    public void a(String str) {
        this.c = str;
        this.d = "image/*";
        this.f1809a = new MediaScannerConnection(this.b, this);
        this.f1809a.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        this.f1809a.scanFile(this.c, this.d);
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        this.f1809a.disconnect();
    }
}
