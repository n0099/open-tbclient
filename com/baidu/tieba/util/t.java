package com.baidu.tieba.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
/* loaded from: classes.dex */
public class t implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a  reason: collision with root package name */
    private MediaScannerConnection f1772a;
    private Context b;
    private String c;
    private String d;

    public t(Context context) {
        this.b = context;
    }

    public void a(String str) {
        this.c = str;
        this.d = "image/*";
        this.f1772a = new MediaScannerConnection(this.b, this);
        this.f1772a.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        this.f1772a.scanFile(this.c, this.d);
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        this.f1772a.disconnect();
    }
}
