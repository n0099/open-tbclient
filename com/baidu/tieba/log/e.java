package com.baidu.tieba.log;

import android.text.TextUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.ae;
import com.baidu.tieba.util.am;
import com.baidu.tieba.util.bd;
import com.baidu.tieba.util.x;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
/* loaded from: classes.dex */
class e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f1917a;
    private am b;

    private e(a aVar) {
        this.f1917a = aVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(a aVar, b bVar) {
        this(aVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [598=4, 599=4, 602=4, 603=4, 608=4, 609=4, 612=4, 613=4] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, String str2, boolean z) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        String str3;
        String str4;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            File file = new File(str);
            String name = file.getName();
            if (file != null) {
                fileInputStream = new FileInputStream(file);
                try {
                    String[] split = name.split("-");
                    String str5 = split.length > 1 ? split[0] : null;
                    byteArrayOutputStream = new ByteArrayOutputStream(1024);
                    try {
                        if (z) {
                            ae.a(fileInputStream, byteArrayOutputStream);
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
                                    bd.b(getClass().getName(), "sendLogFile", e.getMessage());
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                    return;
                                } catch (Exception e2) {
                                    bd.b(getClass().getName(), "sendLogFile", e2.getMessage());
                                    return;
                                }
                            }
                            return;
                        }
                        this.b = new am(com.baidu.tieba.data.h.f1248a + str2);
                        this.b.a(SocialConstants.PARAM_CUID, com.baidu.tieba.im.i.a());
                        this.b.a("uid", TiebaApplication.B());
                        this.b.a("time", str5);
                        this.b.a("errortype", "99");
                        this.b.a("logfile", byteArray);
                        this.b.n();
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                            byteArrayOutputStream = null;
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                            fileInputStream = null;
                        }
                        if (this.b.c()) {
                            str3 = a.d;
                            x.k(str3);
                            if (TextUtils.isEmpty(x.a("log", name, "logbak", name))) {
                                bd.b(getClass().getName(), "sendLogFile", "file.move error");
                            }
                            a aVar = this.f1917a;
                            str4 = a.d;
                            aVar.g(str4);
                        }
                    } catch (Exception e3) {
                        e = e3;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        try {
                            bd.b(getClass().getName(), "sendLogFile", e.getMessage());
                            if (byteArrayOutputStream2 != null) {
                                try {
                                    byteArrayOutputStream2.close();
                                } catch (Exception e4) {
                                    bd.b(getClass().getName(), "sendLogFile", e4.getMessage());
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                    return;
                                } catch (Exception e5) {
                                    bd.b(getClass().getName(), "sendLogFile", e5.getMessage());
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
                                } catch (Exception e6) {
                                    bd.b(getClass().getName(), "sendLogFile", e6.getMessage());
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e7) {
                                    bd.b(getClass().getName(), "sendLogFile", e7.getMessage());
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
                    bd.b(getClass().getName(), "sendLogFile", e9.getMessage());
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e10) {
                    bd.b(getClass().getName(), "sendLogFile", e10.getMessage());
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
            this.b.j();
        }
    }
}
