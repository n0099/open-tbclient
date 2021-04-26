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
import com.baidu.webkit.sdk.VideoCloudSetting;
import d.a.c.e.p.j;
import d.a.c.j.e.n;
import d.a.i0.m0.h;
import d.a.i0.m0.k;
import java.util.List;
import tbclient.User;
/* loaded from: classes4.dex */
public class PersonCenterThreadTabFragment extends PersonCenterTabBaseFragment implements BdListView.p, d.a.j0.i2.i.b.a {
    public static boolean p = true;
    public static CustomMessageListener q = new a(2921440);

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.i2.i.d.a f20666f;

    /* renamed from: g  reason: collision with root package name */
    public long f20667g;

    /* renamed from: i  reason: collision with root package name */
    public PersonPostModel f20669i;
    public User j;

    /* renamed from: h  reason: collision with root package name */
    public boolean f20668h = false;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;
    public PersonPostModel.d n = new b();
    public PersonPostModel.c o = new c();

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class b implements PersonPostModel.d {
        public b() {
        }

        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.d
        public void R(PersonPostModel personPostModel, boolean z) {
            PersonCenterThreadTabFragment.this.M0(personPostModel, z);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PersonPostModel.c {
        public c() {
        }

        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.c
        public void L(PersonPostModel personPostModel, boolean z) {
            PersonCenterThreadTabFragment.this.M0(personPostModel, z);
        }
    }

    public static PersonCenterThreadTabFragment Q0(long j, boolean z) {
        PersonCenterThreadTabFragment personCenterThreadTabFragment = new PersonCenterThreadTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterThreadTabFragment.setArguments(bundle);
        personCenterThreadTabFragment.registerListener(q);
        return personCenterThreadTabFragment;
    }

    public void C0() {
        d.a.j0.i2.i.d.a aVar = this.f20666f;
        if (aVar == null || !this.l) {
            return;
        }
        aVar.k();
    }

    @Override // d.a.j0.i2.i.b.a
    public d.a.j0.i2.i.d.a E() {
        return this.f20666f;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void E0(boolean z) {
        d.a.j0.i2.i.d.a aVar;
        if (this.f20669i == null || (aVar = this.f20666f) == null || !this.l) {
            return;
        }
        hideNetRefreshView(aVar.f());
        if (j.z()) {
            if (z && p) {
                showLoadingView(this.f20666f.f(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
            }
            R0(true);
            C0();
            return;
        }
        showNetRefreshView(this.f20666f.f(), null, false);
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public int F0() {
        return 2;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public boolean G0() {
        return this.f20668h;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void I0(User user) {
        this.j = user;
        N0();
    }

    @Override // d.a.j0.i2.i.b.a
    public List<n> J() {
        PersonPostModel personPostModel = this.f20669i;
        if (personPostModel != null) {
            return personPostModel.threadList;
        }
        return null;
    }

    public final boolean L0(PersonPostModel personPostModel, boolean z) {
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

    public final void M0(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        long currentTimeMillis = System.currentTimeMillis();
        this.k = false;
        hideLoadingView(this.f20666f.f());
        hideNetRefreshView(this.f20666f.f());
        if (personPostModel != null && (personPostModel2 = this.f20669i) != null) {
            if (z) {
                personPostModel2.threadList.clear();
            }
            this.f20669i.threadList.addAll(d.a.j0.i2.i.c.a.c(personPostModel.threadList));
        }
        this.m = L0(personPostModel, z);
        if (ListUtils.isEmpty(this.f20669i.threadList) && !j.z()) {
            showNetRefreshView(this.f20666f.f(), null, false);
        } else {
            if (this.m) {
                this.f20666f.o();
            } else {
                this.f20666f.q();
            }
            S0(this.f20669i.threadList);
        }
        d.a.j0.i2.b.d().l(System.currentTimeMillis() - currentTimeMillis);
        d.a.j0.i2.b.d().p(System.currentTimeMillis() - d.a.j0.i2.b.d().g());
        if (personPostModel == null || personPostModel.getResponsedMessage() == null) {
            return;
        }
        P0(personPostModel.getResponsedMessage());
    }

    public final void N0() {
        if (!isAdded() || !isPrimary() || this.j == null || this.l) {
            return;
        }
        this.l = true;
        d.a.j0.i2.b.d().o(System.currentTimeMillis());
        E0(true);
    }

    public final void O0(Bundle bundle) {
        if (bundle != null) {
            this.f20667g = bundle.getLong("uid");
            this.f20668h = bundle.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f20667g = arguments.getLong("uid");
            this.f20668h = arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
        }
    }

    public void P0(ResponsedMessage<?> responsedMessage) {
        long h2 = d.a.j0.i2.b.d().h();
        long b2 = d.a.j0.i2.b.d().b();
        long a2 = d.a.j0.i2.b.d().a();
        long c2 = d.a.j0.i2.b.d().c();
        long f2 = d.a.j0.i2.b.d().f();
        if (!k.d().g() || b2 <= 0) {
            return;
        }
        long j = h2 + b2;
        if (a2 > 0) {
            j = System.currentTimeMillis() - a2;
        }
        h hVar = new h(1010, true, responsedMessage, 0L, b2, c2, false, 0L, 0L, j);
        if (f2 < VideoCloudSetting.HOUR_MILLISECOND) {
            hVar.b("profileTime", String.valueOf(f2));
        }
        hVar.c();
        d.a.j0.i2.b.d().k(0L);
    }

    public final void R0(boolean z) {
        if (this.k) {
            return;
        }
        this.k = true;
        this.f20669i.fetchPost(getPageContext(), this.o, z, String.valueOf(this.f20667g), true, 0, false, true, this.j);
    }

    public void S0(List<n> list) {
        d.a.j0.i2.i.d.a aVar = this.f20666f;
        if (aVar != null) {
            aVar.n(list);
        }
    }

    @Override // d.a.j0.i2.i.b.a
    public boolean i0() {
        return this.f20668h && isPrimary() && !this.k;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.j0.i2.i.d.a aVar = this.f20666f;
        if (aVar != null) {
            aVar.i(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        O0(bundle);
        this.f20669i = new PersonPostModel(getPageContext(), getUniqueId(), this.n, G0(), PersonPostModel.FROM_PERSON_POST);
        new d.a.j0.i2.i.a.b(getPageContext(), getUniqueId(), this, F0());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        d.a.j0.i2.i.d.a aVar = new d.a.j0.i2.i.d.a(getPageContext(), inflate, this);
        this.f20666f = aVar;
        aVar.m(1012);
        this.f20666f.l(this);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.m = false;
        this.l = false;
        this.k = false;
        d.a.j0.i2.i.d.a aVar = this.f20666f;
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
        super.onPrimary();
        N0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("uid", this.f20667g);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, this.f20668h);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        if (this.f20669i != null && this.l && j.z() && this.m) {
            R0(false);
        }
    }
}
