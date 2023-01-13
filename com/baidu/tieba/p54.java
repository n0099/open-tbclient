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
/* loaded from: classes5.dex */
public class p54 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tb2 a;
    public n54 b;

    public p54(tb2 tb2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tb2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tb2Var;
        this.b = new n54();
    }

    @NonNull
    public t54 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (str == null) {
                return t54.b("parameter error: the key cannot be null.");
            }
            Object obj = null;
            String p = this.b.p(str, null);
            if (p != null) {
                obj = this.a.B(Base64.decode(p, 2), true);
            }
            if (obj == null) {
                obj = t54.h();
            }
            return t54.i(obj);
        }
        return (t54) invokeL.objValue;
    }

    @NonNull
    public t54 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.b.j();
            fg3.h.update();
            return t54.i(null);
        }
        return (t54) invokeV.objValue;
    }

    @NonNull
    public s54 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String[] n = this.b.n();
            s54 s54Var = new s54();
            s54Var.keys = n;
            s54Var.currentSize = this.b.m() / 1024;
            s54Var.limitSize = this.b.s() / 1024;
            s54Var.errMsg = q54.b("getStorageInfoSync");
            return s54Var;
        }
        return (s54) invokeV.objValue;
    }

    public final void d(JsSerializeValue jsSerializeValue) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, jsSerializeValue) == null) && jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }

    @NonNull
    public t54 e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str == null) {
                return t54.b("parameter error: the key cannot be null.");
            }
            this.b.u(str);
            fg3.h.update();
            return t54.i(null);
        }
        return (t54) invokeL.objValue;
    }

    @NonNull
    public t54 f(String str, JsSerializeValue jsSerializeValue) {
        InterceptResult invokeLL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, jsSerializeValue)) == null) {
            if (str == null) {
                d(jsSerializeValue);
                return t54.b("parameter error: the key cannot be null.");
            } else if (jsSerializeValue == null) {
                return t54.i(null);
            } else {
                byte[] I = this.a.I(jsSerializeValue, true);
                d(jsSerializeValue);
                if (I == null) {
                    return t54.b("parameter error: the data parse failed.");
                }
                String encodeToString = Base64.encodeToString(I, 2);
                String p = this.b.p(str, null);
                int length2 = str.getBytes().length;
                int length3 = encodeToString.length() + length2;
                if (p == null) {
                    length = 0;
                } else {
                    length = p.length() + length2;
                }
                if (this.b.s() - this.b.m() < length3 - length) {
                    return t54.b("storage error: the storage space insufficient.");
                }
                boolean t = this.b.t(str, encodeToString);
                fg3.h.update();
                if (t) {
                    return t54.i(null);
                }
                return t54.b("storage error: the storage is invalid.");
            }
        }
        return (t54) invokeLL.objValue;
    }
}
