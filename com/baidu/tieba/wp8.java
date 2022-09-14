package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class wp8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final dq8 b;
    public final cq8 c;
    public final eq8 d;
    public final zp8 e;
    public final vp8 f;
    public final yp8 g;
    public final xp8 h;
    public final tp8 i;
    public final bq8 j;
    public final aq8 k;
    public final up8 l;

    public wp8(MainTabActivity mainTabActivity, ip8 ip8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, ip8Var};
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
        this.b = new dq8(mainTabActivity, ip8Var);
        this.c = new cq8(mainTabActivity, ip8Var);
        this.d = new eq8();
        this.e = new zp8(mainTabActivity, ip8Var);
        this.f = new vp8(mainTabActivity, ip8Var);
        this.g = new yp8(mainTabActivity, ip8Var);
        this.h = new xp8(mainTabActivity, ip8Var);
        this.i = new tp8(mainTabActivity, ip8Var);
        this.j = new bq8(mainTabActivity, ip8Var);
        this.k = new aq8(mainTabActivity);
        this.l = new up8(mainTabActivity, ip8Var);
    }

    public tp8 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.i : (tp8) invokeV.objValue;
    }

    public up8 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : (up8) invokeV.objValue;
    }

    public vp8 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f : (vp8) invokeV.objValue;
    }

    public xp8 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.h : (xp8) invokeV.objValue;
    }

    public yp8 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g : (yp8) invokeV.objValue;
    }

    public zp8 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.e : (zp8) invokeV.objValue;
    }

    public aq8 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.k : (aq8) invokeV.objValue;
    }

    public bq8 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.j : (bq8) invokeV.objValue;
    }

    public cq8 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.c : (cq8) invokeV.objValue;
    }

    public dq8 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.b : (dq8) invokeV.objValue;
    }

    public eq8 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.d : (eq8) invokeV.objValue;
    }
}
