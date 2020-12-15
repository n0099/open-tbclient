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
    private l mtR;

    public abstract void d(User user);

    public abstract int getTabType();

    public abstract boolean isHost();

    public abstract void wJ(boolean z);

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.mtR == null) {
            this.mtR = new l(getPageContext().getPageActivity(), getNetRefreshListener());
            this.mtR.setTitle(getPageContext().getResources().getString(R.string.refresh_view_title_text));
            this.mtR.setSubText(null);
            this.mtR.setButtonText(getPageContext().getResources().getString(R.string.refresh_view_button_text));
            this.mtR.showRefreshButton();
            this.mtR.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mtR.onChangeSkinType();
        this.mtR.attachView(view, z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        if (this.mtR != null) {
            this.mtR.dettachView(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mtR != null) {
            this.mtR.onChangeSkinType();
        }
    }

    public void a(MetaData metaData) {
    }
}
