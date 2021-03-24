package com.baidu.webkit.internal;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.IDevices;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes5.dex */
public class CpuInfo implements INoProGuard {
    public static final int CPU_TYPE_ARM_AR = 2;
    public static final int CPU_TYPE_MIPS = 4;
    public static final int CPU_TYPE_NEON = 1;
    public static final int CPU_TYPE_UNKNOWN = -1;
    public static final int CPU_TYPE_X86 = 3;
    public static boolean sCheckedCpuInfo = false;
    public static int sCpuType = -1;
    public static boolean sSupportNeon;

    public static boolean checkCpuInfo(String str) {
        return checkSysInfo("/proc/cpuinfo", str);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0042 -> B:41:0x0064). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int checkCpuType(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        IOException e2;
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
                            } catch (IOException e3) {
                                e2 = e3;
                                e2.printStackTrace();
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
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedReader.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            } catch (IOException e6) {
                bufferedReader = null;
                e2 = e6;
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

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002a -> B:33:0x004c). Please submit an issue!!! */
    public static boolean checkSysInfo(String str, String str2) {
        BufferedReader bufferedReader;
        IOException e2;
        File file = new File(str);
        boolean z = false;
        if (file.exists()) {
            BufferedReader bufferedReader2 = null;
            try {
            } catch (Throwable th) {
                th = th;
            }
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
                        } catch (IOException e3) {
                            e2 = e3;
                            e2.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return z;
                        }
                    }
                    bufferedReader.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            } catch (IOException e5) {
                bufferedReader = null;
                e2 = e5;
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return z;
    }

    public static String getCpuInfoString() {
        int cpuType = getCpuType();
        return cpuType != 1 ? cpuType != 2 ? cpuType != 3 ? cpuType != 4 ? "" : IDevices.ABI_MIPS : "x86" : "ar" : "neon";
    }

    public static int getCpuType() {
        int i;
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

    public static int getCpuType_deprecated() {
        if (!sCheckedCpuInfo) {
            sCheckedCpuInfo = true;
            sCpuType = checkCpuType("/proc/cpuinfo");
        }
        return sCpuType;
    }

    public static boolean isCPU64() {
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
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return false;
        }
        return true;
    }

    public static boolean supportNeon() {
        boolean checkCpuInfo = checkCpuInfo("neon");
        sSupportNeon = checkCpuInfo;
        return checkCpuInfo;
    }
}
