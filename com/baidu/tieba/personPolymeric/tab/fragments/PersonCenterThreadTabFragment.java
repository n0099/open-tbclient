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
/* loaded from: classes8.dex */
public class PersonCenterThreadTabFragment extends PersonCenterTabBaseFragment implements BdListView.e, a {
    private long mUserId;
    private PersonPostModel mwv;
    private com.baidu.tieba.personPolymeric.tab.view.a myS;
    private User myU;
    private b myX;
    private static boolean myY = true;
    private static CustomMessageListener faZ = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterThreadTabFragment.myY = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean myV = false;
    private boolean mHasInit = false;
    private boolean mHasMore = false;
    private PersonPostModel.b mOnResult = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
        public void a(PersonPostModel personPostModel, boolean z) {
            PersonCenterThreadTabFragment.this.c(personPostModel, z);
        }
    };
    private PersonPostModel.a mze = new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            PersonCenterThreadTabFragment.this.c(personPostModel, z);
        }
    };

    public static PersonCenterThreadTabFragment q(long j, boolean z) {
        PersonCenterThreadTabFragment personCenterThreadTabFragment = new PersonCenterThreadTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterThreadTabFragment.setArguments(bundle);
        personCenterThreadTabFragment.registerListener(faZ);
        return personCenterThreadTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.mwv = new PersonPostModel(getPageContext(), getUniqueId(), this.mOnResult, isHost(), PersonPostModel.FROM_PERSON_POST);
        this.myX = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PersonPostModel personPostModel, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        this.myV = false;
        hideLoadingView(this.myS.getRootView());
        hideNetRefreshView(this.myS.getRootView());
        if (personPostModel != null && this.mwv != null) {
            if (z) {
                this.mwv.threadList.clear();
            }
            this.mwv.threadList.addAll(com.baidu.tieba.personPolymeric.tab.b.a.fC(personPostModel.threadList));
        }
        this.mHasMore = d(personPostModel, z);
        if (x.isEmpty(this.mwv.threadList) && !j.isNetWorkAvailable()) {
            showNetRefreshView(this.myS.getRootView(), null, false);
        } else {
            if (this.mHasMore) {
                this.myS.Zh();
            } else {
                this.myS.Zi();
            }
            setData(this.mwv.threadList);
        }
        com.baidu.tieba.personPolymeric.b.dzM().ho(System.currentTimeMillis() - currentTimeMillis);
        com.baidu.tieba.personPolymeric.b.dzM().setRefreshTime(System.currentTimeMillis() - com.baidu.tieba.personPolymeric.b.dzM().dye());
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
        this.myU = user;
        cQC();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.myS = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.myS.setSubType(1012);
        this.myS.b(this);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        cQC();
    }

    private void cQC() {
        if (isAdded() && isPrimary() && this.myU != null && !this.mHasInit) {
            this.mHasInit = true;
            com.baidu.tieba.personPolymeric.b.dzM().hp(System.currentTimeMillis());
            wK(true);
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
        if (this.myS != null) {
            this.myS.fF(list);
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
    public void wK(boolean z) {
        if (this.mwv != null && this.myS != null && this.mHasInit) {
            hideNetRefreshView(this.myS.getRootView());
            if (j.isNetWorkAvailable()) {
                if (z && myY) {
                    showLoadingView(this.myS.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                wM(true);
                cEG();
                return;
            }
            showNetRefreshView(this.myS.getRootView(), null, false);
        }
    }

    private void wM(boolean z) {
        if (!this.myV) {
            this.myV = true;
            this.mwv.fetchPost(getPageContext(), this.mze, z, String.valueOf(this.mUserId), true, 0, false, true, this.myU);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        wK(true);
    }

    public void cEG() {
        if (this.myS != null && this.mHasInit) {
            this.myS.cEG();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mwv != null && this.mHasInit && j.isNetWorkAvailable() && this.mHasMore) {
            wM(false);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.myS != null) {
            this.myS.onChangeSkinType(i);
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
        this.myV = false;
        if (this.myS != null) {
            this.myS.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a dAU() {
        return this.myS;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<n> cTU() {
        if (this.mwv != null) {
            return this.mwv.threadList;
        }
        return null;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean dAV() {
        return this.isHost && isPrimary() && !this.myV;
    }

    public void k(ResponsedMessage<?> responsedMessage) {
        long refreshTime = com.baidu.tieba.personPolymeric.b.dzM().getRefreshTime();
        long createTime = com.baidu.tieba.personPolymeric.b.dzM().getCreateTime();
        long biH = com.baidu.tieba.personPolymeric.b.dzM().biH();
        long dyd = com.baidu.tieba.personPolymeric.b.dzM().dyd();
        long dzO = com.baidu.tieba.personPolymeric.b.dzM().dzO();
        if (k.bHG().isSmallFlow() && createTime > 0) {
            long j = refreshTime + createTime;
            if (biH > 0) {
                j = System.currentTimeMillis() - biH;
            }
            h hVar = new h(1010, true, responsedMessage, 0L, createTime, dyd, false, 0L, 0L, j);
            if (dzO < BdKVCache.MILLS_1Hour) {
                hVar.ef("profileTime", String.valueOf(dzO));
            }
            if (hVar != null) {
                hVar.bHD();
            }
            com.baidu.tieba.personPolymeric.b.dzM().setCreateTime(0L);
        }
    }
}
