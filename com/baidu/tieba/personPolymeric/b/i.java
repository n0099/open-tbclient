package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.view.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class i implements com.baidu.tieba.model.a, com.baidu.tieba.personPolymeric.b.a {
    private BdUniqueId Zr;
    private BaseFragmentActivity cYG;
    private CustomMessageListener eCQ;
    private BaseFragment hQD;
    private PersonPolymericModel hQG;
    private g hQK;
    private e hRj;
    private p hRk;
    private com.baidu.tieba.personPolymeric.event.c hRl;
    private f hRm;
    private d hRn;
    private PersonPostModel hRo;
    private CustomMessageListener hRp;
    private CustomMessageListener hRq;
    private TbPageContext mContext;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.e> mList;
    private long mUserId;
    private View mView;
    private boolean ddc = true;
    private int mSex = 1;
    private int mSkinType = 3;
    private a hRr = new a() { // from class: com.baidu.tieba.personPolymeric.b.i.1
        @Override // com.baidu.tieba.personPolymeric.b.i.a
        public void removeThread(String str) {
            boolean z;
            if (!ap.isEmpty(str) && i.this.mList != null && i.this.mList.get(0) != null && ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bQq() != null && i.this.hRk != null) {
                ArrayList<m> bQq = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bQq();
                Iterator<m> it = bQq.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    m next = it.next();
                    if ((next instanceof CardPersonDynamicThreadData) && ap.equals(str, ((CardPersonDynamicThreadData) next).threadId)) {
                        it.remove();
                        z = true;
                        break;
                    }
                }
                if (z) {
                    i.this.hRk.dJ(PersonPostModel.mergeDynamicThreadByTime(bQq));
                }
            }
        }
    };
    private final com.baidu.tieba.view.i hRs = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.personPolymeric.b.i.6
        @Override // com.baidu.tieba.view.i
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                i.this.bOa();
            }
        }

        @Override // com.baidu.tieba.view.i
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void removeThread(String str);
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(BaseFragmentActivity baseFragmentActivity, e eVar, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.cYG = baseFragmentActivity;
        this.mContext = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.mIsHost = z;
        this.hRj = eVar;
        this.Zr = bdUniqueId;
        this.mView = eVar.mRootView;
        this.hRo = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.hRk = new p(baseFragmentActivity.getPageContext(), eVar, bdUniqueId, z, z2);
        this.hRk.O(this.mView);
        this.hRl = new com.baidu.tieba.personPolymeric.event.c(baseFragmentActivity.getPageContext());
        this.hRl.a(this.hRj);
        this.hRk.setOnViewResponseListener(this.hRl);
        this.hRk.a(this);
        resetData();
        this.hRk.a(this.hRs);
        this.hQK = this.hRj.bRR();
        this.hRk.Q(this.hQK);
        this.hQG = this.hRj.bRS();
        this.hQG.d(new com.baidu.tieba.personPolymeric.c.p(z));
        this.hRn = this.hRj.bRV();
        this.hRm = new f(baseFragmentActivity.getPageContext(), this.hRj.bRU(), this.hRj.bRT(), this.hRk.aDp(), bdUniqueId);
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
        initListener();
    }

    public void i(final boolean z, boolean z2, boolean z3) {
        if (j.kM()) {
            if (!v.T(this.mList) && this.mList.size() >= 2) {
                final com.baidu.tieba.person.data.e eVar = this.mList.get(z ? 1 : 0);
                if (eVar != null) {
                    if (!eVar.bQp() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.2
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.hRk.bip();
                                i.this.hRn.ia(true);
                            }
                        }, 800L);
                    } else if (!this.mIsHost && z && this.hQG != null && this.hQG.bSs() != null && this.hQG.bSs().bSl()) {
                        this.hRk.bip();
                        ArrayList<m> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                        iVar.sex = this.mSex;
                        iVar.isHost = this.mIsHost;
                        arrayList.add(iVar);
                        this.hRk.aw(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.3
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.hRk.bip();
                                i.this.hRn.ia(true);
                            }
                        }, 800L);
                    } else {
                        this.hRn.oI(z2);
                        this.hRo.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.i.4
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                i.this.hRk.bip();
                                if (personPostModel != null) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                } else {
                                    l.showToast(i.this.mContext.getContext(), i.this.mContext.getString(d.j.data_load_error));
                                }
                                if (z4) {
                                    i.this.hRk.aw(null);
                                    i.this.hRn.aCw();
                                }
                            }
                        });
                        this.hRo.fetchPost(this.cYG.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.i.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                int S;
                                if (personPostModel.getErrorCode() != 0) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                }
                                i.this.hRk.bip();
                                if (z) {
                                    com.baidu.tieba.person.data.e eVar2 = (com.baidu.tieba.person.data.e) i.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<m> bQq = ((com.baidu.tieba.person.data.e) i.this.mList.get(1)).bQq();
                                        if (v.T(bQq)) {
                                            i.this.hRn.aCw();
                                            return;
                                        } else if (i.this.av(personPostModel.postList)) {
                                            eVar2.ov(false);
                                            i.this.hRk.aw(bQq);
                                            i.this.hRn.c(true, bQq);
                                            return;
                                        } else if (i.dK(personPostModel.postList) == 0) {
                                            eVar2.ov(false);
                                            i.this.hRk.aw(bQq);
                                            i.this.hRn.c(true, bQq);
                                            return;
                                        } else {
                                            bQq.addAll(personPostModel.postList);
                                            i.this.hRn.aeD();
                                            eVar2.au(bQq);
                                            i.this.hRk.aw(bQq);
                                            return;
                                        }
                                    }
                                    eVar2.ov(true);
                                    eVar2.au(personPostModel.postList);
                                    i.this.hRk.aw(personPostModel.postList);
                                    if (eVar2.bQq() != null && (S = v.S(eVar2.bQq())) > 0 && S <= 2) {
                                        for (int i = 0; i < S; i++) {
                                            if (eVar2.bQq().get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                                                ((com.baidu.tieba.personPolymeric.c.i) eVar2.bQq().get(i)).isHost = i.this.mIsHost;
                                                i.this.hRn.aCw();
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<m> bQq2 = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bQq();
                                if (!v.T(bQq2)) {
                                    if (i.this.av(personPostModel.postList)) {
                                        eVar.ov(false);
                                        i.this.hRk.aw(bQq2);
                                        i.this.hRn.c(true, bQq2);
                                        return;
                                    }
                                    Iterator<m> it = personPostModel.threadList.iterator();
                                    while (it.hasNext()) {
                                        m next = it.next();
                                        if (next instanceof CardPersonDynamicThreadData) {
                                            ((CardPersonDynamicThreadData) next).isHost = i.this.mIsHost;
                                        }
                                    }
                                    bQq2.addAll(personPostModel.threadList);
                                    ArrayList<m> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(bQq2);
                                    eVar.ov(true);
                                    eVar.au(mergeDynamicThreadByTime);
                                    i.this.hRn.aeD();
                                    i.this.hRk.dJ(mergeDynamicThreadByTime);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z, false);
                    }
                }
            }
        } else if (!z2) {
            this.hRn.aeC();
        } else {
            l.showToast(this.mContext.getContext(), this.mContext.getString(d.j.data_load_error));
            if (z) {
                ArrayList<m> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar2 = new com.baidu.tieba.personPolymeric.c.i();
                iVar2.isHost = this.mIsHost;
                arrayList2.add(iVar2);
                this.hRn.aCw();
                this.hRk.aw(arrayList2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean av(ArrayList<m> arrayList) {
        int S = v.S(arrayList);
        if (S != 0) {
            if (S > 2) {
                return false;
            }
            if (!(arrayList.get(0) instanceof com.baidu.tieba.personPolymeric.c.i) && !(arrayList.get(1) instanceof com.baidu.tieba.personPolymeric.c.i)) {
                return false;
            }
        }
        return true;
    }

    public static int dK(List<m> list) {
        int i = 0;
        if (v.S(list) == 0) {
            return 0;
        }
        int size = list.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            if (list.get(i2) != null && (list.get(i2) instanceof PersonPostModel.PostInfoList)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((PersonPostModel.PostInfoList) list.get(i2));
            }
        }
        if (v.S(arrayList) == 0) {
            return 0;
        }
        int size2 = list.size();
        int i3 = 0;
        while (i3 < size2) {
            int length = ((PersonPostModel.PostInfoList) arrayList.get(i3)).content.length + i;
            i3++;
            i = length;
        }
        return i;
    }

    @Override // com.baidu.tieba.model.a
    public void refreshData() {
        if (this.hRj != null) {
            this.hRj.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void g(boolean z, boolean z2, boolean z3) {
        i(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.hRj != null) {
            this.hRj.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.hRo.resetThreadPn();
        if (this.hQG != null) {
            this.hQG.resetData();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.hRk.bip();
        this.cYG.hideLoadingView(this.mView);
        if (aVar == null) {
            this.hRn.ah(TbadkCoreApplication.getInst().getString(d.j.neterror), true);
            this.hRn.aCw();
            this.hRn.xf(8);
        } else if (aVar.bbI() != null && ((aVar.bbI().getHide_stat() == 1 && aVar.bbI().getBlock_stat() == 1) || (aVar.bbI().getHide_stat() == 1 && aVar.bbI().getBlock_stat() == 2))) {
            this.hRn.oH(this.mIsHost);
            this.hRn.xf(8);
            this.hRn.aBt();
        } else {
            this.hRn.aBt();
            aVar.bSj();
            if (aVar.boB() != null) {
                z = aVar.boB().size() >= 20;
            } else {
                z = false;
            }
            if (aVar.getUserData() != null) {
                this.mSex = aVar.getUserData().getSex();
            }
            this.ddc = false;
            if (this.mIsHost) {
                aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                com.baidu.tbadk.getUserInfo.b.anh().a(aVar.getUserData());
            }
            if (this.hQK != null) {
                this.hQK.a(aVar);
            }
            if (this.hRm != null) {
                this.hRm.c(aVar);
            }
            com.baidu.tieba.person.data.e eVar = this.mList.get(0);
            eVar.au(aVar.boB());
            eVar.ov(z);
            this.hRn.xf(0);
            this.hRk.a(aVar, z);
            bSh();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public f bRK() {
        return this.hRm;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.hRk != null) {
                this.hRk.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.hQD = baseFragment;
    }

    public void bSh() {
        if (!this.ddc) {
            if ((this.hQD == null || this.hQD.isPrimary()) && this.hRk != null && (this.hRk.bSz() instanceof com.baidu.tieba.view.d)) {
                ((com.baidu.tieba.view.d) this.hRk.bSz()).bSh();
            }
        }
    }

    public void bOa() {
        if (this.hRk != null && (this.hRk.bSz() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.hRk.bSz()).bOa();
        }
    }

    public void bSi() {
        if (this.hRk != null && this.hRk.aDp() != null && (this.hRk.bSz() instanceof com.baidu.tieba.personPolymeric.a)) {
            ((com.baidu.tieba.personPolymeric.a) this.hRk.bSz()).a(this.cYG, this.hRk.aDp());
            if (this.hRl != null) {
                this.hRk.setOnViewResponseListener(this.hRl);
            }
            this.hRk.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void removeThread(String str) {
        if (!ap.isEmpty(str) && this.mList != null && this.mList.get(0) != null && this.mList.get(0).bQq() != null && this.hRk != null) {
            ArrayList<m> bQq = this.mList.get(0).bQq();
            for (int i = 0; i < bQq.size() && bQq.get(i) != null; i++) {
                m mVar = bQq.get(i);
                if ((mVar instanceof CardPersonDynamicThreadData) && ap.equals(str, ((CardPersonDynamicThreadData) mVar).threadId)) {
                    this.hRk.a(i, str, this.hRr);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.Zr);
        this.hQK.onDestroy();
        if (this.hRk != null) {
            this.hRk.onDestory();
        }
        bOa();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void iY(boolean z) {
        if (z) {
            if (this.ddc) {
                loadData();
            }
            if (TbadkCoreApplication.isLogin()) {
                bSh();
                return;
            } else {
                bOa();
                return;
            }
        }
        bOa();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            bSh();
            bSi();
            if (!this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
                this.mIsHost = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
                this.cYG.finish();
                return;
            }
            return;
        }
        bOa();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void AI(String str) {
        if (this.hRk != null) {
            this.hRk.AI(str);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void AJ(String str) {
        if (this.hRk != null) {
            this.hRk.AJ(str);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void bRL() {
        if (this.hRk != null) {
            this.hRk.bRL();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void oG(boolean z) {
        this.hRk.oG(z);
    }

    private void initListener() {
        this.eCQ = new CustomMessageListener(2921003) { // from class: com.baidu.tieba.personPolymeric.b.i.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.bOa();
            }
        };
        this.eCQ.setTag(this.Zr);
        MessageManager.getInstance().registerListener(this.eCQ);
        this.hRp = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.personPolymeric.b.i.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.removeThread((String) customResponsedMessage.getData());
                }
            }
        };
        this.hRp.setTag(this.Zr);
        MessageManager.getInstance().registerListener(this.hRp);
        this.hRq = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.personPolymeric.b.i.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.removeThread((String) customResponsedMessage.getData());
                    l.showToast(i.this.mContext.getPageActivity(), d.j.person_polymeric_set_privacy_success);
                }
            }
        };
        this.hRq.setTag(this.Zr);
        MessageManager.getInstance().registerListener(this.hRq);
    }
}
