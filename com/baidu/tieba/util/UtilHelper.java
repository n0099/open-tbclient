package com.baidu.tieba.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.widget.RemoteViews;
import com.baidu.android.pushservice.PushManager;
import com.baidu.browser.Browser;
import com.baidu.browser.base.IntentConstants;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.loginshare.Token;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.CommonWebviewActivity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.flist.ForumRankActivity;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.home.ForumTopicActivity;
import com.baidu.tieba.im.groupInfo.GroupInfoActivity;
import com.baidu.tieba.mention.MentionActivity;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.pb.WebActivity;
import com.baidu.tieba.pb.WebBdActivity;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.recommend.DailyRecommendActivity;
import com.baidu.tieba.service.DealIntentService;
import com.baidu.tieba.service.PerformMonitorService;
import com.baidu.tieba.switchs.SwitchKey;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class UtilHelper {

    /* loaded from: classes.dex */
    public enum NetworkStateInfo {
        UNAVAIL,
        WIFI,
        TwoG,
        ThreeG
    }

    public static void a(Context context, String str) {
        File d;
        if (str != null && str.length() > 0 && (d = x.d(str)) != null) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(d), "application/vnd.android.package-archive");
            context.startActivity(intent);
        }
    }

    public static void a(Activity activity) {
        new AlertDialog.Builder(activity).setTitle(R.string.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(R.string.alert_quit_confirm).setPositiveButton(R.string.alert_yes_button, new bi(activity)).setNegativeButton(R.string.alert_no_button, new bh()).create().show();
    }

    public static int a(Context context) {
        int bitmapMaxMemory = CompatibleUtile.getInstance().getBitmapMaxMemory(context);
        bd.e("UtilHelper", "getBitmapMaxMemory", String.valueOf(bitmapMaxMemory));
        return bitmapMaxMemory;
    }

    public static boolean b(Context context) {
        return Build.VERSION.SDK_INT > 4 && CompatibleUtile.getInstance().supportMultiTouch(context);
    }

    public static void b(Activity activity) {
        CompatibleUtile.getInstance().openGpu(activity);
    }

    public static String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str.indexOf("?") > 0) {
            sb.append("&");
        } else {
            sb.append("?");
        }
        sb.append("cuid=");
        sb.append(TiebaApplication.h().p());
        sb.append("&timestamp=");
        sb.append(Long.toString(System.currentTimeMillis()));
        return sb.toString();
    }

    public static String b(String str) {
        return str + "&_client_version=" + com.baidu.tieba.data.h.j();
    }

    public static void b(Context context, String str) {
        try {
            Token b = com.baidu.tieba.account.a.b(TiebaApplication.E());
            int i = Build.VERSION.SDK_INT;
            int b2 = com.baidu.adp.lib.a.d.a().b(SwitchKey.BAIDU_WEBVIEW);
            String b3 = b(a(str));
            if (b2 == 1) {
                if (b != null) {
                    WebActivity.a(context, b3, b.mBduss, b.mPtoken);
                } else {
                    WebActivity.a(context, b3, null, null);
                }
            } else if (i >= 7 && b2 == 0) {
                if (b != null) {
                    WebBdActivity.a(context, b3, b.mBduss, b.mPtoken);
                } else {
                    WebBdActivity.a(context, b3, null, null);
                }
            } else {
                d(context, b3);
            }
        } catch (Exception e) {
            bd.b("UtilHelper", "startWebActivity", e.getMessage());
        }
    }

    public static void c(Context context, String str) {
        String b = b(a(str));
        try {
            int i = Build.VERSION.SDK_INT;
            Token b2 = com.baidu.tieba.account.a.b(TiebaApplication.E());
            int b3 = com.baidu.adp.lib.a.d.a().b(SwitchKey.BAIDU_WEBVIEW);
            if (i > 7 && b3 == 0) {
                if (b2 != null) {
                    WebBdActivity.a(context, b, b2.mBduss, b2.mPtoken);
                } else {
                    WebBdActivity.a(context, b, null, null);
                }
            } else if (b2 != null) {
                WebActivity.a(context, b, b2.mBduss, b2.mPtoken);
            } else {
                WebActivity.a(context, b, null, null);
            }
        } catch (Exception e) {
            bd.b("UtilHelper", "startInternalWebActivity", e.getMessage());
        }
    }

    public static void d(Context context, String str) {
        String b = b(a(str));
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(b));
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        } catch (Exception e) {
            bd.b("UtilHelper", "startExternWebActivity", e.getMessage());
        }
    }

    public static void a(WebSettings webSettings) {
        CompatibleUtile.getInstance().WebViewNoDataBase(webSettings);
    }

    public static void c(Context context) {
        context.startService(new Intent(context, PerformMonitorService.class));
    }

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
                        com.baidu.adp.lib.h.e.a(e.getMessage());
                        o.a(randomAccessFile);
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    o.a(randomAccessFile);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                randomAccessFile = null;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
                o.a(randomAccessFile);
                throw th;
            }
            if (randomAccessFile.read(bArr) >= 1) {
                String str = new String(bArr);
                int indexOf = str.indexOf(0);
                if (indexOf != -1) {
                    str = str.substring(0, indexOf);
                }
                if (str.toLowerCase().contains("arm")) {
                    o.a(randomAccessFile);
                    return true;
                }
                o.a(randomAccessFile);
                return false;
            }
            o.a(randomAccessFile);
            return false;
        }
        return true;
    }

    public static boolean e(Context context, String str) {
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

    public static final boolean d(Context context) {
        SQLiteDatabase openOrCreateDatabase;
        try {
            openOrCreateDatabase = context.openOrCreateDatabase("webviewCache.db", 0, null);
        } catch (Throwable th) {
            try {
                if (com.baidu.adp.lib.h.e.a()) {
                    com.baidu.adp.lib.h.e.b(UtilHelper.class.getName(), "webViewIsProbablyCorrupt", th.getMessage());
                }
            } finally {
                o.a((SQLiteDatabase) null);
            }
        }
        if (openOrCreateDatabase != null) {
            o.a(openOrCreateDatabase);
            return false;
        }
        o.a(openOrCreateDatabase);
        return true;
    }

    public static void a(Context context, String str, String str2, String str3) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("pb:")) {
            NewPbActivity.a(context, lowerCase.substring(3), null, str3);
        } else if (lowerCase.startsWith("opfeature:")) {
            b(context, a(lowerCase.replaceFirst("opfeature:", ""), str3));
        } else if (lowerCase.startsWith("web:")) {
            b(context, a(lowerCase.replaceFirst("web:", ""), str3));
        } else if (lowerCase.startsWith("frs:")) {
            FrsActivity.a(context, lowerCase.substring(4), str3);
        } else if (lowerCase.startsWith("topic:")) {
            ForumTopicActivity.a(context, lowerCase.substring(6), str2);
        } else if (lowerCase.startsWith("zb:")) {
            CommonWebviewActivity.a(context, context.getString(R.string.kn_zhibo), lowerCase.substring(3), true, "get");
        } else if (lowerCase.startsWith("jctj:")) {
            DailyRecommendActivity.a(context, (String) null);
        } else if (lowerCase.startsWith("list:")) {
            ForumRankActivity.a(context, lowerCase.substring(5), str3);
        } else {
            com.baidu.adp.lib.h.g.a(context, (int) R.string.deal_link_error);
        }
    }

    private static String a(String str, String str2) {
        String str3;
        if (!str.startsWith(com.baidu.loginshare.e.f)) {
            str = com.baidu.loginshare.e.f.concat(str);
        }
        if (str.contains("?")) {
            str3 = "&st_type=" + str2;
        } else {
            str3 = "?st_type=" + str2;
        }
        return str.concat(str3);
    }

    public static void a(Context context, com.baidu.tieba.data.at atVar, int i) {
        boolean z;
        boolean z2;
        int hours = new Date(System.currentTimeMillis()).getHours();
        if ((hours < 0 || hours > 7) && hours < 23) {
            long time = new Date().getTime();
            if (com.baidu.tieba.mention.t.c()) {
                z = false;
                z2 = false;
            } else if (time - TiebaApplication.h().aT() >= 5000) {
                boolean z3 = TiebaApplication.h().T();
                z = TiebaApplication.h().U();
                TiebaApplication.h().c(time);
                z2 = z3;
            } else {
                z = false;
                z2 = false;
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            String d = atVar.d();
            String c = atVar.c();
            if (TiebaApplication.h().P()) {
                Notification notification = new Notification(R.drawable.icon, d, System.currentTimeMillis());
                if (c != null && c.length() > 0) {
                    Intent intent = new Intent(context, DealIntentService.class);
                    if (c.startsWith("http:")) {
                        String substring = c.substring(c.lastIndexOf("/") + 1);
                        intent.putExtra("class", 1);
                        intent.putExtra(LocaleUtil.INDONESIAN, substring);
                        intent.putExtra("is_message_pv", true);
                    } else if (c.equals("tab://1")) {
                        intent.putExtra("class", 3);
                        intent.putExtra("is_message_pv", true);
                        intent.putExtra("refresh_all", true);
                        intent.putExtra("close_dialog", true);
                        intent.putExtra("locate_type", 0);
                        intent.setFlags(603979776);
                        TiebaApplication.h().g(0);
                    } else if (c.startsWith("opfeature:")) {
                        try {
                            intent.putExtra("class", 0);
                            intent.putExtra(SocialConstants.PARAM_URL, c.replaceFirst("opfeature:", com.baidu.loginshare.e.f));
                            intent.putExtra("is_message_pv", true);
                        } catch (Exception e) {
                            bd.a("MessagePullService", "showNotification", e.toString());
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
                    intent.putExtra("message_id", atVar.b());
                    if (!TextUtils.isEmpty(atVar.a())) {
                        intent.putExtra("stat", atVar.a());
                    }
                    PendingIntent service = PendingIntent.getService(context, 0, intent, 134217728);
                    String string = context.getString(R.string.app_name);
                    notification.icon = R.drawable.icon_notify;
                    notification.setLatestEventInfo(context, string, d, service);
                    RemoteViews remoteViews = new RemoteViews(TiebaApplication.h().getPackageName(), (int) R.layout.custom_notification);
                    remoteViews.setImageViewResource(R.id.notification_icon, R.drawable.icon);
                    remoteViews.setTextViewText(R.id.notification_content, d);
                    remoteViews.setTextViewText(R.id.notification_time, bb.b(new Date()));
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

    public static boolean a(Context context, Intent intent) {
        if (intent != null) {
            switch (intent.getExtras().getInt("class", -1)) {
                case 0:
                    b(context, intent.getExtras().getString(SocialConstants.PARAM_URL));
                    return true;
                case 1:
                    if (intent.getBooleanExtra("is_message_pv", false)) {
                        NewPbActivity.a(context, intent.getStringExtra(LocaleUtil.INDONESIAN), null, intent.getStringExtra("from"), intent.getLongExtra("message_id", 0L));
                        return true;
                    }
                    NewPbActivity.a(context, intent.getStringExtra(LocaleUtil.INDONESIAN), null, intent.getStringExtra("from"));
                    return true;
                case 2:
                    FrsActivity.a(context, intent.getStringExtra("fname"), intent.getStringExtra("from"));
                    return true;
                case 3:
                    intent.setClass(context, MainTabActivity.class);
                    context.startActivity(intent);
                    return true;
                case 4:
                case 6:
                case 7:
                default:
                    return false;
                case 5:
                    long longExtra = intent.getLongExtra("at_me", 0L);
                    long longExtra2 = intent.getLongExtra("reply_me", 0L);
                    long longExtra3 = intent.getLongExtra("fans", 0L);
                    long longExtra4 = intent.getLongExtra("chat", 0L);
                    long longExtra5 = intent.getLongExtra("group_msg", 0L);
                    long longExtra6 = intent.getLongExtra("group_msg_validate", 0L);
                    long longExtra7 = intent.getLongExtra("group_msg_updates", 0L);
                    com.baidu.tieba.mention.t.a().a(longExtra2, longExtra, longExtra3, longExtra4);
                    com.baidu.adp.lib.h.e.d("group_msg:" + longExtra5 + " group_msg_validate:" + longExtra6 + " group_msg_updates" + longExtra7);
                    if (longExtra2 > 0 || longExtra > 0 || longExtra4 > 0 || longExtra7 > 0 || longExtra6 > 0 || longExtra5 > 0) {
                        MainTabActivity.a(context, 3, true);
                        return false;
                    }
                    break;
                case 8:
                    MainTabActivity.a(context, 2);
                    return true;
                case 9:
                    intent.setClass(context, MainTabActivity.class);
                    context.startActivity(intent);
                    return true;
                case 10:
                    MainTabActivity.a(context, 4);
                    return true;
                case 11:
                    long longExtra8 = intent.getLongExtra("at_me", 0L);
                    long longExtra9 = intent.getLongExtra("reply_me", 0L);
                    long longExtra10 = intent.getLongExtra("fans", 0L);
                    long longExtra11 = intent.getLongExtra("chat", 0L);
                    long longExtra12 = intent.getLongExtra("group_msg", 0L);
                    long longExtra13 = intent.getLongExtra("group_msg_validate", 0L);
                    long longExtra14 = intent.getLongExtra("group_msg_updates", 0L);
                    com.baidu.tieba.mention.t.a().a(longExtra9, longExtra8, longExtra10, longExtra11);
                    com.baidu.adp.lib.h.e.d("group_msg1:" + longExtra12 + " group_msg_validate1 " + longExtra13 + " group_msg_updates1 " + longExtra14);
                    if (longExtra9 > 0 || longExtra8 > 0 || longExtra11 > 0 || longExtra14 > 0 || longExtra13 > 0 || longExtra12 > 0) {
                        MentionActivity.b = true;
                        MentionActivity.a(context);
                        return false;
                    }
                    break;
                case 12:
                    String B = TiebaApplication.B();
                    String G = TiebaApplication.G();
                    if (!TextUtils.isEmpty(B) && !TextUtils.isEmpty(G)) {
                        PersonInfoActivity.a(context, B, G);
                        return false;
                    }
                    break;
                case 13:
                    GroupInfoActivity.a(context, Long.parseLong(intent.getStringExtra("groupid")), 0);
                    return true;
            }
        }
        return false;
    }

    public static void f(Context context, String str) {
        Intent intent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + str));
        intent.addFlags(268435456);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            bd.a(e.getMessage());
        } catch (SecurityException e2) {
            bd.a(e2.getMessage());
        }
    }

    public static void g(Context context, String str) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
        intent.putExtra("sms_body", "");
        intent.addFlags(268435456);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            bd.a(e.getMessage());
        } catch (SecurityException e2) {
            bd.a(e2.getMessage());
        }
    }

    public static void h(Context context, String str) {
        try {
            StatService.onEvent(context, "search_in_baidu", "searchclick", 1);
            Intent intent = new Intent();
            intent.addCategory("android.intent.category.DEFAULT");
            if (!TextUtils.isEmpty(str)) {
                intent.setAction(IntentConstants.ACTION_SEARCH);
                intent.putExtra(Browser.KEY_VALUE, str);
            } else {
                intent.setAction(IntentConstants.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
            }
            intent.putExtra("BROWSER_RESTART", true);
            intent.putExtra("EXTRA_URL_NEW_WINDOW", true);
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            i(context, str);
        }
    }

    private static void i(Context context, String str) {
        if (str != null && str.length() > 0) {
            c(context, "http://m.baidu.com/s?from=1001157a&word=" + str);
        } else {
            c(context, "http://m.baidu.com/?from=1001157a");
        }
    }

    public static void e(Context context) {
        if (context == null) {
            com.baidu.adp.lib.h.e.b(UtilHelper.class.getName(), "startPushService", " context is null!");
            return;
        }
        String E = TiebaApplication.E();
        if (TextUtils.isEmpty(E)) {
            PushManager.startWork(context, 0, "GXGROE8KmWiRmcWFpiWTmUbE");
            return;
        }
        int indexOf = E.indexOf("|");
        if (indexOf > 0) {
            E = E.substring(0, indexOf);
        }
        PushManager.startWork(context, "1095821", E);
    }

    public static void f(Context context) {
        PushManager.stopWork(context);
    }

    public static boolean b() {
        return g(TiebaApplication.h().getApplicationContext()) != NetworkStateInfo.UNAVAIL;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0069 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0002 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.baidu.tieba.util.UtilHelper$NetworkStateInfo] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
    public static NetworkStateInfo g(Context context) {
        NetworkStateInfo networkStateInfo;
        ?? e = NetworkStateInfo.UNAVAIL;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!activeNetworkInfo.isAvailable()) {
                networkStateInfo = NetworkStateInfo.UNAVAIL;
                try {
                    e = "NetWorkCore";
                    bd.a("NetWorkCore", "NetworkStateInfo", "UNAVAIL");
                } catch (Exception e2) {
                    e = e2;
                }
            } else if (activeNetworkInfo.getType() == 1) {
                bd.a("NetWorkCore", "NetworkStateInfo", "WIFI");
                networkStateInfo = NetworkStateInfo.WIFI;
            } else {
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 0:
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        bd.a("NetWorkCore", "NetworkStateInfo", "TwoG");
                        networkStateInfo = NetworkStateInfo.TwoG;
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        bd.a("NetWorkCore", "NetworkStateInfo", "ThreeG");
                        networkStateInfo = NetworkStateInfo.ThreeG;
                        break;
                    default:
                        bd.a("NetWorkCore", "NetworkStateInfo-default", "TwoG");
                        networkStateInfo = NetworkStateInfo.TwoG;
                        break;
                }
            }
            return networkStateInfo;
        } catch (Exception e3) {
            return e;
        }
    }

    public static boolean a(long j, long j2) {
        return j <= j2 && j / Util.MILLSECONDS_OF_DAY == j2 / Util.MILLSECONDS_OF_DAY;
    }

    public static String a(String str, int i) {
        String str2 = "";
        double d = 0.0d;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || (charAt >= '0' && charAt <= '9'))) {
                d += 0.5d;
            } else {
                d += 1.0d;
            }
            if (d <= i) {
                str2 = str2 + charAt;
            } else {
                return str2 + "...";
            }
        }
        return str2;
    }

    public static String h(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (!wifiManager.isWifiEnabled()) {
                wifiManager.setWifiEnabled(true);
            }
            return a(wifiManager.getConnectionInfo().getIpAddress());
        } catch (Exception e) {
            bd.b("UtilHelper", "getWifiMac", e.toString());
            return null;
        }
    }

    private static String a(int i) {
        return (i & Util.MASK_8BIT) + "." + ((i >> 8) & Util.MASK_8BIT) + "." + ((i >> 16) & Util.MASK_8BIT) + "." + ((i >> 24) & Util.MASK_8BIT);
    }

    public static String c() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        return nextElement.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException e) {
            bd.b("UtilHelper", "getGprsIpAddress", e.toString());
        }
        return null;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (Exception e) {
            bd.b("UtilHelper", "getIpFromDomain", e.toString());
            return null;
        }
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Matcher matcher = Pattern.compile("http(s)?://([\\w-]+\\.)+[\\w-]+/?").matcher(str.toLowerCase());
        String str2 = "";
        if (matcher.find()) {
            str2 = matcher.group();
            if (str2.indexOf(com.baidu.loginshare.e.f) > -1) {
                str2 = str2.replace(com.baidu.loginshare.e.f, "");
            } else if (str2.indexOf(com.baidu.loginshare.e.g) > -1) {
                str2 = str2.replace(com.baidu.loginshare.e.g, "");
            }
        }
        return str2.replace("/", "");
    }
}
