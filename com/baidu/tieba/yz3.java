package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class yz3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public interface d {
        void onFail(String str);

        void onSuccess(Object obj);
    }

    /* loaded from: classes9.dex */
    public static class a extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.a.onFail(exc.getMessage());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
                if (!TextUtils.isEmpty(str)) {
                    JSONObject e = yz3.e(str, this.a);
                    if (e == null) {
                        return;
                    }
                    this.a.onSuccess(a04.a(e));
                    return;
                }
                this.a.onFail(ADConfigError.REASON_NULL_RESPONSE);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.a.onFail(exc.getMessage());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
                if (!TextUtils.isEmpty(str)) {
                    JSONObject e = yz3.e(str, this.a);
                    if (e == null) {
                        return;
                    }
                    this.a.onSuccess(zz3.a(e));
                    return;
                }
                this.a.onFail(ADConfigError.REASON_NULL_RESPONSE);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class c extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k63 a;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            }
        }

        public c(k63 k63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k63Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
                try {
                    if (new JSONObject(str).getInt("errno") != 0) {
                        se3 a = ye3.a();
                        a.putInt("swangame_valid__" + this.a.P(), 0);
                        return;
                    }
                    se3 a2 = ye3.a();
                    a2.putInt("swangame_valid__" + this.a.P(), 1);
                    yz3.g("1");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b() {
        k63 c0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && (c0 = k63.c0()) != null && !c() && rp2.h0().e(rp2.c())) {
            if (d()) {
                g("1");
            } else {
                r44.c().getRequest().cookieManager(rp2.q().a()).url(b34.b().a()).addUrlParam("appKey", c0.P()).requestFrom(16).requestSubFrom(ARPMessageType.MSG_TYPE_SHARE).build().executeAsync(new c(c0));
            }
        }
    }

    public static void f() {
        k63 c0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, null) == null) && (c0 = k63.c0()) != null && d() && rp2.h0().e(rp2.c())) {
            r44.c().getRequest().cookieManager(rp2.q().a()).url(b34.b().i()).addUrlParam("appKey", c0.P()).requestFrom(16).requestSubFrom(ARPMessageType.MSG_TYPE_SHARE).build().executeAsync(null);
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            k63 c0 = k63.c0();
            if (c0 == null) {
                return true;
            }
            se3 a2 = ye3.a();
            if (a2.getInt("swangame_valid__" + c0.P(), -1) == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            k63 c0 = k63.c0();
            if (c0 == null) {
                return false;
            }
            se3 a2 = ye3.a();
            if (1 != a2.getInt("swangame_valid__" + c0.P(), -1)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static JSONObject e(String str, d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, dVar)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("errno", -1) != 0) {
                    dVar.onFail(jSONObject.optString("errmsg"));
                    return null;
                }
                return jSONObject.optJSONObject("data");
            } catch (Exception e) {
                dVar.onFail(e.getMessage());
                return null;
            }
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static void g(String str) {
        k63 c0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, str) == null) && (c0 = k63.c0()) != null && d() && rp2.h0().e(rp2.c())) {
            String h = rp2.h0().h(rp2.c());
            if (TextUtils.isEmpty(h)) {
                return;
            }
            String d2 = pm4.d(Base64.encode(h.getBytes(), 0), false);
            String i = rp2.h0().i(rp2.c());
            if (!TextUtils.isEmpty(i) && i.length() > 32) {
                i = i.substring(0, 32);
            }
            r44.c().getRequest().cookieManager(rp2.q().a()).url(b34.b().q()).addUrlParam("sessionId", d2).addUrlParam("deviceId", i).addUrlParam("behaviorType", str).addUrlParam("behaviorTime", String.valueOf(System.currentTimeMillis() / 1000)).addUrlParam("appKey", c0.P()).requestFrom(16).requestSubFrom(ARPMessageType.MSG_TYPE_SHARE).build().executeAsync(null);
        }
    }

    public static void h(String str, d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, str, dVar) != null) || dVar == null) {
            return;
        }
        k63 c0 = k63.c0();
        if (c0 == null) {
            dVar.onFail("swan app is null");
            return;
        }
        r44.c().getRequest().cookieManager(rp2.q().a()).url(b34.b().j()).addUrlParam("appkey", c0.P()).addUrlParam(IMConstants.SERVICE_TYPE_ORDER, str).requestFrom(16).requestSubFrom(ARPMessageType.MSG_TYPE_SHARE).build().executeAsync(new b(dVar));
    }

    public static void i(long j, d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJL(65544, null, j, dVar) != null) || dVar == null) {
            return;
        }
        k63 c0 = k63.c0();
        if (c0 == null) {
            dVar.onFail("swan app is null");
            return;
        }
        r44.c().getRequest().cookieManager(rp2.q().a()).url(b34.b().h()).addUrlParam("appkey", c0.P()).addUrlParam("duration", String.valueOf(j)).requestFrom(16).requestSubFrom(ARPMessageType.MSG_TYPE_SHARE).build().executeAsync(new a(dVar));
    }
}
