package com.baidu.zeus;

import android.content.Context;
import android.os.Bundle;
import com.baidu.loginshare.e;
import java.io.ByteArrayInputStream;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class Network {
    private static final String LOGTAG = "network";
    private static Network sNetwork;
    private static int sPlatformNotificationEnableRefCount;
    private static boolean sPlatformNotifications;
    private String mProxyPassword;
    private String mProxyUsername;
    private RequestQueue mRequestQueue;
    private SslErrorHandler mSslErrorHandler = new SslErrorHandler();
    private HttpAuthHandler mHttpAuthHandler = new HttpAuthHandler(this);

    public static synchronized Network getInstance(Context context) {
        Network network;
        synchronized (Network.class) {
            if (sNetwork == null) {
                sNetwork = new Network(context.getApplicationContext());
                if (sPlatformNotifications) {
                    sPlatformNotificationEnableRefCount--;
                    enablePlatformNotifications();
                }
            }
            network = sNetwork;
        }
        return network;
    }

    public static void enablePlatformNotifications() {
        int i = sPlatformNotificationEnableRefCount + 1;
        sPlatformNotificationEnableRefCount = i;
        if (i == 1) {
            if (sNetwork != null) {
                sNetwork.mRequestQueue.enablePlatformNotifications();
            } else {
                sPlatformNotifications = true;
            }
        }
    }

    public static void disablePlatformNotifications() {
        int i = sPlatformNotificationEnableRefCount - 1;
        sPlatformNotificationEnableRefCount = i;
        if (i == 0) {
            if (sNetwork != null) {
                sNetwork.mRequestQueue.disablePlatformNotifications();
            } else {
                sPlatformNotifications = false;
            }
        }
    }

    private Network(Context context) {
        this.mRequestQueue = new RequestQueue(context);
    }

    public boolean requestURL(String str, Map<String, String> map, byte[] bArr, LoadListener loadListener, boolean z) {
        int i = 0;
        String url = loadListener.url();
        if (!URLUtil.isValidUrl(url) || URLUtil.isAssetUrl(url) || URLUtil.isResourceUrl(url) || URLUtil.isFileUrl(url) || URLUtil.isDataUrl(url)) {
            return false;
        }
        ByteArrayInputStream byteArrayInputStream = null;
        if (bArr != null) {
            i = bArr.length;
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            NetworkStatistic.getInstance().addUploadLength(i);
        }
        WebAddress webAddress = loadListener.getWebAddress();
        boolean isImageResource = loadListener.isImageResource();
        if (z && isImageResource && !url.startsWith(e.g)) {
            map.put("tc-mode", "4");
            url = "http://f3.mi.baidu.com/folder_mod?url=" + url;
            webAddress = new WebAddress(url);
        }
        RequestQueue requestQueue = this.mRequestQueue;
        NetworkStatistic.getInstance().addUploadLength(url.length() + 286);
        if (loadListener.isSynchronous()) {
            RequestHandle queueSynchronousRequest = new RequestQueue(loadListener.getContext(), 1).queueSynchronousRequest(url, webAddress, str, map, loadListener, byteArrayInputStream, i);
            loadListener.attachRequestHandle(queueSynchronousRequest);
            queueSynchronousRequest.processRequest();
            loadListener.loadSynchronousMessages();
        } else {
            loadListener.attachRequestHandle(requestQueue.queueRequest(url, webAddress, str, map, loadListener, byteArrayInputStream, i));
        }
        return true;
    }

    public boolean requestURL(String str, Map<String, String> map, PreLoadListener preLoadListener) {
        String url = preLoadListener.url();
        WebAddress webAddress = preLoadListener.getWebAddress();
        if (URLUtil.isHttpUrl(url)) {
            NetworkStatistic.getInstance().addUploadLength(url.length() + 286);
            preLoadListener.attachRequestHandle(this.mRequestQueue.queueRequest(url, webAddress, str, map, preLoadListener, null, 0));
            return true;
        }
        return false;
    }

    public boolean isValidProxySet() {
        boolean z;
        synchronized (this.mRequestQueue) {
            z = this.mRequestQueue.getProxyHost() != null;
        }
        return z;
    }

    public String getProxyHostname() {
        return this.mRequestQueue.getProxyHost().getHostName();
    }

    public synchronized String getProxyUsername() {
        return this.mProxyUsername;
    }

    public synchronized void setProxyUsername(String str) {
        this.mProxyUsername = str;
    }

    public synchronized String getProxyPassword() {
        return this.mProxyPassword;
    }

    public synchronized void setProxyPassword(String str) {
        this.mProxyPassword = str;
    }

    public boolean saveState(Bundle bundle) {
        return this.mSslErrorHandler.saveState(bundle);
    }

    public boolean restoreState(Bundle bundle) {
        return this.mSslErrorHandler.restoreState(bundle);
    }

    public void clearUserSslPrefTable() {
        this.mSslErrorHandler.clear();
    }

    public void handleSslErrorRequest(LoadListener loadListener) {
        if (loadListener != null) {
            this.mSslErrorHandler.handleSslErrorRequest(loadListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean checkSslPrefTable(LoadListener loadListener, SslError sslError) {
        if (loadListener == null || sslError == null) {
            return false;
        }
        return this.mSslErrorHandler.checkSslPrefTable(loadListener, sslError);
    }

    public void handleAuthRequest(LoadListener loadListener) {
        if (loadListener != null) {
            this.mHttpAuthHandler.handleAuthRequest(loadListener);
        }
    }

    public void startTiming() {
        this.mRequestQueue.startTiming();
    }

    public void stopTiming() {
        this.mRequestQueue.stopTiming();
    }
}
