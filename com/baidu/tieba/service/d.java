package com.baidu.tieba.service;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.af;
import com.baidu.tieba.util.am;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.util.cb;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
/* loaded from: classes.dex */
class d extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ FatalErrorService a;
    private ba b;

    private d(FatalErrorService fatalErrorService) {
        this.a = fatalErrorService;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(FatalErrorService fatalErrorService, d dVar) {
        this(fatalErrorService);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [128=8, 129=4, 133=4, 134=4, 137=4, 138=8, 139=4, 143=4, 144=4, 147=4, 148=8, 149=4, 123=4, 124=4, 127=4] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, String str2, boolean z, boolean z2) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        FileInputStream fileInputStream2;
        ByteArrayOutputStream byteArrayOutputStream3;
        FileWriter fileWriter = null;
        FileWriter fileWriter2 = null;
        try {
            try {
                File d = af.d(str);
                if (d == null || d.length() <= 50) {
                    fileInputStream2 = null;
                    byteArrayOutputStream3 = null;
                } else {
                    fileInputStream = new FileInputStream(d);
                    try {
                        byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                        try {
                            if (z) {
                                am.a(fileInputStream, byteArrayOutputStream2);
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
                                        com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", e.getMessage());
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception e2) {
                                        com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", e2.getMessage());
                                    }
                                }
                                if (0 != 0) {
                                    try {
                                        fileWriter2.close();
                                        return;
                                    } catch (Exception e3) {
                                        com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", e3.getMessage());
                                        return;
                                    }
                                }
                                return;
                            }
                            this.b = new ba(String.valueOf(com.baidu.tieba.data.i.a) + str2);
                            this.b.a("logfile", byteArray);
                            this.b.n();
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
                                    com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", e.getMessage());
                                    if (byteArrayOutputStream2 != null) {
                                        try {
                                            byteArrayOutputStream2.close();
                                        } catch (Exception e5) {
                                            com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", e5.getMessage());
                                        }
                                    }
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (Exception e6) {
                                            com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", e6.getMessage());
                                        }
                                    }
                                    if (fileWriter == null) {
                                        try {
                                            fileWriter.close();
                                            return;
                                        } catch (Exception e7) {
                                            com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", e7.getMessage());
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
                                            com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", e8.getMessage());
                                        }
                                    }
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (Exception e9) {
                                            com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", e9.getMessage());
                                        }
                                    }
                                    if (fileWriter != null) {
                                        try {
                                            fileWriter.close();
                                        } catch (Exception e10) {
                                            com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", e10.getMessage());
                                        }
                                    }
                                    throw th;
                                }
                            } else {
                                fileInputStream2 = fileInputStream;
                            }
                            try {
                                if (this.b.d()) {
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
                                        if (!d.delete()) {
                                            com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", "file.delete error");
                                        }
                                    } catch (Exception e11) {
                                        e = e11;
                                        fileWriter = fileWriter3;
                                        fileInputStream = fileInputStream2;
                                        byteArrayOutputStream2 = byteArrayOutputStream3;
                                        com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", e.getMessage());
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
                            } catch (Exception e12) {
                                e = e12;
                                fileInputStream = fileInputStream2;
                                byteArrayOutputStream2 = byteArrayOutputStream3;
                            } catch (Throwable th3) {
                                th = th3;
                                fileInputStream = fileInputStream2;
                                byteArrayOutputStream = byteArrayOutputStream3;
                            }
                        } catch (Exception e13) {
                            e = e13;
                        }
                    } catch (Exception e14) {
                        e = e14;
                        byteArrayOutputStream2 = null;
                    } catch (Throwable th4) {
                        th = th4;
                        byteArrayOutputStream = null;
                    }
                }
                if (byteArrayOutputStream3 != null) {
                    try {
                        byteArrayOutputStream3.close();
                    } catch (Exception e15) {
                        com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", e15.getMessage());
                    }
                }
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e16) {
                        com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", e16.getMessage());
                    }
                }
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (Exception e17) {
                        com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", e17.getMessage());
                    }
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Exception e18) {
            e = e18;
            fileInputStream = null;
            byteArrayOutputStream2 = null;
        } catch (Throwable th6) {
            th = th6;
            fileInputStream = null;
            byteArrayOutputStream = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
                            cb.a(readLine.substring("crash_type=".length() - 1));
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e) {
                            com.baidu.adp.lib.util.f.b(getClass().getName(), "countCrashType", e.toString());
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "countCrashType", e.toString());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e3) {
                            com.baidu.adp.lib.util.f.b(getClass().getName(), "countCrashType", e3.toString());
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e4) {
                        com.baidu.adp.lib.util.f.b(getClass().getName(), "countCrashType", e4.toString());
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
    public String a(String... strArr) {
        a("fatal_error.log", "c/s/logupload", true, true);
        a("log_error.log", "c/s/clientlog", false, false);
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.k();
        }
        this.a.a = null;
        super.cancel(true);
        this.a.stopSelf();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        super.a((d) str);
        this.a.a = null;
        this.a.stopSelf();
    }
}
