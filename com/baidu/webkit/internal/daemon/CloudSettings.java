package com.baidu.webkit.internal.daemon;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
import com.baidu.webkit.internal.CfgFileUtils;
import com.baidu.webkit.internal.ConectivityUtils;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.internal.d;
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
/* loaded from: classes5.dex */
public class CloudSettings implements INoProGuard, INetListener {
    private static final String CLOUD_SETTING_URL = "https://browserkernel.baidu.com/config/t5config?cmd=1&";
    private static final String CLOUD_SETTING_URL_HTTP = "http://browserkernel.baidu.com/config/t5config?cmd=1&";
    private static final String LOG_TAG = "CloudSettings";
    public static List<a> NetRecordList = new ArrayList();
    private static boolean mDownloading;
    private static boolean mReady;
    private static boolean mSuccessDownload;
    public static a netRecord;
    private static String sLastGetTime;
    private Map<String, String> mHeader;
    private long mStartTime;
    private int mNetres = -1;
    private ByteArrayOutputStream mData = null;

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public long f3937a;
        public int b = -1;
        public boolean c;

        public a() {
        }

        final void a(int i) {
            Log.w(CloudSettings.LOG_TAG, "setNetRes " + i);
            this.b = i;
        }

        final void a(long j) {
            Log.w(CloudSettings.LOG_TAG, "setNetTime " + j);
            this.f3937a = j;
        }

        final void a(boolean z) {
            Log.w(CloudSettings.LOG_TAG, "mCronet " + z);
            this.c = z;
        }
    }

    private static void addRawLogItem(StringBuilder sb, String str, long j) {
        if (sb.length() > 0) {
            sb.append(ETAG.ITEM_SEPARATOR);
        }
        sb.append(str);
        sb.append(ETAG.EQUAL);
        sb.append(j);
    }

    private static void addRawLogItem(StringBuilder sb, String str, String str2) {
        if (sb.length() > 0) {
            sb.append(ETAG.ITEM_SEPARATOR);
        }
        sb.append(str);
        sb.append(ETAG.EQUAL);
        sb.append(str2);
    }

    private static void addRawLogItem(StringBuilder sb, String str, boolean z) {
        if (sb.length() > 0) {
            sb.append(ETAG.ITEM_SEPARATOR);
        }
        sb.append(str);
        sb.append(ETAG.EQUAL);
        sb.append(z);
    }

    private static String bytesToHexString(byte[] bArr) {
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
        if (cloudSettingUrl == null || cloudSettingUrl.length() <= 0) {
            cloudSettingUrl = CLOUD_SETTING_URL;
        }
        StringBuilder sb = new StringBuilder();
        addRawLogItem(sb, "package_name", context.getPackageName());
        addRawLogItem(sb, "sdk_ver", WebKitFactory.getSdkVersionName());
        if (WebKitFactory.getAppIdString() != null) {
            addRawLogItem(sb, "appid", WebKitFactory.getAppIdString());
        }
        if (WebKitFactory.getAppVersionString() != null) {
            addRawLogItem(sb, ETAG.KEY_APP_VERSION, WebKitFactory.getAppVersionString());
        }
        addRawLogItem(sb, ETAG.KEY_DEV_VER, Build.VERSION.SDK_INT);
        addRawLogItem(sb, "net_type", ConectivityUtils.getNetType(context));
        try {
            addRawLogItem(sb, "model", new String(Base64.encode(Build.MODEL.getBytes(), 0)));
        } catch (Throwable th) {
            Log.e(LOG_TAG, "model exception ", th);
        }
        String str = cloudSettingUrl + sb.toString();
        Log.w(LOG_TAG, "cloud url=" + str);
        return str;
    }

    public static boolean isCloudSettingsReady() {
        return mReady;
    }

    private static String refFormatNowDate() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date(System.currentTimeMillis()));
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
            if (decode != null) {
                sLastGetTime = reverseString(new String(decode, "utf-8"));
                b.b();
                String str2 = ZeusInitConfigUtils.get("engineCloudSettingsData", (String) null);
                if (str2 == null) {
                    Log.w(LOG_TAG, "restoreLastSentTimeFromCfg null");
                } else {
                    WebSettingsGlobalBlink.setCloudSettings(new String(str2.getBytes("utf-8"), "utf-8"));
                }
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

    private static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }

    private static void saveLastSentTimeToCfg(byte[] bArr) {
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

    private static synchronized boolean tryToUploadCloudSettings() {
        boolean z = false;
        synchronized (CloudSettings.class) {
            if (!mDownloading) {
                if (sLastGetTime == null) {
                    restoreLastSentTimeFromCfg();
                }
                if (!refFormatNowDate().equals(sLastGetTime)) {
                    mDownloading = true;
                    sLastGetTime = null;
                    z = true;
                } else if (!mSuccessDownload) {
                    mDownloading = true;
                    z = true;
                }
            }
        }
        return z;
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
        byte[] bArr;
        Exception e;
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
        if (this.mHeader != null) {
            String str = this.mHeader.get(Headers.LAST_MODIFIED);
            Log.w(LOG_TAG, "lastModify " + str);
            if (str != null) {
                Log.w(LOG_TAG, "lastModify1 " + str);
                CfgFileUtils.set(CfgFileUtils.KEY_CLOUDSETTINGS_LASTMODIFY, str);
            }
        }
        mSuccessDownload = true;
        byte[] byteArray = this.mData.toByteArray();
        Log.w(LOG_TAG, "onNetDownloadComplete " + byteArray.length);
        Log.w(LOG_TAG, "onNetDownloadComplete url " + bdNetTask.getUrl());
        try {
            bArr = new d(WebSettingsGlobalBlink.getRc4SecrectKey()).a(byteArray);
            try {
                WebSettingsGlobalBlink.setCloudSettings(new String(bArr, "utf-8"));
                VideoCloudSetting.saveVideoSettingToCfg();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                saveLastSentTimeToCfg(bArr);
                mReady = true;
            }
        } catch (Exception e3) {
            bArr = byteArray;
            e = e3;
        }
        saveLastSentTimeToCfg(bArr);
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
