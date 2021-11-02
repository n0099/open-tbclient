package com.baidu.tieba.personPolymeric.tab.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.j;
import b.a.e.l.e.n;
import b.a.q0.s.q.d2;
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
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes9.dex */
public class PersonCenterDynamicTabFragment extends PersonCenterTabBaseFragment implements BdListView.p, b.a.r0.p2.i.b.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean p = true;
    public static CustomMessageListener q;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.p2.i.d.a f53210f;

    /* renamed from: g  reason: collision with root package name */
    public PersonCenterDynamicTabModel f53211g;

    /* renamed from: h  reason: collision with root package name */
    public long f53212h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f53213i;
    public User j;
    public boolean k;
    public boolean l;
    public b.a.r0.p2.i.a.a m;
    public List<n> n;
    public PersonCenterDynamicTabModel.b o;

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public class b implements PersonCenterDynamicTabModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonCenterDynamicTabFragment f53214a;

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
            this.f53214a = personCenterDynamicTabFragment;
        }

        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.b
        public void a(List<d2> list, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.f53214a.f(list, z, z2);
            }
        }

        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.f53214a.e(z);
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
        this.f53213i = false;
        this.k = false;
        this.l = false;
        this.n = new ArrayList();
        this.o = new b(this);
    }

    public static PersonCenterDynamicTabFragment newInstance(long j, boolean z) {
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

    public final void d(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            if (bundle != null) {
                this.f53212h = bundle.getLong("uid");
                this.f53213i = bundle.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
                return;
            }
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f53212h = arguments.getLong("uid");
                this.f53213i = arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
            }
        }
    }

    public final void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.k = false;
            hideNetRefreshView(this.f53210f.f());
            hideLoadingView(this.f53210f.f());
            this.f53210f.g();
            if (z) {
                showNetRefreshView(this.f53210f.f(), null, false);
            }
        }
    }

    public final void f(List<d2> list, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.k = false;
            hideNetRefreshView(this.f53210f.f());
            hideLoadingView(this.f53210f.f());
            if (z) {
                this.f53210f.o();
            } else {
                this.f53210f.q();
            }
            List<n> a2 = b.a.r0.p2.i.c.a.a(list);
            this.n = a2;
            this.f53210f.n(a2);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void forceRefresh(boolean z) {
        b.a.r0.p2.i.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || this.f53211g == null || (aVar = this.f53210f) == null || !this.l || this.k) {
            return;
        }
        hideNetRefreshView(aVar.f());
        if (j.z()) {
            this.k = true;
            if (z && p) {
                showLoadingView(this.f53210f.f(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
            }
            this.f53211g.I();
            scrollToTop();
            return;
        }
        showNetRefreshView(this.f53210f.f(), null, false);
    }

    @Override // b.a.r0.p2.i.b.a
    public List<n> getListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : (List) invokeV.objValue;
    }

    @Override // b.a.r0.p2.i.b.a
    public b.a.r0.p2.i.d.a getMainView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f53210f : (b.a.r0.p2.i.d.a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public int getTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // b.a.r0.p2.i.b.a
    public boolean isAvaliableToShowManageWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f53213i && isPrimary() && !this.k : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public boolean isHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f53213i : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            super.onChangeSkinType(i2);
            b.a.r0.p2.i.d.a aVar = this.f53210f;
            if (aVar != null) {
                aVar.i(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            d(bundle);
            PersonCenterDynamicTabModel personCenterDynamicTabModel = new PersonCenterDynamicTabModel(getPageContext(), this.f53212h);
            this.f53211g = personCenterDynamicTabModel;
            personCenterDynamicTabModel.K(this.o);
            this.m = new b.a.r0.p2.i.a.a(getPageContext());
            new b.a.r0.p2.i.a.b(getPageContext(), getUniqueId(), this, getTabType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
            b.a.r0.p2.i.d.a aVar = new b.a.r0.p2.i.d.a(getPageContext(), inflate, this);
            this.f53210f = aVar;
            aVar.m(1013);
            this.f53210f.l(this);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            this.l = false;
            this.k = false;
            PersonCenterDynamicTabModel personCenterDynamicTabModel = this.f53211g;
            if (personCenterDynamicTabModel != null) {
                personCenterDynamicTabModel.onDestroy();
            }
            b.a.r0.p2.i.d.a aVar = this.f53210f;
            if (aVar != null) {
                aVar.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onNetRefreshButtonClicked();
            forceRefresh(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        b.a.r0.p2.i.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary() && !this.l) {
                this.l = true;
                forceRefresh(true);
                if (!TbSingleton.getInstance().isShowShoubaiDynamicGuide() || (aVar = this.m) == null || aVar.c() || !this.f53213i) {
                    return;
                }
                this.m.f();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putLong("uid", this.f53212h);
            bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, this.f53213i);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.f53211g != null && this.l && !this.k && j.z() && this.f53211g.E()) {
            this.k = true;
            this.f53211g.G();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void scrollToTop() {
        b.a.r0.p2.i.d.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (aVar = this.f53210f) != null && this.l) {
            aVar.k();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void setAuthor(MetaData metaData) {
        PersonCenterDynamicTabModel personCenterDynamicTabModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, metaData) == null) || (personCenterDynamicTabModel = this.f53211g) == null) {
            return;
        }
        personCenterDynamicTabModel.J(metaData);
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void setUser(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, user) == null) {
            this.j = user;
            PersonCenterDynamicTabModel personCenterDynamicTabModel = this.f53211g;
            if (personCenterDynamicTabModel != null) {
                personCenterDynamicTabModel.L(user);
            }
        }
    }
}
