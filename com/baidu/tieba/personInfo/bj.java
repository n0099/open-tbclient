package com.baidu.tieba.personInfo;

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
import com.baidu.tbadk.core.data.AccountData;
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
public class bj {
    private TextView RX;
    private View aGr;
    private ViewEventCenter aXs;
    private View awk;
    private boolean bIW;
    private PbListView bkd;
    private View bxh;
    private BaseFragmentActivity cSp;
    public ImageView dHA;
    public ImageView dHB;
    private View dHC;
    private ImageView dHD;
    private BdPersonListView dHE;
    private c dHF;
    private LinearLayout dHG;
    private LinearLayout dHH;
    private LinearLayout dHI;
    private LinearLayout dHJ;
    private ImageView dHK;
    private TextView dHL;
    private MorePopupWindow dHM;
    private com.baidu.tieba.person.bo dHN;
    public com.baidu.tieba.person.a.b dHO;
    private View dHP;
    private String dHu;
    private TextView dHv;
    private RelativeLayout dHw;
    private RelativeLayout dHx;
    private ImageView dHy;
    private ImageView dHz;
    private f dxd;
    private NavigationBar mNavigationBar;
    private int mSkinType;
    private BdListView.e zc;
    private boolean dHQ = false;
    private boolean bks = true;

    public bj(f fVar, boolean z, ViewEventCenter viewEventCenter, View view) {
        this.awk = view;
        if (fVar != null) {
            this.dxd = fVar;
            this.cSp = fVar.getBaseFragmentActivity();
            this.bIW = z;
            this.aXs = viewEventCenter;
            this.dHu = fVar.aDb().getName();
            this.bxh = this.dxd.getView();
            aEb();
            WM();
            XQ();
        }
    }

    private void XQ() {
        this.dHG = (LinearLayout) this.awk.findViewById(t.g.relation_root);
        this.dHH = (LinearLayout) this.awk.findViewById(t.g.relation_ll);
        this.aGr = this.awk.findViewById(t.g.line);
        this.dHI = (LinearLayout) this.awk.findViewById(t.g.relation_bg);
        this.dHI.setOnClickListener(this.dxd);
        this.dHK = (ImageView) this.awk.findViewById(t.g.relation_icon);
        this.dHL = (TextView) this.awk.findViewById(t.g.relation_text);
    }

    private void aDZ() {
        if (this.dxd != null) {
            if (this.bIW || (this.dxd.aDb() != null && this.dxd.aDb().aDT())) {
                this.dHG.setVisibility(8);
            } else {
                PersonTainInfo aDA = this.dxd.aDb().aDA();
                int isFriend = aDA != null ? aDA.getIsFriend() : 1;
                this.dHG.setVisibility(0);
                if (isFriend == 0) {
                    this.dHL.setText(t.j.addfriend);
                    com.baidu.tbadk.core.util.at.k(this.dHI, t.f.btn_all_blue);
                    com.baidu.tbadk.core.util.at.k(this.dHK, t.f.icon_person_add);
                    com.baidu.tbadk.core.util.at.c(this.dHL, t.d.cp_cont_i, 1);
                } else if (isFriend == 1) {
                    this.dHL.setText(t.j.user_info_center_head_viewpager_send_text_name);
                    com.baidu.tbadk.core.util.at.k(this.dHI, t.f.btn_all_white);
                    com.baidu.tbadk.core.util.at.k(this.dHK, t.f.icon_pop_news);
                    com.baidu.tbadk.core.util.at.c(this.dHL, t.d.cp_link_tip_c, 1);
                } else if (isFriend == 2) {
                    this.dHL.setText(t.j.acceptfriendapply);
                    com.baidu.tbadk.core.util.at.k(this.dHI, t.f.btn_all_blue);
                    com.baidu.tbadk.core.util.at.k(this.dHK, t.f.icon_pop_pass);
                    com.baidu.tbadk.core.util.at.c(this.dHL, t.d.cp_cont_i, 1);
                } else {
                    this.dHG.setVisibility(8);
                }
            }
            com.baidu.tbadk.core.util.at.l(this.aGr, t.d.cp_bg_line_e);
            com.baidu.tbadk.core.util.at.k(this.dHH, t.f.bg_mycenter_toolbar);
            j(this.dxd.aDb().getUserData());
        }
    }

