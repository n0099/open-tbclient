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
public class az {
    private TextView XE;
    private View bwP;
    private d cLT;
    public com.baidu.tieba.person.a.b cTA;
    private View cTB;
    private boolean cTC = false;
    private String cTk;
    private RelativeLayout cTl;
    private RelativeLayout cTm;
    public ImageView cTn;
    public ImageView cTo;
    private View cTp;
    private ImageView cTq;
    private BdPersonListView cTr;
    private at cTs;
    private LinearLayout cTt;
    private LinearLayout cTu;
    private LinearLayout cTv;
    private LinearLayout cTw;
    private ImageView cTx;
    private MorePopupWindow cTy;
    private bm cTz;
    private View line;
    private BaseFragmentActivity mActivity;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    private int mSkinType;
    private TextView relation_text;
    private View rootView;

    public az(d dVar, boolean z, View view) {
        this.rootView = view;
        this.cLT = dVar;
        this.mActivity = dVar.getBaseFragmentActivity();
        this.mIsHost = z;
        this.cTk = dVar.aoE().getName();
        this.bwP = this.cLT.getView();
        apv();
        St();
        Tw();
    }

    private void Tw() {
        this.cTt = (LinearLayout) this.rootView.findViewById(n.f.relation_root);
        this.cTu = (LinearLayout) this.rootView.findViewById(n.f.relation_ll);
        this.line = this.rootView.findViewById(n.f.line);
        this.cTv = (LinearLayout) this.rootView.findViewById(n.f.relation_bg);
        this.cTv.setOnClickListener(this.cLT);
        this.cTx = (ImageView) this.rootView.findViewById(n.f.relation_icon);
        this.relation_text = (TextView) this.rootView.findViewById(n.f.relation_text);
    }

    private void apt() {
        if (!this.mIsHost) {
            PersonTainInfo apc = this.cLT.aoE().apc();
            int isFriend = apc != null ? apc.getIsFriend() : 1;
            this.cTt.setVisibility(0);
            if (isFriend == 0) {
                this.relation_text.setText(n.i.addfriend);
                com.baidu.tbadk.core.util.as.i(this.cTv, n.e.btn_all_blue);
                com.baidu.tbadk.core.util.as.i(this.cTx, n.e.icon_person_add);
                com.baidu.tbadk.core.util.as.b(this.relation_text, n.c.cp_cont_i, 1);
            } else if (isFriend == 1) {
                this.relation_text.setText(n.i.user_info_center_head_viewpager_send_text_name);
                com.baidu.tbadk.core.util.as.i(this.cTv, n.e.btn_all_white);
                com.baidu.tbadk.core.util.as.i(this.cTx, n.e.icon_pop_news);
                com.baidu.tbadk.core.util.as.b(this.relation_text, n.c.cp_link_tip_c, 1);
            } else if (isFriend == 2) {
                this.relation_text.setText(n.i.acceptfriendapply);
                com.baidu.tbadk.core.util.as.i(this.cTv, n.e.btn_all_blue);
                com.baidu.tbadk.core.util.as.i(this.cTx, n.e.icon_pop_pass);
                com.baidu.tbadk.core.util.as.b(this.relation_text, n.c.cp_cont_i, 1);
            } else {
                this.cTt.setVisibility(8);
            }
        }
        com.baidu.tbadk.core.util.as.j(this.line, n.c.cp_bg_line_e);
        com.baidu.tbadk.core.util.as.i(this.cTu, n.e.bg_mycenter_toolbar);
        j(this.cLT.aoE().getUserData());
    }

