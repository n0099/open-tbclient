package com.bytedance.pangle.plugin;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nps.utils.Constant;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.b.b;
import com.bytedance.pangle.d.b;
import com.bytedance.pangle.f.e;
import com.bytedance.pangle.g;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.f;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import dalvik.system.DexFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class b {
    public static final g a = g.a();

    /* loaded from: classes9.dex */
    public static class a extends IOException {
        public a(String str) {
            super(str);
        }

        public /* synthetic */ a(String str, byte b) {
            this(str);
        }

        public a(String str, Throwable th) {
            super(str, th);
        }

        public /* synthetic */ a(String str, Throwable th, byte b) {
            this(str, th);
        }
    }

    public static void a(String str, int i, @NonNull String str2, int i2, long j, String str3, @Nullable Throwable th) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", com.bytedance.pangle.log.c.a(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.c.a(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.c.a(Integer.valueOf(i2)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.bytedance.pangle.log.c.b(Long.valueOf(j))));
            jSONObject2.putOpt("throwable", com.bytedance.pangle.log.c.a(th));
            jSONObject2.putOpt("timestamp", com.bytedance.pangle.log.c.a(Long.valueOf(System.currentTimeMillis())));
            jSONObject2.putOpt("message", com.bytedance.pangle.log.c.a(str3));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.bytedance.pangle.b.b.a().a(str, jSONObject, jSONObject3, jSONObject2);
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x02ae A[Catch: Exception -> 0x0315, TRY_LEAVE, TryCatch #6 {Exception -> 0x0315, blocks: (B:63:0x016c, B:72:0x0196, B:114:0x02a2, B:116:0x02ae, B:71:0x0193, B:74:0x019c, B:76:0x01a6, B:82:0x01b3, B:87:0x01e2, B:89:0x01e8, B:91:0x01f0, B:94:0x01f9, B:95:0x0209, B:96:0x020d, B:98:0x021f, B:100:0x0225, B:102:0x0237, B:103:0x0247, B:105:0x0260, B:110:0x0272, B:106:0x0266, B:108:0x026a, B:109:0x0270, B:66:0x017f, B:68:0x0189), top: B:156:0x016c, inners: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x017f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a6 A[Catch: all -> 0x029c, TryCatch #6 {Exception -> 0x0315, blocks: (B:63:0x016c, B:72:0x0196, B:114:0x02a2, B:116:0x02ae, B:71:0x0193, B:74:0x019c, B:76:0x01a6, B:82:0x01b3, B:87:0x01e2, B:89:0x01e8, B:91:0x01f0, B:94:0x01f9, B:95:0x0209, B:96:0x020d, B:98:0x021f, B:100:0x0225, B:102:0x0237, B:103:0x0247, B:105:0x0260, B:110:0x0272, B:106:0x0266, B:108:0x026a, B:109:0x0270, B:66:0x017f, B:68:0x0189), top: B:156:0x016c, inners: #8 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(File file, String str, int i) {
        String str2;
        long a2;
        long a3;
        long a4;
        long a5;
        boolean z;
        String str3;
        String str4 = str;
        StringBuilder sb = new StringBuilder();
        try {
            try {
            } catch (a e) {
                e = e;
            }
            try {
                a.a(1000, 0, str, i, null);
                com.bytedance.pangle.log.b a6 = com.bytedance.pangle.log.b.a(ZeusLogger.TAG_INSTALL, "PluginInstaller", "install:".concat(String.valueOf(str)));
                a(com.bytedance.pangle.b.b.e, b.a.l, str, i, -1L, null, null);
                f.a(com.bytedance.pangle.c.c.a(str, i));
                long a7 = a6.a("cleanDir");
                if (a7 > 30 || a7 < 0) {
                    sb.append("cleanDir cost:");
                    sb.append(a7);
                    sb.append(ParamableElem.DIVIDE_PARAM);
                }
                try {
                    if (e.a(file.getAbsolutePath(), str4)) {
                        long a8 = a6.a("checkSignature");
                        if (a8 > 30 || a8 < 0) {
                            sb.append("checkSignature cost:");
                            sb.append(a8);
                            sb.append(ParamableElem.DIVIDE_PARAM);
                        }
                        if (GlobalParam.getInstance().checkMatchHostAbi()) {
                            try {
                                if (!com.bytedance.pangle.c.b.a(file)) {
                                    throw new a("插件包包含so不符合宿主ABI类型", (byte) 0);
                                }
                            } catch (Exception e2) {
                                a(com.bytedance.pangle.b.b.f, b.a.u, str, i, -1L, null, e2);
                                a.a(1100, -5, str, i, e2);
                                throw new a("插件包包含so不符合宿主ABI类型", e2, (byte) 0);
                            }
                        }
                        long a9 = a6.a("checkMathHostAbi");
                        if (a9 > 30 || a9 < 0) {
                            sb.append("checkMathHostAbi cost:");
                            sb.append(a9);
                            sb.append(ParamableElem.DIVIDE_PARAM);
                        }
                        b(file, str, i);
                        long a10 = a6.a("checkPermissions");
                        if (a10 > 30 || a10 < 0) {
                            sb.append("checkPermissions cost:");
                            sb.append(a10);
                            sb.append(ParamableElem.DIVIDE_PARAM);
                        }
                        String c = c(file, str, i);
                        long a11 = a6.a("copyApk");
                        try {
                            try {
                                if (a11 <= 30) {
                                    if (a11 < 0) {
                                    }
                                    if (!a(c, str4, i)) {
                                        str2 = "modifyRes";
                                    } else {
                                        str2 = "noModifyRes";
                                    }
                                    a2 = a6.a(str2);
                                    if (a2 <= 30 || a2 < 0) {
                                        sb.append("modifyRes cost:");
                                        sb.append(a2);
                                        sb.append(ParamableElem.DIVIDE_PARAM);
                                    }
                                    com.bytedance.pangle.c.b.a(new File(com.bytedance.pangle.c.c.b(str, i)), new File(com.bytedance.pangle.c.c.d(str, i)), str4);
                                    a3 = a6.a("copySo");
                                    if (a3 <= 30 || a3 < 0) {
                                        sb.append("copySo cost:");
                                        sb.append(a3);
                                        sb.append(ParamableElem.DIVIDE_PARAM);
                                    }
                                    String c2 = com.bytedance.pangle.c.c.c(str, i);
                                    String d = com.bytedance.pangle.c.c.d(str, i);
                                    String absolutePath = file.getAbsolutePath();
                                    if (Build.VERSION.SDK_INT < 26) {
                                        try {
                                            if (com.bytedance.pangle.c.d.a(Zeus.getAppApplication())) {
                                                DexFile.loadDex(absolutePath, null, 0).close();
                                            }
                                        } catch (Exception e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                    String b = com.bytedance.pangle.c.c.b(str, i);
                                    if (GlobalParam.getInstance().isFastDex2oat()) {
                                        int i2 = Build.VERSION.SDK_INT;
                                        if (i2 >= 21 && i2 < 26) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (z) {
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append(c2);
                                            sb2.append(File.separator);
                                            String substring = b.substring(b.lastIndexOf("/") + 1);
                                            String substring2 = substring.substring(substring.lastIndexOf("."));
                                            if (Build.VERSION.SDK_INT < 26) {
                                                str3 = ".dex";
                                            } else {
                                                str3 = ".odex";
                                            }
                                            if (!".dex".equals(substring2)) {
                                                if (!".zip".equals(substring2) && !Constant.FILE.SUFFIX.BUNDLE_SUFFIX.equals(substring2)) {
                                                    substring = substring + str3;
                                                }
                                                substring = substring.replace(substring2, str3);
                                            }
                                            sb2.append(substring);
                                            String sb3 = sb2.toString();
                                            File file2 = new File(sb3);
                                            if (!file2.exists() || !com.bytedance.pangle.d.c.a(file2)) {
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
                                                arrayList.add("--dex-file=".concat(String.valueOf(b)));
                                                arrayList.add("--oat-file=".concat(String.valueOf(sb3)));
                                                com.bytedance.pangle.d.a.a((String[]) arrayList.toArray(new String[arrayList.size()]));
                                            }
                                        }
                                    }
                                    PluginClassLoader pluginClassLoader = new PluginClassLoader(b, c2, d, null);
                                    if (!TextUtils.isEmpty("")) {
                                        pluginClassLoader.loadClass("");
                                    }
                                    a4 = a6.a("dexOpt");
                                    if (a4 <= 30 || a4 < 0) {
                                        sb.append("dexOpt cost:");
                                        sb.append(a4);
                                        sb.append(ParamableElem.DIVIDE_PARAM);
                                    }
                                    f.a(file);
                                    a5 = a6.a("cleanPluginApk");
                                    if (a5 <= 30 || a5 < 0) {
                                        sb.append("cleanPluginApk cost:");
                                        sb.append(a5);
                                        sb.append(ParamableElem.DIVIDE_PARAM);
                                    }
                                    a(com.bytedance.pangle.b.b.f, b.a.m, str, i, a6.a(), sb.toString(), null);
                                    a6.b("success");
                                    a.a(1100, 0, str, i, null);
                                    return true;
                                }
                                String c22 = com.bytedance.pangle.c.c.c(str, i);
                                String d2 = com.bytedance.pangle.c.c.d(str, i);
                                String absolutePath2 = file.getAbsolutePath();
                                if (Build.VERSION.SDK_INT < 26) {
                                }
                                String b2 = com.bytedance.pangle.c.c.b(str, i);
                                if (GlobalParam.getInstance().isFastDex2oat()) {
                                }
                                PluginClassLoader pluginClassLoader2 = new PluginClassLoader(b2, c22, d2, null);
                                if (!TextUtils.isEmpty("")) {
                                }
                                a4 = a6.a("dexOpt");
                                if (a4 <= 30) {
                                }
                                sb.append("dexOpt cost:");
                                sb.append(a4);
                                sb.append(ParamableElem.DIVIDE_PARAM);
                                f.a(file);
                                a5 = a6.a("cleanPluginApk");
                                if (a5 <= 30) {
                                }
                                sb.append("cleanPluginApk cost:");
                                sb.append(a5);
                                sb.append(ParamableElem.DIVIDE_PARAM);
                                a(com.bytedance.pangle.b.b.f, b.a.m, str, i, a6.a(), sb.toString(), null);
                                a6.b("success");
                                a.a(1100, 0, str, i, null);
                                return true;
                            } catch (Exception e4) {
                                a(com.bytedance.pangle.b.b.f, b.a.t, str, i, -1L, null, e4);
                                a.a(1100, -8, str, i, e4);
                                throw new a("dexOpt失败", e4, (byte) 0);
                            }
                            com.bytedance.pangle.c.b.a(new File(com.bytedance.pangle.c.c.b(str, i)), new File(com.bytedance.pangle.c.c.d(str, i)), str4);
                            a3 = a6.a("copySo");
                            if (a3 <= 30) {
                            }
                            sb.append("copySo cost:");
                            sb.append(a3);
                            sb.append(ParamableElem.DIVIDE_PARAM);
                        } catch (Exception e5) {
                            a(com.bytedance.pangle.b.b.f, b.a.r, str, i, -1L, null, e5);
                            a.a(1100, -7, str, i, e5);
                            throw new a("安装包动态库拷贝失败", e5, (byte) 0);
                        }
                        sb.append("copyApk cost:");
                        sb.append(a11);
                        sb.append(ParamableElem.DIVIDE_PARAM);
                        if (!a(c, str4, i)) {
                        }
                        a2 = a6.a(str2);
                        if (a2 <= 30) {
                        }
                        sb.append("modifyRes cost:");
                        sb.append(a2);
                        sb.append(ParamableElem.DIVIDE_PARAM);
                    } else {
                        throw new RuntimeException("安装包签名校验失败[1]");
                    }
                } catch (Exception e6) {
                    a(com.bytedance.pangle.b.b.f, b.a.o, str, i, -1L, null, e6);
                    a.a(1100, -3, str, i, e6);
                    throw new a(e6.getMessage(), e6, (byte) 0);
                }
            } catch (a e7) {
                e = e7;
                str4 = str;
                ZeusLogger.e(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str4 + " install failed.", e);
                return false;
            }
        } catch (Exception e8) {
            ZeusLogger.e(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed unknown error.", e8);
            a(com.bytedance.pangle.b.b.f, b.a.n, str, i, -1L, sb.toString(), e8);
            a.a(1100, -1, str, i, e8);
            return false;
        }
    }

    public static boolean a(String str, String str2, int i) {
        try {
            return new com.bytedance.pangle.res.a.c().a(new File(str));
        } catch (Throwable th) {
            a(com.bytedance.pangle.b.b.f, b.a.v, str2, i, -1L, null, th);
            a.a(1100, -2, str2, i, th);
            throw new a(th.getMessage(), th, (byte) 0);
        }
    }

    public static void b(File file, String str, int i) {
        String[] strArr;
        try {
            PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 4096);
            PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 4096);
            List asList = Arrays.asList(packageInfo.requestedPermissions);
            if (packageArchiveInfo.requestedPermissions != null && packageArchiveInfo.requestedPermissions.length > 0) {
                ArrayList arrayList = new ArrayList();
                for (String str2 : packageArchiveInfo.requestedPermissions) {
                    if (!asList.contains(str2)) {
                        arrayList.add(str2);
                    }
                }
                if (!arrayList.isEmpty()) {
                    ZeusLogger.e("PluginInstaller", "The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)));
                    if (GlobalParam.getInstance().checkPermission()) {
                        throw new a("The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)), (byte) 0);
                    }
                }
            }
        } catch (Exception e) {
            a(com.bytedance.pangle.b.b.f, b.a.p, str, i, -1L, null, e);
            a.a(1100, -4, str, i, e);
            throw new a("安装包权限校验失败", e, (byte) 0);
        }
    }

    public static String c(File file, String str, int i) {
        String b = com.bytedance.pangle.c.c.b(str, i);
        try {
            String absolutePath = file.getAbsolutePath();
            if (!TextUtils.isEmpty(absolutePath) && !TextUtils.isEmpty(b)) {
                File file2 = new File(absolutePath);
                File file3 = new File(b);
                if (file2.exists() && file2.isFile() && file2.canRead()) {
                    if (file3.getParentFile() != null && !file3.getParentFile().exists()) {
                        file3.getParentFile().mkdirs();
                    }
                    FileInputStream fileInputStream = new FileInputStream(absolutePath);
                    FileOutputStream fileOutputStream = new FileOutputStream(b);
                    FileChannel channel = fileInputStream.getChannel();
                    FileChannel channel2 = fileOutputStream.getChannel();
                    channel2.write(channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size()));
                    channel.close();
                    channel2.close();
                    fileInputStream.close();
                    fileOutputStream.close();
                }
            }
            return b;
        } catch (Exception e) {
            a(com.bytedance.pangle.b.b.f, b.a.q, str, i, -1L, null, e);
            a.a(1100, -6, str, i, e);
            throw new a("安装包拷贝失败", e, (byte) 0);
        }
    }
}
