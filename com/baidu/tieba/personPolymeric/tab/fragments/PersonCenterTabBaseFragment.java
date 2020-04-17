package com.baidu.tieba.personPolymeric.tab.fragments;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.view.l;
import tbclient.User;
/* loaded from: classes11.dex */
public abstract class PersonCenterTabBaseFragment extends BaseFragment {
    private l kcw;

    public abstract void d(User user);

    public abstract int getTabType();

    public abstract boolean isHost();

    public abstract void sH(boolean z);

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.kcw == null) {
            this.kcw = new l(getPageContext().getPageActivity(), getNetRefreshListener());
            this.kcw.setTitle(getPageContext().getResources().getString(R.string.refresh_view_title_text));
            this.kcw.setSubText(null);
            this.kcw.setButtonText(getPageContext().getResources().getString(R.string.refresh_view_button_text));
            this.kcw.showRefreshButton();
            this.kcw.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.kcw.onChangeSkinType();
        this.kcw.attachView(view, z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        if (this.kcw != null) {
            this.kcw.dettachView(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kcw != null) {
            this.kcw.onChangeSkinType();
        }
    }
}
