package com.baidu.tieba;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class v64 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zc2 a;
    public t64 b;

    public v64(zc2 zc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zc2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = zc2Var;
        this.b = new t64();
    }

    @NonNull
    public z64 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (str == null) {
                return z64.b("parameter error: the key cannot be null.");
            }
            Object obj = null;
            String p = this.b.p(str, null);
            if (p != null) {
                obj = this.a.z(Base64.decode(p, 2), true);
            }
            if (obj == null) {
                obj = z64.h();
            }
            return z64.i(obj);
        }
        return (z64) invokeL.objValue;
    }

    @NonNull
    public z64 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.b.j();
            lh3.h.b();
            return z64.i(null);
        }
        return (z64) invokeV.objValue;
    }

    @NonNull
    public y64 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String[] n = this.b.n();
            y64 y64Var = new y64();
            y64Var.keys = n;
            y64Var.currentSize = this.b.m() / 1024;
            y64Var.limitSize = this.b.s() / 1024;
            y64Var.errMsg = w64.b("getStorageInfoSync");
            return y64Var;
        }
        return (y64) invokeV.objValue;
    }

    public final void d(JsSerializeValue jsSerializeValue) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, jsSerializeValue) == null) && jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }

    @NonNull
    public z64 e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str == null) {
                return z64.b("parameter error: the key cannot be null.");
            }
            this.b.u(str);
            lh3.h.b();
            return z64.i(null);
        }
        return (z64) invokeL.objValue;
    }

    @NonNull
    public z64 f(String str, JsSerializeValue jsSerializeValue) {
        InterceptResult invokeLL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, jsSerializeValue)) == null) {
            if (str == null) {
                d(jsSerializeValue);
                return z64.b("parameter error: the key cannot be null.");
            } else if (jsSerializeValue == null) {
                return z64.i(null);
            } else {
                byte[] J = this.a.J(jsSerializeValue, true);
                d(jsSerializeValue);
                if (J == null) {
                    return z64.b("parameter error: the data parse failed.");
                }
                String encodeToString = Base64.encodeToString(J, 2);
                String p = this.b.p(str, null);
                int length2 = str.getBytes().length;
                int length3 = encodeToString.length() + length2;
                if (p == null) {
                    length = 0;
                } else {
                    length = p.length() + length2;
                }
                if (this.b.s() - this.b.m() < length3 - length) {
                    return z64.b("storage error: the storage space insufficient.");
                }
                boolean t = this.b.t(str, encodeToString);
                lh3.h.b();
                if (t) {
                    return z64.i(null);
                }
                return z64.b("storage error: the storage is invalid.");
            }
        }
        return (z64) invokeLL.objValue;
    }
}
