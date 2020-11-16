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
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.tab.a.b;
import com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes23.dex */
public class PersonCenterDynamicTabFragment extends PersonCenterTabBaseFragment implements BdListView.e, a {
    private long mUserId;
    private User mfA;
    private com.baidu.tieba.personPolymeric.tab.a.a mfC;
    private b mfD;
    private com.baidu.tieba.personPolymeric.tab.view.a mfy;
    private PersonCenterDynamicTabModel mfz;
    private static boolean mfE = true;
    private static CustomMessageListener eJO = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterDynamicTabFragment.mfE = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean mfB = false;
    private boolean mHasInit = false;
    private List<q> mDataList = new ArrayList();
    private PersonCenterDynamicTabModel.a mfF = new PersonCenterDynamicTabModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void b(List<bx> list, boolean z, boolean z2) {
            PersonCenterDynamicTabFragment.this.f(list, z, z2);
        }

        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void wg(boolean z) {
            PersonCenterDynamicTabFragment.this.we(z);
        }
    };

    public static PersonCenterDynamicTabFragment n(long j, boolean z) {
        PersonCenterDynamicTabFragment personCenterDynamicTabFragment = new PersonCenterDynamicTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterDynamicTabFragment.setArguments(bundle);
        personCenterDynamicTabFragment.registerListener(eJO);
        return personCenterDynamicTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.mfz = new PersonCenterDynamicTabModel(getPageContext(), this.mUserId);
        this.mfz.a(this.mfF);
        this.mfC = new com.baidu.tieba.personPolymeric.tab.a.a(getPageContext());
        this.mfD = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.mfy = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.mfy.setSubType(1013);
        this.mfy.b(this);
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
    public void we(boolean z) {
        this.mfB = false;
        hideNetRefreshView(this.mfy.getRootView());
        hideLoadingView(this.mfy.getRootView());
        this.mfy.bPp();
        if (z) {
            showNetRefreshView(this.mfy.getRootView(), null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(List<bx> list, boolean z, boolean z2) {
        this.mfB = false;
        hideNetRefreshView(this.mfy.getRootView());
        hideLoadingView(this.mfy.getRootView());
        if (z) {
            this.mfy.Vz();
        } else {
            this.mfy.VA();
        }
        this.mDataList = com.baidu.tieba.personPolymeric.tab.b.a.fr(list);
        this.mfy.ft(this.mDataList);
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void wf(boolean z) {
        if (this.mfz != null && this.mfy != null && this.mHasInit && !this.mfB) {
            hideNetRefreshView(this.mfy.getRootView());
            if (j.isNetWorkAvailable()) {
                this.mfB = true;
                if (z && mfE) {
                    showLoadingView(this.mfy.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                this.mfz.Tc();
                cxv();
                return;
            }
            showNetRefreshView(this.mfy.getRootView(), null, false);
        }
    }

    public void cxv() {
        if (this.mfy != null && this.mHasInit) {
            this.mfy.cxv();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void d(User user) {
        this.mfA = user;
        if (this.mfz != null) {
            this.mfz.d(this.mfA);
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
        if (this.mfz != null && this.mHasInit && !this.mfB && j.isNetWorkAvailable() && this.mfz.isHasMore()) {
            this.mfB = true;
            this.mfz.bOD();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mfy != null) {
            this.mfy.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && !this.mHasInit) {
            this.mHasInit = true;
            wf(true);
            if (TbSingleton.getInstance().isShowShoubaiDynamicGuide() && this.mfC != null && !this.mfC.dvK() && this.isHost) {
                this.mfC.dvJ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        wf(true);
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
        this.mfB = false;
        if (this.mfz != null) {
            this.mfz.onDestroy();
        }
        if (this.mfy != null) {
            this.mfy.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a dvL() {
        return this.mfy;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<q> cLy() {
        return this.mDataList;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean dvM() {
        return this.isHost && isPrimary() && !this.mfB;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void a(MetaData metaData) {
        if (this.mfz != null) {
            this.mfz.a(metaData);
        }
    }
}
