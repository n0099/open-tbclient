package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.e.a;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class aj implements com.baidu.tieba.model.b, a, com.baidu.tieba.personPolymeric.mode.b {
    private TbPageContext aas;
    private boolean beq;
    private PersonPolymericModel bwC;
    private y bwE;
    private as bwG;
    private com.baidu.tieba.e.c bwH;
    private i bwJ;
    private BaseFragmentActivity bwL;
    private n bwN;
    private CustomMessageListener bwO;
    private BaseFragment bwz;
    private com.baidu.tieba.personPolymeric.d.ac eLA;
    private com.baidu.tieba.personPolymeric.event.b eLB;
    private p eLC;
    private PersonPostModel eLD;
    private List<com.baidu.tieba.person.data.c> mList;
    private long mUserId;
    private View mView;
    private boolean bwA = true;
    private boolean bwB = false;
    private int mSex = 1;
    private int mSkinType = 3;
    private final com.baidu.tieba.view.z bwS = new ak(this);
    public View.OnTouchListener aJg = new al(this);
    private a.InterfaceC0059a bwT = new am(this);

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(BaseFragmentActivity baseFragmentActivity, n nVar, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.bwL = baseFragmentActivity;
        this.aas = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.beq = z;
        this.bwN = nVar;
        this.mView = nVar.mRootView;
        this.eLD = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null);
        this.eLA = new com.baidu.tieba.personPolymeric.d.ac(baseFragmentActivity.getPageContext(), nVar, bdUniqueId, z, z2);
        this.eLA.N(this.mView);
        this.eLA.initUI();
        this.eLB = new com.baidu.tieba.personPolymeric.event.b(baseFragmentActivity.getPageContext());
        this.eLB.a(this.bwN);
        this.eLA.setOnViewResponseListener(this.eLB);
        this.eLA.a(this);
        this.bwH = new com.baidu.tieba.e.c(baseFragmentActivity.getActivity());
        this.bwH.a(this.bwT);
        this.eLA.a(this.bwS);
        this.eLA.setOnTouchListener(this.aJg);
        this.bwE = this.bwN.aQW();
        this.eLA.O(this.bwE);
        this.bwC = this.bwN.aQX();
        this.bwC.f(new com.baidu.tieba.personPolymeric.c.o(z));
        this.bwJ = this.bwN.aRa();
        this.eLC = new p(baseFragmentActivity.getPageContext(), this.bwN.aQZ(), this.bwN.aQY(), this.eLA.aaU(), bdUniqueId);
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.c());
        this.mList.add(new com.baidu.tieba.person.data.c());
        this.bwO = new an(this, CmdConfigCustom.CMD_HOME_HIDE_GUIDE);
        this.bwO.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bwO);
    }

    public void i(boolean z, boolean z2, boolean z3) {
        if (com.baidu.adp.lib.util.i.gY()) {
            if (!com.baidu.tbadk.core.util.x.r(this.mList) && this.mList.size() >= 2) {
                com.baidu.tieba.person.data.c cVar = this.mList.get(z ? 1 : 0);
                if (cVar != null) {
                    if (!cVar.aPV() && !z2) {
                        this.mView.postDelayed(new ao(this), 800L);
                    } else if (z && this.bwC != null && this.bwC.aRt() != null && this.bwC.aRt().aRm()) {
                        this.eLA.Tx();
                        ArrayList<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.j jVar = new com.baidu.tieba.personPolymeric.c.j();
                        jVar.sex = this.mSex;
                        arrayList.add(jVar);
                        this.eLA.an(arrayList);
                        this.mView.postDelayed(new ap(this), 800L);
                    } else {
                        this.eLA.jt(z2);
                        this.eLD.setOnResult(new aq(this));
                        this.eLD.fetchPost(this.bwL.getPageContext(), new ar(this, z, z3, cVar), z2, String.valueOf(this.mUserId), false, z);
                    }
                }
            }
        } else if (!z2) {
            this.bwJ.wl();
        } else {
            com.baidu.adp.lib.util.k.showToast(this.aas.getContext(), this.aas.getString(w.l.data_load_error));
            if (z) {
                ArrayList<com.baidu.adp.widget.ListView.v> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                iVar.bld = this.beq;
                arrayList2.add(iVar);
                this.bwJ.VD();
                this.eLA.an(arrayList2);
            }
        }
    }

    public static int cc(List<com.baidu.adp.widget.ListView.v> list) {
        int i = 0;
        if (com.baidu.tbadk.core.util.x.q(list) == 0) {
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
        if (com.baidu.tbadk.core.util.x.q(arrayList) == 0) {
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

    @Override // com.baidu.tieba.model.b
    public void d(boolean z, boolean z2, boolean z3) {
        i(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.b
    public void NJ() {
        if (this.bwN != null) {
            this.bwN.NJ();
        }
    }

    @Override // com.baidu.tieba.model.b
    public void resetData() {
        this.eLD.resetThreadPn();
        if (this.bwC != null) {
            this.bwC.resetData();
        }
    }

    @Override // com.baidu.tieba.model.b
    public com.baidu.tieba.person.data.c hd(int i) {
        return (com.baidu.tieba.person.data.c) com.baidu.tbadk.core.util.x.c(this.mList, i);
    }

    @Override // com.baidu.tieba.model.b
    public void a(int i, com.baidu.tieba.person.data.c cVar) {
        if (cVar != null) {
            this.mList.set(i, cVar);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.eLA.Tx();
        this.bwL.hideLoadingView(this.mView);
        if (aVar == null) {
            this.bwJ.E(TbadkCoreApplication.m9getInst().getString(w.l.neterror), true);
            this.bwJ.VD();
            return;
        }
        this.bwJ.Mx();
        aVar.Tr();
        if (aVar.akJ() != null) {
            z = aVar.akJ().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.bwA = false;
        if (this.beq) {
            com.baidu.tbadk.getUserInfo.b.Dz().a(aVar.getUserData());
        }
        if (this.bwE != null) {
            this.bwE.e(aVar);
        }
        if (this.eLC != null) {
            this.eLC.d(aVar);
        }
        com.baidu.tieba.person.data.c cVar = this.mList.get(0);
        cVar.po(0);
        cVar.al(aVar.akJ());
        cVar.jp(z);
        this.eLA.a(aVar, z);
        if ((this.eLA.mRootView instanceof RelativeLayout) && !this.beq) {
            if (this.bwG == null) {
                this.bwG = new as(this.bwL, (RelativeLayout) this.eLA.mRootView, aVar.getUserData());
                this.bwG.setOnViewResponseListener(this.eLB);
            } else {
                this.bwG.setData(aVar.getUserData());
            }
            this.bwG.j(true, true, true);
        }
        Tv();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public p Tt() {
        return this.eLC;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.eLA != null) {
                this.eLA.onChangeSkinType(i);
            }
            if (this.bwG != null) {
                this.bwG.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(BaseFragment baseFragment) {
        this.bwz = baseFragment;
    }

    public void Tv() {
        if (!this.bwA) {
            if ((this.bwz == null || this.bwz.isPrimary()) && this.eLA != null && (this.eLA.Ty() instanceof com.baidu.tieba.view.j)) {
                ((com.baidu.tieba.view.j) this.eLA.Ty()).Tv();
            }
        }
    }

    public void Tw() {
        if (this.eLA != null && (this.eLA.Ty() instanceof com.baidu.tieba.view.j)) {
            ((com.baidu.tieba.view.j) this.eLA.Ty()).Tw();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        this.bwE.onDestroy();
        if (this.bwG != null) {
            this.bwG.onDestroy();
        }
        if (this.eLA != null) {
            this.eLA.onDestory();
        }
        Tw();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void dj(boolean z) {
        if (z) {
            if (TbadkCoreApplication.isLogin()) {
                Tv();
                return;
            } else {
                Tw();
                return;
            }
        }
        Tw();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            Tv();
        } else {
            Tw();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void Tu() {
        if (this.eLA != null) {
            this.eLA.Tu();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void dk(boolean z) {
    }
}
