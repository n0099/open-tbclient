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
/* loaded from: classes8.dex */
public class b extends Thread {
    private a njc;
    private final String nje;
    private Process njf;
    private FileOutputStream njh;
    private boolean mRunning = true;
    private BufferedReader njg = null;

    /* loaded from: classes8.dex */
    public interface a {
        void dIQ();
    }

    public b(String str, String str2, boolean z) {
        this.njh = null;
        try {
            this.njh = new FileOutputStream(new File(str, str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.ENGLISH).format(new Date()) + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION), true);
        } catch (FileNotFoundException e) {
            BdLog.e(Log.getStackTraceString(e));
        }
        if (z) {
            this.nje = "logcat -v threadtime *:v -d";
        } else {
            this.nje = "logcat -v threadtime *:v";
        }
    }

    public void a(a aVar) {
        this.njc = aVar;
    }

    public void dIR() {
        this.mRunning = false;
        dIS();
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String readLine;
        try {
            this.njf = Runtime.getRuntime().exec(this.nje);
            this.njg = new BufferedReader(new InputStreamReader(this.njf.getInputStream()), 1024);
            while (this.mRunning && (readLine = this.njg.readLine()) != null && this.mRunning) {
                if (readLine.length() != 0 && this.njh != null) {
                    this.njh.write((readLine + "\n").getBytes());
                }
            }
            BdLog.d("collector complete.");
        } catch (IOException e) {
            BdLog.e(Log.getStackTraceString(e));
        } finally {
            dIS();
        }
    }

    private void dIS() {
        if (this.njf != null) {
            this.njf.destroy();
            this.njf = null;
        }
        if (this.njg != null) {
            try {
                this.njg.close();
                this.njg = null;
            } catch (IOException e) {
                BdLog.e(Log.getStackTraceString(e));
            }
        }
        if (this.njh != null) {
            try {
                this.njh.close();
            } catch (IOException e2) {
                BdLog.e(Log.getStackTraceString(e2));
            }
            this.njh = null;
        }
        if (this.njc != null) {
            this.njc.dIQ();
        }
    }
}
