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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.tab.a.b;
import com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes7.dex */
public class PersonCenterDynamicTabFragment extends PersonCenterTabBaseFragment implements BdListView.e, a {
    private long mUserId;
    private com.baidu.tieba.personPolymeric.tab.view.a muo;
    private PersonCenterDynamicTabModel mup;
    private User muq;
    private com.baidu.tieba.personPolymeric.tab.a.a mus;
    private b mut;
    private static boolean muu = true;
    private static CustomMessageListener eWr = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterDynamicTabFragment.muu = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean mur = false;
    private boolean mHasInit = false;
    private List<n> mDataList = new ArrayList();
    private PersonCenterDynamicTabModel.a muv = new PersonCenterDynamicTabModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void b(List<bz> list, boolean z, boolean z2) {
            PersonCenterDynamicTabFragment.this.f(list, z, z2);
        }

        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void wH(boolean z) {
            PersonCenterDynamicTabFragment.this.wF(z);
        }
    };

    public static PersonCenterDynamicTabFragment p(long j, boolean z) {
        PersonCenterDynamicTabFragment personCenterDynamicTabFragment = new PersonCenterDynamicTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterDynamicTabFragment.setArguments(bundle);
        personCenterDynamicTabFragment.registerListener(eWr);
        return personCenterDynamicTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.mup = new PersonCenterDynamicTabModel(getPageContext(), this.mUserId);
        this.mup.a(this.muv);
        this.mus = new com.baidu.tieba.personPolymeric.tab.a.a(getPageContext());
        this.mut = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.muo = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.muo.setSubType(1013);
        this.muo.b(this);
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
    public void wF(boolean z) {
        this.mur = false;
        hideNetRefreshView(this.muo.getRootView());
        hideLoadingView(this.muo.getRootView());
        this.muo.bRO();
        if (z) {
            showNetRefreshView(this.muo.getRootView(), null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(List<bz> list, boolean z, boolean z2) {
        this.mur = false;
        hideNetRefreshView(this.muo.getRootView());
        hideLoadingView(this.muo.getRootView());
        if (z) {
            this.muo.Vo();
        } else {
            this.muo.Vp();
        }
        this.mDataList = com.baidu.tieba.personPolymeric.tab.b.a.fD(list);
        this.muo.fF(this.mDataList);
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void wG(boolean z) {
        if (this.mup != null && this.muo != null && this.mHasInit && !this.mur) {
            hideNetRefreshView(this.muo.getRootView());
            if (j.isNetWorkAvailable()) {
                this.mur = true;
                if (z && muu) {
                    showLoadingView(this.muo.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                this.mup.SM();
                cAO();
                return;
            }
            showNetRefreshView(this.muo.getRootView(), null, false);
        }
    }

    public void cAO() {
        if (this.muo != null && this.mHasInit) {
            this.muo.cAO();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void d(User user) {
        this.muq = user;
        if (this.mup != null) {
            this.mup.d(this.muq);
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
        if (this.mup != null && this.mHasInit && !this.mur && j.isNetWorkAvailable() && this.mup.isHasMore()) {
            this.mur = true;
            this.mup.bRa();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.muo != null) {
            this.muo.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && !this.mHasInit) {
            this.mHasInit = true;
            wG(true);
            if (TbSingleton.getInstance().isShowShoubaiDynamicGuide() && this.mus != null && !this.mus.dxb() && this.isHost) {
                this.mus.dxa();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        wG(true);
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
        this.mur = false;
        if (this.mup != null) {
            this.mup.onDestroy();
        }
        if (this.muo != null) {
            this.muo.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a dxc() {
        return this.muo;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<n> cQc() {
        return this.mDataList;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean dxd() {
        return this.isHost && isPrimary() && !this.mur;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void a(MetaData metaData) {
        if (this.mup != null) {
            this.mup.a(metaData);
        }
    }
}
