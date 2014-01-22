package com.baidu.tieba.service;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.ad;
import com.baidu.tieba.util.ak;
import com.baidu.tieba.util.ax;
import com.baidu.tieba.util.by;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
/* loaded from: classes.dex */
class e extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ FatalErrorService a;
    private ax b;

    private e(FatalErrorService fatalErrorService) {
        this.a = fatalErrorService;
        this.b = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [128=4, 133=4, 134=4, 137=4, 138=4, 143=4, 144=4, 147=4, 148=4, 123=4, 124=4, 127=4] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:158:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, String str2, boolean z, boolean z2) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        String name;
        String str3;
        String message;
        FileInputStream fileInputStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        FileWriter fileWriter = null;
        FileWriter fileWriter2 = null;
        try {
            try {
                File d = ad.d(str);
                if (d == null || d.length() <= 50) {
                    fileInputStream2 = null;
                    byteArrayOutputStream2 = null;
                } else {
                    fileInputStream = new FileInputStream(d);
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream(1024);
                        try {
                            if (z) {
                                ak.a(fileInputStream, byteArrayOutputStream);
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
                                        com.baidu.adp.lib.g.e.b(getClass().getName(), "sendLogFile", e.getMessage());
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception e2) {
                                        com.baidu.adp.lib.g.e.b(getClass().getName(), "sendLogFile", e2.getMessage());
                                    }
                                }
                                if (0 != 0) {
                                    try {
                                        fileWriter2.close();
                                        return;
                                    } catch (Exception e3) {
                                        name = getClass().getName();
                                        str3 = "sendLogFile";
                                        message = e3.getMessage();
                                        com.baidu.adp.lib.g.e.b(name, str3, message);
                                    }
                                }
                                return;
                            }
                            this.b = new ax(com.baidu.tieba.data.h.a + str2);
                            this.b.a("logfile", byteArray);
                            this.b.o();
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
                                    com.baidu.adp.lib.g.e.b(getClass().getName(), "sendLogFile", e.getMessage());
                                    if (byteArrayOutputStream != null) {
                                    }
                                    if (fileInputStream != null) {
                                    }
                                    if (fileWriter == null) {
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    byteArrayOutputStream = byteArrayOutputStream2;
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
                                            com.baidu.adp.lib.g.e.b(getClass().getName(), "sendLogFile", "file.delete error");
                                        }
                                    } catch (Exception e5) {
                                        e = e5;
                                        fileWriter = fileWriter3;
                                        fileInputStream = fileInputStream2;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        com.baidu.adp.lib.g.e.b(getClass().getName(), "sendLogFile", e.getMessage());
                                        if (byteArrayOutputStream != null) {
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (Exception e6) {
                                                com.baidu.adp.lib.g.e.b(getClass().getName(), "sendLogFile", e6.getMessage());
                                            }
                                        }
                                        if (fileInputStream != null) {
                                            try {
                                                fileInputStream.close();
                                            } catch (Exception e7) {
                                                com.baidu.adp.lib.g.e.b(getClass().getName(), "sendLogFile", e7.getMessage());
                                            }
                                        }
                                        if (fileWriter == null) {
                                            try {
                                                fileWriter.close();
                                                return;
                                            } catch (Exception e8) {
                                                name = getClass().getName();
                                                str3 = "sendLogFile";
                                                message = e8.getMessage();
                                                com.baidu.adp.lib.g.e.b(name, str3, message);
                                            }
                                        }
                                        return;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        fileWriter = fileWriter3;
                                        fileInputStream = fileInputStream2;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        if (byteArrayOutputStream != null) {
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (Exception e9) {
                                                com.baidu.adp.lib.g.e.b(getClass().getName(), "sendLogFile", e9.getMessage());
                                            }
                                        }
                                        if (fileInputStream != null) {
                                            try {
                                                fileInputStream.close();
                                            } catch (Exception e10) {
                                                com.baidu.adp.lib.g.e.b(getClass().getName(), "sendLogFile", e10.getMessage());
                                            }
                                        }
                                        if (fileWriter != null) {
                                            try {
                                                fileWriter.close();
                                            } catch (Exception e11) {
                                                com.baidu.adp.lib.g.e.b(getClass().getName(), "sendLogFile", e11.getMessage());
                                            }
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
                        com.baidu.adp.lib.g.e.b(getClass().getName(), "sendLogFile", e15.getMessage());
                    }
                }
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e16) {
                        com.baidu.adp.lib.g.e.b(getClass().getName(), "sendLogFile", e16.getMessage());
                    }
                }
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (Exception e17) {
                        name = getClass().getName();
                        str3 = "sendLogFile";
                        message = e17.getMessage();
                        com.baidu.adp.lib.g.e.b(name, str3, message);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=5] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(File file) {
        BufferedReader bufferedReader;
        String name;
        String str;
        String exc;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                try {
                    for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                        if (readLine.startsWith("crash_type=")) {
                            by.a(readLine.substring("crash_type=".length() - 1));
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e) {
                            name = getClass().getName();
                            str = "countCrashType";
                            exc = e.toString();
                            com.baidu.adp.lib.g.e.b(name, str, exc);
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    com.baidu.adp.lib.g.e.b(getClass().getName(), "countCrashType", e.toString());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e3) {
                            name = getClass().getName();
                            str = "countCrashType";
                            exc = e3.toString();
                            com.baidu.adp.lib.g.e.b(name, str, exc);
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e4) {
                        com.baidu.adp.lib.g.e.b(getClass().getName(), "countCrashType", e4.toString());
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
        super.a((e) str);
        this.a.a = null;
        this.a.stopSelf();
    }
}
