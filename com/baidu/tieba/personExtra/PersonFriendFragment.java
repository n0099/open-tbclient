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
import d.a.o0.r.f0.f;
import d.a.o0.r.q.a1;
import d.a.o0.r.q.g1;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class PersonFriendFragment extends BaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f20130e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.p0.l2.d f20131f;

    /* renamed from: g  reason: collision with root package name */
    public View f20132g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f20133h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.o0.r.f0.g f20134i;
    public PersonFriendModel j;
    public int k;
    public int l;
    public boolean m;
    public g1 n;
    public boolean o;
    public boolean p;
    public int q;
    public int r;
    public final CustomMessageListener s;
    public HttpMessageListener t;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f20135e;

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
            this.f20135e = personFriendFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20135e.l = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    this.f20135e.H0();
                } else {
                    TbadkCoreApplication.getInst().login(this.f20135e.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f20135e.getBaseFragmentActivity().getPageContext().getPageActivity(), true, 11028)));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f20136e;

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
            this.f20136e = personFriendFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f20136e.p) {
                return;
            }
            PersonFriendFragment personFriendFragment = this.f20136e;
            personFriendFragment.q = personFriendFragment.j.w().d().a() + 1;
            this.f20136e.p = true;
            this.f20136e.X0();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f20137e;

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
            this.f20137e = personFriendFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            UserData userData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f20137e.f20131f == null || this.f20137e.f20131f.getItemViewType(i2) != 0 || (userData = (UserData) this.f20137e.f20131f.getItem(i2)) == null || userData.getUserId() == null) {
                return;
            }
            this.f20137e.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f20137e.V0().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f20138e;

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
            this.f20138e = personFriendFragment;
        }

        @Override // d.a.o0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f20138e.V0() == null) {
                return;
            }
            this.f20138e.q = 0;
            this.f20138e.o = true;
            this.f20138e.j.y(this.f20138e.m, this.f20138e.V0().getUid(), this.f20138e.q, this.f20138e.r);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f20139e;

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
            this.f20139e = personFriendFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f20139e.p) {
                return;
            }
            this.f20139e.o = false;
            PersonFriendFragment personFriendFragment = this.f20139e;
            personFriendFragment.q = personFriendFragment.j.w().d().a() + 1;
            this.f20139e.p = true;
            this.f20139e.X0();
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f20140a;

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
            this.f20140a = personFriendFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && this.f20140a.m) {
                g1 personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (this.f20140a.V0() != null) {
                    this.f20140a.n = personFriendData;
                    this.f20140a.Y0(personFriendData, true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f20141a;

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
            this.f20141a = personFriendFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                this.f20141a.p = false;
                if (this.f20141a.V0() == null || httpResponsedMessage.getOrginalMessage().getTag() != this.f20141a.V0().getUniqueId()) {
                    return;
                }
                this.f20141a.f20130e.A(0L);
                if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                    PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                    if (personFriendResponseMessage.getError() == 0) {
                        this.f20141a.Y0(personFriendResponseMessage.getPersonFriendData(), false);
                        return;
                    } else {
                        this.f20141a.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.f20141a.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        return;
                    }
                }
                this.f20141a.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.f20141a.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
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
        d.a.p0.h3.d0.a.b(2001182, d.a.p0.l2.g.class);
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
        this.f20130e = null;
        this.f20131f = null;
        this.f20132g = null;
        this.f20133h = null;
        this.f20134i = null;
        this.j = null;
        this.k = 0;
        this.l = 0;
        this.m = true;
        this.n = null;
        this.o = true;
        this.p = false;
        this.q = 0;
        this.r = 20;
        this.s = new f(this, 2001182);
        this.t = new g(this, CmdConfigHttp.PIC_FRIEND_CMD);
    }

    public final void H0() {
        d.a.p0.l2.d dVar;
        UserData userData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.f20131f) == null || dVar.getItemViewType(this.l) != 0 || (userData = (UserData) this.f20131f.getItem(this.l)) == null || userData.getUserId() == null || userData.getUserName() == null || userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            return;
        }
        TiebaStatic.eventStat(V0().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
        sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(V0().getPageContext().getPageActivity(), d.a.c.e.m.b.f(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
    }

    public final PersonFriendActivity V0() {
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

    public void W0() {
        PersonFriendModel personFriendModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (personFriendModel = this.j) == null) {
            return;
        }
        personFriendModel.x();
    }

    public final void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d.a.p0.l2.d dVar = this.f20131f;
            if (dVar != null) {
                dVar.f(true);
                this.f20131f.notifyDataSetChanged();
            }
            this.q = this.j.w().d().a() + 1;
            PersonFriendModel personFriendModel = this.j;
            personFriendModel.y(this.m, personFriendModel.getId(), this.q, this.r);
        }
    }

    public void Y0(g1 g1Var, boolean z) {
        g1 g1Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048580, this, g1Var, z) == null) || g1Var == null) {
            return;
        }
        this.f20130e.A(0L);
        if (this.j == null || V0() == null) {
            return;
        }
        if (!z) {
            if (this.o) {
                this.o = false;
                if (this.k == V0().getCurrentPageType()) {
                    this.j.z(g1Var);
                }
            } else {
                if (this.k == V0().getCurrentPageType()) {
                    a1(g1Var);
                }
                g1Var2 = this.j.w();
                this.n = g1Var2;
                Z0(g1Var2);
                b1(g1Var);
            }
        }
        g1Var2 = g1Var;
        this.n = g1Var2;
        Z0(g1Var2);
        b1(g1Var);
    }

    public final void Z0(g1 g1Var) {
        d.a.p0.l2.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, g1Var) == null) || (dVar = this.f20131f) == null) {
            return;
        }
        if (g1Var != null) {
            a1 d2 = g1Var.d();
            boolean z = true;
            if (this.k == 0) {
                this.f20131f.e((d2 == null || d2.b() != 1) ? false : false);
                this.f20131f.d(g1Var.e());
            } else {
                if (g1Var.b().size() < this.r) {
                    this.f20131f.e(false);
                } else {
                    this.f20131f.e(true);
                }
                this.f20131f.d(g1Var.b());
            }
            this.f20131f.f(false);
            this.f20131f.b();
            this.f20131f.notifyDataSetChanged();
            return;
        }
        dVar.e(false);
        this.f20131f.d(new ArrayList<>());
        this.f20131f.f(false);
        this.f20131f.b();
        this.f20131f.notifyDataSetChanged();
    }

    public void a1(g1 g1Var) {
        PersonFriendModel personFriendModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, g1Var) == null) || g1Var == null || (personFriendModel = this.j) == null) {
            return;
        }
        personFriendModel.w().e().addAll(g1Var.e());
        this.j.w().b().addAll(g1Var.b());
        this.j.w().h(g1Var.d());
    }

    public final void b1(g1 g1Var) {
        PersonFriendModel personFriendModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, g1Var) == null) || V0() == null || (personFriendModel = this.j) == null) {
            return;
        }
        if (this.k == 0) {
            if (personFriendModel.w().e().size() == 0) {
                g1 g1Var2 = this.n;
                if (g1Var2 != null && g1Var2.e().size() > 0) {
                    this.f20133h.setVisibility(8);
                    this.f20130e.setVisibility(0);
                } else {
                    this.f20133h.setVisibility(0);
                    this.f20130e.setVisibility(0);
                }
            } else {
                this.f20133h.setVisibility(8);
                this.f20130e.setVisibility(0);
            }
        } else if (personFriendModel.w().b().size() == 0) {
            g1 g1Var3 = this.n;
            if (g1Var3 != null && g1Var3.b().size() > 0) {
                this.f20133h.setVisibility(8);
                this.f20130e.setVisibility(0);
            } else {
                this.f20133h.setVisibility(0);
                this.f20130e.setVisibility(0);
            }
        } else {
            this.f20133h.setVisibility(8);
            this.f20130e.setVisibility(0);
        }
        V0().updateTabTitle(this.j.w().c(), this.j.w().a());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onActivityCreated(bundle);
            registerListener(this.t);
            registerListener(this.s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (isAdded()) {
                if (this.f20132g != null && getBaseFragmentActivity() != null) {
                    getBaseFragmentActivity().getPageContext().getLayoutMode().j(this.f20132g);
                }
                NoDataView noDataView = this.f20133h;
                if (noDataView != null) {
                    SkinManager.setBackgroundResource(noDataView, R.color.CAM_X0201);
                }
                d.a.o0.r.f0.g gVar = this.f20134i;
                if (gVar != null) {
                    gVar.I(i2);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, layoutInflater, viewGroup, bundle)) == null) {
            this.k = getArguments().getInt("page_type", 0);
            View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
            this.f20131f = new d.a.p0.l2.d(V0(), V0().getIsHost(), this.k, new a(this), new b(this));
            BdListView bdListView = (BdListView) inflate.findViewById(R.id.my_friend_list);
            this.f20130e = bdListView;
            bdListView.setOnItemClickListener(new c(this));
            this.f20130e.setAdapter((ListAdapter) this.f20131f);
            d.a.o0.r.f0.g gVar = new d.a.o0.r.f0.g(V0().getPageContext());
            this.f20134i = gVar;
            gVar.a(new d(this));
            this.f20130e.setPullRefresh(this.f20134i);
            this.m = V0().getIsHost();
            if (V0() == null) {
                str = null;
            } else if (this.m) {
                str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
            } else if (this.k == 0) {
                str = String.format(getString(R.string.person_friend_no_personal_info), V0().getUtype());
            } else {
                str = getString(R.string.person_friend_no_common_info);
            }
            this.f20133h = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.c(str), null);
            this.f20132g = inflate.findViewById(R.id.friend_fragment_parent);
            this.f20130e.setOnSrollToBottomListener(new e(this));
            if (V0() != null) {
                this.j = V0().getModel();
                if (this.m) {
                    W0();
                }
            }
            if (this.k == V0().getCurrentPageType()) {
                this.q = 0;
                this.f20130e.F();
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            d.a.p0.l2.d dVar = this.f20131f;
            if (dVar != null) {
                dVar.c();
                this.f20131f = null;
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            d.a.p0.l2.d dVar = this.f20131f;
            if (dVar != null) {
                dVar.c();
                this.f20131f = null;
            }
            MessageManager.getInstance().unRegisterListener(this.t);
            MessageManager.getInstance().unRegisterListener(this.s);
            super.onDestroyView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onResume();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (V0() != null) {
                this.j = V0().getModel();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onStart();
            NoDataView noDataView = this.f20133h;
            if (noDataView != null) {
                noDataView.d(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onStop();
            NoDataView noDataView = this.f20133h;
            if (noDataView != null) {
                noDataView.e();
            }
        }
    }
}
