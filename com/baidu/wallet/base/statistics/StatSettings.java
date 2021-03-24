package com.baidu.wallet.base.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.restnet.RestRuntimeException;
import com.baidu.apollon.restnet.RestTemplate;
import com.baidu.apollon.restnet.converter.b;
import com.baidu.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.baidu.apollon.restnet.rest.d;
import com.baidu.apollon.statistics.Config;
import com.baidu.apollon.statistics.StatisticsSettings;
import com.baidu.bankdetection.BuildConfig;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.core.DebugConfig;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.UAFilterUtil;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class StatSettings extends StatisticsSettings {
    public static final String BDUSS = "bs";
    public static final String BDUSS_KEY = "bk";
    public static final String CUID = "cu2";
    public static final String CUID_SEC = "cu";
    public static final String GET_STRATETY_URL = "/callback";
    public static final String LOCATION = "lc";
    public static final String LOG_SEND_URL = "/chanpin_stat";
    public static final String OPERATOR = "op";
    public static final String SSID = "sd";
    public static final String UA = "ua";
    public static final String UNIONID = "union_id";

    /* renamed from: a  reason: collision with root package name */
    public boolean f23695a;

    /* renamed from: b  reason: collision with root package name */
    public String f23696b;

    /* renamed from: c  reason: collision with root package name */
    public String f23697c;

    /* renamed from: d  reason: collision with root package name */
    public Context f23698d;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static StatSettings f23700a = new StatSettings();
    }

    private void a(Context context) {
        if (this.f23698d != null || context == null) {
            return;
        }
        this.f23698d = context.getApplicationContext();
    }

    public static StatSettings getInstance(Context context) {
        a.f23700a.a(context);
        return a.f23700a;
    }

    @Override // com.baidu.apollon.statistics.StatisticsSettings
    public String getCommonHeader() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.baidu.wallet.base.statistics.a a2 = com.baidu.wallet.base.statistics.a.a();
            jSONObject.putOpt("ua", a2.c(this.f23698d));
            jSONObject.putOpt("cu", a2.a(this.f23698d));
            jSONObject.put("cu2", a2.b(this.f23698d));
            jSONObject.putOpt("op", a2.d(this.f23698d));
            jSONObject.putOpt("bs", a2.e(this.f23698d));
            jSONObject.putOpt("bk", a2.f(this.f23698d));
            jSONObject.putOpt("sd", a2.h(this.f23698d));
            jSONObject.putOpt(UNIONID, a2.b());
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.baidu.apollon.statistics.StatisticsSettings
    public String getCrashDataHeader() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Config.m, SafePay.getInstance().encryptProxy(WalletLoginHelper.getInstance().getPassUid()));
            jSONObject.put(Config.n, SafePay.getInstance().getpwProxy());
            return jSONObject.toString();
        } catch (Throwable th) {
            LogUtil.d("wallet_stastics", th.toString());
            return null;
        }
    }

    @Override // com.baidu.apollon.statistics.StatisticsSettings
    public String getPackagesConcerned() {
        if (this.f23696b == null) {
            this.f23696b = "com.baidu.wallet.pay,com.baidu.wallet.balance," + BuildConfig.APPLICATION_ID + ",com.baidu.wallet.fastpay,com.baidu.wallet.home,com.baidu.wallet.paysdk,com.baidu.wallet.personal,com.baidu.wallet.scancode,com.baidu.wallet.transfer,com.baidu.wallet,com.baidu.android.pay,com.baidu.android.lbspay";
        }
        return this.f23696b;
    }

    @Override // com.baidu.apollon.statistics.StatisticsSettings
    public String getStrategy() {
        return a(this.f23698d, 0, DebugConfig.getInstance(this.f23698d).getStatStrategyHost() + GET_STRATETY_URL);
    }

    @Override // com.baidu.apollon.statistics.StatisticsSettings
    public String getUploadUrl() {
        return DebugConfig.getInstance().getStatisticsHost() + LOG_SEND_URL;
    }

    @Override // com.baidu.apollon.statistics.StatisticsSettings
    public boolean isEnableCrashHandler() {
        return true;
    }

    @Override // com.baidu.apollon.statistics.StatisticsSettings
    public boolean isForbidToUploadNow() {
        return false;
    }

    @Override // com.baidu.apollon.statistics.StatisticsSettings
    public boolean isReleaseVersion() {
        return this.f23695a;
    }

    public void setReleaseVesionFlag(boolean z) {
        this.f23695a = z;
    }

    public StatSettings() {
        this.f23695a = true;
        this.f23696b = null;
    }

    private String a(Context context, int i, String str) {
        String str2;
        RestTemplate restTemplate = new RestTemplate(context, UAFilterUtil.getInstance().getTrueUA(context), "stastics bean http request");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("cmd", "2201"));
        arrayList.add(new RestNameValuePair("callback", "productReportStrategy"));
        String c2 = com.baidu.wallet.base.statistics.a.a().c(context);
        if (!TextUtils.isEmpty(c2)) {
            arrayList.add(new RestNameValuePair("ua", c2));
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new RestHttpRequestInterceptor() { // from class: com.baidu.wallet.base.statistics.StatSettings.1
            @Override // com.baidu.apollon.restnet.rest.RestHttpRequestInterceptor
            public void intercept(Context context2, d dVar) {
                dVar.a().a("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
            }
        });
        restTemplate.setRequestInterceptor(arrayList2);
        restTemplate.setMessageConverter(new b());
        String str3 = null;
        try {
            if (i == 0) {
                str2 = (String) restTemplate.a(str, arrayList, "utf-8", String.class);
            } else {
                str2 = (String) restTemplate.c(str, arrayList, "utf-8", String.class);
            }
            str3 = str2;
            return str3;
        } catch (RestRuntimeException e2) {
            e2.printStackTrace();
            return str3;
        }
    }
}
