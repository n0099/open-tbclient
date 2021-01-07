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
    private final String ndA;
    private Process ndB;
    private FileOutputStream ndD;
    private a ndy;
    private boolean mRunning = true;
    private BufferedReader ndC = null;

    /* loaded from: classes8.dex */
    public interface a {
        void dKp();
    }

    public b(String str, String str2, boolean z) {
        this.ndD = null;
        try {
            this.ndD = new FileOutputStream(new File(str, str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.ENGLISH).format(new Date()) + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION), true);
        } catch (FileNotFoundException e) {
            BdLog.e(Log.getStackTraceString(e));
        }
        if (z) {
            this.ndA = "logcat -v threadtime *:v -d";
        } else {
            this.ndA = "logcat -v threadtime *:v";
        }
    }

    public void a(a aVar) {
        this.ndy = aVar;
    }

    public void dKq() {
        this.mRunning = false;
        dKr();
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String readLine;
        try {
            this.ndB = Runtime.getRuntime().exec(this.ndA);
            this.ndC = new BufferedReader(new InputStreamReader(this.ndB.getInputStream()), 1024);
            while (this.mRunning && (readLine = this.ndC.readLine()) != null && this.mRunning) {
                if (readLine.length() != 0 && this.ndD != null) {
                    this.ndD.write((readLine + "\n").getBytes());
                }
            }
            BdLog.d("collector complete.");
        } catch (IOException e) {
            BdLog.e(Log.getStackTraceString(e));
        } finally {
            dKr();
        }
    }

    private void dKr() {
        if (this.ndB != null) {
            this.ndB.destroy();
            this.ndB = null;
        }
        if (this.ndC != null) {
            try {
                this.ndC.close();
                this.ndC = null;
            } catch (IOException e) {
                BdLog.e(Log.getStackTraceString(e));
            }
        }
        if (this.ndD != null) {
            try {
                this.ndD.close();
            } catch (IOException e2) {
                BdLog.e(Log.getStackTraceString(e2));
            }
            this.ndD = null;
        }
        if (this.ndy != null) {
            this.ndy.dKp();
        }
    }
}
