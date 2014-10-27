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
import com.baidu.tieba.person.bk;
import com.baidu.tieba.util.AntiHelper;
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.base.f {
    private View aFZ;
    private NavigationBar aGJ;
    private View ahr;
    private PersonInfoActivity bEE;
    private LinearLayout bGA;
    private ImageView bGB;
    private TextView bGC;
    private MorePopupWindow bGD;
    private bk bGE;
    private String bGt;
    private ImageView bGu;
    private BdExpandListView bGv;
    private p bGw;
    private u bGx;
    private LinearLayout bGy;
    private LinearLayout bGz;
    private View bhZ;
    private boolean mIsHost;
    private int mSkinType;

    public ae(PersonInfoActivity personInfoActivity, boolean z) {
        super(personInfoActivity);
        this.bEE = personInfoActivity;
        this.mIsHost = z;
        this.bGt = personInfoActivity.aap().getName();
        personInfoActivity.setContentView(com.baidu.tieba.w.person_info_view);
        this.aFZ = personInfoActivity.findViewById(com.baidu.tieba.v.root);
        abb();
        Ig();
        VI();
    }

    private void VI() {
        this.bGy = (LinearLayout) this.bEE.findViewById(com.baidu.tieba.v.relation_root);
        this.bGz = (LinearLayout) this.bEE.findViewById(com.baidu.tieba.v.relation_ll);
        this.bhZ = this.bEE.findViewById(com.baidu.tieba.v.line);
        this.bGA = (LinearLayout) this.bEE.findViewById(com.baidu.tieba.v.relation_bg);
        this.bGA.setOnClickListener(this.bEE);
        this.bGB = (ImageView) this.bEE.findViewById(com.baidu.tieba.v.relation_icon);
        this.bGC = (TextView) this.bEE.findViewById(com.baidu.tieba.v.relation_text);
    }

    private void aba() {
        if (this.mIsHost) {
            AntiData An = this.bEE.aap().An();
            if (An != null) {
                if (AntiHelper.c(An) || AntiHelper.e(An)) {
                    this.bGy.setVisibility(0);
                    this.bGB.setVisibility(8);
                    this.bGC.setText(com.baidu.tieba.y.account_exception);
                    aw.h(this.bGA, com.baidu.tieba.u.btn_pop_news);
                    aw.b(this.bGC, com.baidu.tieba.s.cp_link_tip_c, 1);
                }
            } else {
                return;
            }
        } else {
            PersonTainInfo aaS = this.bEE.aap().aaS();
            int isFriend = aaS != null ? aaS.getIsFriend() : 1;
            this.bGy.setVisibility(0);
            if (isFriend == 0) {
                this.bGC.setText(com.baidu.tieba.y.addfriend);
                aw.h(this.bGA, com.baidu.tieba.u.btn_blue_bg);
                aw.h(this.bGB, com.baidu.tieba.u.icon_person_add);
                aw.b(this.bGC, com.baidu.tieba.s.cp_cont_i, 1);
            } else if (isFriend == 1) {
                this.bGC.setText(com.baidu.tieba.y.user_info_center_head_viewpager_send_text_name);
                aw.h(this.bGA, com.baidu.tieba.u.btn_pop_news);
                aw.h(this.bGB, com.baidu.tieba.u.icon_pop_news);
                aw.b(this.bGC, com.baidu.tieba.s.cp_link_tip_c, 1);
            } else if (isFriend == 2) {
                this.bGC.setText(com.baidu.tieba.y.acceptfriendapply);
                aw.h(this.bGA, com.baidu.tieba.u.btn_blue_bg);
                aw.h(this.bGB, com.baidu.tieba.u.icon_pop_pass);
                aw.b(this.bGC, com.baidu.tieba.s.cp_cont_i, 1);
            } else {
                this.bGy.setVisibility(8);
            }
        }
        aw.i(this.bhZ, com.baidu.tieba.s.cp_bg_line_e);
        aw.h(this.bGz, com.baidu.tieba.u.bg_mycenter_toolbar);
    }

    private void abb() {
        this.aGJ = (NavigationBar) this.bEE.findViewById(com.baidu.tieba.v.navigation_bar);
        if (!this.mIsHost) {
            this.aGJ.setTitleText(this.bGt);
        } else {
            this.aGJ.setTitleText(com.baidu.tieba.y.person_info);
        }
        this.ahr = this.aGJ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.bEE);
        this.bGu = (ImageView) this.aGJ.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.nb_item_floor_more, this.bEE);
    }

    private void Ig() {
        this.bGv = (BdExpandListView) this.bEE.findViewById(com.baidu.tieba.v.personcenter_list);
        this.bGx = new u(this.bEE, this.mIsHost);
        this.bGv.addHeaderView(this.bGx.getRootView());
        this.bGv.setExpandView(this.bGx.getRootView());
        this.bGw = new p(this.bEE, this.mIsHost);
        this.bGv.setAdapter((ListAdapter) this.bGw);
        this.bGv.setOnScrollListener(new af(this));
    }

    public void onStart() {
        this.bGx.aaH();
    }

    public void onStop() {
        this.bGx.aaI();
    }

    public void Nj() {
        this.bGv.hx();
    }

    public void hideProgress() {
        this.bGx.hideProgress();
    }

    public void setExpandListRefreshListener(com.baidu.adp.widget.ListView.b bVar) {
        this.bGv.setExpandListRefreshListener(bVar);
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        this.bEE.getLayoutMode().L(i == 1);
        this.bEE.getLayoutMode().h(this.aFZ);
        this.bGx.pS();
        this.aGJ.onChangeSkinType(i);
        eB(this.mIsHost);
    }

    public UserIconBox aaM() {
        return this.bGx.aaM();
    }

    public UserIconBox aaP() {
        return this.bGx.aaP();
    }

    public u abc() {
        return this.bGx;
    }

    public TextView aaO() {
        return this.bGx.aaO();
    }

    public LinearLayout abd() {
        return this.bGA;
    }

    public void abe() {
        aba();
        this.bGx.Hu();
        this.bGw.notifyDataSetChanged();
    }

    public HeadImageView aaL() {
        return this.bGx.aaL();
    }

    public RelativeLayout aaw() {
        return this.bGw.aaw();
    }

    public void eB(boolean z) {
        if (z) {
            aw.c(this.bGu, com.baidu.tieba.u.icon_pop_edit);
        } else {
            aw.c(this.bGu, com.baidu.tieba.u.icon_more_n);
        }
    }

    public LinearLayout aaN() {
        return this.bGx.aaN();
    }

    public TextView aaz() {
        return this.bGw.aaz();
    }

    public RelativeLayout aay() {
        return this.bGw.aay();
    }

    public RelativeLayout aaA() {
        return this.bGw.aaA();
    }

    public RelativeLayout aaB() {
        return this.bGw.aaB();
    }

    public RelativeLayout aaC() {
        return this.bGw.aaC();
    }

    public RelativeLayout aaD() {
        return this.bGw.aaD();
    }

    public RelativeLayout aaE() {
        return this.bGw.aaE();
    }

    public RelativeLayout aaF() {
        return this.bGw.aaF();
    }

    public void ey(boolean z) {
        if (this.mIsHost) {
            this.bGw.ey(z);
        }
    }

    public RelativeLayout aax() {
        return this.bGw.aax();
    }

    public void hc(int i) {
        if (this.mIsHost) {
            this.bGw.hc(i);
        }
    }

    public void h(boolean z, boolean z2) {
        this.bGE = new bk(this.bEE);
        this.bGD = new MorePopupWindow(this.bEE, this.bGE.getView(), this.aGJ, this.bEE.getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_right_n), new ag(this));
        this.bGD.onChangeSkinType(this.bEE, this.mSkinType, this.bEE.getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_right_n));
        this.bGE.g(z, z2);
        this.bGD.refresh();
        this.bGD.showWindowInRightBottomOfHost();
    }

    public void abf() {
        com.baidu.adp.lib.g.j.a(this.bGD, this.bEE);
    }

    public ImageView abg() {
        return this.bGu;
    }

    public View xO() {
        return this.ahr;
    }

    public View aad() {
        return this.bGE.aad();
    }

    public View aac() {
        return this.bGE.aac();
    }
}
