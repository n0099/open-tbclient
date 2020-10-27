package com.baidu.tieba.personPolymeric.tab.fragments;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.view.l;
import tbclient.User;
/* loaded from: classes24.dex */
public abstract class PersonCenterTabBaseFragment extends BaseFragment {
    private l lZr;

    public abstract void d(User user);

    public abstract int getTabType();

    public abstract boolean isHost();

    public abstract void vT(boolean z);

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.lZr == null) {
            this.lZr = new l(getPageContext().getPageActivity(), getNetRefreshListener());
            this.lZr.setTitle(getPageContext().getResources().getString(R.string.refresh_view_title_text));
            this.lZr.setSubText(null);
            this.lZr.setButtonText(getPageContext().getResources().getString(R.string.refresh_view_button_text));
            this.lZr.showRefreshButton();
            this.lZr.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.lZr.onChangeSkinType();
        this.lZr.attachView(view, z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        if (this.lZr != null) {
            this.lZr.dettachView(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lZr != null) {
            this.lZr.onChangeSkinType();
        }
    }

    public void a(MetaData metaData) {
    }
}
