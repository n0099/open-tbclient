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
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.n.i;
import com.baidu.tbadk.n.m;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.tab.a.b;
import java.util.List;
import tbclient.User;
/* loaded from: classes18.dex */
public class PersonCenterThreadTabFragment extends PersonCenterTabBaseFragment implements BdListView.e, a {
    private PersonPostModel lme;
    private com.baidu.tieba.personPolymeric.tab.view.a loC;
    private User loE;
    private b loH;
    private long mUserId;
    private static boolean loI = true;
    private static CustomMessageListener eie = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterThreadTabFragment.loI = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean loF = false;
    private boolean mHasInit = false;
    private boolean mHasMore = false;
    private PersonPostModel.b mOnResult = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
        public void a(PersonPostModel personPostModel, boolean z) {
            PersonCenterThreadTabFragment.this.c(personPostModel, z);
        }
    };
    private PersonPostModel.a loO = new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            PersonCenterThreadTabFragment.this.c(personPostModel, z);
        }
    };

    public static PersonCenterThreadTabFragment m(long j, boolean z) {
        PersonCenterThreadTabFragment personCenterThreadTabFragment = new PersonCenterThreadTabFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean(AlaPersonCenterExpActivityConfig.IS_HOST, z);
        personCenterThreadTabFragment.setArguments(bundle);
        personCenterThreadTabFragment.registerListener(eie);
        return personCenterThreadTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.lme = new PersonPostModel(getPageContext(), getUniqueId(), this.mOnResult, isHost(), PersonPostModel.FROM_PERSON_POST);
        this.loH = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PersonPostModel personPostModel, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        this.loF = false;
        hideLoadingView(this.loC.getRootView());
        hideNetRefreshView(this.loC.getRootView());
        if (personPostModel != null && this.lme != null) {
            if (z) {
                this.lme.threadList.clear();
            }
            this.lme.threadList.addAll(com.baidu.tieba.personPolymeric.tab.b.a.eO(personPostModel.threadList));
        }
        this.mHasMore = d(personPostModel, z);
        if (y.isEmpty(this.lme.threadList) && !j.isNetWorkAvailable()) {
            showNetRefreshView(this.loC.getRootView(), null, false);
        } else {
            if (this.mHasMore) {
                this.loC.bGS();
            } else {
                this.loC.bGT();
            }
            setData(this.lme.threadList);
        }
        com.baidu.tieba.personPolymeric.b.dif().fI(System.currentTimeMillis() - currentTimeMillis);
        com.baidu.tieba.personPolymeric.b.dif().setRefreshTime(System.currentTimeMillis() - com.baidu.tieba.personPolymeric.b.dif().dgz());
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
        this.loE = user;
        cwb();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.loC = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.loC.setSubType(1012);
        this.loC.b(this);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        cwb();
    }

    private void cwb() {
        if (isAdded() && isPrimary() && this.loE != null && !this.mHasInit) {
            this.mHasInit = true;
            com.baidu.tieba.personPolymeric.b.dif().fJ(System.currentTimeMillis());
            uN(true);
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
        if (this.loC != null) {
            this.loC.eR(list);
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
    public void uN(boolean z) {
        if (this.lme != null && this.loC != null && this.mHasInit) {
            hideNetRefreshView(this.loC.getRootView());
            if (j.isNetWorkAvailable()) {
                if (z && loI) {
                    showLoadingView(this.loC.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                uP(true);
                clA();
                return;
            }
            showNetRefreshView(this.loC.getRootView(), null, false);
        }
    }

    private void uP(boolean z) {
        if (!this.loF) {
            this.loF = true;
            this.lme.fetchPost(getPageContext(), this.loO, z, String.valueOf(this.mUserId), true, 0, false, true, this.loE);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        uN(true);
    }

    public void clA() {
        if (this.loC != null && this.mHasInit) {
            this.loC.clA();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.lme != null && this.mHasInit && j.isNetWorkAvailable() && this.mHasMore) {
            uP(false);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.loC != null) {
            this.loC.onChangeSkinType(i);
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
        this.loF = false;
        if (this.loC != null) {
            this.loC.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a djl() {
        return this.loC;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<q> cyT() {
        if (this.lme != null) {
            return this.lme.threadList;
        }
        return null;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean djm() {
        return this.isHost && isPrimary() && !this.loF;
    }

    public void k(ResponsedMessage<?> responsedMessage) {
        long refreshTime = com.baidu.tieba.personPolymeric.b.dif().getRefreshTime();
        long createTime = com.baidu.tieba.personPolymeric.b.dif().getCreateTime();
        long aVY = com.baidu.tieba.personPolymeric.b.dif().aVY();
        long dgy = com.baidu.tieba.personPolymeric.b.dif().dgy();
        long dih = com.baidu.tieba.personPolymeric.b.dif().dih();
        if (m.buo().bup() && createTime > 0) {
            long j = refreshTime + createTime;
            if (aVY > 0) {
                j = System.currentTimeMillis() - aVY;
            }
            i iVar = new i(1010, true, responsedMessage, 0L, createTime, dgy, false, 0L, 0L, j);
            iVar.dL("profileTime", String.valueOf(dih));
            if (iVar != null) {
                iVar.bul();
            }
            com.baidu.tieba.personPolymeric.b.dif().setCreateTime(0L);
        }
    }
}
