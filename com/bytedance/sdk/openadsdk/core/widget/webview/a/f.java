package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.text.TextUtils;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.bytedance.sdk.openadsdk.core.d.s;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static s f28699a;

    public static void a() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                File file = new File(b.e(), "temp_pkg_info.json");
                Long valueOf = Long.valueOf(file.length());
                if (valueOf.longValue() > 0 && file.exists() && file.isFile()) {
                    byte[] bArr = new byte[valueOf.intValue()];
                    fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        s a2 = s.a(new JSONObject(new String(bArr, "utf-8")));
                        if (a2 != null) {
                            f28699a = a2;
                            u.b(com.alipay.sdk.packet.e.f1944e, "old version read success: " + f28699a.b());
                        }
                        fileInputStream2 = fileInputStream;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            u.c(com.alipay.sdk.packet.e.f1944e, "version init error", th);
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return;
                        } catch (Throwable th3) {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            throw th3;
                        }
                    }
                } else {
                    u.b(com.alipay.sdk.packet.e.f1944e, "version pkg json file does not exist");
                }
            } catch (IOException unused2) {
                return;
            }
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
        }
        if (fileInputStream2 != null) {
            fileInputStream2.close();
        }
    }

    public static synchronized s b() {
        s sVar;
        synchronized (f.class) {
            sVar = f28699a;
        }
        return sVar;
    }

    public static void c() {
        s sVar = f28699a;
        if (sVar == null) {
            u.b(com.alipay.sdk.packet.e.f1944e, "version save error1");
            return;
        }
        String g2 = sVar.g();
        if (TextUtils.isEmpty(g2)) {
            u.b(com.alipay.sdk.packet.e.f1944e, "version save error2");
            return;
        }
        File file = new File(b.e(), "temp_pkg_info.json");
        File file2 = new File(file + ".tmp");
        if (file2.exists()) {
            file2.delete();
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    fileOutputStream2.write(g2.getBytes("utf-8"));
                    if (file.exists()) {
                        file.delete();
                    }
                    file2.renameTo(file);
                    fileOutputStream2.close();
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    try {
                        u.c(com.alipay.sdk.packet.e.f1944e, "version save error3", th);
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th2) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th2;
                    }
                }
            } catch (IOException unused2) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static void d() {
        s b2 = b();
        if (b2 == null) {
            return;
        }
        File e2 = b.e();
        try {
            new File(e2, "temp_pkg_info.json").delete();
        } catch (Throwable unused) {
        }
        if (b2.e() != null) {
            for (s.a aVar : b2.e()) {
                try {
                    new File(e2, j.a(aVar.a())).delete();
                } catch (Throwable unused2) {
                }
            }
        }
        f28699a = null;
    }

    public static boolean b(String str) {
        if (b() != null && !TextUtils.isEmpty(b().b())) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String b2 = b().b();
            String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            String[] split2 = b2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
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
        return true;
    }

    public static synchronized void a(s sVar) {
        synchronized (f.class) {
            if (sVar != null) {
                if (sVar.f()) {
                    f28699a = sVar;
                }
            }
        }
    }

    public static s.a a(String str) {
        if (!TextUtils.isEmpty(str) && b() != null && b().e() != null && b().f()) {
            for (s.a aVar : b().e()) {
                if (aVar.a() != null && aVar.a().equals(str)) {
                    return aVar;
                }
            }
        }
        return null;
    }
}
