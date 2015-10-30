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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.i;
import com.baidu.tieba.person.bl;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class aj extends com.baidu.adp.base.f<PersonInfoActivity> {
    private NavigationBar bdY;
    private View bnn;
    private PersonInfoActivity cqE;
    private String cuK;
    private ImageView cuL;
    private View cuM;
    private BdExpandListView cuN;
    private t cuO;
    private w cuP;
    private LinearLayout cuQ;
    private LinearLayout cuR;
    private LinearLayout cuS;
    private ImageView cuT;
    private MorePopupWindow cuU;
    private bl cuV;
    private View line;
    private boolean mIsHost;
    private int mSkinType;
    private TextView relation_text;

    public aj(PersonInfoActivity personInfoActivity, boolean z) {
        super(personInfoActivity.getPageContext());
        this.cqE = personInfoActivity;
        this.mIsHost = z;
        this.cuK = personInfoActivity.ajb().getName();
        personInfoActivity.setContentView(i.g.person_info_view);
        this.bnn = personInfoActivity.findViewById(i.f.root);
        ajT();
        PH();
        Qv();
    }

    private void Qv() {
        this.cuQ = (LinearLayout) this.cqE.findViewById(i.f.relation_root);
        this.cuR = (LinearLayout) this.cqE.findViewById(i.f.relation_ll);
        this.line = this.cqE.findViewById(i.f.line);
        this.cuS = (LinearLayout) this.cqE.findViewById(i.f.relation_bg);
        this.cuS.setOnClickListener(this.cqE);
        this.cuT = (ImageView) this.cqE.findViewById(i.f.relation_icon);
        this.relation_text = (TextView) this.cqE.findViewById(i.f.relation_text);
    }

    private void ajR() {
        if (this.mIsHost) {
            AntiData afd = this.cqE.ajb().afd();
            if (afd != null && AppealActivityConfig.isExistActivity) {
                if (AntiHelper.e(afd) || AntiHelper.g(afd)) {
                    if (this.cuO != null) {
                        this.cuO.b(afd);
                    }
                    this.cuQ.setVisibility(0);
                    this.cuT.setVisibility(8);
                    this.relation_text.setText(i.h.account_exception);
                    an.i(this.cuS, i.e.btn_pop_news);
                    an.b(this.relation_text, i.c.cp_link_tip_c, 1);
                }
            } else {
                return;
            }
        } else {
            PersonTainInfo ajJ = this.cqE.ajb().ajJ();
            int isFriend = ajJ != null ? ajJ.getIsFriend() : 1;
            this.cuQ.setVisibility(0);
            if (isFriend == 0) {
                this.relation_text.setText(i.h.addfriend);
                an.i(this.cuS, i.e.btn_blue_bg);
                an.i(this.cuT, i.e.icon_person_add);
                an.b(this.relation_text, i.c.cp_cont_i, 1);
            } else if (isFriend == 1) {
                this.relation_text.setText(i.h.user_info_center_head_viewpager_send_text_name);
                an.i(this.cuS, i.e.btn_pop_news);
                an.i(this.cuT, i.e.icon_pop_news);
                an.b(this.relation_text, i.c.cp_link_tip_c, 1);
            } else if (isFriend == 2) {
                this.relation_text.setText(i.h.acceptfriendapply);
                an.i(this.cuS, i.e.btn_blue_bg);
                an.i(this.cuT, i.e.icon_pop_pass);
                an.b(this.relation_text, i.c.cp_cont_i, 1);
            } else {
                this.cuQ.setVisibility(8);
            }
        }
        an.j(this.line, i.c.cp_bg_line_e);
        an.i(this.cuR, i.e.bg_mycenter_toolbar);
        h(this.cqE.ajb().getUserData());
    }

    public void ajS() {
        if (this.mIsHost) {
            AntiData afd = this.cqE.ajb().afd();
            if (afd != null) {
                if (AntiHelper.e(afd) || AntiHelper.g(afd)) {
                    an.i(this.cuS, i.e.btn_pop_news);
                    an.b(this.relation_text, i.c.cp_link_tip_c, 1);
                }
            } else {
                return;
            }
        } else {
            PersonTainInfo ajJ = this.cqE.ajb().ajJ();
            int isFriend = ajJ != null ? ajJ.getIsFriend() : 1;
            if (isFriend == 0) {
                an.i(this.cuS, i.e.btn_blue_bg);
                an.i(this.cuT, i.e.icon_person_add);
                an.b(this.relation_text, i.c.cp_cont_i, 1);
            } else if (isFriend == 1) {
                an.i(this.cuS, i.e.btn_pop_news);
                an.i(this.cuT, i.e.icon_pop_news);
                an.b(this.relation_text, i.c.cp_link_tip_c, 1);
            } else if (isFriend == 2) {
                an.i(this.cuS, i.e.btn_blue_bg);
                an.i(this.cuT, i.e.icon_pop_pass);
                an.b(this.relation_text, i.c.cp_cont_i, 1);
            } else {
                this.cuQ.setVisibility(8);
            }
        }
        an.j(this.line, i.c.cp_bg_line_e);
        an.i(this.cuR, i.e.bg_mycenter_toolbar);
        h(this.cqE.ajb().getUserData());
    }

    private void h(UserData userData) {
        if (userData != null && userData.getIsOfficialAccount() == 1) {
            this.relation_text.setText(i.h.user_info_center_head_viewpager_send_text_name);
            an.i(this.cuS, i.e.btn_pop_news);
            an.i(this.cuT, i.e.icon_pop_news);
            an.b(this.relation_text, i.c.cp_link_tip_c, 1);
            this.cuL.setVisibility(8);
            this.cuO.ajl();
        }
    }

    private void ajT() {
        this.bdY = (NavigationBar) this.cqE.findViewById(i.f.navigation_bar);
        if (!this.mIsHost) {
            this.bdY.setTitleText(this.cuK);
        } else {
            this.bdY.setTitleText(i.h.person_info);
        }
        this.cuM = this.bdY.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cqE);
        this.cuL = (ImageView) this.bdY.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_floor_more, this.cqE);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cuL.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds16);
        this.cuL.setLayoutParams(layoutParams);
        if (!PersonInfoActivityConfig.IS_SUPPORT_EDIT) {
            this.cuL.setVisibility(8);
        }
    }

    private void PH() {
        this.cuN = (BdExpandListView) this.cqE.findViewById(i.f.personcenter_list);
        this.cuP = new w(this.cqE, this.mIsHost);
        this.cuN.addHeaderView(this.cuP.getRootView());
        this.cuN.c(this.cuP.getRootView(), this.cqE.getResources().getDimensionPixelSize(i.d.ds372));
        this.cuO = new t(this.cqE, this.mIsHost);
        this.cuN.setAdapter((ListAdapter) this.cuO);
        this.cuN.setOnScrollListener(new ak(this));
    }

    public void onDestroy() {
        this.cuP.ajA();
    }

    public RelativeLayout ajo() {
        return this.cuO.ajo();
    }

    public void startLoad() {
        this.cuN.nl();
    }

    public void hideProgress() {
        this.cuP.hideProgress();
    }

    public void setExpandListRefreshListener(BdExpandListView.a aVar) {
        this.cuN.setExpandListRefreshListener(aVar);
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        this.cqE.getLayoutMode().ad(i == 1);
        this.cqE.getLayoutMode().k(this.bnn);
        if (this.cuO != null) {
            this.cuO.notifyDataSetChanged();
        }
        this.cuP.oO();
        ajS();
        this.bdY.onChangeSkinType(getPageContext(), i);
        fd(this.mIsHost);
    }

    public UserIconBox ajE() {
        return this.cuP.ajE();
    }

    public UserIconBox ajH() {
        return this.cuP.ajH();
    }

    public w ajU() {
        return this.cuP;
    }

    public TextView ajG() {
        return this.cuP.ajG();
    }

    public LinearLayout ajV() {
        return this.cuS;
    }

    public void ajW() {
        ajR();
        this.bdY.setTitleText(this.cqE.ajb().getName());
        this.cuP.ajy();
        this.cuO.notifyDataSetChanged();
        fd(this.mIsHost);
    }

    public HeadImageView ajD() {
        return this.cuP.ajD();
    }

    public RelativeLayout ajk() {
        return this.cuO.ajk();
    }

    public void fd(boolean z) {
        if (z) {
            an.a(this.cuL, i.e.icon_person_edit_bg_s, i.e.icon_person_edit_bg);
        } else {
            an.a(this.cuL, i.e.icon_more_bg_s, i.e.icon_more_bg);
        }
        if (TbadkCoreApplication.isLogin() && PersonInfoActivityConfig.IS_SUPPORT_EDIT) {
            this.cuL.setVisibility(0);
        } else {
            this.cuL.setVisibility(8);
        }
    }

    public LinearLayout ajF() {
        return this.cuP.ajF();
    }

    public TextView ajp() {
        return this.cuO.ajp();
    }

    public RelativeLayout ajn() {
        return this.cuO.ajn();
    }

    public RelativeLayout ajq() {
        return this.cuO.ajq();
    }

    public RelativeLayout ajr() {
        return this.cuO.ajr();
    }

    public RelativeLayout ajs() {
        return this.cuO.ajs();
    }

    public RelativeLayout ajt() {
        return this.cuO.ajt();
    }

    public RelativeLayout aju() {
        return this.cuO.aju();
    }

    public RelativeLayout ajv() {
        return this.cuO.ajv();
    }

    public RelativeLayout ajw() {
        return this.cuO.ajw();
    }

    public void fa(boolean z) {
        if (this.mIsHost) {
            this.cuO.fa(z);
        }
    }

    public RelativeLayout ajm() {
        return this.cuO.ajm();
    }

    public void jm(int i) {
        if (this.mIsHost) {
            this.cuO.jm(i);
        }
    }

    public void a(boolean z, boolean z2, int i) {
        this.cuV = new bl(this.cqE);
        this.cuU = new MorePopupWindow(this.cqE.getPageContext().getPageActivity(), this.cuV.getView(), this.bdY, this.cqE.getResources().getDrawable(i.e.bg_pull_down_right_n), new al(this));
        this.cuU.onChangeSkinType(this.cqE, this.mSkinType, this.cqE.getResources().getDrawable(i.e.bg_pull_down_right_n));
        this.cuV.l(z, z2);
        if (i != -1) {
            this.cuV.jh(i);
        }
        this.cuU.refresh();
        this.cuU.showWindowInRightBottomOfHost();
    }

    public void ajX() {
        com.baidu.adp.lib.g.j.a(this.cuU, this.cqE.getPageContext().getPageActivity());
    }

    public ImageView ajY() {
        return this.cuL;
    }

    public View ajZ() {
        return this.cuM;
    }

    public t aka() {
        return this.cuO;
    }

    public View aiG() {
        if (this.cuV == null) {
            return null;
        }
        return this.cuV.aiG();
    }

    public View aiF() {
        if (this.cuV == null) {
            return null;
        }
        return this.cuV.aiF();
    }

    public View aiH() {
        if (this.cuV == null) {
            return null;
        }
        return this.cuV.aiH();
    }
}
