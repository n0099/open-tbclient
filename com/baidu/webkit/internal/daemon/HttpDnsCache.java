package com.baidu.webkit.internal.daemon;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.CfgFileUtils;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.net.INetListener;
import com.baidu.webkit.sdk.Log;
import java.io.ByteArrayOutputStream;
/* loaded from: classes8.dex */
public class HttpDnsCache implements INoProGuard, INetListener {
    private static final String BACKUP_IP = "{\"area\": \"idc.ct\",   \"backup\": {    \"m.baidu.com\": {      \"ip\": [        \"220.181.38.130\",       \"220.181.38.129\"        ]    },    \"mbd.baidu.com\": {      \"ip\": [       \"180.149.145.177\",         \"112.34.111.104\",        \"111.206.37.66\",        \"180.97.104.214\",        \"117.185.17.20\",        \"112.80.248.204\",       \"14.215.177.166\",        \"183.232.231.184\",        \"163.177.151.106\"       ]    }  },   \"msg\": \"ok\",   \"ttl\": 300,  \"version\": \"v.01\"}";
    private static final String LOG_TAG = "HttpDnsCache";
    private static final String SERVER_LABEL = "?label=browser&type=ipv4&group=ipv6_11_16";
    private static final String SERVER_LABEL_V1 = "?label=browser&type=ipv4,ipv6&group=ipv6_11_23";
    private static final String SERVER_STATIC_URL = "https://httpsdns.baidu.com/v6/0010/";
    private static final String SERVER_URL = "https://180.76.76.112/v6/0010/";
    private static String mBackupIpVersion = "v.00";
    private static boolean mRestore;
    public ByteArrayOutputStream mData = null;
    private String mIpv4Data;
    private String mIpv6Data;

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

    private static String getHttpdnsLabel() {
        if (WebSettingsGlobalBlink.getIpv6HttpdnsEnv()) {
            Log.w(LOG_TAG, "SERVER_LABEL_V1");
            return SERVER_LABEL_V1;
        }
        Log.w(LOG_TAG, "SERVER_LABEL");
        return SERVER_LABEL;
    }

    private static String getUrl(Context context) {
        String str;
        String httpDnsUrlIP = WebSettingsGlobalBlink.getHttpDnsUrlIP();
        if (httpDnsUrlIP != null) {
            str = httpDnsUrlIP + getHttpdnsLabel();
            Log.w(LOG_TAG, "urlNative!=null: " + httpDnsUrlIP);
        } else {
            str = SERVER_URL + getHttpdnsLabel();
            Log.w(LOG_TAG, "urlNative==null ");
        }
        if (!TextUtils.isEmpty(mBackupIpVersion)) {
            str = (str + "&backup=") + mBackupIpVersion;
        }
        Log.d("cronet", "http_dns cloud url " + str);
        return str;
    }

