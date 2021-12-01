package com.baidu.tieba.personExtra;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.w2.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonFriendAdapter mAdapter;
    public PersonFriendModel mModel;

    public PersonFriendActivity() {
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
                this.mAdapter = new PersonFriendAdapter(this, getIsHost());
            }
            return this.mAdapter;
        }
        return (BasePersonInfoAdapter) invokeLZ.objValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String getCommonTabTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? getPageContext().getString(g.person_friend_common) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String getHisCommonEventText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "common_frd" : (String) invokeV.objValue;
    }

    public PersonFriendModel getModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mModel : (PersonFriendModel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String getNavigationBarTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? getPageContext().getString(g.person_friend_title) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String getNoCommonTabTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getPageContext().getString(g.commonfriend) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String getNoPersonalTabTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getPageContext().getString(g.person_friend_no_personal_title) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String getPersonalTabTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? getPageContext().getString(g.person_friend_personal) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int getPrivacyType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 5;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            PersonFriendModel personFriendModel = new PersonFriendModel(getPageContext(), getIsHost());
            this.mModel = personFriendModel;
            personFriendModel.setSex(getSex());
            this.mModel.A(getUid());
            this.mModel.setUniqueId(getUniqueId());
        }
    }
}
