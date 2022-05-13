package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.aq4;
import com.repackage.f38;
import com.repackage.gq4;
import com.repackage.hj8;
import com.repackage.i38;
import com.repackage.kg;
import com.repackage.pu4;
import com.repackage.qu4;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PersonFriendFragment extends BaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdListView a;
    public f38 b;
    public View c;
    public NoDataView d;
    public qu4 e;
    public PersonFriendModel f;
    public int g;
    public int h;
    public boolean i;
    public gq4 j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public final CustomMessageListener o;
    public HttpMessageListener p;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonFriendFragment a;

        public a(PersonFriendFragment personFriendFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personFriendFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personFriendFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.h = ((Integer) view2.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    this.a.C0();
                } else {
                    TbadkCoreApplication.getInst().login(this.a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.a.getBaseFragmentActivity().getPageContext().getPageActivity(), true, 11028)));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonFriendFragment a;

        public b(PersonFriendFragment personFriendFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personFriendFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personFriendFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.l) {
                return;
            }
            PersonFriendFragment personFriendFragment = this.a;
            personFriendFragment.m = personFriendFragment.f.y().d().a() + 1;
            this.a.l = true;
            this.a.S0();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonFriendFragment a;

        public c(PersonFriendFragment personFriendFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personFriendFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personFriendFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            UserData userData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a.b == null || this.a.b.getItemViewType(i) != 0 || (userData = (UserData) this.a.b.getItem(i)) == null || userData.getUserId() == null) {
                return;
            }
            this.a.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.Q0().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements pu4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonFriendFragment a;

        public d(PersonFriendFragment personFriendFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personFriendFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personFriendFragment;
        }

        @Override // com.repackage.pu4.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.Q0() == null) {
                return;
            }
            this.a.m = 0;
            this.a.k = true;
            this.a.f.A(this.a.i, this.a.Q0().getUid(), this.a.m, this.a.n);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonFriendFragment a;

        public e(PersonFriendFragment personFriendFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personFriendFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personFriendFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.l) {
                return;
            }
            this.a.k = false;
            PersonFriendFragment personFriendFragment = this.a;
            personFriendFragment.m = personFriendFragment.f.y().d().a() + 1;
            this.a.l = true;
            this.a.S0();
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonFriendFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(PersonFriendFragment personFriendFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personFriendFragment, Integer.valueOf(i)};
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
            this.a = personFriendFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && this.a.i) {
                gq4 personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (this.a.Q0() != null) {
                    this.a.j = personFriendData;
                    this.a.update(personFriendData, true);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonFriendFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(PersonFriendFragment personFriendFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personFriendFragment, Integer.valueOf(i)};
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
            this.a = personFriendFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                this.a.l = false;
                if (this.a.Q0() == null || httpResponsedMessage.getOrginalMessage().getTag() != this.a.Q0().getUniqueId()) {
                    return;
                }
                this.a.a.A(0L);
                if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                    PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                    if (personFriendResponseMessage.getError() == 0) {
                        this.a.update(personFriendResponseMessage.getPersonFriendData(), false);
                        return;
                    } else {
                        this.a.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c2d) : httpResponsedMessage.getErrorString());
                        return;
                    }
                }
                this.a.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c2d) : httpResponsedMessage.getErrorString());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2099401046, "Lcom/baidu/tieba/personExtra/PersonFriendFragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2099401046, "Lcom/baidu/tieba/personExtra/PersonFriendFragment;");
                return;
            }
        }
        hj8.b(2001182, i38.class);
    }

    public PersonFriendFragment() {
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
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = 0;
        this.h = 0;
        this.i = true;
        this.j = null;
        this.k = true;
        this.l = false;
        this.m = 0;
        this.n = 20;
        this.o = new f(this, 2001182);
        this.p = new g(this, CmdConfigHttp.PIC_FRIEND_CMD);
    }

    public final void C0() {
        f38 f38Var;
        UserData userData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (f38Var = this.b) == null || f38Var.getItemViewType(this.h) != 0 || (userData = (UserData) this.b.getItem(this.h)) == null || userData.getUserId() == null || userData.getUserName() == null || userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            return;
        }
        TiebaStatic.eventStat(Q0().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
        sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(Q0().getPageContext().getPageActivity(), kg.g(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
    }

    public final PersonFriendActivity Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            if (baseFragmentActivity instanceof PersonFriendActivity) {
                return (PersonFriendActivity) baseFragmentActivity;
            }
            return null;
        }
        return (PersonFriendActivity) invokeV.objValue;
    }

    public void R0() {
        PersonFriendModel personFriendModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (personFriendModel = this.f) == null) {
            return;
        }
        personFriendModel.z();
    }

    public final void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f38 f38Var = this.b;
            if (f38Var != null) {
                f38Var.f(true);
                this.b.notifyDataSetChanged();
            }
            this.m = this.f.y().d().a() + 1;
            PersonFriendModel personFriendModel = this.f;
            personFriendModel.A(this.i, personFriendModel.getId(), this.m, this.n);
        }
    }

    public final void T0(gq4 gq4Var) {
        f38 f38Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, gq4Var) == null) || (f38Var = this.b) == null) {
            return;
        }
        if (gq4Var != null) {
            aq4 d2 = gq4Var.d();
            boolean z = true;
            if (this.g == 0) {
                this.b.e((d2 == null || d2.b() != 1) ? false : false);
                this.b.d(gq4Var.e());
            } else {
                if (gq4Var.b().size() < this.n) {
                    this.b.e(false);
                } else {
                    this.b.e(true);
                }
                this.b.d(gq4Var.b());
            }
            this.b.f(false);
            this.b.b();
            this.b.notifyDataSetChanged();
            return;
        }
        f38Var.e(false);
        this.b.d(new ArrayList<>());
        this.b.f(false);
        this.b.b();
        this.b.notifyDataSetChanged();
    }

    public void U0(gq4 gq4Var) {
        PersonFriendModel personFriendModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, gq4Var) == null) || gq4Var == null || (personFriendModel = this.f) == null) {
            return;
        }
        personFriendModel.y().e().addAll(gq4Var.e());
        this.f.y().b().addAll(gq4Var.b());
        this.f.y().h(gq4Var.d());
    }

    public final void V0(gq4 gq4Var) {
        PersonFriendModel personFriendModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, gq4Var) == null) || Q0() == null || (personFriendModel = this.f) == null) {
            return;
        }
        if (this.g == 0) {
            if (personFriendModel.y().e().size() == 0) {
                gq4 gq4Var2 = this.j;
                if (gq4Var2 != null && gq4Var2.e().size() > 0) {
                    this.d.setVisibility(8);
                    this.a.setVisibility(0);
                } else {
                    this.d.setVisibility(0);
                    this.a.setVisibility(0);
                }
            } else {
                this.d.setVisibility(8);
                this.a.setVisibility(0);
            }
        } else if (personFriendModel.y().b().size() == 0) {
            gq4 gq4Var3 = this.j;
            if (gq4Var3 != null && gq4Var3.b().size() > 0) {
                this.d.setVisibility(8);
                this.a.setVisibility(0);
            } else {
                this.d.setVisibility(0);
                this.a.setVisibility(0);
            }
        } else {
            this.d.setVisibility(8);
            this.a.setVisibility(0);
        }
        Q0().updateTabTitle(this.f.y().c(), this.f.y().a());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onActivityCreated(bundle);
            registerListener(this.p);
            registerListener(this.o);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            super.onChangeSkinType(i);
            if (isAdded()) {
                if (this.c != null && getBaseFragmentActivity() != null) {
                    getBaseFragmentActivity().getPageContext().getLayoutMode().j(this.c);
                }
                NoDataView noDataView = this.d;
                if (noDataView != null) {
                    SkinManager.setBackgroundResource(noDataView, R.color.CAM_X0201);
                }
                qu4 qu4Var = this.e;
                if (qu4Var != null) {
                    qu4Var.H(i);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, layoutInflater, viewGroup, bundle)) == null) {
            this.g = getArguments().getInt("page_type", 0);
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d02f0, viewGroup, false);
            this.b = new f38(Q0(), Q0().getIsHost(), this.g, new a(this), new b(this));
            BdListView bdListView = (BdListView) inflate.findViewById(R.id.obfuscated_res_0x7f0914ad);
            this.a = bdListView;
            bdListView.setOnItemClickListener(new c(this));
            this.a.setAdapter((ListAdapter) this.b);
            qu4 qu4Var = new qu4(Q0().getPageContext());
            this.e = qu4Var;
            qu4Var.e(new d(this));
            this.a.setPullRefresh(this.e);
            this.i = Q0().getIsHost();
            if (Q0() == null) {
                str = null;
            } else if (this.i) {
                str = String.format(getString(R.string.obfuscated_res_0x7f0f0e2a), getString(R.string.obfuscated_res_0x7f0f15e3));
            } else if (this.g == 0) {
                str = String.format(getString(R.string.obfuscated_res_0x7f0f0e2a), Q0().getUtype());
            } else {
                str = getString(R.string.obfuscated_res_0x7f0f0e29);
            }
            this.d = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.c(str), null);
            this.c = inflate.findViewById(R.id.obfuscated_res_0x7f090aa4);
            this.a.setOnSrollToBottomListener(new e(this));
            if (Q0() != null) {
                this.f = Q0().getModel();
                if (this.i) {
                    R0();
                }
            }
            if (this.g == Q0().getCurrentPageType()) {
                this.m = 0;
                this.a.F();
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            f38 f38Var = this.b;
            if (f38Var != null) {
                f38Var.c();
                this.b = null;
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            f38 f38Var = this.b;
            if (f38Var != null) {
                f38Var.c();
                this.b = null;
            }
            MessageManager.getInstance().unRegisterListener(this.p);
            MessageManager.getInstance().unRegisterListener(this.o);
            super.onDestroyView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onResume();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (Q0() != null) {
                this.f = Q0().getModel();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onStart();
            NoDataView noDataView = this.d;
            if (noDataView != null) {
                noDataView.d(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onStop();
            NoDataView noDataView = this.d;
            if (noDataView != null) {
                noDataView.e();
            }
        }
    }

    public void update(gq4 gq4Var, boolean z) {
        gq4 gq4Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048591, this, gq4Var, z) == null) || gq4Var == null) {
            return;
        }
        this.a.A(0L);
        if (this.f == null || Q0() == null) {
            return;
        }
        if (!z) {
            if (this.k) {
                this.k = false;
                if (this.g == Q0().getCurrentPageType()) {
                    this.f.B(gq4Var);
                }
            } else {
                if (this.g == Q0().getCurrentPageType()) {
                    U0(gq4Var);
                }
                gq4Var2 = this.f.y();
                this.j = gq4Var2;
                T0(gq4Var2);
                V0(gq4Var);
            }
        }
        gq4Var2 = gq4Var;
        this.j = gq4Var2;
        T0(gq4Var2);
        V0(gq4Var);
    }
}
