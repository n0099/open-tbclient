package com.baidu.tieba.personPolymeric.tab.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.j;
import c.a.d.m.e.n;
import c.a.q0.r0.h;
import c.a.q0.r0.k;
import c.a.r0.w2.e;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.User;
/* loaded from: classes11.dex */
public class PersonCenterThreadTabFragment extends PersonCenterTabBaseFragment implements BdListView.p, c.a.r0.v2.i.b.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean p = true;
    public static CustomMessageListener q;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.v2.i.d.a f48356f;

    /* renamed from: g  reason: collision with root package name */
    public long f48357g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f48358h;

    /* renamed from: i  reason: collision with root package name */
    public PersonPostModel f48359i;

    /* renamed from: j  reason: collision with root package name */
    public User f48360j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f48361k;
    public boolean l;
    public boolean m;
    public PersonPostModel.d n;
    public PersonPostModel.c o;

    /* loaded from: classes11.dex */
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
                boolean unused = PersonCenterThreadTabFragment.p = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements PersonPostModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonCenterThreadTabFragment f48362e;

        public b(PersonCenterThreadTabFragment personCenterThreadTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCenterThreadTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48362e = personCenterThreadTabFragment;
        }

        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.d
        public void on(PersonPostModel personPostModel, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, personPostModel, z) == null) {
                this.f48362e.e(personPostModel, z);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c implements PersonPostModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonCenterThreadTabFragment f48363e;

        public c(PersonCenterThreadTabFragment personCenterThreadTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCenterThreadTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48363e = personCenterThreadTabFragment;
        }

        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.c
        public void onResult(PersonPostModel personPostModel, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, personPostModel, z) == null) {
                this.f48363e.e(personPostModel, z);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1765998202, "Lcom/baidu/tieba/personPolymeric/tab/fragments/PersonCenterThreadTabFragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1765998202, "Lcom/baidu/tieba/personPolymeric/tab/fragments/PersonCenterThreadTabFragment;");
                return;
            }
        }
        q = new a(2921440);
    }

    public PersonCenterThreadTabFragment() {
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
        this.f48358h = false;
        this.f48361k = false;
        this.l = false;
        this.m = false;
        this.n = new b(this);
        this.o = new c(this);
    }

    public static PersonCenterThreadTabFragment newInstance(long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            PersonCenterThreadTabFragment personCenterThreadTabFragment = new PersonCenterThreadTabFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("uid", j2);
            bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
            personCenterThreadTabFragment.setArguments(bundle);
            personCenterThreadTabFragment.registerListener(q);
            return personCenterThreadTabFragment;
        }
        return (PersonCenterThreadTabFragment) invokeCommon.objValue;
    }

    public final boolean d(PersonPostModel personPostModel, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, personPostModel, z)) == null) {
            if (personPostModel != null) {
                boolean z2 = !ListUtils.isEmpty(personPostModel.threadList);
                if (!z) {
                    return z2;
                }
                if (personPostModel.threadList.size() >= 20) {
                    return true;
                }
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public final void e(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, personPostModel, z) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f48361k = false;
            hideLoadingView(this.f48356f.f());
            hideNetRefreshView(this.f48356f.f());
            if (personPostModel != null && (personPostModel2 = this.f48359i) != null) {
                if (z) {
                    personPostModel2.threadList.clear();
                }
                this.f48359i.threadList.addAll(c.a.r0.v2.i.c.a.c(personPostModel.threadList));
            }
            this.m = d(personPostModel, z);
            if (ListUtils.isEmpty(this.f48359i.threadList) && !j.z()) {
                showNetRefreshView(this.f48356f.f(), null, false);
            } else {
                if (this.m) {
                    this.f48356f.o();
                } else {
                    this.f48356f.q();
                }
                setData(this.f48359i.threadList);
            }
            c.a.r0.v2.b.d().l(System.currentTimeMillis() - currentTimeMillis);
            c.a.r0.v2.b.d().p(System.currentTimeMillis() - c.a.r0.v2.b.d().g());
            if (personPostModel == null || personPostModel.getResponsedMessage() == null) {
                return;
            }
            logCostTimeLog(personPostModel.getResponsedMessage());
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void forceRefresh(boolean z) {
        c.a.r0.v2.i.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.f48359i == null || (aVar = this.f48356f) == null || !this.l) {
            return;
        }
        hideNetRefreshView(aVar.f());
        if (j.z()) {
            if (z && p) {
                showLoadingView(this.f48356f.f(), false, getResources().getDimensionPixelSize(c.a.r0.w2.b.ds250));
            }
            k(true);
            scrollToTop();
            return;
        }
        showNetRefreshView(this.f48356f.f(), null, false);
    }

    @Override // c.a.r0.v2.i.b.a
    public List<n> getListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            PersonPostModel personPostModel = this.f48359i;
            if (personPostModel != null) {
                return personPostModel.threadList;
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // c.a.r0.v2.i.b.a
    public c.a.r0.v2.i.d.a getMainView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f48356f : (c.a.r0.v2.i.d.a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public int getTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && isAdded() && isPrimary() && this.f48360j != null && !this.l) {
            this.l = true;
            c.a.r0.v2.b.d().o(System.currentTimeMillis());
            forceRefresh(true);
        }
    }

    @Override // c.a.r0.v2.i.b.a
    public boolean isAvaliableToShowManageWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f48358h && isPrimary() && !this.f48361k : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public boolean isHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f48358h : invokeV.booleanValue;
    }

    public final void j(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            if (bundle != null) {
                this.f48357g = bundle.getLong("uid");
                this.f48358h = bundle.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
                return;
            }
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f48357g = arguments.getLong("uid");
                this.f48358h = arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
            }
        }
    }

    public final void k(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || this.f48361k) {
            return;
        }
        this.f48361k = true;
        this.f48359i.fetchPost(getPageContext(), this.o, z, String.valueOf(this.f48357g), true, 0, false, true, this.f48360j);
    }

    public void logCostTimeLog(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, responsedMessage) == null) {
            long h2 = c.a.r0.v2.b.d().h();
            long b2 = c.a.r0.v2.b.d().b();
            long a2 = c.a.r0.v2.b.d().a();
            long c2 = c.a.r0.v2.b.d().c();
            long f2 = c.a.r0.v2.b.d().f();
            if (!k.d().g() || b2 <= 0) {
                return;
            }
            long j2 = h2 + b2;
            if (a2 > 0) {
                j2 = System.currentTimeMillis() - a2;
            }
            h hVar = new h(1010, true, responsedMessage, 0L, b2, c2, false, 0L, 0L, j2);
            if (f2 < 3600000) {
                hVar.b("profileTime", String.valueOf(f2));
            }
            hVar.c();
            c.a.r0.v2.b.d().k(0L);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            super.onChangeSkinType(i2);
            c.a.r0.v2.i.d.a aVar = this.f48356f;
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
            j(bundle);
            this.f48359i = new PersonPostModel(getPageContext(), getUniqueId(), this.n, isHost(), PersonPostModel.FROM_PERSON_POST);
            new c.a.r0.v2.i.a.b(getPageContext(), getUniqueId(), this, getTabType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(e.person_center_common_tab_layout, viewGroup, false);
            c.a.r0.v2.i.d.a aVar = new c.a.r0.v2.i.d.a(getPageContext(), inflate, this);
            this.f48356f = aVar;
            aVar.m(1012);
            this.f48356f.l(this);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroy();
            this.m = false;
            this.l = false;
            this.f48361k = false;
            c.a.r0.v2.i.d.a aVar = this.f48356f;
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
            forceRefresh(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPrimary();
            i();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putLong("uid", this.f48357g);
            bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, this.f48358h);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && this.f48359i != null && this.l && j.z() && this.m) {
            k(false);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void scrollToTop() {
        c.a.r0.v2.i.d.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (aVar = this.f48356f) != null && this.l) {
            aVar.k();
        }
    }

    public void setData(List<n> list) {
        c.a.r0.v2.i.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, list) == null) || (aVar = this.f48356f) == null) {
            return;
        }
        aVar.n(list);
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void setUser(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, user) == null) {
            this.f48360j = user;
            i();
        }
    }
}