    public void aEa() {
        if (this.bIW) {
            AntiData antiData = this.dxd.aDb().getAntiData();
            if (antiData != null) {
                if (AntiHelper.e(antiData) || AntiHelper.g(antiData)) {
                    com.baidu.tbadk.core.util.at.k(this.dHI, t.f.btn_pop_news);
                    com.baidu.tbadk.core.util.at.c(this.dHL, t.d.cp_link_tip_c, 1);
                }
            } else {
                return;
            }
        } else {
            PersonTainInfo aDA = this.dxd.aDb().aDA();
            int isFriend = aDA != null ? aDA.getIsFriend() : 1;
            if (isFriend == 0) {
                com.baidu.tbadk.core.util.at.k(this.dHI, t.f.btn_all_blue);
                com.baidu.tbadk.core.util.at.k(this.dHK, t.f.icon_person_add);
                com.baidu.tbadk.core.util.at.c(this.dHL, t.d.cp_cont_i, 1);
            } else if (isFriend == 1) {
                com.baidu.tbadk.core.util.at.k(this.dHI, t.f.btn_pop_news);
                com.baidu.tbadk.core.util.at.k(this.dHK, t.f.icon_pop_news);
                com.baidu.tbadk.core.util.at.c(this.dHL, t.d.cp_link_tip_c, 1);
            } else if (isFriend == 2) {
                com.baidu.tbadk.core.util.at.k(this.dHI, t.f.btn_all_blue);
                com.baidu.tbadk.core.util.at.k(this.dHK, t.f.icon_pop_pass);
                com.baidu.tbadk.core.util.at.c(this.dHL, t.d.cp_cont_i, 1);
            } else {
                this.dHG.setVisibility(8);
            }
        }
        com.baidu.tbadk.core.util.at.l(this.aGr, t.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.at.k(this.dHH, t.f.bg_mycenter_toolbar);
        j(this.dxd.aDb().getUserData());
    }

    private void j(UserData userData) {
        if (userData != null && userData.getIsOfficialAccount() == 1) {
            this.dHL.setText(t.j.user_info_center_head_viewpager_send_text_name);
            com.baidu.tbadk.core.util.at.k(this.dHI, t.f.btn_pop_news);
            com.baidu.tbadk.core.util.at.k(this.dHK, t.f.icon_pop_news);
            com.baidu.tbadk.core.util.at.c(this.dHL, t.d.cp_link_tip_c, 1);
        }
    }

    private void aEb() {
        this.mNavigationBar = (NavigationBar) this.awk.findViewById(t.g.navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setOnTouchListener(new bk(this));
        int c = com.baidu.adp.lib.util.k.c(this.cSp.getPageContext().getPageActivity(), t.e.ds16);
        if (this.cSp instanceof PersonInfoActivity) {
            this.dHC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cSp);
            this.dHC.setOnClickListener(this.dxd);
            this.mNavigationBar.setTitleText("");
            if (!this.bIW) {
                this.dHD = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.nb_item_floor_more, this.cSp);
                this.dHD.setContentDescription(this.cSp.getPageContext().getString(t.j.more));
                this.dHD.setVisibility(8);
                if (this.dHD != null && TbadkCoreApplication.isLogin()) {
                    this.dHD.setOnClickListener(this.dxd);
                    this.dHD.setVisibility(0);
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dHD.getLayoutParams();
                layoutParams.rightMargin = c;
                this.dHD.setLayoutParams(layoutParams);
            }
        } else {
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, t.h.maintab_title_layout, (View.OnClickListener) null);
            this.RX = (TextView) addCustomView.findViewById(t.g.title_textview);
            this.dHv = (TextView) addCustomView.findViewById(t.g.another_title_textview);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.cSp.getResources().getDimension(t.e.navi_btn_margin_right);
            com.baidu.tbadk.core.util.at.b(this.RX, t.d.cp_cont_b, t.d.s_navbar_title_color);
            com.baidu.tbadk.core.util.at.b(this.dHv, t.d.cp_cont_b, t.d.s_navbar_title_color);
            layoutParams2.setMargins(dimension, dimension, 0, dimension);
            this.RX.setLayoutParams(layoutParams2);
            this.RX.setText(t.j.mine);
            this.dHv.setLayoutParams(layoutParams2);
            this.dHv.setText(t.j.mine);
            if (TbadkCoreApplication.m11getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
                this.dHx = (RelativeLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.nb_item_floor_more_tip, this.cSp);
                this.dHx.setContentDescription(TbadkCoreApplication.m11getInst().getResources().getString(t.j.dressup_center_title));
                this.dHB = (ImageView) this.dHx.findViewById(t.g.btnmore_red_tip);
                this.dHx.setOnClickListener(new bl(this));
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.dHx.getLayoutParams();
                layoutParams3.rightMargin = com.baidu.adp.lib.util.k.c(this.cSp.getPageContext().getPageActivity(), t.e.ds20);
                this.dHx.setLayoutParams(layoutParams3);
                this.dHy = (ImageView) this.dHx.findViewById(t.g.btnmore_image);
            }
            if (TbadkCoreApplication.m11getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
                this.dHw = (RelativeLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.nb_item_floor_more_tip, this.cSp);
                this.dHw.setContentDescription(TbadkCoreApplication.m11getInst().getResources().getString(t.j.setup));
                this.dHA = (ImageView) this.dHw.findViewById(t.g.btnmore_red_tip);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (!com.baidu.tbadk.core.sharedPref.b.sQ().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj.isMemberCloseAdIsOpen()) {
                    this.dHA.setVisibility(0);
                }
                this.dHw.setOnClickListener(new bm(this));
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.dHw.getLayoutParams();
                layoutParams4.rightMargin = c;
                this.dHw.setLayoutParams(layoutParams4);
                if (!PersonInfoActivityConfig.IS_SUPPORT_EDIT) {
                    this.dHw.setVisibility(8);
                }
                this.dHz = (ImageView) this.dHw.findViewById(t.g.btnmore_image);
            }
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mNavigationBar.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.mNavigationBar.getMeasuredHeight();
        this.dHP = this.awk.findViewById(t.g.view_navigation_bar_bg);
        FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) this.dHP.getLayoutParams();
        layoutParams5.height = measuredHeight;
        this.dHP.setLayoutParams(layoutParams5);
        if (Build.VERSION.SDK_INT >= 11) {
            this.dHP.setAlpha(0.0f);
        } else {
            this.dHP.setVisibility(8);
        }
    }

