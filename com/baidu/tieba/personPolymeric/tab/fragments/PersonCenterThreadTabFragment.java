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
    private PersonPostModel llT;
    private com.baidu.tieba.personPolymeric.tab.view.a loq;
    private User los;
    private b lov;
    private long mUserId;
    private static boolean lox = true;
    private static CustomMessageListener eia = new CustomMessageListener(2921440) { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean unused = PersonCenterThreadTabFragment.lox = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private boolean isHost = false;
    private boolean lot = false;
    private boolean mHasInit = false;
    private boolean mHasMore = false;
    private PersonPostModel.b mOnResult = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.2
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
        public void a(PersonPostModel personPostModel, boolean z) {
            PersonCenterThreadTabFragment.this.c(personPostModel, z);
        }
    };
    private PersonPostModel.a loD = new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment.3
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
        personCenterThreadTabFragment.registerListener(eia);
        return personCenterThreadTabFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.llT = new PersonPostModel(getPageContext(), getUniqueId(), this.mOnResult, isHost(), PersonPostModel.FROM_PERSON_POST);
        this.lov = new b(getPageContext(), getUniqueId(), this, getTabType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PersonPostModel personPostModel, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        this.lot = false;
        hideLoadingView(this.loq.getRootView());
        hideNetRefreshView(this.loq.getRootView());
        if (personPostModel != null && this.llT != null) {
            if (z) {
                this.llT.threadList.clear();
            }
            this.llT.threadList.addAll(com.baidu.tieba.personPolymeric.tab.b.a.eO(personPostModel.threadList));
        }
        this.mHasMore = d(personPostModel, z);
        if (y.isEmpty(this.llT.threadList) && !j.isNetWorkAvailable()) {
            showNetRefreshView(this.loq.getRootView(), null, false);
        } else {
            if (this.mHasMore) {
                this.loq.bGR();
            } else {
                this.loq.bGS();
            }
            setData(this.llT.threadList);
        }
        com.baidu.tieba.personPolymeric.b.die().fI(System.currentTimeMillis() - currentTimeMillis);
        com.baidu.tieba.personPolymeric.b.die().setRefreshTime(System.currentTimeMillis() - com.baidu.tieba.personPolymeric.b.die().dgy());
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
        this.los = user;
        cwa();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.person_center_common_tab_layout, viewGroup, false);
        this.loq = new com.baidu.tieba.personPolymeric.tab.view.a(getPageContext(), inflate, this);
        this.loq.setSubType(1012);
        this.loq.b(this);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        cwa();
    }

    private void cwa() {
        com.baidu.tieba.personPolymeric.b.die().fJ(System.currentTimeMillis());
        if (isAdded() && isPrimary() && this.los != null && !this.mHasInit) {
            this.mHasInit = true;
            uL(true);
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
        if (this.loq != null) {
            this.loq.eR(list);
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
    public void uL(boolean z) {
        if (this.llT != null && this.loq != null && this.mHasInit) {
            hideNetRefreshView(this.loq.getRootView());
            if (j.isNetWorkAvailable()) {
                if (z && lox) {
                    showLoadingView(this.loq.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds250));
                }
                uN(true);
                clz();
                return;
            }
            showNetRefreshView(this.loq.getRootView(), null, false);
        }
    }

    private void uN(boolean z) {
        if (!this.lot) {
            this.lot = true;
            this.llT.fetchPost(getPageContext(), this.loD, z, String.valueOf(this.mUserId), true, 0, false, true, this.los);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        uL(true);
    }

    public void clz() {
        if (this.loq != null && this.mHasInit) {
            this.loq.clz();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.llT != null && this.mHasInit && j.isNetWorkAvailable() && this.mHasMore) {
            uN(false);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.loq != null) {
            this.loq.onChangeSkinType(i);
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
        this.lot = false;
        if (this.loq != null) {
            this.loq.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public com.baidu.tieba.personPolymeric.tab.view.a dji() {
        return this.loq;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public List<q> cyS() {
        if (this.llT != null) {
            return this.llT.threadList;
        }
        return null;
    }

    @Override // com.baidu.tieba.personPolymeric.tab.fragments.a
    public boolean djj() {
        return this.isHost && isPrimary() && !this.lot;
    }

    public void k(ResponsedMessage<?> responsedMessage) {
        long refreshTime = com.baidu.tieba.personPolymeric.b.die().getRefreshTime();
        long createTime = com.baidu.tieba.personPolymeric.b.die().getCreateTime();
        long aVY = com.baidu.tieba.personPolymeric.b.die().aVY();
        long dgx = com.baidu.tieba.personPolymeric.b.die().dgx();
        if (m.bun().buo() && createTime > 0) {
            long j = refreshTime + createTime;
            if (aVY > 0) {
                j = System.currentTimeMillis() - aVY;
            }
            i iVar = new i(1010, true, responsedMessage, 0L, createTime, dgx, false, 0L, 0L, j);
            if (iVar != null) {
                iVar.buk();
            }
            com.baidu.tieba.personPolymeric.b.die().setCreateTime(0L);
        }
    }
}
