package com.baidu.zeus;

import cn.jingling.lib.file.Shared;
import com.baidu.cyberplayer.sdk.internal.HttpUtils;
import com.baidu.zeus.security.Md5MessageDigest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import junit.framework.Assert;
import org.apache.commons.codec.binary.Base64;
/* loaded from: classes.dex */
public class RequestHandle {
    private static final String AUTHORIZATION_HEADER = "Authorization";
    public static final int MAX_REDIRECT_COUNT = 16;
    private static final String PROXY_AUTHORIZATION_HEADER = "Proxy-Authorization";
    private int mBodyLength;
    private InputStream mBodyProvider;
    private Connection mConnection;
    private Map<String, String> mHeaders;
    private String mMethod;
    private int mRedirectCount;
    private Request mRequest;
    private RequestQueue mRequestQueue;
    private WebAddress mUri;
    private String mUrl;

    public RequestHandle(RequestQueue requestQueue, String str, WebAddress webAddress, String str2, Map<String, String> map, InputStream inputStream, int i, Request request) {
        this.mRedirectCount = 0;
        this.mHeaders = map == null ? new HashMap<>() : map;
        this.mBodyProvider = inputStream;
        this.mBodyLength = i;
        this.mMethod = str2 == null ? "GET" : str2;
        this.mUrl = str;
        this.mUri = webAddress;
        this.mRequestQueue = requestQueue;
        this.mRequest = request;
    }

    public RequestHandle(RequestQueue requestQueue, String str, WebAddress webAddress, String str2, Map<String, String> map, InputStream inputStream, int i, Request request, Connection connection) {
        this(requestQueue, str, webAddress, str2, map, inputStream, i, request);
        this.mConnection = connection;
    }

    public void cancel() {
        if (this.mRequest != null) {
            this.mRequest.cancel();
        }
    }

    public void pauseRequest(boolean z) {
        if (this.mRequest != null) {
            this.mRequest.setLoadingPaused(z);
        }
    }

    public void handleSslErrorResponse(boolean z) {
        if (this.mRequest != null) {
            this.mRequest.handleSslErrorResponse(z);
        }
    }

    public boolean isRedirectMax() {
        return this.mRedirectCount >= 16;
    }

    public int getRedirectCount() {
        return this.mRedirectCount;
    }

    public void setRedirectCount(int i) {
        this.mRedirectCount = i;
    }

