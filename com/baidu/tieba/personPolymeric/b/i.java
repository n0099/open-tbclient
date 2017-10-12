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
    private TbPageContext abz;
    private CustomMessageListener cdi;
    private BaseFragmentActivity esL;
    private e ffZ;
    private BaseFragment ffr;
    private PersonPolymericModel ffu;
    private g ffy;
    private s fga;
    private com.baidu.tieba.personPolymeric.event.b fgb;
    private f fgc;
    private d fgd;
    private PersonPostModel fge;
    private boolean fgf;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.f> mList;
    private long mUserId;
    private View mView;
    private boolean blC = true;
    private boolean ffY = false;
    private int mSex = 1;
    private int mSkinType = 3;
    private final com.baidu.tieba.view.i fgg = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.personPolymeric.b.i.6
        @Override // com.baidu.tieba.view.i
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                i.this.aSR();
            }
        }

        @Override // com.baidu.tieba.view.i
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(BaseFragmentActivity baseFragmentActivity, e eVar, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.esL = baseFragmentActivity;
        this.abz = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.mIsHost = z;
        this.ffZ = eVar;
        this.mView = eVar.mRootView;
        this.fge = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null, this.mIsHost);
        this.fga = new s(baseFragmentActivity.getPageContext(), eVar, bdUniqueId, z, z2);
        this.fga.X(this.mView);
        this.fgb = new com.baidu.tieba.personPolymeric.event.b(baseFragmentActivity.getPageContext());
        this.fgb.a(this.ffZ);
        this.fga.setOnViewResponseListener(this.fgb);
        this.fga.a(this);
        resetData();
        this.fga.a(this.fgg);
        this.ffy = this.ffZ.aWE();
        this.fga.J(this.ffy);
        this.ffu = this.ffZ.aWF();
        this.ffu.d(new q(z));
        this.fgd = this.ffZ.aWI();
        this.fgc = new f(baseFragmentActivity.getPageContext(), this.ffZ.aWH(), this.ffZ.aWG(), this.fga.ahj(), bdUniqueId);
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.f());
        this.mList.add(new com.baidu.tieba.person.data.f());
        this.fga.setList(this.mList);
        this.cdi = new CustomMessageListener(CmdConfigCustom.CMD_HOME_HIDE_GUIDE) { // from class: com.baidu.tieba.personPolymeric.b.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.aSR();
            }
        };
        this.cdi.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cdi);
    }

    public void j(final boolean z, boolean z2, final boolean z3) {
        if (com.baidu.adp.lib.util.j.gV()) {
            if (!v.u(this.mList) && this.mList.size() >= 2) {
                final com.baidu.tieba.person.data.f fVar = this.mList.get(z ? 1 : 0);
                if (fVar != null) {
                    if (!fVar.aVk() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.2
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.fga.alC();
                                i.this.fgd.dK(true);
                            }
                        }, 800L);
                    } else if (!this.mIsHost && z && this.ffu != null && this.ffu.aXd() != null && this.ffu.aXd().aWY()) {
                        this.fga.alC();
                        ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.j jVar = new com.baidu.tieba.personPolymeric.c.j();
                        jVar.sex = this.mSex;
                        arrayList.add(jVar);
                        this.fga.am(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.3
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.fga.alC();
                                i.this.fgd.dK(true);
                            }
                        }, 800L);
                    } else {
                        this.fgd.kk(z2);
                        this.fge.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.i.4
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                i.this.fga.alC();
                                if (personPostModel != null) {
                                    l.showToast(i.this.abz.getContext(), personPostModel.getErrorString());
                                } else {
                                    l.showToast(i.this.abz.getContext(), i.this.abz.getString(d.l.data_load_error));
                                }
                                if (z4) {
                                    i.this.fga.am(null);
                                    i.this.fgd.YW();
                                }
                            }
                        });
                        this.fge.fetchPost(this.esL.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.i.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                int t;
                                if (personPostModel.getErrorCode() != 0) {
                                    l.showToast(i.this.abz.getContext(), personPostModel.getErrorString());
                                }
                                i.this.fga.alC();
                                if (z) {
                                    com.baidu.tieba.person.data.f fVar2 = (com.baidu.tieba.person.data.f) i.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<com.baidu.adp.widget.ListView.f> aVl = ((com.baidu.tieba.person.data.f) i.this.mList.get(1)).aVl();
                                        if (v.u(aVl)) {
                                            i.this.fgd.YW();
                                            return;
                                        } else if (i.this.al(personPostModel.postList)) {
                                            fVar2.kc(false);
                                            i.this.fga.am(aVl);
                                            i.this.fgd.a(true, (List<com.baidu.adp.widget.ListView.f>) aVl);
                                            return;
                                        } else if (i.cF(personPostModel.postList) == 0) {
                                            fVar2.kc(false);
                                            i.this.fga.am(aVl);
                                            i.this.fgd.a(true, (List<com.baidu.adp.widget.ListView.f>) aVl);
                                            return;
                                        } else {
                                            aVl.addAll(personPostModel.postList);
                                            i.this.fgd.wu();
                                            fVar2.ak(aVl);
                                            i.this.fga.am(aVl);
                                            return;
                                        }
                                    }
                                    fVar2.kc(true);
                                    fVar2.ak(personPostModel.postList);
                                    fVar2.qe(0);
                                    i.this.fga.am(personPostModel.postList);
                                    if (!z3) {
                                        i.this.fga.aXn();
                                    }
                                    if (fVar2.aVl() != null && (t = v.t(fVar2.aVl())) > 0 && t <= 2) {
                                        for (int i = 0; i < t; i++) {
                                            if (fVar2.aVl().get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                                                ((com.baidu.tieba.personPolymeric.c.i) fVar2.aVl().get(i)).isHost = i.this.mIsHost;
                                                i.this.fgd.YW();
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<com.baidu.adp.widget.ListView.f> aVl2 = ((com.baidu.tieba.person.data.f) i.this.mList.get(0)).aVl();
                                if (!v.u(aVl2)) {
                                    if (i.this.al(personPostModel.postList)) {
                                        fVar.kc(false);
                                        i.this.fga.am(aVl2);
                                        i.this.fgd.a(true, (List<com.baidu.adp.widget.ListView.f>) aVl2);
                                        return;
                                    }
                                    aVl2.addAll(personPostModel.threadList);
                                    fVar.kc(true);
                                    fVar.ak(aVl2);
                                    i.this.fgd.wu();
                                    i.this.fga.cE(aVl2);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z);
                    }
                }
            }
        } else if (!z2) {
            this.fgd.wt();
        } else {
            l.showToast(this.abz.getContext(), this.abz.getString(d.l.data_load_error));
            if (z) {
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                iVar.isHost = this.mIsHost;
                arrayList2.add(iVar);
                this.fgd.YW();
                this.fga.am(arrayList2);
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
        if (this.ffZ != null) {
            this.ffZ.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void h(boolean z, boolean z2, boolean z3) {
        j(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void Qj() {
        if (this.ffZ != null) {
            this.ffZ.Qj();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.fge.resetThreadPn();
        if (this.ffu != null) {
            this.ffu.resetData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public com.baidu.tieba.person.data.f oI(int i) {
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
        this.fga.alC();
        this.esL.hideLoadingView(this.mView);
        if (aVar == null) {
            this.fgd.J(TbadkCoreApplication.getInst().getString(d.l.neterror), true);
            this.fgd.YW();
            this.fgd.qn(8);
            return;
        }
        this.fgd.Oc();
        aVar.aWW();
        if (aVar.arr() != null) {
            z = aVar.arr().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.blC = false;
        if (this.mIsHost) {
            com.baidu.tbadk.getUserInfo.b.DO().a(aVar.getUserData());
        }
        if (this.ffy != null) {
            this.ffy.a(aVar);
        }
        if (this.fgc != null) {
            this.fgc.c(aVar);
        }
        com.baidu.tieba.person.data.f fVar = this.mList.get(0);
        fVar.qe(0);
        fVar.ak(aVar.arr());
        fVar.kc(z);
        this.fgd.qn(0);
        this.fga.a(aVar, z);
        aWT();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public f aWw() {
        return this.fgc;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fga != null) {
                this.fga.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.ffr = baseFragment;
    }

    public void aWT() {
        if (!this.blC) {
            if ((this.ffr == null || this.ffr.isPrimary()) && this.fga != null && (this.fga.aXk() instanceof com.baidu.tieba.view.d)) {
                ((com.baidu.tieba.view.d) this.fga.aXk()).aWT();
            }
        }
    }

    public void aSR() {
        if (this.fga != null && (this.fga.aXk() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.fga.aXk()).aSR();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        this.ffy.onDestroy();
        if (this.fga != null) {
            this.fga.onDestory();
        }
        aSR();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void ki(boolean z) {
        if (z) {
            if (this.blC) {
                Qj();
            }
            if (TbadkCoreApplication.isLogin()) {
                aWT();
                return;
            } else {
                aSR();
                return;
            }
        }
        aSR();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            aWT();
        } else {
            aSR();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void aWx() {
        if (this.fga != null) {
            this.fga.aWx();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void kj(boolean z) {
        this.fgf = z;
        this.fga.kj(z);
    }
}
