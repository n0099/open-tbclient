package com.baidu.webkit.internal;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.IDevices;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes11.dex */
public class CpuInfo implements INoProGuard {
    public static final int CPU_TYPE_ARM_AR = 2;
    public static final int CPU_TYPE_MIPS = 4;
    public static final int CPU_TYPE_NEON = 1;
    public static final int CPU_TYPE_UNKNOWN = -1;
    public static final int CPU_TYPE_X86 = 3;
    private static boolean sCheckedCpuInfo;
    private static int sCpuType = -1;
    private static boolean sSupportNeon;

    public static boolean checkCpuInfo(String str) {
        return checkSysInfo("/proc/cpuinfo", str);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x0063 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int checkCpuType(String str) {
        BufferedReader bufferedReader;
        int i = 2;
        File file = new File(str);
        ?? exists = file.exists();
        if (exists != 0) {
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    while (true) {
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
                            }
                        } catch (IOException e) {
                            e = e;
                            com.a.a.a.a.a.a.a.a(e);
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e2) {
                                    com.a.a.a.a.a.a.a.a(e2);
                                }
                            }
                            return i;
                        }
                    }
                    try {
                        bufferedReader.close();
                        break;
                    } catch (IOException e3) {
                        com.a.a.a.a.a.a.a.a(e3);
                    }
                } catch (Throwable th) {
                    th = th;
                    if (exists != 0) {
                        try {
                            exists.close();
                        } catch (IOException e4) {
                            com.a.a.a.a.a.a.a.a(e4);
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                exists = 0;
                if (exists != 0) {
                }
                throw th;
            }
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean checkSysInfo(String str, String str2) {
        BufferedReader bufferedReader;
        String readLine;
        boolean z = false;
        File file = new File(str);
        ?? exists = file.exists();
        if (exists != 0) {
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    try {
                        do {
                            try {
                                readLine = bufferedReader.readLine();
                                if (readLine != null) {
                                }
                                break;
                            } catch (IOException e) {
                                e = e;
                                com.a.a.a.a.a.a.a.a(e);
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e2) {
                                        com.a.a.a.a.a.a.a.a(e2);
                                    }
                                }
                                return z;
                            }
                        } while (!readLine.contains(str2));
                        break;
                        bufferedReader.close();
                    } catch (IOException e3) {
                        com.a.a.a.a.a.a.a.a(e3);
                    }
                    z = true;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = exists;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e4) {
                            com.a.a.a.a.a.a.a.a(e4);
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader2 != null) {
                }
                throw th;
            }
        }
        return z;
    }

    public static String getCpuInfoString() {
        switch (getCpuType()) {
            case 1:
                return "neon";
            case 2:
                return "ar";
            case 3:
                return "x86";
            case 4:
                return IDevices.ABI_MIPS;
            default:
                return "";
        }
    }

    public static int getCpuType() {
        if (sCheckedCpuInfo) {
            return sCpuType;
        }
        String str = Build.CPU_ABI;
        if (str != null) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.startsWith("arm")) {
                if (supportNeon()) {
                    sCpuType = 1;
                } else {
                    sCpuType = 2;
                }
            } else if (lowerCase.startsWith("x86") || lowerCase.startsWith("i686")) {
                sCpuType = 3;
            } else if (lowerCase.startsWith(IDevices.ABI_MIPS)) {
                sCpuType = 4;
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
        if (TextUtils.isEmpty(property) || !property.endsWith("64")) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                String str = (String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.product.cpu.abilist64", "");
                if (str != null) {
                    if (!str.isEmpty()) {
                        return true;
                    }
                }
            } catch (Exception e) {
                com.a.a.a.a.a.a.a.a(e);
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
