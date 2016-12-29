package com.baidu.tieba.personPolymeric.b;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d.a;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ab implements com.baidu.tieba.model.a, com.baidu.tieba.personPolymeric.mode.b {
    private TbPageContext Gf;
    private BaseActivity aSs;
    private com.baidu.tieba.d.c bBN;
    private boolean ceV;
    private com.baidu.tieba.personPolymeric.mode.c etK;
    private BlackListModel etL;
    private com.baidu.tieba.personPolymeric.d.x etM;
    private com.baidu.tieba.personPolymeric.event.b etN;
    private af etO;
    private q etP;
    private h etQ;
    private a eto;
    private long mUserId;
    private boolean bwm = true;
    private final com.baidu.tieba.view.v etR = new ac(this);
    public View.OnTouchListener aJN = new ad(this);
    private a.InterfaceC0057a aMk = new ae(this);

    public ab(BaseActivity baseActivity, long j, boolean z) {
        this.aSs = baseActivity;
        this.Gf = baseActivity.getPageContext();
        this.mUserId = j;
        this.ceV = z;
        this.etK = new com.baidu.tieba.personPolymeric.mode.c(baseActivity, z);
        this.etK.a(this);
        this.eto = new a(baseActivity.getPageContext());
        this.etK.a(this.eto);
        this.etL = new BlackListModel(baseActivity.getPageContext());
        this.etM = new com.baidu.tieba.personPolymeric.d.x(baseActivity.getPageContext(), z);
        baseActivity.setContentView(this.etM.onCreateView(LayoutInflater.from(baseActivity.getActivity()), null, null));
        this.etM.initUI();
        this.etN = new com.baidu.tieba.personPolymeric.event.b(baseActivity.getPageContext());
        this.etN.c(this);
        this.etM.setOnViewResponseListener(this.etN);
        this.etM.a(this);
        this.bBN = new com.baidu.tieba.d.c(baseActivity.getActivity());
        this.bBN.a(this.aMk);
        this.etM.a(this.etR);
        this.etM.setOnTouchListener(this.aJN);
        this.etP = new q(baseActivity.getPageContext());
        this.etM.J(this.etP);
        this.etP.a(this.etK);
        this.etQ = new h(baseActivity.getPageContext(), this.eto, this.etL, this.etM.bkn());
    }

    @Override // com.baidu.tieba.model.a
    public void Tj() {
        if (com.baidu.adp.lib.util.i.fZ()) {
            if (this.bwm) {
                this.etM.g(true, this.Gf.getResources().getDimensionPixelSize(r.e.ds480));
                this.etK.cs(this.mUserId);
            }
            this.etK.cr(this.mUserId);
        } else if (!this.etK.hasData()) {
            this.etM.H(TbadkCoreApplication.m9getInst().getString(r.j.neterror), true);
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.etK.resetData();
    }

    @Override // com.baidu.tieba.model.a
    public boolean aEa() {
        return this.etK.aEa();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void a(com.baidu.tieba.personPolymeric.c.n nVar, boolean z) {
        this.etM.abt();
        this.etM.Jj();
        if (!z) {
            this.etM.jg(!com.baidu.tbadk.core.util.x.t(nVar.aPT()));
        }
        if (nVar == null || com.baidu.tbadk.core.util.x.t(nVar.alF())) {
            this.etM.H(TbadkCoreApplication.m9getInst().getString(r.j.neterror), true);
            return;
        }
        this.bwm = false;
        if (this.ceV) {
            com.baidu.tbadk.getUserInfo.b.DP().a(nVar.getUserData());
        }
        if (this.etP != null) {
            this.etP.b(nVar);
        }
        if (this.etQ != null) {
            this.etQ.a(nVar);
        }
        this.etM.c(nVar);
        if ((this.etM.mRootView instanceof RelativeLayout) && !this.ceV) {
            if (this.etO == null) {
                this.etO = new af(this.aSs, (RelativeLayout) this.etM.mRootView, nVar.getUserData());
            } else {
                this.etO.setData(nVar.getUserData());
            }
        }
    }

    public q aPN() {
        return this.etP;
    }

    public h aPO() {
        return this.etQ;
    }

    public void onChangeSkinType(int i) {
        if (this.etM != null) {
            this.etM.onChangeSkinType(i);
        }
        if (this.etO != null) {
            this.etO.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        this.etP.onDestroy();
        if (this.etO != null) {
            this.etO.onDestroy();
        }
    }
}
