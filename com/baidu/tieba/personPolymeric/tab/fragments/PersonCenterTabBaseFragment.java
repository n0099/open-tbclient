package com.baidu.tieba.personPolymeric.tab.fragments;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.view.l;
import tbclient.User;
/* loaded from: classes9.dex */
public abstract class PersonCenterTabBaseFragment extends BaseFragment {
    private l jpx;

    public abstract void b(User user);

    public abstract int getTabType();

    public abstract boolean isHost();

    public abstract void ru(boolean z);

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.jpx == null) {
            this.jpx = new l(getPageContext().getPageActivity(), getNetRefreshListener());
            this.jpx.setTitle(getPageContext().getResources().getString(R.string.refresh_view_title_text));
            this.jpx.setSubText(null);
            this.jpx.setButtonText(getPageContext().getResources().getString(R.string.refresh_view_button_text));
            this.jpx.showRefreshButton();
            this.jpx.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.jpx.onChangeSkinType();
        this.jpx.attachView(view, z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        if (this.jpx != null) {
            this.jpx.dettachView(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jpx != null) {
            this.jpx.onChangeSkinType();
        }
    }
}
