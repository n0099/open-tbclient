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
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.tab.a.b;
import java.util.List;
import tbclient.User;
/* loaded from: classes11.dex */
public class PersonCenterThreadTabFragment extends PersonCenterTabBaseFragment implements BdListView.e, a {
    private PersonPostModel kNc;
    private com.baidu.tieba.personPolymeric.tab.view.a kPk;
    private User kPm;
    private b kPp;
    private long mUserId;
    private static boolean kPq = true;
    private static CustomMessageListener dSc = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterThreadTabFragment.kPq = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean kPn = false;
    private boolean mHasInit = false;
    private boolean mHasMore = false;
    private PersonPostModel.b mOnResult = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
        public void a(PersonPostModel personPostModel, boolean z) {
            PersonCenterThreadTabFragment.this.c(personPostModel, z);
        }
    };
    private PersonPostModel.a kPw = new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            PersonCenterThreadTabFragment.this.c(personPostModel, z);
        }
    };

    public static PersonCenterThreadTabFragment m(long j, boolean z) {
        PersonCenterThreadTabFragment personCenterThreadTabFragment = new PersonCenterThreadTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterThreadTabFragment.setArguments(bundle);
        personCenterThreadTabFragment.registerListener(dSc);
        return personCenterThreadTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.kNc = new PersonPostModel(getPageContext(), getUniqueId(), this.mOnResult, isHost(), PersonPostModel.FROM_PERSON_POST);
        this.kPp = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PersonPostModel personPostModel, boolean z) {
        this.kPn = false;
        hideLoadingView(this.kPk.getRootView());
        hideNetRefreshView(this.kPk.getRootView());
        if (personPostModel != null && this.kNc != null) {
            if (z) {
                this.kNc.threadList.clear();
            }
            this.kNc.threadList.addAll(com.baidu.tieba.personPolymeric.tab.b.a.eA(personPostModel.threadList));
        }
        this.mHasMore = d(personPostModel, z);
        if (w.isEmpty(this.kNc.threadList) && !j.isNetWorkAvailable()) {
            showNetRefreshView(this.kPk.getRootView(), null, false);
            return;
        }
        if (this.mHasMore) {
            this.kPk.buJ();
        } else {
            this.kPk.buK();
        }
        setData(this.kNc.threadList);
    }

    private boolean d(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null) {
            return z ? personPostModel.threadList.size() >= 20 : !w.isEmpty(personPostModel.threadList);
        }
        return false;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void d(User user) {
        this.kPm = user;
        chS();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.kPk = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.kPk.b(this);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        chS();
    }

    private void chS() {
        if (isAdded() && isPrimary() && this.kPm != null && !this.mHasInit) {
            this.mHasInit = true;
            tt(true);
        }
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

    public void setData(List<q> list) {
        if (this.kPk != null) {
            this.kPk.eD(list);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public int getTabType() {
        return 2;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public boolean isHost() {
        return this.isHost;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void tt(boolean z) {
        if (this.kNc != null && this.kPk != null && this.mHasInit) {
            hideNetRefreshView(this.kPk.getRootView());
            if (j.isNetWorkAvailable()) {
                if (z && kPq) {
                    showLoadingView(this.kPk.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                tv(true);
                bXH();
                return;
            }
            showNetRefreshView(this.kPk.getRootView(), null, false);
        }
    }

    private void tv(boolean z) {
        if (!this.kPn) {
            this.kPn = true;
            this.kNc.fetchPost(getPageContext(), this.kPw, z, String.valueOf(this.mUserId), true, 0, false, true, this.kPm);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        tt(true);
    }

    public void bXH() {
        if (this.kPk != null && this.mHasInit) {
            this.kPk.bXH();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.kNc != null && this.mHasInit && j.isNetWorkAvailable() && this.mHasMore) {
            tv(false);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kPk != null) {
            this.kPk.onChangeSkinType(i);
        }
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
        this.mHasMore = false;
        this.mHasInit = false;
        this.kPn = false;
        if (this.kPk != null) {
            this.kPk.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a cUp() {
        return this.kPk;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<q> ckz() {
        if (this.kNc != null) {
            return this.kNc.threadList;
        }
        return null;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean cUq() {
        return this.isHost && isPrimary() && !this.kPn;
    }
}
