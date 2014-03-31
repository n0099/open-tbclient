package com.baidu.tieba.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RemoteViews;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.r;
import com.baidu.tieba.service.PerformMonitorService;
import java.io.RandomAccessFile;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public class UtilHelper {
    public static int[] getPbImageSize(com.baidu.tieba.data.f fVar, int i) {
        int i2;
        int[] iArr = new int[2];
        int b = fVar.b();
        int c = fVar.c();
        int i3 = i <= 0 ? 1 : i;
        int i4 = i3 <= 640 ? i3 : 640;
        int i5 = (int) (i4 * 1.6f);
        if (c > i5) {
            b = (b * i5) / c;
        } else {
            i5 = c;
        }
        if (b > i4) {
            i2 = (i5 * i4) / b;
        } else {
            i4 = b;
            i2 = i5;
        }
        iArr[0] = i4;
        iArr[1] = i2;
        return iArr;
    }

    public static int[] getNewPbImageSize(com.baidu.tieba.data.f fVar, int i) {
        int i2;
        int i3;
        int[] iArr = new int[2];
        int b = fVar.b();
        int c = fVar.c();
        if (i <= 0) {
            i = 1;
        }
        int i4 = (int) (i * 1.6f);
        if (b < i / 10) {
            if (c >= i4) {
                c = i4;
            }
            i2 = c;
            i3 = b;
        } else {
            float min = Math.min(i4 / c, i / b);
            i2 = (int) (c * min);
            i3 = (int) (b * min);
        }
        iArr[0] = i3;
        iArr[1] = i2;
        return iArr;
    }

    public static String appendCuidParam(String str) {
        if (bc.c(str) || str.indexOf("cuid=") < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (str.indexOf("?") > 0) {
                sb.append("&");
            } else {
                sb.append("?");
            }
            sb.append("cuid=");
            sb.append(TbadkApplication.j().z());
            sb.append("&timestamp=");
            sb.append(Long.toString(System.currentTimeMillis()));
            return sb.toString();
        }
        return str;
    }

    public static String appendVersionCode(String str) {
        return (bc.c(str) || str.indexOf("_client_version=") < 0) ? String.valueOf(str) + "&_client_version=" + com.baidu.tbadk.core.data.n.c() : str;
    }

    public static String urlAddParam(String str, String str2) {
        if (str != null && str2 != null) {
            if (str.indexOf("?") < 0) {
                str = String.valueOf(str) + "?";
            } else if (!str.endsWith("?") && !str.endsWith("&")) {
                str = String.valueOf(str) + "&";
            }
            return String.valueOf(str) + str2;
        }
        return str;
    }

    public static boolean isAutoBrightness(Context context) {
        return CompatibleUtile.getInstance().isAutoBrightness(context);
    }

    public static void shareThread(Context context, String str, String str2, String str3, String str4) {
        if (str2 != null && str3 != null && str4 != null) {
            try {
                if (str3.length() > 140) {
                    str3 = str3.substring(0, 140);
                }
                String str5 = "http://tieba.baidu.com/p/" + str2 + "?share=9105";
                if (str != null) {
                    new ax(str, str2).start();
                }
                Intent intent = new Intent("android.intent.action.SEND", (Uri) null);
                intent.putExtra("android.intent.extra.TEXT", MessageFormat.format(context.getResources().getString(com.baidu.tieba.a.k.share_format), str3, str4, str5));
                intent.setFlags(268435456);
                intent.setType("text/plain");
                context.startActivity(Intent.createChooser(intent, context.getResources().getString(com.baidu.tieba.a.k.share_to)));
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("UtilHelper", "share", e.toString());
            }
        }
    }

    public static void share(Context context, String str, String str2, String str3) {
        try {
            Intent intent = new Intent("android.intent.action.SEND", (Uri) null);
            intent.addCategory("android.intent.category.DEFAULT");
            if (str2.length() > 140) {
                str2 = str2.substring(0, 140);
            }
            intent.putExtra("android.intent.extra.TEXT", str2);
            intent.setFlags(268435456);
            intent.setType("text/plain");
            r.c();
            context.startActivity(Intent.createChooser(intent, r.d().getResources().getString(com.baidu.tieba.a.k.share_to)));
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("UtilHelper", "share", e.toString());
        }
    }

    public static void takePerformanceSample(Context context) {
        context.startService(new Intent(context, PerformMonitorService.class));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [255=5] */
    public static boolean isARM() {
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

    public static boolean isInstalledPackage(Context context, String str) {
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

    public static void showNotification(Context context, com.baidu.tbadk.core.data.k kVar, int i) {
        boolean z;
        boolean z2;
        int hours = new Date(System.currentTimeMillis()).getHours();
        if ((hours < 0 || hours > 7) && hours < 23) {
            long time = new Date().getTime();
            if (com.baidu.tbadk.coreExtra.messageCenter.a.c()) {
                z = false;
                z2 = false;
            } else {
                r.c();
                if (time - r.H() >= 5000) {
                    boolean z3 = TbadkApplication.j().ap();
                    z = TbadkApplication.j().ao();
                    r.c();
                    r.b(time);
                    z2 = z3;
                } else {
                    z = false;
                    z2 = false;
                }
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            String d = kVar.d();
            String c = kVar.c();
            if (r.c().n()) {
                Notification notification = new Notification(com.baidu.tieba.a.g.icon, d, System.currentTimeMillis());
                if (c != null && c.length() > 0) {
                    Intent intent = new Intent(context, DealIntentService.class);
                    if (c.startsWith("http:")) {
                        String substring = c.substring(c.lastIndexOf("/") + 1);
                        intent.putExtra("class", 1);
                        intent.putExtra("id", substring);
                        intent.putExtra("is_message_pv", true);
                    } else if (c.equals("tab://1")) {
                        intent.putExtra("class", 3);
                        intent.putExtra("is_message_pv", true);
                        intent.putExtra("refresh_all", true);
                        intent.putExtra("close_dialog", true);
                        intent.putExtra("locate_type", 0);
                        intent.setFlags(603979776);
                        r.c().d(0);
                    } else if (c.startsWith("opfeature:")) {
                        try {
                            intent.putExtra("class", 0);
                            c = c.replaceFirst("opfeature:", com.baidu.loginshare.e.f);
                            intent.putExtra("url", c);
                            intent.putExtra("is_message_pv", true);
                        } catch (Exception e) {
                            com.baidu.adp.lib.util.f.a("MessagePullService", "showNotification", e.toString());
                            return;
                        }
                    } else if (c.startsWith("pk_before:")) {
                        intent.putExtra("class", 6);
                        intent.putExtra("value", c.substring(c.lastIndexOf(":") + 1));
                    } else if (c.startsWith("pk_after:")) {
                        intent.putExtra("class", 7);
                        intent.putExtra("value", c.substring(c.lastIndexOf(":") + 1));
                    } else if (c.startsWith("vote")) {
                        intent.putExtra("class", 8);
                    } else {
                        return;
                    }
                    intent.putExtra("is_notify", true);
                    intent.putExtra("link", c);
                    intent.putExtra("message_id", kVar.b());
                    if (!TextUtils.isEmpty(kVar.a())) {
                        intent.putExtra("stat", kVar.a());
                    }
                    PendingIntent service = PendingIntent.getService(context, 0, intent, 134217728);
                    String string = context.getString(com.baidu.tieba.a.k.app_name);
                    notification.icon = com.baidu.tieba.a.g.icon_notify;
                    notification.setLatestEventInfo(context, string, d, service);
                    r.c();
                    RemoteViews remoteViews = new RemoteViews(r.d().getPackageName(), com.baidu.tieba.a.i.custom_notification);
                    remoteViews.setImageViewResource(com.baidu.tieba.a.h.notification_icon, com.baidu.tieba.a.g.icon);
                    remoteViews.setTextViewText(com.baidu.tieba.a.h.notification_content, d);
                    remoteViews.setTextViewText(com.baidu.tieba.a.h.notification_time, bc.b(new Date()));
                    notification.contentView = remoteViews;
                    notification.defaults = -1;
                    if (!z) {
                        notification.defaults &= -3;
                    }
                    if (!z2) {
                        notification.defaults &= -2;
                    } else {
                        notification.audioStreamType = 5;
                    }
                    notification.flags |= 16;
                    notificationManager.notify(i, notification);
                }
            }
        }
    }

    public static void callPhone(Context context, String str) {
        Intent intent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + str));
        intent.addFlags(268435456);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            com.baidu.adp.lib.util.f.b(e.getMessage());
        } catch (SecurityException e2) {
            com.baidu.adp.lib.util.f.b(e2.getMessage());
        }
    }

    public static void smsPhone(Context context, String str) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
        intent.putExtra("sms_body", "");
        intent.addFlags(268435456);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            com.baidu.adp.lib.util.f.b(e.getMessage());
        } catch (SecurityException e2) {
            com.baidu.adp.lib.util.f.b(e2.getMessage());
        }
    }

    public static void startBaiDuBar(Context context, String str) {
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
            startBaiduWebView(context, str);
        }
    }

    private static void startBaiduWebView(Context context, String str) {
        if (str != null && str.length() > 0) {
            com.baidu.tbadk.browser.a.b(context, "http://m.baidu.com/s?from=1001157a&word=" + str);
        } else {
            com.baidu.tbadk.browser.a.b(context, "http://m.baidu.com/?from=1001157a");
        }
    }

    public static String getMetaValue(Context context, String str) {
        if (context == null || str == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            Bundle bundle = applicationInfo != null ? applicationInfo.metaData : null;
            if (bundle != null) {
                return bundle.getString(str);
            }
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public static void setBitmapByTag(View view, String str, com.baidu.adp.widget.ImageView.b bVar) {
        if (view != null && str != null) {
            if (view.getTag() != null && view.getTag().equals(str)) {
                if (bVar == null) {
                    view.invalidate();
                } else if (view instanceof ImageView) {
                    bVar.a((ImageView) view);
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt != null) {
                        setBitmapByTag(childAt, str, bVar);
                    }
                }
            }
        }
    }
}
