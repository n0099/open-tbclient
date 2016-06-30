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
public class bs {
    private TextView So;
    private View aGT;
    private View axa;
    private View bUM;
    private BaseFragmentActivity bfw;
    private ViewEventCenter bfx;
    private PbListView biC;
    private boolean cgJ;
    private f efz;
    private TextView eqA;
    private RelativeLayout eqB;
    private RelativeLayout eqC;
    private ImageView eqD;
    private ImageView eqE;
    public ImageView eqF;
    public ImageView eqG;
    private View eqH;
    private ImageView eqI;
    private BdPersonListView eqJ;
    private c eqK;
    private LinearLayout eqL;
    private LinearLayout eqM;
    private LinearLayout eqN;
    private LinearLayout eqO;
    private ImageView eqP;
    private TextView eqQ;
    private MorePopupWindow eqR;
    private com.baidu.tieba.person.bp eqS;
    public com.baidu.tieba.person.a.b eqT;
    private View eqU;
    private String eqz;
    private NavigationBar mNavigationBar;
    private int mSkinType;
    private BdListView.e zb;
    private boolean eqV = false;
    private boolean bFC = true;

    public bs(f fVar, boolean z, ViewEventCenter viewEventCenter, View view) {
        this.axa = view;
        if (fVar != null) {
            this.efz = fVar;
            this.bfw = fVar.getBaseFragmentActivity();
            this.cgJ = z;
            this.bfx = viewEventCenter;
            this.eqz = fVar.aLZ().getName();
            this.bUM = this.efz.getView();
            aMZ();
            acZ();
            aed();
        }
    }

    private void aed() {
        this.eqL = (LinearLayout) this.axa.findViewById(u.g.relation_root);
        this.eqM = (LinearLayout) this.axa.findViewById(u.g.relation_ll);
        this.aGT = this.axa.findViewById(u.g.line);
        this.eqN = (LinearLayout) this.axa.findViewById(u.g.relation_bg);
        this.eqN.setOnClickListener(this.efz);
        this.eqP = (ImageView) this.axa.findViewById(u.g.relation_icon);
        this.eqQ = (TextView) this.axa.findViewById(u.g.relation_text);
    }

    private void aMX() {
        if (this.efz != null) {
            if (this.cgJ || (this.efz.aLZ() != null && this.efz.aLZ().aMR())) {
                this.eqL.setVisibility(8);
            } else {
                PersonTainInfo aMy = this.efz.aLZ().aMy();
                int isFriend = aMy != null ? aMy.getIsFriend() : 1;
                this.eqL.setVisibility(0);
                if (isFriend == 0) {
                    this.eqQ.setText(u.j.addfriend);
                    com.baidu.tbadk.core.util.av.k(this.eqN, u.f.btn_all_blue);
                    com.baidu.tbadk.core.util.av.k(this.eqP, u.f.icon_person_add);
                    com.baidu.tbadk.core.util.av.c(this.eqQ, u.d.cp_cont_i, 1);
                } else if (isFriend == 1) {
                    this.eqQ.setText(u.j.user_info_center_head_viewpager_send_text_name);
                    com.baidu.tbadk.core.util.av.k(this.eqN, u.f.btn_all_white);
                    com.baidu.tbadk.core.util.av.k(this.eqP, u.f.icon_pop_news);
                    com.baidu.tbadk.core.util.av.c(this.eqQ, u.d.cp_link_tip_c, 1);
                } else if (isFriend == 2) {
                    this.eqQ.setText(u.j.acceptfriendapply);
                    com.baidu.tbadk.core.util.av.k(this.eqN, u.f.btn_all_blue);
                    com.baidu.tbadk.core.util.av.k(this.eqP, u.f.icon_pop_pass);
                    com.baidu.tbadk.core.util.av.c(this.eqQ, u.d.cp_cont_i, 1);
                } else {
                    this.eqL.setVisibility(8);
                }
            }
            com.baidu.tbadk.core.util.av.l(this.aGT, u.d.cp_bg_line_e);
            com.baidu.tbadk.core.util.av.k(this.eqM, u.f.bg_mycenter_toolbar);
            j(this.efz.aLZ().getUserData());
        }
    }

