package com.baidu.tieba.personPolymeric.tab.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.tab.a.b;
import com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes7.dex */
public class PersonCenterDynamicTabFragment extends PersonCenterTabBaseFragment implements BdListView.e, a {
    private com.baidu.tieba.personPolymeric.tab.view.a mFJ;
    private PersonCenterDynamicTabModel mFK;
    private User mFL;
    private com.baidu.tieba.personPolymeric.tab.a.a mFN;
    private b mFO;
    private long mUserId;
    private static boolean mFP = true;
    private static CustomMessageListener fag = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterDynamicTabFragment.mFP = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean mFM = false;
    private boolean mHasInit = false;
    private List<n> mDataList = new ArrayList();
    private PersonCenterDynamicTabModel.a mFQ = new PersonCenterDynamicTabModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void b(List<cb> list, boolean z, boolean z2) {
            PersonCenterDynamicTabFragment.this.f(list, z, z2);
        }

        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void wY(boolean z) {
            PersonCenterDynamicTabFragment.this.wW(z);
        }
    };

    public static PersonCenterDynamicTabFragment p(long j, boolean z) {
        PersonCenterDynamicTabFragment personCenterDynamicTabFragment = new PersonCenterDynamicTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterDynamicTabFragment.setArguments(bundle);
        personCenterDynamicTabFragment.registerListener(fag);
        return personCenterDynamicTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.mFK = new PersonCenterDynamicTabModel(getPageContext(), this.mUserId);
        this.mFK.a(this.mFQ);
        this.mFN = new com.baidu.tieba.personPolymeric.tab.a.a(getPageContext());
        this.mFO = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.mFJ = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.mFJ.setSubType(1013);
        this.mFJ.b(this);
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
    public void wW(boolean z) {
        this.mFM = false;
        hideNetRefreshView(this.mFJ.getRootView());
        hideLoadingView(this.mFJ.getRootView());
        this.mFJ.bSE();
        if (z) {
            showNetRefreshView(this.mFJ.getRootView(), null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(List<cb> list, boolean z, boolean z2) {
        this.mFM = false;
        hideNetRefreshView(this.mFJ.getRootView());
        hideLoadingView(this.mFJ.getRootView());
        if (z) {
            this.mFJ.Xa();
        } else {
            this.mFJ.Xb();
        }
        this.mDataList = com.baidu.tieba.personPolymeric.tab.b.a.fB(list);
        this.mFJ.fD(this.mDataList);
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void wX(boolean z) {
        if (this.mFK != null && this.mFJ != null && this.mHasInit && !this.mFM) {
            hideNetRefreshView(this.mFJ.getRootView());
            if (j.isNetWorkAvailable()) {
                this.mFM = true;
                if (z && mFP) {
                    showLoadingView(this.mFJ.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                this.mFK.Uw();
                cCm();
                return;
            }
            showNetRefreshView(this.mFJ.getRootView(), null, false);
        }
    }

    public void cCm() {
        if (this.mFJ != null && this.mHasInit) {
            this.mFJ.cCm();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void d(User user) {
        this.mFL = user;
        if (this.mFK != null) {
            this.mFK.d(this.mFL);
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
        if (this.mFK != null && this.mHasInit && !this.mFM && j.isNetWorkAvailable() && this.mFK.isHasMore()) {
            this.mFM = true;
            this.mFK.bRR();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mFJ != null) {
            this.mFJ.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && !this.mHasInit) {
            this.mHasInit = true;
            wX(true);
            if (TbSingleton.getInstance().isShowShoubaiDynamicGuide() && this.mFN != null && !this.mFN.dzA() && this.isHost) {
                this.mFN.dzz();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        wX(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("uid", this.mUserId);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, this.isHost);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mHasInit = false;
        this.mFM = false;
        if (this.mFK != null) {
            this.mFK.onDestroy();
        }
        if (this.mFJ != null) {
            this.mFJ.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a dzB() {
        return this.mFJ;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<n> cSp() {
        return this.mDataList;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean dzC() {
        return this.isHost && isPrimary() && !this.mFM;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void a(MetaData metaData) {
        if (this.mFK != null) {
            this.mFK.a(metaData);
        }
    }
}
