package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.ala.personcenter.AlaPersonCenterFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rg6 extends io5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaPersonCenterFragment c;

    @Override // com.baidu.tieba.io5
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public rg6() {
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
        this.c = new AlaPersonCenterFragment();
        b().a = this.c;
    }

    @Override // com.baidu.tieba.io5
    public jo5 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            jo5 jo5Var = new jo5();
            jo5Var.e = 5;
            jo5Var.b = R.string.ala_live;
            jo5Var.i = jo5.k;
            return jo5Var;
        }
        return (jo5) invokeV.objValue;
    }

    @Override // com.baidu.tieba.io5
    public TbFragmentTabIndicator c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
            this.b = fragmentTabIndicator;
            fragmentTabIndicator.setTextSize(2.0f);
            return this.b;
        }
        return (TbFragmentTabIndicator) invokeL.objValue;
    }

    public void g(yi7 yi7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, yi7Var) != null) || yi7Var == null || !yi7Var.h(5)) {
            return;
        }
        yi7Var.a(this);
    }

    public void h(String str) {
        AlaPersonCenterFragment alaPersonCenterFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (alaPersonCenterFragment = this.c) != null) {
            alaPersonCenterFragment.H1(str);
        }
    }

    public void i(String str) {
        AlaPersonCenterFragment alaPersonCenterFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && (alaPersonCenterFragment = this.c) != null) {
            alaPersonCenterFragment.I1(str);
        }
    }

    public void j(String str) {
        AlaPersonCenterFragment alaPersonCenterFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && (alaPersonCenterFragment = this.c) != null) {
            alaPersonCenterFragment.J1(str);
        }
    }

    public void k(String str) {
        AlaPersonCenterFragment alaPersonCenterFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && (alaPersonCenterFragment = this.c) != null) {
            alaPersonCenterFragment.K1(str);
        }
    }
}
