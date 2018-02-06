package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.c.p;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.view.s;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class i implements com.baidu.tieba.model.a, com.baidu.tieba.personPolymeric.b.a {
    private TbPageContext aRR;
    private BdUniqueId brv;
    private CustomMessageListener dpM;
    private BaseFragmentActivity fAn;
    private e goK;
    private s goL;
    private com.baidu.tieba.personPolymeric.event.c goM;
    private f goN;
    private d goO;
    private PersonPostModel goP;
    private CustomMessageListener goQ;
    private CustomMessageListener goR;
    private CustomMessageListener goS;
    private BaseFragment gof;
    private PersonPolymericModel goi;
    private g gom;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.e> mList;
    private long mUserId;
    private View mView;
    private boolean clp = true;
    private int mSex = 1;
    private int mSkinType = 3;
    private a goT = new a() { // from class: com.baidu.tieba.personPolymeric.b.i.1
        @Override // com.baidu.tieba.personPolymeric.b.i.a
        public void rc(String str) {
            boolean z;
            if (!am.isEmpty(str) && i.this.mList != null && i.this.mList.get(0) != null && ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).biD() != null && i.this.goL != null) {
                ArrayList<com.baidu.adp.widget.ListView.i> biD = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).biD();
                Iterator<com.baidu.adp.widget.ListView.i> it = biD.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.i next = it.next();
                    if ((next instanceof CardPersonDynamicThreadData) && am.equals(str, ((CardPersonDynamicThreadData) next).threadId)) {
                        it.remove();
                        z = true;
                        break;
                    }
                }
                if (z) {
                    i.this.goL.dc(PersonPostModel.mergeDynamicThreadByTime(biD));
                }
            }
        }
    };
    private final k goU = new k() { // from class: com.baidu.tieba.personPolymeric.b.i.7
        @Override // com.baidu.tieba.view.k
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                i.this.bgo();
            }
        }

        @Override // com.baidu.tieba.view.k
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void rc(String str);
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(BaseFragmentActivity baseFragmentActivity, e eVar, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.fAn = baseFragmentActivity;
        this.aRR = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.mIsHost = z;
        this.goK = eVar;
        this.brv = bdUniqueId;
        this.mView = eVar.mRootView;
        this.goP = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.goL = new s(baseFragmentActivity.getPageContext(), eVar, bdUniqueId, z, z2);
        this.goL.bu(this.mView);
        this.goM = new com.baidu.tieba.personPolymeric.event.c(baseFragmentActivity.getPageContext());
        this.goM.a(this.goK);
        this.goL.setOnViewResponseListener(this.goM);
        this.goL.a(this);
        resetData();
        this.goL.a(this.goU);
        this.gom = this.goK.bka();
        this.goL.M(this.gom);
        this.goi = this.goK.bkb();
        this.goi.d(new p(z));
        this.goO = this.goK.bke();
        this.goN = new f(baseFragmentActivity.getPageContext(), this.goK.bkd(), this.goK.bkc(), this.goL.avk(), bdUniqueId);
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
        initListener();
    }

    public void k(final boolean z, boolean z2, boolean z3) {
        if (com.baidu.adp.lib.util.j.ox()) {
            if (!v.E(this.mList) && this.mList.size() >= 2) {
                final com.baidu.tieba.person.data.e eVar = this.mList.get(z ? 1 : 0);
                if (eVar != null) {
                    if (!eVar.biC() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.3
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.goL.azT();
                                i.this.goO.eX(true);
                            }
                        }, 800L);
                    } else if (!this.mIsHost && z && this.goi != null && this.goi.bkB() != null && this.goi.bkB().bku()) {
                        this.goL.azT();
                        ArrayList<com.baidu.adp.widget.ListView.i> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                        iVar.sex = this.mSex;
                        iVar.isHost = this.mIsHost;
                        arrayList.add(iVar);
                        this.goL.aq(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.4
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.goL.azT();
                                i.this.goO.eX(true);
                            }
                        }, 800L);
                    } else {
                        this.goO.lz(z2);
                        this.goP.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.i.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                i.this.goL.azT();
                                if (personPostModel != null) {
                                    l.showToast(i.this.aRR.getContext(), personPostModel.getErrorString());
                                } else {
                                    l.showToast(i.this.aRR.getContext(), i.this.aRR.getString(d.j.data_load_error));
                                }
                                if (z4) {
                                    i.this.goL.aq(null);
                                    i.this.goO.XQ();
                                }
                            }
                        });
                        this.goP.fetchPost(this.fAn.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.i.6
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                int D;
                                if (personPostModel.getErrorCode() != 0) {
                                    l.showToast(i.this.aRR.getContext(), personPostModel.getErrorString());
                                }
                                i.this.goL.azT();
                                if (z) {
                                    com.baidu.tieba.person.data.e eVar2 = (com.baidu.tieba.person.data.e) i.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<com.baidu.adp.widget.ListView.i> biD = ((com.baidu.tieba.person.data.e) i.this.mList.get(1)).biD();
                                        if (v.E(biD)) {
                                            i.this.goO.XQ();
                                            return;
                                        } else if (i.this.ap(personPostModel.postList)) {
                                            eVar2.lp(false);
                                            i.this.goL.aq(biD);
                                            i.this.goO.b(true, biD);
                                            return;
                                        } else if (i.dd(personPostModel.postList) == 0) {
                                            eVar2.lp(false);
                                            i.this.goL.aq(biD);
                                            i.this.goO.b(true, biD);
                                            return;
                                        } else {
                                            biD.addAll(personPostModel.postList);
                                            i.this.goO.Eh();
                                            eVar2.ao(biD);
                                            i.this.goL.aq(biD);
                                            return;
                                        }
                                    }
                                    eVar2.lp(true);
                                    eVar2.ao(personPostModel.postList);
                                    i.this.goL.aq(personPostModel.postList);
                                    if (eVar2.biD() != null && (D = v.D(eVar2.biD())) > 0 && D <= 2) {
                                        for (int i = 0; i < D; i++) {
                                            if (eVar2.biD().get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                                                ((com.baidu.tieba.personPolymeric.c.i) eVar2.biD().get(i)).isHost = i.this.mIsHost;
                                                i.this.goO.XQ();
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<com.baidu.adp.widget.ListView.i> biD2 = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).biD();
                                if (!v.E(biD2)) {
                                    if (i.this.ap(personPostModel.postList)) {
                                        eVar.lp(false);
                                        i.this.goL.aq(biD2);
                                        i.this.goO.b(true, biD2);
                                        return;
                                    }
                                    Iterator<com.baidu.adp.widget.ListView.i> it = personPostModel.threadList.iterator();
                                    while (it.hasNext()) {
                                        com.baidu.adp.widget.ListView.i next = it.next();
                                        if (next instanceof CardPersonDynamicThreadData) {
                                            ((CardPersonDynamicThreadData) next).isHost = i.this.mIsHost;
                                        }
                                    }
                                    biD2.addAll(personPostModel.threadList);
                                    ArrayList<com.baidu.adp.widget.ListView.i> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(biD2);
                                    eVar.lp(true);
                                    eVar.ao(mergeDynamicThreadByTime);
                                    i.this.goO.Eh();
                                    i.this.goL.dc(mergeDynamicThreadByTime);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z, false);
                    }
                }
            }
        } else if (!z2) {
            this.goO.Eg();
        } else {
            l.showToast(this.aRR.getContext(), this.aRR.getString(d.j.data_load_error));
            if (z) {
                ArrayList<com.baidu.adp.widget.ListView.i> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar2 = new com.baidu.tieba.personPolymeric.c.i();
                iVar2.isHost = this.mIsHost;
                arrayList2.add(iVar2);
                this.goO.XQ();
                this.goL.aq(arrayList2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ap(ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        int D = v.D(arrayList);
        if (D != 0) {
            if (D > 2) {
                return false;
            }
            if (!(arrayList.get(0) instanceof com.baidu.tieba.personPolymeric.c.i) && !(arrayList.get(1) instanceof com.baidu.tieba.personPolymeric.c.i)) {
                return false;
            }
        }
        return true;
    }

    public static int dd(List<com.baidu.adp.widget.ListView.i> list) {
        int i = 0;
        if (v.D(list) == 0) {
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
        if (v.D(arrayList) == 0) {
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
        if (this.goK != null) {
            this.goK.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void i(boolean z, boolean z2, boolean z3) {
        k(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void Wt() {
        if (this.goK != null) {
            this.goK.Wt();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.goP.resetThreadPn();
        if (this.goi != null) {
            this.goi.resetData();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.goL.azT();
        this.fAn.hideLoadingView(this.mView);
        if (aVar == null) {
            this.goO.I(TbadkCoreApplication.getInst().getString(d.j.neterror), true);
            this.goO.XQ();
            this.goO.tK(8);
            return;
        }
        this.goO.XN();
        aVar.bks();
        if (aVar.aEo() != null) {
            z = aVar.aEo().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.clp = false;
        if (this.mIsHost) {
            aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
            com.baidu.tbadk.getUserInfo.b.Mp().a(aVar.getUserData());
        }
        if (this.gom != null) {
            this.gom.a(aVar);
        }
        if (this.goN != null) {
            this.goN.c(aVar);
        }
        com.baidu.tieba.person.data.e eVar = this.mList.get(0);
        eVar.ao(aVar.aEo());
        eVar.lp(z);
        this.goO.tK(0);
        this.goL.a(aVar, z);
        bkp();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public f bjU() {
        return this.goN;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.goL != null) {
                this.goL.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.gof = baseFragment;
    }

    public void bkp() {
        if (!this.clp) {
            if ((this.gof == null || this.gof.isPrimary()) && this.goL != null && (this.goL.bkJ() instanceof com.baidu.tieba.view.f)) {
                ((com.baidu.tieba.view.f) this.goL.bkJ()).bkp();
            }
        }
    }

    public void bgo() {
        if (this.goL != null && (this.goL.bkJ() instanceof com.baidu.tieba.view.f)) {
            ((com.baidu.tieba.view.f) this.goL.bkJ()).bgo();
        }
    }

    public void bkq() {
        if (this.goL != null && this.goL.avk() != null && (this.goL.bkJ() instanceof com.baidu.tieba.personPolymeric.a)) {
            ((com.baidu.tieba.personPolymeric.a) this.goL.bkJ()).a(this.fAn, this.goL.avk());
            if (this.goM != null) {
                this.goL.setOnViewResponseListener(this.goM);
            }
            this.goL.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void rc(String str) {
        if (!am.isEmpty(str) && this.mList != null && this.mList.get(0) != null && this.mList.get(0).biD() != null && this.goL != null) {
            ArrayList<com.baidu.adp.widget.ListView.i> biD = this.mList.get(0).biD();
            for (int i = 0; i < biD.size() && biD.get(i) != null; i++) {
                com.baidu.adp.widget.ListView.i iVar = biD.get(i);
                if ((iVar instanceof CardPersonDynamicThreadData) && am.equals(str, ((CardPersonDynamicThreadData) iVar).threadId)) {
                    this.goL.a(i, str, this.goT);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        this.gom.onDestroy();
        if (this.goL != null) {
            this.goL.onDestory();
        }
        bgo();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void gr(boolean z) {
        if (z) {
            if (this.clp) {
                Wt();
            }
            if (TbadkCoreApplication.isLogin()) {
                bkp();
                return;
            } else {
                bgo();
                return;
            }
        }
        bgo();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            bkp();
            bkq();
            if (!this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
                this.mIsHost = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.aRR.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
                this.fAn.finish();
                return;
            }
            return;
        }
        bgo();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void bjV() {
        if (this.goL != null) {
            this.goL.bjV();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void ly(boolean z) {
        this.goL.ly(z);
    }

    private void initListener() {
        this.dpM = new CustomMessageListener(2921003) { // from class: com.baidu.tieba.personPolymeric.b.i.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.bgo();
            }
        };
        this.dpM.setTag(this.brv);
        MessageManager.getInstance().registerListener(this.dpM);
        this.goQ = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.personPolymeric.b.i.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.rc((String) customResponsedMessage.getData());
                }
            }
        };
        this.goQ.setTag(this.brv);
        MessageManager.getInstance().registerListener(this.goQ);
        this.goR = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.personPolymeric.b.i.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.rc((String) customResponsedMessage.getData());
                    l.showToast(i.this.aRR.getPageActivity(), d.j.person_polymeric_set_privacy_success);
                }
            }
        };
        this.goR.setTag(this.brv);
        MessageManager.getInstance().registerListener(this.goR);
        this.goS = new CustomMessageListener(2016559) { // from class: com.baidu.tieba.personPolymeric.b.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && i.this.goL != null) {
                    i.this.goL.bkM();
                }
            }
        };
        this.goS.setTag(this.brv);
        MessageManager.getInstance().registerListener(this.goS);
    }
}
