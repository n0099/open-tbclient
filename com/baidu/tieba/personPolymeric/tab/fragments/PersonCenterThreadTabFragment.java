package com.baidu.tieba.personPolymeric.tab.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import d.a.c.e.p.j;
import d.a.c.k.e.n;
import d.a.n0.m0.h;
import d.a.n0.m0.k;
import java.util.List;
import tbclient.User;
/* loaded from: classes5.dex */
public class PersonCenterThreadTabFragment extends PersonCenterTabBaseFragment implements BdListView.p, d.a.o0.j2.i.b.a {
    public static boolean p = true;
    public static CustomMessageListener q = new a(2921440);

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.j2.i.d.a f20035f;

    /* renamed from: g  reason: collision with root package name */
    public long f20036g;

    /* renamed from: i  reason: collision with root package name */
    public PersonPostModel f20038i;
    public User j;

    /* renamed from: h  reason: collision with root package name */
    public boolean f20037h = false;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;
    public PersonPostModel.d n = new b();
    public PersonPostModel.c o = new c();

    /* loaded from: classes5.dex */
    public static class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            boolean unused = PersonCenterThreadTabFragment.p = ((Boolean) customResponsedMessage.getData()).booleanValue();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements PersonPostModel.d {
        public b() {
        }

        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.d
        public void T(PersonPostModel personPostModel, boolean z) {
            PersonCenterThreadTabFragment.this.O0(personPostModel, z);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements PersonPostModel.c {
        public c() {
        }

        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.c
        public void M(PersonPostModel personPostModel, boolean z) {
            PersonCenterThreadTabFragment.this.O0(personPostModel, z);
        }
    }

    public static PersonCenterThreadTabFragment S0(long j, boolean z) {
        PersonCenterThreadTabFragment personCenterThreadTabFragment = new PersonCenterThreadTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterThreadTabFragment.setArguments(bundle);
        personCenterThreadTabFragment.registerListener(q);
        return personCenterThreadTabFragment;
    }

    @Override // d.a.o0.j2.i.b.a
    public d.a.o0.j2.i.d.a E() {
        return this.f20035f;
    }

    public void E0() {
        d.a.o0.j2.i.d.a aVar = this.f20035f;
        if (aVar == null || !this.l) {
            return;
        }
        aVar.k();
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void G0(boolean z) {
        d.a.o0.j2.i.d.a aVar;
        if (this.f20038i == null || (aVar = this.f20035f) == null || !this.l) {
            return;
        }
        hideNetRefreshView(aVar.f());
        if (j.z()) {
            if (z && p) {
                showLoadingView(this.f20035f.f(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
            }
            T0(true);
            E0();
            return;
        }
        showNetRefreshView(this.f20035f.f(), null, false);
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public int H0() {
        return 2;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public boolean I0() {
        return this.f20037h;
    }

    @Override // d.a.o0.j2.i.b.a
    public List<n> K() {
        PersonPostModel personPostModel = this.f20038i;
        if (personPostModel != null) {
            return personPostModel.threadList;
        }
        return null;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void K0(User user) {
        this.j = user;
        P0();
    }

    public final boolean N0(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null) {
            boolean z2 = !ListUtils.isEmpty(personPostModel.threadList);
            if (!z) {
                return z2;
            }
            if (personPostModel.threadList.size() >= 20) {
                return true;
            }
        }
        return false;
    }

    public final void O0(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        long currentTimeMillis = System.currentTimeMillis();
        this.k = false;
        hideLoadingView(this.f20035f.f());
        hideNetRefreshView(this.f20035f.f());
        if (personPostModel != null && (personPostModel2 = this.f20038i) != null) {
            if (z) {
                personPostModel2.threadList.clear();
            }
            this.f20038i.threadList.addAll(d.a.o0.j2.i.c.a.c(personPostModel.threadList));
        }
        this.m = N0(personPostModel, z);
        if (ListUtils.isEmpty(this.f20038i.threadList) && !j.z()) {
            showNetRefreshView(this.f20035f.f(), null, false);
        } else {
            if (this.m) {
                this.f20035f.o();
            } else {
                this.f20035f.q();
            }
            U0(this.f20038i.threadList);
        }
        d.a.o0.j2.b.d().l(System.currentTimeMillis() - currentTimeMillis);
        d.a.o0.j2.b.d().p(System.currentTimeMillis() - d.a.o0.j2.b.d().g());
        if (personPostModel == null || personPostModel.getResponsedMessage() == null) {
            return;
        }
        R0(personPostModel.getResponsedMessage());
    }

    public final void P0() {
        if (!isAdded() || !isPrimary() || this.j == null || this.l) {
            return;
        }
        this.l = true;
        d.a.o0.j2.b.d().o(System.currentTimeMillis());
        G0(true);
    }

    public final void Q0(Bundle bundle) {
        if (bundle != null) {
            this.f20036g = bundle.getLong("uid");
            this.f20037h = bundle.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f20036g = arguments.getLong("uid");
            this.f20037h = arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
        }
    }

    public void R0(ResponsedMessage<?> responsedMessage) {
        long h2 = d.a.o0.j2.b.d().h();
        long b2 = d.a.o0.j2.b.d().b();
        long a2 = d.a.o0.j2.b.d().a();
        long c2 = d.a.o0.j2.b.d().c();
        long f2 = d.a.o0.j2.b.d().f();
        if (!k.d().g() || b2 <= 0) {
            return;
        }
        long j = h2 + b2;
        if (a2 > 0) {
            j = System.currentTimeMillis() - a2;
        }
        h hVar = new h(1010, true, responsedMessage, 0L, b2, c2, false, 0L, 0L, j);
        if (f2 < 3600000) {
            hVar.b("profileTime", String.valueOf(f2));
        }
        hVar.c();
        d.a.o0.j2.b.d().k(0L);
    }

    public final void T0(boolean z) {
        if (this.k) {
            return;
        }
        this.k = true;
        this.f20038i.fetchPost(getPageContext(), this.o, z, String.valueOf(this.f20036g), true, 0, false, true, this.j);
    }

    public void U0(List<n> list) {
        d.a.o0.j2.i.d.a aVar = this.f20035f;
        if (aVar != null) {
            aVar.n(list);
        }
    }

    @Override // d.a.o0.j2.i.b.a
    public boolean l0() {
        return this.f20037h && isPrimary() && !this.k;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.o0.j2.i.d.a aVar = this.f20035f;
        if (aVar != null) {
            aVar.i(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Q0(bundle);
        this.f20038i = new PersonPostModel(getPageContext(), getUniqueId(), this.n, I0(), PersonPostModel.FROM_PERSON_POST);
        new d.a.o0.j2.i.a.b(getPageContext(), getUniqueId(), this, H0());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        d.a.o0.j2.i.d.a aVar = new d.a.o0.j2.i.d.a(getPageContext(), inflate, this);
        this.f20035f = aVar;
        aVar.m(1012);
        this.f20035f.l(this);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.m = false;
        this.l = false;
        this.k = false;
        d.a.o0.j2.i.d.a aVar = this.f20035f;
        if (aVar != null) {
            aVar.j();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        G0(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        P0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("uid", this.f20036g);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, this.f20037h);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        if (this.f20038i != null && this.l && j.z() && this.m) {
            T0(false);
        }
    }
}
