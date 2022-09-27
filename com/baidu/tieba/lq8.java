package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class lq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final sq8 b;
    public final rq8 c;
    public final tq8 d;
    public final oq8 e;
    public final kq8 f;
    public final nq8 g;
    public final mq8 h;
    public final iq8 i;
    public final qq8 j;
    public final pq8 k;
    public final jq8 l;

    public lq8(MainTabActivity mainTabActivity, xp8 xp8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, xp8Var};
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
        this.b = new sq8(mainTabActivity, xp8Var);
        this.c = new rq8(mainTabActivity, xp8Var);
        this.d = new tq8();
        this.e = new oq8(mainTabActivity, xp8Var);
        this.f = new kq8(mainTabActivity, xp8Var);
        this.g = new nq8(mainTabActivity, xp8Var);
        this.h = new mq8(mainTabActivity, xp8Var);
        this.i = new iq8(mainTabActivity, xp8Var);
        this.j = new qq8(mainTabActivity, xp8Var);
        this.k = new pq8(mainTabActivity);
        this.l = new jq8(mainTabActivity, xp8Var);
    }

    public iq8 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.i : (iq8) invokeV.objValue;
    }

    public jq8 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : (jq8) invokeV.objValue;
    }

    public kq8 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f : (kq8) invokeV.objValue;
    }

    public mq8 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.h : (mq8) invokeV.objValue;
    }

    public nq8 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g : (nq8) invokeV.objValue;
    }

    public oq8 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.e : (oq8) invokeV.objValue;
    }

    public pq8 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.k : (pq8) invokeV.objValue;
    }

    public qq8 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.j : (qq8) invokeV.objValue;
    }

    public rq8 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.c : (rq8) invokeV.objValue;
    }

    public sq8 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.b : (sq8) invokeV.objValue;
    }

    public tq8 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.d : (tq8) invokeV.objValue;
    }
}
