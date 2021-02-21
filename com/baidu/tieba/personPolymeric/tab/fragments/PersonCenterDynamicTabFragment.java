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
/* loaded from: classes8.dex */
public class PersonCenterDynamicTabFragment extends PersonCenterTabBaseFragment implements BdListView.e, a {
    private com.baidu.tieba.personPolymeric.tab.view.a mDH;
    private PersonCenterDynamicTabModel mDI;
    private User mDJ;
    private com.baidu.tieba.personPolymeric.tab.a.a mDL;
    private b mDM;
    private long mUserId;
    private static boolean mDN = true;
    private static CustomMessageListener eYH = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterDynamicTabFragment.mDN = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean mDK = false;
    private boolean mHasInit = false;
    private List<n> mDataList = new ArrayList();
    private PersonCenterDynamicTabModel.a mDO = new PersonCenterDynamicTabModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.2
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
        personCenterDynamicTabFragment.registerListener(eYH);
        return personCenterDynamicTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.mDI = new PersonCenterDynamicTabModel(getPageContext(), this.mUserId);
        this.mDI.a(this.mDO);
        this.mDL = new com.baidu.tieba.personPolymeric.tab.a.a(getPageContext());
        this.mDM = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.mDH = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.mDH.setSubType(1013);
        this.mDH.b(this);
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
        this.mDK = false;
        hideNetRefreshView(this.mDH.getRootView());
        hideLoadingView(this.mDH.getRootView());
        this.mDH.bSy();
        if (z) {
            showNetRefreshView(this.mDH.getRootView(), null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(List<cb> list, boolean z, boolean z2) {
        this.mDK = false;
        hideNetRefreshView(this.mDH.getRootView());
        hideLoadingView(this.mDH.getRootView());
        if (z) {
            this.mDH.WX();
        } else {
            this.mDH.WY();
        }
        this.mDataList = com.baidu.tieba.personPolymeric.tab.b.a.fB(list);
        this.mDH.fD(this.mDataList);
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void wX(boolean z) {
        if (this.mDI != null && this.mDH != null && this.mHasInit && !this.mDK) {
            hideNetRefreshView(this.mDH.getRootView());
            if (j.isNetWorkAvailable()) {
                this.mDK = true;
                if (z && mDN) {
                    showLoadingView(this.mDH.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                this.mDI.Ut();
                cCg();
                return;
            }
            showNetRefreshView(this.mDH.getRootView(), null, false);
        }
    }

    public void cCg() {
        if (this.mDH != null && this.mHasInit) {
            this.mDH.cCg();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void d(User user) {
        this.mDJ = user;
        if (this.mDI != null) {
            this.mDI.d(this.mDJ);
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
        if (this.mDI != null && this.mHasInit && !this.mDK && j.isNetWorkAvailable() && this.mDI.isHasMore()) {
            this.mDK = true;
            this.mDI.bRL();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mDH != null) {
            this.mDH.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && !this.mHasInit) {
            this.mHasInit = true;
            wX(true);
            if (TbSingleton.getInstance().isShowShoubaiDynamicGuide() && this.mDL != null && !this.mDL.dzr() && this.isHost) {
                this.mDL.dzq();
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
        this.mDK = false;
        if (this.mDI != null) {
            this.mDI.onDestroy();
        }
        if (this.mDH != null) {
            this.mDH.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a dzs() {
        return this.mDH;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<n> cSi() {
        return this.mDataList;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean dzt() {
        return this.isHost && isPrimary() && !this.mDK;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void a(MetaData metaData) {
        if (this.mDI != null) {
            this.mDI.a(metaData);
        }
    }
}
