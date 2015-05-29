package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.data.MyGift;
import com.baidu.tbadk.game.GameInfoData;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    private int ajy = -1;
    private RelativeLayout bVA;
    private TextView bVB;
    private TextView bVC;
    private TextView bVD;
    private GridView bVE;
    private TextView bVF;
    private TextView bVG;
    private View bVH;
    private RelativeLayout bVI;
    private TextView bVJ;
    private ImageView bVK;
    private TextView bVL;
    private View bVM;
    private RelativeLayout bVN;
    private TextView bVO;
    private TextView bVP;
    private int bVQ;
    private PersonInfoActivity bVf;
    private View bVl;
    private ImageView bVp;
    private ImageView bVu;
    private ImageView bVz;
    private boolean mIsHost;
    private View mRootView;

    public r(PersonInfoActivity personInfoActivity, boolean z) {
        this.bVf = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.hr().inflate(this.bVf.getPageContext().getPageActivity(), com.baidu.tieba.r.personinfo_gift_view, null);
        initView();
    }

    private void initView() {
        this.bVl = this.mRootView.findViewById(com.baidu.tieba.q.root_next);
        this.bVA = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.q.gift);
        this.bVA.setOnClickListener(this.bVf);
        this.bVB = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.gift_num);
        this.bVC = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.new_gift_num);
        this.bVD = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.gift_num_text);
        this.bVE = (GridView) this.mRootView.findViewById(com.baidu.tieba.q.gift_grid);
        this.bVF = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.no_gift_text);
        this.bVp = (ImageView) this.mRootView.findViewById(com.baidu.tieba.q.arrow_top);
        this.bVG = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.give_gift);
        this.bVG.setOnClickListener(this.bVf);
        this.bVH = this.mRootView.findViewById(com.baidu.tieba.q.gift_fans);
        this.bVI = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.q.fans);
        this.bVJ = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.fans_him);
        this.bVK = (ImageView) this.mRootView.findViewById(com.baidu.tieba.q.fans_icon);
        this.bVL = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.fans_num);
        this.bVu = (ImageView) this.mRootView.findViewById(com.baidu.tieba.q.arrow_middle);
        this.bVI.setOnClickListener(this.bVf);
        this.bVM = this.mRootView.findViewById(com.baidu.tieba.q.fans_attention);
        this.bVN = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.q.attention);
        this.bVO = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.attention_other);
        this.bVP = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.attention_num);
        this.bVz = (ImageView) this.mRootView.findViewById(com.baidu.tieba.q.arrow_bottom);
        this.bVN.setOnClickListener(this.bVf);
        if (TbadkCoreApplication.m411getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.bVA.setVisibility(8);
        }
        oG();
    }

    public void er(boolean z) {
        ay.i(this.bVK, com.baidu.tieba.p.icon_news_down_bar_one);
        if (z) {
            this.bVK.setVisibility(0);
        } else {
            this.bVK.setVisibility(8);
        }
    }

    public void hV(int i) {
        if (i <= 0) {
            this.bVC.setVisibility(8);
            return;
        }
        this.bVC.setVisibility(0);
        ay.b(this.bVC, com.baidu.tieba.n.top_msg_num_day, 1);
        if (i < 10) {
            this.bVC.setText(String.valueOf(i));
            this.bVQ = com.baidu.tieba.p.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.bVC.setText(String.valueOf(i));
            this.bVQ = com.baidu.tieba.p.icon_news_head_prompt_two;
        } else {
            this.bVC.setText("");
            this.bVQ = com.baidu.tieba.p.icon_news_head_prompt_more;
        }
        ay.i((View) this.bVC, this.bVQ);
    }

    public void afl() {
        UserData userData = this.bVf.aeT().getUserData();
        e(userData);
        f(userData);
        g(userData);
        oG();
    }

    private void e(UserData userData) {
        if (userData != null) {
            int giftNum = userData.getGiftNum();
            if (giftNum <= 0) {
                this.bVB.setText(GameInfoData.NOT_FROM_DETAIL);
                if (this.mIsHost || !TbadkCoreApplication.m411getInst().isGiftSwitchOn()) {
                    this.bVG.setVisibility(8);
                } else {
                    this.bVG.setVisibility(0);
                }
                this.bVp.setVisibility(8);
                this.bVE.setVisibility(8);
                this.bVF.setVisibility(0);
                if (this.mIsHost) {
                    this.bVF.setText(com.baidu.tieba.t.no_gift_tip_host);
                    return;
                } else {
                    this.bVF.setText(com.baidu.tieba.t.no_gift_tip);
                    return;
                }
            }
            String cl = bb.cl(giftNum);
            if (cl.contains("w") && cl.length() > 3) {
                this.bVB.setTextSize(0, this.bVf.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds48));
            }
            this.bVB.setText(cl);
            this.bVG.setVisibility(8);
            this.bVp.setVisibility(0);
            this.bVE.setVisibility(0);
            this.bVF.setVisibility(8);
            List<MyGift> gift = userData.getGift();
            if (gift == null || gift.size() <= 0) {
                this.bVG.setVisibility(8);
                this.bVp.setVisibility(0);
                this.bVE.setVisibility(0);
                this.bVF.setVisibility(8);
                return;
            }
            this.bVE.setAdapter((ListAdapter) new s(this, gift));
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v3 int)] */
    private void f(UserData userData) {
        if (userData != null) {
            if (userData.getSex() == 2) {
                this.bVJ.setText(com.baidu.tieba.t.user_info_center_head_fans_name_text_g);
            } else {
                this.bVJ.setText(com.baidu.tieba.t.user_info_center_head_fans_name_text_b);
            }
            if (this.mIsHost) {
                this.bVJ.setText(com.baidu.tieba.t.user_info_center_head_fans_name_text);
            }
            int fansNum = userData.getFansNum();
            if (fansNum <= 0) {
                this.bVL.setText(GameInfoData.NOT_FROM_DETAIL);
                this.bVu.setVisibility(8);
                ay.b(this.bVL, com.baidu.tieba.n.cp_cont_e, 1);
                return;
            }
            this.bVL.setText(new StringBuilder().append(fansNum).toString());
            this.bVu.setVisibility(0);
            ay.b(this.bVL, com.baidu.tieba.n.cp_cont_b, 1);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v0 int)] */
    private void g(UserData userData) {
        if (userData != null) {
            int concern_num = userData.getConcern_num();
            if (concern_num <= 0) {
                this.bVP.setText(GameInfoData.NOT_FROM_DETAIL);
                this.bVz.setVisibility(8);
                ay.b(this.bVP, com.baidu.tieba.n.cp_cont_e, 1);
                return;
            }
            this.bVP.setText(new StringBuilder().append(concern_num).toString());
            this.bVz.setVisibility(0);
            ay.b(this.bVP, com.baidu.tieba.n.cp_cont_b, 1);
        }
    }

    public void oG() {
        if (this.ajy != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.ajy = TbadkCoreApplication.m411getInst().getSkinType();
            ay.j(this.bVl, com.baidu.tieba.n.cp_bg_line_d);
            ay.i(this.bVA, com.baidu.tieba.p.personinfo_select_bg);
            ay.b(this.bVB, com.baidu.tieba.n.cp_cont_f, 1);
            ay.b(this.bVC, com.baidu.tieba.n.cp_cont_i, 1);
            ay.b(this.bVD, com.baidu.tieba.n.cp_cont_d, 1);
            ay.b(this.bVF, com.baidu.tieba.n.cp_cont_e, 1);
            ay.i(this.bVp, com.baidu.tieba.p.icon_dredge_arrow_r_n);
            ay.i((View) this.bVG, com.baidu.tieba.p.btn_blue_bg);
            ay.b(this.bVG, com.baidu.tieba.n.cp_cont_i, 1);
            ay.j(this.bVH, com.baidu.tieba.n.cp_bg_line_b);
            ay.i(this.bVI, com.baidu.tieba.p.personinfo_select_bg);
            ay.b(this.bVJ, com.baidu.tieba.n.cp_cont_d, 1);
            ay.i(this.bVu, com.baidu.tieba.p.icon_dredge_arrow_r_n);
            ay.j(this.bVM, com.baidu.tieba.n.cp_bg_line_b);
            ay.i(this.bVN, com.baidu.tieba.p.personinfo_select_bg);
            ay.b(this.bVO, com.baidu.tieba.n.cp_cont_d, 1);
            ay.i(this.bVz, com.baidu.tieba.p.icon_dredge_arrow_r_n);
        }
    }

    public TextView afd() {
        return this.bVG;
    }

    public RelativeLayout aeZ() {
        return this.bVA;
    }

    public void afa() {
        if (this.bVA != null) {
            this.bVA.setVisibility(8);
        }
        if (this.bVH != null) {
            this.bVH.setVisibility(8);
        }
    }

    public RelativeLayout aff() {
        return this.bVI;
    }

    public RelativeLayout afg() {
        return this.bVN;
    }

    public View getRootView() {
        return this.mRootView;
    }
}
