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
    private final String ndB;
    private Process ndC;
    private FileOutputStream ndE;
    private a ndz;
    private boolean mRunning = true;
    private BufferedReader ndD = null;

    /* loaded from: classes8.dex */
    public interface a {
        void dKo();
    }

    public b(String str, String str2, boolean z) {
        this.ndE = null;
        try {
            this.ndE = new FileOutputStream(new File(str, str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.ENGLISH).format(new Date()) + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION), true);
        } catch (FileNotFoundException e) {
            BdLog.e(Log.getStackTraceString(e));
        }
        if (z) {
            this.ndB = "logcat -v threadtime *:v -d";
        } else {
            this.ndB = "logcat -v threadtime *:v";
        }
    }

    public void a(a aVar) {
        this.ndz = aVar;
    }

    public void dKp() {
        this.mRunning = false;
        dKq();
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String readLine;
        try {
            this.ndC = Runtime.getRuntime().exec(this.ndB);
            this.ndD = new BufferedReader(new InputStreamReader(this.ndC.getInputStream()), 1024);
            while (this.mRunning && (readLine = this.ndD.readLine()) != null && this.mRunning) {
                if (readLine.length() != 0 && this.ndE != null) {
                    this.ndE.write((readLine + "\n").getBytes());
                }
            }
            BdLog.d("collector complete.");
        } catch (IOException e) {
            BdLog.e(Log.getStackTraceString(e));
        } finally {
            dKq();
        }
    }

    private void dKq() {
        if (this.ndC != null) {
            this.ndC.destroy();
            this.ndC = null;
        }
        if (this.ndD != null) {
            try {
                this.ndD.close();
                this.ndD = null;
            } catch (IOException e) {
                BdLog.e(Log.getStackTraceString(e));
            }
        }
        if (this.ndE != null) {
            try {
                this.ndE.close();
            } catch (IOException e2) {
                BdLog.e(Log.getStackTraceString(e2));
            }
            this.ndE = null;
        }
        if (this.ndz != null) {
            this.ndz.dKo();
        }
    }
}
