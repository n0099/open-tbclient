package com.baidu.zeus;

import java.util.ArrayList;
import org.apache.http.HeaderElement;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;
/* loaded from: classes.dex */
public final class Headers {
    public static final int CONN_CLOSE = 1;
    public static final int CONN_KEEP_ALIVE = 2;
    private static final int HASH_ACCEPT_RANGES = 1397189435;
    private static final int HASH_CACHE_CONTROL = -208775662;
    private static final int HASH_CONN_DIRECTIVE = -775651618;
    private static final int HASH_CONTENT_DISPOSITION = -1267267485;
    private static final int HASH_CONTENT_ENCODING = 2095084583;
    private static final int HASH_CONTENT_LEN = -1132779846;
    private static final int HASH_CONTENT_TYPE = 785670158;
    private static final int HASH_ETAG = 3123477;
    private static final int HASH_EXPIRES = -1309235404;
    private static final int HASH_LAST_MODIFIED = 150043680;
    private static final int HASH_LOCATION = 1901043637;
    private static final int HASH_PRAGMA = -980228804;
    private static final int HASH_PROXY_AUTHENTICATE = -301767724;
    private static final int HASH_PROXY_CONNECTION = 285929373;
    private static final int HASH_REFRESH = 1085444827;
    private static final int HASH_SET_COOKIE = 1237214767;
    private static final int HASH_TRANSFER_ENCODING = 1274458357;
    private static final int HASH_WWW_AUTHENTICATE = -243037365;
    private static final int HASH_X_PERMITTED_CROSS_DOMAIN_POLICIES = -1345594014;
    private static final int HEADER_COUNT = 19;
    private static final int IDX_ACCEPT_RANGES = 10;
    private static final int IDX_CACHE_CONTROL = 12;
    private static final int IDX_CONN_DIRECTIVE = 4;
    private static final int IDX_CONTENT_DISPOSITION = 9;
    private static final int IDX_CONTENT_ENCODING = 3;
    private static final int IDX_CONTENT_LEN = 1;
    private static final int IDX_CONTENT_TYPE = 2;
    private static final int IDX_ETAG = 14;
    private static final int IDX_EXPIRES = 11;
    private static final int IDX_LAST_MODIFIED = 13;
    private static final int IDX_LOCATION = 5;
    private static final int IDX_PRAGMA = 16;
    private static final int IDX_PROXY_AUTHENTICATE = 8;
    private static final int IDX_PROXY_CONNECTION = 6;
    private static final int IDX_REFRESH = 17;
    private static final int IDX_SET_COOKIE = 15;
    private static final int IDX_TRANSFER_ENCODING = 0;
    private static final int IDX_WWW_AUTHENTICATE = 7;
    private static final int IDX_X_PERMITTED_CROSS_DOMAIN_POLICIES = 18;
    private static final String LOGTAG = "Http";
    public static final int NO_CONN_TYPE = 0;
    public static final long NO_CONTENT_LENGTH = -1;
    public static final long NO_TRANSFER_ENCODING = 0;
    public static final String TRANSFER_ENCODING = "transfer-encoding";
    public static final String CONTENT_LEN = "content-length";
    public static final String CONTENT_TYPE = "content-type";
    public static final String CONTENT_ENCODING = "content-encoding";
    public static final String CONN_DIRECTIVE = "connection";
    public static final String LOCATION = "location";
    public static final String PROXY_CONNECTION = "proxy-connection";
    public static final String WWW_AUTHENTICATE = "www-authenticate";
    public static final String PROXY_AUTHENTICATE = "proxy-authenticate";
    public static final String CONTENT_DISPOSITION = "content-disposition";
    public static final String ACCEPT_RANGES = "accept-ranges";
    public static final String EXPIRES = "expires";
    public static final String CACHE_CONTROL = "cache-control";
    public static final String LAST_MODIFIED = "last-modified";
    public static final String ETAG = "etag";
    public static final String SET_COOKIE = "set-cookie";
    public static final String PRAGMA = "pragma";
    public static final String REFRESH = "refresh";
    public static final String X_PERMITTED_CROSS_DOMAIN_POLICIES = "x-permitted-cross-domain-policies";
    private static final String[] sHeaderNames = {TRANSFER_ENCODING, CONTENT_LEN, CONTENT_TYPE, CONTENT_ENCODING, CONN_DIRECTIVE, LOCATION, PROXY_CONNECTION, WWW_AUTHENTICATE, PROXY_AUTHENTICATE, CONTENT_DISPOSITION, ACCEPT_RANGES, EXPIRES, CACHE_CONTROL, LAST_MODIFIED, ETAG, SET_COOKIE, PRAGMA, REFRESH, X_PERMITTED_CROSS_DOMAIN_POLICIES};
    private ArrayList<String> cookies = new ArrayList<>(2);
    private String[] mHeaders = new String[19];
    private ArrayList<String> mExtraHeaderNames = new ArrayList<>(4);
    private ArrayList<String> mExtraHeaderValues = new ArrayList<>(4);
    private long transferEncoding = 0;
    private long contentLength = -1;
    private int connectionType = 0;

