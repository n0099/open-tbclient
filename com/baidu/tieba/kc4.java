package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class kc4 extends nc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kc4(ri2 ri2Var) {
        super(ri2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ri2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ri2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void g(JsObject jsObject, String str, String str2, rc4 rc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, jsObject, str, str2, rc4Var) == null) {
            o32 n = n(jsObject);
            q54 q54Var = new q54();
            boolean g = rc4Var.g();
            q54Var.errMsg = rc4Var.c(str, str2);
            td4.call(n, g, q54Var);
            if (!g) {
                bc4.i(str2, q54Var.errMsg);
            }
        }
    }

    public void h(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            g(jsObject, "clearStorage", "", a());
        }
    }

    public final JsSerializeValue i(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject)) == null) {
            for (int i = 0; i < jsObject.length(); i++) {
                if ("data".equals(jsObject.getPropertyName(i))) {
                    return jsObject.toSerializeValue(i);
                }
            }
            return null;
        }
        return (JsSerializeValue) invokeL.objValue;
    }

    public void l(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jsObject) == null) {
            o32 n = n(jsObject);
            qc4 b = b();
            b.errMsg = oc4.b("getStorageInfo");
            td4.call(n, true, b);
        }
    }

    @NonNull
    public final o32 n(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jsObject)) == null) {
            o32 F = o32.F(jsObject);
            if (F == null) {
                return new o32();
            }
            return F;
        }
        return (o32) invokeL.objValue;
    }

    public void o(JsObject jsObject) {
        String m;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) != null) || (m = m(jsObject, "removeStorage")) == null) {
            return;
        }
        g(jsObject, "removeStorage", m, e(m));
    }

    public void p(JsObject jsObject) {
        String m;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, jsObject) != null) || (m = m(jsObject, "setStorage")) == null) {
            return;
        }
        g(jsObject, "setStorage", m, f(m, i(jsObject)));
    }

    public final rc4 j(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jsObject)) == null) {
            for (int i = 0; i < jsObject.length(); i++) {
                if ("key".equals(jsObject.getPropertyName(i))) {
                    int propertyType = jsObject.getPropertyType(i);
                    if (propertyType == 7) {
                        return rc4.i(jsObject.toString(i));
                    }
                    return rc4.b(String.format("parameter error: the key must be string instead of %s.", rc4.f(propertyType)));
                }
            }
            return rc4.b("parameter error: the parameter key is necessary.");
        }
        return (rc4) invokeL.objValue;
    }

    public void k(JsObject jsObject) {
        String m;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, jsObject) != null) || (m = m(jsObject, "getStorage")) == null) {
            return;
        }
        rc4 c = c(m);
        if (c.g()) {
            pc4 pc4Var = new pc4();
            pc4Var.errMsg = oc4.b("getStorage");
            Object d = c.d();
            pc4Var.data = d;
            if (d instanceof JsSerializeValue) {
                ((JsSerializeValue) d).setAutoRelease(false);
            }
            td4.call(n(jsObject), true, pc4Var);
            return;
        }
        g(jsObject, "getStorage", m, c);
    }

    public final String m(JsObject jsObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, jsObject, str)) == null) {
            rc4 j = j(jsObject);
            if (!j.g()) {
                g(jsObject, str, "", j);
                return null;
            }
            return (String) j.d();
        }
        return (String) invokeLL.objValue;
    }
}
