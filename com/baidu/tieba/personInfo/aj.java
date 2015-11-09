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
    private NavigationBar beE;
    private View bnR;
    private PersonInfoActivity csa;
    private String cwg;
    private ImageView cwh;
    private View cwi;
    private BdExpandListView cwj;
    private t cwk;
    private w cwl;
    private LinearLayout cwm;
    private LinearLayout cwn;
    private LinearLayout cwo;
    private ImageView cwp;
    private MorePopupWindow cwq;
    private bl cwr;
    private View line;
    private boolean mIsHost;
    private int mSkinType;
    private TextView relation_text;

    public aj(PersonInfoActivity personInfoActivity, boolean z) {
        super(personInfoActivity.getPageContext());
        this.csa = personInfoActivity;
        this.mIsHost = z;
        this.cwg = personInfoActivity.ajH().getName();
        personInfoActivity.setContentView(i.g.person_info_view);
        this.bnR = personInfoActivity.findViewById(i.f.root);
        akz();
        Qd();
        QR();
    }

    private void QR() {
        this.cwm = (LinearLayout) this.csa.findViewById(i.f.relation_root);
        this.cwn = (LinearLayout) this.csa.findViewById(i.f.relation_ll);
        this.line = this.csa.findViewById(i.f.line);
        this.cwo = (LinearLayout) this.csa.findViewById(i.f.relation_bg);
        this.cwo.setOnClickListener(this.csa);
        this.cwp = (ImageView) this.csa.findViewById(i.f.relation_icon);
        this.relation_text = (TextView) this.csa.findViewById(i.f.relation_text);
    }

    private void akx() {
        if (this.mIsHost) {
            AntiData afA = this.csa.ajH().afA();
            if (afA != null && AppealActivityConfig.isExistActivity) {
                if (AntiHelper.e(afA) || AntiHelper.g(afA)) {
                    if (this.cwk != null) {
                        this.cwk.b(afA);
                    }
                    this.cwm.setVisibility(0);
                    this.cwp.setVisibility(8);
                    this.relation_text.setText(i.h.account_exception);
                    an.i(this.cwo, i.e.btn_pop_news);
                    an.b(this.relation_text, i.c.cp_link_tip_c, 1);
                }
            } else {
                return;
            }
        } else {
            PersonTainInfo akp = this.csa.ajH().akp();
            int isFriend = akp != null ? akp.getIsFriend() : 1;
            this.cwm.setVisibility(0);
            if (isFriend == 0) {
                this.relation_text.setText(i.h.addfriend);
                an.i(this.cwo, i.e.btn_blue_bg);
                an.i(this.cwp, i.e.icon_person_add);
                an.b(this.relation_text, i.c.cp_cont_i, 1);
            } else if (isFriend == 1) {
                this.relation_text.setText(i.h.user_info_center_head_viewpager_send_text_name);
                an.i(this.cwo, i.e.btn_pop_news);
                an.i(this.cwp, i.e.icon_pop_news);
                an.b(this.relation_text, i.c.cp_link_tip_c, 1);
            } else if (isFriend == 2) {
                this.relation_text.setText(i.h.acceptfriendapply);
                an.i(this.cwo, i.e.btn_blue_bg);
                an.i(this.cwp, i.e.icon_pop_pass);
                an.b(this.relation_text, i.c.cp_cont_i, 1);
            } else {
                this.cwm.setVisibility(8);
            }
        }
        an.j(this.line, i.c.cp_bg_line_e);
        an.i(this.cwn, i.e.bg_mycenter_toolbar);
        h(this.csa.ajH().getUserData());
    }

    public void aky() {
        if (this.mIsHost) {
            AntiData afA = this.csa.ajH().afA();
            if (afA != null) {
                if (AntiHelper.e(afA) || AntiHelper.g(afA)) {
                    an.i(this.cwo, i.e.btn_pop_news);
                    an.b(this.relation_text, i.c.cp_link_tip_c, 1);
                }
            } else {
                return;
            }
        } else {
            PersonTainInfo akp = this.csa.ajH().akp();
            int isFriend = akp != null ? akp.getIsFriend() : 1;
            if (isFriend == 0) {
                an.i(this.cwo, i.e.btn_blue_bg);
                an.i(this.cwp, i.e.icon_person_add);
                an.b(this.relation_text, i.c.cp_cont_i, 1);
            } else if (isFriend == 1) {
                an.i(this.cwo, i.e.btn_pop_news);
                an.i(this.cwp, i.e.icon_pop_news);
                an.b(this.relation_text, i.c.cp_link_tip_c, 1);
            } else if (isFriend == 2) {
                an.i(this.cwo, i.e.btn_blue_bg);
                an.i(this.cwp, i.e.icon_pop_pass);
                an.b(this.relation_text, i.c.cp_cont_i, 1);
            } else {
                this.cwm.setVisibility(8);
            }
        }
        an.j(this.line, i.c.cp_bg_line_e);
        an.i(this.cwn, i.e.bg_mycenter_toolbar);
        h(this.csa.ajH().getUserData());
    }

    private void h(UserData userData) {
        if (userData != null && userData.getIsOfficialAccount() == 1) {
            this.relation_text.setText(i.h.user_info_center_head_viewpager_send_text_name);
            an.i(this.cwo, i.e.btn_pop_news);
            an.i(this.cwp, i.e.icon_pop_news);
            an.b(this.relation_text, i.c.cp_link_tip_c, 1);
            this.cwh.setVisibility(8);
            this.cwk.ajR();
        }
    }

    private void akz() {
        this.beE = (NavigationBar) this.csa.findViewById(i.f.navigation_bar);
        if (!this.mIsHost) {
            this.beE.setTitleText(this.cwg);
        } else {
            this.beE.setTitleText(i.h.person_info);
        }
        this.cwi = this.beE.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.csa);
        this.cwh = (ImageView) this.beE.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_floor_more, this.csa);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cwh.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds16);
        this.cwh.setLayoutParams(layoutParams);
        if (!PersonInfoActivityConfig.IS_SUPPORT_EDIT) {
            this.cwh.setVisibility(8);
        }
    }

    private void Qd() {
        this.cwj = (BdExpandListView) this.csa.findViewById(i.f.personcenter_list);
        this.cwl = new w(this.csa, this.mIsHost);
        this.cwj.addHeaderView(this.cwl.getRootView());
        this.cwj.c(this.cwl.getRootView(), this.csa.getResources().getDimensionPixelSize(i.d.ds372));
        this.cwk = new t(this.csa, this.mIsHost);
        this.cwj.setAdapter((ListAdapter) this.cwk);
        this.cwj.setOnScrollListener(new ak(this));
    }

    public void onDestroy() {
        this.cwl.akg();
    }

    public RelativeLayout ajU() {
        return this.cwk.ajU();
    }

    public void startLoad() {
        this.cwj.nm();
    }

    public void hideProgress() {
        this.cwl.hideProgress();
    }

    public void setExpandListRefreshListener(BdExpandListView.a aVar) {
        this.cwj.setExpandListRefreshListener(aVar);
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        this.csa.getLayoutMode().ad(i == 1);
        this.csa.getLayoutMode().k(this.bnR);
        if (this.cwk != null) {
            this.cwk.notifyDataSetChanged();
        }
        this.cwl.oP();
        aky();
        this.beE.onChangeSkinType(getPageContext(), i);
        fg(this.mIsHost);
    }

    public UserIconBox akk() {
        return this.cwl.akk();
    }

    public UserIconBox akn() {
        return this.cwl.akn();
    }

    public w akA() {
        return this.cwl;
    }

    public TextView akm() {
        return this.cwl.akm();
    }

    public LinearLayout akB() {
        return this.cwo;
    }

    public void akC() {
        akx();
        if (this.csa != null && this.csa.ajH() != null) {
            this.beE.setTitleText(this.csa.ajH().getNameShow());
        }
        this.cwl.ake();
        this.cwk.notifyDataSetChanged();
        fg(this.mIsHost);
    }

    public HeadImageView akj() {
        return this.cwl.akj();
    }

    public RelativeLayout ajQ() {
        return this.cwk.ajQ();
    }

    public void fg(boolean z) {
        if (z) {
            an.a(this.cwh, i.e.icon_person_edit_bg_s, i.e.icon_person_edit_bg);
        } else {
            an.a(this.cwh, i.e.icon_more_bg_s, i.e.icon_more_bg);
        }
        if (TbadkCoreApplication.isLogin() && PersonInfoActivityConfig.IS_SUPPORT_EDIT) {
            this.cwh.setVisibility(0);
        } else {
            this.cwh.setVisibility(8);
        }
    }

    public LinearLayout akl() {
        return this.cwl.akl();
    }

    public TextView ajV() {
        return this.cwk.ajV();
    }

    public RelativeLayout ajT() {
        return this.cwk.ajT();
    }

    public RelativeLayout ajW() {
        return this.cwk.ajW();
    }

    public RelativeLayout ajX() {
        return this.cwk.ajX();
    }

    public RelativeLayout ajY() {
        return this.cwk.ajY();
    }

    public RelativeLayout ajZ() {
        return this.cwk.ajZ();
    }

    public RelativeLayout aka() {
        return this.cwk.aka();
    }

    public RelativeLayout akb() {
        return this.cwk.akb();
    }

    public RelativeLayout akc() {
        return this.cwk.akc();
    }

    public void fd(boolean z) {
        if (this.mIsHost) {
            this.cwk.fd(z);
        }
    }

    public RelativeLayout ajS() {
        return this.cwk.ajS();
    }

    public void jA(int i) {
        if (this.mIsHost) {
            this.cwk.jA(i);
        }
    }

    public void a(boolean z, boolean z2, int i) {
        this.cwr = new bl(this.csa);
        this.cwq = new MorePopupWindow(this.csa.getPageContext().getPageActivity(), this.cwr.getView(), this.beE, this.csa.getResources().getDrawable(i.e.bg_pull_down_right_n), new al(this));
        this.cwq.onChangeSkinType(this.csa, this.mSkinType, this.csa.getResources().getDrawable(i.e.bg_pull_down_right_n));
        this.cwr.l(z, z2);
        if (i != -1) {
            this.cwr.jv(i);
        }
        this.cwq.refresh();
        this.cwq.showWindowInRightBottomOfHost();
    }

    public void akD() {
        com.baidu.adp.lib.g.j.a(this.cwq, this.csa.getPageContext().getPageActivity());
    }

    public ImageView akE() {
        return this.cwh;
    }

    public View akF() {
        return this.cwi;
    }

    public t akG() {
        return this.cwk;
    }

    public View ajm() {
        if (this.cwr == null) {
            return null;
        }
        return this.cwr.ajm();
    }

    public View ajl() {
        if (this.cwr == null) {
            return null;
        }
        return this.cwr.ajl();
    }

    public View ajn() {
        if (this.cwr == null) {
            return null;
        }
        return this.cwr.ajn();
    }
}
