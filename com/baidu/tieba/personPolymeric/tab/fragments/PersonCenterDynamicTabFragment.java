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
import com.baidu.adp.widget.ListView.o;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.tab.a.b;
import com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes11.dex */
public class PersonCenterDynamicTabFragment extends PersonCenterTabBaseFragment implements BdListView.e, a {
    private com.baidu.tieba.personPolymeric.tab.view.a kvn;
    private PersonCenterDynamicTabModel kvo;
    private User kvp;
    private com.baidu.tieba.personPolymeric.tab.a.a kvr;
    private b kvs;
    private long mUserId;
    private static boolean kvt = true;
    private static CustomMessageListener dLm = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterDynamicTabFragment.kvt = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean kvq = false;
    private boolean mHasInit = false;
    private List<o> mDataList = new ArrayList();
    private PersonCenterDynamicTabModel.a kvu = new PersonCenterDynamicTabModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void c(List<bk> list, boolean z, boolean z2) {
            PersonCenterDynamicTabFragment.this.g(list, z, z2);
        }

        @Override // com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.a
        public void tg(boolean z) {
            PersonCenterDynamicTabFragment.this.te(z);
        }
    };

    public static PersonCenterDynamicTabFragment k(long j, boolean z) {
        PersonCenterDynamicTabFragment personCenterDynamicTabFragment = new PersonCenterDynamicTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterDynamicTabFragment.setArguments(bundle);
        personCenterDynamicTabFragment.registerListener(dLm);
        return personCenterDynamicTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.kvo = new PersonCenterDynamicTabModel(getPageContext(), this.mUserId);
        this.kvo.a(this.kvu);
        this.kvr = new com.baidu.tieba.personPolymeric.tab.a.a(getPageContext());
        this.kvs = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.kvn = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.kvn.b(this);
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
    public void te(boolean z) {
        this.kvq = false;
        hideNetRefreshView(this.kvn.getRootView());
        hideLoadingView(this.kvn.getRootView());
        this.kvn.brO();
        if (z) {
            showNetRefreshView(this.kvn.getRootView(), null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(List<bk> list, boolean z, boolean z2) {
        this.kvq = false;
        hideNetRefreshView(this.kvn.getRootView());
        hideLoadingView(this.kvn.getRootView());
        if (z) {
            this.kvn.brM();
        } else {
            this.kvn.brN();
        }
        this.mDataList = com.baidu.tieba.personPolymeric.tab.b.a.en(list);
        this.kvn.ep(this.mDataList);
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void tf(boolean z) {
        if (this.kvo != null && this.kvn != null && this.mHasInit && !this.kvq) {
            hideNetRefreshView(this.kvn.getRootView());
            if (j.isNetWorkAvailable()) {
                this.kvq = true;
                if (z && kvt) {
                    showLoadingView(this.kvn.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                this.kvo.Ho();
                bUA();
                return;
            }
            showNetRefreshView(this.kvn.getRootView(), null, false);
        }
    }

    public void bUA() {
        if (this.kvn != null && this.mHasInit) {
            this.kvn.bUA();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void d(User user) {
        this.kvp = user;
        if (this.kvo != null) {
            this.kvo.d(this.kvp);
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
        if (this.kvo != null && this.mHasInit && !this.kvq && j.isNetWorkAvailable() && this.kvo.isHasMore()) {
            this.kvq = true;
            this.kvo.bqZ();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kvn != null) {
            this.kvn.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && !this.mHasInit) {
            this.mHasInit = true;
            tf(true);
            if (TbSingleton.getInstance().isShowShoubaiDynamicGuide() && this.kvr != null && !this.kvr.cPW() && this.isHost) {
                this.kvr.cPV();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        tf(true);
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
        this.kvq = false;
        if (this.kvo != null) {
            this.kvo.onDestroy();
        }
        if (this.kvn != null) {
            this.kvn.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a cPX() {
        return this.kvn;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<o> cwI() {
        return this.mDataList;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean cPY() {
        return this.isHost && isPrimary() && !this.kvq;
    }
}
