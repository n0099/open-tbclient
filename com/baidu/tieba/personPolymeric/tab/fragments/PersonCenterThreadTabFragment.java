package com.baidu.tieba.personPolymeric.tab.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.n.h;
import com.baidu.tbadk.n.l;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.tab.a.b;
import java.util.List;
import tbclient.User;
/* loaded from: classes24.dex */
public class PersonCenterThreadTabFragment extends PersonCenterTabBaseFragment implements BdListView.e, a {
    private long mUserId;
    private PersonPostModel mri;
    private com.baidu.tieba.personPolymeric.tab.view.a mtG;
    private User mtI;
    private b mtL;
    private static boolean mtM = true;
    private static CustomMessageListener eRa = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterThreadTabFragment.mtM = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean mtJ = false;
    private boolean mHasInit = false;
    private boolean mHasMore = false;
    private PersonPostModel.b mOnResult = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
        public void a(PersonPostModel personPostModel, boolean z) {
            PersonCenterThreadTabFragment.this.c(personPostModel, z);
        }
    };
    private PersonPostModel.a mtS = new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            PersonCenterThreadTabFragment.this.c(personPostModel, z);
        }
    };

    public static PersonCenterThreadTabFragment p(long j, boolean z) {
        PersonCenterThreadTabFragment personCenterThreadTabFragment = new PersonCenterThreadTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterThreadTabFragment.setArguments(bundle);
        personCenterThreadTabFragment.registerListener(eRa);
        return personCenterThreadTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.mri = new PersonPostModel(getPageContext(), getUniqueId(), this.mOnResult, isHost(), PersonPostModel.FROM_PERSON_POST);
        this.mtL = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PersonPostModel personPostModel, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        this.mtJ = false;
        hideLoadingView(this.mtG.getRootView());
        hideNetRefreshView(this.mtG.getRootView());
        if (personPostModel != null && this.mri != null) {
            if (z) {
                this.mri.threadList.clear();
            }
            this.mri.threadList.addAll(com.baidu.tieba.personPolymeric.tab.b.a.fC(personPostModel.threadList));
        }
        this.mHasMore = d(personPostModel, z);
        if (y.isEmpty(this.mri.threadList) && !j.isNetWorkAvailable()) {
            showNetRefreshView(this.mtG.getRootView(), null, false);
        } else {
            if (this.mHasMore) {
                this.mtG.XZ();
            } else {
                this.mtG.Ya();
            }
            setData(this.mri.threadList);
        }
        com.baidu.tieba.personPolymeric.b.dzW().ht(System.currentTimeMillis() - currentTimeMillis);
        com.baidu.tieba.personPolymeric.b.dzW().setRefreshTime(System.currentTimeMillis() - com.baidu.tieba.personPolymeric.b.dzW().dyo());
        if (personPostModel != null && personPostModel.getResponsedMessage() != null) {
            k(personPostModel.getResponsedMessage());
        }
    }

    private boolean d(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null) {
            return z ? personPostModel.threadList.size() >= 20 : !y.isEmpty(personPostModel.threadList);
        }
        return false;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void d(User user) {
        this.mtI = user;
        cNv();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.mtG = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.mtG.setSubType(1012);
        this.mtG.b(this);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        cNv();
    }

    private void cNv() {
        if (isAdded() && isPrimary() && this.mtI != null && !this.mHasInit) {
            this.mHasInit = true;
            com.baidu.tieba.personPolymeric.b.dzW().hu(System.currentTimeMillis());
            wJ(true);
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
        if (this.mtG != null) {
            this.mtG.fF(list);
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
    public void wJ(boolean z) {
        if (this.mri != null && this.mtG != null && this.mHasInit) {
            hideNetRefreshView(this.mtG.getRootView());
            if (j.isNetWorkAvailable()) {
                if (z && mtM) {
                    showLoadingView(this.mtG.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                wL(true);
                cBM();
                return;
            }
            showNetRefreshView(this.mtG.getRootView(), null, false);
        }
    }

    private void wL(boolean z) {
        if (!this.mtJ) {
            this.mtJ = true;
            this.mri.fetchPost(getPageContext(), this.mtS, z, String.valueOf(this.mUserId), true, 0, false, true, this.mtI);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        wJ(true);
    }

    public void cBM() {
        if (this.mtG != null && this.mHasInit) {
            this.mtG.cBM();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mri != null && this.mHasInit && j.isNetWorkAvailable() && this.mHasMore) {
            wL(false);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mtG != null) {
            this.mtG.onChangeSkinType(i);
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
        this.mtJ = false;
        if (this.mtG != null) {
            this.mtG.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a dBe() {
        return this.mtG;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<q> cQN() {
        if (this.mri != null) {
            return this.mri.threadList;
        }
        return null;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean dBf() {
        return this.isHost && isPrimary() && !this.mtJ;
    }

    public void k(ResponsedMessage<?> responsedMessage) {
        long refreshTime = com.baidu.tieba.personPolymeric.b.dzW().getRefreshTime();
        long createTime = com.baidu.tieba.personPolymeric.b.dzW().getCreateTime();
        long bgj = com.baidu.tieba.personPolymeric.b.dzW().bgj();
        long dyn = com.baidu.tieba.personPolymeric.b.dzW().dyn();
        long dzY = com.baidu.tieba.personPolymeric.b.dzW().dzY();
        if (l.bFl().isSmallFlow() && createTime > 0) {
            long j = refreshTime + createTime;
            if (bgj > 0) {
                j = System.currentTimeMillis() - bgj;
            }
            h hVar = new h(1010, true, responsedMessage, 0L, createTime, dyn, false, 0L, 0L, j);
            if (dzY < BdKVCache.MILLS_1Hour) {
                hVar.eg("profileTime", String.valueOf(dzY));
            }
            if (hVar != null) {
                hVar.bFi();
            }
            com.baidu.tieba.personPolymeric.b.dzW().setCreateTime(0L);
        }
    }
}
