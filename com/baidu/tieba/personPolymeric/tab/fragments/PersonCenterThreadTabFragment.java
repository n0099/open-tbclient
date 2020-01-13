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
import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.tab.a.b;
import java.util.List;
import tbclient.User;
/* loaded from: classes9.dex */
public class PersonCenterThreadTabFragment extends PersonCenterTabBaseFragment implements BdListView.e, a {
    private PersonPostModel jnd;
    private com.baidu.tieba.personPolymeric.tab.view.a jph;
    private User jpj;
    private b jpm;
    private long mUserId;
    private static boolean jpn = true;
    private static CustomMessageListener cTB = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterThreadTabFragment.jpn = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean jpk = false;
    private boolean mHasInit = false;
    private boolean mHasMore = false;
    private PersonPostModel.b mOnResult = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
        public void a(PersonPostModel personPostModel, boolean z) {
            PersonCenterThreadTabFragment.this.c(personPostModel, z);
        }
    };
    private PersonPostModel.a jpt = new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            PersonCenterThreadTabFragment.this.c(personPostModel, z);
        }
    };

    public static PersonCenterThreadTabFragment i(long j, boolean z) {
        PersonCenterThreadTabFragment personCenterThreadTabFragment = new PersonCenterThreadTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterThreadTabFragment.setArguments(bundle);
        personCenterThreadTabFragment.registerListener(cTB);
        return personCenterThreadTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.jnd = new PersonPostModel(getPageContext(), getUniqueId(), this.mOnResult, isHost(), PersonPostModel.FROM_PERSON_POST);
        this.jpm = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PersonPostModel personPostModel, boolean z) {
        this.jpk = false;
        hideLoadingView(this.jph.getRootView());
        hideNetRefreshView(this.jph.getRootView());
        if (personPostModel != null && this.jnd != null) {
            if (z) {
                this.jnd.threadList.clear();
            }
            this.jnd.threadList.addAll(com.baidu.tieba.personPolymeric.tab.b.a.dW(personPostModel.threadList));
        }
        this.mHasMore = d(personPostModel, z);
        if (v.isEmpty(this.jnd.threadList) && !j.isNetWorkAvailable()) {
            showNetRefreshView(this.jph.getRootView(), null, false);
            return;
        }
        if (this.mHasMore) {
            this.jph.bba();
        } else {
            this.jph.bbb();
        }
        setData(this.jnd.threadList);
    }

    private boolean d(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null) {
            return z ? personPostModel.threadList.size() >= 20 : !v.isEmpty(personPostModel.threadList);
        }
        return false;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void b(User user) {
        this.jpj = user;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.jph = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.jph.b(this);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && !this.mHasInit) {
            this.mHasInit = true;
            ru(true);
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

    public void setData(List<m> list) {
        if (this.jph != null) {
            this.jph.dY(list);
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
    public void ru(boolean z) {
        if (this.jnd != null && this.jph != null && this.mHasInit) {
            hideNetRefreshView(this.jph.getRootView());
            if (j.isNetWorkAvailable()) {
                if (z && jpn) {
                    showLoadingView(this.jph.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                rw(true);
                scrollToTop();
                return;
            }
            showNetRefreshView(this.jph.getRootView(), null, false);
        }
    }

    private void rw(boolean z) {
        if (!this.jpk) {
            this.jpk = true;
            this.jnd.fetchPost(getPageContext(), this.jpt, z, String.valueOf(this.mUserId), true, 0, false, true, this.jpj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        ru(true);
    }

    public void scrollToTop() {
        if (this.jph != null && this.mHasInit) {
            this.jph.scrollToTop();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.jnd != null && this.mHasInit && j.isNetWorkAvailable() && this.mHasMore) {
            rw(false);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jph != null) {
            this.jph.onChangeSkinType(i);
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
        this.jpk = false;
        if (this.jph != null) {
            this.jph.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a cwg() {
        return this.jph;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<m> cdi() {
        if (this.jnd != null) {
            return this.jnd.threadList;
        }
        return null;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean cwh() {
        return this.isHost && isPrimary() && !this.jpk;
    }
}
