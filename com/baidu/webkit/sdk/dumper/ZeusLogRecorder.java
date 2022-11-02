package com.baidu.webkit.sdk.dumper;

import android.app.ActivityManager;
import android.os.Process;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes7.dex */
public class ZeusLogRecorder extends ZeusCrashHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static String TAG = "ZeusLogRecorder";
    public static ZeusLogRecorder instance;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes7.dex */
    public class LogRecordBean {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ZeusLogRecorder this$0;
        public String upLoadFileName;
        public boolean uploadSuccess;

        public LogRecordBean(ZeusLogRecorder zeusLogRecorder, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zeusLogRecorder, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = zeusLogRecorder;
            this.upLoadFileName = str;
            this.uploadSuccess = z;
        }

        public String getUpLoadFileName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.upLoadFileName : (String) invokeV.objValue;
        }

        public boolean isUploadSuccess() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.uploadSuccess : invokeV.booleanValue;
        }

        public void setUpLoadFileName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.upLoadFileName = str;
            }
        }

        public void setUploadSuccess(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.uploadSuccess = z;
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface OnFinishedUploadLogListener {
        void onFinishedUploadLog(List<LogRecordBean> list, String str);
    }

    /* loaded from: classes7.dex */
    public class WatchThread extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean over;
        public Process p;
        public ArrayList<String> stream;
        public final /* synthetic */ ZeusLogRecorder this$0;
        public final Writer writer;

        public WatchThread(ZeusLogRecorder zeusLogRecorder, Process process, Writer writer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zeusLogRecorder, process, writer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = zeusLogRecorder;
            this.p = process;
            this.over = false;
            this.writer = writer;
            this.stream = new ArrayList<>();
        }

        public ArrayList<String> getStream() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.stream : (ArrayList) invokeV.objValue;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    if (this.p == null) {
                        return;
                    }
                    Scanner scanner = new Scanner(this.p.getInputStream());
                    this.writer.write("Logcat:\n");
                    while (this.p != null && !this.over && !Thread.interrupted()) {
                        while (scanner.hasNextLine()) {
                            String nextLine = scanner.nextLine();
                            if (this.this$0.isProcessIdInLine(nextLine) && nextLine != null && nextLine.trim().length() != 0) {
                                this.writer.write(nextLine);
                                this.writer.write("\n");
                            }
                        }
                    }
                } catch (Exception e) {
                    Log.e(ZeusLogRecorder.TAG, Log.getStackTraceString(e));
                }
            }
        }

        public void setOver(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.over = z;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2100750340, "Lcom/baidu/webkit/sdk/dumper/ZeusLogRecorder;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2100750340, "Lcom/baidu/webkit/sdk/dumper/ZeusLogRecorder;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZeusLogRecorder() {
        super(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Thread.UncaughtExceptionHandler) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, writer) == null) {
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
                WatchThread watchThread = new WatchThread(this, start, writer);
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
    }

    private boolean generateLogRecord(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65549, this, file)) != null) {
            return invokeL.booleanValue;
        }
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            int myPid = Process.myPid();
            String str = "";
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) WebViewFactory.getContext().getApplicationContext().getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    str = runningAppProcessInfo.processName;
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    private File[] getDirectoryFiles(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, file)) == null) {
            if (file.exists()) {
                return file.listFiles(new ZeusLogUploader.LogFilter(this.recordPrefName));
            }
            return null;
        }
        return (File[]) invokeL.objValue;
    }

    public static ZeusLogRecorder getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            synchronized (ZeusLogRecorder.class) {
                if (instance == null) {
                    instance = new ZeusLogRecorder();
                }
            }
            return instance;
        }
        return (ZeusLogRecorder) invokeV.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x000d: IGET  (r1v1 int A[REMOVE]) = (r4v0 'this' com.baidu.webkit.sdk.dumper.ZeusLogRecorder A[IMMUTABLE_TYPE, THIS]) com.baidu.webkit.sdk.dumper.ZeusLogRecorder.mPid int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public boolean isProcessIdInLine(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, str)) == null) {
            if (this.isFilterLogRecord) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.mPid);
                return str.contains(sb.toString());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void quitUploadLog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToastAndLog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, str) == null) {
            Log.i(TAG, "[ZeusLogRecorder] %1$s", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadLogRecord() throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
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
            this.mUploader.uploadLogDirectory(this.logDir.getAbsolutePath(), true, new ZeusLogUploader.OnFinishedListener(this) { // from class: com.baidu.webkit.sdk.dumper.ZeusLogRecorder.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ZeusLogRecorder this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.webkit.sdk.dumper.ZeusLogUploader.OnFinishedListener
                public void onFinished(String str2, int i, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, str2, i, str3) == null) {
                        int decrementAndGet = this.this$0.unUploadFileSize.decrementAndGet();
                        if (decrementAndGet < 0) {
                            Log.e(ZeusLogRecorder.TAG, "upload file over length, file name is %1$s: ", str2);
                            this.this$0.quitUploadLog();
                            return;
                        }
                        boolean z = i == 0;
                        String substring = str2.substring(str2.lastIndexOf("/") + 1);
                        Log.i(ZeusLogRecorder.TAG, "upload %1$s %2$s", substring, Boolean.valueOf(z));
                        this.this$0.list.add(new LogRecordBean(this.this$0, substring, z));
                        if (decrementAndGet == 0) {
                            this.this$0.showToastAndLog("Finish uploading files!");
                            this.this$0.isUploading = false;
                            if (this.this$0.listener != null) {
                                this.this$0.listener.onFinishedUploadLog(this.this$0.list, str3);
                            }
                            this.this$0.quitUploadLog();
                        }
                    }
                }
            });
            Log.i(TAG, "upload log finished");
        }
    }

    public void initAndUpload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Log.i(TAG, "[ZeusLogRecorder] initAndUpload");
            new Thread(this) { // from class: com.baidu.webkit.sdk.dumper.ZeusLogRecorder.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ZeusLogRecorder this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            synchronized (this.this$0) {
                                ZeusLogRecorder zeusLogRecorder = this.this$0;
                                zeusLogRecorder.showToastAndLog(Thread.currentThread().getId() + " isUploading: " + this.this$0.isUploading);
                                if (this.this$0.isUploading) {
                                    this.this$0.showToastAndLog("some log is uploadiing now, please retry after a few minuite");
                                    return;
                                }
                                this.this$0.isUploading = true;
                                this.this$0.uploadLogRecord();
                            }
                        } catch (Exception e) {
                            Log.e(ZeusLogRecorder.TAG, Log.getStackTraceString(e));
                            this.this$0.quitUploadLog();
                        }
                    }
                }
            }.start();
        }
    }

    public void setListener(OnFinishedUploadLogListener onFinishedUploadLogListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onFinishedUploadLogListener) == null) {
            this.listener = onFinishedUploadLogListener;
        }
    }

    public void shouldWaitForUploadiing() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }
}
