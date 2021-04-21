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
import d.b.i0.r.f0.f;
import d.b.i0.r.q.f1;
import d.b.i0.r.q.z0;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PersonFriendFragment extends BaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public BdListView f20061e = null;

    /* renamed from: f  reason: collision with root package name */
    public d.b.j0.h2.d f20062f = null;

    /* renamed from: g  reason: collision with root package name */
    public View f20063g = null;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f20064h = null;
    public d.b.i0.r.f0.g i = null;
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

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonFriendFragment.this.l = ((Integer) view.getTag()).intValue();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                PersonFriendFragment.this.E0();
            } else {
                TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, 11028)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonFriendFragment.this.p) {
                return;
            }
            PersonFriendFragment personFriendFragment = PersonFriendFragment.this;
            personFriendFragment.q = personFriendFragment.j.s().d().a() + 1;
            PersonFriendFragment.this.p = true;
            PersonFriendFragment.this.U0();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements AdapterView.OnItemClickListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            UserData userData;
            if (PersonFriendFragment.this.f20062f == null || PersonFriendFragment.this.f20062f.getItemViewType(i) != 0 || (userData = (UserData) PersonFriendFragment.this.f20062f.getItem(i)) == null || userData.getUserId() == null) {
                return;
            }
            PersonFriendFragment.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PersonFriendFragment.this.S0().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements f.g {
        public d() {
        }

        @Override // d.b.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (PersonFriendFragment.this.S0() != null) {
                PersonFriendFragment.this.q = 0;
                PersonFriendFragment.this.o = true;
                PersonFriendFragment.this.j.u(PersonFriendFragment.this.m, PersonFriendFragment.this.S0().getUid(), PersonFriendFragment.this.q, PersonFriendFragment.this.r);
            }
        }
    }

    /* loaded from: classes3.dex */
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
            personFriendFragment.q = personFriendFragment.j.s().d().a() + 1;
            PersonFriendFragment.this.p = true;
            PersonFriendFragment.this.U0();
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public f(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.m) {
                f1 personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.S0() != null) {
                    PersonFriendFragment.this.n = personFriendData;
                    PersonFriendFragment.this.V0(personFriendData, true);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends HttpMessageListener {
        public g(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1002001) {
                return;
            }
            PersonFriendFragment.this.p = false;
            if (PersonFriendFragment.this.S0() == null || httpResponsedMessage.getOrginalMessage().getTag() != PersonFriendFragment.this.S0().getUniqueId()) {
                return;
            }
            PersonFriendFragment.this.f20061e.A(0L);
            if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                if (personFriendResponseMessage.getError() == 0) {
                    PersonFriendFragment.this.V0(personFriendResponseMessage.getPersonFriendData(), false);
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
        d.b.j0.d3.d0.a.b(2001182, d.b.j0.h2.g.class);
    }

    public final void E0() {
        UserData userData;
        d.b.j0.h2.d dVar = this.f20062f;
        if (dVar == null || dVar.getItemViewType(this.l) != 0 || (userData = (UserData) this.f20062f.getItem(this.l)) == null || userData.getUserId() == null || userData.getUserName() == null || userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            return;
        }
        TiebaStatic.eventStat(S0().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
        sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(S0().getPageContext().getPageActivity(), d.b.c.e.m.b.f(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
    }

    public final PersonFriendActivity S0() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonFriendActivity) {
            return (PersonFriendActivity) baseFragmentActivity;
        }
        return null;
    }

    public void T0() {
        PersonFriendModel personFriendModel = this.j;
        if (personFriendModel != null) {
            personFriendModel.t();
        }
    }

    public final void U0() {
        d.b.j0.h2.d dVar = this.f20062f;
        if (dVar != null) {
            dVar.f(true);
            this.f20062f.notifyDataSetChanged();
        }
        this.q = this.j.s().d().a() + 1;
        PersonFriendModel personFriendModel = this.j;
        personFriendModel.u(this.m, personFriendModel.getId(), this.q, this.r);
    }

    public void V0(f1 f1Var, boolean z) {
        f1 f1Var2;
        if (f1Var == null) {
            return;
        }
        this.f20061e.A(0L);
        if (this.j == null || S0() == null) {
            return;
        }
        if (!z) {
            if (this.o) {
                this.o = false;
                if (this.k == S0().getCurrentPageType()) {
                    this.j.v(f1Var);
                }
            } else {
                if (this.k == S0().getCurrentPageType()) {
                    X0(f1Var);
                }
                f1Var2 = this.j.s();
                this.n = f1Var2;
                W0(f1Var2);
                Y0(f1Var);
            }
        }
        f1Var2 = f1Var;
        this.n = f1Var2;
        W0(f1Var2);
        Y0(f1Var);
    }

    public final void W0(f1 f1Var) {
        d.b.j0.h2.d dVar = this.f20062f;
        if (dVar != null) {
            if (f1Var != null) {
                z0 d2 = f1Var.d();
                boolean z = true;
                if (this.k == 0) {
                    this.f20062f.e((d2 == null || d2.b() != 1) ? false : false);
                    this.f20062f.d(f1Var.e());
                } else {
                    if (f1Var.b().size() < this.r) {
                        this.f20062f.e(false);
                    } else {
                        this.f20062f.e(true);
                    }
                    this.f20062f.d(f1Var.b());
                }
                this.f20062f.f(false);
                this.f20062f.b();
                this.f20062f.notifyDataSetChanged();
                return;
            }
            dVar.e(false);
            this.f20062f.d(new ArrayList<>());
            this.f20062f.f(false);
            this.f20062f.b();
            this.f20062f.notifyDataSetChanged();
        }
    }

    public void X0(f1 f1Var) {
        PersonFriendModel personFriendModel;
        if (f1Var == null || (personFriendModel = this.j) == null) {
            return;
        }
        personFriendModel.s().e().addAll(f1Var.e());
        this.j.s().b().addAll(f1Var.b());
        this.j.s().h(f1Var.d());
    }

    public final void Y0(f1 f1Var) {
        PersonFriendModel personFriendModel;
        if (S0() == null || (personFriendModel = this.j) == null) {
            return;
        }
        if (this.k == 0) {
            if (personFriendModel.s().e().size() == 0) {
                f1 f1Var2 = this.n;
                if (f1Var2 != null && f1Var2.e().size() > 0) {
                    this.f20064h.setVisibility(8);
                    this.f20061e.setVisibility(0);
                } else {
                    this.f20064h.setVisibility(0);
                    this.f20061e.setVisibility(0);
                }
            } else {
                this.f20064h.setVisibility(8);
                this.f20061e.setVisibility(0);
            }
        } else if (personFriendModel.s().b().size() == 0) {
            f1 f1Var3 = this.n;
            if (f1Var3 != null && f1Var3.b().size() > 0) {
                this.f20064h.setVisibility(8);
                this.f20061e.setVisibility(0);
            } else {
                this.f20064h.setVisibility(0);
                this.f20061e.setVisibility(0);
            }
        } else {
            this.f20064h.setVisibility(8);
            this.f20061e.setVisibility(0);
        }
        S0().updateTabTitle(this.j.s().c(), this.j.s().a());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.t);
        registerListener(this.s);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.f20063g != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().j(this.f20063g);
            }
            NoDataView noDataView = this.f20064h;
            if (noDataView != null) {
                SkinManager.setBackgroundResource(noDataView, R.color.CAM_X0201);
            }
            d.b.i0.r.f0.g gVar = this.i;
            if (gVar != null) {
                gVar.I(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.k = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.f20062f = new d.b.j0.h2.d(S0(), S0().getIsHost(), this.k, new a(), new b());
        BdListView bdListView = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.f20061e = bdListView;
        bdListView.setOnItemClickListener(new c());
        this.f20061e.setAdapter((ListAdapter) this.f20062f);
        d.b.i0.r.f0.g gVar = new d.b.i0.r.f0.g(S0().getPageContext());
        this.i = gVar;
        gVar.b(new d());
        this.f20061e.setPullRefresh(this.i);
        this.m = S0().getIsHost();
        if (S0() == null) {
            str = null;
        } else if (this.m) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.k == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), S0().getUtype());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.f20064h = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.c(str), null);
        this.f20063g = inflate.findViewById(R.id.friend_fragment_parent);
        this.f20061e.setOnSrollToBottomListener(new e());
        if (S0() != null) {
            this.j = S0().getModel();
            if (this.m) {
                T0();
            }
        }
        if (this.k == S0().getCurrentPageType()) {
            this.q = 0;
            this.f20061e.F();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        d.b.j0.h2.d dVar = this.f20062f;
        if (dVar != null) {
            dVar.c();
            this.f20062f = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        d.b.j0.h2.d dVar = this.f20062f;
        if (dVar != null) {
            dVar.c();
            this.f20062f = null;
        }
        MessageManager.getInstance().unRegisterListener(this.t);
        MessageManager.getInstance().unRegisterListener(this.s);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (S0() != null) {
            this.j = S0().getModel();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        NoDataView noDataView = this.f20064h;
        if (noDataView != null) {
            noDataView.d(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        NoDataView noDataView = this.f20064h;
        if (noDataView != null) {
            noDataView.e();
        }
    }
}
