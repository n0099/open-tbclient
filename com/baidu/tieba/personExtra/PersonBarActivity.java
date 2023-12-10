package com.baidu.tieba.personExtra;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
import com.baidu.tieba.y9a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonBarAdapter u;
    public PersonBarModel v;

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? "common_forum" : (String) invokeV.objValue;
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
    public String D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return getPageContext().getString(R.string.obfuscated_res_0x7f0f1096);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return getPageContext().getString(R.string.obfuscated_res_0x7f0f1092);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return getPageContext().getString(R.string.attention_bar);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return getPageContext().getString(R.string.obfuscated_res_0x7f0f1095);
        }
        return (String) invokeV.objValue;
    }

    public PersonBarModel R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.v;
        }
        return (PersonBarModel) invokeV.objValue;
    }

    public int S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return getPageContext().getString(R.string.obfuscated_res_0x7f0f1091);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            if (this.i && this.m != 23011) {
                setSwipeBackEnabled(false);
            }
            PersonBarModel personBarModel = new PersonBarModel(getPageContext(), z1());
            this.v = personBarModel;
            personBarModel.setSex(K1());
            this.v.U(M1());
            this.v.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        BaseFragment baseFragment;
        y9a k3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            super.onPageSelected(i);
            PersonBarAdapter personBarAdapter = this.u;
            if (personBarAdapter != null && personBarAdapter.getItem(i) != null && (baseFragment = (BaseFragment) this.u.getItem(i)) != null && (baseFragment instanceof PersonBarFragment) && (k3 = ((PersonBarFragment) baseFragment).k3()) != null) {
                k3.f(false);
                k3.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter v1(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048585, this, basePersonInfoActivity, z)) == null) {
            if (this.u == null) {
                this.u = new PersonBarAdapter(this, z1());
            }
            return this.u;
        }
        return (BasePersonInfoAdapter) invokeLZ.objValue;
    }
}
