package com.baidu.zeus;

import android.util.Log;
import com.baidu.cyberplayer.sdk.internal.HttpUtils;
import com.baidu.zeus.CacheManager;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
class FrameLoader {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final String CONTENT_TYPE = "content-type";
    static final String HEADER_STR = "text/xml, text/html, application/xhtml+xml, image/png, text/plain, */*;q=0.8";
    private static final String IPHONE_UA = "Mozilla/5.0 (iPhone; CPU iPhone OS 5_1 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9B176 Safari/7534.48.3";
    private static final String LOGTAG = "webkit";
    private static final int URI_PROTOCOL = 256;
    private static final String mAboutBlank = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EB\"><html><head><title>about:blank</title></head><body></body></html>";
    private int mCacheMode;
    private String mContentType;
    private Map<String, String> mHeaders;
    private final LoadListener mListener;
    private final String mMethod;
    private Network mNetwork;
    private byte[] mPostData;
    private String mReferrer;
    private final WebSettings mSettings;

    static {
        $assertionsDisabled = !FrameLoader.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FrameLoader(LoadListener loadListener, WebSettings webSettings, String str) {
        if (!$assertionsDisabled && JniUtil.useChromiumHttpStack()) {
            throw new AssertionError();
        }
        this.mListener = loadListener;
        this.mHeaders = null;
        this.mMethod = str;
        this.mCacheMode = 0;
        this.mSettings = webSettings;
    }

    public void setReferrer(String str) {
        if (URLUtil.isNetworkUrl(str)) {
            this.mReferrer = str;
        }
    }

    public void setPostData(byte[] bArr) {
        this.mPostData = bArr;
    }

    public void setContentTypeForPost(String str) {
        this.mContentType = str;
    }

    public void setCacheMode(int i) {
        this.mCacheMode = i;
    }

    public void setHeaders(HashMap hashMap) {
        this.mHeaders = hashMap;
    }

    public LoadListener getLoadListener() {
        return this.mListener;
    }

    public boolean executeLoad() {
        String urlPreLoad;
        String url = this.mListener.url();
        if (URLUtil.isNetworkUrl(url)) {
            if (this.mSettings.getBlockNetworkLoads()) {
                this.mListener.error(-12, "The page could not be opened because the URL is invalid.");
                return false;
            } else if (this.mListener.host() != null) {
                if (!URLUtil.verifyURLEncoding(this.mListener.host())) {
                    this.mListener.error(-12, "The page could not be opened because the URL is invalid.");
                    return false;
                } else if (this.mSettings.preloadEnabled() && (urlPreLoad = PreLoadManager.getInstance().urlPreLoad(this.mSettings.hashCode())) != null && url.equals(urlPreLoad)) {
                    String urlPreLoadPath = PreLoadManager.getInstance().urlPreLoadPath(this.mSettings.hashCode());
                    Log.i(LOGTAG, "preload, load file: " + urlPreLoadPath);
                    PreFileLoader.requestUrl(urlPreLoadPath, this.mListener, this.mListener.getContext());
                    return true;
                } else {
                    this.mNetwork = Network.getInstance(this.mListener.getContext());
                    if (this.mListener.isSynchronous()) {
                        return handleHTTPLoad();
                    }
                    WebViewWorker.getHandler().obtainMessage(102, this).sendToTarget();
                    return true;
                }
            } else {
                return false;
            }
        } else if (handleLocalFile(url, this.mListener, this.mSettings)) {
            return true;
        } else {
            this.mListener.error(-10, "The protocol is not supported.");
            return false;
        }
    }

    static boolean handleLocalFile(String str, LoadListener loadListener, WebSettings webSettings) {
        if ($assertionsDisabled || !JniUtil.useChromiumHttpStack()) {
            try {
                String str2 = new String(URLUtil.decode(str.getBytes()));
                if (URLUtil.isAssetUrl(str2)) {
                    if (loadListener.isSynchronous()) {
                        new FileLoader(str2, loadListener, 1, true).load();
                        return true;
                    }
                    WebViewWorker.getHandler().obtainMessage(101, new FileLoader(str2, loadListener, 1, true)).sendToTarget();
                    return true;
                } else if (URLUtil.isResourceUrl(str2)) {
                    if (loadListener.isSynchronous()) {
                        new FileLoader(str2, loadListener, 2, true).load();
                        return true;
                    }
                    WebViewWorker.getHandler().obtainMessage(101, new FileLoader(str2, loadListener, 2, true)).sendToTarget();
                    return true;
                } else if (URLUtil.isFileUrl(str2)) {
                    if (loadListener.isSynchronous()) {
                        new FileLoader(str2, loadListener, 3, webSettings.getAllowFileAccess()).load();
                        return true;
                    }
                    WebViewWorker.getHandler().obtainMessage(101, new FileLoader(str2, loadListener, 3, webSettings.getAllowFileAccess())).sendToTarget();
                    return true;
                } else if (URLUtil.isContentUrl(str2)) {
                    if (loadListener.isSynchronous()) {
                        new ContentLoader(loadListener.url(), loadListener).load();
                        return true;
                    }
                    WebViewWorker.getHandler().obtainMessage(101, new ContentLoader(loadListener.url(), loadListener)).sendToTarget();
                    return true;
                } else if (URLUtil.isDataUrl(str2)) {
                    new DataLoader(str2, loadListener).load();
                    return true;
                } else if (URLUtil.isAboutUrl(str2)) {
                    loadListener.data(mAboutBlank.getBytes(), mAboutBlank.length());
                    loadListener.endData();
                    return true;
                } else {
                    return false;
                }
            } catch (IllegalArgumentException e) {
                loadListener.error(-12, "The page could not be opened because the URL is invalid.");
                return true;
            }
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean handleHTTPLoad() {
        int i;
        boolean z;
        if (this.mHeaders == null) {
            this.mHeaders = new HashMap();
        }
        populateStaticHeaders();
        populateHeaders();
        if (handleCache()) {
            this.mListener.setRequestData(this.mMethod, this.mHeaders, this.mPostData);
            return true;
        }
        try {
            z = this.mNetwork.requestURL(this.mMethod, this.mHeaders, this.mPostData, this.mListener, this.mSettings.useImageLoadProxy());
            i = -10;
        } catch (ParseException e) {
            i = -12;
            z = false;
        } catch (RuntimeException e2) {
            i = -12;
            z = false;
        }
        if (z) {
            return true;
        }
        this.mListener.error(i, ErrorStrings.getString(i, this.mListener.getContext()));
        return false;
    }

    private void startCacheLoad(CacheManager.CacheResult cacheResult) {
        CacheLoader cacheLoader = new CacheLoader(this.mListener, cacheResult);
        this.mListener.setCacheLoader(cacheLoader);
        if (this.mListener.isSynchronous()) {
            cacheLoader.load();
        } else {
            WebViewWorker.getHandler().obtainMessage(101, cacheLoader).sendToTarget();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean handleCache() {
        switch (this.mCacheMode) {
            case 1:
                CacheManager.CacheResult cacheFile = CacheManager.getCacheFile(this.mListener.url(), this.mListener.postIdentifier(), null, this.mListener.pageType());
                if (cacheFile != null) {
                    startCacheLoad(cacheFile);
                    return true;
                }
                break;
            case 2:
                break;
            case 3:
                CacheManager.CacheResult cacheFile2 = CacheManager.getCacheFile(this.mListener.url(), this.mListener.postIdentifier(), null, this.mListener.pageType());
                if (cacheFile2 != null) {
                    startCacheLoad(cacheFile2);
                    return true;
                }
                this.mListener.error(-14, ErrorStrings.getString(-14, this.mListener.getContext()));
                return true;
            default:
                return this.mListener.checkCache(this.mHeaders);
        }
        return false;
    }

    private void populateStaticHeaders() {
        String str = this.mHeaders.get("Accept");
        if (str == null || str.length() == 0) {
            this.mHeaders.put("Accept", HEADER_STR);
        }
        this.mHeaders.put("Accept-Charset", "utf-8, iso-8859-1, utf-16, *;q=0.7");
        String acceptLanguage = this.mSettings.getAcceptLanguage();
        if (acceptLanguage.length() > 0) {
            this.mHeaders.put("Accept-Language", acceptLanguage);
        }
        if (!this.mHeaders.get(HttpUtils.HEADER_NAME_USER_AGENT).equals(IPHONE_UA)) {
            this.mHeaders.put(HttpUtils.HEADER_NAME_USER_AGENT, this.mSettings.getUserAgentString());
        }
    }

    private void populateHeaders() {
        String proxyUsername;
        String proxyPassword;
        if (this.mReferrer != null) {
            this.mHeaders.put(HttpUtils.HEADER_NAME_REFERER, this.mReferrer);
        }
        if (this.mContentType != null) {
            this.mHeaders.put("content-type", this.mContentType);
        }
        if (this.mNetwork.isValidProxySet()) {
            synchronized (this.mNetwork) {
                proxyUsername = this.mNetwork.getProxyUsername();
                proxyPassword = this.mNetwork.getProxyPassword();
            }
            if (proxyUsername != null && proxyPassword != null) {
                this.mHeaders.put(RequestHandle.authorizationHeader(true), "Basic " + RequestHandle.computeBasicAuthResponse(proxyUsername, proxyPassword));
            }
        }
        String cookie = CookieManager.getInstance().getCookie(this.mListener.getWebAddress());
        if (cookie != null && cookie.length() > 0) {
            this.mHeaders.put(HttpUtils.HEADER_NAME_COOKIE, cookie);
        }
    }
}
