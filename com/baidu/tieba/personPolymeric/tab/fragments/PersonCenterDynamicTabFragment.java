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
    private com.baidu.tieba.personPolymeric.tab.view.a mtE;
    private PersonCenterDynamicTabModel mtF;
    private User mtG;
    private com.baidu.tieba.personPolymeric.tab.a.a mtI;
    private b mtJ;
    private static boolean mtK = true;
    private static CustomMessageListener eRa = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterDynamicTabFragment.mtK = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean mtH = false;
    private boolean mHasInit = false;
    private List<q> mDataList = new ArrayList();
    private PersonCenterDynamicTabModel.a mtL = new PersonCenterDynamicTabModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.2
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
        this.mtF = new PersonCenterDynamicTabModel(getPageContext(), this.mUserId);
        this.mtF.a(this.mtL);
        this.mtI = new com.baidu.tieba.personPolymeric.tab.a.a(getPageContext());
        this.mtJ = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.mtE = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.mtE.setSubType(1013);
        this.mtE.b(this);
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
        this.mtH = false;
        hideNetRefreshView(this.mtE.getRootView());
        hideLoadingView(this.mtE.getRootView());
        this.mtE.bTa();
        if (z) {
            showNetRefreshView(this.mtE.getRootView(), null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(List<by> list, boolean z, boolean z2) {
        this.mtH = false;
        hideNetRefreshView(this.mtE.getRootView());
        hideLoadingView(this.mtE.getRootView());
        if (z) {
            this.mtE.XZ();
        } else {
            this.mtE.Ya();
        }
        this.mDataList = com.baidu.tieba.personPolymeric.tab.b.a.fD(list);
        this.mtE.fF(this.mDataList);
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void wJ(boolean z) {
        if (this.mtF != null && this.mtE != null && this.mHasInit && !this.mtH) {
            hideNetRefreshView(this.mtE.getRootView());
            if (j.isNetWorkAvailable()) {
                this.mtH = true;
                if (z && mtK) {
                    showLoadingView(this.mtE.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                this.mtF.VC();
                cBL();
                return;
            }
            showNetRefreshView(this.mtE.getRootView(), null, false);
        }
    }

    public void cBL() {
        if (this.mtE != null && this.mHasInit) {
            this.mtE.cBL();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void d(User user) {
        this.mtG = user;
        if (this.mtF != null) {
            this.mtF.d(this.mtG);
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
        if (this.mtF != null && this.mHasInit && !this.mtH && j.isNetWorkAvailable() && this.mtF.isHasMore()) {
            this.mtH = true;
            this.mtF.bSo();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mtE != null) {
            this.mtE.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && !this.mHasInit) {
            this.mHasInit = true;
            wJ(true);
            if (TbSingleton.getInstance().isShowShoubaiDynamicGuide() && this.mtI != null && !this.mtI.dBc() && this.isHost) {
                this.mtI.dBb();
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
        this.mtH = false;
        if (this.mtF != null) {
            this.mtF.onDestroy();
        }
        if (this.mtE != null) {
            this.mtE.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a dBd() {
        return this.mtE;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<q> cQM() {
        return this.mDataList;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean dBe() {
        return this.isHost && isPrimary() && !this.mtH;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void a(MetaData metaData) {
        if (this.mtF != null) {
            this.mtF.a(metaData);
        }
    }
}
