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
    private TbPageContext acp;
    private BaseFragment bEC;
    private d bEE;
    private PersonPolymericModel bEG;
    private BaseFragmentActivity bEH;
    private CustomMessageListener bYF;
    private boolean blJ;
    private com.baidu.tieba.e.b cma;
    private f fiR;
    private s fjs;
    private com.baidu.tieba.personPolymeric.event.b fjt;
    private i fju;
    private e fjv;
    private c fjw;
    private PersonPostModel fjx;
    private List<com.baidu.tieba.person.data.c> mList;
    private long mUserId;
    private View mView;
    private boolean bjA = true;
    private boolean fjr = false;
    private int mSex = 1;
    private int mSkinType = 3;
    private final k fjy = new k() { // from class: com.baidu.tieba.personPolymeric.b.h.6
        @Override // com.baidu.tieba.view.k
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (h.this.fju != null && h.this.fju.fjE != null) {
                h.this.fju.fjE.onScrollStateChanged(absListView, i);
            }
            if (i != 0) {
                h.this.aYz();
            }
        }

        @Override // com.baidu.tieba.view.k
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (h.this.fju != null && h.this.fju.fjE != null) {
                h.this.fju.fjE.onScroll(absListView, i, i2, i3);
            }
        }
    };
    public View.OnTouchListener aMS = new View.OnTouchListener() { // from class: com.baidu.tieba.personPolymeric.b.h.7
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            h.this.cma.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0079a bWf = new a.InterfaceC0079a() { // from class: com.baidu.tieba.personPolymeric.b.h.8
        @Override // com.baidu.tieba.e.a.InterfaceC0079a
        public void ah(int i, int i2) {
            if (Y(i2) && h.this.fju != null && h.this.fju.fjE != null) {
                h.this.fju.fjE.en(false);
                h.this.fju.fjE.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0079a
        public void ai(int i, int i2) {
            if (Y(i2) && h.this.fju != null && h.this.fju.fjE != null) {
                h.this.fju.fjE.en(true);
                h.this.fju.fjE.hideFloatingView();
            }
        }

        private boolean Y(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(BaseFragmentActivity baseFragmentActivity, d dVar, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.bEH = baseFragmentActivity;
        this.acp = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.blJ = z;
        this.bEE = dVar;
        this.mView = dVar.mRootView;
        this.fjx = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null);
        this.fjs = new s(baseFragmentActivity.getPageContext(), dVar, bdUniqueId, z, z2);
        this.fjs.O(this.mView);
        this.fjs.initUI();
        this.fjt = new com.baidu.tieba.personPolymeric.event.b(baseFragmentActivity.getPageContext());
        this.fjt.c(this.bEE);
        this.fjs.setOnViewResponseListener(this.fjt);
        this.fjs.a(this);
        resetData();
        this.cma = new com.baidu.tieba.e.b(baseFragmentActivity.getActivity());
        this.cma.a(this.bWf);
        this.fjs.a(this.fjy);
        this.fjs.setOnTouchListener(this.aMS);
        this.fiR = this.bEE.aYi();
        this.fjs.N(this.fiR);
        this.bEG = this.bEE.aYj();
        this.bEG.d(new o(z));
        this.fjw = this.bEE.aYm();
        this.fjv = new e(baseFragmentActivity.getPageContext(), this.bEE.aYl(), this.bEE.aYk(), this.fjs.afq(), bdUniqueId);
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.c());
        this.mList.add(new com.baidu.tieba.person.data.c());
        this.bYF = new CustomMessageListener(CmdConfigCustom.CMD_HOME_HIDE_GUIDE) { // from class: com.baidu.tieba.personPolymeric.b.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                h.this.aYz();
            }
        };
        this.bYF.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bYF);
    }

    public void j(final boolean z, boolean z2, final boolean z3) {
        if (com.baidu.adp.lib.util.i.hf()) {
            if (!u.v(this.mList) && this.mList.size() >= 2) {
                final com.baidu.tieba.person.data.c cVar = this.mList.get(z ? 1 : 0);
                if (cVar != null) {
                    if (!cVar.aXe() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.h.2
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.fjs.ajc();
                                h.this.fjw.dM(true);
                            }
                        }, 800L);
                    } else if (z && this.bEG != null && this.bEG.aYH() != null && this.bEG.aYH().aYB()) {
                        this.fjs.ajc();
                        ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>();
                        j jVar = new j();
                        jVar.sex = this.mSex;
                        arrayList.add(jVar);
                        this.fjs.ao(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.h.3
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.fjs.ajc();
                                h.this.fjw.dM(true);
                            }
                        }, 800L);
                    } else {
                        this.fjs.km(z2);
                        this.fjx.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.h.4
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                h.this.fjs.ajc();
                                if (personPostModel != null) {
                                    com.baidu.adp.lib.util.k.showToast(h.this.acp.getContext(), personPostModel.getErrorString());
                                } else {
                                    com.baidu.adp.lib.util.k.showToast(h.this.acp.getContext(), h.this.acp.getString(d.l.data_load_error));
                                }
                                if (z4) {
                                    h.this.fjs.ao(null);
                                    h.this.fjw.XH();
                                }
                            }
                        });
                        this.fjx.fetchPost(this.bEH.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.h.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                if (personPostModel.getErrorCode() != 0) {
                                    com.baidu.adp.lib.util.k.showToast(h.this.acp.getContext(), personPostModel.getErrorString());
                                }
                                h.this.fjs.ajc();
                                if (z) {
                                    com.baidu.tieba.person.data.c cVar2 = (com.baidu.tieba.person.data.c) h.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<com.baidu.adp.widget.ListView.f> aXf = ((com.baidu.tieba.person.data.c) h.this.mList.get(1)).aXf();
                                        if (u.v(aXf)) {
                                            h.this.fjw.XH();
                                            return;
                                        } else if (u.u(personPostModel.postList) == 0 || (u.u(personPostModel.postList) == 1 && (personPostModel.postList.get(0) instanceof com.baidu.tieba.personPolymeric.c.i))) {
                                            cVar2.ki(false);
                                            h.this.fjs.ao(aXf);
                                            h.this.fjw.dM(true);
                                            return;
                                        } else if (h.cI(personPostModel.postList) == 0) {
                                            cVar2.ki(false);
                                            h.this.fjs.ao(aXf);
                                            h.this.fjw.dM(true);
                                            return;
                                        } else {
                                            aXf.addAll(personPostModel.postList);
                                            h.this.fjw.wX();
                                            cVar2.an(aXf);
                                            h.this.fjs.ao(aXf);
                                            return;
                                        }
                                    }
                                    cVar2.ki(true);
                                    cVar2.an(personPostModel.postList);
                                    cVar2.pX(0);
                                    h.this.fjs.ao(personPostModel.postList);
                                    if (!z3 && h.this.blJ) {
                                        h.this.fjs.bwF();
                                    }
                                    if (cVar2.aXf() != null && cVar2.aXf().size() == 1 && (cVar2.aXf().get(0) instanceof com.baidu.tieba.personPolymeric.c.i)) {
                                        ((com.baidu.tieba.personPolymeric.c.i) cVar2.aXf().get(0)).buk = h.this.blJ;
                                        h.this.fjw.XH();
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<com.baidu.adp.widget.ListView.f> aXf2 = ((com.baidu.tieba.person.data.c) h.this.mList.get(0)).aXf();
                                if (!u.v(aXf2)) {
                                    if (u.u(personPostModel.postList) == 0 || (u.u(personPostModel.postList) == 1 && (personPostModel.postList.get(0) instanceof com.baidu.tieba.personPolymeric.c.i))) {
                                        cVar.ki(false);
                                        h.this.fjs.ao(aXf2);
                                        h.this.fjw.dM(true);
                                        return;
                                    }
                                    aXf2.addAll(personPostModel.threadList);
                                    cVar.ki(true);
                                    cVar.an(aXf2);
                                    h.this.fjw.wX();
                                    h.this.fjs.cH(aXf2);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z);
                    }
                }
            }
        } else if (!z2) {
            this.fjw.wW();
        } else {
            com.baidu.adp.lib.util.k.showToast(this.acp.getContext(), this.acp.getString(d.l.data_load_error));
            if (z) {
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                iVar.buk = this.blJ;
                arrayList2.add(iVar);
                this.fjw.XH();
                this.fjs.ao(arrayList2);
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
        if (this.bEE != null) {
            this.bEE.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void f(boolean z, boolean z2, boolean z3) {
        j(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void Pr() {
        if (this.bEE != null) {
            this.bEE.Pr();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.fjx.resetThreadPn();
        if (this.bEG != null) {
            this.bEG.resetData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public com.baidu.tieba.person.data.c ho(int i) {
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
        this.fjs.ajc();
        this.bEH.hideLoadingView(this.mView);
        if (aVar == null) {
            this.fjw.K(TbadkCoreApplication.getInst().getString(d.l.neterror), true);
            this.fjw.XH();
            this.fjw.kr(8);
            return;
        }
        this.fjw.Nq();
        aVar.VG();
        if (aVar.aqm() != null) {
            z = aVar.aqm().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.bjA = false;
        if (this.blJ) {
            com.baidu.tbadk.getUserInfo.b.En().a(aVar.getUserData());
        }
        if (this.fiR != null) {
            this.fiR.a(aVar);
        }
        if (this.fjv != null) {
            this.fjv.c(aVar);
        }
        com.baidu.tieba.person.data.c cVar = this.mList.get(0);
        cVar.pX(0);
        cVar.an(aVar.aqm());
        cVar.ki(z);
        this.fjw.kr(0);
        this.fjs.a(aVar, z);
        if ((this.fjs.mRootView instanceof RelativeLayout) && !this.blJ) {
            if (this.fju == null) {
                this.fju = new i(this.bEH, (RelativeLayout) this.fjs.mRootView, aVar.getUserData());
                this.fju.setOnViewResponseListener(this.fjt);
            } else {
                this.fju.setData(aVar.getUserData());
            }
            this.fju.k(true, true, true);
        }
        aYy();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public e VI() {
        return this.fjv;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fjs != null) {
                this.fjs.onChangeSkinType(i);
            }
            if (this.fju != null) {
                this.fju.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.bEC = baseFragment;
    }

    public void aYy() {
        if (!this.bjA) {
            if ((this.bEC == null || this.bEC.isPrimary()) && this.fjs != null && (this.fjs.aYL() instanceof com.baidu.tieba.view.d)) {
                ((com.baidu.tieba.view.d) this.fjs.aYL()).aYy();
            }
        }
    }

    public void aYz() {
        if (this.fjs != null && (this.fjs.aYL() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.fjs.aYL()).aYz();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        this.fiR.onDestroy();
        if (this.fju != null) {
            this.fju.onDestroy();
        }
        if (this.fjs != null) {
            this.fjs.onDestory();
        }
        aYz();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void dz(boolean z) {
        if (z) {
            if (this.bjA) {
                Pr();
            }
            if (TbadkCoreApplication.isLogin()) {
                aYy();
                return;
            } else {
                aYz();
                return;
            }
        }
        aYz();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            aYy();
        } else {
            aYz();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void VJ() {
        if (this.fjs != null) {
            this.fjs.VJ();
        }
    }
}
