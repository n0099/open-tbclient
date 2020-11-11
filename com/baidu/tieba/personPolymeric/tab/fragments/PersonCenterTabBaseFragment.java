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
    private l mfr;

    public abstract void d(User user);

    public abstract int getTabType();

    public abstract boolean isHost();

    public abstract void wc(boolean z);

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.mfr == null) {
            this.mfr = new l(getPageContext().getPageActivity(), getNetRefreshListener());
            this.mfr.setTitle(getPageContext().getResources().getString(R.string.refresh_view_title_text));
            this.mfr.setSubText(null);
            this.mfr.setButtonText(getPageContext().getResources().getString(R.string.refresh_view_button_text));
            this.mfr.showRefreshButton();
            this.mfr.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mfr.onChangeSkinType();
        this.mfr.attachView(view, z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        if (this.mfr != null) {
            this.mfr.dettachView(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mfr != null) {
            this.mfr.onChangeSkinType();
        }
    }

    public void a(MetaData metaData) {
    }
}
