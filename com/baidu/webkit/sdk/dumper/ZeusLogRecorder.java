package com.baidu.webkit.sdk.dumper;

import android.app.ActivityManager;
import android.os.Process;
import com.a.a.a.a.a.a.a;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.baidu.webkit.sdk.dumper.ZeusLogUploader;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
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
    private static String TAG = "ZeusLogRecorder";
    private static ZeusLogRecorder instance;
    public List<String> fileNameList;
    private boolean isFilterLogRecord;
    private boolean isUploading;
    private List<LogRecordBean> list;
    private OnFinishedUploadLogListener listener;
    private Lock lock;
    private File logDir;
    private ZeusCrashHandler.ZeusCrashHandlerClient mClient;
    private File mLogFile;
    private int mPid;
    private ZeusLogUploader mUploader;
    private String recordPrefName;
    private AtomicInteger unUploadFileSize;

    /* loaded from: classes8.dex */
    public class LogRecordBean {
        private String upLoadFileName;
        private boolean uploadSuccess;

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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class WatchThread extends Thread {
        Process p;
        private final Writer writer;
        boolean over = false;
        ArrayList<String> stream = new ArrayList<>();

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

    private ZeusLogRecorder() {
        super(null);
        this.recordPrefName = ZeusLogUploader.RECORD_LOG;
        this.list = new ArrayList();
        this.fileNameList = new ArrayList();
        this.lock = new ReentrantLock();
        try {
            this.logDir = new File(WebViewFactory.getContext().getFilesDir(), this.recordPrefName);
            if (this.logDir.exists() && !this.logDir.isDirectory()) {
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
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void dumpExtraLogcatInfo(Writer writer) throws IOException {
        BufferedReader bufferedReader;
        int i = 0;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                String str = "Logcat:";
                Process start = new ProcessBuilder("logcat", "-d", "-t5000", "-vthreadtime").start();
                bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream()));
                try {
                    WatchThread watchThread = new WatchThread(start, writer);
                    watchThread.start();
                    start.waitFor();
                    watchThread.setOver(true);
                    watchThread.interrupt();
                    while (true) {
                        int i2 = i;
                        if (!watchThread.isAlive()) {
                            break;
                        }
                        Thread.sleep(1000L);
                        i = i2 + 1;
                        if (i2 > 30) {
                            Log.e(TAG, "thread over %1$d secs, WatchThread is still alive", Integer.valueOf(i * 20));
                            break;
                        }
                    }
                    do {
                        if (isProcessIdInLine(str)) {
                            writer.write(str);
                            writer.write("\n");
                        }
                        str = bufferedReader.readLine();
                    } while (str != null);
                    try {
                        bufferedReader.close();
                    } catch (Throwable th) {
                        Log.e(TAG, Log.getStackTraceString(th));
                    }
                } catch (InterruptedException e) {
                    e = e;
                    a.a(e);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th2) {
                            Log.e(TAG, Log.getStackTraceString(th2));
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    Log.e(TAG, Log.getStackTraceString(e));
                    throw new IOException(e);
                }
            } catch (Throwable th3) {
                th = th3;
                if (0 != 0) {
                    try {
                        bufferedReader2.close();
                    } catch (Throwable th4) {
                        Log.e(TAG, Log.getStackTraceString(th4));
                    }
                }
                throw th;
            }
        } catch (InterruptedException e3) {
            e = e3;
            bufferedReader = null;
        } catch (Exception e4) {
            e = e4;
        } catch (Throwable th5) {
            th = th5;
            if (0 != 0) {
            }
            throw th;
        }
    }

    private boolean generateLogRecord(File file) {
        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
        } catch (Throwable th) {
            th = th;
            bufferedWriter = null;
        }
        try {
            dumpExtraLogcatInfo(bufferedWriter);
            bufferedWriter.write("===============end===============");
            bufferedWriter.write("\n\n");
            try {
                bufferedWriter.close();
            } catch (Throwable th2) {
                Log.e(TAG, Log.getStackTraceString(th2));
            }
            return true;
        } catch (Throwable th3) {
            th = th3;
            try {
                a.a(th);
                return false;
            } finally {
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (Throwable th4) {
                        Log.e(TAG, Log.getStackTraceString(th4));
                    }
                }
            }
        }
    }

    private static String getCurrentProcessName() {
        int myPid = Process.myPid();
        String str = "";
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) WebViewFactory.getContext().getApplicationContext().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses()) {
            str = runningAppProcessInfo.pid == myPid ? runningAppProcessInfo.processName : str;
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
            return str.contains(new StringBuilder().append(this.mPid).toString());
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
        Log.i(TAG, Thread.currentThread() + " begin to upload log files");
        setCrashTime(System.currentTimeMillis());
        Log.i(TAG, "generate log file");
        this.mLogFile = this.mClient.getLogFile("recordlog-" + getCurrentProcessName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Process.myPid() + Constants.ACCEPT_TIME_SEPARATOR_SERVER, this.recordPrefName);
        this.fileNameList.add(this.mLogFile.getName());
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
            public void onFinished(String str, int i, String str2) {
                int decrementAndGet = ZeusLogRecorder.this.unUploadFileSize.decrementAndGet();
                if (decrementAndGet < 0) {
                    Log.e(ZeusLogRecorder.TAG, "upload file over length, file name is %1$s: ", str);
                    ZeusLogRecorder.this.quitUploadLog();
                    return;
                }
                boolean z = i == 0;
                String substring = str.substring(str.lastIndexOf("/") + 1);
                Log.i(ZeusLogRecorder.TAG, "upload %1$s %2$s", substring, Boolean.valueOf(z));
                ZeusLogRecorder.this.list.add(new LogRecordBean(substring, z));
                if (decrementAndGet == 0) {
                    ZeusLogRecorder.this.showToastAndLog("Finish uploading files!");
                    ZeusLogRecorder.this.isUploading = false;
                    if (ZeusLogRecorder.this.listener != null) {
                        ZeusLogRecorder.this.listener.onFinishedUploadLog(ZeusLogRecorder.this.list, str2);
                    }
                    ZeusLogRecorder.this.quitUploadLog();
                }
            }
        });
        Log.i(TAG, "upload log finished");
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.webkit.sdk.dumper.ZeusLogRecorder$1] */
    public void initAndUpload() {
        Log.i(TAG, "[ZeusLogRecorder] initAndUpload");
        new Thread() { // from class: com.baidu.webkit.sdk.dumper.ZeusLogRecorder.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    synchronized (ZeusLogRecorder.this) {
                        ZeusLogRecorder.this.showToastAndLog(Thread.currentThread().getId() + " isUploading: " + ZeusLogRecorder.this.isUploading);
                        if (ZeusLogRecorder.this.isUploading) {
                            ZeusLogRecorder.this.showToastAndLog("some log is uploadiing now, please retry after a few minuite");
                        } else {
                            ZeusLogRecorder.this.isUploading = true;
                            ZeusLogRecorder.this.uploadLogRecord();
                        }
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
