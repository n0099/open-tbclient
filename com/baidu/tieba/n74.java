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
/* loaded from: classes7.dex */
public class n74 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rd2 a;
    public l74 b;

    public n74(rd2 rd2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rd2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = rd2Var;
        this.b = new l74();
    }

    @NonNull
    public r74 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (str == null) {
                return r74.b("parameter error: the key cannot be null.");
            }
            Object obj = null;
            String p = this.b.p(str, null);
            if (p != null) {
                obj = this.a.z(Base64.decode(p, 2), true);
            }
            if (obj == null) {
                obj = r74.h();
            }
            return r74.i(obj);
        }
        return (r74) invokeL.objValue;
    }

    @NonNull
    public r74 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.b.j();
            di3.h.b();
            return r74.i(null);
        }
        return (r74) invokeV.objValue;
    }

    @NonNull
    public q74 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String[] n = this.b.n();
            q74 q74Var = new q74();
            q74Var.keys = n;
            q74Var.currentSize = this.b.m() / 1024;
            q74Var.limitSize = this.b.s() / 1024;
            q74Var.errMsg = o74.b("getStorageInfoSync");
            return q74Var;
        }
        return (q74) invokeV.objValue;
    }

    public final void d(JsSerializeValue jsSerializeValue) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, jsSerializeValue) == null) && jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }

    @NonNull
    public r74 e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str == null) {
                return r74.b("parameter error: the key cannot be null.");
            }
            this.b.u(str);
            di3.h.b();
            return r74.i(null);
        }
        return (r74) invokeL.objValue;
    }

    @NonNull
    public r74 f(String str, JsSerializeValue jsSerializeValue) {
        InterceptResult invokeLL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, jsSerializeValue)) == null) {
            if (str == null) {
                d(jsSerializeValue);
                return r74.b("parameter error: the key cannot be null.");
            } else if (jsSerializeValue == null) {
                return r74.i(null);
            } else {
                byte[] H = this.a.H(jsSerializeValue, true);
                d(jsSerializeValue);
                if (H == null) {
                    return r74.b("parameter error: the data parse failed.");
                }
                String encodeToString = Base64.encodeToString(H, 2);
                String p = this.b.p(str, null);
                int length2 = str.getBytes().length;
                int length3 = encodeToString.length() + length2;
                if (p == null) {
                    length = 0;
                } else {
                    length = p.length() + length2;
                }
                if (this.b.s() - this.b.m() < length3 - length) {
                    return r74.b("storage error: the storage space insufficient.");
                }
                boolean t = this.b.t(str, encodeToString);
                di3.h.b();
                if (t) {
                    return r74.i(null);
                }
                return r74.b("storage error: the storage is invalid.");
            }
        }
        return (r74) invokeLL.objValue;
    }
}
