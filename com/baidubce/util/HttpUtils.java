package com.baidubce.util;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.webkit.internal.ETAG;
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
/* loaded from: classes4.dex */
public class HttpUtils {
    private static BitSet URI_UNRESERVED_CHARACTERS = new BitSet();
    private static String[] PERCENT_ENCODED_STRINGS = new String[256];
    private static boolean HTTP_VERBOSE = Boolean.parseBoolean(System.getProperty("bce.sdk.http", "false"));

    static {
        for (int i = 97; i <= 122; i++) {
            URI_UNRESERVED_CHARACTERS.set(i);
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            URI_UNRESERVED_CHARACTERS.set(i2);
        }
        for (int i3 = 48; i3 <= 57; i3++) {
            URI_UNRESERVED_CHARACTERS.set(i3);
        }
        URI_UNRESERVED_CHARACTERS.set(45);
        URI_UNRESERVED_CHARACTERS.set(46);
        URI_UNRESERVED_CHARACTERS.set(95);
        URI_UNRESERVED_CHARACTERS.set(Opcodes.IAND);
        for (int i4 = 0; i4 < PERCENT_ENCODED_STRINGS.length; i4++) {
            PERCENT_ENCODED_STRINGS[i4] = String.format("%%%02X", Integer.valueOf(i4));
        }
    }

    public static String normalizePath(String str) {
        return normalize(str).replace("%2F", "/");
    }

    public static String normalize(String str) {
        byte[] bytes;
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (byte b : str.getBytes("UTF-8")) {
                if (URI_UNRESERVED_CHARACTERS.get(b & 255)) {
                    sb.append((char) b);
                } else {
                    sb.append(PERCENT_ENCODED_STRINGS[b & 255]);
                }
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String generateHostHeader(URI uri) {
        String host = uri.getHost();
        if (isUsingNonDefaultPort(uri)) {
            return host + ":" + uri.getPort();
        }
        return host;
    }

    public static boolean isUsingNonDefaultPort(URI uri) {
        String lowerCase = uri.getScheme().toLowerCase();
        int port = uri.getPort();
        if (port <= 0) {
            return false;
        }
        if (lowerCase.equals(Protocol.HTTP.toString())) {
            return port != Protocol.HTTP.getDefaultPort();
        } else if (lowerCase.equals(Protocol.HTTPS.toString())) {
            return port != Protocol.HTTPS.getDefaultPort();
        } else {
            return false;
        }
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
                if (value == null) {
                    if (z) {
                        arrayList.add(normalize(key) + '=');
                    } else {
                        arrayList.add(normalize(key));
                    }
                } else {
                    arrayList.add(normalize(key) + '=' + normalize(value));
                }
            }
        }
        Collections.sort(arrayList);
        return JoinerUtils.on(ETAG.ITEM_SEPARATOR, arrayList);
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
        } catch (URISyntaxException e) {
            throw new RuntimeException("Unexpected error", e);
        }
    }

    public static void printRequest(Request request) {
        if (HTTP_VERBOSE) {
            BLog.info("\n-------------> ");
            BLog.info(request.method() + " " + request.url() + "");
            Headers headers = request.headers();
            for (int i = 0; i < headers.size(); i++) {
                BLog.info(headers.name(i) + ":" + headers.value(i));
            }
        }
    }

    public static void printResponse(Response response) {
        if (HTTP_VERBOSE) {
            BLog.info("\n<------------- ");
            BLog.info(response.code() + " - " + response.message());
            Headers headers = response.headers();
            for (int i = 0; i < headers.size(); i++) {
                BLog.info(headers.name(i) + ":" + headers.value(i));
            }
        }
    }
}
