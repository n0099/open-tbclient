package com.baidu.tieba.personPolymeric.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ab extends com.baidu.tieba.view.q {
    private PbListView aSj;
    View.OnClickListener asZ;
    private BdUniqueId axU;
    private ImageView bAU;
    private boolean bdp;
    private int boM;
    private com.baidu.tieba.personPolymeric.c.n eCp;
    private TextView eFm;
    private TextView eFn;
    private com.baidu.tieba.personPolymeric.a.s eFo;
    private CustomMessageListener eFp;
    private CustomMessageListener eFq;
    private com.baidu.tieba.personCenter.a.a eFr;
    private GridView eFs;
    private p eFt;
    private com.baidu.tieba.person.data.c eFu;
    private v eFv;
    private boolean eFw;
    private boolean eyr;

    public ab(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        super(tbPageContext);
        this.boM = 0;
        this.eFw = false;
        this.eyr = false;
        this.asZ = new ac(this);
        this.axU = bdUniqueId;
        this.bdp = z;
        this.eyr = z2;
        this.bnl = (int) this.aat.getResources().getDimension(w.f.ds720);
        if (z) {
            this.fII = new com.baidu.tieba.view.j();
            A(tbPageContext);
            return;
        }
        this.fII = new com.baidu.tieba.view.h();
    }

    public void aQe() {
        this.fIL.setVisibility(8);
        if (this.fIP != null) {
            this.fIP.setVisibility(8);
        }
        this.mNavigationBar.setRegisterClickListener(new ad(this));
        this.mNavigationBar.setLoginClickListener(new ae(this));
        this.mNavigationBar.showBottomLine(true);
        int dimensionPixelSize = this.aat.getResources().getDimensionPixelSize(w.f.ds320);
        int dimensionPixelSize2 = this.aat.getResources().getDimensionPixelSize(w.f.ds480);
        int dimensionPixelSize3 = this.aat.getResources().getDimensionPixelSize(w.f.ds360);
        int dimensionPixelSize4 = this.aat.getResources().getDimensionPixelSize(w.f.ds60);
        int dimensionPixelSize5 = this.aat.getResources().getDimensionPixelSize(w.f.ds20);
        this.mNoDataView = NoDataViewFactory.a(this.aat.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, w.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.B(w.l.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.aat.getString(w.l.unlogin_person_button_text), new af(this)), dimensionPixelSize5));
        this.mNoDataView.setVisibility(0);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tieba.view.q
    public void initUI() {
        super.initUI();
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.bdp) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.bAU = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.item_person_polymeric_navigation_back, (View.OnClickListener) null);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.item_person_center_navigation_title, (View.OnClickListener) null);
        this.eFm = (TextView) addCustomView.findViewById(w.h.person_center_navigation_title);
        this.eFn = (TextView) addCustomView.findViewById(w.h.person_center_navigation_another_title);
        if (!this.eyr) {
            this.bAU.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.aSj = new PbListView(this.aat.getPageActivity());
        this.aSj.le();
        this.aSj.setTextColor(aq.getColor(w.e.cp_cont_d));
        this.aSj.dh(w.e.cp_bg_line_c);
        this.fIL.setNextPage(this.aSj);
        this.fIL.setOnSrollToBottomListener(new ag(this));
        this.fIK = new w(this.aat.getPageActivity(), this.bdp);
        this.fIL.addHeaderView(this.fIK.Ru());
        this.fIL.e(this.fIK.Ru(), this.aat.getResources().getDimensionPixelSize(w.f.ds568));
        this.fIL.setPersonListRefreshListener(new ah(this));
        this.eFo = new com.baidu.tieba.personPolymeric.a.s(this.aat, this.fIL, this.axU);
        this.eFo.setIsHost(this.bdp);
        if (this.bdp) {
            this.fIN = LayoutInflater.from(this.aat.getPageActivity()).inflate(w.j.person_center_function_grid_view, (ViewGroup) null);
            this.eFs = (GridView) this.fIN.findViewById(w.h.person_center_function_grid_view);
            this.fIO = this.fIN.findViewById(w.h.divider_line);
            this.eFr = new com.baidu.tieba.personCenter.a.a(this.aat.getPageActivity());
            this.eFs.setAdapter((ListAdapter) this.eFr);
            this.fIL.addHeaderView(this.fIN);
            if (!this.eyr) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fIL.getLayoutParams();
                layoutParams.bottomMargin = this.aat.getResources().getDimensionPixelSize(w.f.ds100);
                this.fIL.setLayoutParams(layoutParams);
            }
        } else {
            this.eFt = new p(this.aat.getPageActivity());
            this.fIL.addHeaderView(this.eFt);
        }
        this.eFv = new v(TbadkCoreApplication.m9getInst(), this);
        this.fIM = this.eFv.UK();
        this.fIL.addHeaderView(this.fIM);
    }

    public void aPQ() {
        this.eFw = false;
        if (this.boM == 0) {
            if (com.baidu.adp.lib.util.i.hk()) {
                this.fIR.resetData();
                this.fIR.NA();
                ((w) this.fIK).lb();
                return;
            }
            ((w) this.fIK).acw();
        } else if (this.boM == 1) {
            if (com.baidu.adp.lib.util.i.hk()) {
                this.fIR.g(true, true, true);
                ((w) this.fIK).lb();
                return;
            }
            ((w) this.fIK).acw();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.view.q
    public void aQf() {
        if (this.fIX) {
            this.fIQ.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
        if (this.mNavigationBar.getY() < 0.0f) {
            this.mNavigationBar.setY(0.0f);
        }
        this.fIP.setVisibility(8);
        this.eFv.oh(this.boM);
        ((RelativeLayout.LayoutParams) this.aSi.getLayoutParams()).addRule(3, w.h.person_center_navigation_bar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.view.q
    public void acT() {
        if (this.fIX) {
            this.fIQ.setVisibility(0);
        }
        this.mNavigationBar.setVisibility(4);
        this.fIP.setVisibility(0);
        oh(this.boM);
        ((RelativeLayout.LayoutParams) this.aSi.getLayoutParams()).addRule(3, w.h.person_center_blank_view);
    }

    @Override // com.baidu.tieba.view.q
    public void setOnViewResponseListener(com.baidu.tieba.view.p pVar) {
        super.setOnViewResponseListener(pVar);
        this.bAU.setOnClickListener(this.asZ);
        this.fIK.setOnViewResponseListener(pVar);
        if (this.eFr != null) {
            this.eFr.setOnViewResponseListener(pVar);
        }
    }

    public void M(View.OnClickListener onClickListener) {
        if (this.eFo != null) {
            this.eFo.M(onClickListener);
        }
    }

    @Override // com.baidu.tieba.view.q
    protected void a(float f, boolean z) {
        float f2;
        if (z) {
            if (this.bdp) {
                this.eFm.setVisibility(8);
                this.eFn.setVisibility(0);
                aq.b(this.eFn, w.e.cp_cont_b, w.e.s_navbar_title_color);
            } else {
                aq.b(this.bAU, w.g.icon_return_bg_s, w.g.icon_return_bg);
            }
        } else if (this.bdp) {
            this.eFm.setVisibility(0);
            this.eFn.setVisibility(8);
            aq.b(this.eFm, w.e.cp_cont_i, w.e.cp_cont_i);
        } else {
            aq.b(this.bAU, w.g.btn_sml_back_selector_s, w.g.btn_sml_back_selector_s);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.bAU.setAlpha(f2);
        }
        if (this.bdp) {
            this.eFm.setAlpha(1.0f - f);
            this.eFn.setAlpha(f);
        }
    }

    public void an(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        cK(arrayList);
    }

    public void wo() {
        if (this.aSj != null) {
            this.aSj.wo();
        }
    }

    public void wp() {
        if (this.aSj != null) {
            this.aSj.wp();
        }
    }

    public void b(com.baidu.tieba.personPolymeric.c.n nVar, boolean z) {
        if (nVar != null) {
            this.eCp = nVar;
            if (this.eFw) {
                cK(nVar.ajJ());
                if (this.aSj != null) {
                    this.aSj.wp();
                    return;
                }
                return;
            }
            this.mNavigationBar.getTopCoverBgView().setVisibility(0);
            this.fII.bkU();
            this.fIK.d(nVar.getUserData());
            if (this.bdp) {
                this.eFr.setData(nVar.aPW());
                this.eFr.notifyDataSetChanged();
            } else if (nVar.aPV() == null || nVar.aPV().eDd == null || nVar.aPV().eDd.size() <= 0) {
                this.fIL.removeHeaderView(this.eFt);
            } else {
                this.eFt.a(nVar.aPV());
            }
            if (com.baidu.tbadk.core.util.x.r(nVar.ajJ())) {
                cK(null);
                UA();
                com.baidu.adp.lib.util.k.showToast(this.aat.getContext(), this.aat.getString(w.l.data_load_error));
                return;
            }
            com.baidu.tieba.h.a.aZj().aZo();
            cK(nVar.ajJ());
            int size = nVar.ajJ().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.v vVar = nVar.ajJ().get(i);
                if (vVar != null && ((vVar instanceof com.baidu.tieba.personPolymeric.c.h) || (vVar instanceof com.baidu.tieba.personPolymeric.c.i))) {
                    UA();
                    return;
                }
            }
            if (z) {
                if (this.aSj != null) {
                    this.aSj.wp();
                    return;
                }
                return;
            }
            dk(true);
        }
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fIL.setOnTouchListener(onTouchListener);
    }

    @Override // com.baidu.tieba.view.q
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aat, i);
        }
        aq.k(this.eFs, w.e.cp_bg_line_d);
        aq.k(this.fIN, w.e.cp_bg_line_d);
        aq.k(this.fIO, w.e.cp_bg_line_b);
        if (this.eFr != null) {
            this.eFr.notifyDataSetChanged();
        }
        if (this.eFv != null) {
            this.eFv.onChangeSkinType();
        }
        if (2 == i) {
            aq.b(this.bAU, w.g.icon_return_bg_s, w.g.icon_return_bg);
        } else {
            if (com.baidu.adp.lib.util.i.hk()) {
                aq.b(this.bAU, w.g.btn_sml_back_selector_s, w.g.btn_sml_back_selector_s);
            } else {
                aq.b(this.bAU, w.g.icon_return_bg_s, w.g.icon_return_bg);
            }
            this.aSj.di(i);
            aq.j(this.mRootView, w.e.cp_bg_line_d);
        }
        if (this.bdp) {
            aq.b(this.eFn, w.e.cp_cont_b, w.e.s_navbar_title_color);
            aq.b(this.eFm, w.e.cp_cont_i, w.e.cp_cont_i);
        }
    }

    public void acw() {
        ((w) this.fIK).acw();
    }

    public void dk(boolean z) {
        if (this.fIL != null && this.aSj != null) {
            this.aSj.wp();
            if (z) {
                this.aSj.setText(this.aat.getString(w.l.list_no_more));
            } else {
                this.aSj.setText("");
            }
        }
    }

    public void UA() {
        if (this.fIL != null && this.aSj != null) {
            this.fIL.setNextPage(null);
            this.aSj.ws();
        }
    }

    private void A(TbPageContext tbPageContext) {
        this.eFp = new ai(this, CmdConfigCustom.CMD_PERSON_RED_TIP);
        this.eFp.setTag(this.axU);
        tbPageContext.registerListener(this.eFp);
        this.eFq = new aj(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
        this.eFq.setTag(this.axU);
        tbPageContext.registerListener(this.eFq);
    }

    public void onDestory() {
        if (this.fIK != null) {
            this.fIK.onDestory();
        }
        if (this.fIP != null) {
            this.fIP.setVisibility(8);
        }
    }

    public void oZ(int i) {
        this.eFw = false;
        int i2 = i == 0 ? 1 : 0;
        this.fIR.a(i2, this.fIR.nu(i2));
        this.eFu = this.fIR.nu(i);
        if (this.eFu.aOG() == null) {
            this.eFw = true;
            if (i == 0) {
                this.fIR.NA();
                return;
            } else if (i == 1) {
                this.fIR.g(true, true, false);
                return;
            } else {
                return;
            }
        }
        cK(this.eFu.aOG());
        if (this.eFu.aOG().size() <= 1 && this.fIP.getVisibility() == 0) {
            this.fIL.smoothScrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.view.q
    public void pa(int i) {
        if (i != this.boM && this.fIR != null) {
            this.boM = i;
            oZ(i);
        }
    }

    public com.baidu.tieba.view.z aQg() {
        return this.fII;
    }
}
