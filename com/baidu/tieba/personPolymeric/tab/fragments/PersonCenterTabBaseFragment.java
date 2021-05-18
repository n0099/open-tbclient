package com.baidu.tieba.personPolymeric.tab.fragments;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.R;
import d.a.k0.i2.j.l;
import tbclient.User;
/* loaded from: classes5.dex */
public abstract class PersonCenterTabBaseFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public l f19953e;

    public abstract void D0(boolean z);

    public abstract int E0();

    public abstract boolean F0();

    public void G0(MetaData metaData) {
    }

    public abstract void H0(User user);

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        l lVar = this.f19953e;
        if (lVar != null) {
            lVar.dettachView(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        l lVar = this.f19953e;
        if (lVar != null) {
            lVar.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.f19953e == null) {
            l lVar = new l(getPageContext().getPageActivity(), getNetRefreshListener());
            this.f19953e = lVar;
            lVar.e(getPageContext().getResources().getString(R.string.refresh_view_title_text));
            this.f19953e.d(null);
            this.f19953e.c(getPageContext().getResources().getString(R.string.refresh_view_button_text));
            this.f19953e.f();
            this.f19953e.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.f19953e.onChangeSkinType();
        this.f19953e.attachView(view, z);
    }
}
