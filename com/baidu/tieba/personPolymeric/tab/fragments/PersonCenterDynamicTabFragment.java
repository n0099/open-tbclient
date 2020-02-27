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
/* loaded from: classes11.dex */
public class PersonCenterDynamicTabFragment extends PersonCenterTabBaseFragment implements BdListView.e, a {
    private com.baidu.tieba.personPolymeric.tab.view.a jqi;
    private PersonCenterDynamicTabModel jqj;
    private User jqk;
    private com.baidu.tieba.personPolymeric.tab.a.a jqm;
    private b jqn;
    private long mUserId;
    private static boolean jqo = true;
    private static CustomMessageListener cXD = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterDynamicTabFragment.jqo = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean jql = false;
    private boolean mHasInit = false;
    private List<m> mDataList = new ArrayList();
    private PersonCenterDynamicTabModel.a jqp = new PersonCenterDynamicTabModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void c(List<bj> list, boolean z, boolean z2) {
            PersonCenterDynamicTabFragment.this.g(list, z, z2);
        }

        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void ry(boolean z) {
            PersonCenterDynamicTabFragment.this.rw(z);
        }
    };

    public static PersonCenterDynamicTabFragment i(long j, boolean z) {
        PersonCenterDynamicTabFragment personCenterDynamicTabFragment = new PersonCenterDynamicTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterDynamicTabFragment.setArguments(bundle);
        personCenterDynamicTabFragment.registerListener(cXD);
        return personCenterDynamicTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.jqj = new PersonCenterDynamicTabModel(getPageContext(), this.mUserId);
        this.jqj.a(this.jqp);
        this.jqm = new com.baidu.tieba.personPolymeric.tab.a.a(getPageContext());
        this.jqn = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.jqi = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.jqi.b(this);
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
    public void rw(boolean z) {
        this.jql = false;
        hideNetRefreshView(this.jqi.getRootView());
        hideLoadingView(this.jqi.getRootView());
        this.jqi.bdr();
        if (z) {
            showNetRefreshView(this.jqi.getRootView(), null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(List<bj> list, boolean z, boolean z2) {
        this.jql = false;
        hideNetRefreshView(this.jqi.getRootView());
        hideLoadingView(this.jqi.getRootView());
        if (z) {
            this.jqi.bdp();
        } else {
            this.jqi.bdq();
        }
        this.mDataList = com.baidu.tieba.personPolymeric.tab.b.a.dT(list);
        this.jqi.dV(this.mDataList);
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void rx(boolean z) {
        if (this.jqj != null && this.jqi != null && this.mHasInit && !this.jql) {
            hideNetRefreshView(this.jqi.getRootView());
            if (j.isNetWorkAvailable()) {
                this.jql = true;
                if (z && jqo) {
                    showLoadingView(this.jqi.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                this.jqj.AA();
                scrollToTop();
                return;
            }
            showNetRefreshView(this.jqi.getRootView(), null, false);
        }
    }

    public void scrollToTop() {
        if (this.jqi != null && this.mHasInit) {
            this.jqi.scrollToTop();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void b(User user) {
        this.jqk = user;
        if (this.jqj != null) {
            this.jqj.b(this.jqk);
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
        if (this.jqj != null && this.mHasInit && !this.jql && j.isNetWorkAvailable() && this.jqj.isHasMore()) {
            this.jql = true;
            this.jqj.bcD();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jqi != null) {
            this.jqi.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && !this.mHasInit) {
            this.mHasInit = true;
            rx(true);
            if (TbSingleton.getInstance().isShowShoubaiDynamicGuide() && this.jqm != null && !this.jqm.cxD() && this.isHost) {
                this.jqm.cxC();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        rx(true);
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
        this.jql = false;
        if (this.jqj != null) {
            this.jqj.onDestroy();
        }
        if (this.jqi != null) {
            this.jqi.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a cxE() {
        return this.jqi;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<m> ceM() {
        return this.mDataList;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean cxF() {
        return this.isHost && isPrimary() && !this.jql;
    }
}
