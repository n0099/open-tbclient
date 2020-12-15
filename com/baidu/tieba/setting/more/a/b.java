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
    private a mYe;
    private final String mYh;
    private Process mYi;
    private FileOutputStream mYk;
    private boolean mRunning = true;
    private BufferedReader mYj = null;

    /* loaded from: classes26.dex */
    public interface a {
        void dKz();
    }

    public b(String str, String str2, boolean z) {
        this.mYk = null;
        try {
            this.mYk = new FileOutputStream(new File(str, str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.ENGLISH).format(new Date()) + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION), true);
        } catch (FileNotFoundException e) {
            BdLog.e(Log.getStackTraceString(e));
        }
        if (z) {
            this.mYh = "logcat -v threadtime *:v -d";
        } else {
            this.mYh = "logcat -v threadtime *:v";
        }
    }

    public void a(a aVar) {
        this.mYe = aVar;
    }

    public void dKA() {
        this.mRunning = false;
        dKB();
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String readLine;
        try {
            this.mYi = Runtime.getRuntime().exec(this.mYh);
            this.mYj = new BufferedReader(new InputStreamReader(this.mYi.getInputStream()), 1024);
            while (this.mRunning && (readLine = this.mYj.readLine()) != null && this.mRunning) {
                if (readLine.length() != 0 && this.mYk != null) {
                    this.mYk.write((readLine + "\n").getBytes());
                }
            }
            BdLog.d("collector complete.");
        } catch (IOException e) {
            BdLog.e(Log.getStackTraceString(e));
        } finally {
            dKB();
        }
    }

    private void dKB() {
        if (this.mYi != null) {
            this.mYi.destroy();
            this.mYi = null;
        }
        if (this.mYj != null) {
            try {
                this.mYj.close();
                this.mYj = null;
            } catch (IOException e) {
                BdLog.e(Log.getStackTraceString(e));
            }
        }
        if (this.mYk != null) {
            try {
                this.mYk.close();
            } catch (IOException e2) {
                BdLog.e(Log.getStackTraceString(e2));
            }
            this.mYk = null;
        }
        if (this.mYe != null) {
            this.mYe.dKz();
        }
    }
}
