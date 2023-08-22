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
/* loaded from: classes6.dex */
public class jc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ni2 a;
    public hc4 b;

    public jc4(ni2 ni2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ni2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ni2Var;
        this.b = new hc4();
    }

    @NonNull
    public nc4 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (str == null) {
                return nc4.b("parameter error: the key cannot be null.");
            }
            Object obj = null;
            String p = this.b.p(str, null);
            if (p != null) {
                obj = this.a.A(Base64.decode(p, 2), true);
            }
            if (obj == null) {
                obj = nc4.h();
            }
            return nc4.i(obj);
        }
        return (nc4) invokeL.objValue;
    }

    @NonNull
    public nc4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.b.j();
            zm3.h.update();
            return nc4.i(null);
        }
        return (nc4) invokeV.objValue;
    }

    @NonNull
    public mc4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String[] n = this.b.n();
            mc4 mc4Var = new mc4();
            mc4Var.keys = n;
            mc4Var.currentSize = this.b.m() / 1024;
            mc4Var.limitSize = this.b.s() / 1024;
            mc4Var.errMsg = kc4.b("getStorageInfoSync");
            return mc4Var;
        }
        return (mc4) invokeV.objValue;
    }

    public final void d(JsSerializeValue jsSerializeValue) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, jsSerializeValue) == null) && jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }

    @NonNull
    public nc4 e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str == null) {
                return nc4.b("parameter error: the key cannot be null.");
            }
            this.b.u(str);
            zm3.h.update();
            return nc4.i(null);
        }
        return (nc4) invokeL.objValue;
    }

    @NonNull
    public nc4 f(String str, JsSerializeValue jsSerializeValue) {
        InterceptResult invokeLL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, jsSerializeValue)) == null) {
            if (str == null) {
                d(jsSerializeValue);
                return nc4.b("parameter error: the key cannot be null.");
            } else if (jsSerializeValue == null) {
                return nc4.i(null);
            } else {
                byte[] K = this.a.K(jsSerializeValue, true);
                d(jsSerializeValue);
                if (K == null) {
                    return nc4.b("parameter error: the data parse failed.");
                }
                String encodeToString = Base64.encodeToString(K, 2);
                String p = this.b.p(str, null);
                int length2 = str.getBytes().length;
                int length3 = encodeToString.length() + length2;
                if (p == null) {
                    length = 0;
                } else {
                    length = p.length() + length2;
                }
                if (this.b.s() - this.b.m() < length3 - length) {
                    return nc4.b("storage error: the storage space insufficient.");
                }
                boolean t = this.b.t(str, encodeToString);
                zm3.h.update();
                if (t) {
                    return nc4.i(null);
                }
                return nc4.b("storage error: the storage is invalid.");
            }
        }
        return (nc4) invokeLL.objValue;
    }
}
