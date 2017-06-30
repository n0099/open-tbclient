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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ac extends com.baidu.tieba.view.s {
    View.OnClickListener atM;
    private BdUniqueId ayI;
    private PbListView bbP;
    private boolean bhl;
    private int btF;
    private ImageView bzJ;
    private boolean bzn;
    private com.baidu.tieba.personPolymeric.b.i bzt;
    private CustomMessageListener bzu;
    private com.baidu.tieba.personPolymeric.c.a eVl;
    private TextView eYn;
    private TextView eYo;
    private com.baidu.tieba.personPolymeric.a.s eYp;
    private CustomMessageListener eYq;
    private com.baidu.tieba.personCenter.a.a eYr;
    private GridView eYs;
    private p eYt;
    private com.baidu.tieba.person.data.c eYu;
    private v eYv;
    private boolean eYw;

    public ac(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.o oVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        super(tbPageContext);
        this.btF = 0;
        this.eYw = false;
        this.bzn = false;
        this.atM = new ad(this);
        this.ayI = bdUniqueId;
        this.bhl = z;
        this.bzn = z2;
        this.bsi = (int) this.aat.getResources().getDimension(w.f.ds720);
        this.bzt = oVar.aVg();
        this.bbP = this.bzt.bbP;
        if (z) {
            this.gas = new com.baidu.tieba.view.j();
            l(tbPageContext);
            return;
        }
        this.gas = new com.baidu.tieba.view.h();
    }

    @Override // com.baidu.tieba.view.s
    public void initUI() {
        super.initUI();
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.bhl) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.bzJ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.item_person_polymeric_navigation_back, (View.OnClickListener) null);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.item_person_center_navigation_title, (View.OnClickListener) null);
        this.eYn = (TextView) addCustomView.findViewById(w.h.person_center_navigation_title);
        this.eYo = (TextView) addCustomView.findViewById(w.h.person_center_navigation_another_title);
        if (!this.bzn) {
            this.bzJ.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.eUV.setOnSrollToBottomListener(new ae(this));
        this.gau = new w(this.aat, this.bhl);
        this.eUV.addHeaderView(this.gau.Tv());
        this.eUV.setExpandView(this.gau.Tv());
        this.eUV.setPersonListRefreshListener(new af(this));
        this.eYp = new com.baidu.tieba.personPolymeric.a.s(this.aat, this.eUV, this.ayI);
        this.eYp.setIsHost(this.bhl);
        if (this.bhl) {
            this.gaw = LayoutInflater.from(this.aat.getPageActivity()).inflate(w.j.person_center_function_grid_view, (ViewGroup) null);
            this.eYs = (GridView) this.gaw.findViewById(w.h.person_center_function_grid_view);
            this.gax = this.gaw.findViewById(w.h.divider_line);
            this.eYr = new com.baidu.tieba.personCenter.a.a(this.aat.getPageActivity());
            this.eYs.setAdapter((ListAdapter) this.eYr);
            this.eUV.addHeaderView(this.gaw);
            if (!this.bzn) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eUV.getLayoutParams();
                layoutParams.bottomMargin = this.aat.getResources().getDimensionPixelSize(w.f.ds100);
                this.eUV.setLayoutParams(layoutParams);
            }
        } else {
            this.eYt = new p(this.aat.getPageActivity());
            this.eUV.addHeaderView(this.eYt);
        }
        this.eYv = new v(TbadkCoreApplication.m9getInst(), this);
        this.gav = this.eYv.Xe();
        this.eUV.addHeaderView(this.gav);
        this.mNavigationBar.setVisibility(0);
        this.eUV.setVisibility(0);
        this.mWebView.setVisibility(8);
    }

    public void UW() {
        this.eYw = false;
        if (this.btF == 0) {
            if (com.baidu.adp.lib.util.i.hj()) {
                this.gaz.resetData();
                this.gaz.refreshData();
                this.gau.kZ();
                return;
            }
            this.gau.ahs();
        } else if (this.btF == 1) {
            if (com.baidu.adp.lib.util.i.hj()) {
                this.gaz.d(true, true, true);
                this.gau.kZ();
                return;
            }
            this.gau.ahs();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.view.s
    public void aVE() {
        if (this.gaF) {
            this.gay.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
        if (this.mNavigationBar.getY() < 0.0f) {
            this.mNavigationBar.setY(0.0f);
        }
        this.eUW.setVisibility(8);
        this.eYv.oR(this.btF);
        ((RelativeLayout.LayoutParams) this.bbO.getLayoutParams()).addRule(3, w.h.person_center_navigation_bar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.view.s
    public void ahK() {
        if (this.gaF) {
            this.gay.setVisibility(0);
        }
        this.mNavigationBar.setVisibility(4);
        this.eUW.setVisibility(0);
        oR(this.btF);
        ((RelativeLayout.LayoutParams) this.bbO.getLayoutParams()).addRule(3, w.h.person_center_blank_view);
    }

    @Override // com.baidu.tieba.view.s
    public void setOnViewResponseListener(com.baidu.tieba.view.r rVar) {
        super.setOnViewResponseListener(rVar);
        this.bzJ.setOnClickListener(this.atM);
        this.gau.setOnViewResponseListener(rVar);
        if (this.eYr != null) {
            this.eYr.setOnViewResponseListener(rVar);
        }
    }

    public void P(View.OnClickListener onClickListener) {
        if (this.eYp != null) {
            this.eYp.P(onClickListener);
        }
    }

    @Override // com.baidu.tieba.view.s
    protected void a(float f, boolean z) {
        float f2;
        if (z) {
            if (this.bhl) {
                if (this.bzn) {
                    as.b(this.bzJ, w.g.icon_return_bg_s, w.g.icon_return_bg);
                } else {
                    this.eYn.setVisibility(8);
                    this.eYo.setVisibility(0);
                    as.b(this.eYo, w.e.cp_cont_b, w.e.s_navbar_title_color);
                }
            } else {
                as.b(this.bzJ, w.g.icon_return_bg_s, w.g.icon_return_bg);
            }
        } else if (this.bhl) {
            if (this.bzn) {
                as.b(this.bzJ, w.g.btn_sml_back_selector_s, w.g.btn_sml_back_selector_s);
            } else {
                this.eYn.setVisibility(0);
                this.eYo.setVisibility(8);
                as.b(this.eYn, w.e.cp_cont_i, w.e.cp_cont_i);
            }
        } else {
            as.b(this.bzJ, w.g.btn_sml_back_selector_s, w.g.btn_sml_back_selector_s);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.bzJ.setAlpha(f2);
        }
        if (this.bhl) {
            this.eYn.setAlpha(1.0f - f);
            this.eYo.setAlpha(f);
        }
    }

    public void ao(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        cq(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        if (aVar != null) {
            this.mWebView.setVisibility(8);
            this.eVl = aVar;
            if (this.eYw) {
                cq(aVar.aou());
                if (this.bbP != null) {
                    this.bbP.wE();
                    return;
                }
                return;
            }
            this.mNavigationBar.getTopCoverBgView().setVisibility(0);
            this.gas.Vi();
            this.gau.e(aVar);
            if (this.bhl) {
                this.eYr.setData(aVar.aVz());
                this.eYr.notifyDataSetChanged();
            } else if (aVar.aVy() == null || aVar.aVy().eWz == null || aVar.aVy().eWz.size() <= 0) {
                this.eUV.removeHeaderView(this.eYt);
            } else {
                this.eYt.a(aVar.aVy());
            }
            if (com.baidu.tbadk.core.util.z.t(aVar.aou())) {
                cq(null);
                this.bzt.WU();
                com.baidu.adp.lib.util.k.showToast(this.aat.getContext(), this.aat.getString(w.l.data_load_error));
                return;
            }
            com.baidu.tieba.j.a.beN().beS();
            cq(aVar.aou());
            int size = aVar.aou().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.v vVar = aVar.aou().get(i);
                if (vVar != null && ((vVar instanceof com.baidu.tieba.personPolymeric.c.i) || (vVar instanceof com.baidu.tieba.personPolymeric.c.j))) {
                    this.bzt.WU();
                    return;
                }
            }
            if (z) {
                if (this.bbP != null) {
                    this.bbP.wE();
                    return;
                }
                return;
            }
            this.bzt.dD(true);
        }
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.eUV.setOnTouchListener(onTouchListener);
    }

    @Override // com.baidu.tieba.view.s
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        as.k(this.eYs, w.e.cp_bg_line_d);
        as.k(this.gaw, w.e.cp_bg_line_d);
        as.k(this.gax, w.e.cp_bg_line_b);
        if (this.eYr != null) {
            this.eYr.notifyDataSetChanged();
        }
        if (this.eYv != null) {
            this.eYv.onChangeSkinType();
        }
        if (2 == i) {
            as.b(this.bzJ, w.g.icon_return_bg_s, w.g.icon_return_bg);
        } else {
            if (com.baidu.adp.lib.util.i.hj()) {
                as.b(this.bzJ, w.g.btn_sml_back_selector_s, w.g.btn_sml_back_selector_s);
            } else {
                as.b(this.bzJ, w.g.icon_return_bg_s, w.g.icon_return_bg);
            }
            this.bbP.dl(i);
            as.j(this.mRootView, w.e.cp_bg_line_d);
        }
        if (this.bhl) {
            as.b(this.eYo, w.e.cp_cont_b, w.e.s_navbar_title_color);
            as.b(this.eYn, w.e.cp_cont_i, w.e.cp_cont_i);
        }
    }

    public void ahs() {
        ((w) this.gau).ahs();
    }

    private void l(TbPageContext tbPageContext) {
        this.bzu = new ag(this, CmdConfigCustom.CMD_PERSON_RED_TIP);
        this.bzu.setTag(this.ayI);
        tbPageContext.registerListener(this.bzu);
        this.eYq = new ah(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
        this.eYq.setTag(this.ayI);
        tbPageContext.registerListener(this.eYq);
    }

    public void onDestory() {
        if (this.gau != null) {
            this.gau.onDestory();
        }
        if (this.eUW != null) {
            this.eUW.setVisibility(8);
        }
    }

    public void pR(int i) {
        this.eYw = false;
        int i2 = i == 0 ? 1 : 0;
        this.gaz.a(i2, this.gaz.hh(i2));
        this.eYu = this.gaz.hh(i);
        if (this.eYu.aTX() == null) {
            this.eYw = true;
            if (i == 0) {
                this.gaz.OZ();
                return;
            } else if (i == 1) {
                this.gaz.d(true, true, false);
                return;
            } else {
                return;
            }
        }
        cq(this.eYu.aTX());
        if (this.eYu.aTX().size() <= 1 && this.eUW.getVisibility() == 0) {
            this.eUV.smoothScrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.view.s
    public void pS(int i) {
        if (i != this.btF && this.gaz != null) {
            this.btF = i;
            pR(i);
        }
    }

    public com.baidu.tieba.view.q aVF() {
        return this.gas;
    }
}
