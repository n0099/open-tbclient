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
import d.a.j0.i2.i.d.a;
import d.a.j0.i2.i.d.b;
import java.util.List;
import tbclient.User;
/* loaded from: classes4.dex */
public class PersonCenterMainTabFragment extends PersonCenterTabBaseFragment {

    /* renamed from: f  reason: collision with root package name */
    public a f20661f;

    /* renamed from: g  reason: collision with root package name */
    public b f20662g;

    /* renamed from: h  reason: collision with root package name */
    public long f20663h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20664i = false;
    public d.a.j0.i2.e.a j;

    public static PersonCenterMainTabFragment K0(long j, boolean z) {
        PersonCenterMainTabFragment personCenterMainTabFragment = new PersonCenterMainTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterMainTabFragment.setArguments(bundle);
        return personCenterMainTabFragment;
    }

    public void C0() {
        if (this.f20661f == null || !isAdded()) {
            return;
        }
        this.f20661f.k();
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void E0(boolean z) {
        C0();
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public int F0() {
        return 0;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public boolean G0() {
        return this.f20664i;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void I0(User user) {
    }

    public final void J0(Bundle bundle) {
        if (bundle != null) {
            this.f20663h = bundle.getLong("uid");
            this.f20664i = bundle.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f20663h = arguments.getLong("uid");
            this.f20664i = arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
        }
    }

    public final void L0(d.a.j0.i2.e.a aVar) {
        if (this.f20661f == null || this.f20662g == null || aVar == null) {
            return;
        }
        List<n> b2 = d.a.j0.i2.i.c.a.b(aVar.h());
        if (!ListUtils.isEmpty(b2)) {
            this.f20661f.r(R.string.person_center_tab_main_footer_text);
        }
        this.f20661f.n(b2);
        this.f20662g.m(aVar);
        this.f20662g.n(ListUtils.isEmpty(b2), G0());
    }

    public void M0(d.a.j0.i2.e.a aVar) {
        if (aVar != null && this.f20661f != null && isAdded()) {
            L0(aVar);
        } else if (aVar != null) {
            this.j = aVar;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        a aVar = this.f20661f;
        if (aVar != null) {
            aVar.i(i2);
        }
        b bVar = this.f20662g;
        if (bVar != null) {
            bVar.r(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        J0(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        a aVar = new a(getPageContext(), inflate, this);
        this.f20661f = aVar;
        aVar.m(1011);
        b bVar = new b(getPageContext(), this.f20664i);
        this.f20662g = bVar;
        this.f20661f.d(bVar.o());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a aVar = this.f20661f;
        if (aVar != null) {
            aVar.j();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        d.a.j0.i2.e.a aVar;
        super.onResume();
        if (this.f20661f == null || this.f20662g == null || (aVar = this.j) == null) {
            return;
        }
        L0(aVar);
        this.j = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("uid", this.f20663h);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, this.f20664i);
    }
}
