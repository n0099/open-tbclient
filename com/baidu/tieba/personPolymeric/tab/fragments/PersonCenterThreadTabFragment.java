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
import com.baidu.tbadk.n.i;
import com.baidu.tbadk.n.m;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.tab.a.b;
import java.util.List;
import tbclient.User;
/* loaded from: classes23.dex */
public class PersonCenterThreadTabFragment extends PersonCenterTabBaseFragment implements BdListView.e, a {
    private long mUserId;
    private PersonPostModel mda;
    private User mfA;
    private b mfD;
    private com.baidu.tieba.personPolymeric.tab.view.a mfy;
    private static boolean mfE = true;
    private static CustomMessageListener eJO = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterThreadTabFragment.mfE = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean mfB = false;
    private boolean mHasInit = false;
    private boolean mHasMore = false;
    private PersonPostModel.b mOnResult = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
        public void a(PersonPostModel personPostModel, boolean z) {
            PersonCenterThreadTabFragment.this.c(personPostModel, z);
        }
    };
    private PersonPostModel.a mfK = new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.3
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
        personCenterThreadTabFragment.registerListener(eJO);
        return personCenterThreadTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.mda = new PersonPostModel(getPageContext(), getUniqueId(), this.mOnResult, isHost(), PersonPostModel.FROM_PERSON_POST);
        this.mfD = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PersonPostModel personPostModel, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        this.mfB = false;
        hideLoadingView(this.mfy.getRootView());
        hideNetRefreshView(this.mfy.getRootView());
        if (personPostModel != null && this.mda != null) {
            if (z) {
                this.mda.threadList.clear();
            }
            this.mda.threadList.addAll(com.baidu.tieba.personPolymeric.tab.b.a.fq(personPostModel.threadList));
        }
        this.mHasMore = d(personPostModel, z);
        if (y.isEmpty(this.mda.threadList) && !j.isNetWorkAvailable()) {
            showNetRefreshView(this.mfy.getRootView(), null, false);
        } else {
            if (this.mHasMore) {
                this.mfy.Vz();
            } else {
                this.mfy.VA();
            }
            setData(this.mda.threadList);
        }
        com.baidu.tieba.personPolymeric.b.duD().gO(System.currentTimeMillis() - currentTimeMillis);
        com.baidu.tieba.personPolymeric.b.duD().setRefreshTime(System.currentTimeMillis() - com.baidu.tieba.personPolymeric.b.duD().dsV());
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
        this.mfA = user;
        cIf();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.mfy = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.mfy.setSubType(1012);
        this.mfy.b(this);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        cIf();
    }

    private void cIf() {
        if (isAdded() && isPrimary() && this.mfA != null && !this.mHasInit) {
            this.mHasInit = true;
            com.baidu.tieba.personPolymeric.b.duD().gP(System.currentTimeMillis());
            wf(true);
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
        if (this.mfy != null) {
            this.mfy.ft(list);
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
    public void wf(boolean z) {
        if (this.mda != null && this.mfy != null && this.mHasInit) {
            hideNetRefreshView(this.mfy.getRootView());
            if (j.isNetWorkAvailable()) {
                if (z && mfE) {
                    showLoadingView(this.mfy.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                wh(true);
                cxv();
                return;
            }
            showNetRefreshView(this.mfy.getRootView(), null, false);
        }
    }

    private void wh(boolean z) {
        if (!this.mfB) {
            this.mfB = true;
            this.mda.fetchPost(getPageContext(), this.mfK, z, String.valueOf(this.mUserId), true, 0, false, true, this.mfA);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        wf(true);
    }

    public void cxv() {
        if (this.mfy != null && this.mHasInit) {
            this.mfy.cxv();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mda != null && this.mHasInit && j.isNetWorkAvailable() && this.mHasMore) {
            wh(false);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mfy != null) {
            this.mfy.onChangeSkinType(i);
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
        this.mfB = false;
        if (this.mfy != null) {
            this.mfy.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a dvL() {
        return this.mfy;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<q> cLy() {
        if (this.mda != null) {
            return this.mda.threadList;
        }
        return null;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean dvM() {
        return this.isHost && isPrimary() && !this.mfB;
    }

    public void k(ResponsedMessage<?> responsedMessage) {
        long refreshTime = com.baidu.tieba.personPolymeric.b.duD().getRefreshTime();
        long createTime = com.baidu.tieba.personPolymeric.b.duD().getCreateTime();
        long bde = com.baidu.tieba.personPolymeric.b.duD().bde();
        long dsU = com.baidu.tieba.personPolymeric.b.duD().dsU();
        long duF = com.baidu.tieba.personPolymeric.b.duD().duF();
        if (m.bBK().isSmallFlow() && createTime > 0) {
            long j = refreshTime + createTime;
            if (bde > 0) {
                j = System.currentTimeMillis() - bde;
            }
            i iVar = new i(1010, true, responsedMessage, 0L, createTime, dsU, false, 0L, 0L, j);
            if (duF < BdKVCache.MILLS_1Hour) {
                iVar.dZ("profileTime", String.valueOf(duF));
            }
            if (iVar != null) {
                iVar.bBH();
            }
            com.baidu.tieba.personPolymeric.b.duD().setCreateTime(0L);
        }
    }
}
