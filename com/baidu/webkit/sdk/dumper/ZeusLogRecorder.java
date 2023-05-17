package com.baidu.webkit.sdk.dumper;

import android.app.ActivityManager;
import android.os.Process;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.baidu.webkit.sdk.dumper.ZeusLogUploader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes8.dex */
public class ZeusLogRecorder extends ZeusCrashHandler {
    public static String TAG = "ZeusLogRecorder";
    public static ZeusLogRecorder instance;
    public List<String> fileNameList;
    public boolean isFilterLogRecord;
    public boolean isUploading;
    public List<LogRecordBean> list;
    public OnFinishedUploadLogListener listener;
    public Lock lock;
    public File logDir;
    public ZeusCrashHandler.ZeusCrashHandlerClient mClient;
    public File mLogFile;
    public int mPid;
    public ZeusLogUploader mUploader;
    public String recordPrefName;
    public AtomicInteger unUploadFileSize;

    /* loaded from: classes8.dex */
    public class LogRecordBean {
        public String upLoadFileName;
        public boolean uploadSuccess;

        public LogRecordBean(String str, boolean z) {
            this.upLoadFileName = str;
            this.uploadSuccess = z;
        }

        public String getUpLoadFileName() {
            return this.upLoadFileName;
        }

        public boolean isUploadSuccess() {
            return this.uploadSuccess;
        }

        public void setUpLoadFileName(String str) {
            this.upLoadFileName = str;
        }

        public void setUploadSuccess(boolean z) {
            this.uploadSuccess = z;
        }
    }

    /* loaded from: classes8.dex */
    public interface OnFinishedUploadLogListener {
        void onFinishedUploadLog(List<LogRecordBean> list, String str);
    }

    /* loaded from: classes8.dex */
    public class WatchThread extends Thread {
        public Process p;
        public final Writer writer;
        public boolean over = false;
        public ArrayList<String> stream = new ArrayList<>();

        public WatchThread(Process process, Writer writer) {
            this.p = process;
            this.writer = writer;
        }

        public ArrayList<String> getStream() {
            return this.stream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                if (this.p == null) {
                    return;
                }
                Scanner scanner = new Scanner(this.p.getInputStream());
                this.writer.write("Logcat:\n");
                while (this.p != null && !this.over && !Thread.interrupted()) {
                    while (scanner.hasNextLine()) {
                        String nextLine = scanner.nextLine();
                        if (ZeusLogRecorder.this.isProcessIdInLine(nextLine) && nextLine != null && nextLine.trim().length() != 0) {
                            this.writer.write(nextLine);
                            this.writer.write("\n");
                        }
                    }
                }
            } catch (Exception e) {
                Log.e(ZeusLogRecorder.TAG, Log.getStackTraceString(e));
            }
        }

