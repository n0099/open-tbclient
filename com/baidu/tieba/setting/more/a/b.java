package com.baidu.tieba.setting.more.a;

import android.util.Log;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.down.request.db.DownloadDataConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes25.dex */
public class b extends Thread {
    private a mKa;
    private final String mKd;
    private Process mKe;
    private FileOutputStream mKg;
    private boolean mRunning = true;
    private BufferedReader mKf = null;

    /* loaded from: classes25.dex */
    public interface a {
        void dFn();
    }

    public b(String str, String str2, boolean z) {
        this.mKg = null;
        try {
            this.mKg = new FileOutputStream(new File(str, str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.ENGLISH).format(new Date()) + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION), true);
        } catch (FileNotFoundException e) {
            BdLog.e(Log.getStackTraceString(e));
        }
        if (z) {
            this.mKd = "logcat -v threadtime *:v -d";
        } else {
            this.mKd = "logcat -v threadtime *:v";
        }
    }

    public void a(a aVar) {
        this.mKa = aVar;
    }

    public void dFo() {
        this.mRunning = false;
        closeAll();
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String readLine;
        try {
            this.mKe = Runtime.getRuntime().exec(this.mKd);
            this.mKf = new BufferedReader(new InputStreamReader(this.mKe.getInputStream()), 1024);
            while (this.mRunning && (readLine = this.mKf.readLine()) != null && this.mRunning) {
                if (readLine.length() != 0 && this.mKg != null) {
                    this.mKg.write((readLine + "\n").getBytes());
                }
            }
            BdLog.d("collector complete.");
        } catch (IOException e) {
            BdLog.e(Log.getStackTraceString(e));
        } finally {
            closeAll();
        }
    }

    private void closeAll() {
        if (this.mKe != null) {
            this.mKe.destroy();
            this.mKe = null;
        }
        if (this.mKf != null) {
            try {
                this.mKf.close();
                this.mKf = null;
            } catch (IOException e) {
                BdLog.e(Log.getStackTraceString(e));
            }
        }
        if (this.mKg != null) {
            try {
                this.mKg.close();
            } catch (IOException e2) {
                BdLog.e(Log.getStackTraceString(e2));
            }
            this.mKg = null;
        }
        if (this.mKa != null) {
            this.mKa.dFn();
        }
    }
}
