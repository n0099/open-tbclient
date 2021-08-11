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
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
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
/* loaded from: classes9.dex */
public class q implements p<com.bytedance.sdk.openadsdk.e.a> {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f66568b = null;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f66569h = true;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.e.t f66570a;

    /* renamed from: c  reason: collision with root package name */
    public final Context f66571c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f66572d;

    /* renamed from: e  reason: collision with root package name */
    public final String f66573e;

    /* renamed from: f  reason: collision with root package name */
    public long f66574f;

    /* renamed from: g  reason: collision with root package name */
    public int f66575g;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f66601a;

        /* renamed from: b  reason: collision with root package name */
        public final long f66602b;

        /* renamed from: c  reason: collision with root package name */
        public final long f66603c;

        /* renamed from: d  reason: collision with root package name */
        public final int f66604d;

        /* renamed from: e  reason: collision with root package name */
        public final String f66605e;

        /* renamed from: f  reason: collision with root package name */
        public final int f66606f;

        /* renamed from: g  reason: collision with root package name */
        public final String f66607g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.core.e.a f66608h;

        /* renamed from: i  reason: collision with root package name */
        public final String f66609i;

        public a(String str, int i2, int i3, String str2, int i4, String str3, @Nullable com.bytedance.sdk.openadsdk.core.e.a aVar, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), str2, Integer.valueOf(i4), str3, aVar, Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66601a = i2;
            this.f66604d = i3;
            this.f66605e = str2;
            this.f66607g = str3;
            this.f66608h = aVar;
            this.f66609i = str;
            this.f66606f = i4;
            this.f66602b = j2;
            this.f66603c = j3;
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

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f66610a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f66611b;

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
            this.f66610a = i2;
            this.f66611b = z;
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

