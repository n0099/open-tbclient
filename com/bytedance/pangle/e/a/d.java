package com.bytedance.pangle.e.a;

import android.content.pm.PackageInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.g;
import com.heytap.mcssdk.PushManager;
import java.io.File;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes11.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE] complete} */
    public static e a(File file) {
        InterceptResult invokeL;
        ZipFile zipFile;
        a aVar;
        int next;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65536, null, file)) != null) {
            return (e) invokeL.objValue;
        }
        try {
            if (!file.exists()) {
                ZeusLogger.e(ZeusLogger.TAG_INSTALL, file.getAbsolutePath() + " not exists!");
                g.a(null);
                return null;
            }
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("AndroidManifest.xml");
                if (entry == null) {
                    ZeusLogger.e(ZeusLogger.TAG_INSTALL, "没有找到AndroidManifest.xml entry");
                    g.a(zipFile2);
                    return null;
                }
                aVar = new a();
                try {
                    InputStream inputStream = zipFile2.getInputStream(entry);
                    aVar.close();
                    if (inputStream != null) {
                        aVar.f61363a = new c(inputStream);
                    }
                    do {
                        next = aVar.next();
                        if (next == 1) {
                            ZeusLogger.e(ZeusLogger.TAG_INSTALL, "已达到END_DOCUMENT");
                            try {
                                aVar.close();
                            } catch (Throwable unused) {
                            }
                            g.a(zipFile2);
                            return null;
                        }
                    } while (next != 2);
                    int attributeCount = aVar.getAttributeCount();
                    String str = null;
                    String str2 = null;
                    for (int i3 = 0; i3 != attributeCount; i3++) {
                        if (PushManager.APP_VERSION_CODE.equals(aVar.getAttributeName(i3))) {
                            str = a(aVar, i3);
                        } else if ("package".equals(aVar.getAttributeName(i3))) {
                            str2 = a(aVar, i3);
                        }
                    }
                    try {
                        i2 = Integer.parseInt(str);
                    } catch (Throwable unused2) {
                        i2 = -1;
                    }
                    if (i2 == -1) {
                        ZeusLogger.e(ZeusLogger.TAG_INSTALL, "versionCode获取失败:".concat(String.valueOf(str)));
                        try {
                            aVar.close();
                        } catch (Throwable unused3) {
                        }
                        g.a(zipFile2);
                        return null;
                    }
                    e eVar = new e(str2, i2);
                    try {
                        aVar.close();
                    } catch (Throwable unused4) {
                    }
                    g.a(zipFile2);
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
                        g.a(zipFile);
                        return eVar2;
                    } finally {
                        if (aVar != null) {
                            try {
                                aVar.close();
                            } catch (Throwable unused6) {
                            }
                        }
                        g.a(zipFile);
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

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) ? (i2 >>> 24) == 1 ? "android:" : "" : (String) invokeI.objValue;
    }

    public static String a(a aVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, aVar, i2)) == null) {
            int a2 = aVar.a(i2);
            int b2 = aVar.b(i2);
            if (a2 == 3) {
                return aVar.getAttributeValue(i2);
            }
            return a2 == 2 ? String.format("?%s%08X", a(b2), Integer.valueOf(b2)) : (a2 < 16 || a2 > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(b2), Integer.valueOf(a2)) : String.valueOf(b2);
        }
        return (String) invokeLI.objValue;
    }
}
