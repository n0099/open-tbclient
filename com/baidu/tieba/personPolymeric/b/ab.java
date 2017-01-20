package com.baidu.tieba.personPolymeric.b;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.f.a;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ab implements com.baidu.tieba.model.a, com.baidu.tieba.personPolymeric.mode.b {
    private TbPageContext Fp;
    private boolean aVU;
    private BaseActivity aWr;
    private com.baidu.tieba.f.c bJg;
    private PersonPolymericModel eDE;
    private BlackListModel eDF;
    private com.baidu.tieba.personPolymeric.d.z eDG;
    private com.baidu.tieba.personPolymeric.event.b eDH;
    private af eDI;
    private q eDJ;
    private h eDK;
    private a eDi;
    private long mUserId;
    private boolean bDQ = true;
    private final com.baidu.tieba.view.v eDL = new ac(this);
    public View.OnTouchListener aIu = new ad(this);
    private a.InterfaceC0057a aLl = new ae(this);

    public ab(BaseActivity baseActivity, long j, boolean z) {
        this.aWr = baseActivity;
        this.Fp = baseActivity.getPageContext();
        this.mUserId = j;
        this.aVU = z;
        this.eDE = new PersonPolymericModel(baseActivity, z);
        this.eDE.a(this);
        this.eDi = new a(baseActivity.getPageContext());
        this.eDE.a(this.eDi);
        this.eDF = new BlackListModel(baseActivity.getPageContext());
        this.eDG = new com.baidu.tieba.personPolymeric.d.z(baseActivity.getPageContext(), z);
        baseActivity.setContentView(this.eDG.onCreateView(LayoutInflater.from(baseActivity.getActivity()), null, null));
        this.eDG.initUI();
        this.eDH = new com.baidu.tieba.personPolymeric.event.b(baseActivity.getPageContext());
        this.eDH.c(this);
        this.eDG.setOnViewResponseListener(this.eDH);
        this.eDG.a(this);
        this.bJg = new com.baidu.tieba.f.c(baseActivity.getActivity());
        this.bJg.a(this.aLl);
        this.eDG.a(this.eDL);
        this.eDG.setOnTouchListener(this.aIu);
        this.eDJ = new q(baseActivity.getPageContext());
        this.eDG.M(this.eDJ);
        this.eDJ.a(this.eDE);
        this.eDK = new h(baseActivity.getPageContext(), this.eDi, this.eDF, this.eDG.blP());
    }

    @Override // com.baidu.tieba.model.a
    public void MR() {
        if (com.baidu.adp.lib.util.i.fX()) {
            if (this.bDQ) {
                this.eDG.g(true, this.Fp.getResources().getDimensionPixelSize(r.f.ds480));
                this.eDE.cn(this.mUserId);
            }
            this.eDE.cm(this.mUserId);
        } else if (!this.eDE.hasData()) {
            this.eDG.G(TbadkCoreApplication.m9getInst().getString(r.l.neterror), true);
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.eDE.resetData();
    }

    @Override // com.baidu.tieba.model.a
    public boolean Py() {
        return this.eDE.Py();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void a(com.baidu.tieba.personPolymeric.c.n nVar, boolean z) {
        this.eDG.acA();
        this.eDG.Jx();
        if (!z) {
            this.eDG.cW(!com.baidu.tbadk.core.util.w.s(nVar.aRR()));
        }
        if (nVar == null || com.baidu.tbadk.core.util.w.s(nVar.amM())) {
            this.eDG.G(TbadkCoreApplication.m9getInst().getString(r.l.neterror), true);
            return;
        }
        this.bDQ = false;
        if (this.aVU) {
            com.baidu.tbadk.getUserInfo.b.DK().a(nVar.getUserData());
        }
        if (this.eDJ != null) {
            this.eDJ.b(nVar);
        }
        if (this.eDK != null) {
            this.eDK.a(nVar);
        }
        this.eDG.c(nVar);
        if ((this.eDG.mRootView instanceof RelativeLayout) && !this.aVU) {
            if (this.eDI == null) {
                this.eDI = new af(this.aWr, (RelativeLayout) this.eDG.mRootView, nVar.getUserData());
            } else {
                this.eDI.setData(nVar.getUserData());
            }
        }
    }

    public q aRL() {
        return this.eDJ;
    }

    public h aRM() {
        return this.eDK;
    }

    public void onChangeSkinType(int i) {
        if (this.eDG != null) {
            this.eDG.onChangeSkinType(i);
        }
        if (this.eDI != null) {
            this.eDI.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        this.eDJ.onDestroy();
        if (this.eDI != null) {
            this.eDI.onDestroy();
        }
        if (this.eDG != null) {
            this.eDG.onDestory();
        }
    }
}