    /* loaded from: classes.dex */
    public interface HeaderCallback {
        void header(String str, String str2);
    }

    public void parseHeader(CharArrayBuffer charArrayBuffer) {
        int lowercaseIndexOf = CharArrayBuffers.setLowercaseIndexOf(charArrayBuffer, 58);
        if (lowercaseIndexOf != -1) {
            String substringTrimmed = charArrayBuffer.substringTrimmed(0, lowercaseIndexOf);
            if (substringTrimmed.length() != 0) {
                int i = lowercaseIndexOf + 1;
                String substringTrimmed2 = charArrayBuffer.substringTrimmed(i, charArrayBuffer.length());
                switch (substringTrimmed.hashCode()) {
                    case HASH_X_PERMITTED_CROSS_DOMAIN_POLICIES /* -1345594014 */:
                        if (substringTrimmed.equals(X_PERMITTED_CROSS_DOMAIN_POLICIES)) {
                            this.mHeaders[18] = substringTrimmed2;
                            return;
                        }
                        return;
                    case HASH_EXPIRES /* -1309235404 */:
                        if (substringTrimmed.equals(EXPIRES)) {
                            this.mHeaders[11] = substringTrimmed2;
                            return;
                        }
                        return;
                    case HASH_CONTENT_DISPOSITION /* -1267267485 */:
                        if (substringTrimmed.equals(CONTENT_DISPOSITION)) {
                            this.mHeaders[9] = substringTrimmed2;
                            return;
                        }
                        return;
                    case HASH_CONTENT_LEN /* -1132779846 */:
                        if (substringTrimmed.equals(CONTENT_LEN)) {
                            this.mHeaders[1] = substringTrimmed2;
                            try {
                                this.contentLength = Long.parseLong(substringTrimmed2);
                                return;
                            } catch (NumberFormatException e) {
                                return;
                            }
                        }
                        return;
                    case HASH_PRAGMA /* -980228804 */:
                        if (substringTrimmed.equals(PRAGMA)) {
                            this.mHeaders[16] = substringTrimmed2;
                            return;
                        }
                        return;
                    case HASH_CONN_DIRECTIVE /* -775651618 */:
                        if (substringTrimmed.equals(CONN_DIRECTIVE)) {
                            this.mHeaders[4] = substringTrimmed2;
                            setConnectionType(charArrayBuffer, i);
                            return;
                        }
                        return;
                    case HASH_PROXY_AUTHENTICATE /* -301767724 */:
                        if (substringTrimmed.equals(PROXY_AUTHENTICATE)) {
                            this.mHeaders[8] = substringTrimmed2;
                            return;
                        }
                        return;
                    case HASH_WWW_AUTHENTICATE /* -243037365 */:
                        if (substringTrimmed.equals(WWW_AUTHENTICATE)) {
                            this.mHeaders[7] = substringTrimmed2;
                            return;
                        }
                        return;
                    case HASH_CACHE_CONTROL /* -208775662 */:
                        if (substringTrimmed.equals(CACHE_CONTROL)) {
                            this.mHeaders[12] = substringTrimmed2;
                            return;
                        }
                        return;
                    case HASH_ETAG /* 3123477 */:
                        if (substringTrimmed.equals(ETAG)) {
                            this.mHeaders[14] = substringTrimmed2;
                            return;
                        }
                        return;
                    case HASH_LAST_MODIFIED /* 150043680 */:
                        if (substringTrimmed.equals(LAST_MODIFIED)) {
                            this.mHeaders[13] = substringTrimmed2;
                            return;
                        }
                        return;
                    case HASH_PROXY_CONNECTION /* 285929373 */:
                        if (substringTrimmed.equals(PROXY_CONNECTION)) {
                            this.mHeaders[6] = substringTrimmed2;
                            setConnectionType(charArrayBuffer, i);
                            return;
                        }
                        return;
                    case HASH_CONTENT_TYPE /* 785670158 */:
                        if (substringTrimmed.equals(CONTENT_TYPE)) {
                            this.mHeaders[2] = substringTrimmed2;
                            return;
                        }
                        return;
                    case HASH_REFRESH /* 1085444827 */:
                        if (substringTrimmed.equals(REFRESH)) {
                            this.mHeaders[17] = substringTrimmed2;
                            return;
                        }
                        return;
                    case HASH_SET_COOKIE /* 1237214767 */:
                        if (substringTrimmed.equals(SET_COOKIE)) {
                            this.mHeaders[15] = substringTrimmed2;
                            this.cookies.add(substringTrimmed2);
                            return;
                        }
                        return;
                    case HASH_TRANSFER_ENCODING /* 1274458357 */:
                        if (substringTrimmed.equals(TRANSFER_ENCODING)) {
                            this.mHeaders[0] = substringTrimmed2;
                            HeaderElement[] parseElements = BasicHeaderValueParser.DEFAULT.parseElements(charArrayBuffer, new ParserCursor(i, charArrayBuffer.length()));
                            int length = parseElements.length;
                            if ("identity".equalsIgnoreCase(substringTrimmed2)) {
                                this.transferEncoding = -1L;
                                return;
                            } else if (length > 0 && "chunked".equalsIgnoreCase(parseElements[length - 1].getName())) {
                                this.transferEncoding = -2L;
                                return;
                            } else {
                                this.transferEncoding = -1L;
                                return;
                            }
                        }
                        return;
                    case HASH_ACCEPT_RANGES /* 1397189435 */:
                        if (substringTrimmed.equals(ACCEPT_RANGES)) {
                            this.mHeaders[10] = substringTrimmed2;
                            return;
                        }
                        return;
                    case HASH_LOCATION /* 1901043637 */:
                        if (substringTrimmed.equals(LOCATION)) {
                            this.mHeaders[5] = substringTrimmed2;
                            return;
                        }
                        return;
                    case HASH_CONTENT_ENCODING /* 2095084583 */:
                        if (substringTrimmed.equals(CONTENT_ENCODING)) {
                            this.mHeaders[3] = substringTrimmed2;
                            return;
                        }
                        return;
                    default:
                        this.mExtraHeaderNames.add(substringTrimmed);
                        this.mExtraHeaderValues.add(substringTrimmed2);
                        return;
                }
            }
        }
    }

