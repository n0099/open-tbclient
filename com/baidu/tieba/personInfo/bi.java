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
public class bi {
    private BdListView.e IL;
    private TextView WM;
    private View aAh;
    private View aKi;
    private boolean bIP;
    private View bJp;
    private ViewEventCenter bbj;
    private PbListView bcf;
    private View dEA;
    private boolean dEB = false;
    private String dEi;
    private RelativeLayout dEj;
    private RelativeLayout dEk;
    public ImageView dEl;
    public ImageView dEm;
    private View dEn;
    private ImageView dEo;
    private BdPersonListView dEp;
    private c dEq;
    private LinearLayout dEr;
    private LinearLayout dEs;
    private LinearLayout dEt;
    private LinearLayout dEu;
    private ImageView dEv;
    private TextView dEw;
    private MorePopupWindow dEx;
    private com.baidu.tieba.person.bn dEy;
    public com.baidu.tieba.person.a.b dEz;
    private BaseFragmentActivity duj;
    private f duk;
    private NavigationBar mNavigationBar;
    private int mSkinType;

    public bi(f fVar, boolean z, ViewEventCenter viewEventCenter, View view) {
        this.aAh = view;
        if (fVar != null) {
            this.duk = fVar;
            this.duj = fVar.getBaseFragmentActivity();
            this.bIP = z;
            this.bbj = viewEventCenter;
            this.dEi = fVar.aCH().getName();
            this.bJp = this.duk.getView();
            aDF();
            WO();
            XS();
        }
    }

    private void XS() {
        this.dEr = (LinearLayout) this.aAh.findViewById(t.g.relation_root);
        this.dEs = (LinearLayout) this.aAh.findViewById(t.g.relation_ll);
        this.aKi = this.aAh.findViewById(t.g.line);
        this.dEt = (LinearLayout) this.aAh.findViewById(t.g.relation_bg);
        this.dEt.setOnClickListener(this.duk);
        this.dEv = (ImageView) this.aAh.findViewById(t.g.relation_icon);
        this.dEw = (TextView) this.aAh.findViewById(t.g.relation_text);
    }

    private void aDD() {
        if (this.duk != null) {
            if (this.bIP || (this.duk.aCH() != null && this.duk.aCH().aDx())) {
                this.dEr.setVisibility(8);
            } else {
                PersonTainInfo aDf = this.duk.aCH().aDf();
                int isFriend = aDf != null ? aDf.getIsFriend() : 1;
                this.dEr.setVisibility(0);
                if (isFriend == 0) {
                    this.dEw.setText(t.j.addfriend);
                    com.baidu.tbadk.core.util.at.k(this.dEt, t.f.btn_all_blue);
                    com.baidu.tbadk.core.util.at.k(this.dEv, t.f.icon_person_add);
                    com.baidu.tbadk.core.util.at.b(this.dEw, t.d.cp_cont_i, 1);
                } else if (isFriend == 1) {
                    this.dEw.setText(t.j.user_info_center_head_viewpager_send_text_name);
                    com.baidu.tbadk.core.util.at.k(this.dEt, t.f.btn_all_white);
                    com.baidu.tbadk.core.util.at.k(this.dEv, t.f.icon_pop_news);
                    com.baidu.tbadk.core.util.at.b(this.dEw, t.d.cp_link_tip_c, 1);
                } else if (isFriend == 2) {
                    this.dEw.setText(t.j.acceptfriendapply);
                    com.baidu.tbadk.core.util.at.k(this.dEt, t.f.btn_all_blue);
                    com.baidu.tbadk.core.util.at.k(this.dEv, t.f.icon_pop_pass);
                    com.baidu.tbadk.core.util.at.b(this.dEw, t.d.cp_cont_i, 1);
                } else {
                    this.dEr.setVisibility(8);
                }
            }
            com.baidu.tbadk.core.util.at.l(this.aKi, t.d.cp_bg_line_e);
            com.baidu.tbadk.core.util.at.k(this.dEs, t.f.bg_mycenter_toolbar);
            j(this.duk.aCH().getUserData());
        }
    }

