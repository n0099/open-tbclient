package com.baidu.tieba.personPolymeric.tab.fragments;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.view.l;
import tbclient.User;
/* loaded from: classes11.dex */
public abstract class PersonCenterTabBaseFragment extends BaseFragment {
    private l jqt;

    public abstract void b(User user);

    public abstract int getTabType();

    public abstract boolean isHost();

    public abstract void rx(boolean z);

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.jqt == null) {
            this.jqt = new l(getPageContext().getPageActivity(), getNetRefreshListener());
            this.jqt.setTitle(getPageContext().getResources().getString(R.string.refresh_view_title_text));
            this.jqt.setSubText(null);
            this.jqt.setButtonText(getPageContext().getResources().getString(R.string.refresh_view_button_text));
            this.jqt.showRefreshButton();
            this.jqt.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.jqt.onChangeSkinType();
        this.jqt.attachView(view, z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        if (this.jqt != null) {
            this.jqt.dettachView(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jqt != null) {
            this.jqt.onChangeSkinType();
        }
    }
}
