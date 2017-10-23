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
import com.baidu.tieba.personPolymeric.view.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class i implements com.baidu.tieba.model.a, a {
    private TbPageContext abm;
    private CustomMessageListener ccW;
    private BaseFragmentActivity esx;
    private e ffL;
    private s ffM;
    private com.baidu.tieba.personPolymeric.event.b ffN;
    private f ffO;
    private d ffP;
    private PersonPostModel ffQ;
    private boolean ffR;
    private BaseFragment ffd;
    private PersonPolymericModel ffg;
    private g ffk;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.f> mList;
    private long mUserId;
    private View mView;
    private boolean blo = true;
    private boolean ffK = false;
    private int mSex = 1;
    private int mSkinType = 3;
    private final com.baidu.tieba.view.i ffS = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.personPolymeric.b.i.6
        @Override // com.baidu.tieba.view.i
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                i.this.aSM();
            }
        }

        @Override // com.baidu.tieba.view.i
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(BaseFragmentActivity baseFragmentActivity, e eVar, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.esx = baseFragmentActivity;
        this.abm = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.mIsHost = z;
        this.ffL = eVar;
        this.mView = eVar.mRootView;
        this.ffQ = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null, this.mIsHost);
        this.ffM = new s(baseFragmentActivity.getPageContext(), eVar, bdUniqueId, z, z2);
        this.ffM.X(this.mView);
        this.ffN = new com.baidu.tieba.personPolymeric.event.b(baseFragmentActivity.getPageContext());
        this.ffN.a(this.ffL);
        this.ffM.setOnViewResponseListener(this.ffN);
        this.ffM.a(this);
        resetData();
        this.ffM.a(this.ffS);
        this.ffk = this.ffL.aWz();
        this.ffM.J(this.ffk);
        this.ffg = this.ffL.aWA();
        this.ffg.d(new q(z));
        this.ffP = this.ffL.aWD();
        this.ffO = new f(baseFragmentActivity.getPageContext(), this.ffL.aWC(), this.ffL.aWB(), this.ffM.ahe(), bdUniqueId);
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.f());
        this.mList.add(new com.baidu.tieba.person.data.f());
        this.ffM.setList(this.mList);
        this.ccW = new CustomMessageListener(CmdConfigCustom.CMD_HOME_HIDE_GUIDE) { // from class: com.baidu.tieba.personPolymeric.b.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.aSM();
            }
        };
        this.ccW.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ccW);
    }

    public void j(final boolean z, boolean z2, final boolean z3) {
        if (com.baidu.adp.lib.util.j.gV()) {
            if (!v.u(this.mList) && this.mList.size() >= 2) {
                final com.baidu.tieba.person.data.f fVar = this.mList.get(z ? 1 : 0);
                if (fVar != null) {
                    if (!fVar.aVf() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.2
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.ffM.alx();
                                i.this.ffP.dJ(true);
                            }
                        }, 800L);
                    } else if (!this.mIsHost && z && this.ffg != null && this.ffg.aWY() != null && this.ffg.aWY().aWT()) {
                        this.ffM.alx();
                        ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.j jVar = new com.baidu.tieba.personPolymeric.c.j();
                        jVar.sex = this.mSex;
                        arrayList.add(jVar);
                        this.ffM.am(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.3
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.ffM.alx();
                                i.this.ffP.dJ(true);
                            }
                        }, 800L);
                    } else {
                        this.ffP.kj(z2);
                        this.ffQ.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.i.4
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                i.this.ffM.alx();
                                if (personPostModel != null) {
                                    l.showToast(i.this.abm.getContext(), personPostModel.getErrorString());
                                } else {
                                    l.showToast(i.this.abm.getContext(), i.this.abm.getString(d.l.data_load_error));
                                }
                                if (z4) {
                                    i.this.ffM.am(null);
                                    i.this.ffP.YS();
                                }
                            }
                        });
                        this.ffQ.fetchPost(this.esx.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.i.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                int t;
                                if (personPostModel.getErrorCode() != 0) {
                                    l.showToast(i.this.abm.getContext(), personPostModel.getErrorString());
                                }
                                i.this.ffM.alx();
                                if (z) {
                                    com.baidu.tieba.person.data.f fVar2 = (com.baidu.tieba.person.data.f) i.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<com.baidu.adp.widget.ListView.f> aVg = ((com.baidu.tieba.person.data.f) i.this.mList.get(1)).aVg();
                                        if (v.u(aVg)) {
                                            i.this.ffP.YS();
                                            return;
                                        } else if (i.this.al(personPostModel.postList)) {
                                            fVar2.kb(false);
                                            i.this.ffM.am(aVg);
                                            i.this.ffP.a(true, (List<com.baidu.adp.widget.ListView.f>) aVg);
                                            return;
                                        } else if (i.cF(personPostModel.postList) == 0) {
                                            fVar2.kb(false);
                                            i.this.ffM.am(aVg);
                                            i.this.ffP.a(true, (List<com.baidu.adp.widget.ListView.f>) aVg);
                                            return;
                                        } else {
                                            aVg.addAll(personPostModel.postList);
                                            i.this.ffP.wn();
                                            fVar2.ak(aVg);
                                            i.this.ffM.am(aVg);
                                            return;
                                        }
                                    }
                                    fVar2.kb(true);
                                    fVar2.ak(personPostModel.postList);
                                    fVar2.qd(0);
                                    i.this.ffM.am(personPostModel.postList);
                                    if (!z3) {
                                        i.this.ffM.aXi();
                                    }
                                    if (fVar2.aVg() != null && (t = v.t(fVar2.aVg())) > 0 && t <= 2) {
                                        for (int i = 0; i < t; i++) {
                                            if (fVar2.aVg().get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                                                ((com.baidu.tieba.personPolymeric.c.i) fVar2.aVg().get(i)).isHost = i.this.mIsHost;
                                                i.this.ffP.YS();
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<com.baidu.adp.widget.ListView.f> aVg2 = ((com.baidu.tieba.person.data.f) i.this.mList.get(0)).aVg();
                                if (!v.u(aVg2)) {
                                    if (i.this.al(personPostModel.postList)) {
                                        fVar.kb(false);
                                        i.this.ffM.am(aVg2);
                                        i.this.ffP.a(true, (List<com.baidu.adp.widget.ListView.f>) aVg2);
                                        return;
                                    }
                                    aVg2.addAll(personPostModel.threadList);
                                    fVar.kb(true);
                                    fVar.ak(aVg2);
                                    i.this.ffP.wn();
                                    i.this.ffM.cE(aVg2);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z);
                    }
                }
            }
        } else if (!z2) {
            this.ffP.wm();
        } else {
            l.showToast(this.abm.getContext(), this.abm.getString(d.l.data_load_error));
            if (z) {
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                iVar.isHost = this.mIsHost;
                arrayList2.add(iVar);
                this.ffP.YS();
                this.ffM.am(arrayList2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean al(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        int t = v.t(arrayList);
        if (t != 0) {
            if (t > 2) {
                return false;
            }
            if (!(arrayList.get(0) instanceof com.baidu.tieba.personPolymeric.c.i) && !(arrayList.get(1) instanceof com.baidu.tieba.personPolymeric.c.i)) {
                return false;
            }
        }
        return true;
    }

    public static int cF(List<com.baidu.adp.widget.ListView.f> list) {
        int i = 0;
        if (v.t(list) == 0) {
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
        if (v.t(arrayList) == 0) {
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
        if (this.ffL != null) {
            this.ffL.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void h(boolean z, boolean z2, boolean z3) {
        j(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void Qf() {
        if (this.ffL != null) {
            this.ffL.Qf();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.ffQ.resetThreadPn();
        if (this.ffg != null) {
            this.ffg.resetData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public com.baidu.tieba.person.data.f oH(int i) {
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
        this.ffM.alx();
        this.esx.hideLoadingView(this.mView);
        if (aVar == null) {
            this.ffP.J(TbadkCoreApplication.getInst().getString(d.l.neterror), true);
            this.ffP.YS();
            this.ffP.qm(8);
            return;
        }
        this.ffP.NW();
        aVar.aWR();
        if (aVar.arm() != null) {
            z = aVar.arm().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.blo = false;
        if (this.mIsHost) {
            com.baidu.tbadk.getUserInfo.b.DI().a(aVar.getUserData());
        }
        if (this.ffk != null) {
            this.ffk.a(aVar);
        }
        if (this.ffO != null) {
            this.ffO.c(aVar);
        }
        com.baidu.tieba.person.data.f fVar = this.mList.get(0);
        fVar.qd(0);
        fVar.ak(aVar.arm());
        fVar.kb(z);
        this.ffP.qm(0);
        this.ffM.a(aVar, z);
        aWO();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public f aWr() {
        return this.ffO;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ffM != null) {
                this.ffM.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.ffd = baseFragment;
    }

    public void aWO() {
        if (!this.blo) {
            if ((this.ffd == null || this.ffd.isPrimary()) && this.ffM != null && (this.ffM.aXf() instanceof com.baidu.tieba.view.d)) {
                ((com.baidu.tieba.view.d) this.ffM.aXf()).aWO();
            }
        }
    }

    public void aSM() {
        if (this.ffM != null && (this.ffM.aXf() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.ffM.aXf()).aSM();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        this.ffk.onDestroy();
        if (this.ffM != null) {
            this.ffM.onDestory();
        }
        aSM();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void kh(boolean z) {
        if (z) {
            if (this.blo) {
                Qf();
            }
            if (TbadkCoreApplication.isLogin()) {
                aWO();
                return;
            } else {
                aSM();
                return;
            }
        }
        aSM();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            aWO();
        } else {
            aSM();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void aWs() {
        if (this.ffM != null) {
            this.ffM.aWs();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void ki(boolean z) {
        this.ffR = z;
        this.ffM.ki(z);
    }
}
