package com.baidu.wallet.base.statistics;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.UAFilterUtil;
import com.baidu.wallet.utils.NetUtils;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23476a = "a";

    /* renamed from: b  reason: collision with root package name */
    public Pattern f23477b;

    /* renamed from: com.baidu.wallet.base.statistics.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0232a {

        /* renamed from: a  reason: collision with root package name */
        public static a f23478a = new a();
    }

    public static a a() {
        return C0232a.f23478a;
    }

    public String b(Context context) {
        try {
        } catch (Exception e2) {
            e = e2;
        }
        try {
            return this.f23477b.matcher(PhoneUtils.getCUID2(context)).replaceAll("");
        } catch (Exception e3) {
            e = e3;
            LogUtil.d(f23476a, e.getMessage());
            return null;
        }
    }

    public String c(Context context) {
        try {
            return UAFilterUtil.getInstance().getTrueUA(context);
        } catch (Exception unused) {
            return null;
        }
    }

    public String d(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        } catch (Exception e2) {
            LogUtil.d(f23476a, e2.getMessage());
            return null;
        }
    }

    public String e(Context context) {
        try {
            if (AccountManager.getInstance(context).getLoginType() == 0) {
                String bduss = AccountManager.getInstance(context).getBduss();
                if (bduss != null) {
                    bduss = SafePay.getInstance().encryptProxy(bduss);
                }
                return bduss;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public String f(Context context) {
        if (AccountManager.getInstance(context).getLoginType() == 0) {
            return SafePay.getInstance().getpwProxy();
        }
        return null;
    }

    public String g(Context context) {
        String gPSLocation = PhoneUtils.getGPSLocation(context);
        if (TextUtils.isEmpty(gPSLocation)) {
            return null;
        }
        return SafePay.getInstance().encryptProxy(gPSLocation);
    }

    public String h(Context context) {
        JSONObject connectedWifi = NetUtils.getConnectedWifi(context);
        if (connectedWifi != null) {
            String optString = connectedWifi.optString("ssid", null);
            return optString != null ? SafePay.getInstance().encryptProxy(optString) : optString;
        }
        return null;
    }

    public a() {
        this.f23477b = Pattern.compile("\\s*|\t|\r|\n");
    }

    public String a(Context context) {
        try {
        } catch (Exception e2) {
            e = e2;
        }
        try {
            return this.f23477b.matcher(PhoneUtils.getCUID(context)).replaceAll("");
        } catch (Exception e3) {
            e = e3;
            LogUtil.d(f23476a, e.getMessage());
            return null;
        }
    }

    public String b() {
        String unionId = WalletLoginHelper.getInstance().getUnionId();
        return TextUtils.isEmpty(unionId) ? "" : SafePay.getInstance().encryptProxy(unionId);
    }
}
