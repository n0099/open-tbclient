package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes6.dex */
public class ko2 implements fk3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gk3 a;

    public ko2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        mo2.X(mo2.p(), mo2.t());
    }

    @Override // com.baidu.tieba.fk3
    @NonNull
    public synchronized gk3 d() {
        InterceptResult invokeV;
        gk3 gk3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = new lo2();
                }
                gk3Var = this.a;
            }
            return gk3Var;
        }
        return (gk3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fk3
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return mo2.P(zn2.USER_DATA_PATH);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fk3
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return mo2.N("bdfile://tmp");
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fk3
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return mo2.Y(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.fk3
    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return mo2.N("bdfile://tmp" + File.separator + str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.fk3
    public String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (kj3.s(str) == PathType.RELATIVE) {
                return mo2.Y(str);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.fk3
    public String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            return mo2.Z(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.fk3
    public String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            return g(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.fk3
    public String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            String B = mo2.B(str);
            if (TextUtils.isEmpty(B)) {
                return null;
            }
            return B;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.fk3
    public String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            return e(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.fk3
    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (!zn2.USER_DATA_PATH.equals(str)) {
                    if (str.startsWith(zn2.USER_DATA_PATH + File.separator)) {
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.fk3
    public boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (str.startsWith("bdfile://tmp" + File.separator) || "bdfile://tmp".equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.fk3
    public boolean j(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048585, this, str, z)) == null) {
            return mo2.V(str);
        }
        return invokeLZ.booleanValue;
    }
}
