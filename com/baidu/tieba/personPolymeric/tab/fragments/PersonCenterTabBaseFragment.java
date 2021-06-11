package com.baidu.tieba.personPolymeric.tab.fragments;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.R;
import d.a.n0.j2.j.l;
import tbclient.User;
/* loaded from: classes5.dex */
public abstract class PersonCenterTabBaseFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public l f19952e;

    public abstract void G0(boolean z);

    public abstract int H0();

    public abstract boolean I0();

    public void J0(MetaData metaData) {
    }

    public abstract void K0(User user);

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        l lVar = this.f19952e;
        if (lVar != null) {
            lVar.dettachView(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        l lVar = this.f19952e;
        if (lVar != null) {
            lVar.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.f19952e == null) {
            l lVar = new l(getPageContext().getPageActivity(), getNetRefreshListener());
            this.f19952e = lVar;
            lVar.e(getPageContext().getResources().getString(R.string.refresh_view_title_text));
            this.f19952e.d(null);
            this.f19952e.c(getPageContext().getResources().getString(R.string.refresh_view_button_text));
            this.f19952e.f();
            this.f19952e.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.f19952e.onChangeSkinType();
        this.f19952e.attachView(view, z);
    }
}
