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
    private PersonPostModel lWJ;
    private com.baidu.tieba.personPolymeric.tab.view.a lZg;
    private User lZi;
    private b lZl;
    private long mUserId;
    private static boolean lZm = true;
    private static CustomMessageListener eFa = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterThreadTabFragment.lZm = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean lZj = false;
    private boolean mHasInit = false;
    private boolean mHasMore = false;
    private PersonPostModel.b mOnResult = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
        public void a(PersonPostModel personPostModel, boolean z) {
            PersonCenterThreadTabFragment.this.c(personPostModel, z);
        }
    };
    private PersonPostModel.a lZs = new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.3
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
        personCenterThreadTabFragment.registerListener(eFa);
        return personCenterThreadTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.lWJ = new PersonPostModel(getPageContext(), getUniqueId(), this.mOnResult, isHost(), PersonPostModel.FROM_PERSON_POST);
        this.lZl = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PersonPostModel personPostModel, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        this.lZj = false;
        hideLoadingView(this.lZg.getRootView());
        hideNetRefreshView(this.lZg.getRootView());
        if (personPostModel != null && this.lWJ != null) {
            if (z) {
                this.lWJ.threadList.clear();
            }
            this.lWJ.threadList.addAll(com.baidu.tieba.personPolymeric.tab.b.a.fi(personPostModel.threadList));
        }
        this.mHasMore = d(personPostModel, z);
        if (y.isEmpty(this.lWJ.threadList) && !j.isNetWorkAvailable()) {
            showNetRefreshView(this.lZg.getRootView(), null, false);
        } else {
            if (this.mHasMore) {
                this.lZg.TI();
            } else {
                this.lZg.TJ();
            }
            setData(this.lWJ.threadList);
        }
        com.baidu.tieba.personPolymeric.b.dsB().gp(System.currentTimeMillis() - currentTimeMillis);
        com.baidu.tieba.personPolymeric.b.dsB().setRefreshTime(System.currentTimeMillis() - com.baidu.tieba.personPolymeric.b.dsB().dqT());
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
        this.lZi = user;
        cFZ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.lZg = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.lZg.setSubType(1012);
        this.lZg.b(this);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        cFZ();
    }

    private void cFZ() {
        if (isAdded() && isPrimary() && this.lZi != null && !this.mHasInit) {
            this.mHasInit = true;
            com.baidu.tieba.personPolymeric.b.dsB().gq(System.currentTimeMillis());
            vT(true);
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
        if (this.lZg != null) {
            this.lZg.fl(list);
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
    public void vT(boolean z) {
        if (this.lWJ != null && this.lZg != null && this.mHasInit) {
            hideNetRefreshView(this.lZg.getRootView());
            if (j.isNetWorkAvailable()) {
                if (z && lZm) {
                    showLoadingView(this.lZg.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                vV(true);
                cvr();
                return;
            }
            showNetRefreshView(this.lZg.getRootView(), null, false);
        }
    }

    private void vV(boolean z) {
        if (!this.lZj) {
            this.lZj = true;
            this.lWJ.fetchPost(getPageContext(), this.lZs, z, String.valueOf(this.mUserId), true, 0, false, true, this.lZi);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        vT(true);
    }

    public void cvr() {
        if (this.lZg != null && this.mHasInit) {
            this.lZg.cvr();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.lWJ != null && this.mHasInit && j.isNetWorkAvailable() && this.mHasMore) {
            vV(false);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lZg != null) {
            this.lZg.onChangeSkinType(i);
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
        this.lZj = false;
        if (this.lZg != null) {
            this.lZg.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a dtJ() {
        return this.lZg;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<q> cJq() {
        if (this.lWJ != null) {
            return this.lWJ.threadList;
        }
        return null;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean dtK() {
        return this.isHost && isPrimary() && !this.lZj;
    }

    public void k(ResponsedMessage<?> responsedMessage) {
        long refreshTime = com.baidu.tieba.personPolymeric.b.dsB().getRefreshTime();
        long createTime = com.baidu.tieba.personPolymeric.b.dsB().getCreateTime();
        long bbl = com.baidu.tieba.personPolymeric.b.dsB().bbl();
        long dqS = com.baidu.tieba.personPolymeric.b.dsB().dqS();
        long dsD = com.baidu.tieba.personPolymeric.b.dsB().dsD();
        if (m.bzV().bzW() && createTime > 0) {
            long j = refreshTime + createTime;
            if (bbl > 0) {
                j = System.currentTimeMillis() - bbl;
            }
            i iVar = new i(1010, true, responsedMessage, 0L, createTime, dqS, false, 0L, 0L, j);
            if (dsD < BdKVCache.MILLS_1Hour) {
                iVar.dZ("profileTime", String.valueOf(dsD));
            }
            if (iVar != null) {
                iVar.bzS();
            }
            com.baidu.tieba.personPolymeric.b.dsB().setCreateTime(0L);
        }
    }
}
