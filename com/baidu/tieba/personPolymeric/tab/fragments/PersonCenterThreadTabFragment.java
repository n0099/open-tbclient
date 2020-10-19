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
/* loaded from: classes24.dex */
public class PersonCenterThreadTabFragment extends PersonCenterTabBaseFragment implements BdListView.e, a {
    private PersonPostModel lKn;
    private com.baidu.tieba.personPolymeric.tab.view.a lMK;
    private User lMM;
    private b lMP;
    private long mUserId;
    private static boolean lMQ = true;
    private static CustomMessageListener ewB = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterThreadTabFragment.lMQ = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean lMN = false;
    private boolean mHasInit = false;
    private boolean mHasMore = false;
    private PersonPostModel.b mOnResult = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
        public void a(PersonPostModel personPostModel, boolean z) {
            PersonCenterThreadTabFragment.this.c(personPostModel, z);
        }
    };
    private PersonPostModel.a lMW = new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            PersonCenterThreadTabFragment.this.c(personPostModel, z);
        }
    };

    public static PersonCenterThreadTabFragment o(long j, boolean z) {
        PersonCenterThreadTabFragment personCenterThreadTabFragment = new PersonCenterThreadTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterThreadTabFragment.setArguments(bundle);
        personCenterThreadTabFragment.registerListener(ewB);
        return personCenterThreadTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.lKn = new PersonPostModel(getPageContext(), getUniqueId(), this.mOnResult, isHost(), PersonPostModel.FROM_PERSON_POST);
        this.lMP = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PersonPostModel personPostModel, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        this.lMN = false;
        hideLoadingView(this.lMK.getRootView());
        hideNetRefreshView(this.lMK.getRootView());
        if (personPostModel != null && this.lKn != null) {
            if (z) {
                this.lKn.threadList.clear();
            }
            this.lKn.threadList.addAll(com.baidu.tieba.personPolymeric.tab.b.a.eZ(personPostModel.threadList));
        }
        this.mHasMore = d(personPostModel, z);
        if (y.isEmpty(this.lKn.threadList) && !j.isNetWorkAvailable()) {
            showNetRefreshView(this.lMK.getRootView(), null, false);
        } else {
            if (this.mHasMore) {
                this.lMK.SI();
            } else {
                this.lMK.SJ();
            }
            setData(this.lKn.threadList);
        }
        com.baidu.tieba.personPolymeric.b.dpu().go(System.currentTimeMillis() - currentTimeMillis);
        com.baidu.tieba.personPolymeric.b.dpu().setRefreshTime(System.currentTimeMillis() - com.baidu.tieba.personPolymeric.b.dpu().dnM());
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
        this.lMM = user;
        cCS();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.lMK = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.lMK.setSubType(1012);
        this.lMK.b(this);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        cCS();
    }

    private void cCS() {
        if (isAdded() && isPrimary() && this.lMM != null && !this.mHasInit) {
            this.mHasInit = true;
            com.baidu.tieba.personPolymeric.b.dpu().gp(System.currentTimeMillis());
            vC(true);
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
        if (this.lMK != null) {
            this.lMK.fc(list);
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
    public void vC(boolean z) {
        if (this.lKn != null && this.lMK != null && this.mHasInit) {
            hideNetRefreshView(this.lMK.getRootView());
            if (j.isNetWorkAvailable()) {
                if (z && lMQ) {
                    showLoadingView(this.lMK.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                vE(true);
                csk();
                return;
            }
            showNetRefreshView(this.lMK.getRootView(), null, false);
        }
    }

    private void vE(boolean z) {
        if (!this.lMN) {
            this.lMN = true;
            this.lKn.fetchPost(getPageContext(), this.lMW, z, String.valueOf(this.mUserId), true, 0, false, true, this.lMM);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        vC(true);
    }

    public void csk() {
        if (this.lMK != null && this.mHasInit) {
            this.lMK.csk();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.lKn != null && this.mHasInit && j.isNetWorkAvailable() && this.mHasMore) {
            vE(false);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lMK != null) {
            this.lMK.onChangeSkinType(i);
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
        this.lMN = false;
        if (this.lMK != null) {
            this.lMK.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a dqC() {
        return this.lMK;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<q> cGj() {
        if (this.lKn != null) {
            return this.lKn.threadList;
        }
        return null;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean dqD() {
        return this.isHost && isPrimary() && !this.lMN;
    }

    public void k(ResponsedMessage<?> responsedMessage) {
        long refreshTime = com.baidu.tieba.personPolymeric.b.dpu().getRefreshTime();
        long createTime = com.baidu.tieba.personPolymeric.b.dpu().getCreateTime();
        long aZs = com.baidu.tieba.personPolymeric.b.dpu().aZs();
        long dnL = com.baidu.tieba.personPolymeric.b.dpu().dnL();
        long dpw = com.baidu.tieba.personPolymeric.b.dpu().dpw();
        if (m.byc().byd() && createTime > 0) {
            long j = refreshTime + createTime;
            if (aZs > 0) {
                j = System.currentTimeMillis() - aZs;
            }
            i iVar = new i(1010, true, responsedMessage, 0L, createTime, dnL, false, 0L, 0L, j);
            if (dpw < BdKVCache.MILLS_1Hour) {
                iVar.dS("profileTime", String.valueOf(dpw));
            }
            if (iVar != null) {
                iVar.bxZ();
            }
            com.baidu.tieba.personPolymeric.b.dpu().setCreateTime(0L);
        }
    }
}
