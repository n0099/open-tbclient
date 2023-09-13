package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mainTab.FragmentDelegate;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.FragmentTabStructure;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class xe6 extends FragmentDelegate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaFrsLiveFragment a;

    @Override // com.baidu.tbadk.mainTab.FragmentDelegate
    public boolean isAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public xe6(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        AlaFrsLiveFragment alaFrsLiveFragment = new AlaFrsLiveFragment();
        this.a = alaFrsLiveFragment;
        alaFrsLiveFragment.k2(z);
        getFragmentTabStructure().frag = this.a;
    }

    public void a(String str) {
        AlaFrsLiveFragment alaFrsLiveFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && (alaFrsLiveFragment = this.a) != null) {
            alaFrsLiveFragment.g2(str);
        }
    }

    public void b(String str) {
        AlaFrsLiveFragment alaFrsLiveFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && (alaFrsLiveFragment = this.a) != null) {
            alaFrsLiveFragment.h2(str);
        }
    }

    public void c(String str) {
        AlaFrsLiveFragment alaFrsLiveFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (alaFrsLiveFragment = this.a) != null) {
            alaFrsLiveFragment.i2(str);
        }
    }

    public void d(int i) {
        AlaFrsLiveFragment alaFrsLiveFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (alaFrsLiveFragment = this.a) != null) {
            alaFrsLiveFragment.j2(i);
        }
    }

    public void e(boolean z) {
        AlaFrsLiveFragment alaFrsLiveFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (alaFrsLiveFragment = this.a) != null) {
            alaFrsLiveFragment.l2(z);
        }
    }

    @Override // com.baidu.tbadk.mainTab.FragmentDelegate
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
            this.mIndicator = fragmentTabIndicator;
            fragmentTabIndicator.setTextSize(2.0f);
            return this.mIndicator;
        }
        return (TbFragmentTabIndicator) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.mainTab.FragmentDelegate
    public FragmentTabStructure createFragmentTabStructure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            FragmentTabStructure fragmentTabStructure = new FragmentTabStructure();
            fragmentTabStructure.type = 2;
            fragmentTabStructure.textResId = R.string.ala_live;
            fragmentTabStructure.showIconType = FragmentTabStructure.SHOWTEXT;
            return fragmentTabStructure;
        }
        return (FragmentTabStructure) invokeV.objValue;
    }
}
