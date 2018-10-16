package com.baidu.webkit.sdk.dumper;

import com.a.a.a.a.a.a.a;
import com.baidu.webkit.sdk.Log;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import org.apache.http.entity.mime.MIME;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class ZeusLogUploader {
    private static final int BUFF_SIZE = 4096;
    private static final String CRASH_IMEI = "imei";
    private static final String CRASH_IS_NATIVE = "is_native";
    public static final String CRASH_LOG = "crashlog";
    private static final String CRASH_SIGNAL = "signal";
    private static final String CRASH_TIME = "time_crash";
    public static final String NR_LOG = "nrlog";
    private static final String TAG = "BREAKPAD";
    public static final int UploadStatus_CompressFailed = 1;
    public static final int UploadStatus_DeletedFailed = 4;
    public static final int UploadStatus_EncryptFailed = 2;
    public static final int UploadStatus_Success = 0;
    public static final int UploadStatus_UploadFailed = 3;
    public static final String VIDEO_LOG = "videolog";
    private static final BigInteger exponent = new BigInteger("65537");
    private String mCuid;
    private String mType;
    private boolean mUseHttps;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class LogFilter implements FilenameFilter {
        String mLogType;

        LogFilter(String str) {
            this.mLogType = null;
            this.mLogType = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            if ("crashlog".equals(this.mLogType)) {
                return str.endsWith(".bdmp");
            }
            if ("videolog".equals(this.mLogType)) {
                return str.endsWith(".log");
            }
            if (ZeusLogUploader.NR_LOG.equals(this.mLogType)) {
                return str.endsWith(".nr");
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
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

        /* JADX WARN: Removed duplicated region for block: B:19:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0069 A[SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            String[] strArr;
            FileInputStream fileInputStream;
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
                        byte[] doCompress = ZeusLogUploader.doCompress(bArr, this.msg);
                        if (doCompress == null) {
                            this.status = 1;
                        } else if (!ZeusLogUploader.doUpload(doCompress, this.logType, this.useHttps, str, this.msg)) {
                            this.status = 3;
                        } else if (this.deletAfterUpload && !ZeusLogUploader.doDelete(str, this.msg)) {
                            this.status = 4;
                        }
                        fileInputStream.close();
                    } catch (Exception e) {
                        e = e;
                        a.a(e);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e2) {
                                a.a(e2);
                            }
                        }
                        if (this.listener == null) {
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileInputStream = null;
                }
                if (this.listener == null) {
                    this.listener.onFinished(str, this.status, this.msg.toString());
                }
            }
        }
    }

    /* loaded from: classes2.dex */
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
        if (str == null || str.isEmpty()) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            File[] listFiles = file.listFiles(new LogFilter(str2));
            if (listFiles.length == 0) {
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
        if (str == null || str.isEmpty()) {
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

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x00e7: ARRAY_LENGTH  (r8v0 int A[REMOVE]) = (r10v0 byte[]))] */
    static boolean doUpload(byte[] bArr, String str, boolean z, String str2, StringBuffer stringBuffer) {
        String str3;
        HttpsURLConnection httpsURLConnection;
        HttpURLConnection httpURLConnection;
        ByteArrayInputStream byteArrayInputStream;
        OutputStream outputStream = null;
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
                Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream("-----BEGIN CERTIFICATE-----\nMIICZTCCAc4CAQAwDQYJKoZIhvcNAQEEBQAwezELMAkGA1UEBhMCQ04xCzAJBgNV\nBAgTAkJKMQswCQYDVQQHEwJCSjELMAkGA1UEChMCQkQxCzAJBgNVBAsTAkJEMRYw\nFAYDVQQDEw13d3cuYmFpZHUuY29tMSAwHgYJKoZIhvcNAQkBFhFsaWJpbjAyQGJh\naWR1LmNvbTAeFw0xMjA1MTAwMjMzNTVaFw0xMjA2MDkwMjMzNTVaMHsxCzAJBgNV\nBAYTAkNOMQswCQYDVQQIEwJCSjELMAkGA1UEBxMCQkoxCzAJBgNVBAoTAkJEMQsw\nCQYDVQQLEwJCRDEWMBQGA1UEAxMNd3d3LmJhaWR1LmNvbTEgMB4GCSqGSIb3DQEJ\nARYRbGliaW4wMkBiYWlkdS5jb20wgZ8wDQYJKoZIhvcNAQEBBQADgY0AMIGJAoGB\nALckGzvn6jcMqYpXrZKuuCYlVJIgN2ETsnvjCtO1va5u3p0EL9CuR5BlHocJadzM\nhTI7rH/nao8mXRIcJ4Q6lOv5TAotcKUv7ri9YZ48smpE3+KXVB+Mjau05OfiYI2h\nqlYy56acRSgyp8Uj65PXL8+gae8Gx+6lq0XOKduolmmNAgMBAAEwDQYJKoZIhvcN\nAQEEBQADgYEAYGPEvv1fc4XySq+9+5jFi4TxlNy9vAWpHOjsmODM9gs5/9PQFG/c\nZc8Fz+T9IVRa8YI0mLuKlApGmvzHxwdWbtBU6AU8ifg1HBA/4VXweiq6fgRfaemd\njgW3PXjbd+OoZ0VI32TvrDErG83OYohQ5CAS2gKHfBXHJvKtmxUSdVE=\n-----END CERTIFICATE-----\n".getBytes()));
                KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore.load(null, null);
                keyStore.setCertificateEntry("ca", generateCertificate);
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init(keyStore);
                SSLContext.getInstance("TLS").init(null, trustManagerFactory.getTrustManagers(), null);
                httpsURLConnection = (HttpsURLConnection) url.openConnection();
            } else {
                httpsURLConnection = (HttpURLConnection) new URL("http://browserkernel.baidu.com/kw?type=engine").openConnection();
            }
            try {
                try {
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setUseCaches(false);
                    httpsURLConnection.setRequestMethod("POST");
                    httpsURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                    httpsURLConnection.setRequestProperty("Content-Type", "application/x-gzip");
                    httpsURLConnection.setRequestProperty(HTTP.CONTENT_LEN, new StringBuilder().append(bArr.length).toString());
                    httpsURLConnection.setRequestProperty(MIME.CONTENT_DISPOSITION, "attchment;filename=" + substring);
                    httpsURLConnection.setRequestProperty("LogType", str);
                    httpsURLConnection.setFixedLengthStreamingMode(bArr.length);
                    httpsURLConnection.connect();
                    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                    try {
                        OutputStream outputStream2 = httpsURLConnection.getOutputStream();
                        while (true) {
                            int read = byteArrayInputStream2.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            outputStream2.write(bArr2, 0, read);
                        }
                        byteArrayInputStream2.close();
                        outputStream2.flush();
                        outputStream2.close();
                        int responseCode = httpsURLConnection.getResponseCode();
                        Log.d(TAG, "finish send the reqeust , responseCode = " + responseCode);
                        if (responseCode == 200) {
                            stringBuffer.append("Upload Success; The server has responed 200 . ");
                            httpsURLConnection.disconnect();
                            return true;
                        }
                        stringBuffer.append("doUpload Failed, The server has responsed Code " + responseCode);
                        httpsURLConnection.disconnect();
                        return false;
                    } catch (Exception e2) {
                        e = e2;
                        httpURLConnection = httpsURLConnection;
                        byteArrayInputStream = byteArrayInputStream2;
                        try {
                            stringBuffer.append(e.getMessage());
                            a.a(e);
                            if (byteArrayInputStream != null) {
                                try {
                                    byteArrayInputStream.close();
                                } catch (Exception e3) {
                                    Log.d(TAG, "failed http.");
                                    httpURLConnection.disconnect();
                                    return false;
                                }
                            }
                            if (0 != 0) {
                                outputStream.close();
                            }
                            Log.d(TAG, "failed http.");
                            httpURLConnection.disconnect();
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            httpsURLConnection = httpURLConnection;
                            httpsURLConnection.disconnect();
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    httpsURLConnection.disconnect();
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                httpURLConnection = httpsURLConnection;
                byteArrayInputStream = null;
            }
        } catch (Exception e5) {
            e = e5;
            httpURLConnection = null;
            byteArrayInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            httpsURLConnection = null;
        }
    }

    public final boolean uploadLogDirectory(String str, boolean z, OnFinishedListener onFinishedListener) {
        if (str == null || str.isEmpty()) {
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
        if (str == null || str.isEmpty() || !new File(str).exists()) {
            return false;
        }
        Thread thread = new Thread(new MyRunner(str, this.mType, this.mCuid, this.mUseHttps, z, onFinishedListener));
        thread.setName("T7@ZeusLogFile1");
        thread.start();
        return true;
    }
}
