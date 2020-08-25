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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.tab.a.b;
import com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes18.dex */
public class PersonCenterDynamicTabFragment extends PersonCenterTabBaseFragment implements BdListView.e, a {
    private com.baidu.tieba.personPolymeric.tab.view.a loq;
    private PersonCenterDynamicTabModel lor;
    private User los;
    private com.baidu.tieba.personPolymeric.tab.a.a lou;
    private b lov;
    private long mUserId;
    private static boolean lox = true;
    private static CustomMessageListener eia = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterDynamicTabFragment.lox = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean lot = false;
    private boolean mHasInit = false;
    private List<q> mDataList = new ArrayList();
    private PersonCenterDynamicTabModel.a loy = new PersonCenterDynamicTabModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void b(List<bw> list, boolean z, boolean z2) {
            PersonCenterDynamicTabFragment.this.f(list, z, z2);
        }

        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void uM(boolean z) {
            PersonCenterDynamicTabFragment.this.uK(z);
        }
    };

    public static PersonCenterDynamicTabFragment k(long j, boolean z) {
        PersonCenterDynamicTabFragment personCenterDynamicTabFragment = new PersonCenterDynamicTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterDynamicTabFragment.setArguments(bundle);
        personCenterDynamicTabFragment.registerListener(eia);
        return personCenterDynamicTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.lor = new PersonCenterDynamicTabModel(getPageContext(), this.mUserId);
        this.lor.a(this.loy);
        this.lou = new com.baidu.tieba.personPolymeric.tab.a.a(getPageContext());
        this.lov = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.loq = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.loq.setSubType(1013);
        this.loq.b(this);
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
    public void uK(boolean z) {
        this.lot = false;
        hideNetRefreshView(this.loq.getRootView());
        hideLoadingView(this.loq.getRootView());
        this.loq.bGT();
        if (z) {
            showNetRefreshView(this.loq.getRootView(), null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(List<bw> list, boolean z, boolean z2) {
        this.lot = false;
        hideNetRefreshView(this.loq.getRootView());
        hideLoadingView(this.loq.getRootView());
        if (z) {
            this.loq.bGR();
        } else {
            this.loq.bGS();
        }
        this.mDataList = com.baidu.tieba.personPolymeric.tab.b.a.eP(list);
        this.loq.eR(this.mDataList);
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void uL(boolean z) {
        if (this.lor != null && this.loq != null && this.mHasInit && !this.lot) {
            hideNetRefreshView(this.loq.getRootView());
            if (j.isNetWorkAvailable()) {
                this.lot = true;
                if (z && lox) {
                    showLoadingView(this.loq.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                this.lor.OA();
                clz();
                return;
            }
            showNetRefreshView(this.loq.getRootView(), null, false);
        }
    }

    public void clz() {
        if (this.loq != null && this.mHasInit) {
            this.loq.clz();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void d(User user) {
        this.los = user;
        if (this.lor != null) {
            this.lor.d(this.los);
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
        if (this.lor != null && this.mHasInit && !this.lot && j.isNetWorkAvailable() && this.lor.isHasMore()) {
            this.lot = true;
            this.lor.bGf();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.loq != null) {
            this.loq.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && !this.mHasInit) {
            this.mHasInit = true;
            uL(true);
            if (TbSingleton.getInstance().isShowShoubaiDynamicGuide() && this.lou != null && !this.lou.djh() && this.isHost) {
                this.lou.djg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        uL(true);
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
        this.lot = false;
        if (this.lor != null) {
            this.lor.onDestroy();
        }
        if (this.loq != null) {
            this.loq.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a dji() {
        return this.loq;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<q> cyS() {
        return this.mDataList;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean djj() {
        return this.isHost && isPrimary() && !this.lot;
    }
}
