package com.baidu.webkit.internal.daemon;

import android.content.Context;
import com.baidu.ar.util.IoUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.ABTestConstants;
import com.baidu.webkit.internal.CfgFileUtils;
import com.baidu.webkit.internal.ConectivityUtils;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.net.INetListener;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class HttpDnsCache implements INoProGuard, INetListener {
    private static final String JSON_KEY_DATA = "data";
    private static final String JSON_KEY_IP = "ip";
    private static final String JSON_KEY_MSG = "msg";
    private static final String LOG_TAG = "HttpDnsCache";
    private static final String MSG_ERR = "error";
    private static final String SERVER_LABEL = "?label=browser";
    private static final String SERVER_URL = "https://180.76.76.112/?label=browser";
    public ByteArrayOutputStream mData;

    public HttpDnsCache() {
        this.mData = null;
        this.mData = null;
    }

    private void addRawLogItem(StringBuilder sb, String str, long j) {
        if (sb.length() > 0) {
            sb.append(ETAG.ITEM_SEPARATOR);
        }
        sb.append(str);
        sb.append(ETAG.EQUAL);
        sb.append(j);
    }

    private void addRawLogItem(StringBuilder sb, String str, String str2) {
        if (sb.length() > 0) {
            sb.append(ETAG.ITEM_SEPARATOR);
        }
        sb.append(str);
        sb.append(ETAG.EQUAL);
        sb.append(str2);
    }

    private void addRawLogItem(StringBuilder sb, String str, boolean z) {
        if (sb.length() > 0) {
            sb.append(ETAG.ITEM_SEPARATOR);
        }
        sb.append(str);
        sb.append(ETAG.EQUAL);
        sb.append(z);
    }

    public static String bytesToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    private static String getUrl(Context context) {
        String str = SERVER_URL;
        String httpDnsUrl = WebSettingsGlobalBlink.getHttpDnsUrl();
        if (httpDnsUrl != null) {
            str = httpDnsUrl + SERVER_LABEL;
            Log.w(LOG_TAG, "urlNative!=null: " + httpDnsUrl);
        } else {
            Log.w(LOG_TAG, "urlNative==null ");
        }
        String transHttpsUrl = transHttpsUrl(str);
        Log.d("cronet", "http_dns cloud url " + transHttpsUrl);
        return transHttpsUrl;
    }

    private String parseData(String str) {
        JSONObject jSONObject;
        String string;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.has("msg") && !jSONObject2.getString("msg").equals("error") && jSONObject2.has("data")) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject("data");
                JSONObject jSONObject4 = new JSONObject();
                Iterator<String> keys = jSONObject3.keys();
                while (keys.hasNext()) {
                    String obj = keys.next().toString();
                    if (obj != null) {
                        try {
                            if (jSONObject3.has(obj) && (jSONObject = jSONObject3.getJSONObject(obj)) != null && (string = jSONObject.getString(JSON_KEY_IP)) != null) {
                                jSONObject4.put(obj.toLowerCase(), string);
                            }
                        } catch (Exception e) {
                            Log.w(LOG_TAG, e.toString());
                        }
                    }
                }
                return jSONObject4.toString();
            }
            return null;
        } catch (Exception e2) {
            Log.w(LOG_TAG, e2.toString());
            return null;
        }
    }

    private static void restoreLastCacheFromCfg() {
        try {
            String str = CfgFileUtils.get(CfgFileUtils.KEY_HTTP_DNS_CACHE, (String) null);
            if (str != null) {
                WebSettingsGlobalBlink.setHttpDnsCache(str);
            }
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    private static void saveLastCacheToCfg(String str) {
        if (str != null) {
            try {
                CfgFileUtils.set(CfgFileUtils.KEY_HTTP_DNS_CACHE, str);
            } catch (Throwable th) {
                com.a.a.a.a.a.a.a.a(th);
            }
        }
    }

    public static String transHttpsUrl(String str) {
        boolean z = true;
        try {
            if (WebSettingsGlobalBlink.GetCloudSettingsValue("https_dns") != null && WebSettingsGlobalBlink.GetCloudSettingsValue("https_dns").equals(ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE)) {
                z = false;
            }
            return z ? (str == null || !str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) ? str.replace("http://", SapiUtils.COOKIE_HTTPS_URL_PREFIX) : str : (str == null || !str.startsWith("http://")) ? str.replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "http://") : str;
        } catch (Exception e) {
            return str;
        }
    }

    public static void tryToUpdateHttpDnsCache(Context context) {
        restoreLastCacheFromCfg();
        if (ConectivityUtils.getNetType(context).equals("unknown")) {
            return;
        }
        try {
            BdNet bdNet = new BdNet(context);
            bdNet.setEventListener(new HttpDnsCache());
            BdNetTask bdNetTask = new BdNetTask();
            bdNetTask.setNet(bdNet);
            bdNetTask.setUrl(getUrl(context));
            bdNet.start(bdNetTask, true);
        } catch (Exception e) {
            com.a.a.a.a.a.a.a.a(e);
        }
    }

    public static void tryToUpdateHttpDnsCache(String str) {
        if (str == null || ConectivityUtils.getNetType(WebKitFactory.getContext()).equals("unknown")) {
            return;
        }
        try {
            BdNet bdNet = new BdNet(WebKitFactory.getContext());
            HttpDnsCacheForHost httpDnsCacheForHost = new HttpDnsCacheForHost();
            httpDnsCacheForHost.setHttpDnsCacheHost(str);
            bdNet.setEventListener(httpDnsCacheForHost);
            BdNetTask bdNetTask = new BdNetTask();
            bdNetTask.setNet(bdNet);
            bdNetTask.setUrl(httpDnsCacheForHost.getUrl(WebKitFactory.getContext()));
            bdNet.start(bdNetTask, true);
        } catch (Exception e) {
            com.a.a.a.a.a.a.a.a(e);
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadComplete(BdNet bdNet) {
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadError(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetError netError, int i) {
        Log.w(LOG_TAG, "onNetDownloadError  " + bdNetTask.getUrl());
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetReceiveData(BdNet bdNet, BdNetTask bdNetTask, byte[] bArr, int i) {
        if (this.mData == null) {
            this.mData = new ByteArrayOutputStream();
        }
        this.mData.write(bArr, 0, i);
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetReceiveHeaders(BdNet bdNet, BdNetTask bdNetTask) {
    }

    @Override // com.baidu.webkit.net.INetListener
    public boolean onNetRedirect(BdNet bdNet, BdNetTask bdNetTask, int i) {
        return false;
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetResponseCode(BdNet bdNet, BdNetTask bdNetTask, int i) {
        Log.w(LOG_TAG, "onNetResponseCode  " + i + " url " + bdNetTask.getUrl());
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetStateChanged(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetState netState, int i) {
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetTaskComplete(BdNet bdNet, BdNetTask bdNetTask) {
        if (this.mData == null) {
            Log.w(LOG_TAG, "mData==null");
            return;
        }
        byte[] byteArray = this.mData.toByteArray();
        Log.w(LOG_TAG, "onNetDownloadComplete " + byteArray.length);
        Log.w(LOG_TAG, "onNetDownloadComplete url " + bdNetTask.getUrl());
        try {
            String parseData = parseData(new String(byteArray, IoUtils.UTF_8));
            WebSettingsGlobalBlink.setHttpDnsCache(parseData);
            saveLastCacheToCfg(parseData);
        } catch (Exception e) {
            com.a.a.a.a.a.a.a.a(e);
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetTaskStart(BdNet bdNet, BdNetTask bdNetTask) {
        Log.w(LOG_TAG, "onNetTaskStart  " + bdNetTask.getUrl());
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetUploadComplete(BdNet bdNet, BdNetTask bdNetTask) {
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetUploadData(BdNet bdNet, BdNetTask bdNetTask, int i, int i2) {
    }
}
