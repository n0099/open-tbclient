package com.baidu.webkit.internal.daemon;

import android.content.Context;
import com.baidu.ar.util.IoUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.ABTestConstants;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.net.INetListener;
import com.baidu.webkit.sdk.Log;
import java.io.ByteArrayOutputStream;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class HttpDnsCacheForHost implements INetListener {
    private static final String LOG_TAG = "HttpDnsCacheForHost";
    private static final String SERVER_URL = "https://180.76.76.112/";
    private static final String TARGET_EXTERNALHOST = "?dn=";
    public static ByteArrayOutputStream mData = null;
    private String mExternalHost = null;

    public HttpDnsCacheForHost() {
        mData = null;
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

    public String getUrl(Context context) {
        String httpDnsUrl = WebSettingsGlobalBlink.getHttpDnsUrl();
        if (httpDnsUrl != null) {
            Log.d(LOG_TAG, "urlNative!=null: " + httpDnsUrl);
        } else {
            Log.d(LOG_TAG, "urlNative==null ");
            httpDnsUrl = SERVER_URL;
        }
        if (this.mExternalHost != null) {
            httpDnsUrl = (httpDnsUrl + TARGET_EXTERNALHOST) + this.mExternalHost;
        }
        String transHttpsUrl = transHttpsUrl(httpDnsUrl);
        Log.d("cronet", "http_dns cloud url " + transHttpsUrl);
        return transHttpsUrl;
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
        if (mData == null) {
            mData = new ByteArrayOutputStream();
        }
        mData.write(bArr, 0, i);
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
        if (mData == null) {
            Log.w(LOG_TAG, "mData==null");
            return;
        }
        byte[] byteArray = mData.toByteArray();
        Log.w(LOG_TAG, "onNetDownloadComplete " + byteArray.length);
        Log.w(LOG_TAG, "onNetDownloadComplete url " + bdNetTask.getUrl());
        try {
            String replace = new String(byteArray, IoUtils.UTF_8).replace(" ", ",");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(this.mExternalHost, replace);
            WebSettingsGlobalBlink.setHttpDnsExtHostEngine(jSONObject.toString());
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

    public void setHttpDnsCacheHost(String str) {
        if (str != null) {
            this.mExternalHost = str;
        } else {
            this.mExternalHost = null;
        }
    }
}
