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
import com.baidu.tieba.person.ba;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.base.g<PersonInfoActivity> {
    private NavigationBar aPk;
    private View aVn;
    private PersonInfoActivity bSi;
    private String bTV;
    private ImageView bTW;
    private View bTX;
    private BdExpandListView bTY;
    private p bTZ;
    private u bUa;
    private LinearLayout bUb;
    private LinearLayout bUc;
    private LinearLayout bUd;
    private ImageView bUe;
    private TextView bUf;
    private MorePopupWindow bUg;
    private ba bUh;
    private View line;
    private boolean mIsHost;
    private int mSkinType;

    public ae(PersonInfoActivity personInfoActivity, boolean z) {
        super(personInfoActivity.getPageContext());
        this.bSi = personInfoActivity;
        this.mIsHost = z;
        this.bTV = personInfoActivity.ady().getName();
        personInfoActivity.setContentView(com.baidu.tieba.w.person_info_view);
        this.aVn = personInfoActivity.findViewById(com.baidu.tieba.v.root);
        aem();
        initListView();
        Nc();
    }

    private void Nc() {
        this.bUb = (LinearLayout) this.bSi.findViewById(com.baidu.tieba.v.relation_root);
        this.bUc = (LinearLayout) this.bSi.findViewById(com.baidu.tieba.v.relation_ll);
        this.line = this.bSi.findViewById(com.baidu.tieba.v.line);
        this.bUd = (LinearLayout) this.bSi.findViewById(com.baidu.tieba.v.relation_bg);
        this.bUd.setOnClickListener(this.bSi);
        this.bUe = (ImageView) this.bSi.findViewById(com.baidu.tieba.v.relation_icon);
        this.bUf = (TextView) this.bSi.findViewById(com.baidu.tieba.v.relation_text);
    }

    private void ael() {
        if (this.mIsHost) {
            AntiData Zc = this.bSi.ady().Zc();
            if (Zc != null) {
                if (AntiHelper.c(Zc) || AntiHelper.e(Zc)) {
                    this.bUb.setVisibility(0);
                    this.bUe.setVisibility(8);
                    this.bUf.setText(com.baidu.tieba.y.account_exception);
                    com.baidu.tbadk.core.util.ba.i(this.bUd, com.baidu.tieba.u.btn_pop_news);
                    com.baidu.tbadk.core.util.ba.b(this.bUf, com.baidu.tieba.s.cp_link_tip_c, 1);
                }
            } else {
                return;
            }
        } else {
            PersonTainInfo aed = this.bSi.ady().aed();
            int isFriend = aed != null ? aed.getIsFriend() : 1;
            this.bUb.setVisibility(0);
            if (isFriend == 0) {
                this.bUf.setText(com.baidu.tieba.y.addfriend);
                com.baidu.tbadk.core.util.ba.i(this.bUd, com.baidu.tieba.u.btn_blue_bg);
                com.baidu.tbadk.core.util.ba.i(this.bUe, com.baidu.tieba.u.icon_person_add);
                com.baidu.tbadk.core.util.ba.b(this.bUf, com.baidu.tieba.s.cp_cont_i, 1);
            } else if (isFriend == 1) {
                this.bUf.setText(com.baidu.tieba.y.user_info_center_head_viewpager_send_text_name);
                com.baidu.tbadk.core.util.ba.i(this.bUd, com.baidu.tieba.u.btn_pop_news);
                com.baidu.tbadk.core.util.ba.i(this.bUe, com.baidu.tieba.u.icon_pop_news);
                com.baidu.tbadk.core.util.ba.b(this.bUf, com.baidu.tieba.s.cp_link_tip_c, 1);
            } else if (isFriend == 2) {
                this.bUf.setText(com.baidu.tieba.y.acceptfriendapply);
                com.baidu.tbadk.core.util.ba.i(this.bUd, com.baidu.tieba.u.btn_blue_bg);
                com.baidu.tbadk.core.util.ba.i(this.bUe, com.baidu.tieba.u.icon_pop_pass);
                com.baidu.tbadk.core.util.ba.b(this.bUf, com.baidu.tieba.s.cp_cont_i, 1);
            } else {
                this.bUb.setVisibility(8);
            }
        }
        com.baidu.tbadk.core.util.ba.j(this.line, com.baidu.tieba.s.cp_bg_line_e);
        com.baidu.tbadk.core.util.ba.i(this.bUc, com.baidu.tieba.u.bg_mycenter_toolbar);
        j(this.bSi.ady().getUserData());
    }

    private void j(UserData userData) {
        if (userData.getIsOfficialAccount() == 1) {
            this.bUf.setText(com.baidu.tieba.y.user_info_center_head_viewpager_send_text_name);
            com.baidu.tbadk.core.util.ba.i(this.bUd, com.baidu.tieba.u.btn_pop_news);
            com.baidu.tbadk.core.util.ba.i(this.bUe, com.baidu.tieba.u.icon_pop_news);
            com.baidu.tbadk.core.util.ba.b(this.bUf, com.baidu.tieba.s.cp_link_tip_c, 1);
            this.bTW.setVisibility(8);
            this.bTZ.adG();
        }
    }

    private void aem() {
        this.aPk = (NavigationBar) this.bSi.findViewById(com.baidu.tieba.v.navigation_bar);
        if (!this.mIsHost) {
            this.aPk.setTitleText(this.bTV);
        } else {
            this.aPk.setTitleText(com.baidu.tieba.y.person_info);
        }
        this.bTX = this.aPk.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.bSi);
        this.bTW = (ImageView) this.aPk.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.nb_item_floor_more, this.bSi);
    }

    private void initListView() {
        this.bTY = (BdExpandListView) this.bSi.findViewById(com.baidu.tieba.v.personcenter_list);
        this.bUa = new u(this.bSi, this.mIsHost);
        this.bTY.addHeaderView(this.bUa.getRootView());
        this.bTY.c(this.bUa.getRootView(), this.bSi.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds372));
        this.bTZ = new p(this.bSi, this.mIsHost);
        this.bTY.setAdapter((ListAdapter) this.bTZ);
        this.bTY.setOnScrollListener(new af(this));
    }

    public void onStart() {
        this.bUa.adS();
    }

    public void onStop() {
        this.bUa.adT();
    }

    public void startLoad() {
        this.bTY.mK();
    }

    public void hideProgress() {
        this.bUa.hideProgress();
    }

    public void setExpandListRefreshListener(com.baidu.adp.widget.ListView.c cVar) {
        this.bTY.setExpandListRefreshListener(cVar);
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        this.bSi.getLayoutMode().X(i == 1);
        this.bSi.getLayoutMode().h(this.aVn);
        if (this.bTZ != null) {
            this.bTZ.notifyDataSetChanged();
        }
        this.bUa.oq();
        this.aPk.onChangeSkinType(getPageContext(), i);
        ek(this.mIsHost);
    }

    public UserIconBox adX() {
        return this.bUa.adX();
    }

    public UserIconBox aea() {
        return this.bUa.aea();
    }

    public u aen() {
        return this.bUa;
    }

    public TextView adZ() {
        return this.bUa.adZ();
    }

    public LinearLayout aeo() {
        return this.bUd;
    }

    public void aep() {
        ael();
        this.aPk.setTitleText(this.bSi.ady().getName());
        this.bUa.adR();
        this.bTZ.notifyDataSetChanged();
    }

    public HeadImageView adW() {
        return this.bUa.adW();
    }

    public RelativeLayout adF() {
        return this.bTZ.adF();
    }

    public void ek(boolean z) {
        if (z) {
            com.baidu.tbadk.core.util.ba.c(this.bTW, com.baidu.tieba.u.icon_pop_edit);
        } else {
            com.baidu.tbadk.core.util.ba.c(this.bTW, com.baidu.tieba.u.icon_more_n);
        }
    }

    public LinearLayout adY() {
        return this.bUa.adY();
    }

    public TextView adJ() {
        return this.bTZ.adJ();
    }

    public RelativeLayout adI() {
        return this.bTZ.adI();
    }

    public RelativeLayout adK() {
        return this.bTZ.adK();
    }

    public RelativeLayout adL() {
        return this.bTZ.adL();
    }

    public RelativeLayout adM() {
        return this.bTZ.adM();
    }

    public RelativeLayout adN() {
        return this.bTZ.adN();
    }

    public RelativeLayout adO() {
        return this.bTZ.adO();
    }

    public RelativeLayout adP() {
        return this.bTZ.adP();
    }

    public void eh(boolean z) {
        if (this.mIsHost) {
            this.bTZ.eh(z);
        }
    }

    public RelativeLayout adH() {
        return this.bTZ.adH();
    }

    public void hD(int i) {
        if (this.mIsHost) {
            this.bTZ.hD(i);
        }
    }

    public void f(boolean z, boolean z2) {
        this.bUh = new ba(this.bSi);
        this.bUg = new MorePopupWindow(this.bSi.getPageContext().getPageActivity(), this.bUh.getView(), this.aPk, this.bSi.getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_right_n), new ag(this));
        this.bUg.onChangeSkinType(this.bSi, this.mSkinType, this.bSi.getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_right_n));
        this.bUh.e(z, z2);
        this.bUg.refresh();
        this.bUg.showWindowInRightBottomOfHost();
    }

    public void aeq() {
        com.baidu.adp.lib.g.k.a(this.bUg, this.bSi.getPageContext().getPageActivity());
    }

    public ImageView aer() {
        return this.bTW;
    }

    public View aes() {
        return this.bTX;
    }

    public View adf() {
        return this.bUh.adf();
    }

    public View ade() {
        return this.bUh.ade();
    }
}
