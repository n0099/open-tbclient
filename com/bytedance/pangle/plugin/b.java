package com.bytedance.pangle.plugin;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nps.utils.Constant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.ApkVerifier;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusParam;
import com.bytedance.pangle.b.b;
import com.bytedance.pangle.d.b;
import com.bytedance.pangle.g;
import com.bytedance.pangle.helper.PluginDirHelper;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.e;
import com.bytedance.pangle.util.f;
import dalvik.system.DexFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends IOException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(String str, byte b) {
            this(str);
        }

        public /* synthetic */ a(String str, Throwable th, byte b) {
            this(str, th);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Throwable th) {
            super(str, th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, th};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Throwable) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean a(File file, String str, int i) {
        InterceptResult invokeLLI;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLI = interceptable.invokeLLI(65538, null, file, str, i)) != null) {
            return invokeLLI.booleanValue;
        }
        StringBuilder sb = new StringBuilder();
        try {
            try {
                com.bytedance.pangle.log.c a2 = com.bytedance.pangle.log.c.a(ZeusLogger.TAG_INSTALL, "PluginInstaller", "install:".concat(String.valueOf(str)));
                a(com.bytedance.pangle.b.b.e, b.a.l, str, i, -1L, null, null);
                e.a(PluginDirHelper.getPackageVersionDir(str, i));
                long a3 = a2.a("cleanDir");
                if (a3 > 30 || a3 < 0) {
                    sb.append("cleanDir cost:");
                    sb.append(a3);
                    sb.append(";");
                }
                try {
                    ApkVerifier verifier = g.a().b.getVerifier();
                    if (verifier != null) {
                        if (!verifier.verify(file)) {
                            throw new RuntimeException("安装包签名校验失败[0]");
                        }
                    } else if (!com.bytedance.pangle.f.e.a(file.getAbsolutePath())) {
                        throw new RuntimeException("安装包签名校验失败[1]");
                    }
                    long a4 = a2.a("checkSignature");
                    if (a4 > 30 || a4 < 0) {
                        sb.append("checkSignature cost:");
                        sb.append(a4);
                        sb.append(";");
                    }
                    ZeusParam zeusParam = g.a().b;
                    if (zeusParam != null) {
                        try {
                            if (zeusParam.checkMatchHostAbi()) {
                                try {
                                    if (!com.bytedance.pangle.helper.b.a(file)) {
                                        throw new a("插件包包含so不符合宿主ABI类型", (byte) 0);
                                    }
                                } catch (Exception e) {
                                    a(com.bytedance.pangle.b.b.f, b.a.u, str, i, -1L, null, e);
                                    throw new a("插件包包含so不符合宿主ABI类型", e, (byte) 0);
                                }
                            }
                        } catch (a e2) {
                            e = e2;
                            str2 = str;
                            ZeusLogger.e(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str2 + " install failed.", e);
                            return false;
                        }
                    }
                    long a5 = a2.a("checkMathHostAbi");
                    if (a5 > 30 || a5 < 0) {
                        sb.append("checkMathHostAbi cost:");
                        sb.append(a5);
                        sb.append(";");
                    }
                    b(file, str, i);
                    long a6 = a2.a("checkPermissions");
                    if (a6 > 30 || a6 < 0) {
                        sb.append("checkPermissions cost:");
                        sb.append(a6);
                        sb.append(";");
                    }
                    String sourceFile = PluginDirHelper.getSourceFile(str, i);
                    try {
                        String absolutePath = file.getAbsolutePath();
                        if (!TextUtils.isEmpty(absolutePath) && !TextUtils.isEmpty(sourceFile)) {
                            File file2 = new File(absolutePath);
                            File file3 = new File(sourceFile);
                            if (file2.exists() && file2.isFile() && file2.canRead()) {
                                if (file3.getParentFile() != null && !file3.getParentFile().exists()) {
                                    file3.getParentFile().mkdirs();
                                }
                                try {
                                    f.a(new FileInputStream(absolutePath), new FileOutputStream(sourceFile), file2.length());
                                } catch (IOException e3) {
                                    if (file3.exists()) {
                                        file3.delete();
                                    }
                                    throw e3;
                                }
                            }
                        }
                        long a7 = a2.a("copyApk");
                        if (a7 > 30 || a7 < 0) {
                            sb.append("copyApk cost:");
                            sb.append(a7);
                            sb.append(";");
                        }
                        try {
                            com.bytedance.pangle.helper.b.a(new File(PluginDirHelper.getSourceFile(str, i)), new File(PluginDirHelper.getNativeLibraryDir(str, i)), str);
                            long a8 = a2.a("copySo");
                            if (a8 > 30 || a8 < 0) {
                                sb.append("copySo cost:");
                                sb.append(a8);
                                sb.append(";");
                            }
                            try {
                                String dalvikCacheDir = PluginDirHelper.getDalvikCacheDir(str, i);
                                String nativeLibraryDir = PluginDirHelper.getNativeLibraryDir(str, i);
                                String absolutePath2 = file.getAbsolutePath();
                                if (Build.VERSION.SDK_INT < 26) {
                                    try {
                                        if (com.bytedance.pangle.helper.c.b(Zeus.getAppApplication())) {
                                            DexFile.loadDex(absolutePath2, null, 0).close();
                                        }
                                    } catch (Exception e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                String sourceFile2 = PluginDirHelper.getSourceFile(str, i);
                                if (g.a().b.fastDex2Oat()) {
                                    int i2 = Build.VERSION.SDK_INT;
                                    if (i2 >= 21 && i2 < 26) {
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append(dalvikCacheDir);
                                        sb2.append(File.separator);
                                        String substring = sourceFile2.substring(sourceFile2.lastIndexOf("/") + 1);
                                        String substring2 = substring.substring(substring.lastIndexOf("."));
                                        String str3 = Build.VERSION.SDK_INT >= 26 ? ".odex" : ".dex";
                                        if (!".dex".equals(substring2)) {
                                            if (!".zip".equals(substring2) && !Constant.FILE.SUFFIX.BUNDLE_SUFFIX.equals(substring2)) {
                                                substring = substring + str3;
                                            }
                                            substring = substring.replace(substring2, str3);
                                        }
                                        sb2.append(substring);
                                        String sb3 = sb2.toString();
                                        File file4 = new File(sb3);
                                        if (!file4.exists() || !com.bytedance.pangle.d.c.a(file4)) {
                                            int i3 = b.a.b;
                                            ArrayList arrayList = new ArrayList();
                                            arrayList.add("dex2oat");
                                            if (Build.VERSION.SDK_INT >= 24) {
                                                arrayList.add("--runtime-arg");
                                                arrayList.add("-classpath");
                                                arrayList.add("--runtime-arg");
                                                arrayList.add("&");
                                            }
                                            arrayList.add("--instruction-set=" + com.bytedance.pangle.d.b.a());
                                            if (i3 == b.a.a) {
                                                arrayList.add("--compiler-filter=verify-none");
                                            } else if (i3 == b.a.b) {
                                                arrayList.add("--compiler-filter=interpret-only");
                                            } else {
                                                int i4 = b.a.c;
                                            }
                                            arrayList.add("--dex-file=".concat(String.valueOf(sourceFile2)));
                                            arrayList.add("--oat-file=".concat(String.valueOf(sb3)));
                                            com.bytedance.pangle.d.a.a((String[]) arrayList.toArray(new String[arrayList.size()]));
                                        }
                                    }
                                }
                                PluginClassLoader pluginClassLoader = new PluginClassLoader(sourceFile2, dalvikCacheDir, nativeLibraryDir, null);
                                if (!TextUtils.isEmpty("")) {
                                    pluginClassLoader.loadClass("");
                                }
                                long a9 = a2.a("dexOpt");
                                if (a9 > 30 || a9 < 0) {
                                    sb.append("dexOpt cost:");
                                    sb.append(a9);
                                    sb.append(";");
                                }
                                e.a(file);
                                long a10 = a2.a("cleanPluginApk");
                                if (a10 > 30 || a10 < 0) {
                                    sb.append("cleanPluginApk cost:");
                                    sb.append(a10);
                                    sb.append(";");
                                }
                                a(com.bytedance.pangle.b.b.f, b.a.m, str, i, a2.a(), sb.toString(), null);
                                a2.b("success");
                                return true;
                            } catch (Exception e5) {
                                a(com.bytedance.pangle.b.b.f, b.a.t, str, i, -1L, null, e5);
                                throw new a("dexOpt失败", e5, (byte) 0);
                            }
                        } catch (Exception e6) {
                            a(com.bytedance.pangle.b.b.f, b.a.r, str, i, -1L, null, e6);
                            throw new a("安装包动态库拷贝失败", e6, (byte) 0);
                        }
                    } catch (Exception e7) {
                        a(com.bytedance.pangle.b.b.f, b.a.q, str, i, -1L, null, e7);
                        throw new a("安装包拷贝失败", e7, (byte) 0);
                    }
                } catch (Exception e8) {
                    a(com.bytedance.pangle.b.b.f, b.a.o, str, i, -1L, null, e8);
                    throw new a(e8.getMessage(), e8, (byte) 0);
                }
            } catch (a e9) {
                e = e9;
                str2 = str;
            }
        } catch (Exception e10) {
            ZeusLogger.e(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed unknown error.", e10);
            a(com.bytedance.pangle.b.b.f, b.a.n, str, i, -1L, sb.toString(), e10);
            return false;
        }
    }

    public static void b(File file, String str, int i) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65539, null, file, str, i) == null) {
            ZeusParam zeusParam = g.a().b;
            try {
                PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 4096);
                PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 4096);
                List asList = Arrays.asList(packageInfo.requestedPermissions);
                if (packageArchiveInfo.requestedPermissions == null || packageArchiveInfo.requestedPermissions.length <= 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (String str2 : packageArchiveInfo.requestedPermissions) {
                    if (!asList.contains(str2)) {
                        arrayList.add(str2);
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                ZeusLogger.e("PluginInstaller", "The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)));
                if (zeusParam != null && zeusParam.checkPermission()) {
                    throw new a("The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)), (byte) 0);
                }
            } catch (Exception e) {
                a(com.bytedance.pangle.b.b.f, b.a.p, str, i, -1L, null, e);
                throw new a("安装包权限校验失败", e, (byte) 0);
            }
        }
    }

    public static void a(String str, int i, @NonNull String str2, int i2, long j, String str3, @Nullable Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2), Long.valueOf(j), str3, th}) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject.putOpt("status_code", com.bytedance.pangle.log.d.a(Integer.valueOf(i)));
                jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.d.a(str2));
                jSONObject.putOpt("version_code", com.bytedance.pangle.log.d.a(Integer.valueOf(i2)));
                jSONObject3.putOpt("duration", com.bytedance.pangle.log.d.a(Long.valueOf(j)));
                jSONObject2.putOpt("throwable", com.bytedance.pangle.log.d.a(th));
                jSONObject2.putOpt("timestamp", com.bytedance.pangle.log.d.a(Long.valueOf(System.currentTimeMillis())));
                jSONObject2.putOpt("message", com.bytedance.pangle.log.d.a(str3));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            com.bytedance.pangle.b.b.a().a(str, jSONObject, jSONObject3, jSONObject2);
        }
    }
}
