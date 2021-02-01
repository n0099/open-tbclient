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
/* loaded from: classes8.dex */
public class PersonCenterThreadTabFragment extends PersonCenterTabBaseFragment implements BdListView.e, a {
    private PersonPostModel mAQ;
    private com.baidu.tieba.personPolymeric.tab.view.a mDq;
    private User mDs;
    private b mDv;
    private long mUserId;
    private static boolean mDw = true;
    private static CustomMessageListener eYH = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterThreadTabFragment.mDw = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean mDt = false;
    private boolean mHasInit = false;
    private boolean mHasMore = false;
    private PersonPostModel.b mOnResult = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
        public void a(PersonPostModel personPostModel, boolean z) {
            PersonCenterThreadTabFragment.this.c(personPostModel, z);
        }
    };
    private PersonPostModel.a mDE = new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.3
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
        personCenterThreadTabFragment.registerListener(eYH);
        return personCenterThreadTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.mAQ = new PersonPostModel(getPageContext(), getUniqueId(), this.mOnResult, isHost(), PersonPostModel.FROM_PERSON_POST);
        this.mDv = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PersonPostModel personPostModel, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        this.mDt = false;
        hideLoadingView(this.mDq.getRootView());
        hideNetRefreshView(this.mDq.getRootView());
        if (personPostModel != null && this.mAQ != null) {
            if (z) {
                this.mAQ.threadList.clear();
            }
            this.mAQ.threadList.addAll(com.baidu.tieba.personPolymeric.tab.b.a.fA(personPostModel.threadList));
        }
        this.mHasMore = d(personPostModel, z);
        if (y.isEmpty(this.mAQ.threadList) && !j.isNetWorkAvailable()) {
            showNetRefreshView(this.mDq.getRootView(), null, false);
        } else {
            if (this.mHasMore) {
                this.mDq.WX();
            } else {
                this.mDq.WY();
            }
            setData(this.mAQ.threadList);
        }
        com.baidu.tieba.personPolymeric.b.dyd().ht(System.currentTimeMillis() - currentTimeMillis);
        com.baidu.tieba.personPolymeric.b.dyd().setRefreshTime(System.currentTimeMillis() - com.baidu.tieba.personPolymeric.b.dyd().dwv());
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
        this.mDs = user;
        cOH();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.mDq = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.mDq.setSubType(1012);
        this.mDq.b(this);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        cOH();
    }

    private void cOH() {
        if (isAdded() && isPrimary() && this.mDs != null && !this.mHasInit) {
            this.mHasInit = true;
            com.baidu.tieba.personPolymeric.b.dyd().hu(System.currentTimeMillis());
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
        if (this.mDq != null) {
            this.mDq.fD(list);
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
        if (this.mAQ != null && this.mDq != null && this.mHasInit) {
            hideNetRefreshView(this.mDq.getRootView());
            if (j.isNetWorkAvailable()) {
                if (z && mDw) {
                    showLoadingView(this.mDq.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                wZ(true);
                cBZ();
                return;
            }
            showNetRefreshView(this.mDq.getRootView(), null, false);
        }
    }

    private void wZ(boolean z) {
        if (!this.mDt) {
            this.mDt = true;
            this.mAQ.fetchPost(getPageContext(), this.mDE, z, String.valueOf(this.mUserId), true, 0, false, true, this.mDs);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        wX(true);
    }

    public void cBZ() {
        if (this.mDq != null && this.mHasInit) {
            this.mDq.cBZ();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mAQ != null && this.mHasInit && j.isNetWorkAvailable() && this.mHasMore) {
            wZ(false);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mDq != null) {
            this.mDq.onChangeSkinType(i);
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
        this.mDt = false;
        if (this.mDq != null) {
            this.mDq.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a dzl() {
        return this.mDq;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<n> cSb() {
        if (this.mAQ != null) {
            return this.mAQ.threadList;
        }
        return null;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean dzm() {
        return this.isHost && isPrimary() && !this.mDt;
    }

    public void k(ResponsedMessage<?> responsedMessage) {
        long refreshTime = com.baidu.tieba.personPolymeric.b.dyd().getRefreshTime();
        long createTime = com.baidu.tieba.personPolymeric.b.dyd().getCreateTime();
        long bfa = com.baidu.tieba.personPolymeric.b.dyd().bfa();
        long dwu = com.baidu.tieba.personPolymeric.b.dyd().dwu();
        long dyf = com.baidu.tieba.personPolymeric.b.dyd().dyf();
        if (k.bEg().isSmallFlow() && createTime > 0) {
            long j = refreshTime + createTime;
            if (bfa > 0) {
                j = System.currentTimeMillis() - bfa;
            }
            h hVar = new h(1010, true, responsedMessage, 0L, createTime, dwu, false, 0L, 0L, j);
            if (dyf < BdKVCache.MILLS_1Hour) {
                hVar.dZ("profileTime", String.valueOf(dyf));
            }
            if (hVar != null) {
                hVar.bEd();
            }
            com.baidu.tieba.personPolymeric.b.dyd().setCreateTime(0L);
        }
    }
}
