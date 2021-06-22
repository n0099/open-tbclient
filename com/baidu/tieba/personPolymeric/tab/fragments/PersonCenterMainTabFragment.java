package com.baidu.tieba.personPolymeric.tab.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import d.a.c.k.e.n;
import d.a.o0.j2.i.d.a;
import d.a.o0.j2.i.d.b;
import java.util.List;
import tbclient.User;
/* loaded from: classes5.dex */
public class PersonCenterMainTabFragment extends PersonCenterTabBaseFragment {

    /* renamed from: f  reason: collision with root package name */
    public a f20030f;

    /* renamed from: g  reason: collision with root package name */
    public b f20031g;

    /* renamed from: h  reason: collision with root package name */
    public long f20032h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20033i = false;
    public d.a.o0.j2.e.a j;

    public static PersonCenterMainTabFragment M0(long j, boolean z) {
        PersonCenterMainTabFragment personCenterMainTabFragment = new PersonCenterMainTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterMainTabFragment.setArguments(bundle);
        return personCenterMainTabFragment;
    }

    public void E0() {
        if (this.f20030f == null || !isAdded()) {
            return;
        }
        this.f20030f.k();
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void G0(boolean z) {
        E0();
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public int H0() {
        return 0;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public boolean I0() {
        return this.f20033i;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void K0(User user) {
    }

    public final void L0(Bundle bundle) {
        if (bundle != null) {
            this.f20032h = bundle.getLong("uid");
            this.f20033i = bundle.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f20032h = arguments.getLong("uid");
            this.f20033i = arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
        }
    }

    public final void N0(d.a.o0.j2.e.a aVar) {
        if (this.f20030f == null || this.f20031g == null || aVar == null) {
            return;
        }
        List<n> b2 = d.a.o0.j2.i.c.a.b(aVar.h());
        if (!ListUtils.isEmpty(b2)) {
            this.f20030f.r(R.string.person_center_tab_main_footer_text);
        }
        this.f20030f.n(b2);
        this.f20031g.m(aVar);
        this.f20031g.n(ListUtils.isEmpty(b2), I0());
    }

    public void O0(d.a.o0.j2.e.a aVar) {
        if (aVar != null && this.f20030f != null && isAdded()) {
            N0(aVar);
        } else if (aVar != null) {
            this.j = aVar;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        a aVar = this.f20030f;
        if (aVar != null) {
            aVar.i(i2);
        }
        b bVar = this.f20031g;
        if (bVar != null) {
            bVar.r(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        L0(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        a aVar = new a(getPageContext(), inflate, this);
        this.f20030f = aVar;
        aVar.m(1011);
        b bVar = new b(getPageContext(), this.f20033i);
        this.f20031g = bVar;
        this.f20030f.d(bVar.o());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a aVar = this.f20030f;
        if (aVar != null) {
            aVar.j();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        d.a.o0.j2.e.a aVar;
        super.onResume();
        if (this.f20030f == null || this.f20031g == null || (aVar = this.j) == null) {
            return;
        }
        N0(aVar);
        this.j = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("uid", this.f20032h);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, this.f20033i);
    }
}
