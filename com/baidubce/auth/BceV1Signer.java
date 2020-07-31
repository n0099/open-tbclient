package com.baidubce.auth;

import android.annotation.SuppressLint;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidubce.BceConfig;
import com.baidubce.http.Headers;
import com.baidubce.internal.InternalRequest;
import com.baidubce.util.BLog;
import com.baidubce.util.CheckUtils;
import com.baidubce.util.DateUtils;
import com.baidubce.util.HashUtils;
import com.baidubce.util.HttpUtils;
import com.baidubce.util.JoinerUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import okhttp3.internal.http.HttpMethod;
@SuppressLint({"NewApi", "DefaultLocale"})
/* loaded from: classes19.dex */
public class BceV1Signer implements Signer {
    private static final Set<String> defaultHeadersToSign = new HashSet();

    static {
        defaultHeadersToSign.add("Host".toLowerCase());
        defaultHeadersToSign.add("Content-Length".toLowerCase());
        defaultHeadersToSign.add("Content-Type".toLowerCase());
        defaultHeadersToSign.add(Headers.CONTENT_MD5.toLowerCase());
    }

    @Override // com.baidubce.auth.Signer
    public void sign(InternalRequest internalRequest, BceCredentials bceCredentials) {
        sign(internalRequest, bceCredentials, null);
    }

    @Override // com.baidubce.auth.Signer
    public void sign(InternalRequest internalRequest, BceCredentials bceCredentials, SignOptions signOptions) {
        CheckUtils.isNotNull(internalRequest, "request should not be null.");
        if (bceCredentials != null) {
            if (signOptions == null) {
                if (internalRequest.getSignOptions() != null) {
                    signOptions = internalRequest.getSignOptions();
                } else {
                    signOptions = SignOptions.DEFAULT;
                }
            }
            String accessKeyId = bceCredentials.getAccessKeyId();
            String secretKey = bceCredentials.getSecretKey();
            internalRequest.addHeader("Host", HttpUtils.generateHostHeader(internalRequest.getUri()));
            String name = internalRequest.getHttpMethod().name();
            boolean z = HttpMethod.requiresRequestBody(name) || HttpMethod.permitsRequestBody(name);
            if (internalRequest.getHeaders().get("Content-Length") == null && internalRequest.getContent() == null && z) {
                internalRequest.addHeader("Content-Length", "0");
            }
            if (bceCredentials instanceof BceSessionCredentials) {
                internalRequest.addHeader(Headers.BCE_SECURITY_TOKEN, ((BceSessionCredentials) bceCredentials).getSessionToken());
            }
            Date timestamp = signOptions.getTimestamp();
            if (timestamp == null) {
                timestamp = new Date();
            }
            String on = JoinerUtils.on("/", BceConfig.BCE_AUTH_VERSION, accessKeyId, DateUtils.alternateIso8601DateFormat(timestamp), Integer.valueOf(signOptions.getExpirationInSeconds()));
            String sha256Hex = HashUtils.sha256Hex(secretKey, on);
            String canonicalURIPath = getCanonicalURIPath(internalRequest.getUri().getPath());
            String canonicalQueryString = HttpUtils.getCanonicalQueryString(internalRequest.getParameters(), true);
            SortedMap<String, String> headersToSign = getHeadersToSign(internalRequest.getHeaders(), signOptions.getHeadersToSign());
            String canonicalHeaders = getCanonicalHeaders(headersToSign);
            String str = "";
            if (signOptions.getHeadersToSign() != null) {
                str = JoinerUtils.on(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR, headersToSign.keySet()).trim().toLowerCase();
            }
            String on2 = JoinerUtils.on("\n", internalRequest.getHttpMethod(), canonicalURIPath, canonicalQueryString, canonicalHeaders);
            String on3 = JoinerUtils.on("/", on, str, HashUtils.sha256Hex(sha256Hex, on2));
            BLog.debug("CanonicalRequest:{}\tAuthorization:{}", on2.replace("\n", "[\\n]"), on3);
            internalRequest.addHeader("Authorization", on3);
        }
    }

    private String getCanonicalURIPath(String str) {
        if (str == null) {
            return "/";
        }
        if (str.startsWith("/")) {
            return HttpUtils.normalizePath(str);
        }
        return "/" + HttpUtils.normalizePath(str);
    }

    private String getCanonicalHeaders(SortedMap<String, String> sortedMap) {
        if (sortedMap.isEmpty()) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            String key = entry.getKey();
            if (key != null) {
                String value = entry.getValue();
                if (value == null) {
                    value = "";
                }
                arrayList.add(HttpUtils.normalize(key.trim().toLowerCase()) + ':' + HttpUtils.normalize(value.trim()));
            }
        }
        Collections.sort(arrayList);
        return JoinerUtils.on("\n", arrayList);
    }

    private SortedMap<String, String> getHeadersToSign(Map<String, String> map, Set<String> set) {
        TreeMap treeMap = new TreeMap();
        if (set != null) {
            HashSet hashSet = new HashSet();
            for (String str : set) {
                hashSet.add(str.trim().toLowerCase());
            }
            set = hashSet;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (entry.getValue() != null && !entry.getValue().isEmpty() && ((set == null && isDefaultHeaderToSign(key)) || (set != null && set.contains(key.toLowerCase()) && !"Authorization".equalsIgnoreCase(key)))) {
                treeMap.put(key, entry.getValue());
            }
        }
        return treeMap;
    }

    private boolean isDefaultHeaderToSign(String str) {
        String lowerCase = str.trim().toLowerCase();
        return lowerCase.startsWith(Headers.BCE_PREFIX) || defaultHeadersToSign.contains(lowerCase);
    }
}
