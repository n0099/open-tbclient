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
    private BdUniqueId axF;
    private BaseFragmentActivity bHp;
    private CustomMessageListener dgV;
    private e goY;
    private p goZ;
    private BaseFragment gos;
    private PersonPolymericModel gov;
    private g goz;
    private com.baidu.tieba.personPolymeric.event.c gpa;
    private f gpb;
    private d gpc;
    private PersonPostModel gpd;
    private CustomMessageListener gpe;
    private CustomMessageListener gpf;
    private TbPageContext mContext;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.e> mList;
    private long mUserId;
    private View mView;
    private boolean bNr = true;
    private int mSex = 1;
    private int mSkinType = 3;
    private a gpg = new a() { // from class: com.baidu.tieba.personPolymeric.b.i.1
        @Override // com.baidu.tieba.personPolymeric.b.i.a
        public void tf(String str) {
            boolean z;
            if (!ao.isEmpty(str) && i.this.mList != null && i.this.mList.get(0) != null && ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bnk() != null && i.this.goZ != null) {
                ArrayList<com.baidu.adp.widget.ListView.h> bnk = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bnk();
                Iterator<com.baidu.adp.widget.ListView.h> it = bnk.iterator();
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
                    i.this.goZ.dr(PersonPostModel.mergeDynamicThreadByTime(bnk));
                }
            }
        }
    };
    private final com.baidu.tieba.view.i gph = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.personPolymeric.b.i.6
        @Override // com.baidu.tieba.view.i
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                i.this.bkX();
            }
        }

        @Override // com.baidu.tieba.view.i
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void tf(String str);
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(BaseFragmentActivity baseFragmentActivity, e eVar, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.bHp = baseFragmentActivity;
        this.mContext = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.mIsHost = z;
        this.goY = eVar;
        this.axF = bdUniqueId;
        this.mView = eVar.mRootView;
        this.gpd = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.goZ = new p(baseFragmentActivity.getPageContext(), eVar, bdUniqueId, z, z2);
        this.goZ.initView(this.mView);
        this.gpa = new com.baidu.tieba.personPolymeric.event.c(baseFragmentActivity.getPageContext());
        this.gpa.a(this.goY);
        this.goZ.setOnViewResponseListener(this.gpa);
        this.goZ.a(this);
        resetData();
        this.goZ.a(this.gph);
        this.goz = this.goY.boL();
        this.goZ.O(this.goz);
        this.gov = this.goY.boM();
        this.gov.d(new com.baidu.tieba.personPolymeric.c.p(z));
        this.gpc = this.goY.boP();
        this.gpb = new f(baseFragmentActivity.getPageContext(), this.goY.boO(), this.goY.boN(), this.goZ.aaD(), bdUniqueId);
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
        initListener();
    }

    public void j(final boolean z, boolean z2, boolean z3) {
        if (j.kM()) {
            if (!v.J(this.mList) && this.mList.size() >= 2) {
                final com.baidu.tieba.person.data.e eVar = this.mList.get(z ? 1 : 0);
                if (eVar != null) {
                    if (!eVar.bnj() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.2
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.goZ.aFG();
                                i.this.gpc.fr(true);
                            }
                        }, 800L);
                    } else if (!this.mIsHost && z && this.gov != null && this.gov.bpm() != null && this.gov.bpm().bpf()) {
                        this.goZ.aFG();
                        ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                        iVar.sex = this.mSex;
                        iVar.isHost = this.mIsHost;
                        arrayList.add(iVar);
                        this.goZ.at(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.3
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.goZ.aFG();
                                i.this.gpc.fr(true);
                            }
                        }, 800L);
                    } else {
                        this.gpc.lU(z2);
                        this.gpd.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.i.4
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                i.this.goZ.aFG();
                                if (personPostModel != null) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                } else {
                                    l.showToast(i.this.mContext.getContext(), i.this.mContext.getString(e.j.data_load_error));
                                }
                                if (z4) {
                                    i.this.goZ.at(null);
                                    i.this.gpc.ZK();
                                }
                            }
                        });
                        this.gpd.fetchPost(this.bHp.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.i.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                int I;
                                if (personPostModel.getErrorCode() != 0) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                }
                                i.this.goZ.aFG();
                                if (z) {
                                    com.baidu.tieba.person.data.e eVar2 = (com.baidu.tieba.person.data.e) i.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<com.baidu.adp.widget.ListView.h> bnk = ((com.baidu.tieba.person.data.e) i.this.mList.get(1)).bnk();
                                        if (v.J(bnk)) {
                                            i.this.gpc.ZK();
                                            return;
                                        } else if (i.this.as(personPostModel.postList)) {
                                            eVar2.lH(false);
                                            i.this.goZ.at(bnk);
                                            i.this.gpc.c(true, bnk);
                                            return;
                                        } else if (i.ds(personPostModel.postList) == 0) {
                                            eVar2.lH(false);
                                            i.this.goZ.at(bnk);
                                            i.this.gpc.c(true, bnk);
                                            return;
                                        } else {
                                            bnk.addAll(personPostModel.postList);
                                            i.this.gpc.DP();
                                            eVar2.ar(bnk);
                                            i.this.goZ.at(bnk);
                                            return;
                                        }
                                    }
                                    eVar2.lH(true);
                                    eVar2.ar(personPostModel.postList);
                                    i.this.goZ.at(personPostModel.postList);
                                    if (eVar2.bnk() != null && (I = v.I(eVar2.bnk())) > 0 && I <= 2) {
                                        for (int i = 0; i < I; i++) {
                                            if (eVar2.bnk().get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                                                ((com.baidu.tieba.personPolymeric.c.i) eVar2.bnk().get(i)).isHost = i.this.mIsHost;
                                                i.this.gpc.ZK();
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<com.baidu.adp.widget.ListView.h> bnk2 = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bnk();
                                if (!v.J(bnk2)) {
                                    if (i.this.as(personPostModel.postList)) {
                                        eVar.lH(false);
                                        i.this.goZ.at(bnk2);
                                        i.this.gpc.c(true, bnk2);
                                        return;
                                    }
                                    Iterator<com.baidu.adp.widget.ListView.h> it = personPostModel.threadList.iterator();
                                    while (it.hasNext()) {
                                        com.baidu.adp.widget.ListView.h next = it.next();
                                        if (next instanceof CardPersonDynamicThreadData) {
                                            ((CardPersonDynamicThreadData) next).isHost = i.this.mIsHost;
                                        }
                                    }
                                    bnk2.addAll(personPostModel.threadList);
                                    ArrayList<com.baidu.adp.widget.ListView.h> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(bnk2);
                                    eVar.lH(true);
                                    eVar.ar(mergeDynamicThreadByTime);
                                    i.this.gpc.DP();
                                    i.this.goZ.dr(mergeDynamicThreadByTime);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z, false);
                    }
                }
            }
        } else if (!z2) {
            this.gpc.DO();
        } else {
            l.showToast(this.mContext.getContext(), this.mContext.getString(e.j.data_load_error));
            if (z) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar2 = new com.baidu.tieba.personPolymeric.c.i();
                iVar2.isHost = this.mIsHost;
                arrayList2.add(iVar2);
                this.gpc.ZK();
                this.goZ.at(arrayList2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean as(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        int I = v.I(arrayList);
        if (I != 0) {
            if (I > 2) {
                return false;
            }
            if (!(arrayList.get(0) instanceof com.baidu.tieba.personPolymeric.c.i) && !(arrayList.get(1) instanceof com.baidu.tieba.personPolymeric.c.i)) {
                return false;
            }
        }
        return true;
    }

    public static int ds(List<com.baidu.adp.widget.ListView.h> list) {
        int i = 0;
        if (v.I(list) == 0) {
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
        if (v.I(arrayList) == 0) {
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
        if (this.goY != null) {
            this.goY.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void g(boolean z, boolean z2, boolean z3) {
        j(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.goY != null) {
            this.goY.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.gpd.resetThreadPn();
        if (this.gov != null) {
            this.gov.resetData();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.goZ.aFG();
        this.bHp.hideLoadingView(this.mView);
        if (aVar == null) {
            this.gpc.M(TbadkCoreApplication.getInst().getString(e.j.neterror), true);
            this.gpc.ZK();
            this.gpc.ss(8);
        } else if (aVar.ayP() != null && ((aVar.ayP().getHide_stat() == 1 && aVar.ayP().getBlock_stat() == 1) || (aVar.ayP().getHide_stat() == 1 && aVar.ayP().getBlock_stat() == 2))) {
            this.gpc.lT(this.mIsHost);
            this.gpc.ss(8);
            this.gpc.ZH();
        } else {
            this.gpc.ZH();
            aVar.bpd();
            if (aVar.aLu() != null) {
                z = aVar.aLu().size() >= 20;
            } else {
                z = false;
            }
            if (aVar.getUserData() != null) {
                this.mSex = aVar.getUserData().getSex();
            }
            this.bNr = false;
            if (this.mIsHost) {
                aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                com.baidu.tbadk.getUserInfo.b.LV().a(aVar.getUserData());
            }
            if (this.goz != null) {
                this.goz.a(aVar);
            }
            if (this.gpb != null) {
                this.gpb.c(aVar);
            }
            com.baidu.tieba.person.data.e eVar = this.mList.get(0);
            eVar.ar(aVar.aLu());
            eVar.lH(z);
            this.gpc.ss(0);
            this.goZ.a(aVar, z);
            bpb();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public f boF() {
        return this.gpb;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.goZ != null) {
                this.goZ.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.gos = baseFragment;
    }

    public void bpb() {
        if (!this.bNr) {
            if ((this.gos == null || this.gos.isPrimary()) && this.goZ != null && (this.goZ.bpt() instanceof com.baidu.tieba.view.d)) {
                ((com.baidu.tieba.view.d) this.goZ.bpt()).bpb();
            }
        }
    }

    public void bkX() {
        if (this.goZ != null && (this.goZ.bpt() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.goZ.bpt()).bkX();
        }
    }

    public void bpc() {
        if (this.goZ != null && this.goZ.aaD() != null && (this.goZ.bpt() instanceof com.baidu.tieba.personPolymeric.a)) {
            ((com.baidu.tieba.personPolymeric.a) this.goZ.bpt()).a(this.bHp, this.goZ.aaD());
            if (this.gpa != null) {
                this.goZ.setOnViewResponseListener(this.gpa);
            }
            this.goZ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void tf(String str) {
        if (!ao.isEmpty(str) && this.mList != null && this.mList.get(0) != null && this.mList.get(0).bnk() != null && this.goZ != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> bnk = this.mList.get(0).bnk();
            for (int i = 0; i < bnk.size() && bnk.get(i) != null; i++) {
                com.baidu.adp.widget.ListView.h hVar = bnk.get(i);
                if ((hVar instanceof CardPersonDynamicThreadData) && ao.equals(str, ((CardPersonDynamicThreadData) hVar).threadId)) {
                    this.goZ.a(i, str, this.gpg);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.axF);
        this.goz.onDestroy();
        if (this.goZ != null) {
            this.goZ.onDestory();
        }
        bkX();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void gj(boolean z) {
        if (z) {
            if (this.bNr) {
                loadData();
            }
            if (TbadkCoreApplication.isLogin()) {
                bpb();
                return;
            } else {
                bkX();
                return;
            }
        }
        bkX();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            bpb();
            bpc();
            if (!this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
                this.mIsHost = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
                this.bHp.finish();
                return;
            }
            return;
        }
        bkX();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void boG() {
        if (this.goZ != null) {
            this.goZ.boG();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void lS(boolean z) {
        this.goZ.lS(z);
    }

    private void initListener() {
        this.dgV = new CustomMessageListener(2921003) { // from class: com.baidu.tieba.personPolymeric.b.i.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.bkX();
            }
        };
        this.dgV.setTag(this.axF);
        MessageManager.getInstance().registerListener(this.dgV);
        this.gpe = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.personPolymeric.b.i.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.tf((String) customResponsedMessage.getData());
                }
            }
        };
        this.gpe.setTag(this.axF);
        MessageManager.getInstance().registerListener(this.gpe);
        this.gpf = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.personPolymeric.b.i.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.tf((String) customResponsedMessage.getData());
                    l.showToast(i.this.mContext.getPageActivity(), e.j.person_polymeric_set_privacy_success);
                }
            }
        };
        this.gpf.setTag(this.axF);
        MessageManager.getInstance().registerListener(this.gpf);
    }
}
