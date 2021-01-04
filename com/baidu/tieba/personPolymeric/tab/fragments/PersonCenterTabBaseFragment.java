package com.baidu.tieba.personPolymeric.tab.fragments;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.view.l;
import tbclient.User;
/* loaded from: classes8.dex */
public abstract class PersonCenterTabBaseFragment extends BaseFragment {
    private l mze;

    public abstract void d(User user);

    public abstract int getTabType();

    public abstract boolean isHost();

    public abstract void wK(boolean z);

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.mze == null) {
            this.mze = new l(getPageContext().getPageActivity(), getNetRefreshListener());
            this.mze.setTitle(getPageContext().getResources().getString(R.string.refresh_view_title_text));
            this.mze.setSubText(null);
            this.mze.setButtonText(getPageContext().getResources().getString(R.string.refresh_view_button_text));
            this.mze.showRefreshButton();
            this.mze.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mze.onChangeSkinType();
        this.mze.attachView(view, z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        if (this.mze != null) {
            this.mze.dettachView(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mze != null) {
            this.mze.onChangeSkinType();
        }
    }

    public void a(MetaData metaData) {
    }
}
