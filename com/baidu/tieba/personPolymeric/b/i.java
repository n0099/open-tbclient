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
    private CustomMessageListener ckr;
    private BaseFragmentActivity eAH;
    private g fnA;
    private e fnZ;
    private BaseFragment fnt;
    private PersonPolymericModel fnw;
    private t foa;
    private com.baidu.tieba.personPolymeric.event.b fob;
    private f foc;
    private d fod;
    private PersonPostModel foe;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.f> mList;
    private long mUserId;
    private View mView;
    private boolean bmV = true;
    private int mSex = 1;
    private int mSkinType = 3;
    private final com.baidu.tieba.view.j fof = new com.baidu.tieba.view.j() { // from class: com.baidu.tieba.personPolymeric.b.i.6
        @Override // com.baidu.tieba.view.j
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                i.this.aWa();
            }
        }

        @Override // com.baidu.tieba.view.j
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(BaseFragmentActivity baseFragmentActivity, e eVar, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.eAH = baseFragmentActivity;
        this.abI = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.mIsHost = z;
        this.fnZ = eVar;
        this.mView = eVar.mRootView;
        this.foe = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null, this.mIsHost);
        this.foa = new t(baseFragmentActivity.getPageContext(), eVar, bdUniqueId, z, z2);
        this.foa.Z(this.mView);
        this.fob = new com.baidu.tieba.personPolymeric.event.b(baseFragmentActivity.getPageContext());
        this.fob.a(this.fnZ);
        this.foa.setOnViewResponseListener(this.fob);
        this.foa.a(this);
        resetData();
        this.foa.a(this.fof);
        this.fnA = this.fnZ.aZC();
        this.foa.K(this.fnA);
        this.fnw = this.fnZ.aZD();
        this.fnw.d(new q(z));
        this.fod = this.fnZ.aZG();
        this.foc = new f(baseFragmentActivity.getPageContext(), this.fnZ.aZF(), this.fnZ.aZE(), this.foa.ajm(), bdUniqueId);
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.f());
        this.mList.add(new com.baidu.tieba.person.data.f());
        this.foa.setList(this.mList);
        this.ckr = new CustomMessageListener(CmdConfigCustom.CMD_HOME_HIDE_GUIDE) { // from class: com.baidu.tieba.personPolymeric.b.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.aWa();
            }
        };
        this.ckr.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ckr);
    }

    public void j(final boolean z, boolean z2, final boolean z3) {
        if (com.baidu.adp.lib.util.j.gV()) {
            if (!v.v(this.mList) && this.mList.size() >= 2) {
                final com.baidu.tieba.person.data.f fVar = this.mList.get(z ? 1 : 0);
                if (fVar != null) {
                    if (!fVar.aYi() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.2
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.foa.aoi();
                                i.this.fod.dI(true);
                            }
                        }, 800L);
                    } else if (!this.mIsHost && z && this.fnw != null && this.fnw.baf() != null && this.fnw.baf().aZY()) {
                        this.foa.aoi();
                        ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.j jVar = new com.baidu.tieba.personPolymeric.c.j();
                        jVar.sex = this.mSex;
                        arrayList.add(jVar);
                        this.foa.am(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.3
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.foa.aoi();
                                i.this.fod.dI(true);
                            }
                        }, 800L);
                    } else {
                        this.fod.kd(z2);
                        this.foe.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.i.4
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                i.this.foa.aoi();
                                if (personPostModel != null) {
                                    l.showToast(i.this.abI.getContext(), personPostModel.getErrorString());
                                } else {
                                    l.showToast(i.this.abI.getContext(), i.this.abI.getString(d.j.data_load_error));
                                }
                                if (z4) {
                                    i.this.foa.am(null);
                                    i.this.fod.abc();
                                }
                            }
                        });
                        this.foe.fetchPost(this.eAH.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.i.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                int u;
                                if (personPostModel.getErrorCode() != 0) {
                                    l.showToast(i.this.abI.getContext(), personPostModel.getErrorString());
                                }
                                i.this.foa.aoi();
                                if (z) {
                                    com.baidu.tieba.person.data.f fVar2 = (com.baidu.tieba.person.data.f) i.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<com.baidu.adp.widget.ListView.f> aYj = ((com.baidu.tieba.person.data.f) i.this.mList.get(1)).aYj();
                                        if (v.v(aYj)) {
                                            i.this.fod.abc();
                                            return;
                                        } else if (i.this.al(personPostModel.postList)) {
                                            fVar2.jV(false);
                                            i.this.foa.am(aYj);
                                            i.this.fod.a(true, (List<com.baidu.adp.widget.ListView.f>) aYj);
                                            return;
                                        } else if (i.cG(personPostModel.postList) == 0) {
                                            fVar2.jV(false);
                                            i.this.foa.am(aYj);
                                            i.this.fod.a(true, (List<com.baidu.adp.widget.ListView.f>) aYj);
                                            return;
                                        } else {
                                            aYj.addAll(personPostModel.postList);
                                            i.this.fod.wu();
                                            fVar2.ak(aYj);
                                            i.this.foa.am(aYj);
                                            return;
                                        }
                                    }
                                    fVar2.jV(true);
                                    fVar2.ak(personPostModel.postList);
                                    i.this.foa.am(personPostModel.postList);
                                    if (!z3) {
                                        i.this.foa.baq();
                                    }
                                    if (fVar2.aYj() != null && (u = v.u(fVar2.aYj())) > 0 && u <= 2) {
                                        for (int i = 0; i < u; i++) {
                                            if (fVar2.aYj().get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                                                ((com.baidu.tieba.personPolymeric.c.i) fVar2.aYj().get(i)).isHost = i.this.mIsHost;
                                                i.this.fod.abc();
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<com.baidu.adp.widget.ListView.f> aYj2 = ((com.baidu.tieba.person.data.f) i.this.mList.get(0)).aYj();
                                if (!v.v(aYj2)) {
                                    if (i.this.al(personPostModel.postList)) {
                                        fVar.jV(false);
                                        i.this.foa.am(aYj2);
                                        i.this.fod.a(true, (List<com.baidu.adp.widget.ListView.f>) aYj2);
                                        return;
                                    }
                                    aYj2.addAll(personPostModel.threadList);
                                    fVar.jV(true);
                                    fVar.ak(aYj2);
                                    i.this.fod.wu();
                                    i.this.foa.cF(aYj2);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z);
                    }
                }
            }
        } else if (!z2) {
            this.fod.wt();
        } else {
            l.showToast(this.abI.getContext(), this.abI.getString(d.j.data_load_error));
            if (z) {
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                iVar.isHost = this.mIsHost;
                arrayList2.add(iVar);
                this.fod.abc();
                this.foa.am(arrayList2);
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

    public static int cG(List<com.baidu.adp.widget.ListView.f> list) {
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
        if (this.fnZ != null) {
            this.fnZ.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void h(boolean z, boolean z2, boolean z3) {
        j(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void Rx() {
        if (this.fnZ != null) {
            this.fnZ.Rx();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.foe.resetThreadPn();
        if (this.fnw != null) {
            this.fnw.resetData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public com.baidu.tieba.person.data.f oY(int i) {
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
        this.foa.aoi();
        this.eAH.hideLoadingView(this.mView);
        if (aVar == null) {
            this.fod.H(TbadkCoreApplication.getInst().getString(d.j.neterror), true);
            this.fod.abc();
            this.fod.qC(8);
            return;
        }
        this.fod.Oc();
        aVar.aZW();
        if (aVar.atI() != null) {
            z = aVar.atI().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.bmV = false;
        if (this.mIsHost) {
            com.baidu.tbadk.getUserInfo.b.DX().a(aVar.getUserData());
        }
        if (this.fnA != null) {
            this.fnA.a(aVar);
        }
        if (this.foc != null) {
            this.foc.c(aVar);
        }
        com.baidu.tieba.person.data.f fVar = this.mList.get(0);
        fVar.ak(aVar.atI());
        fVar.jV(z);
        this.fod.qC(0);
        this.foa.a(aVar, z);
        aZR();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public f aZu() {
        return this.foc;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.foa != null) {
                this.foa.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.fnt = baseFragment;
    }

    public void aZR() {
        if (!this.bmV) {
            if ((this.fnt == null || this.fnt.isPrimary()) && this.foa != null && (this.foa.ban() instanceof com.baidu.tieba.view.e)) {
                ((com.baidu.tieba.view.e) this.foa.ban()).aZR();
            }
        }
    }

    public void aWa() {
        if (this.foa != null && (this.foa.ban() instanceof com.baidu.tieba.view.e)) {
            ((com.baidu.tieba.view.e) this.foa.ban()).aWa();
        }
    }

    public void aZS() {
        if (this.foa != null && this.foa.ajm() != null && (this.foa.ban() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.foa.ban()).a(this.eAH, this.foa.ajm());
            if (this.fob != null) {
                this.foa.setOnViewResponseListener(this.fob);
            }
            this.foa.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        this.fnA.onDestroy();
        if (this.foa != null) {
            this.foa.onDestory();
        }
        aWa();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void kb(boolean z) {
        if (z) {
            if (this.bmV) {
                Rx();
            }
            if (TbadkCoreApplication.isLogin()) {
                aZR();
                return;
            } else {
                aWa();
                return;
            }
        }
        aWa();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            aZR();
            aZS();
            return;
        }
        aWa();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void aZv() {
        if (this.foa != null) {
            this.foa.aZv();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void kc(boolean z) {
        this.foa.kc(z);
    }
}
