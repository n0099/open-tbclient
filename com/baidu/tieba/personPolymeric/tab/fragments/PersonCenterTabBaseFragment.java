package com.baidu.tieba.personPolymeric.tab.fragments;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.view.l;
import tbclient.User;
/* loaded from: classes18.dex */
public abstract class PersonCenterTabBaseFragment extends BaseFragment {
    private l loN;

    public abstract void d(User user);

    public abstract int getTabType();

    public abstract boolean isHost();

    public abstract void uN(boolean z);

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.loN == null) {
            this.loN = new l(getPageContext().getPageActivity(), getNetRefreshListener());
            this.loN.setTitle(getPageContext().getResources().getString(R.string.refresh_view_title_text));
            this.loN.setSubText(null);
            this.loN.setButtonText(getPageContext().getResources().getString(R.string.refresh_view_button_text));
            this.loN.showRefreshButton();
            this.loN.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.loN.onChangeSkinType();
        this.loN.attachView(view, z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        if (this.loN != null) {
            this.loN.dettachView(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.loN != null) {
            this.loN.onChangeSkinType();
        }
    }
}
