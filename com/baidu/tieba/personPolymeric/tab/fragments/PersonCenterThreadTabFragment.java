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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d58;
import com.repackage.e58;
import com.repackage.f58;
import com.repackage.g58;
import com.repackage.ni;
import com.repackage.nn;
import com.repackage.q95;
import com.repackage.t28;
import java.util.List;
import tbclient.User;
/* loaded from: classes3.dex */
public class PersonCenterThreadTabFragment extends PersonCenterTabBaseFragment implements BdListView.p, e58 {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean l = true;
    public static CustomMessageListener m;
    public transient /* synthetic */ FieldHolder $fh;
    public g58 b;
    public long c;
    public boolean d;
    public PersonPostModel e;
    public User f;
    public boolean g;
    public boolean h;
    public boolean i;
    public PersonPostModel.d j;
    public PersonPostModel.c k;

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterThreadTabFragment.l = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void s0(PersonPostModel personPostModel, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, personPostModel, z) == null) {
                this.a.B1(personPostModel, z);
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void k0(PersonPostModel personPostModel, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, personPostModel, z) == null) {
                this.a.B1(personPostModel, z);
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
        m = new a(2921440);
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

    public static PersonCenterThreadTabFragment F1(long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), Boolean.valueOf(z)})) == null) {
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

    public final boolean A1(PersonPostModel personPostModel, boolean z) {
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

    public final void B1(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, personPostModel, z) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.g = false;
            hideLoadingView(this.b.f());
            hideNetRefreshView(this.b.f());
            if (personPostModel != null && (personPostModel2 = this.e) != null) {
                if (z) {
                    personPostModel2.threadList.clear();
                }
                this.e.threadList.addAll(f58.c(personPostModel.threadList));
            }
            this.i = A1(personPostModel, z);
            if (ListUtils.isEmpty(this.e.threadList) && !ni.z()) {
                showNetRefreshView(this.b.f(), null, false);
            } else {
                if (this.i) {
                    this.b.o();
                } else {
                    this.b.q();
                }
                H1(this.e.threadList);
            }
            t28.d().l(System.currentTimeMillis() - currentTimeMillis);
            t28.d().p(System.currentTimeMillis() - t28.d().g());
            if (personPostModel == null || personPostModel.getResponsedMessage() == null) {
                return;
            }
            E1(personPostModel.getResponsedMessage());
        }
    }

    public final void C1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && isAdded() && isPrimary() && this.f != null && !this.h) {
            this.h = true;
            t28.d().o(System.currentTimeMillis());
            s1(true);
        }
    }

    public final void D1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
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

    public void E1(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, responsedMessage) == null) {
            long h = t28.d().h();
            long b2 = t28.d().b();
            long a2 = t28.d().a();
            long c2 = t28.d().c();
            long f = t28.d().f();
            if (!PerformanceLoggerHelper.getInstance().isSmallFlow() || b2 <= 0) {
                return;
            }
            long j = h + b2;
            if (a2 > 0) {
                j = System.currentTimeMillis() - a2;
            }
            q95 q95Var = new q95(1010, true, responsedMessage, 0L, b2, c2, false, 0L, 0L, j);
            if (f < 3600000) {
                q95Var.b("profileTime", String.valueOf(f));
            }
            q95Var.c();
            t28.d().k(0L);
        }
    }

    public final void G1(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || this.g) {
            return;
        }
        this.g = true;
        this.e.fetchPost(getPageContext(), this.k, z, String.valueOf(this.c), true, 0, false, true, this.f);
    }

    public void H1(List<nn> list) {
        g58 g58Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, list) == null) || (g58Var = this.b) == null) {
            return;
        }
        g58Var.n(list);
    }

    @Override // com.repackage.e58
    public boolean V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.d && isPrimary() && !this.g : invokeV.booleanValue;
    }

    @Override // com.repackage.e58
    public List<nn> g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            PersonPostModel personPostModel = this.e;
            if (personPostModel != null) {
                return personPostModel.threadList;
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.repackage.e58
    public g58 getMainView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.b : (g58) invokeV.objValue;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            super.onChangeSkinType(i);
            g58 g58Var = this.b;
            if (g58Var != null) {
                g58Var.i(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onCreate(bundle);
            D1(bundle);
            this.e = new PersonPostModel(getPageContext(), getUniqueId(), this.j, u1(), PersonPostModel.FROM_PERSON_POST);
            new d58(getPageContext(), getUniqueId(), this, t1());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d06b8, viewGroup, false);
            g58 g58Var = new g58(getPageContext(), inflate, this);
            this.b = g58Var;
            g58Var.m(1012);
            this.b.l(this);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDestroy();
            this.i = false;
            this.h = false;
            this.g = false;
            g58 g58Var = this.b;
            if (g58Var != null) {
                g58Var.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onNetRefreshButtonClicked();
            s1(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onPrimary();
            C1();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putLong("uid", this.c);
            bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, this.d);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.e != null && this.h && ni.z() && this.i) {
            G1(false);
        }
    }

    public void p1() {
        g58 g58Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (g58Var = this.b) != null && this.h) {
            g58Var.k();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void s1(boolean z) {
        g58 g58Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z) == null) || this.e == null || (g58Var = this.b) == null || !this.h) {
            return;
        }
        hideNetRefreshView(g58Var.f());
        if (ni.z()) {
            if (z && l) {
                showLoadingView(this.b.f(), false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070288));
            }
            G1(true);
            p1();
            return;
        }
        showNetRefreshView(this.b.f(), null, false);
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public int t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public boolean u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.d : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void w1(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, user) == null) {
            this.f = user;
            C1();
        }
    }
}
