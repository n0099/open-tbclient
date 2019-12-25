package com.baidu.webkit.sdk.dumper;

import com.a.a.a.a.a.a.a;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.webkit.internal.e;
import com.baidu.webkit.sdk.Log;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class ZeusLogUploader {
    public static final String ADD_UPLOAD_FILE_FLAG = "uploadfailed";
    private static final int BUFF_SIZE = 4096;
    private static final String CRASH_IMEI = "imei";
    private static final String CRASH_IS_NATIVE = "is_native";
    public static final String CRASH_LOG = "crashlog";
    private static final String CRASH_SIGNAL = "signal";
    private static final String CRASH_TIME = "time_crash";
    public static final String NR_LOG = "nrlog";
    public static final String RECORD_LOG = "recordlog";
    private static final String TAG = "BREAKPAD";
    public static final int UploadStatus_CompressFailed = 1;
    public static final int UploadStatus_DecryptFailed = 8;
    public static final int UploadStatus_DecryptSuccess = 7;
    public static final int UploadStatus_DeletedFailed = 4;
    public static final int UploadStatus_EncryptFailed = 2;
    public static final int UploadStatus_EncryptSuccess = 6;
    public static final int UploadStatus_ExceptionHappended = 5;
    public static final int UploadStatus_Success = 0;
    public static final int UploadStatus_UploadFailed = 3;
    public static final String VIDEO_LOG = "videolog";
    private String mCuid;
    private String mType;
    private boolean mUseHttps;
    private static final BigInteger exponent = new BigInteger("65537");
    private static boolean sIsEnabled = false;
    private static boolean mUploadCrashLogFailedEncrypt = true;
    private static String mEncryptKey = null;

    /* loaded from: classes9.dex */
    public static class LogFilter implements FilenameFilter {
        String mLogType;

        /* JADX INFO: Access modifiers changed from: package-private */
        public LogFilter(String str) {
            this.mLogType = null;
            this.mLogType = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            if ("crashlog".equals(this.mLogType) || ZeusLogUploader.RECORD_LOG.equals(this.mLogType)) {
                return str.endsWith(".bdmp");
            }
            if ("videolog".equals(this.mLogType)) {
                return str.endsWith(BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
            }
            if (ZeusLogUploader.NR_LOG.equals(this.mLogType)) {
                return str.endsWith(".nr");
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class MyRunner implements Runnable {
        String cuid;
        boolean deletAfterUpload;
        String[] files;
        OnFinishedListener listener;
        String logType;
        boolean useHttps;
        int status = 0;
        StringBuffer msg = new StringBuffer("");

        MyRunner(String str, String str2, String str3, boolean z, boolean z2, OnFinishedListener onFinishedListener) {
            this.files = null;
            this.listener = null;
            this.deletAfterUpload = false;
            this.logType = null;
            this.cuid = null;
            this.useHttps = false;
            this.files = new String[]{str};
            this.deletAfterUpload = z2;
            this.listener = onFinishedListener;
            this.logType = str2;
            this.cuid = str3;
            this.useHttps = z;
        }

        MyRunner(File[] fileArr, String str, String str2, boolean z, boolean z2, OnFinishedListener onFinishedListener) {
            this.files = null;
            this.listener = null;
            this.deletAfterUpload = false;
            this.logType = null;
            this.cuid = null;
            this.useHttps = false;
            this.files = new String[fileArr.length];
            for (int i = 0; i < fileArr.length; i++) {
                this.files[i] = fileArr[i].getPath();
            }
            this.deletAfterUpload = z2;
            this.listener = onFinishedListener;
            this.logType = str;
            this.cuid = str2;
            this.useHttps = z;
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x009e  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x00ab A[SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            String[] strArr;
            FileInputStream fileInputStream;
            Exception e;
            boolean z;
            byte[] bArr;
            int i;
            for (String str : this.files) {
                try {
                    fileInputStream = new FileInputStream(str);
                    try {
                        int available = fileInputStream.available();
                        if (this.cuid == null || this.logType.equals("crashlog")) {
                            bArr = new byte[available];
                            i = 0;
                        } else {
                            i = this.cuid.getBytes().length;
                            bArr = new byte[available + i];
                            System.arraycopy(this.cuid.getBytes(), 0, bArr, 0, this.cuid.getBytes().length);
                        }
                        do {
                            i += fileInputStream.read(bArr, i, available);
                            available = fileInputStream.available();
                        } while (available > 0);
                        z = ZeusLogUploader.uploadFileEncryptJudge(bArr);
                    } catch (Exception e2) {
                        e = e2;
                        z = false;
                    }
                } catch (Exception e3) {
                    fileInputStream = null;
                    e = e3;
                    z = false;
                }
                try {
                    if (this.logType.equals("crashlog") && z && (bArr = ZeusLogUploader.doEncryptUploadFailedFile(bArr, bArr.length - 12, false)) == null) {
                        this.status = 8;
                    }
                    byte[] doCompress = ZeusLogUploader.doCompress(bArr, bArr.length, this.msg);
                    if (doCompress == null) {
                        this.status = 1;
                    } else if (!ZeusLogUploader.doUpload(doCompress, this.logType, this.useHttps, str, this.msg)) {
                        this.status = 3;
                    } else if (this.deletAfterUpload && !ZeusLogUploader.doDelete(str, this.msg)) {
                        this.status = 4;
                    }
                    fileInputStream.close();
                } catch (Exception e4) {
                    e = e4;
                    this.status = 5;
                    a.a(e);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e5) {
                            a.a(e5);
                        }
                    }
                    if (ZeusLogUploader.mUploadCrashLogFailedEncrypt) {
                        this.status = 2;
                    }
                    if (this.listener == null) {
                    }
                }
                if (ZeusLogUploader.mUploadCrashLogFailedEncrypt && this.status != 0 && this.logType.equals("crashlog") && !z && ZeusLogUploader.encryptUploadFailedFile(str, true) != 6) {
                    this.status = 2;
                }
                if (this.listener == null) {
                    this.listener.onFinished(str, this.status, this.msg.toString());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface OnFinishedListener {
        void onFinished(String str, int i, String str2);
    }

    public ZeusLogUploader(String str, String str2, boolean z) {
        this.mCuid = null;
        this.mType = null;
        this.mUseHttps = true;
        this.mType = str;
        this.mUseHttps = z;
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("CUID").put(str2);
        try {
            jSONObject.put("CUID", jSONArray);
        } catch (JSONException e) {
            a.a(e);
        }
        this.mCuid = jSONObject.toString();
    }

    public static boolean UploadLogDirectory(String str, String str2, boolean z, OnFinishedListener onFinishedListener) {
        if (!sIsEnabled || str == null || str.isEmpty()) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            File[] listFiles = file.listFiles(new LogFilter(str2));
            if (listFiles == null || listFiles.length == 0) {
                return false;
            }
            Thread thread = new Thread(new MyRunner(listFiles, str2, (String) null, true, z, onFinishedListener));
            thread.setName("T7@ZeusLogDir2");
            thread.start();
            return true;
        }
        return false;
    }

    public static boolean UploadLogFile(String str, String str2, boolean z, OnFinishedListener onFinishedListener) {
        if (!sIsEnabled || str == null || str.isEmpty()) {
            return false;
        }
        if (new File(str).exists()) {
            Thread thread = new Thread(new MyRunner(str, str2, (String) null, true, z, onFinishedListener));
            thread.setName("T7@ZeusLogFile2");
            thread.start();
            return true;
        }
        return false;
    }

    static byte[] doCompress(byte[] bArr, int i, StringBuffer stringBuffer) {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayInputStream byteArrayInputStream;
        if (bArr == null || i <= 0) {
            stringBuffer.append("doCompress Failed, source is null; ");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[4096];
        try {
            if (i > bArr.length) {
                i = bArr.length;
            }
            byteArrayInputStream = new ByteArrayInputStream(bArr, 0, i);
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
                                a.a(e2);
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
            stringBuffer.append("Failed to remove empty file:" + str);
            return false;
        }
        File file = new File(str);
        if (file.isFile() && file.delete()) {
            return true;
        }
        stringBuffer.append("Failed to remove file:" + file.getName());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] doEncryptUploadFailedFile(byte[] bArr, int i, boolean z) {
        byte[] bArr2 = null;
        if (bArr != null && bArr.length > 0 && i > 0 && mEncryptKey != null) {
            if (i > bArr.length) {
                i = bArr.length;
            }
            long currentTimeMillis = System.currentTimeMillis();
            byte[] bArr3 = new byte[i];
            System.arraycopy(bArr, 0, bArr3, 0, i);
            e eVar = new e(mEncryptKey);
            if (z) {
                eVar.a();
                bArr2 = new byte[bArr3.length];
                eVar.a(bArr3, bArr3.length, bArr2);
            } else {
                bArr2 = eVar.a(bArr3);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            Object[] objArr = new Object[2];
            objArr[0] = z ? "encrypt" : "decrypt";
            objArr[1] = Long.valueOf(currentTimeMillis2 - currentTimeMillis);
            Log.i(TAG, "%s upload file run time: %d (ms)", objArr);
        }
        return bArr2;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:60:0x01db */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:86:0x0068 */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x00e6: ARRAY_LENGTH  (r8v4 int A[REMOVE]) = (r11v0 byte[]))] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v22, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.OutputStream] */
    static boolean doUpload(byte[] bArr, String str, boolean z, String str2, StringBuffer stringBuffer) {
        String str3;
        HttpsURLConnection httpsURLConnection;
        ?? r3;
        boolean z2;
        HttpsURLConnection httpsURLConnection2 = null;
        r4 = 0;
        ?? r4 = 0;
        httpsURLConnection2 = null;
        httpsURLConnection2 = null;
        httpsURLConnection2 = null;
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
        str3 = "https://browserkernel.baidu.com/kw?type=engine";
        if (ZwDebug.debugModel()) {
            try {
                File file = new File("/sdcard/log_server.txt");
                if (file.exists()) {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    String readLine = bufferedReader.readLine();
                    str3 = readLine != null ? readLine : "https://browserkernel.baidu.com/kw?type=engine";
                    bufferedReader.close();
                } else {
                    Log.v(TAG, "no local server url ");
                }
            } catch (Exception e) {
                a.a(e);
            }
        }
        byte[] bArr2 = new byte[4096];
        try {
            if (z) {
                URL url = new URL(str3);
                try {
                    Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream("-----BEGIN CERTIFICATE-----\nMIICZTCCAc4CAQAwDQYJKoZIhvcNAQEEBQAwezELMAkGA1UEBhMCQ04xCzAJBgNV\nBAgTAkJKMQswCQYDVQQHEwJCSjELMAkGA1UEChMCQkQxCzAJBgNVBAsTAkJEMRYw\nFAYDVQQDEw13d3cuYmFpZHUuY29tMSAwHgYJKoZIhvcNAQkBFhFsaWJpbjAyQGJh\naWR1LmNvbTAeFw0xMjA1MTAwMjMzNTVaFw0xMjA2MDkwMjMzNTVaMHsxCzAJBgNV\nBAYTAkNOMQswCQYDVQQIEwJCSjELMAkGA1UEBxMCQkoxCzAJBgNVBAoTAkJEMQsw\nCQYDVQQLEwJCRDEWMBQGA1UEAxMNd3d3LmJhaWR1LmNvbTEgMB4GCSqGSIb3DQEJ\nARYRbGliaW4wMkBiYWlkdS5jb20wgZ8wDQYJKoZIhvcNAQEBBQADgY0AMIGJAoGB\nALckGzvn6jcMqYpXrZKuuCYlVJIgN2ETsnvjCtO1va5u3p0EL9CuR5BlHocJadzM\nhTI7rH/nao8mXRIcJ4Q6lOv5TAotcKUv7ri9YZ48smpE3+KXVB+Mjau05OfiYI2h\nqlYy56acRSgyp8Uj65PXL8+gae8Gx+6lq0XOKduolmmNAgMBAAEwDQYJKoZIhvcN\nAQEEBQADgYEAYGPEvv1fc4XySq+9+5jFi4TxlNy9vAWpHOjsmODM9gs5/9PQFG/c\nZc8Fz+T9IVRa8YI0mLuKlApGmvzHxwdWbtBU6AU8ifg1HBA/4VXweiq6fgRfaemd\njgW3PXjbd+OoZ0VI32TvrDErG83OYohQ5CAS2gKHfBXHJvKtmxUSdVE=\n-----END CERTIFICATE-----\n".getBytes()));
                    KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                    keyStore.load(null, null);
                    keyStore.setCertificateEntry("ca", generateCertificate);
                    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                    trustManagerFactory.init(keyStore);
                    SSLContext.getInstance("TLS").init(null, trustManagerFactory.getTrustManagers(), null);
                    HttpsURLConnection httpsURLConnection3 = (HttpsURLConnection) url.openConnection();
                    try {
                        try {
                            httpsURLConnection3.setDoInput(true);
                            httpsURLConnection3.setDoOutput(true);
                            httpsURLConnection3.setUseCaches(false);
                            httpsURLConnection3.setRequestMethod("POST");
                            httpsURLConnection3.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                            httpsURLConnection3.setRequestProperty("Content-Type", "application/x-gzip");
                            httpsURLConnection3.setRequestProperty("Content-Length", new StringBuilder().append(bArr.length).toString());
                            httpsURLConnection3.setRequestProperty("Content-Disposition", "attchment;filename=" + substring);
                            httpsURLConnection3.setRequestProperty("LogType", str);
                            httpsURLConnection3.setFixedLengthStreamingMode(bArr.length);
                            httpsURLConnection3.connect();
                            r3 = new ByteArrayInputStream(bArr);
                        } catch (Throwable th) {
                            httpsURLConnection2 = httpsURLConnection3;
                            th = th;
                            httpsURLConnection2.disconnect();
                            throw th;
                        }
                    } catch (Exception e2) {
                        r3 = null;
                        e = e2;
                        httpsURLConnection = httpsURLConnection3;
                    }
                    try {
                        OutputStream outputStream = httpsURLConnection3.getOutputStream();
                        while (true) {
                            int read = r3.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            outputStream.write(bArr2, 0, read);
                        }
                        r3.close();
                        outputStream.flush();
                        outputStream.close();
                        int responseCode = httpsURLConnection3.getResponseCode();
                        Log.d(TAG, "finish send the reqeust , responseCode = " + responseCode);
                        if (responseCode == 200) {
                            stringBuffer.append("Upload Success; The server has responed 200 . ");
                            httpsURLConnection3.disconnect();
                            z2 = true;
                            httpsURLConnection2 = outputStream;
                        } else {
                            stringBuffer.append("doUpload Failed, The server has responsed Code " + responseCode);
                            httpsURLConnection3.disconnect();
                            z2 = false;
                            httpsURLConnection2 = outputStream;
                        }
                    } catch (Exception e3) {
                        httpsURLConnection = httpsURLConnection3;
                        e = e3;
                        try {
                            stringBuffer.append(e.getMessage());
                            a.a(e);
                            if (r3 != null) {
                                try {
                                    r3.close();
                                } catch (Exception e4) {
                                    Log.d(TAG, "failed http.");
                                    httpsURLConnection.disconnect();
                                    return false;
                                }
                            }
                            if (r4 != 0) {
                                r4.close();
                            }
                            Log.d(TAG, "failed http.");
                            httpsURLConnection.disconnect();
                            return false;
                        } catch (Throwable th2) {
                            th = th2;
                            httpsURLConnection2 = httpsURLConnection;
                            httpsURLConnection2.disconnect();
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    a.a(th3);
                    stringBuffer.append("Upload Failed; " + th3.getMessage());
                    httpsURLConnection2.disconnect();
                    z2 = false;
                }
            } else {
                stringBuffer.append("doUpload Failed, HTTP is never supported!");
                httpsURLConnection2.disconnect();
                z2 = false;
            }
            return z2;
        } catch (Exception e5) {
            e = e5;
            httpsURLConnection = httpsURLConnection2;
            r3 = httpsURLConnection2;
            r4 = httpsURLConnection2;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004c A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0070 A[Catch: Exception -> 0x0092, TRY_ENTER, TRY_LEAVE, TryCatch #7 {Exception -> 0x0092, blocks: (B:22:0x003d, B:42:0x0070), top: B:74:0x003d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int encryptUploadFailedFile(String str, boolean z) {
        DataInputStream dataInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        DataInputStream dataInputStream2;
        int i;
        ByteArrayOutputStream byteArrayOutputStream2;
        byte[] doEncryptUploadFailedFile;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        FileOutputStream fileOutputStream = null;
        byteArrayOutputStream3 = null;
        int i2 = z ? 6 : 7;
        File file = new File(str);
        if (file.exists()) {
            try {
                dataInputStream = new DataInputStream(new FileInputStream(file));
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                } catch (Exception e) {
                    byteArrayOutputStream = null;
                    dataInputStream2 = dataInputStream;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = dataInputStream.read(bArr);
                        if (read != -1) {
                            byteArrayOutputStream2.write(bArr, 0, read);
                        } else {
                            try {
                                break;
                            } catch (Exception e2) {
                                i2 = 5;
                            }
                        }
                    }
                    byteArrayOutputStream2.close();
                    try {
                        dataInputStream.close();
                        i = i2;
                        byteArrayOutputStream = byteArrayOutputStream2;
                    } catch (Exception e3) {
                        byteArrayOutputStream = byteArrayOutputStream2;
                        i = 5;
                    }
                } catch (Exception e4) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    dataInputStream2 = dataInputStream;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e5) {
                        }
                    }
                    if (dataInputStream2 != null) {
                        try {
                            dataInputStream2.close();
                            i = 5;
                        } catch (Exception e6) {
                            i = 5;
                        }
                    } else {
                        i = 5;
                    }
                    doEncryptUploadFailedFile = doEncryptUploadFailedFile(byteArrayOutputStream.toByteArray(), byteArrayOutputStream.toByteArray().length, z);
                    if (doEncryptUploadFailedFile != null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream3 = byteArrayOutputStream2;
                    if (byteArrayOutputStream3 != null) {
                        try {
                            byteArrayOutputStream3.close();
                        } catch (Exception e7) {
                        }
                    }
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (Exception e8) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e9) {
                byteArrayOutputStream = null;
                dataInputStream2 = null;
            } catch (Throwable th3) {
                th = th3;
                dataInputStream = null;
            }
        } else {
            i = i2;
            byteArrayOutputStream = null;
        }
        try {
            doEncryptUploadFailedFile = doEncryptUploadFailedFile(byteArrayOutputStream.toByteArray(), byteArrayOutputStream.toByteArray().length, z);
            if (doEncryptUploadFailedFile != null) {
                return 5;
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str), false);
            try {
                fileOutputStream2.write(doEncryptUploadFailedFile);
                if (z) {
                    fileOutputStream2.write(ADD_UPLOAD_FILE_FLAG.getBytes());
                }
                fileOutputStream2.flush();
                fileOutputStream2.close();
                return i;
            } catch (Exception e10) {
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        return 5;
                    } catch (IOException e11) {
                        a.a(e11);
                        return 5;
                    }
                }
                return 5;
            }
        } catch (Exception e12) {
        }
    }

    public static void setEnabled(boolean z) {
        sIsEnabled = z;
    }

    public static void setEncryptKey(String str) {
        mEncryptKey = str;
    }

    public static void setUploadCrashLogFailedEncrypt(boolean z) {
        mUploadCrashLogFailedEncrypt = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean uploadFileEncryptJudge(byte[] bArr) {
        return 12 < bArr.length && ADD_UPLOAD_FILE_FLAG.equals(new String(bArr, bArr.length + (-12), 12));
    }

    public final boolean uploadLogDirectory(String str, boolean z, OnFinishedListener onFinishedListener) {
        if (!sIsEnabled || str == null || str.isEmpty()) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            File[] listFiles = file.listFiles(new LogFilter(this.mType));
            if (listFiles.length != 0) {
                Thread thread = new Thread(new MyRunner(listFiles, this.mType, this.mCuid, this.mUseHttps, z, onFinishedListener));
                thread.setName("T7@ZeusLogDir1");
                thread.start();
                return true;
            }
            return false;
        }
        return false;
    }

    public final boolean uploadLogFile(String str, boolean z, OnFinishedListener onFinishedListener) {
        if (!sIsEnabled || str == null || str.isEmpty() || !new File(str).exists()) {
            return false;
        }
        Thread thread = new Thread(new MyRunner(str, this.mType, this.mCuid, this.mUseHttps, z, onFinishedListener));
        thread.setName("T7@ZeusLogFile1");
        thread.start();
        return true;
    }
}
