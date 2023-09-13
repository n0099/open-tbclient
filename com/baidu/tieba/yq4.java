package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.ubc.Flow;
import com.baidu.swan.ubc.IRemoteUBCService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class yq4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final yq4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-252176145, "Lcom/baidu/tieba/yq4$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-252176145, "Lcom/baidu/tieba/yq4$b;");
                    return;
                }
            }
            a = new yq4(null);
        }
    }

    public yq4() {
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

    public static yq4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (yq4) invokeV.objValue;
    }

    public final IRemoteUBCService c() throws RemoteException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return nq4.f();
        }
        return (IRemoteUBCService) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            wq4.f().q();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            wq4.f().l();
        }
    }

    public /* synthetic */ yq4(a aVar) {
        this();
    }

    public final void onEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            e(str, "", 0);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public Flow a(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, str, str2, i)) == null) {
            if (qk1.g()) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return wq4.f().a(str, str2, i);
            }
            return d(str, ar4.b(str2), i);
        }
        return (Flow) invokeLLI.objValue;
    }

    public final Flow d(String str, String str2, int i) {
        Flow flow;
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, str2, i)) == null) {
            try {
                flow = c().ubcBeginFlow(str, str2, i);
            } catch (RemoteException e) {
                e.printStackTrace();
                flow = null;
            }
            if (flow == null) {
                return new Flow();
            }
            return flow;
        }
        return (Flow) invokeLLI.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public void e(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, str, str2, i) == null) {
            if (qk1.g()) {
                if (nq4.g() == null && TextUtils.isEmpty(str)) {
                    return;
                }
                wq4.f().j(str, str2, i);
                return;
            }
            try {
                c().ubcOnEvent(str, ar4.b(str2), i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void f(String str, Map<String, String> map, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048580, this, str, map, i) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException unused) {
            }
            e(str, jSONObject.toString(), i);
        }
    }

    public void g(String str, JSONObject jSONObject, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048581, this, str, jSONObject, i) == null) {
            if (qk1.g()) {
                if (nq4.g() == null && TextUtils.isEmpty(str)) {
                    return;
                }
                wq4.f().k(str, jSONObject, i);
                return;
            }
            try {
                c().ubcOnEvent(str, ar4.c(jSONObject), i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