        public void setOver(boolean z) {
            this.over = z;
        }
    }

    public ZeusLogRecorder() {
        super(null);
        this.recordPrefName = "recordlog";
        this.list = new ArrayList();
        this.fileNameList = new ArrayList();
        this.lock = new ReentrantLock();
        try {
            File file = new File(WebViewFactory.getContext().getFilesDir(), this.recordPrefName);
            this.logDir = file;
            if (file.exists() && !this.logDir.isDirectory()) {
                this.logDir.delete();
            }
            if (!this.logDir.exists()) {
                this.logDir.mkdirs();
            }
        } catch (Throwable th) {
            Log.e(TAG, Log.getStackTraceString(th));
        }
        this.mPid = Process.myPid();
        this.mUploader = new ZeusLogUploader(this.recordPrefName, null, true);
        this.mClient = new ZeusCrashHandler.ZeusCrashHandlerClient(this);
        this.isFilterLogRecord = this.isFilterLogRecord;
    }

    private void dumpExtraLogcatInfo(Writer writer) throws IOException {
        String str;
        Process start;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    str = "Logcat:";
                    start = new ProcessBuilder("logcat", "-d", "-t5000", "-vthreadtime").start();
                    bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream()));
                } catch (Throwable th) {
                    Log.e(TAG, Log.getStackTraceString(th));
                    return;
                }
            } catch (InterruptedException e) {
                e = e;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            WatchThread watchThread = new WatchThread(start, writer);
            watchThread.start();
            start.waitFor();
            watchThread.setOver(true);
            watchThread.interrupt();
            int i = 0;
            while (true) {
                if (!watchThread.isAlive()) {
                    break;
                }
                Thread.sleep(1000L);
                int i2 = i + 1;
                if (i > 30) {
                    Log.e(TAG, "thread over %1$d secs, WatchThread is still alive", Integer.valueOf(i2 * 20));
                    break;
                }
                i = i2;
            }
            do {
                if (isProcessIdInLine(str)) {
                    writer.write(str);
                    writer.write("\n");
                }
                str = bufferedReader.readLine();
            } while (str != null);
            bufferedReader.close();
        } catch (InterruptedException e3) {
            e = e3;
            bufferedReader2 = bufferedReader;
            e.printStackTrace();
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
        } catch (Exception e4) {
            e = e4;
            Log.e(TAG, Log.getStackTraceString(e));
            throw new IOException(e);
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Throwable th4) {
                    Log.e(TAG, Log.getStackTraceString(th4));
                }
            }
            throw th;
        }
    }

    private boolean generateLogRecord(File file) {
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
            try {
                dumpExtraLogcatInfo(bufferedWriter2);
                bufferedWriter2.write("===============end===============");
                bufferedWriter2.write("\n\n");
                try {
                    bufferedWriter2.close();
                    return true;
                } catch (Throwable th) {
                    Log.e(TAG, Log.getStackTraceString(th));
                    return true;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = bufferedWriter2;
                try {
                    th.printStackTrace();
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                            return false;
                        } catch (Throwable th3) {
                            Log.e(TAG, Log.getStackTraceString(th3));
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th4) {
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (Throwable th5) {
                            Log.e(TAG, Log.getStackTraceString(th5));
                        }
                    }
                    throw th4;
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static String getCurrentProcessName() {
        int myPid = Process.myPid();
        String str = "";
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) WebViewFactory.getContext().getApplicationContext().getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                str = runningAppProcessInfo.processName;
            }
        }
        return str;
    }

    private File[] getDirectoryFiles(File file) {
        if (file.exists()) {
            return file.listFiles(new ZeusLogUploader.LogFilter(this.recordPrefName));
        }
        return null;
    }

    public static ZeusLogRecorder getInstance() {
        synchronized (ZeusLogRecorder.class) {
            if (instance == null) {
                instance = new ZeusLogRecorder();
            }
        }
        return instance;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0009: IGET  (r1v0 int A[REMOVE]) = (r2v0 'this' com.baidu.webkit.sdk.dumper.ZeusLogRecorder A[IMMUTABLE_TYPE, THIS]) com.baidu.webkit.sdk.dumper.ZeusLogRecorder.mPid int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public boolean isProcessIdInLine(String str) {
        if (this.isFilterLogRecord) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.mPid);
            return str.contains(sb.toString());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void quitUploadLog() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToastAndLog(String str) {
        Log.i(TAG, "[ZeusLogRecorder] %1$s", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadLogRecord() throws Exception {
        String str = TAG;
        Log.i(str, Thread.currentThread() + " begin to upload log files");
        setCrashTime(System.currentTimeMillis());
        Log.i(TAG, "generate log file");
        ZeusCrashHandler.ZeusCrashHandlerClient zeusCrashHandlerClient = this.mClient;
        File logFile = zeusCrashHandlerClient.getLogFile("recordlog-" + getCurrentProcessName() + "-" + Process.myPid() + "-", this.recordPrefName);
        this.mLogFile = logFile;
        this.fileNameList.add(logFile.getName());
        showToastAndLog("log file " + this.mLogFile.getName() + " is generating now, maybe wait more than a minute");
        if (!generateLogRecord(this.mLogFile)) {
            Log.e(TAG, "[ZeusLogRecorder] create log file error");
        }
        if (this.fileNameList.contains(this.mLogFile.getName())) {
            this.fileNameList.remove(this.mLogFile.getName());
        }
        Log.i(TAG, "logDir path: %1$s", this.logDir.getAbsolutePath());
        File[] directoryFiles = getDirectoryFiles(this.logDir);
        if (directoryFiles == null || directoryFiles.length == 0) {
            Log.i(TAG, "files count in directory recordlog is 0, set isUploading = false");
            this.isUploading = false;
            quitUploadLog();
            return;
        }
        showToastAndLog("Start uploading files");
        this.unUploadFileSize = new AtomicInteger(directoryFiles.length);
        this.mUploader.uploadLogDirectory(this.logDir.getAbsolutePath(), true, new ZeusLogUploader.OnFinishedListener() { // from class: com.baidu.webkit.sdk.dumper.ZeusLogRecorder.2
            @Override // com.baidu.webkit.sdk.dumper.ZeusLogUploader.OnFinishedListener
            public void onFinished(String str2, int i, String str3) {
                int decrementAndGet = ZeusLogRecorder.this.unUploadFileSize.decrementAndGet();
                if (decrementAndGet < 0) {
                    Log.e(ZeusLogRecorder.TAG, "upload file over length, file name is %1$s: ", str2);
                    ZeusLogRecorder.this.quitUploadLog();
                    return;
                }
                boolean z = i == 0;
                String substring = str2.substring(str2.lastIndexOf("/") + 1);
                Log.i(ZeusLogRecorder.TAG, "upload %1$s %2$s", substring, Boolean.valueOf(z));
                ZeusLogRecorder.this.list.add(new LogRecordBean(substring, z));
                if (decrementAndGet == 0) {
                    ZeusLogRecorder.this.showToastAndLog("Finish uploading files!");
                    ZeusLogRecorder.this.isUploading = false;
                    if (ZeusLogRecorder.this.listener != null) {
                        ZeusLogRecorder.this.listener.onFinishedUploadLog(ZeusLogRecorder.this.list, str3);
                    }
                    ZeusLogRecorder.this.quitUploadLog();
                }
            }
        });
        Log.i(TAG, "upload log finished");
    }

    public void initAndUpload() {
        Log.i(TAG, "[ZeusLogRecorder] initAndUpload");
        new Thread() { // from class: com.baidu.webkit.sdk.dumper.ZeusLogRecorder.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    synchronized (ZeusLogRecorder.this) {
                        ZeusLogRecorder zeusLogRecorder = ZeusLogRecorder.this;
                        zeusLogRecorder.showToastAndLog(Thread.currentThread().getId() + " isUploading: " + ZeusLogRecorder.this.isUploading);
                        if (ZeusLogRecorder.this.isUploading) {
                            ZeusLogRecorder.this.showToastAndLog("some log is uploadiing now, please retry after a few minuite");
                            return;
                        }
                        ZeusLogRecorder.this.isUploading = true;
                        ZeusLogRecorder.this.uploadLogRecord();
                    }
                } catch (Exception e) {
                    Log.e(ZeusLogRecorder.TAG, Log.getStackTraceString(e));
                    ZeusLogRecorder.this.quitUploadLog();
                }
            }
        }.start();
    }

    public void setListener(OnFinishedUploadLogListener onFinishedUploadLogListener) {
        this.listener = onFinishedUploadLogListener;
    }

    public void shouldWaitForUploadiing() {
    }
}
