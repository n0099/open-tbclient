package com.baidu.tieba.personPolymeric.b;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e.a;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ab implements com.baidu.tieba.model.a, com.baidu.tieba.personPolymeric.mode.b {
    private TbPageContext Gd;
    private BaseActivity aPR;
    private com.baidu.tieba.e.c bPI;
    private boolean cue;
    private com.baidu.tieba.personPolymeric.mode.c eHI;
    private BlackListModel eHJ;
    private com.baidu.tieba.personPolymeric.d.x eHK;
    private com.baidu.tieba.personPolymeric.event.b eHL;
    private af eHM;
    private q eHN;
    private h eHO;
    private a eHn;
    private long mUserId;
    private boolean bNs = true;
    private final com.baidu.tieba.view.v eHP = new ac(this);
    public View.OnTouchListener aKe = new ad(this);
    private a.InterfaceC0055a aQg = new ae(this);

    public ab(BaseActivity baseActivity, long j, boolean z) {
        this.aPR = baseActivity;
        this.Gd = baseActivity.getPageContext();
        this.mUserId = j;
        this.cue = z;
        this.eHI = new com.baidu.tieba.personPolymeric.mode.c(baseActivity, z);
        this.eHI.a(this);
        this.eHn = new a(baseActivity.getPageContext());
        this.eHI.a(this.eHn);
        this.eHJ = new BlackListModel(baseActivity.getPageContext());
        this.eHK = new com.baidu.tieba.personPolymeric.d.x(baseActivity.getPageContext(), z);
        baseActivity.setContentView(this.eHK.onCreateView(LayoutInflater.from(baseActivity.getActivity()), null, null));
        this.eHK.initUI();
        this.eHL = new com.baidu.tieba.personPolymeric.event.b(baseActivity.getPageContext());
        this.eHL.c(this);
        this.eHK.setOnViewResponseListener(this.eHL);
        this.eHK.a(this);
        this.bPI = new com.baidu.tieba.e.c(baseActivity.getActivity());
        this.bPI.a(this.aQg);
        this.eHK.a(this.eHP);
        this.eHK.setOnTouchListener(this.aKe);
        this.eHN = new q(baseActivity.getPageContext());
        this.eHK.M(this.eHN);
        this.eHN.a(this.eHI);
        this.eHO = new h(baseActivity.getPageContext(), this.eHn, this.eHJ, this.eHK.bqq());
    }

    @Override // com.baidu.tieba.model.a
    public void Rt() {
        if (com.baidu.adp.lib.util.i.fZ()) {
            if (this.bNs) {
                this.eHK.i(true, this.Gd.getResources().getDimensionPixelSize(t.e.ds480));
                this.eHI.cJ(this.mUserId);
            }
            this.eHI.cI(this.mUserId);
        } else if (!this.eHI.hasData()) {
            this.eHK.F(TbadkCoreApplication.m9getInst().getString(t.j.neterror), true);
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.eHI.resetData();
    }

    @Override // com.baidu.tieba.model.a
    public boolean hasMoreData() {
        return this.eHI.hasMoreData();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void a(com.baidu.tieba.personPolymeric.c.n nVar, boolean z) {
        this.eHK.afa();
        this.eHK.Lb();
        if (!z) {
            this.eHK.iS(!com.baidu.tbadk.core.util.y.t(nVar.aTF()));
        }
        if (nVar == null || com.baidu.tbadk.core.util.y.t(nVar.aoT())) {
            this.eHK.F(TbadkCoreApplication.m9getInst().getString(t.j.neterror), true);
            return;
        }
        this.bNs = false;
        if (this.cue) {
            com.baidu.tbadk.getUserInfo.b.Ec().a(nVar.getUserData());
        }
        if (this.eHN != null) {
            this.eHN.b(nVar);
        }
        if (this.eHO != null) {
            this.eHO.a(nVar);
        }
        this.eHK.c(nVar);
        if ((this.eHK.mRootView instanceof RelativeLayout) && !this.cue) {
            if (this.eHM == null) {
                this.eHM = new af(this.aPR, (RelativeLayout) this.eHK.mRootView, nVar.getUserData());
            } else {
                this.eHM.setData(nVar.getUserData());
            }
        }
    }

    public q aTz() {
        return this.eHN;
    }

    public h aTA() {
        return this.eHO;
    }

    public void onChangeSkinType(int i) {
        if (this.eHK != null) {
            this.eHK.onChangeSkinType(i);
        }
        if (this.eHM != null) {
            this.eHM.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        this.eHN.onDestroy();
    }
}
