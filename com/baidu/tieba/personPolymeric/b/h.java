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
    private TbPageContext acr;
    private BaseFragment bFm;
    private d bFo;
    private PersonPolymericModel bFq;
    private BaseFragmentActivity bFr;
    private CustomMessageListener bZs;
    private boolean blT;
    private com.baidu.tieba.e.b cmN;
    private f fkM;
    private s fln;
    private com.baidu.tieba.personPolymeric.event.b flo;
    private i flp;
    private e flq;
    private c flr;
    private PersonPostModel fls;
    private List<com.baidu.tieba.person.data.c> mList;
    private long mUserId;
    private View mView;
    private boolean bjC = true;
    private boolean flm = false;
    private int mSex = 1;
    private int mSkinType = 3;
    private final k flt = new k() { // from class: com.baidu.tieba.personPolymeric.b.h.6
        @Override // com.baidu.tieba.view.k
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (h.this.flp != null && h.this.flp.flz != null) {
                h.this.flp.flz.onScrollStateChanged(absListView, i);
            }
            if (i != 0) {
                h.this.aZb();
            }
        }

        @Override // com.baidu.tieba.view.k
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (h.this.flp != null && h.this.flp.flz != null) {
                h.this.flp.flz.onScroll(absListView, i, i2, i3);
            }
        }
    };
    public View.OnTouchListener aMU = new View.OnTouchListener() { // from class: com.baidu.tieba.personPolymeric.b.h.7
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            h.this.cmN.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0080a bWS = new a.InterfaceC0080a() { // from class: com.baidu.tieba.personPolymeric.b.h.8
        @Override // com.baidu.tieba.e.a.InterfaceC0080a
        public void ah(int i, int i2) {
            if (Y(i2) && h.this.flp != null && h.this.flp.flz != null) {
                h.this.flp.flz.eo(false);
                h.this.flp.flz.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0080a
        public void ai(int i, int i2) {
            if (Y(i2) && h.this.flp != null && h.this.flp.flz != null) {
                h.this.flp.flz.eo(true);
                h.this.flp.flz.hideFloatingView();
            }
        }

        private boolean Y(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(BaseFragmentActivity baseFragmentActivity, d dVar, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.bFr = baseFragmentActivity;
        this.acr = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.blT = z;
        this.bFo = dVar;
        this.mView = dVar.mRootView;
        this.fls = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null);
        this.fln = new s(baseFragmentActivity.getPageContext(), dVar, bdUniqueId, z, z2);
        this.fln.P(this.mView);
        this.fln.initUI();
        this.flo = new com.baidu.tieba.personPolymeric.event.b(baseFragmentActivity.getPageContext());
        this.flo.c(this.bFo);
        this.fln.setOnViewResponseListener(this.flo);
        this.fln.a(this);
        resetData();
        this.cmN = new com.baidu.tieba.e.b(baseFragmentActivity.getActivity());
        this.cmN.a(this.bWS);
        this.fln.a(this.flt);
        this.fln.setOnTouchListener(this.aMU);
        this.fkM = this.bFo.aYK();
        this.fln.J(this.fkM);
        this.bFq = this.bFo.aYL();
        this.bFq.d(new o(z));
        this.flr = this.bFo.aYO();
        this.flq = new e(baseFragmentActivity.getPageContext(), this.bFo.aYN(), this.bFo.aYM(), this.fln.afG(), bdUniqueId);
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.c());
        this.mList.add(new com.baidu.tieba.person.data.c());
        this.bZs = new CustomMessageListener(CmdConfigCustom.CMD_HOME_HIDE_GUIDE) { // from class: com.baidu.tieba.personPolymeric.b.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                h.this.aZb();
            }
        };
        this.bZs.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bZs);
    }

    public void k(final boolean z, boolean z2, final boolean z3) {
        if (com.baidu.adp.lib.util.i.hf()) {
            if (!u.v(this.mList) && this.mList.size() >= 2) {
                final com.baidu.tieba.person.data.c cVar = this.mList.get(z ? 1 : 0);
                if (cVar != null) {
                    if (!cVar.aXG() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.h.2
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.fln.ajD();
                                h.this.flr.dN(true);
                            }
                        }, 800L);
                    } else if (z && this.bFq != null && this.bFq.aZj() != null && this.bFq.aZj().aZd()) {
                        this.fln.ajD();
                        ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>();
                        j jVar = new j();
                        jVar.sex = this.mSex;
                        arrayList.add(jVar);
                        this.fln.ao(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.h.3
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.fln.ajD();
                                h.this.flr.dN(true);
                            }
                        }, 800L);
                    } else {
                        this.fln.kp(z2);
                        this.fls.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.h.4
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                h.this.fln.ajD();
                                if (personPostModel != null) {
                                    com.baidu.adp.lib.util.k.showToast(h.this.acr.getContext(), personPostModel.getErrorString());
                                } else {
                                    com.baidu.adp.lib.util.k.showToast(h.this.acr.getContext(), h.this.acr.getString(d.l.data_load_error));
                                }
                                if (z4) {
                                    h.this.fln.ao(null);
                                    h.this.flr.XZ();
                                }
                            }
                        });
                        this.fls.fetchPost(this.bFr.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.h.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                if (personPostModel.getErrorCode() != 0) {
                                    com.baidu.adp.lib.util.k.showToast(h.this.acr.getContext(), personPostModel.getErrorString());
                                }
                                h.this.fln.ajD();
                                if (z) {
                                    com.baidu.tieba.person.data.c cVar2 = (com.baidu.tieba.person.data.c) h.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<com.baidu.adp.widget.ListView.f> aXH = ((com.baidu.tieba.person.data.c) h.this.mList.get(1)).aXH();
                                        if (u.v(aXH)) {
                                            h.this.flr.XZ();
                                            return;
                                        } else if (u.u(personPostModel.postList) == 0 || (u.u(personPostModel.postList) == 1 && (personPostModel.postList.get(0) instanceof com.baidu.tieba.personPolymeric.c.i))) {
                                            cVar2.kl(false);
                                            h.this.fln.ao(aXH);
                                            h.this.flr.dN(true);
                                            return;
                                        } else if (h.cL(personPostModel.postList) == 0) {
                                            cVar2.kl(false);
                                            h.this.fln.ao(aXH);
                                            h.this.flr.dN(true);
                                            return;
                                        } else {
                                            aXH.addAll(personPostModel.postList);
                                            h.this.flr.wY();
                                            cVar2.an(aXH);
                                            h.this.fln.ao(aXH);
                                            return;
                                        }
                                    }
                                    cVar2.kl(true);
                                    cVar2.an(personPostModel.postList);
                                    cVar2.qh(0);
                                    h.this.fln.ao(personPostModel.postList);
                                    if (!z3 && h.this.blT) {
                                        h.this.fln.bxg();
                                    }
                                    if (cVar2.aXH() != null && cVar2.aXH().size() == 1 && (cVar2.aXH().get(0) instanceof com.baidu.tieba.personPolymeric.c.i)) {
                                        ((com.baidu.tieba.personPolymeric.c.i) cVar2.aXH().get(0)).buB = h.this.blT;
                                        h.this.flr.XZ();
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<com.baidu.adp.widget.ListView.f> aXH2 = ((com.baidu.tieba.person.data.c) h.this.mList.get(0)).aXH();
                                if (!u.v(aXH2)) {
                                    if (u.u(personPostModel.postList) == 0 || (u.u(personPostModel.postList) == 1 && (personPostModel.postList.get(0) instanceof com.baidu.tieba.personPolymeric.c.i))) {
                                        cVar.kl(false);
                                        h.this.fln.ao(aXH2);
                                        h.this.flr.dN(true);
                                        return;
                                    }
                                    aXH2.addAll(personPostModel.threadList);
                                    cVar.kl(true);
                                    cVar.an(aXH2);
                                    h.this.flr.wY();
                                    h.this.fln.cK(aXH2);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z);
                    }
                }
            }
        } else if (!z2) {
            this.flr.wX();
        } else {
            com.baidu.adp.lib.util.k.showToast(this.acr.getContext(), this.acr.getString(d.l.data_load_error));
            if (z) {
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                iVar.buB = this.blT;
                arrayList2.add(iVar);
                this.flr.XZ();
                this.fln.ao(arrayList2);
            }
        }
    }

    public static int cL(List<com.baidu.adp.widget.ListView.f> list) {
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
        if (this.bFo != null) {
            this.bFo.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void g(boolean z, boolean z2, boolean z3) {
        k(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void Px() {
        if (this.bFo != null) {
            this.bFo.Px();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.fls.resetThreadPn();
        if (this.bFq != null) {
            this.bFq.resetData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public com.baidu.tieba.person.data.c hp(int i) {
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
        this.fln.ajD();
        this.bFr.hideLoadingView(this.mView);
        if (aVar == null) {
            this.flr.L(TbadkCoreApplication.getInst().getString(d.l.neterror), true);
            this.flr.XZ();
            this.flr.kB(8);
            return;
        }
        this.flr.Nq();
        aVar.VZ();
        if (aVar.aqN() != null) {
            z = aVar.aqN().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.bjC = false;
        if (this.blT) {
            com.baidu.tbadk.getUserInfo.b.En().a(aVar.getUserData());
        }
        if (this.fkM != null) {
            this.fkM.a(aVar);
        }
        if (this.flq != null) {
            this.flq.c(aVar);
        }
        com.baidu.tieba.person.data.c cVar = this.mList.get(0);
        cVar.qh(0);
        cVar.an(aVar.aqN());
        cVar.kl(z);
        this.flr.kB(0);
        this.fln.a(aVar, z);
        if ((this.fln.mRootView instanceof RelativeLayout) && !this.blT) {
            if (this.flp == null) {
                this.flp = new i(this.bFr, (RelativeLayout) this.fln.mRootView, aVar.getUserData());
                this.flp.setOnViewResponseListener(this.flo);
            } else {
                this.flp.setData(aVar.getUserData());
            }
            this.flp.l(true, true, true);
        }
        aZa();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public e Wb() {
        return this.flq;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fln != null) {
                this.fln.onChangeSkinType(i);
            }
            if (this.flp != null) {
                this.flp.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.bFm = baseFragment;
    }

    public void aZa() {
        if (!this.bjC) {
            if ((this.bFm == null || this.bFm.isPrimary()) && this.fln != null && (this.fln.aZn() instanceof com.baidu.tieba.view.d)) {
                ((com.baidu.tieba.view.d) this.fln.aZn()).aZa();
            }
        }
    }

    public void aZb() {
        if (this.fln != null && (this.fln.aZn() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.fln.aZn()).aZb();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        this.fkM.onDestroy();
        if (this.flp != null) {
            this.flp.onDestroy();
        }
        if (this.fln != null) {
            this.fln.onDestory();
        }
        aZb();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void dA(boolean z) {
        if (z) {
            if (this.bjC) {
                Px();
            }
            if (TbadkCoreApplication.isLogin()) {
                aZa();
                return;
            } else {
                aZb();
                return;
            }
        }
        aZb();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            aZa();
        } else {
            aZb();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void Wc() {
        if (this.fln != null) {
            this.fln.Wc();
        }
    }
}
