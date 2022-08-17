package com.baidu.tieba.personPolymeric.tab.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.k68;
import com.repackage.l78;
import com.repackage.m78;
import com.repackage.n78;
import com.repackage.on;
import java.util.List;
import tbclient.User;
/* loaded from: classes4.dex */
public class PersonCenterMainTabFragment extends PersonCenterTabBaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m78 b;
    public n78 c;
    public long d;
    public boolean e;
    public k68 f;

    public PersonCenterMainTabFragment() {
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
        this.e = false;
    }

    public static PersonCenterMainTabFragment x1(long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            PersonCenterMainTabFragment personCenterMainTabFragment = new PersonCenterMainTabFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("uid", j);
            bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
            personCenterMainTabFragment.setArguments(bundle);
            return personCenterMainTabFragment;
        }
        return (PersonCenterMainTabFragment) invokeCommon.objValue;
    }

    public void A1(k68 k68Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, k68Var) == null) {
            if (k68Var != null && this.b != null && isAdded()) {
                z1(k68Var);
            } else if (k68Var != null) {
                this.f = k68Var;
            }
        }
    }

    public void o1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.b != null && isAdded()) {
            this.b.k();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
            m78 m78Var = this.b;
            if (m78Var != null) {
                m78Var.i(i);
            }
            n78 n78Var = this.c;
            if (n78Var != null) {
                n78Var.r(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            w1(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d06de, viewGroup, false);
            m78 m78Var = new m78(getPageContext(), inflate, this);
            this.b = m78Var;
            m78Var.m(1011);
            n78 n78Var = new n78(getPageContext(), this.e);
            this.c = n78Var;
            this.b.d(n78Var.o());
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            m78 m78Var = this.b;
            if (m78Var != null) {
                m78Var.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        k68 k68Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            if (this.b == null || this.c == null || (k68Var = this.f) == null) {
                return;
            }
            z1(k68Var);
            this.f = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putLong("uid", this.d);
            bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, this.e);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void r1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            o1();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public int s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public boolean t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.e : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void v1(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, user) == null) {
        }
    }

    public final void w1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            if (bundle != null) {
                this.d = bundle.getLong("uid");
                this.e = bundle.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
                return;
            }
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.d = arguments.getLong("uid");
                this.e = arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
            }
        }
    }

    public final void z1(k68 k68Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, k68Var) == null) || this.b == null || this.c == null || k68Var == null) {
            return;
        }
        List<on> b = l78.b(k68Var.h());
        if (!ListUtils.isEmpty(b)) {
            this.b.r(R.string.obfuscated_res_0x7f0f0e2d);
        }
        this.b.n(b);
        this.c.m(k68Var);
        this.c.n(ListUtils.isEmpty(b), t1());
    }
}
