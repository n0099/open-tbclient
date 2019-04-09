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
    private BdUniqueId Zs;
    private BaseFragmentActivity cYK;
    private CustomMessageListener eCC;
    private e hQW;
    private p hQX;
    private com.baidu.tieba.personPolymeric.event.c hQY;
    private f hQZ;
    private BaseFragment hQq;
    private PersonPolymericModel hQt;
    private g hQx;
    private d hRa;
    private PersonPostModel hRb;
    private CustomMessageListener hRc;
    private CustomMessageListener hRd;
    private TbPageContext mContext;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.e> mList;
    private long mUserId;
    private View mView;
    private boolean ddh = true;
    private int mSex = 1;
    private int mSkinType = 3;
    private a hRe = new a() { // from class: com.baidu.tieba.personPolymeric.b.i.1
        @Override // com.baidu.tieba.personPolymeric.b.i.a
        public void removeThread(String str) {
            boolean z;
            if (!ap.isEmpty(str) && i.this.mList != null && i.this.mList.get(0) != null && ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bQm() != null && i.this.hQX != null) {
                ArrayList<m> bQm = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bQm();
                Iterator<m> it = bQm.iterator();
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
                    i.this.hQX.dG(PersonPostModel.mergeDynamicThreadByTime(bQm));
                }
            }
        }
    };
    private final com.baidu.tieba.view.i hRf = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.personPolymeric.b.i.6
        @Override // com.baidu.tieba.view.i
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                i.this.bNX();
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
        this.cYK = baseFragmentActivity;
        this.mContext = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.mIsHost = z;
        this.hQW = eVar;
        this.Zs = bdUniqueId;
        this.mView = eVar.mRootView;
        this.hRb = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.hQX = new p(baseFragmentActivity.getPageContext(), eVar, bdUniqueId, z, z2);
        this.hQX.O(this.mView);
        this.hQY = new com.baidu.tieba.personPolymeric.event.c(baseFragmentActivity.getPageContext());
        this.hQY.a(this.hQW);
        this.hQX.setOnViewResponseListener(this.hQY);
        this.hQX.a(this);
        resetData();
        this.hQX.a(this.hRf);
        this.hQx = this.hQW.bRN();
        this.hQX.Q(this.hQx);
        this.hQt = this.hQW.bRO();
        this.hQt.d(new com.baidu.tieba.personPolymeric.c.p(z));
        this.hRa = this.hQW.bRR();
        this.hQZ = new f(baseFragmentActivity.getPageContext(), this.hQW.bRQ(), this.hQW.bRP(), this.hQX.aDm(), bdUniqueId);
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
                    if (!eVar.bQl() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.2
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.hQX.bin();
                                i.this.hRa.ia(true);
                            }
                        }, 800L);
                    } else if (!this.mIsHost && z && this.hQt != null && this.hQt.bSo() != null && this.hQt.bSo().bSh()) {
                        this.hQX.bin();
                        ArrayList<m> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                        iVar.sex = this.mSex;
                        iVar.isHost = this.mIsHost;
                        arrayList.add(iVar);
                        this.hQX.aw(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.3
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.hQX.bin();
                                i.this.hRa.ia(true);
                            }
                        }, 800L);
                    } else {
                        this.hRa.oI(z2);
                        this.hRb.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.i.4
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                i.this.hQX.bin();
                                if (personPostModel != null) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                } else {
                                    l.showToast(i.this.mContext.getContext(), i.this.mContext.getString(d.j.data_load_error));
                                }
                                if (z4) {
                                    i.this.hQX.aw(null);
                                    i.this.hRa.aCt();
                                }
                            }
                        });
                        this.hRb.fetchPost(this.cYK.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.i.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                int S;
                                if (personPostModel.getErrorCode() != 0) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                }
                                i.this.hQX.bin();
                                if (z) {
                                    com.baidu.tieba.person.data.e eVar2 = (com.baidu.tieba.person.data.e) i.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<m> bQm = ((com.baidu.tieba.person.data.e) i.this.mList.get(1)).bQm();
                                        if (v.T(bQm)) {
                                            i.this.hRa.aCt();
                                            return;
                                        } else if (i.this.av(personPostModel.postList)) {
                                            eVar2.ov(false);
                                            i.this.hQX.aw(bQm);
                                            i.this.hRa.c(true, bQm);
                                            return;
                                        } else if (i.dH(personPostModel.postList) == 0) {
                                            eVar2.ov(false);
                                            i.this.hQX.aw(bQm);
                                            i.this.hRa.c(true, bQm);
                                            return;
                                        } else {
                                            bQm.addAll(personPostModel.postList);
                                            i.this.hRa.aeA();
                                            eVar2.au(bQm);
                                            i.this.hQX.aw(bQm);
                                            return;
                                        }
                                    }
                                    eVar2.ov(true);
                                    eVar2.au(personPostModel.postList);
                                    i.this.hQX.aw(personPostModel.postList);
                                    if (eVar2.bQm() != null && (S = v.S(eVar2.bQm())) > 0 && S <= 2) {
                                        for (int i = 0; i < S; i++) {
                                            if (eVar2.bQm().get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                                                ((com.baidu.tieba.personPolymeric.c.i) eVar2.bQm().get(i)).isHost = i.this.mIsHost;
                                                i.this.hRa.aCt();
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<m> bQm2 = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bQm();
                                if (!v.T(bQm2)) {
                                    if (i.this.av(personPostModel.postList)) {
                                        eVar.ov(false);
                                        i.this.hQX.aw(bQm2);
                                        i.this.hRa.c(true, bQm2);
                                        return;
                                    }
                                    Iterator<m> it = personPostModel.threadList.iterator();
                                    while (it.hasNext()) {
                                        m next = it.next();
                                        if (next instanceof CardPersonDynamicThreadData) {
                                            ((CardPersonDynamicThreadData) next).isHost = i.this.mIsHost;
                                        }
                                    }
                                    bQm2.addAll(personPostModel.threadList);
                                    ArrayList<m> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(bQm2);
                                    eVar.ov(true);
                                    eVar.au(mergeDynamicThreadByTime);
                                    i.this.hRa.aeA();
                                    i.this.hQX.dG(mergeDynamicThreadByTime);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z, false);
                    }
                }
            }
        } else if (!z2) {
            this.hRa.aez();
        } else {
            l.showToast(this.mContext.getContext(), this.mContext.getString(d.j.data_load_error));
            if (z) {
                ArrayList<m> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar2 = new com.baidu.tieba.personPolymeric.c.i();
                iVar2.isHost = this.mIsHost;
                arrayList2.add(iVar2);
                this.hRa.aCt();
                this.hQX.aw(arrayList2);
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

    public static int dH(List<m> list) {
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
        if (this.hQW != null) {
            this.hQW.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void g(boolean z, boolean z2, boolean z3) {
        i(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.hQW != null) {
            this.hQW.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.hRb.resetThreadPn();
        if (this.hQt != null) {
            this.hQt.resetData();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.hQX.bin();
        this.cYK.hideLoadingView(this.mView);
        if (aVar == null) {
            this.hRa.ah(TbadkCoreApplication.getInst().getString(d.j.neterror), true);
            this.hRa.aCt();
            this.hRa.xb(8);
        } else if (aVar.bbG() != null && ((aVar.bbG().getHide_stat() == 1 && aVar.bbG().getBlock_stat() == 1) || (aVar.bbG().getHide_stat() == 1 && aVar.bbG().getBlock_stat() == 2))) {
            this.hRa.oH(this.mIsHost);
            this.hRa.xb(8);
            this.hRa.aBq();
        } else {
            this.hRa.aBq();
            aVar.bSf();
            if (aVar.boy() != null) {
                z = aVar.boy().size() >= 20;
            } else {
                z = false;
            }
            if (aVar.getUserData() != null) {
                this.mSex = aVar.getUserData().getSex();
            }
            this.ddh = false;
            if (this.mIsHost) {
                aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                com.baidu.tbadk.getUserInfo.b.ane().a(aVar.getUserData());
            }
            if (this.hQx != null) {
                this.hQx.a(aVar);
            }
            if (this.hQZ != null) {
                this.hQZ.c(aVar);
            }
            com.baidu.tieba.person.data.e eVar = this.mList.get(0);
            eVar.au(aVar.boy());
            eVar.ov(z);
            this.hRa.xb(0);
            this.hQX.a(aVar, z);
            bSd();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public f bRG() {
        return this.hQZ;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.hQX != null) {
                this.hQX.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.hQq = baseFragment;
    }

    public void bSd() {
        if (!this.ddh) {
            if ((this.hQq == null || this.hQq.isPrimary()) && this.hQX != null && (this.hQX.bSv() instanceof com.baidu.tieba.view.d)) {
                ((com.baidu.tieba.view.d) this.hQX.bSv()).bSd();
            }
        }
    }

    public void bNX() {
        if (this.hQX != null && (this.hQX.bSv() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.hQX.bSv()).bNX();
        }
    }

    public void bSe() {
        if (this.hQX != null && this.hQX.aDm() != null && (this.hQX.bSv() instanceof com.baidu.tieba.personPolymeric.a)) {
            ((com.baidu.tieba.personPolymeric.a) this.hQX.bSv()).a(this.cYK, this.hQX.aDm());
            if (this.hQY != null) {
                this.hQX.setOnViewResponseListener(this.hQY);
            }
            this.hQX.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void removeThread(String str) {
        if (!ap.isEmpty(str) && this.mList != null && this.mList.get(0) != null && this.mList.get(0).bQm() != null && this.hQX != null) {
            ArrayList<m> bQm = this.mList.get(0).bQm();
            for (int i = 0; i < bQm.size() && bQm.get(i) != null; i++) {
                m mVar = bQm.get(i);
                if ((mVar instanceof CardPersonDynamicThreadData) && ap.equals(str, ((CardPersonDynamicThreadData) mVar).threadId)) {
                    this.hQX.a(i, str, this.hRe);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.Zs);
        this.hQx.onDestroy();
        if (this.hQX != null) {
            this.hQX.onDestory();
        }
        bNX();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void iY(boolean z) {
        if (z) {
            if (this.ddh) {
                loadData();
            }
            if (TbadkCoreApplication.isLogin()) {
                bSd();
                return;
            } else {
                bNX();
                return;
            }
        }
        bNX();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            bSd();
            bSe();
            if (!this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
                this.mIsHost = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
                this.cYK.finish();
                return;
            }
            return;
        }
        bNX();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void AH(String str) {
        if (this.hQX != null) {
            this.hQX.AH(str);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void AI(String str) {
        if (this.hQX != null) {
            this.hQX.AI(str);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void bRH() {
        if (this.hQX != null) {
            this.hQX.bRH();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void oG(boolean z) {
        this.hQX.oG(z);
    }

    private void initListener() {
        this.eCC = new CustomMessageListener(2921003) { // from class: com.baidu.tieba.personPolymeric.b.i.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.bNX();
            }
        };
        this.eCC.setTag(this.Zs);
        MessageManager.getInstance().registerListener(this.eCC);
        this.hRc = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.personPolymeric.b.i.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.removeThread((String) customResponsedMessage.getData());
                }
            }
        };
        this.hRc.setTag(this.Zs);
        MessageManager.getInstance().registerListener(this.hRc);
        this.hRd = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.personPolymeric.b.i.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.removeThread((String) customResponsedMessage.getData());
                    l.showToast(i.this.mContext.getPageActivity(), d.j.person_polymeric_set_privacy_success);
                }
            }
        };
        this.hRd.setTag(this.Zs);
        MessageManager.getInstance().registerListener(this.hRd);
    }
}
