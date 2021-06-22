package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
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
import d.a.n0.r.f0.f;
import d.a.n0.r.q.f1;
import d.a.n0.r.q.z0;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class PersonFriendFragment extends BaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public BdListView f19940e = null;

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.i2.d f19941f = null;

    /* renamed from: g  reason: collision with root package name */
    public View f19942g = null;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f19943h = null;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.r.f0.g f19944i = null;
    public PersonFriendModel j = null;
    public int k = 0;
    public int l = 0;
    public boolean m = true;
    public f1 n = null;
    public boolean o = true;
    public boolean p = false;
    public int q = 0;
    public int r = 20;
    public final CustomMessageListener s = new f(2001182);
    public HttpMessageListener t = new g(CmdConfigHttp.PIC_FRIEND_CMD);

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonFriendFragment.this.l = ((Integer) view.getTag()).intValue();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                PersonFriendFragment.this.G0();
            } else {
                TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, 11028)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonFriendFragment.this.p) {
                return;
            }
            PersonFriendFragment personFriendFragment = PersonFriendFragment.this;
            personFriendFragment.q = personFriendFragment.j.w().d().a() + 1;
            PersonFriendFragment.this.p = true;
            PersonFriendFragment.this.W0();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements AdapterView.OnItemClickListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            UserData userData;
            if (PersonFriendFragment.this.f19941f == null || PersonFriendFragment.this.f19941f.getItemViewType(i2) != 0 || (userData = (UserData) PersonFriendFragment.this.f19941f.getItem(i2)) == null || userData.getUserId() == null) {
                return;
            }
            PersonFriendFragment.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PersonFriendFragment.this.U0().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
        }
    }

    /* loaded from: classes5.dex */
    public class d implements f.g {
        public d() {
        }

        @Override // d.a.n0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (PersonFriendFragment.this.U0() != null) {
                PersonFriendFragment.this.q = 0;
                PersonFriendFragment.this.o = true;
                PersonFriendFragment.this.j.y(PersonFriendFragment.this.m, PersonFriendFragment.this.U0().getUid(), PersonFriendFragment.this.q, PersonFriendFragment.this.r);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements BdListView.p {
        public e() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (PersonFriendFragment.this.p) {
                return;
            }
            PersonFriendFragment.this.o = false;
            PersonFriendFragment personFriendFragment = PersonFriendFragment.this;
            personFriendFragment.q = personFriendFragment.j.w().d().a() + 1;
            PersonFriendFragment.this.p = true;
            PersonFriendFragment.this.W0();
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public f(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.m) {
                f1 personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.U0() != null) {
                    PersonFriendFragment.this.n = personFriendData;
                    PersonFriendFragment.this.X0(personFriendData, true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends HttpMessageListener {
        public g(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1002001) {
                return;
            }
            PersonFriendFragment.this.p = false;
            if (PersonFriendFragment.this.U0() == null || httpResponsedMessage.getOrginalMessage().getTag() != PersonFriendFragment.this.U0().getUniqueId()) {
                return;
            }
            PersonFriendFragment.this.f19940e.A(0L);
            if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                if (personFriendResponseMessage.getError() == 0) {
                    PersonFriendFragment.this.X0(personFriendResponseMessage.getPersonFriendData(), false);
                    return;
                } else {
                    PersonFriendFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonFriendFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                    return;
                }
            }
            PersonFriendFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonFriendFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        }
    }

    static {
        d.a.o0.e3.d0.a.b(2001182, d.a.o0.i2.g.class);
    }

    public final void G0() {
        UserData userData;
        d.a.o0.i2.d dVar = this.f19941f;
        if (dVar == null || dVar.getItemViewType(this.l) != 0 || (userData = (UserData) this.f19941f.getItem(this.l)) == null || userData.getUserId() == null || userData.getUserName() == null || userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            return;
        }
        TiebaStatic.eventStat(U0().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
        sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(U0().getPageContext().getPageActivity(), d.a.c.e.m.b.f(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
    }

    public final PersonFriendActivity U0() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonFriendActivity) {
            return (PersonFriendActivity) baseFragmentActivity;
        }
        return null;
    }

    public void V0() {
        PersonFriendModel personFriendModel = this.j;
        if (personFriendModel != null) {
            personFriendModel.x();
        }
    }

    public final void W0() {
        d.a.o0.i2.d dVar = this.f19941f;
        if (dVar != null) {
            dVar.f(true);
            this.f19941f.notifyDataSetChanged();
        }
        this.q = this.j.w().d().a() + 1;
        PersonFriendModel personFriendModel = this.j;
        personFriendModel.y(this.m, personFriendModel.getId(), this.q, this.r);
    }

    public void X0(f1 f1Var, boolean z) {
        f1 f1Var2;
        if (f1Var == null) {
            return;
        }
        this.f19940e.A(0L);
        if (this.j == null || U0() == null) {
            return;
        }
        if (!z) {
            if (this.o) {
                this.o = false;
                if (this.k == U0().getCurrentPageType()) {
                    this.j.z(f1Var);
                }
            } else {
                if (this.k == U0().getCurrentPageType()) {
                    Z0(f1Var);
                }
                f1Var2 = this.j.w();
                this.n = f1Var2;
                Y0(f1Var2);
                a1(f1Var);
            }
        }
        f1Var2 = f1Var;
        this.n = f1Var2;
        Y0(f1Var2);
        a1(f1Var);
    }

    public final void Y0(f1 f1Var) {
        d.a.o0.i2.d dVar = this.f19941f;
        if (dVar != null) {
            if (f1Var != null) {
                z0 d2 = f1Var.d();
                boolean z = true;
                if (this.k == 0) {
                    this.f19941f.e((d2 == null || d2.b() != 1) ? false : false);
                    this.f19941f.d(f1Var.e());
                } else {
                    if (f1Var.b().size() < this.r) {
                        this.f19941f.e(false);
                    } else {
                        this.f19941f.e(true);
                    }
                    this.f19941f.d(f1Var.b());
                }
                this.f19941f.f(false);
                this.f19941f.b();
                this.f19941f.notifyDataSetChanged();
                return;
            }
            dVar.e(false);
            this.f19941f.d(new ArrayList<>());
            this.f19941f.f(false);
            this.f19941f.b();
            this.f19941f.notifyDataSetChanged();
        }
    }

    public void Z0(f1 f1Var) {
        PersonFriendModel personFriendModel;
        if (f1Var == null || (personFriendModel = this.j) == null) {
            return;
        }
        personFriendModel.w().e().addAll(f1Var.e());
        this.j.w().b().addAll(f1Var.b());
        this.j.w().h(f1Var.d());
    }

    public final void a1(f1 f1Var) {
        PersonFriendModel personFriendModel;
        if (U0() == null || (personFriendModel = this.j) == null) {
            return;
        }
        if (this.k == 0) {
            if (personFriendModel.w().e().size() == 0) {
                f1 f1Var2 = this.n;
                if (f1Var2 != null && f1Var2.e().size() > 0) {
                    this.f19943h.setVisibility(8);
                    this.f19940e.setVisibility(0);
                } else {
                    this.f19943h.setVisibility(0);
                    this.f19940e.setVisibility(0);
                }
            } else {
                this.f19943h.setVisibility(8);
                this.f19940e.setVisibility(0);
            }
        } else if (personFriendModel.w().b().size() == 0) {
            f1 f1Var3 = this.n;
            if (f1Var3 != null && f1Var3.b().size() > 0) {
                this.f19943h.setVisibility(8);
                this.f19940e.setVisibility(0);
            } else {
                this.f19943h.setVisibility(0);
                this.f19940e.setVisibility(0);
            }
        } else {
            this.f19943h.setVisibility(8);
            this.f19940e.setVisibility(0);
        }
        U0().updateTabTitle(this.j.w().c(), this.j.w().a());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.t);
        registerListener(this.s);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        if (isAdded()) {
            if (this.f19942g != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().j(this.f19942g);
            }
            NoDataView noDataView = this.f19943h;
            if (noDataView != null) {
                SkinManager.setBackgroundResource(noDataView, R.color.CAM_X0201);
            }
            d.a.n0.r.f0.g gVar = this.f19944i;
            if (gVar != null) {
                gVar.I(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.k = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.f19941f = new d.a.o0.i2.d(U0(), U0().getIsHost(), this.k, new a(), new b());
        BdListView bdListView = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.f19940e = bdListView;
        bdListView.setOnItemClickListener(new c());
        this.f19940e.setAdapter((ListAdapter) this.f19941f);
        d.a.n0.r.f0.g gVar = new d.a.n0.r.f0.g(U0().getPageContext());
        this.f19944i = gVar;
        gVar.a(new d());
        this.f19940e.setPullRefresh(this.f19944i);
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
        this.f19943h = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.c(str), null);
        this.f19942g = inflate.findViewById(R.id.friend_fragment_parent);
        this.f19940e.setOnSrollToBottomListener(new e());
        if (U0() != null) {
            this.j = U0().getModel();
            if (this.m) {
                V0();
            }
        }
        if (this.k == U0().getCurrentPageType()) {
            this.q = 0;
            this.f19940e.F();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        d.a.o0.i2.d dVar = this.f19941f;
        if (dVar != null) {
            dVar.c();
            this.f19941f = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        d.a.o0.i2.d dVar = this.f19941f;
        if (dVar != null) {
            dVar.c();
            this.f19941f = null;
        }
        MessageManager.getInstance().unRegisterListener(this.t);
        MessageManager.getInstance().unRegisterListener(this.s);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (U0() != null) {
            this.j = U0().getModel();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        NoDataView noDataView = this.f19943h;
        if (noDataView != null) {
            noDataView.d(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        NoDataView noDataView = this.f19943h;
        if (noDataView != null) {
            noDataView.e();
        }
    }
}
