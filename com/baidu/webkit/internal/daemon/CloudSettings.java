package com.baidu.webkit.internal.daemon;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import com.baidu.webkit.internal.CfgFileUtils;
import com.baidu.webkit.internal.ConectivityUtils;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.RC4;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import com.baidu.webkit.internal.utils.b;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.net.INetListener;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.VideoCloudSetting;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidubce.http.Headers;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class CloudSettings implements INoProGuard, INetListener {
    public static final String CLOUD_SETTING_URL = "https://browserkernel.baidu.com/config/t5config?cmd=1&";
    public static final String CLOUD_SETTING_URL_HTTP = "http://browserkernel.baidu.com/config/t5config?cmd=1&";
    public static final String LOG_TAG = "CloudSettings";
    public static List<a> NetRecordList = new ArrayList();
    public static boolean mDownloading;
    public static boolean mReady;
    public static boolean mSuccessDownload;
    public static a netRecord;
    public static String sLastGetTime;
    public Map<String, String> mHeader;
    public long mStartTime;
    public int mNetres = -1;
    public ByteArrayOutputStream mData = null;

    /* loaded from: classes8.dex */
    public class a {
        public long a;
        public int b = -1;
        public boolean c;

        public a() {
        }

        public final void a(int i) {
            Log.w(CloudSettings.LOG_TAG, "setNetRes ".concat(String.valueOf(i)));
            this.b = i;
        }

        public final void a(long j) {
            Log.w(CloudSettings.LOG_TAG, "setNetTime ".concat(String.valueOf(j)));
            this.a = j;
        }

        public final void a(boolean z) {
            Log.w(CloudSettings.LOG_TAG, "mCronet ".concat(String.valueOf(z)));
            this.c = z;
        }
    }

    public static void addRawLogItem(StringBuilder sb, String str, long j) {
        if (sb.length() > 0) {
            sb.append("&");
        }
        sb.append(str);
        sb.append("=");
        sb.append(j);
    }

    public static void addRawLogItem(StringBuilder sb, String str, String str2) {
        if (sb.length() > 0) {
            sb.append("&");
        }
        sb.append(str);
        sb.append("=");
        sb.append(str2);
    }

    public static void addRawLogItem(StringBuilder sb, String str, boolean z) {
        if (sb.length() > 0) {
            sb.append("&");
        }
        sb.append(str);
        sb.append("=");
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

    public static String getUrl(Context context) {
        String cloudSettingUrl = WebSettingsGlobalBlink.getCloudSettingUrl();
        cloudSettingUrl = (cloudSettingUrl == null || cloudSettingUrl.length() <= 0) ? "https://browserkernel.baidu.com/config/t5config?cmd=1&" : "https://browserkernel.baidu.com/config/t5config?cmd=1&";
        StringBuilder sb = new StringBuilder();
        addRawLogItem(sb, "package_name", context.getPackageName());
        addRawLogItem(sb, "sdk_ver", WebKitFactory.getSdkVersionName());
        if (WebKitFactory.getAppIdString() != null) {
            addRawLogItem(sb, "appid", WebKitFactory.getAppIdString());
        }
        if (WebKitFactory.getAppVersionString() != null) {
            addRawLogItem(sb, "appversion", WebKitFactory.getAppVersionString());
        }
        addRawLogItem(sb, ETAG.KEY_DEV_VER, Build.VERSION.SDK_INT);
        addRawLogItem(sb, "net_type", ConectivityUtils.getNetType(context));
        try {
            addRawLogItem(sb, "model", new String(Base64.encode(Build.MODEL.getBytes(), 0)));
        } catch (Throwable th) {
            Log.e(LOG_TAG, "model exception ", th);
        }
        String str = cloudSettingUrl + sb.toString();
        Log.w(LOG_TAG, "cloud url=".concat(String.valueOf(str)));
        return str;
    }

    public static boolean isCloudSettingsReady() {
        return mReady;
    }

    public static String refFormatNowDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
    }

    public static void restoreLastSentTimeFromCfg() {
        Log.w(LOG_TAG, "restoreLastSentTimeFromCfg");
        sLastGetTime = null;
        b.b();
        String str = ZeusInitConfigUtils.get("engineCloudSettingsTime", (String) null);
        if (str == null) {
            return;
        }
        try {
            byte[] decode = Base64.decode(str.getBytes(), 0);
            if (decode == null) {
                return;
            }
            sLastGetTime = reverseString(new String(decode, "utf-8"));
            b.b();
            String str2 = ZeusInitConfigUtils.get("engineCloudSettingsData", (String) null);
            if (str2 == null) {
                Log.w(LOG_TAG, "restoreLastSentTimeFromCfg null");
            } else {
                WebSettingsGlobalBlink.setCloudSettings(new String(str2.getBytes("utf-8"), "utf-8"));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void restoreSettingsToFrameWork() {
        try {
            b.b();
            String str = ZeusInitConfigUtils.get("engineCloudSettingsData", (String) null);
            if (str == null) {
                return;
            }
            WebSettingsGlobalBlink.setCloudSettings(new String(str.getBytes("utf-8"), "utf-8"));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }

    public static void saveLastSentTimeToCfg(byte[] bArr) {
        try {
            String refFormatNowDate = refFormatNowDate();
            sLastGetTime = refFormatNowDate;
            byte[] encode = Base64.encode(reverseString(refFormatNowDate).getBytes(), 0);
            if (encode != null) {
                String str = new String(encode, "utf-8");
                b.b();
                ZeusInitConfigUtils.set("engineCloudSettingsTime", str);
                ZeusInitConfigUtils.set("engineCloudSettingsData", new String(bArr, "utf-8"));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void tryToUpdateCloudSettings(Context context) {
        if (ConectivityUtils.getNetType(context).equals("unknown")) {
            return;
        }
        if (!WebKitFactory.getNeedDownloadCloudResource()) {
            Log.w(LOG_TAG, " tryToUpdateCloudSettings festival return");
        } else if (!WebKitFactory.isUserPrivacyEnabled()) {
            Log.i(LOG_TAG, " tryToUpdateCloudSettings isUserPrivacy return");
        } else if (!tryToUploadCloudSettings()) {
            Log.i(LOG_TAG, " tryToUpdateCloudSettings tryToUploadCloudSettings return");
        } else {
            Log.w(LOG_TAG, "tryToUpdateCloudSettings " + WebKitFactory.getNeedDownloadCloudResource());
            try {
                BdNet bdNet = new BdNet(context);
                bdNet.setEventListener(new CloudSettings());
                BdNetTask bdNetTask = new BdNetTask();
                bdNetTask.setNet(bdNet);
                bdNetTask.setUrl(getUrl(context));
                bdNet.start(bdNetTask, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized boolean tryToUploadCloudSettings() {
        synchronized (CloudSettings.class) {
            if (mDownloading) {
                return false;
            }
            if (sLastGetTime == null) {
                restoreLastSentTimeFromCfg();
            }
            if (!refFormatNowDate().equals(sLastGetTime)) {
                mDownloading = true;
                sLastGetTime = null;
                return true;
            } else if (mSuccessDownload) {
                return false;
            } else {
                mDownloading = true;
                return true;
            }
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadComplete(BdNet bdNet) {
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadError(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetError netError, int i) {
        a aVar = new a();
        aVar.a(System.currentTimeMillis() - this.mStartTime);
        aVar.a(0);
        aVar.a(bdNetTask.isUseCorenet());
        NetRecordList.add(aVar);
        mDownloading = false;
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
        this.mHeader = bdNetTask.getResHeaders();
    }

    @Override // com.baidu.webkit.net.INetListener
    public boolean onNetRedirect(BdNet bdNet, BdNetTask bdNetTask, int i) {
        return false;
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetResponseCode(BdNet bdNet, BdNetTask bdNetTask, int i) {
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetStateChanged(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetState netState, int i) {
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetTaskComplete(BdNet bdNet, BdNetTask bdNetTask) {
        a aVar = new a();
        aVar.a(System.currentTimeMillis() - this.mStartTime);
        aVar.a(1);
        aVar.a(bdNetTask.isUseCorenet());
        NetRecordList.add(aVar);
        mDownloading = false;
        this.mNetres = 1;
        if (this.mData == null) {
            Log.w(LOG_TAG, "mData==null");
            return;
        }
        Map<String, String> map = this.mHeader;
        if (map != null) {
            String str = map.get(Headers.LAST_MODIFIED);
            Log.w(LOG_TAG, "lastModify ".concat(String.valueOf(str)));
            if (str != null) {
                Log.w(LOG_TAG, "lastModify1 ".concat(String.valueOf(str)));
                CfgFileUtils.set(CfgFileUtils.KEY_CLOUDSETTINGS_LASTMODIFY, str);
            }
        }
        mSuccessDownload = true;
        byte[] byteArray = this.mData.toByteArray();
        Log.w(LOG_TAG, "onNetDownloadComplete " + byteArray.length);
        Log.w(LOG_TAG, "onNetDownloadComplete url " + bdNetTask.getUrl());
        try {
            byteArray = new RC4(WebSettingsGlobalBlink.getRc4SecrectKey()).decrypt(byteArray);
            WebSettingsGlobalBlink.setCloudSettings(new String(byteArray, "utf-8"));
            VideoCloudSetting.saveVideoSettingToCfg();
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveLastSentTimeToCfg(byteArray);
        mReady = true;
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetTaskStart(BdNet bdNet, BdNetTask bdNetTask) {
        Log.w(LOG_TAG, "onNetTaskStart  " + bdNetTask.getUrl());
        Log.w(LOG_TAG, "getUsingChromiumNet  " + bdNetTask.isUseCorenet());
        this.mStartTime = System.currentTimeMillis();
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetUploadComplete(BdNet bdNet, BdNetTask bdNetTask) {
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetUploadData(BdNet bdNet, BdNetTask bdNetTask, int i, int i2) {
    }
}
