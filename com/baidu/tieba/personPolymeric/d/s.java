package com.baidu.tieba.personPolymeric.d;

import android.util.SparseArray;
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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.d;
import com.baidu.tieba.j.b;
import com.baidu.tieba.person.listview.BdPersonListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class s extends com.baidu.tieba.view.h {
    private BdUniqueId aAj;
    View.OnClickListener avg;
    private int bBs;
    private boolean bIY;
    private com.baidu.tieba.personPolymeric.b.c bJe;
    private CustomMessageListener bJf;
    private ImageView bJv;
    private PbListView ben;
    private boolean bmn;
    private com.baidu.tieba.personPolymeric.c.a fkg;
    private com.baidu.tieba.person.data.c fnA;
    private p fnB;
    private boolean fnC;
    private TextView fns;
    private TextView fnt;
    private com.baidu.tieba.personPolymeric.a.n fnu;
    private CustomMessageListener fnv;
    private com.baidu.tieba.personCenter.a.a fnw;
    private GridView fnx;
    private l fny;
    private e fnz;

    public s(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.d dVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        super(tbPageContext);
        this.bBs = 0;
        this.fnC = false;
        this.bIY = false;
        this.avg = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.d.s.3
            com.baidu.tieba.personPolymeric.event.a fno = new com.baidu.tieba.personPolymeric.event.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.ffP != null) {
                    if (s.this.bJv == view) {
                        this.fno.ceT = 8;
                    }
                    s.this.ffP.a(view, this.fno);
                }
            }
        };
        this.aAj = bdUniqueId;
        this.bmn = z;
        this.bIY = z2;
        this.bzU = (int) this.aby.getResources().getDimension(d.f.ds720);
        this.bJe = dVar.aYl();
        this.ben = this.bJe.ben;
        if (z) {
            this.gxi = new com.baidu.tieba.view.d();
            l(tbPageContext);
            return;
        }
        this.gxi = new com.baidu.tieba.view.c();
    }

    @Override // com.baidu.tieba.view.h
    public void initUI() {
        super.initUI();
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.bmn) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.bJv = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.item_person_polymeric_navigation_back, (View.OnClickListener) null);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.item_person_center_navigation_title, (View.OnClickListener) null);
        this.fns = (TextView) addCustomView.findViewById(d.h.person_center_navigation_title);
        this.fnt = (TextView) addCustomView.findViewById(d.h.person_center_navigation_another_title);
        if (!this.bIY) {
            this.bJv.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.fjP.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.d.s.1
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (s.this.ben != null && s.this.gxp != null) {
                    if (s.this.bBs == 0) {
                        s.this.ben.wV();
                        s.this.gxp.g(false, false, false);
                    } else if (s.this.bBs == 1) {
                        s.this.ben.wV();
                        s.this.gxp.g(true, false, false);
                    }
                }
            }
        });
        this.gxk = new q(this.aby, this.bmn);
        this.fjP.addHeaderView(this.gxk.VB());
        this.fjP.setExpandView(this.gxk.VB());
        this.fjP.setPersonListRefreshListener(new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.d.s.2
            @Override // com.baidu.tieba.person.listview.BdPersonListView.a
            public void la() {
                s.this.Xq();
            }

            @Override // com.baidu.tieba.person.listview.BdPersonListView.a
            public void kZ() {
                s.this.gxk.aly();
            }

            @Override // com.baidu.tieba.person.listview.BdPersonListView.a
            public void v(float f) {
                s.this.gxk.u(f);
            }
        });
        this.fnu = new com.baidu.tieba.personPolymeric.a.n(this.aby, this.fjP, this.aAj);
        this.fnu.setIsHost(this.bmn);
        if (this.bmn) {
            this.gxl = LayoutInflater.from(this.aby.getPageActivity()).inflate(d.j.person_center_function_grid_view, (ViewGroup) null);
            this.fnx = (GridView) this.gxl.findViewById(d.h.person_center_function_grid_view);
            this.gxn = this.gxl.findViewById(d.h.divider_line);
            this.fnw = new com.baidu.tieba.personCenter.a.a(this.aby.getPageActivity());
            this.fnx.setAdapter((ListAdapter) this.fnw);
            this.fjP.addHeaderView(this.gxl);
            if (!this.bIY) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fjP.getLayoutParams();
                layoutParams.bottomMargin = this.aby.getResources().getDimensionPixelSize(d.f.ds100);
                this.fjP.setLayoutParams(layoutParams);
            }
        } else {
            this.gxm = new k(this.aby.getPageActivity());
            this.fjP.addHeaderView(this.gxm);
            this.fny = new l(this.aby.getPageActivity());
            this.fjP.addHeaderView(this.fny);
            this.fnz = new e(this.aby);
            this.fjP.addHeaderView(this.fnz.getView());
        }
        this.fnB = new p(TbadkCoreApplication.getInst(), this);
        this.gex = this.fnB.Zx();
        this.fjP.addHeaderView(this.gex);
        this.mNavigationBar.setVisibility(0);
        this.fjP.setVisibility(0);
        this.bZC.setVisibility(8);
    }

    public void Xq() {
        this.fnC = false;
        if (this.bBs == 0) {
            if (com.baidu.adp.lib.util.i.hi()) {
                this.gxp.resetData();
                this.gxp.refreshData();
                this.gxk.kY();
                return;
            }
            this.gxk.aly();
        } else if (this.bBs == 1) {
            if (com.baidu.adp.lib.util.i.hi()) {
                this.gxp.g(true, true, true);
                this.gxk.kY();
                return;
            }
            this.gxk.aly();
        }
    }

    @Override // com.baidu.tieba.view.h
    protected void aYJ() {
        if (this.gxv) {
            this.gxo.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
        if (this.mNavigationBar.getY() < 0.0f) {
            this.mNavigationBar.setY(0.0f);
        }
        this.fjQ.setVisibility(8);
        this.fnB.pt(this.bBs);
        ((RelativeLayout.LayoutParams) this.bem.getLayoutParams()).addRule(3, d.h.person_center_navigation_bar);
    }

    @Override // com.baidu.tieba.view.h
    protected void alP() {
        if (this.gxv) {
            this.gxo.setVisibility(0);
        }
        this.mNavigationBar.setVisibility(4);
        this.fjQ.setVisibility(0);
        pt(this.bBs);
        ((RelativeLayout.LayoutParams) this.bem.getLayoutParams()).addRule(3, d.h.person_center_blank_view);
    }

    @Override // com.baidu.tieba.view.h
    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        super.setOnViewResponseListener(gVar);
        this.bJv.setOnClickListener(this.avg);
        this.gxk.setOnViewResponseListener(gVar);
        if (this.fnw != null) {
            this.fnw.setOnViewResponseListener(gVar);
        }
        if (this.gxm != null) {
            this.gxm.setOnViewResponseListener(gVar);
        }
    }

    public void H(View.OnClickListener onClickListener) {
        if (this.fnu != null) {
            this.fnu.H(onClickListener);
        }
    }

    @Override // com.baidu.tieba.view.h
    protected void a(float f, boolean z) {
        float f2;
        if (z) {
            if (this.bmn) {
                if (this.bIY) {
                    aj.a(this.bJv, d.g.icon_return_bg_s, d.g.icon_return_bg);
                } else {
                    this.fns.setVisibility(8);
                    this.fnt.setVisibility(0);
                    aj.b(this.fnt, d.e.cp_cont_b, d.e.s_navbar_title_color);
                }
            } else {
                aj.a(this.bJv, d.g.icon_return_bg_s, d.g.icon_return_bg);
            }
        } else if (this.bmn) {
            if (this.bIY) {
                aj.a(this.bJv, d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
            } else {
                this.fns.setVisibility(0);
                this.fnt.setVisibility(8);
                aj.b(this.fns, d.e.cp_cont_i, d.e.cp_cont_i);
            }
        } else {
            aj.a(this.bJv, d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.bJv.setAlpha(f2);
        }
        if (this.bmn) {
            this.fns.setAlpha(1.0f - f);
            this.fnt.setAlpha(f);
        }
    }

    public void an(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        cI(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        if (aVar != null) {
            this.bZC.setVisibility(8);
            this.fkg = aVar;
            if (this.fnC) {
                cI(aVar.asI());
                if (this.ben != null) {
                    this.ben.wW();
                    return;
                }
                return;
            }
            this.mNavigationBar.getTopCoverBgView().setVisibility(0);
            this.gxi.XB();
            this.gxk.e(aVar);
            if (this.bmn) {
                this.fnw.setData(aVar.aYE());
                this.fnw.notifyDataSetChanged();
            } else {
                if (this.gxm != null && aVar.getUserData() != null) {
                    this.gxm.setUserData(aVar.getUserData());
                }
                if (aVar.aYC() == null || aVar.aYC().flv == null || aVar.aYC().flv.size() <= 0) {
                    this.fjP.removeHeaderView(this.fny);
                } else {
                    this.fny.a(aVar.aYC());
                }
                if (aVar.aYD() == null || v.v(aVar.aYD().flD)) {
                    this.fjP.removeHeaderView(this.fnz.getView());
                } else {
                    this.fnz.a(aVar.aYD());
                }
            }
            if (v.v(aVar.asI())) {
                cI(null);
                this.bJe.Zn();
                com.baidu.adp.lib.util.k.showToast(this.aby.getContext(), this.aby.getString(d.l.data_load_error));
                return;
            }
            com.baidu.tieba.j.a.bij().lQ(this.bmn);
            cI(aVar.asI());
            int size = aVar.asI().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.f fVar = aVar.asI().get(i);
                if (fVar != null && ((fVar instanceof com.baidu.tieba.personPolymeric.c.i) || (fVar instanceof com.baidu.tieba.personPolymeric.c.j))) {
                    this.bJe.Zn();
                    return;
                }
            }
            if (z) {
                if (this.ben != null) {
                    this.ben.wW();
                    return;
                }
                return;
            }
            this.bJe.dR(true);
        }
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fjP.setOnTouchListener(onTouchListener);
    }

    @Override // com.baidu.tieba.view.h
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.k(this.fnx, d.e.cp_bg_line_d);
        aj.k(this.gxl, d.e.cp_bg_line_d);
        aj.k(this.gxn, d.e.cp_bg_line_b);
        if (this.fnw != null) {
            this.fnw.notifyDataSetChanged();
        }
        if (this.fnB != null) {
            this.fnB.onChangeSkinType();
        }
        if (2 == i) {
            aj.a(this.bJv, d.g.icon_return_bg_s, d.g.icon_return_bg);
        } else {
            if (com.baidu.adp.lib.util.i.hi()) {
                aj.a(this.bJv, d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
            } else {
                aj.a(this.bJv, d.g.icon_return_bg_s, d.g.icon_return_bg);
            }
            this.ben.dq(i);
            aj.j(this.mRootView, d.e.cp_bg_line_d);
        }
        if (this.bmn) {
            aj.b(this.fnt, d.e.cp_cont_b, d.e.s_navbar_title_color);
            aj.b(this.fns, d.e.cp_cont_i, d.e.cp_cont_i);
        }
        if (this.gxm != null) {
            this.gxm.onChangeSkinType();
        }
    }

    public void aly() {
        ((q) this.gxk).aly();
    }

    private void l(TbPageContext tbPageContext) {
        this.bJf = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.d.s.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z;
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.j.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.j.b) customResponsedMessage.getData()).fLg;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && s.this.gxk != null && s.this.gxk.gxT != null) {
                            s.this.gxk.gxT.ne(aVar.edg);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (s.this.fkg != null) {
                            if (s.this.fkg.flk != null && s.this.fkg.flk.ceU != null && aVar2 != null) {
                                s.this.fkg.flk.ceU.putBoolean("person_center_item_red_tip_show", aVar2.edg);
                                z = true;
                            } else {
                                z = false;
                            }
                            if (aVar3 != null && s.this.fkg.flj != null && s.this.fkg.flj.ceU != null) {
                                s.this.fkg.flj.ceU.putBoolean("person_center_item_red_tip_show", aVar3.edg);
                                z = true;
                            }
                            if (aVar4 != null && s.this.fkg.flh != null && s.this.fkg.flh.ceU != null) {
                                s.this.fkg.flh.ceU.putBoolean("person_center_item_red_tip_show", aVar4.edg);
                                z = true;
                            }
                            if (aVar5 != null && s.this.fkg.fll != null && s.this.fkg.fll.ceU != null) {
                                s.this.fkg.fll.ceU.putBoolean("person_center_item_red_tip_show", aVar5.edg);
                                z = true;
                            }
                            if (aVar6 != null && s.this.fkg.flm != null && s.this.fkg.flm.ceU != null) {
                                s.this.fkg.flm.ceU.putBoolean("person_center_item_red_tip_show", aVar6.edg);
                                s.this.fkg.flm.ceU.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                                z = true;
                            }
                            if (z && s.this.fnw != null) {
                                s.this.fnw.setData(s.this.fkg.aYE());
                                s.this.fnw.notifyDataSetChanged();
                            }
                        }
                        if (s.this.gxi instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                s.this.gxi.l(5, aVar7.edg);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                s.this.gxi.l(6, aVar8.edg);
                            }
                        }
                    }
                }
            }
        };
        this.bJf.setTag(this.aAj);
        tbPageContext.registerListener(this.bJf);
        this.fnv = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.d.s.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.j jVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && (jVar = (com.baidu.tbadk.data.j) customResponsedMessage.getData()) != null) {
                    s.this.gxk.sO(jVar.pR());
                }
            }
        };
        this.fnv.setTag(this.aAj);
        tbPageContext.registerListener(this.fnv);
    }

    @Override // com.baidu.tieba.view.h
    public void onDestory() {
        super.onDestory();
        if (this.gxk != null) {
            this.gxk.onDestory();
        }
        if (this.fjQ != null) {
            this.fjQ.setVisibility(8);
        }
    }

    public void qs(int i) {
        this.fnC = false;
        int i2 = i == 0 ? 1 : 0;
        this.gxp.a(i2, this.gxp.hC(i2));
        this.fnA = this.gxp.hC(i);
        if (this.fnA.aXe() == null) {
            this.fnC = true;
            if (i == 0) {
                this.gxp.PP();
                return;
            } else if (i == 1) {
                this.gxp.g(true, true, false);
                return;
            } else {
                return;
            }
        }
        cI(this.fnA.aXe());
        if (this.fnA.aXe().size() <= 1 && this.fjQ.getVisibility() == 0) {
            this.fjP.smoothScrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.view.h
    public void qt(int i) {
        if (i != this.bBs && this.gxp != null) {
            this.bBs = i;
            qs(i);
        }
    }

    public com.baidu.tieba.view.f aYK() {
        return this.gxi;
    }
}
