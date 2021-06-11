package com.baidubce.util;

import com.alipay.sdk.encrypt.a;
import com.baidubce.Protocol;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes5.dex */
public class HttpUtils {
    public static BitSet URI_UNRESERVED_CHARACTERS = new BitSet();
    public static String[] PERCENT_ENCODED_STRINGS = new String[256];
    public static boolean HTTP_VERBOSE = Boolean.parseBoolean(System.getProperty("bce.sdk.http", "false"));

    static {
        for (int i2 = 97; i2 <= 122; i2++) {
            URI_UNRESERVED_CHARACTERS.set(i2);
        }
        for (int i3 = 65; i3 <= 90; i3++) {
            URI_UNRESERVED_CHARACTERS.set(i3);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            URI_UNRESERVED_CHARACTERS.set(i4);
        }
        URI_UNRESERVED_CHARACTERS.set(45);
        URI_UNRESERVED_CHARACTERS.set(46);
        URI_UNRESERVED_CHARACTERS.set(95);
        URI_UNRESERVED_CHARACTERS.set(126);
        int i5 = 0;
        while (true) {
            String[] strArr = PERCENT_ENCODED_STRINGS;
            if (i5 >= strArr.length) {
                return;
            }
            strArr[i5] = String.format("%%%02X", Integer.valueOf(i5));
            i5++;
        }
    }

    public static URI appendUri(URI uri, String... strArr) {
        StringBuilder sb = new StringBuilder(uri.toASCIIString());
        for (String str : strArr) {
            if (str != null && str.length() > 0) {
                String normalizePath = normalizePath(str);
                if (normalizePath.startsWith("/")) {
                    if (sb.charAt(sb.length() - 1) == '/') {
                        sb.setLength(sb.length() - 1);
                    }
                } else if (sb.charAt(sb.length() - 1) != '/') {
                    sb.append('/');
                }
                sb.append(normalizePath);
            }
        }
        try {
            return new URI(sb.toString());
        } catch (URISyntaxException e2) {
            throw new RuntimeException("Unexpected error", e2);
        }
    }

    public static String generateHostHeader(URI uri) {
        String host = uri.getHost();
        if (isUsingNonDefaultPort(uri)) {
            return host + ":" + uri.getPort();
        }
        return host;
    }

    public static String getCanonicalQueryString(Map<String, String> map, boolean z) {
        if (map.isEmpty()) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!z || !"Authorization".equalsIgnoreCase(entry.getKey())) {
                String key = entry.getKey();
                CheckUtils.isNotNull(key, "parameter key should not be null");
                String value = entry.getValue();
                if (value != null) {
                    arrayList.add(normalize(key) + a.f1886h + normalize(value));
                } else if (z) {
                    arrayList.add(normalize(key) + a.f1886h);
                } else {
                    arrayList.add(normalize(key));
                }
            }
        }
        Collections.sort(arrayList);
        return JoinerUtils.on("&", arrayList);
    }

    public static boolean isUsingNonDefaultPort(URI uri) {
        String lowerCase = uri.getScheme().toLowerCase();
        int port = uri.getPort();
        if (port <= 0) {
            return false;
        }
        return lowerCase.equals(Protocol.HTTP.toString()) ? port != Protocol.HTTP.getDefaultPort() : lowerCase.equals(Protocol.HTTPS.toString()) && port != Protocol.HTTPS.getDefaultPort();
    }

    public static String normalize(String str) {
        byte[] bytes;
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (byte b2 : str.getBytes("UTF-8")) {
                int i2 = b2 & 255;
                if (URI_UNRESERVED_CHARACTERS.get(i2)) {
                    sb.append((char) b2);
                } else {
                    sb.append(PERCENT_ENCODED_STRINGS[i2]);
                }
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String normalizePath(String str) {
        return normalize(str).replace("%2F", "/");
    }

    public static void printRequest(Request request) {
        if (HTTP_VERBOSE) {
            BLog.info("\n-------------> ");
            BLog.info(request.method() + " " + request.url() + "");
            Headers headers = request.headers();
            for (int i2 = 0; i2 < headers.size(); i2++) {
                BLog.info(headers.name(i2) + ":" + headers.value(i2));
            }
        }
    }

    public static void printResponse(Response response) {
        if (HTTP_VERBOSE) {
            BLog.info("\n<------------- ");
            BLog.info(response.code() + " - " + response.message());
            Headers headers = response.headers();
            for (int i2 = 0; i2 < headers.size(); i2++) {
                BLog.info(headers.name(i2) + ":" + headers.value(i2));
            }
        }
    }
}
