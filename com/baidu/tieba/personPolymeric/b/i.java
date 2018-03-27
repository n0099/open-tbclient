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
    private TbPageContext aRI;
    private BdUniqueId brl;
    private CustomMessageListener dpD;
    private BaseFragmentActivity fAr;
    private e goP;
    private s goQ;
    private com.baidu.tieba.personPolymeric.event.c goR;
    private f goS;
    private d goT;
    private PersonPostModel goU;
    private CustomMessageListener goV;
    private CustomMessageListener goW;
    private CustomMessageListener goX;
    private BaseFragment gok;
    private PersonPolymericModel gon;
    private g gor;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.e> mList;
    private long mUserId;
    private View mView;
    private boolean clg = true;
    private int mSex = 1;
    private int mSkinType = 3;
    private a goY = new a() { // from class: com.baidu.tieba.personPolymeric.b.i.1
        @Override // com.baidu.tieba.personPolymeric.b.i.a
        public void rc(String str) {
            boolean z;
            if (!am.isEmpty(str) && i.this.mList != null && i.this.mList.get(0) != null && ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).biD() != null && i.this.goQ != null) {
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
                    i.this.goQ.dc(PersonPostModel.mergeDynamicThreadByTime(biD));
                }
            }
        }
    };
    private final k goZ = new k() { // from class: com.baidu.tieba.personPolymeric.b.i.7
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
        this.fAr = baseFragmentActivity;
        this.aRI = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.mIsHost = z;
        this.goP = eVar;
        this.brl = bdUniqueId;
        this.mView = eVar.mRootView;
        this.goU = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.goQ = new s(baseFragmentActivity.getPageContext(), eVar, bdUniqueId, z, z2);
        this.goQ.bu(this.mView);
        this.goR = new com.baidu.tieba.personPolymeric.event.c(baseFragmentActivity.getPageContext());
        this.goR.a(this.goP);
        this.goQ.setOnViewResponseListener(this.goR);
        this.goQ.a(this);
        resetData();
        this.goQ.a(this.goZ);
        this.gor = this.goP.bka();
        this.goQ.M(this.gor);
        this.gon = this.goP.bkb();
        this.gon.d(new p(z));
        this.goT = this.goP.bke();
        this.goS = new f(baseFragmentActivity.getPageContext(), this.goP.bkd(), this.goP.bkc(), this.goQ.avk(), bdUniqueId);
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
                                i.this.goQ.azU();
                                i.this.goT.eX(true);
                            }
                        }, 800L);
                    } else if (!this.mIsHost && z && this.gon != null && this.gon.bkB() != null && this.gon.bkB().bku()) {
                        this.goQ.azU();
                        ArrayList<com.baidu.adp.widget.ListView.i> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                        iVar.sex = this.mSex;
                        iVar.isHost = this.mIsHost;
                        arrayList.add(iVar);
                        this.goQ.aq(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.4
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.goQ.azU();
                                i.this.goT.eX(true);
                            }
                        }, 800L);
                    } else {
                        this.goT.lE(z2);
                        this.goU.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.i.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                i.this.goQ.azU();
                                if (personPostModel != null) {
                                    l.showToast(i.this.aRI.getContext(), personPostModel.getErrorString());
                                } else {
                                    l.showToast(i.this.aRI.getContext(), i.this.aRI.getString(d.j.data_load_error));
                                }
                                if (z4) {
                                    i.this.goQ.aq(null);
                                    i.this.goT.XQ();
                                }
                            }
                        });
                        this.goU.fetchPost(this.fAr.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.i.6
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                int D;
                                if (personPostModel.getErrorCode() != 0) {
                                    l.showToast(i.this.aRI.getContext(), personPostModel.getErrorString());
                                }
                                i.this.goQ.azU();
                                if (z) {
                                    com.baidu.tieba.person.data.e eVar2 = (com.baidu.tieba.person.data.e) i.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<com.baidu.adp.widget.ListView.i> biD = ((com.baidu.tieba.person.data.e) i.this.mList.get(1)).biD();
                                        if (v.E(biD)) {
                                            i.this.goT.XQ();
                                            return;
                                        } else if (i.this.ap(personPostModel.postList)) {
                                            eVar2.lu(false);
                                            i.this.goQ.aq(biD);
                                            i.this.goT.b(true, biD);
                                            return;
                                        } else if (i.dd(personPostModel.postList) == 0) {
                                            eVar2.lu(false);
                                            i.this.goQ.aq(biD);
                                            i.this.goT.b(true, biD);
                                            return;
                                        } else {
                                            biD.addAll(personPostModel.postList);
                                            i.this.goT.Eh();
                                            eVar2.ao(biD);
                                            i.this.goQ.aq(biD);
                                            return;
                                        }
                                    }
                                    eVar2.lu(true);
                                    eVar2.ao(personPostModel.postList);
                                    i.this.goQ.aq(personPostModel.postList);
                                    if (eVar2.biD() != null && (D = v.D(eVar2.biD())) > 0 && D <= 2) {
                                        for (int i = 0; i < D; i++) {
                                            if (eVar2.biD().get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                                                ((com.baidu.tieba.personPolymeric.c.i) eVar2.biD().get(i)).isHost = i.this.mIsHost;
                                                i.this.goT.XQ();
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<com.baidu.adp.widget.ListView.i> biD2 = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).biD();
                                if (!v.E(biD2)) {
                                    if (i.this.ap(personPostModel.postList)) {
                                        eVar.lu(false);
                                        i.this.goQ.aq(biD2);
                                        i.this.goT.b(true, biD2);
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
                                    eVar.lu(true);
                                    eVar.ao(mergeDynamicThreadByTime);
                                    i.this.goT.Eh();
                                    i.this.goQ.dc(mergeDynamicThreadByTime);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z, false);
                    }
                }
            }
        } else if (!z2) {
            this.goT.Eg();
        } else {
            l.showToast(this.aRI.getContext(), this.aRI.getString(d.j.data_load_error));
            if (z) {
                ArrayList<com.baidu.adp.widget.ListView.i> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar2 = new com.baidu.tieba.personPolymeric.c.i();
                iVar2.isHost = this.mIsHost;
                arrayList2.add(iVar2);
                this.goT.XQ();
                this.goQ.aq(arrayList2);
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
        if (this.goP != null) {
            this.goP.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void i(boolean z, boolean z2, boolean z3) {
        k(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void Wt() {
        if (this.goP != null) {
            this.goP.Wt();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.goU.resetThreadPn();
        if (this.gon != null) {
            this.gon.resetData();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.goQ.azU();
        this.fAr.hideLoadingView(this.mView);
        if (aVar == null) {
            this.goT.H(TbadkCoreApplication.getInst().getString(d.j.neterror), true);
            this.goT.XQ();
            this.goT.tL(8);
            return;
        }
        this.goT.XN();
        aVar.bks();
        if (aVar.aEo() != null) {
            z = aVar.aEo().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.clg = false;
        if (this.mIsHost) {
            aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
            com.baidu.tbadk.getUserInfo.b.Mp().a(aVar.getUserData());
        }
        if (this.gor != null) {
            this.gor.a(aVar);
        }
        if (this.goS != null) {
            this.goS.c(aVar);
        }
        com.baidu.tieba.person.data.e eVar = this.mList.get(0);
        eVar.ao(aVar.aEo());
        eVar.lu(z);
        this.goT.tL(0);
        this.goQ.a(aVar, z);
        bkp();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public f bjU() {
        return this.goS;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.goQ != null) {
                this.goQ.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.gok = baseFragment;
    }

    public void bkp() {
        if (!this.clg) {
            if ((this.gok == null || this.gok.isPrimary()) && this.goQ != null && (this.goQ.bkJ() instanceof com.baidu.tieba.view.f)) {
                ((com.baidu.tieba.view.f) this.goQ.bkJ()).bkp();
            }
        }
    }

    public void bgo() {
        if (this.goQ != null && (this.goQ.bkJ() instanceof com.baidu.tieba.view.f)) {
            ((com.baidu.tieba.view.f) this.goQ.bkJ()).bgo();
        }
    }

    public void bkq() {
        if (this.goQ != null && this.goQ.avk() != null && (this.goQ.bkJ() instanceof com.baidu.tieba.personPolymeric.a)) {
            ((com.baidu.tieba.personPolymeric.a) this.goQ.bkJ()).a(this.fAr, this.goQ.avk());
            if (this.goR != null) {
                this.goQ.setOnViewResponseListener(this.goR);
            }
            this.goQ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void rc(String str) {
        if (!am.isEmpty(str) && this.mList != null && this.mList.get(0) != null && this.mList.get(0).biD() != null && this.goQ != null) {
            ArrayList<com.baidu.adp.widget.ListView.i> biD = this.mList.get(0).biD();
            for (int i = 0; i < biD.size() && biD.get(i) != null; i++) {
                com.baidu.adp.widget.ListView.i iVar = biD.get(i);
                if ((iVar instanceof CardPersonDynamicThreadData) && am.equals(str, ((CardPersonDynamicThreadData) iVar).threadId)) {
                    this.goQ.a(i, str, this.goY);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        this.gor.onDestroy();
        if (this.goQ != null) {
            this.goQ.onDestory();
        }
        bgo();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void gt(boolean z) {
        if (z) {
            if (this.clg) {
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
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.aRI.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
                this.fAr.finish();
                return;
            }
            return;
        }
        bgo();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void bjV() {
        if (this.goQ != null) {
            this.goQ.bjV();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void lD(boolean z) {
        this.goQ.lD(z);
    }

    private void initListener() {
        this.dpD = new CustomMessageListener(2921003) { // from class: com.baidu.tieba.personPolymeric.b.i.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.bgo();
            }
        };
        this.dpD.setTag(this.brl);
        MessageManager.getInstance().registerListener(this.dpD);
        this.goV = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.personPolymeric.b.i.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.rc((String) customResponsedMessage.getData());
                }
            }
        };
        this.goV.setTag(this.brl);
        MessageManager.getInstance().registerListener(this.goV);
        this.goW = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.personPolymeric.b.i.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.rc((String) customResponsedMessage.getData());
                    l.showToast(i.this.aRI.getPageActivity(), d.j.person_polymeric_set_privacy_success);
                }
            }
        };
        this.goW.setTag(this.brl);
        MessageManager.getInstance().registerListener(this.goW);
        this.goX = new CustomMessageListener(2016559) { // from class: com.baidu.tieba.personPolymeric.b.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && i.this.goQ != null) {
                    i.this.goQ.bkM();
                }
            }
        };
        this.goX.setTag(this.brl);
        MessageManager.getInstance().registerListener(this.goX);
    }
}
