package com.baidu.tieba.personExtra;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
import com.baidu.tieba.o69;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonBarAdapter u;
    public PersonBarModel v;

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "common_forum" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public PersonBarActivity() {
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
        this.u = null;
        this.v = null;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return getPageContext().getString(R.string.obfuscated_res_0x7f0f0f10);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return getPageContext().getString(R.string.obfuscated_res_0x7f0f0f15);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return getPageContext().getString(R.string.obfuscated_res_0x7f0f0f11);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return getPageContext().getString(R.string.attention_bar);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return getPageContext().getString(R.string.obfuscated_res_0x7f0f0f14);
        }
        return (String) invokeV.objValue;
    }

    public PersonBarModel W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.v;
        }
        return (PersonBarModel) invokeV.objValue;
    }

    public int X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter D1(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, basePersonInfoActivity, z)) == null) {
            if (this.u == null) {
                this.u = new PersonBarAdapter(this, I1());
            }
            return this.u;
        }
        return (BasePersonInfoAdapter) invokeLZ.objValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            if (this.i && this.m != 23011) {
                setSwipeBackEnabled(false);
            }
            PersonBarModel personBarModel = new PersonBarModel(getPageContext(), I1());
            this.v = personBarModel;
            personBarModel.setSex(R1());
            this.v.b0(S1());
            this.v.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        o69 j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            super.onPageSelected(i);
            PersonBarAdapter personBarAdapter = this.u;
            if (personBarAdapter != null && personBarAdapter.getItem(i) != null && (baseFragment = (BaseFragment) this.u.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (j2 = ((PersonBarFragment) baseFragment).j2()) != null) {
                j2.f(false);
                j2.notifyDataSetChanged();
            }
        }
    }
}
