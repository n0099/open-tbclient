package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdExpandListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AppealActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.i;
import com.baidu.tieba.person.bl;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class aj extends com.baidu.adp.base.f<PersonInfoActivity> {
    private NavigationBar bdN;
    private View bnc;
    private PersonInfoActivity cqt;
    private ImageView cuA;
    private View cuB;
    private BdExpandListView cuC;
    private t cuD;
    private w cuE;
    private LinearLayout cuF;
    private LinearLayout cuG;
    private LinearLayout cuH;
    private ImageView cuI;
    private MorePopupWindow cuJ;
    private bl cuK;
    private String cuz;
    private View line;
    private boolean mIsHost;
    private int mSkinType;
    private TextView relation_text;

    public aj(PersonInfoActivity personInfoActivity, boolean z) {
        super(personInfoActivity.getPageContext());
        this.cqt = personInfoActivity;
        this.mIsHost = z;
        this.cuz = personInfoActivity.ajf().getName();
        personInfoActivity.setContentView(i.g.person_info_view);
        this.bnc = personInfoActivity.findViewById(i.f.root);
        ajX();
        PL();
        Qz();
    }

    private void Qz() {
        this.cuF = (LinearLayout) this.cqt.findViewById(i.f.relation_root);
        this.cuG = (LinearLayout) this.cqt.findViewById(i.f.relation_ll);
        this.line = this.cqt.findViewById(i.f.line);
        this.cuH = (LinearLayout) this.cqt.findViewById(i.f.relation_bg);
        this.cuH.setOnClickListener(this.cqt);
        this.cuI = (ImageView) this.cqt.findViewById(i.f.relation_icon);
        this.relation_text = (TextView) this.cqt.findViewById(i.f.relation_text);
    }

    private void ajV() {
        if (this.mIsHost) {
            AntiData afh = this.cqt.ajf().afh();
            if (afh != null && AppealActivityConfig.isExistActivity) {
                if (AntiHelper.e(afh) || AntiHelper.g(afh)) {
                    if (this.cuD != null) {
                        this.cuD.b(afh);
                    }
                    this.cuF.setVisibility(0);
                    this.cuI.setVisibility(8);
                    this.relation_text.setText(i.h.account_exception);
                    am.i(this.cuH, i.e.btn_pop_news);
                    am.b(this.relation_text, i.c.cp_link_tip_c, 1);
                }
            } else {
                return;
            }
        } else {
            PersonTainInfo ajN = this.cqt.ajf().ajN();
            int isFriend = ajN != null ? ajN.getIsFriend() : 1;
            this.cuF.setVisibility(0);
            if (isFriend == 0) {
                this.relation_text.setText(i.h.addfriend);
                am.i(this.cuH, i.e.btn_blue_bg);
                am.i(this.cuI, i.e.icon_person_add);
                am.b(this.relation_text, i.c.cp_cont_i, 1);
            } else if (isFriend == 1) {
                this.relation_text.setText(i.h.user_info_center_head_viewpager_send_text_name);
                am.i(this.cuH, i.e.btn_pop_news);
                am.i(this.cuI, i.e.icon_pop_news);
                am.b(this.relation_text, i.c.cp_link_tip_c, 1);
            } else if (isFriend == 2) {
                this.relation_text.setText(i.h.acceptfriendapply);
                am.i(this.cuH, i.e.btn_blue_bg);
                am.i(this.cuI, i.e.icon_pop_pass);
                am.b(this.relation_text, i.c.cp_cont_i, 1);
            } else {
                this.cuF.setVisibility(8);
            }
        }
        am.j(this.line, i.c.cp_bg_line_e);
        am.i(this.cuG, i.e.bg_mycenter_toolbar);
        h(this.cqt.ajf().getUserData());
    }

    public void ajW() {
        if (this.mIsHost) {
            AntiData afh = this.cqt.ajf().afh();
            if (afh != null) {
                if (AntiHelper.e(afh) || AntiHelper.g(afh)) {
                    am.i(this.cuH, i.e.btn_pop_news);
                    am.b(this.relation_text, i.c.cp_link_tip_c, 1);
                }
            } else {
                return;
            }
        } else {
            PersonTainInfo ajN = this.cqt.ajf().ajN();
            int isFriend = ajN != null ? ajN.getIsFriend() : 1;
            if (isFriend == 0) {
                am.i(this.cuH, i.e.btn_blue_bg);
                am.i(this.cuI, i.e.icon_person_add);
                am.b(this.relation_text, i.c.cp_cont_i, 1);
            } else if (isFriend == 1) {
                am.i(this.cuH, i.e.btn_pop_news);
                am.i(this.cuI, i.e.icon_pop_news);
                am.b(this.relation_text, i.c.cp_link_tip_c, 1);
            } else if (isFriend == 2) {
                am.i(this.cuH, i.e.btn_blue_bg);
                am.i(this.cuI, i.e.icon_pop_pass);
                am.b(this.relation_text, i.c.cp_cont_i, 1);
            } else {
                this.cuF.setVisibility(8);
            }
        }
        am.j(this.line, i.c.cp_bg_line_e);
        am.i(this.cuG, i.e.bg_mycenter_toolbar);
        h(this.cqt.ajf().getUserData());
    }

    private void h(UserData userData) {
        if (userData != null && userData.getIsOfficialAccount() == 1) {
            this.relation_text.setText(i.h.user_info_center_head_viewpager_send_text_name);
            am.i(this.cuH, i.e.btn_pop_news);
            am.i(this.cuI, i.e.icon_pop_news);
            am.b(this.relation_text, i.c.cp_link_tip_c, 1);
            this.cuA.setVisibility(8);
            this.cuD.ajp();
        }
    }

    private void ajX() {
        this.bdN = (NavigationBar) this.cqt.findViewById(i.f.navigation_bar);
        if (!this.mIsHost) {
            this.bdN.setTitleText(this.cuz);
        } else {
            this.bdN.setTitleText(i.h.person_info);
        }
        this.cuB = this.bdN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cqt);
        this.cuA = (ImageView) this.bdN.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_floor_more, this.cqt);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cuA.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds16);
        this.cuA.setLayoutParams(layoutParams);
        if (!PersonInfoActivityConfig.IS_SUPPORT_EDIT) {
            this.cuA.setVisibility(8);
        }
    }

    private void PL() {
        this.cuC = (BdExpandListView) this.cqt.findViewById(i.f.personcenter_list);
        this.cuE = new w(this.cqt, this.mIsHost);
        this.cuC.addHeaderView(this.cuE.getRootView());
        this.cuC.c(this.cuE.getRootView(), this.cqt.getResources().getDimensionPixelSize(i.d.ds372));
        this.cuD = new t(this.cqt, this.mIsHost);
        this.cuC.setAdapter((ListAdapter) this.cuD);
        this.cuC.setOnScrollListener(new ak(this));
    }

    public void onDestroy() {
        this.cuE.ajE();
    }

    public RelativeLayout ajs() {
        return this.cuD.ajs();
    }

    public void startLoad() {
        this.cuC.nl();
    }

    public void hideProgress() {
        this.cuE.hideProgress();
    }

    public void setExpandListRefreshListener(BdExpandListView.a aVar) {
        this.cuC.setExpandListRefreshListener(aVar);
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        this.cqt.getLayoutMode().ad(i == 1);
        this.cqt.getLayoutMode().k(this.bnc);
        if (this.cuD != null) {
            this.cuD.notifyDataSetChanged();
        }
        this.cuE.oO();
        ajW();
        this.bdN.onChangeSkinType(getPageContext(), i);
        fd(this.mIsHost);
    }

    public UserIconBox ajI() {
        return this.cuE.ajI();
    }

    public UserIconBox ajL() {
        return this.cuE.ajL();
    }

    public w ajY() {
        return this.cuE;
    }

    public TextView ajK() {
        return this.cuE.ajK();
    }

    public LinearLayout ajZ() {
        return this.cuH;
    }

    public void aka() {
        ajV();
        this.bdN.setTitleText(this.cqt.ajf().getName());
        this.cuE.ajC();
        this.cuD.notifyDataSetChanged();
        fd(this.mIsHost);
    }

    public HeadImageView ajH() {
        return this.cuE.ajH();
    }

    public RelativeLayout ajo() {
        return this.cuD.ajo();
    }

    public void fd(boolean z) {
        if (z) {
            am.a(this.cuA, i.e.icon_person_edit_bg_s, i.e.icon_person_edit_bg);
        } else {
            am.a(this.cuA, i.e.icon_more_bg_s, i.e.icon_more_bg);
        }
        if (TbadkCoreApplication.isLogin() && PersonInfoActivityConfig.IS_SUPPORT_EDIT) {
            this.cuA.setVisibility(0);
        } else {
            this.cuA.setVisibility(8);
        }
    }

    public LinearLayout ajJ() {
        return this.cuE.ajJ();
    }

    public TextView ajt() {
        return this.cuD.ajt();
    }

    public RelativeLayout ajr() {
        return this.cuD.ajr();
    }

    public RelativeLayout aju() {
        return this.cuD.aju();
    }

    public RelativeLayout ajv() {
        return this.cuD.ajv();
    }

    public RelativeLayout ajw() {
        return this.cuD.ajw();
    }

    public RelativeLayout ajx() {
        return this.cuD.ajx();
    }

    public RelativeLayout ajy() {
        return this.cuD.ajy();
    }

    public RelativeLayout ajz() {
        return this.cuD.ajz();
    }

    public RelativeLayout ajA() {
        return this.cuD.ajA();
    }

    public void fa(boolean z) {
        if (this.mIsHost) {
            this.cuD.fa(z);
        }
    }

    public RelativeLayout ajq() {
        return this.cuD.ajq();
    }

    public void jm(int i) {
        if (this.mIsHost) {
            this.cuD.jm(i);
        }
    }

    public void a(boolean z, boolean z2, int i) {
        this.cuK = new bl(this.cqt);
        this.cuJ = new MorePopupWindow(this.cqt.getPageContext().getPageActivity(), this.cuK.getView(), this.bdN, this.cqt.getResources().getDrawable(i.e.bg_pull_down_right_n), new al(this));
        this.cuJ.onChangeSkinType(this.cqt, this.mSkinType, this.cqt.getResources().getDrawable(i.e.bg_pull_down_right_n));
        this.cuK.l(z, z2);
        if (i != -1) {
            this.cuK.jh(i);
        }
        this.cuJ.refresh();
        this.cuJ.showWindowInRightBottomOfHost();
    }

    public void akb() {
        com.baidu.adp.lib.g.j.a(this.cuJ, this.cqt.getPageContext().getPageActivity());
    }

    public ImageView akc() {
        return this.cuA;
    }

    public View akd() {
        return this.cuB;
    }

    public t ake() {
        return this.cuD;
    }

    public View aiK() {
        if (this.cuK == null) {
            return null;
        }
        return this.cuK.aiK();
    }

    public View aiJ() {
        if (this.cuK == null) {
            return null;
        }
        return this.cuK.aiJ();
    }

    public View aiL() {
        if (this.cuK == null) {
            return null;
        }
        return this.cuK.aiL();
    }
}
