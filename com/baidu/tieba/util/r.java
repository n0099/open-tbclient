package com.baidu.tieba.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class r {
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [255=5] */
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
                        com.baidu.adp.lib.util.f.b(e.getMessage());
                        com.baidu.tbadk.core.util.l.a(randomAccessFile);
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.tbadk.core.util.l.a(randomAccessFile);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                randomAccessFile = null;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
                com.baidu.tbadk.core.util.l.a(randomAccessFile);
                throw th;
            }
            if (randomAccessFile.read(bArr) <= 0) {
                com.baidu.tbadk.core.util.l.a(randomAccessFile);
                return false;
            }
            String str = new String(bArr);
            int indexOf = str.indexOf(0);
            if (indexOf != -1) {
                str = str.substring(0, indexOf);
            }
            if (str.toLowerCase().contains("arm")) {
                com.baidu.tbadk.core.util.l.a(randomAccessFile);
                return true;
            }
            com.baidu.tbadk.core.util.l.a(randomAccessFile);
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
        try {
            TiebaStatic.a(context, "search_in_baidu", "searchclick", 1, new Object[0]);
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
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            if (str == null || str.length() <= 0) {
                com.baidu.tbadk.browser.a.b(context, "http://m.baidu.com/?from=1001157a");
            } else {
                com.baidu.tbadk.browser.a.b(context, "http://m.baidu.com/s?from=1001157a&word=" + str);
            }
        }
    }
}
