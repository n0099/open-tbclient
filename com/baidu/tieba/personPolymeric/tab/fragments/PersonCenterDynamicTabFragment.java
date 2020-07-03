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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.tab.a.b;
import com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes11.dex */
public class PersonCenterDynamicTabFragment extends PersonCenterTabBaseFragment implements BdListView.e, a {
    private com.baidu.tieba.personPolymeric.tab.view.a kPk;
    private PersonCenterDynamicTabModel kPl;
    private User kPm;
    private com.baidu.tieba.personPolymeric.tab.a.a kPo;
    private b kPp;
    private long mUserId;
    private static boolean kPq = true;
    private static CustomMessageListener dSc = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterDynamicTabFragment.kPq = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean kPn = false;
    private boolean mHasInit = false;
    private List<q> mDataList = new ArrayList();
    private PersonCenterDynamicTabModel.a kPr = new PersonCenterDynamicTabModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void c(List<bu> list, boolean z, boolean z2) {
            PersonCenterDynamicTabFragment.this.g(list, z, z2);
        }

        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void tu(boolean z) {
            PersonCenterDynamicTabFragment.this.ts(z);
        }
    };

    public static PersonCenterDynamicTabFragment k(long j, boolean z) {
        PersonCenterDynamicTabFragment personCenterDynamicTabFragment = new PersonCenterDynamicTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterDynamicTabFragment.setArguments(bundle);
        personCenterDynamicTabFragment.registerListener(dSc);
        return personCenterDynamicTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.kPl = new PersonCenterDynamicTabModel(getPageContext(), this.mUserId);
        this.kPl.a(this.kPr);
        this.kPo = new com.baidu.tieba.personPolymeric.tab.a.a(getPageContext());
        this.kPp = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.kPk = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.kPk.b(this);
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
    public void ts(boolean z) {
        this.kPn = false;
        hideNetRefreshView(this.kPk.getRootView());
        hideLoadingView(this.kPk.getRootView());
        this.kPk.buK();
        if (z) {
            showNetRefreshView(this.kPk.getRootView(), null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(List<bu> list, boolean z, boolean z2) {
        this.kPn = false;
        hideNetRefreshView(this.kPk.getRootView());
        hideLoadingView(this.kPk.getRootView());
        if (z) {
            this.kPk.buI();
        } else {
            this.kPk.buJ();
        }
        this.mDataList = com.baidu.tieba.personPolymeric.tab.b.a.eB(list);
        this.kPk.eD(this.mDataList);
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void tt(boolean z) {
        if (this.kPl != null && this.kPk != null && this.mHasInit && !this.kPn) {
            hideNetRefreshView(this.kPk.getRootView());
            if (j.isNetWorkAvailable()) {
                this.kPn = true;
                if (z && kPq) {
                    showLoadingView(this.kPk.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                this.kPl.IB();
                bXG();
                return;
            }
            showNetRefreshView(this.kPk.getRootView(), null, false);
        }
    }

    public void bXG() {
        if (this.kPk != null && this.mHasInit) {
            this.kPk.bXG();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void d(User user) {
        this.kPm = user;
        if (this.kPl != null) {
            this.kPl.d(this.kPm);
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
        if (this.kPl != null && this.mHasInit && !this.kPn && j.isNetWorkAvailable() && this.kPl.isHasMore()) {
            this.kPn = true;
            this.kPl.btW();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kPk != null) {
            this.kPk.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && !this.mHasInit) {
            this.mHasInit = true;
            tt(true);
            if (TbSingleton.getInstance().isShowShoubaiDynamicGuide() && this.kPo != null && !this.kPo.cUn() && this.isHost) {
                this.kPo.cUm();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        tt(true);
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
        this.kPn = false;
        if (this.kPl != null) {
            this.kPl.onDestroy();
        }
        if (this.kPk != null) {
            this.kPk.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a cUo() {
        return this.kPk;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<q> cky() {
        return this.mDataList;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean cUp() {
        return this.isHost && isPrimary() && !this.kPn;
    }
}
