package com.baidu.zeus;

import com.baidu.cyberplayer.sdk.internal.HttpUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
class PreLoader {
    private static final String CONTENT_TYPE = "content-type";
    static final String HEADER_STR = "text/xml, text/html, application/xhtml+xml, image/png, text/plain, */*;q=0.8";
    private static final String LOGTAG = "PreLoader";
    private static final int URI_PROTOCOL = 256;
    private static final String mAboutBlank = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EB\"><html><head><title>about:blank</title></head><body></body></html>";
    private Map<String, String> mHeaders = null;
    private final PreLoadListener mListener;
    private final String mMethod;
    private Network mNetwork;
    private final WebSettings mSettings;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PreLoader(PreLoadListener preLoadListener, WebSettings webSettings, String str) {
        this.mListener = preLoadListener;
        this.mMethod = str;
        this.mSettings = webSettings;
    }

    public PreLoadListener getLoadListener() {
        return this.mListener;
    }

    public boolean executeLoad() {
        String url = this.mListener.url();
        if (URLUtil.isHttpUrl(url) && !this.mSettings.getBlockNetworkLoads() && URLUtil.verifyURLEncoding(url)) {
            this.mNetwork = Network.getInstance(this.mListener.getContext());
            return handleHTTPLoad();
        }
        return false;
    }

    private boolean handleHTTPLoad() {
        boolean z;
        if (this.mHeaders == null) {
            this.mHeaders = new HashMap();
        }
        populateStaticHeaders();
        populateHeaders();
        try {
            z = this.mNetwork.requestURL(this.mMethod, this.mHeaders, this.mListener);
        } catch (ParseException e) {
            z = false;
        } catch (RuntimeException e2) {
            z = false;
        }
        return z;
    }

    private void populateStaticHeaders() {
        this.mHeaders.put("Accept", HEADER_STR);
        this.mHeaders.put("Accept-Charset", "utf-8, iso-8859-1, utf-16, *;q=0.7");
        String acceptLanguage = this.mSettings.getAcceptLanguage();
        if (acceptLanguage.length() > 0) {
            this.mHeaders.put("Accept-Language", acceptLanguage);
        }
        this.mHeaders.put(HttpUtils.HEADER_NAME_USER_AGENT, this.mSettings.getUserAgentString());
    }

    private void populateHeaders() {
        String proxyUsername;
        String proxyPassword;
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
