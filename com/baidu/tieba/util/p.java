package com.baidu.tieba.util;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.s;
import com.baidu.tieba.aj;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.lang.Thread;
import java.util.List;
/* loaded from: classes.dex */
public class p implements Thread.UncaughtExceptionHandler {
    public static final String[] bQr = {"com.baidu.android.systemmonitor", "com.baidu.android.defense", "com.baidu.android.moplus", "com.baidu.android.nebula", "com.baidu.android.a."};
    public static final String[] bQs = {"com.baidu.lightapp", "com.baidu.channelrtc"};
    public static final String[] bQt = {"com.baidu.hao123sdk", "com.baidu.android.pushservice"};
    public static final String[] bQu = {"cn.myhug.baobao.sdk", "com.nostra13.universalimageloader"};
    private static final String bQw = String.valueOf(Environment.getExternalStorageDirectory().getPath()) + File.separator + "tieba" + File.separator + "oom" + File.separator;
    private final Thread.UncaughtExceptionHandler bQv = Thread.getDefaultUncaughtExceptionHandler();

    /* JADX WARN: Removed duplicated region for block: B:101:0x0239 A[Catch: Exception -> 0x02af, TRY_LEAVE, TryCatch #2 {Exception -> 0x02af, blocks: (B:97:0x022f, B:99:0x0234, B:101:0x0239), top: B:148:0x022f }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x022f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0234 A[Catch: Exception -> 0x02af, TryCatch #2 {Exception -> 0x02af, blocks: (B:97:0x022f, B:99:0x0234, B:101:0x0239), top: B:148:0x022f }] */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void uncaughtException(Thread thread, Throwable th) {
        PrintStream printStream;
        ByteArrayOutputStream byteArrayOutputStream;
        PrintStream printStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        String str;
        FileWriter fileWriter = null;
        if (TbConfig.getDebugSwitch() && b(th)) {
            aeM();
        }
        if (!aeN()) {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    printStream = new PrintStream(byteArrayOutputStream);
                    try {
                        th.printStackTrace(printStream);
                        String str2 = new String(byteArrayOutputStream.toByteArray());
                        if (TbConfig.getDebugSwitch()) {
                            str = TbConfig.FATAL_ERROR_DEBUG_FILE;
                        } else {
                            str = TbConfig.FATAL_ERROR_FILE;
                        }
                        File bu = s.bu(str);
                        if (bu != null && bu.length() < 204800 && str2 != null) {
                            FileWriter fileWriter2 = new FileWriter(bu, true);
                            try {
                                a(fileWriter2, az.mB(), null);
                                a(fileWriter2, "tieba_crash_new_info", null);
                                a(fileWriter2, "version", TbConfig.getVersion());
                                a(fileWriter2, "model", Build.MODEL);
                                a(fileWriter2, "android_version", Build.VERSION.RELEASE);
                                a(fileWriter2, "android_sdk", String.valueOf(Build.VERSION.SDK_INT));
                                a(fileWriter2, "from", TbConfig.getFrom());
                                a(fileWriter2, "current_from", TbConfig.getCurrentFrom());
                                a(fileWriter2, SapiAccountManager.SESSION_UID, TbadkApplication.getCurrentAccount());
                                a(fileWriter2, "client_id", TbadkApplication.getClientId());
                                a(fileWriter2, "imei", TbadkApplication.m251getInst().getImei());
                                a(fileWriter2, "uname", TbadkApplication.getCurrentAccountName());
                                a(fileWriter2, "activity", be.mP());
                                a(fileWriter2, "maxMemory", String.valueOf(Runtime.getRuntime().maxMemory()));
                                a(fileWriter2, "crash_type", th.getClass().getName());
                                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) aj.wm().getApp().getSystemService("activity")).getRunningAppProcesses();
                                int myPid = Process.myPid();
                                if (runningAppProcesses != null) {
                                    int i = 0;
                                    while (true) {
                                        if (i >= runningAppProcesses.size()) {
                                            break;
                                        } else if (runningAppProcesses.get(i).pid != myPid) {
                                            i++;
                                        } else {
                                            a(fileWriter2, "process_name", runningAppProcesses.get(i).processName);
                                            break;
                                        }
                                    }
                                }
                                a(fileWriter2, "error", str2);
                                a(fileWriter2, "tieba_crash_new_info_end", null);
                                fileWriter2.append("\n");
                                fileWriter2.flush();
                                fileWriter = fileWriter2;
                            } catch (Exception e) {
                                e = e;
                                fileWriter = fileWriter2;
                                printStream2 = printStream;
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                try {
                                    e.printStackTrace();
                                    if (printStream2 != null) {
                                        try {
                                            printStream2.close();
                                        } catch (Exception e2) {
                                            e2.printStackTrace();
                                            if (!TbConfig.getDebugSwitch() && this.bQv != null) {
                                                this.bQv.uncaughtException(thread, th);
                                                return;
                                            } else {
                                                Process.killProcess(Process.myPid());
                                                return;
                                            }
                                        }
                                    }
                                    if (byteArrayOutputStream2 != null) {
                                        byteArrayOutputStream2.close();
                                    }
                                    if (fileWriter != null) {
                                        fileWriter.close();
                                    }
                                    if (!TbConfig.getDebugSwitch()) {
                                    }
                                    Process.killProcess(Process.myPid());
                                    return;
                                } catch (Throwable th2) {
                                    th = th2;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    printStream = printStream2;
                                    if (printStream != null) {
                                        try {
                                            printStream.close();
                                        } catch (Exception e3) {
                                            e3.printStackTrace();
                                            if (!TbConfig.getDebugSwitch() && this.bQv != null) {
                                                this.bQv.uncaughtException(thread, th);
                                            } else {
                                                Process.killProcess(Process.myPid());
                                            }
                                            throw th;
                                        }
                                    }
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                    if (fileWriter != null) {
                                        fileWriter.close();
                                    }
                                    if (!TbConfig.getDebugSwitch()) {
                                    }
                                    Process.killProcess(Process.myPid());
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                fileWriter = fileWriter2;
                                if (printStream != null) {
                                }
                                if (byteArrayOutputStream != null) {
                                }
                                if (fileWriter != null) {
                                }
                                if (!TbConfig.getDebugSwitch()) {
                                }
                                Process.killProcess(Process.myPid());
                                throw th;
                            }
                        }
                        if (str2 != null) {
                            if (str2.contains("java.lang.SecurityException: No permission to modify given thread")) {
                                TbadkApplication.m251getInst().setWebviewCrashCount(TbadkApplication.m251getInst().getWebviewCrashCount() + 1);
                            } else if (str2.contains("com.baidu.location")) {
                                aj.wm().wJ();
                            } else if (str2.contains("Couldn't load mtprocessor-jni")) {
                                com.baidu.adp.lib.b.f.db().c("motu_sdk", 1);
                            }
                            if (str2.contains("com.baidu.sapi2")) {
                                TbadkApplication.m251getInst().incPassportV6CrashCount();
                            }
                            String[] strArr = bQt;
                            int length = strArr.length;
                            int i2 = 0;
                            while (true) {
                                if (i2 >= length) {
                                    break;
                                } else if (!str2.contains(strArr[i2])) {
                                    i2++;
                                } else {
                                    TbadkApplication.m251getInst().incHao123HelperCrashCount();
                                    break;
                                }
                            }
                            if (str2.contains("com.baidu.dq")) {
                                TbadkApplication.m251getInst().incDQCrashCount();
                            }
                            String[] strArr2 = bQr;
                            int length2 = strArr2.length;
                            int i3 = 0;
                            while (true) {
                                if (i3 >= length2) {
                                    break;
                                } else if (!str2.contains(strArr2[i3])) {
                                    i3++;
                                } else {
                                    TbadkApplication.m251getInst().incMoPlusCrashCount();
                                    break;
                                }
                            }
                            String[] strArr3 = bQs;
                            int length3 = strArr3.length;
                            int i4 = 0;
                            while (true) {
                                if (i4 >= length3) {
                                    break;
                                } else if (!str2.contains(strArr3[i4])) {
                                    i4++;
                                } else {
                                    TbadkApplication.m251getInst().incLiveSdkCrashCount();
                                    break;
                                }
                            }
                            String[] strArr4 = bQu;
                            int length4 = strArr4.length;
                            int i5 = 0;
                            while (true) {
                                if (i5 >= length4) {
                                    break;
                                } else if (!str2.contains(strArr4[i5])) {
                                    i5++;
                                } else {
                                    TbadkApplication.m251getInst().incBaobaoCrashCount();
                                    break;
                                }
                            }
                            if (be.mO() != null && be.mO().indexOf("NewVcode") != -1) {
                                aj.wm().dD(aj.wm().wI() + 1);
                            }
                        }
                        com.baidu.adp.lib.b.f.db().crash(str2);
                        if (!TextUtils.isEmpty(str2)) {
                            BdLog.e(str2);
                        }
                        if (printStream != null) {
                            try {
                                printStream.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        if (fileWriter != null) {
                            fileWriter.close();
                        }
                        if (TbConfig.getDebugSwitch() && this.bQv != null) {
                            this.bQv.uncaughtException(thread, th);
                        } else {
                            Process.killProcess(Process.myPid());
                        }
                    } catch (Exception e5) {
                        e = e5;
                        printStream2 = printStream;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } catch (Exception e6) {
                    e = e6;
                    printStream2 = null;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                } catch (Throwable th5) {
                    th = th5;
                    printStream = null;
                }
            } catch (Exception e7) {
                e = e7;
                printStream2 = null;
                byteArrayOutputStream2 = null;
            } catch (Throwable th6) {
                th = th6;
                printStream = null;
                byteArrayOutputStream = null;
            }
        }
    }

