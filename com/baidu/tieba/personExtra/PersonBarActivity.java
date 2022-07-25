package com.baidu.tieba.personExtra;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.l28;
/* loaded from: classes3.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonBarAdapter u;
    public PersonBarModel v;

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
    public BasePersonInfoAdapter B0(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, basePersonInfoActivity, z)) == null) {
            if (this.u == null) {
                this.u = new PersonBarAdapter(this, F0());
            }
            return this.u;
        }
        return (BasePersonInfoAdapter) invokeLZ.objValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? getPageContext().getString(R.string.obfuscated_res_0x7f0f0de5) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "common_forum" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? getPageContext().getString(R.string.obfuscated_res_0x7f0f0dea) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? getPageContext().getString(R.string.obfuscated_res_0x7f0f0de6) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getPageContext().getString(R.string.obfuscated_res_0x7f0f02ab) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getPageContext().getString(R.string.obfuscated_res_0x7f0f0de9) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public PersonBarModel a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.v : (PersonBarModel) invokeV.objValue;
    }

    public int b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.m : invokeV.intValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            if (this.i && this.m != 23011) {
                setSwipeBackEnabled(false);
            }
            PersonBarModel personBarModel = new PersonBarModel(getPageContext(), F0());
            this.v = personBarModel;
            personBarModel.setSex(T0());
            this.v.G(U0());
            this.v.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        l28 X1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            super.onPageSelected(i);
            PersonBarAdapter personBarAdapter = this.u;
            if (personBarAdapter == null || personBarAdapter.getItem(i) == null || (baseFragment = (BaseFragment) this.u.getItem(i)) == null || !(baseFragment instanceof PersonBarFragment) || (X1 = ((PersonBarFragment) baseFragment).X1()) == null) {
                return;
            }
            X1.f(false);
            X1.notifyDataSetChanged();
        }
    }
}
