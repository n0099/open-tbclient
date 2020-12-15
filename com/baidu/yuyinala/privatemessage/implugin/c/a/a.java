package com.baidu.yuyinala.privatemessage.implugin.c.a;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.baidu.yuyinala.privatemessage.implugin.util.c;
import com.baidu.yuyinala.privatemessage.implugin.util.f;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes4.dex */
public class a extends AsyncTask<String, Integer, Integer> {
    private String mFilePath;
    private String mUrl;
    private b oOg;
    private int oOh = 0;

    public a(Context context, String str, String str2, b bVar) {
        this.mUrl = str;
        this.oOg = bVar;
        this.mFilePath = str2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [93=4] */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0210 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x020b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.os.AsyncTask
    /* renamed from: W */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Integer doInBackground(String... strArr) {
        BufferedInputStream bufferedInputStream;
        HttpURLConnection httpURLConnection;
        FileOutputStream fileOutputStream;
        if (TextUtils.isEmpty(this.mUrl)) {
            return 1002;
        }
        c.i("AsyncDownloadTask", "murl:" + this.mUrl);
        c.i("AsyncDownloadTask", "mFilePath:" + this.mFilePath);
        byte[] bArr = new byte[8192];
        BufferedInputStream bufferedInputStream2 = null;
        FileOutputStream fileOutputStream2 = null;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.mUrl = f.replaceToHttps(this.mUrl);
            c.d("AsyncDownloadTask", "download url is:" + this.mUrl);
            httpURLConnection = (HttpURLConnection) new URL(this.mUrl).openConnection();
            httpURLConnection.connect();
            bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            try {
                if (c.isDebugMode()) {
                    c.d("AsyncDownloadTask", "get url:[" + this.mUrl + "] to [" + this.mFilePath + "]");
                }
                File file = new File(this.mFilePath);
                if (!file.exists()) {
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(this.mFilePath);
            } catch (IOException e) {
                e = e;
                bufferedInputStream2 = bufferedInputStream;
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            e = e2;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
        }
        try {
            long contentLength = httpURLConnection.getContentLength();
            int i = -1;
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
                int i2 = (int) (0 / contentLength);
                if (i2 >= 99) {
                    i2 = 99;
                }
                if (i2 != i) {
                    publishProgress(Integer.valueOf(i2));
                } else {
                    i2 = i;
                }
                i = i2;
            }
            if (c.isDebugMode()) {
                c.d("AsyncDownloadTask", "finish  time:" + (((float) (System.currentTimeMillis() - currentTimeMillis)) / 1000.0f));
            }
            fileOutputStream.flush();
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    c.e("AsyncDownloadTask", "fileOutputStream close IOException:" + e3.getMessage());
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                    return 0;
                } catch (IOException e4) {
                    c.e("AsyncDownloadTask", "isclose IOException:" + e4.getMessage());
                    return 0;
                }
            }
            return 0;
        } catch (IOException e5) {
            e = e5;
            fileOutputStream2 = fileOutputStream;
            bufferedInputStream2 = bufferedInputStream;
            try {
                c.e("AsyncDownloadTask", "DownloadTask:" + e.getMessage());
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e6) {
                        c.e("AsyncDownloadTask", "fileOutputStream close IOException:" + e6.getMessage());
                    }
                }
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e7) {
                        c.e("AsyncDownloadTask", "isclose IOException:" + e7.getMessage());
                    }
                }
                return 1003;
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = bufferedInputStream2;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e8) {
                        c.e("AsyncDownloadTask", "fileOutputStream close IOException:" + e8.getMessage());
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e9) {
                        c.e("AsyncDownloadTask", "isclose IOException:" + e9.getMessage());
                    }
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
            }
            if (bufferedInputStream != null) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onProgressUpdate(Integer... numArr) {
        if (numArr != null) {
            try {
                if (numArr.length > 0) {
                    Integer num = numArr[0];
                    if (num.intValue() > this.oOh) {
                        this.oOh = num.intValue();
                        if (this.oOg != null) {
                            this.oOg.onProgress(this.oOh);
                        }
                    }
                }
            } catch (Exception e) {
                c.e("AsyncDownloadTask", "notifyProgress:" + e.getMessage());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Integer num) {
        if (num.equals(0)) {
            notifyFinished();
        } else {
            notifyFailed(num.intValue());
        }
    }

    private void notifyFailed(int i) {
        try {
            if (this.oOg != null) {
                this.oOg.onFailed(i);
            }
        } catch (Exception e) {
            c.e("AsyncDownloadTask", "notifyFailed:" + e.getMessage());
        }
    }

    private void notifyFinished() {
        try {
            if (this.oOg != null) {
                this.oOg.YA(this.mFilePath);
            }
            if (c.isDebugMode()) {
                c.d("AsyncDownloadTask", "donwLoad finshed sucess:" + System.currentTimeMillis());
            }
        } catch (Exception e) {
            c.e("AsyncDownloadTask", "notifyFinished:" + e.getMessage());
        }
    }
}
