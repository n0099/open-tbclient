package com.baidu.webkit.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.text.TextUtils;
import com.a.a.a.a.a.a.a;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class VideoStatisticsUpload {
    private static final int BUFF_SIZE = 4096;
    public static final String CRASH_LOG = "crashlog";
    public static final String VIDEO_LOG = "videolog";
    public static String TAG = "VideoStatisticsUpload";
    private static String logFileName = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class MyRunner implements Runnable {
        String alias;
        String cuid;
        boolean deletAfterUpload;
        String[] files;
        String logType;
        StringBuffer msg;
        UploadStatus status;
        boolean useHttps;

        MyRunner(String str, String str2, String str3, boolean z, String str4, boolean z2) {
            this.files = null;
            this.deletAfterUpload = false;
            this.status = UploadStatus.Success;
            this.msg = new StringBuffer("");
            this.logType = null;
            this.cuid = null;
            this.useHttps = false;
            this.alias = null;
            this.files = new String[]{str};
            this.deletAfterUpload = z2;
            this.logType = str2;
            this.cuid = str3;
            this.useHttps = z;
            this.alias = str4;
        }

        MyRunner(File[] fileArr, String str, String str2, boolean z, boolean z2) {
            this.files = null;
            this.deletAfterUpload = false;
            this.status = UploadStatus.Success;
            this.msg = new StringBuffer("");
            this.logType = null;
            this.cuid = null;
            this.useHttps = false;
            this.alias = null;
            this.files = new String[fileArr.length];
            for (int i = 0; i < fileArr.length; i++) {
                this.files[i] = fileArr[i].getPath();
            }
            this.deletAfterUpload = z2;
            this.logType = str;
            this.cuid = str2;
            this.useHttps = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            String[] strArr;
            FileInputStream fileInputStream;
            byte[] bArr;
            int i;
            for (String str : this.files) {
                FileInputStream fileInputStream2 = null;
                try {
                    fileInputStream = new FileInputStream(str);
                } catch (Exception e) {
                    e = e;
                }
                try {
                    int available = fileInputStream.available();
                    Log.d(VideoStatisticsUpload.TAG, "file size = " + available);
                    if (this.cuid == null || this.logType.equals("crashlog")) {
                        bArr = new byte[available];
                        i = 0;
                    } else {
                        i = this.cuid.getBytes().length;
                        bArr = new byte[available + i];
                        System.arraycopy(this.cuid.getBytes(), 0, bArr, 0, this.cuid.getBytes().length);
                        Log.d(VideoStatisticsUpload.TAG, "offset = " + i);
                    }
                    do {
                        i += fileInputStream.read(bArr, i, available);
                        available = fileInputStream.available();
                    } while (available > 0);
                    byte[] doCompress = VideoStatisticsUpload.doCompress(bArr, this.msg);
                    if (doCompress == null) {
                        this.status = UploadStatus.CompressFailed;
                    } else if (VideoStatisticsUpload.doUpload(doCompress, this.logType, this.useHttps, str, this.alias, this.msg)) {
                        if (!this.deletAfterUpload) {
                            this.msg.append("Upload Success;");
                        } else if (VideoStatisticsUpload.doDelete(str, this.msg)) {
                            this.msg.append("Upload Success;");
                        } else {
                            this.status = UploadStatus.DeletedFailed;
                        }
                        Log.d(VideoStatisticsUpload.TAG, AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
                    } else {
                        this.status = UploadStatus.UploadFailed;
                    }
                    fileInputStream.close();
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    a.a(e);
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e3) {
                            Log.d(VideoStatisticsUpload.TAG, "MyRunner.run io exception");
                        }
                    }
                    Log.d(VideoStatisticsUpload.TAG, "end " + str);
                    Log.d(VideoStatisticsUpload.TAG, "onFinished Notify app with callback");
                }
                Log.d(VideoStatisticsUpload.TAG, "onFinished Notify app with callback");
            }
        }
    }

    /* loaded from: classes11.dex */
    public enum UploadStatus {
        Success,
        CompressFailed,
        EncryptFailed,
        UploadFailed,
        DeletedFailed
    }

    static byte[] doCompress(byte[] bArr, StringBuffer stringBuffer) {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayInputStream byteArrayInputStream;
        if (bArr == null) {
            stringBuffer.append("doCompress Failed, source is null; ");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[4096];
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                while (true) {
                    try {
                        int read = byteArrayInputStream.read(bArr2);
                        if (read == -1) {
                            byteArrayInputStream.close();
                            gZIPOutputStream.close();
                            return byteArrayOutputStream.toByteArray();
                        }
                        gZIPOutputStream.write(bArr2, 0, read);
                    } catch (Exception e) {
                        e = e;
                        a.a(e);
                        stringBuffer.append(e.getMessage());
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (Exception e2) {
                                Log.d(TAG, "doCompress io exception");
                                return null;
                            }
                        }
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                            return null;
                        }
                        return null;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                gZIPOutputStream = null;
            }
        } catch (Exception e4) {
            e = e4;
            gZIPOutputStream = null;
            byteArrayInputStream = null;
        }
    }

    static boolean doDelete(String str, StringBuffer stringBuffer) {
        if (str == null || str.isEmpty()) {
            stringBuffer.append("Failed to remove empty file  " + str);
            return false;
        }
        File file = new File(str);
        if (file.isFile() && file.delete()) {
            return true;
        }
        stringBuffer.append("Failed to remove file  " + file.getName());
        Log.e(TAG, "Failed to remove file - " + file.getName());
        return false;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x00f6: ARRAY_LENGTH  (r8v0 int A[REMOVE]) = (r10v0 byte[]))] */
    static boolean doUpload(byte[] bArr, String str, boolean z, String str2, String str3, StringBuffer stringBuffer) {
        OutputStream outputStream;
        HttpsURLConnection httpsURLConnection;
        ByteArrayInputStream byteArrayInputStream = null;
        Log.d(TAG, "doUpload data=" + Arrays.toString(bArr) + ", logType" + str + ", name=" + str2);
        String substring = str2.substring(str2.lastIndexOf(47) + 1);
        if (bArr == null || substring == null || substring.isEmpty()) {
            if (bArr == null) {
                stringBuffer.append("doUpload Failed, data is null");
            } else if (substring == null) {
                stringBuffer.append("doUpload Failed, filename is null");
            } else if (substring.isEmpty()) {
                stringBuffer.append("doUpload Failed, filename is empty");
            }
            return false;
        }
        byte[] bArr2 = new byte[4096];
        try {
            if (z) {
                URL url = new URL("https://browserkernel.baidu.com/kw?type=engine");
                Log.d(TAG, "httpsEnable");
                Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream("-----BEGIN CERTIFICATE-----\nMIICZTCCAc4CAQAwDQYJKoZIhvcNAQEEBQAwezELMAkGA1UEBhMCQ04xCzAJBgNV\nBAgTAkJKMQswCQYDVQQHEwJCSjELMAkGA1UEChMCQkQxCzAJBgNVBAsTAkJEMRYw\nFAYDVQQDEw13d3cuYmFpZHUuY29tMSAwHgYJKoZIhvcNAQkBFhFsaWJpbjAyQGJh\naWR1LmNvbTAeFw0xMjA1MTAwMjMzNTVaFw0xMjA2MDkwMjMzNTVaMHsxCzAJBgNV\nBAYTAkNOMQswCQYDVQQIEwJCSjELMAkGA1UEBxMCQkoxCzAJBgNVBAoTAkJEMQsw\nCQYDVQQLEwJCRDEWMBQGA1UEAxMNd3d3LmJhaWR1LmNvbTEgMB4GCSqGSIb3DQEJ\nARYRbGliaW4wMkBiYWlkdS5jb20wgZ8wDQYJKoZIhvcNAQEBBQADgY0AMIGJAoGB\nALckGzvn6jcMqYpXrZKuuCYlVJIgN2ETsnvjCtO1va5u3p0EL9CuR5BlHocJadzM\nhTI7rH/nao8mXRIcJ4Q6lOv5TAotcKUv7ri9YZ48smpE3+KXVB+Mjau05OfiYI2h\nqlYy56acRSgyp8Uj65PXL8+gae8Gx+6lq0XOKduolmmNAgMBAAEwDQYJKoZIhvcN\nAQEEBQADgYEAYGPEvv1fc4XySq+9+5jFi4TxlNy9vAWpHOjsmODM9gs5/9PQFG/c\nZc8Fz+T9IVRa8YI0mLuKlApGmvzHxwdWbtBU6AU8ifg1HBA/4VXweiq6fgRfaemd\njgW3PXjbd+OoZ0VI32TvrDErG83OYohQ5CAS2gKHfBXHJvKtmxUSdVE=\n-----END CERTIFICATE-----\n".getBytes()));
                KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore.load(null, null);
                keyStore.setCertificateEntry("ca", generateCertificate);
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init(keyStore);
                SSLContext.getInstance("TLS").init(null, trustManagerFactory.getTrustManagers(), null);
                httpsURLConnection = (HttpsURLConnection) url.openConnection();
            } else {
                URL url2 = new URL("http://browserkernel.baidu.com/kw?type=engine");
                Log.d(TAG, "httpsdisabled");
                httpsURLConnection = (HttpURLConnection) url2.openConnection();
            }
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            httpsURLConnection.setRequestProperty("Content-Type", "application/x-gzip");
            httpsURLConnection.setRequestProperty("Content-Length", new StringBuilder().append(bArr.length).toString());
            Log.d(TAG, "filename " + (str3 != null ? str3 : substring));
            StringBuilder sb = new StringBuilder("attchment;filename=");
            if (str3 == null) {
                str3 = substring;
            }
            httpsURLConnection.setRequestProperty("Content-Disposition", sb.append(str3).toString());
            httpsURLConnection.setRequestProperty("LogType", str);
            httpsURLConnection.setFixedLengthStreamingMode(bArr.length);
            httpsURLConnection.connect();
            ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
            try {
                OutputStream outputStream2 = httpsURLConnection.getOutputStream();
                while (true) {
                    try {
                        int read = byteArrayInputStream2.read(bArr2);
                        if (read == -1) {
                            byteArrayInputStream2.close();
                            outputStream2.flush();
                            outputStream2.close();
                            Log.d(TAG, "finish http");
                            return true;
                        }
                        outputStream2.write(bArr2, 0, read);
                    } catch (Exception e) {
                        e = e;
                        outputStream = outputStream2;
                        byteArrayInputStream = byteArrayInputStream2;
                        stringBuffer.append(e.getMessage());
                        a.a(e);
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (Exception e2) {
                                Log.d(TAG, "doUpload io exception");
                                Log.d(TAG, "failed http");
                                return false;
                            }
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        Log.d(TAG, "failed http");
                        return false;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                outputStream = null;
                byteArrayInputStream = byteArrayInputStream2;
            }
        } catch (Exception e4) {
            e = e4;
            outputStream = null;
        }
    }

    private static String getDestSplitStr(int i, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(str2);
            if (split.length > i) {
                return split[i];
            }
        }
        return "";
    }

    private static String getLogFileVersion(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("error_video-") || !str.endsWith(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX)) {
            if (str.equals("error_video.log")) {
                return VideoCloudSetting.getCyberSdkVersion();
            }
            return null;
        }
        String destSplitStr = getDestSplitStr(0, str.substring("error_video-".length(), str.length() - BdStatsConstant.StatsFile.LOG_FILE_SUFFIX.length()), Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        if (isRightVersionName(destSplitStr)) {
            return destSplitStr;
        }
        return null;
    }

    public static synchronized void init(Context context, String str) {
        synchronized (VideoStatisticsUpload.class) {
            if (context == null) {
                Log.e(TAG, "[ERROR]init ctx null");
            } else {
                searchVideoErrorLogFileAndUpload(context, str);
            }
        }
    }

    private static boolean isRightVersionName(String str) {
        String[] split;
        int length;
        if (TextUtils.isEmpty(str) || (length = (split = str.split("\\.")).length) != 4) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            try {
                if (Integer.valueOf(split[i]).intValue() < 0) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    private static void searchVideoErrorLogFileAndUpload(Context context, String str) {
        if (context == null || searchVideoErrorLogFileAndUpload(context, str, Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "baidu" + File.separator + "flyflow" + File.separator + "video_statistic" + File.separator + context.getPackageName() + File.separator)) {
            return;
        }
        searchVideoErrorLogFileAndUpload(context, str, context.getFilesDir().getAbsolutePath() + File.separator + "video_statistic" + File.separator);
    }

    private static boolean searchVideoErrorLogFileAndUpload(Context context, String str, String str2) {
        boolean z;
        File file = new File(str2);
        if (file.exists()) {
            String[] list = file.list();
            if (list == null) {
                return false;
            }
            z = false;
            for (String str3 : list) {
                String logFileVersion = getLogFileVersion(str3);
                if (logFileVersion != null) {
                    File file2 = new File(str2 + str3);
                    file2.exists();
                    file2.length();
                    if (file2.exists() && file2.length() > 0) {
                        uploadVideoErrorLogFile(context, str, file2.getPath(), logFileVersion);
                        z = true;
                    }
                }
            }
        } else {
            z = false;
        }
        return z;
    }

    public static boolean uploadLogFile(String str, String str2, String str3, String str4, boolean z, boolean z2) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        if (!new File(str).exists()) {
            Log.v(TAG, "uploadLogfile no  " + str);
            return false;
        }
        String str5 = null;
        if (str4 != null) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put("CUID").put(str4);
            try {
                jSONObject.put("CUID", jSONArray);
            } catch (JSONException e) {
                a.a(e);
            }
            str5 = jSONObject.toString();
        }
        Executors.newSingleThreadExecutor().execute(new MyRunner(str, str3, str5, z, str2, z2));
        return true;
    }

    private static void uploadVideoErrorLogFile(Context context, String str, String str2, String str3) {
        boolean z;
        boolean z2 = false;
        if (str2 != null) {
            if (!VideoCloudSetting.hasCyberSdkVersion()) {
                String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("video_log_enable");
                if (GetCloudSettingsValue != null) {
                    Log.v(TAG, "CloudSetting video_log_enable = " + GetCloudSettingsValue);
                    z = !GetCloudSettingsValue.equals("false");
                } else {
                    Log.w(TAG, "videoLogEnable is NULL so uses default value video_log_enable = true");
                    z = true;
                }
            } else if (!VideoCloudSetting.isErrorLogTimePassedEnough()) {
                Log.d(TAG, "isErrorLogTimePassedEnough failed");
                return;
            } else {
                Log.d(TAG, "isErrorLogTimePassedEnough ok");
                if (VideoCloudSetting.canUploadVideoErrorLog()) {
                    Log.d(TAG, "canUploadVideoErrorLog ok upload!!!");
                    VideoCloudSetting.updateLastUploadTime();
                    z = true;
                } else {
                    Log.d(TAG, "canUploadVideoErrorLog failed delete!!!");
                    z = false;
                }
            }
            if (!z) {
                new File(str2).delete();
                Log.d(TAG, "video error log file delete!!");
                return;
            }
            String GetCloudSettingsValue2 = WebSettingsGlobalBlink.GetCloudSettingsValue("https_enable");
            if (GetCloudSettingsValue2 == null || !GetCloudSettingsValue2.equals("false")) {
                z2 = true;
            }
            Log.d(TAG, "httpsEnable = " + z2);
            try {
                uploadLogFile(str2, "error_video-" + context.getPackageName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str3, "videolog", str, z2, true);
                Log.d(TAG, "video error log file upload!!");
            } catch (PackageManager.NameNotFoundException e) {
                Log.v(TAG, "get application package info fail!");
            }
        }
    }
}
