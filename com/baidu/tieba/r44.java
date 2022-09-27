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
public class r44 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public va2 a;
    public p44 b;

    public r44(va2 va2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {va2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = va2Var;
        this.b = new p44();
    }

    @NonNull
    public v44 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.b.j();
            hf3.h.update();
            return v44.i(null);
        }
        return (v44) invokeV.objValue;
    }

    @NonNull
    public u44 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String[] n = this.b.n();
            u44 u44Var = new u44();
            u44Var.keys = n;
            u44Var.currentSize = this.b.m() / 1024;
            u44Var.limitSize = this.b.s() / 1024;
            u44Var.errMsg = s44.b("getStorageInfoSync");
            return u44Var;
        }
        return (u44) invokeV.objValue;
    }

    @NonNull
    public v44 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (str == null) {
                return v44.b("parameter error: the key cannot be null.");
            }
            String p = this.b.p(str, null);
            Object B = p != null ? this.a.B(Base64.decode(p, 2), true) : null;
            if (B == null) {
                B = v44.h();
            }
            return v44.i(B);
        }
        return (v44) invokeL.objValue;
    }

    public final void d(JsSerializeValue jsSerializeValue) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jsSerializeValue) == null) || jsSerializeValue == null) {
            return;
        }
        jsSerializeValue.release();
    }

    @NonNull
    public v44 e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str == null) {
                return v44.b("parameter error: the key cannot be null.");
            }
            this.b.u(str);
            hf3.h.update();
            return v44.i(null);
        }
        return (v44) invokeL.objValue;
    }

    @NonNull
    public v44 f(String str, JsSerializeValue jsSerializeValue) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, jsSerializeValue)) == null) {
            if (str == null) {
                d(jsSerializeValue);
                return v44.b("parameter error: the key cannot be null.");
            } else if (jsSerializeValue == null) {
                return v44.i(null);
            } else {
                byte[] J = this.a.J(jsSerializeValue, true);
                d(jsSerializeValue);
                if (J == null) {
                    return v44.b("parameter error: the data parse failed.");
                }
                String encodeToString = Base64.encodeToString(J, 2);
                String p = this.b.p(str, null);
                int length = str.getBytes().length;
                if (this.b.s() - this.b.m() < (encodeToString.length() + length) - (p == null ? 0 : p.length() + length)) {
                    return v44.b("storage error: the storage space insufficient.");
                }
                boolean t = this.b.t(str, encodeToString);
                hf3.h.update();
                return t ? v44.i(null) : v44.b("storage error: the storage is invalid.");
            }
        }
        return (v44) invokeLL.objValue;
    }
}
