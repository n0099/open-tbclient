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
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.widget.Toast;
import com.baidu.android.pushservice.PushManager;
import com.baidu.browser.Browser;
import com.baidu.browser.base.IntentConstants;
import com.baidu.loginshare.Token;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.CommonWebviewActivity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.home.ForumTopicActivity;
import com.baidu.tieba.kn.ladders.KnTabActivity;
import com.baidu.tieba.kn.pk.PKEndActivity;
import com.baidu.tieba.kn.pk.PKJumpActivity;
import com.baidu.tieba.kn.pk.PKWaitingActivity;
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
import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public class UtilHelper {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f1887a = false;
    private static float b;
    private static int c;
    private static int d;

    /* loaded from: classes.dex */
    public enum NetworkStateInfo {
        UNAVAIL,
        WIFI,
        TwoG,
        ThreeG;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static NetworkStateInfo[] valuesCustom() {
            NetworkStateInfo[] valuesCustom = values();
            int length = valuesCustom.length;
            NetworkStateInfo[] networkStateInfoArr = new NetworkStateInfo[length];
            System.arraycopy(valuesCustom, 0, networkStateInfoArr, 0, length);
            return networkStateInfoArr;
        }
    }

    private static void j(Context context) {
        b = context.getResources().getDisplayMetrics().density;
        c = context.getResources().getDisplayMetrics().widthPixels;
        d = context.getResources().getDisplayMetrics().heightPixels;
        f1887a = true;
    }

    public static int a(Context context, float f) {
        if (!f1887a) {
            j(context);
        }
        return (int) ((b * f) + 0.5f);
    }

    public static int b(Context context, float f) {
        if (!f1887a) {
            j(context);
        }
        return (int) ((f / b) + 0.5f);
    }

    public static int a(Context context) {
        if (!f1887a) {
            j(context);
        }
        return c;
    }

    public static int b(Context context) {
        if (!f1887a) {
            j(context);
        }
        return d;
    }

    public static void a(Context context, String str) {
        if (str != null && str.length() > 0) {
            Toast makeText = Toast.makeText(TiebaApplication.g(), str, 0);
            makeText.setGravity(17, 0, a(context, 100.0f));
            makeText.show();
        }
    }

    public static void a(Context context, int i) {
        a(context, context.getResources().getString(i));
    }

    public static void a(Activity activity) {
        new AlertDialog.Builder(activity).setTitle(R.string.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(R.string.alert_quit_confirm).setPositiveButton(R.string.alert_yes_button, new ay(activity)).setNegativeButton(R.string.alert_no_button, new az()).create().show();
    }

    public static void a(Context context, View view) {
        if (view != null) {
            try {
                if (view.getWindowToken() != null) {
                    ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 2);
                }
            } catch (Throwable th) {
                av.b("UtilHelper", "hideSoftKeyPad", "error = " + th.getMessage());
            }
        }
    }

    public static void b(Context context, View view) {
        try {
            ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 0);
        } catch (Throwable th) {
            av.b("UtilHelper", "showSoftKeyPad", "error = " + th.getMessage());
        }
    }

    public static void b(Context context, String str) {
        File c2;
        if (str != null && str.length() > 0 && (c2 = p.c(str)) != null) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(c2), "application/vnd.android.package-archive");
            context.startActivity(intent);
        }
    }

    public static Field a(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static int c(Context context) {
        int bitmapMaxMemory = CompatibleUtile.getInstance().getBitmapMaxMemory(context);
        av.e("UtilHelper", "getBitmapMaxMemory", String.valueOf(bitmapMaxMemory));
        return bitmapMaxMemory;
    }

    public static boolean a(byte[] bArr) {
        try {
            if (bArr[0] == 71 && bArr[1] == 73) {
                if (bArr[2] == 70) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean d(Context context) {
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
        sb.append(TiebaApplication.g().o());
        sb.append("&timestamp=");
        sb.append(Long.toString(System.currentTimeMillis()));
        return sb.toString();
    }

    public static String b(String str) {
        return String.valueOf(str) + "&_client_version=" + com.baidu.tieba.data.g.j();
    }

    public static void c(Context context, String str) {
        try {
            Token b2 = com.baidu.tieba.account.a.b(TiebaApplication.E());
            int i = Build.VERSION.SDK_INT;
            int b3 = com.baidu.adp.lib.a.d.a().b(SwitchKey.BAIDU_WEBVIEW);
            String b4 = b(a(str));
            if (b3 == 1) {
                if (b2 != null) {
                    WebActivity.a(context, b4, b2.mBduss, b2.mPtoken);
                } else {
                    WebActivity.a(context, b4, null, null);
                }
            } else if (i >= 7 && b3 == 0) {
                if (b2 != null) {
                    WebBdActivity.a(context, b4, b2.mBduss, b2.mPtoken);
                } else {
                    WebBdActivity.a(context, b4, null, null);
                }
            } else {
                e(context, b4);
            }
        } catch (Exception e) {
            av.b("UtilHelper", "startWebActivity", e.getMessage());
        }
    }

    public static void d(Context context, String str) {
        String b2 = b(a(str));
        try {
            int i = Build.VERSION.SDK_INT;
            Token b3 = com.baidu.tieba.account.a.b(TiebaApplication.E());
            int b4 = com.baidu.adp.lib.a.d.a().b(SwitchKey.BAIDU_WEBVIEW);
            if (i > 7 && b4 == 0) {
                if (b3 != null) {
                    WebBdActivity.a(context, b2, b3.mBduss, b3.mPtoken);
                } else {
                    WebBdActivity.a(context, b2, null, null);
                }
            } else if (b3 != null) {
                WebActivity.a(context, b2, b3.mBduss, b3.mPtoken);
            } else {
                WebActivity.a(context, b2, null, null);
            }
        } catch (Exception e) {
            av.b("UtilHelper", "startInternalWebActivity", e.getMessage());
        }
    }

    public static void e(Context context, String str) {
        String b2 = b(a(str));
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(b2));
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        } catch (Exception e) {
            av.b("UtilHelper", "startExternWebActivity", e.getMessage());
        }
    }

    public static void a(WebSettings webSettings) {
        CompatibleUtile.getInstance().WebViewNoDataBase(webSettings);
    }

    public static float a(Paint paint, String str) {
        if (paint == null || str == null) {
            return 0.0f;
        }
        return paint.measureText(str);
    }

    public static String a(TextPaint textPaint, String str, int i) {
        CharSequence ellipsize = TextUtils.ellipsize(str, textPaint, i, TextUtils.TruncateAt.END);
        if (ellipsize == null) {
            return null;
        }
        return ellipsize.toString();
    }

    public static TextPaint a(Context context, TextPaint textPaint, float f) {
        Resources resources;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        if (resources != null) {
            textPaint.setTextSize(TypedValue.applyDimension(2, f, resources.getDisplayMetrics()));
        }
        return textPaint;
    }

    public static int c(Context context, float f) {
        TextPaint textPaint = new TextPaint();
        a(context, textPaint, f);
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        return (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
    }

    public static void a(Context context, String str, String str2, String str3, String str4) {
        if (str2 != null && str3 != null && str4 != null) {
            try {
                if (str3.length() > 140) {
                    str3 = str3.substring(0, 140);
                }
                String str5 = "http://tieba.baidu.com/p/" + str2 + "?share=9105";
                if (str != null) {
                    new com.baidu.tieba.account.ag(str, str2).start();
                }
                Intent intent = new Intent("android.intent.action.SEND", (Uri) null);
                intent.putExtra("android.intent.extra.TEXT", MessageFormat.format(context.getResources().getString(R.string.share_format), str3, str4, str5));
                intent.setFlags(268435456);
                intent.setType("text/plain");
                context.startActivity(Intent.createChooser(intent, context.getResources().getString(R.string.share_to)));
            } catch (Exception e) {
                av.b("UtilHelper", "share", e.toString());
            }
        }
    }

    public static void e(Context context) {
        context.startService(new Intent(context, PerformMonitorService.class));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [638=5] */
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
                        com.baidu.adp.lib.f.d.a(e.getMessage());
                        g.a(randomAccessFile);
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    g.a(randomAccessFile);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                randomAccessFile = null;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
                g.a(randomAccessFile);
                throw th;
            }
            if (randomAccessFile.read(bArr) < 1) {
                g.a(randomAccessFile);
                return false;
            }
            String str = new String(bArr);
            int indexOf = str.indexOf(0);
            if (indexOf != -1) {
                str = str.substring(0, indexOf);
            }
            if (str.toLowerCase().contains("arm")) {
                g.a(randomAccessFile);
                return true;
            }
            g.a(randomAccessFile);
            return false;
        }
        return true;
    }

    public static boolean f(Context context, String str) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [687=4] */
    public static final boolean f(Context context) {
        SQLiteDatabase openOrCreateDatabase;
        try {
            openOrCreateDatabase = context.openOrCreateDatabase("webviewCache.db", 0, null);
        } catch (Throwable th) {
            try {
                if (com.baidu.adp.lib.f.d.a()) {
                    com.baidu.adp.lib.f.d.b(UtilHelper.class.getName(), "webViewIsProbablyCorrupt", th.getMessage());
                }
            } finally {
                g.a((SQLiteDatabase) null);
            }
        }
        if (openOrCreateDatabase != null) {
            g.a(openOrCreateDatabase);
            return false;
        }
        g.a(openOrCreateDatabase);
        return true;
    }

    public static void a(Context context, String str, String str2) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("pb:")) {
            NewPbActivity.a(context, lowerCase.substring(3), null, null);
        } else if (lowerCase.startsWith("opfeature:")) {
            String replaceFirst = lowerCase.replaceFirst("opfeature:", "");
            if (!replaceFirst.startsWith(com.baidu.loginshare.e.f)) {
                replaceFirst = com.baidu.loginshare.e.f.concat(replaceFirst);
            }
            c(context, replaceFirst);
        } else if (lowerCase.startsWith("frs:")) {
            FrsActivity.a(context, lowerCase.substring(4), (String) null);
        } else if (lowerCase.startsWith("topic:")) {
            ForumTopicActivity.a(context, lowerCase.substring(6), str2);
        } else if (lowerCase.startsWith("pk:")) {
            PKJumpActivity.a(context, lowerCase.substring(3), "");
        } else if (lowerCase.startsWith("zb:")) {
            CommonWebviewActivity.a(context, context.getString(R.string.kn_zhibo), lowerCase.substring(3), true, "get");
        } else if (lowerCase.startsWith("hnbk:")) {
            KnTabActivity.a(context);
        } else if (lowerCase.startsWith("jctj:")) {
            DailyRecommendActivity.a(context);
        } else {
            a(context, (int) R.string.deal_link_error);
        }
    }

    public static void a(Context context, com.baidu.tieba.data.au auVar, int i) {
        boolean z;
        boolean z2;
        int hours = new Date(System.currentTimeMillis()).getHours();
        if ((hours < 0 || hours > 7) && hours < 23) {
            long time = new Date().getTime();
            if (com.baidu.tieba.mention.s.c()) {
                z = false;
                z2 = false;
            } else if (time - TiebaApplication.g().aP() >= 5000) {
                boolean z3 = TiebaApplication.g().W();
                z = TiebaApplication.g().X();
                TiebaApplication.g().c(time);
                z2 = z3;
            } else {
                z = false;
                z2 = false;
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            String d2 = auVar.d();
            String c2 = auVar.c();
            if (TiebaApplication.g().S()) {
                Notification notification = new Notification(R.drawable.icon, d2, System.currentTimeMillis());
                if (c2 != null && c2.length() > 0) {
                    Intent intent = new Intent(context, DealIntentService.class);
                    if (c2.startsWith("http:")) {
                        String substring = c2.substring(c2.lastIndexOf("/") + 1);
                        intent.putExtra("class", 1);
                        intent.putExtra(LocaleUtil.INDONESIAN, substring);
                        intent.putExtra("is_message_pv", true);
                    } else if (c2.equals("tab://1")) {
                        intent.putExtra("class", 3);
                        intent.putExtra("is_message_pv", true);
                        intent.putExtra("refresh_all", true);
                        intent.putExtra("close_dialog", true);
                        intent.putExtra("locate_type", 0);
                        intent.setFlags(603979776);
                        TiebaApplication.g().k(0);
                    } else if (c2.startsWith("opfeature:")) {
                        try {
                            intent.putExtra("class", 0);
                            intent.putExtra("url", c2.replaceFirst("opfeature:", com.baidu.loginshare.e.f));
                            intent.putExtra("is_message_pv", true);
                        } catch (Exception e) {
                            av.a("MessagePullService", "showNotification", e.toString());
                            return;
                        }
                    } else if (c2.startsWith("pk_before:")) {
                        intent.putExtra("class", 6);
                        intent.putExtra("value", c2.substring(c2.lastIndexOf(":") + 1));
                    } else if (c2.startsWith("pk_after:")) {
                        intent.putExtra("class", 7);
                        intent.putExtra("value", c2.substring(c2.lastIndexOf(":") + 1));
                    } else if (c2.startsWith("vote")) {
                        intent.putExtra("class", 8);
                    } else {
                        return;
                    }
                    intent.putExtra("is_notify", true);
                    intent.putExtra("message_id", auVar.b());
                    if (!TextUtils.isEmpty(auVar.a())) {
                        intent.putExtra("stat", auVar.a());
                    }
                    PendingIntent service = PendingIntent.getService(context, 0, intent, 134217728);
                    String string = context.getString(R.string.app_name);
                    notification.icon = R.drawable.icon;
                    notification.setLatestEventInfo(context, string, d2, service);
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
                    c(context, intent.getExtras().getString("url"));
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
                default:
                    return false;
                case 5:
                    long longExtra = intent.getLongExtra("at_me", 0L);
                    long longExtra2 = intent.getLongExtra("reply_me", 0L);
                    long longExtra3 = intent.getLongExtra("fans", 0L);
                    long longExtra4 = intent.getLongExtra("chat", 0L);
                    com.baidu.tieba.mention.s.a().a(longExtra2, longExtra, longExtra3, longExtra4);
                    if (longExtra2 > 0 || longExtra > 0 || longExtra4 > 0) {
                        MainTabActivity.a(context, 3);
                        return false;
                    }
                    break;
                case 6:
                    PKWaitingActivity.a(context, intent.getStringExtra("value"), null);
                    return true;
                case 7:
                    PKEndActivity.a(context, intent.getStringExtra("value"), null);
                    return true;
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
                    long longExtra5 = intent.getLongExtra("at_me", 0L);
                    long longExtra6 = intent.getLongExtra("reply_me", 0L);
                    long longExtra7 = intent.getLongExtra("fans", 0L);
                    long longExtra8 = intent.getLongExtra("chat", 0L);
                    com.baidu.tieba.mention.s.a().a(longExtra6, longExtra5, longExtra7, longExtra8);
                    if (longExtra6 > 0 || longExtra5 > 0 || longExtra8 > 0) {
                        MentionActivity.a(context);
                        return false;
                    }
                    break;
                case 12:
                    String C = TiebaApplication.C();
                    String G = TiebaApplication.G();
                    if (!TextUtils.isEmpty(C) && !TextUtils.isEmpty(G)) {
                        PersonInfoActivity.a(context, C, G);
                        return false;
                    }
                    break;
            }
        }
        return false;
    }

    public static void g(Context context, String str) {
        Intent intent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + str));
        intent.addFlags(268435456);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            av.a(e.getMessage());
        } catch (SecurityException e2) {
            av.a(e2.getMessage());
        }
    }

    public static void h(Context context, String str) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
        intent.putExtra("sms_body", "");
        intent.addFlags(268435456);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            av.a(e.getMessage());
        } catch (SecurityException e2) {
            av.a(e2.getMessage());
        }
    }

    public static void i(Context context, String str) {
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
            j(context, str);
        }
    }

    private static void j(Context context, String str) {
        if (str != null && str.length() > 0) {
            d(context, "http://m.baidu.com/s?from=1001157a&word=" + str);
        } else {
            d(context, "http://m.baidu.com/?from=1001157a");
        }
    }

    public static void g(Context context) {
        if (context == null) {
            com.baidu.adp.lib.f.d.b(UtilHelper.class.getName(), "startPushService", " context is null!");
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

    public static void h(Context context) {
        PushManager.stopWork(context);
    }

    public static boolean b() {
        return i(TiebaApplication.g().getApplicationContext()) != NetworkStateInfo.UNAVAIL;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0069 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0002 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.baidu.tieba.util.UtilHelper$NetworkStateInfo] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
    public static NetworkStateInfo i(Context context) {
        NetworkStateInfo networkStateInfo;
        ?? e = NetworkStateInfo.UNAVAIL;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!activeNetworkInfo.isAvailable()) {
                networkStateInfo = NetworkStateInfo.UNAVAIL;
                try {
                    e = "NetWorkCore";
                    av.a("NetWorkCore", "NetworkStateInfo", "UNAVAIL");
                } catch (Exception e2) {
                    e = e2;
                }
            } else if (activeNetworkInfo.getType() == 1) {
                av.a("NetWorkCore", "NetworkStateInfo", "WIFI");
                networkStateInfo = NetworkStateInfo.WIFI;
            } else {
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 0:
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        av.a("NetWorkCore", "NetworkStateInfo", "TwoG");
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
                        av.a("NetWorkCore", "NetworkStateInfo", "ThreeG");
                        networkStateInfo = NetworkStateInfo.ThreeG;
                        break;
                    default:
                        av.a("NetWorkCore", "NetworkStateInfo-default", "TwoG");
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
}
