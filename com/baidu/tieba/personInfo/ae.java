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
    private NavigationBar aJn;
    private View aOm;
    private View apN;
    private PersonInfoActivity bJZ;
    private String bLM;
    private ImageView bLN;
    private BdExpandListView bLO;
    private p bLP;
    private u bLQ;
    private LinearLayout bLR;
    private LinearLayout bLS;
    private LinearLayout bLT;
    private ImageView bLU;
    private TextView bLV;
    private MorePopupWindow bLW;
    private bc bLX;
    private View line;
    private boolean mIsHost;
    private int mSkinType;

    public ae(PersonInfoActivity personInfoActivity, boolean z) {
        super(personInfoActivity.getPageContext());
        this.bJZ = personInfoActivity;
        this.mIsHost = z;
        this.bLM = personInfoActivity.abq().getName();
        personInfoActivity.setContentView(com.baidu.tieba.x.person_info_view);
        this.aOm = personInfoActivity.findViewById(com.baidu.tieba.w.root);
        ace();
        initListView();
        WL();
    }

    private void WL() {
        this.bLR = (LinearLayout) this.bJZ.findViewById(com.baidu.tieba.w.relation_root);
        this.bLS = (LinearLayout) this.bJZ.findViewById(com.baidu.tieba.w.relation_ll);
        this.line = this.bJZ.findViewById(com.baidu.tieba.w.line);
        this.bLT = (LinearLayout) this.bJZ.findViewById(com.baidu.tieba.w.relation_bg);
        this.bLT.setOnClickListener(this.bJZ);
        this.bLU = (ImageView) this.bJZ.findViewById(com.baidu.tieba.w.relation_icon);
        this.bLV = (TextView) this.bJZ.findViewById(com.baidu.tieba.w.relation_text);
    }

    private void acd() {
        if (this.mIsHost) {
            AntiData abT = this.bJZ.abq().abT();
            if (abT != null) {
                if (AntiHelper.c(abT) || AntiHelper.e(abT)) {
                    this.bLR.setVisibility(0);
                    this.bLU.setVisibility(8);
                    this.bLV.setText(com.baidu.tieba.z.account_exception);
                    com.baidu.tbadk.core.util.bc.i(this.bLT, com.baidu.tieba.v.btn_pop_news);
                    com.baidu.tbadk.core.util.bc.b(this.bLV, com.baidu.tieba.t.cp_link_tip_c, 1);
                }
            } else {
                return;
            }
        } else {
            PersonTainInfo abV = this.bJZ.abq().abV();
            int isFriend = abV != null ? abV.getIsFriend() : 1;
            this.bLR.setVisibility(0);
            if (isFriend == 0) {
                this.bLV.setText(com.baidu.tieba.z.addfriend);
                com.baidu.tbadk.core.util.bc.i(this.bLT, com.baidu.tieba.v.btn_blue_bg);
                com.baidu.tbadk.core.util.bc.i(this.bLU, com.baidu.tieba.v.icon_person_add);
                com.baidu.tbadk.core.util.bc.b(this.bLV, com.baidu.tieba.t.cp_cont_i, 1);
            } else if (isFriend == 1) {
                this.bLV.setText(com.baidu.tieba.z.user_info_center_head_viewpager_send_text_name);
                com.baidu.tbadk.core.util.bc.i(this.bLT, com.baidu.tieba.v.btn_pop_news);
                com.baidu.tbadk.core.util.bc.i(this.bLU, com.baidu.tieba.v.icon_pop_news);
                com.baidu.tbadk.core.util.bc.b(this.bLV, com.baidu.tieba.t.cp_link_tip_c, 1);
            } else if (isFriend == 2) {
                this.bLV.setText(com.baidu.tieba.z.acceptfriendapply);
                com.baidu.tbadk.core.util.bc.i(this.bLT, com.baidu.tieba.v.btn_blue_bg);
                com.baidu.tbadk.core.util.bc.i(this.bLU, com.baidu.tieba.v.icon_pop_pass);
                com.baidu.tbadk.core.util.bc.b(this.bLV, com.baidu.tieba.t.cp_cont_i, 1);
            } else {
                this.bLR.setVisibility(8);
            }
        }
        com.baidu.tbadk.core.util.bc.j(this.line, com.baidu.tieba.t.cp_bg_line_e);
        com.baidu.tbadk.core.util.bc.i(this.bLS, com.baidu.tieba.v.bg_mycenter_toolbar);
        k(this.bJZ.abq().getUserData());
    }

    private void k(UserData userData) {
        if (userData.getIsOfficialAccount() == 1) {
            this.bLV.setText(com.baidu.tieba.z.user_info_center_head_viewpager_send_text_name);
            com.baidu.tbadk.core.util.bc.i(this.bLT, com.baidu.tieba.v.btn_pop_news);
            com.baidu.tbadk.core.util.bc.i(this.bLU, com.baidu.tieba.v.icon_pop_news);
            com.baidu.tbadk.core.util.bc.b(this.bLV, com.baidu.tieba.t.cp_link_tip_c, 1);
            this.bLN.setVisibility(8);
            this.bLP.abx();
        }
    }

    private void ace() {
        this.aJn = (NavigationBar) this.bJZ.findViewById(com.baidu.tieba.w.navigation_bar);
        if (!this.mIsHost) {
            this.aJn.setTitleText(this.bLM);
        } else {
            this.aJn.setTitleText(com.baidu.tieba.z.person_info);
        }
        this.aJn.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.apN = this.aJn.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.bJZ);
        this.bLN = (ImageView) this.aJn.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.nb_item_floor_more, this.bJZ);
    }

    private void DJ() {
        this.aJn.setTitleText(this.bJZ.abq().getUserData().getUserName());
    }

    private void initListView() {
        this.bLO = (BdExpandListView) this.bJZ.findViewById(com.baidu.tieba.w.personcenter_list);
        this.bLQ = new u(this.bJZ, this.mIsHost);
        this.bLO.addHeaderView(this.bLQ.getRootView());
        this.bLO.c(this.bLQ.getRootView(), this.bJZ.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds372));
        this.bLP = new p(this.bJZ, this.mIsHost);
        this.bLO.setAdapter((ListAdapter) this.bLP);
        this.bLO.setOnScrollListener(new af(this));
    }

    public void onStart() {
        this.bLQ.abJ();
    }

    public void onStop() {
        this.bLQ.abK();
    }

    public void startLoad() {
        this.bLO.jv();
    }

    public void hideProgress() {
        this.bLQ.hideProgress();
    }

    public void setExpandListRefreshListener(com.baidu.adp.widget.ListView.c cVar) {
        this.bLO.setExpandListRefreshListener(cVar);
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        this.bJZ.getLayoutMode().ab(i == 1);
        this.bJZ.getLayoutMode().h(this.aOm);
        this.bLQ.kE();
        this.aJn.onChangeSkinType(getPageContext(), i);
        en(this.mIsHost);
    }

    public UserIconBox abO() {
        return this.bLQ.abO();
    }

    public UserIconBox abR() {
        return this.bLQ.abR();
    }

    public u acf() {
        return this.bLQ;
    }

    public TextView abQ() {
        return this.bLQ.abQ();
    }

    public LinearLayout acg() {
        return this.bLT;
    }

    public void ach() {
        acd();
        DJ();
        this.bLQ.abI();
        this.bLP.notifyDataSetChanged();
    }

    public HeadImageView abN() {
        return this.bLQ.abN();
    }

    public RelativeLayout abw() {
        return this.bLP.abw();
    }

    public void en(boolean z) {
        if (z) {
            com.baidu.tbadk.core.util.bc.c(this.bLN, com.baidu.tieba.v.icon_pop_edit);
        } else {
            com.baidu.tbadk.core.util.bc.c(this.bLN, com.baidu.tieba.v.icon_more_n);
        }
    }

    public LinearLayout abP() {
        return this.bLQ.abP();
    }

    public TextView abA() {
        return this.bLP.abA();
    }

    public RelativeLayout abz() {
        return this.bLP.abz();
    }

    public RelativeLayout abB() {
        return this.bLP.abB();
    }

    public RelativeLayout abC() {
        return this.bLP.abC();
    }

    public RelativeLayout abD() {
        return this.bLP.abD();
    }

    public RelativeLayout abE() {
        return this.bLP.abE();
    }

    public RelativeLayout abF() {
        return this.bLP.abF();
    }

    public RelativeLayout abG() {
        return this.bLP.abG();
    }

    public void ek(boolean z) {
        if (this.mIsHost) {
            this.bLP.ek(z);
        }
    }

    public RelativeLayout aby() {
        return this.bLP.aby();
    }

    public void hu(int i) {
        if (this.mIsHost) {
            this.bLP.hu(i);
        }
    }

    public void j(boolean z, boolean z2) {
        this.bLX = new bc(this.bJZ);
        this.bLW = new MorePopupWindow(this.bJZ.getPageContext().getPageActivity(), this.bLX.getView(), this.aJn, this.bJZ.getResources().getDrawable(com.baidu.tieba.v.bg_pull_down_right_n), new ag(this));
        this.bLW.onChangeSkinType(this.bJZ, this.mSkinType, this.bJZ.getResources().getDrawable(com.baidu.tieba.v.bg_pull_down_right_n));
        this.bLX.i(z, z2);
        this.bLW.refresh();
        this.bLW.showWindowInRightBottomOfHost();
    }

    public void aci() {
        com.baidu.adp.lib.g.k.a(this.bLW, this.bJZ.getPageContext().getPageActivity());
    }

    public ImageView acj() {
        return this.bLN;
    }

    public View BI() {
        return this.apN;
    }

    public View abb() {
        if (this.bLX != null) {
            return this.bLX.abb();
        }
        return null;
    }

    public View aba() {
        if (this.bLX != null) {
            return this.bLX.aba();
        }
        return null;
    }
}
