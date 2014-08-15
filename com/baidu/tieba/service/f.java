package com.baidu.tieba.service;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
/* loaded from: classes.dex */
class f extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ FatalErrorService a;
    private ae b;

    private f(FatalErrorService fatalErrorService) {
        this.a = fatalErrorService;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(FatalErrorService fatalErrorService, f fVar) {
        this(fatalErrorService);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [149=4, 150=4, 153=4, 154=4, 158=4, 159=4, 162=4, 163=4, 167=4, 168=4, 171=4, 172=4] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, String str2, boolean z, boolean z2) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        FileWriter fileWriter = null;
        FileWriter fileWriter2 = null;
        try {
            try {
                File d = com.baidu.tbadk.core.util.s.d(str);
                if (d == null || d.length() <= 50) {
                    fileInputStream2 = null;
                    byteArrayOutputStream2 = null;
                } else {
                    fileInputStream = new FileInputStream(d);
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream(1024);
                        try {
                            if (z) {
                                com.baidu.tbadk.c.b.a(fileInputStream, byteArrayOutputStream);
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
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
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
                            this.b = new ae(String.valueOf(TbConfig.SERVER_ADDRESS) + str2);
                            this.b.a("logfile", byteArray);
                            this.b.i();
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                                byteArrayOutputStream2 = null;
                            } else {
                                byteArrayOutputStream2 = byteArrayOutputStream;
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                    fileInputStream2 = null;
                                } catch (Exception e4) {
                                    e = e4;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    BdLog.e(e.getMessage());
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
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
                                    byteArrayOutputStream = byteArrayOutputStream2;
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
                                if (this.b.a().b().b()) {
                                    if (z2) {
                                        a(d);
                                    }
                                    FileWriter fileWriter3 = new FileWriter(d, false);
                                    try {
                                        fileWriter3.append((CharSequence) "");
                                        fileWriter3.flush();
                                        if (fileWriter3 != null) {
                                            fileWriter3.close();
                                        } else {
                                            fileWriter = fileWriter3;
                                        }
                                        d.delete();
                                    } catch (Exception e11) {
                                        e = e11;
                                        fileWriter = fileWriter3;
                                        fileInputStream = fileInputStream2;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        BdLog.e(e.getMessage());
                                        if (byteArrayOutputStream != null) {
                                        }
                                        if (fileInputStream != null) {
                                        }
                                        if (fileWriter == null) {
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        fileWriter = fileWriter3;
                                        fileInputStream = fileInputStream2;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        if (byteArrayOutputStream != null) {
                                        }
                                        if (fileInputStream != null) {
                                        }
                                        if (fileWriter != null) {
                                        }
                                        throw th;
                                    }
                                }
                            } catch (Exception e12) {
                                e = e12;
                                fileInputStream = fileInputStream2;
                                byteArrayOutputStream = byteArrayOutputStream2;
                            } catch (Throwable th3) {
                                th = th3;
                                fileInputStream = fileInputStream2;
                                byteArrayOutputStream = byteArrayOutputStream2;
                            }
                        } catch (Exception e13) {
                            e = e13;
                        }
                    } catch (Exception e14) {
                        e = e14;
                        byteArrayOutputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        byteArrayOutputStream = null;
                    }
                }
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Exception e15) {
                        BdLog.e(e15.getMessage());
                    }
                }
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e16) {
                        BdLog.e(e16.getMessage());
                    }
                }
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (Exception e17) {
                        BdLog.e(e17.getMessage());
                    }
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Exception e18) {
            e = e18;
            fileInputStream = null;
            byteArrayOutputStream = null;
        } catch (Throwable th6) {
            th = th6;
            fileInputStream = null;
            byteArrayOutputStream = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(File file) {
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
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        a(TbConfig.FATAL_ERROR_FILE, TbConfig.ERROR_UPLOAD_SERVER, true, true);
        a(TbConfig.LOG_ERROR_FILE, "c/s/clientlog", false, false);
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.f();
        }
        this.a.mTask = null;
        super.cancel(true);
        this.a.stopSelf();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        this.a.mTask = null;
        this.a.stopSelf();
    }
}
