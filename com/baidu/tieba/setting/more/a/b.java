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
/* loaded from: classes7.dex */
public class b extends Thread {
    private a mYT;
    private final String mYV;
    private Process mYW;
    private FileOutputStream mYY;
    private boolean mRunning = true;
    private BufferedReader mYX = null;

    /* loaded from: classes7.dex */
    public interface a {
        void dGx();
    }

    public b(String str, String str2, boolean z) {
        this.mYY = null;
        try {
            this.mYY = new FileOutputStream(new File(str, str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.ENGLISH).format(new Date()) + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION), true);
        } catch (FileNotFoundException e) {
            BdLog.e(Log.getStackTraceString(e));
        }
        if (z) {
            this.mYV = "logcat -v threadtime *:v -d";
        } else {
            this.mYV = "logcat -v threadtime *:v";
        }
    }

    public void a(a aVar) {
        this.mYT = aVar;
    }

    public void dGy() {
        this.mRunning = false;
        dGz();
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String readLine;
        try {
            this.mYW = Runtime.getRuntime().exec(this.mYV);
            this.mYX = new BufferedReader(new InputStreamReader(this.mYW.getInputStream()), 1024);
            while (this.mRunning && (readLine = this.mYX.readLine()) != null && this.mRunning) {
                if (readLine.length() != 0 && this.mYY != null) {
                    this.mYY.write((readLine + "\n").getBytes());
                }
            }
            BdLog.d("collector complete.");
        } catch (IOException e) {
            BdLog.e(Log.getStackTraceString(e));
        } finally {
            dGz();
        }
    }

    private void dGz() {
        if (this.mYW != null) {
            this.mYW.destroy();
            this.mYW = null;
        }
        if (this.mYX != null) {
            try {
                this.mYX.close();
                this.mYX = null;
            } catch (IOException e) {
                BdLog.e(Log.getStackTraceString(e));
            }
        }
        if (this.mYY != null) {
            try {
                this.mYY.close();
            } catch (IOException e2) {
                BdLog.e(Log.getStackTraceString(e2));
            }
            this.mYY = null;
        }
        if (this.mYT != null) {
            this.mYT.dGx();
        }
    }
}
