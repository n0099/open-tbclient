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
    private TbPageContext aaI;
    private com.baidu.tieba.e.c bQp;
    private BaseActivity bcF;
    private boolean bch;
    private a eGK;
    private PersonPolymericModel eHg;
    private BlackListModel eHh;
    private com.baidu.tieba.personPolymeric.d.z eHi;
    private com.baidu.tieba.personPolymeric.event.b eHj;
    private af eHk;
    private q eHl;
    private h eHm;
    private long mUserId;
    private boolean bKX = true;
    private final com.baidu.tieba.view.v eHn = new ac(this);
    public View.OnTouchListener aNR = new ad(this);
    private a.InterfaceC0056a aQW = new ae(this);

    public ab(BaseActivity baseActivity, long j, boolean z) {
        this.bcF = baseActivity;
        this.aaI = baseActivity.getPageContext();
        this.mUserId = j;
        this.bch = z;
        this.eHg = new PersonPolymericModel(baseActivity, z);
        this.eHg.a(this);
        this.eGK = new a(baseActivity.getPageContext());
        this.eHg.a(this.eGK);
        this.eHh = new BlackListModel(baseActivity.getPageContext());
        this.eHi = new com.baidu.tieba.personPolymeric.d.z(baseActivity.getPageContext(), z);
        baseActivity.setContentView(this.eHi.onCreateView(LayoutInflater.from(baseActivity.getActivity()), null, null));
        this.eHi.initUI();
        this.eHj = new com.baidu.tieba.personPolymeric.event.b(baseActivity.getPageContext());
        this.eHj.c(this);
        this.eHi.setOnViewResponseListener(this.eHj);
        this.eHi.a(this);
        this.bQp = new com.baidu.tieba.e.c(baseActivity.getActivity());
        this.bQp.a(this.aQW);
        this.eHi.a(this.eHn);
        this.eHi.setOnTouchListener(this.aNR);
        this.eHl = new q(baseActivity.getPageContext());
        this.eHi.K(this.eHl);
        this.eHl.a(this.eHg);
        this.eHm = new h(baseActivity.getPageContext(), this.eGK, this.eHh, this.eHi.blE());
    }

    @Override // com.baidu.tieba.model.a
    public void NE() {
        if (com.baidu.adp.lib.util.i.gS()) {
            if (this.bKX) {
                this.eHi.g(true, this.aaI.getResources().getDimensionPixelSize(w.f.ds480));
                this.eHg.cp(this.mUserId);
            }
            this.eHg.co(this.mUserId);
        } else if (!this.eHg.hasData()) {
            this.eHi.H(TbadkCoreApplication.m9getInst().getString(w.l.neterror), true);
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.eHg.resetData();
    }

    @Override // com.baidu.tieba.model.a
    public boolean Qr() {
        return this.eHg.Qr();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void a(com.baidu.tieba.personPolymeric.c.n nVar, boolean z) {
        this.eHi.ady();
        this.eHi.Kc();
        if (!z) {
            this.eHi.cW(!com.baidu.tbadk.core.util.x.q(nVar.aRu()));
        }
        if (nVar == null || com.baidu.tbadk.core.util.x.q(nVar.alZ())) {
            this.eHi.H(TbadkCoreApplication.m9getInst().getString(w.l.neterror), true);
            return;
        }
        this.bKX = false;
        if (this.bch) {
            com.baidu.tbadk.getUserInfo.b.Ed().a(nVar.getUserData());
        }
        if (this.eHl != null) {
            this.eHl.b(nVar);
        }
        if (this.eHm != null) {
            this.eHm.a(nVar);
        }
        this.eHi.c(nVar);
        if ((this.eHi.mRootView instanceof RelativeLayout) && !this.bch) {
            if (this.eHk == null) {
                this.eHk = new af(this.bcF, (RelativeLayout) this.eHi.mRootView, nVar.getUserData());
            } else {
                this.eHk.setData(nVar.getUserData());
            }
        }
    }

    public q aRo() {
        return this.eHl;
    }

    public h aRp() {
        return this.eHm;
    }

    public void onChangeSkinType(int i) {
        if (this.eHi != null) {
            this.eHi.onChangeSkinType(i);
        }
        if (this.eHk != null) {
            this.eHk.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        this.eHl.onDestroy();
        if (this.eHk != null) {
            this.eHk.onDestroy();
        }
        if (this.eHi != null) {
            this.eHi.onDestory();
        }
    }
}
