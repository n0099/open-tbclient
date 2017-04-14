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
    private TbPageContext aaX;
    private com.baidu.tieba.e.c bQe;
    private boolean bca;
    private BaseActivity bcy;
    private a eEG;
    private PersonPolymericModel eFc;
    private BlackListModel eFd;
    private com.baidu.tieba.personPolymeric.d.z eFe;
    private com.baidu.tieba.personPolymeric.event.b eFf;
    private af eFg;
    private q eFh;
    private h eFi;
    private long mUserId;
    private boolean bKQ = true;
    private final com.baidu.tieba.view.v eFj = new ac(this);
    public View.OnTouchListener aOh = new ad(this);
    private a.InterfaceC0055a aRm = new ae(this);

    public ab(BaseActivity baseActivity, long j, boolean z) {
        this.bcy = baseActivity;
        this.aaX = baseActivity.getPageContext();
        this.mUserId = j;
        this.bca = z;
        this.eFc = new PersonPolymericModel(baseActivity, z);
        this.eFc.a(this);
        this.eEG = new a(baseActivity.getPageContext());
        this.eFc.a(this.eEG);
        this.eFd = new BlackListModel(baseActivity.getPageContext());
        this.eFe = new com.baidu.tieba.personPolymeric.d.z(baseActivity.getPageContext(), z);
        baseActivity.setContentView(this.eFe.onCreateView(LayoutInflater.from(baseActivity.getActivity()), null, null));
        this.eFe.initUI();
        this.eFf = new com.baidu.tieba.personPolymeric.event.b(baseActivity.getPageContext());
        this.eFf.c(this);
        this.eFe.setOnViewResponseListener(this.eFf);
        this.eFe.a(this);
        this.bQe = new com.baidu.tieba.e.c(baseActivity.getActivity());
        this.bQe.a(this.aRm);
        this.eFe.a(this.eFj);
        this.eFe.setOnTouchListener(this.aOh);
        this.eFh = new q(baseActivity.getPageContext());
        this.eFe.L(this.eFh);
        this.eFh.a(this.eFc);
        this.eFi = new h(baseActivity.getPageContext(), this.eEG, this.eFd, this.eFe.bmo());
    }

    @Override // com.baidu.tieba.model.a
    public void Oc() {
        if (com.baidu.adp.lib.util.i.gX()) {
            if (this.bKQ) {
                this.eFe.g(true, this.aaX.getResources().getDimensionPixelSize(w.f.ds480));
                this.eFc.cp(this.mUserId);
            }
            this.eFc.co(this.mUserId);
        } else if (!this.eFc.hasData()) {
            this.eFe.H(TbadkCoreApplication.m9getInst().getString(w.l.neterror), true);
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.eFc.resetData();
    }

    @Override // com.baidu.tieba.model.a
    public boolean QP() {
        return this.eFc.QP();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void a(com.baidu.tieba.personPolymeric.c.n nVar, boolean z) {
        this.eFe.ads();
        this.eFe.KC();
        if (!z) {
            this.eFe.cY(!com.baidu.tbadk.core.util.x.q(nVar.aRD()));
        }
        if (nVar == null || com.baidu.tbadk.core.util.x.q(nVar.alT())) {
            this.eFe.H(TbadkCoreApplication.m9getInst().getString(w.l.neterror), true);
            return;
        }
        this.bKQ = false;
        if (this.bca) {
            com.baidu.tbadk.getUserInfo.b.EB().a(nVar.getUserData());
        }
        if (this.eFh != null) {
            this.eFh.b(nVar);
        }
        if (this.eFi != null) {
            this.eFi.a(nVar);
        }
        this.eFe.c(nVar);
        if ((this.eFe.mRootView instanceof RelativeLayout) && !this.bca) {
            if (this.eFg == null) {
                this.eFg = new af(this.bcy, (RelativeLayout) this.eFe.mRootView, nVar.getUserData());
            } else {
                this.eFg.setData(nVar.getUserData());
            }
        }
    }

    public q aRx() {
        return this.eFh;
    }

    public h aRy() {
        return this.eFi;
    }

    public void onChangeSkinType(int i) {
        if (this.eFe != null) {
            this.eFe.onChangeSkinType(i);
        }
        if (this.eFg != null) {
            this.eFg.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        this.eFh.onDestroy();
        if (this.eFg != null) {
            this.eFg.onDestroy();
        }
        if (this.eFe != null) {
            this.eFe.onDestory();
        }
    }
}
