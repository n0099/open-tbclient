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
    private BaseActivity aTb;
    private com.baidu.tieba.d.c bVF;
    private boolean czI;
    private a ePQ;
    private com.baidu.tieba.personPolymeric.mode.c eQl;
    private BlackListModel eQm;
    private com.baidu.tieba.personPolymeric.d.x eQn;
    private com.baidu.tieba.personPolymeric.event.b eQo;
    private af eQp;
    private q eQq;
    private h eQr;
    private long mUserId;
    private boolean bQi = true;
    private final com.baidu.tieba.view.v eQs = new ac(this);
    public View.OnTouchListener aKw = new ad(this);
    private a.InterfaceC0058a aMT = new ae(this);

    public ab(BaseActivity baseActivity, long j, boolean z) {
        this.aTb = baseActivity;
        this.Gf = baseActivity.getPageContext();
        this.mUserId = j;
        this.czI = z;
        this.eQl = new com.baidu.tieba.personPolymeric.mode.c(baseActivity, z);
        this.eQl.a(this);
        this.ePQ = new a(baseActivity.getPageContext());
        this.eQl.a(this.ePQ);
        this.eQm = new BlackListModel(baseActivity.getPageContext());
        this.eQn = new com.baidu.tieba.personPolymeric.d.x(baseActivity.getPageContext(), z);
        baseActivity.setContentView(this.eQn.onCreateView(LayoutInflater.from(baseActivity.getActivity()), null, null));
        this.eQn.initUI();
        this.eQo = new com.baidu.tieba.personPolymeric.event.b(baseActivity.getPageContext());
        this.eQo.c(this);
        this.eQn.setOnViewResponseListener(this.eQo);
        this.eQn.a(this);
        this.bVF = new com.baidu.tieba.d.c(baseActivity.getActivity());
        this.bVF.a(this.aMT);
        this.eQn.a(this.eQs);
        this.eQn.setOnTouchListener(this.aKw);
        this.eQq = new q(baseActivity.getPageContext());
        this.eQn.N(this.eQq);
        this.eQq.a(this.eQl);
        this.eQr = new h(baseActivity.getPageContext(), this.ePQ, this.eQm, this.eQn.btn());
    }

    @Override // com.baidu.tieba.model.a
    public void SN() {
        if (com.baidu.adp.lib.util.i.fZ()) {
            if (this.bQi) {
                this.eQn.j(true, this.Gf.getResources().getDimensionPixelSize(r.e.ds480));
                this.eQl.cK(this.mUserId);
            }
            this.eQl.cJ(this.mUserId);
        } else if (!this.eQl.hasData()) {
            this.eQn.G(TbadkCoreApplication.m9getInst().getString(r.j.neterror), true);
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.eQl.resetData();
    }

    @Override // com.baidu.tieba.model.a
    public boolean hasMoreData() {
        return this.eQl.hasMoreData();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void a(com.baidu.tieba.personPolymeric.c.n nVar, boolean z) {
        this.eQn.agY();
        this.eQn.JO();
        if (!z) {
            this.eQn.jv(!com.baidu.tbadk.core.util.x.t(nVar.aWj()));
        }
        if (nVar == null || com.baidu.tbadk.core.util.x.t(nVar.ard())) {
            this.eQn.G(TbadkCoreApplication.m9getInst().getString(r.j.neterror), true);
            return;
        }
        this.bQi = false;
        if (this.czI) {
            com.baidu.tbadk.getUserInfo.b.Eh().a(nVar.getUserData());
        }
        if (this.eQq != null) {
            this.eQq.b(nVar);
        }
        if (this.eQr != null) {
            this.eQr.a(nVar);
        }
        this.eQn.c(nVar);
        if ((this.eQn.mRootView instanceof RelativeLayout) && !this.czI) {
            if (this.eQp == null) {
                this.eQp = new af(this.aTb, (RelativeLayout) this.eQn.mRootView, nVar.getUserData());
            } else {
                this.eQp.setData(nVar.getUserData());
            }
        }
    }

    public q aWd() {
        return this.eQq;
    }

    public h aWe() {
        return this.eQr;
    }

    public void onChangeSkinType(int i) {
        if (this.eQn != null) {
            this.eQn.onChangeSkinType(i);
        }
        if (this.eQp != null) {
            this.eQp.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        this.eQq.onDestroy();
        if (this.eQp != null) {
            this.eQp.onDestroy();
        }
    }
}
