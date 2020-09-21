package com.baidu.tieba.personPolymeric.tab.fragments;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.view.l;
import tbclient.User;
/* loaded from: classes23.dex */
public abstract class PersonCenterTabBaseFragment extends BaseFragment {
    private l lxF;

    public abstract void d(User user);

    public abstract int getTabType();

    public abstract boolean isHost();

    public abstract void uV(boolean z);

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.lxF == null) {
            this.lxF = new l(getPageContext().getPageActivity(), getNetRefreshListener());
            this.lxF.setTitle(getPageContext().getResources().getString(R.string.refresh_view_title_text));
            this.lxF.setSubText(null);
            this.lxF.setButtonText(getPageContext().getResources().getString(R.string.refresh_view_button_text));
            this.lxF.showRefreshButton();
            this.lxF.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.lxF.onChangeSkinType();
        this.lxF.attachView(view, z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        if (this.lxF != null) {
            this.lxF.dettachView(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lxF != null) {
            this.lxF.onChangeSkinType();
        }
    }

    public void a(MetaData metaData) {
    }
}
