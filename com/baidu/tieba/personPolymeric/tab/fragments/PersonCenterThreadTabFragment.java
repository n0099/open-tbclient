package com.baidu.tieba.personPolymeric.tab.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.bn;
import com.baidu.tieba.hw9;
import com.baidu.tieba.iw9;
import com.baidu.tieba.jw9;
import com.baidu.tieba.kw9;
import com.baidu.tieba.ls5;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.xt9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.User;
/* loaded from: classes7.dex */
public class PersonCenterThreadTabFragment extends PersonCenterTabBaseFragment implements BdListView.p, iw9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean l = true;
    public static CustomMessageListener m;
    public transient /* synthetic */ FieldHolder $fh;
    public kw9 b;
    public long c;
    public boolean d;
    public PersonPostModel e;
    public User f;
    public boolean g;
    public boolean h;
    public boolean i;
    public PersonPostModel.d j;
    public PersonPostModel.c k;

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public int V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes7.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            boolean unused = PersonCenterThreadTabFragment.l = ((Boolean) customResponsedMessage.getData()).booleanValue();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements PersonPostModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonCenterThreadTabFragment a;

        public b(PersonCenterThreadTabFragment personCenterThreadTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCenterThreadTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personCenterThreadTabFragment;
        }

        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.d
        public void L0(PersonPostModel personPostModel, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLZ(1048576, this, personPostModel, z) != null) {
                return;
            }
            this.a.c2(personPostModel, z);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements PersonPostModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonCenterThreadTabFragment a;

        public c(PersonCenterThreadTabFragment personCenterThreadTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCenterThreadTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personCenterThreadTabFragment;
        }

        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.c
        public void A0(PersonPostModel personPostModel, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLZ(1048576, this, personPostModel, z) != null) {
                return;
            }
            this.a.c2(personPostModel, z);
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
        m = new a(2921440);
    }

    public void Q1() {
        kw9 kw9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (kw9Var = this.b) != null && this.h) {
            kw9Var.k();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.iw9
    public List<bn> getListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            PersonPostModel personPostModel = this.e;
            if (personPostModel != null) {
                return personPostModel.threadList;
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.iw9
    public kw9 getMainView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.b;
        }
        return (kw9) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onDestroy();
            this.i = false;
            this.h = false;
            this.g = false;
            kw9 kw9Var = this.b;
            if (kw9Var != null) {
                kw9Var.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onNetRefreshButtonClicked();
            U1(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onPrimary();
            d2();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && this.e != null && this.h && BdNetTypeUtil.isNetWorkAvailable() && this.i) {
            h2(false);
        }
    }

    @Override // com.baidu.tieba.iw9
    public boolean u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.d && isPrimary() && !this.g) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public PersonCenterThreadTabFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = new b(this);
        this.k = new c(this);
    }

    public final void d2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && isAdded() && isPrimary() && this.f != null && !this.h) {
            this.h = true;
            xt9.d().o(System.currentTimeMillis());
            U1(true);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void Y1(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, user) == null) {
            this.f = user;
            d2();
        }
    }

    public final void h2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048588, this, z) != null) || this.g) {
            return;
        }
        this.g = true;
        this.e.fetchPost(getPageContext(), this.k, z, String.valueOf(this.c), true, 0, false, true, this.f);
    }

    public void i2(List<bn> list) {
        kw9 kw9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, list) == null) && (kw9Var = this.b) != null) {
            kw9Var.n(list);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            super.onChangeSkinType(i);
            kw9 kw9Var = this.b;
            if (kw9Var != null) {
                kw9Var.i(i);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putLong("uid", this.c);
            bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, this.d);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048592, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d07c6, viewGroup, false);
            kw9 kw9Var = new kw9(getPageContext(), inflate, this);
            this.b = kw9Var;
            kw9Var.m(1012);
            this.b.l(this);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    public static PersonCenterThreadTabFragment g2(long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            PersonCenterThreadTabFragment personCenterThreadTabFragment = new PersonCenterThreadTabFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("uid", j);
            bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
            personCenterThreadTabFragment.setArguments(bundle);
            personCenterThreadTabFragment.registerListener(m);
            return personCenterThreadTabFragment;
        }
        return (PersonCenterThreadTabFragment) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void U1(boolean z) {
        kw9 kw9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && this.e != null && (kw9Var = this.b) != null && this.h) {
            hideNetRefreshView(kw9Var.f());
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                if (z && l) {
                    showLoadingView(this.b.f(), false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703a6));
                }
                h2(true);
                Q1();
                return;
            }
            showNetRefreshView(this.b.f(), null, false);
        }
    }

    public final boolean b2(PersonPostModel personPostModel, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048581, this, personPostModel, z)) == null) {
            if (personPostModel != null) {
                boolean z2 = !ListUtils.isEmpty(personPostModel.threadList);
                if (z) {
                    if (personPostModel.threadList.size() >= 20) {
                        return true;
                    }
                } else {
                    return z2;
                }
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public final void c2(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, personPostModel, z) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.g = false;
            hideLoadingView(this.b.f());
            hideNetRefreshView(this.b.f());
            if (personPostModel != null && (personPostModel2 = this.e) != null) {
                if (z) {
                    personPostModel2.threadList.clear();
                }
                this.e.threadList.addAll(jw9.c(personPostModel.threadList));
            }
            this.i = b2(personPostModel, z);
            if (ListUtils.isEmpty(this.e.threadList) && !BdNetTypeUtil.isNetWorkAvailable()) {
                showNetRefreshView(this.b.f(), null, false);
            } else {
                if (this.i) {
                    this.b.o();
                } else {
                    this.b.q();
                }
                i2(this.e.threadList);
            }
            xt9.d().l(System.currentTimeMillis() - currentTimeMillis);
            xt9.d().p(System.currentTimeMillis() - xt9.d().g());
            if (personPostModel != null && personPostModel.getResponsedMessage() != null) {
                f2(personPostModel.getResponsedMessage());
            }
        }
    }

    public final void e2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            if (bundle != null) {
                this.c = bundle.getLong("uid");
                this.d = bundle.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
                return;
            }
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.c = arguments.getLong("uid");
                this.d = arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            super.onCreate(bundle);
            e2(bundle);
            this.e = new PersonPostModel(getPageContext(), getUniqueId(), this.j, W1(), 2);
            new hw9(getPageContext(), getUniqueId(), this, V1());
        }
    }

    public void f2(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, responsedMessage) == null) {
            long h = xt9.d().h();
            long b2 = xt9.d().b();
            long a2 = xt9.d().a();
            long c2 = xt9.d().c();
            long f = xt9.d().f();
            if (PerformanceLoggerHelper.getInstance().isSmallFlow() && b2 > 0) {
                long j = h + b2;
                if (a2 > 0) {
                    j = System.currentTimeMillis() - a2;
                }
                ls5 ls5Var = new ls5(1010, true, responsedMessage, 0L, b2, c2, false, 0L, 0L, j);
                if (f < 3600000) {
                    ls5Var.b("profileTime", String.valueOf(f));
                }
                ls5Var.c();
                xt9.d().k(0L);
            }
        }
    }
}
