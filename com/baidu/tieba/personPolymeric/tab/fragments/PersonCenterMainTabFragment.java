package com.baidu.tieba.personPolymeric.tab.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.tab.view.b;
import java.util.List;
import tbclient.User;
/* loaded from: classes8.dex */
public class PersonCenterMainTabFragment extends PersonCenterTabBaseFragment {
    private boolean isHost = false;
    private com.baidu.tieba.personPolymeric.tab.view.a mDH;
    private User mDJ;
    private b mDQ;
    private com.baidu.tieba.personPolymeric.c.a mDR;
    private long mUserId;

    public static PersonCenterMainTabFragment q(long j, boolean z) {
        PersonCenterMainTabFragment personCenterMainTabFragment = new PersonCenterMainTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterMainTabFragment.setArguments(bundle);
        return personCenterMainTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.mDH = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.mDH.setSubType(1011);
        this.mDQ = new b(getPageContext(), this.isHost);
        this.mDH.addHeaderView(this.mDQ.getView());
        return inflate;
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.mUserId = bundle.getLong("uid");
            this.isHost = bundle.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUserId = arguments.getLong("uid");
            this.isHost = arguments.getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
        }
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && this.mDH != null && isAdded()) {
            f(aVar);
        } else if (aVar != null) {
            this.mDR = aVar;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public int getTabType() {
        return 0;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public boolean isHost() {
        return this.isHost;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void wX(boolean z) {
        cCg();
    }

    public void cCg() {
        if (this.mDH != null && isAdded()) {
            this.mDH.cCg();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void d(User user) {
        this.mDJ = user;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mDH != null) {
            this.mDH.onChangeSkinType(i);
        }
        if (this.mDQ != null) {
            this.mDQ.onChangeSkinType(i);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("uid", this.mUserId);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, this.isHost);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.mDH != null && this.mDQ != null && this.mDR != null) {
            f(this.mDR);
            this.mDR = null;
        }
    }

    private void f(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.mDH != null && this.mDQ != null && aVar != null) {
            List<n> fC = com.baidu.tieba.personPolymeric.tab.b.a.fC(aVar.getNewestThreadList());
            if (!y.isEmpty(fC)) {
                this.mDH.Hd(R.string.person_center_tab_main_footer_text);
            }
            this.mDH.fD(fC);
            this.mDQ.b(aVar);
            this.mDQ.aw(y.isEmpty(fC), isHost());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mDH != null) {
            this.mDH.onDestroy();
        }
    }
}
