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
    private BaseFragment ffs;
    private PersonPolymericModel ffv;
    private g ffz;
    private e fga;
    private s fgb;
    private com.baidu.tieba.personPolymeric.event.b fgc;
    private f fgd;
    private d fge;
    private PersonPostModel fgf;
    private boolean fgg;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.f> mList;
    private long mUserId;
    private View mView;
    private boolean blC = true;
    private boolean ffZ = false;
    private int mSex = 1;
    private int mSkinType = 3;
    private final com.baidu.tieba.view.i fgh = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.personPolymeric.b.i.6
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
        this.fga = eVar;
        this.mView = eVar.mRootView;
        this.fgf = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null, this.mIsHost);
        this.fgb = new s(baseFragmentActivity.getPageContext(), eVar, bdUniqueId, z, z2);
        this.fgb.X(this.mView);
        this.fgc = new com.baidu.tieba.personPolymeric.event.b(baseFragmentActivity.getPageContext());
        this.fgc.a(this.fga);
        this.fgb.setOnViewResponseListener(this.fgc);
        this.fgb.a(this);
        resetData();
        this.fgb.a(this.fgh);
        this.ffz = this.fga.aWF();
        this.fgb.J(this.ffz);
        this.ffv = this.fga.aWG();
        this.ffv.d(new q(z));
        this.fge = this.fga.aWJ();
        this.fgd = new f(baseFragmentActivity.getPageContext(), this.fga.aWI(), this.fga.aWH(), this.fgb.ahj(), bdUniqueId);
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.f());
        this.mList.add(new com.baidu.tieba.person.data.f());
        this.fgb.setList(this.mList);
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
                                i.this.fgb.alC();
                                i.this.fge.dK(true);
                            }
                        }, 800L);
                    } else if (!this.mIsHost && z && this.ffv != null && this.ffv.aXe() != null && this.ffv.aXe().aWZ()) {
                        this.fgb.alC();
                        ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.j jVar = new com.baidu.tieba.personPolymeric.c.j();
                        jVar.sex = this.mSex;
                        arrayList.add(jVar);
                        this.fgb.am(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.3
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.fgb.alC();
                                i.this.fge.dK(true);
                            }
                        }, 800L);
                    } else {
                        this.fge.kk(z2);
                        this.fgf.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.i.4
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                i.this.fgb.alC();
                                if (personPostModel != null) {
                                    l.showToast(i.this.abz.getContext(), personPostModel.getErrorString());
                                } else {
                                    l.showToast(i.this.abz.getContext(), i.this.abz.getString(d.l.data_load_error));
                                }
                                if (z4) {
                                    i.this.fgb.am(null);
                                    i.this.fge.YW();
                                }
                            }
                        });
                        this.fgf.fetchPost(this.esL.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.i.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                int t;
                                if (personPostModel.getErrorCode() != 0) {
                                    l.showToast(i.this.abz.getContext(), personPostModel.getErrorString());
                                }
                                i.this.fgb.alC();
                                if (z) {
                                    com.baidu.tieba.person.data.f fVar2 = (com.baidu.tieba.person.data.f) i.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<com.baidu.adp.widget.ListView.f> aVl = ((com.baidu.tieba.person.data.f) i.this.mList.get(1)).aVl();
                                        if (v.u(aVl)) {
                                            i.this.fge.YW();
                                            return;
                                        } else if (i.this.al(personPostModel.postList)) {
                                            fVar2.kc(false);
                                            i.this.fgb.am(aVl);
                                            i.this.fge.a(true, (List<com.baidu.adp.widget.ListView.f>) aVl);
                                            return;
                                        } else if (i.cF(personPostModel.postList) == 0) {
                                            fVar2.kc(false);
                                            i.this.fgb.am(aVl);
                                            i.this.fge.a(true, (List<com.baidu.adp.widget.ListView.f>) aVl);
                                            return;
                                        } else {
                                            aVl.addAll(personPostModel.postList);
                                            i.this.fge.wu();
                                            fVar2.ak(aVl);
                                            i.this.fgb.am(aVl);
                                            return;
                                        }
                                    }
                                    fVar2.kc(true);
                                    fVar2.ak(personPostModel.postList);
                                    fVar2.qe(0);
                                    i.this.fgb.am(personPostModel.postList);
                                    if (!z3) {
                                        i.this.fgb.aXo();
                                    }
                                    if (fVar2.aVl() != null && (t = v.t(fVar2.aVl())) > 0 && t <= 2) {
                                        for (int i = 0; i < t; i++) {
                                            if (fVar2.aVl().get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                                                ((com.baidu.tieba.personPolymeric.c.i) fVar2.aVl().get(i)).isHost = i.this.mIsHost;
                                                i.this.fge.YW();
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
                                        i.this.fgb.am(aVl2);
                                        i.this.fge.a(true, (List<com.baidu.adp.widget.ListView.f>) aVl2);
                                        return;
                                    }
                                    aVl2.addAll(personPostModel.threadList);
                                    fVar.kc(true);
                                    fVar.ak(aVl2);
                                    i.this.fge.wu();
                                    i.this.fgb.cE(aVl2);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z);
                    }
                }
            }
        } else if (!z2) {
            this.fge.wt();
        } else {
            l.showToast(this.abz.getContext(), this.abz.getString(d.l.data_load_error));
            if (z) {
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                iVar.isHost = this.mIsHost;
                arrayList2.add(iVar);
                this.fge.YW();
                this.fgb.am(arrayList2);
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
        if (this.fga != null) {
            this.fga.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void h(boolean z, boolean z2, boolean z3) {
        j(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void Qj() {
        if (this.fga != null) {
            this.fga.Qj();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.fgf.resetThreadPn();
        if (this.ffv != null) {
            this.ffv.resetData();
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
        this.fgb.alC();
        this.esL.hideLoadingView(this.mView);
        if (aVar == null) {
            this.fge.J(TbadkCoreApplication.getInst().getString(d.l.neterror), true);
            this.fge.YW();
            this.fge.qn(8);
            return;
        }
        this.fge.Oc();
        aVar.aWX();
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
        if (this.ffz != null) {
            this.ffz.a(aVar);
        }
        if (this.fgd != null) {
            this.fgd.c(aVar);
        }
        com.baidu.tieba.person.data.f fVar = this.mList.get(0);
        fVar.qe(0);
        fVar.ak(aVar.arr());
        fVar.kc(z);
        this.fge.qn(0);
        this.fgb.a(aVar, z);
        aWU();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public f aWx() {
        return this.fgd;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fgb != null) {
                this.fgb.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.ffs = baseFragment;
    }

    public void aWU() {
        if (!this.blC) {
            if ((this.ffs == null || this.ffs.isPrimary()) && this.fgb != null && (this.fgb.aXl() instanceof com.baidu.tieba.view.d)) {
                ((com.baidu.tieba.view.d) this.fgb.aXl()).aWU();
            }
        }
    }

    public void aSR() {
        if (this.fgb != null && (this.fgb.aXl() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.fgb.aXl()).aSR();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        this.ffz.onDestroy();
        if (this.fgb != null) {
            this.fgb.onDestory();
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
                aWU();
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
            aWU();
        } else {
            aSR();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void aWy() {
        if (this.fgb != null) {
            this.fgb.aWy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void kj(boolean z) {
        this.fgg = z;
        this.fgb.kj(z);
    }
}
