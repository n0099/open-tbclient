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
    private l mFU;

    public abstract void d(User user);

    public abstract int getTabType();

    public abstract boolean isHost();

    public abstract void wX(boolean z);

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.mFU == null) {
            this.mFU = new l(getPageContext().getPageActivity(), getNetRefreshListener());
            this.mFU.setTitle(getPageContext().getResources().getString(R.string.refresh_view_title_text));
            this.mFU.setSubText(null);
            this.mFU.setButtonText(getPageContext().getResources().getString(R.string.refresh_view_button_text));
            this.mFU.showRefreshButton();
            this.mFU.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mFU.onChangeSkinType();
        this.mFU.attachView(view, z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        if (this.mFU != null) {
            this.mFU.dettachView(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mFU != null) {
            this.mFU.onChangeSkinType();
        }
    }

    public void a(MetaData metaData) {
    }
}
