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
/* loaded from: classes4.dex */
public class l54 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pb2 a;
    public j54 b;

    public l54(pb2 pb2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pb2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = pb2Var;
        this.b = new j54();
    }

    @NonNull
    public p54 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (str == null) {
                return p54.b("parameter error: the key cannot be null.");
            }
            Object obj = null;
            String p = this.b.p(str, null);
            if (p != null) {
                obj = this.a.B(Base64.decode(p, 2), true);
            }
            if (obj == null) {
                obj = p54.h();
            }
            return p54.i(obj);
        }
        return (p54) invokeL.objValue;
    }

    @NonNull
    public p54 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.b.j();
            bg3.h.update();
            return p54.i(null);
        }
        return (p54) invokeV.objValue;
    }

    @NonNull
    public o54 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String[] n = this.b.n();
            o54 o54Var = new o54();
            o54Var.keys = n;
            o54Var.currentSize = this.b.m() / 1024;
            o54Var.limitSize = this.b.s() / 1024;
            o54Var.errMsg = m54.b("getStorageInfoSync");
            return o54Var;
        }
        return (o54) invokeV.objValue;
    }

    public final void d(JsSerializeValue jsSerializeValue) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, jsSerializeValue) == null) && jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }

    @NonNull
    public p54 e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str == null) {
                return p54.b("parameter error: the key cannot be null.");
            }
            this.b.u(str);
            bg3.h.update();
            return p54.i(null);
        }
        return (p54) invokeL.objValue;
    }

    @NonNull
    public p54 f(String str, JsSerializeValue jsSerializeValue) {
        InterceptResult invokeLL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, jsSerializeValue)) == null) {
            if (str == null) {
                d(jsSerializeValue);
                return p54.b("parameter error: the key cannot be null.");
            } else if (jsSerializeValue == null) {
                return p54.i(null);
            } else {
                byte[] J = this.a.J(jsSerializeValue, true);
                d(jsSerializeValue);
                if (J == null) {
                    return p54.b("parameter error: the data parse failed.");
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
                    return p54.b("storage error: the storage space insufficient.");
                }
                boolean t = this.b.t(str, encodeToString);
                bg3.h.update();
                if (t) {
                    return p54.i(null);
                }
                return p54.b("storage error: the storage is invalid.");
            }
        }
        return (p54) invokeLL.objValue;
    }
}
