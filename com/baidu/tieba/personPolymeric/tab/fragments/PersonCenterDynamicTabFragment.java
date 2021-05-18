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
import d.a.c.j.e.n;
import d.a.j0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes5.dex */
public class PersonCenterDynamicTabFragment extends PersonCenterTabBaseFragment implements BdListView.p, d.a.k0.i2.i.b.a {
    public static boolean p = true;
    public static CustomMessageListener q = new a(2921440);

    /* renamed from: f  reason: collision with root package name */
    public d.a.k0.i2.i.d.a f19944f;

    /* renamed from: g  reason: collision with root package name */
    public PersonCenterDynamicTabModel f19945g;

    /* renamed from: h  reason: collision with root package name */
    public long f19946h;
    public User j;
    public d.a.k0.i2.i.a.a m;

    /* renamed from: i  reason: collision with root package name */
    public boolean f19947i = false;
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
            PersonCenterDynamicTabFragment.this.O0(list, z, z2);
        }

        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.b
        public void b(boolean z) {
            PersonCenterDynamicTabFragment.this.N0(z);
        }
    }

    public static PersonCenterDynamicTabFragment M0(long j, boolean z) {
        PersonCenterDynamicTabFragment personCenterDynamicTabFragment = new PersonCenterDynamicTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterDynamicTabFragment.setArguments(bundle);
        personCenterDynamicTabFragment.registerListener(q);
        return personCenterDynamicTabFragment;
    }

    public void B0() {
        d.a.k0.i2.i.d.a aVar = this.f19944f;
        if (aVar == null || !this.l) {
            return;
        }
        aVar.k();
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void D0(boolean z) {
        d.a.k0.i2.i.d.a aVar;
        if (this.f19945g == null || (aVar = this.f19944f) == null || !this.l || this.k) {
            return;
        }
        hideNetRefreshView(aVar.f());
        if (j.z()) {
            this.k = true;
            if (z && p) {
                showLoadingView(this.f19944f.f(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
            }
            this.f19945g.E();
            B0();
            return;
        }
        showNetRefreshView(this.f19944f.f(), null, false);
    }

    @Override // d.a.k0.i2.i.b.a
    public d.a.k0.i2.i.d.a E() {
        return this.f19944f;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public int E0() {
        return 1;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public boolean F0() {
        return this.f19947i;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void G0(MetaData metaData) {
        PersonCenterDynamicTabModel personCenterDynamicTabModel = this.f19945g;
        if (personCenterDynamicTabModel != null) {
            personCenterDynamicTabModel.F(metaData);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void H0(User user) {
        this.j = user;
        PersonCenterDynamicTabModel personCenterDynamicTabModel = this.f19945g;
        if (personCenterDynamicTabModel != null) {
            personCenterDynamicTabModel.H(user);
        }
    }

    @Override // d.a.k0.i2.i.b.a
    public List<n> J() {
        return this.n;
    }

    public final void L0(Bundle bundle) {
        if (bundle != null) {
            this.f19946h = bundle.getLong("uid");
            this.f19947i = bundle.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f19946h = arguments.getLong("uid");
            this.f19947i = arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
        }
    }

    public final void N0(boolean z) {
        this.k = false;
        hideNetRefreshView(this.f19944f.f());
        hideLoadingView(this.f19944f.f());
        this.f19944f.g();
        if (z) {
            showNetRefreshView(this.f19944f.f(), null, false);
        }
    }

    public final void O0(List<a2> list, boolean z, boolean z2) {
        this.k = false;
        hideNetRefreshView(this.f19944f.f());
        hideLoadingView(this.f19944f.f());
        if (z) {
            this.f19944f.o();
        } else {
            this.f19944f.q();
        }
        List<n> a2 = d.a.k0.i2.i.c.a.a(list);
        this.n = a2;
        this.f19944f.n(a2);
    }

    @Override // d.a.k0.i2.i.b.a
    public boolean i0() {
        return this.f19947i && isPrimary() && !this.k;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.k0.i2.i.d.a aVar = this.f19944f;
        if (aVar != null) {
            aVar.i(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        L0(bundle);
        PersonCenterDynamicTabModel personCenterDynamicTabModel = new PersonCenterDynamicTabModel(getPageContext(), this.f19946h);
        this.f19945g = personCenterDynamicTabModel;
        personCenterDynamicTabModel.G(this.o);
        this.m = new d.a.k0.i2.i.a.a(getPageContext());
        new d.a.k0.i2.i.a.b(getPageContext(), getUniqueId(), this, E0());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        d.a.k0.i2.i.d.a aVar = new d.a.k0.i2.i.d.a(getPageContext(), inflate, this);
        this.f19944f = aVar;
        aVar.m(1013);
        this.f19944f.l(this);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.l = false;
        this.k = false;
        PersonCenterDynamicTabModel personCenterDynamicTabModel = this.f19945g;
        if (personCenterDynamicTabModel != null) {
            personCenterDynamicTabModel.onDestroy();
        }
        d.a.k0.i2.i.d.a aVar = this.f19944f;
        if (aVar != null) {
            aVar.j();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        D0(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        d.a.k0.i2.i.a.a aVar;
        super.onPrimary();
        if (isAdded() && isPrimary() && !this.l) {
            this.l = true;
            D0(true);
            if (!TbSingleton.getInstance().isShowShoubaiDynamicGuide() || (aVar = this.m) == null || aVar.c() || !this.f19947i) {
                return;
            }
            this.m.f();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("uid", this.f19946h);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, this.f19947i);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        if (this.f19945g != null && this.l && !this.k && j.z() && this.f19945g.A()) {
            this.k = true;
            this.f19945g.C();
        }
    }
}
