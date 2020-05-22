package com.baidu.tieba.personPolymeric.tab.fragments;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.view.l;
import tbclient.User;
/* loaded from: classes11.dex */
public abstract class PersonCenterTabBaseFragment extends BaseFragment {
    private l kus;

    public abstract void d(User user);

    public abstract int getTabType();

    public abstract boolean isHost();

    public abstract void tf(boolean z);

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.kus == null) {
            this.kus = new l(getPageContext().getPageActivity(), getNetRefreshListener());
            this.kus.setTitle(getPageContext().getResources().getString(R.string.refresh_view_title_text));
            this.kus.setSubText(null);
            this.kus.setButtonText(getPageContext().getResources().getString(R.string.refresh_view_button_text));
            this.kus.showRefreshButton();
            this.kus.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.kus.onChangeSkinType();
        this.kus.attachView(view, z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        if (this.kus != null) {
            this.kus.dettachView(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kus != null) {
            this.kus.onChangeSkinType();
        }
    }
}
