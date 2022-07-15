package com.bytedance.pangle.e.a;

import android.content.pm.PackageInfo;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.heytap.mcssdk.PushManager;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes4.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE] complete} */
    public static e a(File file) {
        InterceptResult invokeL;
        ZipFile zipFile;
        a aVar;
        int b;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65536, null, file)) != null) {
            return (e) invokeL.objValue;
        }
        try {
            if (!file.exists()) {
                ZeusLogger.e(ZeusLogger.TAG_INSTALL, file.getAbsolutePath() + " not exists!");
                com.bytedance.pangle.util.f.a((Closeable) null);
                return null;
            }
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry(CommonMethods.ANDROID_MANIFEST_FILENAME);
                if (entry == null) {
                    ZeusLogger.e(ZeusLogger.TAG_INSTALL, "没有找到AndroidManifest.xml entry");
                    com.bytedance.pangle.util.f.a(zipFile2);
                    return null;
                }
                aVar = new a();
                try {
                    InputStream inputStream = zipFile2.getInputStream(entry);
                    aVar.a();
                    if (inputStream != null) {
                        aVar.b = new b(inputStream);
                    }
                    do {
                        b = aVar.b();
                        if (b == 1) {
                            ZeusLogger.e(ZeusLogger.TAG_INSTALL, "已达到END_DOCUMENT");
                            try {
                                aVar.a();
                            } catch (Throwable unused) {
                            }
                            com.bytedance.pangle.util.f.a(zipFile2);
                            return null;
                        }
                    } while (b != 2);
                    int length = aVar.a != 2 ? -1 : aVar.c.length / 5;
                    String str = null;
                    String str2 = null;
                    for (int i2 = 0; i2 != length; i2++) {
                        if (PushManager.APP_VERSION_CODE.equals(aVar.a(i2))) {
                            str = a(aVar, i2);
                        } else if ("package".equals(aVar.a(i2))) {
                            str2 = a(aVar, i2);
                        }
                    }
                    try {
                        i = Integer.parseInt(str);
                    } catch (Throwable unused2) {
                        i = -1;
                    }
                    if (i == -1) {
                        ZeusLogger.e(ZeusLogger.TAG_INSTALL, "versionCode获取失败:".concat(String.valueOf(str)));
                        try {
                            aVar.a();
                        } catch (Throwable unused3) {
                        }
                        com.bytedance.pangle.util.f.a(zipFile2);
                        return null;
                    }
                    e eVar = new e(str2, i);
                    try {
                        aVar.a();
                    } catch (Throwable unused4) {
                    }
                    com.bytedance.pangle.util.f.a(zipFile2);
                    return eVar;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    zipFile = zipFile2;
                    th = th2;
                    try {
                        PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getPath(), 0);
                        if (packageArchiveInfo == null) {
                            ZeusLogger.e(ZeusLogger.TAG_INSTALL, "packageArchiveInfo == null", th);
                            return null;
                        }
                        e eVar2 = new e(packageArchiveInfo.packageName, packageArchiveInfo.versionCode);
                        if (aVar != null) {
                            try {
                                aVar.a();
                            } catch (Throwable unused5) {
                            }
                        }
                        com.bytedance.pangle.util.f.a(zipFile);
                        return eVar2;
                    } finally {
                        if (aVar != null) {
                            try {
                                aVar.a();
                            } catch (Throwable unused6) {
                            }
                        }
                        com.bytedance.pangle.util.f.a(zipFile);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                aVar = null;
            }
        } catch (Throwable th4) {
            th = th4;
            zipFile = null;
            aVar = null;
        }
    }

    public static String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? (i >>> 24) == 1 ? "android:" : "" : (String) invokeI.objValue;
    }

    public static String a(a aVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, aVar, i)) == null) {
            int b = aVar.b(i);
            int c = aVar.c(i);
            if (b == 3) {
                return aVar.d(i);
            }
            return b == 2 ? String.format("?%s%08X", a(c), Integer.valueOf(c)) : (b < 16 || b > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(c), Integer.valueOf(b)) : String.valueOf(c);
        }
        return (String) invokeLI.objValue;
    }
}
