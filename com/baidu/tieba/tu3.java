package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.tieba.yk4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.Callback;
import org.json.JSONObject;
@Service
/* loaded from: classes8.dex */
public class tu3 implements iv1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948193655, "Lcom/baidu/tieba/tu3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948193655, "Lcom/baidu/tieba/tu3;");
                return;
            }
        }
        a = fs1.a;
    }

    public tu3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.iv1
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return uu3.b().d();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.iv1
    public void d(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bArr) == null) {
            uu3.b().c(bArr);
        }
    }

    @Override // com.baidu.tieba.iv1
    public boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return uu3.b().e(str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.iv1
    public <T> void e(String str, String str2, ResponseCallback<T> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, responseCallback) == null) {
            new kv3().q(str, str2, responseCallback);
        }
    }

    @Override // com.baidu.tieba.iv1
    public void f(String str, String str2, yk4.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, cVar) == null) {
            new jv3().k(str, str2, cVar);
        }
    }

    @Override // com.baidu.tieba.iv1
    public boolean i(@NonNull vb3 vb3Var, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, Callback callback, oq3<String> oq3Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{vb3Var, jSONObject, str, str2, callback, oq3Var})) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("ext");
            if (optJSONObject == null || !optJSONObject.optBoolean("enableBdtls", false)) {
                return false;
            }
            String optString = optJSONObject.optString("serviceId");
            if (TextUtils.isEmpty(optString)) {
                if (a) {
                    Log.d("BdtlsImpl", "onFailure: serviceId is invalid");
                }
                if (oq3Var != null) {
                    oq3Var.a("serviceId is invalid");
                    return true;
                }
                return true;
            }
            oi3.D(str, vb3Var.Y().G(), null, str2);
            new mv3(vb3Var, jSONObject, str2, callback).o(optString);
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
