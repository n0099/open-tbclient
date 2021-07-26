package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.e.u;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static u f31133a;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        FileInputStream fileInputStream;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
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
                            u a2 = u.a(new JSONObject(new String(bArr, "utf-8")));
                            if (a2 != null) {
                                f31133a = a2;
                                k.b(com.alipay.sdk.packet.e.f1946e, "old version read success: " + f31133a.b());
                            }
                            fileInputStream2 = fileInputStream;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                k.c(com.alipay.sdk.packet.e.f1946e, "version init error", th);
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
                        k.b(com.alipay.sdk.packet.e.f1946e, "version pkg json file does not exist");
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
    }

    public static synchronized u b() {
        InterceptResult invokeV;
        u uVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (f.class) {
                uVar = f31133a;
            }
            return uVar;
        }
        return (u) invokeV.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            u uVar = f31133a;
            if (uVar == null) {
                k.b(com.alipay.sdk.packet.e.f1946e, "version save error1");
                return;
            }
            String g2 = uVar.g();
            if (TextUtils.isEmpty(g2)) {
                k.b(com.alipay.sdk.packet.e.f1946e, "version save error2");
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
                            k.c(com.alipay.sdk.packet.e.f1946e, "version save error3", th);
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
    }

    public static void d() {
        u b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) || (b2 = b()) == null) {
            return;
        }
        File e2 = b.e();
        try {
            new File(e2, "temp_pkg_info.json").delete();
        } catch (Throwable unused) {
        }
        if (b2.e() != null) {
            for (u.a aVar : b2.e()) {
                try {
                    new File(e2, com.bytedance.sdk.component.utils.e.a(aVar.a())).delete();
                } catch (Throwable unused2) {
                }
            }
        }
        f31133a = null;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (b() != null && !TextUtils.isEmpty(b().b())) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                String b2 = b().b();
                String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                String[] split2 = b2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                int min = Math.min(split.length, split2.length);
                for (int i2 = 0; i2 < min; i2++) {
                    int length = split[i2].length() - split2[i2].length();
                    if (length != 0) {
                        return length > 0;
                    }
                    int compareTo = split[i2].compareTo(split2[i2]);
                    if (compareTo > 0) {
                        return true;
                    }
                    if (compareTo < 0) {
                        return false;
                    }
                    if (i2 == min - 1) {
                        return split.length > split2.length;
                    }
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void a(u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, uVar) == null) {
            synchronized (f.class) {
                if (uVar != null) {
                    if (uVar.f()) {
                        f31133a = uVar;
                    }
                }
            }
        }
    }

    public static u.a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && b() != null && b().e() != null && b().f()) {
                for (u.a aVar : b().e()) {
                    if (aVar.a() != null && aVar.a().equals(str)) {
                        return aVar;
                    }
                }
            }
            return null;
        }
        return (u.a) invokeL.objValue;
    }
}
