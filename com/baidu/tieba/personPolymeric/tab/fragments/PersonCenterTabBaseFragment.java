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
    private l mfJ;

    public abstract void d(User user);

    public abstract int getTabType();

    public abstract boolean isHost();

    public abstract void wf(boolean z);

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.mfJ == null) {
            this.mfJ = new l(getPageContext().getPageActivity(), getNetRefreshListener());
            this.mfJ.setTitle(getPageContext().getResources().getString(R.string.refresh_view_title_text));
            this.mfJ.setSubText(null);
            this.mfJ.setButtonText(getPageContext().getResources().getString(R.string.refresh_view_button_text));
            this.mfJ.showRefreshButton();
            this.mfJ.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mfJ.onChangeSkinType();
        this.mfJ.attachView(view, z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        if (this.mfJ != null) {
            this.mfJ.dettachView(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mfJ != null) {
            this.mfJ.onChangeSkinType();
        }
    }

    public void a(MetaData metaData) {
    }
}
