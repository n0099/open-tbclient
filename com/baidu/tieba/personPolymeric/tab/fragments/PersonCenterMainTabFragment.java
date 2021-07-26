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
import d.a.d.k.e.n;
import d.a.q0.m2.i.d.a;
import d.a.q0.m2.i.d.b;
import java.util.List;
import tbclient.User;
/* loaded from: classes4.dex */
public class PersonCenterMainTabFragment extends PersonCenterTabBaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public a f20337f;

    /* renamed from: g  reason: collision with root package name */
    public b f20338g;

    /* renamed from: h  reason: collision with root package name */
    public long f20339h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20340i;
    public d.a.q0.m2.e.a j;

    public PersonCenterMainTabFragment() {
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
        this.f20340i = false;
    }

    public static PersonCenterMainTabFragment S0(long j, boolean z) {
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

    public void J0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f20337f != null && isAdded()) {
            this.f20337f.k();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void M0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            J0();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public int N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public boolean O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f20340i : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void Q0(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, user) == null) {
        }
    }

    public final void R0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            if (bundle != null) {
                this.f20339h = bundle.getLong("uid");
                this.f20340i = bundle.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
                return;
            }
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f20339h = arguments.getLong("uid");
                this.f20340i = arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
            }
        }
    }

    public final void T0(d.a.q0.m2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) || this.f20337f == null || this.f20338g == null || aVar == null) {
            return;
        }
        List<n> b2 = d.a.q0.m2.i.c.a.b(aVar.h());
        if (!ListUtils.isEmpty(b2)) {
            this.f20337f.r(R.string.person_center_tab_main_footer_text);
        }
        this.f20337f.n(b2);
        this.f20338g.m(aVar);
        this.f20338g.n(ListUtils.isEmpty(b2), O0());
    }

    public void U0(d.a.q0.m2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            if (aVar != null && this.f20337f != null && isAdded()) {
                T0(aVar);
            } else if (aVar != null) {
                this.j = aVar;
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            super.onChangeSkinType(i2);
            a aVar = this.f20337f;
            if (aVar != null) {
                aVar.i(i2);
            }
            b bVar = this.f20338g;
            if (bVar != null) {
                bVar.r(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            R0(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
            a aVar = new a(getPageContext(), inflate, this);
            this.f20337f = aVar;
            aVar.m(1011);
            b bVar = new b(getPageContext(), this.f20340i);
            this.f20338g = bVar;
            this.f20337f.d(bVar.o());
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroy();
            a aVar = this.f20337f;
            if (aVar != null) {
                aVar.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        d.a.q0.m2.e.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onResume();
            if (this.f20337f == null || this.f20338g == null || (aVar = this.j) == null) {
                return;
            }
            T0(aVar);
            this.j = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putLong("uid", this.f20339h);
            bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, this.f20340i);
        }
    }
}
