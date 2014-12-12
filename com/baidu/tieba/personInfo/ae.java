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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.person.bd;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.base.g<PersonInfoActivity> {
    private NavigationBar aId;
    private View aNd;
    private View aoP;
    private PersonInfoActivity bIn;
    private String bKb;
    private ImageView bKc;
    private BdExpandListView bKd;
    private p bKe;
    private u bKf;
    private LinearLayout bKg;
    private LinearLayout bKh;
    private LinearLayout bKi;
    private ImageView bKj;
    private TextView bKk;
    private MorePopupWindow bKl;
    private bd bKm;
    private View line;
    private boolean mIsHost;
    private int mSkinType;

    public ae(PersonInfoActivity personInfoActivity, boolean z) {
        super(personInfoActivity.getPageContext());
        this.bIn = personInfoActivity;
        this.mIsHost = z;
        this.bKb = personInfoActivity.aaL().getName();
        personInfoActivity.setContentView(com.baidu.tieba.x.person_info_view);
        this.aNd = personInfoActivity.findViewById(com.baidu.tieba.w.root);
        abA();
        initListView();
        Wh();
    }

    private void Wh() {
        this.bKg = (LinearLayout) this.bIn.findViewById(com.baidu.tieba.w.relation_root);
        this.bKh = (LinearLayout) this.bIn.findViewById(com.baidu.tieba.w.relation_ll);
        this.line = this.bIn.findViewById(com.baidu.tieba.w.line);
        this.bKi = (LinearLayout) this.bIn.findViewById(com.baidu.tieba.w.relation_bg);
        this.bKi.setOnClickListener(this.bIn);
        this.bKj = (ImageView) this.bIn.findViewById(com.baidu.tieba.w.relation_icon);
        this.bKk = (TextView) this.bIn.findViewById(com.baidu.tieba.w.relation_text);
    }

    private void abz() {
        if (this.mIsHost) {
            AntiData abp = this.bIn.aaL().abp();
            if (abp != null) {
                if (AntiHelper.c(abp) || AntiHelper.e(abp)) {
                    this.bKg.setVisibility(0);
                    this.bKj.setVisibility(8);
                    this.bKk.setText(com.baidu.tieba.z.account_exception);
                    ax.i(this.bKi, com.baidu.tieba.v.btn_pop_news);
                    ax.b(this.bKk, com.baidu.tieba.t.cp_link_tip_c, 1);
                }
            } else {
                return;
            }
        } else {
            PersonTainInfo abr = this.bIn.aaL().abr();
            int isFriend = abr != null ? abr.getIsFriend() : 1;
            this.bKg.setVisibility(0);
            if (isFriend == 0) {
                this.bKk.setText(com.baidu.tieba.z.addfriend);
                ax.i(this.bKi, com.baidu.tieba.v.btn_blue_bg);
                ax.i(this.bKj, com.baidu.tieba.v.icon_person_add);
                ax.b(this.bKk, com.baidu.tieba.t.cp_cont_i, 1);
            } else if (isFriend == 1) {
                this.bKk.setText(com.baidu.tieba.z.user_info_center_head_viewpager_send_text_name);
                ax.i(this.bKi, com.baidu.tieba.v.btn_pop_news);
                ax.i(this.bKj, com.baidu.tieba.v.icon_pop_news);
                ax.b(this.bKk, com.baidu.tieba.t.cp_link_tip_c, 1);
            } else if (isFriend == 2) {
                this.bKk.setText(com.baidu.tieba.z.acceptfriendapply);
                ax.i(this.bKi, com.baidu.tieba.v.btn_blue_bg);
                ax.i(this.bKj, com.baidu.tieba.v.icon_pop_pass);
                ax.b(this.bKk, com.baidu.tieba.t.cp_cont_i, 1);
            } else {
                this.bKg.setVisibility(8);
            }
        }
        ax.j(this.line, com.baidu.tieba.t.cp_bg_line_e);
        ax.i(this.bKh, com.baidu.tieba.v.bg_mycenter_toolbar);
        k(this.bIn.aaL().getUserData());
    }

    private void k(UserData userData) {
        if (userData.getIsOfficialAccount() == 1) {
            this.bKk.setText(com.baidu.tieba.z.user_info_center_head_viewpager_send_text_name);
            ax.i(this.bKi, com.baidu.tieba.v.btn_pop_news);
            ax.i(this.bKj, com.baidu.tieba.v.icon_pop_news);
            ax.b(this.bKk, com.baidu.tieba.t.cp_link_tip_c, 1);
            this.bKc.setVisibility(8);
            this.bKe.aaT();
        }
    }

    private void abA() {
        this.aId = (NavigationBar) this.bIn.findViewById(com.baidu.tieba.w.navigation_bar);
        if (!this.mIsHost) {
            this.aId.setTitleText(this.bKb);
        } else {
            this.aId.setTitleText(com.baidu.tieba.z.person_info);
        }
        this.aoP = this.aId.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.bIn);
        this.bKc = (ImageView) this.aId.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.nb_item_floor_more, this.bIn);
    }

    private void initListView() {
        this.bKd = (BdExpandListView) this.bIn.findViewById(com.baidu.tieba.w.personcenter_list);
        this.bKf = new u(this.bIn, this.mIsHost);
        this.bKd.addHeaderView(this.bKf.getRootView());
        this.bKd.c(this.bKf.getRootView(), this.bIn.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds372));
        this.bKe = new p(this.bIn, this.mIsHost);
        this.bKd.setAdapter((ListAdapter) this.bKe);
        this.bKd.setOnScrollListener(new af(this));
    }

    public void onStart() {
        this.bKf.abf();
    }

    public void onStop() {
        this.bKf.abg();
    }

    public void startLoad() {
        this.bKd.ju();
    }

    public void hideProgress() {
        this.bKf.hideProgress();
    }

    public void setExpandListRefreshListener(com.baidu.adp.widget.ListView.c cVar) {
        this.bKd.setExpandListRefreshListener(cVar);
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        this.bIn.getLayoutMode().ab(i == 1);
        this.bIn.getLayoutMode().h(this.aNd);
        this.bKf.kE();
        this.aId.onChangeSkinType(getPageContext(), i);
        eh(this.mIsHost);
    }

    public UserIconBox abk() {
        return this.bKf.abk();
    }

    public UserIconBox abn() {
        return this.bKf.abn();
    }

    public u abB() {
        return this.bKf;
    }

    public TextView abm() {
        return this.bKf.abm();
    }

    public LinearLayout abC() {
        return this.bKi;
    }

    public void abD() {
        abz();
        this.bKf.abe();
        this.bKe.notifyDataSetChanged();
    }

    public HeadImageView abj() {
        return this.bKf.abj();
    }

    public RelativeLayout aaS() {
        return this.bKe.aaS();
    }

    public void eh(boolean z) {
        if (z) {
            ax.c(this.bKc, com.baidu.tieba.v.icon_pop_edit);
        } else {
            ax.c(this.bKc, com.baidu.tieba.v.icon_more_n);
        }
    }

    public LinearLayout abl() {
        return this.bKf.abl();
    }

    public TextView aaW() {
        return this.bKe.aaW();
    }

    public RelativeLayout aaV() {
        return this.bKe.aaV();
    }

    public RelativeLayout aaX() {
        return this.bKe.aaX();
    }

    public RelativeLayout aaY() {
        return this.bKe.aaY();
    }

    public RelativeLayout aaZ() {
        return this.bKe.aaZ();
    }

    public RelativeLayout aba() {
        return this.bKe.aba();
    }

    public RelativeLayout abb() {
        return this.bKe.abb();
    }

    public RelativeLayout abc() {
        return this.bKe.abc();
    }

    public void ee(boolean z) {
        if (this.mIsHost) {
            this.bKe.ee(z);
        }
    }

    public RelativeLayout aaU() {
        return this.bKe.aaU();
    }

    public void hl(int i) {
        if (this.mIsHost) {
            this.bKe.hl(i);
        }
    }

    public void i(boolean z, boolean z2) {
        this.bKm = new bd(this.bIn);
        this.bKl = new MorePopupWindow(this.bIn.getPageContext().getPageActivity(), this.bKm.getView(), this.aId, this.bIn.getResources().getDrawable(com.baidu.tieba.v.bg_pull_down_right_n), new ag(this));
        this.bKl.onChangeSkinType(this.bIn, this.mSkinType, this.bIn.getResources().getDrawable(com.baidu.tieba.v.bg_pull_down_right_n));
        this.bKm.h(z, z2);
        this.bKl.refresh();
        this.bKl.showWindowInRightBottomOfHost();
    }

    public void abE() {
        com.baidu.adp.lib.g.k.a(this.bKl, this.bIn.getPageContext().getPageActivity());
    }

    public ImageView abF() {
        return this.bKc;
    }

    public View Bj() {
        return this.aoP;
    }

    public View aaw() {
        return this.bKm.aaw();
    }

    public View aav() {
        return this.bKm.aav();
    }
}
