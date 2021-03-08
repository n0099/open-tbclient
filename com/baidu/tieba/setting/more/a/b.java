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
    private a nlg;
    private final String nli;
    private Process nlj;
    private FileOutputStream nll;
    private boolean mRunning = true;
    private BufferedReader nlk = null;

    /* loaded from: classes7.dex */
    public interface a {
        void dIY();
    }

    public b(String str, String str2, boolean z) {
        this.nll = null;
        try {
            this.nll = new FileOutputStream(new File(str, str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.ENGLISH).format(new Date()) + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION), true);
        } catch (FileNotFoundException e) {
            BdLog.e(Log.getStackTraceString(e));
        }
        if (z) {
            this.nli = "logcat -v threadtime *:v -d";
        } else {
            this.nli = "logcat -v threadtime *:v";
        }
    }

    public void a(a aVar) {
        this.nlg = aVar;
    }

    public void dIZ() {
        this.mRunning = false;
        dJa();
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String readLine;
        try {
            this.nlj = Runtime.getRuntime().exec(this.nli);
            this.nlk = new BufferedReader(new InputStreamReader(this.nlj.getInputStream()), 1024);
            while (this.mRunning && (readLine = this.nlk.readLine()) != null && this.mRunning) {
                if (readLine.length() != 0 && this.nll != null) {
                    this.nll.write((readLine + "\n").getBytes());
                }
            }
            BdLog.d("collector complete.");
        } catch (IOException e) {
            BdLog.e(Log.getStackTraceString(e));
        } finally {
            dJa();
        }
    }

    private void dJa() {
        if (this.nlj != null) {
            this.nlj.destroy();
            this.nlj = null;
        }
        if (this.nlk != null) {
            try {
                this.nlk.close();
                this.nlk = null;
            } catch (IOException e) {
                BdLog.e(Log.getStackTraceString(e));
            }
        }
        if (this.nll != null) {
            try {
                this.nll.close();
            } catch (IOException e2) {
                BdLog.e(Log.getStackTraceString(e2));
            }
            this.nll = null;
        }
        if (this.nlg != null) {
            this.nlg.dIY();
        }
    }
}
