package com.baidu.tieba.personPolymeric.tab.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.j;
import d.a.d.k.e.n;
import d.a.p0.s.q.b2;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes4.dex */
public class PersonCenterDynamicTabFragment extends PersonCenterTabBaseFragment implements BdListView.p, d.a.q0.m2.i.b.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean p = true;
    public static CustomMessageListener q;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public d.a.q0.m2.i.d.a f20332f;

    /* renamed from: g  reason: collision with root package name */
    public PersonCenterDynamicTabModel f20333g;

    /* renamed from: h  reason: collision with root package name */
    public long f20334h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20335i;
    public User j;
    public boolean k;
    public boolean l;
    public d.a.q0.m2.i.a.a m;
    public List<n> n;
    public PersonCenterDynamicTabModel.b o;

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterDynamicTabFragment.p = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements PersonCenterDynamicTabModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonCenterDynamicTabFragment f20336a;

        public b(PersonCenterDynamicTabFragment personCenterDynamicTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCenterDynamicTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20336a = personCenterDynamicTabFragment;
        }

        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.b
        public void a(List<b2> list, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.f20336a.X0(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.f20336a.W0(z);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1533255301, "Lcom/baidu/tieba/personPolymeric/tab/fragments/PersonCenterDynamicTabFragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1533255301, "Lcom/baidu/tieba/personPolymeric/tab/fragments/PersonCenterDynamicTabFragment;");
                return;
            }
        }
        q = new a(2921440);
    }

    public PersonCenterDynamicTabFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f20335i = false;
        this.k = false;
        this.l = false;
        this.n = new ArrayList();
        this.o = new b(this);
    }

    public static PersonCenterDynamicTabFragment V0(long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            PersonCenterDynamicTabFragment personCenterDynamicTabFragment = new PersonCenterDynamicTabFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("uid", j);
            bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
            personCenterDynamicTabFragment.setArguments(bundle);
            personCenterDynamicTabFragment.registerListener(q);
            return personCenterDynamicTabFragment;
        }
        return (PersonCenterDynamicTabFragment) invokeCommon.objValue;
    }

    @Override // d.a.q0.m2.i.b.a
    public d.a.q0.m2.i.d.a E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20332f : (d.a.q0.m2.i.d.a) invokeV.objValue;
    }

    @Override // d.a.q0.m2.i.b.a
    public List<n> J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.n : (List) invokeV.objValue;
    }

    public void J0() {
        d.a.q0.m2.i.d.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (aVar = this.f20332f) != null && this.l) {
            aVar.k();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void M0(boolean z) {
        d.a.q0.m2.i.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || this.f20333g == null || (aVar = this.f20332f) == null || !this.l || this.k) {
            return;
        }
        hideNetRefreshView(aVar.f());
        if (j.z()) {
            this.k = true;
            if (z && p) {
                showLoadingView(this.f20332f.f(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
            }
            this.f20333g.I();
            J0();
            return;
        }
        showNetRefreshView(this.f20332f.f(), null, false);
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public int N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public boolean O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f20335i : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void P0(MetaData metaData) {
        PersonCenterDynamicTabModel personCenterDynamicTabModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, metaData) == null) || (personCenterDynamicTabModel = this.f20333g) == null) {
            return;
        }
        personCenterDynamicTabModel.J(metaData);
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void Q0(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, user) == null) {
            this.j = user;
            PersonCenterDynamicTabModel personCenterDynamicTabModel = this.f20333g;
            if (personCenterDynamicTabModel != null) {
                personCenterDynamicTabModel.L(user);
            }
        }
    }

    public final void U0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            if (bundle != null) {
                this.f20334h = bundle.getLong("uid");
                this.f20335i = bundle.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
                return;
            }
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f20334h = arguments.getLong("uid");
                this.f20335i = arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
            }
        }
    }

    public final void W0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.k = false;
            hideNetRefreshView(this.f20332f.f());
            hideLoadingView(this.f20332f.f());
            this.f20332f.g();
            if (z) {
                showNetRefreshView(this.f20332f.f(), null, false);
            }
        }
    }

    public final void X0(List<b2> list, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.k = false;
            hideNetRefreshView(this.f20332f.f());
            hideLoadingView(this.f20332f.f());
            if (z) {
                this.f20332f.o();
            } else {
                this.f20332f.q();
            }
            List<n> a2 = d.a.q0.m2.i.c.a.a(list);
            this.n = a2;
            this.f20332f.n(a2);
        }
    }

    @Override // d.a.q0.m2.i.b.a
    public boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f20335i && isPrimary() && !this.k : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            super.onChangeSkinType(i2);
            d.a.q0.m2.i.d.a aVar = this.f20332f;
            if (aVar != null) {
                aVar.i(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            U0(bundle);
            PersonCenterDynamicTabModel personCenterDynamicTabModel = new PersonCenterDynamicTabModel(getPageContext(), this.f20334h);
            this.f20333g = personCenterDynamicTabModel;
            personCenterDynamicTabModel.K(this.o);
            this.m = new d.a.q0.m2.i.a.a(getPageContext());
            new d.a.q0.m2.i.a.b(getPageContext(), getUniqueId(), this, N0());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
            d.a.q0.m2.i.d.a aVar = new d.a.q0.m2.i.d.a(getPageContext(), inflate, this);
            this.f20332f = aVar;
            aVar.m(1013);
            this.f20332f.l(this);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroy();
            this.l = false;
            this.k = false;
            PersonCenterDynamicTabModel personCenterDynamicTabModel = this.f20333g;
            if (personCenterDynamicTabModel != null) {
                personCenterDynamicTabModel.onDestroy();
            }
            d.a.q0.m2.i.d.a aVar = this.f20332f;
            if (aVar != null) {
                aVar.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onNetRefreshButtonClicked();
            M0(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        d.a.q0.m2.i.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary() && !this.l) {
                this.l = true;
                M0(true);
                if (!TbSingleton.getInstance().isShowShoubaiDynamicGuide() || (aVar = this.m) == null || aVar.c() || !this.f20335i) {
                    return;
                }
                this.m.f();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putLong("uid", this.f20334h);
            bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, this.f20335i);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && this.f20333g != null && this.l && !this.k && j.z() && this.f20333g.E()) {
            this.k = true;
            this.f20333g.G();
        }
    }
}
