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
public class m74 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qd2 a;
    public k74 b;

    public m74(qd2 qd2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qd2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = qd2Var;
        this.b = new k74();
    }

    @NonNull
    public q74 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (str == null) {
                return q74.b("parameter error: the key cannot be null.");
            }
            Object obj = null;
            String p = this.b.p(str, null);
            if (p != null) {
                obj = this.a.z(Base64.decode(p, 2), true);
            }
            if (obj == null) {
                obj = q74.h();
            }
            return q74.i(obj);
        }
        return (q74) invokeL.objValue;
    }

    @NonNull
    public q74 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.b.j();
            ci3.h.b();
            return q74.i(null);
        }
        return (q74) invokeV.objValue;
    }

    @NonNull
    public p74 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String[] n = this.b.n();
            p74 p74Var = new p74();
            p74Var.keys = n;
            p74Var.currentSize = this.b.m() / 1024;
            p74Var.limitSize = this.b.s() / 1024;
            p74Var.errMsg = n74.b("getStorageInfoSync");
            return p74Var;
        }
        return (p74) invokeV.objValue;
    }

    public final void d(JsSerializeValue jsSerializeValue) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, jsSerializeValue) == null) && jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }

    @NonNull
    public q74 e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str == null) {
                return q74.b("parameter error: the key cannot be null.");
            }
            this.b.u(str);
            ci3.h.b();
            return q74.i(null);
        }
        return (q74) invokeL.objValue;
    }

    @NonNull
    public q74 f(String str, JsSerializeValue jsSerializeValue) {
        InterceptResult invokeLL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, jsSerializeValue)) == null) {
            if (str == null) {
                d(jsSerializeValue);
                return q74.b("parameter error: the key cannot be null.");
            } else if (jsSerializeValue == null) {
                return q74.i(null);
            } else {
                byte[] G = this.a.G(jsSerializeValue, true);
                d(jsSerializeValue);
                if (G == null) {
                    return q74.b("parameter error: the data parse failed.");
                }
                String encodeToString = Base64.encodeToString(G, 2);
                String p = this.b.p(str, null);
                int length2 = str.getBytes().length;
                int length3 = encodeToString.length() + length2;
                if (p == null) {
                    length = 0;
                } else {
                    length = p.length() + length2;
                }
                if (this.b.s() - this.b.m() < length3 - length) {
                    return q74.b("storage error: the storage space insufficient.");
                }
                boolean t = this.b.t(str, encodeToString);
                ci3.h.b();
                if (t) {
                    return q74.i(null);
                }
                return q74.b("storage error: the storage is invalid.");
            }
        }
        return (q74) invokeLL.objValue;
    }
}
