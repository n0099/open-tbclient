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
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.n.h;
import com.baidu.tbadk.n.k;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.tab.a.b;
import java.util.List;
import tbclient.User;
/* loaded from: classes7.dex */
public class PersonCenterThreadTabFragment extends PersonCenterTabBaseFragment implements BdListView.e, a {
    private PersonPostModel mDk;
    private com.baidu.tieba.personPolymeric.tab.view.a mFJ;
    private User mFL;
    private b mFO;
    private long mUserId;
    private static boolean mFP = true;
    private static CustomMessageListener fag = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterThreadTabFragment.mFP = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean mFM = false;
    private boolean mHasInit = false;
    private boolean mHasMore = false;
    private PersonPostModel.b mOnResult = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
        public void a(PersonPostModel personPostModel, boolean z) {
            PersonCenterThreadTabFragment.this.c(personPostModel, z);
        }
    };
    private PersonPostModel.a mFV = new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.3
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
        personCenterThreadTabFragment.registerListener(fag);
        return personCenterThreadTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.mDk = new PersonPostModel(getPageContext(), getUniqueId(), this.mOnResult, isHost(), PersonPostModel.FROM_PERSON_POST);
        this.mFO = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PersonPostModel personPostModel, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        this.mFM = false;
        hideLoadingView(this.mFJ.getRootView());
        hideNetRefreshView(this.mFJ.getRootView());
        if (personPostModel != null && this.mDk != null) {
            if (z) {
                this.mDk.threadList.clear();
            }
            this.mDk.threadList.addAll(com.baidu.tieba.personPolymeric.tab.b.a.fA(personPostModel.threadList));
        }
        this.mHasMore = d(personPostModel, z);
        if (y.isEmpty(this.mDk.threadList) && !j.isNetWorkAvailable()) {
            showNetRefreshView(this.mFJ.getRootView(), null, false);
        } else {
            if (this.mHasMore) {
                this.mFJ.Xa();
            } else {
                this.mFJ.Xb();
            }
            setData(this.mDk.threadList);
        }
        com.baidu.tieba.personPolymeric.b.dyt().ht(System.currentTimeMillis() - currentTimeMillis);
        com.baidu.tieba.personPolymeric.b.dyt().setRefreshTime(System.currentTimeMillis() - com.baidu.tieba.personPolymeric.b.dyt().dwL());
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
        this.mFL = user;
        cOV();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.mFJ = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.mFJ.setSubType(1012);
        this.mFJ.b(this);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        cOV();
    }

    private void cOV() {
        if (isAdded() && isPrimary() && this.mFL != null && !this.mHasInit) {
            this.mHasInit = true;
            com.baidu.tieba.personPolymeric.b.dyt().hu(System.currentTimeMillis());
            wX(true);
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
        if (this.mFJ != null) {
            this.mFJ.fD(list);
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
    public void wX(boolean z) {
        if (this.mDk != null && this.mFJ != null && this.mHasInit) {
            hideNetRefreshView(this.mFJ.getRootView());
            if (j.isNetWorkAvailable()) {
                if (z && mFP) {
                    showLoadingView(this.mFJ.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                wZ(true);
                cCm();
                return;
            }
            showNetRefreshView(this.mFJ.getRootView(), null, false);
        }
    }

    private void wZ(boolean z) {
        if (!this.mFM) {
            this.mFM = true;
            this.mDk.fetchPost(getPageContext(), this.mFV, z, String.valueOf(this.mUserId), true, 0, false, true, this.mFL);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        wX(true);
    }

    public void cCm() {
        if (this.mFJ != null && this.mHasInit) {
            this.mFJ.cCm();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mDk != null && this.mHasInit && j.isNetWorkAvailable() && this.mHasMore) {
            wZ(false);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mFJ != null) {
            this.mFJ.onChangeSkinType(i);
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
        this.mFM = false;
        if (this.mFJ != null) {
            this.mFJ.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a dzB() {
        return this.mFJ;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<n> cSp() {
        if (this.mDk != null) {
            return this.mDk.threadList;
        }
        return null;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean dzC() {
        return this.isHost && isPrimary() && !this.mFM;
    }

    public void k(ResponsedMessage<?> responsedMessage) {
        long refreshTime = com.baidu.tieba.personPolymeric.b.dyt().getRefreshTime();
        long createTime = com.baidu.tieba.personPolymeric.b.dyt().getCreateTime();
        long bfc = com.baidu.tieba.personPolymeric.b.dyt().bfc();
        long dwK = com.baidu.tieba.personPolymeric.b.dyt().dwK();
        long dyv = com.baidu.tieba.personPolymeric.b.dyt().dyv();
        if (k.bEk().isSmallFlow() && createTime > 0) {
            long j = refreshTime + createTime;
            if (bfc > 0) {
                j = System.currentTimeMillis() - bfc;
            }
            h hVar = new h(1010, true, responsedMessage, 0L, createTime, dwK, false, 0L, 0L, j);
            if (dyv < BdKVCache.MILLS_1Hour) {
                hVar.dZ("profileTime", String.valueOf(dyv));
            }
            if (hVar != null) {
                hVar.bEh();
            }
            com.baidu.tieba.personPolymeric.b.dyt().setCreateTime(0L);
        }
    }
}
