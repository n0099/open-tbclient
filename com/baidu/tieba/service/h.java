package com.baidu.tieba.service;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.w;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ PerformMonitorService a;
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
        super.a((h) str);
        this.a.g = null;
        this.a.stopSelf();
    }

    private h(PerformMonitorService performMonitorService) {
        this.a = performMonitorService;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(PerformMonitorService performMonitorService, byte b) {
        this(performMonitorService);
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x0142 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x013d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0138 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a() {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        FileWriter fileWriter;
        FileInputStream fileInputStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        FileWriter fileWriter2 = null;
        try {
            File d = w.d("performance_sample.log");
            if (d != null) {
                fileInputStream = new FileInputStream(d);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream(1024);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream.read(bArr, 0, 1024);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        byteArrayOutputStream.flush();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (byteArray == null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e) {
                                com.baidu.adp.lib.util.f.b(getClass().getName(), "sendPerformFile", e.getMessage());
                            }
                            try {
                                fileInputStream.close();
                            } catch (Exception e2) {
                                com.baidu.adp.lib.util.f.b(getClass().getName(), "sendPerformFile", e2.getMessage());
                            }
                        } else {
                            this.b = new ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/s/logupload");
                            this.b.a("logfile", byteArray);
                            this.b.a("errortype", "3");
                            this.b.j();
                            byteArrayOutputStream.close();
                            fileInputStream.close();
                            if (this.b.a().b().b()) {
                                fileWriter = new FileWriter(d, false);
                                try {
                                    fileWriter.append((CharSequence) "");
                                    fileWriter.flush();
                                    fileWriter.close();
                                    if (!d.delete()) {
                                        com.baidu.adp.lib.util.f.b(getClass().getName(), "sendPerformFile", "file.delete error");
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    fileInputStream2 = null;
                                    byteArrayOutputStream2 = null;
                                    try {
                                        com.baidu.adp.lib.util.f.b(getClass().getName(), "sendPerformFile", e.getMessage());
                                        if (byteArrayOutputStream2 != null) {
                                            try {
                                                byteArrayOutputStream2.close();
                                            } catch (Exception e4) {
                                                com.baidu.adp.lib.util.f.b(getClass().getName(), "sendPerformFile", e4.getMessage());
                                            }
                                        }
                                        if (fileInputStream2 != null) {
                                            try {
                                                fileInputStream2.close();
                                            } catch (Exception e5) {
                                                com.baidu.adp.lib.util.f.b(getClass().getName(), "sendPerformFile", e5.getMessage());
                                            }
                                        }
                                        if (fileWriter != null) {
                                            try {
                                                fileWriter.close();
                                            } catch (Exception e6) {
                                                com.baidu.adp.lib.util.f.b(getClass().getName(), "sendPerformFile", e6.getMessage());
                                            }
                                        }
                                        return null;
                                    } catch (Throwable th) {
                                        th = th;
                                        fileWriter2 = fileWriter;
                                        fileInputStream = fileInputStream2;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        if (byteArrayOutputStream != null) {
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (Exception e7) {
                                                com.baidu.adp.lib.util.f.b(getClass().getName(), "sendPerformFile", e7.getMessage());
                                            }
                                        }
                                        if (fileInputStream != null) {
                                            try {
                                                fileInputStream.close();
                                            } catch (Exception e8) {
                                                com.baidu.adp.lib.util.f.b(getClass().getName(), "sendPerformFile", e8.getMessage());
                                            }
                                        }
                                        if (fileWriter2 != null) {
                                            try {
                                                fileWriter2.close();
                                            } catch (Exception e9) {
                                                com.baidu.adp.lib.util.f.b(getClass().getName(), "sendPerformFile", e9.getMessage());
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    byteArrayOutputStream = null;
                                    fileWriter2 = fileWriter;
                                    fileInputStream = null;
                                    if (byteArrayOutputStream != null) {
                                    }
                                    if (fileInputStream != null) {
                                    }
                                    if (fileWriter2 != null) {
                                    }
                                    throw th;
                                }
                            }
                        }
                    } catch (Exception e10) {
                        e = e10;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        fileInputStream2 = fileInputStream;
                        fileWriter = null;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Exception e11) {
                    e = e11;
                    fileInputStream2 = fileInputStream;
                    byteArrayOutputStream2 = null;
                    fileWriter = null;
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream = null;
                }
            }
        } catch (Exception e12) {
            e = e12;
            fileWriter = null;
            fileInputStream2 = null;
            byteArrayOutputStream2 = null;
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
            byteArrayOutputStream = null;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        if (this.b != null) {
            this.b.g();
        }
        this.a.g = null;
        super.cancel(true);
        this.a.stopSelf();
    }
}
