package com.baidu.zeus;

import android.app.ActivityManager;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import android.view.WindowManager;
import com.baidu.zeus.WebView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.harmony.security.provider.cert.X509CertImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class BrowserFrame extends Handler {
    private static final int DRAWABLEDIR = 3;
    private static final int ERROR_PAGE = 7;
    private static final int FILE_UPLOAD_LABEL = 4;
    static final int FRAME_COMPLETED = 1001;
    static final int FRAME_LOADTYPE_BACK = 1;
    static final int FRAME_LOADTYPE_FORWARD = 2;
    static final int FRAME_LOADTYPE_INDEXEDBACKFORWARD = 3;
    static final int FRAME_LOADTYPE_REDIRECT = 7;
    static final int FRAME_LOADTYPE_RELOAD = 4;
    static final int FRAME_LOADTYPE_RELOADALLOWINGSTALEDATA = 5;
    static final int FRAME_LOADTYPE_REPLACE = 8;
    static final int FRAME_LOADTYPE_SAME = 6;
    static final int FRAME_LOADTYPE_STANDARD = 0;
    private static final int LOADERROR = 2;
    private static final String LOGTAG = "webkit";
    private static final int MAX_OUTSTANDING_REQUESTS = 300;
    private static final int NODOMAIN = 1;
    static final int ORIENTATION_CHANGED = 1002;
    static final int POLICY_FUNCTION = 1003;
    static final int POLICY_IGNORE = 2;
    static final int POLICY_USE = 0;
    private static final int RESET_LABEL = 5;
    private static final int SUBMIT_LABEL = 6;
    private static final int TRANSITION_SWITCH_THRESHOLD = 75;
    static WebView.PageType mType;
    static ConfigCallback sConfigCallback;
    static JWebCoreJavaBridge sJavaBridge;
    private final CallbackProxy mCallbackProxy;
    private final Context mContext;
    private final WebViewDatabase mDatabase;
    private boolean mIsMainFrame;
    private Map<String, Object> mJSInterfaceMap;
    boolean mLoadInitFromJava;
    private int mLoadType;
    private LoadListener mMainLoadListener;
    int mNativeFrame;
    private final WebSettings mSettings;
    private final WebViewCore mWebViewCore;
    static boolean mUserClick = false;
    static String DESKTOP_USERAGENT = "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN) AppleWebKit/531.1 (KHTML, like Gecko) Version/5.0 Safari/531.1";
    private boolean mFirstLayoutDone = true;
    private boolean mCommitted = true;
    private boolean mBlockMessages = false;
    private KeyStoreHandler mKeyStoreHandler = null;

    private native String documentAsText();

    private native String externalRepresentation();

    private native HashMap getFormTextData();

    private native String[] getUsernamePassword();

    private native boolean hasPasswordField();

    private native void nativeAddJavascriptInterface(int i, Object obj, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeAuthenticationCancel(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeAuthenticationProceed(int i, String str, String str2);

    private native void nativeCallPolicyFunction(int i, int i2);

    private native void nativeCreateFrame(WebViewCore webViewCore, AssetManager assetManager, WebBackForwardList webBackForwardList);

    private native void nativeGoBackOrForward(int i);

    private native void nativeLoadData(String str, String str2, String str3, String str4, String str5);

    private native void nativeLoadUrl(String str, Map<String, String> map);

    private native void nativeOrientationChanged(int i);

    private native void nativePostUrl(String str, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSslCertErrorCancel(int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSslCertErrorProceed(int i);

    private native void nativeStopLoading();

    private native void setCacheDisabled(boolean z);

    private native void setUsernamePassword(String str, String str2);

    public native boolean cacheDisabled();

    public native void clearCache();

    public native boolean documentHasImages();

    public native void nativeDestroyFrame();

    public native void nativeExitFullScreenMode();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void nativeSslClientCert(int i, byte[] bArr, byte[][] bArr2);

    public native void reload(boolean z);

    public native String stringByEvaluatingJavaScriptFromString(String str);

    public WebSettings getWebSettings() {
        return this.mSettings;
    }

    /* loaded from: classes.dex */
    class ConfigCallback implements ComponentCallbacks {
        private final ArrayList<WeakReference<Handler>> mHandlers = new ArrayList<>();
        private final WindowManager mWindowManager;

        ConfigCallback(WindowManager windowManager) {
            this.mWindowManager = windowManager;
        }

        public synchronized void addHandler(Handler handler) {
            this.mHandlers.add(new WeakReference<>(handler));
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            int i;
            if (this.mHandlers.size() != 0) {
                int orientation = this.mWindowManager.getDefaultDisplay().getOrientation();
                switch (orientation) {
                    case 0:
                        i = 0;
                        break;
                    case 1:
                        i = 90;
                        break;
                    case 2:
                        i = 180;
                        break;
                    case 3:
                        i = -90;
                        break;
                    default:
                        i = orientation;
                        break;
                }
                synchronized (this) {
                    ArrayList arrayList = new ArrayList(this.mHandlers.size());
                    Iterator<WeakReference<Handler>> it = this.mHandlers.iterator();
                    while (it.hasNext()) {
                        WeakReference<Handler> next = it.next();
                        Handler handler = next.get();
                        if (handler != null) {
                            handler.sendMessage(handler.obtainMessage(BrowserFrame.ORIENTATION_CHANGED, i, 0));
                        } else {
                            arrayList.add(next);
                        }
                    }
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        this.mHandlers.remove((WeakReference) it2.next());
                    }
                }
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }
    }

    public BrowserFrame(Context context, WebViewCore webViewCore, CallbackProxy callbackProxy, WebSettings webSettings, Map<String, Object> map) {
        Context applicationContext = context.getApplicationContext();
        if (sJavaBridge == null) {
            sJavaBridge = new JWebCoreJavaBridge();
            if (((ActivityManager) context.getSystemService("activity")).getMemoryClass() > 16) {
                sJavaBridge.setCacheSize(8388608);
            } else {
                sJavaBridge.setCacheSize(4194304);
            }
            CacheManager.init(applicationContext);
            CookieSyncManager.createInstance(applicationContext);
            PluginManager.getInstance(applicationContext);
            PreLoadManager.init(context);
        }
        if (sConfigCallback == null) {
            sConfigCallback = new ConfigCallback((WindowManager) context.getSystemService("window"));
        }
        sConfigCallback.addHandler(this);
        this.mJSInterfaceMap = map;
        this.mSettings = webSettings;
        this.mContext = context;
        this.mCallbackProxy = callbackProxy;
        this.mDatabase = WebViewDatabase.getInstance(applicationContext);
        this.mWebViewCore = webViewCore;
        nativeCreateFrame(webViewCore, context.getAssets(), callbackProxy.getBackForwardList());
    }

    public void loadUrl(String str, Map<String, String> map) {
        this.mLoadInitFromJava = true;
        if (URLUtil.isJavaScriptUrl(str)) {
            stringByEvaluatingJavaScriptFromString(str.substring("javascript:".length()));
        } else {
            nativeLoadUrl(str, map);
        }
        this.mLoadInitFromJava = false;
    }

    public void setPageType(WebView.PageType pageType) {
        mType = pageType;
    }

    public void postUrl(String str, byte[] bArr) {
        this.mLoadInitFromJava = true;
        nativePostUrl(str, bArr);
        this.mLoadInitFromJava = false;
    }

    public void loadData(String str, String str2, String str3, String str4, String str5) {
        this.mLoadInitFromJava = true;
        String str6 = (str5 == null || str5.length() == 0) ? "about:blank" : str5;
        nativeLoadData((str == null || str.length() == 0) ? "about:blank" : str, str2 == null ? "" : str2, (str3 == null || str3.length() == 0) ? "text/html" : str3, str4, str6);
        this.mLoadInitFromJava = false;
    }

    public void goBackOrForward(int i) {
        this.mLoadInitFromJava = true;
        nativeGoBackOrForward(i);
        this.mLoadInitFromJava = false;
    }

    private void reportError(int i, String str, String str2) {
        resetLoadingStates();
        this.mCallbackProxy.onReceivedError(i, str, str2);
    }

    private void resetLoadingStates() {
        this.mCommitted = true;
        this.mFirstLayoutDone = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean committed() {
        return this.mCommitted;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean firstLayoutDone() {
        return this.mFirstLayoutDone;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int loadType() {
        return this.mLoadType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void didFirstLayout() {
        if (!this.mFirstLayoutDone) {
            this.mFirstLayoutDone = true;
            this.mWebViewCore.contentDraw();
        }
    }

    private void loadStarted(String str, Bitmap bitmap, int i, boolean z) {
        WebHistoryItem currentItem;
        String url;
        this.mIsMainFrame = z;
        if (z || i == 0) {
            this.mLoadType = i;
            if (z) {
                this.mCallbackProxy.onPageStarted(str, bitmap);
                this.mWebViewCore.initialLastSubjectRectSize();
                this.mFirstLayoutDone = false;
                this.mCommitted = false;
                this.mWebViewCore.removeMessages(130);
            }
            if (i == 0 && this.mSettings.getSaveFormData() && (currentItem = this.mCallbackProxy.getBackForwardList().getCurrentItem()) != null && (url = currentItem.getUrl()) != null) {
                this.mDatabase.setFormData(url, getFormTextData());
            }
        }
    }

    private void transitionToCommitted(int i, boolean z) {
        if (z) {
            this.mCommitted = true;
            this.mWebViewCore.getWebView().mViewManager.postResetStateAll();
        }
    }

    private boolean isBaiduSearch(String str) {
        String lowerCase = str.toLowerCase();
        return (lowerCase.startsWith("http://www.baidu.com/s?") && lowerCase.indexOf("wd=") != -1) || (lowerCase.startsWith("http://video.baidu.com/v?") && lowerCase.indexOf("word=") != -1) || ((lowerCase.startsWith("http://mp3.baidu.com/m?") && lowerCase.indexOf("word=") != -1) || ((lowerCase.startsWith("http://news.baidu.com/ns?") && lowerCase.indexOf("word=") != -1) || ((lowerCase.startsWith("http://image.baidu.com/i?") && lowerCase.indexOf("word=") != -1) || lowerCase.startsWith("http://www.baidu.com/baidu?q1=") || ((lowerCase.startsWith("http://tieba.baidu.com/f?") && lowerCase.indexOf("kw=") != -1) || ((lowerCase.startsWith("http://tieba.baidu.com/f?") && lowerCase.indexOf("word=") != -1) || ((lowerCase.startsWith("http://zhidao.baidu.com/q?") && lowerCase.indexOf("word=") != -1) || ((lowerCase.startsWith("http://wap.baidu.com/") && lowerCase.indexOf("word=") != -1) || ((lowerCase.startsWith("http://m.baidu.com/") && lowerCase.indexOf("word=") != -1) || ((lowerCase.startsWith("http://wapiknow.baidu.com/index") && lowerCase.indexOf("word=") != -1) || ((lowerCase.startsWith("http://news.baidu.com/i") && lowerCase.indexOf("word=") != -1) || ((lowerCase.startsWith("http://wapp.baidu.com/") && lowerCase.indexOf("word=") != -1) || (lowerCase.startsWith("http://youxi.m.baidu.com/") && lowerCase.indexOf("gamename=") != -1))))))))))));
    }

    private void updateCacheFile(String str, int i, boolean z) {
        if (z && this.mMainLoadListener != null && this.mMainLoadListener.pageType() == WebView.PageType.DesktopType) {
            WebViewWorker.getHandler().obtainMessage(114, this.mMainLoadListener).sendToTarget();
        }
    }

    private void loadFinished(String str, int i, boolean z) {
        if ((z || i == 0) && z) {
            resetLoadingStates();
            this.mCallbackProxy.switchOutDrawHistory();
            this.mCallbackProxy.onPageFinished(str);
            this.mSettings.markSubjectEnabled();
            boolean collectMainAction = this.mSettings.collectMainAction();
            if (collectMainAction) {
                this.mCallbackProxy.onMainActionsCollected(collectMainAction);
            }
            if (isBaiduSearch(str)) {
                this.mCallbackProxy.onBaiduSearchPVCollected();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void certificate(SslCertificate sslCertificate) {
        if (this.mIsMainFrame) {
            this.mCallbackProxy.onReceivedCertificate(sslCertificate);
        }
    }

    public void destroy() {
        nativeDestroyFrame();
        this.mBlockMessages = true;
        removeCallbacksAndMessages(null);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        WebHistoryItem currentItem;
        if (!this.mBlockMessages) {
            switch (message.what) {
                case FRAME_COMPLETED /* 1001 */:
                    if (this.mSettings.getSavePassword() && hasPasswordField() && (currentItem = this.mCallbackProxy.getBackForwardList().getCurrentItem()) != null) {
                        WebAddress webAddress = new WebAddress(currentItem.getUrl());
                        String[] usernamePassword = this.mDatabase.getUsernamePassword(webAddress.mScheme + webAddress.mHost);
                        if (usernamePassword != null && usernamePassword[0] != null) {
                            setUsernamePassword(usernamePassword[0], usernamePassword[1]);
                        }
                    }
                    if (!JniUtil.useChromiumHttpStack()) {
                        WebViewWorker.getHandler().sendEmptyMessage(108);
                        return;
                    }
                    return;
                case ORIENTATION_CHANGED /* 1002 */:
                    nativeOrientationChanged(message.arg1);
                    return;
                case POLICY_FUNCTION /* 1003 */:
                    nativeCallPolicyFunction(message.arg1, message.arg2);
                    return;
                default:
                    return;
            }
        }
    }

    private void setTitle(String str) {
        this.mCallbackProxy.onReceivedTitle(str);
    }

    public void externalRepresentation(Message message) {
        message.obj = externalRepresentation();
        message.sendToTarget();
    }

    public void documentAsText(Message message) {
        message.obj = documentAsText();
        message.sendToTarget();
    }

    private void windowObjectCleared(int i) {
        if (this.mJSInterfaceMap != null) {
            for (String str : this.mJSInterfaceMap.keySet()) {
                nativeAddJavascriptInterface(i, this.mJSInterfaceMap.get(str), str);
            }
        }
    }

    public boolean didFullScreenMode(boolean z, int i, int i2) {
        this.mCallbackProxy.onFullScreenMode(z, i, i2);
        this.mWebViewCore.didFullScreenMode(z);
        return true;
    }

    public void exitFullScreenMode() {
        nativeExitFullScreenMode();
    }

    public boolean handleFlash(String str) {
        return this.mCallbackProxy.shouldOpenFlash(str);
    }

    public boolean handleUrl(String str) {
        if (!this.mLoadInitFromJava || mUserClick) {
            if (mUserClick) {
                mUserClick = false;
            }
            if (this.mCallbackProxy.shouldOverrideUrlLoading(str)) {
                didFirstLayout();
                return true;
            }
            return false;
        }
        return false;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.mJSInterfaceMap == null) {
            this.mJSInterfaceMap = new HashMap();
        }
        if (this.mJSInterfaceMap.containsKey(str)) {
            this.mJSInterfaceMap.remove(str);
        }
        this.mJSInterfaceMap.put(str, obj);
    }

    private int getFileSize(String str) {
        int i = 0;
        try {
            InputStream openInputStream = this.mContext.getContentResolver().openInputStream(Uri.parse(str));
            i = openInputStream.available();
            openInputStream.close();
            return i;
        } catch (Exception e) {
            return i;
        }
    }

    private int getFile(String str, byte[] bArr, int i, int i2) {
        try {
            InputStream openInputStream = this.mContext.getContentResolver().openInputStream(Uri.parse(str));
            int available = openInputStream.available();
            if (available > i2 || bArr == null || bArr.length - i < available) {
                available = 0;
            } else {
                openInputStream.read(bArr, i, available);
            }
            openInputStream.close();
            return available;
        } catch (FileNotFoundException e) {
            Log.e(LOGTAG, "FileNotFoundException:" + e);
            return 0;
        } catch (IOException e2) {
            Log.e(LOGTAG, "IOException: " + e2);
            return 0;
        }
    }

    private InputStream inputStreamForAndroidResource(String str) {
        InputStream inputStream = null;
        if (str.startsWith("file:///android_res/")) {
            String replaceFirst = str.replaceFirst("file:///android_res/", "");
            if (replaceFirst == null || replaceFirst.length() == 0) {
                Log.e(LOGTAG, "url has length 0 " + replaceFirst);
                return null;
            }
            int indexOf = replaceFirst.indexOf(47);
            int indexOf2 = replaceFirst.indexOf(46, indexOf);
            if (indexOf == -1 || indexOf2 == -1) {
                Log.e(LOGTAG, "Incorrect res path: " + replaceFirst);
                return null;
            }
            String substring = replaceFirst.substring(0, indexOf);
            try {
                int i = this.mContext.getApplicationContext().getClassLoader().loadClass(this.mContext.getPackageName() + ".R$" + substring).getField(replaceFirst.substring(indexOf + 1, indexOf2)).getInt(null);
                TypedValue typedValue = new TypedValue();
                this.mContext.getResources().getValue(i, typedValue, true);
                if (typedValue.type == 3) {
                    inputStream = this.mContext.getAssets().openNonAsset(typedValue.assetCookie, typedValue.string.toString(), 2);
                } else {
                    Log.e(LOGTAG, "not of type string: " + replaceFirst);
                }
                return inputStream;
            } catch (Exception e) {
                Log.e(LOGTAG, "Exception: " + replaceFirst);
                return inputStream;
            }
        } else if (str.startsWith("file:///android_asset/")) {
            try {
                return this.mContext.getAssets().open(str.replaceFirst("file:///android_asset/", ""), 2);
            } catch (Exception e2) {
                return null;
            }
        } else if (this.mSettings.getAllowContentAccess() && str.startsWith("content:")) {
            try {
                int lastIndexOf = str.lastIndexOf(63);
                if (lastIndexOf != -1) {
                    str = str.substring(0, lastIndexOf);
                }
                return this.mContext.getContentResolver().openInputStream(Uri.parse(str));
            } catch (Exception e3) {
                Log.e(LOGTAG, "Exception: " + str);
                return null;
            }
        } else {
            return null;
        }
    }

    private LoadListener startLoadingResource(int i, String str, String str2, HashMap hashMap, byte[] bArr, long j, int i2, boolean z, boolean z2, boolean z3, String str3, String str4, boolean z4) {
        long j2;
        long j3;
        PerfChecker perfChecker = new PerfChecker();
        if (this.mSettings.getCacheMode() != -1) {
            i2 = this.mSettings.getCacheMode();
        }
        if (str2.equals("POST")) {
            if (i2 == 0) {
                i2 = 2;
            }
            String[] usernamePassword = getUsernamePassword();
            if (usernamePassword != null) {
                maybeSavePassword(bArr, usernamePassword[0], usernamePassword[1]);
            }
        }
        boolean z5 = this.mIsMainFrame;
        WebView.PageType pageType = mType;
        if (WebView.PageType.DesktopType == pageType) {
            if (this.mSettings.getUserAgentString() == DESKTOP_USERAGENT) {
                j3 = -1;
            } else {
                j3 = -2;
            }
            mType = WebView.PageType.NormalType;
            j2 = j3;
        } else {
            j2 = j;
        }
        LoadListener loadListener = LoadListener.getLoadListener(this.mContext, this, str, i, z3, z5, z, z2, j2, str3, str4, pageType);
        loadListener.setIsImageResource(z4);
        if (z) {
            this.mMainLoadListener = loadListener;
        }
        this.mCallbackProxy.onLoadResource(str);
        if (LoadListener.getNativeLoaderCount() > MAX_OUTSTANDING_REQUESTS) {
            loadListener.error(-1, "Too many requests are being processed. Try again later.");
            return loadListener;
        }
        FrameLoader frameLoader = new FrameLoader(loadListener, this.mSettings, str2);
        frameLoader.setHeaders(hashMap);
        frameLoader.setPostData(bArr);
        frameLoader.setCacheMode((hashMap.containsKey("If-Modified-Since") || hashMap.containsKey("If-None-Match")) ? 2 : 2);
        if (!frameLoader.executeLoad()) {
            perfChecker.responseAlert("startLoadingResource fail");
        }
        perfChecker.responseAlert("startLoadingResource succeed");
        if (z3) {
            return null;
        }
        return loadListener;
    }

    private void maybeSavePassword(byte[] bArr, String str, String str2) {
        if (bArr != null && str != null && str.length() != 0 && str2 != null && str2.length() != 0 && this.mSettings.getSavePassword()) {
            try {
                WebAddress webAddress = new WebAddress(this.mCallbackProxy.getBackForwardList().getCurrentItem().getUrl());
                String str3 = webAddress.getScheme() + webAddress.getHost();
                String str4 = new String(bArr);
                if (str4.contains(URLEncoder.encode(str)) && str4.contains(URLEncoder.encode(str2))) {
                    String[] usernamePassword = this.mDatabase.getUsernamePassword(str3);
                    if (usernamePassword != null) {
                        if (usernamePassword[0] != null) {
                            this.mDatabase.setUsernamePassword(str3, str, str2);
                        }
                    } else {
                        this.mCallbackProxy.onSavePassword(str3, str, str2, null);
                    }
                }
            } catch (ParseException e) {
            }
        }
    }

    private WebResourceResponse shouldInterceptRequest(String str) {
        InputStream inputStreamForAndroidResource = inputStreamForAndroidResource(str);
        if (inputStreamForAndroidResource != null) {
            return new WebResourceResponse(null, null, inputStreamForAndroidResource);
        }
        WebResourceResponse shouldInterceptRequest = this.mCallbackProxy.shouldInterceptRequest(str);
        if (shouldInterceptRequest == null && "browser:incognito".equals(str)) {
            Log.v(LOGTAG, "ERROR in WebResourceResponse shouldInterceptRequest browser:incognito");
            return shouldInterceptRequest;
        }
        return shouldInterceptRequest;
    }

    private void setProgress(int i) {
        this.mCallbackProxy.onProgressChanged(i);
        if (i == 100) {
            sendMessageDelayed(obtainMessage(FRAME_COMPLETED), 100L);
        }
        if (this.mFirstLayoutDone && i > TRANSITION_SWITCH_THRESHOLD) {
            this.mCallbackProxy.switchOutDrawHistory();
        }
    }

    private void didReceiveIcon(Bitmap bitmap) {
        this.mCallbackProxy.onReceivedIcon(bitmap);
    }

    private void didReceiveTouchIconUrl(String str, boolean z) {
        this.mCallbackProxy.onReceivedTouchIconUrl(str, z);
    }

    private BrowserFrame createWindow(boolean z, boolean z2) {
        WebView createWindow = this.mCallbackProxy.createWindow(z, z2);
        if (createWindow == null || createWindow.getWebViewCore() == null) {
            return null;
        }
        return createWindow.getWebViewCore().getBrowserFrame();
    }

    private void requestFocus() {
        this.mCallbackProxy.onRequestFocus();
    }

    private void closeWindow(WebViewCore webViewCore) {
        this.mCallbackProxy.onCloseWindow(webViewCore.getWebView());
    }

    private void decidePolicyForFormResubmission(int i) {
        this.mCallbackProxy.onFormResubmission(obtainMessage(POLICY_FUNCTION, i, 2), obtainMessage(POLICY_FUNCTION, i, 0));
    }

    private void updateVisitedHistory(String str, boolean z) {
        this.mCallbackProxy.doUpdateVisitedHistory(str, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallbackProxy getCallbackProxy() {
        return this.mCallbackProxy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUserAgentString() {
        return this.mSettings.getUserAgentString();
    }

    String getRawResFilename(int i) {
        int drawableId;
        switch (i) {
            case 1:
                drawableId = 17563650;
                break;
            case 2:
                drawableId = 17563649;
                break;
            case 3:
                drawableId = WebKitInit.drawableId();
                break;
            case 4:
                try {
                    return this.mContext.getResources().getString(this.mContext.getResources().getIdentifier("zeus_file_upload", "string", this.mContext.getPackageName()));
                } catch (Exception e) {
                    return "choose file";
                }
            case 5:
                try {
                    return this.mContext.getResources().getString(this.mContext.getResources().getIdentifier("zeus_reset", "string", this.mContext.getPackageName()));
                } catch (Exception e2) {
                    return "reset";
                }
            case 6:
                try {
                    return this.mContext.getResources().getString(this.mContext.getResources().getIdentifier("zeus_submit", "string", this.mContext.getPackageName()));
                } catch (Exception e3) {
                    return "submit";
                }
            case 7:
                if (this.mCallbackProxy != null) {
                    return this.mCallbackProxy.getStringById(7);
                }
                return "";
            default:
                Log.e(LOGTAG, "getRawResFilename got incompatible resource ID");
                return "";
        }
        TypedValue typedValue = new TypedValue();
        this.mContext.getResources().getValue(drawableId, typedValue, true);
        if (i == 3) {
            String obj = typedValue.string.toString();
            int lastIndexOf = obj.lastIndexOf(47);
            if (lastIndexOf < 0) {
                Log.e(LOGTAG, "Can't find drawable directory.");
                return "";
            }
            return obj.substring(0, lastIndexOf + 1);
        }
        return typedValue.string.toString();
    }

    private float density() {
        return this.mContext.getResources().getDisplayMetrics().density;
    }

    private void didReceiveAuthenticationChallenge(final int i, String str, String str2, final boolean z, final boolean z2) {
        this.mCallbackProxy.onReceivedHttpAuthRequest(new HttpAuthHandler(null) { // from class: com.baidu.zeus.BrowserFrame.1
            @Override // com.baidu.zeus.HttpAuthHandler
            public boolean useHttpAuthUsernamePassword() {
                return z;
            }

            @Override // com.baidu.zeus.HttpAuthHandler
            public void proceed(String str3, String str4) {
                BrowserFrame.this.nativeAuthenticationProceed(i, str3, str4);
            }

            @Override // com.baidu.zeus.HttpAuthHandler
            public void cancel() {
                BrowserFrame.this.nativeAuthenticationCancel(i);
            }

            @Override // com.baidu.zeus.HttpAuthHandler
            public boolean suppressDialog() {
                return z2;
            }
        }, str, str2);
    }

    private void reportSslCertError(final int i, final int i2, byte[] bArr, String str) {
        try {
            final SslError SslErrorFromChromiumErrorCode = SslError.SslErrorFromChromiumErrorCode(i2, new SslCertificate(new X509CertImpl(bArr)), str);
            if (SslCertLookupTable.getInstance().isAllowed(SslErrorFromChromiumErrorCode)) {
                nativeSslCertErrorProceed(i);
                this.mCallbackProxy.onProceededAfterSslError(SslErrorFromChromiumErrorCode);
                return;
            }
            this.mCallbackProxy.onReceivedSslError(new SslErrorHandler() { // from class: com.baidu.zeus.BrowserFrame.2
                @Override // com.baidu.zeus.SslErrorHandler
                public void proceed() {
                    SslCertLookupTable.getInstance().setIsAllowed(SslErrorFromChromiumErrorCode);
                    BrowserFrame.this.nativeSslCertErrorProceed(i);
                }

                @Override // com.baidu.zeus.SslErrorHandler
                public void cancel() {
                    BrowserFrame.this.nativeSslCertErrorCancel(i, i2);
                }
            }, SslErrorFromChromiumErrorCode);
        } catch (Exception e) {
            Log.e(LOGTAG, "Can't get the certificate from WebKit, canceling");
            nativeSslCertErrorCancel(i, i2);
        }
    }

    private void requestClientCert(int i, String str) {
        SslClientCertLookupTable sslClientCertLookupTable = SslClientCertLookupTable.getInstance();
        if (sslClientCertLookupTable.IsAllowed(str)) {
            nativeSslClientCert(i, sslClientCertLookupTable.PrivateKey(str), sslClientCertLookupTable.CertificateChain(str));
        } else if (sslClientCertLookupTable.IsDenied(str)) {
            nativeSslClientCert(i, null, null);
        } else {
            this.mCallbackProxy.onReceivedClientCertRequest(new ClientCertRequestHandler(this, i, str, sslClientCertLookupTable), str);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:15:0x0041
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private void downloadStart(java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, long r12) {
        /*
            r7 = this;
            int r0 = r11.length()
            if (r0 != 0) goto L43
            r0 = 46
            int r0 = r8.lastIndexOf(r0)     // Catch: java.lang.IndexOutOfBoundsException -> L3e
            int r0 = r0 + 1
            java.lang.String r0 = r8.substring(r0)     // Catch: java.lang.IndexOutOfBoundsException -> L3e
            com.baidu.zeus.MimeTypeMap r1 = com.baidu.zeus.MimeTypeMap.getSingleton()     // Catch: java.lang.IndexOutOfBoundsException -> L3e
            java.lang.String r0 = r1.getMimeTypeFromExtension(r0)     // Catch: java.lang.IndexOutOfBoundsException -> L3e
            if (r0 != 0) goto L1e
            java.lang.String r0 = ""
        L1e:
            com.baidu.zeus.MimeTypeMap r1 = com.baidu.zeus.MimeTypeMap.getSingleton()
            java.lang.String r4 = r1.remapGenericMimeType(r0, r8, r10)
            java.lang.String r0 = com.baidu.zeus.CertTool.getCertType(r4)
            if (r0 == 0) goto L34
            com.baidu.zeus.KeyStoreHandler r0 = new com.baidu.zeus.KeyStoreHandler
            r0.<init>(r4)
            r7.mKeyStoreHandler = r0
        L33:
            return
        L34:
            com.baidu.zeus.CallbackProxy r0 = r7.mCallbackProxy
            r1 = r8
            r2 = r9
            r3 = r10
            r5 = r12
            r0.onDownloadStart(r1, r2, r3, r4, r5)
            goto L33
        L3e:
            r0 = move-exception
            r0 = r11
            goto L1e
        L41:
            r1 = move-exception
            goto L1e
        L43:
            r0 = r11
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.zeus.BrowserFrame.downloadStart(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long):void");
    }

    private void didReceiveData(byte[] bArr, int i) {
        if (this.mKeyStoreHandler != null) {
            this.mKeyStoreHandler.didReceiveData(bArr, i);
        }
    }

    private void didFinishLoading() {
        if (this.mKeyStoreHandler != null) {
            this.mKeyStoreHandler.installCert(this.mContext);
            this.mKeyStoreHandler = null;
        }
    }

    private void setCertificate(byte[] bArr) {
        try {
            this.mCallbackProxy.onReceivedCertificate(new SslCertificate(new X509CertImpl(bArr)));
        } catch (Exception e) {
            Log.e(LOGTAG, "Can't get the certificate from WebKit, canceling");
        }
    }

    private void autoLogin(String str, String str2, String str3) {
        this.mCallbackProxy.onReceivedLoginRequest(str, str2, str3);
    }

    private void startPreload(String str) {
        int hashCode = this.mSettings.hashCode();
        if (PreLoadManager.getInstance().removePreLoad(hashCode)) {
            new PreLoader(PreLoadListener.getLoadListener(this.mContext, str, hashCode), this.mSettings, "GET").executeLoad();
        }
    }

    public void stopLoading() {
        if (this.mIsMainFrame) {
            resetLoadingStates();
        }
        nativeStopLoading();
    }
}
