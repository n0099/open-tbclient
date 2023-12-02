package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class vb3<ResultDataT> extends hb3<ResultDataT> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, String> g;
    public String h;
    public JSONObject i;
    public boolean j;
    public boolean k;
    public String l;

    public abstract SwanInterfaceType A();

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean G(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i == 600101 || i == 600102 || i == 600103 || i == 402 || i == 401 : invokeI.booleanValue;
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public abstract HttpRequest x(vb3 vb3Var);

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vb3 a;

        public a(vb3 vb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vb3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (hb3.f) {
                    Log.d("OAuthRequest", "OAuthRequest.onExec in thread pool");
                }
                this.a.E();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HttpRequest a;
        public final /* synthetic */ vb3 b;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        public b(vb3 vb3Var, HttpRequest httpRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vb3Var, httpRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vb3Var;
            this.a = httpRequest;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (this.b.F()) {
                    this.b.O(this.a);
                } else {
                    this.b.I(this.a, exc);
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                this.b.K(response);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HttpRequest a;
        public final /* synthetic */ vb3 b;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        public c(vb3 vb3Var, HttpRequest httpRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vb3Var, httpRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vb3Var;
            this.a = httpRequest;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                k32.i("OAuthRequest", "retryRequest fail: ");
                this.b.I(this.a, exc);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                k32.i("OAuthRequest", "retryRequest success: ");
                this.b.K(response);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements xm1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ vb3 b;

        public d(vb3 vb3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vb3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vb3Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.xm1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.b.q();
                    this.b.a();
                    return;
                }
                this.b.D(null, this.a);
            }
        }
    }

    public vb3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new HashMap();
    }

    public Map<String, String> C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return (Map) invokeV.objValue;
    }

    public final void E() {
        HttpRequest x;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (x = x(this)) == null) {
            return;
        }
        x.executeAsync(new b(this, x));
        pd3.a(A());
    }

    @NonNull
    @SuppressLint({"BDThrowableCheck"})
    public k63 N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            k63 M = k63.M();
            if (M == null) {
                if (!hb3.f) {
                    return j63.K().q();
                }
                throw new IllegalStateException("null SwanApp");
            }
            return M;
        }
        return (k63) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hb3
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            ExecutorUtilsExt.postOnElastic(new a(this), "OAuthRequest-onExec", 2);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.k = true;
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.j = true;
        }
    }

    public final void P(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            N().N().f(xr2.V().getActivity(), null, new d(this, str));
        }
    }

    @Override // com.baidu.tieba.hb3
    public hb3<ResultDataT> r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                this.l = "loginApi";
            } else {
                this.l = str;
            }
            super.r(str);
            return this;
        }
        return (hb3) invokeL.objValue;
    }

    public vb3<ResultDataT> w(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, str, str2)) == null) {
            this.g.put(str, str2);
            return this;
        }
        return (vb3) invokeLL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public void D(Response response, String str) {
        int optInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, response, str) == null) {
            this.h = str;
            try {
                JSONObject jSONObject = new JSONObject(this.h);
                this.i = jSONObject;
                optInt = jSONObject.optInt("errno");
            } catch (OAuthException e) {
                H(e.mErrorCode, str, response);
                e(e);
            } catch (Exception e2) {
                ib3.k(e2.toString(), Boolean.TRUE);
                M(str, e2);
                H(2103, str, response);
                e(new OAuthException(10005));
                dd3.r(10005, null);
            }
            if ((this.j && optInt == 402) || (this.k && optInt == 401)) {
                this.j = false;
                this.k = false;
                if (SwanAppAllianceLoginHelper.d.f()) {
                    SwanAppAllianceLoginHelper.d.b();
                }
                P(str);
            } else if (G(optInt)) {
                if (SwanAppAllianceLoginHelper.d.f()) {
                    SwanAppAllianceLoginHelper.d.b();
                    P(str);
                } else if (!hb3.f) {
                } else {
                    throw new RuntimeException("is not AllianceLogin, error number");
                }
            } else {
                if (response != null && optInt != 0) {
                    H(optInt, str, response);
                }
                s(n(this.i));
                J();
                d();
            }
        }
    }

    public final void H(int i, String str, Response response) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048583, this, i, str, response) == null) {
            pd3.c(A(), i, str, response);
        }
    }

    public void I(HttpRequest httpRequest, Exception exc) {
        String httpUrl;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, httpRequest, exc) == null) {
            ib3.k(exc.toString(), Boolean.FALSE);
            if (httpRequest.getOkRequest() == null) {
                httpUrl = null;
            } else {
                httpUrl = httpRequest.getOkRequest().url().toString();
            }
            pd3.b(A(), 2101, httpUrl, null, exc.getMessage());
            e(new OAuthException(10002));
        }
    }

    public final void K(Response response) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, response) == null) {
            if (!response.isSuccessful()) {
                ib3.k("bad response", Boolean.TRUE);
                H(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, null, null);
                e(new OAuthException(10002));
                return;
            }
            ResponseBody body = response.body();
            if (body == null) {
                ib3.k("empty response body", Boolean.TRUE);
                H(2103, null, null);
                e(new OAuthException(10001));
                return;
            }
            try {
                D(response, body.string());
            } catch (IOException e) {
                if (hb3.f) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void M(String str, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, exc) == null) {
            if (this.i == null) {
                ib3.t("OAuthRequest", "ex: " + exc.toString() + " ,strResponse: " + str);
                return;
            }
            ib3.t("OAuthRequest", "ex: " + exc.toString());
        }
    }

    public void O(HttpRequest httpRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, httpRequest) == null) {
            k32.i("OAuthRequest", "retryRequest: " + httpRequest.toString());
            L();
            httpRequest.executeAsync(new c(this, httpRequest));
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            nb3<ResultDataT> nb3Var = this.a;
            return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), f(), Integer.valueOf(this.a.b()), this.h, this.i, nb3Var.a, nb3Var.a());
        }
        return (String) invokeV.objValue;
    }
}
