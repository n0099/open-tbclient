package com.baidu.tieba.personPolymeric.b;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
import com.baidu.tieba.personPolymeric.c.j;
import com.baidu.tieba.personPolymeric.c.o;
import com.baidu.tieba.personPolymeric.d.s;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h implements com.baidu.tieba.model.a, a {
    private TbPageContext aaS;
    private BaseFragment bDs;
    private d bDu;
    private PersonPolymericModel bDw;
    private BaseFragmentActivity bDx;
    private CustomMessageListener bXz;
    private boolean bkz;
    private com.baidu.tieba.e.b ckS;
    private f fhD;
    private s fif;
    private com.baidu.tieba.personPolymeric.event.b fig;
    private i fih;
    private e fii;
    private c fij;
    private PersonPostModel fik;
    private List<com.baidu.tieba.person.data.c> mList;
    private long mUserId;
    private View mView;
    private boolean biq = true;
    private boolean fie = false;
    private int mSex = 1;
    private int mSkinType = 3;
    private final k fil = new k() { // from class: com.baidu.tieba.personPolymeric.b.h.6
        @Override // com.baidu.tieba.view.k
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (h.this.fih != null && h.this.fih.fir != null) {
                h.this.fih.fir.onScrollStateChanged(absListView, i);
            }
            if (i != 0) {
                h.this.aYo();
            }
        }

        @Override // com.baidu.tieba.view.k
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (h.this.fih != null && h.this.fih.fir != null) {
                h.this.fih.fir.onScroll(absListView, i, i2, i3);
            }
        }
    };
    public View.OnTouchListener aLD = new View.OnTouchListener() { // from class: com.baidu.tieba.personPolymeric.b.h.7
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            h.this.ckS.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0080a bUZ = new a.InterfaceC0080a() { // from class: com.baidu.tieba.personPolymeric.b.h.8
        @Override // com.baidu.tieba.e.a.InterfaceC0080a
        public void ag(int i, int i2) {
            if (Y(i2) && h.this.fih != null && h.this.fih.fir != null) {
                h.this.fih.fir.en(false);
                h.this.fih.fir.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0080a
        public void ah(int i, int i2) {
            if (Y(i2) && h.this.fih != null && h.this.fih.fir != null) {
                h.this.fih.fir.en(true);
                h.this.fih.fir.hideFloatingView();
            }
        }

        private boolean Y(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(BaseFragmentActivity baseFragmentActivity, d dVar, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.bDx = baseFragmentActivity;
        this.aaS = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.bkz = z;
        this.bDu = dVar;
        this.mView = dVar.mRootView;
        this.fik = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null);
        this.fif = new s(baseFragmentActivity.getPageContext(), dVar, bdUniqueId, z, z2);
        this.fif.O(this.mView);
        this.fif.initUI();
        this.fig = new com.baidu.tieba.personPolymeric.event.b(baseFragmentActivity.getPageContext());
        this.fig.c(this.bDu);
        this.fif.setOnViewResponseListener(this.fig);
        this.fif.a(this);
        resetData();
        this.ckS = new com.baidu.tieba.e.b(baseFragmentActivity.getActivity());
        this.ckS.a(this.bUZ);
        this.fif.a(this.fil);
        this.fif.setOnTouchListener(this.aLD);
        this.fhD = this.bDu.aXX();
        this.fif.N(this.fhD);
        this.bDw = this.bDu.aXY();
        this.bDw.d(new o(z));
        this.fij = this.bDu.aYb();
        this.fii = new e(baseFragmentActivity.getPageContext(), this.bDu.aYa(), this.bDu.aXZ(), this.fif.afl(), bdUniqueId);
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.c());
        this.mList.add(new com.baidu.tieba.person.data.c());
        this.bXz = new CustomMessageListener(CmdConfigCustom.CMD_HOME_HIDE_GUIDE) { // from class: com.baidu.tieba.personPolymeric.b.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                h.this.aYo();
            }
        };
        this.bXz.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bXz);
    }

    public void j(final boolean z, boolean z2, final boolean z3) {
        if (com.baidu.adp.lib.util.i.gV()) {
            if (!u.v(this.mList) && this.mList.size() >= 2) {
                final com.baidu.tieba.person.data.c cVar = this.mList.get(z ? 1 : 0);
                if (cVar != null) {
                    if (!cVar.aWT() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.h.2
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.fif.aiQ();
                                h.this.fij.dM(true);
                            }
                        }, 800L);
                    } else if (z && this.bDw != null && this.bDw.aYw() != null && this.bDw.aYw().aYq()) {
                        this.fif.aiQ();
                        ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>();
                        j jVar = new j();
                        jVar.sex = this.mSex;
                        arrayList.add(jVar);
                        this.fif.ao(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.h.3
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.fif.aiQ();
                                h.this.fij.dM(true);
                            }
                        }, 800L);
                    } else {
                        this.fif.km(z2);
                        this.fik.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.h.4
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                h.this.fif.aiQ();
                                if (personPostModel != null) {
                                    com.baidu.adp.lib.util.k.showToast(h.this.aaS.getContext(), personPostModel.getErrorString());
                                } else {
                                    com.baidu.adp.lib.util.k.showToast(h.this.aaS.getContext(), h.this.aaS.getString(d.l.data_load_error));
                                }
                                if (z4) {
                                    h.this.fif.ao(null);
                                    h.this.fij.XC();
                                }
                            }
                        });
                        this.fik.fetchPost(this.bDx.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.h.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                if (personPostModel.getErrorCode() != 0) {
                                    com.baidu.adp.lib.util.k.showToast(h.this.aaS.getContext(), personPostModel.getErrorString());
                                }
                                h.this.fif.aiQ();
                                if (z) {
                                    com.baidu.tieba.person.data.c cVar2 = (com.baidu.tieba.person.data.c) h.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<com.baidu.adp.widget.ListView.f> aWU = ((com.baidu.tieba.person.data.c) h.this.mList.get(1)).aWU();
                                        if (u.v(aWU)) {
                                            h.this.fij.XC();
                                            return;
                                        } else if (u.u(personPostModel.postList) == 0 || (u.u(personPostModel.postList) == 1 && (personPostModel.postList.get(0) instanceof com.baidu.tieba.personPolymeric.c.i))) {
                                            cVar2.ki(false);
                                            h.this.fif.ao(aWU);
                                            h.this.fij.dM(true);
                                            return;
                                        } else if (h.cI(personPostModel.postList) == 0) {
                                            cVar2.ki(false);
                                            h.this.fif.ao(aWU);
                                            h.this.fij.dM(true);
                                            return;
                                        } else {
                                            aWU.addAll(personPostModel.postList);
                                            h.this.fij.wO();
                                            cVar2.an(aWU);
                                            h.this.fif.ao(aWU);
                                            return;
                                        }
                                    }
                                    cVar2.ki(true);
                                    cVar2.an(personPostModel.postList);
                                    cVar2.pX(0);
                                    h.this.fif.ao(personPostModel.postList);
                                    if (!z3 && h.this.bkz) {
                                        h.this.fif.bwy();
                                    }
                                    if (cVar2.aWU() != null && cVar2.aWU().size() == 1 && (cVar2.aWU().get(0) instanceof com.baidu.tieba.personPolymeric.c.i)) {
                                        ((com.baidu.tieba.personPolymeric.c.i) cVar2.aWU().get(0)).bsZ = h.this.bkz;
                                        h.this.fij.XC();
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<com.baidu.adp.widget.ListView.f> aWU2 = ((com.baidu.tieba.person.data.c) h.this.mList.get(0)).aWU();
                                if (!u.v(aWU2)) {
                                    if (u.u(personPostModel.postList) == 0 || (u.u(personPostModel.postList) == 1 && (personPostModel.postList.get(0) instanceof com.baidu.tieba.personPolymeric.c.i))) {
                                        cVar.ki(false);
                                        h.this.fif.ao(aWU2);
                                        h.this.fij.dM(true);
                                        return;
                                    }
                                    aWU2.addAll(personPostModel.threadList);
                                    cVar.ki(true);
                                    cVar.an(aWU2);
                                    h.this.fij.wO();
                                    h.this.fif.cH(aWU2);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z);
                    }
                }
            }
        } else if (!z2) {
            this.fij.wN();
        } else {
            com.baidu.adp.lib.util.k.showToast(this.aaS.getContext(), this.aaS.getString(d.l.data_load_error));
            if (z) {
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                iVar.bsZ = this.bkz;
                arrayList2.add(iVar);
                this.fij.XC();
                this.fif.ao(arrayList2);
            }
        }
    }

    public static int cI(List<com.baidu.adp.widget.ListView.f> list) {
        int i = 0;
        if (u.u(list) == 0) {
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
        if (u.u(arrayList) == 0) {
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
        if (this.bDu != null) {
            this.bDu.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void f(boolean z, boolean z2, boolean z3) {
        j(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void Pm() {
        if (this.bDu != null) {
            this.bDu.Pm();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.fik.resetThreadPn();
        if (this.bDw != null) {
            this.bDw.resetData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public com.baidu.tieba.person.data.c hn(int i) {
        return (com.baidu.tieba.person.data.c) u.c(this.mList, i);
    }

    @Override // com.baidu.tieba.model.a
    public void a(int i, com.baidu.tieba.person.data.c cVar) {
        if (cVar != null) {
            this.mList.set(i, cVar);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.fif.aiQ();
        this.bDx.hideLoadingView(this.mView);
        if (aVar == null) {
            this.fij.L(TbadkCoreApplication.getInst().getString(d.l.neterror), true);
            this.fij.XC();
            this.fij.kr(8);
            return;
        }
        this.fij.Nl();
        aVar.VB();
        if (aVar.aqa() != null) {
            z = aVar.aqa().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.biq = false;
        if (this.bkz) {
            com.baidu.tbadk.getUserInfo.b.Ef().a(aVar.getUserData());
        }
        if (this.fhD != null) {
            this.fhD.a(aVar);
        }
        if (this.fii != null) {
            this.fii.c(aVar);
        }
        com.baidu.tieba.person.data.c cVar = this.mList.get(0);
        cVar.pX(0);
        cVar.an(aVar.aqa());
        cVar.ki(z);
        this.fij.kr(0);
        this.fif.a(aVar, z);
        if ((this.fif.mRootView instanceof RelativeLayout) && !this.bkz) {
            if (this.fih == null) {
                this.fih = new i(this.bDx, (RelativeLayout) this.fif.mRootView, aVar.getUserData());
                this.fih.setOnViewResponseListener(this.fig);
            } else {
                this.fih.setData(aVar.getUserData());
            }
            this.fih.k(true, true, true);
        }
        aYn();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public e VD() {
        return this.fii;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fif != null) {
                this.fif.onChangeSkinType(i);
            }
            if (this.fih != null) {
                this.fih.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.bDs = baseFragment;
    }

    public void aYn() {
        if (!this.biq) {
            if ((this.bDs == null || this.bDs.isPrimary()) && this.fif != null && (this.fif.aYA() instanceof com.baidu.tieba.view.d)) {
                ((com.baidu.tieba.view.d) this.fif.aYA()).aYn();
            }
        }
    }

    public void aYo() {
        if (this.fif != null && (this.fif.aYA() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.fif.aYA()).aYo();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        this.fhD.onDestroy();
        if (this.fih != null) {
            this.fih.onDestroy();
        }
        if (this.fif != null) {
            this.fif.onDestory();
        }
        aYo();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void dz(boolean z) {
        if (z) {
            if (this.biq) {
                Pm();
            }
            if (TbadkCoreApplication.isLogin()) {
                aYn();
                return;
            } else {
                aYo();
                return;
            }
        }
        aYo();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            aYn();
        } else {
            aYo();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void VE() {
        if (this.fif != null) {
            this.fif.VE();
        }
    }
}
