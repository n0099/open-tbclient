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
public class ak implements com.baidu.tieba.model.b, a {
    private TbPageContext aat;
    private CustomMessageListener bTl;
    private boolean bhl;
    private BaseFragment bzm;
    private o bzo;
    private PersonPolymericModel bzq;
    private BaseFragmentActivity bzr;
    private com.baidu.tieba.e.c cfe;
    private com.baidu.tieba.personPolymeric.d.ac eVF;
    private com.baidu.tieba.personPolymeric.event.b eVG;
    private at eVH;
    private r eVI;
    private i eVJ;
    private PersonPostModel eVK;
    private z eVe;
    private List<com.baidu.tieba.person.data.c> mList;
    private long mUserId;
    private View mView;
    private boolean bHe = true;
    private boolean eVE = false;
    private int mSex = 1;
    private int mSkinType = 3;
    private final com.baidu.tieba.view.z eVL = new al(this);
    public View.OnTouchListener aKv = new am(this);
    private a.InterfaceC0062a bQR = new an(this);

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(BaseFragmentActivity baseFragmentActivity, o oVar, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.bzr = baseFragmentActivity;
        this.aat = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.bhl = z;
        this.bzo = oVar;
        this.mView = oVar.mRootView;
        this.eVK = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null);
        this.eVF = new com.baidu.tieba.personPolymeric.d.ac(baseFragmentActivity.getPageContext(), oVar, bdUniqueId, z, z2);
        this.eVF.O(this.mView);
        this.eVF.initUI();
        this.eVG = new com.baidu.tieba.personPolymeric.event.b(baseFragmentActivity.getPageContext());
        this.eVG.c(this.bzo);
        this.eVF.setOnViewResponseListener(this.eVG);
        this.eVF.a(this);
        resetData();
        this.cfe = new com.baidu.tieba.e.c(baseFragmentActivity.getActivity());
        this.cfe.a(this.bQR);
        this.eVF.a(this.eVL);
        this.eVF.setOnTouchListener(this.aKv);
        this.eVe = this.bzo.aVc();
        this.eVF.P(this.eVe);
        this.bzq = this.bzo.aVd();
        this.bzq.d(new com.baidu.tieba.personPolymeric.c.o(z));
        this.eVJ = this.bzo.aVg();
        this.eVI = new r(baseFragmentActivity.getPageContext(), this.bzo.aVf(), this.bzo.aVe(), this.eVF.aeL(), bdUniqueId);
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.c());
        this.mList.add(new com.baidu.tieba.person.data.c());
        this.bTl = new ao(this, CmdConfigCustom.CMD_HOME_HIDE_GUIDE);
        this.bTl.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bTl);
    }

    public void h(boolean z, boolean z2, boolean z3) {
        if (com.baidu.adp.lib.util.i.gX()) {
            if (!com.baidu.tbadk.core.util.z.t(this.mList) && this.mList.size() >= 2) {
                com.baidu.tieba.person.data.c cVar = this.mList.get(z ? 1 : 0);
                if (cVar != null) {
                    if (!cVar.aTW() && !z2) {
                        this.mView.postDelayed(new ap(this), 800L);
                    } else if (z && this.bzq != null && this.bzq.aVB() != null && this.bzq.aVB().aVv()) {
                        this.eVF.ahs();
                        ArrayList<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.j jVar = new com.baidu.tieba.personPolymeric.c.j();
                        jVar.sex = this.mSex;
                        arrayList.add(jVar);
                        this.eVF.ao(arrayList);
                        this.mView.postDelayed(new aq(this), 800L);
                    } else {
                        this.eVF.jR(z2);
                        this.eVK.setOnResult(new ar(this));
                        this.eVK.fetchPost(this.bzr.getPageContext(), new as(this, z, z3, cVar), z2, String.valueOf(this.mUserId), false, z);
                    }
                }
            }
        } else if (!z2) {
            this.eVJ.wD();
        } else {
            com.baidu.adp.lib.util.k.showToast(this.aat.getContext(), this.aat.getString(w.l.data_load_error));
            if (z) {
                ArrayList<com.baidu.adp.widget.ListView.v> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                iVar.boT = this.bhl;
                arrayList2.add(iVar);
                this.eVJ.WU();
                this.eVF.ao(arrayList2);
            }
        }
    }

    public static int cr(List<com.baidu.adp.widget.ListView.v> list) {
        int i = 0;
        if (com.baidu.tbadk.core.util.z.s(list) == 0) {
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
        if (com.baidu.tbadk.core.util.z.s(arrayList) == 0) {
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
    public void refreshData() {
        if (this.bzo != null) {
            this.bzo.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.b
    public void d(boolean z, boolean z2, boolean z3) {
        h(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.b
    public void OZ() {
        if (this.bzo != null) {
            this.bzo.OZ();
        }
    }

    @Override // com.baidu.tieba.model.b
    public void resetData() {
        this.eVK.resetThreadPn();
        if (this.bzq != null) {
            this.bzq.resetData();
        }
    }

    @Override // com.baidu.tieba.model.b
    public com.baidu.tieba.person.data.c hh(int i) {
        return (com.baidu.tieba.person.data.c) com.baidu.tbadk.core.util.z.c(this.mList, i);
    }

    @Override // com.baidu.tieba.model.b
    public void a(int i, com.baidu.tieba.person.data.c cVar) {
        if (cVar != null) {
            this.mList.set(i, cVar);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.eVF.ahs();
        this.bzr.hideLoadingView(this.mView);
        if (aVar == null) {
            this.eVJ.J(TbadkCoreApplication.m9getInst().getString(w.l.neterror), true);
            this.eVJ.WU();
            this.eVJ.kj(8);
            return;
        }
        this.eVJ.Np();
        aVar.UT();
        if (aVar.aou() != null) {
            z = aVar.aou().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.bHe = false;
        if (this.bhl) {
            com.baidu.tbadk.getUserInfo.b.DT().a(aVar.getUserData());
        }
        if (this.eVe != null) {
            this.eVe.a(aVar);
        }
        if (this.eVI != null) {
            this.eVI.c(aVar);
        }
        com.baidu.tieba.person.data.c cVar = this.mList.get(0);
        cVar.pI(0);
        cVar.an(aVar.aou());
        cVar.jN(z);
        this.eVJ.kj(0);
        this.eVF.a(aVar, z);
        if ((this.eVF.mRootView instanceof RelativeLayout) && !this.bhl) {
            if (this.eVH == null) {
                this.eVH = new at(this.bzr, (RelativeLayout) this.eVF.mRootView, aVar.getUserData());
                this.eVH.setOnViewResponseListener(this.eVG);
            } else {
                this.eVH.setData(aVar.getUserData());
            }
            this.eVH.i(true, true, true);
        }
        aVs();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public r UV() {
        return this.eVI;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.eVF != null) {
                this.eVF.onChangeSkinType(i);
            }
            if (this.eVH != null) {
                this.eVH.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(BaseFragment baseFragment) {
        this.bzm = baseFragment;
    }

    public void aVs() {
        if (!this.bHe) {
            if ((this.bzm == null || this.bzm.isPrimary()) && this.eVF != null && (this.eVF.aVF() instanceof com.baidu.tieba.view.j)) {
                ((com.baidu.tieba.view.j) this.eVF.aVF()).aVs();
            }
        }
    }

    public void aVt() {
        if (this.eVF != null && (this.eVF.aVF() instanceof com.baidu.tieba.view.j)) {
            ((com.baidu.tieba.view.j) this.eVF.aVF()).aVt();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        this.eVe.onDestroy();
        if (this.eVH != null) {
            this.eVH.onDestroy();
        }
        if (this.eVF != null) {
            this.eVF.onDestory();
        }
        aVt();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void dq(boolean z) {
        if (z) {
            if (this.bHe) {
                OZ();
            }
            if (TbadkCoreApplication.isLogin()) {
                aVs();
                return;
            } else {
                aVt();
                return;
            }
        }
        aVt();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            aVs();
        } else {
            aVt();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void UW() {
        if (this.eVF != null) {
            this.eVF.UW();
        }
    }
}
