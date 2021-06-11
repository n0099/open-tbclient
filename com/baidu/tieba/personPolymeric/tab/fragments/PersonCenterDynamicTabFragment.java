package com.baidu.tieba.personPolymeric.tab.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel;
import d.a.c.e.p.j;
import d.a.c.k.e.n;
import d.a.m0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes5.dex */
public class PersonCenterDynamicTabFragment extends PersonCenterTabBaseFragment implements BdListView.p, d.a.n0.j2.i.b.a {
    public static boolean p = true;
    public static CustomMessageListener q = new a(2921440);

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.j2.i.d.a f19943f;

    /* renamed from: g  reason: collision with root package name */
    public PersonCenterDynamicTabModel f19944g;

    /* renamed from: h  reason: collision with root package name */
    public long f19945h;
    public User j;
    public d.a.n0.j2.i.a.a m;

    /* renamed from: i  reason: collision with root package name */
    public boolean f19946i = false;
    public boolean k = false;
    public boolean l = false;
    public List<n> n = new ArrayList();
    public PersonCenterDynamicTabModel.b o = new b();

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
            boolean unused = PersonCenterDynamicTabFragment.p = ((Boolean) customResponsedMessage.getData()).booleanValue();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements PersonCenterDynamicTabModel.b {
        public b() {
        }

        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.b
        public void a(List<a2> list, boolean z, boolean z2) {
            PersonCenterDynamicTabFragment.this.R0(list, z, z2);
        }

        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.b
        public void b(boolean z) {
            PersonCenterDynamicTabFragment.this.Q0(z);
        }
    }

    public static PersonCenterDynamicTabFragment P0(long j, boolean z) {
        PersonCenterDynamicTabFragment personCenterDynamicTabFragment = new PersonCenterDynamicTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterDynamicTabFragment.setArguments(bundle);
        personCenterDynamicTabFragment.registerListener(q);
        return personCenterDynamicTabFragment;
    }

    @Override // d.a.n0.j2.i.b.a
    public d.a.n0.j2.i.d.a E() {
        return this.f19943f;
    }

    public void E0() {
        d.a.n0.j2.i.d.a aVar = this.f19943f;
        if (aVar == null || !this.l) {
            return;
        }
        aVar.k();
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void G0(boolean z) {
        d.a.n0.j2.i.d.a aVar;
        if (this.f19944g == null || (aVar = this.f19943f) == null || !this.l || this.k) {
            return;
        }
        hideNetRefreshView(aVar.f());
        if (j.z()) {
            this.k = true;
            if (z && p) {
                showLoadingView(this.f19943f.f(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
            }
            this.f19944g.I();
            E0();
            return;
        }
        showNetRefreshView(this.f19943f.f(), null, false);
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public int H0() {
        return 1;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public boolean I0() {
        return this.f19946i;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void J0(MetaData metaData) {
        PersonCenterDynamicTabModel personCenterDynamicTabModel = this.f19944g;
        if (personCenterDynamicTabModel != null) {
            personCenterDynamicTabModel.J(metaData);
        }
    }

    @Override // d.a.n0.j2.i.b.a
    public List<n> K() {
        return this.n;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void K0(User user) {
        this.j = user;
        PersonCenterDynamicTabModel personCenterDynamicTabModel = this.f19944g;
        if (personCenterDynamicTabModel != null) {
            personCenterDynamicTabModel.L(user);
        }
    }

    public final void O0(Bundle bundle) {
        if (bundle != null) {
            this.f19945h = bundle.getLong("uid");
            this.f19946i = bundle.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f19945h = arguments.getLong("uid");
            this.f19946i = arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
        }
    }

    public final void Q0(boolean z) {
        this.k = false;
        hideNetRefreshView(this.f19943f.f());
        hideLoadingView(this.f19943f.f());
        this.f19943f.g();
        if (z) {
            showNetRefreshView(this.f19943f.f(), null, false);
        }
    }

    public final void R0(List<a2> list, boolean z, boolean z2) {
        this.k = false;
        hideNetRefreshView(this.f19943f.f());
        hideLoadingView(this.f19943f.f());
        if (z) {
            this.f19943f.o();
        } else {
            this.f19943f.q();
        }
        List<n> a2 = d.a.n0.j2.i.c.a.a(list);
        this.n = a2;
        this.f19943f.n(a2);
    }

    @Override // d.a.n0.j2.i.b.a
    public boolean l0() {
        return this.f19946i && isPrimary() && !this.k;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.n0.j2.i.d.a aVar = this.f19943f;
        if (aVar != null) {
            aVar.i(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        O0(bundle);
        PersonCenterDynamicTabModel personCenterDynamicTabModel = new PersonCenterDynamicTabModel(getPageContext(), this.f19945h);
        this.f19944g = personCenterDynamicTabModel;
        personCenterDynamicTabModel.K(this.o);
        this.m = new d.a.n0.j2.i.a.a(getPageContext());
        new d.a.n0.j2.i.a.b(getPageContext(), getUniqueId(), this, H0());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        d.a.n0.j2.i.d.a aVar = new d.a.n0.j2.i.d.a(getPageContext(), inflate, this);
        this.f19943f = aVar;
        aVar.m(1013);
        this.f19943f.l(this);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.l = false;
        this.k = false;
        PersonCenterDynamicTabModel personCenterDynamicTabModel = this.f19944g;
        if (personCenterDynamicTabModel != null) {
            personCenterDynamicTabModel.onDestroy();
        }
        d.a.n0.j2.i.d.a aVar = this.f19943f;
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
        d.a.n0.j2.i.a.a aVar;
        super.onPrimary();
        if (isAdded() && isPrimary() && !this.l) {
            this.l = true;
            G0(true);
            if (!TbSingleton.getInstance().isShowShoubaiDynamicGuide() || (aVar = this.m) == null || aVar.c() || !this.f19946i) {
                return;
            }
            this.m.f();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("uid", this.f19945h);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, this.f19946i);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        if (this.f19944g != null && this.l && !this.k && j.z() && this.f19944g.E()) {
            this.k = true;
            this.f19944g.G();
        }
    }
}
