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
/* loaded from: classes23.dex */
public class PersonCenterDynamicTabFragment extends PersonCenterTabBaseFragment implements BdListView.e, a {
    private com.baidu.tieba.personPolymeric.tab.view.a lxu;
    private PersonCenterDynamicTabModel lxv;
    private User lxw;
    private com.baidu.tieba.personPolymeric.tab.a.a lxy;
    private b lxz;
    private long mUserId;
    private static boolean lxA = true;
    private static CustomMessageListener ekt = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterDynamicTabFragment.lxA = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean lxx = false;
    private boolean mHasInit = false;
    private List<q> mDataList = new ArrayList();
    private PersonCenterDynamicTabModel.a lxB = new PersonCenterDynamicTabModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void b(List<bw> list, boolean z, boolean z2) {
            PersonCenterDynamicTabFragment.this.f(list, z, z2);
        }

        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void uW(boolean z) {
            PersonCenterDynamicTabFragment.this.uU(z);
        }
    };

    public static PersonCenterDynamicTabFragment m(long j, boolean z) {
        PersonCenterDynamicTabFragment personCenterDynamicTabFragment = new PersonCenterDynamicTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterDynamicTabFragment.setArguments(bundle);
        personCenterDynamicTabFragment.registerListener(ekt);
        return personCenterDynamicTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.lxv = new PersonCenterDynamicTabModel(getPageContext(), this.mUserId);
        this.lxv.a(this.lxB);
        this.lxy = new com.baidu.tieba.personPolymeric.tab.a.a(getPageContext());
        this.lxz = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.lxu = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.lxu.setSubType(1013);
        this.lxu.b(this);
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
    public void uU(boolean z) {
        this.lxx = false;
        hideNetRefreshView(this.lxu.getRootView());
        hideLoadingView(this.lxu.getRootView());
        this.lxu.bIk();
        if (z) {
            showNetRefreshView(this.lxu.getRootView(), null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(List<bw> list, boolean z, boolean z2) {
        this.lxx = false;
        hideNetRefreshView(this.lxu.getRootView());
        hideLoadingView(this.lxu.getRootView());
        if (z) {
            this.lxu.bIi();
        } else {
            this.lxu.bIj();
        }
        this.mDataList = com.baidu.tieba.personPolymeric.tab.b.a.eX(list);
        this.lxu.eZ(this.mDataList);
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void uV(boolean z) {
        if (this.lxv != null && this.lxu != null && this.mHasInit && !this.lxx) {
            hideNetRefreshView(this.lxu.getRootView());
            if (j.isNetWorkAvailable()) {
                this.lxx = true;
                if (z && lxA) {
                    showLoadingView(this.lxu.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                this.lxv.Pd();
                coM();
                return;
            }
            showNetRefreshView(this.lxu.getRootView(), null, false);
        }
    }

    public void coM() {
        if (this.lxu != null && this.mHasInit) {
            this.lxu.coM();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void d(User user) {
        this.lxw = user;
        if (this.lxv != null) {
            this.lxv.d(this.lxw);
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
        if (this.lxv != null && this.mHasInit && !this.lxx && j.isNetWorkAvailable() && this.lxv.isHasMore()) {
            this.lxx = true;
            this.lxv.bHw();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lxu != null) {
            this.lxu.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && !this.mHasInit) {
            this.mHasInit = true;
            uV(true);
            if (TbSingleton.getInstance().isShowShoubaiDynamicGuide() && this.lxy != null && !this.lxy.dmP() && this.isHost) {
                this.lxy.dmO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        uV(true);
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
        this.lxx = false;
        if (this.lxv != null) {
            this.lxv.onDestroy();
        }
        if (this.lxu != null) {
            this.lxu.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a dmQ() {
        return this.lxu;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<q> cCA() {
        return this.mDataList;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean dmR() {
        return this.isHost && isPrimary() && !this.lxx;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void a(MetaData metaData) {
        if (this.lxv != null) {
            this.lxv.a(metaData);
        }
    }
}
