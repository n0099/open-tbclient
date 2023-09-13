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
public class nc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ri2 a;
    public lc4 b;

    public nc4(ri2 ri2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ri2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ri2Var;
        this.b = new lc4();
    }

    @NonNull
    public rc4 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (str == null) {
                return rc4.b("parameter error: the key cannot be null.");
            }
            Object obj = null;
            String p = this.b.p(str, null);
            if (p != null) {
                obj = this.a.A(Base64.decode(p, 2), true);
            }
            if (obj == null) {
                obj = rc4.h();
            }
            return rc4.i(obj);
        }
        return (rc4) invokeL.objValue;
    }

    @NonNull
    public rc4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.b.j();
            dn3.h.update();
            return rc4.i(null);
        }
        return (rc4) invokeV.objValue;
    }

    @NonNull
    public qc4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String[] n = this.b.n();
            qc4 qc4Var = new qc4();
            qc4Var.keys = n;
            qc4Var.currentSize = this.b.m() / 1024;
            qc4Var.limitSize = this.b.s() / 1024;
            qc4Var.errMsg = oc4.b("getStorageInfoSync");
            return qc4Var;
        }
        return (qc4) invokeV.objValue;
    }

    public final void d(JsSerializeValue jsSerializeValue) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, jsSerializeValue) == null) && jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }

    @NonNull
    public rc4 e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str == null) {
                return rc4.b("parameter error: the key cannot be null.");
            }
            this.b.u(str);
            dn3.h.update();
            return rc4.i(null);
        }
        return (rc4) invokeL.objValue;
    }

    @NonNull
    public rc4 f(String str, JsSerializeValue jsSerializeValue) {
        InterceptResult invokeLL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, jsSerializeValue)) == null) {
            if (str == null) {
                d(jsSerializeValue);
                return rc4.b("parameter error: the key cannot be null.");
            } else if (jsSerializeValue == null) {
                return rc4.i(null);
            } else {
                byte[] K = this.a.K(jsSerializeValue, true);
                d(jsSerializeValue);
                if (K == null) {
                    return rc4.b("parameter error: the data parse failed.");
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
                    return rc4.b("storage error: the storage space insufficient.");
                }
                boolean t = this.b.t(str, encodeToString);
                dn3.h.update();
                if (t) {
                    return rc4.i(null);
                }
                return rc4.b("storage error: the storage is invalid.");
            }
        }
        return (rc4) invokeLL.objValue;
    }
}
