package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.k0.f;
import c.a.s0.s.q.b1;
import c.a.s0.s.q.h1;
import c.a.t0.x2.h;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes12.dex */
public class PersonFriendFragment extends BaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.x2.e f47202e;

    /* renamed from: f  reason: collision with root package name */
    public View f47203f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f47204g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.s0.s.k0.g f47205h;

    /* renamed from: i  reason: collision with root package name */
    public PersonFriendModel f47206i;

    /* renamed from: j  reason: collision with root package name */
    public int f47207j;
    public int k;
    public boolean l;
    public h1 m;
    public BdListView mListView;
    public boolean n;
    public boolean o;
    public int p;
    public int q;
    public final CustomMessageListener r;
    public HttpMessageListener s;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f47208e;

        public a(PersonFriendFragment personFriendFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personFriendFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47208e = personFriendFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47208e.k = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    this.f47208e.i();
                } else {
                    TbadkCoreApplication.getInst().login(this.f47208e.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f47208e.getBaseFragmentActivity().getPageContext().getPageActivity(), true, 11028)));
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f47209e;

        public b(PersonFriendFragment personFriendFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personFriendFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47209e = personFriendFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f47209e.o) {
                return;
            }
            PersonFriendFragment personFriendFragment = this.f47209e;
            personFriendFragment.p = personFriendFragment.f47206i.w().d().a() + 1;
            this.f47209e.o = true;
            this.f47209e.y();
        }
    }

    /* loaded from: classes12.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f47210e;

        public c(PersonFriendFragment personFriendFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personFriendFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47210e = personFriendFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            UserData userData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f47210e.f47202e == null || this.f47210e.f47202e.getItemViewType(i2) != 0 || (userData = (UserData) this.f47210e.f47202e.getItem(i2)) == null || userData.getUserId() == null) {
                return;
            }
            this.f47210e.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f47210e.x().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
        }
    }

    /* loaded from: classes12.dex */
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f47211e;

        public d(PersonFriendFragment personFriendFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personFriendFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47211e = personFriendFragment;
        }

        @Override // c.a.s0.s.k0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f47211e.x() == null) {
                return;
            }
            this.f47211e.p = 0;
            this.f47211e.n = true;
            this.f47211e.f47206i.y(this.f47211e.l, this.f47211e.x().getUid(), this.f47211e.p, this.f47211e.q);
        }
    }

    /* loaded from: classes12.dex */
    public class e implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f47212e;

        public e(PersonFriendFragment personFriendFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personFriendFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47212e = personFriendFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f47212e.o) {
                return;
            }
            this.f47212e.n = false;
            PersonFriendFragment personFriendFragment = this.f47212e;
            personFriendFragment.p = personFriendFragment.f47206i.w().d().a() + 1;
            this.f47212e.o = true;
            this.f47212e.y();
        }
    }

    /* loaded from: classes12.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonFriendFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(PersonFriendFragment personFriendFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personFriendFragment, Integer.valueOf(i2)};
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
            this.a = personFriendFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && this.a.l) {
                h1 personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (this.a.x() != null) {
                    this.a.m = personFriendData;
                    this.a.update(personFriendData, true);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class g extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonFriendFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(PersonFriendFragment personFriendFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personFriendFragment, Integer.valueOf(i2)};
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
            this.a = personFriendFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                this.a.o = false;
                if (this.a.x() == null || httpResponsedMessage.getOrginalMessage().getTag() != this.a.x().getUniqueId()) {
                    return;
                }
                this.a.mListView.completePullRefreshPostDelayed(0L);
                if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                    PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                    if (personFriendResponseMessage.getError() == 0) {
                        this.a.update(personFriendResponseMessage.getPersonFriendData(), false);
                        return;
                    } else {
                        this.a.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.a.getResources().getString(c.a.t0.z2.g.neterror) : httpResponsedMessage.getErrorString());
                        return;
                    }
                }
                this.a.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.a.getResources().getString(c.a.t0.z2.g.neterror) : httpResponsedMessage.getErrorString());
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
        c.a.t0.x3.f0.a.b(2001182, h.class);
    }

    public PersonFriendFragment() {
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
        this.mListView = null;
        this.f47202e = null;
        this.f47203f = null;
        this.f47204g = null;
        this.f47205h = null;
        this.f47206i = null;
        this.f47207j = 0;
        this.k = 0;
        this.l = true;
        this.m = null;
        this.n = true;
        this.o = false;
        this.p = 0;
        this.q = 20;
        this.r = new f(this, 2001182);
        this.s = new g(this, CmdConfigHttp.PIC_FRIEND_CMD);
    }

    public final void A(h1 h1Var) {
        PersonFriendModel personFriendModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, h1Var) == null) || x() == null || (personFriendModel = this.f47206i) == null) {
            return;
        }
        if (this.f47207j == 0) {
            if (personFriendModel.w().e().size() == 0) {
                h1 h1Var2 = this.m;
                if (h1Var2 != null && h1Var2.e().size() > 0) {
                    this.f47204g.setVisibility(8);
                    this.mListView.setVisibility(0);
                } else {
                    this.f47204g.setVisibility(0);
                    this.mListView.setVisibility(0);
                }
            } else {
                this.f47204g.setVisibility(8);
                this.mListView.setVisibility(0);
            }
        } else if (personFriendModel.w().b().size() == 0) {
            h1 h1Var3 = this.m;
            if (h1Var3 != null && h1Var3.b().size() > 0) {
                this.f47204g.setVisibility(8);
                this.mListView.setVisibility(0);
            } else {
                this.f47204g.setVisibility(0);
                this.mListView.setVisibility(0);
            }
        } else {
            this.f47204g.setVisibility(8);
            this.mListView.setVisibility(0);
        }
        x().updateTabTitle(this.f47206i.w().c(), this.f47206i.w().a());
    }

    public final void i() {
        c.a.t0.x2.e eVar;
        UserData userData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (eVar = this.f47202e) == null || eVar.getItemViewType(this.k) != 0 || (userData = (UserData) this.f47202e.getItem(this.k)) == null || userData.getUserId() == null || userData.getUserName() == null || userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            return;
        }
        TiebaStatic.eventStat(x().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
        sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(x().getPageContext().getPageActivity(), c.a.d.f.m.b.g(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
    }

    public void loadDataFromCache() {
        PersonFriendModel personFriendModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (personFriendModel = this.f47206i) == null) {
            return;
        }
        personFriendModel.x();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onActivityCreated(bundle);
            registerListener(this.s);
            registerListener(this.r);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (isAdded()) {
                if (this.f47203f != null && getBaseFragmentActivity() != null) {
                    getBaseFragmentActivity().getPageContext().getLayoutMode().j(this.f47203f);
                }
                NoDataView noDataView = this.f47204g;
                if (noDataView != null) {
                    SkinManager.setBackgroundResource(noDataView, c.a.t0.z2.a.CAM_X0201);
                }
                c.a.s0.s.k0.g gVar = this.f47205h;
                if (gVar != null) {
                    gVar.C(i2);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f47207j = getArguments().getInt("page_type", 0);
            View inflate = layoutInflater.inflate(c.a.t0.z2.e.friend_fragment, viewGroup, false);
            this.f47202e = new c.a.t0.x2.e(x(), x().getIsHost(), this.f47207j, new a(this), new b(this));
            BdListView bdListView = (BdListView) inflate.findViewById(c.a.t0.z2.d.my_friend_list);
            this.mListView = bdListView;
            bdListView.setOnItemClickListener(new c(this));
            this.mListView.setAdapter((ListAdapter) this.f47202e);
            c.a.s0.s.k0.g gVar = new c.a.s0.s.k0.g(x().getPageContext());
            this.f47205h = gVar;
            gVar.a(new d(this));
            this.mListView.setPullRefresh(this.f47205h);
            this.l = x().getIsHost();
            if (x() == null) {
                str = null;
            } else if (this.l) {
                str = String.format(getString(c.a.t0.z2.g.person_friend_no_personal_info), getString(c.a.t0.z2.g.you));
            } else if (this.f47207j == 0) {
                str = String.format(getString(c.a.t0.z2.g.person_friend_no_personal_info), x().getUtype());
            } else {
                str = getString(c.a.t0.z2.g.person_friend_no_common_info);
            }
            this.f47204g = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.c(str), null);
            this.f47203f = inflate.findViewById(c.a.t0.z2.d.friend_fragment_parent);
            this.mListView.setOnSrollToBottomListener(new e(this));
            if (x() != null) {
                this.f47206i = x().getModel();
                if (this.l) {
                    loadDataFromCache();
                }
            }
            if (this.f47207j == x().getCurrentPageType()) {
                this.p = 0;
                this.mListView.startPullRefresh();
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.t0.x2.e eVar = this.f47202e;
            if (eVar != null) {
                eVar.c();
                this.f47202e = null;
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.t0.x2.e eVar = this.f47202e;
            if (eVar != null) {
                eVar.c();
                this.f47202e = null;
            }
            MessageManager.getInstance().unRegisterListener(this.s);
            MessageManager.getInstance().unRegisterListener(this.r);
            super.onDestroyView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (x() != null) {
                this.f47206i = x().getModel();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onStart();
            NoDataView noDataView = this.f47204g;
            if (noDataView != null) {
                noDataView.onActivityStart(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onStop();
            NoDataView noDataView = this.f47204g;
            if (noDataView != null) {
                noDataView.onActivityStop();
            }
        }
    }

    public void update(h1 h1Var, boolean z) {
        h1 h1Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048587, this, h1Var, z) == null) || h1Var == null) {
            return;
        }
        this.mListView.completePullRefreshPostDelayed(0L);
        if (this.f47206i == null || x() == null) {
            return;
        }
        if (!z) {
            if (this.n) {
                this.n = false;
                if (this.f47207j == x().getCurrentPageType()) {
                    this.f47206i.z(h1Var);
                }
            } else {
                if (this.f47207j == x().getCurrentPageType()) {
                    updateModel(h1Var);
                }
                h1Var2 = this.f47206i.w();
                this.m = h1Var2;
                z(h1Var2);
                A(h1Var);
            }
        }
        h1Var2 = h1Var;
        this.m = h1Var2;
        z(h1Var2);
        A(h1Var);
    }

    public void updateModel(h1 h1Var) {
        PersonFriendModel personFriendModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, h1Var) == null) || h1Var == null || (personFriendModel = this.f47206i) == null) {
            return;
        }
        personFriendModel.w().e().addAll(h1Var.e());
        this.f47206i.w().b().addAll(h1Var.b());
        this.f47206i.w().h(h1Var.d());
    }

    public final PersonFriendActivity x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            if (baseFragmentActivity instanceof PersonFriendActivity) {
                return (PersonFriendActivity) baseFragmentActivity;
            }
            return null;
        }
        return (PersonFriendActivity) invokeV.objValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            c.a.t0.x2.e eVar = this.f47202e;
            if (eVar != null) {
                eVar.f(true);
                this.f47202e.notifyDataSetChanged();
            }
            this.p = this.f47206i.w().d().a() + 1;
            PersonFriendModel personFriendModel = this.f47206i;
            personFriendModel.y(this.l, personFriendModel.getId(), this.p, this.q);
        }
    }

    public final void z(h1 h1Var) {
        c.a.t0.x2.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, h1Var) == null) || (eVar = this.f47202e) == null) {
            return;
        }
        if (h1Var != null) {
            b1 d2 = h1Var.d();
            boolean z = true;
            if (this.f47207j == 0) {
                this.f47202e.e((d2 == null || d2.b() != 1) ? false : false);
                this.f47202e.d(h1Var.e());
            } else {
                if (h1Var.b().size() < this.q) {
                    this.f47202e.e(false);
                } else {
                    this.f47202e.e(true);
                }
                this.f47202e.d(h1Var.b());
            }
            this.f47202e.f(false);
            this.f47202e.b();
            this.f47202e.notifyDataSetChanged();
            return;
        }
        eVar.e(false);
        this.f47202e.d(new ArrayList<>());
        this.f47202e.f(false);
        this.f47202e.b();
        this.f47202e.notifyDataSetChanged();
    }
}
