package com.baidu.tieba.personPolymeric.tab.fragments;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.view.l;
import tbclient.User;
/* loaded from: classes11.dex */
public abstract class PersonCenterTabBaseFragment extends BaseFragment {
    private l jqv;

    public abstract void b(User user);

    public abstract int getTabType();

    public abstract boolean isHost();

    public abstract void rx(boolean z);

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.jqv == null) {
            this.jqv = new l(getPageContext().getPageActivity(), getNetRefreshListener());
            this.jqv.setTitle(getPageContext().getResources().getString(R.string.refresh_view_title_text));
            this.jqv.setSubText(null);
            this.jqv.setButtonText(getPageContext().getResources().getString(R.string.refresh_view_button_text));
            this.jqv.showRefreshButton();
            this.jqv.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.jqv.onChangeSkinType();
        this.jqv.attachView(view, z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        if (this.jqv != null) {
            this.jqv.dettachView(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jqv != null) {
            this.jqv.onChangeSkinType();
        }
    }
}
