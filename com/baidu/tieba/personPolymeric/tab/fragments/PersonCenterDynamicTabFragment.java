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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.tab.a.b;
import com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes24.dex */
public class PersonCenterDynamicTabFragment extends PersonCenterTabBaseFragment implements BdListView.e, a {
    private com.baidu.tieba.personPolymeric.tab.view.a lMK;
    private PersonCenterDynamicTabModel lML;
    private User lMM;
    private com.baidu.tieba.personPolymeric.tab.a.a lMO;
    private b lMP;
    private long mUserId;
    private static boolean lMQ = true;
    private static CustomMessageListener ewB = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterDynamicTabFragment.lMQ = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean lMN = false;
    private boolean mHasInit = false;
    private List<q> mDataList = new ArrayList();
    private PersonCenterDynamicTabModel.a lMR = new PersonCenterDynamicTabModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void b(List<bw> list, boolean z, boolean z2) {
            PersonCenterDynamicTabFragment.this.f(list, z, z2);
        }

        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void vD(boolean z) {
            PersonCenterDynamicTabFragment.this.vB(z);
        }
    };

    public static PersonCenterDynamicTabFragment m(long j, boolean z) {
        PersonCenterDynamicTabFragment personCenterDynamicTabFragment = new PersonCenterDynamicTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterDynamicTabFragment.setArguments(bundle);
        personCenterDynamicTabFragment.registerListener(ewB);
        return personCenterDynamicTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.lML = new PersonCenterDynamicTabModel(getPageContext(), this.mUserId);
        this.lML.a(this.lMR);
        this.lMO = new com.baidu.tieba.personPolymeric.tab.a.a(getPageContext());
        this.lMP = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.lMK = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.lMK.setSubType(1013);
        this.lMK.b(this);
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
    public void vB(boolean z) {
        this.lMN = false;
        hideNetRefreshView(this.lMK.getRootView());
        hideLoadingView(this.lMK.getRootView());
        this.lMK.bKU();
        if (z) {
            showNetRefreshView(this.lMK.getRootView(), null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(List<bw> list, boolean z, boolean z2) {
        this.lMN = false;
        hideNetRefreshView(this.lMK.getRootView());
        hideLoadingView(this.lMK.getRootView());
        if (z) {
            this.lMK.SI();
        } else {
            this.lMK.SJ();
        }
        this.mDataList = com.baidu.tieba.personPolymeric.tab.b.a.fa(list);
        this.lMK.fc(this.mDataList);
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void vC(boolean z) {
        if (this.lML != null && this.lMK != null && this.mHasInit && !this.lMN) {
            hideNetRefreshView(this.lMK.getRootView());
            if (j.isNetWorkAvailable()) {
                this.lMN = true;
                if (z && lMQ) {
                    showLoadingView(this.lMK.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                this.lML.Qi();
                csk();
                return;
            }
            showNetRefreshView(this.lMK.getRootView(), null, false);
        }
    }

    public void csk() {
        if (this.lMK != null && this.mHasInit) {
            this.lMK.csk();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void d(User user) {
        this.lMM = user;
        if (this.lML != null) {
            this.lML.d(this.lMM);
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
        if (this.lML != null && this.mHasInit && !this.lMN && j.isNetWorkAvailable() && this.lML.isHasMore()) {
            this.lMN = true;
            this.lML.bKi();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lMK != null) {
            this.lMK.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && !this.mHasInit) {
            this.mHasInit = true;
            vC(true);
            if (TbSingleton.getInstance().isShowShoubaiDynamicGuide() && this.lMO != null && !this.lMO.dqB() && this.isHost) {
                this.lMO.dqA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        vC(true);
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
        this.lMN = false;
        if (this.lML != null) {
            this.lML.onDestroy();
        }
        if (this.lMK != null) {
            this.lMK.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a dqC() {
        return this.lMK;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<q> cGj() {
        return this.mDataList;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean dqD() {
        return this.isHost && isPrimary() && !this.lMN;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void a(MetaData metaData) {
        if (this.lML != null) {
            this.lML.a(metaData);
        }
    }
}
