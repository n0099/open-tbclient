package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Singleton
@Service
/* loaded from: classes9.dex */
public class z74 implements a04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public z74() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.a04
    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ud4.A().n();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.a04
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ud4.A().C();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.a04
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return ud4.A().B();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.a04
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ud4.A().v();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a04
    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return ud4.A().o();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.a04
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return ud4.A().z();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a04
    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return ud4.A().p();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.a04
    public Long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return ud4.A().w();
        }
        return (Long) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a04
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return ud4.A().q();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.a04
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return ud4.A().u();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.a04
    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return ud4.A().x();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a04
    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return ud4.A().y();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a04
    public void b(boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                str = "gdtvideo";
            } else {
                str = "video";
            }
            f44.b(str, null);
        }
    }
}
