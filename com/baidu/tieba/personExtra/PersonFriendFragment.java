package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.r.l0.f;
import c.a.q0.r.r.b1;
import c.a.q0.r.r.h1;
import c.a.r0.y2.h;
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
/* loaded from: classes6.dex */
public class PersonFriendFragment extends BaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.y2.e f45752e;

    /* renamed from: f  reason: collision with root package name */
    public View f45753f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f45754g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.r.l0.g f45755h;

    /* renamed from: i  reason: collision with root package name */
    public PersonFriendModel f45756i;

    /* renamed from: j  reason: collision with root package name */
    public int f45757j;
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

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f45758e;

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
            this.f45758e = personFriendFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f45758e.k = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    this.f45758e.i();
                } else {
                    TbadkCoreApplication.getInst().login(this.f45758e.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f45758e.getBaseFragmentActivity().getPageContext().getPageActivity(), true, 11028)));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f45759e;

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
            this.f45759e = personFriendFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f45759e.o) {
                return;
            }
            PersonFriendFragment personFriendFragment = this.f45759e;
            personFriendFragment.p = personFriendFragment.f45756i.w().d().a() + 1;
            this.f45759e.o = true;
            this.f45759e.y();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f45760e;

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
            this.f45760e = personFriendFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            UserData userData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f45760e.f45752e == null || this.f45760e.f45752e.getItemViewType(i2) != 0 || (userData = (UserData) this.f45760e.f45752e.getItem(i2)) == null || userData.getUserId() == null) {
                return;
            }
            this.f45760e.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f45760e.x().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
        }
    }

    /* loaded from: classes6.dex */
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f45761e;

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
            this.f45761e = personFriendFragment;
        }

        @Override // c.a.q0.r.l0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f45761e.x() == null) {
                return;
            }
            this.f45761e.p = 0;
            this.f45761e.n = true;
            this.f45761e.f45756i.y(this.f45761e.l, this.f45761e.x().getUid(), this.f45761e.p, this.f45761e.q);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f45762e;

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
            this.f45762e = personFriendFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f45762e.o) {
                return;
            }
            this.f45762e.n = false;
            PersonFriendFragment personFriendFragment = this.f45762e;
            personFriendFragment.p = personFriendFragment.f45756i.w().d().a() + 1;
            this.f45762e.o = true;
            this.f45762e.y();
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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
                        this.a.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.a.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        return;
                    }
                }
                this.a.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.a.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
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
        c.a.r0.y3.g0.a.b(2001182, h.class);
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
        this.f45752e = null;
        this.f45753f = null;
        this.f45754g = null;
        this.f45755h = null;
        this.f45756i = null;
        this.f45757j = 0;
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
        if (!(interceptable == null || interceptable.invokeL(1048576, this, h1Var) == null) || x() == null || (personFriendModel = this.f45756i) == null) {
            return;
        }
        if (this.f45757j == 0) {
            if (personFriendModel.w().e().size() == 0) {
                h1 h1Var2 = this.m;
                if (h1Var2 != null && h1Var2.e().size() > 0) {
                    this.f45754g.setVisibility(8);
                    this.mListView.setVisibility(0);
                } else {
                    this.f45754g.setVisibility(0);
                    this.mListView.setVisibility(0);
                }
            } else {
                this.f45754g.setVisibility(8);
                this.mListView.setVisibility(0);
            }
        } else if (personFriendModel.w().b().size() == 0) {
            h1 h1Var3 = this.m;
            if (h1Var3 != null && h1Var3.b().size() > 0) {
                this.f45754g.setVisibility(8);
                this.mListView.setVisibility(0);
            } else {
                this.f45754g.setVisibility(0);
                this.mListView.setVisibility(0);
            }
        } else {
            this.f45754g.setVisibility(8);
            this.mListView.setVisibility(0);
        }
        x().updateTabTitle(this.f45756i.w().c(), this.f45756i.w().a());
    }

    public final void i() {
        c.a.r0.y2.e eVar;
        UserData userData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (eVar = this.f45752e) == null || eVar.getItemViewType(this.k) != 0 || (userData = (UserData) this.f45752e.getItem(this.k)) == null || userData.getUserId() == null || userData.getUserName() == null || userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            return;
        }
        TiebaStatic.eventStat(x().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
        sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(x().getPageContext().getPageActivity(), c.a.d.f.m.b.g(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
    }

    public void loadDataFromCache() {
        PersonFriendModel personFriendModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (personFriendModel = this.f45756i) == null) {
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
                if (this.f45753f != null && getBaseFragmentActivity() != null) {
                    getBaseFragmentActivity().getPageContext().getLayoutMode().j(this.f45753f);
                }
                NoDataView noDataView = this.f45754g;
                if (noDataView != null) {
                    SkinManager.setBackgroundResource(noDataView, R.color.CAM_X0201);
                }
                c.a.q0.r.l0.g gVar = this.f45755h;
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
            this.f45757j = getArguments().getInt("page_type", 0);
            View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
            this.f45752e = new c.a.r0.y2.e(x(), x().getIsHost(), this.f45757j, new a(this), new b(this));
            BdListView bdListView = (BdListView) inflate.findViewById(R.id.my_friend_list);
            this.mListView = bdListView;
            bdListView.setOnItemClickListener(new c(this));
            this.mListView.setAdapter((ListAdapter) this.f45752e);
            c.a.q0.r.l0.g gVar = new c.a.q0.r.l0.g(x().getPageContext());
            this.f45755h = gVar;
            gVar.a(new d(this));
            this.mListView.setPullRefresh(this.f45755h);
            this.l = x().getIsHost();
            if (x() == null) {
                str = null;
            } else if (this.l) {
                str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
            } else if (this.f45757j == 0) {
                str = String.format(getString(R.string.person_friend_no_personal_info), x().getUtype());
            } else {
                str = getString(R.string.person_friend_no_common_info);
            }
            this.f45754g = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.c(str), null);
            this.f45753f = inflate.findViewById(R.id.friend_fragment_parent);
            this.mListView.setOnSrollToBottomListener(new e(this));
            if (x() != null) {
                this.f45756i = x().getModel();
                if (this.l) {
                    loadDataFromCache();
                }
            }
            if (this.f45757j == x().getCurrentPageType()) {
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
            c.a.r0.y2.e eVar = this.f45752e;
            if (eVar != null) {
                eVar.c();
                this.f45752e = null;
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.r0.y2.e eVar = this.f45752e;
            if (eVar != null) {
                eVar.c();
                this.f45752e = null;
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
                this.f45756i = x().getModel();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onStart();
            NoDataView noDataView = this.f45754g;
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
            NoDataView noDataView = this.f45754g;
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
        if (this.f45756i == null || x() == null) {
            return;
        }
        if (!z) {
            if (this.n) {
                this.n = false;
                if (this.f45757j == x().getCurrentPageType()) {
                    this.f45756i.z(h1Var);
                }
            } else {
                if (this.f45757j == x().getCurrentPageType()) {
                    updateModel(h1Var);
                }
                h1Var2 = this.f45756i.w();
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
        if (!(interceptable == null || interceptable.invokeL(1048588, this, h1Var) == null) || h1Var == null || (personFriendModel = this.f45756i) == null) {
            return;
        }
        personFriendModel.w().e().addAll(h1Var.e());
        this.f45756i.w().b().addAll(h1Var.b());
        this.f45756i.w().h(h1Var.d());
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
            c.a.r0.y2.e eVar = this.f45752e;
            if (eVar != null) {
                eVar.f(true);
                this.f45752e.notifyDataSetChanged();
            }
            this.p = this.f45756i.w().d().a() + 1;
            PersonFriendModel personFriendModel = this.f45756i;
            personFriendModel.y(this.l, personFriendModel.getId(), this.p, this.q);
        }
    }

    public final void z(h1 h1Var) {
        c.a.r0.y2.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, h1Var) == null) || (eVar = this.f45752e) == null) {
            return;
        }
        if (h1Var != null) {
            b1 d2 = h1Var.d();
            boolean z = true;
            if (this.f45757j == 0) {
                this.f45752e.e((d2 == null || d2.b() != 1) ? false : false);
                this.f45752e.d(h1Var.e());
            } else {
                if (h1Var.b().size() < this.q) {
                    this.f45752e.e(false);
                } else {
                    this.f45752e.e(true);
                }
                this.f45752e.d(h1Var.b());
            }
            this.f45752e.f(false);
            this.f45752e.b();
            this.f45752e.notifyDataSetChanged();
            return;
        }
        eVar.e(false);
        this.f45752e.d(new ArrayList<>());
        this.f45752e.f(false);
        this.f45752e.b();
        this.f45752e.notifyDataSetChanged();
    }
}