    public void apu() {
        if (this.mIsHost) {
            AntiData ajS = this.cLT.aoE().ajS();
            if (ajS != null) {
                if (AntiHelper.d(ajS) || AntiHelper.f(ajS)) {
                    com.baidu.tbadk.core.util.as.i(this.cTv, n.e.btn_pop_news);
                    com.baidu.tbadk.core.util.as.b(this.relation_text, n.c.cp_link_tip_c, 1);
                }
            } else {
                return;
            }
        } else {
            PersonTainInfo apc = this.cLT.aoE().apc();
            int isFriend = apc != null ? apc.getIsFriend() : 1;
            if (isFriend == 0) {
                com.baidu.tbadk.core.util.as.i(this.cTv, n.e.btn_all_blue);
                com.baidu.tbadk.core.util.as.i(this.cTx, n.e.icon_person_add);
                com.baidu.tbadk.core.util.as.b(this.relation_text, n.c.cp_cont_i, 1);
            } else if (isFriend == 1) {
                com.baidu.tbadk.core.util.as.i(this.cTv, n.e.btn_pop_news);
                com.baidu.tbadk.core.util.as.i(this.cTx, n.e.icon_pop_news);
                com.baidu.tbadk.core.util.as.b(this.relation_text, n.c.cp_link_tip_c, 1);
            } else if (isFriend == 2) {
                com.baidu.tbadk.core.util.as.i(this.cTv, n.e.btn_all_blue);
                com.baidu.tbadk.core.util.as.i(this.cTx, n.e.icon_pop_pass);
                com.baidu.tbadk.core.util.as.b(this.relation_text, n.c.cp_cont_i, 1);
            } else {
                this.cTt.setVisibility(8);
            }
        }
        com.baidu.tbadk.core.util.as.j(this.line, n.c.cp_bg_line_e);
        com.baidu.tbadk.core.util.as.i(this.cTu, n.e.bg_mycenter_toolbar);
        j(this.cLT.aoE().getUserData());
    }

    private void j(UserData userData) {
        if (userData != null && userData.getIsOfficialAccount() == 1) {
            this.relation_text.setText(n.i.user_info_center_head_viewpager_send_text_name);
            com.baidu.tbadk.core.util.as.i(this.cTv, n.e.btn_pop_news);
            com.baidu.tbadk.core.util.as.i(this.cTx, n.e.icon_pop_news);
            com.baidu.tbadk.core.util.as.b(this.relation_text, n.c.cp_link_tip_c, 1);
        }
    }

