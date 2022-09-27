package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes6.dex */
public abstract class w83<ResultDataT> extends i83<ResultDataT> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, String> g;
    public String h;
    public JSONObject i;
    public boolean j;
    public boolean k;
    public String l;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w83 a;

        public a(w83 w83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w83Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (i83.f) {
                    Log.d("OAuthRequest", "OAuthRequest.onExec in thread pool");
                }
                this.a.D();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HttpRequest a;
        public final /* synthetic */ w83 b;

        public b(w83 w83Var, HttpRequest httpRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w83Var, httpRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = w83Var;
            this.a = httpRequest;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (this.b.E()) {
                    this.b.N(this.a);
                } else {
                    this.b.H(this.a, exc);
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                this.b.J(response);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HttpRequest a;
        public final /* synthetic */ w83 b;

        public c(w83 w83Var, HttpRequest httpRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w83Var, httpRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = w83Var;
            this.a = httpRequest;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                l02.i("OAuthRequest", "retryRequest fail: ");
                this.b.H(this.a, exc);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                l02.i("OAuthRequest", "retryRequest success: ");
                this.b.J(response);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements xj1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ w83 b;

        public d(w83 w83Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w83Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = w83Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.xj1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.b.p();
                    this.b.call();
                    return;
                }
                this.b.C(null, this.a);
            }
        }
    }

    public w83() {
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

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public Map<String, String> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.g : (Map) invokeV.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public void C(Response response, String str) {
        int optInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, response, str) == null) {
            this.h = str;
            try {
                JSONObject jSONObject = new JSONObject(this.h);
                this.i = jSONObject;
                optInt = jSONObject.optInt("errno");
            } catch (OAuthException e) {
                G(e.mErrorCode, str, response);
                d(e);
            } catch (Exception e2) {
                j83.k(e2.toString(), Boolean.TRUE);
                L(str, e2);
                G(2103, str, response);
                d(new OAuthException(10005));
                ea3.r(10005, null);
            }
            if ((this.j && optInt == 402) || (this.k && optInt == 401)) {
                this.j = false;
                this.k = false;
                if (SwanAppAllianceLoginHelper.d.f()) {
                    SwanAppAllianceLoginHelper.d.b();
                }
                O(str);
            } else if (F(optInt)) {
                if (SwanAppAllianceLoginHelper.d.f()) {
                    SwanAppAllianceLoginHelper.d.b();
                    O(str);
                } else if (i83.f) {
                    throw new RuntimeException("is not AllianceLogin, error number");
                }
            } else {
                if (response != null && optInt != 0) {
                    G(optInt, str, response);
                }
                r(m(this.i));
                I();
                c();
            }
        }
    }

    public final void D() {
        HttpRequest w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (w = w(this)) == null) {
            return;
        }
        w.executeAsync(new b(this, w));
        qa3.a(z());
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean F(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i == 600101 || i == 600102 || i == 600103 || i == 402 || i == 401 : invokeI.booleanValue;
    }

    public final void G(int i, String str, Response response) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048582, this, i, str, response) == null) {
            qa3.c(z(), i, str, response);
        }
    }

    public void H(HttpRequest httpRequest, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, httpRequest, exc) == null) {
            j83.k(exc.toString(), Boolean.FALSE);
            qa3.b(z(), 2101, httpRequest.getOkRequest() == null ? null : httpRequest.getOkRequest().url().toString(), null, exc.getMessage());
            d(new OAuthException(10002));
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public final void J(Response response) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, response) == null) {
            if (!response.isSuccessful()) {
                j83.k("bad response", Boolean.TRUE);
                G(2104, null, null);
                d(new OAuthException(10002));
                return;
            }
            ResponseBody body = response.body();
            if (body == null) {
                j83.k("empty response body", Boolean.TRUE);
                G(2103, null, null);
                d(new OAuthException(10001));
                return;
            }
            try {
                C(response, body.string());
            } catch (IOException e) {
                if (i83.f) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public final void L(String str, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, exc) == null) {
            if (this.i == null) {
                j83.t("OAuthRequest", "ex: " + exc.toString() + " ,strResponse: " + str);
                return;
            }
            j83.t("OAuthRequest", "ex: " + exc.toString());
        }
    }

    @NonNull
    @SuppressLint({"BDThrowableCheck"})
    public l33 M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            l33 M = l33.M();
            if (M == null) {
                if (!i83.f) {
                    return k33.K().q();
                }
                throw new IllegalStateException("null SwanApp");
            }
            return M;
        }
        return (l33) invokeV.objValue;
    }

    public void N(HttpRequest httpRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, httpRequest) == null) {
            l02.i("OAuthRequest", "retryRequest: " + httpRequest.toString());
            K();
            httpRequest.executeAsync(new c(this, httpRequest));
        }
    }

    public final void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            M().N().f(yo2.U().getActivity(), null, new d(this, str));
        }
    }

    @Override // com.baidu.tieba.i83
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ExecutorUtilsExt.postOnElastic(new a(this), "OAuthRequest-onExec", 2);
        }
    }

    @Override // com.baidu.tieba.i83
    public i83<ResultDataT> q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                this.l = "loginApi";
            } else {
                this.l = str;
            }
            super.q(str);
            return this;
        }
        return (i83) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            o83<ResultDataT> o83Var = this.a;
            return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), e(), Integer.valueOf(this.a.b()), this.h, this.i, o83Var.a, o83Var.a());
        }
        return (String) invokeV.objValue;
    }

    public w83<ResultDataT> v(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, str, str2)) == null) {
            this.g.put(str, str2);
            return this;
        }
        return (w83) invokeLL.objValue;
    }

    public abstract HttpRequest w(w83 w83Var);

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.k = true;
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.j = true;
        }
    }

    public abstract SwanInterfaceType z();
}
