package com.baidu.tieba.service;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.af;
import com.baidu.tieba.util.ah;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.util.bg;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<String, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PerformMonitorService f2346a;
    private ap b;

    private j(PerformMonitorService performMonitorService) {
        this.f2346a = performMonitorService;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(PerformMonitorService performMonitorService, g gVar) {
        this(performMonitorService);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [294=4, 295=4, 298=4, 299=4, 304=4, 305=4, 308=4, 309=4, 314=4, 315=4, 318=4, 319=4] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, String str2, boolean z) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        String name;
        String str3;
        String message;
        FileInputStream fileInputStream2;
        ByteArrayOutputStream byteArrayOutputStream3;
        FileWriter fileWriter = null;
        FileWriter fileWriter2 = null;
        try {
            try {
                File d = af.d(str);
                if (d != null) {
                    fileInputStream = new FileInputStream(d);
                    try {
                        byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                        try {
                            if (z) {
                                ah.a(fileInputStream, byteArrayOutputStream2);
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
                                        bg.b(getClass().getName(), "sendPerformFile", e.getMessage());
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception e2) {
                                        bg.b(getClass().getName(), "sendPerformFile", e2.getMessage());
                                    }
                                }
                                if (0 != 0) {
                                    try {
                                        fileWriter2.close();
                                        return;
                                    } catch (Exception e3) {
                                        name = getClass().getName();
                                        str3 = "sendPerformFile";
                                        message = e3.getMessage();
                                        bg.b(name, str3, message);
                                    }
                                }
                                return;
                            }
                            this.b = new ap(com.baidu.tieba.data.h.f1196a + str2);
                            this.b.a("logfile", byteArray);
                            this.b.a("errortype", "3");
                            this.b.l();
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
                                    bg.b(getClass().getName(), "sendPerformFile", e.getMessage());
                                    if (byteArrayOutputStream2 != null) {
                                        try {
                                            byteArrayOutputStream2.close();
                                        } catch (Exception e5) {
                                            bg.b(getClass().getName(), "sendPerformFile", e5.getMessage());
                                        }
                                    }
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (Exception e6) {
                                            bg.b(getClass().getName(), "sendPerformFile", e6.getMessage());
                                        }
                                    }
                                    if (fileWriter == null) {
                                        try {
                                            fileWriter.close();
                                            return;
                                        } catch (Exception e7) {
                                            name = getClass().getName();
                                            str3 = "sendPerformFile";
                                            message = e7.getMessage();
                                            bg.b(name, str3, message);
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
                                            bg.b(getClass().getName(), "sendPerformFile", e8.getMessage());
                                        }
                                    }
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (Exception e9) {
                                            bg.b(getClass().getName(), "sendPerformFile", e9.getMessage());
                                        }
                                    }
                                    if (fileWriter != null) {
                                        try {
                                            fileWriter.close();
                                        } catch (Exception e10) {
                                            bg.b(getClass().getName(), "sendPerformFile", e10.getMessage());
                                        }
                                    }
                                    throw th;
                                }
                            } else {
                                fileInputStream2 = fileInputStream;
                            }
                            try {
                                if (this.b.c()) {
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
                                            bg.b(getClass().getName(), "sendPerformFile", "file.delete error");
                                        }
                                    } catch (Exception e11) {
                                        e = e11;
                                        fileWriter = fileWriter3;
                                        fileInputStream = fileInputStream2;
                                        byteArrayOutputStream2 = byteArrayOutputStream3;
                                        bg.b(getClass().getName(), "sendPerformFile", e.getMessage());
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
                } else {
                    fileInputStream2 = null;
                    byteArrayOutputStream3 = null;
                }
                if (byteArrayOutputStream3 != null) {
                    try {
                        byteArrayOutputStream3.close();
                    } catch (Exception e15) {
                        bg.b(getClass().getName(), "sendPerformFile", e15.getMessage());
                    }
                }
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e16) {
                        bg.b(getClass().getName(), "sendPerformFile", e16.getMessage());
                    }
                }
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (Exception e17) {
                        name = getClass().getName();
                        str3 = "sendPerformFile";
                        message = e17.getMessage();
                        bg.b(name, str3, message);
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        a("performance_sample.log", "c/s/logupload", false);
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.h();
        }
        this.f2346a.g = null;
        super.cancel(true);
        this.f2346a.stopSelf();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        super.a((j) str);
        this.f2346a.g = null;
        this.f2346a.stopSelf();
    }
}
