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
/* loaded from: classes8.dex */
public class PersonCenterDynamicTabFragment extends PersonCenterTabBaseFragment implements BdListView.e, a {
    private long mUserId;
    private com.baidu.tieba.personPolymeric.tab.view.a myT;
    private PersonCenterDynamicTabModel myU;
    private User myV;
    private com.baidu.tieba.personPolymeric.tab.a.a myX;
    private b myY;
    private static boolean myZ = true;
    private static CustomMessageListener faZ = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterDynamicTabFragment.myZ = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean myW = false;
    private boolean mHasInit = false;
    private List<n> mDataList = new ArrayList();
    private PersonCenterDynamicTabModel.a mza = new PersonCenterDynamicTabModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void b(List<bz> list, boolean z, boolean z2) {
            PersonCenterDynamicTabFragment.this.f(list, z, z2);
        }

        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void wL(boolean z) {
            PersonCenterDynamicTabFragment.this.wJ(z);
        }
    };

    public static PersonCenterDynamicTabFragment o(long j, boolean z) {
        PersonCenterDynamicTabFragment personCenterDynamicTabFragment = new PersonCenterDynamicTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterDynamicTabFragment.setArguments(bundle);
        personCenterDynamicTabFragment.registerListener(faZ);
        return personCenterDynamicTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.myU = new PersonCenterDynamicTabModel(getPageContext(), this.mUserId);
        this.myU.a(this.mza);
        this.myX = new com.baidu.tieba.personPolymeric.tab.a.a(getPageContext());
        this.myY = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.myT = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.myT.setSubType(1013);
        this.myT.b(this);
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
    public void wJ(boolean z) {
        this.myW = false;
        hideNetRefreshView(this.myT.getRootView());
        hideLoadingView(this.myT.getRootView());
        this.myT.bVF();
        if (z) {
            showNetRefreshView(this.myT.getRootView(), null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(List<bz> list, boolean z, boolean z2) {
        this.myW = false;
        hideNetRefreshView(this.myT.getRootView());
        hideLoadingView(this.myT.getRootView());
        if (z) {
            this.myT.Zg();
        } else {
            this.myT.Zh();
        }
        this.mDataList = com.baidu.tieba.personPolymeric.tab.b.a.fD(list);
        this.myT.fF(this.mDataList);
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void wK(boolean z) {
        if (this.myU != null && this.myT != null && this.mHasInit && !this.myW) {
            hideNetRefreshView(this.myT.getRootView());
            if (j.isNetWorkAvailable()) {
                this.myW = true;
                if (z && myZ) {
                    showLoadingView(this.myT.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                this.myU.WE();
                cEF();
                return;
            }
            showNetRefreshView(this.myT.getRootView(), null, false);
        }
    }

    public void cEF() {
        if (this.myT != null && this.mHasInit) {
            this.myT.cEF();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void d(User user) {
        this.myV = user;
        if (this.myU != null) {
            this.myU.d(this.myV);
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
        if (this.myU != null && this.mHasInit && !this.myW && j.isNetWorkAvailable() && this.myU.isHasMore()) {
            this.myW = true;
            this.myU.bUR();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.myT != null) {
            this.myT.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && !this.mHasInit) {
            this.mHasInit = true;
            wK(true);
            if (TbSingleton.getInstance().isShowShoubaiDynamicGuide() && this.myX != null && !this.myX.dAS() && this.isHost) {
                this.myX.dAR();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        wK(true);
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
        this.myW = false;
        if (this.myU != null) {
            this.myU.onDestroy();
        }
        if (this.myT != null) {
            this.myT.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a dAT() {
        return this.myT;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<n> cTT() {
        return this.mDataList;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean dAU() {
        return this.isHost && isPrimary() && !this.myW;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void a(MetaData metaData) {
        if (this.myU != null) {
            this.myU.a(metaData);
        }
    }
}
