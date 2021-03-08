package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d.q;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static q f4636a;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [50=4] */
    public static void a() {
        FileInputStream fileInputStream;
        try {
            File file = new File(b.e(), "temp_pkg_info.json");
            Long valueOf = Long.valueOf(file.length());
            if (valueOf.longValue() > 0 && file.exists() && file.isFile()) {
                byte[] bArr = new byte[valueOf.intValue()];
                fileInputStream = new FileInputStream(file);
                try {
                    fileInputStream.read(bArr);
                    q a2 = q.a(new JSONObject(new String(bArr, "utf-8")));
                    if (a2 != null) {
                        f4636a = a2;
                        u.b("Version", "old version read success: " + f4636a.b());
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        u.c("Version", "version init error", th);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                return;
                            } catch (IOException e) {
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th2) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                        throw th2;
                    }
                }
            } else {
                u.b("Version", "version pkg json file does not exist");
                fileInputStream = null;
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static synchronized q b() {
        q qVar;
        synchronized (f.class) {
            qVar = f4636a;
        }
        return qVar;
    }

    public static synchronized void a(q qVar) {
        synchronized (f.class) {
            if (qVar != null) {
                if (qVar.f()) {
                    f4636a = qVar;
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [108=4] */
    public static void c() {
        FileOutputStream fileOutputStream;
        if (f4636a == null) {
            u.b("Version", "version save error1");
            return;
        }
        String g = f4636a.g();
        if (TextUtils.isEmpty(g)) {
            u.b("Version", "version save error2");
            return;
        }
        File file = new File(b.e(), "temp_pkg_info.json");
        File file2 = new File(file + ".tmp");
        if (file2.exists()) {
            file2.delete();
        }
        try {
            fileOutputStream = new FileOutputStream(file2);
            try {
                fileOutputStream.write(g.getBytes("utf-8"));
                if (file.exists()) {
                    file.delete();
                }
                file2.renameTo(file);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                try {
                    u.c("Version", "version save error3", th);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                } catch (Throwable th2) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public static q.a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (b() == null || b().e() == null) {
            return null;
        }
        if (b().f()) {
            for (q.a aVar : b().e()) {
                if (aVar.a() != null && aVar.a().equals(str)) {
                    return aVar;
                }
            }
        }
        return null;
    }

    public static boolean b(String str) {
        if (b() == null || TextUtils.isEmpty(b().b())) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String b = b().b();
        String[] split = str.split("\\.");
        String[] split2 = b.split("\\.");
        int min = Math.min(split.length, split2.length);
        for (int i = 0; i < min; i++) {
            int length = split[i].length() - split2[i].length();
            if (length != 0) {
                return length > 0;
            }
            int compareTo = split[i].compareTo(split2[i]);
            if (compareTo > 0) {
                return true;
            }
            if (compareTo < 0) {
                return false;
            }
            if (i == min - 1) {
                return split.length > split2.length;
            }
        }
        return false;
    }

    public static void d() {
        q b = b();
        if (b != null) {
            File e = b.e();
            try {
                new File(e, "temp_pkg_info.json").delete();
            } catch (Throwable th) {
            }
            if (b.e() != null) {
                for (q.a aVar : b.e()) {
                    try {
                        new File(e, j.a(aVar.a())).delete();
                    } catch (Throwable th2) {
                    }
                }
            }
            f4636a = null;
        }
    }
}
