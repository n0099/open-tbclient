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
/* loaded from: classes10.dex */
public class a extends AsyncTask<String, Integer, Integer> {
    private String mFilePath;
    private String mUrl;
    private b pcH;
    private int pcI = 0;

    public a(Context context, String str, String str2, b bVar) {
        this.mUrl = str;
        this.pcH = bVar;
        this.mFilePath = str2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [93=4] */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: ac */
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
        FileOutputStream fileOutputStream2 = null;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.mUrl = f.replaceToHttps(this.mUrl);
            c.d("AsyncDownloadTask", "download url is:" + this.mUrl);
            httpURLConnection = (HttpURLConnection) new URL(this.mUrl).openConnection();
            httpURLConnection.connect();
            bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            try {
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
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            e = e2;
            bufferedInputStream = null;
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
            c.e("AsyncDownloadTask", "DownloadTask:" + e.getMessage());
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e6) {
                    c.e("AsyncDownloadTask", "fileOutputStream close IOException:" + e6.getMessage());
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e7) {
                    c.e("AsyncDownloadTask", "isclose IOException:" + e7.getMessage());
                }
            }
            return 1003;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream2 = fileOutputStream;
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onProgressUpdate(Integer... numArr) {
        if (numArr != null) {
            try {
                if (numArr.length > 0) {
                    Integer num = numArr[0];
                    if (num.intValue() > this.pcI) {
                        this.pcI = num.intValue();
                        if (this.pcH != null) {
                            this.pcH.onProgress(this.pcI);
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
            if (this.pcH != null) {
                this.pcH.onFailed(i);
            }
        } catch (Exception e) {
            c.e("AsyncDownloadTask", "notifyFailed:" + e.getMessage());
        }
    }

    private void notifyFinished() {
        try {
            if (this.pcH != null) {
                this.pcH.Yw(this.mFilePath);
            }
            if (c.isDebugMode()) {
                c.d("AsyncDownloadTask", "donwLoad finshed sucess:" + System.currentTimeMillis());
            }
        } catch (Exception e) {
            c.e("AsyncDownloadTask", "notifyFinished:" + e.getMessage());
        }
    }
}
