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
/* loaded from: classes18.dex */
public class PersonCenterMainTabFragment extends PersonCenterTabBaseFragment {
    private boolean isHost = false;
    private b loA;
    private com.baidu.tieba.personPolymeric.c.a loB;
    private com.baidu.tieba.personPolymeric.tab.view.a loq;
    private User los;
    private long mUserId;

    public static PersonCenterMainTabFragment l(long j, boolean z) {
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
        this.loq = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.loq.setSubType(1011);
        this.loA = new b(getPageContext(), this.isHost);
        this.loq.addHeaderView(this.loA.getView());
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
        if (aVar != null && this.loq != null && isAdded()) {
            f(aVar);
        } else if (aVar != null) {
            this.loB = aVar;
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
    public void uL(boolean z) {
        clz();
    }

    public void clz() {
        if (this.loq != null && isAdded()) {
            this.loq.clz();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void d(User user) {
        this.los = user;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.loq != null) {
            this.loq.onChangeSkinType(i);
        }
        if (this.loA != null) {
            this.loA.onChangeSkinType(i);
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
        if (this.loq != null && this.loA != null && this.loB != null) {
            f(this.loB);
            this.loB = null;
        }
    }

    private void f(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.loq != null && this.loA != null && aVar != null) {
            List<q> eQ = com.baidu.tieba.personPolymeric.tab.b.a.eQ(aVar.getNewestThreadList());
            if (!y.isEmpty(eQ)) {
                this.loq.Fw(R.string.person_center_tab_main_footer_text);
            }
            this.loq.eR(eQ);
            this.loA.b(aVar);
            this.loA.at(y.isEmpty(eQ), isHost());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.loq != null) {
            this.loq.onDestroy();
        }
    }
}
