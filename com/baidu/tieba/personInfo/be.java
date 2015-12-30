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
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.n;
import com.baidu.tieba.person.bm;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class be {
    private TextView Yh;
    private View bAG;
    private d cQj;
    private String cXW;
    private RelativeLayout cXX;
    private RelativeLayout cXY;
    public ImageView cXZ;
    public ImageView cYa;
    private View cYb;
    private ImageView cYc;
    private BdPersonListView cYd;
    private ay cYe;
    private LinearLayout cYf;
    private LinearLayout cYg;
    private LinearLayout cYh;
    private LinearLayout cYi;
    private ImageView cYj;
    private MorePopupWindow cYk;
    private bm cYl;
    public com.baidu.tieba.person.a.b cYm;
    private View cYn;
    private boolean cYo = false;
    private View line;
    private BaseFragmentActivity mActivity;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    private int mSkinType;
    private TextView relation_text;
    private View rootView;

    public be(d dVar, boolean z, View view) {
        this.rootView = view;
        this.cQj = dVar;
        this.mActivity = dVar.getBaseFragmentActivity();
        this.mIsHost = z;
        this.cXW = dVar.apO().getName();
        this.bAG = this.cQj.getView();
        aqK();
        SL();
        TO();
    }

    private void TO() {
        this.cYf = (LinearLayout) this.rootView.findViewById(n.g.relation_root);
        this.cYg = (LinearLayout) this.rootView.findViewById(n.g.relation_ll);
        this.line = this.rootView.findViewById(n.g.line);
        this.cYh = (LinearLayout) this.rootView.findViewById(n.g.relation_bg);
        this.cYh.setOnClickListener(this.cQj);
        this.cYj = (ImageView) this.rootView.findViewById(n.g.relation_icon);
        this.relation_text = (TextView) this.rootView.findViewById(n.g.relation_text);
    }

    private void aqI() {
        if (!this.mIsHost) {
            PersonTainInfo aqp = this.cQj.apO().aqp();
            int isFriend = aqp != null ? aqp.getIsFriend() : 1;
            this.cYf.setVisibility(0);
            if (isFriend == 0) {
                this.relation_text.setText(n.j.addfriend);
                com.baidu.tbadk.core.util.as.i(this.cYh, n.f.btn_all_blue);
                com.baidu.tbadk.core.util.as.i(this.cYj, n.f.icon_person_add);
                com.baidu.tbadk.core.util.as.b(this.relation_text, n.d.cp_cont_i, 1);
            } else if (isFriend == 1) {
                this.relation_text.setText(n.j.user_info_center_head_viewpager_send_text_name);
                com.baidu.tbadk.core.util.as.i(this.cYh, n.f.btn_all_white);
                com.baidu.tbadk.core.util.as.i(this.cYj, n.f.icon_pop_news);
                com.baidu.tbadk.core.util.as.b(this.relation_text, n.d.cp_link_tip_c, 1);
            } else if (isFriend == 2) {
                this.relation_text.setText(n.j.acceptfriendapply);
                com.baidu.tbadk.core.util.as.i(this.cYh, n.f.btn_all_blue);
                com.baidu.tbadk.core.util.as.i(this.cYj, n.f.icon_pop_pass);
                com.baidu.tbadk.core.util.as.b(this.relation_text, n.d.cp_cont_i, 1);
            } else {
                this.cYf.setVisibility(8);
            }
        }
        com.baidu.tbadk.core.util.as.j(this.line, n.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.as.i(this.cYg, n.f.bg_mycenter_toolbar);
        j(this.cQj.apO().getUserData());
    }

    public void aqJ() {
        if (this.mIsHost) {
            AntiData ala = this.cQj.apO().ala();
            if (ala != null) {
                if (AntiHelper.d(ala) || AntiHelper.f(ala)) {
                    com.baidu.tbadk.core.util.as.i(this.cYh, n.f.btn_pop_news);
                    com.baidu.tbadk.core.util.as.b(this.relation_text, n.d.cp_link_tip_c, 1);
                }
            } else {
                return;
            }
        } else {
            PersonTainInfo aqp = this.cQj.apO().aqp();
            int isFriend = aqp != null ? aqp.getIsFriend() : 1;
            if (isFriend == 0) {
                com.baidu.tbadk.core.util.as.i(this.cYh, n.f.btn_all_blue);
                com.baidu.tbadk.core.util.as.i(this.cYj, n.f.icon_person_add);
                com.baidu.tbadk.core.util.as.b(this.relation_text, n.d.cp_cont_i, 1);
            } else if (isFriend == 1) {
                com.baidu.tbadk.core.util.as.i(this.cYh, n.f.btn_pop_news);
                com.baidu.tbadk.core.util.as.i(this.cYj, n.f.icon_pop_news);
                com.baidu.tbadk.core.util.as.b(this.relation_text, n.d.cp_link_tip_c, 1);
            } else if (isFriend == 2) {
                com.baidu.tbadk.core.util.as.i(this.cYh, n.f.btn_all_blue);
                com.baidu.tbadk.core.util.as.i(this.cYj, n.f.icon_pop_pass);
                com.baidu.tbadk.core.util.as.b(this.relation_text, n.d.cp_cont_i, 1);
            } else {
                this.cYf.setVisibility(8);
            }
        }
        com.baidu.tbadk.core.util.as.j(this.line, n.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.as.i(this.cYg, n.f.bg_mycenter_toolbar);
        j(this.cQj.apO().getUserData());
    }

    private void j(UserData userData) {
        if (userData != null && userData.getIsOfficialAccount() == 1) {
            this.relation_text.setText(n.j.user_info_center_head_viewpager_send_text_name);
            com.baidu.tbadk.core.util.as.i(this.cYh, n.f.btn_pop_news);
            com.baidu.tbadk.core.util.as.i(this.cYj, n.f.icon_pop_news);
            com.baidu.tbadk.core.util.as.b(this.relation_text, n.d.cp_link_tip_c, 1);
        }
    }

    private void aqK() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(n.g.navigation_bar);
        this.mNavigationBar.setOnTouchListener(new bf(this));
        int d = com.baidu.adp.lib.util.k.d(this.mActivity.getPageContext().getPageActivity(), n.e.ds16);
        if (this.mActivity instanceof PersonInfoActivity) {
            this.cYb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mActivity);
            this.cYb.setOnClickListener(this.cQj);
            this.mNavigationBar.setTitleText("");
            if (!this.mIsHost) {
                this.cYc = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.h.nb_item_floor_more, this.mActivity);
                this.cYc.setVisibility(8);
                if (this.cYc != null && TbadkCoreApplication.isLogin()) {
                    this.cYc.setOnClickListener(this.cQj);
                    this.cYc.setVisibility(0);
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cYc.getLayoutParams();
                layoutParams.rightMargin = d;
                this.cYc.setLayoutParams(layoutParams);
            }
        } else {
            this.Yh = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, n.h.maintab_title_layout, (View.OnClickListener) null).findViewById(n.g.title_textview);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.mActivity.getResources().getDimension(n.e.navi_btn_margin_right);
            com.baidu.tbadk.core.util.as.h((View) this.Yh, n.d.s_navbar_title_color);
            layoutParams2.setMargins(dimension, dimension, 0, dimension);
            this.Yh.setLayoutParams(layoutParams2);
            this.Yh.setText(n.j.mine);
            if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
                this.cXY = (RelativeLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.h.nb_item_floor_more_tip, this.mActivity);
                this.cYa = (ImageView) this.cXY.findViewById(n.g.btnmore_red_tip);
                this.cXY.setOnClickListener(new bg(this));
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.cXY.getLayoutParams();
                layoutParams3.rightMargin = com.baidu.adp.lib.util.k.d(this.mActivity.getPageContext().getPageActivity(), n.e.ds20);
                this.cXY.setLayoutParams(layoutParams3);
            }
            if (TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
                this.cXX = (RelativeLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.h.nb_item_floor_more_tip, this.mActivity);
                this.cXZ = (ImageView) this.cXX.findViewById(n.g.btnmore_red_tip);
                this.cXX.setOnClickListener(new bh(this));
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.cXX.getLayoutParams();
                layoutParams4.rightMargin = d;
                this.cXX.setLayoutParams(layoutParams4);
                if (!PersonInfoActivityConfig.IS_SUPPORT_EDIT) {
                    this.cXX.setVisibility(8);
                }
            }
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mNavigationBar.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.mNavigationBar.getMeasuredHeight();
        this.cYn = this.rootView.findViewById(n.g.view_navigation_bar_bg);
        FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) this.cYn.getLayoutParams();
        layoutParams5.height = measuredHeight;
        this.cYn.setLayoutParams(layoutParams5);
        if (Build.VERSION.SDK_INT >= 11) {
            this.cYn.setAlpha(0.0f);
        } else {
            this.cYn.setVisibility(8);
        }
    }

    private void aqL() {
        this.cYn.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.as.cy(n.f.s_navbar_bg)));
    }

    private void SL() {
        this.cYd = (BdPersonListView) this.rootView.findViewById(n.g.personcenter_list);
        this.cYe = new ay(this.cQj, this.mIsHost);
        this.cYd.addHeaderView(this.cYe.getRootView());
        this.cYd.c(this.cYe.getRootView(), this.mActivity.getResources().getDimensionPixelSize(n.e.ds568));
        this.cYm = new com.baidu.tieba.person.a.b(this.cQj, this.cYd);
        this.cYm.Z(this.cQj.apO().getDataList());
        this.cYm.notifyDataSetChanged();
        this.cYd.setOnScrollListener(new bi(this));
        aqW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqM() {
        if (Build.VERSION.SDK_INT >= 11) {
            int dimension = (int) this.mActivity.getResources().getDimension(n.e.ds98);
            int dimension2 = ((int) this.mActivity.getResources().getDimension(n.e.ds400)) - (-this.cYe.getRootView().getTop());
            if (dimension2 < dimension) {
                if (this.cYn.getAlpha() != 1.0f) {
                    this.cYn.setAlpha(1.0f);
                }
            } else if (dimension2 >= dimension && dimension2 <= dimension * 2) {
                this.cYn.setAlpha(1.0f - (((dimension2 - dimension) * 1.0f) / dimension));
            } else if (dimension2 > dimension * 2 && this.cYn.getAlpha() != 0.0f) {
                this.cYn.setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqN() {
        if ((this.mActivity instanceof PersonInfoActivity) && Build.VERSION.SDK_INT >= 11) {
            if (this.cYn.getAlpha() == 1.0f) {
                if (!this.cYo) {
                    this.mNavigationBar.setTitleText(this.cXW);
                    this.cYo = true;
                }
            } else if (this.cYo) {
                this.mNavigationBar.setTitleText("");
                this.cYo = false;
            }
        }
    }

    public void onDestroy() {
        this.cYe.aqg();
        this.cYd.removeHeaderView(this.cYe.getRootView());
    }

    public void startLoad() {
        this.cYd.mQ();
    }

    public void hideProgress() {
        this.cYe.hideProgress();
    }

    public void setPersonListRefreshListener(BdPersonListView.a aVar) {
        this.cYd.setPersonListRefreshListener(aVar);
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tbadk.core.util.as.j(this.cYd, n.d.cp_bg_line_c);
        this.mActivity.getLayoutMode().ac(i == 1);
        this.mActivity.getLayoutMode().k(this.bAG);
        this.cYe.ot();
        this.cYm.notifyDataSetChanged();
        aqJ();
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        com.baidu.tbadk.core.util.as.i(this.mNavigationBar, n.d.white_alpha0);
        aqS();
        if (this.cYa != null && this.cYa.getVisibility() == 0) {
            com.baidu.tbadk.core.util.as.c(this.cYa, n.f.icon_news_down_bar_one);
        }
        if (this.cYi != null) {
            com.baidu.tbadk.core.util.as.j(this.cYi, n.d.cp_bg_line_c);
        }
        aqL();
    }

    public UserIconBox aqk() {
        return this.cYe.aqk();
    }

    public ay aqO() {
        return this.cYe;
    }

    public LinearLayout aqm() {
        return this.cYe.aqm();
    }

    public LinearLayout aqP() {
        return this.cYh;
    }

    public void aqQ() {
        aqR();
        aqI();
        if (this.cYe != null && this.cQj.apO().getUserData() != null) {
            this.cYe.agW();
        }
        aqS();
    }

    private void aqR() {
        if (this.cQj != null && this.cQj.apO() != null && this.cQj.apO().getUserData() != null) {
            this.cXW = this.cQj.apO().getUserData().getUserName();
        }
    }

    public HeadImageView aqj() {
        return this.cYe.aqj();
    }

    public void aqS() {
        ImageView imageView;
        if (!(this.mActivity instanceof PersonInfoActivity)) {
            if (this.cXY != null && (imageView = (ImageView) this.cXY.findViewById(n.g.btnmore_image)) != null) {
                com.baidu.tbadk.core.util.as.a(imageView, n.f.icon_person_dressup, n.f.icon_person_dressup);
            }
            if (this.cXX != null) {
                ImageView imageView2 = (ImageView) this.cXX.findViewById(n.g.btnmore_image);
                if (imageView2 != null) {
                    com.baidu.tbadk.core.util.as.a(imageView2, n.f.icon_home_setting, n.f.icon_home_setting);
                }
                if (TbadkCoreApplication.isLogin() && PersonInfoActivityConfig.IS_SUPPORT_EDIT) {
                    this.cXX.setVisibility(0);
                } else {
                    this.cXX.setVisibility(8);
                }
            }
            com.baidu.tbadk.core.util.as.h((View) this.Yh, n.d.s_navbar_title_color);
        } else if (this.cYc != null) {
            com.baidu.tbadk.core.util.as.a(this.cYc, n.f.icon_more_bg_s, n.f.icon_more_bg);
        }
    }

    public LinearLayout aql() {
        return this.cYe.aql();
    }

    public void fO(boolean z) {
    }

    public void kT(int i) {
    }

    public void a(boolean z, boolean z2, int i) {
        this.cYl = new bm(this.cQj);
        this.cYk = new MorePopupWindow(this.mActivity.getPageContext().getPageActivity(), this.cYl.getView(), this.mNavigationBar, this.mActivity.getResources().getDrawable(n.f.bg_pull_down_right_n), new bj(this));
        this.cYk.onChangeSkinType(this.mActivity, this.mSkinType, this.mActivity.getResources().getDrawable(n.f.bg_pull_down_right_n));
        this.cYl.o(z, z2);
        if (i != -1) {
            this.cYl.kM(i);
        }
        this.cYk.refresh();
        this.cYk.showWindowInRightBottomOfHost();
    }

    public void aqT() {
        com.baidu.adp.lib.h.j.a(this.cYk, this.mActivity.getPageContext().getPageActivity());
    }

    public ImageView aqU() {
        return this.cYc;
    }

    public View aqV() {
        return this.cYb;
    }

    public View apa() {
        if (this.cYl == null) {
            return null;
        }
        return this.cYl.apa();
    }

    public View aoZ() {
        if (this.cYl == null) {
            return null;
        }
        return this.cYl.aoZ();
    }

    public View apb() {
        if (this.cYl == null) {
            return null;
        }
        return this.cYl.apb();
    }

    public void b(a aVar) {
        this.cYm.cQm.a(aVar);
    }

    public void b(com.baidu.adp.widget.ListView.v vVar) {
        this.cYm.b(vVar);
    }

    public void H(View.OnClickListener onClickListener) {
        if (this.cYm != null && this.cYm.cQt != null) {
            this.cYm.cQt.F(onClickListener);
        }
    }

    private void aqW() {
        this.cYi = new LinearLayout(this.mActivity.getPageContext().getContext());
        int dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(n.e.ds70);
        if (!this.mIsHost) {
            dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(n.e.ds240);
        }
        this.cYi.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        com.baidu.tbadk.core.util.as.j(this.cYi, n.d.cp_bg_line_c);
        this.cYd.addFooterView(this.cYi);
    }
}
