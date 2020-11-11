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
    private long mUserId;
    private com.baidu.tieba.personPolymeric.tab.view.a mfg;
    private PersonCenterDynamicTabModel mfh;
    private User mfi;
    private com.baidu.tieba.personPolymeric.tab.a.a mfk;
    private b mfl;
    private static boolean mfm = true;
    private static CustomMessageListener eKP = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterDynamicTabFragment.mfm = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean mfj = false;
    private boolean mHasInit = false;
    private List<q> mDataList = new ArrayList();
    private PersonCenterDynamicTabModel.a mfn = new PersonCenterDynamicTabModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void b(List<bw> list, boolean z, boolean z2) {
            PersonCenterDynamicTabFragment.this.f(list, z, z2);
        }

        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void wd(boolean z) {
            PersonCenterDynamicTabFragment.this.wb(z);
        }
    };

    public static PersonCenterDynamicTabFragment n(long j, boolean z) {
        PersonCenterDynamicTabFragment personCenterDynamicTabFragment = new PersonCenterDynamicTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterDynamicTabFragment.setArguments(bundle);
        personCenterDynamicTabFragment.registerListener(eKP);
        return personCenterDynamicTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.mfh = new PersonCenterDynamicTabModel(getPageContext(), this.mUserId);
        this.mfh.a(this.mfn);
        this.mfk = new com.baidu.tieba.personPolymeric.tab.a.a(getPageContext());
        this.mfl = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.mfg = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.mfg.setSubType(1013);
        this.mfg.b(this);
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
    public void wb(boolean z) {
        this.mfj = false;
        hideNetRefreshView(this.mfg.getRootView());
        hideLoadingView(this.mfg.getRootView());
        this.mfg.bPW();
        if (z) {
            showNetRefreshView(this.mfg.getRootView(), null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(List<bw> list, boolean z, boolean z2) {
        this.mfj = false;
        hideNetRefreshView(this.mfg.getRootView());
        hideLoadingView(this.mfg.getRootView());
        if (z) {
            this.mfg.Wi();
        } else {
            this.mfg.Wj();
        }
        this.mDataList = com.baidu.tieba.personPolymeric.tab.b.a.fr(list);
        this.mfg.ft(this.mDataList);
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void wc(boolean z) {
        if (this.mfh != null && this.mfg != null && this.mHasInit && !this.mfj) {
            hideNetRefreshView(this.mfg.getRootView());
            if (j.isNetWorkAvailable()) {
                this.mfj = true;
                if (z && mfm) {
                    showLoadingView(this.mfg.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                this.mfh.TL();
                cxS();
                return;
            }
            showNetRefreshView(this.mfg.getRootView(), null, false);
        }
    }

    public void cxS() {
        if (this.mfg != null && this.mHasInit) {
            this.mfg.cxS();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void d(User user) {
        this.mfi = user;
        if (this.mfh != null) {
            this.mfh.d(this.mfi);
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
        if (this.mfh != null && this.mHasInit && !this.mfj && j.isNetWorkAvailable() && this.mfh.isHasMore()) {
            this.mfj = true;
            this.mfh.bPk();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mfg != null) {
            this.mfg.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && !this.mHasInit) {
            this.mHasInit = true;
            wc(true);
            if (TbSingleton.getInstance().isShowShoubaiDynamicGuide() && this.mfk != null && !this.mfk.dwk() && this.isHost) {
                this.mfk.dwj();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        wc(true);
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
        this.mfj = false;
        if (this.mfh != null) {
            this.mfh.onDestroy();
        }
        if (this.mfg != null) {
            this.mfg.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a dwl() {
        return this.mfg;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<q> cLR() {
        return this.mDataList;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean dwm() {
        return this.isHost && isPrimary() && !this.mfj;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void a(MetaData metaData) {
        if (this.mfh != null) {
            this.mfh.a(metaData);
        }
    }
}
