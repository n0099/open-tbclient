package com.baidu.tieba.personPolymeric.tab.fragments;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.view.l;
import tbclient.User;
/* loaded from: classes11.dex */
public abstract class PersonCenterTabBaseFragment extends BaseFragment {
    private l jqH;

    public abstract void b(User user);

    public abstract int getTabType();

    public abstract boolean isHost();

    public abstract void rx(boolean z);

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.jqH == null) {
            this.jqH = new l(getPageContext().getPageActivity(), getNetRefreshListener());
            this.jqH.setTitle(getPageContext().getResources().getString(R.string.refresh_view_title_text));
            this.jqH.setSubText(null);
            this.jqH.setButtonText(getPageContext().getResources().getString(R.string.refresh_view_button_text));
            this.jqH.showRefreshButton();
            this.jqH.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.jqH.onChangeSkinType();
        this.jqH.attachView(view, z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        if (this.jqH != null) {
            this.jqH.dettachView(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jqH != null) {
            this.jqH.onChangeSkinType();
        }
    }
}
