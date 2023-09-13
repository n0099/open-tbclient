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
/* loaded from: classes8.dex */
public class v44 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface d {
        void onFail(String str);

        void onSuccess(Object obj);
    }

    /* loaded from: classes8.dex */
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
                    JSONObject e = v44.e(str, this.a);
                    if (e == null) {
                        return;
                    }
                    this.a.onSuccess(x44.a(e));
                    return;
                }
                this.a.onFail(ADConfigError.REASON_NULL_RESPONSE);
            }
        }
    }

    /* loaded from: classes8.dex */
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
                    JSONObject e = v44.e(str, this.a);
                    if (e == null) {
                        return;
                    }
                    this.a.onSuccess(w44.a(e));
                    return;
                }
                this.a.onFail(ADConfigError.REASON_NULL_RESPONSE);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hb3 a;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            }
        }

        public c(hb3 hb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hb3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
                try {
                    if (new JSONObject(str).getInt("errno") != 0) {
                        pj3 a = vj3.a();
                        a.putInt("swangame_valid__" + this.a.O(), 0);
                        return;
                    }
                    pj3 a2 = vj3.a();
                    a2.putInt("swangame_valid__" + this.a.O(), 1);
                    v44.g("1");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b() {
        hb3 b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && (b0 = hb3.b0()) != null && !c() && ou2.h0().e(ou2.c())) {
            if (d()) {
                g("1");
            } else {
                o94.a().getRequest().cookieManager(ou2.q().a()).url(y74.b().a()).addUrlParam("appKey", b0.O()).requestFrom(16).requestSubFrom(ARPMessageType.MSG_TYPE_SHARE).build().executeAsync(new c(b0));
            }
        }
    }

    public static void f() {
        hb3 b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, null) == null) && (b0 = hb3.b0()) != null && d() && ou2.h0().e(ou2.c())) {
            o94.a().getRequest().cookieManager(ou2.q().a()).url(y74.b().i()).addUrlParam("appKey", b0.O()).requestFrom(16).requestSubFrom(ARPMessageType.MSG_TYPE_SHARE).build().executeAsync(null);
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            hb3 b0 = hb3.b0();
            if (b0 == null) {
                return true;
            }
            pj3 a2 = vj3.a();
            if (a2.getInt("swangame_valid__" + b0.O(), -1) == 0) {
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
            hb3 b0 = hb3.b0();
            if (b0 == null) {
                return false;
            }
            pj3 a2 = vj3.a();
            if (1 != a2.getInt("swangame_valid__" + b0.O(), -1)) {
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
        hb3 b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, str) == null) && (b0 = hb3.b0()) != null && d() && ou2.h0().e(ou2.c())) {
            String h = ou2.h0().h(ou2.c());
            if (TextUtils.isEmpty(h)) {
                return;
            }
            String d2 = nr4.d(Base64.encode(h.getBytes(), 0), false);
            String i = ou2.h0().i(ou2.c());
            if (!TextUtils.isEmpty(i) && i.length() > 32) {
                i = i.substring(0, 32);
            }
            o94.a().getRequest().cookieManager(ou2.q().a()).url(y74.b().q()).addUrlParam("sessionId", d2).addUrlParam("deviceId", i).addUrlParam("behaviorType", str).addUrlParam("behaviorTime", String.valueOf(System.currentTimeMillis() / 1000)).addUrlParam("appKey", b0.O()).requestFrom(16).requestSubFrom(ARPMessageType.MSG_TYPE_SHARE).build().executeAsync(null);
        }
    }

    public static void h(String str, d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, str, dVar) != null) || dVar == null) {
            return;
        }
        hb3 b0 = hb3.b0();
        if (b0 == null) {
            dVar.onFail("swan app is null");
            return;
        }
        o94.a().getRequest().cookieManager(ou2.q().a()).url(y74.b().j()).addUrlParam("appkey", b0.O()).addUrlParam(IMConstants.SERVICE_TYPE_ORDER, str).requestFrom(16).requestSubFrom(ARPMessageType.MSG_TYPE_SHARE).build().executeAsync(new b(dVar));
    }

    public static void i(long j, d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJL(65544, null, j, dVar) != null) || dVar == null) {
            return;
        }
        hb3 b0 = hb3.b0();
        if (b0 == null) {
            dVar.onFail("swan app is null");
            return;
        }
        o94.a().getRequest().cookieManager(ou2.q().a()).url(y74.b().h()).addUrlParam("appkey", b0.O()).addUrlParam("duration", String.valueOf(j)).requestFrom(16).requestSubFrom(ARPMessageType.MSG_TYPE_SHARE).build().executeAsync(new a(dVar));
    }
}
