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
    private l mtP;

    public abstract void d(User user);

    public abstract int getTabType();

    public abstract boolean isHost();

    public abstract void wJ(boolean z);

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.mtP == null) {
            this.mtP = new l(getPageContext().getPageActivity(), getNetRefreshListener());
            this.mtP.setTitle(getPageContext().getResources().getString(R.string.refresh_view_title_text));
            this.mtP.setSubText(null);
            this.mtP.setButtonText(getPageContext().getResources().getString(R.string.refresh_view_button_text));
            this.mtP.showRefreshButton();
            this.mtP.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mtP.onChangeSkinType();
        this.mtP.attachView(view, z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        if (this.mtP != null) {
            this.mtP.dettachView(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mtP != null) {
            this.mtP.onChangeSkinType();
        }
    }

    public void a(MetaData metaData) {
    }
}
