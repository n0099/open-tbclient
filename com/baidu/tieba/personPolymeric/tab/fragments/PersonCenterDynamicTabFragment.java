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
    private com.baidu.tieba.personPolymeric.tab.view.a lZg;
    private PersonCenterDynamicTabModel lZh;
    private User lZi;
    private com.baidu.tieba.personPolymeric.tab.a.a lZk;
    private b lZl;
    private long mUserId;
    private static boolean lZm = true;
    private static CustomMessageListener eFa = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterDynamicTabFragment.lZm = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean lZj = false;
    private boolean mHasInit = false;
    private List<q> mDataList = new ArrayList();
    private PersonCenterDynamicTabModel.a lZn = new PersonCenterDynamicTabModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void b(List<bw> list, boolean z, boolean z2) {
            PersonCenterDynamicTabFragment.this.f(list, z, z2);
        }

        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void vU(boolean z) {
            PersonCenterDynamicTabFragment.this.vS(z);
        }
    };

    public static PersonCenterDynamicTabFragment n(long j, boolean z) {
        PersonCenterDynamicTabFragment personCenterDynamicTabFragment = new PersonCenterDynamicTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterDynamicTabFragment.setArguments(bundle);
        personCenterDynamicTabFragment.registerListener(eFa);
        return personCenterDynamicTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.lZh = new PersonCenterDynamicTabModel(getPageContext(), this.mUserId);
        this.lZh.a(this.lZn);
        this.lZk = new com.baidu.tieba.personPolymeric.tab.a.a(getPageContext());
        this.lZl = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.lZg = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.lZg.setSubType(1013);
        this.lZg.b(this);
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
    public void vS(boolean z) {
        this.lZj = false;
        hideNetRefreshView(this.lZg.getRootView());
        hideLoadingView(this.lZg.getRootView());
        this.lZg.bNw();
        if (z) {
            showNetRefreshView(this.lZg.getRootView(), null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(List<bw> list, boolean z, boolean z2) {
        this.lZj = false;
        hideNetRefreshView(this.lZg.getRootView());
        hideLoadingView(this.lZg.getRootView());
        if (z) {
            this.lZg.TI();
        } else {
            this.lZg.TJ();
        }
        this.mDataList = com.baidu.tieba.personPolymeric.tab.b.a.fj(list);
        this.lZg.fl(this.mDataList);
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void vT(boolean z) {
        if (this.lZh != null && this.lZg != null && this.mHasInit && !this.lZj) {
            hideNetRefreshView(this.lZg.getRootView());
            if (j.isNetWorkAvailable()) {
                this.lZj = true;
                if (z && lZm) {
                    showLoadingView(this.lZg.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                this.lZh.Rd();
                cvr();
                return;
            }
            showNetRefreshView(this.lZg.getRootView(), null, false);
        }
    }

    public void cvr() {
        if (this.lZg != null && this.mHasInit) {
            this.lZg.cvr();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void d(User user) {
        this.lZi = user;
        if (this.lZh != null) {
            this.lZh.d(this.lZi);
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
        if (this.lZh != null && this.mHasInit && !this.lZj && j.isNetWorkAvailable() && this.lZh.isHasMore()) {
            this.lZj = true;
            this.lZh.bMK();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lZg != null) {
            this.lZg.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && !this.mHasInit) {
            this.mHasInit = true;
            vT(true);
            if (TbSingleton.getInstance().isShowShoubaiDynamicGuide() && this.lZk != null && !this.lZk.dtI() && this.isHost) {
                this.lZk.dtH();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        vT(true);
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
        this.lZj = false;
        if (this.lZh != null) {
            this.lZh.onDestroy();
        }
        if (this.lZg != null) {
            this.lZg.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a dtJ() {
        return this.lZg;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<q> cJq() {
        return this.mDataList;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean dtK() {
        return this.isHost && isPrimary() && !this.lZj;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void a(MetaData metaData) {
        if (this.lZh != null) {
            this.lZh.a(metaData);
        }
    }
}
