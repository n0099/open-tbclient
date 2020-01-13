package com.baidu.tieba.personPolymeric.tab.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.tab.a.b;
import com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes9.dex */
public class PersonCenterDynamicTabFragment extends PersonCenterTabBaseFragment implements BdListView.e, a {
    private com.baidu.tieba.personPolymeric.tab.view.a jph;
    private PersonCenterDynamicTabModel jpi;
    private User jpj;
    private com.baidu.tieba.personPolymeric.tab.a.a jpl;
    private b jpm;
    private long mUserId;
    private static boolean jpn = true;
    private static CustomMessageListener cTB = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterDynamicTabFragment.jpn = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean jpk = false;
    private boolean mHasInit = false;
    private List<m> mDataList = new ArrayList();
    private PersonCenterDynamicTabModel.a jpo = new PersonCenterDynamicTabModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void c(List<bj> list, boolean z, boolean z2) {
            PersonCenterDynamicTabFragment.this.g(list, z, z2);
        }

        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void rv(boolean z) {
            PersonCenterDynamicTabFragment.this.rt(z);
        }
    };

    public static PersonCenterDynamicTabFragment g(long j, boolean z) {
        PersonCenterDynamicTabFragment personCenterDynamicTabFragment = new PersonCenterDynamicTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterDynamicTabFragment.setArguments(bundle);
        personCenterDynamicTabFragment.registerListener(cTB);
        return personCenterDynamicTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.jpi = new PersonCenterDynamicTabModel(getPageContext(), this.mUserId);
        this.jpi.a(this.jpo);
        this.jpl = new com.baidu.tieba.personPolymeric.tab.a.a(getPageContext());
        this.jpm = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.jph = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.jph.b(this);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void rt(boolean z) {
        this.jpk = false;
        hideNetRefreshView(this.jph.getRootView());
        hideLoadingView(this.jph.getRootView());
        this.jph.bbc();
        if (z) {
            showNetRefreshView(this.jph.getRootView(), null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(List<bj> list, boolean z, boolean z2) {
        this.jpk = false;
        hideNetRefreshView(this.jph.getRootView());
        hideLoadingView(this.jph.getRootView());
        if (z) {
            this.jph.bba();
        } else {
            this.jph.bbb();
        }
        this.mDataList = com.baidu.tieba.personPolymeric.tab.b.a.dX(list);
        this.jph.dY(this.mDataList);
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void ru(boolean z) {
        if (this.jpi != null && this.jph != null && this.mHasInit && !this.jpk) {
            hideNetRefreshView(this.jph.getRootView());
            if (j.isNetWorkAvailable()) {
                this.jpk = true;
                if (z && jpn) {
                    showLoadingView(this.jph.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                this.jpi.yj();
                scrollToTop();
                return;
            }
            showNetRefreshView(this.jph.getRootView(), null, false);
        }
    }

    public void scrollToTop() {
        if (this.jph != null && this.mHasInit) {
            this.jph.scrollToTop();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void b(User user) {
        this.jpj = user;
        if (this.jpi != null) {
            this.jpi.b(this.jpj);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public int getTabType() {
        return 1;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public boolean isHost() {
        return this.isHost;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.jpi != null && this.mHasInit && !this.jpk && j.isNetWorkAvailable() && this.jpi.isHasMore()) {
            this.jpk = true;
            this.jpi.bao();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jph != null) {
            this.jph.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && !this.mHasInit) {
            this.mHasInit = true;
            ru(true);
            if (TbSingleton.getInstance().isShowShoubaiDynamicGuide() && this.jpl != null && !this.jpl.cwf() && this.isHost) {
                this.jpl.cwe();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        ru(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("uid", this.mUserId);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, this.isHost);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mHasInit = false;
        this.jpk = false;
        if (this.jpi != null) {
            this.jpi.onDestroy();
        }
        if (this.jph != null) {
            this.jph.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a cwg() {
        return this.jph;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<m> cdi() {
        return this.mDataList;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean cwh() {
        return this.isHost && isPrimary() && !this.jpk;
    }
}
