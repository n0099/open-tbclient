package com.baidu.tieba.service;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.w;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
/* loaded from: classes.dex */
final class d extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ FatalErrorService a;
    private ak b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ String a(String... strArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        super.a((d) str);
        this.a.a = null;
        this.a.stopSelf();
    }

    private d(FatalErrorService fatalErrorService) {
        this.a = fatalErrorService;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(FatalErrorService fatalErrorService, byte b) {
        this(fatalErrorService);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [159=6, 169=6, 179=5] */
    private void a(String str, String str2, boolean z, boolean z2) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        FileWriter fileWriter = null;
        try {
            try {
                File d = w.d(str);
                if (d == null || d.length() <= 50) {
                    return;
                }
                fileInputStream = new FileInputStream(d);
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                    try {
                        if (z) {
                            com.baidu.tbadk.d.a.a(fileInputStream, byteArrayOutputStream2);
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
                            try {
                                byteArrayOutputStream2.close();
                            } catch (Exception e) {
                                com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", e.getMessage());
                            }
                            try {
                                fileInputStream.close();
                                return;
                            } catch (Exception e2) {
                                com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", e2.getMessage());
                                return;
                            }
                        }
                        this.b = new ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + str2);
                        this.b.a("logfile", byteArray);
                        this.b.j();
                        byteArrayOutputStream2.close();
                        fileInputStream.close();
                        if (this.b.a().b().b()) {
                            if (z2) {
                                a(d);
                            }
                            FileWriter fileWriter2 = new FileWriter(d, false);
                            try {
                                fileWriter2.append((CharSequence) "");
                                fileWriter2.flush();
                                fileWriter2.close();
                                if (d.delete()) {
                                    return;
                                }
                                com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", "file.delete error");
                            } catch (Exception e3) {
                                e = e3;
                                byteArrayOutputStream2 = null;
                                fileWriter = fileWriter2;
                                fileInputStream = null;
                                com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", e.getMessage());
                                if (byteArrayOutputStream2 != null) {
                                    try {
                                        byteArrayOutputStream2.close();
                                    } catch (Exception e4) {
                                        com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", e4.getMessage());
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception e5) {
                                        com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", e5.getMessage());
                                    }
                                }
                                if (fileWriter != null) {
                                    try {
                                        fileWriter.close();
                                    } catch (Exception e6) {
                                        com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", e6.getMessage());
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                byteArrayOutputStream = null;
                                fileWriter = fileWriter2;
                                fileInputStream = null;
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception e7) {
                                        com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", e7.getMessage());
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception e8) {
                                        com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", e8.getMessage());
                                    }
                                }
                                if (fileWriter != null) {
                                    try {
                                        fileWriter.close();
                                    } catch (Exception e9) {
                                        com.baidu.adp.lib.util.f.b(getClass().getName(), "sendLogFile", e9.getMessage());
                                    }
                                }
                                throw th;
                            }
                        }
                    } catch (Exception e10) {
                        e = e10;
                    }
                } catch (Exception e11) {
                    e = e11;
                    byteArrayOutputStream2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e12) {
            e = e12;
            fileInputStream = null;
            byteArrayOutputStream2 = null;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            byteArrayOutputStream = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(File file) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            if (readLine.startsWith("crash_type=")) {
                                TiebaStatic.a(readLine.substring(10));
                            }
                        } else {
                            try {
                                bufferedReader.close();
                                return;
                            } catch (Exception e) {
                                com.baidu.adp.lib.util.f.b(getClass().getName(), "countCrashType", e.toString());
                                return;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        com.baidu.adp.lib.util.f.b(getClass().getName(), "countCrashType", e.toString());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                                return;
                            } catch (Exception e3) {
                                com.baidu.adp.lib.util.f.b(getClass().getName(), "countCrashType", e3.toString());
                                return;
                            }
                        }
                        return;
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        bufferedReader2.close();
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
            if (0 != 0) {
            }
            throw th;
        }
    }

    private String a() {
        a("fatal_error.log", "c/s/logupload", true, true);
        a("log_error.log", "c/s/clientlog", false, false);
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        if (this.b != null) {
            this.b.g();
        }
        this.a.a = null;
        super.cancel(true);
        this.a.stopSelf();
    }
}
