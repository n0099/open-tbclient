package com.baidu.tieba.service;

import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.c.e.p.g;
import d.a.c.e.p.m;
import d.a.j0.r.d0.b;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes5.dex */
public class FatalErrorService extends BdBaseService {
    public static final String ERROR_TYPE_KEY = "errortype";
    public static final String ERROR_TYPE_NATIVE_C = "4";
    public static final String ERROR_TYPE_UNKNOW = "0";
    public static final int NATIVE_CRASH_DUMP_MIN_SIZE = 1024;
    public a mTask = null;

    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<String, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public Intent f20416a;

        /* renamed from: b  reason: collision with root package name */
        public NetWork f20417b = null;

        public a(Intent intent) {
            this.f20416a = intent;
        }

        public final void b(FileWriter fileWriter, String str, String str2) {
            try {
                fileWriter.append((CharSequence) str);
                if (str2 != null) {
                    fileWriter.append("=");
                    fileWriter.append((CharSequence) str2);
                }
                fileWriter.append("\n");
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0096 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x0017 */
        public final void c(File file) {
            FileWriter fileWriter;
            if (file == null || !file.exists() || !file.isFile() || this.f20416a == null) {
                return;
            }
            FileWriter fileWriter2 = null;
            try {
                try {
                    fileWriter = new FileWriter(file, true);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
            }
            try {
                fileWriter.append("\n##TIEBA_NATIVE##\n");
                b(fileWriter, StringHelper.getCurrentString(), null);
                b(fileWriter, "version", TbConfig.getVersion());
                b(fileWriter, "model", Build.MODEL);
                b(fileWriter, "android_version", Build.VERSION.RELEASE);
                b(fileWriter, "android_sdk", String.valueOf(Build.VERSION.SDK_INT));
                b(fileWriter, "from", TbConfig.getFrom());
                String currentFrom = TbConfig.getCurrentFrom();
                b(fileWriter, "current_from", currentFrom);
                b(fileWriter, "uid", this.f20416a.getStringExtra("uid"));
                b(fileWriter, "client_id", TbadkCoreApplication.getClientId());
                b(fileWriter, "imei", TbadkCoreApplication.getInst().getImei());
                b(fileWriter, "uname", this.f20416a.getStringExtra("uname"));
                fileWriter.append("\n##TIEBA_NATIVE_END##\n");
                m.h(fileWriter);
                fileWriter2 = currentFrom;
            } catch (Exception e3) {
                e = e3;
                fileWriter2 = fileWriter;
                e.printStackTrace();
                m.h(fileWriter2);
                fileWriter2 = fileWriter2;
            } catch (Throwable th2) {
                th = th2;
                fileWriter2 = fileWriter;
                m.h(fileWriter2);
                throw th;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NetWork netWork = this.f20417b;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            FatalErrorService.this.mTask = null;
            super.cancel(true);
            FatalErrorService.this.stopSelf();
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x0022 */
        /* JADX WARN: Type inference failed for: r0v11, types: [boolean] */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v13 */
        public final void d(File file) {
            BufferedReader bufferedReader;
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    try {
                        bufferedReader = new BufferedReader(new FileReader(file));
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    String readLine = bufferedReader.readLine();
                    while (readLine != null) {
                        ?? startsWith = readLine.startsWith("crash_type=");
                        if (startsWith != 0) {
                            startsWith = 10;
                            TiebaStatic.crash(readLine.substring(10));
                        }
                        readLine = bufferedReader.readLine();
                        bufferedReader2 = startsWith;
                    }
                    bufferedReader.close();
                } catch (Exception e3) {
                    e = e3;
                    bufferedReader2 = bufferedReader;
                    BdLog.e(e.toString());
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (Exception e4) {
                            BdLog.e(e4.toString());
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                BdLog.e(e5.toString());
            }
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:72:0x00fa */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:105:0x010b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:113:0x0119 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:126:0x00fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.io.ByteArrayOutputStream, java.io.FileWriter, java.io.FileInputStream] */
        /* JADX WARN: Type inference failed for: r0v1, types: [java.io.ByteArrayOutputStream] */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.io.ByteArrayOutputStream] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void e(File file, String str, String str2, boolean z, boolean z2) {
            FileWriter fileWriter;
            FileInputStream fileInputStream;
            ?? r0 = 0;
            r0 = 0;
            r0 = 0;
            r0 = 0;
            r0 = 0;
            r0 = 0;
            try {
                if (file != null) {
                    try {
                        if (file.length() > 50) {
                            fileInputStream = new FileInputStream(file);
                            try {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                                try {
                                    if (z) {
                                        g.a(fileInputStream, byteArrayOutputStream);
                                    } else {
                                        byte[] bArr = new byte[1024];
                                        while (true) {
                                            int read = fileInputStream.read(bArr, 0, 1024);
                                            if (read == -1) {
                                                break;
                                            }
                                            byteArrayOutputStream.write(bArr, 0, read);
                                        }
                                        byteArrayOutputStream.flush();
                                    }
                                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                                    if (byteArray == null) {
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Exception e2) {
                                            BdLog.e(e2.getMessage());
                                        }
                                        try {
                                            fileInputStream.close();
                                            return;
                                        } catch (Exception e3) {
                                            BdLog.e(e3.getMessage());
                                            return;
                                        }
                                    }
                                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + str);
                                    this.f20417b = netWork;
                                    netWork.addPostData("logfile", byteArray);
                                    if (!TextUtils.isEmpty(str2) && !"0".equals(str2)) {
                                        this.f20417b.addPostData(FatalErrorService.ERROR_TYPE_KEY, str2);
                                    }
                                    this.f20417b.postMultiNetData();
                                    byteArrayOutputStream.close();
                                    fileInputStream.close();
                                    if (this.f20417b.getNetContext().getResponse().isRequestSuccess()) {
                                        if (z2) {
                                            d(file);
                                        }
                                        fileWriter = new FileWriter(file, false);
                                        try {
                                            fileWriter.append((CharSequence) "");
                                            fileWriter.flush();
                                            fileWriter.close();
                                            file.delete();
                                        } catch (Exception e4) {
                                            e = e4;
                                            fileInputStream = null;
                                            try {
                                                BdLog.e(e.getMessage());
                                                if (r0 != 0) {
                                                    try {
                                                        r0.close();
                                                    } catch (Exception e5) {
                                                        BdLog.e(e5.getMessage());
                                                    }
                                                }
                                                if (fileInputStream != null) {
                                                    try {
                                                        fileInputStream.close();
                                                    } catch (Exception e6) {
                                                        BdLog.e(e6.getMessage());
                                                    }
                                                }
                                                if (fileWriter != null) {
                                                    fileWriter.close();
                                                }
                                                return;
                                            } catch (Throwable th) {
                                                th = th;
                                                if (r0 != 0) {
                                                    try {
                                                        r0.close();
                                                    } catch (Exception e7) {
                                                        BdLog.e(e7.getMessage());
                                                    }
                                                }
                                                if (fileInputStream != null) {
                                                    try {
                                                        fileInputStream.close();
                                                    } catch (Exception e8) {
                                                        BdLog.e(e8.getMessage());
                                                    }
                                                }
                                                if (fileWriter != null) {
                                                    try {
                                                        fileWriter.close();
                                                    } catch (Exception e9) {
                                                        BdLog.e(e9.getMessage());
                                                    }
                                                }
                                                throw th;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            fileInputStream = null;
                                            if (r0 != 0) {
                                            }
                                            if (fileInputStream != null) {
                                            }
                                            if (fileWriter != null) {
                                            }
                                            throw th;
                                        }
                                    }
                                } catch (Exception e10) {
                                    e = e10;
                                    fileWriter = null;
                                    r0 = byteArrayOutputStream;
                                } catch (Throwable th3) {
                                    th = th3;
                                    fileWriter = null;
                                    r0 = byteArrayOutputStream;
                                }
                            } catch (Exception e11) {
                                e = e11;
                                fileWriter = null;
                            } catch (Throwable th4) {
                                th = th4;
                                fileWriter = null;
                            }
                        }
                    } catch (Exception e12) {
                        e = e12;
                        fileWriter = null;
                        fileInputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        fileWriter = null;
                        fileInputStream = null;
                    }
                }
                if (0 != 0) {
                    try {
                        r0.close();
                    } catch (Exception e13) {
                        BdLog.e(e13.getMessage());
                    }
                }
                if (0 != 0) {
                    try {
                        r0.close();
                    } catch (Exception e14) {
                        BdLog.e(e14.getMessage());
                    }
                }
                if (0 != 0) {
                    r0.close();
                }
            } catch (Exception e15) {
                BdLog.e(e15.getMessage());
            }
        }

        public final void f() {
            File GetFileByAbsolutePath = FileHelper.GetFileByAbsolutePath(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + TbConfig.FATAL_ERROR_ALERT_FILE);
            if (GetFileByAbsolutePath == null) {
                return;
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(GetFileByAbsolutePath)));
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        stringBuffer.append(readLine);
                    } else {
                        String stringBuffer2 = stringBuffer.toString();
                        BdLog.i("sendLogForAlert log = " + stringBuffer2);
                        BdStatisticsManager.getInstance().alert("alert_crash", stringBuffer2);
                        GetFileByAbsolutePath.delete();
                        return;
                    }
                }
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            boolean z;
            File[] listFiles;
            try {
                e(FileHelper.GetFileByAbsolutePath(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + TbConfig.FATAL_ERROR_FILE), TbConfig.ERROR_UPLOAD_SERVER, "0", true, true);
                e(FileHelper.GetFileByAbsolutePath(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + TbConfig.LOG_ERROR_FILE), "c/s/clientlog", "0", false, false);
                f();
                if (TbConfig.getVersion().equals(b.j().p("native_crash_dump_version", ""))) {
                    z = true;
                } else {
                    b.j().x("native_crash_dump_version", TbConfig.getVersion());
                    z = false;
                }
                File GetFile = FileHelper.GetFile(TbConfig.FATAL_ERROR_NATIVE_DIR);
                if (GetFile != null) {
                    for (File file : GetFile.listFiles()) {
                        if (file.length() >= 1024 && z) {
                            c(file);
                            e(file, TbConfig.ERROR_UPLOAD_SERVER, "4", true, true);
                        } else {
                            file.delete();
                        }
                    }
                    return null;
                }
                return null;
            } catch (Exception e2) {
                BdLog.e(e2.toString());
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            FatalErrorService.this.mTask = null;
            FatalErrorService.this.stopSelf();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        a aVar = this.mTask;
        if (aVar != null) {
            aVar.cancel();
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        super.onStart(intent, i2);
        if (this.mTask == null) {
            a aVar = new a(intent);
            this.mTask = aVar;
            aVar.execute(new String[0]);
        }
    }
}
