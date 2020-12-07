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
/* loaded from: classes26.dex */
public class b extends Thread {
    private a mYc;
    private final String mYf;
    private Process mYg;
    private FileOutputStream mYi;
    private boolean mRunning = true;
    private BufferedReader mYh = null;

    /* loaded from: classes26.dex */
    public interface a {
        void dKy();
    }

    public b(String str, String str2, boolean z) {
        this.mYi = null;
        try {
            this.mYi = new FileOutputStream(new File(str, str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.ENGLISH).format(new Date()) + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION), true);
        } catch (FileNotFoundException e) {
            BdLog.e(Log.getStackTraceString(e));
        }
        if (z) {
            this.mYf = "logcat -v threadtime *:v -d";
        } else {
            this.mYf = "logcat -v threadtime *:v";
        }
    }

    public void a(a aVar) {
        this.mYc = aVar;
    }

    public void dKz() {
        this.mRunning = false;
        dKA();
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String readLine;
        try {
            this.mYg = Runtime.getRuntime().exec(this.mYf);
            this.mYh = new BufferedReader(new InputStreamReader(this.mYg.getInputStream()), 1024);
            while (this.mRunning && (readLine = this.mYh.readLine()) != null && this.mRunning) {
                if (readLine.length() != 0 && this.mYi != null) {
                    this.mYi.write((readLine + "\n").getBytes());
                }
            }
            BdLog.d("collector complete.");
        } catch (IOException e) {
            BdLog.e(Log.getStackTraceString(e));
        } finally {
            dKA();
        }
    }

    private void dKA() {
        if (this.mYg != null) {
            this.mYg.destroy();
            this.mYg = null;
        }
        if (this.mYh != null) {
            try {
                this.mYh.close();
                this.mYh = null;
            } catch (IOException e) {
                BdLog.e(Log.getStackTraceString(e));
            }
        }
        if (this.mYi != null) {
            try {
                this.mYi.close();
            } catch (IOException e2) {
                BdLog.e(Log.getStackTraceString(e2));
            }
            this.mYi = null;
        }
        if (this.mYc != null) {
            this.mYc.dKy();
        }
    }
}
