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
import d.a.r0.r.f0.f;
import d.a.r0.r.q.a1;
import d.a.r0.r.q.g1;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class PersonFriendFragment extends BaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f20090e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.s0.l2.d f20091f;

    /* renamed from: g  reason: collision with root package name */
    public View f20092g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f20093h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.r0.r.f0.g f20094i;
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

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f20095e;

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
            this.f20095e = personFriendFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20095e.l = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    this.f20095e.G0();
                } else {
                    TbadkCoreApplication.getInst().login(this.f20095e.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f20095e.getBaseFragmentActivity().getPageContext().getPageActivity(), true, 11028)));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f20096e;

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
            this.f20096e = personFriendFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f20096e.p) {
                return;
            }
            PersonFriendFragment personFriendFragment = this.f20096e;
            personFriendFragment.q = personFriendFragment.j.w().d().a() + 1;
            this.f20096e.p = true;
            this.f20096e.W0();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f20097e;

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
            this.f20097e = personFriendFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            UserData userData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f20097e.f20091f == null || this.f20097e.f20091f.getItemViewType(i2) != 0 || (userData = (UserData) this.f20097e.f20091f.getItem(i2)) == null || userData.getUserId() == null) {
                return;
            }
            this.f20097e.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f20097e.U0().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
        }
    }

    /* loaded from: classes5.dex */
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f20098e;

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
            this.f20098e = personFriendFragment;
        }

        @Override // d.a.r0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f20098e.U0() == null) {
                return;
            }
            this.f20098e.q = 0;
            this.f20098e.o = true;
            this.f20098e.j.y(this.f20098e.m, this.f20098e.U0().getUid(), this.f20098e.q, this.f20098e.r);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f20099e;

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
            this.f20099e = personFriendFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f20099e.p) {
                return;
            }
            this.f20099e.o = false;
            PersonFriendFragment personFriendFragment = this.f20099e;
            personFriendFragment.q = personFriendFragment.j.w().d().a() + 1;
            this.f20099e.p = true;
            this.f20099e.W0();
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f20100a;

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
            this.f20100a = personFriendFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && this.f20100a.m) {
                g1 personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (this.f20100a.U0() != null) {
                    this.f20100a.n = personFriendData;
                    this.f20100a.X0(personFriendData, true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonFriendFragment f20101a;

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
            this.f20101a = personFriendFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                this.f20101a.p = false;
                if (this.f20101a.U0() == null || httpResponsedMessage.getOrginalMessage().getTag() != this.f20101a.U0().getUniqueId()) {
                    return;
                }
                this.f20101a.f20090e.A(0L);
                if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                    PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                    if (personFriendResponseMessage.getError() == 0) {
                        this.f20101a.X0(personFriendResponseMessage.getPersonFriendData(), false);
                        return;
                    } else {
                        this.f20101a.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.f20101a.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        return;
                    }
                }
                this.f20101a.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.f20101a.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
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
        d.a.s0.h3.d0.a.b(2001182, d.a.s0.l2.g.class);
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
        this.f20090e = null;
        this.f20091f = null;
        this.f20092g = null;
        this.f20093h = null;
        this.f20094i = null;
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

    public final void G0() {
        d.a.s0.l2.d dVar;
        UserData userData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.f20091f) == null || dVar.getItemViewType(this.l) != 0 || (userData = (UserData) this.f20091f.getItem(this.l)) == null || userData.getUserId() == null || userData.getUserName() == null || userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            return;
        }
        TiebaStatic.eventStat(U0().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
        sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(U0().getPageContext().getPageActivity(), d.a.c.e.m.b.f(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
    }

    public final PersonFriendActivity U0() {
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

    public void V0() {
        PersonFriendModel personFriendModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (personFriendModel = this.j) == null) {
            return;
        }
        personFriendModel.x();
    }

    public final void W0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d.a.s0.l2.d dVar = this.f20091f;
            if (dVar != null) {
                dVar.f(true);
                this.f20091f.notifyDataSetChanged();
            }
            this.q = this.j.w().d().a() + 1;
            PersonFriendModel personFriendModel = this.j;
            personFriendModel.y(this.m, personFriendModel.getId(), this.q, this.r);
        }
    }

    public void X0(g1 g1Var, boolean z) {
        g1 g1Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048580, this, g1Var, z) == null) || g1Var == null) {
            return;
        }
        this.f20090e.A(0L);
        if (this.j == null || U0() == null) {
            return;
        }
        if (!z) {
            if (this.o) {
                this.o = false;
                if (this.k == U0().getCurrentPageType()) {
                    this.j.z(g1Var);
                }
            } else {
                if (this.k == U0().getCurrentPageType()) {
                    Z0(g1Var);
                }
                g1Var2 = this.j.w();
                this.n = g1Var2;
                Y0(g1Var2);
                a1(g1Var);
            }
        }
        g1Var2 = g1Var;
        this.n = g1Var2;
        Y0(g1Var2);
        a1(g1Var);
    }

    public final void Y0(g1 g1Var) {
        d.a.s0.l2.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, g1Var) == null) || (dVar = this.f20091f) == null) {
            return;
        }
        if (g1Var != null) {
            a1 d2 = g1Var.d();
            boolean z = true;
            if (this.k == 0) {
                this.f20091f.e((d2 == null || d2.b() != 1) ? false : false);
                this.f20091f.d(g1Var.e());
            } else {
                if (g1Var.b().size() < this.r) {
                    this.f20091f.e(false);
                } else {
                    this.f20091f.e(true);
                }
                this.f20091f.d(g1Var.b());
            }
            this.f20091f.f(false);
            this.f20091f.b();
            this.f20091f.notifyDataSetChanged();
            return;
        }
        dVar.e(false);
        this.f20091f.d(new ArrayList<>());
        this.f20091f.f(false);
        this.f20091f.b();
        this.f20091f.notifyDataSetChanged();
    }

    public void Z0(g1 g1Var) {
        PersonFriendModel personFriendModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, g1Var) == null) || g1Var == null || (personFriendModel = this.j) == null) {
            return;
        }
        personFriendModel.w().e().addAll(g1Var.e());
        this.j.w().b().addAll(g1Var.b());
        this.j.w().h(g1Var.d());
    }

    public final void a1(g1 g1Var) {
        PersonFriendModel personFriendModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, g1Var) == null) || U0() == null || (personFriendModel = this.j) == null) {
            return;
        }
        if (this.k == 0) {
            if (personFriendModel.w().e().size() == 0) {
                g1 g1Var2 = this.n;
                if (g1Var2 != null && g1Var2.e().size() > 0) {
                    this.f20093h.setVisibility(8);
                    this.f20090e.setVisibility(0);
                } else {
                    this.f20093h.setVisibility(0);
                    this.f20090e.setVisibility(0);
                }
            } else {
                this.f20093h.setVisibility(8);
                this.f20090e.setVisibility(0);
            }
        } else if (personFriendModel.w().b().size() == 0) {
            g1 g1Var3 = this.n;
            if (g1Var3 != null && g1Var3.b().size() > 0) {
                this.f20093h.setVisibility(8);
                this.f20090e.setVisibility(0);
            } else {
                this.f20093h.setVisibility(0);
                this.f20090e.setVisibility(0);
            }
        } else {
            this.f20093h.setVisibility(8);
            this.f20090e.setVisibility(0);
        }
        U0().updateTabTitle(this.j.w().c(), this.j.w().a());
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
                if (this.f20092g != null && getBaseFragmentActivity() != null) {
                    getBaseFragmentActivity().getPageContext().getLayoutMode().j(this.f20092g);
                }
                NoDataView noDataView = this.f20093h;
                if (noDataView != null) {
                    SkinManager.setBackgroundResource(noDataView, R.color.CAM_X0201);
                }
                d.a.r0.r.f0.g gVar = this.f20094i;
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
            this.f20091f = new d.a.s0.l2.d(U0(), U0().getIsHost(), this.k, new a(this), new b(this));
            BdListView bdListView = (BdListView) inflate.findViewById(R.id.my_friend_list);
            this.f20090e = bdListView;
            bdListView.setOnItemClickListener(new c(this));
            this.f20090e.setAdapter((ListAdapter) this.f20091f);
            d.a.r0.r.f0.g gVar = new d.a.r0.r.f0.g(U0().getPageContext());
            this.f20094i = gVar;
            gVar.a(new d(this));
            this.f20090e.setPullRefresh(this.f20094i);
            this.m = U0().getIsHost();
            if (U0() == null) {
                str = null;
            } else if (this.m) {
                str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
            } else if (this.k == 0) {
                str = String.format(getString(R.string.person_friend_no_personal_info), U0().getUtype());
            } else {
                str = getString(R.string.person_friend_no_common_info);
            }
            this.f20093h = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.c(str), null);
            this.f20092g = inflate.findViewById(R.id.friend_fragment_parent);
            this.f20090e.setOnSrollToBottomListener(new e(this));
            if (U0() != null) {
                this.j = U0().getModel();
                if (this.m) {
                    V0();
                }
            }
            if (this.k == U0().getCurrentPageType()) {
                this.q = 0;
                this.f20090e.F();
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            d.a.s0.l2.d dVar = this.f20091f;
            if (dVar != null) {
                dVar.c();
                this.f20091f = null;
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            d.a.s0.l2.d dVar = this.f20091f;
            if (dVar != null) {
                dVar.c();
                this.f20091f = null;
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
            if (U0() != null) {
                this.j = U0().getModel();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onStart();
            NoDataView noDataView = this.f20093h;
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
            NoDataView noDataView = this.f20093h;
            if (noDataView != null) {
                noDataView.e();
            }
        }
    }
}
