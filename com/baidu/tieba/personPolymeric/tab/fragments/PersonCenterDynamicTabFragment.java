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
    private com.baidu.tieba.personPolymeric.tab.a.a jqA;
    private b jqB;
    private com.baidu.tieba.personPolymeric.tab.view.a jqw;
    private PersonCenterDynamicTabModel jqx;
    private User jqy;
    private long mUserId;
    private static boolean jqC = true;
    private static CustomMessageListener cXF = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterDynamicTabFragment.jqC = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean jqz = false;
    private boolean mHasInit = false;
    private List<m> mDataList = new ArrayList();
    private PersonCenterDynamicTabModel.a jqD = new PersonCenterDynamicTabModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.2
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
        personCenterDynamicTabFragment.registerListener(cXF);
        return personCenterDynamicTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.jqx = new PersonCenterDynamicTabModel(getPageContext(), this.mUserId);
        this.jqx.a(this.jqD);
        this.jqA = new com.baidu.tieba.personPolymeric.tab.a.a(getPageContext());
        this.jqB = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.jqw = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.jqw.b(this);
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
        this.jqz = false;
        hideNetRefreshView(this.jqw.getRootView());
        hideLoadingView(this.jqw.getRootView());
        this.jqw.bdu();
        if (z) {
            showNetRefreshView(this.jqw.getRootView(), null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(List<bj> list, boolean z, boolean z2) {
        this.jqz = false;
        hideNetRefreshView(this.jqw.getRootView());
        hideLoadingView(this.jqw.getRootView());
        if (z) {
            this.jqw.bds();
        } else {
            this.jqw.bdt();
        }
        this.mDataList = com.baidu.tieba.personPolymeric.tab.b.a.dT(list);
        this.jqw.dV(this.mDataList);
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void rx(boolean z) {
        if (this.jqx != null && this.jqw != null && this.mHasInit && !this.jqz) {
            hideNetRefreshView(this.jqw.getRootView());
            if (j.isNetWorkAvailable()) {
                this.jqz = true;
                if (z && jqC) {
                    showLoadingView(this.jqw.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                this.jqx.AC();
                scrollToTop();
                return;
            }
            showNetRefreshView(this.jqw.getRootView(), null, false);
        }
    }

    public void scrollToTop() {
        if (this.jqw != null && this.mHasInit) {
            this.jqw.scrollToTop();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void b(User user) {
        this.jqy = user;
        if (this.jqx != null) {
            this.jqx.b(this.jqy);
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
        if (this.jqx != null && this.mHasInit && !this.jqz && j.isNetWorkAvailable() && this.jqx.isHasMore()) {
            this.jqz = true;
            this.jqx.bcG();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jqw != null) {
            this.jqw.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && !this.mHasInit) {
            this.mHasInit = true;
            rx(true);
            if (TbSingleton.getInstance().isShowShoubaiDynamicGuide() && this.jqA != null && !this.jqA.cxG() && this.isHost) {
                this.jqA.cxF();
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
        this.jqz = false;
        if (this.jqx != null) {
            this.jqx.onDestroy();
        }
        if (this.jqw != null) {
            this.jqw.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a cxH() {
        return this.jqw;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<m> ceP() {
        return this.mDataList;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean cxI() {
        return this.isHost && isPrimary() && !this.jqz;
    }
}
