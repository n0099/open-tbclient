package com.baidu.tieba;

import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class s44 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wa2 a;
    public q44 b;

    public s44(wa2 wa2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wa2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = wa2Var;
        this.b = new q44();
    }

    public w44 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (str == null) {
                return w44.b("parameter error: the key cannot be null.");
            }
            Object obj = null;
            String p = this.b.p(str, null);
            if (p != null) {
                obj = this.a.B(Base64.decode(p, 2), true);
            }
            if (obj == null) {
                obj = w44.h();
            }
            return w44.i(obj);
        }
        return (w44) invokeL.objValue;
    }

    public w44 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.b.j();
            if3.h.update();
            return w44.i(null);
        }
        return (w44) invokeV.objValue;
    }

    public v44 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String[] n = this.b.n();
            v44 v44Var = new v44();
            v44Var.keys = n;
            v44Var.currentSize = this.b.m() / 1024;
            v44Var.limitSize = this.b.s() / 1024;
            v44Var.errMsg = t44.b("getStorageInfoSync");
            return v44Var;
        }
        return (v44) invokeV.objValue;
    }

    public final void d(JsSerializeValue jsSerializeValue) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, jsSerializeValue) == null) && jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }

    public w44 e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str == null) {
                return w44.b("parameter error: the key cannot be null.");
            }
            this.b.u(str);
            if3.h.update();
            return w44.i(null);
        }
        return (w44) invokeL.objValue;
    }

    public w44 f(String str, JsSerializeValue jsSerializeValue) {
        InterceptResult invokeLL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, jsSerializeValue)) == null) {
            if (str == null) {
                d(jsSerializeValue);
                return w44.b("parameter error: the key cannot be null.");
            } else if (jsSerializeValue == null) {
                return w44.i(null);
            } else {
                byte[] J = this.a.J(jsSerializeValue, true);
                d(jsSerializeValue);
                if (J == null) {
                    return w44.b("parameter error: the data parse failed.");
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
                    return w44.b("storage error: the storage space insufficient.");
                }
                boolean t = this.b.t(str, encodeToString);
                if3.h.update();
                if (t) {
                    return w44.i(null);
                }
                return w44.b("storage error: the storage is invalid.");
            }
        }
        return (w44) invokeLL.objValue;
    }
}
