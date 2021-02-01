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
    private com.baidu.tieba.personPolymeric.tab.view.a mDq;
    private PersonCenterDynamicTabModel mDr;
    private User mDs;
    private com.baidu.tieba.personPolymeric.tab.a.a mDu;
    private b mDv;
    private long mUserId;
    private static boolean mDw = true;
    private static CustomMessageListener eYH = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterDynamicTabFragment.mDw = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean mDt = false;
    private boolean mHasInit = false;
    private List<n> mDataList = new ArrayList();
    private PersonCenterDynamicTabModel.a mDz = new PersonCenterDynamicTabModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.2
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
        this.mDr = new PersonCenterDynamicTabModel(getPageContext(), this.mUserId);
        this.mDr.a(this.mDz);
        this.mDu = new com.baidu.tieba.personPolymeric.tab.a.a(getPageContext());
        this.mDv = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.mDq = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.mDq.setSubType(1013);
        this.mDq.b(this);
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
        this.mDt = false;
        hideNetRefreshView(this.mDq.getRootView());
        hideLoadingView(this.mDq.getRootView());
        this.mDq.bSr();
        if (z) {
            showNetRefreshView(this.mDq.getRootView(), null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(List<cb> list, boolean z, boolean z2) {
        this.mDt = false;
        hideNetRefreshView(this.mDq.getRootView());
        hideLoadingView(this.mDq.getRootView());
        if (z) {
            this.mDq.WX();
        } else {
            this.mDq.WY();
        }
        this.mDataList = com.baidu.tieba.personPolymeric.tab.b.a.fB(list);
        this.mDq.fD(this.mDataList);
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void wX(boolean z) {
        if (this.mDr != null && this.mDq != null && this.mHasInit && !this.mDt) {
            hideNetRefreshView(this.mDq.getRootView());
            if (j.isNetWorkAvailable()) {
                this.mDt = true;
                if (z && mDw) {
                    showLoadingView(this.mDq.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                this.mDr.Ut();
                cBZ();
                return;
            }
            showNetRefreshView(this.mDq.getRootView(), null, false);
        }
    }

    public void cBZ() {
        if (this.mDq != null && this.mHasInit) {
            this.mDq.cBZ();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void d(User user) {
        this.mDs = user;
        if (this.mDr != null) {
            this.mDr.d(this.mDs);
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
        if (this.mDr != null && this.mHasInit && !this.mDt && j.isNetWorkAvailable() && this.mDr.isHasMore()) {
            this.mDt = true;
            this.mDr.bRE();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mDq != null) {
            this.mDq.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && !this.mHasInit) {
            this.mHasInit = true;
            wX(true);
            if (TbSingleton.getInstance().isShowShoubaiDynamicGuide() && this.mDu != null && !this.mDu.dzk() && this.isHost) {
                this.mDu.dzj();
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
        this.mDt = false;
        if (this.mDr != null) {
            this.mDr.onDestroy();
        }
        if (this.mDq != null) {
            this.mDq.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a dzl() {
        return this.mDq;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<n> cSb() {
        return this.mDataList;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean dzm() {
        return this.isHost && isPrimary() && !this.mDt;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void a(MetaData metaData) {
        if (this.mDr != null) {
            this.mDr.a(metaData);
        }
    }
}
