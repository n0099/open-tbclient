package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdExpandListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.person.bt;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class ad extends com.baidu.adp.base.g<PersonInfoActivity> {
    private NavigationBar aRM;
    private View aYi;
    private PersonInfoActivity bVf;
    private String bWS;
    private ImageView bWT;
    private View bWU;
    private BdExpandListView bWV;
    private p bWW;
    private u bWX;
    private LinearLayout bWY;
    private LinearLayout bWZ;
    private LinearLayout bXa;
    private ImageView bXb;
    private MorePopupWindow bXc;
    private bt bXd;
    private View line;
    private boolean mIsHost;
    private int mSkinType;
    private TextView relation_text;

    public ad(PersonInfoActivity personInfoActivity, boolean z) {
        super(personInfoActivity.getPageContext());
        this.bVf = personInfoActivity;
        this.mIsHost = z;
        this.bWS = personInfoActivity.aeT().getName();
        personInfoActivity.setContentView(com.baidu.tieba.r.person_info_view);
        this.aYi = personInfoActivity.findViewById(com.baidu.tieba.q.root);
        afH();
        initListView();
        OF();
    }

    private void OF() {
        this.bWY = (LinearLayout) this.bVf.findViewById(com.baidu.tieba.q.relation_root);
        this.bWZ = (LinearLayout) this.bVf.findViewById(com.baidu.tieba.q.relation_ll);
        this.line = this.bVf.findViewById(com.baidu.tieba.q.line);
        this.bXa = (LinearLayout) this.bVf.findViewById(com.baidu.tieba.q.relation_bg);
        this.bXa.setOnClickListener(this.bVf);
        this.bXb = (ImageView) this.bVf.findViewById(com.baidu.tieba.q.relation_icon);
        this.relation_text = (TextView) this.bVf.findViewById(com.baidu.tieba.q.relation_text);
    }

    private void afF() {
        if (this.mIsHost) {
            AntiData aaG = this.bVf.aeT().aaG();
            if (aaG != null) {
                if (AntiHelper.c(aaG) || AntiHelper.e(aaG)) {
                    this.bWY.setVisibility(0);
                    this.bXb.setVisibility(8);
                    this.relation_text.setText(com.baidu.tieba.t.account_exception);
                    ay.i(this.bXa, com.baidu.tieba.p.btn_pop_news);
                    ay.b(this.relation_text, com.baidu.tieba.n.cp_link_tip_c, 1);
                }
            } else {
                return;
            }
        } else {
            PersonTainInfo afx = this.bVf.aeT().afx();
            int isFriend = afx != null ? afx.getIsFriend() : 1;
            this.bWY.setVisibility(0);
            if (isFriend == 0) {
                this.relation_text.setText(com.baidu.tieba.t.addfriend);
                ay.i(this.bXa, com.baidu.tieba.p.btn_blue_bg);
                ay.i(this.bXb, com.baidu.tieba.p.icon_person_add);
                ay.b(this.relation_text, com.baidu.tieba.n.cp_cont_i, 1);
            } else if (isFriend == 1) {
                this.relation_text.setText(com.baidu.tieba.t.user_info_center_head_viewpager_send_text_name);
                ay.i(this.bXa, com.baidu.tieba.p.btn_pop_news);
                ay.i(this.bXb, com.baidu.tieba.p.icon_pop_news);
                ay.b(this.relation_text, com.baidu.tieba.n.cp_link_tip_c, 1);
            } else if (isFriend == 2) {
                this.relation_text.setText(com.baidu.tieba.t.acceptfriendapply);
                ay.i(this.bXa, com.baidu.tieba.p.btn_blue_bg);
                ay.i(this.bXb, com.baidu.tieba.p.icon_pop_pass);
                ay.b(this.relation_text, com.baidu.tieba.n.cp_cont_i, 1);
            } else {
                this.bWY.setVisibility(8);
            }
        }
        ay.j(this.line, com.baidu.tieba.n.cp_bg_line_e);
        ay.i(this.bWZ, com.baidu.tieba.p.bg_mycenter_toolbar);
        j(this.bVf.aeT().getUserData());
    }

    public void afG() {
        if (this.mIsHost) {
            AntiData aaG = this.bVf.aeT().aaG();
            if (aaG != null) {
                if (AntiHelper.c(aaG) || AntiHelper.e(aaG)) {
                    ay.i(this.bXa, com.baidu.tieba.p.btn_pop_news);
                    ay.b(this.relation_text, com.baidu.tieba.n.cp_link_tip_c, 1);
                }
            } else {
                return;
            }
        } else {
            PersonTainInfo afx = this.bVf.aeT().afx();
            int isFriend = afx != null ? afx.getIsFriend() : 1;
            if (isFriend == 0) {
                ay.i(this.bXa, com.baidu.tieba.p.btn_blue_bg);
                ay.i(this.bXb, com.baidu.tieba.p.icon_person_add);
                ay.b(this.relation_text, com.baidu.tieba.n.cp_cont_i, 1);
            } else if (isFriend == 1) {
                ay.i(this.bXa, com.baidu.tieba.p.btn_pop_news);
                ay.i(this.bXb, com.baidu.tieba.p.icon_pop_news);
                ay.b(this.relation_text, com.baidu.tieba.n.cp_link_tip_c, 1);
            } else if (isFriend == 2) {
                ay.i(this.bXa, com.baidu.tieba.p.btn_blue_bg);
                ay.i(this.bXb, com.baidu.tieba.p.icon_pop_pass);
                ay.b(this.relation_text, com.baidu.tieba.n.cp_cont_i, 1);
            } else {
                this.bWY.setVisibility(8);
            }
        }
        ay.j(this.line, com.baidu.tieba.n.cp_bg_line_e);
        ay.i(this.bWZ, com.baidu.tieba.p.bg_mycenter_toolbar);
        j(this.bVf.aeT().getUserData());
    }

    private void j(UserData userData) {
        if (userData != null && userData.getIsOfficialAccount() == 1) {
            this.relation_text.setText(com.baidu.tieba.t.user_info_center_head_viewpager_send_text_name);
            ay.i(this.bXa, com.baidu.tieba.p.btn_pop_news);
            ay.i(this.bXb, com.baidu.tieba.p.icon_pop_news);
            ay.b(this.relation_text, com.baidu.tieba.n.cp_link_tip_c, 1);
            this.bWT.setVisibility(8);
            this.bWW.afa();
        }
    }

    private void afH() {
        this.aRM = (NavigationBar) this.bVf.findViewById(com.baidu.tieba.q.navigation_bar);
        if (!this.mIsHost) {
            this.aRM.setTitleText(this.bWS);
        } else {
            this.aRM.setTitleText(com.baidu.tieba.t.person_info);
        }
        this.bWU = this.aRM.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.bVf);
        this.bWT = (ImageView) this.aRM.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.nb_item_floor_more, this.bVf);
    }

    private void initListView() {
        this.bWV = (BdExpandListView) this.bVf.findViewById(com.baidu.tieba.q.personcenter_list);
        this.bWX = new u(this.bVf, this.mIsHost);
        this.bWV.addHeaderView(this.bWX.getRootView());
        this.bWV.c(this.bWX.getRootView(), this.bVf.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds372));
        this.bWW = new p(this.bVf, this.mIsHost);
        this.bWV.setAdapter((ListAdapter) this.bWW);
        this.bWV.setOnScrollListener(new ae(this));
    }

    public void onStart() {
        this.bWX.afm();
    }

    public void onStop() {
        this.bWX.afn();
    }

    public void startLoad() {
        this.bWV.nd();
    }

    public void hideProgress() {
        this.bWX.hideProgress();
    }

    public void setExpandListRefreshListener(com.baidu.adp.widget.ListView.c cVar) {
        this.bWV.setExpandListRefreshListener(cVar);
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        this.bVf.getLayoutMode().ab(i == 1);
        this.bVf.getLayoutMode().j(this.aYi);
        if (this.bWW != null) {
            this.bWW.notifyDataSetChanged();
        }
        this.bWX.oG();
        afG();
        this.aRM.onChangeSkinType(getPageContext(), i);
        eu(this.mIsHost);
    }

    public UserIconBox afr() {
        return this.bWX.afr();
    }

    public UserIconBox afu() {
        return this.bWX.afu();
    }

    public u afI() {
        return this.bWX;
    }

    public TextView aft() {
        return this.bWX.aft();
    }

    public LinearLayout afJ() {
        return this.bXa;
    }

    public void afK() {
        afF();
        this.aRM.setTitleText(this.bVf.aeT().getName());
        this.bWX.afl();
        this.bWW.notifyDataSetChanged();
        eu(this.mIsHost);
    }

    public HeadImageView afq() {
        return this.bWX.afq();
    }

    public RelativeLayout aeZ() {
        return this.bWW.aeZ();
    }

    public void eu(boolean z) {
        if (z) {
            ay.c(this.bWT, com.baidu.tieba.p.icon_pop_edit);
        } else {
            ay.c(this.bWT, com.baidu.tieba.p.icon_more_n);
        }
        if (TbadkCoreApplication.isLogin()) {
            this.bWT.setVisibility(0);
        } else {
            this.bWT.setVisibility(8);
        }
    }

    public LinearLayout afs() {
        return this.bWX.afs();
    }

    public TextView afd() {
        return this.bWW.afd();
    }

    public RelativeLayout afc() {
        return this.bWW.afc();
    }

    public RelativeLayout afe() {
        return this.bWW.afe();
    }

    public RelativeLayout aff() {
        return this.bWW.aff();
    }

    public RelativeLayout afg() {
        return this.bWW.afg();
    }

    public RelativeLayout afh() {
        return this.bWW.afh();
    }

    public RelativeLayout afi() {
        return this.bWW.afi();
    }

    public RelativeLayout afj() {
        return this.bWW.afj();
    }

    public void er(boolean z) {
        if (this.mIsHost) {
            this.bWW.er(z);
        }
    }

    public RelativeLayout afb() {
        return this.bWW.afb();
    }

    public void hV(int i) {
        if (this.mIsHost) {
            this.bWW.hV(i);
        }
    }

    public void g(boolean z, boolean z2) {
        this.bXd = new bt(this.bVf);
        this.bXc = new MorePopupWindow(this.bVf.getPageContext().getPageActivity(), this.bXd.getView(), this.aRM, this.bVf.getResources().getDrawable(com.baidu.tieba.p.bg_pull_down_right_n), new af(this));
        this.bXc.onChangeSkinType(this.bVf, this.mSkinType, this.bVf.getResources().getDrawable(com.baidu.tieba.p.bg_pull_down_right_n));
        this.bXd.f(z, z2);
        this.bXc.refresh();
        this.bXc.showWindowInRightBottomOfHost();
    }

    public void afL() {
        com.baidu.adp.lib.g.k.a(this.bXc, this.bVf.getPageContext().getPageActivity());
    }

    public ImageView afM() {
        return this.bWT;
    }

    public View afN() {
        return this.bWU;
    }

    public View aeC() {
        return this.bXd.aeC();
    }

    public View aeB() {
        return this.bXd.aeB();
    }
}
