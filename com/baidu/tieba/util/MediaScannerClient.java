package com.baidu.tieba.util;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
/* loaded from: classes.dex */
public class MediaScannerClient implements MediaScannerConnection.MediaScannerConnectionClient {
    private MediaScannerConnection mConnection;
    private Context mContext;
    private String mMimeType;
    private String mPath;

    public MediaScannerClient(Context ctx) {
        this.mContext = ctx;
    }

    public void saveImage(String path) {
        this.mPath = path;
        this.mMimeType = "image/*";
        this.mConnection = new MediaScannerConnection(this.mContext, this);
        this.mConnection.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        this.mConnection.scanFile(this.mPath, this.mMimeType);
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String path, Uri uri) {
        this.mConnection.disconnect();
    }
}
