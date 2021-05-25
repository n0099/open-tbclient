package com.baidu.wallet.passport;

import android.content.Context;
import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.core.Domains;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import org.json.JSONException;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f24990a = {Domains.DU_XIAO_MAN_PAY, Domains.DU_XIAO_MAN, Domains.BAIFUBAO, ".8.baidu.com"};

    /* renamed from: b  reason: collision with root package name */
    public static final int f24991b = 8;

    /* renamed from: c  reason: collision with root package name */
    public Context f24992c;

    /* renamed from: d  reason: collision with root package name */
    public String f24993d;

    /* renamed from: com.baidu.wallet.passport.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0245a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f24994a = new a();
    }

    private void a(int i2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(1, i2);
        Date time = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        this.f24993d = simpleDateFormat.format(time);
        LogUtil.d("--DxmCookieManager---cookie----expires--->" + this.f24993d);
    }

    public void b() {
        a(-8, "");
    }

    public a() {
        this.f24992c = BaiduWalletDelegate.getInstance().getAppContext();
    }

    private String[] b(String str) {
        try {
            return (String[]) JsonUtils.fromJson(str, String[].class);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static a a() {
        return C0245a.f24994a;
    }

    public void a(String str) {
        a(8, str);
    }

    private void a(int i2, String str) {
        try {
            a(i2);
            String[] b2 = b(SdkInitResponse.getInstance().getCookiesSyncDomainList(this.f24992c));
            if (b2 == null) {
                b2 = f24990a;
            }
            CookieSyncManager.createInstance(this.f24992c);
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            String str2 = "OPENBDUSS=" + str;
            String str3 = ";expires=" + this.f24993d;
            LogUtil.d("------------------DxmCookieManager start setCookie--------------");
            for (String str4 : b2) {
                if (!str4.startsWith(".")) {
                    str4 = "." + str4;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(";path=/");
                sb.append(str3);
                sb.append(";domain=");
                sb.append(str4);
                sb.append(";httponly");
                sb.append(";secure");
                LogUtil.d("---DxmCookieManager---setCookie value--->" + sb.toString());
                cookieManager.setCookie(str4, sb.toString());
            }
            if (Build.VERSION.SDK_INT < 21) {
                CookieSyncManager.getInstance().sync();
            } else {
                cookieManager.flush();
            }
        } catch (Exception e2) {
            LogUtil.d(e2.getMessage());
        }
    }
}
