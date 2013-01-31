package com.baidu.zeus;
/* loaded from: classes.dex */
public final class NetworkStatistic {
    private static NetworkStatistic sRef = null;
    private long uploadLength = 0;
    private long downloadLength = 0;

    private native int nativeGetNetworkVolume();

    private NetworkStatistic() {
    }

    public static synchronized NetworkStatistic getInstance() {
        NetworkStatistic networkStatistic;
        synchronized (NetworkStatistic.class) {
            if (sRef == null) {
                sRef = new NetworkStatistic();
            }
            networkStatistic = sRef;
        }
        return networkStatistic;
    }

    public void addUploadLength(long j) {
        this.uploadLength += j;
    }

    public long uploadLength() {
        return WebViewCore.GetNetworkUpload();
    }

    public void clearUploadLength() {
        this.uploadLength = 0L;
    }

    public void addDownloadLength(long j) {
        this.downloadLength += j;
    }

    public long downloadLength() {
        return WebViewCore.GetNetworkDownload();
    }

    public void clearDownloadLength() {
        this.downloadLength = 0L;
    }

    public void clear() {
        this.uploadLength = 0L;
        this.downloadLength = 0L;
    }
}
