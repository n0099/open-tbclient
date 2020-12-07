package com.baidu.yuyinala.privatemessage.implugin.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.style.ClickableSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.sdk.WebView;
import com.baidu.yuyinala.privatemessage.implugin.d.b;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {
    @SuppressLint({"UseSparseArrays"})
    private static Map<Long, Long> oVv = new HashMap();

    public static String g(Context context, long j) {
        SimpleDateFormat simpleDateFormat;
        SimpleDateFormat simpleDateFormat2;
        SimpleDateFormat simpleDateFormat3;
        Calendar calendar;
        long currentTimeMillis = System.currentTimeMillis();
        if (Long.valueOf(j).toString().length() == 10) {
            j *= 1000;
        }
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        String str = "";
        if (hu(context)) {
            simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.CHINA);
        } else {
            str = h(context, j) + " ";
            simpleDateFormat = new SimpleDateFormat("hh:mm", Locale.CHINA);
        }
        simpleDateFormat.setTimeZone(timeZone);
        if (a(Long.valueOf(currentTimeMillis), j)) {
            return str + simpleDateFormat.format(new Date(j));
        }
        if (b(Long.valueOf(currentTimeMillis), j)) {
            return "昨天 " + str + simpleDateFormat.format(new Date(j));
        }
        if (c(Long.valueOf(currentTimeMillis), j)) {
            Calendar.getInstance().setTimeInMillis(j);
            return Px(calendar.get(7)) + " " + str + simpleDateFormat.format(new Date(j));
        } else if (d(Long.valueOf(currentTimeMillis), j) || e(Long.valueOf(currentTimeMillis), j)) {
            new SimpleDateFormat("MM-dd ", Locale.CHINA).setTimeZone(timeZone);
            return simpleDateFormat2.format(new Date(j)) + str + simpleDateFormat.format(new Date(j));
        } else {
            new SimpleDateFormat("yyyy-MM-dd ", Locale.CHINA).setTimeZone(timeZone);
            return simpleDateFormat3.format(new Date(j)) + str + simpleDateFormat.format(new Date(j));
        }
    }

    private static String Px(int i) {
        switch (i) {
            case 1:
                return "星期日";
            case 2:
                return "星期一";
            case 3:
                return "星期二";
            case 4:
                return "星期三";
            case 5:
                return "星期四";
            case 6:
                return "星期五";
            case 7:
                return "星期六";
            default:
                return "星期一";
        }
    }

    private static boolean hu(Context context) {
        return DateFormat.is24HourFormat(context);
    }

    private static String h(Context context, long j) {
        int hours = new Date(j).getHours();
        if (hours >= 5 && hours < 12) {
            return "上午";
        }
        if (hours >= 12 && hours < 19) {
            return "下午";
        }
        if (hours >= 19 && hours < 24) {
            return "晚上";
        }
        return "凌晨";
    }

    private static boolean a(Long l, long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l.longValue());
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j);
        return calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    private static boolean b(Long l, long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l.longValue());
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j);
        calendar2.add(6, 1);
        return calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    private static boolean c(Long l, long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l.longValue());
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.add(6, -6);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTimeInMillis(l.longValue());
        return calendar2.after(calendar) && calendar2.before(calendar3);
    }

    private static boolean d(Long l, long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l.longValue());
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.add(6, -29);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTimeInMillis(l.longValue());
        return calendar2.after(calendar) && calendar2.before(calendar3);
    }

    private static boolean e(Long l, long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l.longValue());
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j);
        return calendar.get(1) == calendar2.get(1);
    }

    public static String i(Context context, long j) {
        if (Long.valueOf(j).toString().length() == 10) {
            j *= 1000;
        }
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日", Locale.CHINA);
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(new Date(j));
    }

    public static void e(Context context, View view) {
        if (context != null && view != null) {
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void f(Context context, View view) {
        view.requestFocus();
        ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 1);
    }

    public static int dip2px(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static int dp2px(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 55;
    }

    public static long enS() {
        long j = 0;
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                if (Build.VERSION.SDK_INT >= 18) {
                    j = (statFs.getAvailableBytes() / 1024) / 1024;
                } else {
                    j = ((statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1024) / 1024;
                }
                c.d("Utils", "free size " + j);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return j;
    }

    public static boolean hv(Context context) {
        long h = com.baidu.yuyinala.privatemessage.implugin.util.b.b.h(context, "check_sdcard", 0L);
        return h == 0 || (System.currentTimeMillis() / 1000) - h > 18000;
    }

    public static String replaceToHttps(String str) {
        return str.replace("http://", SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    public static boolean c(Date date, Date date2) {
        if (date == null || date2 == null) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date2);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date);
        return calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5);
    }

    public static Spannable c(final Context context, CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            Matcher matcher = Pattern.compile("((([A-Za-z]{3,9}:(?:\\/\\/)?)(?:[-;:&=\\+\\$,A-Za-z0-9_]+@)?[A-Za-z0-9.-]+(:[0-9]+)?|(?:www.|[-;:&=\\+\\$,A-Za-z0-9_]+@)[A-Za-z0-9.-_]+)((?:\\/[\\+~%\\/.A-Za-z0-9_-]*)?\\??(?:[-\\+=&;%@.A-Za-z0-9_]*)#?(?:[A-Za-z0-9_-]*))?)").matcher(charSequence);
            SpannableString spannableString = new SpannableString(charSequence);
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                final String group = matcher.group();
                spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.yuyinala.privatemessage.implugin.util.f.1
                    @Override // android.text.style.ClickableSpan
                    public void onClick(View view) {
                        try {
                            String str = group;
                            if (Pattern.compile(EditTextPasteFilterUtils.REGX_EMAIL, 2).matcher(group).matches()) {
                                str = WebView.SCHEME_MAILTO + group;
                            }
                            if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SMS) || str.startsWith(WebView.SCHEME_MAILTO) || str.startsWith("tel:")) {
                                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                                return;
                            }
                            com.baidu.yuyinala.privatemessage.implugin.d.b.elg().h(context, str, false);
                        } catch (Exception e) {
                            c.e("Utils", "ex " + e.getMessage());
                        }
                    }
                }, start, end, 33);
            }
            return spannableString;
        }
        return null;
    }

    public static void b(b.d dVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pluginName", "百度轻客服");
            jSONObject.put("loginSrc", "hudong_immenu");
            jSONObject.put("loginMode", 1);
            jSONObject.put("oauth", "");
            jSONObject.put("needUserSetting", false);
            jSONObject.put("thirdLogin", false);
            com.baidu.yuyinala.privatemessage.implugin.d.b.elg().a(jSONObject.toString(), dVar);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void emy() {
        com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.a emE = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.emz().emE();
        if (emE != null) {
            emE.emy();
        }
    }

    public static int dt(Context context) {
        try {
            if (context.getResources().getIdentifier("config_showNavigationBar", "bool", "android") != 0) {
                return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("navigation_bar_height", "dimen", "android"));
            }
        } catch (Exception e) {
            LogUtils.e("Utils", "getBottomBarHeight" + e.getMessage());
        }
        return 0;
    }
}
