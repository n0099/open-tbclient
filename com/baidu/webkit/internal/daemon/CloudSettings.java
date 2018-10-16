package com.baidu.webkit.internal.daemon;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import com.baidu.ar.util.IoUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppDateTimeUtil;
import com.baidu.webkit.internal.CfgFileUtils;
import com.baidu.webkit.internal.ConectivityUtils;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.net.INetListener;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.VideoCloudSetting;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebSettings;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes2.dex */
public class CloudSettings implements INoProGuard, INetListener {
    private static final String CLOUD_SETTING_URL = "https://browserkernel.baidu.com/config/t5config?cmd=1&";
    private static final String LOG_TAG = "CloudSettings";
    public static a netRecord;
    private ByteArrayOutputStream mData;
    private static String sLastGetTime = null;
    private static boolean mDownloading = false;
    private static boolean mSuccessDownload = false;
    private static boolean mReady = false;
    public static List<a> NetRecordList = new ArrayList();
    private long mStartTime = 0;
    private int mNetres = -1;

    /* loaded from: classes2.dex */
    public class a {
        public long a = 0;
        public int b = -1;
        public boolean c = false;

        public a() {
        }

        final void a(int i) {
            Log.w(CloudSettings.LOG_TAG, "setNetRes " + i);
            this.b = i;
        }

        final void a(long j) {
            Log.w(CloudSettings.LOG_TAG, "setNetTime " + j);
            this.a = j;
        }

        final void a(boolean z) {
            Log.w(CloudSettings.LOG_TAG, "mCronet " + z);
            this.c = z;
        }
    }

    public CloudSettings() {
        this.mData = null;
        this.mData = null;
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

    private static String getUrl(Context context) {
        String cloudSettingUrl = WebSettingsGlobalBlink.getCloudSettingUrl();
        if (cloudSettingUrl == null || cloudSettingUrl.length() <= 0) {
            cloudSettingUrl = CLOUD_SETTING_URL;
        }
        StringBuilder sb = new StringBuilder();
        addRawLogItem(sb, ETAG.KEY_PACKAGE_NAME, context.getPackageName());
        addRawLogItem(sb, ETAG.KEY_SDK_VER, WebKitFactory.getSdkVersionName());
        if (WebKitFactory.getAppIdString() != null) {
            addRawLogItem(sb, "appid", WebKitFactory.getAppIdString());
        }
        addRawLogItem(sb, ETAG.KEY_DEV_VER, Build.VERSION.SDK_INT);
        addRawLogItem(sb, ETAG.KEY_NET_TYPE, ConectivityUtils.getNetType(context));
        addRawLogItem(sb, "cuid", WebSettings.getCuid());
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
        return new SimpleDateFormat(AiAppDateTimeUtil.DATE_FORMAT).format(new Date(System.currentTimeMillis()));
    }

    private static void restoreLastSentTimeFromCfg() {
        byte[] decode;
        sLastGetTime = null;
        String str = CfgFileUtils.get(CfgFileUtils.KEY_ENGINE_CLOUDSETTINGS_TIME, (String) null);
        if (str == null || (decode = Base64.decode(str.getBytes(), 0)) == null) {
            return;
        }
        try {
            sLastGetTime = reverseString(new String(decode, IoUtils.UTF_8));
            String str2 = CfgFileUtils.get(CfgFileUtils.KEY_ENGINE_CLOUDSETTINGS_DATA, (String) null);
            if (str2 == null) {
                Log.w(LOG_TAG, "restoreLastSentTimeFromCfg null");
            } else {
                WebSettingsGlobalBlink.setCloudSettings(new String(str2.getBytes(IoUtils.UTF_8), IoUtils.UTF_8));
            }
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void restoreSettingsToFrameWork() {
        try {
            String str = CfgFileUtils.get(CfgFileUtils.KEY_ENGINE_CLOUDSETTINGS_DATA, (String) null);
            if (str == null) {
                return;
            }
            WebSettingsGlobalBlink.setCloudSettings(new String(str.getBytes(IoUtils.UTF_8), IoUtils.UTF_8));
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    private static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }

    private static void saveLastSentTimeToCfg(byte[] bArr) {
        String refFormatNowDate = refFormatNowDate();
        sLastGetTime = refFormatNowDate;
        byte[] encode = Base64.encode(reverseString(refFormatNowDate).getBytes(), 0);
        if (encode != null) {
            try {
                CfgFileUtils.set(CfgFileUtils.KEY_ENGINE_CLOUDSETTINGS_TIME, new String(encode, IoUtils.UTF_8));
                CfgFileUtils.set(CfgFileUtils.KEY_ENGINE_CLOUDSETTINGS_DATA, new String(bArr, IoUtils.UTF_8));
            } catch (Throwable th) {
                com.a.a.a.a.a.a.a.a(th);
            }
        }
    }

    public static void tryToUpdateCloudSettings(Context context) {
        if (!ConectivityUtils.getNetType(context).equals("unknown") && tryToUploadCloudSettings()) {
            Log.w(LOG_TAG, "tryToUpdateCloudSettings");
            try {
                BdNet bdNet = new BdNet(context);
                bdNet.setEventListener(new CloudSettings());
                BdNetTask bdNetTask = new BdNetTask();
                bdNetTask.setNet(bdNet);
                bdNetTask.setUrl(getUrl(context));
                bdNet.start(bdNetTask, false);
            } catch (Exception e) {
                com.a.a.a.a.a.a.a.a(e);
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
        mSuccessDownload = true;
        byte[] byteArray = this.mData.toByteArray();
        Log.w(LOG_TAG, "onNetDownloadComplete " + byteArray.length);
        Log.w(LOG_TAG, "onNetDownloadComplete url " + bdNetTask.getUrl());
        try {
            bArr = new com.baidu.webkit.internal.a(WebSettingsGlobalBlink.getRc4SecrectKey()).a(byteArray);
            try {
                WebSettingsGlobalBlink.setCloudSettings(new String(bArr, IoUtils.UTF_8));
                VideoCloudSetting.saveVideoSettingToCfg();
            } catch (Exception e2) {
                e = e2;
                com.a.a.a.a.a.a.a.a(e);
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
