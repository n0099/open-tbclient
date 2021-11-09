package com.baidu.tieba.personPolymeric.tab.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.e.l.e.n;
import b.a.r0.p2.i.d.a;
import b.a.r0.p2.i.d.b;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.User;
/* loaded from: classes9.dex */
public class PersonCenterMainTabFragment extends PersonCenterTabBaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public a f53214f;

    /* renamed from: g  reason: collision with root package name */
    public b f53215g;

    /* renamed from: h  reason: collision with root package name */
    public long f53216h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f53217i;
    public b.a.r0.p2.e.a j;

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
        this.f53217i = false;
    }

    public static PersonCenterMainTabFragment newInstance(long j, boolean z) {
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

    public final void a(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            if (bundle != null) {
                this.f53216h = bundle.getLong("uid");
                this.f53217i = bundle.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
                return;
            }
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f53216h = arguments.getLong("uid");
                this.f53217i = arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
            }
        }
    }

    public final void b(b.a.r0.p2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || this.f53214f == null || this.f53215g == null || aVar == null) {
            return;
        }
        List<n> b2 = b.a.r0.p2.i.c.a.b(aVar.h());
        if (!ListUtils.isEmpty(b2)) {
            this.f53214f.r(R.string.person_center_tab_main_footer_text);
        }
        this.f53214f.n(b2);
        this.f53215g.m(aVar);
        this.f53215g.n(ListUtils.isEmpty(b2), isHost());
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void forceRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            scrollToTop();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public int getTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public boolean isHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f53217i : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.onChangeSkinType(i2);
            a aVar = this.f53214f;
            if (aVar != null) {
                aVar.i(i2);
            }
            b bVar = this.f53215g;
            if (bVar != null) {
                bVar.r(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            a(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
            a aVar = new a(getPageContext(), inflate, this);
            this.f53214f = aVar;
            aVar.m(1011);
            b bVar = new b(getPageContext(), this.f53217i);
            this.f53215g = bVar;
            this.f53214f.d(bVar.o());
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            a aVar = this.f53214f;
            if (aVar != null) {
                aVar.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        b.a.r0.p2.e.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
            if (this.f53214f == null || this.f53215g == null || (aVar = this.j) == null) {
                return;
            }
            b(aVar);
            this.j = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putLong("uid", this.f53216h);
            bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, this.f53217i);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void scrollToTop() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.f53214f != null && isAdded()) {
            this.f53214f.k();
        }
    }

    public void setData(b.a.r0.p2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            if (aVar != null && this.f53214f != null && isAdded()) {
                b(aVar);
            } else if (aVar != null) {
                this.j = aVar;
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void setUser(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, user) == null) {
        }
    }
}
