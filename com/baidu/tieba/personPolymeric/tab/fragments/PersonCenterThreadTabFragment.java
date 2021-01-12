package com.baidu.tieba.personPolymeric.tab.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.n.h;
import com.baidu.tbadk.n.k;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.tab.a.b;
import java.util.List;
import tbclient.User;
/* loaded from: classes7.dex */
public class PersonCenterThreadTabFragment extends PersonCenterTabBaseFragment implements BdListView.e, a {
    private long mUserId;
    private PersonPostModel mrQ;
    private com.baidu.tieba.personPolymeric.tab.view.a muo;
    private User muq;
    private b mut;
    private static boolean muu = true;
    private static CustomMessageListener eWr = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterThreadTabFragment.muu = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean mur = false;
    private boolean mHasInit = false;
    private boolean mHasMore = false;
    private PersonPostModel.b mOnResult = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
        public void a(PersonPostModel personPostModel, boolean z) {
            PersonCenterThreadTabFragment.this.c(personPostModel, z);
        }
    };
    private PersonPostModel.a muA = new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            PersonCenterThreadTabFragment.this.c(personPostModel, z);
        }
    };

    public static PersonCenterThreadTabFragment r(long j, boolean z) {
        PersonCenterThreadTabFragment personCenterThreadTabFragment = new PersonCenterThreadTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterThreadTabFragment.setArguments(bundle);
        personCenterThreadTabFragment.registerListener(eWr);
        return personCenterThreadTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.mrQ = new PersonPostModel(getPageContext(), getUniqueId(), this.mOnResult, isHost(), PersonPostModel.FROM_PERSON_POST);
        this.mut = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PersonPostModel personPostModel, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        this.mur = false;
        hideLoadingView(this.muo.getRootView());
        hideNetRefreshView(this.muo.getRootView());
        if (personPostModel != null && this.mrQ != null) {
            if (z) {
                this.mrQ.threadList.clear();
            }
            this.mrQ.threadList.addAll(com.baidu.tieba.personPolymeric.tab.b.a.fC(personPostModel.threadList));
        }
        this.mHasMore = d(personPostModel, z);
        if (x.isEmpty(this.mrQ.threadList) && !j.isNetWorkAvailable()) {
            showNetRefreshView(this.muo.getRootView(), null, false);
        } else {
            if (this.mHasMore) {
                this.muo.Vo();
            } else {
                this.muo.Vp();
            }
            setData(this.mrQ.threadList);
        }
        com.baidu.tieba.personPolymeric.b.dvU().ho(System.currentTimeMillis() - currentTimeMillis);
        com.baidu.tieba.personPolymeric.b.dvU().setRefreshTime(System.currentTimeMillis() - com.baidu.tieba.personPolymeric.b.dvU().dum());
        if (personPostModel != null && personPostModel.getResponsedMessage() != null) {
            k(personPostModel.getResponsedMessage());
        }
    }

    private boolean d(PersonPostModel personPostModel, boolean z) {
        if (personPostModel != null) {
            return z ? personPostModel.threadList.size() >= 20 : !x.isEmpty(personPostModel.threadList);
        }
        return false;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment
    public void d(User user) {
        this.muq = user;
        cMK();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.muo = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.muo.setSubType(1012);
        this.muo.b(this);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        cMK();
    }

    private void cMK() {
        if (isAdded() && isPrimary() && this.muq != null && !this.mHasInit) {
            this.mHasInit = true;
            com.baidu.tieba.personPolymeric.b.dvU().hp(System.currentTimeMillis());
            wG(true);
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

    public void setData(List<n> list) {
        if (this.muo != null) {
            this.muo.fF(list);
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
    public void wG(boolean z) {
        if (this.mrQ != null && this.muo != null && this.mHasInit) {
            hideNetRefreshView(this.muo.getRootView());
            if (j.isNetWorkAvailable()) {
                if (z && muu) {
                    showLoadingView(this.muo.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                wI(true);
                cAO();
                return;
            }
            showNetRefreshView(this.muo.getRootView(), null, false);
        }
    }

    private void wI(boolean z) {
        if (!this.mur) {
            this.mur = true;
            this.mrQ.fetchPost(getPageContext(), this.muA, z, String.valueOf(this.mUserId), true, 0, false, true, this.muq);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        wG(true);
    }

    public void cAO() {
        if (this.muo != null && this.mHasInit) {
            this.muo.cAO();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mrQ != null && this.mHasInit && j.isNetWorkAvailable() && this.mHasMore) {
            wI(false);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.muo != null) {
            this.muo.onChangeSkinType(i);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("uid", this.mUserId);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, this.isHost);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mHasMore = false;
        this.mHasInit = false;
        this.mur = false;
        if (this.muo != null) {
            this.muo.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a dxc() {
        return this.muo;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<n> cQc() {
        if (this.mrQ != null) {
            return this.mrQ.threadList;
        }
        return null;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean dxd() {
        return this.isHost && isPrimary() && !this.mur;
    }

    public void k(ResponsedMessage<?> responsedMessage) {
        long refreshTime = com.baidu.tieba.personPolymeric.b.dvU().getRefreshTime();
        long createTime = com.baidu.tieba.personPolymeric.b.dvU().getCreateTime();
        long beN = com.baidu.tieba.personPolymeric.b.dvU().beN();
        long dul = com.baidu.tieba.personPolymeric.b.dvU().dul();
        long dvW = com.baidu.tieba.personPolymeric.b.dvU().dvW();
        if (k.bDO().isSmallFlow() && createTime > 0) {
            long j = refreshTime + createTime;
            if (beN > 0) {
                j = System.currentTimeMillis() - beN;
            }
            h hVar = new h(1010, true, responsedMessage, 0L, createTime, dul, false, 0L, 0L, j);
            if (dvW < BdKVCache.MILLS_1Hour) {
                hVar.ee("profileTime", String.valueOf(dvW));
            }
            if (hVar != null) {
                hVar.bDL();
            }
            com.baidu.tieba.personPolymeric.b.dvU().setCreateTime(0L);
        }
    }
}
