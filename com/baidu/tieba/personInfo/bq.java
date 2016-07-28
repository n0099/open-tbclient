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
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class bq {
    private TextView SW;
    private View aHK;
    private View axO;
    private View bWM;
    private BaseFragmentActivity bgI;
    private ViewEventCenter bgJ;
    private PbListView bjZ;
    private boolean ciS;
    private ImageView eCA;
    private TextView eCB;
    private MorePopupWindow eCC;
    private com.baidu.tieba.person.e eCD;
    public com.baidu.tieba.person.a.b eCE;
    private View eCF;
    private String eCk;
    private TextView eCl;
    private RelativeLayout eCm;
    private RelativeLayout eCn;
    private ImageView eCo;
    private ImageView eCp;
    public ImageView eCq;
    public ImageView eCr;
    private View eCs;
    private ImageView eCt;
    private BdPersonListView eCu;
    private e eCv;
    private LinearLayout eCw;
    private LinearLayout eCx;
    private LinearLayout eCy;
    private LinearLayout eCz;
    private h epz;
    private NavigationBar mNavigationBar;
    private int mSkinType;
    private BdListView.e zC;
    private boolean eCG = false;
    private boolean bGQ = true;

    public bq(h hVar, boolean z, ViewEventCenter viewEventCenter, View view) {
        this.axO = view;
        if (hVar != null) {
            this.epz = hVar;
            this.bgI = hVar.getBaseFragmentActivity();
            this.ciS = z;
            this.bgJ = viewEventCenter;
            this.eCk = hVar.aPe().getName();
            this.bWM = this.epz.getView();
            aQc();
            adB();
            aeG();
        }
    }

    private void aeG() {
        this.eCw = (LinearLayout) this.axO.findViewById(u.g.relation_root);
        this.eCx = (LinearLayout) this.axO.findViewById(u.g.relation_ll);
        this.eCx.setOnTouchListener(new br(this));
        this.aHK = this.axO.findViewById(u.g.line);
        this.eCy = (LinearLayout) this.axO.findViewById(u.g.relation_bg);
        this.eCy.setOnClickListener(this.epz);
        this.eCA = (ImageView) this.axO.findViewById(u.g.relation_icon);
        this.eCB = (TextView) this.axO.findViewById(u.g.relation_text);
    }

    private void aQa() {
        if (this.epz != null) {
            if (this.ciS || (this.epz.aPe() != null && this.epz.aPe().aPU())) {
                this.eCw.setVisibility(8);
            } else {
                PersonTainInfo aPD = this.epz.aPe().aPD();
                int isFriend = aPD != null ? aPD.getIsFriend() : 1;
                this.eCw.setVisibility(0);
                if (isFriend == 0) {
                    this.eCB.setText(u.j.addfriend);
                    com.baidu.tbadk.core.util.av.k(this.eCy, u.f.btn_all_blue);
                    com.baidu.tbadk.core.util.av.k(this.eCA, u.f.icon_person_add);
                    com.baidu.tbadk.core.util.av.c(this.eCB, u.d.cp_cont_i, 1);
                } else if (isFriend == 1) {
                    this.eCB.setText(u.j.user_info_center_head_viewpager_send_text_name);
                    com.baidu.tbadk.core.util.av.k(this.eCy, u.f.btn_all_white);
                    com.baidu.tbadk.core.util.av.k(this.eCA, u.f.icon_pop_news);
                    com.baidu.tbadk.core.util.av.c(this.eCB, u.d.cp_link_tip_c, 1);
                } else if (isFriend == 2) {
                    this.eCB.setText(u.j.acceptfriendapply);
                    com.baidu.tbadk.core.util.av.k(this.eCy, u.f.btn_all_blue);
                    com.baidu.tbadk.core.util.av.k(this.eCA, u.f.icon_pop_pass);
                    com.baidu.tbadk.core.util.av.c(this.eCB, u.d.cp_cont_i, 1);
                } else {
                    this.eCw.setVisibility(8);
                }
            }
            com.baidu.tbadk.core.util.av.l(this.aHK, u.d.cp_bg_line_e);
            com.baidu.tbadk.core.util.av.k(this.eCx, u.f.bg_mycenter_toolbar);
            j(this.epz.aPe().getUserData());
        }
    }

    public void aQb() {
        if (this.ciS) {
            AntiData antiData = this.epz.aPe().getAntiData();
            if (antiData != null) {
                if (AntiHelper.e(antiData) || AntiHelper.g(antiData)) {
                    com.baidu.tbadk.core.util.av.k(this.eCy, u.f.btn_pop_news);
                    com.baidu.tbadk.core.util.av.c(this.eCB, u.d.cp_link_tip_c, 1);
                }
            } else {
                return;
            }
        } else {
            PersonTainInfo aPD = this.epz.aPe().aPD();
            int isFriend = aPD != null ? aPD.getIsFriend() : 1;
            if (isFriend == 0) {
                com.baidu.tbadk.core.util.av.k(this.eCy, u.f.btn_all_blue);
                com.baidu.tbadk.core.util.av.k(this.eCA, u.f.icon_person_add);
                com.baidu.tbadk.core.util.av.c(this.eCB, u.d.cp_cont_i, 1);
            } else if (isFriend == 1) {
                com.baidu.tbadk.core.util.av.k(this.eCy, u.f.btn_pop_news);
                com.baidu.tbadk.core.util.av.k(this.eCA, u.f.icon_pop_news);
                com.baidu.tbadk.core.util.av.c(this.eCB, u.d.cp_link_tip_c, 1);
            } else if (isFriend == 2) {
                com.baidu.tbadk.core.util.av.k(this.eCy, u.f.btn_all_blue);
                com.baidu.tbadk.core.util.av.k(this.eCA, u.f.icon_pop_pass);
                com.baidu.tbadk.core.util.av.c(this.eCB, u.d.cp_cont_i, 1);
            } else {
                this.eCw.setVisibility(8);
            }
        }
        com.baidu.tbadk.core.util.av.l(this.aHK, u.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.av.k(this.eCx, u.f.bg_mycenter_toolbar);
        j(this.epz.aPe().getUserData());
    }

    private void j(UserData userData) {
        if (userData != null && userData.getIsOfficialAccount() == 1) {
            this.eCB.setText(u.j.user_info_center_head_viewpager_send_text_name);
            com.baidu.tbadk.core.util.av.k(this.eCy, u.f.btn_pop_news);
            com.baidu.tbadk.core.util.av.k(this.eCA, u.f.icon_pop_news);
            com.baidu.tbadk.core.util.av.c(this.eCB, u.d.cp_link_tip_c, 1);
        }
    }

    private void aQc() {
        this.mNavigationBar = (NavigationBar) this.axO.findViewById(u.g.navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setOnTouchListener(new bs(this));
        int c = com.baidu.adp.lib.util.k.c(this.bgI.getPageContext().getPageActivity(), u.e.ds16);
        if (this.bgI instanceof PersonInfoActivity) {
            this.eCs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.bgI);
            this.eCs.setOnClickListener(this.epz);
            this.mNavigationBar.setTitleText("");
            if (!this.ciS) {
                this.eCt = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.nb_item_floor_more, this.bgI);
                this.eCt.setContentDescription(this.bgI.getPageContext().getString(u.j.more));
                this.eCt.setVisibility(8);
                if (this.eCt != null && TbadkCoreApplication.isLogin()) {
                    this.eCt.setOnClickListener(this.epz);
                    this.eCt.setVisibility(0);
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eCt.getLayoutParams();
                layoutParams.rightMargin = c;
                this.eCt.setLayoutParams(layoutParams);
            }
        } else {
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, u.h.maintab_title_layout, (View.OnClickListener) null);
            this.SW = (TextView) addCustomView.findViewById(u.g.title_textview);
            this.eCl = (TextView) addCustomView.findViewById(u.g.another_title_textview);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.bgI.getResources().getDimension(u.e.ds16);
            com.baidu.tbadk.core.util.av.b(this.SW, u.d.cp_cont_b, u.d.cp_cont_b);
            com.baidu.tbadk.core.util.av.b(this.eCl, u.d.cp_cont_b, u.d.cp_cont_b);
            layoutParams2.setMargins(dimension, dimension, 0, dimension);
            this.SW.setLayoutParams(layoutParams2);
            this.SW.setText(u.j.mine);
            this.eCl.setLayoutParams(layoutParams2);
            this.eCl.setText(u.j.mine);
            if (TbadkCoreApplication.m10getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
                this.eCn = (RelativeLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.nb_item_floor_more_tip, this.bgI);
                this.eCn.setContentDescription(TbadkCoreApplication.m10getInst().getResources().getString(u.j.dressup_center_title));
                this.eCr = (ImageView) this.eCn.findViewById(u.g.btnmore_red_tip);
                this.eCn.setOnClickListener(new bt(this));
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.eCn.getLayoutParams();
                layoutParams3.rightMargin = com.baidu.adp.lib.util.k.c(this.bgI.getPageContext().getPageActivity(), u.e.ds20);
                this.eCn.setLayoutParams(layoutParams3);
                this.eCo = (ImageView) this.eCn.findViewById(u.g.btnmore_image);
            }
            if (TbadkCoreApplication.m10getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
                this.eCm = (RelativeLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.nb_item_floor_more_tip, this.bgI);
                this.eCm.setContentDescription(TbadkCoreApplication.m10getInst().getResources().getString(u.j.setup));
                this.eCq = (ImageView) this.eCm.findViewById(u.g.btnmore_red_tip);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (!com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                    this.eCq.setVisibility(0);
                }
                this.eCm.setOnClickListener(new bu(this));
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.eCm.getLayoutParams();
                layoutParams4.rightMargin = c;
                this.eCm.setLayoutParams(layoutParams4);
                if (!PersonInfoActivityConfig.IS_SUPPORT_EDIT) {
                    this.eCm.setVisibility(8);
                }
                this.eCp = (ImageView) this.eCm.findViewById(u.g.btnmore_image);
            }
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mNavigationBar.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.mNavigationBar.getMeasuredHeight();
        this.eCF = this.axO.findViewById(u.g.view_navigation_bar_bg);
        FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) this.eCF.getLayoutParams();
        layoutParams5.height = measuredHeight;
        this.eCF.setLayoutParams(layoutParams5);
        if (Build.VERSION.SDK_INT >= 11) {
            this.eCF.setAlpha(0.0f);
        } else {
            this.eCF.setVisibility(8);
        }
    }

    private void aQd() {
        this.eCF.setBackgroundDrawable(com.baidu.tbadk.core.util.av.getDrawable(u.f.s_navbar_bg));
    }

    private void adB() {
        this.eCu = (BdPersonListView) this.axO.findViewById(u.g.personcenter_list);
        this.eCv = new e(this.epz, this.ciS, this.bgJ);
        this.eCu.addHeaderView(this.eCv.getRootView());
        this.eCu.e(this.eCv.getRootView(), this.bgI.getResources().getDimensionPixelSize(u.e.ds568));
        this.eCE = new com.baidu.tieba.person.a.b(this.epz, this.eCu);
        this.eCE.ap(this.epz.aPe().getDataList());
        this.eCE.notifyDataSetChanged();
        this.eCu.setOnScrollListener(new bv(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQe() {
        float f;
        if (!(this.bgI instanceof PersonInfoActivity) && aQr() != 2) {
            float alpha = this.eCF.getAlpha();
            if (alpha < 0.5f) {
                if (!this.bGQ) {
                    this.bGQ = true;
                    if (this.eCn != null && this.eCo != null) {
                        com.baidu.tbadk.core.util.av.b(this.eCo, u.f.icon_person_dressup_w, u.f.icon_person_dressup_w);
                    }
                    if (this.eCm != null && this.eCp != null) {
                        com.baidu.tbadk.core.util.av.b(this.eCp, u.f.icon_home_setting_w, u.f.icon_home_setting_w);
                    }
                    this.SW.setVisibility(0);
                    this.eCl.setVisibility(8);
                    com.baidu.tbadk.core.util.av.b(this.SW, u.d.cp_cont_i, u.d.cp_cont_i);
                }
            } else if (this.bGQ) {
                this.bGQ = false;
                if (this.eCn != null && this.eCo != null) {
                    com.baidu.tbadk.core.util.av.b(this.eCo, u.f.icon_person_dressup_s, u.f.icon_person_dressup_s);
                }
                if (this.eCm != null && this.eCp != null) {
                    com.baidu.tbadk.core.util.av.b(this.eCp, u.f.icon_home_setting_s, u.f.icon_home_setting_s);
                }
                this.SW.setVisibility(8);
                this.eCl.setVisibility(0);
                com.baidu.tbadk.core.util.av.b(this.eCl, u.d.cp_cont_b, u.d.s_navbar_title_color);
            }
            this.SW.setAlpha(1.0f - alpha);
            this.eCl.setAlpha(alpha);
            if (alpha < 0.5f) {
                f = 1.0f - (alpha * 2.0f);
            } else {
                f = (alpha * 2.0f) - 1.0f;
            }
            if (f >= 0.0f && f <= 1.0f) {
                if (this.eCn != null && this.eCo != null) {
                    this.eCo.setAlpha(f);
                }
                if (this.eCm != null && this.eCp != null) {
                    this.eCp.setAlpha(f);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKW() {
        if (Build.VERSION.SDK_INT >= 11) {
            int dimension = (int) this.bgI.getResources().getDimension(u.e.ds98);
            int dimension2 = ((int) this.bgI.getResources().getDimension(u.e.ds450)) - (-this.eCv.getRootView().getTop());
            if (dimension2 < dimension) {
                if (this.eCF.getAlpha() != 1.0f) {
                    this.eCF.setAlpha(1.0f);
                }
            } else if (dimension2 >= dimension && dimension2 <= dimension * 2) {
                this.eCF.setAlpha(1.0f - (((dimension2 - dimension) * 1.0f) / dimension));
            } else if (dimension2 > dimension * 2 && this.eCF.getAlpha() != 0.0f) {
                this.eCF.setAlpha(0.0f);
            }
            if (this.eCu.getFirstVisiblePosition() > 0 && this.eCF.getAlpha() != 1.0f) {
                this.eCF.setAlpha(1.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQf() {
        if ((this.bgI instanceof PersonInfoActivity) && Build.VERSION.SDK_INT >= 11) {
            if (this.eCF.getAlpha() == 1.0f) {
                if (!this.eCG) {
                    this.mNavigationBar.setTitleText(this.eCk);
                    this.eCG = true;
                }
            } else if (this.eCG) {
                this.mNavigationBar.setTitleText("");
                this.eCG = false;
            }
        }
    }

    public void onDestroy() {
        this.eCv.aOj();
        this.eCu.removeHeaderView(this.eCv.getRootView());
        if (this.eCz != null) {
            this.eCu.removeFooterView(this.eCz);
        }
    }

    public void ahV() {
        this.eCu.jm();
    }

    public void aap() {
        this.eCv.aap();
    }

    public void setPersonListRefreshListener(BdPersonListView.a aVar) {
        this.eCu.setPersonListRefreshListener(aVar);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        if (this.bjZ == null) {
            this.bjZ = new PbListView(this.bgI.getActivity());
            this.bjZ.jp();
            this.bjZ.cS(u.d.cp_bg_line_c);
            this.bjZ.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.cp_cont_d));
            this.bjZ.cT(TbadkCoreApplication.m10getInst().getSkinType());
        }
        this.eCu.setNextPage(this.bjZ);
        aQg();
        this.zC = eVar;
        this.eCu.setOnScrollListener(new bw(this));
    }

    public void UV() {
        if (this.bjZ != null) {
            this.bjZ.getView().setVisibility(0);
            this.bjZ.vh();
        }
    }

    public void aNY() {
        if (this.bjZ != null) {
            this.bjZ.getView().setVisibility(0);
            this.bjZ.setText(this.epz.getString(u.j.list_no_more_god_threads));
            this.bjZ.vi();
        }
    }

    public void aQg() {
        if (this.bjZ != null) {
            this.bjZ.getView().setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            aQq();
        }
        this.mSkinType = i;
        com.baidu.tbadk.core.util.av.l(this.eCu, u.d.cp_bg_line_c);
        this.bgI.getLayoutMode().af(i == 1);
        this.bgI.getLayoutMode().w(this.bWM);
        this.eCv.kT();
        this.eCE.notifyDataSetChanged();
        aQb();
        this.mNavigationBar.onChangeSkinType(this.bgI.getPageContext(), i);
        com.baidu.tbadk.core.util.av.k(this.mNavigationBar, u.d.common_color_10262);
        aQm();
        if (this.eCr != null && this.eCr.getVisibility() == 0) {
            com.baidu.tbadk.core.util.av.c(this.eCr, u.f.icon_news_down_bar_one);
        }
        if (this.eCq != null && this.eCq.getVisibility() == 0) {
            com.baidu.tbadk.core.util.av.c(this.eCq, u.f.icon_news_down_bar_one);
        }
        if (this.eCz != null) {
            com.baidu.tbadk.core.util.av.l(this.eCz, u.d.cp_bg_line_c);
        }
        if (this.bjZ != null) {
            this.bjZ.cS(u.d.cp_bg_line_c);
            this.bjZ.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.cp_cont_d));
            this.bjZ.cT(i);
        }
        aQd();
    }

    public UserIconBox getUserIcon() {
        return this.eCv.getUserIcon();
    }

    public e aQh() {
        return this.eCv;
    }

    public View getAttentionView() {
        return this.eCv.getAttentionView();
    }

    public View aQi() {
        return this.eCy;
    }

    public void aQj() {
        aQl();
        aQa();
        if (this.eCv != null && this.epz.aPe().getUserData() != null) {
            if (this.epz.aPe().getUserData() != null && this.epz.aPe().getUserData().getUserTbVipInfoData() != null && this.epz.aPe().getUserData().getUserTbVipInfoData().getvipV_url() != null) {
                this.eCv.ot(3);
            } else if (this.epz.aPe().aPU()) {
                this.eCv.ot(2);
            } else {
                this.eCv.ot(1);
            }
            this.eCv.RP();
        }
        aQq();
        aQt();
        if (this.eCE != null && this.epz != null && this.epz.aPe() != null) {
            this.eCE.ap(this.epz.aPe().getDataList());
        }
        aQm();
    }

    public com.baidu.tieba.person.a.b aQk() {
        return this.eCE;
    }

    private void aQl() {
        if (this.epz != null && this.epz.aPe() != null && this.epz.aPe().getUserData() != null) {
            this.eCk = this.epz.aPe().getUserData().getUserName();
        }
    }

    public HeadImageView getHeadImage() {
        return this.eCv.getHeadImage();
    }

    public void aQm() {
        ImageView imageView;
        if (!(this.bgI instanceof PersonInfoActivity)) {
            if (this.eCn != null && (imageView = (ImageView) this.eCn.findViewById(u.g.btnmore_image)) != null) {
                if (aQr() == 2) {
                    com.baidu.tbadk.core.util.av.b(imageView, u.f.icon_person_dressup_s, u.f.icon_person_dressup);
                } else if (this.eCF.getAlpha() < 0.5f) {
                    com.baidu.tbadk.core.util.av.b(imageView, u.f.icon_person_dressup_w, u.f.icon_person_dressup_w);
                } else {
                    com.baidu.tbadk.core.util.av.b(imageView, u.f.icon_person_dressup_s, u.f.icon_person_dressup_s);
                }
            }
            if (this.eCm != null) {
                ImageView imageView2 = (ImageView) this.eCm.findViewById(u.g.btnmore_image);
                if (imageView2 != null) {
                    if (aQr() == 2) {
                        com.baidu.tbadk.core.util.av.b(imageView2, u.f.icon_home_setting_s, u.f.icon_home_setting);
                    } else if (this.eCF.getAlpha() < 0.5f) {
                        com.baidu.tbadk.core.util.av.b(imageView2, u.f.icon_home_setting_w, u.f.icon_home_setting_w);
                    } else {
                        com.baidu.tbadk.core.util.av.b(imageView2, u.f.icon_home_setting_s, u.f.icon_home_setting_s);
                    }
                }
                if (TbadkCoreApplication.isLogin() && PersonInfoActivityConfig.IS_SUPPORT_EDIT) {
                    this.eCm.setVisibility(0);
                } else {
                    this.eCm.setVisibility(8);
                }
            }
            if (aQr() == 2) {
                com.baidu.tbadk.core.util.av.b(this.SW, u.d.cp_cont_b, u.d.s_navbar_title_color);
            } else {
                com.baidu.tbadk.core.util.av.b(this.SW, u.d.cp_cont_i, u.d.cp_cont_i);
            }
            com.baidu.tbadk.core.util.av.b(this.eCl, u.d.cp_cont_b, u.d.cp_cont_i);
        } else if (this.eCt != null) {
            com.baidu.tbadk.core.util.av.b(this.eCt, u.f.icon_more_bg_s, u.f.icon_more_bg);
        }
    }

    public LinearLayout getMyGiftIcon() {
        return this.eCv.getMyGiftIcon();
    }

    public void iC(boolean z) {
    }

    public void ou(int i) {
    }

    public void a(boolean z, boolean z2, int i) {
        this.eCD = new com.baidu.tieba.person.e(this.epz);
        this.eCC = new MorePopupWindow(this.bgI.getPageContext().getPageActivity(), this.eCD.getView(), this.mNavigationBar, this.bgI.getResources().getDrawable(u.f.bg_pull_down_right_n), new bx(this));
        this.eCC.onChangeSkinType(this.bgI, this.mSkinType, this.bgI.getResources().getDrawable(u.f.bg_pull_down_right_n));
        this.eCD.t(z, z2);
        if (i != -1) {
            this.eCD.od(i);
        }
        this.eCC.refresh();
        this.eCC.showWindowInRightBottomOfHost();
    }

    public void aQn() {
        com.baidu.adp.lib.h.j.a(this.eCC, this.bgI.getPageContext().getPageActivity());
    }

    public ImageView aQo() {
        return this.eCt;
    }

    public View aQp() {
        return this.eCs;
    }

    public View aNr() {
        if (this.eCD == null) {
            return null;
        }
        return this.eCD.aNr();
    }

    public View aNq() {
        if (this.eCD == null) {
            return null;
        }
        return this.eCD.aNq();
    }

    public View aNs() {
        if (this.eCD == null) {
            return null;
        }
        return this.eCD.aNs();
    }

    public void b(d dVar) {
        this.eCE.epD.a(dVar);
    }

    public void d(com.baidu.adp.widget.ListView.w wVar) {
        this.eCE.d(wVar);
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.eCE != null && this.eCE.epL != null) {
            this.eCE.epL.L(onClickListener);
        }
    }

    private void aQq() {
        if (this.eCz == null) {
            this.eCz = new LinearLayout(this.bgI.getPageContext().getContext());
            this.eCz.setVisibility(0);
        }
        if (this.bgI != null && this.eCu != null) {
            int aQs = aQs();
            if (!this.ciS) {
                aQs = this.bgI.getResources().getDimensionPixelSize(u.e.ds240);
            }
            this.eCz.setLayoutParams(new AbsListView.LayoutParams(-1, aQs));
            com.baidu.tbadk.core.util.av.l(this.eCz, u.d.cp_bg_line_c);
            this.eCu.removeFooterView(this.eCz);
            this.eCu.addFooterView(this.eCz);
        }
    }

    private int aQr() {
        return TbadkCoreApplication.m10getInst().getSkinType();
    }

    private int aQs() {
        int dimensionPixelSize = this.bgI.getResources().getDimensionPixelSize(u.e.ds170);
        if (aQr() == 2) {
            return this.bgI.getResources().getDimensionPixelSize(u.e.ds70);
        }
        return dimensionPixelSize;
    }

    private void aQt() {
        int i = 0;
        if (this.epz != null && this.epz.aPe() != null) {
            if (!this.epz.aPe().aPU()) {
                if (this.ciS) {
                    i = aQs();
                } else {
                    i = this.bgI.getResources().getDimensionPixelSize(u.e.ds240);
                }
            } else if (this.epz.aPe().aPW()) {
                i = aQs();
            } else if (this.epz.aPe().aPV()) {
            }
            if (this.eCz != null) {
                this.eCz.setLayoutParams(new AbsListView.LayoutParams(-1, i));
            }
        }
    }
}
