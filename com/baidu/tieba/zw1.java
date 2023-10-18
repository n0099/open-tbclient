package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class zw1 extends pw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.tt1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "SystemInfoApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes9.dex */
    public class a implements lj3<qx1> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zw1 a;

        public a(zw1 zw1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zw1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zw1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lj3
        /* renamed from: a */
        public qx1 call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject d = dz2.c().d("getSystemInfo");
                if (d == null) {
                    zw1 zw1Var = this.a;
                    d = zw1Var.H(zw1Var.i());
                    dz2.c().h("getSystemInfo", d);
                    dz2.c().h("getSystemInfoSync", d);
                }
                if (d == null) {
                    return new qx1(202, "empty joData");
                }
                return new qx1(0, d);
            }
            return (qx1) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ lj3 b;
        public final /* synthetic */ zw1 c;

        public b(zw1 zw1Var, String str, lj3 lj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zw1Var, str, lj3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zw1Var;
            this.a = str;
            this.b = lj3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, (qx1) this.b.call());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zw1(@NonNull rt1 rt1Var) {
        super(rt1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rt1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((rt1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static String G(Context context) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (context instanceof SwanAppActivity) {
                i = ((SwanAppActivity) context).R();
            } else {
                i = 0;
            }
            if (i == 1) {
                return ue3.i(xo2.i().m(), i);
            }
            return ue3.i(jc2.V().e0(), i);
        }
        return (String) invokeL.objValue;
    }

    public static void C(@NonNull JSONObject jSONObject) throws JSONException {
        p53 M;
        o83 h;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, jSONObject) == null) && (M = p53.M()) != null && M.f0().f("mapp_location")) {
            pp2 I = wo2.I();
            if (I == null) {
                h = null;
            } else {
                h = I.h();
            }
            if (h == null) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("city", h.k);
            jSONObject2.put("cityCode", h.l);
            jSONObject2.put("country", h.i);
            jSONObject2.put("district", h.n);
            jSONObject2.put("province", h.m);
            jSONObject2.put("street", h.o);
            jSONObject2.put("streetNumber", h.p);
            jSONObject2.put("coord_gcj02", E(h, "gcj02"));
            jSONObject2.put("coord_wgs84", E(h, "wgs84"));
            jSONObject.put("cacheLocation", jSONObject2);
        }
    }

    public static JSONObject E(@NonNull o83 o83Var, @NonNull String str) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, o83Var, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            double[] g = wo2.I().g(o83Var, str);
            if (g != null && g.length >= 2) {
                jSONObject.put("longitude", g[0]);
                jSONObject.put("latitude", g[1]);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public final void B(@NonNull JSONObject jSONObject) throws JSONException {
        p53 M;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) && (M = p53.M()) != null && M.f0().f("mapp_set_user_agent")) {
            jSONObject.put("userAgent", hc4.b().getUserAgent());
        }
    }

    public final void A(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, jSONObject) == null) {
            jSONObject.put("cameraAuthorized", ti3.j(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE));
            jSONObject.put("locationAuthorized", ti3.j(context, com.kuaishou.weapon.p0.h.g));
            jSONObject.put("microphoneAuthorized", ti3.j(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE));
            jSONObject.put("notificationAuthorized", jj3.N(context));
            jSONObject.put("locationEnabled", jj3.L(context));
            jSONObject.put("wifiEnabled", jj3.V(context));
        }
    }

    public final void D(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull Pair<Integer, Integer> pair) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, jSONObject, pair) == null) {
            int O = gj3.O(yi3.e(context));
            int O2 = gj3.O(((Integer) pair.first).intValue());
            int O3 = gj3.O(((Integer) pair.second).intValue());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("left", 0);
            jSONObject2.put("right", O2);
            jSONObject2.put("top", O);
            jSONObject2.put("width", O2);
            jSONObject2.put("bottom", O3);
            jSONObject2.put("height", O3 - O);
            jSONObject.put("safeArea", jSONObject2);
        }
    }

    public qx1 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            r("#getCommonSysInfoSync", false);
            JSONObject d = dz2.c().d("getCommonSysInfoSync");
            if (d == null) {
                try {
                    d = new JSONObject();
                    d.put("imei", jj3.r());
                    dz2.c().h("getCommonSysInfoSync", d);
                } catch (JSONException unused) {
                    return new qx1(1001, "exec fail");
                }
            }
            return new qx1(0, d);
        }
        return (qx1) invokeV.objValue;
    }

    public qx1 K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            r("#getSystemInfoSync", false);
            JSONObject d = dz2.c().d("getSystemInfoSync");
            if (d == null) {
                d = H(i());
                dz2.c().h("getSystemInfoSync", d);
                dz2.c().h("getSystemInfo", d);
            }
            if (d == null) {
                return new qx1(202, "empty joData");
            }
            return new qx1(0, d);
        }
        return (qx1) invokeV.objValue;
    }

    public final JSONObject H(Context context) {
        InterceptResult invokeL;
        JSONObject a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            if (wo2.g0().o()) {
                a2 = ax1.b(context);
            } else {
                a2 = ax1.a(context);
            }
            if (a2 == null) {
                return null;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay().getMetrics(displayMetrics);
            Pair<Integer, Integer> s = cr2.V().s();
            Pair<Integer, Integer> y = cr2.V().y();
            try {
                a2.put("SDKVersion", G(context));
                a2.put("windowWidth", (int) (((Integer) s.first).intValue() / displayMetrics.density));
                a2.put("windowHeight", (int) (((Integer) s.second).intValue() / displayMetrics.density));
                a2.put("screenWidth", gj3.O(((Integer) y.first).intValue()));
                a2.put("screenHeight", gj3.O(((Integer) y.second).intValue()));
                a2.put("privacyMode", wo2.y0().c());
                C(a2);
                A(context, a2);
                D(context, a2, y);
                B(a2);
            } catch (JSONException e) {
                q("json put data fail", e, false);
            }
            return a2;
        }
        return (JSONObject) invokeL.objValue;
    }

    public qx1 I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            r("#getSystemInfo", false);
            return J(null);
        }
        return (qx1) invokeV.objValue;
    }

    public qx1 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            r("#getSystemInfoAsync", false);
            a aVar = new a(this);
            if (!TextUtils.isEmpty(str)) {
                try {
                    String optString = new JSONObject(str).optString("cb");
                    if (!TextUtils.isEmpty(optString)) {
                        ji3.k(new b(this, optString, aVar), "SystemInfoApi");
                        return qx1.f();
                    }
                } catch (JSONException e) {
                    q("json put data fail", e, false);
                }
            }
            return aVar.call();
        }
        return (qx1) invokeL.objValue;
    }
}
