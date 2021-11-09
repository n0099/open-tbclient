package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.g0.f;
import b.a.q0.s.q.b1;
import b.a.q0.s.q.h1;
import b.a.r0.o2.h;
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
/* loaded from: classes9.dex */
public class PersonFriendFragment extends BaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.o2.e f53126e;

    /* renamed from: f  reason: collision with root package name */
    public View f53127f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f53128g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.q0.s.g0.g f53129h;

    /* renamed from: i  reason: collision with root package name */
    public PersonFriendModel f53130i;
    public int j;
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

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f53131e;

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
            this.f53131e = personFriendFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f53131e.k = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    this.f53131e.g();
                } else {
                    TbadkCoreApplication.getInst().login(this.f53131e.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f53131e.getBaseFragmentActivity().getPageContext().getPageActivity(), true, 11028)));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f53132e;

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
            this.f53132e = personFriendFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f53132e.o) {
                return;
            }
            PersonFriendFragment personFriendFragment = this.f53132e;
            personFriendFragment.p = personFriendFragment.f53130i.w().d().a() + 1;
            this.f53132e.o = true;
            this.f53132e.v();
        }
    }

    /* loaded from: classes9.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f53133e;

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
            this.f53133e = personFriendFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            UserData userData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f53133e.f53126e == null || this.f53133e.f53126e.getItemViewType(i2) != 0 || (userData = (UserData) this.f53133e.f53126e.getItem(i2)) == null || userData.getUserId() == null) {
                return;
            }
            this.f53133e.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f53133e.u().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
        }
    }

    /* loaded from: classes9.dex */
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f53134e;

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
            this.f53134e = personFriendFragment;
        }

        @Override // b.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f53134e.u() == null) {
                return;
            }
            this.f53134e.p = 0;
            this.f53134e.n = true;
            this.f53134e.f53130i.y(this.f53134e.l, this.f53134e.u().getUid(), this.f53134e.p, this.f53134e.q);
        }
    }

    /* loaded from: classes9.dex */
    public class e implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f53135e;

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
            this.f53135e = personFriendFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f53135e.o) {
                return;
            }
            this.f53135e.n = false;
            PersonFriendFragment personFriendFragment = this.f53135e;
            personFriendFragment.p = personFriendFragment.f53130i.w().d().a() + 1;
            this.f53135e.o = true;
            this.f53135e.v();
        }
    }

    /* loaded from: classes9.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f53136a;

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
            this.f53136a = personFriendFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && this.f53136a.l) {
                h1 personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (this.f53136a.u() != null) {
                    this.f53136a.m = personFriendData;
                    this.f53136a.update(personFriendData, true);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f53137a;

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
            this.f53137a = personFriendFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                this.f53137a.o = false;
                if (this.f53137a.u() == null || httpResponsedMessage.getOrginalMessage().getTag() != this.f53137a.u().getUniqueId()) {
                    return;
                }
                this.f53137a.mListView.completePullRefreshPostDelayed(0L);
                if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                    PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                    if (personFriendResponseMessage.getError() == 0) {
                        this.f53137a.update(personFriendResponseMessage.getPersonFriendData(), false);
                        return;
                    } else {
                        this.f53137a.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.f53137a.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        return;
                    }
                }
                this.f53137a.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.f53137a.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
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
        b.a.r0.l3.f0.a.b(2001182, h.class);
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
        this.f53126e = null;
        this.f53127f = null;
        this.f53128g = null;
        this.f53129h = null;
        this.f53130i = null;
        this.j = 0;
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
        b.a.r0.o2.e eVar;
        UserData userData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (eVar = this.f53126e) == null || eVar.getItemViewType(this.k) != 0 || (userData = (UserData) this.f53126e.getItem(this.k)) == null || userData.getUserId() == null || userData.getUserName() == null || userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            return;
        }
        TiebaStatic.eventStat(u().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
        sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(u().getPageContext().getPageActivity(), b.a.e.e.m.b.g(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
    }

    public void loadDataFromCache() {
        PersonFriendModel personFriendModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (personFriendModel = this.f53130i) == null) {
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
                if (this.f53127f != null && getBaseFragmentActivity() != null) {
                    getBaseFragmentActivity().getPageContext().getLayoutMode().j(this.f53127f);
                }
                NoDataView noDataView = this.f53128g;
                if (noDataView != null) {
                    SkinManager.setBackgroundResource(noDataView, R.color.CAM_X0201);
                }
                b.a.q0.s.g0.g gVar = this.f53129h;
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) {
            this.j = getArguments().getInt("page_type", 0);
            View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
            this.f53126e = new b.a.r0.o2.e(u(), u().getIsHost(), this.j, new a(this), new b(this));
            BdListView bdListView = (BdListView) inflate.findViewById(R.id.my_friend_list);
            this.mListView = bdListView;
            bdListView.setOnItemClickListener(new c(this));
            this.mListView.setAdapter((ListAdapter) this.f53126e);
            b.a.q0.s.g0.g gVar = new b.a.q0.s.g0.g(u().getPageContext());
            this.f53129h = gVar;
            gVar.a(new d(this));
            this.mListView.setPullRefresh(this.f53129h);
            this.l = u().getIsHost();
            if (u() == null) {
                str = null;
            } else if (this.l) {
                str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
            } else if (this.j == 0) {
                str = String.format(getString(R.string.person_friend_no_personal_info), u().getUtype());
            } else {
                str = getString(R.string.person_friend_no_common_info);
            }
            this.f53128g = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.c(str), null);
            this.f53127f = inflate.findViewById(R.id.friend_fragment_parent);
            this.mListView.setOnSrollToBottomListener(new e(this));
            if (u() != null) {
                this.f53130i = u().getModel();
                if (this.l) {
                    loadDataFromCache();
                }
            }
            if (this.j == u().getCurrentPageType()) {
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
            b.a.r0.o2.e eVar = this.f53126e;
            if (eVar != null) {
                eVar.c();
                this.f53126e = null;
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b.a.r0.o2.e eVar = this.f53126e;
            if (eVar != null) {
                eVar.c();
                this.f53126e = null;
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
                this.f53130i = u().getModel();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onStart();
            NoDataView noDataView = this.f53128g;
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
            NoDataView noDataView = this.f53128g;
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
        if (this.f53130i == null || u() == null) {
            return;
        }
        if (!z) {
            if (this.n) {
                this.n = false;
                if (this.j == u().getCurrentPageType()) {
                    this.f53130i.z(h1Var);
                }
            } else {
                if (this.j == u().getCurrentPageType()) {
                    updateModel(h1Var);
                }
                h1Var2 = this.f53130i.w();
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
        if (!(interceptable == null || interceptable.invokeL(1048588, this, h1Var) == null) || h1Var == null || (personFriendModel = this.f53130i) == null) {
            return;
        }
        personFriendModel.w().e().addAll(h1Var.e());
        this.f53130i.w().b().addAll(h1Var.b());
        this.f53130i.w().h(h1Var.d());
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            b.a.r0.o2.e eVar = this.f53126e;
            if (eVar != null) {
                eVar.f(true);
                this.f53126e.notifyDataSetChanged();
            }
            this.p = this.f53130i.w().d().a() + 1;
            PersonFriendModel personFriendModel = this.f53130i;
            personFriendModel.y(this.l, personFriendModel.getId(), this.p, this.q);
        }
    }

    public final void w(h1 h1Var) {
        b.a.r0.o2.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, h1Var) == null) || (eVar = this.f53126e) == null) {
            return;
        }
        if (h1Var != null) {
            b1 d2 = h1Var.d();
            boolean z = true;
            if (this.j == 0) {
                this.f53126e.e((d2 == null || d2.b() != 1) ? false : false);
                this.f53126e.d(h1Var.e());
            } else {
                if (h1Var.b().size() < this.q) {
                    this.f53126e.e(false);
                } else {
                    this.f53126e.e(true);
                }
                this.f53126e.d(h1Var.b());
            }
            this.f53126e.f(false);
            this.f53126e.b();
            this.f53126e.notifyDataSetChanged();
            return;
        }
        eVar.e(false);
        this.f53126e.d(new ArrayList<>());
        this.f53126e.f(false);
        this.f53126e.b();
        this.f53126e.notifyDataSetChanged();
    }

    public final void x(h1 h1Var) {
        PersonFriendModel personFriendModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, h1Var) == null) || u() == null || (personFriendModel = this.f53130i) == null) {
            return;
        }
        if (this.j == 0) {
            if (personFriendModel.w().e().size() == 0) {
                h1 h1Var2 = this.m;
                if (h1Var2 != null && h1Var2.e().size() > 0) {
                    this.f53128g.setVisibility(8);
                    this.mListView.setVisibility(0);
                } else {
                    this.f53128g.setVisibility(0);
                    this.mListView.setVisibility(0);
                }
            } else {
                this.f53128g.setVisibility(8);
                this.mListView.setVisibility(0);
            }
        } else if (personFriendModel.w().b().size() == 0) {
            h1 h1Var3 = this.m;
            if (h1Var3 != null && h1Var3.b().size() > 0) {
                this.f53128g.setVisibility(8);
                this.mListView.setVisibility(0);
            } else {
                this.f53128g.setVisibility(0);
                this.mListView.setVisibility(0);
            }
        } else {
            this.f53128g.setVisibility(8);
            this.mListView.setVisibility(0);
        }
        u().updateTabTitle(this.f53130i.w().c(), this.f53130i.w().a());
    }
}
