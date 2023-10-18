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
import com.baidu.tieba.ju9;
import com.baidu.tieba.ku9;
import com.baidu.tieba.lu9;
import com.baidu.tieba.mn5;
import com.baidu.tieba.mu9;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.yh;
import com.baidu.tieba.zr9;
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
public class PersonCenterThreadTabFragment extends PersonCenterTabBaseFragment implements BdListView.p, ku9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean l = true;
    public static CustomMessageListener m;
    public transient /* synthetic */ FieldHolder $fh;
    public mu9 b;
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
    public int d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
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
        public void S0(PersonPostModel personPostModel, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLZ(1048576, this, personPostModel, z) != null) {
                return;
            }
            this.a.k2(personPostModel, z);
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
        public void I0(PersonPostModel personPostModel, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLZ(1048576, this, personPostModel, z) != null) {
                return;
            }
            this.a.k2(personPostModel, z);
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

    public void Y1() {
        mu9 mu9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (mu9Var = this.b) != null && this.h) {
            mu9Var.k();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ku9
    public List<yh> getListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            PersonPostModel personPostModel = this.e;
            if (personPostModel != null) {
                return personPostModel.threadList;
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ku9
    public mu9 getMainView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (mu9) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroy();
            this.i = false;
            this.h = false;
            this.g = false;
            mu9 mu9Var = this.b;
            if (mu9Var != null) {
                mu9Var.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onNetRefreshButtonClicked();
            c2(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPrimary();
            l2();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && this.e != null && this.h && BdNetTypeUtil.isNetWorkAvailable() && this.i) {
            p2(false);
        }
    }

    @Override // com.baidu.tieba.ku9
    public boolean y1() {
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

    public final void l2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && isAdded() && isPrimary() && this.f != null && !this.h) {
            this.h = true;
            zr9.d().o(System.currentTimeMillis());
            c2(true);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void g2(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, user) == null) {
            this.f = user;
            l2();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            super.onChangeSkinType(i);
            mu9 mu9Var = this.b;
            if (mu9Var != null) {
                mu9Var.i(i);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putLong("uid", this.c);
            bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, this.d);
        }
    }

    public final void p2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048596, this, z) != null) || this.g) {
            return;
        }
        this.g = true;
        this.e.fetchPost(getPageContext(), this.k, z, String.valueOf(this.c), true, 0, false, true, this.f);
    }

    public void q2(List<yh> list) {
        mu9 mu9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, list) == null) && (mu9Var = this.b) != null) {
            mu9Var.n(list);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d07cb, viewGroup, false);
            mu9 mu9Var = new mu9(getPageContext(), inflate, this);
            this.b = mu9Var;
            mu9Var.m(1012);
            this.b.l(this);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    public static PersonCenterThreadTabFragment o2(long j, boolean z) {
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
    public void c2(boolean z) {
        mu9 mu9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && this.e != null && (mu9Var = this.b) != null && this.h) {
            hideNetRefreshView(mu9Var.f());
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                if (z && l) {
                    showLoadingView(this.b.f(), false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703a6));
                }
                p2(true);
                Y1();
                return;
            }
            showNetRefreshView(this.b.f(), null, false);
        }
    }

    public final boolean j2(PersonPostModel personPostModel, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048583, this, personPostModel, z)) == null) {
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

    public final void k2(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, personPostModel, z) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.g = false;
            hideLoadingView(this.b.f());
            hideNetRefreshView(this.b.f());
            if (personPostModel != null && (personPostModel2 = this.e) != null) {
                if (z) {
                    personPostModel2.threadList.clear();
                }
                this.e.threadList.addAll(lu9.c(personPostModel.threadList));
            }
            this.i = j2(personPostModel, z);
            if (ListUtils.isEmpty(this.e.threadList) && !BdNetTypeUtil.isNetWorkAvailable()) {
                showNetRefreshView(this.b.f(), null, false);
            } else {
                if (this.i) {
                    this.b.o();
                } else {
                    this.b.q();
                }
                q2(this.e.threadList);
            }
            zr9.d().l(System.currentTimeMillis() - currentTimeMillis);
            zr9.d().p(System.currentTimeMillis() - zr9.d().g());
            if (personPostModel != null && personPostModel.getResponsedMessage() != null) {
                n2(personPostModel.getResponsedMessage());
            }
        }
    }

    public final void m2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            m2(bundle);
            this.e = new PersonPostModel(getPageContext(), getUniqueId(), this.j, e2(), 2);
            new ju9(getPageContext(), getUniqueId(), this, d2());
        }
    }

    public void n2(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, responsedMessage) == null) {
            long h = zr9.d().h();
            long b2 = zr9.d().b();
            long a2 = zr9.d().a();
            long c2 = zr9.d().c();
            long f = zr9.d().f();
            if (PerformanceLoggerHelper.getInstance().isSmallFlow() && b2 > 0) {
                long j = h + b2;
                if (a2 > 0) {
                    j = System.currentTimeMillis() - a2;
                }
                mn5 mn5Var = new mn5(1010, true, responsedMessage, 0L, b2, c2, false, 0L, 0L, j);
                if (f < 3600000) {
                    mn5Var.b("profileTime", String.valueOf(f));
                }
                mn5Var.c();
                zr9.d().k(0L);
            }
        }
    }
}
