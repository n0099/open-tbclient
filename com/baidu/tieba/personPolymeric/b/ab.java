package com.baidu.tieba.personPolymeric.b;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e.a;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ab implements com.baidu.tieba.model.a, com.baidu.tieba.personPolymeric.mode.b {
    private TbPageContext aat;
    private com.baidu.tieba.e.c bRf;
    private boolean bdp;
    private BaseFragmentActivity dEr;
    private BaseFragment eCH;
    private PersonPolymericModel eCJ;
    private BlackListModel eCK;
    private com.baidu.tieba.personPolymeric.d.ab eCL;
    private com.baidu.tieba.personPolymeric.event.b eCM;
    private aj eCN;
    private q eCO;
    private h eCP;
    private PersonPostModel eCQ;
    private a eCl;
    private List<com.baidu.tieba.person.data.c> mList;
    private long mUserId;
    private View mView;
    private boolean bAr = true;
    private boolean eCI = false;
    private int mSex = 1;
    private int mSkinType = 3;
    private final com.baidu.tieba.view.y eCR = new ac(this);
    public View.OnTouchListener aJt = new ad(this);
    private a.InterfaceC0059a aRJ = new ae(this);

    public View getView() {
        return this.mView;
    }

    public ab(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.dEr = baseFragmentActivity;
        this.aat = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.bdp = z;
        this.eCJ = new PersonPolymericModel(baseFragmentActivity, bdUniqueId, z);
        this.eCJ.a(this);
        this.eCQ = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null);
        this.eCl = new a(baseFragmentActivity.getPageContext());
        this.eCJ.a(this.eCl);
        this.eCK = new BlackListModel(baseFragmentActivity.getPageContext(), bdUniqueId);
        this.eCL = new com.baidu.tieba.personPolymeric.d.ab(baseFragmentActivity.getPageContext(), bdUniqueId, z, z2);
        this.mView = this.eCL.onCreateView(LayoutInflater.from(baseFragmentActivity.getActivity()), null, null);
        this.eCL.initUI();
        this.eCM = new com.baidu.tieba.personPolymeric.event.b(baseFragmentActivity.getPageContext());
        this.eCM.f(this);
        this.eCL.setOnViewResponseListener(this.eCM);
        this.eCL.a(this);
        this.bRf = new com.baidu.tieba.e.c(baseFragmentActivity.getActivity());
        this.bRf.a(this.aRJ);
        this.eCL.a(this.eCR);
        this.eCL.setOnTouchListener(this.aJt);
        this.eCO = new q(baseFragmentActivity.getPageContext(), bdUniqueId);
        this.eCL.M(this.eCO);
        this.eCO.a(this.eCJ);
        this.eCP = new h(baseFragmentActivity.getPageContext(), this.eCl, this.eCK, this.eCL.bkW(), bdUniqueId);
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.c());
        this.mList.add(new com.baidu.tieba.person.data.c());
    }

    public void i(boolean z, boolean z2, boolean z3) {
        if (com.baidu.adp.lib.util.i.gY()) {
            if (!com.baidu.tbadk.core.util.x.r(this.mList) && this.mList.size() >= 2) {
                com.baidu.tieba.person.data.c cVar = this.mList.get(z ? 1 : 0);
                if (cVar != null) {
                    if (!cVar.aOF() && !z2) {
                        this.mView.postDelayed(new af(this), 800L);
                    } else if (z && this.eCJ.aPY() != null && this.eCJ.aPY().aPT()) {
                        this.eCL.acw();
                        ArrayList<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                        iVar.sex = this.mSex;
                        arrayList.add(iVar);
                        this.eCL.an(arrayList);
                        this.mView.postDelayed(new ag(this), 800L);
                    } else {
                        this.eCL.lu(z2);
                        this.eCQ.setOnResult(new ah(this));
                        this.eCQ.fetchPost(this.dEr.getPageContext(), new ai(this, z, z3, cVar), z2, String.valueOf(this.mUserId), false, z);
                    }
                }
            }
        } else if (!z2) {
            this.eCL.wo();
        } else {
            com.baidu.adp.lib.util.k.showToast(this.aat.getContext(), this.aat.getString(w.l.data_load_error));
            if (z) {
                ArrayList<com.baidu.adp.widget.ListView.v> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.h hVar = new com.baidu.tieba.personPolymeric.c.h();
                hVar.bjW = this.bdp;
                arrayList2.add(hVar);
                this.eCL.UA();
                this.eCL.an(arrayList2);
            }
        }
    }

    public static int bZ(List<com.baidu.adp.widget.ListView.v> list) {
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

    public void aPL() {
        if (this.eCH != null && this.bAr && !this.eCI) {
            this.eCI = true;
            NA();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void NA() {
        if (!TbadkCoreApplication.isLogin() && this.bdp) {
            this.eCL.aQe();
        } else if (com.baidu.adp.lib.util.i.gY()) {
            if (this.bAr) {
                this.eCL.lu(true);
                this.eCJ.ca(this.mUserId);
                this.dEr.showLoadingView(this.mView);
            }
            this.eCJ.bZ(this.mUserId);
        } else if (this.bAr) {
            this.eCL.H(TbadkCoreApplication.m9getInst().getString(w.l.neterror), true);
        } else {
            com.baidu.adp.lib.util.k.showToast(this.aat.getContext(), this.aat.getString(w.l.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.h hVar = new com.baidu.tieba.personPolymeric.c.h();
            hVar.bjW = this.bdp;
            arrayList.add(hVar);
            this.eCL.UA();
            this.eCL.cK(arrayList);
        }
    }

    @Override // com.baidu.tieba.model.a
    public void g(boolean z, boolean z2, boolean z3) {
        i(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.eCQ.resetThreadPn();
        this.eCJ.resetData();
    }

    @Override // com.baidu.tieba.model.a
    public com.baidu.tieba.person.data.c nu(int i) {
        return (com.baidu.tieba.person.data.c) com.baidu.tbadk.core.util.x.c(this.mList, i);
    }

    @Override // com.baidu.tieba.model.a
    public void a(int i, com.baidu.tieba.person.data.c cVar) {
        if (cVar != null) {
            this.mList.set(i, cVar);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void a(com.baidu.tieba.personPolymeric.c.n nVar, boolean z) {
        this.eCL.acw();
        this.dEr.hideLoadingView(this.mView);
        if (nVar == null) {
            this.eCL.H(TbadkCoreApplication.m9getInst().getString(w.l.neterror), true);
            this.eCL.UA();
            return;
        }
        if (nVar.getUserData() != null) {
            this.mSex = nVar.getUserData().getSex();
        }
        this.bAr = false;
        if (this.bdp) {
            com.baidu.tbadk.getUserInfo.b.DF().a(nVar.getUserData());
        }
        if (this.eCO != null) {
            this.eCO.b(nVar);
        }
        if (this.eCP != null) {
            this.eCP.a(nVar);
        }
        com.baidu.tieba.person.data.c cVar = this.mList.get(0);
        cVar.oP(0);
        cVar.al(nVar.ajJ());
        cVar.iW(z);
        this.eCL.b(nVar, z);
        if ((this.eCL.mRootView instanceof RelativeLayout) && !this.bdp) {
            if (this.eCN == null) {
                this.eCN = new aj(this.dEr, (RelativeLayout) this.eCL.mRootView, nVar.getUserData());
            } else {
                this.eCN.setData(nVar.getUserData());
            }
        }
        aPO();
    }

    public q aPM() {
        return this.eCO;
    }

    public h aPN() {
        return this.eCP;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.eCL != null) {
                this.eCL.onChangeSkinType(i);
            }
            if (this.eCN != null) {
                this.eCN.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void a(BaseFragment baseFragment) {
        this.eCH = baseFragment;
    }

    public void aPO() {
        if (!this.bAr) {
            if ((this.eCH == null || this.eCH.isPrimary()) && this.eCL != null && (this.eCL.aQg() instanceof com.baidu.tieba.view.j)) {
                ((com.baidu.tieba.view.j) this.eCL.aQg()).aPO();
            }
        }
    }

    public void aPP() {
        if (this.eCL != null && (this.eCL.aQg() instanceof com.baidu.tieba.view.j)) {
            ((com.baidu.tieba.view.j) this.eCL.aQg()).aPP();
        }
    }

    public void onDestroy() {
        this.eCO.onDestroy();
        if (this.eCN != null) {
            this.eCN.onDestroy();
        }
        if (this.eCL != null) {
            this.eCL.onDestory();
        }
        aPP();
    }

    public void aPQ() {
        if (this.eCL != null) {
            this.eCL.aPQ();
        }
    }
}
