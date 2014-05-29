package com.baidu.tieba.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.service.PerformMonitorService;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    public static String a(String str) {
        if (be.c(str) || str.indexOf("cuid=") <= -1) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (str.indexOf("?") > 0) {
                sb.append("&");
            } else {
                sb.append("?");
            }
            sb.append("cuid=");
            sb.append(TbadkApplication.m252getInst().getCuid());
            sb.append("&timestamp=");
            sb.append(Long.toString(System.currentTimeMillis()));
            return sb.toString();
        }
        return str;
    }

    public static void a(Context context) {
        context.startService(new Intent(context, PerformMonitorService.class));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [280=5] */
    public static boolean a() {
        RandomAccessFile randomAccessFile;
        byte[] bArr;
        if (Build.CPU_ABI == null || !Build.CPU_ABI.toLowerCase().contains("arm")) {
            try {
                bArr = new byte[1024];
                randomAccessFile = new RandomAccessFile("/proc/cpuinfo", "r");
                try {
                    try {
                    } catch (Exception e) {
                        e = e;
                        BdLog.e(e.getMessage());
                        com.baidu.tbadk.core.util.m.a(randomAccessFile);
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.tbadk.core.util.m.a(randomAccessFile);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                randomAccessFile = null;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
                com.baidu.tbadk.core.util.m.a(randomAccessFile);
                throw th;
            }
            if (randomAccessFile.read(bArr) < 1) {
                com.baidu.tbadk.core.util.m.a(randomAccessFile);
                return false;
            }
            String str = new String(bArr);
            int indexOf = str.indexOf(0);
            if (indexOf != -1) {
                str = str.substring(0, indexOf);
            }
            if (str.toLowerCase().contains("arm")) {
                com.baidu.tbadk.core.util.m.a(randomAccessFile);
                return true;
            }
            com.baidu.tbadk.core.util.m.a(randomAccessFile);
            return false;
        }
        return true;
    }

    public static boolean a(Context context, String str) {
        int i = 0;
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        ArrayList arrayList = new ArrayList();
        if (installedPackages != null) {
            while (true) {
                int i2 = i;
                if (i2 >= installedPackages.size()) {
                    break;
                }
                arrayList.add(installedPackages.get(i2).packageName);
                i = i2 + 1;
            }
        }
        return arrayList.contains(str);
    }

    public static void b(Context context, String str) {
        Intent intent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + str));
        intent.addFlags(268435456);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            BdLog.e(e.getMessage());
        } catch (SecurityException e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public static void c(Context context, String str) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
        intent.putExtra("sms_body", "");
        intent.addFlags(268435456);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            BdLog.e(e.getMessage());
        } catch (SecurityException e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public static void d(Context context, String str) {
        try {
            TiebaStatic.eventStat(context, "search_in_baidu", "searchclick", 1, new Object[0]);
            Intent intent = new Intent();
            intent.addCategory("android.intent.category.DEFAULT");
            if (!TextUtils.isEmpty(str)) {
                intent.setAction("com.baidu.searchbox.action.SEARCH");
                intent.putExtra("key_value", str);
            } else {
                intent.setAction("com.baidu.searchbox.action.VIEW");
                intent.setData(Uri.parse("http://www.baidu.com"));
            }
            intent.putExtra("BROWSER_RESTART", true);
            intent.putExtra("EXTRA_URL_NEW_WINDOW", true);
            intent.putExtra("isBackToLauncher", true);
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            e(context, str);
        }
    }

    private static void e(Context context, String str) {
        if (str != null && str.length() > 0) {
            com.baidu.tbadk.browser.a.b(context, "http://m.baidu.com/s?from=1001157a&word=" + str);
        } else {
            com.baidu.tbadk.browser.a.b(context, "http://m.baidu.com/?from=1001157a");
        }
    }

    public static boolean a(Activity activity) {
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) activity.getSystemService("activity")).getRunningTasks(100)) {
            if (runningTaskInfo.baseActivity.getClassName().equals(activity.getClass().getName())) {
                return true;
            }
        }
        return false;
    }
}
