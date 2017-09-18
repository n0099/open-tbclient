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
import com.baidu.tbadk.core.util.v;
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
    private TbPageContext aby;
    private BaseFragment bIX;
    private d bIZ;
    private PersonPolymericModel bJb;
    private BaseFragmentActivity bJc;
    private boolean bmn;
    private CustomMessageListener cdh;
    private com.baidu.tieba.e.b csZ;
    private f fjY;
    private s fkA;
    private com.baidu.tieba.personPolymeric.event.b fkB;
    private i fkC;
    private e fkD;
    private c fkE;
    private PersonPostModel fkF;
    private List<com.baidu.tieba.person.data.c> mList;
    private long mUserId;
    private View mView;
    private boolean bjR = true;
    private boolean fkz = false;
    private int mSex = 1;
    private int mSkinType = 3;
    private final k fkG = new k() { // from class: com.baidu.tieba.personPolymeric.b.h.6
        @Override // com.baidu.tieba.view.k
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (h.this.fkC != null && h.this.fkC.fkM != null) {
                h.this.fkC.fkM.onScrollStateChanged(absListView, i);
            }
            if (i != 0) {
                h.this.aUI();
            }
        }

        @Override // com.baidu.tieba.view.k
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (h.this.fkC != null && h.this.fkC.fkM != null) {
                h.this.fkC.fkM.onScroll(absListView, i, i2, i3);
            }
        }
    };
    public View.OnTouchListener aMx = new View.OnTouchListener() { // from class: com.baidu.tieba.personPolymeric.b.h.7
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            h.this.csZ.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0081a caG = new a.InterfaceC0081a() { // from class: com.baidu.tieba.personPolymeric.b.h.8
        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ak(int i, int i2) {
            if (N(i2) && h.this.fkC != null && h.this.fkC.fkM != null) {
                h.this.fkC.fkM.es(false);
                h.this.fkC.fkM.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void al(int i, int i2) {
            if (N(i2) && h.this.fkC != null && h.this.fkC.fkM != null) {
                h.this.fkC.fkM.es(true);
                h.this.fkC.fkM.hideFloatingView();
            }
        }

        private boolean N(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(BaseFragmentActivity baseFragmentActivity, d dVar, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.bJc = baseFragmentActivity;
        this.aby = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.bmn = z;
        this.bIZ = dVar;
        this.mView = dVar.mRootView;
        this.fkF = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null);
        this.fkA = new s(baseFragmentActivity.getPageContext(), dVar, bdUniqueId, z, z2);
        this.fkA.X(this.mView);
        this.fkA.initUI();
        this.fkB = new com.baidu.tieba.personPolymeric.event.b(baseFragmentActivity.getPageContext());
        this.fkB.c(this.bIZ);
        this.fkA.setOnViewResponseListener(this.fkB);
        this.fkA.a(this);
        resetData();
        this.csZ = new com.baidu.tieba.e.b(baseFragmentActivity.getActivity());
        this.csZ.a(this.caG);
        this.fkA.a(this.fkG);
        this.fkA.setOnTouchListener(this.aMx);
        this.fjY = this.bIZ.aYh();
        this.fkA.H(this.fjY);
        this.bJb = this.bIZ.aYi();
        this.bJb.d(new o(z));
        this.fkE = this.bIZ.aYl();
        this.fkD = new e(baseFragmentActivity.getPageContext(), this.bIZ.aYk(), this.bIZ.aYj(), this.fkA.ahp(), bdUniqueId);
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.c());
        this.mList.add(new com.baidu.tieba.person.data.c());
        this.cdh = new CustomMessageListener(CmdConfigCustom.CMD_HOME_HIDE_GUIDE) { // from class: com.baidu.tieba.personPolymeric.b.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                h.this.aUI();
            }
        };
        this.cdh.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cdh);
    }

    public void k(final boolean z, boolean z2, final boolean z3) {
        if (com.baidu.adp.lib.util.i.gW()) {
            if (!v.v(this.mList) && this.mList.size() >= 2) {
                final com.baidu.tieba.person.data.c cVar = this.mList.get(z ? 1 : 0);
                if (cVar != null) {
                    if (!cVar.aXd() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.h.2
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.fkA.aly();
                                h.this.fkE.dR(true);
                            }
                        }, 800L);
                    } else if (z && this.bJb != null && this.bJb.aYG() != null && this.bJb.aYG().aYz()) {
                        this.fkA.aly();
                        ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>();
                        j jVar = new j();
                        jVar.sex = this.mSex;
                        arrayList.add(jVar);
                        this.fkA.an(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.h.3
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.fkA.aly();
                                h.this.fkE.dR(true);
                            }
                        }, 800L);
                    } else {
                        this.fkA.kr(z2);
                        this.fkF.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.h.4
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                h.this.fkA.aly();
                                if (personPostModel != null) {
                                    com.baidu.adp.lib.util.k.showToast(h.this.aby.getContext(), personPostModel.getErrorString());
                                } else {
                                    com.baidu.adp.lib.util.k.showToast(h.this.aby.getContext(), h.this.aby.getString(d.l.data_load_error));
                                }
                                if (z4) {
                                    h.this.fkA.an(null);
                                    h.this.fkE.Zn();
                                }
                            }
                        });
                        this.fkF.fetchPost(this.bJc.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.h.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                if (personPostModel.getErrorCode() != 0) {
                                    com.baidu.adp.lib.util.k.showToast(h.this.aby.getContext(), personPostModel.getErrorString());
                                }
                                h.this.fkA.aly();
                                if (z) {
                                    com.baidu.tieba.person.data.c cVar2 = (com.baidu.tieba.person.data.c) h.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<com.baidu.adp.widget.ListView.f> aXe = ((com.baidu.tieba.person.data.c) h.this.mList.get(1)).aXe();
                                        if (v.v(aXe)) {
                                            h.this.fkE.Zn();
                                            return;
                                        } else if (v.u(personPostModel.postList) == 0 || (v.u(personPostModel.postList) == 1 && (personPostModel.postList.get(0) instanceof com.baidu.tieba.personPolymeric.c.i))) {
                                            cVar2.kn(false);
                                            h.this.fkA.an(aXe);
                                            h.this.fkE.dR(true);
                                            return;
                                        } else if (h.cJ(personPostModel.postList) == 0) {
                                            cVar2.kn(false);
                                            h.this.fkA.an(aXe);
                                            h.this.fkE.dR(true);
                                            return;
                                        } else {
                                            aXe.addAll(personPostModel.postList);
                                            h.this.fkE.wW();
                                            cVar2.am(aXe);
                                            h.this.fkA.an(aXe);
                                            return;
                                        }
                                    }
                                    cVar2.kn(true);
                                    cVar2.am(personPostModel.postList);
                                    cVar2.qj(0);
                                    h.this.fkA.an(personPostModel.postList);
                                    if (!z3 && h.this.bmn) {
                                        h.this.fkA.bwH();
                                    }
                                    if (cVar2.aXe() != null && cVar2.aXe().size() == 1 && (cVar2.aXe().get(0) instanceof com.baidu.tieba.personPolymeric.c.i)) {
                                        ((com.baidu.tieba.personPolymeric.c.i) cVar2.aXe().get(0)).bwa = h.this.bmn;
                                        h.this.fkE.Zn();
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<com.baidu.adp.widget.ListView.f> aXe2 = ((com.baidu.tieba.person.data.c) h.this.mList.get(0)).aXe();
                                if (!v.v(aXe2)) {
                                    if (v.u(personPostModel.postList) == 0 || (v.u(personPostModel.postList) == 1 && (personPostModel.postList.get(0) instanceof com.baidu.tieba.personPolymeric.c.i))) {
                                        cVar.kn(false);
                                        h.this.fkA.an(aXe2);
                                        h.this.fkE.dR(true);
                                        return;
                                    }
                                    aXe2.addAll(personPostModel.threadList);
                                    cVar.kn(true);
                                    cVar.am(aXe2);
                                    h.this.fkE.wW();
                                    h.this.fkA.cI(aXe2);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z);
                    }
                }
            }
        } else if (!z2) {
            this.fkE.wV();
        } else {
            com.baidu.adp.lib.util.k.showToast(this.aby.getContext(), this.aby.getString(d.l.data_load_error));
            if (z) {
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                iVar.bwa = this.bmn;
                arrayList2.add(iVar);
                this.fkE.Zn();
                this.fkA.an(arrayList2);
            }
        }
    }

    public static int cJ(List<com.baidu.adp.widget.ListView.f> list) {
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
        if (this.bIZ != null) {
            this.bIZ.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void g(boolean z, boolean z2, boolean z3) {
        k(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void PP() {
        if (this.bIZ != null) {
            this.bIZ.PP();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.fkF.resetThreadPn();
        if (this.bJb != null) {
            this.bJb.resetData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public com.baidu.tieba.person.data.c hC(int i) {
        return (com.baidu.tieba.person.data.c) v.c(this.mList, i);
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
        this.fkA.aly();
        this.bJc.hideLoadingView(this.mView);
        if (aVar == null) {
            this.fkE.M(TbadkCoreApplication.getInst().getString(d.l.neterror), true);
            this.fkE.Zn();
            this.fkE.kR(8);
            return;
        }
        this.fkE.NH();
        aVar.Xn();
        if (aVar.asI() != null) {
            z = aVar.asI().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.bjR = false;
        if (this.bmn) {
            com.baidu.tbadk.getUserInfo.b.Ek().a(aVar.getUserData());
        }
        if (this.fjY != null) {
            this.fjY.a(aVar);
        }
        if (this.fkD != null) {
            this.fkD.c(aVar);
        }
        com.baidu.tieba.person.data.c cVar = this.mList.get(0);
        cVar.qj(0);
        cVar.am(aVar.asI());
        cVar.kn(z);
        this.fkE.kR(0);
        this.fkA.a(aVar, z);
        if ((this.fkA.mRootView instanceof RelativeLayout) && !this.bmn) {
            if (this.fkC == null) {
                this.fkC = new i(this.bJc, (RelativeLayout) this.fkA.mRootView, aVar.getUserData());
                this.fkC.setOnViewResponseListener(this.fkB);
            } else {
                this.fkC.setData(aVar.getUserData());
            }
            this.fkC.l(true, true, true);
        }
        aYx();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public e Xp() {
        return this.fkD;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fkA != null) {
                this.fkA.onChangeSkinType(i);
            }
            if (this.fkC != null) {
                this.fkC.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.bIX = baseFragment;
    }

    public void aYx() {
        if (!this.bjR) {
            if ((this.bIX == null || this.bIX.isPrimary()) && this.fkA != null && (this.fkA.aYK() instanceof com.baidu.tieba.view.d)) {
                ((com.baidu.tieba.view.d) this.fkA.aYK()).aYx();
            }
        }
    }

    public void aUI() {
        if (this.fkA != null && (this.fkA.aYK() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.fkA.aYK()).aUI();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        this.fjY.onDestroy();
        if (this.fkC != null) {
            this.fkC.onDestroy();
        }
        if (this.fkA != null) {
            this.fkA.onDestory();
        }
        aUI();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void dE(boolean z) {
        if (z) {
            if (this.bjR) {
                PP();
            }
            if (TbadkCoreApplication.isLogin()) {
                aYx();
                return;
            } else {
                aUI();
                return;
            }
        }
        aUI();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            aYx();
        } else {
            aUI();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void Xq() {
        if (this.fkA != null) {
            this.fkA.Xq();
        }
    }
}
