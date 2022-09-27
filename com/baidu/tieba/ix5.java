package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.ala.gamefrslivetab.video.AlaGameFrsLiveTabVideoFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ix5 extends l95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaGameFrsLiveTabVideoFragment c;

    public ix5() {
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
        this.c = new AlaGameFrsLiveTabVideoFragment();
        b().a = this.c;
    }

    @Override // com.baidu.tieba.l95
    public m95 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            m95 m95Var = new m95();
            m95Var.e = 3;
            m95Var.b = R.string.obfuscated_res_0x7f0f0226;
            m95Var.i = m95.k;
            return m95Var;
        }
        return (m95) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l95
    public TbFragmentTabIndicator c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02ee, (ViewGroup) null);
            this.b = fragmentTabIndicator;
            fragmentTabIndicator.setTextSize(2.0f);
            return this.b;
        }
        return (TbFragmentTabIndicator) invokeL.objValue;
    }

    @Override // com.baidu.tieba.l95
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void g(String str) {
        AlaGameFrsLiveTabVideoFragment alaGameFrsLiveTabVideoFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (alaGameFrsLiveTabVideoFragment = this.c) == null) {
            return;
        }
        alaGameFrsLiveTabVideoFragment.t1(str);
    }

    public void h(String str) {
        AlaGameFrsLiveTabVideoFragment alaGameFrsLiveTabVideoFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (alaGameFrsLiveTabVideoFragment = this.c) == null) {
            return;
        }
        alaGameFrsLiveTabVideoFragment.u1(str);
    }

    public void i(boolean z) {
        AlaGameFrsLiveTabVideoFragment alaGameFrsLiveTabVideoFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (alaGameFrsLiveTabVideoFragment = this.c) == null) {
            return;
        }
        alaGameFrsLiveTabVideoFragment.v1(z);
    }
}
