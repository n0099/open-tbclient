package com.baidu.tieba.personPolymeric.tab.fragments;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.R;
import d.b.i0.h2.j.l;
import tbclient.User;
/* loaded from: classes5.dex */
public abstract class PersonCenterTabBaseFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public l f20447e;

    public abstract void E0(boolean z);

    public abstract int F0();

    public abstract boolean G0();

    public void H0(MetaData metaData) {
    }

    public abstract void I0(User user);

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        l lVar = this.f20447e;
        if (lVar != null) {
            lVar.dettachView(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        l lVar = this.f20447e;
        if (lVar != null) {
            lVar.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.f20447e == null) {
            l lVar = new l(getPageContext().getPageActivity(), getNetRefreshListener());
            this.f20447e = lVar;
            lVar.e(getPageContext().getResources().getString(R.string.refresh_view_title_text));
            this.f20447e.d(null);
            this.f20447e.c(getPageContext().getResources().getString(R.string.refresh_view_button_text));
            this.f20447e.f();
            this.f20447e.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.f20447e.onChangeSkinType();
        this.f20447e.attachView(view, z);
    }
}
