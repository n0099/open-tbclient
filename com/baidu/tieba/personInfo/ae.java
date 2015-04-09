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
    private NavigationBar aPB;
    private View aVC;
    private PersonInfoActivity bSy;
    private String bUl;
    private ImageView bUm;
    private View bUn;
    private BdExpandListView bUo;
    private p bUp;
    private u bUq;
    private LinearLayout bUr;
    private LinearLayout bUs;
    private LinearLayout bUt;
    private ImageView bUu;
    private TextView bUv;
    private MorePopupWindow bUw;
    private ba bUx;
    private View line;
    private boolean mIsHost;
    private int mSkinType;

    public ae(PersonInfoActivity personInfoActivity, boolean z) {
        super(personInfoActivity.getPageContext());
        this.bSy = personInfoActivity;
        this.mIsHost = z;
        this.bUl = personInfoActivity.adN().getName();
        personInfoActivity.setContentView(com.baidu.tieba.w.person_info_view);
        this.aVC = personInfoActivity.findViewById(com.baidu.tieba.v.root);
        aeB();
        initListView();
        Np();
    }

    private void Np() {
        this.bUr = (LinearLayout) this.bSy.findViewById(com.baidu.tieba.v.relation_root);
        this.bUs = (LinearLayout) this.bSy.findViewById(com.baidu.tieba.v.relation_ll);
        this.line = this.bSy.findViewById(com.baidu.tieba.v.line);
        this.bUt = (LinearLayout) this.bSy.findViewById(com.baidu.tieba.v.relation_bg);
        this.bUt.setOnClickListener(this.bSy);
        this.bUu = (ImageView) this.bSy.findViewById(com.baidu.tieba.v.relation_icon);
        this.bUv = (TextView) this.bSy.findViewById(com.baidu.tieba.v.relation_text);
    }

    private void aeA() {
        if (this.mIsHost) {
            AntiData Zp = this.bSy.adN().Zp();
            if (Zp != null) {
                if (AntiHelper.c(Zp) || AntiHelper.e(Zp)) {
                    this.bUr.setVisibility(0);
                    this.bUu.setVisibility(8);
                    this.bUv.setText(com.baidu.tieba.y.account_exception);
                    com.baidu.tbadk.core.util.ba.i(this.bUt, com.baidu.tieba.u.btn_pop_news);
                    com.baidu.tbadk.core.util.ba.b(this.bUv, com.baidu.tieba.s.cp_link_tip_c, 1);
                }
            } else {
                return;
            }
        } else {
            PersonTainInfo aes = this.bSy.adN().aes();
            int isFriend = aes != null ? aes.getIsFriend() : 1;
            this.bUr.setVisibility(0);
            if (isFriend == 0) {
                this.bUv.setText(com.baidu.tieba.y.addfriend);
                com.baidu.tbadk.core.util.ba.i(this.bUt, com.baidu.tieba.u.btn_blue_bg);
                com.baidu.tbadk.core.util.ba.i(this.bUu, com.baidu.tieba.u.icon_person_add);
                com.baidu.tbadk.core.util.ba.b(this.bUv, com.baidu.tieba.s.cp_cont_i, 1);
            } else if (isFriend == 1) {
                this.bUv.setText(com.baidu.tieba.y.user_info_center_head_viewpager_send_text_name);
                com.baidu.tbadk.core.util.ba.i(this.bUt, com.baidu.tieba.u.btn_pop_news);
                com.baidu.tbadk.core.util.ba.i(this.bUu, com.baidu.tieba.u.icon_pop_news);
                com.baidu.tbadk.core.util.ba.b(this.bUv, com.baidu.tieba.s.cp_link_tip_c, 1);
            } else if (isFriend == 2) {
                this.bUv.setText(com.baidu.tieba.y.acceptfriendapply);
                com.baidu.tbadk.core.util.ba.i(this.bUt, com.baidu.tieba.u.btn_blue_bg);
                com.baidu.tbadk.core.util.ba.i(this.bUu, com.baidu.tieba.u.icon_pop_pass);
                com.baidu.tbadk.core.util.ba.b(this.bUv, com.baidu.tieba.s.cp_cont_i, 1);
            } else {
                this.bUr.setVisibility(8);
            }
        }
        com.baidu.tbadk.core.util.ba.j(this.line, com.baidu.tieba.s.cp_bg_line_e);
        com.baidu.tbadk.core.util.ba.i(this.bUs, com.baidu.tieba.u.bg_mycenter_toolbar);
        j(this.bSy.adN().getUserData());
    }

    private void j(UserData userData) {
        if (userData.getIsOfficialAccount() == 1) {
            this.bUv.setText(com.baidu.tieba.y.user_info_center_head_viewpager_send_text_name);
            com.baidu.tbadk.core.util.ba.i(this.bUt, com.baidu.tieba.u.btn_pop_news);
            com.baidu.tbadk.core.util.ba.i(this.bUu, com.baidu.tieba.u.icon_pop_news);
            com.baidu.tbadk.core.util.ba.b(this.bUv, com.baidu.tieba.s.cp_link_tip_c, 1);
            this.bUm.setVisibility(8);
            this.bUp.adV();
        }
    }

    private void aeB() {
        this.aPB = (NavigationBar) this.bSy.findViewById(com.baidu.tieba.v.navigation_bar);
        if (!this.mIsHost) {
            this.aPB.setTitleText(this.bUl);
        } else {
            this.aPB.setTitleText(com.baidu.tieba.y.person_info);
        }
        this.bUn = this.aPB.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.bSy);
        this.bUm = (ImageView) this.aPB.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.nb_item_floor_more, this.bSy);
    }

    private void initListView() {
        this.bUo = (BdExpandListView) this.bSy.findViewById(com.baidu.tieba.v.personcenter_list);
        this.bUq = new u(this.bSy, this.mIsHost);
        this.bUo.addHeaderView(this.bUq.getRootView());
        this.bUo.c(this.bUq.getRootView(), this.bSy.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds372));
        this.bUp = new p(this.bSy, this.mIsHost);
        this.bUo.setAdapter((ListAdapter) this.bUp);
        this.bUo.setOnScrollListener(new af(this));
    }

    public void onStart() {
        this.bUq.aeh();
    }

    public void onStop() {
        this.bUq.aei();
    }

    public void startLoad() {
        this.bUo.mK();
    }

    public void hideProgress() {
        this.bUq.hideProgress();
    }

    public void setExpandListRefreshListener(com.baidu.adp.widget.ListView.c cVar) {
        this.bUo.setExpandListRefreshListener(cVar);
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        this.bSy.getLayoutMode().X(i == 1);
        this.bSy.getLayoutMode().h(this.aVC);
        if (this.bUp != null) {
            this.bUp.notifyDataSetChanged();
        }
        this.bUq.oq();
        this.aPB.onChangeSkinType(getPageContext(), i);
        ei(this.mIsHost);
    }

    public UserIconBox aem() {
        return this.bUq.aem();
    }

    public UserIconBox aep() {
        return this.bUq.aep();
    }

    public u aeC() {
        return this.bUq;
    }

    public TextView aeo() {
        return this.bUq.aeo();
    }

    public LinearLayout aeD() {
        return this.bUt;
    }

    public void aeE() {
        aeA();
        this.aPB.setTitleText(this.bSy.adN().getName());
        this.bUq.aeg();
        this.bUp.notifyDataSetChanged();
    }

    public HeadImageView ael() {
        return this.bUq.ael();
    }

    public RelativeLayout adU() {
        return this.bUp.adU();
    }

    public void ei(boolean z) {
        if (z) {
            com.baidu.tbadk.core.util.ba.c(this.bUm, com.baidu.tieba.u.icon_pop_edit);
        } else {
            com.baidu.tbadk.core.util.ba.c(this.bUm, com.baidu.tieba.u.icon_more_n);
        }
    }

    public LinearLayout aen() {
        return this.bUq.aen();
    }

    public TextView adY() {
        return this.bUp.adY();
    }

    public RelativeLayout adX() {
        return this.bUp.adX();
    }

    public RelativeLayout adZ() {
        return this.bUp.adZ();
    }

    public RelativeLayout aea() {
        return this.bUp.aea();
    }

    public RelativeLayout aeb() {
        return this.bUp.aeb();
    }

    public RelativeLayout aec() {
        return this.bUp.aec();
    }

    public RelativeLayout aed() {
        return this.bUp.aed();
    }

    public RelativeLayout aee() {
        return this.bUp.aee();
    }

    public void ef(boolean z) {
        if (this.mIsHost) {
            this.bUp.ef(z);
        }
    }

    public RelativeLayout adW() {
        return this.bUp.adW();
    }

    public void hG(int i) {
        if (this.mIsHost) {
            this.bUp.hG(i);
        }
    }

    public void f(boolean z, boolean z2) {
        this.bUx = new ba(this.bSy);
        this.bUw = new MorePopupWindow(this.bSy.getPageContext().getPageActivity(), this.bUx.getView(), this.aPB, this.bSy.getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_right_n), new ag(this));
        this.bUw.onChangeSkinType(this.bSy, this.mSkinType, this.bSy.getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_right_n));
        this.bUx.e(z, z2);
        this.bUw.refresh();
        this.bUw.showWindowInRightBottomOfHost();
    }

    public void aeF() {
        com.baidu.adp.lib.g.k.a(this.bUw, this.bSy.getPageContext().getPageActivity());
    }

    public ImageView aeG() {
        return this.bUm;
    }

    public View aeH() {
        return this.bUn;
    }

    public View adu() {
        return this.bUx.adu();
    }

    public View adt() {
        return this.bUx.adt();
    }
}
