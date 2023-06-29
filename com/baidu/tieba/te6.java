package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.ala.gamebar.AlaGameFrsLiveTabFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class te6 extends jn5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaGameFrsLiveTabFragment c;

    @Override // com.baidu.tieba.jn5
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public te6() {
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
        this.c = new AlaGameFrsLiveTabFragment();
        b().a = this.c;
    }

    @Override // com.baidu.tieba.jn5
    public kn5 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            kn5 kn5Var = new kn5();
            kn5Var.e = 2;
            kn5Var.b = R.string.ala_live;
            kn5Var.i = kn5.k;
            return kn5Var;
        }
        return (kn5) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jn5
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

    public void g(se7 se7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, se7Var) != null) || se7Var == null || !se7Var.h(2)) {
            return;
        }
        se7Var.a(this);
    }

    public void h(String str) {
        AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (alaGameFrsLiveTabFragment = this.c) != null) {
            alaGameFrsLiveTabFragment.R1(str);
        }
    }

    public void i(String str) {
        AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && (alaGameFrsLiveTabFragment = this.c) != null) {
            alaGameFrsLiveTabFragment.S1(str);
        }
    }

    public void j(String str) {
        AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && (alaGameFrsLiveTabFragment = this.c) != null) {
            alaGameFrsLiveTabFragment.T1(str);
        }
    }
}
