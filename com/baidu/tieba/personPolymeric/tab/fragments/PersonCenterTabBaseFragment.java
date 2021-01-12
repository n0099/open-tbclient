package com.baidu.tieba.personPolymeric.tab.fragments;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.view.l;
import tbclient.User;
/* loaded from: classes7.dex */
public abstract class PersonCenterTabBaseFragment extends BaseFragment {
    private l muz;

    public abstract void d(User user);

    public abstract int getTabType();

    public abstract boolean isHost();

    public abstract void wG(boolean z);

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.muz == null) {
            this.muz = new l(getPageContext().getPageActivity(), getNetRefreshListener());
            this.muz.setTitle(getPageContext().getResources().getString(R.string.refresh_view_title_text));
            this.muz.setSubText(null);
            this.muz.setButtonText(getPageContext().getResources().getString(R.string.refresh_view_button_text));
            this.muz.showRefreshButton();
            this.muz.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.muz.onChangeSkinType();
        this.muz.attachView(view, z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        if (this.muz != null) {
            this.muz.dettachView(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.muz != null) {
            this.muz.onChangeSkinType();
        }
    }

    public void a(MetaData metaData) {
    }
}
