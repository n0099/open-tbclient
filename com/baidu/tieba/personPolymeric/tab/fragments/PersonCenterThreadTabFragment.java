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
    private long mUserId;
    private PersonPostModel mcI;
    private com.baidu.tieba.personPolymeric.tab.view.a mfg;
    private User mfi;
    private b mfl;
    private static boolean mfm = true;
    private static CustomMessageListener eKP = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterThreadTabFragment.mfm = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean mfj = false;
    private boolean mHasInit = false;
    private boolean mHasMore = false;
    private PersonPostModel.b mOnResult = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
        public void a(PersonPostModel personPostModel, boolean z) {
            PersonCenterThreadTabFragment.this.c(personPostModel, z);
        }
    };
    private PersonPostModel.a mfs = new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.3
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
        personCenterThreadTabFragment.registerListener(eKP);
        return personCenterThreadTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.mcI = new PersonPostModel(getPageContext(), getUniqueId(), this.mOnResult, isHost(), PersonPostModel.FROM_PERSON_POST);
        this.mfl = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PersonPostModel personPostModel, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        this.mfj = false;
        hideLoadingView(this.mfg.getRootView());
        hideNetRefreshView(this.mfg.getRootView());
        if (personPostModel != null && this.mcI != null) {
            if (z) {
                this.mcI.threadList.clear();
            }
            this.mcI.threadList.addAll(com.baidu.tieba.personPolymeric.tab.b.a.fq(personPostModel.threadList));
        }
        this.mHasMore = d(personPostModel, z);
        if (y.isEmpty(this.mcI.threadList) && !j.isNetWorkAvailable()) {
            showNetRefreshView(this.mfg.getRootView(), null, false);
        } else {
            if (this.mHasMore) {
                this.mfg.Wi();
            } else {
                this.mfg.Wj();
            }
            setData(this.mcI.threadList);
        }
        com.baidu.tieba.personPolymeric.b.dvd().gL(System.currentTimeMillis() - currentTimeMillis);
        com.baidu.tieba.personPolymeric.b.dvd().setRefreshTime(System.currentTimeMillis() - com.baidu.tieba.personPolymeric.b.dvd().dtv());
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
        this.mfi = user;
        cIA();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.mfg = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.mfg.setSubType(1012);
        this.mfg.b(this);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        cIA();
    }

    private void cIA() {
        if (isAdded() && isPrimary() && this.mfi != null && !this.mHasInit) {
            this.mHasInit = true;
            com.baidu.tieba.personPolymeric.b.dvd().gM(System.currentTimeMillis());
            wc(true);
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
        if (this.mfg != null) {
            this.mfg.ft(list);
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
    public void wc(boolean z) {
        if (this.mcI != null && this.mfg != null && this.mHasInit) {
            hideNetRefreshView(this.mfg.getRootView());
            if (j.isNetWorkAvailable()) {
                if (z && mfm) {
                    showLoadingView(this.mfg.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                we(true);
                cxS();
                return;
            }
            showNetRefreshView(this.mfg.getRootView(), null, false);
        }
    }

    private void we(boolean z) {
        if (!this.mfj) {
            this.mfj = true;
            this.mcI.fetchPost(getPageContext(), this.mfs, z, String.valueOf(this.mUserId), true, 0, false, true, this.mfi);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        wc(true);
    }

    public void cxS() {
        if (this.mfg != null && this.mHasInit) {
            this.mfg.cxS();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mcI != null && this.mHasInit && j.isNetWorkAvailable() && this.mHasMore) {
            we(false);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mfg != null) {
            this.mfg.onChangeSkinType(i);
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
        this.mfj = false;
        if (this.mfg != null) {
            this.mfg.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a dwl() {
        return this.mfg;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<q> cLR() {
        if (this.mcI != null) {
            return this.mcI.threadList;
        }
        return null;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean dwm() {
        return this.isHost && isPrimary() && !this.mfj;
    }

    public void k(ResponsedMessage<?> responsedMessage) {
        long refreshTime = com.baidu.tieba.personPolymeric.b.dvd().getRefreshTime();
        long createTime = com.baidu.tieba.personPolymeric.b.dvd().getCreateTime();
        long bdL = com.baidu.tieba.personPolymeric.b.dvd().bdL();
        long dtu = com.baidu.tieba.personPolymeric.b.dvd().dtu();
        long dvf = com.baidu.tieba.personPolymeric.b.dvd().dvf();
        if (m.bCu().bCv() && createTime > 0) {
            long j = refreshTime + createTime;
            if (bdL > 0) {
                j = System.currentTimeMillis() - bdL;
            }
            i iVar = new i(1010, true, responsedMessage, 0L, createTime, dtu, false, 0L, 0L, j);
            if (dvf < BdKVCache.MILLS_1Hour) {
                iVar.dZ("profileTime", String.valueOf(dvf));
            }
            if (iVar != null) {
                iVar.bCr();
            }
            com.baidu.tieba.personPolymeric.b.dvd().setCreateTime(0L);
        }
    }
}
