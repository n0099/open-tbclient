package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.StatKey;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class j2a implements qd9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public l2a b;

    public j2a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.b = new l2a(str);
    }

    @Override // com.baidu.tieba.qd9
    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || !m(str)) {
            return;
        }
        lsa.d().j(this.a, lsa.i(VideoPlatformStatic.c(), this.b.d(), this.b.b()));
    }

    @Override // com.baidu.tieba.qd9
    public void k(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, str) != null) || !m(str)) {
            return;
        }
        this.b.k();
        this.b.j();
        this.b.a(new a2a(401, "write", -4399, ""));
    }

    @Override // com.baidu.tieba.qd9
    public void b(String str, int i, int i2, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2}) != null) || !m(str)) {
            return;
        }
        this.b.f();
        this.b.i();
        this.b.k();
        this.b.a(new a2a(i, "write", i2, str2));
    }

    @Override // com.baidu.tieba.qd9
    public void c(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, str, i, str2) != null) || !m(str)) {
            return;
        }
        this.b.f();
        this.b.a(new a2a(i, StatKey.EDITADDR_TAG_STAGE_EDIT, i, str2));
    }

    @Override // com.baidu.tieba.qd9
    public void f(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048581, this, str, i, str2) != null) || !m(str)) {
            return;
        }
        this.b.f();
        this.b.a(new a2a(i, "record", i, str2));
    }

    @Override // com.baidu.tieba.qd9
    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (!m(str)) {
                return false;
            }
            return this.b.g();
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.qd9
    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return this.b.h();
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.qd9
    public void j(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, str) != null) || !m(str)) {
            return;
        }
        this.b.k();
        this.b.a(new a2a(301, "write", -4399, ""));
    }

    public final boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (TextUtils.equals(this.a, str) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.a)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.qd9
    public void g(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048582, this, str, i, str2) != null) || !m(str)) {
            return;
        }
        this.b.f();
        this.b.i();
        this.b.k();
        this.b.a(new a2a(402, "write", i, str2));
    }

    @Override // com.baidu.tieba.qd9
    public void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048583, this, str, str2) != null) || !m(str)) {
            return;
        }
        this.b.a(new a2a(503, str2, -4399, ""));
    }

    @Override // com.baidu.tieba.qd9
    public void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) != null) || !m(str)) {
            return;
        }
        this.b.a(new a2a(501, str2, -4399, ""));
    }

    @Override // com.baidu.tieba.qd9
    public void l(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048587, this, str, i, str2) != null) || !m(str)) {
            return;
        }
        if (i != 103 && i != 105 && i != 106 && i != 107 && i != 104) {
            this.b.a(new a2a(i, str2, -4399, ""));
            return;
        }
        this.b.f();
        this.b.a(new a2a(i, str2, i, VideoPlatformStatic.g(i)));
    }
}
