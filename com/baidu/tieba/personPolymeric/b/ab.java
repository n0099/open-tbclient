package com.baidu.tieba.personPolymeric.b;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e.a;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ab implements com.baidu.tieba.model.a, com.baidu.tieba.personPolymeric.mode.b {
    private TbPageContext aaY;
    private com.baidu.tieba.e.c bSv;
    private boolean bcY;
    private BaseActivity bdG;
    private a eGW;
    private PersonPolymericModel eHs;
    private BlackListModel eHt;
    private com.baidu.tieba.personPolymeric.d.z eHu;
    private com.baidu.tieba.personPolymeric.event.b eHv;
    private af eHw;
    private q eHx;
    private h eHy;
    private long mUserId;
    private boolean bNh = true;
    private final com.baidu.tieba.view.v eHz = new ac(this);
    public View.OnTouchListener aOj = new ad(this);
    private a.InterfaceC0055a aRo = new ae(this);

    public ab(BaseActivity baseActivity, long j, boolean z) {
        this.bdG = baseActivity;
        this.aaY = baseActivity.getPageContext();
        this.mUserId = j;
        this.bcY = z;
        this.eHs = new PersonPolymericModel(baseActivity, z);
        this.eHs.a(this);
        this.eGW = new a(baseActivity.getPageContext());
        this.eHs.a(this.eGW);
        this.eHt = new BlackListModel(baseActivity.getPageContext());
        this.eHu = new com.baidu.tieba.personPolymeric.d.z(baseActivity.getPageContext(), z);
        baseActivity.setContentView(this.eHu.onCreateView(LayoutInflater.from(baseActivity.getActivity()), null, null));
        this.eHu.initUI();
        this.eHv = new com.baidu.tieba.personPolymeric.event.b(baseActivity.getPageContext());
        this.eHv.c(this);
        this.eHu.setOnViewResponseListener(this.eHv);
        this.eHu.a(this);
        this.bSv = new com.baidu.tieba.e.c(baseActivity.getActivity());
        this.bSv.a(this.aRo);
        this.eHu.a(this.eHz);
        this.eHu.setOnTouchListener(this.aOj);
        this.eHx = new q(baseActivity.getPageContext());
        this.eHu.L(this.eHx);
        this.eHx.a(this.eHs);
        this.eHy = new h(baseActivity.getPageContext(), this.eGW, this.eHt, this.eHu.bnp());
    }

    @Override // com.baidu.tieba.model.a
    public void Ol() {
        if (com.baidu.adp.lib.util.i.gY()) {
            if (this.bNh) {
                this.eHu.h(true, this.aaY.getResources().getDimensionPixelSize(w.f.ds480));
                this.eHs.cp(this.mUserId);
            }
            this.eHs.co(this.mUserId);
        } else if (!this.eHs.hasData()) {
            this.eHu.H(TbadkCoreApplication.m9getInst().getString(w.l.neterror), true);
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.eHs.resetData();
    }

    @Override // com.baidu.tieba.model.a
    public boolean RR() {
        return this.eHs.RR();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void a(com.baidu.tieba.personPolymeric.c.n nVar, boolean z) {
        this.eHu.aet();
        this.eHu.KC();
        if (!z) {
            this.eHu.di(!com.baidu.tbadk.core.util.x.q(nVar.aSE()));
        }
        if (nVar == null || com.baidu.tbadk.core.util.x.q(nVar.amU())) {
            this.eHu.H(TbadkCoreApplication.m9getInst().getString(w.l.neterror), true);
            return;
        }
        this.bNh = false;
        if (this.bcY) {
            com.baidu.tbadk.getUserInfo.b.EB().a(nVar.getUserData());
        }
        if (this.eHx != null) {
            this.eHx.b(nVar);
        }
        if (this.eHy != null) {
            this.eHy.a(nVar);
        }
        this.eHu.c(nVar);
        if ((this.eHu.mRootView instanceof RelativeLayout) && !this.bcY) {
            if (this.eHw == null) {
                this.eHw = new af(this.bdG, (RelativeLayout) this.eHu.mRootView, nVar.getUserData());
            } else {
                this.eHw.setData(nVar.getUserData());
            }
        }
    }

    public q aSy() {
        return this.eHx;
    }

    public h aSz() {
        return this.eHy;
    }

    public void onChangeSkinType(int i) {
        if (this.eHu != null) {
            this.eHu.onChangeSkinType(i);
        }
        if (this.eHw != null) {
            this.eHw.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        this.eHx.onDestroy();
        if (this.eHw != null) {
            this.eHw.onDestroy();
        }
        if (this.eHu != null) {
            this.eHu.onDestory();
        }
    }
}
