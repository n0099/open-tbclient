package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.s.f0.f;
import c.a.o0.s.q.b1;
import c.a.o0.s.q.h1;
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
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class PersonFriendFragment extends BaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.m2.d f55608e;

    /* renamed from: f  reason: collision with root package name */
    public View f55609f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f55610g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.o0.s.f0.g f55611h;

    /* renamed from: i  reason: collision with root package name */
    public PersonFriendModel f55612i;

    /* renamed from: j  reason: collision with root package name */
    public int f55613j;
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

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f55614e;

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
            this.f55614e = personFriendFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f55614e.k = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    this.f55614e.g();
                } else {
                    TbadkCoreApplication.getInst().login(this.f55614e.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f55614e.getBaseFragmentActivity().getPageContext().getPageActivity(), true, 11028)));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f55615e;

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
            this.f55615e = personFriendFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f55615e.o) {
                return;
            }
            PersonFriendFragment personFriendFragment = this.f55615e;
            personFriendFragment.p = personFriendFragment.f55612i.w().d().a() + 1;
            this.f55615e.o = true;
            this.f55615e.v();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f55616e;

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
            this.f55616e = personFriendFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            UserData userData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f55616e.f55608e == null || this.f55616e.f55608e.getItemViewType(i2) != 0 || (userData = (UserData) this.f55616e.f55608e.getItem(i2)) == null || userData.getUserId() == null) {
                return;
            }
            this.f55616e.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f55616e.u().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
        }
    }

    /* loaded from: classes7.dex */
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f55617e;

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
            this.f55617e = personFriendFragment;
        }

        @Override // c.a.o0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f55617e.u() == null) {
                return;
            }
            this.f55617e.p = 0;
            this.f55617e.n = true;
            this.f55617e.f55612i.y(this.f55617e.l, this.f55617e.u().getUid(), this.f55617e.p, this.f55617e.q);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f55618e;

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
            this.f55618e = personFriendFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f55618e.o) {
                return;
            }
            this.f55618e.n = false;
            PersonFriendFragment personFriendFragment = this.f55618e;
            personFriendFragment.p = personFriendFragment.f55612i.w().d().a() + 1;
            this.f55618e.o = true;
            this.f55618e.v();
        }
    }

    /* loaded from: classes7.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f55619a;

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
            this.f55619a = personFriendFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && this.f55619a.l) {
                h1 personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (this.f55619a.u() != null) {
                    this.f55619a.m = personFriendData;
                    this.f55619a.update(personFriendData, true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f55620a;

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
            this.f55620a = personFriendFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                this.f55620a.o = false;
                if (this.f55620a.u() == null || httpResponsedMessage.getOrginalMessage().getTag() != this.f55620a.u().getUniqueId()) {
                    return;
                }
                this.f55620a.mListView.completePullRefreshPostDelayed(0L);
                if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                    PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                    if (personFriendResponseMessage.getError() == 0) {
                        this.f55620a.update(personFriendResponseMessage.getPersonFriendData(), false);
                        return;
                    } else {
                        this.f55620a.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.f55620a.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        return;
                    }
                }
                this.f55620a.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.f55620a.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
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
        c.a.p0.i3.d0.a.b(2001182, c.a.p0.m2.g.class);
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
        this.f55608e = null;
        this.f55609f = null;
        this.f55610g = null;
        this.f55611h = null;
        this.f55612i = null;
        this.f55613j = 0;
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

    public final void g() {
        c.a.p0.m2.d dVar;
        UserData userData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.f55608e) == null || dVar.getItemViewType(this.k) != 0 || (userData = (UserData) this.f55608e.getItem(this.k)) == null || userData.getUserId() == null || userData.getUserName() == null || userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            return;
        }
        TiebaStatic.eventStat(u().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
        sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(u().getPageContext().getPageActivity(), c.a.e.e.m.b.f(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
    }

    public void loadDataFromCache() {
        PersonFriendModel personFriendModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (personFriendModel = this.f55612i) == null) {
            return;
        }
        personFriendModel.x();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onActivityCreated(bundle);
            registerListener(this.s);
            registerListener(this.r);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (isAdded()) {
                if (this.f55609f != null && getBaseFragmentActivity() != null) {
                    getBaseFragmentActivity().getPageContext().getLayoutMode().j(this.f55609f);
                }
                NoDataView noDataView = this.f55610g;
                if (noDataView != null) {
                    SkinManager.setBackgroundResource(noDataView, R.color.CAM_X0201);
                }
                c.a.o0.s.f0.g gVar = this.f55611h;
                if (gVar != null) {
                    gVar.D(i2);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f55613j = getArguments().getInt("page_type", 0);
            View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
            this.f55608e = new c.a.p0.m2.d(u(), u().getIsHost(), this.f55613j, new a(this), new b(this));
            BdListView bdListView = (BdListView) inflate.findViewById(R.id.my_friend_list);
            this.mListView = bdListView;
            bdListView.setOnItemClickListener(new c(this));
            this.mListView.setAdapter((ListAdapter) this.f55608e);
            c.a.o0.s.f0.g gVar = new c.a.o0.s.f0.g(u().getPageContext());
            this.f55611h = gVar;
            gVar.a(new d(this));
            this.mListView.setPullRefresh(this.f55611h);
            this.l = u().getIsHost();
            if (u() == null) {
                str = null;
            } else if (this.l) {
                str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
            } else if (this.f55613j == 0) {
                str = String.format(getString(R.string.person_friend_no_personal_info), u().getUtype());
            } else {
                str = getString(R.string.person_friend_no_common_info);
            }
            this.f55610g = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.c(str), null);
            this.f55609f = inflate.findViewById(R.id.friend_fragment_parent);
            this.mListView.setOnSrollToBottomListener(new e(this));
            if (u() != null) {
                this.f55612i = u().getModel();
                if (this.l) {
                    loadDataFromCache();
                }
            }
            if (this.f55613j == u().getCurrentPageType()) {
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
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.p0.m2.d dVar = this.f55608e;
            if (dVar != null) {
                dVar.c();
                this.f55608e = null;
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.p0.m2.d dVar = this.f55608e;
            if (dVar != null) {
                dVar.c();
                this.f55608e = null;
            }
            MessageManager.getInstance().unRegisterListener(this.s);
            MessageManager.getInstance().unRegisterListener(this.r);
            super.onDestroyView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (u() != null) {
                this.f55612i = u().getModel();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onStart();
            NoDataView noDataView = this.f55610g;
            if (noDataView != null) {
                noDataView.onActivityStart(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onStop();
            NoDataView noDataView = this.f55610g;
            if (noDataView != null) {
                noDataView.onActivityStop();
            }
        }
    }

    public final PersonFriendActivity u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            if (baseFragmentActivity instanceof PersonFriendActivity) {
                return (PersonFriendActivity) baseFragmentActivity;
            }
            return null;
        }
        return (PersonFriendActivity) invokeV.objValue;
    }

    public void update(h1 h1Var, boolean z) {
        h1 h1Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048587, this, h1Var, z) == null) || h1Var == null) {
            return;
        }
        this.mListView.completePullRefreshPostDelayed(0L);
        if (this.f55612i == null || u() == null) {
            return;
        }
        if (!z) {
            if (this.n) {
                this.n = false;
                if (this.f55613j == u().getCurrentPageType()) {
                    this.f55612i.z(h1Var);
                }
            } else {
                if (this.f55613j == u().getCurrentPageType()) {
                    updateModel(h1Var);
                }
                h1Var2 = this.f55612i.w();
                this.m = h1Var2;
                w(h1Var2);
                x(h1Var);
            }
        }
        h1Var2 = h1Var;
        this.m = h1Var2;
        w(h1Var2);
        x(h1Var);
    }

    public void updateModel(h1 h1Var) {
        PersonFriendModel personFriendModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, h1Var) == null) || h1Var == null || (personFriendModel = this.f55612i) == null) {
            return;
        }
        personFriendModel.w().e().addAll(h1Var.e());
        this.f55612i.w().b().addAll(h1Var.b());
        this.f55612i.w().h(h1Var.d());
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.p0.m2.d dVar = this.f55608e;
            if (dVar != null) {
                dVar.f(true);
                this.f55608e.notifyDataSetChanged();
            }
            this.p = this.f55612i.w().d().a() + 1;
            PersonFriendModel personFriendModel = this.f55612i;
            personFriendModel.y(this.l, personFriendModel.getId(), this.p, this.q);
        }
    }

    public final void w(h1 h1Var) {
        c.a.p0.m2.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, h1Var) == null) || (dVar = this.f55608e) == null) {
            return;
        }
        if (h1Var != null) {
            b1 d2 = h1Var.d();
            boolean z = true;
            if (this.f55613j == 0) {
                this.f55608e.e((d2 == null || d2.b() != 1) ? false : false);
                this.f55608e.d(h1Var.e());
            } else {
                if (h1Var.b().size() < this.q) {
                    this.f55608e.e(false);
                } else {
                    this.f55608e.e(true);
                }
                this.f55608e.d(h1Var.b());
            }
            this.f55608e.f(false);
            this.f55608e.b();
            this.f55608e.notifyDataSetChanged();
            return;
        }
        dVar.e(false);
        this.f55608e.d(new ArrayList<>());
        this.f55608e.f(false);
        this.f55608e.b();
        this.f55608e.notifyDataSetChanged();
    }

    public final void x(h1 h1Var) {
        PersonFriendModel personFriendModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, h1Var) == null) || u() == null || (personFriendModel = this.f55612i) == null) {
            return;
        }
        if (this.f55613j == 0) {
            if (personFriendModel.w().e().size() == 0) {
                h1 h1Var2 = this.m;
                if (h1Var2 != null && h1Var2.e().size() > 0) {
                    this.f55610g.setVisibility(8);
                    this.mListView.setVisibility(0);
                } else {
                    this.f55610g.setVisibility(0);
                    this.mListView.setVisibility(0);
                }
            } else {
                this.f55610g.setVisibility(8);
                this.mListView.setVisibility(0);
            }
        } else if (personFriendModel.w().b().size() == 0) {
            h1 h1Var3 = this.m;
            if (h1Var3 != null && h1Var3.b().size() > 0) {
                this.f55610g.setVisibility(8);
                this.mListView.setVisibility(0);
            } else {
                this.f55610g.setVisibility(0);
                this.mListView.setVisibility(0);
            }
        } else {
            this.f55610g.setVisibility(8);
            this.mListView.setVisibility(0);
        }
        u().updateTabTitle(this.f55612i.w().c(), this.f55612i.w().a());
    }
}
