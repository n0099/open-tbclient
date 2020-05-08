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
    private com.baidu.tieba.personPolymeric.tab.view.a kcp;
    private PersonCenterDynamicTabModel kcq;
    private User kcr;
    private com.baidu.tieba.personPolymeric.tab.a.a kct;
    private b kcu;
    private long mUserId;
    private static boolean kcv = true;
    private static CustomMessageListener dxg = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterDynamicTabFragment.kcv = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean kcs = false;
    private boolean mHasInit = false;
    private List<m> mDataList = new ArrayList();
    private PersonCenterDynamicTabModel.a kcw = new PersonCenterDynamicTabModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void c(List<bj> list, boolean z, boolean z2) {
            PersonCenterDynamicTabFragment.this.g(list, z, z2);
        }

        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void sI(boolean z) {
            PersonCenterDynamicTabFragment.this.sG(z);
        }
    };

    public static PersonCenterDynamicTabFragment j(long j, boolean z) {
        PersonCenterDynamicTabFragment personCenterDynamicTabFragment = new PersonCenterDynamicTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterDynamicTabFragment.setArguments(bundle);
        personCenterDynamicTabFragment.registerListener(dxg);
        return personCenterDynamicTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.kcq = new PersonCenterDynamicTabModel(getPageContext(), this.mUserId);
        this.kcq.a(this.kcw);
        this.kct = new com.baidu.tieba.personPolymeric.tab.a.a(getPageContext());
        this.kcu = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.kcp = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.kcp.b(this);
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
    public void sG(boolean z) {
        this.kcs = false;
        hideNetRefreshView(this.kcp.getRootView());
        hideLoadingView(this.kcp.getRootView());
        this.kcp.bmo();
        if (z) {
            showNetRefreshView(this.kcp.getRootView(), null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(List<bj> list, boolean z, boolean z2) {
        this.kcs = false;
        hideNetRefreshView(this.kcp.getRootView());
        hideLoadingView(this.kcp.getRootView());
        if (z) {
            this.kcp.bmm();
        } else {
            this.kcp.bmn();
        }
        this.mDataList = com.baidu.tieba.personPolymeric.tab.b.a.ee(list);
        this.kcp.eg(this.mDataList);
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void sH(boolean z) {
        if (this.kcq != null && this.kcp != null && this.mHasInit && !this.kcs) {
            hideNetRefreshView(this.kcp.getRootView());
            if (j.isNetWorkAvailable()) {
                this.kcs = true;
                if (z && kcv) {
                    showLoadingView(this.kcp.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                this.kcq.FG();
                bOc();
                return;
            }
            showNetRefreshView(this.kcp.getRootView(), null, false);
        }
    }

    public void bOc() {
        if (this.kcp != null && this.mHasInit) {
            this.kcp.bOc();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void d(User user) {
        this.kcr = user;
        if (this.kcq != null) {
            this.kcq.d(this.kcr);
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
        if (this.kcq != null && this.mHasInit && !this.kcs && j.isNetWorkAvailable() && this.kcq.isHasMore()) {
            this.kcs = true;
            this.kcq.blz();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kcp != null) {
            this.kcp.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && !this.mHasInit) {
            this.mHasInit = true;
            sH(true);
            if (TbSingleton.getInstance().isShowShoubaiDynamicGuide() && this.kct != null && !this.kct.cIG() && this.isHost) {
                this.kct.cIF();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        sH(true);
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
        this.kcs = false;
        if (this.kcq != null) {
            this.kcq.onDestroy();
        }
        if (this.kcp != null) {
            this.kcp.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a cIH() {
        return this.kcp;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<m> cpN() {
        return this.mDataList;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean cII() {
        return this.isHost && isPrimary() && !this.kcs;
    }
}
