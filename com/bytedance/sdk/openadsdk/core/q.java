package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.parser.JSONLexer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.JProtect;
import com.bytedance.sdk.component.net.NetResponse;
import com.bytedance.sdk.component.net.callback.NetCallback;
import com.bytedance.sdk.component.net.executor.GetExecutor;
import com.bytedance.sdk.component.net.executor.NetExecutor;
import com.bytedance.sdk.component.net.executor.PostExecutor;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.AppLogHelper;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.PersonalizationPrompt;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.core.p;
import com.google.zxing.maxicode.decoder.DecodedBitStreamParser;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.io.File;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class q implements p<com.bytedance.sdk.openadsdk.e.a> {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f30474b = null;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f30475h = true;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.e.t f30476a;

    /* renamed from: c  reason: collision with root package name */
    public final Context f30477c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f30478d;

    /* renamed from: e  reason: collision with root package name */
    public final String f30479e;

    /* renamed from: f  reason: collision with root package name */
    public long f30480f;

    /* renamed from: g  reason: collision with root package name */
    public int f30481g;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f30507a;

        /* renamed from: b  reason: collision with root package name */
        public final long f30508b;

        /* renamed from: c  reason: collision with root package name */
        public final long f30509c;

        /* renamed from: d  reason: collision with root package name */
        public final int f30510d;

        /* renamed from: e  reason: collision with root package name */
        public final String f30511e;

        /* renamed from: f  reason: collision with root package name */
        public final int f30512f;

        /* renamed from: g  reason: collision with root package name */
        public final String f30513g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.core.e.a f30514h;

        /* renamed from: i  reason: collision with root package name */
        public final String f30515i;

        public a(String str, int i2, int i3, String str2, int i4, String str3, @Nullable com.bytedance.sdk.openadsdk.core.e.a aVar, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), str2, Integer.valueOf(i4), str3, aVar, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30507a = i2;
            this.f30510d = i3;
            this.f30511e = str2;
            this.f30513g = str3;
            this.f30514h = aVar;
            this.f30515i = str;
            this.f30512f = i4;
            this.f30508b = j;
            this.f30509c = j2;
        }

        public static a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) ? a(jSONObject, null, null) : (a) invokeL.objValue;
        }

        public static a a(JSONObject jSONObject, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.e.n nVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, jSONObject, adSlot, nVar)) == null) {
                String optString = jSONObject.optString("did");
                int optInt = jSONObject.optInt("processing_time_ms");
                long optLong = jSONObject.optLong("s_receive_ts");
                long optLong2 = jSONObject.optLong("s_send_ts");
                int optInt2 = jSONObject.optInt("status_code");
                String optString2 = jSONObject.optString("desc");
                String optString3 = jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
                int optInt3 = jSONObject.optInt("reason");
                com.bytedance.sdk.openadsdk.core.e.a a2 = com.bytedance.sdk.openadsdk.core.b.a(jSONObject, adSlot, nVar);
                if (a2 != null) {
                    a2.a(jSONObject.optLong("request_after"));
                }
                return new a(optString, optInt, optInt2, optString2, optInt3, optString3, a2, optLong, optLong2);
            }
            return (a) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f30516a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f30517b;

        public b(int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30516a = i2;
            this.f30517b = z;
        }

        public static b a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                return new b(jSONObject.optInt("error_code"), jSONObject.optBoolean("result"));
            }
            return (b) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f30518a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f30519b;

        /* renamed from: c  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.core.e.w f30520c;

        public c(int i2, boolean z, com.bytedance.sdk.openadsdk.core.e.w wVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Boolean.valueOf(z), wVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30518a = i2;
            this.f30519b = z;
            this.f30520c = wVar;
        }

        public static c a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                int optInt = jSONObject.optInt("code");
                boolean optBoolean = jSONObject.optBoolean(SmsLoginView.f.j);
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                com.bytedance.sdk.openadsdk.core.e.w wVar = new com.bytedance.sdk.openadsdk.core.e.w();
                if (optJSONObject != null) {
                    try {
                        wVar.a(optJSONObject.optInt("reason"));
                        wVar.b(optJSONObject.optInt("corp_type"));
                        wVar.c(optJSONObject.optInt("reward_amount"));
                        wVar.a(optJSONObject.optString("reward_name"));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                return new c(optInt, optBoolean, wVar);
            }
            return (c) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(210335013, "Lcom/bytedance/sdk/openadsdk/core/q;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(210335013, "Lcom/bytedance/sdk/openadsdk/core/q;");
        }
    }

    public q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f30477c = context;
        this.f30478d = e();
        this.f30479e = h();
    }

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? i2 != 120 ? i2 != 160 ? i2 != 240 ? i2 != 320 ? i2 != 480 ? i2 != 640 ? "mdpi" : "xxxhdpi" : "xxhdpi" : "xhdpi" : "hdpi" : "mdpi" : "ldpi" : (String) invokeI.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            TTCustomController f2 = h.d().f();
            if (f2 == null || f2.isCanUsePhoneState()) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    return telephonyManager == null ? "" : telephonyManager.getSimOperator();
                } catch (Throwable unused) {
                    return "";
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x017c, code lost:
        if (r15.f30103d == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x017e, code lost:
        r9 = r13.getAdCount();
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0196 A[Catch: Exception -> 0x01b2, TryCatch #0 {Exception -> 0x01b2, blocks: (B:5:0x000b, B:7:0x0042, B:9:0x004c, B:11:0x0056, B:33:0x00ed, B:35:0x00f6, B:36:0x00fa, B:41:0x011b, B:45:0x0147, B:53:0x0160, B:55:0x0164, B:56:0x016b, B:63:0x017a, B:65:0x017e, B:66:0x0182, B:68:0x0196, B:70:0x019d, B:72:0x01a3, B:75:0x01ae, B:51:0x0159, B:37:0x0102, B:39:0x0107, B:32:0x00d4, B:40:0x0113, B:27:0x00b0, B:13:0x005c, B:15:0x006b, B:16:0x0074, B:18:0x007e, B:19:0x0087, B:21:0x008d, B:22:0x0096), top: B:82:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JSONObject a(AdSlot adSlot, int i2, com.bytedance.sdk.openadsdk.core.e.n nVar) {
        InterceptResult invokeLIL;
        int i3;
        int imgAcceptedWidth;
        int adCount;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(AdIconUtil.AD_TEXT_ID, this, adSlot, i2, nVar)) == null) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("id", adSlot.getCodeId());
                jSONObject3.put("prime_rit", adSlot.getPrimeRit());
                jSONObject3.put("show_seq", adSlot.getAdloadSeq());
                jSONObject3.put("adtype", i2);
                jSONObject3.put("themeStatus", h.d().A());
                if (!TextUtils.isEmpty(adSlot.getAdId()) || !TextUtils.isEmpty(adSlot.getCreativeId()) || !TextUtils.isEmpty(adSlot.getExt()) || com.bytedance.sdk.openadsdk.p.a.a()) {
                    JSONObject jSONObject4 = new JSONObject();
                    if (!TextUtils.isEmpty(adSlot.getAdId())) {
                        jSONObject4.put(LegoListActivityConfig.AD_ID, adSlot.getAdId());
                    }
                    if (!TextUtils.isEmpty(adSlot.getCreativeId())) {
                        jSONObject4.put("creative_id", adSlot.getCreativeId());
                    }
                    if (adSlot.getExt() != null) {
                        jSONObject4.put("ext", adSlot.getExt());
                    }
                    com.bytedance.sdk.openadsdk.p.a.a(jSONObject4, adSlot.getCodeId());
                    jSONObject3.put("preview_ads", jSONObject4);
                }
                if ((i2 == 3 || i2 == 4) && nVar != null) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("publisher_timeout_control", nVar.f30106g);
                    jSONObject5.put("time_out_control", nVar.f30107h);
                    jSONObject5.put("time_out", nVar.f30108i);
                    jSONObject3.put("splash_time", jSONObject5);
                }
                i3 = 1;
            } catch (Exception unused) {
            }
            if (nVar != null) {
                if (i2 == 3 || i2 == 4) {
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("publisher_timeout_control", nVar.f30106g);
                    jSONObject6.put("time_out_control", nVar.f30107h);
                    jSONObject6.put("time_out", nVar.f30108i);
                    jSONObject3.put("tmax", jSONObject6);
                }
                jSONObject3.put("render_method", nVar.f30104e);
                if (nVar.f30104e != 1) {
                    if (nVar.f30104e == 2) {
                        a(jSONObject3, "accepted_size", adSlot.getExpressViewAcceptedWidth(), adSlot.getExpressViewAcceptedHeight());
                    }
                    jSONObject3.put("ptpl_ids", o.h().h(adSlot.getCodeId()));
                    jSONObject3.put(IAdRequestParam.POS, AdSlot.getPosition(i2));
                    jSONObject3.put("is_support_dpl", adSlot.isSupportDeepLink());
                    jSONObject3.put("if_support_render_control", !adSlot.isSupportRenderConrol() ? 1 : 0);
                    if (adSlot.getNativeAdType() <= 0 || i2 == 9 || i2 == 5) {
                        jSONObject3.put("is_origin_ad", true);
                    }
                    if (nVar != null && nVar.j != null) {
                        jSONObject3.put("session_params", nVar.j);
                    }
                    adCount = adSlot.getAdCount();
                    if (i2 != 7 && i2 != 8) {
                        i3 = adCount;
                    }
                    jSONObject3.put("ad_count", i3);
                    String l = com.bytedance.sdk.openadsdk.r.o.l(adSlot.getExtraSmartLookParam());
                    jSONObject = TextUtils.isEmpty(l) ? null : new JSONObject(l);
                    if (jSONObject != null && (jSONObject2 = jSONObject.getJSONObject("smart_look")) != null && !TextUtils.isEmpty(jSONObject2.toString())) {
                        jSONObject3.put("smart_look", jSONObject2);
                    }
                    return jSONObject3;
                }
                imgAcceptedWidth = adSlot.getImgAcceptedWidth();
            } else {
                jSONObject3.put("render_method", 1);
                imgAcceptedWidth = adSlot.getImgAcceptedWidth();
            }
            a(jSONObject3, "accepted_size", imgAcceptedWidth, adSlot.getImgAcceptedHeight());
            jSONObject3.put("ptpl_ids", o.h().h(adSlot.getCodeId()));
            jSONObject3.put(IAdRequestParam.POS, AdSlot.getPosition(i2));
            jSONObject3.put("is_support_dpl", adSlot.isSupportDeepLink());
            jSONObject3.put("if_support_render_control", !adSlot.isSupportRenderConrol() ? 1 : 0);
            if (adSlot.getNativeAdType() <= 0) {
            }
            jSONObject3.put("is_origin_ad", true);
            if (nVar != null) {
                jSONObject3.put("session_params", nVar.j);
            }
            adCount = adSlot.getAdCount();
            if (i2 != 7) {
                i3 = adCount;
            }
            jSONObject3.put("ad_count", i3);
            String l2 = com.bytedance.sdk.openadsdk.r.o.l(adSlot.getExtraSmartLookParam());
            if (TextUtils.isEmpty(l2)) {
            }
            if (jSONObject != null) {
                jSONObject3.put("smart_look", jSONObject2);
            }
            return jSONObject3;
        }
        return (JSONObject) invokeLIL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007b A[Catch: all -> 0x00a7, TryCatch #1 {all -> 0x00a7, blocks: (B:29:0x0053, B:32:0x006f, B:34:0x007b, B:35:0x0098), top: B:68:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d0 A[Catch: Exception -> 0x017d, TryCatch #0 {Exception -> 0x017d, blocks: (B:8:0x001e, B:10:0x0025, B:13:0x002e, B:18:0x003c, B:20:0x0040, B:21:0x0042, B:36:0x00a7, B:38:0x00d0, B:40:0x00da, B:42:0x00e0, B:44:0x00e7, B:46:0x00ed, B:47:0x00f6, B:49:0x0100, B:50:0x010d, B:53:0x0157, B:54:0x0167, B:56:0x0172, B:58:0x0176, B:25:0x004c, B:27:0x0050, B:14:0x0031), top: B:67:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0172 A[Catch: Exception -> 0x017d, TryCatch #0 {Exception -> 0x017d, blocks: (B:8:0x001e, B:10:0x0025, B:13:0x002e, B:18:0x003c, B:20:0x0040, B:21:0x0042, B:36:0x00a7, B:38:0x00d0, B:40:0x00da, B:42:0x00e0, B:44:0x00e7, B:46:0x00ed, B:47:0x00f6, B:49:0x0100, B:50:0x010d, B:53:0x0157, B:54:0x0167, B:56:0x0172, B:58:0x0176, B:25:0x004c, B:27:0x0050, B:14:0x0031), top: B:67:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0176 A[Catch: Exception -> 0x017d, TRY_LEAVE, TryCatch #0 {Exception -> 0x017d, blocks: (B:8:0x001e, B:10:0x0025, B:13:0x002e, B:18:0x003c, B:20:0x0040, B:21:0x0042, B:36:0x00a7, B:38:0x00d0, B:40:0x00da, B:42:0x00e0, B:44:0x00e7, B:46:0x00ed, B:47:0x00f6, B:49:0x0100, B:50:0x010d, B:53:0x0157, B:54:0x0167, B:56:0x0172, B:58:0x0176, B:25:0x004c, B:27:0x0050, B:14:0x0031), top: B:67:0x001e }] */
    @Keep
    @JProtect
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JSONObject a(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.e.n nVar, int i2, boolean z) {
        InterceptResult invokeCommon;
        String c2;
        int i3;
        JSONObject e2;
        long currentTimeMillis;
        String str;
        String h2;
        String i4;
        String w;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{adSlot, nVar, Integer.valueOf(i2), Boolean.valueOf(z)})) != null) {
            return (JSONObject) invokeCommon.objValue;
        }
        char c3 = '(';
        while (true) {
            switch (c3) {
                case '(':
                case ')':
                default:
                    c3 = '*';
                case '*':
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (nVar != null && !TextUtils.isEmpty(nVar.f30100a)) {
                            c2 = nVar.f30100a;
                            if (i2 != 7) {
                                if (nVar != null && nVar.f30101b > 0) {
                                    i3 = nVar.f30101b;
                                    jSONObject.put("req_type", i3);
                                }
                                try {
                                    h2 = o.h().h();
                                    i4 = o.h().i();
                                    w = h.d().w();
                                    if (h2 != null && i4 != null) {
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("version", h2);
                                        if (adSlot != null) {
                                            String a2 = com.bytedance.sdk.openadsdk.o.g.d.a(adSlot.getExternalABVid());
                                            jSONObject2.put("external_ab_vid", a2);
                                            com.bytedance.sdk.component.utils.j.c("NetApiImpl", "external_ab_vid ", a2);
                                        }
                                        jSONObject2.put("param", i4);
                                        jSONObject2.put("tob_ab_sdk_version", w);
                                        jSONObject.put("abtest", jSONObject2);
                                    }
                                } catch (Throwable unused) {
                                }
                                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, c2);
                                jSONObject.put("ad_sdk_version", "3.6.1.3");
                                jSONObject.put("source_type", "app");
                                jSONObject.put("logsdk_version", AppLogHelper.getInstance().getSdkVersion());
                                jSONObject.put("app", b());
                                e2 = com.bytedance.sdk.openadsdk.core.k.c.e(this.f30477c);
                                if (e2 != null) {
                                    if (!o.h().w() && !com.bytedance.sdk.openadsdk.downloadnew.a.g.b()) {
                                        e2.remove(PmsConstant.EnvParam.Key.FREE_SPACE);
                                    }
                                    if (adSlot != null && adSlot.getOrientation() > 0) {
                                        e2.put("orientation", adSlot.getOrientation());
                                    }
                                    if (r.c() > 0) {
                                        e2.put("screenshot_time", String.valueOf(r.c()));
                                    }
                                }
                                jSONObject.put("device", e2);
                                jSONObject.put("user", b(adSlot));
                                jSONObject.put("ua", com.bytedance.sdk.openadsdk.r.o.b());
                                jSONObject.put("ip", c());
                                JSONArray jSONArray = new JSONArray();
                                jSONArray.put(a(adSlot, i2, nVar));
                                jSONObject.put("adslots", jSONArray);
                                a(jSONObject, nVar);
                                currentTimeMillis = System.currentTimeMillis() / 1000;
                                jSONObject.put("ts", currentTimeMillis);
                                str = "";
                                if (adSlot.getCodeId() != null && c2 != null) {
                                    str = String.valueOf(currentTimeMillis).concat(adSlot.getCodeId()).concat(c2);
                                }
                                jSONObject.put("req_sign", com.bytedance.sdk.component.utils.e.a(str));
                                if (!z) {
                                    jSONObject.put("ad_sdk_version", "3.6.1.3");
                                    return jSONObject;
                                }
                                JSONObject a3 = com.bytedance.sdk.component.utils.a.a(jSONObject);
                                a3.put("ad_sdk_version", "3.6.1.3");
                                return a3;
                            }
                            if (i2 == 8 && nVar != null && nVar.f30102c > 0) {
                                i3 = nVar.f30102c;
                                jSONObject.put("req_type", i3);
                            }
                            h2 = o.h().h();
                            i4 = o.h().i();
                            w = h.d().w();
                            if (h2 != null) {
                                JSONObject jSONObject22 = new JSONObject();
                                jSONObject22.put("version", h2);
                                if (adSlot != null) {
                                }
                                jSONObject22.put("param", i4);
                                jSONObject22.put("tob_ab_sdk_version", w);
                                jSONObject.put("abtest", jSONObject22);
                            }
                            jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, c2);
                            jSONObject.put("ad_sdk_version", "3.6.1.3");
                            jSONObject.put("source_type", "app");
                            jSONObject.put("logsdk_version", AppLogHelper.getInstance().getSdkVersion());
                            jSONObject.put("app", b());
                            e2 = com.bytedance.sdk.openadsdk.core.k.c.e(this.f30477c);
                            if (e2 != null) {
                            }
                            jSONObject.put("device", e2);
                            jSONObject.put("user", b(adSlot));
                            jSONObject.put("ua", com.bytedance.sdk.openadsdk.r.o.b());
                            jSONObject.put("ip", c());
                            JSONArray jSONArray2 = new JSONArray();
                            jSONArray2.put(a(adSlot, i2, nVar));
                            jSONObject.put("adslots", jSONArray2);
                            a(jSONObject, nVar);
                            currentTimeMillis = System.currentTimeMillis() / 1000;
                            jSONObject.put("ts", currentTimeMillis);
                            str = "";
                            if (adSlot.getCodeId() != null) {
                                str = String.valueOf(currentTimeMillis).concat(adSlot.getCodeId()).concat(c2);
                            }
                            jSONObject.put("req_sign", com.bytedance.sdk.component.utils.e.a(str));
                            if (!z) {
                            }
                        }
                        c2 = com.bytedance.sdk.openadsdk.r.o.c();
                        if (i2 != 7) {
                        }
                    } catch (Exception unused2) {
                        return new JSONObject();
                    }
                    break;
            }
        }
    }

    private JSONObject a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                String a2 = com.bytedance.sdk.component.utils.a.a(str);
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                String upperCase = com.bytedance.sdk.component.utils.e.a("id=" + a2 + "&timestamp=" + currentTimeMillis + "&ext=" + str2).toUpperCase();
                jSONObject.put("id", a2);
                jSONObject.put("timestamp", currentTimeMillis);
                jSONObject.put("sign", upperCase);
                jSONObject.put("ext", str2);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2, long j3, long j4) {
        com.bytedance.sdk.openadsdk.core.e.t tVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) || (tVar = this.f30476a) == null) {
            return;
        }
        tVar.d(j);
        this.f30476a.e(j3);
        this.f30476a.f(j2);
        this.f30476a.g(j4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, String str, int i2, a aVar, int i3, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{Long.valueOf(j), str, Integer.valueOf(i2), aVar, Integer.valueOf(i3), str2}) == null) && com.bytedance.sdk.openadsdk.core.j.g.a()) {
            if (i2 == 4 || i2 == 3) {
                com.bytedance.sdk.component.e.e.b(new com.bytedance.sdk.component.e.g(this, "uploadAdTypeTimeOutEvent", i3, str2, i2, aVar, str, j) { // from class: com.bytedance.sdk.openadsdk.core.q.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ int f30494a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f30495b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ int f30496c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ a f30497d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ String f30498e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ long f30499f;

                    /* renamed from: g  reason: collision with root package name */
                    public final /* synthetic */ q f30500g;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r8, Integer.valueOf(i3), str2, Integer.valueOf(i2), aVar, str, Long.valueOf(j)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                super((String) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f30500g = this;
                        this.f30494a = i3;
                        this.f30495b = str2;
                        this.f30496c = i2;
                        this.f30497d = aVar;
                        this.f30498e = str;
                        this.f30499f = j;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        String str3;
                        String str4;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            int i4 = this.f30494a;
                            com.bytedance.sdk.openadsdk.k.a.b h2 = new com.bytedance.sdk.openadsdk.k.a.b().a(this.f30496c).b(i4).h(TextUtils.isEmpty(this.f30495b) ? g.a(i4) : this.f30495b);
                            com.bytedance.sdk.openadsdk.core.e.m mVar = null;
                            try {
                                if (this.f30497d == null || this.f30497d.f30514h == null || this.f30497d.f30514h.c() == null || this.f30497d.f30514h.c().size() <= 0) {
                                    str3 = "";
                                    str4 = str3;
                                } else {
                                    mVar = this.f30497d.f30514h.c().get(0);
                                    str3 = mVar.ao();
                                    if (!TextUtils.isEmpty(str3)) {
                                        try {
                                            str4 = new JSONObject(str3).getString(IAdRequestParam.REQ_ID);
                                        } catch (Throwable unused) {
                                        }
                                    }
                                    str4 = "";
                                }
                                if (TextUtils.isEmpty(str4) && this.f30497d != null && this.f30497d.f30514h != null) {
                                    str4 = this.f30497d.f30514h.a();
                                }
                                h2.g(str4).d(mVar != null ? mVar.ak() : "").i(str3).c(this.f30498e).a(this.f30499f).b(this.f30497d != null ? this.f30497d.f30507a : 0L);
                            } catch (Throwable th) {
                                com.bytedance.sdk.component.utils.j.c("NetApiImpl", "uploadAdTypeTimeOutEvent throws exception ", th);
                            }
                            com.bytedance.sdk.openadsdk.k.a.a().e(h2);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.bytedance.sdk.openadsdk.core.e.n nVar, long j, long j2, a aVar, long j3, com.bytedance.sdk.openadsdk.core.e.m mVar, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65547, this, new Object[]{nVar, Long.valueOf(j), Long.valueOf(j2), aVar, Long.valueOf(j3), mVar, str}) == null) && o.h().v()) {
            JSONObject jSONObject = new JSONObject();
            long j4 = 0;
            if (nVar != null) {
                try {
                    if (nVar.f30105f > 0) {
                        jSONObject.put("client_start_time", j - nVar.f30105f);
                        j4 = j3 - nVar.f30105f;
                    }
                } catch (Exception unused) {
                    return;
                }
            }
            jSONObject.put("network_time", j2 - j);
            jSONObject.put("sever_time", aVar.f30507a);
            jSONObject.put("client_end_time", j3 - j2);
            try {
                com.bytedance.sdk.openadsdk.e.d.a(this.f30477c, mVar, str, "load_ad_time", j4, jSONObject);
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(p.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, bVar) == null) {
            bVar.a(-1, g.a(-1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(p.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, cVar) == null) {
            cVar.a(-1, g.a(-1));
        }
    }

    private void a(com.bytedance.sdk.openadsdk.e.a aVar) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65555, this, aVar) == null) || aVar == null || (jSONObject = aVar.f31182b) == null) {
            return;
        }
        String optString = jSONObject.optString("log_extra", "");
        long e2 = com.bytedance.sdk.openadsdk.r.o.e(optString);
        int f2 = com.bytedance.sdk.openadsdk.r.o.f(optString);
        if (e2 == 0) {
            e2 = this.f30480f;
        }
        this.f30480f = e2;
        if (f2 == 0) {
            f2 = this.f30481g;
        }
        this.f30481g = f2;
    }

    private void a(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.e.n nVar) {
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65556, this, jSONObject, nVar) == null) && nVar != null && (jSONArray = nVar.f30103d) != null) {
            try {
                jSONObject.put("source_temai_product_ids", jSONArray);
            } catch (Exception unused) {
            }
        }
    }

    private void a(JSONObject jSONObject, String str, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65557, this, new Object[]{jSONObject, str, Float.valueOf(f2), Float.valueOf(f3)}) == null) || f2 <= 0.0f || f3 < 0.0f) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put("width", (int) f2);
            jSONObject2.put("height", (int) f3);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    private void a(JSONObject jSONObject, String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(65558, this, jSONObject, str, i2, i3) == null) || i2 <= 0 || i3 <= 0) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put("width", i2);
            jSONObject2.put("height", i3);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    private void a(JSONObject jSONObject, String str, String str2) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65559, this, jSONObject, str, str2) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    private boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, this, str)) == null) {
            if (com.bytedance.sdk.openadsdk.core.c.b.a()) {
                return true;
            }
            if (com.bytedance.sdk.openadsdk.core.c.b.a(str)) {
                String b2 = com.bytedance.sdk.openadsdk.core.c.b.b();
                if (!TextUtils.isEmpty(b2)) {
                    com.bytedance.sdk.openadsdk.e.d.a(this.f30477c, b2, System.currentTimeMillis());
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private String b(List<FilterWord> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, this, list)) == null) {
            if (list.get(0).getId().equals("0:00")) {
                return list.get(0).getName();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    private JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", h.d().h());
                jSONObject.put("name", h.d().j());
                f(jSONObject);
                com.bytedance.sdk.openadsdk.n.a.a(jSONObject);
                jSONObject.put("is_paid_app", h.d().k());
                jSONObject.put("apk_sign", com.bytedance.sdk.openadsdk.n.a.e());
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Keep
    @JProtect
    private JSONObject b(AdSlot adSlot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, this, adSlot)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                a(jSONObject, "keywords", h.d().l());
                com.bytedance.sdk.openadsdk.n.a.d(this.f30477c, jSONObject);
                a(jSONObject, "data", c(adSlot));
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0093  */
    @Keep
    @JProtect
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JSONObject b(@NonNull com.bytedance.sdk.openadsdk.dislike.c.b bVar, List<FilterWord> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65564, this, bVar, list)) == null) {
            while (true) {
                char c2 = 'J';
                char c3 = '7';
                while (true) {
                    switch (c2) {
                        case 'H':
                            break;
                        case 'I':
                            switch (c3) {
                                case '^':
                                    c2 = 'I';
                                    c3 = '`';
                            }
                            break;
                        case 'J':
                            break;
                        default:
                            c2 = 'H';
                    }
                    switch (c3) {
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("action", "dislike");
                jSONObject2.put("timestamp", System.currentTimeMillis());
                jSONObject2.put("ad_sdk_version", "3.6.1.3");
                com.bytedance.sdk.openadsdk.n.a.a(this.f30477c, jSONObject2);
                if (bVar != null) {
                    jSONObject2.put("extra", bVar.e());
                    if (bVar.c() == null) {
                        bVar.a("other");
                    }
                    jSONObject2.put("dislike_source", bVar.c());
                }
                String b2 = b(list);
                if (b2 != null) {
                    jSONObject2.put("comment", b2);
                    list.clear();
                } else {
                    jSONObject2.put("comment", (Object) null);
                }
                jSONObject2.put("filter_words", c(list));
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject2);
                jSONObject.put(NotificationCompat.WearableExtender.KEY_ACTIONS, jSONArray);
                PersonalizationPrompt a2 = bVar.a();
                if (a2 != null) {
                    jSONObject2.put("personalization_prompts", a2.toJson());
                }
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    private boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, this, str)) == null) {
            try {
                String l = com.bytedance.sdk.openadsdk.r.o.l(str);
                JSONObject jSONObject = !TextUtils.isEmpty(l) ? new JSONObject(l) : null;
                if (jSONObject != null && jSONObject.getJSONObject("smart_look") != null && jSONObject.getString("smart_look_url") != null) {
                    f30474b = com.bytedance.sdk.openadsdk.multipro.c.b(jSONObject.getString("smart_look_url"));
                    return true;
                }
            } catch (Exception e2) {
                com.bytedance.sdk.component.utils.j.a("TTMediationSDK", "NetApiImpl-->异常：", e2.toString());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private boolean b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65566, this, jSONObject)) == null) ? jSONObject != null && jSONObject.length() > 0 : invokeL.booleanValue;
    }

    private String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65567, this)) == null) ? com.bytedance.sdk.openadsdk.core.k.c.a(true) : (String) invokeV.objValue;
    }

    private String c(AdSlot adSlot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, this, adSlot)) == null) {
            if (adSlot == null) {
                return "";
            }
            String m = h.d().m();
            String userData = adSlot.getUserData();
            if (TextUtils.isEmpty(m)) {
                return userData;
            }
            if (TextUtils.isEmpty(userData)) {
                return m;
            }
            HashSet hashSet = new HashSet();
            try {
                JSONArray jSONArray = new JSONArray(userData);
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    if (jSONObject != null) {
                        hashSet.add(jSONObject.optString("name", null));
                    }
                }
                try {
                    JSONArray jSONArray2 = new JSONArray(m);
                    int length2 = jSONArray2.length();
                    for (int i3 = 0; i3 < length2; i3++) {
                        JSONObject jSONObject2 = jSONArray2.getJSONObject(i3);
                        if (jSONObject2 != null && !hashSet.contains(jSONObject2.optString("name", null))) {
                            jSONArray.put(jSONObject2);
                        }
                    }
                    return jSONArray.toString();
                } catch (Throwable unused) {
                    return userData;
                }
            } catch (Throwable unused2) {
                return m;
            }
        }
        return (String) invokeL.objValue;
    }

    private JSONArray c(List<FilterWord> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, this, list)) == null) {
            if (list == null || list.isEmpty()) {
                return new JSONArray();
            }
            JSONArray jSONArray = new JSONArray();
            for (FilterWord filterWord : list) {
                jSONArray.put(filterWord.getId());
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    private void c(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65570, this, jSONObject) == null) && jSONObject != null && h.d().x()) {
            Map<String, String> d2 = d(jSONObject);
            PostExecutor postExecutor = com.bytedance.sdk.openadsdk.l.e.b().c().getPostExecutor();
            postExecutor.setUrl(com.bytedance.sdk.openadsdk.r.o.l());
            if (d2 != null) {
                for (Map.Entry<String, String> entry : d2.entrySet()) {
                    postExecutor.addHeader(entry.getKey(), entry.getValue());
                }
            }
            postExecutor.setJson(jSONObject.toString());
            postExecutor.addHeader("User-Agent", com.bytedance.sdk.openadsdk.r.o.b());
            postExecutor.enqueue(new NetCallback(this) { // from class: com.bytedance.sdk.openadsdk.core.q.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f30501a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f30501a = this;
                }

                @Override // com.bytedance.sdk.component.net.callback.NetCallback
                public void onFailure(NetExecutor netExecutor, IOException iOException) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, netExecutor, iOException) == null) {
                        com.bytedance.sdk.component.utils.j.b("NetApiImpl", "onFailure: ", iOException.getMessage());
                    }
                }

                @Override // com.bytedance.sdk.component.net.callback.NetCallback
                public void onResponse(NetExecutor netExecutor, NetResponse netResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, netExecutor, netResponse) == null) {
                        if (netResponse == null || !netResponse.isSuccess()) {
                            com.bytedance.sdk.component.utils.j.c("NetApiImpl", "onResponse: NetResponse is null");
                        } else {
                            com.bytedance.sdk.component.utils.j.b("NetApiImpl", "onResponse: ", netResponse.getBody());
                        }
                    }
                }
            });
        }
    }

    @NonNull
    private Map<String, String> d(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, this, jSONObject)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json; charset=utf-8");
            if (b(jSONObject)) {
                hashMap.put("Content-Encoding", "union_sdk_encode");
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    @Keep
    @SuppressLint({"HardwareIds"})
    @JProtect
    private JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65572, this)) != null) {
            return (JSONObject) invokeV.objValue;
        }
        char c2 = '\t';
        char c3 = JSONLexer.EOI;
        while (true) {
            char c4 = 14;
            while (true) {
                switch (c4) {
                    case 14:
                        c4 = 16;
                        c3 = 65492;
                        c2 = DecodedBitStreamParser.RS;
                    case 16:
                        if (c3 <= 22) {
                            while (true) {
                                switch (c2) {
                                    case 30:
                                    case 31:
                                        JSONObject jSONObject = new JSONObject();
                                        try {
                                            jSONObject.put("ua", com.bytedance.sdk.openadsdk.r.o.b());
                                            com.bytedance.sdk.openadsdk.n.a.c(this.f30477c, jSONObject);
                                            jSONObject.put("openudid", j.c(this.f30477c));
                                            jSONObject.put("oaid", com.bytedance.sdk.openadsdk.r.i.a());
                                            jSONObject.put("ad_sdk_version", "3.6.1.3");
                                            jSONObject.put("sim_op", a(this.f30477c));
                                            jSONObject.put(PrefetchEvent.EVENT_DATA_ROOT_PATH, this.f30478d ? 1 : 0);
                                            jSONObject.put(BaseStatisContent.TIMEZONE, g());
                                            jSONObject.put("access", com.bytedance.sdk.component.utils.m.g(this.f30477c));
                                            jSONObject.put(IAdRequestParam.OS, "Android");
                                            jSONObject.put(HttpConstants.OS_VERSION, Build.VERSION.RELEASE);
                                            jSONObject.put("os_api", Build.VERSION.SDK_INT);
                                            jSONObject.put(HttpConstants.DEVICE_TYPE, this.f30479e);
                                            jSONObject.put("device_model", Build.MODEL);
                                            jSONObject.put("device_brand", Build.BRAND);
                                            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
                                            jSONObject.put("language", Locale.getDefault().getLanguage());
                                            jSONObject.put("resolution", com.bytedance.sdk.openadsdk.r.q.d(this.f30477c) + "x" + com.bytedance.sdk.openadsdk.r.q.c(this.f30477c));
                                            jSONObject.put("display_density", a(com.bytedance.sdk.openadsdk.r.q.g(this.f30477c)));
                                            jSONObject.put("density_dpi", com.bytedance.sdk.openadsdk.r.q.g(this.f30477c));
                                            jSONObject.put("device_id", j.a(this.f30477c));
                                            jSONObject.put("aid", "1371");
                                            jSONObject.put(Config.ROM, f());
                                            jSONObject.put(PmsConstant.EnvParam.Key.CPU_ABI, Build.CPU_ABI);
                                            jSONObject.put("build_serial", j.i(this.f30477c));
                                            jSONObject.put("ut", this.f30481g);
                                            jSONObject.put("uid", this.f30480f);
                                            jSONObject.put("locale_language", com.bytedance.sdk.openadsdk.core.k.c.c());
                                            jSONObject.put("screen_bright", Math.ceil(com.bytedance.sdk.openadsdk.core.k.c.d() * 10.0f) / 10.0d);
                                            Context a2 = o.a();
                                            jSONObject.put("is_screen_off", com.bytedance.sdk.openadsdk.core.k.c.a() ? 0 : 1);
                                            if (a2 != null) {
                                                jSONObject.put("download_channel", com.bytedance.sdk.openadsdk.c.a.b(a2));
                                            }
                                            if (r.c() > 0) {
                                                jSONObject.put("screenshot_time", String.valueOf(r.c()));
                                            }
                                            jSONObject.put("mnc", com.bytedance.sdk.openadsdk.r.k.b());
                                            jSONObject.put("mcc", com.bytedance.sdk.openadsdk.r.k.a());
                                        } catch (Exception unused) {
                                        }
                                        return jSONObject;
                                }
                            }
                        }
                        continue;
                        break;
                }
            }
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
            try {
                if (!new File("/system/bin/su").exists()) {
                    if (!new File("/system/xbin/su").exists()) {
                        return false;
                    }
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    private boolean e(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, this, jSONObject)) == null) {
            if (jSONObject != null) {
                try {
                    return jSONObject.optString("message").equalsIgnoreCase("success");
                } catch (Throwable unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String f() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            StringBuilder sb = new StringBuilder();
            if (com.bytedance.sdk.openadsdk.r.j.e()) {
                str = "MIUI-";
            } else if (!com.bytedance.sdk.openadsdk.r.j.b()) {
                String n = com.bytedance.sdk.openadsdk.r.j.n();
                if (com.bytedance.sdk.openadsdk.r.j.a(n)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(n)) {
                    sb.append(n);
                    str = "-";
                }
                sb.append(Build.VERSION.INCREMENTAL);
                return sb.toString();
            } else {
                str = "FLYME-";
            }
            sb.append(str);
            sb.append(Build.VERSION.INCREMENTAL);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    private void f(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65576, this, jSONObject) == null) {
            try {
                jSONObject.put("package_name", com.bytedance.sdk.openadsdk.r.o.d());
                jSONObject.put("version_code", com.bytedance.sdk.openadsdk.r.o.e());
                jSONObject.put("version", com.bytedance.sdk.openadsdk.r.o.f());
            } catch (Exception unused) {
            }
        }
    }

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) {
            int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
            if (rawOffset < -12) {
                rawOffset = -12;
            }
            if (rawOffset > 12) {
                return 12;
            }
            return rawOffset;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Throwable added to exception handler: 'Exception', keep only Throwable */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject g(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65578, this, jSONObject)) != null) {
            return (JSONObject) invokeL.objValue;
        }
        if (jSONObject == null) {
            return jSONObject;
        }
        if (f30475h) {
            int optInt = jSONObject.optInt("cypher", -1);
            String optString = jSONObject.optString("message");
            if (optInt == 3) {
                optString = com.bytedance.sdk.component.utils.a.b(optString);
            }
            if (!TextUtils.isEmpty(optString)) {
                jSONObject2 = new JSONObject(optString);
                return !f30475h ? jSONObject2 : jSONObject;
            }
        }
        jSONObject2 = jSONObject;
        if (!f30475h) {
        }
    }

    private String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65579, this)) == null) ? com.bytedance.sdk.openadsdk.core.k.c.c(this.f30477c) ? Config.TARGET_SDK_VERSION : com.bytedance.sdk.openadsdk.core.k.c.b(this.f30477c) ? "android_pad" : "android" : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    public com.bytedance.sdk.openadsdk.core.e.u a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (com.bytedance.sdk.openadsdk.core.j.g.a()) {
                com.bytedance.sdk.component.adnet.b.h.a();
                String z = o.h().z();
                GetExecutor getExecutor = com.bytedance.sdk.openadsdk.l.e.b().c().getGetExecutor();
                getExecutor.setUrl(com.bytedance.sdk.openadsdk.r.n.b(z));
                NetResponse execute = getExecutor.execute();
                if (execute != null) {
                    try {
                        if (execute.isSuccess()) {
                            return com.bytedance.sdk.openadsdk.core.e.u.e(execute.getBody());
                        }
                        return null;
                    } catch (Exception unused) {
                        return null;
                    }
                }
                return null;
            }
            return null;
        }
        return (com.bytedance.sdk.openadsdk.core.e.u) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    @WorkerThread
    public com.bytedance.sdk.openadsdk.e.h a(List<com.bytedance.sdk.openadsdk.e.a> list) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            try {
                if (com.bytedance.sdk.openadsdk.core.j.g.a()) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        a(list.get(0));
                        jSONObject.put("header", d());
                        JSONArray jSONArray = new JSONArray();
                        for (com.bytedance.sdk.openadsdk.e.a aVar : list) {
                            jSONArray.put(aVar.f31182b);
                        }
                        jSONObject.put("event", jSONArray);
                        jSONObject.put("_gen_time", System.currentTimeMillis());
                    } catch (JSONException unused) {
                    }
                    JSONObject a2 = com.bytedance.sdk.component.utils.a.a(jSONObject);
                    if (!b(a2)) {
                        a2 = jSONObject;
                    }
                    if (com.bytedance.sdk.component.utils.j.c()) {
                        com.bytedance.sdk.component.utils.j.b("adevent", "adevent is :" + jSONObject.toString());
                    }
                    Map<String, String> d2 = d(a2);
                    PostExecutor postExecutor = com.bytedance.sdk.openadsdk.l.e.b().c().getPostExecutor();
                    postExecutor.setUrl(com.bytedance.sdk.openadsdk.r.o.k());
                    if (d2 != null) {
                        for (Map.Entry<String, String> entry : d2.entrySet()) {
                            postExecutor.addHeader(entry.getKey(), entry.getValue());
                        }
                    }
                    postExecutor.setJson(a2.toString());
                    postExecutor.addHeader("User-Agent", com.bytedance.sdk.openadsdk.r.o.b());
                    NetResponse execute = postExecutor.execute();
                    boolean e2 = (execute == null || !execute.isSuccess() || TextUtils.isEmpty(execute.getBody())) ? false : e(new JSONObject(execute.getBody()));
                    String str = "error unknown";
                    int code = execute != null ? execute.getCode() : 0;
                    if (e2 || code != 200) {
                        if (execute != null && execute.getMessage() != null) {
                            str = execute.getMessage();
                        }
                        z = false;
                    } else {
                        str = "server say not success";
                        z = true;
                    }
                    c(a2);
                    return new com.bytedance.sdk.openadsdk.e.h(e2, code, str, z);
                }
                return null;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.j.c("NetApiImpl", "uploadEvent error", th);
                return new com.bytedance.sdk.openadsdk.e.h(false, 509, "service_busy", false);
            }
        }
        return (com.bytedance.sdk.openadsdk.e.h) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0081, code lost:
        if (r4 == 60005) goto L26;
     */
    @Override // com.bytedance.sdk.openadsdk.core.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.bytedance.sdk.openadsdk.e.h a(JSONObject jSONObject) {
        InterceptResult invokeL;
        int i2;
        boolean z;
        boolean z2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            if (com.bytedance.sdk.openadsdk.core.j.g.a() && jSONObject != null && jSONObject.length() > 0) {
                JSONObject a2 = com.bytedance.sdk.component.utils.a.a(jSONObject);
                PostExecutor postExecutor = com.bytedance.sdk.openadsdk.l.e.b().c().getPostExecutor();
                postExecutor.setUrl(com.bytedance.sdk.openadsdk.r.o.m("/api/ad/union/sdk/stats/batch/"));
                postExecutor.setJson(a2.toString());
                postExecutor.addHeader("User-Agent", com.bytedance.sdk.openadsdk.r.o.b());
                NetResponse execute = postExecutor.execute();
                String str = "error unknown";
                boolean z3 = false;
                try {
                } catch (Throwable unused) {
                    i2 = 0;
                    z = false;
                }
                if (execute == null) {
                    return new com.bytedance.sdk.openadsdk.e.h(false, 0, "error unknown", false);
                }
                z = true;
                if (!execute.isSuccess() || TextUtils.isEmpty(execute.getBody())) {
                    z2 = false;
                } else {
                    JSONObject jSONObject2 = new JSONObject(execute.getBody());
                    int optInt = jSONObject2.optInt("code", -1);
                    str = jSONObject2.optString("data", "");
                    z2 = optInt == 20000;
                }
                z = false;
                try {
                    i3 = execute.getCode();
                    try {
                        if (!execute.isSuccess()) {
                            str = execute.getMessage();
                        }
                    } catch (Throwable unused2) {
                        i2 = i3;
                        z3 = z2;
                        z2 = z3;
                        i3 = i2;
                        return new com.bytedance.sdk.openadsdk.e.h(z2, i3, str, z);
                    }
                } catch (Throwable unused3) {
                    z3 = z2;
                    i2 = 0;
                }
                return new com.bytedance.sdk.openadsdk.e.h(z2, i3, str, z);
            }
            return null;
        }
        return (com.bytedance.sdk.openadsdk.e.h) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    public String a(AdSlot adSlot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, adSlot)) == null) ? a(adSlot, false, -1) : (String) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    public String a(AdSlot adSlot, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{adSlot, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            JSONObject jSONObject = new JSONObject();
            com.bytedance.sdk.openadsdk.core.e.n nVar = new com.bytedance.sdk.openadsdk.core.e.n();
            if (7 == adSlot.getAdType()) {
                nVar.f30101b = 1;
            } else if (8 == adSlot.getAdType()) {
                nVar.f30102c = 1;
            } else if (3 == adSlot.getAdType()) {
                nVar.f30105f = System.currentTimeMillis();
            }
            if (o.h().i(adSlot.getCodeId())) {
                nVar.f30104e = 2;
            }
            if (z) {
                nVar.f30104e = 2;
                if (i2 == 1 || i2 == 2) {
                    adSlot.setNativeAdType(i2);
                }
            }
            if (5 == adSlot.getNativeAdType() || 1 == adSlot.getNativeAdType() || 2 == adSlot.getNativeAdType()) {
                nVar.f30104e = 2;
            }
            if (adSlot.getAdType() > 0) {
                i2 = adSlot.getAdType();
            } else if (i2 <= 0) {
                i2 = 0;
            }
            JSONObject a2 = a(adSlot, nVar, i2, true);
            JSONObject jSONObject2 = new JSONObject();
            try {
                com.bytedance.sdk.openadsdk.n.a.a(jSONObject2, a2);
                jSONObject2.putOpt("User-Agent", com.bytedance.sdk.openadsdk.r.o.b());
                jSONObject.putOpt("header", jSONObject2);
                jSONObject.putOpt("bid_request", a2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String a3 = com.bytedance.sdk.component.utils.a.a(jSONObject.toString());
            com.bytedance.sdk.component.utils.j.b("NetApiImpl", "bidding toke: 0000000003" + a3);
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("message", a3);
                jSONObject3.put("cypher", 2);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            return "0000000003" + a3;
        }
        return (String) invokeCommon.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    @Keep
    @JProtect
    public void a(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.e.n nVar, int i2, p.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048581, this, adSlot, nVar, i2, bVar) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                l.c().post(new Runnable(this, adSlot, nVar, i2, bVar) { // from class: com.bytedance.sdk.openadsdk.core.q.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f30482a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ com.bytedance.sdk.openadsdk.core.e.n f30483b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ int f30484c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ p.b f30485d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ q f30486e;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, adSlot, nVar, Integer.valueOf(i2), bVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f30486e = this;
                        this.f30482a = adSlot;
                        this.f30483b = nVar;
                        this.f30484c = i2;
                        this.f30485d = bVar;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f30486e.b(this.f30482a, this.f30483b, this.f30484c, this.f30485d);
                        }
                    }
                });
            } else {
                b(adSlot, nVar, i2, bVar);
            }
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.e.t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tVar) == null) {
            this.f30476a = tVar;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    public void a(@NonNull com.bytedance.sdk.openadsdk.dislike.c.b bVar, List<FilterWord> list) {
        JSONObject b2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, bVar, list) == null) && com.bytedance.sdk.openadsdk.core.j.g.a() && (b2 = b(bVar, list)) != null) {
            PostExecutor postExecutor = com.bytedance.sdk.openadsdk.l.e.b().c().getPostExecutor();
            postExecutor.setUrl(com.bytedance.sdk.openadsdk.r.o.m("/api/ad/union/dislike_event/"));
            postExecutor.setJson(com.bytedance.sdk.component.utils.a.a(b2).toString());
            postExecutor.enqueue(new NetCallback(this) { // from class: com.bytedance.sdk.openadsdk.core.q.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f30502a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f30502a = this;
                }

                @Override // com.bytedance.sdk.component.net.callback.NetCallback
                public void onFailure(NetExecutor netExecutor, IOException iOException) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, netExecutor, iOException) == null) {
                    }
                }

                @Override // com.bytedance.sdk.component.net.callback.NetCallback
                public void onResponse(NetExecutor netExecutor, NetResponse netResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, netExecutor, netResponse) == null) {
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    public void a(String str, String str2, p.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, aVar) == null) {
            if (!com.bytedance.sdk.openadsdk.core.j.g.a()) {
                if (aVar != null) {
                    aVar.a(false, -1L, 0L);
                }
            } else if (str == null || str2 == null || aVar == null) {
            } else {
                JSONObject a2 = a(str, str2);
                PostExecutor postExecutor = com.bytedance.sdk.openadsdk.l.e.b().c().getPostExecutor();
                postExecutor.setUrl(com.bytedance.sdk.openadsdk.r.o.m("/api/ad/union/sdk/material/check/"));
                postExecutor.setJson(com.bytedance.sdk.component.utils.a.a(a2));
                postExecutor.enqueue(new NetCallback(this, aVar) { // from class: com.bytedance.sdk.openadsdk.core.q.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ p.a f30505a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ q f30506b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, aVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f30506b = this;
                        this.f30505a = aVar;
                    }

                    @Override // com.bytedance.sdk.component.net.callback.NetCallback
                    public void onFailure(NetExecutor netExecutor, IOException iOException) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, netExecutor, iOException) == null) {
                            this.f30505a.a(false, 0L, 0L);
                        }
                    }

                    @Override // com.bytedance.sdk.component.net.callback.NetCallback
                    public void onResponse(NetExecutor netExecutor, NetResponse netResponse) {
                        boolean z;
                        long j;
                        long j2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, netExecutor, netResponse) == null) || netResponse == null) {
                            return;
                        }
                        if (netResponse.isSuccess()) {
                            long j3 = 0;
                            if (netResponse.getBody() != null) {
                                try {
                                    b a3 = b.a(new JSONObject(netResponse.getBody()));
                                    r0 = a3.f30516a;
                                    j3 = netResponse.getDuration();
                                    z = a3.f30517b;
                                    j = r0;
                                    j2 = j3;
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                }
                                this.f30505a.a(z, j, j2);
                                return;
                            }
                            j = r0;
                            j2 = j3;
                            z = false;
                            this.f30505a.a(z, j, j2);
                            return;
                        }
                        this.f30505a.a(false, netResponse.getCode() != 0 ? netResponse.getCode() : -1L, netResponse.getDuration());
                    }
                });
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    public void a(JSONObject jSONObject, p.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, jSONObject, cVar) == null) {
            if (!com.bytedance.sdk.openadsdk.core.j.g.a()) {
                if (cVar != null) {
                    cVar.a(1000, "广告请求开关已关闭,请联系穿山甲管理员");
                }
            } else if (jSONObject == null || cVar == null) {
            } else {
                JSONObject a2 = com.bytedance.sdk.component.utils.a.a(jSONObject);
                PostExecutor postExecutor = com.bytedance.sdk.openadsdk.l.e.b().c().getPostExecutor();
                postExecutor.setUrl(com.bytedance.sdk.openadsdk.r.o.m("/api/ad/union/sdk/reward_video/reward/"));
                postExecutor.setJson(a2.toString());
                postExecutor.enqueue(new NetCallback(this, cVar) { // from class: com.bytedance.sdk.openadsdk.core.q.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ p.c f30503a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ q f30504b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, cVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f30504b = this;
                        this.f30503a = cVar;
                    }

                    @Override // com.bytedance.sdk.component.net.callback.NetCallback
                    public void onFailure(NetExecutor netExecutor, IOException iOException) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, netExecutor, iOException) == null) {
                            this.f30503a.a(-2, iOException.getMessage());
                        }
                    }

                    @Override // com.bytedance.sdk.component.net.callback.NetCallback
                    public void onResponse(NetExecutor netExecutor, NetResponse netResponse) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, netExecutor, netResponse) == null) {
                            if (netResponse != null) {
                                if (netResponse.isSuccess() && !TextUtils.isEmpty(netResponse.getBody())) {
                                    try {
                                        JSONObject jSONObject2 = new JSONObject(netResponse.getBody());
                                        String b2 = jSONObject2.optInt("cypher", -1) == 3 ? com.bytedance.sdk.component.utils.a.b(jSONObject2.optString("message")) : null;
                                        if (!TextUtils.isEmpty(b2)) {
                                            try {
                                                jSONObject2 = new JSONObject(b2);
                                            } catch (Throwable unused) {
                                            }
                                        }
                                        c a3 = c.a(jSONObject2);
                                        if (a3.f30518a != 20000) {
                                            this.f30503a.a(a3.f30518a, g.a(a3.f30518a));
                                            return;
                                        } else if (a3.f30520c == null) {
                                            this.f30504b.a(this.f30503a);
                                            return;
                                        } else {
                                            this.f30503a.a(a3);
                                            return;
                                        }
                                    } catch (JSONException e2) {
                                        e2.printStackTrace();
                                        this.f30504b.a(this.f30503a);
                                        return;
                                    }
                                }
                                String a4 = g.a(-2);
                                int code = netResponse.getCode();
                                if (!netResponse.isSuccess() && !TextUtils.isEmpty(netResponse.getMessage())) {
                                    a4 = netResponse.getMessage();
                                }
                                this.f30503a.a(code, a4);
                                return;
                            }
                            this.f30504b.a(this.f30503a);
                        }
                    }
                });
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    public boolean a(JSONObject jSONObject, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, jSONObject, i2)) == null) {
            if (com.bytedance.sdk.openadsdk.core.j.g.a()) {
                if (jSONObject == null || jSONObject.length() <= 0) {
                    return true;
                }
                PostExecutor postExecutor = com.bytedance.sdk.openadsdk.l.e.b().c().getPostExecutor();
                postExecutor.setUrl(com.bytedance.sdk.openadsdk.r.n.b("https://i.snssdk.com/inspect/aegis/client/page/"));
                postExecutor.setJson(jSONObject.toString());
                NetResponse execute = postExecutor.execute();
                if (execute != null) {
                    try {
                        if (!execute.isSuccess() || TextUtils.isEmpty(execute.getBody())) {
                            return false;
                        }
                        return "success".equals(new JSONObject(execute.getBody()).optString("status", "success"));
                    } catch (Throwable unused) {
                        return false;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public void b(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.e.n nVar, int i2, p.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048587, this, adSlot, nVar, i2, bVar) == null) {
            if (!com.bytedance.sdk.openadsdk.core.j.g.a()) {
                if (bVar != null) {
                    bVar.a(1000, "广告请求开关已关闭,请联系穿山甲管理员");
                    return;
                }
                return;
            }
            d.a().c();
            com.bytedance.sdk.component.e.e.a(new com.bytedance.sdk.component.e.g(this, "getAd") { // from class: com.bytedance.sdk.openadsdk.core.q.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f30487a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f30487a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        l.c().postDelayed(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.q.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass2 f30488a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f30488a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.bytedance.sdk.openadsdk.core.j.f.a((com.bytedance.sdk.openadsdk.core.j.c) null).e();
                                }
                            }
                        }, 10000L);
                        com.bytedance.sdk.openadsdk.core.j.d.c().d();
                        com.bytedance.sdk.openadsdk.n.a.c();
                    }
                }
            }, 10);
            if (bVar == null) {
                return;
            }
            if (a(adSlot.getCodeId())) {
                bVar.a(-8, g.a(-8));
            } else if (!TextUtils.isEmpty(adSlot.getBidAdm())) {
                com.bytedance.sdk.component.utils.j.a("bidding", "getAd bidAdm有效，则直接解析返回广告：BidAdm->MD5->", com.bytedance.sdk.openadsdk.o.g.b.a(adSlot.getBidAdm()));
                try {
                    JSONObject g2 = g(new JSONObject(adSlot.getBidAdm()));
                    if (g2 == null) {
                        a(bVar);
                        return;
                    }
                    a a2 = a.a(g2, adSlot, nVar);
                    j.a(this.f30477c, a2.f30515i);
                    if (a2.f30510d != 20000) {
                        bVar.a(a2.f30510d, a2.f30511e);
                    } else if (a2.f30514h == null) {
                        a(bVar);
                    } else {
                        a2.f30514h.c(g2.toString());
                        bVar.a(a2.f30514h);
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.j.c("NetApiImpl", "get ad error: ", th);
                    a(bVar);
                }
            } else {
                com.bytedance.sdk.openadsdk.p.a.a(adSlot);
                JSONObject a3 = a(adSlot, nVar, i2, false);
                if (a3 == null) {
                    bVar.a(-9, g.a(-9));
                    return;
                }
                String a4 = com.bytedance.sdk.openadsdk.r.o.a("/api/ad/union/sdk/get_ads/", true);
                try {
                    boolean b2 = b(adSlot.getExtraSmartLookParam());
                    com.bytedance.sdk.component.utils.j.f("TTMediationSDK", "获取到的smartlook信息：isSmartLook=" + b2 + "，type=" + i2);
                    if (b2 && !TextUtils.isEmpty(f30474b)) {
                        if (i2 == 4) {
                            return;
                        }
                        a4 = f30474b;
                    }
                } catch (Throwable unused) {
                    a4 = com.bytedance.sdk.openadsdk.r.o.m("/api/ad/union/sdk/get_ads/");
                }
                PostExecutor postExecutor = com.bytedance.sdk.openadsdk.l.e.b().c().getPostExecutor();
                postExecutor.setUrl(a4);
                postExecutor.setJson(a3);
                HashMap hashMap = new HashMap();
                hashMap.put("extra_time_start", Long.valueOf(System.currentTimeMillis()));
                postExecutor.setExtraMap(hashMap);
                postExecutor.addHeader("User-Agent", com.bytedance.sdk.openadsdk.r.o.b());
                Map<String, String> b3 = com.bytedance.sdk.openadsdk.n.a.b(a4, a3.toString());
                com.bytedance.sdk.openadsdk.r.n.a(b3);
                if (b3 != null && b3.size() > 0) {
                    for (Map.Entry<String, String> entry : b3.entrySet()) {
                        postExecutor.addHeader(entry.getKey(), entry.getValue());
                    }
                }
                postExecutor.enqueue(new NetCallback(this, bVar, adSlot, i2, nVar) { // from class: com.bytedance.sdk.openadsdk.core.q.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ p.b f30489a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f30490b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ int f30491c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ com.bytedance.sdk.openadsdk.core.e.n f30492d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ q f30493e;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, bVar, adSlot, Integer.valueOf(i2), nVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f30493e = this;
                        this.f30489a = bVar;
                        this.f30490b = adSlot;
                        this.f30491c = i2;
                        this.f30492d = nVar;
                    }

                    @Override // com.bytedance.sdk.component.net.callback.NetCallback
                    public void onFailure(NetExecutor netExecutor, IOException iOException) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, netExecutor, iOException) == null) {
                            long longValue = ((Long) netExecutor.getExtraMap().get("extra_time_start")).longValue();
                            long currentTimeMillis = System.currentTimeMillis();
                            if (iOException != null && SocketTimeoutException.class.equals(iOException.getCause())) {
                                this.f30489a.a(602, iOException.getMessage());
                            }
                            this.f30489a.a(602, iOException.getMessage());
                            com.bytedance.sdk.component.utils.j.b("NetApiImpl", "onFailure: ", 601);
                            this.f30493e.a(currentTimeMillis - longValue, this.f30490b.getCodeId(), this.f30491c, null, 601, iOException.getMessage());
                        }
                    }

                    @Override // com.bytedance.sdk.component.net.callback.NetCallback
                    public void onResponse(NetExecutor netExecutor, NetResponse netResponse) {
                        JSONObject jSONObject;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, netExecutor, netResponse) == null) || netResponse == null) {
                            return;
                        }
                        if (netResponse.isSuccess()) {
                            boolean z = true;
                            long j = 0;
                            try {
                                j = ((Long) netExecutor.getExtraMap().get("extra_time_start")).longValue();
                            } catch (Throwable unused2) {
                                z = false;
                            }
                            try {
                                long currentTimeMillis = System.currentTimeMillis();
                                JSONObject g3 = this.f30493e.g(new JSONObject(netResponse.getBody()));
                                if (g3 == null) {
                                    this.f30493e.a(this.f30489a);
                                    this.f30493e.a(netResponse.getDuration(), this.f30490b.getCodeId(), this.f30491c, null, -1, "mate parse_fail");
                                    return;
                                }
                                a a5 = a.a(g3, this.f30490b, this.f30492d);
                                j.a(this.f30493e.f30477c, a5.f30515i);
                                if (a5.f30510d != 20000) {
                                    this.f30489a.a(a5.f30510d, a5.f30511e);
                                    this.f30493e.a(netResponse.getDuration(), this.f30490b.getCodeId(), this.f30491c, a5, a5.f30510d, String.valueOf(a5.f30512f));
                                    return;
                                } else if (a5.f30514h == null) {
                                    this.f30493e.a(this.f30489a);
                                    this.f30493e.a(netResponse.getDuration(), this.f30490b.getCodeId(), this.f30491c, a5, -1, "parse_fail");
                                    return;
                                } else {
                                    a5.f30514h.c(g3.toString());
                                    long currentTimeMillis2 = System.currentTimeMillis();
                                    this.f30489a.a(a5.f30514h);
                                    Map<String, com.bytedance.sdk.openadsdk.core.e.m> a6 = com.bytedance.sdk.openadsdk.core.e.a.a(a5.f30514h);
                                    if (a6 != null) {
                                        com.bytedance.sdk.openadsdk.f.a.a().a(a6);
                                    }
                                    if (!z || a5.f30514h.c() == null || a5.f30514h.c().isEmpty()) {
                                        jSONObject = g3;
                                    } else {
                                        jSONObject = g3;
                                        this.f30493e.a(this.f30492d, j, currentTimeMillis, a5, currentTimeMillis2, a5.f30514h.c().get(0), com.bytedance.sdk.openadsdk.r.o.b(this.f30491c));
                                        this.f30493e.a(j - this.f30492d.f30105f, a5.f30507a, currentTimeMillis - j, currentTimeMillis2 - currentTimeMillis);
                                    }
                                    com.bytedance.sdk.openadsdk.a.b.a().a(jSONObject);
                                    return;
                                }
                            } catch (Throwable th2) {
                                com.bytedance.sdk.component.utils.j.c("NetApiImpl", "get ad error: ", th2);
                                this.f30493e.a(this.f30489a);
                                this.f30493e.a(netResponse.getDuration(), this.f30490b.getCodeId(), this.f30491c, null, -1, "parse_fail");
                                return;
                            }
                        }
                        int code = netResponse.getCode();
                        String message = netResponse.getMessage();
                        this.f30489a.a(code, message);
                        this.f30493e.a(netResponse.getDuration(), this.f30490b.getCodeId(), this.f30491c, null, code, message);
                    }
                });
            }
        }
    }
}
