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
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.tab.a.b;
import com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes18.dex */
public class PersonCenterDynamicTabFragment extends PersonCenterTabBaseFragment implements BdListView.e, a {
    private com.baidu.tieba.personPolymeric.tab.view.a kYg;
    private PersonCenterDynamicTabModel kYh;
    private User kYi;
    private com.baidu.tieba.personPolymeric.tab.a.a kYk;
    private b kYl;
    private long mUserId;
    private static boolean kYm = true;
    private static CustomMessageListener dYu = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterDynamicTabFragment.kYm = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean kYj = false;
    private boolean mHasInit = false;
    private List<q> mDataList = new ArrayList();
    private PersonCenterDynamicTabModel.a kYn = new PersonCenterDynamicTabModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void b(List<bv> list, boolean z, boolean z2) {
            PersonCenterDynamicTabFragment.this.f(list, z, z2);
        }

        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void ua(boolean z) {
            PersonCenterDynamicTabFragment.this.tY(z);
        }
    };

    public static PersonCenterDynamicTabFragment k(long j, boolean z) {
        PersonCenterDynamicTabFragment personCenterDynamicTabFragment = new PersonCenterDynamicTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterDynamicTabFragment.setArguments(bundle);
        personCenterDynamicTabFragment.registerListener(dYu);
        return personCenterDynamicTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.kYh = new PersonCenterDynamicTabModel(getPageContext(), this.mUserId);
        this.kYh.a(this.kYn);
        this.kYk = new com.baidu.tieba.personPolymeric.tab.a.a(getPageContext());
        this.kYl = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.kYg = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.kYg.b(this);
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
    public void tY(boolean z) {
        this.kYj = false;
        hideNetRefreshView(this.kYg.getRootView());
        hideLoadingView(this.kYg.getRootView());
        this.kYg.bxU();
        if (z) {
            showNetRefreshView(this.kYg.getRootView(), null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(List<bv> list, boolean z, boolean z2) {
        this.kYj = false;
        hideNetRefreshView(this.kYg.getRootView());
        hideLoadingView(this.kYg.getRootView());
        if (z) {
            this.kYg.bxS();
        } else {
            this.kYg.bxT();
        }
        this.mDataList = com.baidu.tieba.personPolymeric.tab.b.a.eH(list);
        this.kYg.eJ(this.mDataList);
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void tZ(boolean z) {
        if (this.kYh != null && this.kYg != null && this.mHasInit && !this.kYj) {
            hideNetRefreshView(this.kYg.getRootView());
            if (j.isNetWorkAvailable()) {
                this.kYj = true;
                if (z && kYm) {
                    showLoadingView(this.kYg.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                this.kYh.IH();
                cbd();
                return;
            }
            showNetRefreshView(this.kYg.getRootView(), null, false);
        }
    }

    public void cbd() {
        if (this.kYg != null && this.mHasInit) {
            this.kYg.cbd();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void d(User user) {
        this.kYi = user;
        if (this.kYh != null) {
            this.kYh.d(this.kYi);
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
        if (this.kYh != null && this.mHasInit && !this.kYj && j.isNetWorkAvailable() && this.kYh.isHasMore()) {
            this.kYj = true;
            this.kYh.bxg();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kYg != null) {
            this.kYg.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && !this.mHasInit) {
            this.mHasInit = true;
            tZ(true);
            if (TbSingleton.getInstance().isShowShoubaiDynamicGuide() && this.kYk != null && !this.kYk.cYe() && this.isHost) {
                this.kYk.cYd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        tZ(true);
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
        this.kYj = false;
        if (this.kYh != null) {
            this.kYh.onDestroy();
        }
        if (this.kYg != null) {
            this.kYg.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a cYf() {
        return this.kYg;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<q> cnZ() {
        return this.mDataList;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean cYg() {
        return this.isHost && isPrimary() && !this.kYj;
    }
}
