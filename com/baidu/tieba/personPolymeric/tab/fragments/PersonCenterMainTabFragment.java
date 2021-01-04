package com.baidu.tieba.personPolymeric.tab.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.tab.view.b;
import java.util.List;
import tbclient.User;
/* loaded from: classes8.dex */
public class PersonCenterMainTabFragment extends PersonCenterTabBaseFragment {
    private boolean isHost = false;
    private long mUserId;
    private com.baidu.tieba.personPolymeric.tab.view.a myT;
    private User myV;
    private b mzc;
    private com.baidu.tieba.personPolymeric.c.a mzd;

    public static PersonCenterMainTabFragment p(long j, boolean z) {
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
        this.myT = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.myT.setSubType(1011);
        this.mzc = new b(getPageContext(), this.isHost);
        this.myT.addHeaderView(this.mzc.getView());
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
        if (aVar != null && this.myT != null && isAdded()) {
            f(aVar);
        } else if (aVar != null) {
            this.mzd = aVar;
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
    public void wK(boolean z) {
        cEF();
    }

    public void cEF() {
        if (this.myT != null && isAdded()) {
            this.myT.cEF();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void d(User user) {
        this.myV = user;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.myT != null) {
            this.myT.onChangeSkinType(i);
        }
        if (this.mzc != null) {
            this.mzc.onChangeSkinType(i);
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
        if (this.myT != null && this.mzc != null && this.mzd != null) {
            f(this.mzd);
            this.mzd = null;
        }
    }

    private void f(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (this.myT != null && this.mzc != null && aVar != null) {
            List<n> fE = com.baidu.tieba.personPolymeric.tab.b.a.fE(aVar.getNewestThreadList());
            if (!x.isEmpty(fE)) {
                this.myT.Is(R.string.person_center_tab_main_footer_text);
            }
            this.myT.fF(fE);
            this.mzc.b(aVar);
            this.mzc.aw(x.isEmpty(fE), isHost());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.myT != null) {
            this.myT.onDestroy();
        }
    }
}
