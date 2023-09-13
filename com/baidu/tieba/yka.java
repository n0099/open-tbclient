package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class yka {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final hla b;
    public final fla c;
    public final ila d;
    public final bla e;
    public final xka f;
    public final ala g;
    public final zka h;
    public final wka i;
    public final dla j;
    public final cla k;
    public final ela l;

    public yka(MainTabActivity mainTabActivity, kka kkaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, kkaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mainTabActivity;
        this.b = new hla(mainTabActivity, kkaVar);
        this.c = new fla(mainTabActivity, kkaVar);
        this.d = new ila();
        this.e = new bla(mainTabActivity, kkaVar);
        this.f = new xka(mainTabActivity, kkaVar);
        this.g = new ala(mainTabActivity, kkaVar);
        this.h = new zka(mainTabActivity, kkaVar);
        this.i = new wka(mainTabActivity, kkaVar);
        this.j = new dla(mainTabActivity, kkaVar);
        this.k = new cla(mainTabActivity);
        this.l = new ela(mainTabActivity);
    }

    public wka a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.i;
        }
        return (wka) invokeV.objValue;
    }

    public xka b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (xka) invokeV.objValue;
    }

    public zka c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.h;
        }
        return (zka) invokeV.objValue;
    }

    public ala d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.g;
        }
        return (ala) invokeV.objValue;
    }

    public bla e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (bla) invokeV.objValue;
    }

    public cla f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.k;
        }
        return (cla) invokeV.objValue;
    }

    public dla g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.j;
        }
        return (dla) invokeV.objValue;
    }

    public fla h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return (fla) invokeV.objValue;
    }

    public hla i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b;
        }
        return (hla) invokeV.objValue;
    }

    public ila j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.d;
        }
        return (ila) invokeV.objValue;
    }

    public ela k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.l;
        }
        return (ela) invokeV.objValue;
    }
}