    public boolean setupRedirect(String str, int i, Map<String, String> map) {
        this.mHeaders.remove(AUTHORIZATION_HEADER);
        this.mHeaders.remove(PROXY_AUTHORIZATION_HEADER);
        int i2 = this.mRedirectCount + 1;
        this.mRedirectCount = i2;
        if (i2 == 16) {
            this.mRequest.error(-9, 17039608);
            this.mRequest.cancel();
            return false;
        }
        if (this.mUrl.startsWith("https:") && str.startsWith("http:")) {
            this.mHeaders.remove(HttpUtils.HEADER_NAME_REFERER);
        }
        this.mUrl = str;
        try {
            this.mUri = new WebAddress(this.mUrl);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.mHeaders.remove(HttpUtils.HEADER_NAME_COOKIE);
        try {
            String cookie = CookieManager.getInstance().getCookie(this.mUri);
            if (cookie != null && cookie.length() > 0) {
                this.mHeaders.put(HttpUtils.HEADER_NAME_COOKIE, cookie);
            }
        } catch (IllegalStateException e2) {
        }
        if ((i == 302 || i == 303) && this.mMethod.equals("POST")) {
            this.mMethod = "GET";
        }
        if (i == 307) {
            try {
                if (this.mBodyProvider != null) {
                    this.mBodyProvider.reset();
                }
            } catch (IOException e3) {
                return false;
            }
        } else {
            this.mHeaders.remove("Content-Type");
            this.mBodyProvider = null;
        }
        this.mHeaders.putAll(map);
        createAndQueueNewRequest();
        return true;
    }

    public void setupBasicAuthResponse(boolean z, String str, String str2) {
        this.mHeaders.put(authorizationHeader(z), "Basic " + computeBasicAuthResponse(str, str2));
        setupAuthResponse();
    }

    public void setupDigestAuthResponse(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.mHeaders.put(authorizationHeader(z), "Digest " + computeDigestAuthResponse(str, str2, str3, str4, str5, str6, str7));
        setupAuthResponse();
    }

    private void setupAuthResponse() {
        try {
            if (this.mBodyProvider != null) {
                this.mBodyProvider.reset();
            }
        } catch (IOException e) {
        }
        createAndQueueNewRequest();
    }

    public String getMethod() {
        return this.mMethod;
    }

    public static String computeBasicAuthResponse(String str, String str2) {
        Assert.assertNotNull(str);
        Assert.assertNotNull(str2);
        return new String(Base64.encodeBase64((str + ':' + str2).getBytes()));
    }

    public void waitUntilComplete() {
        this.mRequest.waitUntilComplete();
    }

    public void processRequest() {
        if (this.mConnection != null) {
            this.mConnection.processRequests(this.mRequest);
        }
    }

    private String computeDigestAuthResponse(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        String computeCnonce;
        Assert.assertNotNull(str);
        Assert.assertNotNull(str2);
        Assert.assertNotNull(str3);
        String computeDigest = computeDigest(str + ":" + str3 + ":" + str2, this.mMethod + ":" + this.mUrl, str4, str5, "000001", computeCnonce());
        String str8 = (((("username=" + doubleQuote(str) + ", ") + "realm=" + doubleQuote(str3) + ", ") + "nonce=" + doubleQuote(str4) + ", ") + "uri=" + doubleQuote(this.mUrl) + ", ") + "response=" + doubleQuote(computeDigest);
        if (str7 != null) {
            str8 = str8 + ", opaque=" + doubleQuote(str7);
        }
        if (str6 != null) {
            str8 = str8 + ", algorithm=" + str6;
        }
        if (str5 != null) {
            return str8 + ", qop=" + str5 + ", nc=000001, cnonce=" + doubleQuote(computeCnonce);
        }
        return str8;
    }

    public static String authorizationHeader(boolean z) {
        return !z ? AUTHORIZATION_HEADER : PROXY_AUTHORIZATION_HEADER;
    }

    private String computeDigest(String str, String str2, String str3, String str4, String str5, String str6) {
        if (str4 == null) {
            return KD(H(str), str3 + ":" + H(str2));
        }
        if (str4.equalsIgnoreCase("auth")) {
            return KD(H(str), str3 + ":" + str5 + ":" + str6 + ":" + str4 + ":" + H(str2));
        }
        return null;
    }

    private String KD(String str, String str2) {
        return H(str + ":" + str2);
    }

    private String H(String str) {
        byte[] digest;
        if (str == null || (digest = new Md5MessageDigest().digest(str.getBytes())) == null) {
            return null;
        }
        return bufferToHex(digest);
    }

    private String bufferToHex(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        if (bArr != null) {
            int length = bArr.length;
            if (length > 0) {
                StringBuilder sb = new StringBuilder(length * 2);
                for (int i = 0; i < length; i++) {
                    sb.append(cArr[(byte) ((bArr[i] & 240) >> 4)]);
                    sb.append(cArr[(byte) (bArr[i] & 15)]);
                }
                return sb.toString();
            }
            return "";
        }
        return null;
    }

    private String computeCnonce() {
        int nextInt = new Random().nextInt();
        return Integer.toString(nextInt == Integer.MIN_VALUE ? Shared.INFINITY : Math.abs(nextInt), 16);
    }

    private String doubleQuote(String str) {
        if (str != null) {
            return "\"" + str + "\"";
        }
        return null;
    }

    private void createAndQueueNewRequest() {
        if (this.mConnection != null) {
            RequestHandle queueSynchronousRequest = this.mRequestQueue.queueSynchronousRequest(this.mUrl, this.mUri, this.mMethod, this.mHeaders, this.mRequest.mEventHandler, this.mBodyProvider, this.mBodyLength);
            this.mRequest = queueSynchronousRequest.mRequest;
            this.mConnection = queueSynchronousRequest.mConnection;
            queueSynchronousRequest.processRequest();
            return;
        }
        this.mRequest = this.mRequestQueue.queueRequest(this.mUrl, this.mUri, this.mMethod, this.mHeaders, this.mRequest.mEventHandler, this.mBodyProvider, this.mBodyLength).mRequest;
    }
}