    public void aDE() {
        if (this.bIP) {
            AntiData amu = this.duk.aCH().amu();
            if (amu != null) {
                if (AntiHelper.f(amu) || AntiHelper.h(amu)) {
                    com.baidu.tbadk.core.util.at.k(this.dEt, t.f.btn_pop_news);
                    com.baidu.tbadk.core.util.at.b(this.dEw, t.d.cp_link_tip_c, 1);
                }
            } else {
                return;
            }
        } else {
            PersonTainInfo aDf = this.duk.aCH().aDf();
            int isFriend = aDf != null ? aDf.getIsFriend() : 1;
            if (isFriend == 0) {
                com.baidu.tbadk.core.util.at.k(this.dEt, t.f.btn_all_blue);
                com.baidu.tbadk.core.util.at.k(this.dEv, t.f.icon_person_add);
                com.baidu.tbadk.core.util.at.b(this.dEw, t.d.cp_cont_i, 1);
            } else if (isFriend == 1) {
                com.baidu.tbadk.core.util.at.k(this.dEt, t.f.btn_pop_news);
                com.baidu.tbadk.core.util.at.k(this.dEv, t.f.icon_pop_news);
                com.baidu.tbadk.core.util.at.b(this.dEw, t.d.cp_link_tip_c, 1);
            } else if (isFriend == 2) {
                com.baidu.tbadk.core.util.at.k(this.dEt, t.f.btn_all_blue);
                com.baidu.tbadk.core.util.at.k(this.dEv, t.f.icon_pop_pass);
                com.baidu.tbadk.core.util.at.b(this.dEw, t.d.cp_cont_i, 1);
            } else {
                this.dEr.setVisibility(8);
            }
        }
        com.baidu.tbadk.core.util.at.l(this.aKi, t.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.at.k(this.dEs, t.f.bg_mycenter_toolbar);
        j(this.duk.aCH().getUserData());
    }

    private void j(UserData userData) {
        if (userData != null && userData.getIsOfficialAccount() == 1) {
            this.dEw.setText(t.j.user_info_center_head_viewpager_send_text_name);
            com.baidu.tbadk.core.util.at.k(this.dEt, t.f.btn_pop_news);
            com.baidu.tbadk.core.util.at.k(this.dEv, t.f.icon_pop_news);
            com.baidu.tbadk.core.util.at.b(this.dEw, t.d.cp_link_tip_c, 1);
        }
    }

    private void aDF() {
        this.mNavigationBar = (NavigationBar) this.aAh.findViewById(t.g.navigation_bar);
        this.mNavigationBar.setOnTouchListener(new bj(this));
        int c = com.baidu.adp.lib.util.k.c(this.duj.getPageContext().getPageActivity(), t.e.ds16);
        if (this.duj instanceof PersonInfoActivity) {
            this.dEn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.duj);
            this.dEn.setOnClickListener(this.duk);
            this.mNavigationBar.setTitleText("");
            if (!this.bIP) {
                this.dEo = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.nb_item_floor_more, this.duj);
                this.dEo.setContentDescription(this.duj.getPageContext().getString(t.j.more));
                this.dEo.setVisibility(8);
                if (this.dEo != null && TbadkCoreApplication.isLogin()) {
                    this.dEo.setOnClickListener(this.duk);
                    this.dEo.setVisibility(0);
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dEo.getLayoutParams();
                layoutParams.rightMargin = c;
                this.dEo.setLayoutParams(layoutParams);
            }
        } else {
            this.WM = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, t.h.maintab_title_layout, (View.OnClickListener) null).findViewById(t.g.title_textview);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.duj.getResources().getDimension(t.e.navi_btn_margin_right);
            com.baidu.tbadk.core.util.at.j((View) this.WM, t.d.s_navbar_title_color);
            layoutParams2.setMargins(dimension, dimension, 0, dimension);
            this.WM.setLayoutParams(layoutParams2);
            this.WM.setText(t.j.mine);
            if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
                this.dEk = (RelativeLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.nb_item_floor_more_tip, this.duj);
                this.dEk.setContentDescription(TbadkCoreApplication.m411getInst().getResources().getString(t.j.dressup_center_title));
                this.dEm = (ImageView) this.dEk.findViewById(t.g.btnmore_red_tip);
                this.dEk.setOnClickListener(new bk(this));
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.dEk.getLayoutParams();
                layoutParams3.rightMargin = com.baidu.adp.lib.util.k.c(this.duj.getPageContext().getPageActivity(), t.e.ds20);
                this.dEk.setLayoutParams(layoutParams3);
            }
            if (TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
                this.dEj = (RelativeLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.nb_item_floor_more_tip, this.duj);
                this.dEj.setContentDescription(TbadkCoreApplication.m411getInst().getResources().getString(t.j.setup));
                this.dEl = (ImageView) this.dEj.findViewById(t.g.btnmore_red_tip);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (!com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj.isMemberCloseAdIsOpen()) {
                    this.dEl.setVisibility(0);
                }
                this.dEj.setOnClickListener(new bl(this));
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.dEj.getLayoutParams();
                layoutParams4.rightMargin = c;
                this.dEj.setLayoutParams(layoutParams4);
                if (!PersonInfoActivityConfig.IS_SUPPORT_EDIT) {
                    this.dEj.setVisibility(8);
                }
            }
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mNavigationBar.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.mNavigationBar.getMeasuredHeight();
        this.dEA = this.aAh.findViewById(t.g.view_navigation_bar_bg);
        FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) this.dEA.getLayoutParams();
        layoutParams5.height = measuredHeight;
        this.dEA.setLayoutParams(layoutParams5);
        if (Build.VERSION.SDK_INT >= 11) {
            this.dEA.setAlpha(0.0f);
        } else {
            this.dEA.setVisibility(8);
        }
    }

    private void aDG() {
        this.dEA.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.at.cS(t.f.s_navbar_bg)));
    }

    private void WO() {
        this.dEp = (BdPersonListView) this.aAh.findViewById(t.g.personcenter_list);
        this.dEq = new c(this.duk, this.bIP, this.bbj);
        this.dEp.addHeaderView(this.dEq.getRootView());
        this.dEp.e(this.dEq.getRootView(), this.duj.getResources().getDimensionPixelSize(t.e.ds568));
        this.dEz = new com.baidu.tieba.person.a.b(this.duk, this.dEp);
        this.dEz.ab(this.duk.aCH().getDataList());
        this.dEz.notifyDataSetChanged();
        this.dEp.setOnScrollListener(new bm(this));
        aDS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDH() {
        if (Build.VERSION.SDK_INT >= 11) {
            int dimension = (int) this.duj.getResources().getDimension(t.e.ds98);
            int dimension2 = ((int) this.duj.getResources().getDimension(t.e.ds450)) - (-this.dEq.getRootView().getTop());
            if (dimension2 < dimension) {
                if (this.dEA.getAlpha() != 1.0f) {
                    this.dEA.setAlpha(1.0f);
                }
            } else if (dimension2 >= dimension && dimension2 <= dimension * 2) {
                this.dEA.setAlpha(1.0f - (((dimension2 - dimension) * 1.0f) / dimension));
            } else if (dimension2 > dimension * 2 && this.dEA.getAlpha() != 0.0f) {
                this.dEA.setAlpha(0.0f);
            }
            if (this.dEp.getFirstVisiblePosition() > 0 && this.dEA.getAlpha() != 1.0f) {
                this.dEA.setAlpha(1.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDI() {
        if ((this.duj instanceof PersonInfoActivity) && Build.VERSION.SDK_INT >= 11) {
            if (this.dEA.getAlpha() == 1.0f) {
                if (!this.dEB) {
                    this.mNavigationBar.setTitleText(this.dEi);
                    this.dEB = true;
                }
            } else if (this.dEB) {
                this.mNavigationBar.setTitleText("");
                this.dEB = false;
            }
        }
    }

    public void onDestroy() {
        this.dEq.aCr();
        this.dEp.removeHeaderView(this.dEq.getRootView());
        if (this.dEu != null) {
            this.dEp.removeFooterView(this.dEu);
        }
    }

    public void aiC() {
        this.dEp.mW();
    }

    public void Qo() {
        this.dEq.Qo();
    }

    public void setPersonListRefreshListener(BdPersonListView.a aVar) {
        this.dEp.setPersonListRefreshListener(aVar);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        if (this.bcf == null) {
            this.bcf = new PbListView(this.duj.getActivity());
            this.bcf.mZ();
            this.bcf.di(t.d.cp_bg_line_c);
            this.bcf.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_d));
            this.bcf.dj(TbadkCoreApplication.m411getInst().getSkinType());
        }
        this.dEp.setNextPage(this.bcf);
        aDJ();
        this.IL = eVar;
        this.dEp.setOnScrollListener(new bn(this));
    }

    public void PQ() {
        if (this.bcf != null) {
            this.bcf.getView().setVisibility(0);
            this.bcf.xu();
        }
    }

    public void aCg() {
        if (this.bcf != null) {
            this.bcf.getView().setVisibility(0);
            this.bcf.setText(this.duk.getString(t.j.list_no_more_god_threads));
            this.bcf.xv();
        }
    }

    public void aDJ() {
        if (this.bcf != null) {
            this.bcf.getView().setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tbadk.core.util.at.l(this.dEp, t.d.cp_bg_line_c);
        this.duj.getLayoutMode().ab(i == 1);
        this.duj.getLayoutMode().x(this.bJp);
        this.dEq.oH();
        this.dEz.notifyDataSetChanged();
        aDE();
        this.mNavigationBar.onChangeSkinType(this.duj.getPageContext(), i);
        com.baidu.tbadk.core.util.at.k(this.mNavigationBar, t.d.white_alpha0);
        aDO();
        if (this.dEm != null && this.dEm.getVisibility() == 0) {
            com.baidu.tbadk.core.util.at.c(this.dEm, t.f.icon_news_down_bar_one);
        }
        if (this.dEl != null && this.dEl.getVisibility() == 0) {
            com.baidu.tbadk.core.util.at.c(this.dEl, t.f.icon_news_down_bar_one);
        }
        if (this.dEu != null) {
            com.baidu.tbadk.core.util.at.l(this.dEu, t.d.cp_bg_line_c);
        }
        if (this.bcf != null) {
            this.bcf.di(t.d.cp_bg_line_c);
            this.bcf.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_d));
            this.bcf.dj(i);
        }
        aDG();
    }

    public UserIconBox getUserIcon() {
        return this.dEq.getUserIcon();
    }

    public c aDK() {
        return this.dEq;
    }

    public View getAttentionView() {
        return this.dEq.getAttentionView();
    }

    public View aDL() {
        return this.dEt;
    }

    public void aDM() {
        aDN();
        aDD();
        if (this.dEq != null && this.duk.aCH().getUserData() != null) {
            if (this.duk.aCH().aDx()) {
                this.dEq.mL(2);
                aDT();
            } else {
                this.dEq.mL(1);
                aDT();
            }
            this.dEq.arP();
        }
        if (this.dEz != null) {
            this.dEz.notifyDataSetChanged();
        }
        aDO();
    }

    private void aDN() {
        if (this.duk != null && this.duk.aCH() != null && this.duk.aCH().getUserData() != null) {
            this.dEi = this.duk.aCH().getUserData().getUserName();
        }
    }

    public HeadImageView getHeadImage() {
        return this.dEq.getHeadImage();
    }

    public void aDO() {
        ImageView imageView;
        if (!(this.duj instanceof PersonInfoActivity)) {
            if (this.dEk != null && (imageView = (ImageView) this.dEk.findViewById(t.g.btnmore_image)) != null) {
                com.baidu.tbadk.core.util.at.a(imageView, t.f.icon_person_dressup, t.f.icon_person_dressup);
            }
            if (this.dEj != null) {
                ImageView imageView2 = (ImageView) this.dEj.findViewById(t.g.btnmore_image);
                if (imageView2 != null) {
                    com.baidu.tbadk.core.util.at.a(imageView2, t.f.icon_home_setting, t.f.icon_home_setting);
                }
                if (TbadkCoreApplication.isLogin() && PersonInfoActivityConfig.IS_SUPPORT_EDIT) {
                    this.dEj.setVisibility(0);
                } else {
                    this.dEj.setVisibility(8);
                }
            }
            com.baidu.tbadk.core.util.at.j((View) this.WM, t.d.s_navbar_title_color);
        } else if (this.dEo != null) {
            com.baidu.tbadk.core.util.at.a(this.dEo, t.f.icon_more_bg_s, t.f.icon_more_bg);
        }
    }

    public LinearLayout getMyGiftIcon() {
        return this.dEq.getMyGiftIcon();
    }

    public void gT(boolean z) {
    }

    public void mM(int i) {
    }

    public void a(boolean z, boolean z2, int i) {
        this.dEy = new com.baidu.tieba.person.bn(this.duk);
        this.dEx = new MorePopupWindow(this.duj.getPageContext().getPageActivity(), this.dEy.getView(), this.mNavigationBar, this.duj.getResources().getDrawable(t.f.bg_pull_down_right_n), new bo(this));
        this.dEx.onChangeSkinType(this.duj, this.mSkinType, this.duj.getResources().getDrawable(t.f.bg_pull_down_right_n));
        this.dEy.s(z, z2);
        if (i != -1) {
            this.dEy.mB(i);
        }
        this.dEx.refresh();
        this.dEx.showWindowInRightBottomOfHost();
    }

    public void aDP() {
        com.baidu.adp.lib.h.j.a(this.dEx, this.duj.getPageContext().getPageActivity());
    }

    public ImageView aDQ() {
        return this.dEo;
    }

    public View aDR() {
        return this.dEn;
    }

    public View aBz() {
        if (this.dEy == null) {
            return null;
        }
        return this.dEy.aBz();
    }

    public View aBy() {
        if (this.dEy == null) {
            return null;
        }
        return this.dEy.aBy();
    }

    public View aBA() {
        if (this.dEy == null) {
            return null;
        }
        return this.dEy.aBA();
    }

    public void b(b bVar) {
        this.dEz.duo.a(bVar);
    }

    public void b(com.baidu.adp.widget.ListView.v vVar) {
        this.dEz.b(vVar);
    }

    public void Q(View.OnClickListener onClickListener) {
        if (this.dEz != null && this.dEz.duv != null) {
            this.dEz.duv.P(onClickListener);
        }
    }

    private void aDS() {
        if (this.dEu == null && this.duj != null && this.dEp != null) {
            this.dEu = new LinearLayout(this.duj.getPageContext().getContext());
            this.dEu.setVisibility(0);
            int dimensionPixelSize = this.duj.getResources().getDimensionPixelSize(t.e.ds70);
            if (!this.bIP) {
                dimensionPixelSize = this.duj.getResources().getDimensionPixelSize(t.e.ds240);
            }
            this.dEu.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
            com.baidu.tbadk.core.util.at.l(this.dEu, t.d.cp_bg_line_c);
            this.dEp.removeFooterView(this.dEu);
            this.dEp.addFooterView(this.dEu);
        }
    }

    private void aDT() {
        int i = 0;
        if (this.duk != null && this.duk.aCH() != null) {
            if (!this.duk.aCH().aDx()) {
                if (this.bIP) {
                    i = this.duj.getResources().getDimensionPixelSize(t.e.ds70);
                } else {
                    i = this.duj.getResources().getDimensionPixelSize(t.e.ds240);
                }
            } else if (this.duk.aCH().aDz()) {
                i = this.duj.getResources().getDimensionPixelSize(t.e.ds70);
            } else if (this.duk.aCH().aDy()) {
            }
            if (this.dEu != null) {
                this.dEu.setLayoutParams(new AbsListView.LayoutParams(-1, i));
            }
        }
    }
}
