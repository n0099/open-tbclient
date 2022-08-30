package com.baidu.webkit.internal;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.IDevices;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import com.kuaishou.weapon.p0.k1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes6.dex */
public class CpuInfo implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CPU_TYPE_ARM_AR = 2;
    public static final int CPU_TYPE_MIPS = 4;
    public static final int CPU_TYPE_NEON = 1;
    public static final int CPU_TYPE_UNKNOWN = -1;
    public static final int CPU_TYPE_X86 = 3;
    public static boolean sCheckedCpuInfo = false;
    public static int sCpuType = -1;
    public static boolean sSupportNeon;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1675865848, "Lcom/baidu/webkit/internal/CpuInfo;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1675865848, "Lcom/baidu/webkit/internal/CpuInfo;");
        }
    }

    public CpuInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean checkCpuInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? checkSysInfo(k1.a, str) : invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0046 -> B:47:0x0068). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int checkCpuType(String str) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        Throwable th;
        IOException e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            File file = new File(str);
            int i = 2;
            if (file.exists()) {
                try {
                    try {
                        bufferedReader = new BufferedReader(new FileReader(file));
                        while (true) {
                            try {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine != null) {
                                        if (!readLine.contains("neon")) {
                                            if (!readLine.contains("Atom")) {
                                                if (readLine.contains(IDevices.ABI_MIPS)) {
                                                    i = 4;
                                                    break;
                                                }
                                            } else {
                                                i = 3;
                                                break;
                                            }
                                        } else {
                                            i = 1;
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                } catch (IOException e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    return i;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        }
                        bufferedReader.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                } catch (IOException e5) {
                    bufferedReader = null;
                    e = e5;
                } catch (Throwable th3) {
                    bufferedReader = null;
                    th = th3;
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x0044 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0047 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002e -> B:42:0x0050). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean checkSysInfo(String str, String str2) {
        ?? r2;
        Throwable th;
        BufferedReader bufferedReader;
        IOException e;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r2 = 65540;
            InterceptResult invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2);
            if (invokeLL != null) {
                return invokeLL.booleanValue;
            }
        }
        File file = new File(str);
        boolean z = false;
        if (file.exists()) {
            try {
                try {
                    try {
                        bufferedReader = new BufferedReader(new FileReader(file));
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine != null) {
                                    if (readLine.contains(str2)) {
                                        z = true;
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            } catch (IOException e2) {
                                e = e2;
                                e.printStackTrace();
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                return z;
                            }
                        }
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th = th2;
                        if (r2 != 0) {
                            try {
                                r2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e4) {
                    bufferedReader = null;
                    e = e4;
                } catch (Throwable th3) {
                    r2 = 0;
                    th = th3;
                    if (r2 != 0) {
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e5.printStackTrace();
            }
        }
        return z;
    }

    public static String getCpuInfoString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            int cpuType = getCpuType();
            return cpuType != 1 ? cpuType != 2 ? cpuType != 3 ? cpuType != 4 ? "" : IDevices.ABI_MIPS : "x86" : "ar" : "neon";
        }
        return (String) invokeV.objValue;
    }

    public static int getCpuType() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (sCheckedCpuInfo) {
                return sCpuType;
            }
            String str = Build.CPU_ABI;
            if (str != null) {
                String lowerCase = str.toLowerCase();
                if (!lowerCase.startsWith("arm")) {
                    if (lowerCase.startsWith("x86") || lowerCase.startsWith("i686")) {
                        i = 3;
                    } else if (lowerCase.startsWith(IDevices.ABI_MIPS)) {
                        i = 4;
                    }
                    sCpuType = i;
                } else if (supportNeon()) {
                    sCpuType = 1;
                } else {
                    i = 2;
                    sCpuType = i;
                }
            }
            sCheckedCpuInfo = true;
            return sCpuType;
        }
        return invokeV.intValue;
    }

    public static int getCpuType_deprecated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (!sCheckedCpuInfo) {
                sCheckedCpuInfo = true;
                sCpuType = checkCpuType(k1.a);
            }
            return sCpuType;
        }
        return invokeV.intValue;
    }

    public static boolean isCPU64() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            String property = System.getProperty("os.arch");
            if (TextUtils.isEmpty(property) || !property.endsWith(WebKitFactory.OS_64)) {
                try {
                    Class<?> cls = Class.forName("android.os.SystemProperties");
                    String str = (String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.product.cpu.abilist64", "");
                    if (str != null) {
                        if (!str.isEmpty()) {
                            return true;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean supportNeon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            boolean checkCpuInfo = checkCpuInfo("neon");
            sSupportNeon = checkCpuInfo;
            return checkCpuInfo;
        }
        return invokeV.booleanValue;
    }
}
