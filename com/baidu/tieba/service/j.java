package com.baidu.tieba.service;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ae;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ PerformMonitorService a;
    private ae b;

    private j(PerformMonitorService performMonitorService) {
        this.a = performMonitorService;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(PerformMonitorService performMonitorService, j jVar) {
        this(performMonitorService);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [294=4, 295=4, 298=4, 299=4, 303=4, 304=4, 307=4, 308=4, 312=4, 313=4, 316=4, 317=4] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, String str2, boolean z) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        FileInputStream fileInputStream2;
        ByteArrayOutputStream byteArrayOutputStream3;
        FileWriter fileWriter = null;
        FileWriter fileWriter2 = null;
        try {
            try {
                File d = com.baidu.tbadk.core.util.s.d(str);
                if (d != null) {
                    fileInputStream = new FileInputStream(d);
                    try {
                        byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                        try {
                            if (z) {
                                com.baidu.tbadk.c.b.a(fileInputStream, byteArrayOutputStream2);
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
                            this.b = new ae(String.valueOf(TbConfig.SERVER_ADDRESS) + str2);
                            this.b.a("logfile", byteArray);
                            this.b.a("errortype", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                            this.b.i();
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
                                if (this.b.a().b().b()) {
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
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        a("performance_sample.log", TbConfig.ERROR_UPLOAD_SERVER, false);
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
