package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdExpandListView;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.person.bc;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.base.g<PersonInfoActivity> {
    private NavigationBar aJk;
    private View aOl;
    private View apK;
    private PersonInfoActivity bJY;
    private String bLL;
    private ImageView bLM;
    private BdExpandListView bLN;
    private p bLO;
    private u bLP;
    private LinearLayout bLQ;
    private LinearLayout bLR;
    private LinearLayout bLS;
    private ImageView bLT;
    private TextView bLU;
    private MorePopupWindow bLV;
    private bc bLW;
    private View line;
    private boolean mIsHost;
    private int mSkinType;

    public ae(PersonInfoActivity personInfoActivity, boolean z) {
        super(personInfoActivity.getPageContext());
        this.bJY = personInfoActivity;
        this.mIsHost = z;
        this.bLL = personInfoActivity.abl().getName();
        personInfoActivity.setContentView(com.baidu.tieba.x.person_info_view);
        this.aOl = personInfoActivity.findViewById(com.baidu.tieba.w.root);
        abZ();
        initListView();
        WG();
    }

    private void WG() {
        this.bLQ = (LinearLayout) this.bJY.findViewById(com.baidu.tieba.w.relation_root);
        this.bLR = (LinearLayout) this.bJY.findViewById(com.baidu.tieba.w.relation_ll);
        this.line = this.bJY.findViewById(com.baidu.tieba.w.line);
        this.bLS = (LinearLayout) this.bJY.findViewById(com.baidu.tieba.w.relation_bg);
        this.bLS.setOnClickListener(this.bJY);
        this.bLT = (ImageView) this.bJY.findViewById(com.baidu.tieba.w.relation_icon);
        this.bLU = (TextView) this.bJY.findViewById(com.baidu.tieba.w.relation_text);
    }

    private void abY() {
        if (this.mIsHost) {
            AntiData abO = this.bJY.abl().abO();
            if (abO != null) {
                if (AntiHelper.c(abO) || AntiHelper.e(abO)) {
                    this.bLQ.setVisibility(0);
                    this.bLT.setVisibility(8);
                    this.bLU.setText(com.baidu.tieba.z.account_exception);
                    com.baidu.tbadk.core.util.bc.i(this.bLS, com.baidu.tieba.v.btn_pop_news);
                    com.baidu.tbadk.core.util.bc.b(this.bLU, com.baidu.tieba.t.cp_link_tip_c, 1);
                }
            } else {
                return;
            }
        } else {
            PersonTainInfo abQ = this.bJY.abl().abQ();
            int isFriend = abQ != null ? abQ.getIsFriend() : 1;
            this.bLQ.setVisibility(0);
            if (isFriend == 0) {
                this.bLU.setText(com.baidu.tieba.z.addfriend);
                com.baidu.tbadk.core.util.bc.i(this.bLS, com.baidu.tieba.v.btn_blue_bg);
                com.baidu.tbadk.core.util.bc.i(this.bLT, com.baidu.tieba.v.icon_person_add);
                com.baidu.tbadk.core.util.bc.b(this.bLU, com.baidu.tieba.t.cp_cont_i, 1);
            } else if (isFriend == 1) {
                this.bLU.setText(com.baidu.tieba.z.user_info_center_head_viewpager_send_text_name);
                com.baidu.tbadk.core.util.bc.i(this.bLS, com.baidu.tieba.v.btn_pop_news);
                com.baidu.tbadk.core.util.bc.i(this.bLT, com.baidu.tieba.v.icon_pop_news);
                com.baidu.tbadk.core.util.bc.b(this.bLU, com.baidu.tieba.t.cp_link_tip_c, 1);
            } else if (isFriend == 2) {
                this.bLU.setText(com.baidu.tieba.z.acceptfriendapply);
                com.baidu.tbadk.core.util.bc.i(this.bLS, com.baidu.tieba.v.btn_blue_bg);
                com.baidu.tbadk.core.util.bc.i(this.bLT, com.baidu.tieba.v.icon_pop_pass);
                com.baidu.tbadk.core.util.bc.b(this.bLU, com.baidu.tieba.t.cp_cont_i, 1);
            } else {
                this.bLQ.setVisibility(8);
            }
        }
        com.baidu.tbadk.core.util.bc.j(this.line, com.baidu.tieba.t.cp_bg_line_e);
        com.baidu.tbadk.core.util.bc.i(this.bLR, com.baidu.tieba.v.bg_mycenter_toolbar);
        k(this.bJY.abl().getUserData());
    }

    private void k(UserData userData) {
        if (userData.getIsOfficialAccount() == 1) {
            this.bLU.setText(com.baidu.tieba.z.user_info_center_head_viewpager_send_text_name);
            com.baidu.tbadk.core.util.bc.i(this.bLS, com.baidu.tieba.v.btn_pop_news);
            com.baidu.tbadk.core.util.bc.i(this.bLT, com.baidu.tieba.v.icon_pop_news);
            com.baidu.tbadk.core.util.bc.b(this.bLU, com.baidu.tieba.t.cp_link_tip_c, 1);
            this.bLM.setVisibility(8);
            this.bLO.abs();
        }
    }

    private void abZ() {
        this.aJk = (NavigationBar) this.bJY.findViewById(com.baidu.tieba.w.navigation_bar);
        if (!this.mIsHost) {
            this.aJk.setTitleText(this.bLL);
        } else {
            this.aJk.setTitleText(com.baidu.tieba.z.person_info);
        }
        this.aJk.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.apK = this.aJk.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.bJY);
        this.bLM = (ImageView) this.aJk.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.nb_item_floor_more, this.bJY);
    }

    private void DD() {
        this.aJk.setTitleText(this.bJY.abl().getUserData().getUserName());
    }

    private void initListView() {
        this.bLN = (BdExpandListView) this.bJY.findViewById(com.baidu.tieba.w.personcenter_list);
        this.bLP = new u(this.bJY, this.mIsHost);
        this.bLN.addHeaderView(this.bLP.getRootView());
        this.bLN.c(this.bLP.getRootView(), this.bJY.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds372));
        this.bLO = new p(this.bJY, this.mIsHost);
        this.bLN.setAdapter((ListAdapter) this.bLO);
        this.bLN.setOnScrollListener(new af(this));
    }

    public void onStart() {
        this.bLP.abE();
    }

    public void onStop() {
        this.bLP.abF();
    }

    public void startLoad() {
        this.bLN.jo();
    }

    public void hideProgress() {
        this.bLP.hideProgress();
    }

    public void setExpandListRefreshListener(com.baidu.adp.widget.ListView.c cVar) {
        this.bLN.setExpandListRefreshListener(cVar);
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        this.bJY.getLayoutMode().ab(i == 1);
        this.bJY.getLayoutMode().h(this.aOl);
        this.bLP.kx();
        this.aJk.onChangeSkinType(getPageContext(), i);
        en(this.mIsHost);
    }

    public UserIconBox abJ() {
        return this.bLP.abJ();
    }

    public UserIconBox abM() {
        return this.bLP.abM();
    }

    public u aca() {
        return this.bLP;
    }

    public TextView abL() {
        return this.bLP.abL();
    }

    public LinearLayout acb() {
        return this.bLS;
    }

    public void acc() {
        abY();
        DD();
        this.bLP.abD();
        this.bLO.notifyDataSetChanged();
    }

    public HeadImageView abI() {
        return this.bLP.abI();
    }

    public RelativeLayout abr() {
        return this.bLO.abr();
    }

    public void en(boolean z) {
        if (z) {
            com.baidu.tbadk.core.util.bc.c(this.bLM, com.baidu.tieba.v.icon_pop_edit);
        } else {
            com.baidu.tbadk.core.util.bc.c(this.bLM, com.baidu.tieba.v.icon_more_n);
        }
    }

    public LinearLayout abK() {
        return this.bLP.abK();
    }

    public TextView abv() {
        return this.bLO.abv();
    }

    public RelativeLayout abu() {
        return this.bLO.abu();
    }

    public RelativeLayout abw() {
        return this.bLO.abw();
    }

    public RelativeLayout abx() {
        return this.bLO.abx();
    }

    public RelativeLayout aby() {
        return this.bLO.aby();
    }

    public RelativeLayout abz() {
        return this.bLO.abz();
    }

    public RelativeLayout abA() {
        return this.bLO.abA();
    }

    public RelativeLayout abB() {
        return this.bLO.abB();
    }

    public void ek(boolean z) {
        if (this.mIsHost) {
            this.bLO.ek(z);
        }
    }

    public RelativeLayout abt() {
        return this.bLO.abt();
    }

    public void hu(int i) {
        if (this.mIsHost) {
            this.bLO.hu(i);
        }
    }

    public void j(boolean z, boolean z2) {
        this.bLW = new bc(this.bJY);
        this.bLV = new MorePopupWindow(this.bJY.getPageContext().getPageActivity(), this.bLW.getView(), this.aJk, this.bJY.getResources().getDrawable(com.baidu.tieba.v.bg_pull_down_right_n), new ag(this));
        this.bLV.onChangeSkinType(this.bJY, this.mSkinType, this.bJY.getResources().getDrawable(com.baidu.tieba.v.bg_pull_down_right_n));
        this.bLW.i(z, z2);
        this.bLV.refresh();
        this.bLV.showWindowInRightBottomOfHost();
    }

    public void acd() {
        com.baidu.adp.lib.g.k.a(this.bLV, this.bJY.getPageContext().getPageActivity());
    }

    public ImageView ace() {
        return this.bLM;
    }

    public View BC() {
        return this.apK;
    }

    public View aaW() {
        if (this.bLW != null) {
            return this.bLW.aaW();
        }
        return null;
    }

    public View aaV() {
        if (this.bLW != null) {
            return this.bLW.aaV();
        }
        return null;
    }
}
