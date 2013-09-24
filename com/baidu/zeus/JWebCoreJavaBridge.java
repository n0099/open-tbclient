package com.baidu.zeus;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.HashMap;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class JWebCoreJavaBridge extends Handler {
    private static final int FUNCPTR_MESSAGE = 2;
    private static final String LOGTAG = "webkit-timers";
    static final int REFRESH_PLUGINS = 100;
    private static final int TIMER_MESSAGE = 1;
    private HashMap<String, String> mContentUriToFilePathMap;
    private WebView mCurrentMainWebView;
    private boolean mHasDeferredTimers;
    private boolean mHasInstantTimer;
    private int mNativeBridge;
    private int mPauseTimerRefCount;
    private boolean mTimerPaused;

    private native void nativeConstructor();

    private native void nativeFinalize();

    private native void nativeServiceFuncPtrQueue();

    private native void nativeUpdatePluginDirectories(String[] strArr, boolean z);

    private native void sharedTimerFired();

    public native void addPackageName(String str);

    public native void addPackageNames(Set<String> set);

    public native void nativeUpdateProxy(String str, String str2);

    public native void removePackageName(String str);

    public native void setCacheSize(int i);

    public native void setNetworkOnLine(boolean z);

    public native void setNetworkType(String str, String str2);

    public JWebCoreJavaBridge() {
        nativeConstructor();
    }

    protected void finalize() {
        nativeFinalize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void setActiveWebView(WebView webView) {
        if (this.mCurrentMainWebView == null) {
            this.mCurrentMainWebView = webView;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void removeActiveWebView(WebView webView) {
        if (this.mCurrentMainWebView == webView) {
            this.mCurrentMainWebView = null;
        }
    }

    private void fireSharedTimer() {
        PerfChecker perfChecker = new PerfChecker();
        this.mHasInstantTimer = false;
        sharedTimerFired();
        perfChecker.responseAlert("sharedTimer");
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (this.mTimerPaused) {
                    this.mHasDeferredTimers = true;
                    return;
                } else {
                    fireSharedTimer();
                    return;
                }
            case 2:
                nativeServiceFuncPtrQueue();
                return;
            case 100:
                nativeUpdatePluginDirectories(PluginManager.getInstance(null).getPluginDirectories(), ((Boolean) message.obj).booleanValue());
                return;
            default:
                return;
        }
    }

    private void signalServiceFuncPtrQueue() {
        sendMessage(obtainMessage(2));
    }

    public void pause() {
        int i = this.mPauseTimerRefCount - 1;
        this.mPauseTimerRefCount = i;
        if (i == 0) {
            this.mTimerPaused = true;
            this.mHasDeferredTimers = false;
        }
    }

    public void resume() {
        int i = this.mPauseTimerRefCount + 1;
        this.mPauseTimerRefCount = i;
        if (i == 1) {
            this.mTimerPaused = false;
            if (this.mHasDeferredTimers) {
                this.mHasDeferredTimers = false;
                fireSharedTimer();
            }
        }
    }

    private void setCookies(String str, String str2) {
        if (str2.contains("\r") || str2.contains("\n")) {
            int length = str2.length();
            StringBuilder sb = new StringBuilder(length);
            int i = 0;
            while (true) {
                if (i == -1 || i >= length) {
                    break;
                }
                int indexOf = str2.indexOf(13, i);
                int indexOf2 = str2.indexOf(10, i);
                if (indexOf != -1) {
                    if (indexOf2 == -1) {
                        indexOf2 = indexOf;
                    } else if (indexOf < indexOf2) {
                        indexOf2 = indexOf;
                    }
                }
                if (indexOf2 > i) {
                    sb.append(str2.subSequence(i, indexOf2));
                } else if (indexOf2 == -1) {
                    sb.append(str2.subSequence(i, length));
                    break;
                }
                i = indexOf2 + 1;
            }
            str2 = sb.toString();
        }
        CookieManager.getInstance().setCookie(str, str2);
    }

    private String cookies(String str) {
        return CookieManager.getInstance().getCookie(str);
    }

    private boolean cookiesEnabled() {
        return CookieManager.getInstance().acceptCookie();
    }

    private String[] getPluginDirectories() {
        return PluginManager.getInstance(null).getPluginDirectories();
    }

    private String getPluginSharedDataDirectory() {
        return PluginManager.getInstance(null).getPluginSharedDataDirectory();
    }

    private void setSharedTimer(long j) {
        if (j <= 0) {
            if (!this.mHasInstantTimer) {
                this.mHasInstantTimer = true;
                sendMessageDelayed(obtainMessage(1), j);
                return;
            }
            return;
        }
        sendMessageDelayed(obtainMessage(1), j);
    }

    private void stopSharedTimer() {
        removeMessages(1);
        this.mHasInstantTimer = false;
        this.mHasDeferredTimers = false;
    }

    private String[] getKeyStrengthList() {
        return CertTool.getKeyStrengthList();
    }

    private synchronized String getSignedPublicKey(int i, String str, String str2) {
        String str3;
        if (this.mCurrentMainWebView != null) {
            str3 = CertTool.getSignedPublicKey(this.mCurrentMainWebView.getContext(), i, str);
        } else {
            Log.e(LOGTAG, "There is no active WebView for getSignedPublicKey");
            str3 = "";
        }
        return str3;
    }

    public void updateProxy(ProxyProperties proxyProperties) {
        if (proxyProperties == null) {
            nativeUpdateProxy("", "");
            return;
        }
        String host = proxyProperties.getHost();
        int port = proxyProperties.getPort();
        if (port != 0) {
            host = host + ":" + port;
        }
        nativeUpdateProxy(host, proxyProperties.getExclusionList());
    }

    private String resolveFilePathForContentUri(String str) {
        String str2;
        return (this.mContentUriToFilePathMap == null || (str2 = this.mContentUriToFilePathMap.get(str)) == null) ? Uri.parse(str).getLastPathSegment() : str2;
    }

    public void storeFilePathForContentUri(String str, String str2) {
        if (this.mContentUriToFilePathMap == null) {
            this.mContentUriToFilePathMap = new HashMap<>();
        }
        this.mContentUriToFilePathMap.put(str2, str);
    }
}
