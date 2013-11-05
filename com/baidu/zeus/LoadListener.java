package com.baidu.zeus;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.zeus.ByteArrayBuilder;
import com.baidu.zeus.CacheManager;
import com.baidu.zeus.Headers;
import com.baidu.zeus.WebView;
import com.baidu.zeus.WebViewWorker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class LoadListener extends Handler implements EventHandler {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Pattern CONTENT_TYPE_PATTERN;
    private static final int HTTP_AUTH = 401;
    private static final int HTTP_FOUND = 302;
    private static final int HTTP_MOVED_PERMANENTLY = 301;
    private static final int HTTP_NOT_FOUND = 404;
    private static final int HTTP_NOT_MODIFIED = 304;
    private static final int HTTP_OK = 200;
    private static final int HTTP_PARTIAL_CONTENT = 206;
    private static final int HTTP_PROXY_AUTH = 407;
    private static final int HTTP_SEE_OTHER = 303;
    private static final int HTTP_TEMPORARY_REDIRECT = 307;
    private static final String LOGTAG = "webkit";
    private static final int MSG_CONTENT_DATA = 110;
    private static final int MSG_CONTENT_ERROR = 130;
    private static final int MSG_CONTENT_FINISHED = 120;
    private static final int MSG_CONTENT_HEADERS = 100;
    private static final int MSG_LOCATION_CHANGED = 140;
    private static final int MSG_LOCATION_CHANGED_REQUEST = 150;
    private static final int MSG_SSL_CERTIFICATE = 170;
    private static final int MSG_SSL_ERROR = 180;
    private static final int MSG_STATUS = 160;
    private static final String XML_MIME_TYPE = "^[\\w_\\-+~!$\\^{}|.%'`#&*]+/[\\w_\\-+~!$\\^{}|.%'`#&*]+\\+xml$";
    private static HashMap<String, String> sCertificateTypeMap;
    private static int sNativeLoaderCount;
    private boolean mAuthFailed;
    private HttpAuthHeader mAuthHeader;
    private BrowserFrame mBrowserFrame;
    private CacheLoader mCacheLoader;
    private int mCacheRedirectCount;
    private boolean mCancelled;
    public long mContentLength;
    private Context mContext;
    private String mEncoding;
    private String mErrorDescription;
    private Headers mHeaders;
    private boolean mIsMainPageLoader;
    private final boolean mIsMainResourceLoader;
    private Vector<Message> mMessageQueue;
    private String mMethod;
    private String mMimeType;
    private int mNativeLoader;
    private String mOriginalUrl;
    private final String mPassword;
    private boolean mPermanent;
    private byte[] mPostData;
    private long mPostIdentifier;
    private RequestHandle mRequestHandle;
    private Map<String, String> mRequestHeaders;
    private SslError mSslError;
    private RequestHandle mSslErrorRequestHandle;
    private int mStatusCode;
    private String mStatusText;
    private boolean mSynchronous;
    private String mTransferEncoding;
    private WebView.PageType mType;
    private WebAddress mUri;
    private String mUrl;
    private final boolean mUserGesture;
    private final String mUsername;
    private final ByteArrayBuilder mDataBuilder = new ByteArrayBuilder();
    private boolean mFromCache = false;
    private int mErrorID = 0;
    private boolean isWMLGB2312 = false;
    private boolean isWMLUTF8 = false;
    private boolean isHiAoWAP = false;
    private boolean isContentTypeWML = false;
    private boolean mIsImageResource = false;

    private native void nativeAddData(byte[] bArr, int i);

    private native int nativeCreateResponse(String str, int i, String str2, String str3, long j, String str4);

    private native void nativeError(int i, String str, String str2);

    private native void nativeFinished();

    private native void nativeReceivedResponse(int i);

    private native String nativeRedirectedToUrl(String str, String str2, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSetResponseHeader(int i, String str, String str2);

    static {
        $assertionsDisabled = !LoadListener.class.desiredAssertionStatus();
        sCertificateTypeMap = new HashMap<>();
        sCertificateTypeMap.put("application/x-x509-ca-cert", "CERT");
        sCertificateTypeMap.put("application/x-x509-user-cert", "CERT");
        sCertificateTypeMap.put("application/x-pkcs12", "PKCS12");
        CONTENT_TYPE_PATTERN = Pattern.compile("^((?:[xX]-)?[a-zA-Z\\*]+/[\\w\\+\\*-]+[\\.[\\w\\+-]+]*)$");
    }

    public static LoadListener getLoadListener(Context context, BrowserFrame browserFrame, String str, int i, boolean z, boolean z2, boolean z3, boolean z4, long j, String str2, String str3, WebView.PageType pageType) {
        sNativeLoaderCount++;
        return new LoadListener(context, browserFrame, str, i, z, z2, z3, z4, j, str2, str3, pageType);
    }

    public static int getNativeLoaderCount() {
        return sNativeLoaderCount;
    }

    LoadListener(Context context, BrowserFrame browserFrame, String str, int i, boolean z, boolean z2, boolean z3, boolean z4, long j, String str2, String str3, WebView.PageType pageType) {
        if (!$assertionsDisabled && JniUtil.useChromiumHttpStack()) {
            throw new AssertionError();
        }
        this.mContext = context;
        this.mBrowserFrame = browserFrame;
        setUrl(str);
        this.mNativeLoader = i;
        this.mSynchronous = z;
        if (z) {
            this.mMessageQueue = new Vector<>();
        }
        this.mIsMainPageLoader = z2;
        this.mIsMainResourceLoader = z3;
        this.mUserGesture = z4;
        this.mPostIdentifier = j;
        this.mUsername = str2;
        this.mPassword = str3;
        this.mType = pageType;
    }

    public WebView.PageType pageType() {
        return this.mType;
    }

    private void clearNativeLoader() {
        sNativeLoaderCount--;
        this.mNativeLoader = 0;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 100:
                handleHeaders((Headers) message.obj);
                return;
            case 110:
                if (this.mNativeLoader != 0 && !ignoreCallbacks()) {
                    commitLoad();
                    return;
                }
                return;
            case 120:
                handleEndData();
                return;
            case MSG_CONTENT_ERROR /* 130 */:
                handleError(message.arg1, (String) message.obj);
                return;
            case MSG_LOCATION_CHANGED /* 140 */:
                doRedirect();
                return;
            case 150:
                Message obtainMessage = obtainMessage(MSG_LOCATION_CHANGED);
                this.mBrowserFrame.getCallbackProxy().onFormResubmission(obtainMessage(120), obtainMessage);
                return;
            case MSG_STATUS /* 160 */:
                HashMap hashMap = (HashMap) message.obj;
                handleStatus(((Integer) hashMap.get("major")).intValue(), ((Integer) hashMap.get("minor")).intValue(), ((Integer) hashMap.get("code")).intValue(), (String) hashMap.get("reason"));
                return;
            case MSG_SSL_CERTIFICATE /* 170 */:
                handleCertificate((SslCertificate) message.obj);
                return;
            case MSG_SSL_ERROR /* 180 */:
                handleSslError((SslError) message.obj);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BrowserFrame getFrame() {
        return this.mBrowserFrame;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context getContext() {
        return this.mContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSynchronous() {
        return this.mSynchronous;
    }

    public boolean cancelled() {
        return this.mCancelled;
    }

    @Override // com.baidu.zeus.EventHandler
    public void headers(Headers headers) {
        if (!this.mCancelled) {
            ArrayList<String> setCookie = headers.getSetCookie();
            for (int i = 0; i < setCookie.size(); i++) {
                CookieManager.getInstance().setCookie(this.mUri, setCookie.get(i));
            }
            String contentType = headers.getContentType();
            if (contentType != null && contentType.startsWith("text/vnd.wap.wml")) {
                this.isContentTypeWML = true;
            } else {
                this.isContentTypeWML = false;
            }
            sendMessageInternal(obtainMessage(100, headers));
        }
    }

    private void handleHeaders(Headers headers) {
        boolean z = true;
        if (!this.mCancelled) {
            if (this.mStatusCode == HTTP_PARTIAL_CONTENT) {
                WebViewWorker.getHandler().obtainMessage(SocialAPIErrorCodes.ERROR_INVALID_TIMESTAMP, this).sendToTarget();
                return;
            }
            this.mHeaders = headers;
            long contentLength = headers.getContentLength();
            if (contentLength != -1) {
                this.mContentLength = contentLength;
            } else {
                this.mContentLength = 0L;
            }
            String contentType = headers.getContentType();
            if (contentType != null) {
                parseContentTypeHeader(contentType);
                if (this.mMimeType.equals("text/plain") || this.mMimeType.equals("application/octet-stream")) {
                    String contentDisposition = headers.getContentDisposition();
                    String parseContentDisposition = contentDisposition != null ? URLUtil.parseContentDisposition(contentDisposition) : null;
                    if (parseContentDisposition == null) {
                        parseContentDisposition = this.mUrl;
                    }
                    String guessMimeTypeFromExtension = guessMimeTypeFromExtension(parseContentDisposition);
                    if (guessMimeTypeFromExtension != null) {
                        this.mMimeType = guessMimeTypeFromExtension;
                    }
                } else if (!this.mMimeType.equals("text/vnd.wap.wml") && this.mMimeType.equals("application/vnd.wap.xhtml+xml")) {
                    this.mMimeType = "application/xhtml+xml";
                }
            } else {
                guessMimeType();
            }
            if (this.mIsMainPageLoader && this.mIsMainResourceLoader && this.mUserGesture && Pattern.matches(XML_MIME_TYPE, this.mMimeType) && !this.mMimeType.equalsIgnoreCase("application/xhtml+xml")) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(Uri.parse(url()), this.mMimeType);
                ResolveInfo resolveActivity = this.mContext.getPackageManager().resolveActivity(intent, 65536);
                if (resolveActivity != null && !this.mContext.getPackageName().equals(resolveActivity.activityInfo.packageName)) {
                    try {
                        this.mContext.startActivity(intent);
                        this.mBrowserFrame.stopLoading();
                        return;
                    } catch (ActivityNotFoundException e) {
                    }
                }
            }
            boolean z2 = this.mStatusCode == 401 || this.mStatusCode == 407;
            boolean z3 = this.mStatusCode == 407;
            this.mAuthFailed = false;
            if (this.mAuthHeader != null) {
                if (!z2 || z3 != this.mAuthHeader.isProxy()) {
                    z = false;
                }
                this.mAuthFailed = z;
                if (!this.mAuthFailed && this.mAuthHeader.isProxy()) {
                    Network network = Network.getInstance(this.mContext);
                    if (network.isValidProxySet()) {
                        synchronized (network) {
                            network.setProxyUsername(this.mAuthHeader.getUsername());
                            network.setProxyPassword(this.mAuthHeader.getPassword());
                        }
                    }
                }
            }
            this.mAuthHeader = null;
            if (z2) {
                if (this.mStatusCode == 401) {
                    this.mAuthHeader = parseAuthHeader(headers.getWwwAuthenticate());
                } else {
                    this.mAuthHeader = parseAuthHeader(headers.getProxyAuthenticate());
                    if (this.mAuthHeader != null) {
                        this.mAuthHeader.setProxy();
                    }
                }
            }
            if ((this.mStatusCode == 200 || this.mStatusCode == 302 || this.mStatusCode == 301 || this.mStatusCode == HTTP_TEMPORARY_REDIRECT) && this.mNativeLoader != 0) {
                if (!this.mFromCache && this.mRequestHandle != null && (!this.mRequestHandle.getMethod().equals("POST") || this.mPostIdentifier != 0)) {
                    WebViewWorker.CacheCreateData cacheCreateData = new WebViewWorker.CacheCreateData();
                    cacheCreateData.mListener = this;
                    cacheCreateData.mUrl = this.mUrl;
                    cacheCreateData.mMimeType = this.mMimeType;
                    cacheCreateData.mStatusCode = this.mStatusCode;
                    cacheCreateData.mPostId = this.mPostIdentifier;
                    cacheCreateData.mHeaders = headers;
                    cacheCreateData.mType = this.mType;
                    WebViewWorker.getHandler().obtainMessage(103, cacheCreateData).sendToTarget();
                }
                WebViewWorker.CacheEncoding cacheEncoding = new WebViewWorker.CacheEncoding();
                cacheEncoding.mEncoding = this.mEncoding;
                cacheEncoding.mListener = this;
                WebViewWorker.getHandler().obtainMessage(104, cacheEncoding).sendToTarget();
            }
            commitHeadersCheckRedirect();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean proxyAuthenticate() {
        if (this.mAuthHeader != null) {
            return this.mAuthHeader.isProxy();
        }
        return false;
    }

    @Override // com.baidu.zeus.EventHandler
    public void status(int i, int i2, int i3, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("major", Integer.valueOf(i));
        hashMap.put("minor", Integer.valueOf(i2));
        hashMap.put("code", Integer.valueOf(i3));
        hashMap.put("reason", str);
        this.mDataBuilder.clear();
        this.mMimeType = "";
        this.mEncoding = "";
        this.mTransferEncoding = "";
        sendMessageInternal(obtainMessage(MSG_STATUS, hashMap));
    }

    private void handleStatus(int i, int i2, int i3, String str) {
        if (!this.mCancelled) {
            this.mStatusCode = i3;
            this.mStatusText = str;
            this.mPermanent = false;
        }
    }

    @Override // com.baidu.zeus.EventHandler
    public void certificate(SslCertificate sslCertificate) {
        sendMessageInternal(obtainMessage(MSG_SSL_CERTIFICATE, sslCertificate));
    }

    private void handleCertificate(SslCertificate sslCertificate) {
        if (this.mIsMainPageLoader && this.mIsMainResourceLoader) {
            this.mBrowserFrame.certificate(sslCertificate);
        }
    }

    @Override // com.baidu.zeus.EventHandler
    public void error(int i, String str) {
        sendMessageInternal(obtainMessage(MSG_CONTENT_ERROR, i, 0, str));
    }

    private void handleError(int i, String str) {
        this.mErrorID = i;
        this.mErrorDescription = str;
        detachRequestHandle();
        notifyError();
        tearDown();
    }

    @Override // com.baidu.zeus.EventHandler
    public void data(byte[] bArr, int i) {
        boolean isEmpty;
        try {
            if (this.isContentTypeWML && !this.isHiAoWAP && url().indexOf("wap.hiao.com") != -1 && new String(bArr).indexOf("<!DOCTYPE html") != -1) {
                String replaceFirst = new String(bArr, 0, i, BdUtil.UTF8).replaceFirst("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">", "<!DOCTYPE wml PUBLIC \"-//WAPFORUM//DTD WML 1.1//EN\" \"http://www.wapforum.org/DTD/wml_1.1.xml\">");
                if (replaceFirst != null) {
                    bArr = replaceFirst.getBytes(BdUtil.UTF8);
                }
                i = bArr.length;
                this.isHiAoWAP = true;
            }
        } catch (Exception e) {
            Log.e(LOGTAG, "data error");
            e.printStackTrace();
        }
        synchronized (this.mDataBuilder) {
            isEmpty = this.mDataBuilder.isEmpty();
            this.mDataBuilder.append(bArr, 0, i);
        }
        if (isEmpty) {
            sendMessageInternal(obtainMessage(110));
        }
    }

    @Override // com.baidu.zeus.EventHandler
    public void endData() {
        this.isWMLGB2312 = false;
        this.isContentTypeWML = false;
        this.isWMLUTF8 = false;
        this.isHiAoWAP = false;
        sendMessageInternal(obtainMessage(120));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleEndData() {
        if (!this.mCancelled) {
            switch (this.mStatusCode) {
                case 301:
                    this.mPermanent = true;
                    if (this.mStatusCode != HTTP_TEMPORARY_REDIRECT) {
                        if (this.mRequestHandle != null && this.mRequestHandle.getMethod().equals("POST")) {
                            sendMessageInternal(obtainMessage(150));
                            return;
                        } else if (this.mMethod != null && this.mMethod.equals("POST")) {
                            sendMessageInternal(obtainMessage(150));
                            return;
                        } else {
                            sendMessageInternal(obtainMessage(MSG_LOCATION_CHANGED));
                            return;
                        }
                    }
                    sendMessageInternal(obtainMessage(MSG_LOCATION_CHANGED));
                    return;
                case 302:
                case 303:
                case HTTP_TEMPORARY_REDIRECT /* 307 */:
                    if (this.mStatusCode != HTTP_TEMPORARY_REDIRECT) {
                    }
                    break;
                case 304:
                    if (this.mCacheLoader != null) {
                        if (isSynchronous()) {
                            this.mCacheLoader.load();
                        } else {
                            WebViewWorker.getHandler().obtainMessage(101, this.mCacheLoader).sendToTarget();
                        }
                        this.mFromCache = true;
                        return;
                    }
                    detachRequestHandle();
                    tearDown();
                    return;
                case 401:
                case 407:
                    if (this.mAuthHeader != null && (Network.getInstance(this.mContext).isValidProxySet() || !this.mAuthHeader.isProxy())) {
                        if (!this.mAuthFailed && this.mUsername != null && this.mPassword != null) {
                            HttpAuthHandler.onReceivedCredentials(this, this.mAuthHeader.isProxy() ? Network.getInstance(this.mContext).getProxyHostname() : this.mUri.mHost, this.mAuthHeader.getRealm(), this.mUsername, this.mPassword);
                            makeAuthResponse(this.mUsername, this.mPassword);
                            return;
                        }
                        Network.getInstance(this.mContext).handleAuthRequest(this);
                        return;
                    }
                    detachRequestHandle();
                    tearDown();
                    return;
                default:
                    detachRequestHandle();
                    tearDown();
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCacheLoader(CacheLoader cacheLoader) {
        this.mCacheLoader = cacheLoader;
        this.mFromCache = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean checkCache(Map<String, String> map) {
        CacheManager.CacheResult cacheFile = CacheManager.getCacheFile(url(), this.mPostIdentifier, map, this.mType);
        this.mCacheLoader = null;
        this.mFromCache = false;
        if (cacheFile != null) {
            this.mCacheLoader = new CacheLoader(this, cacheFile);
            if (!map.containsKey("if-none-match") && !map.containsKey("if-modified-since")) {
                if (isSynchronous()) {
                    this.mCacheLoader.load();
                } else {
                    WebViewWorker.getHandler().obtainMessage(101, this.mCacheLoader).sendToTarget();
                }
                this.mFromCache = true;
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.zeus.EventHandler
    public boolean handleSslErrorRequest(SslError sslError) {
        if (Network.getInstance(this.mContext).checkSslPrefTable(this, sslError)) {
            return true;
        }
        if (isSynchronous()) {
            this.mRequestHandle.handleSslErrorResponse(false);
            return true;
        }
        sendMessageInternal(obtainMessage(MSG_SSL_ERROR, sslError));
        if (!this.mCancelled) {
            this.mSslErrorRequestHandle = this.mRequestHandle;
        }
        return !this.mCancelled;
    }

    private void handleSslError(SslError sslError) {
        if (!this.mCancelled) {
            this.mSslError = sslError;
            Network.getInstance(this.mContext).handleSslErrorRequest(this);
        } else if (this.mSslErrorRequestHandle != null) {
            this.mSslErrorRequestHandle.handleSslErrorResponse(true);
        }
        this.mSslErrorRequestHandle = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String realm() {
        if (this.mAuthHeader == null) {
            return null;
        }
        return this.mAuthHeader.getRealm();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean authCredentialsInvalid() {
        return this.mAuthFailed && !(this.mAuthHeader.isDigest() && this.mAuthHeader.getStale());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SslError sslError() {
        return this.mSslError;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleSslErrorResponse(boolean z) {
        if (this.mRequestHandle != null) {
            this.mRequestHandle.handleSslErrorResponse(z);
        }
        if (!z) {
            commitLoad();
            tearDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleAuthResponse(String str, String str2) {
        if (str != null && str2 != null) {
            makeAuthResponse(str, str2);
            return;
        }
        commitLoad();
        tearDown();
    }

    void makeAuthResponse(String str, String str2) {
        if (this.mAuthHeader != null && this.mRequestHandle != null) {
            this.mAuthHeader.setUsername(str);
            this.mAuthHeader.setPassword(str2);
            int scheme = this.mAuthHeader.getScheme();
            if (scheme == 1) {
                this.mRequestHandle.setupBasicAuthResponse(this.mAuthHeader.isProxy(), str, str2);
            } else if (scheme == 2) {
                this.mRequestHandle.setupDigestAuthResponse(this.mAuthHeader.isProxy(), str, str2, this.mAuthHeader.getRealm(), this.mAuthHeader.getNonce(), this.mAuthHeader.getQop(), this.mAuthHeader.getAlgorithm(), this.mAuthHeader.getOpaque());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRequestData(String str, Map<String, String> map, byte[] bArr) {
        this.mMethod = str;
        this.mRequestHeaders = map;
        this.mPostData = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String url() {
        return this.mUrl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebAddress getWebAddress() {
        return this.mUri;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String host() {
        if (this.mUri != null) {
            return this.mUri.mHost;
        }
        return null;
    }

    String originalUrl() {
        return this.mOriginalUrl != null ? this.mOriginalUrl : this.mUrl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long postIdentifier() {
        return this.mPostIdentifier;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void attachRequestHandle(RequestHandle requestHandle) {
        this.mRequestHandle = requestHandle;
    }

    void detachRequestHandle() {
        this.mRequestHandle = null;
    }

    void downloadFile() {
        WebViewWorker.getHandler().obtainMessage(SocialAPIErrorCodes.ERROR_INVALID_TIMESTAMP, this).sendToTarget();
        this.mBrowserFrame.getCallbackProxy().onDownloadStart(url(), this.mBrowserFrame.getUserAgentString(), this.mHeaders.getContentDisposition(), this.mMimeType, this.mContentLength);
        cancel();
    }

    static boolean willLoadFromCache(String str, long j) {
        if ($assertionsDisabled || !JniUtil.useChromiumHttpStack()) {
            return CacheManager.getCacheFile(str, j, null, WebView.PageType.NormalType) != null;
        }
        throw new AssertionError();
    }

    void resetCancel() {
        this.mCancelled = false;
    }

    String mimeType() {
        return this.mMimeType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String transferEncoding() {
        return this.mTransferEncoding;
    }

    long contentLength() {
        return this.mContentLength;
    }

    private void commitHeadersCheckRedirect() {
        if (!this.mCancelled) {
            if ((this.mStatusCode < 301 || this.mStatusCode > 303) && this.mStatusCode != HTTP_TEMPORARY_REDIRECT) {
                if (this.mStatusCode != 304 || this.mCacheLoader == null) {
                    commitHeaders();
                }
            }
        }
    }

    private void commitHeaders() {
        if ((!this.mIsMainPageLoader || !sCertificateTypeMap.containsKey(this.mMimeType)) && this.mAuthHeader == null) {
            nativeReceivedResponse(createNativeResponse());
        }
    }

    private int createNativeResponse() {
        final int nativeCreateResponse = nativeCreateResponse(originalUrl(), (this.mStatusCode != 304 || this.mCacheLoader == null) ? this.mStatusCode : 200, this.mStatusText, this.mMimeType, this.mContentLength, this.mEncoding);
        if (this.mHeaders != null) {
            this.mHeaders.getHeaders(new Headers.HeaderCallback() { // from class: com.baidu.zeus.LoadListener.1
                @Override // com.baidu.zeus.Headers.HeaderCallback
                public void header(String str, String str2) {
                    LoadListener.this.nativeSetResponseHeader(nativeCreateResponse, str, str2);
                }
            });
        }
        return nativeCreateResponse;
    }

    private void commitLoad() {
        String str;
        int i = 0;
        if (!this.mCancelled) {
            if (this.mIsMainPageLoader && (str = sCertificateTypeMap.get(this.mMimeType)) != null) {
                synchronized (this.mDataBuilder) {
                    byte[] bArr = new byte[this.mDataBuilder.getByteSize()];
                    while (true) {
                        ByteArrayBuilder.Chunk firstChunk = this.mDataBuilder.getFirstChunk();
                        if (firstChunk != null) {
                            if (firstChunk.mLength != 0) {
                                System.arraycopy(firstChunk.mArray, 0, bArr, i, firstChunk.mLength);
                                i += firstChunk.mLength;
                                if (!this.mFromCache && this.mRequestHandle != null) {
                                    NetworkStatistic.getInstance().addDownloadLength(firstChunk.mLength);
                                }
                            }
                            firstChunk.release();
                        } else {
                            CertTool.addCertificate(this.mContext, str, bArr);
                            this.mBrowserFrame.stopLoading();
                        }
                    }
                }
                return;
            }
            PerfChecker perfChecker = new PerfChecker();
            while (true) {
                ByteArrayBuilder.Chunk firstChunk2 = this.mDataBuilder.getFirstChunk();
                if (firstChunk2 != null) {
                    if (firstChunk2.mLength != 0) {
                        if (!this.mFromCache && this.mRequestHandle != null) {
                            NetworkStatistic.getInstance().addDownloadLength(firstChunk2.mLength);
                        }
                        nativeAddData(firstChunk2.mArray, firstChunk2.mLength);
                        WebViewWorker.CacheData cacheData = new WebViewWorker.CacheData();
                        cacheData.mListener = this;
                        cacheData.mChunk = firstChunk2;
                        WebViewWorker.getHandler().obtainMessage(105, cacheData).sendToTarget();
                    } else {
                        firstChunk2.release();
                    }
                    perfChecker.responseAlert("res nativeAddData");
                } else {
                    return;
                }
            }
        }
    }

    void tearDown() {
        if (getErrorID() == 0) {
            WebViewWorker.CacheSaveData cacheSaveData = new WebViewWorker.CacheSaveData();
            cacheSaveData.mListener = this;
            cacheSaveData.mUrl = this.mUrl;
            cacheSaveData.mPostId = this.mPostIdentifier;
            WebViewWorker.getHandler().obtainMessage(SocialAPIErrorCodes.ERROR_INVALID_SIGNATURE_ALGORITHM, cacheSaveData).sendToTarget();
        } else {
            WebViewWorker.getHandler().obtainMessage(SocialAPIErrorCodes.ERROR_INVALID_TIMESTAMP, this).sendToTarget();
        }
        if (this.mNativeLoader != 0) {
            PerfChecker perfChecker = new PerfChecker();
            nativeFinished();
            perfChecker.responseAlert("res nativeFinished");
            clearNativeLoader();
        }
    }

    private int getErrorID() {
        return this.mErrorID;
    }

    private String getErrorDescription() {
        return this.mErrorDescription;
    }

    void notifyError() {
        if (this.mNativeLoader != 0) {
            String errorDescription = getErrorDescription();
            if (errorDescription == null) {
                errorDescription = "";
            }
            nativeError(getErrorID(), errorDescription, url());
            clearNativeLoader();
        }
    }

    void pauseLoad(boolean z) {
        if (this.mRequestHandle != null) {
            this.mRequestHandle.pauseRequest(z);
        }
    }

    public void cancel() {
        if (this.mRequestHandle != null) {
            this.mRequestHandle.cancel();
            this.mRequestHandle = null;
        }
        WebViewWorker.getHandler().obtainMessage(SocialAPIErrorCodes.ERROR_INVALID_TIMESTAMP, this).sendToTarget();
        this.mCancelled = true;
        clearNativeLoader();
    }

    private void doRedirect() {
        boolean z;
        if (!this.mCancelled) {
            if (this.mCacheRedirectCount >= 16) {
                handleError(-9, "The page contains too many server redirects.");
                return;
            }
            String location = this.mHeaders.getLocation();
            if (location != null) {
                String nativeRedirectedToUrl = nativeRedirectedToUrl(this.mUrl, location, createNativeResponse());
                if (!this.mCancelled) {
                    if (nativeRedirectedToUrl == null) {
                        Log.d(LOGTAG, "Redirection failed for " + this.mHeaders.getLocation());
                        cancel();
                        return;
                    } else if (!URLUtil.isNetworkUrl(nativeRedirectedToUrl)) {
                        String str = "You do not have permission to open this page.\n" + nativeRedirectedToUrl;
                        nativeAddData(str.getBytes(), str.length());
                        nativeFinished();
                        clearNativeLoader();
                        return;
                    } else {
                        if (getErrorID() == 0) {
                            WebViewWorker.CacheSaveData cacheSaveData = new WebViewWorker.CacheSaveData();
                            cacheSaveData.mListener = this;
                            cacheSaveData.mUrl = this.mUrl;
                            cacheSaveData.mPostId = this.mPostIdentifier;
                            WebViewWorker.getHandler().obtainMessage(SocialAPIErrorCodes.ERROR_INVALID_SIGNATURE_ALGORITHM, cacheSaveData).sendToTarget();
                        } else {
                            WebViewWorker.getHandler().obtainMessage(SocialAPIErrorCodes.ERROR_INVALID_TIMESTAMP, this).sendToTarget();
                        }
                        this.mOriginalUrl = nativeRedirectedToUrl;
                        setUrl(nativeRedirectedToUrl);
                        if (this.mRequestHeaders == null) {
                            this.mRequestHeaders = new HashMap();
                        }
                        if (this.mCacheLoader != null) {
                            this.mCacheRedirectCount++;
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!checkCache(this.mRequestHeaders)) {
                            if (this.mRequestHandle != null) {
                                try {
                                    this.mRequestHandle.setupRedirect(this.mUrl, this.mStatusCode, this.mRequestHeaders);
                                } catch (RuntimeException e) {
                                    Log.e(LOGTAG, e.getMessage());
                                    handleError(-12, this.mContext.getString(17039367));
                                    return;
                                }
                            } else {
                                Network network = Network.getInstance(getContext());
                                WebSettings webSettings = this.mBrowserFrame.getWebSettings();
                                if (!network.requestURL(this.mMethod, this.mRequestHeaders, this.mPostData, this, webSettings != null ? webSettings.useImageLoadProxy() : false)) {
                                    handleError(-12, this.mContext.getString(17039367));
                                    return;
                                }
                            }
                            if (z) {
                                this.mRequestHandle.setRedirectCount(this.mCacheRedirectCount);
                                return;
                            }
                            return;
                        } else if (!z) {
                            this.mCacheRedirectCount = this.mRequestHandle.getRedirectCount() + 1;
                            return;
                        } else {
                            return;
                        }
                    }
                }
                return;
            }
            commitHeaders();
            commitLoad();
            tearDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void parseContentTypeHeader(String str) {
        if (str != null) {
            int indexOf = str.indexOf(59);
            if (indexOf >= 0) {
                this.mMimeType = str.substring(0, indexOf);
                int indexOf2 = str.indexOf(61, indexOf);
                if (indexOf2 > 0) {
                    indexOf = str.indexOf(59, indexOf2);
                    if (indexOf < indexOf2) {
                        indexOf = str.length();
                    }
                    this.mEncoding = str.substring(indexOf2 + 1, indexOf);
                } else {
                    this.mEncoding = str.substring(indexOf + 1);
                }
                this.mEncoding = this.mEncoding.trim().toLowerCase();
                if (indexOf < str.length() - 1) {
                    this.mTransferEncoding = str.substring(indexOf + 1).trim().toLowerCase();
                }
            } else {
                this.mMimeType = str;
            }
            this.mMimeType = this.mMimeType.trim();
            try {
                Matcher matcher = CONTENT_TYPE_PATTERN.matcher(this.mMimeType);
                if (matcher.find()) {
                    this.mMimeType = matcher.group(1);
                } else {
                    guessMimeType();
                }
            } catch (IllegalStateException e) {
                guessMimeType();
            }
        }
        this.mMimeType = this.mMimeType.toLowerCase();
    }

    private HttpAuthHeader parseAuthHeader(String str) {
        int i;
        boolean z;
        int i2;
        if (str != null) {
            int[] iArr = new int[256];
            int length = str.length();
            if (length > 0) {
                int i3 = 0;
                boolean z2 = false;
                i = 0;
                while (i3 < length && i < 256) {
                    if (str.charAt(i3) == '\"') {
                        z = !z2;
                        i2 = i;
                    } else {
                        if (!z2) {
                            if (str.regionMatches(true, i3, HttpAuthHeader.BASIC_TOKEN, 0, HttpAuthHeader.BASIC_TOKEN.length())) {
                                iArr[i] = i3;
                                i2 = i + 1;
                                z = z2;
                            } else if (str.regionMatches(true, i3, HttpAuthHeader.DIGEST_TOKEN, 0, HttpAuthHeader.DIGEST_TOKEN.length())) {
                                iArr[i] = i3;
                                i2 = i + 1;
                                z = z2;
                            }
                        }
                        z = z2;
                        i2 = i;
                    }
                    i3++;
                    z2 = z;
                    i = i2;
                }
            } else {
                i = 0;
            }
            if (i > 0) {
                for (int i4 = 0; i4 < i; i4++) {
                    if (str.regionMatches(true, iArr[i4], HttpAuthHeader.DIGEST_TOKEN, 0, HttpAuthHeader.DIGEST_TOKEN.length())) {
                        HttpAuthHeader httpAuthHeader = new HttpAuthHeader(str.substring(iArr[i4], i4 + 1 < i ? iArr[i4 + 1] : length));
                        if (httpAuthHeader.isSupportedScheme()) {
                            return httpAuthHeader;
                        }
                    }
                }
                for (int i5 = 0; i5 < i; i5++) {
                    if (str.regionMatches(true, iArr[i5], HttpAuthHeader.BASIC_TOKEN, 0, HttpAuthHeader.BASIC_TOKEN.length())) {
                        HttpAuthHeader httpAuthHeader2 = new HttpAuthHeader(str.substring(iArr[i5], i5 + 1 < i ? iArr[i5 + 1] : length));
                        if (httpAuthHeader2.isSupportedScheme()) {
                            return httpAuthHeader2;
                        }
                    }
                }
            }
        }
        return null;
    }

    private boolean ignoreCallbacks() {
        return this.mCancelled || this.mAuthHeader != null || (this.mStatusCode > 300 && this.mStatusCode < 400 && this.mStatusCode != 305);
    }

    void setUrl(String str) {
        if (str != null) {
            this.mUri = null;
            if (URLUtil.isNetworkUrl(str)) {
                this.mUrl = URLUtil.stripAnchor(str);
                try {
                    this.mUri = new WebAddress(this.mUrl);
                    return;
                } catch (ParseException e) {
                    e.printStackTrace();
                    return;
                }
            }
            this.mUrl = str;
        }
    }

    private void guessMimeType() {
        if (URLUtil.isDataUrl(this.mUrl) && this.mMimeType.length() != 0) {
            cancel();
            handleError(-12, "The page could not be opened because the URL is invalid.");
            return;
        }
        this.mMimeType = "text/html";
        String guessMimeTypeFromExtension = guessMimeTypeFromExtension(this.mUrl);
        if (guessMimeTypeFromExtension != null) {
            this.mMimeType = guessMimeTypeFromExtension;
        }
    }

    private String guessMimeTypeFromExtension(String str) {
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str));
    }

    private void sendMessageInternal(Message message) {
        if (this.mSynchronous) {
            this.mMessageQueue.add(message);
        } else {
            sendMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadSynchronousMessages() {
        while (!this.mMessageQueue.isEmpty()) {
            handleMessage(this.mMessageQueue.remove(0));
        }
    }

    public void setIsImageResource(boolean z) {
        this.mIsImageResource = z;
    }

    public boolean isImageResource() {
        return this.mIsImageResource;
    }
}
