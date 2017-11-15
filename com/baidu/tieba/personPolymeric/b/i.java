package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.c.q;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.view.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class i implements com.baidu.tieba.model.a, a {
    private TbPageContext abI;
    private CustomMessageListener ckK;
    private BaseFragmentActivity eBb;
    private BaseFragment fnQ;
    private PersonPolymericModel fnT;
    private g fnX;
    private f foA;
    private d foB;
    private PersonPostModel foC;
    private e fox;
    private t foy;
    private com.baidu.tieba.personPolymeric.event.b foz;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.f> mList;
    private long mUserId;
    private View mView;
    private boolean bne = true;
    private int mSex = 1;
    private int mSkinType = 3;
    private final com.baidu.tieba.view.j foD = new com.baidu.tieba.view.j() { // from class: com.baidu.tieba.personPolymeric.b.i.6
        @Override // com.baidu.tieba.view.j
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                i.this.aWi();
            }
        }

        @Override // com.baidu.tieba.view.j
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(BaseFragmentActivity baseFragmentActivity, e eVar, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.eBb = baseFragmentActivity;
        this.abI = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.mIsHost = z;
        this.fox = eVar;
        this.mView = eVar.mRootView;
        this.foC = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null, this.mIsHost);
        this.foy = new t(baseFragmentActivity.getPageContext(), eVar, bdUniqueId, z, z2);
        this.foy.Z(this.mView);
        this.foz = new com.baidu.tieba.personPolymeric.event.b(baseFragmentActivity.getPageContext());
        this.foz.a(this.fox);
        this.foy.setOnViewResponseListener(this.foz);
        this.foy.a(this);
        resetData();
        this.foy.a(this.foD);
        this.fnX = this.fox.aZK();
        this.foy.K(this.fnX);
        this.fnT = this.fox.aZL();
        this.fnT.d(new q(z));
        this.foB = this.fox.aZO();
        this.foA = new f(baseFragmentActivity.getPageContext(), this.fox.aZN(), this.fox.aZM(), this.foy.ajA(), bdUniqueId);
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.f());
        this.mList.add(new com.baidu.tieba.person.data.f());
        this.foy.setList(this.mList);
        this.ckK = new CustomMessageListener(CmdConfigCustom.CMD_HOME_HIDE_GUIDE) { // from class: com.baidu.tieba.personPolymeric.b.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.aWi();
            }
        };
        this.ckK.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ckK);
    }

    public void j(final boolean z, boolean z2, final boolean z3) {
        if (com.baidu.adp.lib.util.j.gV()) {
            if (!v.v(this.mList) && this.mList.size() >= 2) {
                final com.baidu.tieba.person.data.f fVar = this.mList.get(z ? 1 : 0);
                if (fVar != null) {
                    if (!fVar.aYq() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.2
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.foy.aox();
                                i.this.foB.dN(true);
                            }
                        }, 800L);
                    } else if (!this.mIsHost && z && this.fnT != null && this.fnT.ban() != null && this.fnT.ban().bag()) {
                        this.foy.aox();
                        ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.j jVar = new com.baidu.tieba.personPolymeric.c.j();
                        jVar.sex = this.mSex;
                        arrayList.add(jVar);
                        this.foy.am(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.3
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.foy.aox();
                                i.this.foB.dN(true);
                            }
                        }, 800L);
                    } else {
                        this.foB.kj(z2);
                        this.foC.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.i.4
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                i.this.foy.aox();
                                if (personPostModel != null) {
                                    l.showToast(i.this.abI.getContext(), personPostModel.getErrorString());
                                } else {
                                    l.showToast(i.this.abI.getContext(), i.this.abI.getString(d.j.data_load_error));
                                }
                                if (z4) {
                                    i.this.foy.am(null);
                                    i.this.foB.abo();
                                }
                            }
                        });
                        this.foC.fetchPost(this.eBb.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.i.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                int u;
                                if (personPostModel.getErrorCode() != 0) {
                                    l.showToast(i.this.abI.getContext(), personPostModel.getErrorString());
                                }
                                i.this.foy.aox();
                                if (z) {
                                    com.baidu.tieba.person.data.f fVar2 = (com.baidu.tieba.person.data.f) i.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<com.baidu.adp.widget.ListView.f> aYr = ((com.baidu.tieba.person.data.f) i.this.mList.get(1)).aYr();
                                        if (v.v(aYr)) {
                                            i.this.foB.abo();
                                            return;
                                        } else if (i.this.al(personPostModel.postList)) {
                                            fVar2.kb(false);
                                            i.this.foy.am(aYr);
                                            i.this.foB.a(true, (List<com.baidu.adp.widget.ListView.f>) aYr);
                                            return;
                                        } else if (i.cH(personPostModel.postList) == 0) {
                                            fVar2.kb(false);
                                            i.this.foy.am(aYr);
                                            i.this.foB.a(true, (List<com.baidu.adp.widget.ListView.f>) aYr);
                                            return;
                                        } else {
                                            aYr.addAll(personPostModel.postList);
                                            i.this.foB.wu();
                                            fVar2.ak(aYr);
                                            i.this.foy.am(aYr);
                                            return;
                                        }
                                    }
                                    fVar2.kb(true);
                                    fVar2.ak(personPostModel.postList);
                                    i.this.foy.am(personPostModel.postList);
                                    if (!z3) {
                                        i.this.foy.bay();
                                    }
                                    if (fVar2.aYr() != null && (u = v.u(fVar2.aYr())) > 0 && u <= 2) {
                                        for (int i = 0; i < u; i++) {
                                            if (fVar2.aYr().get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                                                ((com.baidu.tieba.personPolymeric.c.i) fVar2.aYr().get(i)).isHost = i.this.mIsHost;
                                                i.this.foB.abo();
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<com.baidu.adp.widget.ListView.f> aYr2 = ((com.baidu.tieba.person.data.f) i.this.mList.get(0)).aYr();
                                if (!v.v(aYr2)) {
                                    if (i.this.al(personPostModel.postList)) {
                                        fVar.kb(false);
                                        i.this.foy.am(aYr2);
                                        i.this.foB.a(true, (List<com.baidu.adp.widget.ListView.f>) aYr2);
                                        return;
                                    }
                                    aYr2.addAll(personPostModel.threadList);
                                    fVar.kb(true);
                                    fVar.ak(aYr2);
                                    i.this.foB.wu();
                                    i.this.foy.cG(aYr2);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z);
                    }
                }
            }
        } else if (!z2) {
            this.foB.wt();
        } else {
            l.showToast(this.abI.getContext(), this.abI.getString(d.j.data_load_error));
            if (z) {
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                iVar.isHost = this.mIsHost;
                arrayList2.add(iVar);
                this.foB.abo();
                this.foy.am(arrayList2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean al(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        int u = v.u(arrayList);
        if (u != 0) {
            if (u > 2) {
                return false;
            }
            if (!(arrayList.get(0) instanceof com.baidu.tieba.personPolymeric.c.i) && !(arrayList.get(1) instanceof com.baidu.tieba.personPolymeric.c.i)) {
                return false;
            }
        }
        return true;
    }

    public static int cH(List<com.baidu.adp.widget.ListView.f> list) {
        int i = 0;
        if (v.u(list) == 0) {
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
        if (v.u(arrayList) == 0) {
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
        if (this.fox != null) {
            this.fox.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void h(boolean z, boolean z2, boolean z3) {
        j(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void RG() {
        if (this.fox != null) {
            this.fox.RG();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.foC.resetThreadPn();
        if (this.fnT != null) {
            this.fnT.resetData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public com.baidu.tieba.person.data.f oZ(int i) {
        return (com.baidu.tieba.person.data.f) v.c(this.mList, i);
    }

    @Override // com.baidu.tieba.model.a
    public void a(int i, com.baidu.tieba.person.data.f fVar) {
        if (fVar != null) {
            this.mList.set(i, fVar);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.foy.aox();
        this.eBb.hideLoadingView(this.mView);
        if (aVar == null) {
            this.foB.H(TbadkCoreApplication.getInst().getString(d.j.neterror), true);
            this.foB.abo();
            this.foB.qD(8);
            return;
        }
        this.foB.On();
        aVar.bae();
        if (aVar.atZ() != null) {
            z = aVar.atZ().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.bne = false;
        if (this.mIsHost) {
            com.baidu.tbadk.getUserInfo.b.Ej().a(aVar.getUserData());
        }
        if (this.fnX != null) {
            this.fnX.a(aVar);
        }
        if (this.foA != null) {
            this.foA.c(aVar);
        }
        com.baidu.tieba.person.data.f fVar = this.mList.get(0);
        fVar.ak(aVar.atZ());
        fVar.kb(z);
        this.foB.qD(0);
        this.foy.a(aVar, z);
        aZZ();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public f aZC() {
        return this.foA;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.foy != null) {
                this.foy.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.fnQ = baseFragment;
    }

    public void aZZ() {
        if (!this.bne) {
            if ((this.fnQ == null || this.fnQ.isPrimary()) && this.foy != null && (this.foy.bav() instanceof com.baidu.tieba.view.e)) {
                ((com.baidu.tieba.view.e) this.foy.bav()).aZZ();
            }
        }
    }

    public void aWi() {
        if (this.foy != null && (this.foy.bav() instanceof com.baidu.tieba.view.e)) {
            ((com.baidu.tieba.view.e) this.foy.bav()).aWi();
        }
    }

    public void baa() {
        if (this.foy != null && this.foy.ajA() != null && (this.foy.bav() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.foy.bav()).a(this.eBb, this.foy.ajA());
            if (this.foz != null) {
                this.foy.setOnViewResponseListener(this.foz);
            }
            this.foy.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        this.fnX.onDestroy();
        if (this.foy != null) {
            this.foy.onDestory();
        }
        aWi();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void fj(boolean z) {
        if (z) {
            if (this.bne) {
                RG();
            }
            if (TbadkCoreApplication.isLogin()) {
                aZZ();
                return;
            } else {
                aWi();
                return;
            }
        }
        aWi();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            aZZ();
            baa();
            return;
        }
        aWi();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void aZD() {
        if (this.foy != null) {
            this.foy.aZD();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void ki(boolean z) {
        this.foy.ki(z);
    }
}
