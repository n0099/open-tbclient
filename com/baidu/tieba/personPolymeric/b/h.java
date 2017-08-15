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
    private BaseFragment bFl;
    private d bFn;
    private PersonPolymericModel bFp;
    private BaseFragmentActivity bFq;
    private CustomMessageListener bZr;
    private boolean blR;
    private com.baidu.tieba.e.b cmM;
    private f fkK;
    private s fll;
    private com.baidu.tieba.personPolymeric.event.b flm;
    private i fln;
    private e flo;
    private c flp;
    private PersonPostModel flq;
    private List<com.baidu.tieba.person.data.c> mList;
    private long mUserId;
    private View mView;
    private boolean bjB = true;
    private boolean flk = false;
    private int mSex = 1;
    private int mSkinType = 3;
    private final k flr = new k() { // from class: com.baidu.tieba.personPolymeric.b.h.6
        @Override // com.baidu.tieba.view.k
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (h.this.fln != null && h.this.fln.flx != null) {
                h.this.fln.flx.onScrollStateChanged(absListView, i);
            }
            if (i != 0) {
                h.this.aZg();
            }
        }

        @Override // com.baidu.tieba.view.k
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (h.this.fln != null && h.this.fln.flx != null) {
                h.this.fln.flx.onScroll(absListView, i, i2, i3);
            }
        }
    };
    public View.OnTouchListener aMT = new View.OnTouchListener() { // from class: com.baidu.tieba.personPolymeric.b.h.7
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            h.this.cmM.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0080a bWR = new a.InterfaceC0080a() { // from class: com.baidu.tieba.personPolymeric.b.h.8
        @Override // com.baidu.tieba.e.a.InterfaceC0080a
        public void ah(int i, int i2) {
            if (Y(i2) && h.this.fln != null && h.this.fln.flx != null) {
                h.this.fln.flx.eo(false);
                h.this.fln.flx.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0080a
        public void ai(int i, int i2) {
            if (Y(i2) && h.this.fln != null && h.this.fln.flx != null) {
                h.this.fln.flx.eo(true);
                h.this.fln.flx.hideFloatingView();
            }
        }

        private boolean Y(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(BaseFragmentActivity baseFragmentActivity, d dVar, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.bFq = baseFragmentActivity;
        this.acr = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.blR = z;
        this.bFn = dVar;
        this.mView = dVar.mRootView;
        this.flq = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null);
        this.fll = new s(baseFragmentActivity.getPageContext(), dVar, bdUniqueId, z, z2);
        this.fll.P(this.mView);
        this.fll.initUI();
        this.flm = new com.baidu.tieba.personPolymeric.event.b(baseFragmentActivity.getPageContext());
        this.flm.c(this.bFn);
        this.fll.setOnViewResponseListener(this.flm);
        this.fll.a(this);
        resetData();
        this.cmM = new com.baidu.tieba.e.b(baseFragmentActivity.getActivity());
        this.cmM.a(this.bWR);
        this.fll.a(this.flr);
        this.fll.setOnTouchListener(this.aMT);
        this.fkK = this.bFn.aYP();
        this.fll.N(this.fkK);
        this.bFp = this.bFn.aYQ();
        this.bFp.d(new o(z));
        this.flp = this.bFn.aYT();
        this.flo = new e(baseFragmentActivity.getPageContext(), this.bFn.aYS(), this.bFn.aYR(), this.fll.afM(), bdUniqueId);
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.c());
        this.mList.add(new com.baidu.tieba.person.data.c());
        this.bZr = new CustomMessageListener(CmdConfigCustom.CMD_HOME_HIDE_GUIDE) { // from class: com.baidu.tieba.personPolymeric.b.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                h.this.aZg();
            }
        };
        this.bZr.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bZr);
    }

    public void k(final boolean z, boolean z2, final boolean z3) {
        if (com.baidu.adp.lib.util.i.hf()) {
            if (!u.v(this.mList) && this.mList.size() >= 2) {
                final com.baidu.tieba.person.data.c cVar = this.mList.get(z ? 1 : 0);
                if (cVar != null) {
                    if (!cVar.aXL() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.h.2
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.fll.ajJ();
                                h.this.flp.dN(true);
                            }
                        }, 800L);
                    } else if (z && this.bFp != null && this.bFp.aZo() != null && this.bFp.aZo().aZi()) {
                        this.fll.ajJ();
                        ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>();
                        j jVar = new j();
                        jVar.sex = this.mSex;
                        arrayList.add(jVar);
                        this.fll.ao(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.h.3
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.fll.ajJ();
                                h.this.flp.dN(true);
                            }
                        }, 800L);
                    } else {
                        this.fll.kp(z2);
                        this.flq.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.h.4
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                h.this.fll.ajJ();
                                if (personPostModel != null) {
                                    com.baidu.adp.lib.util.k.showToast(h.this.acr.getContext(), personPostModel.getErrorString());
                                } else {
                                    com.baidu.adp.lib.util.k.showToast(h.this.acr.getContext(), h.this.acr.getString(d.l.data_load_error));
                                }
                                if (z4) {
                                    h.this.fll.ao(null);
                                    h.this.flp.Yc();
                                }
                            }
                        });
                        this.flq.fetchPost(this.bFq.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.h.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                if (personPostModel.getErrorCode() != 0) {
                                    com.baidu.adp.lib.util.k.showToast(h.this.acr.getContext(), personPostModel.getErrorString());
                                }
                                h.this.fll.ajJ();
                                if (z) {
                                    com.baidu.tieba.person.data.c cVar2 = (com.baidu.tieba.person.data.c) h.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<com.baidu.adp.widget.ListView.f> aXM = ((com.baidu.tieba.person.data.c) h.this.mList.get(1)).aXM();
                                        if (u.v(aXM)) {
                                            h.this.flp.Yc();
                                            return;
                                        } else if (u.u(personPostModel.postList) == 0 || (u.u(personPostModel.postList) == 1 && (personPostModel.postList.get(0) instanceof com.baidu.tieba.personPolymeric.c.i))) {
                                            cVar2.kl(false);
                                            h.this.fll.ao(aXM);
                                            h.this.flp.dN(true);
                                            return;
                                        } else if (h.cL(personPostModel.postList) == 0) {
                                            cVar2.kl(false);
                                            h.this.fll.ao(aXM);
                                            h.this.flp.dN(true);
                                            return;
                                        } else {
                                            aXM.addAll(personPostModel.postList);
                                            h.this.flp.wX();
                                            cVar2.an(aXM);
                                            h.this.fll.ao(aXM);
                                            return;
                                        }
                                    }
                                    cVar2.kl(true);
                                    cVar2.an(personPostModel.postList);
                                    cVar2.qh(0);
                                    h.this.fll.ao(personPostModel.postList);
                                    if (!z3 && h.this.blR) {
                                        h.this.fll.bxn();
                                    }
                                    if (cVar2.aXM() != null && cVar2.aXM().size() == 1 && (cVar2.aXM().get(0) instanceof com.baidu.tieba.personPolymeric.c.i)) {
                                        ((com.baidu.tieba.personPolymeric.c.i) cVar2.aXM().get(0)).buA = h.this.blR;
                                        h.this.flp.Yc();
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<com.baidu.adp.widget.ListView.f> aXM2 = ((com.baidu.tieba.person.data.c) h.this.mList.get(0)).aXM();
                                if (!u.v(aXM2)) {
                                    if (u.u(personPostModel.postList) == 0 || (u.u(personPostModel.postList) == 1 && (personPostModel.postList.get(0) instanceof com.baidu.tieba.personPolymeric.c.i))) {
                                        cVar.kl(false);
                                        h.this.fll.ao(aXM2);
                                        h.this.flp.dN(true);
                                        return;
                                    }
                                    aXM2.addAll(personPostModel.threadList);
                                    cVar.kl(true);
                                    cVar.an(aXM2);
                                    h.this.flp.wX();
                                    h.this.fll.cK(aXM2);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z);
                    }
                }
            }
        } else if (!z2) {
            this.flp.wW();
        } else {
            com.baidu.adp.lib.util.k.showToast(this.acr.getContext(), this.acr.getString(d.l.data_load_error));
            if (z) {
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                iVar.buA = this.blR;
                arrayList2.add(iVar);
                this.flp.Yc();
                this.fll.ao(arrayList2);
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
        if (this.bFn != null) {
            this.bFn.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void g(boolean z, boolean z2, boolean z3) {
        k(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void Py() {
        if (this.bFn != null) {
            this.bFn.Py();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.flq.resetThreadPn();
        if (this.bFp != null) {
            this.bFp.resetData();
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
        this.fll.ajJ();
        this.bFq.hideLoadingView(this.mView);
        if (aVar == null) {
            this.flp.L(TbadkCoreApplication.getInst().getString(d.l.neterror), true);
            this.flp.Yc();
            this.flp.kB(8);
            return;
        }
        this.flp.Nq();
        aVar.Wc();
        if (aVar.aqT() != null) {
            z = aVar.aqT().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.bjB = false;
        if (this.blR) {
            com.baidu.tbadk.getUserInfo.b.En().a(aVar.getUserData());
        }
        if (this.fkK != null) {
            this.fkK.a(aVar);
        }
        if (this.flo != null) {
            this.flo.c(aVar);
        }
        com.baidu.tieba.person.data.c cVar = this.mList.get(0);
        cVar.qh(0);
        cVar.an(aVar.aqT());
        cVar.kl(z);
        this.flp.kB(0);
        this.fll.a(aVar, z);
        if ((this.fll.mRootView instanceof RelativeLayout) && !this.blR) {
            if (this.fln == null) {
                this.fln = new i(this.bFq, (RelativeLayout) this.fll.mRootView, aVar.getUserData());
                this.fln.setOnViewResponseListener(this.flm);
            } else {
                this.fln.setData(aVar.getUserData());
            }
            this.fln.l(true, true, true);
        }
        aZf();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public e We() {
        return this.flo;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fll != null) {
                this.fll.onChangeSkinType(i);
            }
            if (this.fln != null) {
                this.fln.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.bFl = baseFragment;
    }

    public void aZf() {
        if (!this.bjB) {
            if ((this.bFl == null || this.bFl.isPrimary()) && this.fll != null && (this.fll.aZs() instanceof com.baidu.tieba.view.d)) {
                ((com.baidu.tieba.view.d) this.fll.aZs()).aZf();
            }
        }
    }

    public void aZg() {
        if (this.fll != null && (this.fll.aZs() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.fll.aZs()).aZg();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        this.fkK.onDestroy();
        if (this.fln != null) {
            this.fln.onDestroy();
        }
        if (this.fll != null) {
            this.fll.onDestory();
        }
        aZg();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void dA(boolean z) {
        if (z) {
            if (this.bjB) {
                Py();
            }
            if (TbadkCoreApplication.isLogin()) {
                aZf();
                return;
            } else {
                aZg();
                return;
            }
        }
        aZg();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            aZf();
        } else {
            aZg();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void Wf() {
        if (this.fll != null) {
            this.fll.Wf();
        }
    }
}
