package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdExpandListView;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.person.bl;
import com.baidu.tieba.util.AntiHelper;
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.base.f {
    private NavigationBar aGT;
    private View aGj;
    private View ahA;
    private PersonInfoActivity bES;
    private String bGH;
    private ImageView bGI;
    private BdExpandListView bGJ;
    private p bGK;
    private u bGL;
    private LinearLayout bGM;
    private LinearLayout bGN;
    private LinearLayout bGO;
    private ImageView bGP;
    private TextView bGQ;
    private MorePopupWindow bGR;
    private bl bGS;
    private View bip;
    private boolean mIsHost;
    private int mSkinType;

    public ae(PersonInfoActivity personInfoActivity, boolean z) {
        super(personInfoActivity);
        this.bES = personInfoActivity;
        this.mIsHost = z;
        this.bGH = personInfoActivity.aar().getName();
        personInfoActivity.setContentView(com.baidu.tieba.w.person_info_view);
        this.aGj = personInfoActivity.findViewById(com.baidu.tieba.v.root);
        abe();
        Ik();
        VL();
    }

    private void VL() {
        this.bGM = (LinearLayout) this.bES.findViewById(com.baidu.tieba.v.relation_root);
        this.bGN = (LinearLayout) this.bES.findViewById(com.baidu.tieba.v.relation_ll);
        this.bip = this.bES.findViewById(com.baidu.tieba.v.line);
        this.bGO = (LinearLayout) this.bES.findViewById(com.baidu.tieba.v.relation_bg);
        this.bGO.setOnClickListener(this.bES);
        this.bGP = (ImageView) this.bES.findViewById(com.baidu.tieba.v.relation_icon);
        this.bGQ = (TextView) this.bES.findViewById(com.baidu.tieba.v.relation_text);
    }

    private void abd() {
        if (this.mIsHost) {
            AntiData Ap = this.bES.aar().Ap();
            if (Ap != null) {
                if (AntiHelper.c(Ap) || AntiHelper.e(Ap)) {
                    this.bGM.setVisibility(0);
                    this.bGP.setVisibility(8);
                    this.bGQ.setText(com.baidu.tieba.y.account_exception);
                    aw.h(this.bGO, com.baidu.tieba.u.btn_pop_news);
                    aw.b(this.bGQ, com.baidu.tieba.s.cp_link_tip_c, 1);
                }
            } else {
                return;
            }
        } else {
            PersonTainInfo aaV = this.bES.aar().aaV();
            int isFriend = aaV != null ? aaV.getIsFriend() : 1;
            this.bGM.setVisibility(0);
            if (isFriend == 0) {
                this.bGQ.setText(com.baidu.tieba.y.addfriend);
                aw.h(this.bGO, com.baidu.tieba.u.btn_blue_bg);
                aw.h(this.bGP, com.baidu.tieba.u.icon_person_add);
                aw.b(this.bGQ, com.baidu.tieba.s.cp_cont_i, 1);
            } else if (isFriend == 1) {
                this.bGQ.setText(com.baidu.tieba.y.user_info_center_head_viewpager_send_text_name);
                aw.h(this.bGO, com.baidu.tieba.u.btn_pop_news);
                aw.h(this.bGP, com.baidu.tieba.u.icon_pop_news);
                aw.b(this.bGQ, com.baidu.tieba.s.cp_link_tip_c, 1);
            } else if (isFriend == 2) {
                this.bGQ.setText(com.baidu.tieba.y.acceptfriendapply);
                aw.h(this.bGO, com.baidu.tieba.u.btn_blue_bg);
                aw.h(this.bGP, com.baidu.tieba.u.icon_pop_pass);
                aw.b(this.bGQ, com.baidu.tieba.s.cp_cont_i, 1);
            } else {
                this.bGM.setVisibility(8);
            }
        }
        aw.i(this.bip, com.baidu.tieba.s.cp_bg_line_e);
        aw.h(this.bGN, com.baidu.tieba.u.bg_mycenter_toolbar);
    }

    private void abe() {
        this.aGT = (NavigationBar) this.bES.findViewById(com.baidu.tieba.v.navigation_bar);
        if (!this.mIsHost) {
            this.aGT.setTitleText(this.bGH);
        } else {
            this.aGT.setTitleText(com.baidu.tieba.y.person_info);
        }
        this.ahA = this.aGT.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.bES);
        this.bGI = (ImageView) this.aGT.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.nb_item_floor_more, this.bES);
    }

    private void Ik() {
        this.bGJ = (BdExpandListView) this.bES.findViewById(com.baidu.tieba.v.personcenter_list);
        this.bGL = new u(this.bES, this.mIsHost);
        this.bGJ.addHeaderView(this.bGL.getRootView());
        this.bGJ.setExpandView(this.bGL.getRootView());
        this.bGK = new p(this.bES, this.mIsHost);
        this.bGJ.setAdapter((ListAdapter) this.bGK);
        this.bGJ.setOnScrollListener(new af(this));
    }

    public void onStart() {
        this.bGL.aaK();
    }

    public void onStop() {
        this.bGL.aaL();
    }

    public void Nn() {
        this.bGJ.hx();
    }

    public void hideProgress() {
        this.bGL.hideProgress();
    }

    public void setExpandListRefreshListener(com.baidu.adp.widget.ListView.b bVar) {
        this.bGJ.setExpandListRefreshListener(bVar);
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        this.bES.getLayoutMode().L(i == 1);
        this.bES.getLayoutMode().h(this.aGj);
        this.bGL.pU();
        this.aGT.onChangeSkinType(i);
        eB(this.mIsHost);
    }

    public UserIconBox aaP() {
        return this.bGL.aaP();
    }

    public UserIconBox aaS() {
        return this.bGL.aaS();
    }

    public u abf() {
        return this.bGL;
    }

    public TextView aaR() {
        return this.bGL.aaR();
    }

    public LinearLayout abg() {
        return this.bGO;
    }

    public void abh() {
        abd();
        this.bGL.aaJ();
        this.bGK.notifyDataSetChanged();
    }

    public HeadImageView aaO() {
        return this.bGL.aaO();
    }

    public RelativeLayout aay() {
        return this.bGK.aay();
    }

    public void eB(boolean z) {
        if (z) {
            aw.c(this.bGI, com.baidu.tieba.u.icon_pop_edit);
        } else {
            aw.c(this.bGI, com.baidu.tieba.u.icon_more_n);
        }
    }

    public LinearLayout aaQ() {
        return this.bGL.aaQ();
    }

    public TextView aaB() {
        return this.bGK.aaB();
    }

    public RelativeLayout aaA() {
        return this.bGK.aaA();
    }

    public RelativeLayout aaC() {
        return this.bGK.aaC();
    }

    public RelativeLayout aaD() {
        return this.bGK.aaD();
    }

    public RelativeLayout aaE() {
        return this.bGK.aaE();
    }

    public RelativeLayout aaF() {
        return this.bGK.aaF();
    }

    public RelativeLayout aaG() {
        return this.bGK.aaG();
    }

    public RelativeLayout aaH() {
        return this.bGK.aaH();
    }

    public void ey(boolean z) {
        if (this.mIsHost) {
            this.bGK.ey(z);
        }
    }

    public RelativeLayout aaz() {
        return this.bGK.aaz();
    }

    public void hc(int i) {
        if (this.mIsHost) {
            this.bGK.hc(i);
        }
    }

    public void h(boolean z, boolean z2) {
        this.bGS = new bl(this.bES);
        this.bGR = new MorePopupWindow(this.bES, this.bGS.getView(), this.aGT, this.bES.getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_right_n), new ag(this));
        this.bGR.onChangeSkinType(this.bES, this.mSkinType, this.bES.getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_right_n));
        this.bGS.g(z, z2);
        this.bGR.refresh();
        this.bGR.showWindowInRightBottomOfHost();
    }

    public void abi() {
        com.baidu.adp.lib.g.j.a(this.bGR, this.bES);
    }

    public ImageView abj() {
        return this.bGI;
    }

    public View xQ() {
        return this.ahA;
    }

    public View aaf() {
        return this.bGS.aaf();
    }

    public View aae() {
        return this.bGS.aae();
    }
}
