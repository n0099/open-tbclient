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
import d.b.b.e.p.j;
import d.b.b.j.e.n;
import d.b.h0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes5.dex */
public class PersonCenterDynamicTabFragment extends PersonCenterTabBaseFragment implements BdListView.p, d.b.i0.h2.i.b.a {
    public static boolean p = true;
    public static CustomMessageListener q = new a(2921440);

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.h2.i.d.a f20440f;

    /* renamed from: g  reason: collision with root package name */
    public PersonCenterDynamicTabModel f20441g;

    /* renamed from: h  reason: collision with root package name */
    public long f20442h;
    public User j;
    public d.b.i0.h2.i.a.a m;
    public boolean i = false;
    public boolean k = false;
    public boolean l = false;
    public List<n> n = new ArrayList();
    public PersonCenterDynamicTabModel.b o = new b();

    /* loaded from: classes5.dex */
    public static class a extends CustomMessageListener {
        public a(int i) {
            super(i);
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
            PersonCenterDynamicTabFragment.this.P0(list, z, z2);
        }

        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.b
        public void b(boolean z) {
            PersonCenterDynamicTabFragment.this.O0(z);
        }
    }

    public static PersonCenterDynamicTabFragment N0(long j, boolean z) {
        PersonCenterDynamicTabFragment personCenterDynamicTabFragment = new PersonCenterDynamicTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterDynamicTabFragment.setArguments(bundle);
        personCenterDynamicTabFragment.registerListener(q);
        return personCenterDynamicTabFragment;
    }

    public void B0() {
        d.b.i0.h2.i.d.a aVar = this.f20440f;
        if (aVar == null || !this.l) {
            return;
        }
        aVar.k();
    }

    @Override // d.b.i0.h2.i.b.a
    public d.b.i0.h2.i.d.a C() {
        return this.f20440f;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void E0(boolean z) {
        d.b.i0.h2.i.d.a aVar;
        if (this.f20441g == null || (aVar = this.f20440f) == null || !this.l || this.k) {
            return;
        }
        hideNetRefreshView(aVar.f());
        if (j.z()) {
            this.k = true;
            if (z && p) {
                showLoadingView(this.f20440f.f(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
            }
            this.f20441g.E();
            B0();
            return;
        }
        showNetRefreshView(this.f20440f.f(), null, false);
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public int F0() {
        return 1;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public boolean G0() {
        return this.i;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void H0(MetaData metaData) {
        PersonCenterDynamicTabModel personCenterDynamicTabModel = this.f20441g;
        if (personCenterDynamicTabModel != null) {
            personCenterDynamicTabModel.F(metaData);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void I0(User user) {
        this.j = user;
        PersonCenterDynamicTabModel personCenterDynamicTabModel = this.f20441g;
        if (personCenterDynamicTabModel != null) {
            personCenterDynamicTabModel.H(user);
        }
    }

    public final void M0(Bundle bundle) {
        if (bundle != null) {
            this.f20442h = bundle.getLong("uid");
            this.i = bundle.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f20442h = arguments.getLong("uid");
            this.i = arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
        }
    }

    public final void O0(boolean z) {
        this.k = false;
        hideNetRefreshView(this.f20440f.f());
        hideLoadingView(this.f20440f.f());
        this.f20440f.g();
        if (z) {
            showNetRefreshView(this.f20440f.f(), null, false);
        }
    }

    public final void P0(List<a2> list, boolean z, boolean z2) {
        this.k = false;
        hideNetRefreshView(this.f20440f.f());
        hideLoadingView(this.f20440f.f());
        if (z) {
            this.f20440f.o();
        } else {
            this.f20440f.q();
        }
        List<n> a2 = d.b.i0.h2.i.c.a.a(list);
        this.n = a2;
        this.f20440f.n(a2);
    }

    @Override // d.b.i0.h2.i.b.a
    public boolean X() {
        return this.i && isPrimary() && !this.k;
    }

    @Override // d.b.i0.h2.i.b.a
    public List<n> i0() {
        return this.n;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        d.b.i0.h2.i.d.a aVar = this.f20440f;
        if (aVar != null) {
            aVar.i(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        M0(bundle);
        PersonCenterDynamicTabModel personCenterDynamicTabModel = new PersonCenterDynamicTabModel(getPageContext(), this.f20442h);
        this.f20441g = personCenterDynamicTabModel;
        personCenterDynamicTabModel.G(this.o);
        this.m = new d.b.i0.h2.i.a.a(getPageContext());
        new d.b.i0.h2.i.a.b(getPageContext(), getUniqueId(), this, F0());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        d.b.i0.h2.i.d.a aVar = new d.b.i0.h2.i.d.a(getPageContext(), inflate, this);
        this.f20440f = aVar;
        aVar.m(1013);
        this.f20440f.l(this);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.l = false;
        this.k = false;
        PersonCenterDynamicTabModel personCenterDynamicTabModel = this.f20441g;
        if (personCenterDynamicTabModel != null) {
            personCenterDynamicTabModel.onDestroy();
        }
        d.b.i0.h2.i.d.a aVar = this.f20440f;
        if (aVar != null) {
            aVar.j();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        E0(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        d.b.i0.h2.i.a.a aVar;
        super.onPrimary();
        if (isAdded() && isPrimary() && !this.l) {
            this.l = true;
            E0(true);
            if (!TbSingleton.getInstance().isShowShoubaiDynamicGuide() || (aVar = this.m) == null || aVar.c() || !this.i) {
                return;
            }
            this.m.f();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("uid", this.f20442h);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, this.i);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        if (this.f20441g != null && this.l && !this.k && j.z() && this.f20441g.A()) {
            this.k = true;
            this.f20441g.C();
        }
    }
}