    private void apv() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(n.f.navigation_bar);
        this.mNavigationBar.setOnTouchListener(new ba(this));
        int d = com.baidu.adp.lib.util.k.d(this.mActivity.getPageContext().getPageActivity(), n.d.ds16);
        if (this.mActivity instanceof PersonInfoActivity) {
            this.cTp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.mActivity);
            this.cTp.setOnClickListener(this.cLT);
            this.mNavigationBar.setTitleText("");
            if (!this.mIsHost) {
                this.cTq = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.nb_item_floor_more, this.mActivity);
                this.cTq.setVisibility(8);
                if (this.cTq != null && TbadkCoreApplication.isLogin()) {
                    this.cTq.setOnClickListener(this.cLT);
                    this.cTq.setVisibility(0);
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cTq.getLayoutParams();
                layoutParams.rightMargin = d;
                this.cTq.setLayoutParams(layoutParams);
            }
        } else {
            this.XE = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, n.g.maintab_title_layout, (View.OnClickListener) null).findViewById(n.f.title_textview);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.mActivity.getResources().getDimension(n.d.navi_btn_margin_right);
            com.baidu.tbadk.core.util.as.h((View) this.XE, n.c.s_navbar_title_color);
            layoutParams2.setMargins(dimension, dimension, 0, dimension);
            this.XE.setLayoutParams(layoutParams2);
            this.XE.setText(n.i.mine);
            if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
                this.cTm = (RelativeLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.nb_item_floor_more_tip, this.mActivity);
                this.cTo = (ImageView) this.cTm.findViewById(n.f.btnmore_red_tip);
                this.cTm.setOnClickListener(new bb(this));
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.cTm.getLayoutParams();
                layoutParams3.rightMargin = com.baidu.adp.lib.util.k.d(this.mActivity.getPageContext().getPageActivity(), n.d.ds20);
                this.cTm.setLayoutParams(layoutParams3);
            }
            if (TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
                this.cTl = (RelativeLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.nb_item_floor_more_tip, this.mActivity);
                this.cTn = (ImageView) this.cTl.findViewById(n.f.btnmore_red_tip);
                this.cTl.setOnClickListener(new bc(this));
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.cTl.getLayoutParams();
                layoutParams4.rightMargin = d;
                this.cTl.setLayoutParams(layoutParams4);
                if (!PersonInfoActivityConfig.IS_SUPPORT_EDIT) {
                    this.cTl.setVisibility(8);
                }
            }
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mNavigationBar.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.mNavigationBar.getMeasuredHeight();
        this.cTB = this.rootView.findViewById(n.f.view_navigation_bar_bg);
        FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) this.cTB.getLayoutParams();
        layoutParams5.height = measuredHeight;
        this.cTB.setLayoutParams(layoutParams5);
        if (Build.VERSION.SDK_INT >= 11) {
            this.cTB.setAlpha(0.0f);
        } else {
            this.cTB.setVisibility(8);
        }
    }

    private void apw() {
        this.cTB.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.as.cF(n.e.s_navbar_bg)));
    }

    private void St() {
        this.cTr = (BdPersonListView) this.rootView.findViewById(n.f.personcenter_list);
        this.cTs = new at(this.cLT, this.mIsHost);
        this.cTr.addHeaderView(this.cTs.getRootView());
        this.cTr.c(this.cTs.getRootView(), this.mActivity.getResources().getDimensionPixelSize(n.d.ds560));
        this.cTA = new com.baidu.tieba.person.a.b(this.cLT, this.cTr);
        this.cTA.J(this.cLT.aoE().getDataList());
        this.cTA.notifyDataSetChanged();
        this.cTr.setOnScrollListener(new bd(this));
        TW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apx() {
        if (Build.VERSION.SDK_INT >= 11) {
            int dimension = (int) this.mActivity.getResources().getDimension(n.d.ds98);
            int dimension2 = ((int) this.mActivity.getResources().getDimension(n.d.ds400)) - (-this.cTs.getRootView().getTop());
            if (dimension2 < dimension) {
                if (this.cTB.getAlpha() != 1.0f) {
                    this.cTB.setAlpha(1.0f);
                }
            } else if (dimension2 >= dimension && dimension2 <= dimension * 2) {
                this.cTB.setAlpha(1.0f - (((dimension2 - dimension) * 1.0f) / dimension));
            } else if (dimension2 > dimension * 2 && this.cTB.getAlpha() != 0.0f) {
                this.cTB.setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apy() {
        if ((this.mActivity instanceof PersonInfoActivity) && Build.VERSION.SDK_INT >= 11) {
            if (this.cTB.getAlpha() == 1.0f) {
                if (!this.cTC) {
                    this.mNavigationBar.setTitleText(this.cTk);
                    this.cTC = true;
                }
            } else if (this.cTC) {
                this.mNavigationBar.setTitleText("");
                this.cTC = false;
            }
        }
    }

    public void onDestroy() {
        this.cTs.aoT();
        this.cTr.removeHeaderView(this.cTs.getRootView());
    }

    public void startLoad() {
        this.cTr.ns();
    }

    public void hideProgress() {
        this.cTs.hideProgress();
    }

    public void setPersonListRefreshListener(BdPersonListView.a aVar) {
        this.cTr.setPersonListRefreshListener(aVar);
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tbadk.core.util.as.j(this.cTr, n.c.cp_bg_line_c);
        this.mActivity.getLayoutMode().af(i == 1);
        this.mActivity.getLayoutMode().k(this.bwP);
        this.cTs.oV();
        this.cTA.notifyDataSetChanged();
        apu();
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        com.baidu.tbadk.core.util.as.i(this.mNavigationBar, n.c.white_alpha0);
        apD();
        if (this.cTw != null) {
            com.baidu.tbadk.core.util.as.j(this.cTw, n.c.cp_bg_line_c);
        }
        apw();
    }

    public UserIconBox aoX() {
        return this.cTs.aoX();
    }

    public at apz() {
        return this.cTs;
    }

    public LinearLayout aoZ() {
        return this.cTs.aoZ();
    }

    public LinearLayout apA() {
        return this.cTv;
    }

    public void apB() {
        apC();
        apt();
        if (this.cTs != null && this.cLT.aoE().getUserData() != null) {
            this.cTs.afN();
        }
        apD();
    }

    private void apC() {
        if (this.cLT != null && this.cLT.aoE() != null && this.cLT.aoE().getUserData() != null) {
            this.cTk = this.cLT.aoE().getUserData().getUserName();
        }
    }

    public HeadImageView aoW() {
        return this.cTs.aoW();
    }

    public void apD() {
        ImageView imageView;
        if (!(this.mActivity instanceof PersonInfoActivity)) {
            if (this.cTm != null && (imageView = (ImageView) this.cTm.findViewById(n.f.btnmore_image)) != null) {
                com.baidu.tbadk.core.util.as.a(imageView, n.e.icon_person_dressup, n.e.icon_person_dressup);
            }
            if (this.cTl != null) {
                ImageView imageView2 = (ImageView) this.cTl.findViewById(n.f.btnmore_image);
                if (imageView2 != null) {
                    com.baidu.tbadk.core.util.as.a(imageView2, n.e.icon_home_setting, n.e.icon_home_setting);
                }
                if (TbadkCoreApplication.isLogin() && PersonInfoActivityConfig.IS_SUPPORT_EDIT) {
                    this.cTl.setVisibility(0);
                } else {
                    this.cTl.setVisibility(8);
                }
            }
            com.baidu.tbadk.core.util.as.h((View) this.XE, n.c.s_navbar_title_color);
        } else if (this.cTq != null) {
            com.baidu.tbadk.core.util.as.a(this.cTq, n.e.icon_more_bg_s, n.e.icon_more_bg);
        }
    }

    public LinearLayout aoY() {
        return this.cTs.aoY();
    }

    public void fP(boolean z) {
    }

    public void kw(int i) {
    }

    public void a(boolean z, boolean z2, int i) {
        this.cTz = new bm(this.cLT);
        this.cTy = new MorePopupWindow(this.mActivity.getPageContext().getPageActivity(), this.cTz.getView(), this.mNavigationBar, this.mActivity.getResources().getDrawable(n.e.bg_pull_down_right_n), new be(this));
        this.cTy.onChangeSkinType(this.mActivity, this.mSkinType, this.mActivity.getResources().getDrawable(n.e.bg_pull_down_right_n));
        this.cTz.m(z, z2);
        if (i != -1) {
            this.cTz.kp(i);
        }
        this.cTy.refresh();
        this.cTy.showWindowInRightBottomOfHost();
    }

    public void apE() {
        com.baidu.adp.lib.h.j.a(this.cTy, this.mActivity.getPageContext().getPageActivity());
    }

    public ImageView apF() {
        return this.cTq;
    }

    public View apG() {
        return this.cTp;
    }

    public View anP() {
        if (this.cTz == null) {
            return null;
        }
        return this.cTz.anP();
    }

    public View anO() {
        if (this.cTz == null) {
            return null;
        }
        return this.cTz.anO();
    }

    public View anQ() {
        if (this.cTz == null) {
            return null;
        }
        return this.cTz.anQ();
    }

    public void b(a aVar) {
        this.cTA.cLW.a(aVar);
    }

    public void b(com.baidu.adp.widget.ListView.v vVar) {
        this.cTA.b(vVar);
    }

    public void H(View.OnClickListener onClickListener) {
        if (this.cTA != null && this.cTA.cMd != null) {
            this.cTA.cMd.F(onClickListener);
        }
    }

    private void TW() {
        this.cTw = new LinearLayout(this.mActivity.getPageContext().getContext());
        int dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(n.d.ds70);
        if (!this.mIsHost) {
            dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(n.d.ds240);
        }
        this.cTw.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        com.baidu.tbadk.core.util.as.j(this.cTw, n.c.cp_bg_line_c);
        this.cTr.addFooterView(this.cTw);
    }
}
