package com.bytedance.pangle.e.a;

import android.content.pm.PackageInfo;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.heytap.mcssdk.PushManager;
import java.io.File;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes6.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE] complete} */
    public static e a(File file) {
        InterceptResult invokeL;
        ZipFile zipFile;
        a aVar;
        int next;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65536, null, file)) != null) {
            return (e) invokeL.objValue;
        }
        try {
            if (!file.exists()) {
                ZeusLogger.e(ZeusLogger.TAG_INSTALL, file.getAbsolutePath() + " not exists!");
                com.bytedance.pangle.util.f.a(null);
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
                    aVar.close();
                    if (inputStream != null) {
                        aVar.a = new c(inputStream);
                    }
                    do {
                        next = aVar.next();
                        if (next == 1) {
                            ZeusLogger.e(ZeusLogger.TAG_INSTALL, "已达到END_DOCUMENT");
                            try {
                                aVar.close();
                            } catch (Throwable unused) {
                            }
                            com.bytedance.pangle.util.f.a(zipFile2);
                            return null;
                        }
                    } while (next != 2);
                    int attributeCount = aVar.getAttributeCount();
                    String str = null;
                    String str2 = null;
                    for (int i2 = 0; i2 != attributeCount; i2++) {
                        if (PushManager.APP_VERSION_CODE.equals(aVar.getAttributeName(i2))) {
                            str = a(aVar, i2);
                        } else if ("package".equals(aVar.getAttributeName(i2))) {
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
                            aVar.close();
                        } catch (Throwable unused3) {
                        }
                        com.bytedance.pangle.util.f.a(zipFile2);
                        return null;
                    }
                    e eVar = new e(str2, i);
                    try {
                        aVar.close();
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
                        ZeusLogger.e(ZeusLogger.TAG_INSTALL, "getSimplePackageInfo failed", th);
                        PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getPath(), 0);
                        if (packageArchiveInfo == null) {
                            return null;
                        }
                        e eVar2 = new e(packageArchiveInfo.packageName, packageArchiveInfo.versionCode);
                        if (aVar != null) {
                            try {
                                aVar.close();
                            } catch (Throwable unused5) {
                            }
                        }
                        com.bytedance.pangle.util.f.a(zipFile);
                        return eVar2;
                    } finally {
                        if (aVar != null) {
                            try {
                                aVar.close();
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
            int a = aVar.a(i);
            int b2 = aVar.b(i);
            if (a == 3) {
                return aVar.getAttributeValue(i);
            }
            return a == 2 ? String.format("?%s%08X", a(b2), Integer.valueOf(b2)) : (a < 16 || a > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(b2), Integer.valueOf(a)) : String.valueOf(b2);
        }
        return (String) invokeLI.objValue;
    }
}
