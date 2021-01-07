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
    private l mzd;

    public abstract void d(User user);

    public abstract int getTabType();

    public abstract boolean isHost();

    public abstract void wK(boolean z);

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.mzd == null) {
            this.mzd = new l(getPageContext().getPageActivity(), getNetRefreshListener());
            this.mzd.setTitle(getPageContext().getResources().getString(R.string.refresh_view_title_text));
            this.mzd.setSubText(null);
            this.mzd.setButtonText(getPageContext().getResources().getString(R.string.refresh_view_button_text));
            this.mzd.showRefreshButton();
            this.mzd.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mzd.onChangeSkinType();
        this.mzd.attachView(view, z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        if (this.mzd != null) {
            this.mzd.dettachView(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mzd != null) {
            this.mzd.onChangeSkinType();
        }
    }

    public void a(MetaData metaData) {
    }
}
