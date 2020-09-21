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
/* loaded from: classes23.dex */
public class PersonCenterMainTabFragment extends PersonCenterTabBaseFragment {
    private boolean isHost = false;
    private b lxD;
    private com.baidu.tieba.personPolymeric.c.a lxE;
    private com.baidu.tieba.personPolymeric.tab.view.a lxu;
    private User lxw;
    private long mUserId;

    public static PersonCenterMainTabFragment n(long j, boolean z) {
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
        this.lxu = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.lxu.setSubType(1011);
        this.lxD = new b(getPageContext(), this.isHost);
        this.lxu.addHeaderView(this.lxD.getView());
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
        if (aVar != null && this.lxu != null && isAdded()) {
            f(aVar);
        } else if (aVar != null) {
            this.lxE = aVar;
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
    public void uV(boolean z) {
        coM();
    }

    public void coM() {
        if (this.lxu != null && isAdded()) {
            this.lxu.coM();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void d(User user) {
        this.lxw = user;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lxu != null) {
            this.lxu.onChangeSkinType(i);
        }
        if (this.lxD != null) {
            this.lxD.onChangeSkinType(i);
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
        if (this.lxu != null && this.lxD != null && this.lxE != null) {
            f(this.lxE);
            this.lxE = null;
        }
    }

    private void f(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.lxu != null && this.lxD != null && aVar != null) {
            List<q> eY = com.baidu.tieba.personPolymeric.tab.b.a.eY(aVar.getNewestThreadList());
            if (!y.isEmpty(eY)) {
                this.lxu.FX(R.string.person_center_tab_main_footer_text);
            }
            this.lxu.eZ(eY);
            this.lxD.b(aVar);
            this.lxD.av(y.isEmpty(eY), isHost());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.lxu != null) {
            this.lxu.onDestroy();
        }
    }
}
