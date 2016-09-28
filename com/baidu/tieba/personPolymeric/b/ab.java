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
    private TbPageContext Gd;
    private BaseActivity aRd;
    private com.baidu.tieba.d.c bPA;
    private boolean cuB;
    private com.baidu.tieba.personPolymeric.mode.c eJM;
    private BlackListModel eJN;
    private com.baidu.tieba.personPolymeric.d.x eJO;
    private com.baidu.tieba.personPolymeric.event.b eJP;
    private af eJQ;
    private q eJR;
    private h eJS;
    private a eJr;
    private long mUserId;
    private boolean bNp = true;
    private final com.baidu.tieba.view.v eJT = new ac(this);
    public View.OnTouchListener aJD = new ad(this);
    private a.InterfaceC0058a aMy = new ae(this);

    public ab(BaseActivity baseActivity, long j, boolean z) {
        this.aRd = baseActivity;
        this.Gd = baseActivity.getPageContext();
        this.mUserId = j;
        this.cuB = z;
        this.eJM = new com.baidu.tieba.personPolymeric.mode.c(baseActivity, z);
        this.eJM.a(this);
        this.eJr = new a(baseActivity.getPageContext());
        this.eJM.a(this.eJr);
        this.eJN = new BlackListModel(baseActivity.getPageContext());
        this.eJO = new com.baidu.tieba.personPolymeric.d.x(baseActivity.getPageContext(), z);
        baseActivity.setContentView(this.eJO.onCreateView(LayoutInflater.from(baseActivity.getActivity()), null, null));
        this.eJO.initUI();
        this.eJP = new com.baidu.tieba.personPolymeric.event.b(baseActivity.getPageContext());
        this.eJP.c(this);
        this.eJO.setOnViewResponseListener(this.eJP);
        this.eJO.a(this);
        this.bPA = new com.baidu.tieba.d.c(baseActivity.getActivity());
        this.bPA.a(this.aMy);
        this.eJO.a(this.eJT);
        this.eJO.setOnTouchListener(this.aJD);
        this.eJR = new q(baseActivity.getPageContext());
        this.eJO.L(this.eJR);
        this.eJR.a(this.eJM);
        this.eJS = new h(baseActivity.getPageContext(), this.eJr, this.eJN, this.eJO.bqU());
    }

    @Override // com.baidu.tieba.model.a
    public void RL() {
        if (com.baidu.adp.lib.util.i.fZ()) {
            if (this.bNp) {
                this.eJO.j(true, this.Gd.getResources().getDimensionPixelSize(r.e.ds480));
                this.eJM.cJ(this.mUserId);
            }
            this.eJM.cI(this.mUserId);
        } else if (!this.eJM.hasData()) {
            this.eJO.G(TbadkCoreApplication.m9getInst().getString(r.j.neterror), true);
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.eJM.resetData();
    }

    @Override // com.baidu.tieba.model.a
    public boolean hasMoreData() {
        return this.eJM.hasMoreData();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void a(com.baidu.tieba.personPolymeric.c.n nVar, boolean z) {
        this.eJO.afo();
        this.eJO.JE();
        if (!z) {
            this.eJO.iV(!com.baidu.tbadk.core.util.y.t(nVar.aUc()));
        }
        if (nVar == null || com.baidu.tbadk.core.util.y.t(nVar.aph())) {
            this.eJO.G(TbadkCoreApplication.m9getInst().getString(r.j.neterror), true);
            return;
        }
        this.bNp = false;
        if (this.cuB) {
            com.baidu.tbadk.getUserInfo.b.Ec().a(nVar.getUserData());
        }
        if (this.eJR != null) {
            this.eJR.b(nVar);
        }
        if (this.eJS != null) {
            this.eJS.a(nVar);
        }
        this.eJO.c(nVar);
        if ((this.eJO.mRootView instanceof RelativeLayout) && !this.cuB) {
            if (this.eJQ == null) {
                this.eJQ = new af(this.aRd, (RelativeLayout) this.eJO.mRootView, nVar.getUserData());
            } else {
                this.eJQ.setData(nVar.getUserData());
            }
        }
    }

    public q aTW() {
        return this.eJR;
    }

    public h aTX() {
        return this.eJS;
    }

    public void onChangeSkinType(int i) {
        if (this.eJO != null) {
            this.eJO.onChangeSkinType(i);
        }
        if (this.eJQ != null) {
            this.eJQ.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        this.eJR.onDestroy();
        if (this.eJQ != null) {
            this.eJQ.onDestroy();
        }
    }
}