    private static String getUrlStaticIP() {
        String str;
        String httpDnsUrlHOST = WebSettingsGlobalBlink.getHttpDnsUrlHOST();
        if (httpDnsUrlHOST != null) {
            str = httpDnsUrlHOST + getHttpdnsLabel();
            Log.w(LOG_TAG, "urlNative!=null: " + httpDnsUrlHOST);
        } else {
            str = SERVER_STATIC_URL + getHttpdnsLabel();
            Log.w(LOG_TAG, "urlNative==null ");
        }
        if (!TextUtils.isEmpty(mBackupIpVersion)) {
            str = (str + "&backup=") + mBackupIpVersion;
        }
        Log.d("cronet", "http_dns cloud url static ip " + str);
        return str;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0043 -> B:18:0x0022). Please submit an issue!!! */
    public static void restoreLastCacheFromCfg() {
        if (WebSettingsGlobalBlink.GetCloudSettingsValue("http_dns_persist_v1") != null && WebSettingsGlobalBlink.GetCloudSettingsValue("http_dns_persist_v1").equals("false")) {
            Log.i(LOG_TAG, "restoreLastCacheFromCfg http_dns_persist false");
            return;
        }
        try {
            if (!mRestore) {
                mRestore = true;
                Log.w(LOG_TAG, "restoreLastCacheFromCfg ok  ");
                String str = CfgFileUtils.get(CfgFileUtils.KEY_HTTP_DNS_CACHE, (String) null);
                if (str != null) {
                    WebSettingsGlobalBlink.setHttpDnsCache(str, 1);
                } else {
                    WebSettingsGlobalBlink.setHttpDnsCache(BACKUP_IP, 1);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void saveLastCacheToCfg(String str) {
        if (str != null) {
            try {
                CfgFileUtils.set(CfgFileUtils.KEY_HTTP_DNS_CACHE, str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

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

    public static void tryToUpdateHttpDnsCache(Context context) {
        if (WebSettingsGlobalBlink.GetCloudSettingsValue(ETAG.KEY_HTTP_DNS_ENABLE) != null && WebSettingsGlobalBlink.GetCloudSettingsValue(ETAG.KEY_HTTP_DNS_ENABLE).equals("false")) {
            Log.i(LOG_TAG, "tryToUpdateHttpDnsCache http_dns false");
        } else if (WebSettingsGlobalBlink.getNativeHttpdnsEnabled()) {
            Log.i(LOG_TAG, "getNativeHttpdnsEnabled enabled");
        } else if (WebSettingsGlobalBlink.isSFSwitchEnabled()) {
            Log.i(LOG_TAG, "tryToUpdateHttpDnsCache festival return");
        } else {
            Log.i(LOG_TAG, "tryToUpdateHttpDnsCache");
            restoreLastCacheFromCfg();
            if (WebSettingsGlobalBlink.GetCloudSettingsValue("block_http_dns") != null && WebSettingsGlobalBlink.GetCloudSettingsValue("block_http_dns").equals("true")) {
                Log.i(LOG_TAG, "block_http_dns1");
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
                e.printStackTrace();
            }
        }
    }

    public static void tryToUpdateHttpDnsCacheStaticIP(Context context) {
        if (WebSettingsGlobalBlink.GetCloudSettingsValue(ETAG.KEY_HTTP_DNS_ENABLE) != null && WebSettingsGlobalBlink.GetCloudSettingsValue(ETAG.KEY_HTTP_DNS_ENABLE).equals("false")) {
            Log.i(LOG_TAG, "tryToUpdateHttpDnsCacheStaticIP http_dns false");
        } else if (WebSettingsGlobalBlink.getNativeHttpdnsEnabled()) {
            Log.i(LOG_TAG, "getNativeHttpdnsEnabled enabled1");
        } else if (WebSettingsGlobalBlink.isSFSwitchEnabled()) {
            Log.i(LOG_TAG, "tryToUpdateHttpDnsCacheStaticIP festival return");
        } else {
            restoreLastCacheFromCfg();
            Log.i(LOG_TAG, "tryToUpdateHttpDnsCacheStaticIP");
            if (WebSettingsGlobalBlink.GetCloudSettingsValue("block_http_dns") != null && WebSettingsGlobalBlink.GetCloudSettingsValue("block_http_dns").equals("true")) {
                Log.i(LOG_TAG, "block_http_dns2");
                return;
            }
            try {
                BdNet bdNet = new BdNet(context);
                bdNet.setEventListener(new HttpDnsCache());
                BdNetTask bdNetTask = new BdNetTask();
                bdNetTask.setNet(bdNet);
                bdNetTask.setUrl(getUrlStaticIP());
                bdNet.start(bdNetTask, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
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
            String str = new String(byteArray, "utf-8");
            if (!TextUtils.isEmpty(str)) {
                WebSettingsGlobalBlink.setHttpDnsCache(str, 2);
            }
            String httpDnsCache = WebSettingsGlobalBlink.getHttpDnsCache();
            if (TextUtils.isEmpty(httpDnsCache)) {
                return;
            }
            Log.w(LOG_TAG, "saveLastCacheToCfg " + httpDnsCache);
            saveLastCacheToCfg(httpDnsCache);
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
}
