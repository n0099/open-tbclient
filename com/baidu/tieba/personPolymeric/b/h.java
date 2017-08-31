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
    private BaseFragment bIg;
    private d bIi;
    private PersonPolymericModel bIk;
    private BaseFragmentActivity bIl;
    private boolean bmo;
    private CustomMessageListener ccp;
    private com.baidu.tieba.e.b csh;
    private s fjH;
    private com.baidu.tieba.personPolymeric.event.b fjI;
    private i fjJ;
    private e fjK;
    private c fjL;
    private PersonPostModel fjM;
    private f fjf;
    private List<com.baidu.tieba.person.data.c> mList;
    private long mUserId;
    private View mView;
    private boolean bjS = true;
    private boolean fjG = false;
    private int mSex = 1;
    private int mSkinType = 3;
    private final k fjN = new k() { // from class: com.baidu.tieba.personPolymeric.b.h.6
        @Override // com.baidu.tieba.view.k
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (h.this.fjJ != null && h.this.fjJ.fjT != null) {
                h.this.fjJ.fjT.onScrollStateChanged(absListView, i);
            }
            if (i != 0) {
                h.this.aUx();
            }
        }

        @Override // com.baidu.tieba.view.k
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (h.this.fjJ != null && h.this.fjJ.fjT != null) {
                h.this.fjJ.fjT.onScroll(absListView, i, i2, i3);
            }
        }
    };
    public View.OnTouchListener aMA = new View.OnTouchListener() { // from class: com.baidu.tieba.personPolymeric.b.h.7
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            h.this.csh.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0082a bZO = new a.InterfaceC0082a() { // from class: com.baidu.tieba.personPolymeric.b.h.8
        @Override // com.baidu.tieba.e.a.InterfaceC0082a
        public void ag(int i, int i2) {
            if (N(i2) && h.this.fjJ != null && h.this.fjJ.fjT != null) {
                h.this.fjJ.fjT.er(false);
                h.this.fjJ.fjT.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0082a
        public void ah(int i, int i2) {
            if (N(i2) && h.this.fjJ != null && h.this.fjJ.fjT != null) {
                h.this.fjJ.fjT.er(true);
                h.this.fjJ.fjT.hideFloatingView();
            }
        }

        private boolean N(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(BaseFragmentActivity baseFragmentActivity, d dVar, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.bIl = baseFragmentActivity;
        this.aby = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.bmo = z;
        this.bIi = dVar;
        this.mView = dVar.mRootView;
        this.fjM = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null);
        this.fjH = new s(baseFragmentActivity.getPageContext(), dVar, bdUniqueId, z, z2);
        this.fjH.X(this.mView);
        this.fjH.initUI();
        this.fjI = new com.baidu.tieba.personPolymeric.event.b(baseFragmentActivity.getPageContext());
        this.fjI.c(this.bIi);
        this.fjH.setOnViewResponseListener(this.fjI);
        this.fjH.a(this);
        resetData();
        this.csh = new com.baidu.tieba.e.b(baseFragmentActivity.getActivity());
        this.csh.a(this.bZO);
        this.fjH.a(this.fjN);
        this.fjH.setOnTouchListener(this.aMA);
        this.fjf = this.bIi.aXW();
        this.fjH.H(this.fjf);
        this.bIk = this.bIi.aXX();
        this.bIk.d(new o(z));
        this.fjL = this.bIi.aYa();
        this.fjK = new e(baseFragmentActivity.getPageContext(), this.bIi.aXZ(), this.bIi.aXY(), this.fjH.ahe(), bdUniqueId);
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.c());
        this.mList.add(new com.baidu.tieba.person.data.c());
        this.ccp = new CustomMessageListener(CmdConfigCustom.CMD_HOME_HIDE_GUIDE) { // from class: com.baidu.tieba.personPolymeric.b.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                h.this.aUx();
            }
        };
        this.ccp.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ccp);
    }

    public void k(final boolean z, boolean z2, final boolean z3) {
        if (com.baidu.adp.lib.util.i.gW()) {
            if (!v.v(this.mList) && this.mList.size() >= 2) {
                final com.baidu.tieba.person.data.c cVar = this.mList.get(z ? 1 : 0);
                if (cVar != null) {
                    if (!cVar.aWS() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.h.2
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.fjH.aln();
                                h.this.fjL.dQ(true);
                            }
                        }, 800L);
                    } else if (z && this.bIk != null && this.bIk.aYv() != null && this.bIk.aYv().aYo()) {
                        this.fjH.aln();
                        ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>();
                        j jVar = new j();
                        jVar.sex = this.mSex;
                        arrayList.add(jVar);
                        this.fjH.an(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.h.3
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.fjH.aln();
                                h.this.fjL.dQ(true);
                            }
                        }, 800L);
                    } else {
                        this.fjH.kq(z2);
                        this.fjM.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.h.4
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                h.this.fjH.aln();
                                if (personPostModel != null) {
                                    com.baidu.adp.lib.util.k.showToast(h.this.aby.getContext(), personPostModel.getErrorString());
                                } else {
                                    com.baidu.adp.lib.util.k.showToast(h.this.aby.getContext(), h.this.aby.getString(d.l.data_load_error));
                                }
                                if (z4) {
                                    h.this.fjH.an(null);
                                    h.this.fjL.Zc();
                                }
                            }
                        });
                        this.fjM.fetchPost(this.bIl.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.h.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                if (personPostModel.getErrorCode() != 0) {
                                    com.baidu.adp.lib.util.k.showToast(h.this.aby.getContext(), personPostModel.getErrorString());
                                }
                                h.this.fjH.aln();
                                if (z) {
                                    com.baidu.tieba.person.data.c cVar2 = (com.baidu.tieba.person.data.c) h.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<com.baidu.adp.widget.ListView.f> aWT = ((com.baidu.tieba.person.data.c) h.this.mList.get(1)).aWT();
                                        if (v.v(aWT)) {
                                            h.this.fjL.Zc();
                                            return;
                                        } else if (v.u(personPostModel.postList) == 0 || (v.u(personPostModel.postList) == 1 && (personPostModel.postList.get(0) instanceof com.baidu.tieba.personPolymeric.c.i))) {
                                            cVar2.km(false);
                                            h.this.fjH.an(aWT);
                                            h.this.fjL.dQ(true);
                                            return;
                                        } else if (h.cI(personPostModel.postList) == 0) {
                                            cVar2.km(false);
                                            h.this.fjH.an(aWT);
                                            h.this.fjL.dQ(true);
                                            return;
                                        } else {
                                            aWT.addAll(personPostModel.postList);
                                            h.this.fjL.wW();
                                            cVar2.am(aWT);
                                            h.this.fjH.an(aWT);
                                            return;
                                        }
                                    }
                                    cVar2.km(true);
                                    cVar2.am(personPostModel.postList);
                                    cVar2.qh(0);
                                    h.this.fjH.an(personPostModel.postList);
                                    if (!z3 && h.this.bmo) {
                                        h.this.fjH.bww();
                                    }
                                    if (cVar2.aWT() != null && cVar2.aWT().size() == 1 && (cVar2.aWT().get(0) instanceof com.baidu.tieba.personPolymeric.c.i)) {
                                        ((com.baidu.tieba.personPolymeric.c.i) cVar2.aWT().get(0)).bvm = h.this.bmo;
                                        h.this.fjL.Zc();
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<com.baidu.adp.widget.ListView.f> aWT2 = ((com.baidu.tieba.person.data.c) h.this.mList.get(0)).aWT();
                                if (!v.v(aWT2)) {
                                    if (v.u(personPostModel.postList) == 0 || (v.u(personPostModel.postList) == 1 && (personPostModel.postList.get(0) instanceof com.baidu.tieba.personPolymeric.c.i))) {
                                        cVar.km(false);
                                        h.this.fjH.an(aWT2);
                                        h.this.fjL.dQ(true);
                                        return;
                                    }
                                    aWT2.addAll(personPostModel.threadList);
                                    cVar.km(true);
                                    cVar.am(aWT2);
                                    h.this.fjL.wW();
                                    h.this.fjH.cH(aWT2);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z);
                    }
                }
            }
        } else if (!z2) {
            this.fjL.wV();
        } else {
            com.baidu.adp.lib.util.k.showToast(this.aby.getContext(), this.aby.getString(d.l.data_load_error));
            if (z) {
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                iVar.bvm = this.bmo;
                arrayList2.add(iVar);
                this.fjL.Zc();
                this.fjH.an(arrayList2);
            }
        }
    }

    public static int cI(List<com.baidu.adp.widget.ListView.f> list) {
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
        if (this.bIi != null) {
            this.bIi.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void g(boolean z, boolean z2, boolean z3) {
        k(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void PN() {
        if (this.bIi != null) {
            this.bIi.PN();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.fjM.resetThreadPn();
        if (this.bIk != null) {
            this.bIk.resetData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public com.baidu.tieba.person.data.c hA(int i) {
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
        this.fjH.aln();
        this.bIl.hideLoadingView(this.mView);
        if (aVar == null) {
            this.fjL.M(TbadkCoreApplication.getInst().getString(d.l.neterror), true);
            this.fjL.Zc();
            this.fjL.kP(8);
            return;
        }
        this.fjL.NG();
        aVar.Xc();
        if (aVar.asx() != null) {
            z = aVar.asx().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.bjS = false;
        if (this.bmo) {
            com.baidu.tbadk.getUserInfo.b.Ek().a(aVar.getUserData());
        }
        if (this.fjf != null) {
            this.fjf.a(aVar);
        }
        if (this.fjK != null) {
            this.fjK.c(aVar);
        }
        com.baidu.tieba.person.data.c cVar = this.mList.get(0);
        cVar.qh(0);
        cVar.am(aVar.asx());
        cVar.km(z);
        this.fjL.kP(0);
        this.fjH.a(aVar, z);
        if ((this.fjH.mRootView instanceof RelativeLayout) && !this.bmo) {
            if (this.fjJ == null) {
                this.fjJ = new i(this.bIl, (RelativeLayout) this.fjH.mRootView, aVar.getUserData());
                this.fjJ.setOnViewResponseListener(this.fjI);
            } else {
                this.fjJ.setData(aVar.getUserData());
            }
            this.fjJ.l(true, true, true);
        }
        aYm();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public e Xe() {
        return this.fjK;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fjH != null) {
                this.fjH.onChangeSkinType(i);
            }
            if (this.fjJ != null) {
                this.fjJ.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.bIg = baseFragment;
    }

    public void aYm() {
        if (!this.bjS) {
            if ((this.bIg == null || this.bIg.isPrimary()) && this.fjH != null && (this.fjH.aYz() instanceof com.baidu.tieba.view.d)) {
                ((com.baidu.tieba.view.d) this.fjH.aYz()).aYm();
            }
        }
    }

    public void aUx() {
        if (this.fjH != null && (this.fjH.aYz() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.fjH.aYz()).aUx();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        this.fjf.onDestroy();
        if (this.fjJ != null) {
            this.fjJ.onDestroy();
        }
        if (this.fjH != null) {
            this.fjH.onDestory();
        }
        aUx();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void dD(boolean z) {
        if (z) {
            if (this.bjS) {
                PN();
            }
            if (TbadkCoreApplication.isLogin()) {
                aYm();
                return;
            } else {
                aUx();
                return;
            }
        }
        aUx();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            aYm();
        } else {
            aUx();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void Xf() {
        if (this.fjH != null) {
            this.fjH.Xf();
        }
    }
}
