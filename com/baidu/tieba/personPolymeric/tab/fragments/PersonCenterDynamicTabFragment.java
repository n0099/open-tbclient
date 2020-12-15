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
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.tab.a.b;
import com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes24.dex */
public class PersonCenterDynamicTabFragment extends PersonCenterTabBaseFragment implements BdListView.e, a {
    private long mUserId;
    private com.baidu.tieba.personPolymeric.tab.view.a mtG;
    private PersonCenterDynamicTabModel mtH;
    private User mtI;
    private com.baidu.tieba.personPolymeric.tab.a.a mtK;
    private b mtL;
    private static boolean mtM = true;
    private static CustomMessageListener eRa = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterDynamicTabFragment.mtM = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean mtJ = false;
    private boolean mHasInit = false;
    private List<q> mDataList = new ArrayList();
    private PersonCenterDynamicTabModel.a mtN = new PersonCenterDynamicTabModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void b(List<by> list, boolean z, boolean z2) {
            PersonCenterDynamicTabFragment.this.f(list, z, z2);
        }

        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void wK(boolean z) {
            PersonCenterDynamicTabFragment.this.wI(z);
        }
    };

    public static PersonCenterDynamicTabFragment n(long j, boolean z) {
        PersonCenterDynamicTabFragment personCenterDynamicTabFragment = new PersonCenterDynamicTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterDynamicTabFragment.setArguments(bundle);
        personCenterDynamicTabFragment.registerListener(eRa);
        return personCenterDynamicTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.mtH = new PersonCenterDynamicTabModel(getPageContext(), this.mUserId);
        this.mtH.a(this.mtN);
        this.mtK = new com.baidu.tieba.personPolymeric.tab.a.a(getPageContext());
        this.mtL = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.mtG = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.mtG.setSubType(1013);
        this.mtG.b(this);
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
    public void wI(boolean z) {
        this.mtJ = false;
        hideNetRefreshView(this.mtG.getRootView());
        hideLoadingView(this.mtG.getRootView());
        this.mtG.bTb();
        if (z) {
            showNetRefreshView(this.mtG.getRootView(), null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(List<by> list, boolean z, boolean z2) {
        this.mtJ = false;
        hideNetRefreshView(this.mtG.getRootView());
        hideLoadingView(this.mtG.getRootView());
        if (z) {
            this.mtG.XZ();
        } else {
            this.mtG.Ya();
        }
        this.mDataList = com.baidu.tieba.personPolymeric.tab.b.a.fD(list);
        this.mtG.fF(this.mDataList);
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void wJ(boolean z) {
        if (this.mtH != null && this.mtG != null && this.mHasInit && !this.mtJ) {
            hideNetRefreshView(this.mtG.getRootView());
            if (j.isNetWorkAvailable()) {
                this.mtJ = true;
                if (z && mtM) {
                    showLoadingView(this.mtG.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                this.mtH.VC();
                cBM();
                return;
            }
            showNetRefreshView(this.mtG.getRootView(), null, false);
        }
    }

    public void cBM() {
        if (this.mtG != null && this.mHasInit) {
            this.mtG.cBM();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void d(User user) {
        this.mtI = user;
        if (this.mtH != null) {
            this.mtH.d(this.mtI);
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
        if (this.mtH != null && this.mHasInit && !this.mtJ && j.isNetWorkAvailable() && this.mtH.isHasMore()) {
            this.mtJ = true;
            this.mtH.bSp();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mtG != null) {
            this.mtG.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && !this.mHasInit) {
            this.mHasInit = true;
            wJ(true);
            if (TbSingleton.getInstance().isShowShoubaiDynamicGuide() && this.mtK != null && !this.mtK.dBd() && this.isHost) {
                this.mtK.dBc();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        wJ(true);
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
        this.mtJ = false;
        if (this.mtH != null) {
            this.mtH.onDestroy();
        }
        if (this.mtG != null) {
            this.mtG.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a dBe() {
        return this.mtG;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<q> cQN() {
        return this.mDataList;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean dBf() {
        return this.isHost && isPrimary() && !this.mtJ;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void a(MetaData metaData) {
        if (this.mtH != null) {
            this.mtH.a(metaData);
        }
    }
}