    private void a(FileWriter fileWriter, String str, String str2) {
        try {
            fileWriter.append((CharSequence) str);
            if (str2 != null) {
                fileWriter.append("=");
                fileWriter.append((CharSequence) str2);
            }
            fileWriter.append("\n");
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static boolean b(Throwable th) {
        if ("java.lang.OutOfMemoryError".equals(th.getClass().getName())) {
            return true;
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            return b(cause);
        }
        return false;
    }

    private void aeM() {
        try {
            File file = new File(bQw);
            if (!file.exists()) {
                file.mkdir();
            }
            Debug.dumpHprofData(String.valueOf(bQw) + System.currentTimeMillis());
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    private boolean aeN() {
        int i;
        int i2;
        int i3 = 10;
        try {
            int i4 = com.baidu.tbadk.core.sharedPref.b.lk().getInt("crash_limit_count", 100);
            if (i4 >= 10) {
                i3 = i4;
            }
        } catch (Throwable th) {
            i3 = 100;
        }
        int mC = az.mC();
        byte[] at = com.baidu.adp.lib.util.d.at("crash_upload_info.log");
        String str = null;
        if (at != null) {
            str = new String(at);
        }
        if (TextUtils.isEmpty(str)) {
            i = mC;
            i2 = 0;
        } else {
            String[] split = str.split(":");
            if (split == null || split.length != 2) {
                i = mC;
                i2 = 0;
            } else {
                int f = com.baidu.adp.lib.g.c.f(split[0], 0);
                int f2 = com.baidu.adp.lib.g.c.f(split[1], mC);
                i2 = f;
                i = f2;
            }
        }
        if (i != mC) {
            i2 = 0;
        }
        if (i2 > i3) {
            return true;
        }
        com.baidu.adp.lib.util.d.c("crash_upload_info.log", (String.valueOf(i2 + 1) + ":" + mC).getBytes());
        return false;
    }
}