    public void aMY() {
        if (this.cgJ) {
            AntiData antiData = this.efz.aLZ().getAntiData();
            if (antiData != null) {
                if (AntiHelper.e(antiData) || AntiHelper.g(antiData)) {
                    com.baidu.tbadk.core.util.av.k(this.eqN, u.f.btn_pop_news);
                    com.baidu.tbadk.core.util.av.c(this.eqQ, u.d.cp_link_tip_c, 1);
                }
            } else {
                return;
            }
        } else {
            PersonTainInfo aMy = this.efz.aLZ().aMy();
            int isFriend = aMy != null ? aMy.getIsFriend() : 1;
            if (isFriend == 0) {
                com.baidu.tbadk.core.util.av.k(this.eqN, u.f.btn_all_blue);
                com.baidu.tbadk.core.util.av.k(this.eqP, u.f.icon_person_add);
                com.baidu.tbadk.core.util.av.c(this.eqQ, u.d.cp_cont_i, 1);
            } else if (isFriend == 1) {
                com.baidu.tbadk.core.util.av.k(this.eqN, u.f.btn_pop_news);
                com.baidu.tbadk.core.util.av.k(this.eqP, u.f.icon_pop_news);
                com.baidu.tbadk.core.util.av.c(this.eqQ, u.d.cp_link_tip_c, 1);
            } else if (isFriend == 2) {
                com.baidu.tbadk.core.util.av.k(this.eqN, u.f.btn_all_blue);
                com.baidu.tbadk.core.util.av.k(this.eqP, u.f.icon_pop_pass);
                com.baidu.tbadk.core.util.av.c(this.eqQ, u.d.cp_cont_i, 1);
            } else {
                this.eqL.setVisibility(8);
            }
        }
        com.baidu.tbadk.core.util.av.l(this.aGT, u.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.av.k(this.eqM, u.f.bg_mycenter_toolbar);
        j(this.efz.aLZ().getUserData());
    }

    private void j(UserData userData) {
        if (userData != null && userData.getIsOfficialAccount() == 1) {
            this.eqQ.setText(u.j.user_info_center_head_viewpager_send_text_name);
            com.baidu.tbadk.core.util.av.k(this.eqN, u.f.btn_pop_news);
            com.baidu.tbadk.core.util.av.k(this.eqP, u.f.icon_pop_news);
            com.baidu.tbadk.core.util.av.c(this.eqQ, u.d.cp_link_tip_c, 1);
        }
    }

    private void aMZ() {
        this.mNavigationBar = (NavigationBar) this.axa.findViewById(u.g.navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setOnTouchListener(new bt(this));
        int c = com.baidu.adp.lib.util.k.c(this.bfw.getPageContext().getPageActivity(), u.e.ds16);
        if (this.bfw instanceof PersonInfoActivity) {
            this.eqH = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.bfw);
            this.eqH.setOnClickListener(this.efz);
            this.mNavigationBar.setTitleText("");
            if (!this.cgJ) {
                this.eqI = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.nb_item_floor_more, this.bfw);
                this.eqI.setContentDescription(this.bfw.getPageContext().getString(u.j.more));
                this.eqI.setVisibility(8);
                if (this.eqI != null && TbadkCoreApplication.isLogin()) {
                    this.eqI.setOnClickListener(this.efz);
                    this.eqI.setVisibility(0);
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eqI.getLayoutParams();
                layoutParams.rightMargin = c;
                this.eqI.setLayoutParams(layoutParams);
            }
        } else {
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, u.h.maintab_title_layout, (View.OnClickListener) null);
            this.So = (TextView) addCustomView.findViewById(u.g.title_textview);
            this.eqA = (TextView) addCustomView.findViewById(u.g.another_title_textview);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.bfw.getResources().getDimension(u.e.ds16);
            com.baidu.tbadk.core.util.av.b(this.So, u.d.cp_cont_b, u.d.cp_cont_b);
            com.baidu.tbadk.core.util.av.b(this.eqA, u.d.cp_cont_b, u.d.cp_cont_b);
            layoutParams2.setMargins(dimension, dimension, 0, dimension);
            this.So.setLayoutParams(layoutParams2);
            this.So.setText(u.j.mine);
            this.eqA.setLayoutParams(layoutParams2);
            this.eqA.setText(u.j.mine);
            if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
                this.eqC = (RelativeLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.nb_item_floor_more_tip, this.bfw);
                this.eqC.setContentDescription(TbadkCoreApplication.m9getInst().getResources().getString(u.j.dressup_center_title));
                this.eqG = (ImageView) this.eqC.findViewById(u.g.btnmore_red_tip);
                this.eqC.setOnClickListener(new bu(this));
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.eqC.getLayoutParams();
                layoutParams3.rightMargin = com.baidu.adp.lib.util.k.c(this.bfw.getPageContext().getPageActivity(), u.e.ds20);
                this.eqC.setLayoutParams(layoutParams3);
                this.eqD = (ImageView) this.eqC.findViewById(u.g.btnmore_image);
            }
            if (TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
                this.eqB = (RelativeLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.nb_item_floor_more_tip, this.bfw);
                this.eqB.setContentDescription(TbadkCoreApplication.m9getInst().getResources().getString(u.j.setup));
                this.eqF = (ImageView) this.eqB.findViewById(u.g.btnmore_red_tip);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (!com.baidu.tbadk.core.sharedPref.b.sO().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj.isMemberCloseAdIsOpen()) {
                    this.eqF.setVisibility(0);
                }
                this.eqB.setOnClickListener(new bv(this));
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.eqB.getLayoutParams();
                layoutParams4.rightMargin = c;
                this.eqB.setLayoutParams(layoutParams4);
                if (!PersonInfoActivityConfig.IS_SUPPORT_EDIT) {
                    this.eqB.setVisibility(8);
                }
                this.eqE = (ImageView) this.eqB.findViewById(u.g.btnmore_image);
            }
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mNavigationBar.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.mNavigationBar.getMeasuredHeight();
        this.eqU = this.axa.findViewById(u.g.view_navigation_bar_bg);
        FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) this.eqU.getLayoutParams();
        layoutParams5.height = measuredHeight;
        this.eqU.setLayoutParams(layoutParams5);
        if (Build.VERSION.SDK_INT >= 11) {
            this.eqU.setAlpha(0.0f);
        } else {
            this.eqU.setVisibility(8);
        }
    }

    private void aNa() {
        this.eqU.setBackgroundDrawable(com.baidu.tbadk.core.util.av.getDrawable(u.f.s_navbar_bg));
    }

    private void acZ() {
        this.eqJ = (BdPersonListView) this.axa.findViewById(u.g.personcenter_list);
        this.eqK = new c(this.efz, this.cgJ, this.bfx);
        this.eqJ.addHeaderView(this.eqK.getRootView());
        this.eqJ.e(this.eqK.getRootView(), this.bfw.getResources().getDimensionPixelSize(u.e.ds568));
        this.eqT = new com.baidu.tieba.person.a.b(this.efz, this.eqJ);
        this.eqT.an(this.efz.aLZ().getDataList());
        this.eqT.notifyDataSetChanged();
        this.eqJ.setOnScrollListener(new bw(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNb() {
        float f;
        if (!(this.bfw instanceof PersonInfoActivity) && aNo() != 2) {
            float alpha = this.eqU.getAlpha();
            if (alpha < 0.5f) {
                if (!this.bFC) {
                    this.bFC = true;
                    if (this.eqC != null && this.eqD != null) {
                        com.baidu.tbadk.core.util.av.a(this.eqD, u.f.icon_person_dressup_w, u.f.icon_person_dressup_w);
                    }
                    if (this.eqB != null && this.eqE != null) {
                        com.baidu.tbadk.core.util.av.a(this.eqE, u.f.icon_home_setting_w, u.f.icon_home_setting_w);
                    }
                    this.So.setVisibility(0);
                    this.eqA.setVisibility(8);
                    com.baidu.tbadk.core.util.av.b(this.So, u.d.cp_cont_i, u.d.cp_cont_i);
                }
            } else if (this.bFC) {
                this.bFC = false;
                if (this.eqC != null && this.eqD != null) {
                    com.baidu.tbadk.core.util.av.a(this.eqD, u.f.icon_person_dressup_s, u.f.icon_person_dressup_s);
                }
                if (this.eqB != null && this.eqE != null) {
                    com.baidu.tbadk.core.util.av.a(this.eqE, u.f.icon_home_setting_s, u.f.icon_home_setting_s);
                }
                this.So.setVisibility(8);
                this.eqA.setVisibility(0);
                com.baidu.tbadk.core.util.av.b(this.eqA, u.d.cp_cont_b, u.d.s_navbar_title_color);
            }
            this.So.setAlpha(1.0f - alpha);
            this.eqA.setAlpha(alpha);
            if (alpha < 0.5f) {
                f = 1.0f - (alpha * 2.0f);
            } else {
                f = (alpha * 2.0f) - 1.0f;
            }
            if (f >= 0.0f && f <= 1.0f) {
                if (this.eqC != null && this.eqD != null) {
                    this.eqD.setAlpha(f);
                }
                if (this.eqB != null && this.eqE != null) {
                    this.eqE.setAlpha(f);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHM() {
        if (Build.VERSION.SDK_INT >= 11) {
            int dimension = (int) this.bfw.getResources().getDimension(u.e.ds98);
            int dimension2 = ((int) this.bfw.getResources().getDimension(u.e.ds450)) - (-this.eqK.getRootView().getTop());
            if (dimension2 < dimension) {
                if (this.eqU.getAlpha() != 1.0f) {
                    this.eqU.setAlpha(1.0f);
                }
            } else if (dimension2 >= dimension && dimension2 <= dimension * 2) {
                this.eqU.setAlpha(1.0f - (((dimension2 - dimension) * 1.0f) / dimension));
            } else if (dimension2 > dimension * 2 && this.eqU.getAlpha() != 0.0f) {
                this.eqU.setAlpha(0.0f);
            }
            if (this.eqJ.getFirstVisiblePosition() > 0 && this.eqU.getAlpha() != 1.0f) {
                this.eqU.setAlpha(1.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNc() {
        if ((this.bfw instanceof PersonInfoActivity) && Build.VERSION.SDK_INT >= 11) {
            if (this.eqU.getAlpha() == 1.0f) {
                if (!this.eqV) {
                    this.mNavigationBar.setTitleText(this.eqz);
                    this.eqV = true;
                }
            } else if (this.eqV) {
                this.mNavigationBar.setTitleText("");
                this.eqV = false;
            }
        }
    }

    public void onDestroy() {
        this.eqK.aLG();
        this.eqJ.removeHeaderView(this.eqK.getRootView());
        if (this.eqO != null) {
            this.eqJ.removeFooterView(this.eqO);
        }
    }

    public void ahm() {
        this.eqJ.jn();
    }

    public void US() {
        this.eqK.US();
    }

    public void setPersonListRefreshListener(BdPersonListView.a aVar) {
        this.eqJ.setPersonListRefreshListener(aVar);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        if (this.biC == null) {
            this.biC = new PbListView(this.bfw.getActivity());
            this.biC.jq();
            this.biC.cS(u.d.cp_bg_line_c);
            this.biC.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.cp_cont_d));
            this.biC.cT(TbadkCoreApplication.m9getInst().getSkinType());
        }
        this.eqJ.setNextPage(this.biC);
        aNd();
        this.zb = eVar;
        this.eqJ.setOnScrollListener(new bx(this));
    }

    public void Un() {
        if (this.biC != null) {
            this.biC.getView().setVisibility(0);
            this.biC.vh();
        }
    }

    public void aLv() {
        if (this.biC != null) {
            this.biC.getView().setVisibility(0);
            this.biC.setText(this.efz.getString(u.j.list_no_more_god_threads));
            this.biC.vi();
        }
    }

    public void aNd() {
        if (this.biC != null) {
            this.biC.getView().setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            aNn();
        }
        this.mSkinType = i;
        com.baidu.tbadk.core.util.av.l(this.eqJ, u.d.cp_bg_line_c);
        this.bfw.getLayoutMode().ad(i == 1);
        this.bfw.getLayoutMode().w(this.bUM);
        this.eqK.kX();
        this.eqT.notifyDataSetChanged();
        aMY();
        this.mNavigationBar.onChangeSkinType(this.bfw.getPageContext(), i);
        com.baidu.tbadk.core.util.av.k(this.mNavigationBar, u.d.common_color_10262);
        aNj();
        if (this.eqG != null && this.eqG.getVisibility() == 0) {
            com.baidu.tbadk.core.util.av.c(this.eqG, u.f.icon_news_down_bar_one);
        }
        if (this.eqF != null && this.eqF.getVisibility() == 0) {
            com.baidu.tbadk.core.util.av.c(this.eqF, u.f.icon_news_down_bar_one);
        }
        if (this.eqO != null) {
            com.baidu.tbadk.core.util.av.l(this.eqO, u.d.cp_bg_line_c);
        }
        if (this.biC != null) {
            this.biC.cS(u.d.cp_bg_line_c);
            this.biC.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.cp_cont_d));
            this.biC.cT(i);
        }
        aNa();
    }

    public UserIconBox getUserIcon() {
        return this.eqK.getUserIcon();
    }

    public c aNe() {
        return this.eqK;
    }

    public View getAttentionView() {
        return this.eqK.getAttentionView();
    }

    public View aNf() {
        return this.eqN;
    }

    public void aNg() {
        aNi();
        aMX();
        if (this.eqK != null && this.efz.aLZ().getUserData() != null) {
            if (this.efz.aLZ().aMR()) {
                this.eqK.od(2);
            } else {
                this.eqK.od(1);
            }
            this.eqK.Ri();
        }
        aNn();
        aNq();
        if (this.eqT != null) {
            this.eqT.notifyDataSetChanged();
        }
        aNj();
    }

    public com.baidu.tieba.person.a.b aNh() {
        return this.eqT;
    }

    private void aNi() {
        if (this.efz != null && this.efz.aLZ() != null && this.efz.aLZ().getUserData() != null) {
            this.eqz = this.efz.aLZ().getUserData().getUserName();
        }
    }

    public HeadImageView getHeadImage() {
        return this.eqK.getHeadImage();
    }

    public void aNj() {
        ImageView imageView;
        if (!(this.bfw instanceof PersonInfoActivity)) {
            if (this.eqC != null && (imageView = (ImageView) this.eqC.findViewById(u.g.btnmore_image)) != null) {
                if (aNo() == 2) {
                    com.baidu.tbadk.core.util.av.a(imageView, u.f.icon_person_dressup_s, u.f.icon_person_dressup);
                } else if (this.eqU.getAlpha() < 0.5f) {
                    com.baidu.tbadk.core.util.av.a(imageView, u.f.icon_person_dressup_w, u.f.icon_person_dressup_w);
                } else {
                    com.baidu.tbadk.core.util.av.a(imageView, u.f.icon_person_dressup_s, u.f.icon_person_dressup_s);
                }
            }
            if (this.eqB != null) {
                ImageView imageView2 = (ImageView) this.eqB.findViewById(u.g.btnmore_image);
                if (imageView2 != null) {
                    if (aNo() == 2) {
                        com.baidu.tbadk.core.util.av.a(imageView2, u.f.icon_home_setting_s, u.f.icon_home_setting);
                    } else if (this.eqU.getAlpha() < 0.5f) {
                        com.baidu.tbadk.core.util.av.a(imageView2, u.f.icon_home_setting_w, u.f.icon_home_setting_w);
                    } else {
                        com.baidu.tbadk.core.util.av.a(imageView2, u.f.icon_home_setting_s, u.f.icon_home_setting_s);
                    }
                }
                if (TbadkCoreApplication.isLogin() && PersonInfoActivityConfig.IS_SUPPORT_EDIT) {
                    this.eqB.setVisibility(0);
                } else {
                    this.eqB.setVisibility(8);
                }
            }
            if (aNo() == 2) {
                com.baidu.tbadk.core.util.av.b(this.So, u.d.cp_cont_b, u.d.s_navbar_title_color);
            } else {
                com.baidu.tbadk.core.util.av.b(this.So, u.d.cp_cont_i, u.d.cp_cont_i);
            }
            com.baidu.tbadk.core.util.av.b(this.eqA, u.d.cp_cont_b, u.d.cp_cont_i);
        } else if (this.eqI != null) {
            com.baidu.tbadk.core.util.av.a(this.eqI, u.f.icon_more_bg_s, u.f.icon_more_bg);
        }
    }

    public LinearLayout getMyGiftIcon() {
        return this.eqK.getMyGiftIcon();
    }

    public void ix(boolean z) {
    }

    public void oe(int i) {
    }

    public void a(boolean z, boolean z2, int i) {
        this.eqS = new com.baidu.tieba.person.bp(this.efz);
        this.eqR = new MorePopupWindow(this.bfw.getPageContext().getPageActivity(), this.eqS.getView(), this.mNavigationBar, this.bfw.getResources().getDrawable(u.f.bg_pull_down_right_n), new by(this));
        this.eqR.onChangeSkinType(this.bfw, this.mSkinType, this.bfw.getResources().getDrawable(u.f.bg_pull_down_right_n));
        this.eqS.t(z, z2);
        if (i != -1) {
            this.eqS.nS(i);
        }
        this.eqR.refresh();
        this.eqR.showWindowInRightBottomOfHost();
    }

    public void aNk() {
        com.baidu.adp.lib.h.j.a(this.eqR, this.bfw.getPageContext().getPageActivity());
    }

    public ImageView aNl() {
        return this.eqI;
    }

    public View aNm() {
        return this.eqH;
    }

    public View aKO() {
        if (this.eqS == null) {
            return null;
        }
        return this.eqS.aKO();
    }

    public View aKN() {
        if (this.eqS == null) {
            return null;
        }
        return this.eqS.aKN();
    }

    public View aKP() {
        if (this.eqS == null) {
            return null;
        }
        return this.eqS.aKP();
    }

    public void b(b bVar) {
        this.eqT.efD.a(bVar);
    }

    public void d(com.baidu.adp.widget.ListView.w wVar) {
        this.eqT.d(wVar);
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.eqT != null && this.eqT.efK != null) {
            this.eqT.efK.L(onClickListener);
        }
    }

    private void aNn() {
        if (this.eqO == null) {
            this.eqO = new LinearLayout(this.bfw.getPageContext().getContext());
            this.eqO.setVisibility(0);
        }
        if (this.bfw != null && this.eqJ != null) {
            int aNp = aNp();
            if (!this.cgJ) {
                aNp = this.bfw.getResources().getDimensionPixelSize(u.e.ds240);
            }
            this.eqO.setLayoutParams(new AbsListView.LayoutParams(-1, aNp));
            com.baidu.tbadk.core.util.av.l(this.eqO, u.d.cp_bg_line_c);
            this.eqJ.removeFooterView(this.eqO);
            this.eqJ.addFooterView(this.eqO);
        }
    }

    private int aNo() {
        return TbadkCoreApplication.m9getInst().getSkinType();
    }

    private int aNp() {
        int dimensionPixelSize = this.bfw.getResources().getDimensionPixelSize(u.e.ds170);
        if (aNo() == 2) {
            return this.bfw.getResources().getDimensionPixelSize(u.e.ds70);
        }
        return dimensionPixelSize;
    }

    private void aNq() {
        int i = 0;
        if (this.efz != null && this.efz.aLZ() != null) {
            if (!this.efz.aLZ().aMR()) {
                if (this.cgJ) {
                    i = aNp();
                } else {
                    i = this.bfw.getResources().getDimensionPixelSize(u.e.ds240);
                }
            } else if (this.efz.aLZ().aMT()) {
                i = aNp();
            } else if (this.efz.aLZ().aMS()) {
            }
            if (this.eqO != null) {
                this.eqO.setLayoutParams(new AbsListView.LayoutParams(-1, i));
            }
        }
    }
}
