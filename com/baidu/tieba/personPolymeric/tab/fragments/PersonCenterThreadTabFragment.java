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
    private PersonPostModel jni;
    private com.baidu.tieba.personPolymeric.tab.view.a jpm;
    private User jpo;
    private b jpr;
    private long mUserId;
    private static boolean jps = true;
    private static CustomMessageListener cTB = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterThreadTabFragment.jps = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean jpp = false;
    private boolean mHasInit = false;
    private boolean mHasMore = false;
    private PersonPostModel.b mOnResult = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
        public void a(PersonPostModel personPostModel, boolean z) {
            PersonCenterThreadTabFragment.this.c(personPostModel, z);
        }
    };
    private PersonPostModel.a jpy = new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.3
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
        this.jni = new PersonPostModel(getPageContext(), getUniqueId(), this.mOnResult, isHost(), PersonPostModel.FROM_PERSON_POST);
        this.jpr = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PersonPostModel personPostModel, boolean z) {
        this.jpp = false;
        hideLoadingView(this.jpm.getRootView());
        hideNetRefreshView(this.jpm.getRootView());
        if (personPostModel != null && this.jni != null) {
            if (z) {
                this.jni.threadList.clear();
            }
            this.jni.threadList.addAll(com.baidu.tieba.personPolymeric.tab.b.a.dW(personPostModel.threadList));
        }
        this.mHasMore = d(personPostModel, z);
        if (v.isEmpty(this.jni.threadList) && !j.isNetWorkAvailable()) {
            showNetRefreshView(this.jpm.getRootView(), null, false);
            return;
        }
        if (this.mHasMore) {
            this.jpm.bba();
        } else {
            this.jpm.bbb();
        }
        setData(this.jni.threadList);
    }

    private boolean d(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null) {
            return z ? personPostModel.threadList.size() >= 20 : !v.isEmpty(personPostModel.threadList);
        }
        return false;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void b(User user) {
        this.jpo = user;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.jpm = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.jpm.b(this);
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
        if (this.jpm != null) {
            this.jpm.dY(list);
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
        if (this.jni != null && this.jpm != null && this.mHasInit) {
            hideNetRefreshView(this.jpm.getRootView());
            if (j.isNetWorkAvailable()) {
                if (z && jps) {
                    showLoadingView(this.jpm.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                rw(true);
                scrollToTop();
                return;
            }
            showNetRefreshView(this.jpm.getRootView(), null, false);
        }
    }

    private void rw(boolean z) {
        if (!this.jpp) {
            this.jpp = true;
            this.jni.fetchPost(getPageContext(), this.jpy, z, String.valueOf(this.mUserId), true, 0, false, true, this.jpo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        ru(true);
    }

    public void scrollToTop() {
        if (this.jpm != null && this.mHasInit) {
            this.jpm.scrollToTop();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.jni != null && this.mHasInit && j.isNetWorkAvailable() && this.mHasMore) {
            rw(false);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jpm != null) {
            this.jpm.onChangeSkinType(i);
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
        this.jpp = false;
        if (this.jpm != null) {
            this.jpm.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a cwi() {
        return this.jpm;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<m> cdi() {
        if (this.jni != null) {
            return this.jni.threadList;
        }
        return null;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean cwj() {
        return this.isHost && isPrimary() && !this.jpp;
    }
}
