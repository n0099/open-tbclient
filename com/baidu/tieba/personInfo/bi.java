package com.baidu.tieba.personInfo;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class bi {
    private BdListView.e IE;
    private TextView Yu;
    private View aHm;
    private ViewEventCenter aWA;
    private PbListView aXw;
    private View azA;
    private View bDS;
    private boolean bDs;
    private BaseFragmentActivity cZG;
    private f cZH;
    private String djI;
    private RelativeLayout djJ;
    private RelativeLayout djK;
    public ImageView djL;
    public ImageView djM;
    private View djN;
    private ImageView djO;
    private BdPersonListView djP;
    private c djQ;
    private LinearLayout djR;
    private LinearLayout djS;
    private LinearLayout djT;
    private LinearLayout djU;
    private ImageView djV;
    private TextView djW;
    private MorePopupWindow djX;
    private com.baidu.tieba.person.bn djY;
    public com.baidu.tieba.person.a.b djZ;
    private View dka;
    private boolean dkb = false;
    private NavigationBar mNavigationBar;
    private int mSkinType;

    public bi(f fVar, boolean z, ViewEventCenter viewEventCenter, View view) {
        this.azA = view;
        if (fVar != null) {
            this.cZH = fVar;
            this.cZG = fVar.getBaseFragmentActivity();
            this.bDs = z;
            this.aWA = viewEventCenter;
            this.djI = fVar.avb().getName();
            this.bDS = this.cZH.getView();
            awa();
            UU();
            VX();
        }
    }

    private void VX() {
        this.djR = (LinearLayout) this.azA.findViewById(t.g.relation_root);
        this.djS = (LinearLayout) this.azA.findViewById(t.g.relation_ll);
        this.aHm = this.azA.findViewById(t.g.line);
        this.djT = (LinearLayout) this.azA.findViewById(t.g.relation_bg);
        this.djT.setOnClickListener(this.cZH);
        this.djV = (ImageView) this.azA.findViewById(t.g.relation_icon);
        this.djW = (TextView) this.azA.findViewById(t.g.relation_text);
    }

    private void avY() {
        if (this.bDs || (this.cZH != null && this.cZH.avb() != null && this.cZH.avb().avS())) {
            this.djR.setVisibility(8);
        } else {
            PersonTainInfo avA = this.cZH.avb().avA();
            int isFriend = avA != null ? avA.getIsFriend() : 1;
            this.djR.setVisibility(0);
            if (isFriend == 0) {
                this.djW.setText(t.j.addfriend);
                com.baidu.tbadk.core.util.ar.k(this.djT, t.f.btn_all_blue);
                com.baidu.tbadk.core.util.ar.k(this.djV, t.f.icon_person_add);
                com.baidu.tbadk.core.util.ar.b(this.djW, t.d.cp_cont_i, 1);
            } else if (isFriend == 1) {
                this.djW.setText(t.j.user_info_center_head_viewpager_send_text_name);
                com.baidu.tbadk.core.util.ar.k(this.djT, t.f.btn_all_white);
                com.baidu.tbadk.core.util.ar.k(this.djV, t.f.icon_pop_news);
                com.baidu.tbadk.core.util.ar.b(this.djW, t.d.cp_link_tip_c, 1);
            } else if (isFriend == 2) {
                this.djW.setText(t.j.acceptfriendapply);
                com.baidu.tbadk.core.util.ar.k(this.djT, t.f.btn_all_blue);
                com.baidu.tbadk.core.util.ar.k(this.djV, t.f.icon_pop_pass);
                com.baidu.tbadk.core.util.ar.b(this.djW, t.d.cp_cont_i, 1);
            } else {
                this.djR.setVisibility(8);
            }
        }
        com.baidu.tbadk.core.util.ar.l(this.aHm, t.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.ar.k(this.djS, t.f.bg_mycenter_toolbar);
        j(this.cZH.avb().getUserData());
    }

    public void avZ() {
        if (this.bDs) {
            AntiData ajb = this.cZH.avb().ajb();
            if (ajb != null) {
                if (AntiHelper.f(ajb) || AntiHelper.h(ajb)) {
                    com.baidu.tbadk.core.util.ar.k(this.djT, t.f.btn_pop_news);
                    com.baidu.tbadk.core.util.ar.b(this.djW, t.d.cp_link_tip_c, 1);
                }
            } else {
                return;
            }
        } else {
            PersonTainInfo avA = this.cZH.avb().avA();
            int isFriend = avA != null ? avA.getIsFriend() : 1;
            if (isFriend == 0) {
                com.baidu.tbadk.core.util.ar.k(this.djT, t.f.btn_all_blue);
                com.baidu.tbadk.core.util.ar.k(this.djV, t.f.icon_person_add);
                com.baidu.tbadk.core.util.ar.b(this.djW, t.d.cp_cont_i, 1);
            } else if (isFriend == 1) {
                com.baidu.tbadk.core.util.ar.k(this.djT, t.f.btn_pop_news);
                com.baidu.tbadk.core.util.ar.k(this.djV, t.f.icon_pop_news);
                com.baidu.tbadk.core.util.ar.b(this.djW, t.d.cp_link_tip_c, 1);
            } else if (isFriend == 2) {
                com.baidu.tbadk.core.util.ar.k(this.djT, t.f.btn_all_blue);
                com.baidu.tbadk.core.util.ar.k(this.djV, t.f.icon_pop_pass);
                com.baidu.tbadk.core.util.ar.b(this.djW, t.d.cp_cont_i, 1);
            } else {
                this.djR.setVisibility(8);
            }
        }
        com.baidu.tbadk.core.util.ar.l(this.aHm, t.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.ar.k(this.djS, t.f.bg_mycenter_toolbar);
        j(this.cZH.avb().getUserData());
    }

    private void j(UserData userData) {
        if (userData != null && userData.getIsOfficialAccount() == 1) {
            this.djW.setText(t.j.user_info_center_head_viewpager_send_text_name);
            com.baidu.tbadk.core.util.ar.k(this.djT, t.f.btn_pop_news);
            com.baidu.tbadk.core.util.ar.k(this.djV, t.f.icon_pop_news);
            com.baidu.tbadk.core.util.ar.b(this.djW, t.d.cp_link_tip_c, 1);
        }
    }

    private void awa() {
        this.mNavigationBar = (NavigationBar) this.azA.findViewById(t.g.navigation_bar);
        this.mNavigationBar.setOnTouchListener(new bj(this));
        int c = com.baidu.adp.lib.util.k.c(this.cZG.getPageContext().getPageActivity(), t.e.ds16);
        if (this.cZG instanceof PersonInfoActivity) {
            this.djN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cZG);
            this.djN.setOnClickListener(this.cZH);
            this.mNavigationBar.setTitleText("");
            if (!this.bDs) {
                this.djO = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.nb_item_floor_more, this.cZG);
                this.djO.setVisibility(8);
                if (this.djO != null && TbadkCoreApplication.isLogin()) {
                    this.djO.setOnClickListener(this.cZH);
                    this.djO.setVisibility(0);
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.djO.getLayoutParams();
                layoutParams.rightMargin = c;
                this.djO.setLayoutParams(layoutParams);
            }
        } else {
            this.Yu = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, t.h.maintab_title_layout, (View.OnClickListener) null).findViewById(t.g.title_textview);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.cZG.getResources().getDimension(t.e.navi_btn_margin_right);
            com.baidu.tbadk.core.util.ar.j((View) this.Yu, t.d.s_navbar_title_color);
            layoutParams2.setMargins(dimension, dimension, 0, dimension);
            this.Yu.setLayoutParams(layoutParams2);
            this.Yu.setText(t.j.mine);
            if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
                this.djK = (RelativeLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.nb_item_floor_more_tip, this.cZG);
                this.djM = (ImageView) this.djK.findViewById(t.g.btnmore_red_tip);
                this.djK.setOnClickListener(new bk(this));
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.djK.getLayoutParams();
                layoutParams3.rightMargin = com.baidu.adp.lib.util.k.c(this.cZG.getPageContext().getPageActivity(), t.e.ds20);
                this.djK.setLayoutParams(layoutParams3);
            }
            if (TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
                this.djJ = (RelativeLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.nb_item_floor_more_tip, this.cZG);
                this.djL = (ImageView) this.djJ.findViewById(t.g.btnmore_red_tip);
                this.djJ.setOnClickListener(new bl(this));
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.djJ.getLayoutParams();
                layoutParams4.rightMargin = c;
                this.djJ.setLayoutParams(layoutParams4);
                if (!PersonInfoActivityConfig.IS_SUPPORT_EDIT) {
                    this.djJ.setVisibility(8);
                }
            }
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mNavigationBar.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.mNavigationBar.getMeasuredHeight();
        this.dka = this.azA.findViewById(t.g.view_navigation_bar_bg);
        FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) this.dka.getLayoutParams();
        layoutParams5.height = measuredHeight;
        this.dka.setLayoutParams(layoutParams5);
        if (Build.VERSION.SDK_INT >= 11) {
            this.dka.setAlpha(0.0f);
        } else {
            this.dka.setVisibility(8);
        }
    }

    private void awb() {
        this.dka.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.ar.cP(t.f.s_navbar_bg)));
    }

    private void UU() {
        this.djP = (BdPersonListView) this.azA.findViewById(t.g.personcenter_list);
        this.djQ = new c(this.cZH, this.bDs, this.aWA);
        this.djP.addHeaderView(this.djQ.getRootView());
        this.djP.e(this.djQ.getRootView(), this.cZG.getResources().getDimensionPixelSize(t.e.ds568));
        this.djZ = new com.baidu.tieba.person.a.b(this.cZH, this.djP);
        this.djZ.aa(this.cZH.avb().getDataList());
        this.djZ.notifyDataSetChanged();
        this.djP.setOnScrollListener(new bm(this));
        awn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awc() {
        if (Build.VERSION.SDK_INT >= 11) {
            int dimension = (int) this.cZG.getResources().getDimension(t.e.ds98);
            int dimension2 = ((int) this.cZG.getResources().getDimension(t.e.ds450)) - (-this.djQ.getRootView().getTop());
            if (dimension2 < dimension) {
                if (this.dka.getAlpha() != 1.0f) {
                    this.dka.setAlpha(1.0f);
                }
            } else if (dimension2 >= dimension && dimension2 <= dimension * 2) {
                this.dka.setAlpha(1.0f - (((dimension2 - dimension) * 1.0f) / dimension));
            } else if (dimension2 > dimension * 2 && this.dka.getAlpha() != 0.0f) {
                this.dka.setAlpha(0.0f);
            }
            if (this.djP.getFirstVisiblePosition() > 0 && this.dka.getAlpha() != 1.0f) {
                this.dka.setAlpha(1.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awd() {
        if ((this.cZG instanceof PersonInfoActivity) && Build.VERSION.SDK_INT >= 11) {
            if (this.dka.getAlpha() == 1.0f) {
                if (!this.dkb) {
                    this.mNavigationBar.setTitleText(this.djI);
                    this.dkb = true;
                }
            } else if (this.dkb) {
                this.mNavigationBar.setTitleText("");
                this.dkb = false;
            }
        }
    }

    public void onDestroy() {
        this.djQ.auL();
        this.djP.removeHeaderView(this.djQ.getRootView());
    }

    public void startLoad() {
        this.djP.nf();
    }

    public void Oz() {
        this.djQ.Oz();
    }

    public void setPersonListRefreshListener(BdPersonListView.a aVar) {
        this.djP.setPersonListRefreshListener(aVar);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        if (this.aXw == null) {
            this.aXw = new PbListView(this.cZG.getActivity());
            this.aXw.ni();
            this.aXw.df(t.d.cp_bg_line_c);
            this.aXw.setTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_cont_d));
            this.aXw.dg(TbadkCoreApplication.m411getInst().getSkinType());
        }
        this.djP.setNextPage(this.aXw);
        awe();
        this.IE = eVar;
        this.djP.setOnScrollListener(new bn(this));
    }

    public void Ob() {
        if (this.aXw != null) {
            this.aXw.getView().setVisibility(0);
            this.aXw.xb();
        }
    }

    public void auA() {
        if (this.aXw != null) {
            this.aXw.getView().setVisibility(0);
            this.aXw.setText(this.cZH.getString(t.j.list_no_more_god_threads));
            this.aXw.xc();
        }
    }

    public void awe() {
        if (this.aXw != null) {
            this.aXw.getView().setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tbadk.core.util.ar.l(this.djP, t.d.cp_bg_line_c);
        this.cZG.getLayoutMode().ac(i == 1);
        this.cZG.getLayoutMode().x(this.bDS);
        this.djQ.oO();
        this.djZ.notifyDataSetChanged();
        avZ();
        this.mNavigationBar.onChangeSkinType(this.cZG.getPageContext(), i);
        com.baidu.tbadk.core.util.ar.k(this.mNavigationBar, t.d.white_alpha0);
        awj();
        if (this.djM != null && this.djM.getVisibility() == 0) {
            com.baidu.tbadk.core.util.ar.c(this.djM, t.f.icon_news_down_bar_one);
        }
        if (this.djU != null) {
            com.baidu.tbadk.core.util.ar.l(this.djU, t.d.cp_bg_line_c);
        }
        if (this.aXw != null) {
            this.aXw.df(t.d.cp_bg_line_c);
            this.aXw.setTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_cont_d));
            this.aXw.dg(i);
        }
        awb();
    }

    public UserIconBox getUserIcon() {
        return this.djQ.getUserIcon();
    }

    public c awf() {
        return this.djQ;
    }

    public View getAttentionView() {
        return this.djQ.getAttentionView();
    }

    public View awg() {
        return this.djT;
    }

    public void awh() {
        awi();
        avY();
        if (this.djQ != null && this.cZH.avb().getUserData() != null) {
            if (this.cZH.avb().avS()) {
                this.djQ.lC(2);
                awo();
            } else {
                this.djQ.lC(1);
                awo();
            }
            this.djQ.akY();
        }
        if (this.djZ != null) {
            this.djZ.notifyDataSetChanged();
        }
        awj();
    }

    private void awi() {
        if (this.cZH != null && this.cZH.avb() != null && this.cZH.avb().getUserData() != null) {
            this.djI = this.cZH.avb().getUserData().getUserName();
        }
    }

    public HeadImageView getHeadImage() {
        return this.djQ.getHeadImage();
    }

    public void awj() {
        ImageView imageView;
        if (!(this.cZG instanceof PersonInfoActivity)) {
            if (this.djK != null && (imageView = (ImageView) this.djK.findViewById(t.g.btnmore_image)) != null) {
                com.baidu.tbadk.core.util.ar.a(imageView, t.f.icon_person_dressup, t.f.icon_person_dressup);
            }
            if (this.djJ != null) {
                ImageView imageView2 = (ImageView) this.djJ.findViewById(t.g.btnmore_image);
                if (imageView2 != null) {
                    com.baidu.tbadk.core.util.ar.a(imageView2, t.f.icon_home_setting, t.f.icon_home_setting);
                }
                if (TbadkCoreApplication.isLogin() && PersonInfoActivityConfig.IS_SUPPORT_EDIT) {
                    this.djJ.setVisibility(0);
                } else {
                    this.djJ.setVisibility(8);
                }
            }
            com.baidu.tbadk.core.util.ar.j((View) this.Yu, t.d.s_navbar_title_color);
        } else if (this.djO != null) {
            com.baidu.tbadk.core.util.ar.a(this.djO, t.f.icon_more_bg_s, t.f.icon_more_bg);
        }
    }

    public LinearLayout getMyGiftIcon() {
        return this.djQ.getMyGiftIcon();
    }

    public void gf(boolean z) {
    }

    public void lD(int i) {
    }

    public void a(boolean z, boolean z2, int i) {
        this.djY = new com.baidu.tieba.person.bn(this.cZH);
        this.djX = new MorePopupWindow(this.cZG.getPageContext().getPageActivity(), this.djY.getView(), this.mNavigationBar, this.cZG.getResources().getDrawable(t.f.bg_pull_down_right_n), new bo(this));
        this.djX.onChangeSkinType(this.cZG, this.mSkinType, this.cZG.getResources().getDrawable(t.f.bg_pull_down_right_n));
        this.djY.q(z, z2);
        if (i != -1) {
            this.djY.ls(i);
        }
        this.djX.refresh();
        this.djX.showWindowInRightBottomOfHost();
    }

    public void awk() {
        com.baidu.adp.lib.h.j.a(this.djX, this.cZG.getPageContext().getPageActivity());
    }

    public ImageView awl() {
        return this.djO;
    }

    public View awm() {
        return this.djN;
    }

    public View atT() {
        if (this.djY == null) {
            return null;
        }
        return this.djY.atT();
    }

    public View atS() {
        if (this.djY == null) {
            return null;
        }
        return this.djY.atS();
    }

    public View atU() {
        if (this.djY == null) {
            return null;
        }
        return this.djY.atU();
    }

    public void b(b bVar) {
        this.djZ.cZL.a(bVar);
    }

    public void b(com.baidu.adp.widget.ListView.v vVar) {
        this.djZ.b(vVar);
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.djZ != null && this.djZ.cZS != null) {
            this.djZ.cZS.L(onClickListener);
        }
    }

    private void awn() {
        if (this.djU == null && this.cZG != null && this.djP != null) {
            this.djU = new LinearLayout(this.cZG.getPageContext().getContext());
            this.djU.setVisibility(0);
            int dimensionPixelSize = this.cZG.getResources().getDimensionPixelSize(t.e.ds70);
            if (!this.bDs) {
                dimensionPixelSize = this.cZG.getResources().getDimensionPixelSize(t.e.ds240);
            }
            this.djU.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
            com.baidu.tbadk.core.util.ar.l(this.djU, t.d.cp_bg_line_c);
            this.djP.removeFooterView(this.djU);
            this.djP.addFooterView(this.djU);
        }
    }

    private void awo() {
        int i = 0;
        if (this.cZH != null && this.cZH.avb() != null) {
            if (!this.cZH.avb().avS()) {
                if (this.bDs) {
                    i = this.cZG.getResources().getDimensionPixelSize(t.e.ds70);
                } else {
                    i = this.cZG.getResources().getDimensionPixelSize(t.e.ds240);
                }
            } else if (this.cZH.avb().avU()) {
                i = this.cZG.getResources().getDimensionPixelSize(t.e.ds70);
            } else if (this.cZH.avb().avT()) {
            }
            if (this.djU != null) {
                this.djU.setLayoutParams(new AbsListView.LayoutParams(-1, i));
            }
        }
    }
}
