package com.baidu.tieba.util;

import android.text.TextUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
/* loaded from: classes.dex */
class t {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f2460a;
    private ag b;

    private t(o oVar) {
        this.f2460a = oVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(o oVar, p pVar) {
        this(oVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [742=4, 743=4, 746=4, 747=4, 752=4, 753=4, 756=4, 757=4] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, String str2, boolean z) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        String name;
        String str3;
        String message;
        String str4;
        String str5;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            File file = new File(str);
            String name2 = file.getName();
            if (file != null) {
                fileInputStream = new FileInputStream(file);
                try {
                    String[] split = name2.split("-");
                    String str6 = split.length > 1 ? split[0] : null;
                    byteArrayOutputStream = new ByteArrayOutputStream(1024);
                    try {
                        if (z) {
                            y.a(fileInputStream, byteArrayOutputStream);
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
                                    be.b(getClass().getName(), "sendLogFile", e.getMessage());
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                    return;
                                } catch (Exception e2) {
                                    name = getClass().getName();
                                    str3 = "sendLogFile";
                                    message = e2.getMessage();
                                    be.b(name, str3, message);
                                }
                            }
                            return;
                        }
                        this.b = new ag(com.baidu.tieba.data.h.f1165a + str2);
                        this.b.a(SocialConstants.PARAM_CUID, com.baidu.tieba.im.i.a());
                        this.b.a("uid", TiebaApplication.C());
                        this.b.a("time", str6);
                        this.b.a("errortype", "99");
                        this.b.a("logfile", byteArray);
                        this.b.l();
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                            byteArrayOutputStream = null;
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                            fileInputStream = null;
                        }
                        if (this.b.c()) {
                            str4 = o.e;
                            w.k(str4);
                            if (TextUtils.isEmpty(w.a("log", name2, "logbak", name2))) {
                                be.b(getClass().getName(), "sendLogFile", "file.move error");
                            }
                            o oVar = this.f2460a;
                            str5 = o.e;
                            oVar.d(str5);
                        }
                    } catch (Exception e3) {
                        e = e3;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        try {
                            be.b(getClass().getName(), "sendLogFile", e.getMessage());
                            if (byteArrayOutputStream2 != null) {
                                try {
                                    byteArrayOutputStream2.close();
                                } catch (Exception e4) {
                                    be.b(getClass().getName(), "sendLogFile", e4.getMessage());
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                    return;
                                } catch (Exception e5) {
                                    name = getClass().getName();
                                    str3 = "sendLogFile";
                                    message = e5.getMessage();
                                    be.b(name, str3, message);
                                }
                            }
                            return;
                        } catch (Throwable th) {
                            th = th;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception e6) {
                                    be.b(getClass().getName(), "sendLogFile", e6.getMessage());
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e7) {
                                    be.b(getClass().getName(), "sendLogFile", e7.getMessage());
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (byteArrayOutputStream != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        throw th;
                    }
                } catch (Exception e8) {
                    e = e8;
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                }
            } else {
                fileInputStream = null;
                byteArrayOutputStream = null;
            }
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e9) {
                    be.b(getClass().getName(), "sendLogFile", e9.getMessage());
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e10) {
                    name = getClass().getName();
                    str3 = "sendLogFile";
                    message = e10.getMessage();
                    be.b(name, str3, message);
                }
            }
        } catch (Exception e11) {
            e = e11;
            fileInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            byteArrayOutputStream = null;
        }
    }

    public void a() {
        if (this.b != null) {
            this.b.h();
        }
    }
}
