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
    private PersonPostModel mrg;
    private com.baidu.tieba.personPolymeric.tab.view.a mtE;
    private User mtG;
    private b mtJ;
    private static boolean mtK = true;
    private static CustomMessageListener eRa = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterThreadTabFragment.mtK = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean mtH = false;
    private boolean mHasInit = false;
    private boolean mHasMore = false;
    private PersonPostModel.b mOnResult = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
        public void a(PersonPostModel personPostModel, boolean z) {
            PersonCenterThreadTabFragment.this.c(personPostModel, z);
        }
    };
    private PersonPostModel.a mtQ = new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.3
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
        this.mrg = new PersonPostModel(getPageContext(), getUniqueId(), this.mOnResult, isHost(), PersonPostModel.FROM_PERSON_POST);
        this.mtJ = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PersonPostModel personPostModel, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        this.mtH = false;
        hideLoadingView(this.mtE.getRootView());
        hideNetRefreshView(this.mtE.getRootView());
        if (personPostModel != null && this.mrg != null) {
            if (z) {
                this.mrg.threadList.clear();
            }
            this.mrg.threadList.addAll(com.baidu.tieba.personPolymeric.tab.b.a.fC(personPostModel.threadList));
        }
        this.mHasMore = d(personPostModel, z);
        if (y.isEmpty(this.mrg.threadList) && !j.isNetWorkAvailable()) {
            showNetRefreshView(this.mtE.getRootView(), null, false);
        } else {
            if (this.mHasMore) {
                this.mtE.XZ();
            } else {
                this.mtE.Ya();
            }
            setData(this.mrg.threadList);
        }
        com.baidu.tieba.personPolymeric.b.dzV().ht(System.currentTimeMillis() - currentTimeMillis);
        com.baidu.tieba.personPolymeric.b.dzV().setRefreshTime(System.currentTimeMillis() - com.baidu.tieba.personPolymeric.b.dzV().dyn());
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
        this.mtG = user;
        cNu();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.mtE = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.mtE.setSubType(1012);
        this.mtE.b(this);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        cNu();
    }

    private void cNu() {
        if (isAdded() && isPrimary() && this.mtG != null && !this.mHasInit) {
            this.mHasInit = true;
            com.baidu.tieba.personPolymeric.b.dzV().hu(System.currentTimeMillis());
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
        if (this.mtE != null) {
            this.mtE.fF(list);
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
        if (this.mrg != null && this.mtE != null && this.mHasInit) {
            hideNetRefreshView(this.mtE.getRootView());
            if (j.isNetWorkAvailable()) {
                if (z && mtK) {
                    showLoadingView(this.mtE.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                wL(true);
                cBL();
                return;
            }
            showNetRefreshView(this.mtE.getRootView(), null, false);
        }
    }

    private void wL(boolean z) {
        if (!this.mtH) {
            this.mtH = true;
            this.mrg.fetchPost(getPageContext(), this.mtQ, z, String.valueOf(this.mUserId), true, 0, false, true, this.mtG);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        wJ(true);
    }

    public void cBL() {
        if (this.mtE != null && this.mHasInit) {
            this.mtE.cBL();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mrg != null && this.mHasInit && j.isNetWorkAvailable() && this.mHasMore) {
            wL(false);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mtE != null) {
            this.mtE.onChangeSkinType(i);
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
        this.mtH = false;
        if (this.mtE != null) {
            this.mtE.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a dBd() {
        return this.mtE;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<q> cQM() {
        if (this.mrg != null) {
            return this.mrg.threadList;
        }
        return null;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean dBe() {
        return this.isHost && isPrimary() && !this.mtH;
    }

    public void k(ResponsedMessage<?> responsedMessage) {
        long refreshTime = com.baidu.tieba.personPolymeric.b.dzV().getRefreshTime();
        long createTime = com.baidu.tieba.personPolymeric.b.dzV().getCreateTime();
        long bgj = com.baidu.tieba.personPolymeric.b.dzV().bgj();
        long dym = com.baidu.tieba.personPolymeric.b.dzV().dym();
        long dzX = com.baidu.tieba.personPolymeric.b.dzV().dzX();
        if (l.bFl().isSmallFlow() && createTime > 0) {
            long j = refreshTime + createTime;
            if (bgj > 0) {
                j = System.currentTimeMillis() - bgj;
            }
            h hVar = new h(1010, true, responsedMessage, 0L, createTime, dym, false, 0L, 0L, j);
            if (dzX < BdKVCache.MILLS_1Hour) {
                hVar.eg("profileTime", String.valueOf(dzX));
            }
            if (hVar != null) {
                hVar.bFi();
            }
            com.baidu.tieba.personPolymeric.b.dzV().setCreateTime(0L);
        }
    }
}
