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
    private NavigationBar bdE;
    private View bmB;
    private PersonInfoActivity ckP;
    private String coN;
    private ImageView coO;
    private View coP;
    private BdExpandListView coQ;
    private s coR;
    private v coS;
    private LinearLayout coT;
    private LinearLayout coU;
    private LinearLayout coV;
    private ImageView coW;
    private MorePopupWindow coX;
    private bk coY;
    private View line;
    private boolean mIsHost;
    private int mSkinType;
    private TextView relation_text;

    public ag(PersonInfoActivity personInfoActivity, boolean z) {
        super(personInfoActivity.getPageContext());
        this.ckP = personInfoActivity;
        this.mIsHost = z;
        this.coN = personInfoActivity.ahd().getName();
        personInfoActivity.setContentView(i.g.person_info_view);
        this.bmB = personInfoActivity.findViewById(i.f.root);
        ahW();
        PJ();
        Qs();
    }

    private void Qs() {
        this.coT = (LinearLayout) this.ckP.findViewById(i.f.relation_root);
        this.coU = (LinearLayout) this.ckP.findViewById(i.f.relation_ll);
        this.line = this.ckP.findViewById(i.f.line);
        this.coV = (LinearLayout) this.ckP.findViewById(i.f.relation_bg);
        this.coV.setOnClickListener(this.ckP);
        this.coW = (ImageView) this.ckP.findViewById(i.f.relation_icon);
        this.relation_text = (TextView) this.ckP.findViewById(i.f.relation_text);
    }

    private void ahU() {
        if (this.mIsHost) {
            AntiData adj = this.ckP.ahd().adj();
            if (adj != null && AppealActivityConfig.isExistActivity) {
                if (AntiHelper.d(adj) || AntiHelper.f(adj)) {
                    this.coT.setVisibility(0);
                    this.coW.setVisibility(8);
                    this.relation_text.setText(i.h.account_exception);
                    al.h(this.coV, i.e.btn_pop_news);
                    al.b(this.relation_text, i.c.cp_link_tip_c, 1);
                }
            } else {
                return;
            }
        } else {
            PersonTainInfo ahM = this.ckP.ahd().ahM();
            int isFriend = ahM != null ? ahM.getIsFriend() : 1;
            this.coT.setVisibility(0);
            if (isFriend == 0) {
                this.relation_text.setText(i.h.addfriend);
                al.h(this.coV, i.e.btn_blue_bg);
                al.h(this.coW, i.e.icon_person_add);
                al.b(this.relation_text, i.c.cp_cont_i, 1);
            } else if (isFriend == 1) {
                this.relation_text.setText(i.h.user_info_center_head_viewpager_send_text_name);
                al.h(this.coV, i.e.btn_pop_news);
                al.h(this.coW, i.e.icon_pop_news);
                al.b(this.relation_text, i.c.cp_link_tip_c, 1);
            } else if (isFriend == 2) {
                this.relation_text.setText(i.h.acceptfriendapply);
                al.h(this.coV, i.e.btn_blue_bg);
                al.h(this.coW, i.e.icon_pop_pass);
                al.b(this.relation_text, i.c.cp_cont_i, 1);
            } else {
                this.coT.setVisibility(8);
            }
        }
        al.i(this.line, i.c.cp_bg_line_e);
        al.h(this.coU, i.e.bg_mycenter_toolbar);
        g(this.ckP.ahd().getUserData());
    }

    public void ahV() {
        if (this.mIsHost) {
            AntiData adj = this.ckP.ahd().adj();
            if (adj != null) {
                if (AntiHelper.d(adj) || AntiHelper.f(adj)) {
                    al.h(this.coV, i.e.btn_pop_news);
                    al.b(this.relation_text, i.c.cp_link_tip_c, 1);
                }
            } else {
                return;
            }
        } else {
            PersonTainInfo ahM = this.ckP.ahd().ahM();
            int isFriend = ahM != null ? ahM.getIsFriend() : 1;
            if (isFriend == 0) {
                al.h(this.coV, i.e.btn_blue_bg);
                al.h(this.coW, i.e.icon_person_add);
                al.b(this.relation_text, i.c.cp_cont_i, 1);
            } else if (isFriend == 1) {
                al.h(this.coV, i.e.btn_pop_news);
                al.h(this.coW, i.e.icon_pop_news);
                al.b(this.relation_text, i.c.cp_link_tip_c, 1);
            } else if (isFriend == 2) {
                al.h(this.coV, i.e.btn_blue_bg);
                al.h(this.coW, i.e.icon_pop_pass);
                al.b(this.relation_text, i.c.cp_cont_i, 1);
            } else {
                this.coT.setVisibility(8);
            }
        }
        al.i(this.line, i.c.cp_bg_line_e);
        al.h(this.coU, i.e.bg_mycenter_toolbar);
        g(this.ckP.ahd().getUserData());
    }

    private void g(UserData userData) {
        if (userData != null && userData.getIsOfficialAccount() == 1) {
            this.relation_text.setText(i.h.user_info_center_head_viewpager_send_text_name);
            al.h(this.coV, i.e.btn_pop_news);
            al.h(this.coW, i.e.icon_pop_news);
            al.b(this.relation_text, i.c.cp_link_tip_c, 1);
            this.coO.setVisibility(8);
            this.coR.ahn();
        }
    }

    private void ahW() {
        this.bdE = (NavigationBar) this.ckP.findViewById(i.f.navigation_bar);
        if (!this.mIsHost) {
            this.bdE.setTitleText(this.coN);
        } else {
            this.bdE.setTitleText(i.h.person_info);
        }
        this.coP = this.bdE.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.ckP);
        this.coO = (ImageView) this.bdE.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_floor_more, this.ckP);
        if (!PersonInfoActivityConfig.IS_SUPPORT_EDIT) {
            this.coO.setVisibility(8);
        }
    }

    private void PJ() {
        this.coQ = (BdExpandListView) this.ckP.findViewById(i.f.personcenter_list);
        this.coS = new v(this.ckP, this.mIsHost);
        this.coQ.addHeaderView(this.coS.getRootView());
        this.coQ.c(this.coS.getRootView(), this.ckP.getResources().getDimensionPixelSize(i.d.ds372));
        this.coR = new s(this.ckP, this.mIsHost);
        this.coQ.setAdapter((ListAdapter) this.coR);
        this.coQ.setOnScrollListener(new ah(this));
    }

    public void onStart() {
        this.coS.ahC();
    }

    public void onDestroy() {
        this.coS.ahD();
    }

    public RelativeLayout ahq() {
        return this.coR.ahq();
    }

    public void startLoad() {
        this.coQ.nk();
    }

    public void hideProgress() {
        this.coS.hideProgress();
    }

    public void setExpandListRefreshListener(BdExpandListView.a aVar) {
        this.coQ.setExpandListRefreshListener(aVar);
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        this.ckP.getLayoutMode().ad(i == 1);
        this.ckP.getLayoutMode().k(this.bmB);
        if (this.coR != null) {
            this.coR.notifyDataSetChanged();
        }
        this.coS.oN();
        ahV();
        this.bdE.onChangeSkinType(getPageContext(), i);
        eX(this.mIsHost);
    }

    public UserIconBox ahH() {
        return this.coS.ahH();
    }

    public UserIconBox ahK() {
        return this.coS.ahK();
    }

    public v ahX() {
        return this.coS;
    }

    public TextView ahJ() {
        return this.coS.ahJ();
    }

    public LinearLayout ahY() {
        return this.coV;
    }

    public void ahZ() {
        ahU();
        this.bdE.setTitleText(this.ckP.ahd().getName());
        this.coS.ahA();
        this.coR.notifyDataSetChanged();
        eX(this.mIsHost);
    }

    public HeadImageView ahG() {
        return this.coS.ahG();
    }

    public RelativeLayout ahm() {
        return this.coR.ahm();
    }

    public void eX(boolean z) {
        if (z) {
            al.c(this.coO, i.e.icon_pop_edit);
        } else {
            al.c(this.coO, i.e.icon_more_n);
        }
        if (TbadkCoreApplication.isLogin() && PersonInfoActivityConfig.IS_SUPPORT_EDIT) {
            this.coO.setVisibility(0);
        } else {
            this.coO.setVisibility(8);
        }
    }

    public LinearLayout ahI() {
        return this.coS.ahI();
    }

    public TextView ahr() {
        return this.coR.ahr();
    }

    public RelativeLayout ahp() {
        return this.coR.ahp();
    }

    public RelativeLayout ahs() {
        return this.coR.ahs();
    }

    public RelativeLayout aht() {
        return this.coR.aht();
    }

    public RelativeLayout ahu() {
        return this.coR.ahu();
    }

    public RelativeLayout ahv() {
        return this.coR.ahv();
    }

    public RelativeLayout ahw() {
        return this.coR.ahw();
    }

    public RelativeLayout ahx() {
        return this.coR.ahx();
    }

    public RelativeLayout ahy() {
        return this.coR.ahy();
    }

    public void eU(boolean z) {
        if (this.mIsHost) {
            this.coR.eU(z);
        }
    }

    public RelativeLayout aho() {
        return this.coR.aho();
    }

    public void jc(int i) {
        if (this.mIsHost) {
            this.coR.jc(i);
        }
    }

    public void a(boolean z, boolean z2, int i) {
        this.coY = new bk(this.ckP);
        this.coX = new MorePopupWindow(this.ckP.getPageContext().getPageActivity(), this.coY.getView(), this.bdE, this.ckP.getResources().getDrawable(i.e.bg_pull_down_right_n), new ai(this));
        this.coX.onChangeSkinType(this.ckP, this.mSkinType, this.ckP.getResources().getDrawable(i.e.bg_pull_down_right_n));
        this.coY.j(z, z2);
        if (i != -1) {
            this.coY.iX(i);
        }
        this.coX.refresh();
        this.coX.showWindowInRightBottomOfHost();
    }

    public void aia() {
        com.baidu.adp.lib.g.j.a(this.coX, this.ckP.getPageContext().getPageActivity());
    }

    public ImageView aib() {
        return this.coO;
    }

    public View aic() {
        return this.coP;
    }

    public s aid() {
        return this.coR;
    }

    public View agK() {
        if (this.coY == null) {
            return null;
        }
        return this.coY.agK();
    }

    public View agJ() {
        if (this.coY == null) {
            return null;
        }
        return this.coY.agJ();
    }

    public View agL() {
        if (this.coY == null) {
            return null;
        }
        return this.coY.agL();
    }
}
