package com.baidu.tieba.personPolymeric.tab.fragments;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.view.l;
import tbclient.User;
/* loaded from: classes18.dex */
public abstract class PersonCenterTabBaseFragment extends BaseFragment {
    private l kYr;

    public abstract void d(User user);

    public abstract int getTabType();

    public abstract boolean isHost();

    public abstract void tZ(boolean z);

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.kYr == null) {
            this.kYr = new l(getPageContext().getPageActivity(), getNetRefreshListener());
            this.kYr.setTitle(getPageContext().getResources().getString(R.string.refresh_view_title_text));
            this.kYr.setSubText(null);
            this.kYr.setButtonText(getPageContext().getResources().getString(R.string.refresh_view_button_text));
            this.kYr.showRefreshButton();
            this.kYr.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.kYr.onChangeSkinType();
        this.kYr.attachView(view, z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        if (this.kYr != null) {
            this.kYr.dettachView(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kYr != null) {
            this.kYr.onChangeSkinType();
        }
    }
}
