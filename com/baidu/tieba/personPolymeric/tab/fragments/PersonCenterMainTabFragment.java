package com.baidu.tieba.personPolymeric.tab.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.tab.view.b;
import java.util.List;
import tbclient.User;
/* loaded from: classes24.dex */
public class PersonCenterMainTabFragment extends PersonCenterTabBaseFragment {
    private boolean isHost = false;
    private long mUserId;
    private com.baidu.tieba.personPolymeric.tab.view.a mtG;
    private User mtI;
    private b mtP;
    private com.baidu.tieba.personPolymeric.c.a mtQ;

    public static PersonCenterMainTabFragment o(long j, boolean z) {
        PersonCenterMainTabFragment personCenterMainTabFragment = new PersonCenterMainTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterMainTabFragment.setArguments(bundle);
        return personCenterMainTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.mtG = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.mtG.setSubType(1011);
        this.mtP = new b(getPageContext(), this.isHost);
        this.mtG.addHeaderView(this.mtP.getView());
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
        if (aVar != null && this.mtG != null && isAdded()) {
            f(aVar);
        } else if (aVar != null) {
            this.mtQ = aVar;
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
    public void wJ(boolean z) {
        cBM();
    }

    public void cBM() {
        if (this.mtG != null && isAdded()) {
            this.mtG.cBM();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void d(User user) {
        this.mtI = user;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mtG != null) {
            this.mtG.onChangeSkinType(i);
        }
        if (this.mtP != null) {
            this.mtP.onChangeSkinType(i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("uid", this.mUserId);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, this.isHost);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.mtG != null && this.mtP != null && this.mtQ != null) {
            f(this.mtQ);
            this.mtQ = null;
        }
    }

    private void f(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.mtG != null && this.mtP != null && aVar != null) {
            List<q> fE = com.baidu.tieba.personPolymeric.tab.b.a.fE(aVar.getNewestThreadList());
            if (!y.isEmpty(fE)) {
                this.mtG.Iy(R.string.person_center_tab_main_footer_text);
            }
            this.mtG.fF(fE);
            this.mtP.b(aVar);
            this.mtP.au(y.isEmpty(fE), isHost());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mtG != null) {
            this.mtG.onDestroy();
        }
    }
}
