package com.baidu.tieba;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.nadcore.requester.NadRequester;
import com.baidu.nadcore.requester.RequestParameters;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class q01 implements s01 {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] c;
    public static final Map<String, String> d;
    public static final JSONArray e;
    public static final lj0 f;
    public static String g;
    public transient /* synthetic */ FieldHolder $fh;
    public final y01 b;

    /* loaded from: classes5.dex */
    public class a extends ir0<b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RequestParameters a;
        public final /* synthetic */ NadRequester.b b;

        public a(q01 q01Var, RequestParameters requestParameters, NadRequester.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q01Var, requestParameters, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = requestParameters;
            this.b = bVar;
        }

        @Override // com.baidu.tieba.gr0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
                this.b.a(new NadRequester.Error());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hr0
        /* renamed from: e */
        public void b(Headers headers, b bVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, bVar, i) == null) {
                if (bVar != null) {
                    this.b.b(Arrays.asList(bVar.a));
                } else {
                    this.b.a(new NadRequester.Error());
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hr0
        /* renamed from: f */
        public b d(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) {
                AdBaseModel[] c = aq0.c(str, new String[]{this.a.a});
                ArrayList arrayList = new ArrayList();
                for (AdBaseModel adBaseModel : c) {
                    if (this.a.m || adBaseModel.f.a != AdBaseModel.STYLE.HIDDEN) {
                        arrayList.add(adBaseModel);
                        adBaseModel.a(this.a.e);
                    }
                }
                b bVar = new b(null);
                bVar.a = (AdBaseModel[]) arrayList.toArray(new AdBaseModel[0]);
                return bVar;
            }
            return (b) invokeLLI.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AdBaseModel[] a;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948037911, "Lcom/baidu/tieba/q01;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948037911, "Lcom/baidu/tieba/q01;");
                return;
            }
        }
        c = new byte[]{48, -127, -97, 48, 13, 6, 9, ExifInterface.START_CODE, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0, 48, -127, -119, 2, -127, -127, 0, -69, 118, 15, 43, -102, -34, -94, -8, -78, 1, 17, -80, 84, 56, 79, 40, -89, 68, 50, 105, -35, 111, -70, 68, -68, ExifInterface.MARKER_SOF0, 62, 111, -66, -108, 77, 21, 106, 69, -34, 94, -1, 18, -100, -75, 7, 48, ExifInterface.MARKER_SOF5, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 50, ExifInterface.MARKER_SOF6, -124, 23, -97, -14, 100, 67, 115, -70, 4, 2, 47, -36, Constants.GZIP_CAST_TYPE, 80, 6, -88, 116, ExifInterface.MARKER_SOS, -121, -4, ExifInterface.MARKER_SOF3, -13, -32, 106, 7, 85, ExifInterface.MARKER_EOI, 111, 53, 0, -35, Base64.INTERNAL_PADDING, 33, 106, -125, ExifInterface.MARKER_SOF5, 100, -42, -32, 15, -108, 33, -14, 67, 124, 57, -83, -91, -86, -67, ExifInterface.MARKER_SOF7, 19, 90, -113, -41, 69, -25, 70, 70, 111, -41, -47, 76, -85, 118, -52, 110, -56, -28, 9, 75, 2, 43, -35, 15, 58, 31, 126, 8, 27, -82, -107, 2, 3, 1, 0, 1};
        d = new HashMap();
        e = new JSONArray();
        f = ej0.a();
        g = null;
        e("is_https", "1");
        String e2 = uj0.c().e(false);
        if (!TextUtils.isEmpty(e2)) {
            e(SearchJsBridge.COOKIE_MOD, e2);
        }
        e("ua", f.p());
        e("fmt", "json");
        e("apna", f.packageName());
        e("ver", f.v());
        String h = uj0.c().h(false);
        if (!TextUtils.isEmpty(h)) {
            e("ov", h);
        }
        e("ot", "2");
        e(Config.EXCEPTION_CRASH_TYPE, "2");
        e("cuid", f.g());
        e("uid", f.s());
        e(TiebaStatic.Params.BDID, f.n());
        e("encrypted_imei", h());
        String a2 = uj0.c().a(false);
        if (!TextUtils.isEmpty(a2)) {
            e(HttpRequest.ANDROID_ID, a2);
        }
        e.put(g(AdExtParam.KEY_NAD_CORE_VERSION, "5.10.0.26"));
        e.put(g("os_br", Build.BRAND));
        String g2 = uj0.c().g(false);
        if (!TextUtils.isEmpty(g2)) {
            e.put(g("os_mafa", g2));
        }
        String d2 = uj0.c().d(false);
        if (!TextUtils.isEmpty(d2)) {
            e.put(g("mac", d2));
        }
        String f2 = uj0.c().f(false);
        if (!TextUtils.isEmpty(f2)) {
            e.put(g("oaid_v", f2));
        }
        try {
            e.put(g("encoded_ua_new", URLEncoder.encode(ej0.e(), IMAudioTransRequest.CHARSET)));
        } catch (UnsupportedEncodingException unused) {
        }
    }

    public q01() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = b11.a().b("nad.refresh_count.sp");
    }

    public static void c(@Nullable JSONArray jSONArray, @Nullable Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, jSONArray, map) == null) && jSONArray != null && !t01.h(map)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && !TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                    jSONArray.put(g(entry.getKey(), entry.getValue()));
                }
            }
        }
    }

    public static void d(@NonNull or0 or0Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, or0Var, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            or0Var.a(str, str2);
        }
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            d.put(str, str2);
        }
    }

    public static JSONObject g(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("k", str);
                jSONObject.put("v", str2);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            String str = g;
            if (str != null) {
                return str;
            }
            try {
                String b2 = uj0.c().b(false);
                if (TextUtils.isEmpty(b2)) {
                    g = "";
                } else {
                    byte[] a2 = d41.a(b2.getBytes(), d41.b(c));
                    if (a2 != null) {
                        g = new String(android.util.Base64.encode(a2, 2));
                    } else {
                        g = "";
                    }
                }
            } catch (Throwable unused) {
                g = "";
            }
            return g;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s01
    public void a(@NonNull RequestParameters requestParameters, @NonNull NadRequester.b bVar) {
        NadRequester.Error error;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, requestParameters, bVar) == null) {
            wq0 b2 = wq0.b();
            pr0 pr0Var = new pr0();
            JSONArray jSONArray = new JSONArray();
            or0 e2 = or0.e(d);
            for (int i = 0; i < e.length(); i++) {
                jSONArray.put(e.opt(i));
            }
            jSONArray.put(g(AdExtParam.KEY_IADEX, jh0.e()));
            if (TextUtils.isEmpty(requestParameters.a)) {
                error = new NadRequester.Error("missing placeId");
            } else {
                error = null;
            }
            if (requestParameters.j == RequestParameters.SlotType.REWARD) {
                if (TextUtils.isEmpty(requestParameters.h)) {
                    error = new NadRequester.Error("missing tu");
                }
                if (TextUtils.isEmpty(requestParameters.i)) {
                    error = new NadRequester.Error("missing app_sid");
                }
                pr0Var.a("X-BD-SDK-SOURCE", "reward");
                d(e2, "appsid", requestParameters.i);
                jSONArray.put(g("tu", requestParameters.h));
                jSONArray.put(g("app_sid", requestParameters.i));
            }
            if (error != null) {
                bVar.a(error);
                return;
            }
            if (sg0.a && !TextUtils.isEmpty(ej0.d().j())) {
                pr0Var.l(ej0.d().j());
            } else {
                pr0Var.l("https://afd.baidu.com/afd/entry");
            }
            d(e2, "pid", requestParameters.a);
            d(e2, "ac", String.valueOf(requestParameters.b));
            d(e2, "ft", requestParameters.f.value);
            d(e2, "tabid", requestParameters.d);
            d(e2, "tabn", requestParameters.c);
            f(e2, requestParameters.a, requestParameters.c);
            d(e2, "nt", String.valueOf(new er0().c()));
            d(e2, "qe", requestParameters.g);
            c(jSONArray, requestParameters.l);
            d(e2, "ext", jSONArray.toString());
            d(e2, "eid", f.i());
            b(e2, requestParameters.k);
            pr0Var.a("User-Agent", ej0.e());
            pr0Var.f(e2);
            b2.a().a(pr0Var, new a(this, requestParameters, bVar));
        }
    }

    public final void b(@NonNull or0 or0Var, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, or0Var, map) != null) || t01.h(map)) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                d(or0Var, entry.getKey(), entry.getValue());
            }
        }
    }

    public final void f(@NonNull or0 or0Var, String str, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, or0Var, str, str2) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("_");
            if (str2 == null) {
                str3 = "";
            } else {
                str3 = str2;
            }
            sb.append(str3);
            sb.append("_fc");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append("_");
            if (str2 == null) {
                str2 = "";
            }
            sb3.append(str2);
            sb3.append("_ts");
            String sb4 = sb3.toString();
            long currentTimeMillis = System.currentTimeMillis();
            int i = 1;
            if (q31.d(this.b.getLong(sb4, 0L), currentTimeMillis)) {
                i = this.b.getInt(sb2, 1);
            }
            this.b.h(sb4, currentTimeMillis);
            this.b.g(sb2, i + 1);
            d(or0Var, "fc", String.valueOf(i));
        }
    }
}
