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
import d.a.s0.l2.c;
/* loaded from: classes5.dex */
public class PersonBarActivity extends BasePersonInfoActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonBarAdapter mAdapter;
    public PersonBarModel mModel;

    public PersonBarActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAdapter = null;
        this.mModel = null;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter createPersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, basePersonInfoActivity, z)) == null) {
            if (this.mAdapter == null) {
                this.mAdapter = new PersonBarAdapter(this, getIsHost());
            }
            return this.mAdapter;
        }
        return (BasePersonInfoAdapter) invokeLZ.objValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String getCommonTabTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? getPageContext().getString(R.string.person_bar_common) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String getHisCommonEventText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "common_forum" : (String) invokeV.objValue;
    }

    public PersonBarModel getModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mModel : (PersonBarModel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String getNavigationBarTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? getPageContext().getString(R.string.person_bar_title) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String getNoCommonTabTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getPageContext().getString(R.string.person_bar_no_common_title) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String getNoPersonalTabTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getPageContext().getString(R.string.attention_bar) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String getPersonalTabTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? getPageContext().getString(R.string.person_bar_personal) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int getPrivacyType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public int getRequestCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.requestCode : invokeV.intValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            if (this.mIsChooseBarMode && this.requestCode != 23011) {
                setSwipeBackEnabled(false);
            }
            PersonBarModel personBarModel = new PersonBarModel(getPageContext(), getIsHost());
            this.mModel = personBarModel;
            personBarModel.setSex(getSex());
            this.mModel.C(getUid());
            this.mModel.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        BaseFragment baseFragment;
        c k1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            super.onPageSelected(i2);
            PersonBarAdapter personBarAdapter = this.mAdapter;
            if (personBarAdapter == null || personBarAdapter.getItem(i2) == null || (baseFragment = (BaseFragment) this.mAdapter.getItem(i2)) == null || !(baseFragment instanceof PersonBarFragment) || (k1 = ((PersonBarFragment) baseFragment).k1()) == null) {
                return;
            }
            k1.f(false);
            k1.notifyDataSetChanged();
        }
    }
}
