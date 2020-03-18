package com.baidu.tieba.personPolymeric.tab.fragments;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.view.l;
import tbclient.User;
/* loaded from: classes11.dex */
public abstract class PersonCenterTabBaseFragment extends BaseFragment {
    private l jsg;

    public abstract void b(User user);

    public abstract int getTabType();

    public abstract boolean isHost();

    public abstract void rD(boolean z);

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.jsg == null) {
            this.jsg = new l(getPageContext().getPageActivity(), getNetRefreshListener());
            this.jsg.setTitle(getPageContext().getResources().getString(R.string.refresh_view_title_text));
            this.jsg.setSubText(null);
            this.jsg.setButtonText(getPageContext().getResources().getString(R.string.refresh_view_button_text));
            this.jsg.showRefreshButton();
            this.jsg.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.jsg.onChangeSkinType();
        this.jsg.attachView(view, z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        if (this.jsg != null) {
            this.jsg.dettachView(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jsg != null) {
            this.jsg.onChangeSkinType();
        }
    }
}
