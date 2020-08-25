package com.baidu.webkit.internal.daemon;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.net.INetListener;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.ByteArrayOutputStream;
/* loaded from: classes19.dex */
public class HttpDnsCacheForHost implements INetListener {
    private static final String JSON_KEY_DATA = "data";
    private static final String JSON_KEY_EXTINFO = "ext-info";
    private static final String JSON_KEY_IP = "ip";
    private static final String JSON_KEY_IPV6 = "ipv6";
    private static final String JSON_KEY_IPV6_GROUP = "ipv6-group";
    private static final String JSON_KEY_MSG = "msg";
    private static final String LOG_TAG = "HttpDnsCacheForHost";
    private static final String MSG_ERR = "error";
    private static final String SERVER_URL = "https://180.76.76.112/v6/0010";
    private static final String SERVER_URL_IPV6_ONLY = "https://[240c:4006::6666]/v6/0010";
    private static final String TARGET_EXTERNALHOST = "?dn=";
    public ByteArrayOutputStream mData = null;
    private String mExternalHost;
    private boolean mIpv6Only;

    public static String transHttpsUrl(String str) {
        boolean z = true;
        try {
            if (WebSettingsGlobalBlink.GetCloudSettingsValue("https_dns") != null && WebSettingsGlobalBlink.GetCloudSettingsValue("https_dns").equals("false")) {
                z = false;
            }
            return z ? (str == null || !str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) ? str.replace("http://", SapiUtils.COOKIE_HTTPS_URL_PREFIX) : str : (str == null || !str.startsWith("http://")) ? str.replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "http://") : str;
        } catch (Exception e) {
            return str;
        }
    }

    public static void tryToUpdateHttpDnsCacheHost(String str, boolean z) {
        if (str == null) {
            return;
        }
        if (WebSettingsGlobalBlink.GetCloudSettingsValue("block_http_dns") != null && WebSettingsGlobalBlink.GetCloudSettingsValue("block_http_dns").equals("true")) {
            Log.i(LOG_TAG, "block_http_dns3");
            return;
        }
        try {
            BdNet bdNet = new BdNet(WebKitFactory.getContext());
            HttpDnsCacheForHost httpDnsCacheForHost = new HttpDnsCacheForHost();
            httpDnsCacheForHost.setHttpDnsCacheHost(str);
            httpDnsCacheForHost.setHttpDnsIpv6Only(z);
            bdNet.setEventListener(httpDnsCacheForHost);
            BdNetTask bdNetTask = new BdNetTask();
            bdNetTask.setNet(bdNet);
            if (z) {
                bdNetTask.setUrl(httpDnsCacheForHost.getUrlIpv6Only(WebKitFactory.getContext()));
            } else {
                bdNetTask.setUrl(httpDnsCacheForHost.getUrl(WebKitFactory.getContext()));
            }
            bdNet.start(bdNetTask, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUrl(Context context) {
        String httpDnsUrlIP = WebSettingsGlobalBlink.getHttpDnsUrlIP();
        if (httpDnsUrlIP != null) {
            Log.d(LOG_TAG, "urlNative!=null: " + httpDnsUrlIP);
        } else {
            Log.d(LOG_TAG, "urlNative==null ");
            httpDnsUrlIP = SERVER_URL;
        }
        if (this.mExternalHost != null) {
            httpDnsUrlIP = (httpDnsUrlIP + TARGET_EXTERNALHOST) + this.mExternalHost;
        }
        String transHttpsUrl = transHttpsUrl(httpDnsUrlIP);
        Log.d("cronet", "http_dns cloud url " + transHttpsUrl);
        return transHttpsUrl;
    }

    public String getUrlIpv6Only(Context context) {
        String transHttpsUrl = transHttpsUrl(((SERVER_URL_IPV6_ONLY + TARGET_EXTERNALHOST) + this.mExternalHost) + "&type=ipv6&group=ipv6");
        Log.d("cronet", "http_dns cloud url ipv6 " + transHttpsUrl);
        return transHttpsUrl;
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadComplete(BdNet bdNet) {
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadError(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetError netError, int i) {
        Log.w(LOG_TAG, "onNetDownloadError  " + bdNetTask.getUrl());
        try {
            WebSettingsGlobalBlink.setHttpDnsDnFailed(this.mExternalHost);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            Log.w(LOG_TAG, "mData==null " + bdNetTask.getUrl());
            return;
        }
        byte[] byteArray = this.mData.toByteArray();
        Log.w(LOG_TAG, "onNetDownloadComplete " + byteArray.length);
        Log.w(LOG_TAG, "onNetDownloadComplete url " + bdNetTask.getUrl());
        try {
            String str = new String(byteArray, "utf-8");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            WebSettingsGlobalBlink.setHttpDnsCache(str, 3);
        } catch (Exception e) {
            e.printStackTrace();
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

    public void setHttpDnsCacheHost(String str) {
        if (str != null) {
            this.mExternalHost = str;
        } else {
            this.mExternalHost = null;
        }
    }

    public void setHttpDnsIpv6Only(boolean z) {
        this.mIpv6Only = z;
    }
}
