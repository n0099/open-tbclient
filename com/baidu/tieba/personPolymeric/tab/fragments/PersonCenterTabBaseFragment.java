package com.baidu.tieba.personPolymeric.tab.fragments;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.view.l;
import tbclient.User;
/* loaded from: classes8.dex */
public abstract class PersonCenterTabBaseFragment extends BaseFragment {
    private l jlP;

    public abstract void b(User user);

    public abstract int getTabType();

    public abstract boolean isHost();

    public abstract void rh(boolean z);

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.jlP == null) {
            this.jlP = new l(getPageContext().getPageActivity(), getNetRefreshListener());
            this.jlP.setTitle(getPageContext().getResources().getString(R.string.refresh_view_title_text));
            this.jlP.setSubText(null);
            this.jlP.setButtonText(getPageContext().getResources().getString(R.string.refresh_view_button_text));
            this.jlP.showRefreshButton();
            this.jlP.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.jlP.onChangeSkinType();
        this.jlP.attachView(view, z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        if (this.jlP != null) {
            this.jlP.dettachView(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jlP != null) {
            this.jlP.onChangeSkinType();
        }
    }
}
