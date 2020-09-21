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
    private PersonPostModel lvb;
    private com.baidu.tieba.personPolymeric.tab.view.a lxu;
    private User lxw;
    private b lxz;
    private long mUserId;
    private static boolean lxA = true;
    private static CustomMessageListener ekt = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterThreadTabFragment.lxA = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean lxx = false;
    private boolean mHasInit = false;
    private boolean mHasMore = false;
    private PersonPostModel.b mOnResult = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
        public void a(PersonPostModel personPostModel, boolean z) {
            PersonCenterThreadTabFragment.this.c(personPostModel, z);
        }
    };
    private PersonPostModel.a lxG = new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.3
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
        personCenterThreadTabFragment.registerListener(ekt);
        return personCenterThreadTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.lvb = new PersonPostModel(getPageContext(), getUniqueId(), this.mOnResult, isHost(), PersonPostModel.FROM_PERSON_POST);
        this.lxz = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PersonPostModel personPostModel, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        this.lxx = false;
        hideLoadingView(this.lxu.getRootView());
        hideNetRefreshView(this.lxu.getRootView());
        if (personPostModel != null && this.lvb != null) {
            if (z) {
                this.lvb.threadList.clear();
            }
            this.lvb.threadList.addAll(com.baidu.tieba.personPolymeric.tab.b.a.eW(personPostModel.threadList));
        }
        this.mHasMore = d(personPostModel, z);
        if (y.isEmpty(this.lvb.threadList) && !j.isNetWorkAvailable()) {
            showNetRefreshView(this.lxu.getRootView(), null, false);
        } else {
            if (this.mHasMore) {
                this.lxu.bIi();
            } else {
                this.lxu.bIj();
            }
            setData(this.lvb.threadList);
        }
        com.baidu.tieba.personPolymeric.b.dlK().fW(System.currentTimeMillis() - currentTimeMillis);
        com.baidu.tieba.personPolymeric.b.dlK().setRefreshTime(System.currentTimeMillis() - com.baidu.tieba.personPolymeric.b.dlK().dkc());
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
        this.lxw = user;
        czv();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.lxu = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.lxu.setSubType(1012);
        this.lxu.b(this);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        czv();
    }

    private void czv() {
        if (isAdded() && isPrimary() && this.lxw != null && !this.mHasInit) {
            this.mHasInit = true;
            com.baidu.tieba.personPolymeric.b.dlK().fX(System.currentTimeMillis());
            uV(true);
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
        if (this.lxu != null) {
            this.lxu.eZ(list);
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
    public void uV(boolean z) {
        if (this.lvb != null && this.lxu != null && this.mHasInit) {
            hideNetRefreshView(this.lxu.getRootView());
            if (j.isNetWorkAvailable()) {
                if (z && lxA) {
                    showLoadingView(this.lxu.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                uX(true);
                coM();
                return;
            }
            showNetRefreshView(this.lxu.getRootView(), null, false);
        }
    }

    private void uX(boolean z) {
        if (!this.lxx) {
            this.lxx = true;
            this.lvb.fetchPost(getPageContext(), this.lxG, z, String.valueOf(this.mUserId), true, 0, false, true, this.lxw);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        uV(true);
    }

    public void coM() {
        if (this.lxu != null && this.mHasInit) {
            this.lxu.coM();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.lvb != null && this.mHasInit && j.isNetWorkAvailable() && this.mHasMore) {
            uX(false);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lxu != null) {
            this.lxu.onChangeSkinType(i);
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
        this.lxx = false;
        if (this.lxu != null) {
            this.lxu.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a dmQ() {
        return this.lxu;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<q> cCA() {
        if (this.lvb != null) {
            return this.lvb.threadList;
        }
        return null;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean dmR() {
        return this.isHost && isPrimary() && !this.lxx;
    }

    public void k(ResponsedMessage<?> responsedMessage) {
        long refreshTime = com.baidu.tieba.personPolymeric.b.dlK().getRefreshTime();
        long createTime = com.baidu.tieba.personPolymeric.b.dlK().getCreateTime();
        long aWK = com.baidu.tieba.personPolymeric.b.dlK().aWK();
        long dkb = com.baidu.tieba.personPolymeric.b.dlK().dkb();
        long dlM = com.baidu.tieba.personPolymeric.b.dlK().dlM();
        if (m.bvs().bvt() && createTime > 0) {
            long j = refreshTime + createTime;
            if (aWK > 0) {
                j = System.currentTimeMillis() - aWK;
            }
            i iVar = new i(1010, true, responsedMessage, 0L, createTime, dkb, false, 0L, 0L, j);
            if (dlM < BdKVCache.MILLS_1Hour) {
                iVar.dN("profileTime", String.valueOf(dlM));
            }
            if (iVar != null) {
                iVar.bvp();
            }
            com.baidu.tieba.personPolymeric.b.dlK().setCreateTime(0L);
        }
    }
}
