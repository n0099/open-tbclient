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
    private a niC;
    private final String niE;
    private Process niF;
    private FileOutputStream niH;
    private boolean mRunning = true;
    private BufferedReader niG = null;

    /* loaded from: classes8.dex */
    public interface a {
        void dII();
    }

    public b(String str, String str2, boolean z) {
        this.niH = null;
        try {
            this.niH = new FileOutputStream(new File(str, str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.ENGLISH).format(new Date()) + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION), true);
        } catch (FileNotFoundException e) {
            BdLog.e(Log.getStackTraceString(e));
        }
        if (z) {
            this.niE = "logcat -v threadtime *:v -d";
        } else {
            this.niE = "logcat -v threadtime *:v";
        }
    }

    public void a(a aVar) {
        this.niC = aVar;
    }

    public void dIJ() {
        this.mRunning = false;
        dIK();
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String readLine;
        try {
            this.niF = Runtime.getRuntime().exec(this.niE);
            this.niG = new BufferedReader(new InputStreamReader(this.niF.getInputStream()), 1024);
            while (this.mRunning && (readLine = this.niG.readLine()) != null && this.mRunning) {
                if (readLine.length() != 0 && this.niH != null) {
                    this.niH.write((readLine + "\n").getBytes());
                }
            }
            BdLog.d("collector complete.");
        } catch (IOException e) {
            BdLog.e(Log.getStackTraceString(e));
        } finally {
            dIK();
        }
    }

    private void dIK() {
        if (this.niF != null) {
            this.niF.destroy();
            this.niF = null;
        }
        if (this.niG != null) {
            try {
                this.niG.close();
                this.niG = null;
            } catch (IOException e) {
                BdLog.e(Log.getStackTraceString(e));
            }
        }
        if (this.niH != null) {
            try {
                this.niH.close();
            } catch (IOException e2) {
                BdLog.e(Log.getStackTraceString(e2));
            }
            this.niH = null;
        }
        if (this.niC != null) {
            this.niC.dII();
        }
    }
}