    private void aEc() {
        this.dHP.setBackgroundDrawable(com.baidu.tbadk.core.util.at.getDrawable(t.f.s_navbar_bg));
    }

    private void WM() {
        this.dHE = (BdPersonListView) this.awk.findViewById(t.g.personcenter_list);
        this.dHF = new c(this.dxd, this.bIW, this.aXs);
        this.dHE.addHeaderView(this.dHF.getRootView());
        this.dHE.e(this.dHF.getRootView(), this.cSp.getResources().getDimensionPixelSize(t.e.ds568));
        this.dHO = new com.baidu.tieba.person.a.b(this.dxd, this.dHE);
        this.dHO.ac(this.dxd.aDb().getDataList());
        this.dHO.notifyDataSetChanged();
        this.dHE.setOnScrollListener(new bn(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEd() {
        float f;
        if (!(this.cSp instanceof PersonInfoActivity) && aEq() != 2) {
            float alpha = this.dHP.getAlpha();
            if (alpha < 0.5f) {
                if (!this.bks) {
                    this.bks = true;
                    if (this.dHx != null && this.dHy != null) {
                        com.baidu.tbadk.core.util.at.a(this.dHy, t.f.icon_person_dressup_w, t.f.icon_person_dressup_w);
                    }
                    if (this.dHw != null && this.dHz != null) {
                        com.baidu.tbadk.core.util.at.a(this.dHz, t.f.icon_home_setting_w, t.f.icon_home_setting_w);
                    }
                    this.RX.setVisibility(0);
                    this.dHv.setVisibility(8);
                    com.baidu.tbadk.core.util.at.b(this.RX, t.d.cp_cont_i, t.d.cp_cont_i);
                }
            } else if (this.bks) {
                this.bks = false;
                if (this.dHx != null && this.dHy != null) {
                    com.baidu.tbadk.core.util.at.a(this.dHy, t.f.icon_person_dressup_s, t.f.icon_person_dressup_s);
                }
                if (this.dHw != null && this.dHz != null) {
                    com.baidu.tbadk.core.util.at.a(this.dHz, t.f.icon_home_setting_s, t.f.icon_home_setting_s);
                }
                this.RX.setVisibility(8);
                this.dHv.setVisibility(0);
                com.baidu.tbadk.core.util.at.b(this.dHv, t.d.cp_cont_b, t.d.s_navbar_title_color);
            }
            this.RX.setAlpha(1.0f - alpha);
            this.dHv.setAlpha(alpha);
            if (alpha < 0.5f) {
                f = 1.0f - (alpha * 2.0f);
            } else {
                f = (alpha * 2.0f) - 1.0f;
            }
            if (f >= 0.0f && f <= 1.0f) {
                if (this.dHx != null && this.dHy != null) {
                    this.dHy.setAlpha(f);
                }
                if (this.dHw != null && this.dHz != null) {
                    this.dHz.setAlpha(f);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEe() {
        if (Build.VERSION.SDK_INT >= 11) {
            int dimension = (int) this.cSp.getResources().getDimension(t.e.ds98);
            int dimension2 = ((int) this.cSp.getResources().getDimension(t.e.ds450)) - (-this.dHF.getRootView().getTop());
            if (dimension2 < dimension) {
                if (this.dHP.getAlpha() != 1.0f) {
                    this.dHP.setAlpha(1.0f);
                }
            } else if (dimension2 >= dimension && dimension2 <= dimension * 2) {
                this.dHP.setAlpha(1.0f - (((dimension2 - dimension) * 1.0f) / dimension));
            } else if (dimension2 > dimension * 2 && this.dHP.getAlpha() != 0.0f) {
                this.dHP.setAlpha(0.0f);
            }
            if (this.dHE.getFirstVisiblePosition() > 0 && this.dHP.getAlpha() != 1.0f) {
                this.dHP.setAlpha(1.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEf() {
        if ((this.cSp instanceof PersonInfoActivity) && Build.VERSION.SDK_INT >= 11) {
            if (this.dHP.getAlpha() == 1.0f) {
                if (!this.dHQ) {
                    this.mNavigationBar.setTitleText(this.dHu);
                    this.dHQ = true;
                }
            } else if (this.dHQ) {
                this.mNavigationBar.setTitleText("");
                this.dHQ = false;
            }
        }
    }

    public void onDestroy() {
        this.dHF.aCJ();
        this.dHE.removeHeaderView(this.dHF.getRootView());
        if (this.dHJ != null) {
            this.dHE.removeFooterView(this.dHJ);
        }
    }

    public void aiJ() {
        this.dHE.jk();
    }

    public void Pl() {
        this.dHF.Pl();
    }

    public void setPersonListRefreshListener(BdPersonListView.a aVar) {
        this.dHE.setPersonListRefreshListener(aVar);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        if (this.bkd == null) {
            this.bkd = new PbListView(this.cSp.getActivity());
            this.bkd.jn();
            this.bkd.cR(t.d.cp_bg_line_c);
            this.bkd.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_d));
            this.bkd.cS(TbadkCoreApplication.m11getInst().getSkinType());
        }
        this.dHE.setNextPage(this.bkd);
        aEg();
        this.zc = eVar;
        this.dHE.setOnScrollListener(new bo(this));
    }

    public void OJ() {
        if (this.bkd != null) {
            this.bkd.getView().setVisibility(0);
            this.bkd.vg();
        }
    }

    public void aCx() {
        if (this.bkd != null) {
            this.bkd.getView().setVisibility(0);
            this.bkd.setText(this.dxd.getString(t.j.list_no_more_god_threads));
            this.bkd.vh();
        }
    }

    public void aEg() {
        if (this.bkd != null) {
            this.bkd.getView().setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            aEp();
        }
        this.mSkinType = i;
        com.baidu.tbadk.core.util.at.l(this.dHE, t.d.cp_bg_line_c);
        this.cSp.getLayoutMode().ae(i == 1);
        this.cSp.getLayoutMode().x(this.bxh);
        this.dHF.kU();
        this.dHO.notifyDataSetChanged();
        aEa();
        this.mNavigationBar.onChangeSkinType(this.cSp.getPageContext(), i);
        com.baidu.tbadk.core.util.at.k(this.mNavigationBar, t.d.white_alpha0);
        aEl();
        if (this.dHB != null && this.dHB.getVisibility() == 0) {
            com.baidu.tbadk.core.util.at.c(this.dHB, t.f.icon_news_down_bar_one);
        }
        if (this.dHA != null && this.dHA.getVisibility() == 0) {
            com.baidu.tbadk.core.util.at.c(this.dHA, t.f.icon_news_down_bar_one);
        }
        if (this.dHJ != null) {
            com.baidu.tbadk.core.util.at.l(this.dHJ, t.d.cp_bg_line_c);
        }
        if (this.bkd != null) {
            this.bkd.cR(t.d.cp_bg_line_c);
            this.bkd.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_d));
            this.bkd.cS(i);
        }
        aEc();
    }

    public UserIconBox getUserIcon() {
        return this.dHF.getUserIcon();
    }

    public c aEh() {
        return this.dHF;
    }

    public View getAttentionView() {
        return this.dHF.getAttentionView();
    }

    public View aEi() {
        return this.dHI;
    }

    public void aEj() {
        aEk();
        aDZ();
        if (this.dHF != null && this.dxd.aDb().getUserData() != null) {
            if (this.dxd.aDb().aDT()) {
                this.dHF.mC(2);
            } else {
                this.dHF.mC(1);
            }
            this.dHF.aBX();
        }
        aEp();
        aEs();
        if (this.dHO != null) {
            this.dHO.notifyDataSetChanged();
        }
        aEl();
    }

    private void aEk() {
        if (this.dxd != null && this.dxd.aDb() != null && this.dxd.aDb().getUserData() != null) {
            this.dHu = this.dxd.aDb().getUserData().getUserName();
        }
    }

    public HeadImageView getHeadImage() {
        return this.dHF.getHeadImage();
    }

    public void aEl() {
        ImageView imageView;
        if (!(this.cSp instanceof PersonInfoActivity)) {
            if (this.dHx != null && (imageView = (ImageView) this.dHx.findViewById(t.g.btnmore_image)) != null) {
                if (aEq() == 2) {
                    com.baidu.tbadk.core.util.at.a(imageView, t.f.icon_person_dressup_s, t.f.icon_person_dressup);
                } else {
                    com.baidu.tbadk.core.util.at.a(imageView, t.f.icon_person_dressup_w, t.f.icon_person_dressup_w);
                }
            }
            if (this.dHw != null) {
                ImageView imageView2 = (ImageView) this.dHw.findViewById(t.g.btnmore_image);
                if (imageView2 != null) {
                    if (aEq() == 2) {
                        com.baidu.tbadk.core.util.at.a(imageView2, t.f.icon_home_setting_s, t.f.icon_home_setting);
                    } else {
                        com.baidu.tbadk.core.util.at.a(imageView2, t.f.icon_home_setting_w, t.f.icon_home_setting_w);
                    }
                }
                if (TbadkCoreApplication.isLogin() && PersonInfoActivityConfig.IS_SUPPORT_EDIT) {
                    this.dHw.setVisibility(0);
                } else {
                    this.dHw.setVisibility(8);
                }
            }
            if (aEq() == 2) {
                com.baidu.tbadk.core.util.at.b(this.RX, t.d.cp_cont_b, t.d.s_navbar_title_color);
            } else {
                com.baidu.tbadk.core.util.at.b(this.RX, t.d.cp_cont_i, t.d.cp_cont_i);
            }
            com.baidu.tbadk.core.util.at.b(this.dHv, t.d.cp_cont_b, t.d.cp_cont_i);
        } else if (this.dHD != null) {
            com.baidu.tbadk.core.util.at.a(this.dHD, t.f.icon_more_bg_s, t.f.icon_more_bg);
        }
    }

    public LinearLayout getMyGiftIcon() {
        return this.dHF.getMyGiftIcon();
    }

    public void hC(boolean z) {
    }

    public void mD(int i) {
    }

    public void a(boolean z, boolean z2, int i) {
        this.dHN = new com.baidu.tieba.person.bo(this.dxd);
        this.dHM = new MorePopupWindow(this.cSp.getPageContext().getPageActivity(), this.dHN.getView(), this.mNavigationBar, this.cSp.getResources().getDrawable(t.f.bg_pull_down_right_n), new bp(this));
        this.dHM.onChangeSkinType(this.cSp, this.mSkinType, this.cSp.getResources().getDrawable(t.f.bg_pull_down_right_n));
        this.dHN.s(z, z2);
        if (i != -1) {
            this.dHN.ms(i);
        }
        this.dHM.refresh();
        this.dHM.showWindowInRightBottomOfHost();
    }

    public void aEm() {
        com.baidu.adp.lib.h.j.a(this.dHM, this.cSp.getPageContext().getPageActivity());
    }

    public ImageView aEn() {
        return this.dHD;
    }

    public View aEo() {
        return this.dHC;
    }

    public View aBT() {
        if (this.dHN == null) {
            return null;
        }
        return this.dHN.aBT();
    }

    public View aBS() {
        if (this.dHN == null) {
            return null;
        }
        return this.dHN.aBS();
    }

    public View aBU() {
        if (this.dHN == null) {
            return null;
        }
        return this.dHN.aBU();
    }

    public void b(b bVar) {
        this.dHO.dxh.a(bVar);
    }

    public void d(com.baidu.adp.widget.ListView.w wVar) {
        this.dHO.d(wVar);
    }

    public void M(View.OnClickListener onClickListener) {
        if (this.dHO != null && this.dHO.dxo != null) {
            this.dHO.dxo.L(onClickListener);
        }
    }

    private void aEp() {
        if (this.dHJ == null) {
            this.dHJ = new LinearLayout(this.cSp.getPageContext().getContext());
            this.dHJ.setVisibility(0);
        }
        if (this.cSp != null && this.dHE != null) {
            int aEr = aEr();
            if (!this.bIW) {
                aEr = this.cSp.getResources().getDimensionPixelSize(t.e.ds240);
            }
            this.dHJ.setLayoutParams(new AbsListView.LayoutParams(-1, aEr));
            com.baidu.tbadk.core.util.at.l(this.dHJ, t.d.cp_bg_line_c);
            this.dHE.removeFooterView(this.dHJ);
            this.dHE.addFooterView(this.dHJ);
        }
    }

    private int aEq() {
        return TbadkCoreApplication.m11getInst().getSkinType();
    }

    private int aEr() {
        int dimensionPixelSize = this.cSp.getResources().getDimensionPixelSize(t.e.ds170);
        if (aEq() == 2) {
            return this.cSp.getResources().getDimensionPixelSize(t.e.ds70);
        }
        return dimensionPixelSize;
    }

    private void aEs() {
        int i = 0;
        if (this.dxd != null && this.dxd.aDb() != null) {
            if (!this.dxd.aDb().aDT()) {
                if (this.bIW) {
                    i = aEr();
                } else {
                    i = this.cSp.getResources().getDimensionPixelSize(t.e.ds240);
                }
            } else if (this.dxd.aDb().aDV()) {
                i = aEr();
            } else if (this.dxd.aDb().aDU()) {
            }
            if (this.dHJ != null) {
                this.dHJ.setLayoutParams(new AbsListView.LayoutParams(-1, i));
            }
        }
    }
}
