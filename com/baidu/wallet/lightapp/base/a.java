package com.baidu.wallet.lightapp.base;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.Base64Utils;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.Domains;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f24510a;

    /* renamed from: com.baidu.wallet.lightapp.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0237a {

        /* renamed from: a  reason: collision with root package name */
        public static a f24511a = new a();
    }

    public static a a() {
        return C0237a.f24511a;
    }

    public a() {
        this.f24510a = -1;
    }

    public void a(Context context) {
        try {
            CookieSyncManager.createInstance(context);
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            StringBuilder sb = new StringBuilder();
            sb.append("STDCJUVF=");
            sb.append(Base64Utils.encodeToString(("{\"ua\":\"" + BussinessUtils.getUA(context) + "\",\"cu\":\"" + PhoneUtils.getCUID(context) + "\",\"cu2\":\"" + PhoneUtils.getCUID2(context) + "\"}").getBytes()));
            String sb2 = sb.toString();
            String[] strArr = {Domains.BAIDU, Domains.BAIFUBAO, Domains.DU_XIAO_MAN, Domains.DU_XIAO_MAN_PAY, "duxiaoman-int.com"};
            for (int i2 = 0; i2 < 5; i2++) {
                String str = strArr[i2];
                cookieManager.setCookie(str, sb2 + ";path=/;domain=" + str + ";secure;httponly");
            }
            String str2 = "" + System.currentTimeMillis();
            String str3 = SafePay.getInstance().getpwProxy();
            String encryptProxy = SafePay.getInstance().encryptProxy(str2);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("TIMETOKEN=");
            sb3.append(Base64Utils.encodeToString(("{\"timestamp\":\"" + str2 + "\",\"key\":\"" + str3 + "\",\"timeencrypt\":\"" + encryptProxy + "\"}").getBytes()));
            String sb4 = sb3.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb4);
            sb5.append(";domain=" + DomainConfig.getInstance().getAppHost().substring(8));
            sb5.append(";path=/walletapp/misc/");
            sb5.append(";secure");
            sb5.append(";httponly");
            cookieManager.setCookie(DomainConfig.getInstance().getAppHost() + "/walletapp/misc/jump", sb5.toString());
            CookieSyncManager.getInstance().sync();
        } catch (Exception unused) {
        }
    }

    public int a(Context context, String str, int i2) {
        int bdussState = WalletLoginHelper.getInstance().getBdussState();
        if (i2 != bdussState && (bdussState == 0 || bdussState == 3 || bdussState == 4)) {
            WalletLoginHelper.getInstance().getOpenBduss(false, null);
        }
        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.SYNC_WEB_LOGIN_STATUS_TO_NATIVE, Arrays.asList(str));
        PayStatisticsUtil.onEventWithValue(LightAppStatEvent.SYNC_WEB_LOGIN_STATUS_TO_NATIVE, str);
        if (WalletLoginHelper.getInstance().getSyncLoginListener() == null) {
            return bdussState;
        }
        WalletLoginHelper.getInstance().syncH5LoginStatus(context);
        return bdussState;
    }
}
