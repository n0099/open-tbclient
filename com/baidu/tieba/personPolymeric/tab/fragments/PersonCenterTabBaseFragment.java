package com.baidu.tieba.personPolymeric.tab.fragments;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.view.l;
import tbclient.User;
/* loaded from: classes11.dex */
public abstract class PersonCenterTabBaseFragment extends BaseFragment {
    private l kPv;

    public abstract void d(User user);

    public abstract int getTabType();

    public abstract boolean isHost();

    public abstract void tt(boolean z);

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.kPv == null) {
            this.kPv = new l(getPageContext().getPageActivity(), getNetRefreshListener());
            this.kPv.setTitle(getPageContext().getResources().getString(R.string.refresh_view_title_text));
            this.kPv.setSubText(null);
            this.kPv.setButtonText(getPageContext().getResources().getString(R.string.refresh_view_button_text));
            this.kPv.showRefreshButton();
            this.kPv.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.kPv.onChangeSkinType();
        this.kPv.attachView(view, z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        if (this.kPv != null) {
            this.kPv.dettachView(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kPv != null) {
            this.kPv.onChangeSkinType();
        }
    }
}