    public long getTransferEncoding() {
        return this.transferEncoding;
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public int getConnectionType() {
        return this.connectionType;
    }

    public String getContentType() {
        return this.mHeaders[2];
    }

    public String getContentEncoding() {
        return this.mHeaders[3];
    }

    public String getLocation() {
        return this.mHeaders[5];
    }

    public String getWwwAuthenticate() {
        return this.mHeaders[7];
    }

    public String getProxyAuthenticate() {
        return this.mHeaders[8];
    }

    public String getContentDisposition() {
        return this.mHeaders[9];
    }

    public String getAcceptRanges() {
        return this.mHeaders[10];
    }

    public String getExpires() {
        return this.mHeaders[11];
    }

    public String getCacheControl() {
        return this.mHeaders[12];
    }

    public String getLastModified() {
        return this.mHeaders[13];
    }

    public String getEtag() {
        return this.mHeaders[14];
    }

    public ArrayList<String> getSetCookie() {
        return this.cookies;
    }

    public String getPragma() {
        return this.mHeaders[16];
    }

    public String getRefresh() {
        return this.mHeaders[17];
    }

    public String getXPermittedCrossDomainPolicies() {
        return this.mHeaders[18];
    }

    public void setContentLength(long j) {
        this.contentLength = j;
    }

    public void setContentType(String str) {
        this.mHeaders[2] = str;
    }

    public void setContentEncoding(String str) {
        this.mHeaders[3] = str;
    }

    public void setLocation(String str) {
        this.mHeaders[5] = str;
    }

    public void setWwwAuthenticate(String str) {
        this.mHeaders[7] = str;
    }

    public void setProxyAuthenticate(String str) {
        this.mHeaders[8] = str;
    }

    public void setContentDisposition(String str) {
        this.mHeaders[9] = str;
    }

    public void setAcceptRanges(String str) {
        this.mHeaders[10] = str;
    }

    public void setExpires(String str) {
        this.mHeaders[11] = str;
    }

    public void setCacheControl(String str) {
        this.mHeaders[12] = str;
    }

    public void setLastModified(String str) {
        this.mHeaders[13] = str;
    }

    public void setEtag(String str) {
        this.mHeaders[14] = str;
    }

    public void setXPermittedCrossDomainPolicies(String str) {
        this.mHeaders[18] = str;
    }

    public void getHeaders(HeaderCallback headerCallback) {
        for (int i = 0; i < 19; i++) {
            String str = this.mHeaders[i];
            if (str != null) {
                headerCallback.header(sHeaderNames[i], str);
            }
        }
        int size = this.mExtraHeaderNames.size();
        for (int i2 = 0; i2 < size; i2++) {
            headerCallback.header(this.mExtraHeaderNames.get(i2), this.mExtraHeaderValues.get(i2));
        }
    }

    private void setConnectionType(CharArrayBuffer charArrayBuffer, int i) {
        if (CharArrayBuffers.containsIgnoreCaseTrimmed(charArrayBuffer, i, "Close")) {
            this.connectionType = 1;
        } else if (CharArrayBuffers.containsIgnoreCaseTrimmed(charArrayBuffer, i, "Keep-Alive")) {
            this.connectionType = 2;
        }
    }
}
