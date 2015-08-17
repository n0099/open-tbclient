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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.i;
import com.baidu.tieba.person.bk;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.base.f<PersonInfoActivity> {
    private NavigationBar bdj;
    private View bmf;
    private PersonInfoActivity cjU;
    private String cnM;
    private ImageView cnN;
    private View cnO;
    private BdExpandListView cnP;
    private s cnQ;
    private v cnR;
    private LinearLayout cnS;
    private LinearLayout cnT;
    private LinearLayout cnU;
    private ImageView cnV;
    private MorePopupWindow cnW;
    private bk cnX;
    private View line;
    private boolean mIsHost;
    private int mSkinType;
    private TextView relation_text;

    public ag(PersonInfoActivity personInfoActivity, boolean z) {
        super(personInfoActivity.getPageContext());
        this.cjU = personInfoActivity;
        this.mIsHost = z;
        this.cnM = personInfoActivity.agL().getName();
        personInfoActivity.setContentView(i.g.person_info_view);
        this.bmf = personInfoActivity.findViewById(i.f.root);
        ahE();
        PI();
        Qq();
    }

    private void Qq() {
        this.cnS = (LinearLayout) this.cjU.findViewById(i.f.relation_root);
        this.cnT = (LinearLayout) this.cjU.findViewById(i.f.relation_ll);
        this.line = this.cjU.findViewById(i.f.line);
        this.cnU = (LinearLayout) this.cjU.findViewById(i.f.relation_bg);
        this.cnU.setOnClickListener(this.cjU);
        this.cnV = (ImageView) this.cjU.findViewById(i.f.relation_icon);
        this.relation_text = (TextView) this.cjU.findViewById(i.f.relation_text);
    }

    private void ahC() {
        if (this.mIsHost) {
            AntiData acW = this.cjU.agL().acW();
            if (acW != null && AppealActivityConfig.isExistActivity) {
                if (AntiHelper.d(acW) || AntiHelper.f(acW)) {
                    this.cnS.setVisibility(0);
                    this.cnV.setVisibility(8);
                    this.relation_text.setText(i.C0057i.account_exception);
                    al.i(this.cnU, i.e.btn_pop_news);
                    al.b(this.relation_text, i.c.cp_link_tip_c, 1);
                }
            } else {
                return;
            }
        } else {
            PersonTainInfo ahu = this.cjU.agL().ahu();
            int isFriend = ahu != null ? ahu.getIsFriend() : 1;
            this.cnS.setVisibility(0);
            if (isFriend == 0) {
                this.relation_text.setText(i.C0057i.addfriend);
                al.i(this.cnU, i.e.btn_blue_bg);
                al.i(this.cnV, i.e.icon_person_add);
                al.b(this.relation_text, i.c.cp_cont_i, 1);
            } else if (isFriend == 1) {
                this.relation_text.setText(i.C0057i.user_info_center_head_viewpager_send_text_name);
                al.i(this.cnU, i.e.btn_pop_news);
                al.i(this.cnV, i.e.icon_pop_news);
                al.b(this.relation_text, i.c.cp_link_tip_c, 1);
            } else if (isFriend == 2) {
                this.relation_text.setText(i.C0057i.acceptfriendapply);
                al.i(this.cnU, i.e.btn_blue_bg);
                al.i(this.cnV, i.e.icon_pop_pass);
                al.b(this.relation_text, i.c.cp_cont_i, 1);
            } else {
                this.cnS.setVisibility(8);
            }
        }
        al.j(this.line, i.c.cp_bg_line_e);
        al.i(this.cnT, i.e.bg_mycenter_toolbar);
        g(this.cjU.agL().getUserData());
    }

    public void ahD() {
        if (this.mIsHost) {
            AntiData acW = this.cjU.agL().acW();
            if (acW != null) {
                if (AntiHelper.d(acW) || AntiHelper.f(acW)) {
                    al.i(this.cnU, i.e.btn_pop_news);
                    al.b(this.relation_text, i.c.cp_link_tip_c, 1);
                }
            } else {
                return;
            }
        } else {
            PersonTainInfo ahu = this.cjU.agL().ahu();
            int isFriend = ahu != null ? ahu.getIsFriend() : 1;
            if (isFriend == 0) {
                al.i(this.cnU, i.e.btn_blue_bg);
                al.i(this.cnV, i.e.icon_person_add);
                al.b(this.relation_text, i.c.cp_cont_i, 1);
            } else if (isFriend == 1) {
                al.i(this.cnU, i.e.btn_pop_news);
                al.i(this.cnV, i.e.icon_pop_news);
                al.b(this.relation_text, i.c.cp_link_tip_c, 1);
            } else if (isFriend == 2) {
                al.i(this.cnU, i.e.btn_blue_bg);
                al.i(this.cnV, i.e.icon_pop_pass);
                al.b(this.relation_text, i.c.cp_cont_i, 1);
            } else {
                this.cnS.setVisibility(8);
            }
        }
        al.j(this.line, i.c.cp_bg_line_e);
        al.i(this.cnT, i.e.bg_mycenter_toolbar);
        g(this.cjU.agL().getUserData());
    }

    private void g(UserData userData) {
        if (userData != null && userData.getIsOfficialAccount() == 1) {
            this.relation_text.setText(i.C0057i.user_info_center_head_viewpager_send_text_name);
            al.i(this.cnU, i.e.btn_pop_news);
            al.i(this.cnV, i.e.icon_pop_news);
            al.b(this.relation_text, i.c.cp_link_tip_c, 1);
            this.cnN.setVisibility(8);
            this.cnQ.agV();
        }
    }

    private void ahE() {
        this.bdj = (NavigationBar) this.cjU.findViewById(i.f.navigation_bar);
        if (!this.mIsHost) {
            this.bdj.setTitleText(this.cnM);
        } else {
            this.bdj.setTitleText(i.C0057i.person_info);
        }
        this.cnO = this.bdj.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cjU);
        this.cnN = (ImageView) this.bdj.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_floor_more, this.cjU);
        if (!PersonInfoActivityConfig.IS_SUPPORT_EDIT) {
            this.cnN.setVisibility(8);
        }
    }

    private void PI() {
        this.cnP = (BdExpandListView) this.cjU.findViewById(i.f.personcenter_list);
        this.cnR = new v(this.cjU, this.mIsHost);
        this.cnP.addHeaderView(this.cnR.getRootView());
        this.cnP.c(this.cnR.getRootView(), this.cjU.getResources().getDimensionPixelSize(i.d.ds372));
        this.cnQ = new s(this.cjU, this.mIsHost);
        this.cnP.setAdapter((ListAdapter) this.cnQ);
        this.cnP.setOnScrollListener(new ah(this));
    }

    public void onStart() {
        this.cnR.ahk();
    }

    public void onDestroy() {
        this.cnR.ahl();
    }

    public RelativeLayout agY() {
        return this.cnQ.agY();
    }

    public void startLoad() {
        this.cnP.nn();
    }

    public void hideProgress() {
        this.cnR.hideProgress();
    }

    public void setExpandListRefreshListener(BdExpandListView.a aVar) {
        this.cnP.setExpandListRefreshListener(aVar);
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        this.cjU.getLayoutMode().ad(i == 1);
        this.cjU.getLayoutMode().k(this.bmf);
        if (this.cnQ != null) {
            this.cnQ.notifyDataSetChanged();
        }
        this.cnR.oQ();
        ahD();
        this.bdj.onChangeSkinType(getPageContext(), i);
        eM(this.mIsHost);
    }

    public UserIconBox ahp() {
        return this.cnR.ahp();
    }

    public UserIconBox ahs() {
        return this.cnR.ahs();
    }

    public v ahF() {
        return this.cnR;
    }

    public TextView ahr() {
        return this.cnR.ahr();
    }

    public LinearLayout ahG() {
        return this.cnU;
    }

    public void ahH() {
        ahC();
        this.bdj.setTitleText(this.cjU.agL().getName());
        this.cnR.ahi();
        this.cnQ.notifyDataSetChanged();
        eM(this.mIsHost);
    }

    public HeadImageView aho() {
        return this.cnR.aho();
    }

    public RelativeLayout agU() {
        return this.cnQ.agU();
    }

    public void eM(boolean z) {
        if (z) {
            al.c(this.cnN, i.e.icon_pop_edit);
        } else {
            al.c(this.cnN, i.e.icon_more_n);
        }
        if (TbadkCoreApplication.isLogin() && PersonInfoActivityConfig.IS_SUPPORT_EDIT) {
            this.cnN.setVisibility(0);
        } else {
            this.cnN.setVisibility(8);
        }
    }

    public LinearLayout ahq() {
        return this.cnR.ahq();
    }

    public TextView agZ() {
        return this.cnQ.agZ();
    }

    public RelativeLayout agX() {
        return this.cnQ.agX();
    }

    public RelativeLayout aha() {
        return this.cnQ.aha();
    }

    public RelativeLayout ahb() {
        return this.cnQ.ahb();
    }

    public RelativeLayout ahc() {
        return this.cnQ.ahc();
    }

    public RelativeLayout ahd() {
        return this.cnQ.ahd();
    }

    public RelativeLayout ahe() {
        return this.cnQ.ahe();
    }

    public RelativeLayout ahf() {
        return this.cnQ.ahf();
    }

    public RelativeLayout ahg() {
        return this.cnQ.ahg();
    }

    public void eJ(boolean z) {
        if (this.mIsHost) {
            this.cnQ.eJ(z);
        }
    }

    public RelativeLayout agW() {
        return this.cnQ.agW();
    }

    public void iP(int i) {
        if (this.mIsHost) {
            this.cnQ.iP(i);
        }
    }

    public void a(boolean z, boolean z2, int i) {
        this.cnX = new bk(this.cjU);
        this.cnW = new MorePopupWindow(this.cjU.getPageContext().getPageActivity(), this.cnX.getView(), this.bdj, this.cjU.getResources().getDrawable(i.e.bg_pull_down_right_n), new ai(this));
        this.cnW.onChangeSkinType(this.cjU, this.mSkinType, this.cjU.getResources().getDrawable(i.e.bg_pull_down_right_n));
        this.cnX.j(z, z2);
        if (i != -1) {
            this.cnX.iL(i);
        }
        this.cnW.refresh();
        this.cnW.showWindowInRightBottomOfHost();
    }

    public void ahI() {
        com.baidu.adp.lib.g.j.a(this.cnW, this.cjU.getPageContext().getPageActivity());
    }

    public ImageView ahJ() {
        return this.cnN;
    }

    public View ahK() {
        return this.cnO;
    }

    public s ahL() {
        return this.cnQ;
    }

    public View agu() {
        if (this.cnX == null) {
            return null;
        }
        return this.cnX.agu();
    }

    public View agt() {
        if (this.cnX == null) {
            return null;
        }
        return this.cnX.agt();
    }

    public View agv() {
        if (this.cnX == null) {
            return null;
        }
        return this.cnX.agv();
    }
}
