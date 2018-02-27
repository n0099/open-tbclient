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
    private TbPageContext aRG;
    private BdUniqueId bri;
    private CustomMessageListener dpA;
    private BaseFragmentActivity fAb;
    private BaseFragment gnT;
    private PersonPolymericModel gnW;
    private s goA;
    private com.baidu.tieba.personPolymeric.event.c goB;
    private f goC;
    private d goD;
    private PersonPostModel goE;
    private CustomMessageListener goF;
    private CustomMessageListener goG;
    private CustomMessageListener goH;
    private g goa;
    private e goz;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.e> mList;
    private long mUserId;
    private View mView;
    private boolean cld = true;
    private int mSex = 1;
    private int mSkinType = 3;
    private a goI = new a() { // from class: com.baidu.tieba.personPolymeric.b.i.1
        @Override // com.baidu.tieba.personPolymeric.b.i.a
        public void rc(String str) {
            boolean z;
            if (!am.isEmpty(str) && i.this.mList != null && i.this.mList.get(0) != null && ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).biC() != null && i.this.goA != null) {
                ArrayList<com.baidu.adp.widget.ListView.i> biC = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).biC();
                Iterator<com.baidu.adp.widget.ListView.i> it = biC.iterator();
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
                    i.this.goA.dc(PersonPostModel.mergeDynamicThreadByTime(biC));
                }
            }
        }
    };
    private final k goJ = new k() { // from class: com.baidu.tieba.personPolymeric.b.i.7
        @Override // com.baidu.tieba.view.k
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                i.this.bgn();
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
        this.fAb = baseFragmentActivity;
        this.aRG = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.mIsHost = z;
        this.goz = eVar;
        this.bri = bdUniqueId;
        this.mView = eVar.mRootView;
        this.goE = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.goA = new s(baseFragmentActivity.getPageContext(), eVar, bdUniqueId, z, z2);
        this.goA.bu(this.mView);
        this.goB = new com.baidu.tieba.personPolymeric.event.c(baseFragmentActivity.getPageContext());
        this.goB.a(this.goz);
        this.goA.setOnViewResponseListener(this.goB);
        this.goA.a(this);
        resetData();
        this.goA.a(this.goJ);
        this.goa = this.goz.bjZ();
        this.goA.M(this.goa);
        this.gnW = this.goz.bka();
        this.gnW.d(new p(z));
        this.goD = this.goz.bkd();
        this.goC = new f(baseFragmentActivity.getPageContext(), this.goz.bkc(), this.goz.bkb(), this.goA.avj(), bdUniqueId);
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
                    if (!eVar.biB() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.3
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.goA.azS();
                                i.this.goD.eX(true);
                            }
                        }, 800L);
                    } else if (!this.mIsHost && z && this.gnW != null && this.gnW.bkA() != null && this.gnW.bkA().bkt()) {
                        this.goA.azS();
                        ArrayList<com.baidu.adp.widget.ListView.i> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                        iVar.sex = this.mSex;
                        iVar.isHost = this.mIsHost;
                        arrayList.add(iVar);
                        this.goA.aq(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.4
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.goA.azS();
                                i.this.goD.eX(true);
                            }
                        }, 800L);
                    } else {
                        this.goD.lz(z2);
                        this.goE.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.i.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                i.this.goA.azS();
                                if (personPostModel != null) {
                                    l.showToast(i.this.aRG.getContext(), personPostModel.getErrorString());
                                } else {
                                    l.showToast(i.this.aRG.getContext(), i.this.aRG.getString(d.j.data_load_error));
                                }
                                if (z4) {
                                    i.this.goA.aq(null);
                                    i.this.goD.XP();
                                }
                            }
                        });
                        this.goE.fetchPost(this.fAb.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.i.6
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                int D;
                                if (personPostModel.getErrorCode() != 0) {
                                    l.showToast(i.this.aRG.getContext(), personPostModel.getErrorString());
                                }
                                i.this.goA.azS();
                                if (z) {
                                    com.baidu.tieba.person.data.e eVar2 = (com.baidu.tieba.person.data.e) i.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<com.baidu.adp.widget.ListView.i> biC = ((com.baidu.tieba.person.data.e) i.this.mList.get(1)).biC();
                                        if (v.E(biC)) {
                                            i.this.goD.XP();
                                            return;
                                        } else if (i.this.ap(personPostModel.postList)) {
                                            eVar2.lp(false);
                                            i.this.goA.aq(biC);
                                            i.this.goD.b(true, biC);
                                            return;
                                        } else if (i.dd(personPostModel.postList) == 0) {
                                            eVar2.lp(false);
                                            i.this.goA.aq(biC);
                                            i.this.goD.b(true, biC);
                                            return;
                                        } else {
                                            biC.addAll(personPostModel.postList);
                                            i.this.goD.Eg();
                                            eVar2.ao(biC);
                                            i.this.goA.aq(biC);
                                            return;
                                        }
                                    }
                                    eVar2.lp(true);
                                    eVar2.ao(personPostModel.postList);
                                    i.this.goA.aq(personPostModel.postList);
                                    if (eVar2.biC() != null && (D = v.D(eVar2.biC())) > 0 && D <= 2) {
                                        for (int i = 0; i < D; i++) {
                                            if (eVar2.biC().get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                                                ((com.baidu.tieba.personPolymeric.c.i) eVar2.biC().get(i)).isHost = i.this.mIsHost;
                                                i.this.goD.XP();
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<com.baidu.adp.widget.ListView.i> biC2 = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).biC();
                                if (!v.E(biC2)) {
                                    if (i.this.ap(personPostModel.postList)) {
                                        eVar.lp(false);
                                        i.this.goA.aq(biC2);
                                        i.this.goD.b(true, biC2);
                                        return;
                                    }
                                    Iterator<com.baidu.adp.widget.ListView.i> it = personPostModel.threadList.iterator();
                                    while (it.hasNext()) {
                                        com.baidu.adp.widget.ListView.i next = it.next();
                                        if (next instanceof CardPersonDynamicThreadData) {
                                            ((CardPersonDynamicThreadData) next).isHost = i.this.mIsHost;
                                        }
                                    }
                                    biC2.addAll(personPostModel.threadList);
                                    ArrayList<com.baidu.adp.widget.ListView.i> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(biC2);
                                    eVar.lp(true);
                                    eVar.ao(mergeDynamicThreadByTime);
                                    i.this.goD.Eg();
                                    i.this.goA.dc(mergeDynamicThreadByTime);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z, false);
                    }
                }
            }
        } else if (!z2) {
            this.goD.Ef();
        } else {
            l.showToast(this.aRG.getContext(), this.aRG.getString(d.j.data_load_error));
            if (z) {
                ArrayList<com.baidu.adp.widget.ListView.i> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar2 = new com.baidu.tieba.personPolymeric.c.i();
                iVar2.isHost = this.mIsHost;
                arrayList2.add(iVar2);
                this.goD.XP();
                this.goA.aq(arrayList2);
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
        if (this.goz != null) {
            this.goz.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void i(boolean z, boolean z2, boolean z3) {
        k(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void Ws() {
        if (this.goz != null) {
            this.goz.Ws();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.goE.resetThreadPn();
        if (this.gnW != null) {
            this.gnW.resetData();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.goA.azS();
        this.fAb.hideLoadingView(this.mView);
        if (aVar == null) {
            this.goD.H(TbadkCoreApplication.getInst().getString(d.j.neterror), true);
            this.goD.XP();
            this.goD.tL(8);
            return;
        }
        this.goD.XM();
        aVar.bkr();
        if (aVar.aEn() != null) {
            z = aVar.aEn().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.cld = false;
        if (this.mIsHost) {
            aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
            com.baidu.tbadk.getUserInfo.b.Mo().a(aVar.getUserData());
        }
        if (this.goa != null) {
            this.goa.a(aVar);
        }
        if (this.goC != null) {
            this.goC.c(aVar);
        }
        com.baidu.tieba.person.data.e eVar = this.mList.get(0);
        eVar.ao(aVar.aEn());
        eVar.lp(z);
        this.goD.tL(0);
        this.goA.a(aVar, z);
        bko();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public f bjT() {
        return this.goC;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.goA != null) {
                this.goA.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.gnT = baseFragment;
    }

    public void bko() {
        if (!this.cld) {
            if ((this.gnT == null || this.gnT.isPrimary()) && this.goA != null && (this.goA.bkI() instanceof com.baidu.tieba.view.f)) {
                ((com.baidu.tieba.view.f) this.goA.bkI()).bko();
            }
        }
    }

    public void bgn() {
        if (this.goA != null && (this.goA.bkI() instanceof com.baidu.tieba.view.f)) {
            ((com.baidu.tieba.view.f) this.goA.bkI()).bgn();
        }
    }

    public void bkp() {
        if (this.goA != null && this.goA.avj() != null && (this.goA.bkI() instanceof com.baidu.tieba.personPolymeric.a)) {
            ((com.baidu.tieba.personPolymeric.a) this.goA.bkI()).a(this.fAb, this.goA.avj());
            if (this.goB != null) {
                this.goA.setOnViewResponseListener(this.goB);
            }
            this.goA.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void rc(String str) {
        if (!am.isEmpty(str) && this.mList != null && this.mList.get(0) != null && this.mList.get(0).biC() != null && this.goA != null) {
            ArrayList<com.baidu.adp.widget.ListView.i> biC = this.mList.get(0).biC();
            for (int i = 0; i < biC.size() && biC.get(i) != null; i++) {
                com.baidu.adp.widget.ListView.i iVar = biC.get(i);
                if ((iVar instanceof CardPersonDynamicThreadData) && am.equals(str, ((CardPersonDynamicThreadData) iVar).threadId)) {
                    this.goA.a(i, str, this.goI);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        this.goa.onDestroy();
        if (this.goA != null) {
            this.goA.onDestory();
        }
        bgn();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void gr(boolean z) {
        if (z) {
            if (this.cld) {
                Ws();
            }
            if (TbadkCoreApplication.isLogin()) {
                bko();
                return;
            } else {
                bgn();
                return;
            }
        }
        bgn();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            bko();
            bkp();
            if (!this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
                this.mIsHost = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.aRG.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
                this.fAb.finish();
                return;
            }
            return;
        }
        bgn();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void bjU() {
        if (this.goA != null) {
            this.goA.bjU();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void ly(boolean z) {
        this.goA.ly(z);
    }

    private void initListener() {
        this.dpA = new CustomMessageListener(2921003) { // from class: com.baidu.tieba.personPolymeric.b.i.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.bgn();
            }
        };
        this.dpA.setTag(this.bri);
        MessageManager.getInstance().registerListener(this.dpA);
        this.goF = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.personPolymeric.b.i.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.rc((String) customResponsedMessage.getData());
                }
            }
        };
        this.goF.setTag(this.bri);
        MessageManager.getInstance().registerListener(this.goF);
        this.goG = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.personPolymeric.b.i.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.rc((String) customResponsedMessage.getData());
                    l.showToast(i.this.aRG.getPageActivity(), d.j.person_polymeric_set_privacy_success);
                }
            }
        };
        this.goG.setTag(this.bri);
        MessageManager.getInstance().registerListener(this.goG);
        this.goH = new CustomMessageListener(2016559) { // from class: com.baidu.tieba.personPolymeric.b.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && i.this.goA != null) {
                    i.this.goA.bkL();
                }
            }
        };
        this.goH.setTag(this.bri);
        MessageManager.getInstance().registerListener(this.goH);
    }
}
