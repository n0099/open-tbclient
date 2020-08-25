package com.baidu.tieba.personPolymeric.tab.fragments;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.view.l;
import tbclient.User;
/* loaded from: classes18.dex */
public abstract class PersonCenterTabBaseFragment extends BaseFragment {
    private l loC;

    public abstract void d(User user);

    public abstract int getTabType();

    public abstract boolean isHost();

    public abstract void uL(boolean z);

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.loC == null) {
            this.loC = new l(getPageContext().getPageActivity(), getNetRefreshListener());
            this.loC.setTitle(getPageContext().getResources().getString(R.string.refresh_view_title_text));
            this.loC.setSubText(null);
            this.loC.setButtonText(getPageContext().getResources().getString(R.string.refresh_view_button_text));
            this.loC.showRefreshButton();
            this.loC.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.loC.onChangeSkinType();
        this.loC.attachView(view, z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        if (this.loC != null) {
            this.loC.dettachView(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.loC != null) {
            this.loC.onChangeSkinType();
        }
    }
}
