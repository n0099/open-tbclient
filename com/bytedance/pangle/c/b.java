package com.bytedance.pangle.c;

import android.os.Build;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.h;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static String b;
    public static Map<String, Integer> c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-294229965, "Lcom/bytedance/pangle/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-294229965, "Lcom/bytedance/pangle/c/b;");
                return;
            }
        }
        c = new HashMap();
        if (h.a()) {
            b = Build.SUPPORTED_ABIS[0];
        } else {
            b = Build.CPU_ABI;
        }
        c.put("arm64-v8a", 64);
        c.put(PassBiometricUtil.CPU_TYPE_ARMEABI_V7A, 32);
        c.put("armeabi", 32);
        c.put("x86_64", 64);
        c.put("x86", 32);
        c.put("mips64", 64);
        c.put("mips", 32);
        a = c();
    }

    public static void a(File file, File file2, String str) {
        ZipFile zipFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, file, file2, str) == null) {
            ZipFile zipFile2 = null;
            LinkedList<ZipEntry> linkedList = null;
            try {
                zipFile = new ZipFile(file);
            } catch (Throwable th) {
                th = th;
            }
            try {
                Map<String, List<ZipEntry>> a2 = a(zipFile);
                boolean containsKey = a2.containsKey(a);
                ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper copyNativeLib pre-verify-matchHostAbi[" + containsKey + "], pkg=" + str);
                if (containsKey) {
                    if (!a2.isEmpty()) {
                        linkedList = new LinkedList();
                        HashSet hashSet = new HashSet();
                        String str2 = a != null ? a : b;
                        char c2 = 65535;
                        switch (str2.hashCode()) {
                            case -1073971299:
                                if (str2.equals("mips64")) {
                                    c2 = 5;
                                    break;
                                }
                                break;
                            case -806050265:
                                if (str2.equals("x86_64")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case -738963905:
                                if (str2.equals("armeabi")) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                            case 117110:
                                if (str2.equals("x86")) {
                                    c2 = 4;
                                    break;
                                }
                                break;
                            case 3351711:
                                if (str2.equals("mips")) {
                                    c2 = 6;
                                    break;
                                }
                                break;
                            case 145444210:
                                if (str2.equals(PassBiometricUtil.CPU_TYPE_ARMEABI_V7A)) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case 1431565292:
                                if (str2.equals("arm64-v8a")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                        }
                        switch (c2) {
                            case 0:
                                a(a2, "arm64-v8a", linkedList, hashSet);
                                break;
                            case 1:
                                a(a2, PassBiometricUtil.CPU_TYPE_ARMEABI_V7A, linkedList, hashSet);
                                a(a2, "armeabi", linkedList, hashSet);
                                break;
                            case 2:
                                a(a2, "armeabi", linkedList, hashSet);
                                break;
                            case 3:
                                a(a2, "x86_64", linkedList, hashSet);
                                if (linkedList.size() == 0) {
                                    a(a2, "arm64-v8a", linkedList, hashSet);
                                    break;
                                }
                                break;
                            case 4:
                                a(a2, "x86", linkedList, hashSet);
                                if (linkedList.size() == 0) {
                                    a(a2, PassBiometricUtil.CPU_TYPE_ARMEABI_V7A, linkedList, hashSet);
                                    a(a2, "armeabi", linkedList, hashSet);
                                    break;
                                }
                                break;
                            case 5:
                                a(a2, "mips64", linkedList, hashSet);
                                break;
                            case 6:
                                a(a2, "mips", linkedList, hashSet);
                                break;
                        }
                    }
                    if (linkedList != null && !linkedList.isEmpty()) {
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        for (ZipEntry zipEntry : linkedList) {
                            a(zipFile, zipEntry, file2);
                        }
                    }
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "NativeLibHelper copyNativeLib, supportedSoEntries empty, pkg=".concat(String.valueOf(str)));
                    zipFile.close();
                    return;
                }
                zipFile.close();
            } catch (Throwable th2) {
                th = th2;
                zipFile2 = zipFile;
                if (zipFile2 != null) {
                    zipFile2.close();
                }
                throw th;
            }
        }
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? c.get(a()).intValue() : invokeV.intValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            JSONObject d = d();
            String a2 = a(d);
            return a2 == null ? b(d) : a2;
        }
        return (String) invokeV.objValue;
    }

    public static JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("primaryCpuAbi", "0");
                jSONObject.put("processMode", "0");
                jSONObject.put("supportedABI0", "0");
                jSONObject.put("matchCpuAbi", "0");
                jSONObject.put("defaultABI0", "0");
                jSONObject.put("defaultABI", "0");
                jSONObject.put("autoError", "0");
                jSONObject.put("manualError", "0");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static String b(JSONObject jSONObject) {
        InterceptResult invokeL;
        HashSet hashSet;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, jSONObject)) == null) {
            try {
                ZipFile zipFile = new ZipFile(new File(Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 0).applicationInfo.sourceDir));
                hashSet = new HashSet(a(zipFile).keySet());
                try {
                    zipFile.close();
                } catch (IOException unused) {
                    ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, close sourceApkZipFile error!");
                }
                strArr = h.a() ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2};
            } catch (Throwable th) {
                ZeusLogger.e(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual failed!", th);
                a(jSONObject, "manualError", "1");
            }
            if (hashSet.isEmpty()) {
                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, host source apk .so is empty, use supportedABIs[0]=" + strArr[0]);
                a(jSONObject, "supportedABI0", strArr[0]);
                return strArr[0];
            }
            for (String str : strArr) {
                if (hashSet.contains(str)) {
                    ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, match cpuAbi=".concat(String.valueOf(str)));
                    a(jSONObject, "matchCpuAbi", str);
                    return str;
                }
            }
            if (h.a()) {
                a(jSONObject, "defaultABI0", Build.SUPPORTED_ABIS[0]);
                return Build.SUPPORTED_ABIS[0];
            }
            a(jSONObject, "defaultABI", Build.CPU_ABI);
            return Build.CPU_ABI;
        }
        return (String) invokeL.objValue;
    }

    public static boolean b(File file) {
        InterceptResult invokeL;
        ZipFile zipFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, file)) == null) {
            ZipFile zipFile2 = null;
            try {
                try {
                    zipFile = new ZipFile(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e) {
                e = e;
            }
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                Pattern compile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    if (!nextElement.isDirectory() && compile.matcher(nextElement.getName()).matches()) {
                        try {
                            zipFile.close();
                            return true;
                        } catch (IOException unused) {
                            ZeusLogger.e(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                            return true;
                        }
                    }
                }
                try {
                    zipFile.close();
                } catch (IOException unused2) {
                    ZeusLogger.e(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                }
                return false;
            } catch (IOException e2) {
                e = e2;
                zipFile2 = zipFile;
                ZeusLogger.e(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, get sourceApk ZipFile failed!", e);
                if (zipFile2 != null) {
                    try {
                        zipFile2.close();
                    } catch (IOException unused3) {
                        ZeusLogger.e(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                zipFile2 = zipFile;
                if (zipFile2 != null) {
                    try {
                        zipFile2.close();
                    } catch (IOException unused4) {
                        ZeusLogger.e(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                    }
                }
                throw th;
            }
        }
        return invokeL.booleanValue;
    }

    public static Map<String, List<ZipEntry>> a(ZipFile zipFile) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, zipFile)) == null) {
            HashMap hashMap = new HashMap();
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            Pattern compile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                if (!nextElement.isDirectory() && !nextElement.getName().contains("../") && compile.matcher(nextElement.getName()).matches() && (split = nextElement.getName().split(File.separator)) != null && split.length >= 2) {
                    String str = split[split.length - 2];
                    if (c.containsKey(str)) {
                        if (hashMap.get(str) == null) {
                            hashMap.put(str, new LinkedList());
                        }
                        ((List) hashMap.get(str)).add(nextElement);
                    }
                }
            }
            ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper getAllSoZipEntries, zipFile=" + zipFile.getName() + ", soEntries=" + hashMap.toString());
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static void a(Map<String, List<ZipEntry>> map, String str, List<ZipEntry> list, Set<String> set) {
        List<ZipEntry> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65541, null, map, str, list, set) == null) || (list2 = map.get(str)) == null || list2.size() == 0) {
            return;
        }
        for (ZipEntry zipEntry : list2) {
            String substring = zipEntry.getName().substring(zipEntry.getName().lastIndexOf(File.separator) + 1);
            if (!set.contains(substring)) {
                list.add(zipEntry);
                set.add(substring);
            }
        }
    }

    public static void a(ZipFile zipFile, ZipEntry zipEntry, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, zipFile, zipEntry, file) == null) {
            File file2 = new File(file, zipEntry.getName().substring(zipEntry.getName().lastIndexOf(File.separator) + 1));
            int i = 0;
            boolean z = false;
            do {
                if (file2.exists()) {
                    file2.delete();
                }
                try {
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "NativeLibHelper copySoZipEntry, soZipEntry=" + zipEntry + ", targetSoFile=" + file2);
                    g.a(zipFile.getInputStream(zipEntry), new FileOutputStream(file2));
                    z = true;
                    continue;
                } catch (IOException e) {
                    if (i >= 3) {
                        throw e;
                    }
                    i++;
                    continue;
                }
            } while (!z);
        }
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            String str = a;
            if (str != null) {
                return str;
            }
            String c2 = c();
            a = c2;
            return c2;
        }
        return (String) invokeV.objValue;
    }

    public static String a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (h.a()) {
                try {
                    String str = (String) FieldUtils.readField(Zeus.getAppApplication().getApplicationInfo(), "primaryCpuAbi");
                    ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, primaryCpuAbi=".concat(String.valueOf(str)));
                    a(jSONObject, "primaryCpuAbi", str);
                    if (str != null) {
                        int i = 0;
                        if (Build.VERSION.SDK_INT >= 23) {
                            try {
                                i = Process.is64Bit() ? 64 : 32;
                                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode=".concat(String.valueOf(i)));
                            } catch (Exception unused) {
                                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode exception default=".concat(String.valueOf(i)));
                            }
                        } else {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode default=0");
                        }
                        a(jSONObject, "processMode", String.valueOf(i));
                        if (i != 0) {
                            if (c.get(str).intValue() == i) {
                                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto2, sHostAbi=".concat(String.valueOf(str)));
                                return str;
                            }
                            return null;
                        }
                        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto1, sHostAbi=".concat(String.valueOf(str)));
                        return str;
                    }
                    return null;
                } catch (Exception e) {
                    ZeusLogger.e(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto failed!", e);
                    a(jSONObject, "autoError", "1");
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static boolean a(File file) {
        InterceptResult invokeL;
        ZipFile zipFile;
        boolean containsKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, file)) == null) {
            ZipFile zipFile2 = null;
            try {
                try {
                    zipFile = new ZipFile(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e) {
                e = e;
            }
            try {
                Map<String, List<ZipEntry>> a2 = a(zipFile);
                if (a2.isEmpty()) {
                    containsKey = true;
                    ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [true] soEntries empty, ".concat(String.valueOf(file)));
                } else {
                    containsKey = a2.containsKey(a);
                    if (containsKey) {
                        ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [" + containsKey + "], " + file);
                    } else {
                        ZeusLogger.e(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [" + containsKey + "], " + file);
                    }
                }
                try {
                    zipFile.close();
                } catch (IOException unused) {
                    ZeusLogger.e(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                }
                return containsKey;
            } catch (IOException e2) {
                e = e2;
                zipFile2 = zipFile;
                ZeusLogger.e(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, get sourceApk ZipFile failed!", e);
                if (zipFile2 != null) {
                    try {
                        zipFile2.close();
                        return false;
                    } catch (IOException unused2) {
                        ZeusLogger.e(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                        return false;
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                zipFile2 = zipFile;
                if (zipFile2 != null) {
                    try {
                        zipFile2.close();
                    } catch (IOException unused3) {
                        ZeusLogger.e(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                    }
                }
                throw th;
            }
        }
        return invokeL.booleanValue;
    }

    public static void a(JSONObject jSONObject, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, jSONObject, str, str2) == null) {
            try {
                jSONObject.put(str, str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
