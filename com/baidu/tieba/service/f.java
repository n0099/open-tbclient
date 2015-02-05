package com.baidu.tieba.service;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.bf;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
/* loaded from: classes.dex */
class f extends BdAsyncTask<String, Integer, String> {
    private ad CU;
    final /* synthetic */ FatalErrorService bOT;

    private f(FatalErrorService fatalErrorService) {
        this.bOT = fatalErrorService;
        this.CU = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(FatalErrorService fatalErrorService, f fVar) {
        this(fatalErrorService);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [151=4, 152=4, 155=4, 156=4, 160=4, 161=4, 164=4, 165=4, 169=4, 170=4, 173=4, 174=4] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x010d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0117 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
                                    com.baidu.tbadk.util.g.c(fileInputStream, byteArrayOutputStream2);
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
                                this.CU = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + str);
                                this.CU.g("logfile", byteArray);
                                if (!TextUtils.isEmpty(str2) && !"0".equals(str2)) {
                                    this.CU.o("errortype", str2);
                                }
                                this.CU.ou();
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
                                            try {
                                                byteArrayOutputStream2.close();
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
                                        if (fileWriter == null) {
                                            try {
                                                fileWriter.close();
                                                return;
                                            } catch (Exception e7) {
                                                BdLog.e(e7.getMessage());
                                                return;
                                            }
                                        }
                                        return;
                                    } catch (Throwable th) {
                                        th = th;
                                        byteArrayOutputStream = byteArrayOutputStream3;
                                        if (byteArrayOutputStream != null) {
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (Exception e8) {
                                                BdLog.e(e8.getMessage());
                                            }
                                        }
                                        if (fileInputStream != null) {
                                            try {
                                                fileInputStream.close();
                                            } catch (Exception e9) {
                                                BdLog.e(e9.getMessage());
                                            }
                                        }
                                        if (fileWriter != null) {
                                            try {
                                                fileWriter.close();
                                            } catch (Exception e10) {
                                                BdLog.e(e10.getMessage());
                                            }
                                        }
                                        throw th;
                                    }
                                } else {
                                    fileInputStream2 = fileInputStream;
                                }
                                try {
                                    if (this.CU.oS().qa().lT()) {
                                        if (z2) {
                                            u(file);
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
                                            file.delete();
                                        } catch (Exception e11) {
                                            e = e11;
                                            fileWriter = fileWriter3;
                                            fileInputStream = fileInputStream2;
                                            byteArrayOutputStream2 = byteArrayOutputStream3;
                                            BdLog.e(e.getMessage());
                                            if (byteArrayOutputStream2 != null) {
                                            }
                                            if (fileInputStream != null) {
                                            }
                                            if (fileWriter == null) {
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            fileWriter = fileWriter3;
                                            fileInputStream = fileInputStream2;
                                            byteArrayOutputStream = byteArrayOutputStream3;
                                            if (byteArrayOutputStream != null) {
                                            }
                                            if (fileInputStream != null) {
                                            }
                                            if (fileWriter != null) {
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

    /* JADX WARN: Removed duplicated region for block: B:40:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void u(File file) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
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
                if (0 != 0) {
                    try {
                        bufferedReader2.close();
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
            if (0 != 0) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public String doInBackground(String... strArr) {
        File[] listFiles;
        try {
            a(com.baidu.tbadk.core.util.s.ce(TbConfig.FATAL_ERROR_FILE), TbConfig.ERROR_UPLOAD_SERVER, "0", true, true);
            a(com.baidu.tbadk.core.util.s.ce(TbConfig.LOG_ERROR_FILE), "c/s/clientlog", "0", false, false);
            File ce = com.baidu.tbadk.core.util.s.ce(TbConfig.FATAL_ERROR_NATIVE_DIR);
            if (ce != null) {
                for (File file : ce.listFiles()) {
                    v(file);
                    a(file, TbConfig.ERROR_UPLOAD_SERVER, "4", true, true);
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return null;
        }
    }

    private void v(File file) {
        FileWriter fileWriter;
        if (file != null && file.exists()) {
            try {
                if (file.isFile()) {
                    try {
                        fileWriter = new FileWriter(file, true);
                        try {
                            fileWriter.append("\n##TIEBA_NATIVE##\n");
                            a(fileWriter, bf.pz(), null);
                            a(fileWriter, "version", TbConfig.getVersion());
                            a(fileWriter, "model", Build.MODEL);
                            a(fileWriter, "android_version", Build.VERSION.RELEASE);
                            a(fileWriter, "android_sdk", String.valueOf(Build.VERSION.SDK_INT));
                            a(fileWriter, "from", TbConfig.getFrom());
                            a(fileWriter, "current_from", TbConfig.getCurrentFrom());
                            a(fileWriter, SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                            a(fileWriter, "client_id", TbadkCoreApplication.getClientId());
                            a(fileWriter, "imei", TbadkCoreApplication.m255getInst().getImei());
                            a(fileWriter, "uname", TbadkCoreApplication.getCurrentAccountName());
                            com.baidu.adp.lib.util.t.a(fileWriter);
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            com.baidu.adp.lib.util.t.a(fileWriter);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        fileWriter = null;
                    } catch (Throwable th) {
                        th = th;
                        fileWriter = null;
                        com.baidu.adp.lib.util.t.a(fileWriter);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private void a(FileWriter fileWriter, String str, String str2) {
        try {
            fileWriter.append((CharSequence) str);
            if (str2 != null) {
                fileWriter.append("=");
                fileWriter.append((CharSequence) str2);
            }
            fileWriter.append("\n");
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.CU != null) {
            this.CU.dJ();
        }
        this.bOT.mTask = null;
        super.cancel(true);
        this.bOT.stopSelf();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((f) str);
        this.bOT.mTask = null;
        this.bOT.stopSelf();
    }
}
