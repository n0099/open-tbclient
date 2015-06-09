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
    private NavigationBar aRN;
    private View aYj;
    private PersonInfoActivity bVg;
    private String bWT;
    private ImageView bWU;
    private View bWV;
    private BdExpandListView bWW;
    private p bWX;
    private u bWY;
    private LinearLayout bWZ;
    private LinearLayout bXa;
    private LinearLayout bXb;
    private ImageView bXc;
    private MorePopupWindow bXd;
    private bt bXe;
    private View line;
    private boolean mIsHost;
    private int mSkinType;
    private TextView relation_text;

    public ad(PersonInfoActivity personInfoActivity, boolean z) {
        super(personInfoActivity.getPageContext());
        this.bVg = personInfoActivity;
        this.mIsHost = z;
        this.bWT = personInfoActivity.aeU().getName();
        personInfoActivity.setContentView(com.baidu.tieba.r.person_info_view);
        this.aYj = personInfoActivity.findViewById(com.baidu.tieba.q.root);
        afI();
        initListView();
        OG();
    }

    private void OG() {
        this.bWZ = (LinearLayout) this.bVg.findViewById(com.baidu.tieba.q.relation_root);
        this.bXa = (LinearLayout) this.bVg.findViewById(com.baidu.tieba.q.relation_ll);
        this.line = this.bVg.findViewById(com.baidu.tieba.q.line);
        this.bXb = (LinearLayout) this.bVg.findViewById(com.baidu.tieba.q.relation_bg);
        this.bXb.setOnClickListener(this.bVg);
        this.bXc = (ImageView) this.bVg.findViewById(com.baidu.tieba.q.relation_icon);
        this.relation_text = (TextView) this.bVg.findViewById(com.baidu.tieba.q.relation_text);
    }

    private void afG() {
        if (this.mIsHost) {
            AntiData aaH = this.bVg.aeU().aaH();
            if (aaH != null) {
                if (AntiHelper.c(aaH) || AntiHelper.e(aaH)) {
                    this.bWZ.setVisibility(0);
                    this.bXc.setVisibility(8);
                    this.relation_text.setText(com.baidu.tieba.t.account_exception);
                    ay.i(this.bXb, com.baidu.tieba.p.btn_pop_news);
                    ay.b(this.relation_text, com.baidu.tieba.n.cp_link_tip_c, 1);
                }
            } else {
                return;
            }
        } else {
            PersonTainInfo afy = this.bVg.aeU().afy();
            int isFriend = afy != null ? afy.getIsFriend() : 1;
            this.bWZ.setVisibility(0);
            if (isFriend == 0) {
                this.relation_text.setText(com.baidu.tieba.t.addfriend);
                ay.i(this.bXb, com.baidu.tieba.p.btn_blue_bg);
                ay.i(this.bXc, com.baidu.tieba.p.icon_person_add);
                ay.b(this.relation_text, com.baidu.tieba.n.cp_cont_i, 1);
            } else if (isFriend == 1) {
                this.relation_text.setText(com.baidu.tieba.t.user_info_center_head_viewpager_send_text_name);
                ay.i(this.bXb, com.baidu.tieba.p.btn_pop_news);
                ay.i(this.bXc, com.baidu.tieba.p.icon_pop_news);
                ay.b(this.relation_text, com.baidu.tieba.n.cp_link_tip_c, 1);
            } else if (isFriend == 2) {
                this.relation_text.setText(com.baidu.tieba.t.acceptfriendapply);
                ay.i(this.bXb, com.baidu.tieba.p.btn_blue_bg);
                ay.i(this.bXc, com.baidu.tieba.p.icon_pop_pass);
                ay.b(this.relation_text, com.baidu.tieba.n.cp_cont_i, 1);
            } else {
                this.bWZ.setVisibility(8);
            }
        }
        ay.j(this.line, com.baidu.tieba.n.cp_bg_line_e);
        ay.i(this.bXa, com.baidu.tieba.p.bg_mycenter_toolbar);
        j(this.bVg.aeU().getUserData());
    }

    public void afH() {
        if (this.mIsHost) {
            AntiData aaH = this.bVg.aeU().aaH();
            if (aaH != null) {
                if (AntiHelper.c(aaH) || AntiHelper.e(aaH)) {
                    ay.i(this.bXb, com.baidu.tieba.p.btn_pop_news);
                    ay.b(this.relation_text, com.baidu.tieba.n.cp_link_tip_c, 1);
                }
            } else {
                return;
            }
        } else {
            PersonTainInfo afy = this.bVg.aeU().afy();
            int isFriend = afy != null ? afy.getIsFriend() : 1;
            if (isFriend == 0) {
                ay.i(this.bXb, com.baidu.tieba.p.btn_blue_bg);
                ay.i(this.bXc, com.baidu.tieba.p.icon_person_add);
                ay.b(this.relation_text, com.baidu.tieba.n.cp_cont_i, 1);
            } else if (isFriend == 1) {
                ay.i(this.bXb, com.baidu.tieba.p.btn_pop_news);
                ay.i(this.bXc, com.baidu.tieba.p.icon_pop_news);
                ay.b(this.relation_text, com.baidu.tieba.n.cp_link_tip_c, 1);
            } else if (isFriend == 2) {
                ay.i(this.bXb, com.baidu.tieba.p.btn_blue_bg);
                ay.i(this.bXc, com.baidu.tieba.p.icon_pop_pass);
                ay.b(this.relation_text, com.baidu.tieba.n.cp_cont_i, 1);
            } else {
                this.bWZ.setVisibility(8);
            }
        }
        ay.j(this.line, com.baidu.tieba.n.cp_bg_line_e);
        ay.i(this.bXa, com.baidu.tieba.p.bg_mycenter_toolbar);
        j(this.bVg.aeU().getUserData());
    }

    private void j(UserData userData) {
        if (userData != null && userData.getIsOfficialAccount() == 1) {
            this.relation_text.setText(com.baidu.tieba.t.user_info_center_head_viewpager_send_text_name);
            ay.i(this.bXb, com.baidu.tieba.p.btn_pop_news);
            ay.i(this.bXc, com.baidu.tieba.p.icon_pop_news);
            ay.b(this.relation_text, com.baidu.tieba.n.cp_link_tip_c, 1);
            this.bWU.setVisibility(8);
            this.bWX.afb();
        }
    }

    private void afI() {
        this.aRN = (NavigationBar) this.bVg.findViewById(com.baidu.tieba.q.navigation_bar);
        if (!this.mIsHost) {
            this.aRN.setTitleText(this.bWT);
        } else {
            this.aRN.setTitleText(com.baidu.tieba.t.person_info);
        }
        this.bWV = this.aRN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.bVg);
        this.bWU = (ImageView) this.aRN.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.nb_item_floor_more, this.bVg);
    }

    private void initListView() {
        this.bWW = (BdExpandListView) this.bVg.findViewById(com.baidu.tieba.q.personcenter_list);
        this.bWY = new u(this.bVg, this.mIsHost);
        this.bWW.addHeaderView(this.bWY.getRootView());
        this.bWW.c(this.bWY.getRootView(), this.bVg.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds372));
        this.bWX = new p(this.bVg, this.mIsHost);
        this.bWW.setAdapter((ListAdapter) this.bWX);
        this.bWW.setOnScrollListener(new ae(this));
    }

    public void onStart() {
        this.bWY.afn();
    }

    public void onStop() {
        this.bWY.afo();
    }

    public void startLoad() {
        this.bWW.nd();
    }

    public void hideProgress() {
        this.bWY.hideProgress();
    }

    public void setExpandListRefreshListener(com.baidu.adp.widget.ListView.c cVar) {
        this.bWW.setExpandListRefreshListener(cVar);
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        this.bVg.getLayoutMode().ab(i == 1);
        this.bVg.getLayoutMode().j(this.aYj);
        if (this.bWX != null) {
            this.bWX.notifyDataSetChanged();
        }
        this.bWY.oG();
        afH();
        this.aRN.onChangeSkinType(getPageContext(), i);
        eu(this.mIsHost);
    }

    public UserIconBox afs() {
        return this.bWY.afs();
    }

    public UserIconBox afv() {
        return this.bWY.afv();
    }

    public u afJ() {
        return this.bWY;
    }

    public TextView afu() {
        return this.bWY.afu();
    }

    public LinearLayout afK() {
        return this.bXb;
    }

    public void afL() {
        afG();
        this.aRN.setTitleText(this.bVg.aeU().getName());
        this.bWY.afm();
        this.bWX.notifyDataSetChanged();
        eu(this.mIsHost);
    }

    public HeadImageView afr() {
        return this.bWY.afr();
    }

    public RelativeLayout afa() {
        return this.bWX.afa();
    }

    public void eu(boolean z) {
        if (z) {
            ay.c(this.bWU, com.baidu.tieba.p.icon_pop_edit);
        } else {
            ay.c(this.bWU, com.baidu.tieba.p.icon_more_n);
        }
        if (TbadkCoreApplication.isLogin()) {
            this.bWU.setVisibility(0);
        } else {
            this.bWU.setVisibility(8);
        }
    }

    public LinearLayout aft() {
        return this.bWY.aft();
    }

    public TextView afe() {
        return this.bWX.afe();
    }

    public RelativeLayout afd() {
        return this.bWX.afd();
    }

    public RelativeLayout aff() {
        return this.bWX.aff();
    }

    public RelativeLayout afg() {
        return this.bWX.afg();
    }

    public RelativeLayout afh() {
        return this.bWX.afh();
    }

    public RelativeLayout afi() {
        return this.bWX.afi();
    }

    public RelativeLayout afj() {
        return this.bWX.afj();
    }

    public RelativeLayout afk() {
        return this.bWX.afk();
    }

    public void er(boolean z) {
        if (this.mIsHost) {
            this.bWX.er(z);
        }
    }

    public RelativeLayout afc() {
        return this.bWX.afc();
    }

    public void hV(int i) {
        if (this.mIsHost) {
            this.bWX.hV(i);
        }
    }

    public void g(boolean z, boolean z2) {
        this.bXe = new bt(this.bVg);
        this.bXd = new MorePopupWindow(this.bVg.getPageContext().getPageActivity(), this.bXe.getView(), this.aRN, this.bVg.getResources().getDrawable(com.baidu.tieba.p.bg_pull_down_right_n), new af(this));
        this.bXd.onChangeSkinType(this.bVg, this.mSkinType, this.bVg.getResources().getDrawable(com.baidu.tieba.p.bg_pull_down_right_n));
        this.bXe.f(z, z2);
        this.bXd.refresh();
        this.bXd.showWindowInRightBottomOfHost();
    }

    public void afM() {
        com.baidu.adp.lib.g.k.a(this.bXd, this.bVg.getPageContext().getPageActivity());
    }

    public ImageView afN() {
        return this.bWU;
    }

    public View afO() {
        return this.bWV;
    }

    public View aeD() {
        return this.bXe.aeD();
    }

    public View aeC() {
        return this.bXe.aeC();
    }
}
