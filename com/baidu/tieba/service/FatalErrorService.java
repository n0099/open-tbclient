package com.baidu.tieba.service;

import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.g;
import com.baidu.adp.lib.util.n;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.x;
import com.baidu.webkit.internal.ETAG;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
/* loaded from: classes.dex */
public class FatalErrorService extends BdBaseService {
    private static final String ERROR_TYPE_KEY = "errortype";
    private static final String ERROR_TYPE_NATIVE_C = "4";
    private static final String ERROR_TYPE_UNKNOW = "0";
    private static final int NATIVE_CRASH_DUMP_MIN_SIZE = 1024;
    private a mTask = null;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (this.mTask != null) {
            this.mTask.cancel();
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (this.mTask == null) {
            this.mTask = new a(intent);
            this.mTask.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<String, Integer, String> {
        Intent intent;
        private x mNetwork = null;

        public a(Intent intent) {
            this.intent = intent;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [139=4, 140=4, 143=4, 144=4, 148=4, 149=4, 152=4, 153=4, 157=4, 158=4, 161=4, 162=4] */
        /* JADX WARN: Removed duplicated region for block: B:123:0x0114 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:125:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:127:0x0119 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:129:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:132:0x005c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:134:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:138:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:142:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:146:0x011e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:160:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:163:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void a(File file, String str, String str2, boolean z, boolean z2) {
            ByteArrayOutputStream byteArrayOutputStream;
            FileInputStream fileInputStream;
            ByteArrayOutputStream byteArrayOutputStream2;
            ByteArrayOutputStream byteArrayOutputStream3;
            FileInputStream fileInputStream2;
            FileWriter fileWriter = null;
            FileWriter fileWriter2 = null;
            try {
                if (file != null) {
                    try {
                        if (file.length() > 50) {
                            fileInputStream = new FileInputStream(file);
                            try {
                                byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                                try {
                                    if (z) {
                                        g.compress(fileInputStream, byteArrayOutputStream2);
                                    } else {
                                        byte[] bArr = new byte[1024];
                                        while (true) {
                                            int read = fileInputStream.read(bArr, 0, 1024);
                                            if (read == -1) {
                                                break;
                                            }
                                            byteArrayOutputStream2.write(bArr, 0, read);
                                        }
                                        byteArrayOutputStream2.flush();
                                    }
                                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                                    if (byteArray == null) {
                                        if (byteArrayOutputStream2 != null) {
                                            try {
                                                byteArrayOutputStream2.close();
                                            } catch (Exception e) {
                                                BdLog.e(e.getMessage());
                                            }
                                        }
                                        if (fileInputStream != null) {
                                            try {
                                                fileInputStream.close();
                                            } catch (Exception e2) {
                                                BdLog.e(e2.getMessage());
                                            }
                                        }
                                        if (0 != 0) {
                                            try {
                                                fileWriter2.close();
                                                return;
                                            } catch (Exception e3) {
                                                BdLog.e(e3.getMessage());
                                                return;
                                            }
                                        }
                                        return;
                                    }
                                    this.mNetwork = new x(TbConfig.SERVER_ADDRESS + str);
                                    this.mNetwork.addPostData("logfile", byteArray);
                                    if (!TextUtils.isEmpty(str2) && !"0".equals(str2)) {
                                        this.mNetwork.addPostData(FatalErrorService.ERROR_TYPE_KEY, str2);
                                    }
                                    this.mNetwork.postMultiNetData();
                                    if (byteArrayOutputStream2 != null) {
                                        byteArrayOutputStream2.close();
                                        byteArrayOutputStream3 = null;
                                    } else {
                                        byteArrayOutputStream3 = byteArrayOutputStream2;
                                    }
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                            fileInputStream2 = null;
                                        } catch (Exception e4) {
                                            e = e4;
                                            byteArrayOutputStream2 = byteArrayOutputStream3;
                                            BdLog.e(e.getMessage());
                                            if (byteArrayOutputStream2 != null) {
                                            }
                                            if (fileInputStream != null) {
                                            }
                                            if (fileWriter == null) {
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            byteArrayOutputStream = byteArrayOutputStream3;
                                            if (byteArrayOutputStream != null) {
                                            }
                                            if (fileInputStream != null) {
                                            }
                                            if (fileWriter != null) {
                                            }
                                            throw th;
                                        }
                                    } else {
                                        fileInputStream2 = fileInputStream;
                                    }
                                    try {
                                        if (this.mNetwork.aUA().aVc().isRequestSuccess()) {
                                            if (z2) {
                                                V(file);
                                            }
                                            FileWriter fileWriter3 = new FileWriter(file, false);
                                            try {
                                                fileWriter3.append((CharSequence) "");
                                                fileWriter3.flush();
                                                if (fileWriter3 != null) {
                                                    fileWriter3.close();
                                                } else {
                                                    fileWriter = fileWriter3;
                                                }
                                                if (!file.delete()) {
                                                }
                                            } catch (Exception e5) {
                                                e = e5;
                                                fileWriter = fileWriter3;
                                                fileInputStream = fileInputStream2;
                                                byteArrayOutputStream2 = byteArrayOutputStream3;
                                                BdLog.e(e.getMessage());
                                                if (byteArrayOutputStream2 != null) {
                                                    try {
                                                        byteArrayOutputStream2.close();
                                                    } catch (Exception e6) {
                                                        BdLog.e(e6.getMessage());
                                                    }
                                                }
                                                if (fileInputStream != null) {
                                                    try {
                                                        fileInputStream.close();
                                                    } catch (Exception e7) {
                                                        BdLog.e(e7.getMessage());
                                                    }
                                                }
                                                if (fileWriter == null) {
                                                    try {
                                                        fileWriter.close();
                                                        return;
                                                    } catch (Exception e8) {
                                                        BdLog.e(e8.getMessage());
                                                        return;
                                                    }
                                                }
                                                return;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                fileWriter = fileWriter3;
                                                fileInputStream = fileInputStream2;
                                                byteArrayOutputStream = byteArrayOutputStream3;
                                                if (byteArrayOutputStream != null) {
                                                    try {
                                                        byteArrayOutputStream.close();
                                                    } catch (Exception e9) {
                                                        BdLog.e(e9.getMessage());
                                                    }
                                                }
                                                if (fileInputStream != null) {
                                                    try {
                                                        fileInputStream.close();
                                                    } catch (Exception e10) {
                                                        BdLog.e(e10.getMessage());
                                                    }
                                                }
                                                if (fileWriter != null) {
                                                    try {
                                                        fileWriter.close();
                                                    } catch (Exception e11) {
                                                        BdLog.e(e11.getMessage());
                                                    }
                                                }
                                                throw th;
                                            }
                                        }
                                        if (byteArrayOutputStream3 != null) {
                                            try {
                                                byteArrayOutputStream3.close();
                                            } catch (Exception e12) {
                                                BdLog.e(e12.getMessage());
                                            }
                                        }
                                        if (fileInputStream2 != null) {
                                            try {
                                                fileInputStream2.close();
                                            } catch (Exception e13) {
                                                BdLog.e(e13.getMessage());
                                            }
                                        }
                                        if (fileWriter == null) {
                                            try {
                                                fileWriter.close();
                                                return;
                                            } catch (Exception e14) {
                                                BdLog.e(e14.getMessage());
                                                return;
                                            }
                                        }
                                        return;
                                    } catch (Exception e15) {
                                        e = e15;
                                        fileInputStream = fileInputStream2;
                                        byteArrayOutputStream2 = byteArrayOutputStream3;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        fileInputStream = fileInputStream2;
                                        byteArrayOutputStream = byteArrayOutputStream3;
                                    }
                                } catch (Exception e16) {
                                    e = e16;
                                }
                            } catch (Exception e17) {
                                e = e17;
                                byteArrayOutputStream2 = null;
                            } catch (Throwable th4) {
                                th = th4;
                                byteArrayOutputStream = null;
                            }
                        }
                    } catch (Exception e18) {
                        e = e18;
                        fileInputStream = null;
                        byteArrayOutputStream2 = null;
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream = null;
                        byteArrayOutputStream = null;
                    }
                }
                fileInputStream2 = null;
                byteArrayOutputStream3 = null;
                if (byteArrayOutputStream3 != null) {
                }
                if (fileInputStream2 != null) {
                }
                if (fileWriter == null) {
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [182=4] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void V(File file) {
            BufferedReader bufferedReader;
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                try {
                    try {
                        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                            if (readLine.startsWith("crash_type=")) {
                                TiebaStatic.crash(readLine.substring("crash_type=".length() - 1));
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e) {
                                BdLog.e(e.toString());
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.e(e.toString());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e3) {
                                BdLog.e(e3.toString());
                            }
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e4) {
                            BdLog.e(e4.toString());
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
                if (bufferedReader != null) {
                }
                throw th;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            File[] listFiles;
            boolean z = true;
            try {
                a(m.GetFileByAbsolutePath(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + TbConfig.FATAL_ERROR_FILE), TbConfig.ERROR_UPLOAD_SERVER, "0", true, true);
                a(m.GetFileByAbsolutePath(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + TbConfig.LOG_ERROR_FILE), Config.ERROR_LOG_SERVER, "0", false, false);
                cWV();
                if (!TbConfig.getVersion().equals(b.aTX().getString(SharedPrefConfig.NATIVE_CRASH_DUMP_VERSION, ""))) {
                    b.aTX().putString(SharedPrefConfig.NATIVE_CRASH_DUMP_VERSION, TbConfig.getVersion());
                    z = false;
                }
                File GetFile = m.GetFile(TbConfig.FATAL_ERROR_NATIVE_DIR);
                if (GetFile != null) {
                    for (File file : GetFile.listFiles()) {
                        if (file.length() >= 1024 && z) {
                            W(file);
                            a(file, TbConfig.ERROR_UPLOAD_SERVER, "4", true, true);
                        } else {
                            file.delete();
                        }
                    }
                    return null;
                }
                return null;
            } catch (Exception e) {
                BdLog.e(e.toString());
                return null;
            }
        }

        private void cWV() {
            File GetFileByAbsolutePath = m.GetFileByAbsolutePath(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + TbConfig.FATAL_ERROR_ALERT_FILE);
            if (GetFileByAbsolutePath != null) {
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
                            BdStatisticsManager.getInstance().alert(BdStatsConstant.AlertTypeKey.ALERT_CRASH, stringBuffer2);
                            GetFileByAbsolutePath.delete();
                            return;
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }

        private void W(File file) {
            FileWriter fileWriter;
            if (file == null || !file.exists() || !file.isFile()) {
                return;
            }
            try {
                if (this.intent != null) {
                    try {
                        fileWriter = new FileWriter(file, true);
                        try {
                            fileWriter.append("\n##TIEBA_NATIVE##\n");
                            addInfo(fileWriter, aq.getCurrentString(), null);
                            addInfo(fileWriter, "version", TbConfig.getVersion());
                            addInfo(fileWriter, "model", Build.MODEL);
                            addInfo(fileWriter, "android_version", Build.VERSION.RELEASE);
                            addInfo(fileWriter, "android_sdk", String.valueOf(Build.VERSION.SDK_INT));
                            addInfo(fileWriter, "from", TbConfig.getFrom());
                            addInfo(fileWriter, "current_from", TbConfig.getCurrentFrom());
                            addInfo(fileWriter, "uid", this.intent.getStringExtra("uid"));
                            addInfo(fileWriter, "client_id", TbadkCoreApplication.getClientId());
                            addInfo(fileWriter, "imei", TbadkCoreApplication.getInst().getImei());
                            addInfo(fileWriter, BdStatsConstant.StatsKey.UNAME, this.intent.getStringExtra(BdStatsConstant.StatsKey.UNAME));
                            fileWriter.append("\n##TIEBA_NATIVE_END##\n");
                            n.close((Writer) fileWriter);
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            n.close((Writer) fileWriter);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        fileWriter = null;
                    } catch (Throwable th) {
                        th = th;
                        fileWriter = null;
                        n.close((Writer) fileWriter);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        private void addInfo(FileWriter fileWriter, String str, String str2) {
            try {
                fileWriter.append((CharSequence) str);
                if (str2 != null) {
                    fileWriter.append(ETAG.EQUAL);
                    fileWriter.append((CharSequence) str2);
                }
                fileWriter.append("\n");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            FatalErrorService.this.mTask = null;
            super.cancel(true);
            FatalErrorService.this.stopSelf();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            FatalErrorService.this.mTask = null;
            FatalErrorService.this.stopSelf();
        }
    }
}
