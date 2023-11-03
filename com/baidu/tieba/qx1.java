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
/* loaded from: classes8.dex */
public class qx1 extends gx1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ku1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "SystemInfoApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements ck3<hy1> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qx1 a;

        public a(qx1 qx1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qx1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qx1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ck3
        /* renamed from: a */
        public hy1 call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject d = uz2.c().d("getSystemInfo");
                if (d == null) {
                    qx1 qx1Var = this.a;
                    d = qx1Var.H(qx1Var.i());
                    uz2.c().h("getSystemInfo", d);
                    uz2.c().h("getSystemInfoSync", d);
                }
                if (d == null) {
                    return new hy1(202, "empty joData");
                }
                return new hy1(0, d);
            }
            return (hy1) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ck3 b;
        public final /* synthetic */ qx1 c;

        public b(qx1 qx1Var, String str, ck3 ck3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qx1Var, str, ck3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qx1Var;
            this.a = str;
            this.b = ck3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, (hy1) this.b.call());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qx1(@NonNull iu1 iu1Var) {
        super(iu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iu1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((iu1) newInitContext.callArgs[0]);
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
                i = ((SwanAppActivity) context).S();
            } else {
                i = 0;
            }
            if (i == 1) {
                return lf3.i(op2.i().m(), i);
            }
            return lf3.i(ad2.V().e0(), i);
        }
        return (String) invokeL.objValue;
    }

    public static void C(@NonNull JSONObject jSONObject) throws JSONException {
        g63 M;
        f93 h;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, jSONObject) == null) && (M = g63.M()) != null && M.f0().f("mapp_location")) {
            gq2 I = np2.I();
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

    public static JSONObject E(@NonNull f93 f93Var, @NonNull String str) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, f93Var, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            double[] g = np2.I().g(f93Var, str);
            if (g != null && g.length >= 2) {
                jSONObject.put("longitude", g[0]);
                jSONObject.put("latitude", g[1]);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public final void B(@NonNull JSONObject jSONObject) throws JSONException {
        g63 M;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) && (M = g63.M()) != null && M.f0().f("mapp_set_user_agent")) {
            jSONObject.put("userAgent", yc4.b().getUserAgent());
        }
    }

    public final void A(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, jSONObject) == null) {
            jSONObject.put("cameraAuthorized", kj3.j(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE));
            jSONObject.put("locationAuthorized", kj3.j(context, com.kuaishou.weapon.p0.h.g));
            jSONObject.put("microphoneAuthorized", kj3.j(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE));
            jSONObject.put("notificationAuthorized", ak3.N(context));
            jSONObject.put("locationEnabled", ak3.L(context));
            jSONObject.put("wifiEnabled", ak3.V(context));
        }
    }

    public final void D(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull Pair<Integer, Integer> pair) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, jSONObject, pair) == null) {
            int O = xj3.O(pj3.e(context));
            int O2 = xj3.O(((Integer) pair.first).intValue());
            int O3 = xj3.O(((Integer) pair.second).intValue());
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

    public hy1 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            r("#getCommonSysInfoSync", false);
            JSONObject d = uz2.c().d("getCommonSysInfoSync");
            if (d == null) {
                try {
                    d = new JSONObject();
                    d.put("imei", ak3.r());
                    uz2.c().h("getCommonSysInfoSync", d);
                } catch (JSONException unused) {
                    return new hy1(1001, "exec fail");
                }
            }
            return new hy1(0, d);
        }
        return (hy1) invokeV.objValue;
    }

    public hy1 K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            r("#getSystemInfoSync", false);
            JSONObject d = uz2.c().d("getSystemInfoSync");
            if (d == null) {
                d = H(i());
                uz2.c().h("getSystemInfoSync", d);
                uz2.c().h("getSystemInfo", d);
            }
            if (d == null) {
                return new hy1(202, "empty joData");
            }
            return new hy1(0, d);
        }
        return (hy1) invokeV.objValue;
    }

    public final JSONObject H(Context context) {
        InterceptResult invokeL;
        JSONObject a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            if (np2.g0().o()) {
                a2 = rx1.b(context);
            } else {
                a2 = rx1.a(context);
            }
            if (a2 == null) {
                return null;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay().getMetrics(displayMetrics);
            Pair<Integer, Integer> s = tr2.V().s();
            Pair<Integer, Integer> y = tr2.V().y();
            try {
                a2.put("SDKVersion", G(context));
                a2.put("windowWidth", (int) (((Integer) s.first).intValue() / displayMetrics.density));
                a2.put("windowHeight", (int) (((Integer) s.second).intValue() / displayMetrics.density));
                a2.put("screenWidth", xj3.O(((Integer) y.first).intValue()));
                a2.put("screenHeight", xj3.O(((Integer) y.second).intValue()));
                a2.put("privacyMode", np2.y0().c());
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

    public hy1 I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            r("#getSystemInfo", false);
            return J(null);
        }
        return (hy1) invokeV.objValue;
    }

    public hy1 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            r("#getSystemInfoAsync", false);
            a aVar = new a(this);
            if (!TextUtils.isEmpty(str)) {
                try {
                    String optString = new JSONObject(str).optString("cb");
                    if (!TextUtils.isEmpty(optString)) {
                        aj3.k(new b(this, optString, aVar), "SystemInfoApi");
                        return hy1.f();
                    }
                } catch (JSONException e) {
                    q("json put data fail", e, false);
                }
            }
            return aVar.call();
        }
        return (hy1) invokeL.objValue;
    }
}
