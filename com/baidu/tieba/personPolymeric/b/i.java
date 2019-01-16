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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.e;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.view.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class i implements com.baidu.tieba.model.a, com.baidu.tieba.personPolymeric.b.a {
    private BdUniqueId aCu;
    private BaseFragmentActivity bMG;
    private CustomMessageListener dsh;
    private BaseFragment gAD;
    private PersonPolymericModel gAG;
    private g gAK;
    private e gBj;
    private p gBk;
    private com.baidu.tieba.personPolymeric.event.c gBl;
    private f gBm;
    private d gBn;
    private PersonPostModel gBo;
    private CustomMessageListener gBp;
    private CustomMessageListener gBq;
    private TbPageContext mContext;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.e> mList;
    private long mUserId;
    private View mView;
    private boolean bSH = true;
    private int mSex = 1;
    private int mSkinType = 3;
    private a gBr = new a() { // from class: com.baidu.tieba.personPolymeric.b.i.1
        @Override // com.baidu.tieba.personPolymeric.b.i.a
        public void uf(String str) {
            boolean z;
            if (!ao.isEmpty(str) && i.this.mList != null && i.this.mList.get(0) != null && ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bpS() != null && i.this.gBk != null) {
                ArrayList<com.baidu.adp.widget.ListView.h> bpS = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bpS();
                Iterator<com.baidu.adp.widget.ListView.h> it = bpS.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.h next = it.next();
                    if ((next instanceof CardPersonDynamicThreadData) && ao.equals(str, ((CardPersonDynamicThreadData) next).threadId)) {
                        it.remove();
                        z = true;
                        break;
                    }
                }
                if (z) {
                    i.this.gBk.dv(PersonPostModel.mergeDynamicThreadByTime(bpS));
                }
            }
        }
    };
    private final com.baidu.tieba.view.i gBs = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.personPolymeric.b.i.6
        @Override // com.baidu.tieba.view.i
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                i.this.bnG();
            }
        }

        @Override // com.baidu.tieba.view.i
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void uf(String str);
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(BaseFragmentActivity baseFragmentActivity, e eVar, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.bMG = baseFragmentActivity;
        this.mContext = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.mIsHost = z;
        this.gBj = eVar;
        this.aCu = bdUniqueId;
        this.mView = eVar.mRootView;
        this.gBo = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.gBk = new p(baseFragmentActivity.getPageContext(), eVar, bdUniqueId, z, z2);
        this.gBk.initView(this.mView);
        this.gBl = new com.baidu.tieba.personPolymeric.event.c(baseFragmentActivity.getPageContext());
        this.gBl.a(this.gBj);
        this.gBk.setOnViewResponseListener(this.gBl);
        this.gBk.a(this);
        resetData();
        this.gBk.a(this.gBs);
        this.gAK = this.gBj.brt();
        this.gBk.Q(this.gAK);
        this.gAG = this.gBj.bru();
        this.gAG.d(new com.baidu.tieba.personPolymeric.c.p(z));
        this.gBn = this.gBj.brx();
        this.gBm = new f(baseFragmentActivity.getPageContext(), this.gBj.brw(), this.gBj.brv(), this.gBk.act(), bdUniqueId);
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
        initListener();
    }

    public void j(final boolean z, boolean z2, boolean z3) {
        if (j.kK()) {
            if (!v.I(this.mList) && this.mList.size() >= 2) {
                final com.baidu.tieba.person.data.e eVar = this.mList.get(z ? 1 : 0);
                if (eVar != null) {
                    if (!eVar.bpR() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.2
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.gBk.aIa();
                                i.this.gBn.fI(true);
                            }
                        }, 800L);
                    } else if (!this.mIsHost && z && this.gAG != null && this.gAG.brU() != null && this.gAG.brU().brN()) {
                        this.gBk.aIa();
                        ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                        iVar.sex = this.mSex;
                        iVar.isHost = this.mIsHost;
                        arrayList.add(iVar);
                        this.gBk.as(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.3
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.gBk.aIa();
                                i.this.gBn.fI(true);
                            }
                        }, 800L);
                    } else {
                        this.gBn.ml(z2);
                        this.gBo.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.i.4
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                i.this.gBk.aIa();
                                if (personPostModel != null) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                } else {
                                    l.showToast(i.this.mContext.getContext(), i.this.mContext.getString(e.j.data_load_error));
                                }
                                if (z4) {
                                    i.this.gBk.as(null);
                                    i.this.gBn.abA();
                                }
                            }
                        });
                        this.gBo.fetchPost(this.bMG.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.i.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                int H;
                                if (personPostModel.getErrorCode() != 0) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                }
                                i.this.gBk.aIa();
                                if (z) {
                                    com.baidu.tieba.person.data.e eVar2 = (com.baidu.tieba.person.data.e) i.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<com.baidu.adp.widget.ListView.h> bpS = ((com.baidu.tieba.person.data.e) i.this.mList.get(1)).bpS();
                                        if (v.I(bpS)) {
                                            i.this.gBn.abA();
                                            return;
                                        } else if (i.this.ar(personPostModel.postList)) {
                                            eVar2.lY(false);
                                            i.this.gBk.as(bpS);
                                            i.this.gBn.c(true, bpS);
                                            return;
                                        } else if (i.dw(personPostModel.postList) == 0) {
                                            eVar2.lY(false);
                                            i.this.gBk.as(bpS);
                                            i.this.gBn.c(true, bpS);
                                            return;
                                        } else {
                                            bpS.addAll(personPostModel.postList);
                                            i.this.gBn.Fq();
                                            eVar2.aq(bpS);
                                            i.this.gBk.as(bpS);
                                            return;
                                        }
                                    }
                                    eVar2.lY(true);
                                    eVar2.aq(personPostModel.postList);
                                    i.this.gBk.as(personPostModel.postList);
                                    if (eVar2.bpS() != null && (H = v.H(eVar2.bpS())) > 0 && H <= 2) {
                                        for (int i = 0; i < H; i++) {
                                            if (eVar2.bpS().get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                                                ((com.baidu.tieba.personPolymeric.c.i) eVar2.bpS().get(i)).isHost = i.this.mIsHost;
                                                i.this.gBn.abA();
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<com.baidu.adp.widget.ListView.h> bpS2 = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bpS();
                                if (!v.I(bpS2)) {
                                    if (i.this.ar(personPostModel.postList)) {
                                        eVar.lY(false);
                                        i.this.gBk.as(bpS2);
                                        i.this.gBn.c(true, bpS2);
                                        return;
                                    }
                                    Iterator<com.baidu.adp.widget.ListView.h> it = personPostModel.threadList.iterator();
                                    while (it.hasNext()) {
                                        com.baidu.adp.widget.ListView.h next = it.next();
                                        if (next instanceof CardPersonDynamicThreadData) {
                                            ((CardPersonDynamicThreadData) next).isHost = i.this.mIsHost;
                                        }
                                    }
                                    bpS2.addAll(personPostModel.threadList);
                                    ArrayList<com.baidu.adp.widget.ListView.h> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(bpS2);
                                    eVar.lY(true);
                                    eVar.aq(mergeDynamicThreadByTime);
                                    i.this.gBn.Fq();
                                    i.this.gBk.dv(mergeDynamicThreadByTime);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z, false);
                    }
                }
            }
        } else if (!z2) {
            this.gBn.Fp();
        } else {
            l.showToast(this.mContext.getContext(), this.mContext.getString(e.j.data_load_error));
            if (z) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar2 = new com.baidu.tieba.personPolymeric.c.i();
                iVar2.isHost = this.mIsHost;
                arrayList2.add(iVar2);
                this.gBn.abA();
                this.gBk.as(arrayList2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ar(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        int H = v.H(arrayList);
        if (H != 0) {
            if (H > 2) {
                return false;
            }
            if (!(arrayList.get(0) instanceof com.baidu.tieba.personPolymeric.c.i) && !(arrayList.get(1) instanceof com.baidu.tieba.personPolymeric.c.i)) {
                return false;
            }
        }
        return true;
    }

    public static int dw(List<com.baidu.adp.widget.ListView.h> list) {
        int i = 0;
        if (v.H(list) == 0) {
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
        if (v.H(arrayList) == 0) {
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
        if (this.gBj != null) {
            this.gBj.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void g(boolean z, boolean z2, boolean z3) {
        j(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.gBj != null) {
            this.gBj.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.gBo.resetThreadPn();
        if (this.gAG != null) {
            this.gAG.resetData();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.gBk.aIa();
        this.bMG.hideLoadingView(this.mView);
        if (aVar == null) {
            this.gBn.N(TbadkCoreApplication.getInst().getString(e.j.neterror), true);
            this.gBn.abA();
            this.gBn.tw(8);
        } else if (aVar.aBj() != null && ((aVar.aBj().getHide_stat() == 1 && aVar.aBj().getBlock_stat() == 1) || (aVar.aBj().getHide_stat() == 1 && aVar.aBj().getBlock_stat() == 2))) {
            this.gBn.mk(this.mIsHost);
            this.gBn.tw(8);
            this.gBn.abx();
        } else {
            this.gBn.abx();
            aVar.brL();
            if (aVar.aNX() != null) {
                z = aVar.aNX().size() >= 20;
            } else {
                z = false;
            }
            if (aVar.getUserData() != null) {
                this.mSex = aVar.getUserData().getSex();
            }
            this.bSH = false;
            if (this.mIsHost) {
                aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                com.baidu.tbadk.getUserInfo.b.ND().a(aVar.getUserData());
            }
            if (this.gAK != null) {
                this.gAK.a(aVar);
            }
            if (this.gBm != null) {
                this.gBm.c(aVar);
            }
            com.baidu.tieba.person.data.e eVar = this.mList.get(0);
            eVar.aq(aVar.aNX());
            eVar.lY(z);
            this.gBn.tw(0);
            this.gBk.a(aVar, z);
            brJ();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public f brn() {
        return this.gBm;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gBk != null) {
                this.gBk.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.gAD = baseFragment;
    }

    public void brJ() {
        if (!this.bSH) {
            if ((this.gAD == null || this.gAD.isPrimary()) && this.gBk != null && (this.gBk.bsb() instanceof com.baidu.tieba.view.d)) {
                ((com.baidu.tieba.view.d) this.gBk.bsb()).brJ();
            }
        }
    }

    public void bnG() {
        if (this.gBk != null && (this.gBk.bsb() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.gBk.bsb()).bnG();
        }
    }

    public void brK() {
        if (this.gBk != null && this.gBk.act() != null && (this.gBk.bsb() instanceof com.baidu.tieba.personPolymeric.a)) {
            ((com.baidu.tieba.personPolymeric.a) this.gBk.bsb()).a(this.bMG, this.gBk.act());
            if (this.gBl != null) {
                this.gBk.setOnViewResponseListener(this.gBl);
            }
            this.gBk.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void uf(String str) {
        if (!ao.isEmpty(str) && this.mList != null && this.mList.get(0) != null && this.mList.get(0).bpS() != null && this.gBk != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> bpS = this.mList.get(0).bpS();
            for (int i = 0; i < bpS.size() && bpS.get(i) != null; i++) {
                com.baidu.adp.widget.ListView.h hVar = bpS.get(i);
                if ((hVar instanceof CardPersonDynamicThreadData) && ao.equals(str, ((CardPersonDynamicThreadData) hVar).threadId)) {
                    this.gBk.a(i, str, this.gBr);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aCu);
        this.gAK.onDestroy();
        if (this.gBk != null) {
            this.gBk.onDestory();
        }
        bnG();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void gA(boolean z) {
        if (z) {
            if (this.bSH) {
                loadData();
            }
            if (TbadkCoreApplication.isLogin()) {
                brJ();
                return;
            } else {
                bnG();
                return;
            }
        }
        bnG();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            brJ();
            brK();
            if (!this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
                this.mIsHost = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
                this.bMG.finish();
                return;
            }
            return;
        }
        bnG();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void ud(String str) {
        if (this.gBk != null) {
            this.gBk.ud(str);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void ue(String str) {
        if (this.gBk != null) {
            this.gBk.ue(str);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void bro() {
        if (this.gBk != null) {
            this.gBk.bro();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void mj(boolean z) {
        this.gBk.mj(z);
    }

    private void initListener() {
        this.dsh = new CustomMessageListener(2921003) { // from class: com.baidu.tieba.personPolymeric.b.i.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.bnG();
            }
        };
        this.dsh.setTag(this.aCu);
        MessageManager.getInstance().registerListener(this.dsh);
        this.gBp = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.personPolymeric.b.i.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.uf((String) customResponsedMessage.getData());
                }
            }
        };
        this.gBp.setTag(this.aCu);
        MessageManager.getInstance().registerListener(this.gBp);
        this.gBq = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.personPolymeric.b.i.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.uf((String) customResponsedMessage.getData());
                    l.showToast(i.this.mContext.getPageActivity(), e.j.person_polymeric_set_privacy_success);
                }
            }
        };
        this.gBq.setTag(this.aCu);
        MessageManager.getInstance().registerListener(this.gBq);
    }
}
