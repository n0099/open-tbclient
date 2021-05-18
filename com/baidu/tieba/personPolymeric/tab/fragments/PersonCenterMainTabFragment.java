package com.baidu.tieba.personPolymeric.tab.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import d.a.c.j.e.n;
import d.a.k0.i2.i.d.a;
import d.a.k0.i2.i.d.b;
import java.util.List;
import tbclient.User;
/* loaded from: classes5.dex */
public class PersonCenterMainTabFragment extends PersonCenterTabBaseFragment {

    /* renamed from: f  reason: collision with root package name */
    public a f19949f;

    /* renamed from: g  reason: collision with root package name */
    public b f19950g;

    /* renamed from: h  reason: collision with root package name */
    public long f19951h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f19952i = false;
    public d.a.k0.i2.e.a j;

    public static PersonCenterMainTabFragment J0(long j, boolean z) {
        PersonCenterMainTabFragment personCenterMainTabFragment = new PersonCenterMainTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterMainTabFragment.setArguments(bundle);
        return personCenterMainTabFragment;
    }

    public void B0() {
        if (this.f19949f == null || !isAdded()) {
            return;
        }
        this.f19949f.k();
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void D0(boolean z) {
        B0();
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public int E0() {
        return 0;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public boolean F0() {
        return this.f19952i;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void H0(User user) {
    }

    public final void I0(Bundle bundle) {
        if (bundle != null) {
            this.f19951h = bundle.getLong("uid");
            this.f19952i = bundle.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f19951h = arguments.getLong("uid");
            this.f19952i = arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
        }
    }

    public final void K0(d.a.k0.i2.e.a aVar) {
        if (this.f19949f == null || this.f19950g == null || aVar == null) {
            return;
        }
        List<n> b2 = d.a.k0.i2.i.c.a.b(aVar.h());
        if (!ListUtils.isEmpty(b2)) {
            this.f19949f.r(R.string.person_center_tab_main_footer_text);
        }
        this.f19949f.n(b2);
        this.f19950g.m(aVar);
        this.f19950g.n(ListUtils.isEmpty(b2), F0());
    }

    public void L0(d.a.k0.i2.e.a aVar) {
        if (aVar != null && this.f19949f != null && isAdded()) {
            K0(aVar);
        } else if (aVar != null) {
            this.j = aVar;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        a aVar = this.f19949f;
        if (aVar != null) {
            aVar.i(i2);
        }
        b bVar = this.f19950g;
        if (bVar != null) {
            bVar.r(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        I0(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        a aVar = new a(getPageContext(), inflate, this);
        this.f19949f = aVar;
        aVar.m(1011);
        b bVar = new b(getPageContext(), this.f19952i);
        this.f19950g = bVar;
        this.f19949f.d(bVar.o());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a aVar = this.f19949f;
        if (aVar != null) {
            aVar.j();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        d.a.k0.i2.e.a aVar;
        super.onResume();
        if (this.f19949f == null || this.f19950g == null || (aVar = this.j) == null) {
            return;
        }
        K0(aVar);
        this.j = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("uid", this.f19951h);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, this.f19952i);
    }
}