    /* loaded from: classes9.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f66612a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f66613b;

        /* renamed from: c  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.core.e.w f66614c;

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
            this.f66612a = i2;
            this.f66613b = z;
            this.f66614c = wVar;
        }

        public static c a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                int optInt = jSONObject.optInt("code");
                boolean optBoolean = jSONObject.optBoolean(SmsLoginView.f.f44761j);
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
        this.f66571c = context;
        this.f66572d = e();
        this.f66573e = h();
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

    /* JADX WARN: Code restructure failed: missing block: B:64:0x017a, code lost:
        if (r14.f66112d == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x017c, code lost:
        r8 = r12.getAdCount();
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0144  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JSONObject a(AdSlot adSlot, int i2, com.bytedance.sdk.openadsdk.core.e.n nVar) {
        InterceptResult invokeLIL;
        int i3;
        int imgAcceptedWidth;
        int adCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(AdIconUtil.AD_TEXT_ID, this, adSlot, i2, nVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", adSlot.getCodeId());
                jSONObject.put("prime_rit", adSlot.getPrimeRit());
                jSONObject.put("show_seq", adSlot.getAdloadSeq());
                jSONObject.put("adtype", i2);
                jSONObject.put("themeStatus", h.d().A());
                if (!TextUtils.isEmpty(adSlot.getAdId()) || !TextUtils.isEmpty(adSlot.getCreativeId()) || !TextUtils.isEmpty(adSlot.getExt()) || com.bytedance.sdk.openadsdk.o.a.a()) {
                    JSONObject jSONObject2 = new JSONObject();
                    if (!TextUtils.isEmpty(adSlot.getAdId())) {
                        jSONObject2.put(LegoListActivityConfig.AD_ID, adSlot.getAdId());
                    }
                    if (!TextUtils.isEmpty(adSlot.getCreativeId())) {
                        jSONObject2.put("creative_id", adSlot.getCreativeId());
                    }
                    if (adSlot.getExt() != null) {
                        jSONObject2.put("ext", adSlot.getExt());
                    }
                    com.bytedance.sdk.openadsdk.o.a.a(jSONObject2, adSlot.getCodeId());
                    jSONObject.put("preview_ads", jSONObject2);
                }
                if ((i2 == 3 || i2 == 4) && nVar != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("publisher_timeout_control", nVar.f66115g);
                    jSONObject3.put("time_out_control", nVar.f66116h);
                    jSONObject3.put("time_out", nVar.f66117i);
                    jSONObject.put("splash_time", jSONObject3);
                }
                i3 = 1;
            } catch (Exception unused) {
            }
            if (nVar != null) {
                if (i2 == 3 || i2 == 4) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("publisher_timeout_control", nVar.f66115g);
                    jSONObject4.put("time_out_control", nVar.f66116h);
                    jSONObject4.put("time_out", nVar.f66117i);
                    jSONObject.put("tmax", jSONObject4);
                }
                jSONObject.put("render_method", nVar.f66113e);
                if (nVar.f66113e != 1) {
                    if (nVar.f66113e == 2) {
                        a(jSONObject, "accepted_size", adSlot.getExpressViewAcceptedWidth(), adSlot.getExpressViewAcceptedHeight());
                    }
                    jSONObject.put("ptpl_ids", o.h().h(adSlot.getCodeId()));
                    jSONObject.put(IAdRequestParam.POS, AdSlot.getPosition(i2));
                    jSONObject.put("is_support_dpl", adSlot.isSupportDeepLink());
                    jSONObject.put("if_support_render_control", !adSlot.isSupportRenderConrol() ? 1 : 0);
                    if (adSlot.getNativeAdType() <= 0 || i2 == 9 || i2 == 5) {
                        jSONObject.put("is_origin_ad", true);
                    }
                    if (nVar != null && nVar.f66118j != null) {
                        jSONObject.put("session_params", nVar.f66118j);
                    }
                    adCount = adSlot.getAdCount();
                    if (i2 != 7 && i2 != 8) {
                        i3 = adCount;
                    }
                    jSONObject.put("ad_count", i3);
                    return jSONObject;
                }
                imgAcceptedWidth = adSlot.getImgAcceptedWidth();
            } else {
                jSONObject.put("render_method", 1);
                imgAcceptedWidth = adSlot.getImgAcceptedWidth();
            }
            a(jSONObject, "accepted_size", imgAcceptedWidth, adSlot.getImgAcceptedHeight());
            jSONObject.put("ptpl_ids", o.h().h(adSlot.getCodeId()));
            jSONObject.put(IAdRequestParam.POS, AdSlot.getPosition(i2));
            jSONObject.put("is_support_dpl", adSlot.isSupportDeepLink());
            jSONObject.put("if_support_render_control", !adSlot.isSupportRenderConrol() ? 1 : 0);
            if (adSlot.getNativeAdType() <= 0) {
            }
            jSONObject.put("is_origin_ad", true);
            if (nVar != null) {
                jSONObject.put("session_params", nVar.f66118j);
            }
            adCount = adSlot.getAdCount();
            if (i2 != 7) {
                i3 = adCount;
            }
            jSONObject.put("ad_count", i3);
            return jSONObject;
        }
        return (JSONObject) invokeLIL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0075 A[Catch: all -> 0x00a1, TryCatch #0 {all -> 0x00a1, blocks: (B:26:0x004c, B:29:0x0068, B:31:0x0075, B:32:0x0092), top: B:63:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ca A[Catch: Exception -> 0x0181, TryCatch #1 {Exception -> 0x0181, blocks: (B:5:0x0017, B:7:0x001e, B:10:0x0027, B:15:0x0035, B:17:0x0039, B:18:0x003b, B:33:0x00a1, B:35:0x00ca, B:37:0x00d4, B:39:0x00da, B:41:0x00e1, B:43:0x00e7, B:44:0x00f0, B:46:0x00fa, B:47:0x0107, B:50:0x015b, B:51:0x016b, B:53:0x0176, B:55:0x017a, B:22:0x0045, B:24:0x0049, B:11:0x002a), top: B:65:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0176 A[Catch: Exception -> 0x0181, TryCatch #1 {Exception -> 0x0181, blocks: (B:5:0x0017, B:7:0x001e, B:10:0x0027, B:15:0x0035, B:17:0x0039, B:18:0x003b, B:33:0x00a1, B:35:0x00ca, B:37:0x00d4, B:39:0x00da, B:41:0x00e1, B:43:0x00e7, B:44:0x00f0, B:46:0x00fa, B:47:0x0107, B:50:0x015b, B:51:0x016b, B:53:0x0176, B:55:0x017a, B:22:0x0045, B:24:0x0049, B:11:0x002a), top: B:65:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x017a A[Catch: Exception -> 0x0181, TRY_LEAVE, TryCatch #1 {Exception -> 0x0181, blocks: (B:5:0x0017, B:7:0x001e, B:10:0x0027, B:15:0x0035, B:17:0x0039, B:18:0x003b, B:33:0x00a1, B:35:0x00ca, B:37:0x00d4, B:39:0x00da, B:41:0x00e1, B:43:0x00e7, B:44:0x00f0, B:46:0x00fa, B:47:0x0107, B:50:0x015b, B:51:0x016b, B:53:0x0176, B:55:0x017a, B:22:0x0045, B:24:0x0049, B:11:0x002a), top: B:65:0x0017 }] */
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
        try {
            JSONObject jSONObject = new JSONObject();
            if (nVar != null && !TextUtils.isEmpty(nVar.f66109a)) {
                c2 = nVar.f66109a;
                if (i2 != 7) {
                    if (nVar != null && nVar.f66110b > 0) {
                        i3 = nVar.f66110b;
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
                                String a2 = com.bytedance.sdk.openadsdk.n.g.d.a(adSlot.getExternalABVid());
                                jSONObject2.put("external_ab_vid", a2);
                                com.bytedance.sdk.component.utils.k.c("NetApiImpl", "external_ab_vid ", a2);
                            }
                            jSONObject2.put("param", i4);
                            jSONObject2.put("tob_ab_sdk_version", w);
                            jSONObject.put("abtest", jSONObject2);
                        }
                    } catch (Throwable unused) {
                    }
                    jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, c2);
                    jSONObject.put("ad_sdk_version", "3.7.0.3");
                    jSONObject.put("source_type", "app");
                    jSONObject.put("logsdk_version", AppLogHelper.getInstance().getSdkVersion());
                    jSONObject.put("app", b());
                    e2 = com.bytedance.sdk.openadsdk.core.k.c.e(this.f66571c);
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
                    jSONObject.put("ua", com.bytedance.sdk.openadsdk.q.q.b());
                    jSONObject.put("channel", FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT);
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
                        jSONObject.put("ad_sdk_version", "3.7.0.3");
                        return jSONObject;
                    }
                    JSONObject a3 = com.bytedance.sdk.component.utils.a.a(jSONObject);
                    a3.put("ad_sdk_version", "3.7.0.3");
                    return a3;
                }
                if (i2 == 8 && nVar != null && nVar.f66111c > 0) {
                    i3 = nVar.f66111c;
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
                jSONObject.put("ad_sdk_version", "3.7.0.3");
                jSONObject.put("source_type", "app");
                jSONObject.put("logsdk_version", AppLogHelper.getInstance().getSdkVersion());
                jSONObject.put("app", b());
                e2 = com.bytedance.sdk.openadsdk.core.k.c.e(this.f66571c);
                if (e2 != null) {
                }
                jSONObject.put("device", e2);
                jSONObject.put("user", b(adSlot));
                jSONObject.put("ua", com.bytedance.sdk.openadsdk.q.q.b());
                jSONObject.put("channel", FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT);
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
            c2 = com.bytedance.sdk.openadsdk.q.q.c();
            if (i2 != 7) {
            }
        } catch (Exception unused2) {
            return new JSONObject();
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
    public void a(long j2, long j3, long j4, long j5) {
        com.bytedance.sdk.openadsdk.core.e.t tVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)}) == null) || (tVar = this.f66570a) == null) {
            return;
        }
        tVar.c(j2);
        this.f66570a.d(j4);
        this.f66570a.e(j3);
        this.f66570a.f(j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2, String str, int i2, a aVar, int i3, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{Long.valueOf(j2), str, Integer.valueOf(i2), aVar, Integer.valueOf(i3), str2}) == null) && com.bytedance.sdk.openadsdk.core.j.g.a()) {
            if (i2 == 4 || i2 == 3) {
                com.bytedance.sdk.component.d.e.b(new com.bytedance.sdk.component.d.g(this, "uploadAdTypeTimeOutEvent", i3, str2, i2, aVar, str, j2) { // from class: com.bytedance.sdk.openadsdk.core.q.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ int f66588a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f66589b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ int f66590c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ a f66591d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ String f66592e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ long f66593f;

                    /* renamed from: g  reason: collision with root package name */
                    public final /* synthetic */ q f66594g;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r8, Integer.valueOf(i3), str2, Integer.valueOf(i2), aVar, str, Long.valueOf(j2)};
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
                        this.f66594g = this;
                        this.f66588a = i3;
                        this.f66589b = str2;
                        this.f66590c = i2;
                        this.f66591d = aVar;
                        this.f66592e = str;
                        this.f66593f = j2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        String str3;
                        String str4;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            int i4 = this.f66588a;
                            com.bytedance.sdk.openadsdk.j.a.b g2 = new com.bytedance.sdk.openadsdk.j.a.b().a(this.f66590c).b(i4).g(TextUtils.isEmpty(this.f66589b) ? g.a(i4) : this.f66589b);
                            com.bytedance.sdk.openadsdk.core.e.m mVar = null;
                            try {
                                if (this.f66591d == null || this.f66591d.f66608h == null || this.f66591d.f66608h.c() == null || this.f66591d.f66608h.c().size() <= 0) {
                                    str3 = "";
                                    str4 = str3;
                                } else {
                                    mVar = this.f66591d.f66608h.c().get(0);
                                    str3 = mVar.ao();
                                    if (!TextUtils.isEmpty(str3)) {
                                        try {
                                            str4 = new JSONObject(str3).getString(IAdRequestParam.REQ_ID);
                                        } catch (Throwable unused) {
                                        }
                                    }
                                    str4 = "";
                                }
                                if (TextUtils.isEmpty(str4) && this.f66591d != null && this.f66591d.f66608h != null) {
                                    str4 = this.f66591d.f66608h.a();
                                }
                                g2.f(str4).d(mVar != null ? mVar.ak() : "").h(str3).c(this.f66592e).a(this.f66593f).b(this.f66591d != null ? this.f66591d.f66601a : 0L);
                            } catch (Throwable th) {
                                com.bytedance.sdk.component.utils.k.c("NetApiImpl", "uploadAdTypeTimeOutEvent throws exception ", th);
                            }
                            com.bytedance.sdk.openadsdk.j.a.a().e(g2);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.bytedance.sdk.openadsdk.core.e.n nVar, long j2, long j3, a aVar, long j4, com.bytedance.sdk.openadsdk.core.e.m mVar, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65547, this, new Object[]{nVar, Long.valueOf(j2), Long.valueOf(j3), aVar, Long.valueOf(j4), mVar, str}) == null) && o.h().v()) {
            JSONObject jSONObject = new JSONObject();
            long j5 = 0;
            if (nVar != null) {
                try {
                    if (nVar.f66114f > 0) {
                        jSONObject.put("client_start_time", j2 - nVar.f66114f);
                        j5 = j4 - nVar.f66114f;
                    }
                } catch (Exception unused) {
                    return;
                }
            }
            jSONObject.put("network_time", j3 - j2);
            jSONObject.put("sever_time", aVar.f66601a);
            jSONObject.put("client_end_time", j4 - j3);
            try {
                com.bytedance.sdk.openadsdk.e.d.a(this.f66571c, mVar, str, "load_ad_time", j5, jSONObject);
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
        if (!(interceptable == null || interceptable.invokeL(65555, this, aVar) == null) || aVar == null || (jSONObject = aVar.f67304b) == null) {
            return;
        }
        String optString = jSONObject.optString("log_extra", "");
        long e2 = com.bytedance.sdk.openadsdk.q.q.e(optString);
        int f2 = com.bytedance.sdk.openadsdk.q.q.f(optString);
        if (e2 == 0) {
            e2 = this.f66574f;
        }
        this.f66574f = e2;
        if (f2 == 0) {
            f2 = this.f66575g;
        }
        this.f66575g = f2;
    }

    private void a(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.e.n nVar) {
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65556, this, jSONObject, nVar) == null) && nVar != null && (jSONArray = nVar.f66112d) != null) {
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
                    com.bytedance.sdk.openadsdk.e.d.a(this.f66571c, b2, System.currentTimeMillis());
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
                com.bytedance.sdk.openadsdk.m.a.a(jSONObject);
                jSONObject.put("is_paid_app", h.d().k());
                jSONObject.put("apk_sign", com.bytedance.sdk.openadsdk.m.a.e());
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
                com.bytedance.sdk.openadsdk.m.a.d(this.f66571c, jSONObject);
                a(jSONObject, "data", c(adSlot));
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0004, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0092  */
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
                char c2 = 'I';
                char c3 = '`';
                while (true) {
                    switch (c2) {
                        case 'H':
                            c2 = 'J';
                            c3 = '7';
                        case 'I':
                            switch (c3) {
                                case '_':
                                case '`':
                                    c2 = 'J';
                                    c3 = '7';
                            }
                            break;
                        case 'J':
                            break;
                        default:
                            c2 = 'H';
                    }
                    switch (c3) {
                        case '7':
                            JSONObject jSONObject = new JSONObject();
                            try {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("action", "dislike");
                                jSONObject2.put("timestamp", System.currentTimeMillis());
                                jSONObject2.put("ad_sdk_version", "3.7.0.3");
                                com.bytedance.sdk.openadsdk.m.a.a(this.f66571c, jSONObject2);
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
                }
            }
        }
        return (JSONObject) invokeLL.objValue;
    }

    private boolean b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65565, this, jSONObject)) == null) ? jSONObject != null && jSONObject.length() > 0 : invokeL.booleanValue;
    }

    private String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65566, this)) == null) ? com.bytedance.sdk.openadsdk.core.k.c.a(true) : (String) invokeV.objValue;
    }

    private String c(AdSlot adSlot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, this, adSlot)) == null) {
            String d2 = d(adSlot);
            Map<String, Object> n = h.d().n();
            if (n != null && !n.isEmpty()) {
                try {
                    JSONArray jSONArray = TextUtils.isEmpty(d2) ? new JSONArray() : new JSONArray(d2);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        String optString = optJSONObject != null ? optJSONObject.optString("name") : "";
                        if (!TextUtils.isEmpty(optString) && n.containsKey(optString)) {
                            n.remove(optString);
                        }
                    }
                    for (Map.Entry<String, Object> entry : n.entrySet()) {
                        if (!TextUtils.isEmpty(entry.getKey())) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("name", entry.getKey());
                            jSONObject.put("value", entry.getValue());
                            jSONArray.put(jSONObject);
                        }
                    }
                    return jSONArray.toString();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return d2;
        }
        return (String) invokeL.objValue;
    }

    private JSONArray c(List<FilterWord> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, this, list)) == null) {
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
        if ((interceptable == null || interceptable.invokeL(65569, this, jSONObject) == null) && jSONObject != null && h.d().x()) {
            Map<String, String> d2 = d(jSONObject);
            PostExecutor postExecutor = com.bytedance.sdk.openadsdk.k.d.b().c().getPostExecutor();
            postExecutor.setUrl(com.bytedance.sdk.openadsdk.q.q.l());
            if (d2 != null) {
                for (Map.Entry<String, String> entry : d2.entrySet()) {
                    postExecutor.addHeader(entry.getKey(), entry.getValue());
                }
            }
            postExecutor.setJson(jSONObject.toString());
            postExecutor.addHeader("User-Agent", com.bytedance.sdk.openadsdk.q.q.b());
            postExecutor.enqueue(new NetCallback(this) { // from class: com.bytedance.sdk.openadsdk.core.q.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f66595a;

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
                    this.f66595a = this;
                }

                @Override // com.bytedance.sdk.component.net.callback.NetCallback
                public void onFailure(NetExecutor netExecutor, IOException iOException) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, netExecutor, iOException) == null) {
                        com.bytedance.sdk.component.utils.k.b("NetApiImpl", "onFailure: ", iOException.getMessage());
                    }
                }

                @Override // com.bytedance.sdk.component.net.callback.NetCallback
                public void onResponse(NetExecutor netExecutor, NetResponse netResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, netExecutor, netResponse) == null) {
                        if (netResponse == null || !netResponse.isSuccess()) {
                            com.bytedance.sdk.component.utils.k.c("NetApiImpl", "onResponse: NetResponse is null");
                        } else {
                            com.bytedance.sdk.component.utils.k.b("NetApiImpl", "onResponse: ", netResponse.getBody());
                        }
                    }
                }
            });
        }
    }

    private String d(AdSlot adSlot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, this, adSlot)) == null) {
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
                                            jSONObject.put("ua", com.bytedance.sdk.openadsdk.q.q.b());
                                            com.bytedance.sdk.openadsdk.m.a.c(this.f66571c, jSONObject);
                                            jSONObject.put("openudid", j.c(this.f66571c));
                                            jSONObject.put("oaid", com.bytedance.sdk.openadsdk.q.k.a());
                                            jSONObject.put("ad_sdk_version", "3.7.0.3");
                                            jSONObject.put("sim_op", a(this.f66571c));
                                            jSONObject.put(PrefetchEvent.EVENT_DATA_ROOT_PATH, this.f66572d ? 1 : 0);
                                            jSONObject.put(BaseStatisContent.TIMEZONE, g());
                                            jSONObject.put("access", com.bytedance.sdk.component.utils.n.g(this.f66571c));
                                            jSONObject.put("os", "Android");
                                            jSONObject.put(HttpConstants.OS_VERSION, Build.VERSION.RELEASE);
                                            jSONObject.put("os_api", Build.VERSION.SDK_INT);
                                            jSONObject.put(HttpConstants.DEVICE_TYPE, this.f66573e);
                                            jSONObject.put("device_model", Build.MODEL);
                                            jSONObject.put("device_brand", Build.BRAND);
                                            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
                                            jSONObject.put("language", Locale.getDefault().getLanguage());
                                            jSONObject.put("resolution", com.bytedance.sdk.openadsdk.q.s.d(this.f66571c) + "x" + com.bytedance.sdk.openadsdk.q.s.c(this.f66571c));
                                            jSONObject.put("display_density", a(com.bytedance.sdk.openadsdk.q.s.f(this.f66571c)));
                                            jSONObject.put("density_dpi", com.bytedance.sdk.openadsdk.q.s.f(this.f66571c));
                                            jSONObject.put("device_id", j.a(this.f66571c));
                                            jSONObject.put("aid", "1371");
                                            jSONObject.put("rom", f());
                                            jSONObject.put(PmsConstant.EnvParam.Key.CPU_ABI, Build.CPU_ABI);
                                            jSONObject.put("build_serial", j.i(this.f66571c));
                                            jSONObject.put("ut", this.f66575g);
                                            jSONObject.put("uid", this.f66574f);
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
                                            jSONObject.put("mnc", com.bytedance.sdk.openadsdk.q.m.b());
                                            jSONObject.put("mcc", com.bytedance.sdk.openadsdk.q.m.a());
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
            if (com.bytedance.sdk.openadsdk.q.l.e()) {
                str = "MIUI-";
            } else if (!com.bytedance.sdk.openadsdk.q.l.b()) {
                String n = com.bytedance.sdk.openadsdk.q.l.n();
                if (com.bytedance.sdk.openadsdk.q.l.a(n)) {
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
                jSONObject.put("package_name", com.bytedance.sdk.openadsdk.q.q.d());
                jSONObject.put("version_code", com.bytedance.sdk.openadsdk.q.q.e());
                jSONObject.put("version", com.bytedance.sdk.openadsdk.q.q.f());
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
        if (f66569h) {
            int optInt = jSONObject.optInt("cypher", -1);
            String optString = jSONObject.optString("message");
            if (optInt == 3) {
                optString = com.bytedance.sdk.component.utils.a.b(optString);
            }
            if (!TextUtils.isEmpty(optString)) {
                jSONObject2 = new JSONObject(optString);
                return !f66569h ? jSONObject2 : jSONObject;
            }
        }
        jSONObject2 = jSONObject;
        if (!f66569h) {
        }
    }

    private String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65579, this)) == null) ? com.bytedance.sdk.openadsdk.core.k.c.c(this.f66571c) ? "tv" : com.bytedance.sdk.openadsdk.core.k.c.b(this.f66571c) ? "android_pad" : "android" : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    public com.bytedance.sdk.openadsdk.core.e.u a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (com.bytedance.sdk.openadsdk.core.j.g.a()) {
                com.bytedance.sdk.component.adnet.b.d.a();
                String z = o.h().z();
                GetExecutor getExecutor = com.bytedance.sdk.openadsdk.k.d.b().c().getGetExecutor();
                getExecutor.setUrl(com.bytedance.sdk.openadsdk.q.p.b(z));
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
                            jSONArray.put(aVar.f67304b);
                        }
                        jSONObject.put("event", jSONArray);
                        jSONObject.put("_gen_time", System.currentTimeMillis());
                    } catch (JSONException unused) {
                    }
                    JSONObject a2 = com.bytedance.sdk.component.utils.a.a(jSONObject);
                    if (!b(a2)) {
                        a2 = jSONObject;
                    }
                    if (com.bytedance.sdk.component.utils.k.c()) {
                        com.bytedance.sdk.component.utils.k.b("adevent", "adevent is :" + jSONObject.toString());
                    }
                    Map<String, String> d2 = d(a2);
                    PostExecutor postExecutor = com.bytedance.sdk.openadsdk.k.d.b().c().getPostExecutor();
                    postExecutor.setUrl(com.bytedance.sdk.openadsdk.q.q.k());
                    if (d2 != null) {
                        for (Map.Entry<String, String> entry : d2.entrySet()) {
                            postExecutor.addHeader(entry.getKey(), entry.getValue());
                        }
                    }
                    postExecutor.setJson(a2.toString());
                    postExecutor.addHeader("User-Agent", com.bytedance.sdk.openadsdk.q.q.b());
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
                com.bytedance.sdk.component.utils.k.c("NetApiImpl", "uploadEvent error", th);
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
                PostExecutor postExecutor = com.bytedance.sdk.openadsdk.k.d.b().c().getPostExecutor();
                postExecutor.setUrl(com.bytedance.sdk.openadsdk.q.q.l("/api/ad/union/sdk/stats/batch/"));
                postExecutor.setJson(a2.toString());
                postExecutor.addHeader("User-Agent", com.bytedance.sdk.openadsdk.q.q.b());
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
                nVar.f66110b = 1;
            } else if (8 == adSlot.getAdType()) {
                nVar.f66111c = 1;
            } else if (3 == adSlot.getAdType()) {
                nVar.f66114f = System.currentTimeMillis();
            }
            if (o.h().i(adSlot.getCodeId())) {
                nVar.f66113e = 2;
            }
            if (z) {
                nVar.f66113e = 2;
                if (i2 == 1 || i2 == 2) {
                    adSlot.setNativeAdType(i2);
                }
            }
            if (5 == adSlot.getNativeAdType() || 1 == adSlot.getNativeAdType() || 2 == adSlot.getNativeAdType()) {
                nVar.f66113e = 2;
            }
            if (adSlot.getAdType() > 0) {
                i2 = adSlot.getAdType();
            } else if (i2 <= 0) {
                i2 = 0;
            }
            JSONObject a2 = a(adSlot, nVar, i2, true);
            JSONObject jSONObject2 = new JSONObject();
            try {
                com.bytedance.sdk.openadsdk.m.a.a(jSONObject2, a2);
                jSONObject2.putOpt("User-Agent", com.bytedance.sdk.openadsdk.q.q.b());
                jSONObject.putOpt("header", jSONObject2);
                jSONObject.putOpt("bid_request", a2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String a3 = com.bytedance.sdk.component.utils.a.a(jSONObject.toString());
            com.bytedance.sdk.component.utils.k.b("NetApiImpl", "bidding toke: 0000000003" + a3);
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
                    public final /* synthetic */ AdSlot f66576a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ com.bytedance.sdk.openadsdk.core.e.n f66577b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ int f66578c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ p.b f66579d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ q f66580e;

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
                        this.f66580e = this;
                        this.f66576a = adSlot;
                        this.f66577b = nVar;
                        this.f66578c = i2;
                        this.f66579d = bVar;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f66580e.b(this.f66576a, this.f66577b, this.f66578c, this.f66579d);
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
            this.f66570a = tVar;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    public void a(@NonNull com.bytedance.sdk.openadsdk.dislike.c.b bVar, List<FilterWord> list) {
        JSONObject b2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, bVar, list) == null) && com.bytedance.sdk.openadsdk.core.j.g.a() && (b2 = b(bVar, list)) != null) {
            PostExecutor postExecutor = com.bytedance.sdk.openadsdk.k.d.b().c().getPostExecutor();
            postExecutor.setUrl(com.bytedance.sdk.openadsdk.q.q.l("/api/ad/union/dislike_event/"));
            postExecutor.setJson(com.bytedance.sdk.component.utils.a.a(b2).toString());
            postExecutor.enqueue(new NetCallback(this) { // from class: com.bytedance.sdk.openadsdk.core.q.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f66596a;

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
                    this.f66596a = this;
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
                PostExecutor postExecutor = com.bytedance.sdk.openadsdk.k.d.b().c().getPostExecutor();
                postExecutor.setUrl(com.bytedance.sdk.openadsdk.q.q.l("/api/ad/union/sdk/material/check/"));
                postExecutor.setJson(com.bytedance.sdk.component.utils.a.a(a2));
                postExecutor.enqueue(new NetCallback(this, aVar) { // from class: com.bytedance.sdk.openadsdk.core.q.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ p.a f66599a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ q f66600b;

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
                        this.f66600b = this;
                        this.f66599a = aVar;
                    }

                    @Override // com.bytedance.sdk.component.net.callback.NetCallback
                    public void onFailure(NetExecutor netExecutor, IOException iOException) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, netExecutor, iOException) == null) {
                            this.f66599a.a(false, 0L, 0L);
                        }
                    }

                    @Override // com.bytedance.sdk.component.net.callback.NetCallback
                    public void onResponse(NetExecutor netExecutor, NetResponse netResponse) {
                        boolean z;
                        long j2;
                        long j3;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, netExecutor, netResponse) == null) || netResponse == null) {
                            return;
                        }
                        if (netResponse.isSuccess()) {
                            long j4 = 0;
                            if (netResponse.getBody() != null) {
                                try {
                                    b a3 = b.a(new JSONObject(netResponse.getBody()));
                                    r0 = a3.f66610a;
                                    j4 = netResponse.getDuration();
                                    z = a3.f66611b;
                                    j2 = r0;
                                    j3 = j4;
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                }
                                this.f66599a.a(z, j2, j3);
                                return;
                            }
                            j2 = r0;
                            j3 = j4;
                            z = false;
                            this.f66599a.a(z, j2, j3);
                            return;
                        }
                        this.f66599a.a(false, netResponse.getCode() != 0 ? netResponse.getCode() : -1L, netResponse.getDuration());
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
                PostExecutor postExecutor = com.bytedance.sdk.openadsdk.k.d.b().c().getPostExecutor();
                postExecutor.setUrl(com.bytedance.sdk.openadsdk.q.q.l("/api/ad/union/sdk/reward_video/reward/"));
                postExecutor.setJson(a2.toString());
                postExecutor.enqueue(new NetCallback(this, cVar) { // from class: com.bytedance.sdk.openadsdk.core.q.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ p.c f66597a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ q f66598b;

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
                        this.f66598b = this;
                        this.f66597a = cVar;
                    }

                    @Override // com.bytedance.sdk.component.net.callback.NetCallback
                    public void onFailure(NetExecutor netExecutor, IOException iOException) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, netExecutor, iOException) == null) {
                            this.f66597a.a(-2, iOException.getMessage());
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
                                        if (a3.f66612a != 20000) {
                                            this.f66597a.a(a3.f66612a, g.a(a3.f66612a));
                                            return;
                                        } else if (a3.f66614c == null) {
                                            this.f66598b.a(this.f66597a);
                                            return;
                                        } else {
                                            this.f66597a.a(a3);
                                            return;
                                        }
                                    } catch (JSONException e2) {
                                        e2.printStackTrace();
                                        this.f66598b.a(this.f66597a);
                                        return;
                                    }
                                }
                                String a4 = g.a(-2);
                                int code = netResponse.getCode();
                                if (!netResponse.isSuccess() && !TextUtils.isEmpty(netResponse.getMessage())) {
                                    a4 = netResponse.getMessage();
                                }
                                this.f66597a.a(code, a4);
                                return;
                            }
                            this.f66598b.a(this.f66597a);
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
                PostExecutor postExecutor = com.bytedance.sdk.openadsdk.k.d.b().c().getPostExecutor();
                postExecutor.setUrl(com.bytedance.sdk.openadsdk.q.p.b("https://i.snssdk.com/inspect/aegis/client/page/"));
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
            try {
                if (!com.bytedance.sdk.openadsdk.core.j.g.a()) {
                    if (bVar != null) {
                        bVar.a(1000, "广告请求开关已关闭,请联系穿山甲管理员");
                        return;
                    }
                    return;
                }
                d.a().c();
                com.bytedance.sdk.component.d.e.a(new com.bytedance.sdk.component.d.g(this, "getAd") { // from class: com.bytedance.sdk.openadsdk.core.q.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ q f66581a;

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
                        this.f66581a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            l.c().postDelayed(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.q.2.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass2 f66582a;

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
                                    this.f66582a = this;
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
                            com.bytedance.sdk.openadsdk.m.a.c();
                        }
                    }
                }, 10);
                if (bVar == null) {
                    return;
                }
                if (a(adSlot.getCodeId())) {
                    bVar.a(-8, g.a(-8));
                } else if (!TextUtils.isEmpty(adSlot.getBidAdm())) {
                    com.bytedance.sdk.component.utils.k.a("bidding", "getAd bidAdm有效，则直接解析返回广告：BidAdm->MD5->", com.bytedance.sdk.openadsdk.n.g.b.a(adSlot.getBidAdm()));
                    JSONObject g2 = g(new JSONObject(adSlot.getBidAdm()));
                    if (g2 == null) {
                        a(bVar);
                        return;
                    }
                    a a2 = a.a(g2, adSlot, nVar);
                    j.a(this.f66571c, a2.f66609i);
                    if (a2.f66604d != 20000) {
                        bVar.a(a2.f66604d, a2.f66605e);
                    } else if (a2.f66608h == null) {
                        a(bVar);
                    } else {
                        a2.f66608h.c(g2.toString());
                        bVar.a(a2.f66608h);
                    }
                } else {
                    com.bytedance.sdk.openadsdk.o.a.a(adSlot);
                    JSONObject a3 = a(adSlot, nVar, i2, false);
                    if (a3 == null) {
                        bVar.a(-9, g.a(-9));
                        return;
                    }
                    String a4 = com.bytedance.sdk.openadsdk.q.q.a("/api/ad/union/sdk/get_ads/", true);
                    PostExecutor postExecutor = com.bytedance.sdk.openadsdk.k.d.b().c().getPostExecutor();
                    postExecutor.setUrl(a4);
                    postExecutor.setJson(a3);
                    HashMap hashMap = new HashMap();
                    hashMap.put("extra_time_start", Long.valueOf(System.currentTimeMillis()));
                    postExecutor.setExtraMap(hashMap);
                    postExecutor.addHeader("User-Agent", com.bytedance.sdk.openadsdk.q.q.b());
                    Map<String, String> b2 = com.bytedance.sdk.openadsdk.m.a.b(a4, a3.toString());
                    com.bytedance.sdk.openadsdk.q.p.a(b2);
                    if (b2 != null && b2.size() > 0) {
                        for (Map.Entry<String, String> entry : b2.entrySet()) {
                            postExecutor.addHeader(entry.getKey(), entry.getValue());
                        }
                    }
                    postExecutor.enqueue(new NetCallback(this, bVar, adSlot, i2, nVar) { // from class: com.bytedance.sdk.openadsdk.core.q.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ p.b f66583a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ AdSlot f66584b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ int f66585c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ com.bytedance.sdk.openadsdk.core.e.n f66586d;

                        /* renamed from: e  reason: collision with root package name */
                        public final /* synthetic */ q f66587e;

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
                            this.f66587e = this;
                            this.f66583a = bVar;
                            this.f66584b = adSlot;
                            this.f66585c = i2;
                            this.f66586d = nVar;
                        }

                        @Override // com.bytedance.sdk.component.net.callback.NetCallback
                        public void onFailure(NetExecutor netExecutor, IOException iOException) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(1048576, this, netExecutor, iOException) == null) {
                                long longValue = ((Long) netExecutor.getExtraMap().get("extra_time_start")).longValue();
                                long currentTimeMillis = System.currentTimeMillis();
                                if (this.f66583a != null) {
                                    if (iOException != null && SocketTimeoutException.class.equals(iOException.getCause())) {
                                        this.f66583a.a(602, iOException.getMessage());
                                    }
                                    this.f66583a.a(602, iOException.getMessage());
                                }
                                com.bytedance.sdk.component.utils.k.b("NetApiImpl", "onFailure: ", 601);
                                this.f66587e.a(currentTimeMillis - longValue, this.f66584b.getCodeId(), this.f66585c, null, 601, iOException.getMessage());
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
                                long j2 = 0;
                                try {
                                    j2 = ((Long) netExecutor.getExtraMap().get("extra_time_start")).longValue();
                                } catch (Throwable unused) {
                                    z = false;
                                }
                                try {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    JSONObject g3 = this.f66587e.g(new JSONObject(netResponse.getBody()));
                                    if (g3 == null) {
                                        this.f66587e.a(this.f66583a);
                                        this.f66587e.a(netResponse.getDuration(), this.f66584b.getCodeId(), this.f66585c, null, -1, "mate parse_fail");
                                        return;
                                    }
                                    a a5 = a.a(g3, this.f66584b, this.f66586d);
                                    j.a(this.f66587e.f66571c, a5.f66609i);
                                    if (a5.f66604d != 20000) {
                                        this.f66583a.a(a5.f66604d, a5.f66605e);
                                        this.f66587e.a(netResponse.getDuration(), this.f66584b.getCodeId(), this.f66585c, a5, a5.f66604d, String.valueOf(a5.f66606f));
                                        return;
                                    } else if (a5.f66608h == null) {
                                        this.f66587e.a(this.f66583a);
                                        this.f66587e.a(netResponse.getDuration(), this.f66584b.getCodeId(), this.f66585c, a5, -1, "parse_fail");
                                        return;
                                    } else {
                                        a5.f66608h.c(g3.toString());
                                        long currentTimeMillis2 = System.currentTimeMillis();
                                        this.f66583a.a(a5.f66608h);
                                        Map<String, com.bytedance.sdk.openadsdk.core.e.m> a6 = com.bytedance.sdk.openadsdk.core.e.a.a(a5.f66608h);
                                        if (a6 != null) {
                                            com.bytedance.sdk.openadsdk.f.a.a().a(a6);
                                        }
                                        if (!z || a5.f66608h.c() == null || a5.f66608h.c().isEmpty()) {
                                            jSONObject = g3;
                                        } else {
                                            jSONObject = g3;
                                            this.f66587e.a(this.f66586d, j2, currentTimeMillis, a5, currentTimeMillis2, a5.f66608h.c().get(0), com.bytedance.sdk.openadsdk.q.q.b(this.f66585c));
                                            this.f66587e.a(j2 - this.f66586d.f66114f, a5.f66601a, currentTimeMillis - j2, currentTimeMillis2 - currentTimeMillis);
                                        }
                                        com.bytedance.sdk.openadsdk.a.b.a().a(jSONObject);
                                        return;
                                    }
                                } catch (Throwable th) {
                                    com.bytedance.sdk.component.utils.k.c("NetApiImpl", "get ad error: ", th);
                                    this.f66587e.a(this.f66583a);
                                    this.f66587e.a(netResponse.getDuration(), this.f66584b.getCodeId(), this.f66585c, null, -1, "parse_fail");
                                    return;
                                }
                            }
                            int code = netResponse.getCode();
                            String message = netResponse.getMessage();
                            this.f66583a.a(code, message);
                            this.f66587e.a(netResponse.getDuration(), this.f66584b.getCodeId(), this.f66585c, null, code, message);
                        }
                    });
                }
            } catch (Throwable th) {
                if (bVar != null) {
                    bVar.a(4000, th.getMessage());
                    com.bytedance.sdk.component.utils.k.c("NetApiImpl", " msg = ", th.getMessage());
                }
            }
        }
    }
}
