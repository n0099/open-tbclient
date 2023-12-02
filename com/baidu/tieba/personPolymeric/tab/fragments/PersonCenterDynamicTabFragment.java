package com.baidu.tieba.personPolymeric.tab.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.R;
import com.baidu.tieba.oca;
import com.baidu.tieba.pca;
import com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel;
import com.baidu.tieba.pi;
import com.baidu.tieba.qca;
import com.baidu.tieba.rca;
import com.baidu.tieba.sca;
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
/* loaded from: classes7.dex */
public class PersonCenterDynamicTabFragment extends PersonCenterTabBaseFragment implements BdListView.p, qca {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean l = true;
    public static CustomMessageListener m;
    public transient /* synthetic */ FieldHolder $fh;
    public sca b;
    public PersonCenterDynamicTabModel c;
    public long d;
    public boolean e;
    public User f;
    public boolean g;
    public boolean h;
    public oca i;
    public List<pi> j;
    public PersonCenterDynamicTabModel.b k;

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public int H2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 1;
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
            boolean unused = PersonCenterDynamicTabFragment.l = ((Boolean) customResponsedMessage.getData()).booleanValue();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements PersonCenterDynamicTabModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonCenterDynamicTabFragment a;

        public b(PersonCenterDynamicTabFragment personCenterDynamicTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCenterDynamicTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personCenterDynamicTabFragment;
        }

        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) != null) {
                return;
            }
            this.a.Q2(z);
        }

        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.b
        public void a(List<ThreadData> list, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) {
                return;
            }
            this.a.R2(list, z, z2);
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
        m = new a(2921440);
    }

    public void F() {
        sca scaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (scaVar = this.b) != null && this.h) {
            scaVar.k();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public boolean I2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.qca
    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.e && isPrimary() && !this.g) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.qca
    public List<pi> getListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.j;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qca
    public sca getMainView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.b;
        }
        return (sca) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroy();
            this.h = false;
            this.g = false;
            PersonCenterDynamicTabModel personCenterDynamicTabModel = this.c;
            if (personCenterDynamicTabModel != null) {
                personCenterDynamicTabModel.onDestroy();
            }
            sca scaVar = this.b;
            if (scaVar != null) {
                scaVar.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onNetRefreshButtonClicked();
            G2(true);
        }
    }

    public PersonCenterDynamicTabFragment() {
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
        this.e = false;
        this.g = false;
        this.h = false;
        this.j = new ArrayList();
        this.k = new b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        oca ocaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary() && !this.h) {
                this.h = true;
                G2(true);
                if (TbSingleton.getInstance().isShowShoubaiDynamicGuide() && (ocaVar = this.i) != null && !ocaVar.c() && this.e) {
                    this.i.f();
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && this.c != null && this.h && !this.g && BdNetTypeUtil.isNetWorkAvailable() && this.c.W()) {
            this.g = true;
            this.c.Y();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void J2(MetaData metaData) {
        PersonCenterDynamicTabModel personCenterDynamicTabModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, metaData) == null) && (personCenterDynamicTabModel = this.c) != null) {
            personCenterDynamicTabModel.b0(metaData);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void K2(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, user) == null) {
            this.f = user;
            PersonCenterDynamicTabModel personCenterDynamicTabModel = this.c;
            if (personCenterDynamicTabModel != null) {
                personCenterDynamicTabModel.d0(user);
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            super.onChangeSkinType(i);
            sca scaVar = this.b;
            if (scaVar != null) {
                scaVar.i(i);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putLong("uid", this.d);
            bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, this.e);
        }
    }

    public static PersonCenterDynamicTabFragment P2(long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            PersonCenterDynamicTabFragment personCenterDynamicTabFragment = new PersonCenterDynamicTabFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("uid", j);
            bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
            personCenterDynamicTabFragment.setArguments(bundle);
            personCenterDynamicTabFragment.registerListener(m);
            return personCenterDynamicTabFragment;
        }
        return (PersonCenterDynamicTabFragment) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void G2(boolean z) {
        sca scaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) != null) || this.c == null || (scaVar = this.b) == null || !this.h || this.g) {
            return;
        }
        hideNetRefreshView(scaVar.f());
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.g = true;
            if (z && l) {
                showLoadingView(this.b.f(), false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703a7));
            }
            this.c.a0();
            F();
            return;
        }
        showNetRefreshView(this.b.f(), null, false);
    }

    public final void O2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
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

    public final void Q2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.g = false;
            hideNetRefreshView(this.b.f());
            hideLoadingView(this.b.f());
            this.b.g();
            if (z) {
                showNetRefreshView(this.b.f(), null, false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            O2(bundle);
            PersonCenterDynamicTabModel personCenterDynamicTabModel = new PersonCenterDynamicTabModel(getPageContext(), this.d);
            this.c = personCenterDynamicTabModel;
            personCenterDynamicTabModel.c0(this.k);
            this.i = new oca(getPageContext());
            new pca(getPageContext(), getUniqueId(), this, H2());
        }
    }

    public final void R2(List<ThreadData> list, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.g = false;
            hideNetRefreshView(this.b.f());
            hideLoadingView(this.b.f());
            if (z) {
                this.b.o();
            } else {
                this.b.q();
            }
            List<pi> a2 = rca.a(list);
            this.j = a2;
            this.b.n(a2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d07fb, viewGroup, false);
            sca scaVar = new sca(getPageContext(), inflate, this);
            this.b = scaVar;
            scaVar.m(1013);
            this.b.l(this);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
