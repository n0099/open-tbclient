package com.baidu.tieba.service;

import android.os.AsyncTask;
import com.baidu.tieba.c.ae;
import com.baidu.tieba.c.q;
import com.baidu.tieba.c.t;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
/* loaded from: classes.dex */
class c extends AsyncTask {
    final /* synthetic */ FatalErrorService a;
    private t b;

    private c(FatalErrorService fatalErrorService) {
        this.a = fatalErrorService;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(FatalErrorService fatalErrorService, c cVar) {
        this(fatalErrorService);
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, String str2, boolean z) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        FileWriter fileWriter = null;
        FileWriter fileWriter2 = null;
        try {
            try {
                File c = com.baidu.tieba.c.o.c(str);
                if (c == null || c.length() <= 50) {
                    fileInputStream2 = null;
                    byteArrayOutputStream2 = null;
                } else {
                    fileInputStream = new FileInputStream(c);
                    try {
                        byte[] bArr = null;
                        byteArrayOutputStream = new ByteArrayOutputStream(1024);
                        try {
                            if (z) {
                                q.b(fileInputStream, byteArrayOutputStream);
                            } else {
                                byte[] bArr2 = new byte[1024];
                                while (true) {
                                    int read = fileInputStream.read(bArr2, 0, 1024);
                                    if (read == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr2, 0, read);
                                }
                                byteArrayOutputStream.flush();
                            }
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            if (byteArray == null) {
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception e) {
                                        ae.b(getClass().getName(), "sendLogFile", e.getMessage());
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception e2) {
                                        ae.b(getClass().getName(), "sendLogFile", e2.getMessage());
                                    }
                                }
                                if (0 != 0) {
                                    try {
                                        fileWriter2.close();
                                        return;
                                    } catch (Exception e3) {
                                        ae.b(getClass().getName(), "sendLogFile", e3.getMessage());
                                        return;
                                    }
                                }
                                return;
                            }
                            this.b = new t("http://c.tieba.baidu.com/" + str2);
                            this.b.a("logfile", byteArray);
                            this.b.j();
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
                                    ae.b(getClass().getName(), "sendLogFile", e.getMessage());
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
                                if (this.b.b()) {
                                    FileWriter fileWriter3 = new FileWriter(c, false);
                                    try {
                                        fileWriter3.append((CharSequence) "");
                                        fileWriter3.flush();
                                        if (fileWriter3 != null) {
                                            fileWriter3.close();
                                        } else {
                                            fileWriter = fileWriter3;
                                        }
                                        if (!c.delete()) {
                                            ae.b(getClass().getName(), "sendLogFile", "file.delete error");
                                        }
                                    } catch (Exception e5) {
                                        e = e5;
                                        fileWriter = fileWriter3;
                                        fileInputStream = fileInputStream2;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        ae.b(getClass().getName(), "sendLogFile", e.getMessage());
                                        if (byteArrayOutputStream != null) {
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (Exception e6) {
                                                ae.b(getClass().getName(), "sendLogFile", e6.getMessage());
                                            }
                                        }
                                        if (fileInputStream != null) {
                                            try {
                                                fileInputStream.close();
                                            } catch (Exception e7) {
                                                ae.b(getClass().getName(), "sendLogFile", e7.getMessage());
                                            }
                                        }
                                        if (fileWriter == null) {
                                            try {
                                                fileWriter.close();
                                                return;
                                            } catch (Exception e8) {
                                                ae.b(getClass().getName(), "sendLogFile", e8.getMessage());
                                                return;
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
                                                ae.b(getClass().getName(), "sendLogFile", e9.getMessage());
                                            }
                                        }
                                        if (fileInputStream != null) {
                                            try {
                                                fileInputStream.close();
                                            } catch (Exception e10) {
                                                ae.b(getClass().getName(), "sendLogFile", e10.getMessage());
                                            }
                                        }
                                        if (fileWriter != null) {
                                            try {
                                                fileWriter.close();
                                            } catch (Exception e11) {
                                                ae.b(getClass().getName(), "sendLogFile", e11.getMessage());
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
                        ae.b(getClass().getName(), "sendLogFile", e15.getMessage());
                    }
                }
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e16) {
                        ae.b(getClass().getName(), "sendLogFile", e16.getMessage());
                    }
                }
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (Exception e17) {
                        ae.b(getClass().getName(), "sendLogFile", e17.getMessage());
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        a("fatal_error.log", "c/s/logupload", true);
        a("log_error.log", "c/s/clientlog", false);
        return null;
    }

    public void a() {
        if (this.b != null) {
            this.b.g();
        }
        this.a.a = null;
        super.cancel(true);
        this.a.stopSelf();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        this.a.a = null;
        this.a.stopSelf();
    }
}
