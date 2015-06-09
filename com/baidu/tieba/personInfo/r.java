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
    private ImageView bVA;
    private RelativeLayout bVB;
    private TextView bVC;
    private TextView bVD;
    private TextView bVE;
    private GridView bVF;
    private TextView bVG;
    private TextView bVH;
    private View bVI;
    private RelativeLayout bVJ;
    private TextView bVK;
    private ImageView bVL;
    private TextView bVM;
    private View bVN;
    private RelativeLayout bVO;
    private TextView bVP;
    private TextView bVQ;
    private int bVR;
    private PersonInfoActivity bVg;
    private View bVm;
    private ImageView bVq;
    private ImageView bVv;
    private boolean mIsHost;
    private View mRootView;

    public r(PersonInfoActivity personInfoActivity, boolean z) {
        this.bVg = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.hr().inflate(this.bVg.getPageContext().getPageActivity(), com.baidu.tieba.r.personinfo_gift_view, null);
        initView();
    }

    private void initView() {
        this.bVm = this.mRootView.findViewById(com.baidu.tieba.q.root_next);
        this.bVB = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.q.gift);
        this.bVB.setOnClickListener(this.bVg);
        this.bVC = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.gift_num);
        this.bVD = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.new_gift_num);
        this.bVE = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.gift_num_text);
        this.bVF = (GridView) this.mRootView.findViewById(com.baidu.tieba.q.gift_grid);
        this.bVG = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.no_gift_text);
        this.bVq = (ImageView) this.mRootView.findViewById(com.baidu.tieba.q.arrow_top);
        this.bVH = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.give_gift);
        this.bVH.setOnClickListener(this.bVg);
        this.bVI = this.mRootView.findViewById(com.baidu.tieba.q.gift_fans);
        this.bVJ = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.q.fans);
        this.bVK = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.fans_him);
        this.bVL = (ImageView) this.mRootView.findViewById(com.baidu.tieba.q.fans_icon);
        this.bVM = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.fans_num);
        this.bVv = (ImageView) this.mRootView.findViewById(com.baidu.tieba.q.arrow_middle);
        this.bVJ.setOnClickListener(this.bVg);
        this.bVN = this.mRootView.findViewById(com.baidu.tieba.q.fans_attention);
        this.bVO = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.q.attention);
        this.bVP = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.attention_other);
        this.bVQ = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.attention_num);
        this.bVA = (ImageView) this.mRootView.findViewById(com.baidu.tieba.q.arrow_bottom);
        this.bVO.setOnClickListener(this.bVg);
        if (TbadkCoreApplication.m411getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.bVB.setVisibility(8);
        }
        oG();
    }

    public void er(boolean z) {
        ay.i(this.bVL, com.baidu.tieba.p.icon_news_down_bar_one);
        if (z) {
            this.bVL.setVisibility(0);
        } else {
            this.bVL.setVisibility(8);
        }
    }

    public void hV(int i) {
        if (i <= 0) {
            this.bVD.setVisibility(8);
            return;
        }
        this.bVD.setVisibility(0);
        ay.b(this.bVD, com.baidu.tieba.n.top_msg_num_day, 1);
        if (i < 10) {
            this.bVD.setText(String.valueOf(i));
            this.bVR = com.baidu.tieba.p.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.bVD.setText(String.valueOf(i));
            this.bVR = com.baidu.tieba.p.icon_news_head_prompt_two;
        } else {
            this.bVD.setText("");
            this.bVR = com.baidu.tieba.p.icon_news_head_prompt_more;
        }
        ay.i((View) this.bVD, this.bVR);
    }

    public void afm() {
        UserData userData = this.bVg.aeU().getUserData();
        e(userData);
        f(userData);
        g(userData);
        oG();
    }

    private void e(UserData userData) {
        if (userData != null) {
            int giftNum = userData.getGiftNum();
            if (giftNum <= 0) {
                this.bVC.setText(GameInfoData.NOT_FROM_DETAIL);
                if (this.mIsHost || !TbadkCoreApplication.m411getInst().isGiftSwitchOn()) {
                    this.bVH.setVisibility(8);
                } else {
                    this.bVH.setVisibility(0);
                }
                this.bVq.setVisibility(8);
                this.bVF.setVisibility(8);
                this.bVG.setVisibility(0);
                if (this.mIsHost) {
                    this.bVG.setText(com.baidu.tieba.t.no_gift_tip_host);
                    return;
                } else {
                    this.bVG.setText(com.baidu.tieba.t.no_gift_tip);
                    return;
                }
            }
            String cl = bb.cl(giftNum);
            if (cl.contains("w") && cl.length() > 3) {
                this.bVC.setTextSize(0, this.bVg.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds48));
            }
            this.bVC.setText(cl);
            this.bVH.setVisibility(8);
            this.bVq.setVisibility(0);
            this.bVF.setVisibility(0);
            this.bVG.setVisibility(8);
            List<MyGift> gift = userData.getGift();
            if (gift == null || gift.size() <= 0) {
                this.bVH.setVisibility(8);
                this.bVq.setVisibility(0);
                this.bVF.setVisibility(0);
                this.bVG.setVisibility(8);
                return;
            }
            this.bVF.setAdapter((ListAdapter) new s(this, gift));
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v3 int)] */
    private void f(UserData userData) {
        if (userData != null) {
            if (userData.getSex() == 2) {
                this.bVK.setText(com.baidu.tieba.t.user_info_center_head_fans_name_text_g);
            } else {
                this.bVK.setText(com.baidu.tieba.t.user_info_center_head_fans_name_text_b);
            }
            if (this.mIsHost) {
                this.bVK.setText(com.baidu.tieba.t.user_info_center_head_fans_name_text);
            }
            int fansNum = userData.getFansNum();
            if (fansNum <= 0) {
                this.bVM.setText(GameInfoData.NOT_FROM_DETAIL);
                this.bVv.setVisibility(8);
                ay.b(this.bVM, com.baidu.tieba.n.cp_cont_e, 1);
                return;
            }
            this.bVM.setText(new StringBuilder().append(fansNum).toString());
            this.bVv.setVisibility(0);
            ay.b(this.bVM, com.baidu.tieba.n.cp_cont_b, 1);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v0 int)] */
    private void g(UserData userData) {
        if (userData != null) {
            int concern_num = userData.getConcern_num();
            if (concern_num <= 0) {
                this.bVQ.setText(GameInfoData.NOT_FROM_DETAIL);
                this.bVA.setVisibility(8);
                ay.b(this.bVQ, com.baidu.tieba.n.cp_cont_e, 1);
                return;
            }
            this.bVQ.setText(new StringBuilder().append(concern_num).toString());
            this.bVA.setVisibility(0);
            ay.b(this.bVQ, com.baidu.tieba.n.cp_cont_b, 1);
        }
    }

    public void oG() {
        if (this.ajy != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.ajy = TbadkCoreApplication.m411getInst().getSkinType();
            ay.j(this.bVm, com.baidu.tieba.n.cp_bg_line_d);
            ay.i(this.bVB, com.baidu.tieba.p.personinfo_select_bg);
            ay.b(this.bVC, com.baidu.tieba.n.cp_cont_f, 1);
            ay.b(this.bVD, com.baidu.tieba.n.cp_cont_i, 1);
            ay.b(this.bVE, com.baidu.tieba.n.cp_cont_d, 1);
            ay.b(this.bVG, com.baidu.tieba.n.cp_cont_e, 1);
            ay.i(this.bVq, com.baidu.tieba.p.icon_dredge_arrow_r_n);
            ay.i((View) this.bVH, com.baidu.tieba.p.btn_blue_bg);
            ay.b(this.bVH, com.baidu.tieba.n.cp_cont_i, 1);
            ay.j(this.bVI, com.baidu.tieba.n.cp_bg_line_b);
            ay.i(this.bVJ, com.baidu.tieba.p.personinfo_select_bg);
            ay.b(this.bVK, com.baidu.tieba.n.cp_cont_d, 1);
            ay.i(this.bVv, com.baidu.tieba.p.icon_dredge_arrow_r_n);
            ay.j(this.bVN, com.baidu.tieba.n.cp_bg_line_b);
            ay.i(this.bVO, com.baidu.tieba.p.personinfo_select_bg);
            ay.b(this.bVP, com.baidu.tieba.n.cp_cont_d, 1);
            ay.i(this.bVA, com.baidu.tieba.p.icon_dredge_arrow_r_n);
        }
    }

    public TextView afe() {
        return this.bVH;
    }

    public RelativeLayout afa() {
        return this.bVB;
    }

    public void afb() {
        if (this.bVB != null) {
            this.bVB.setVisibility(8);
        }
        if (this.bVI != null) {
            this.bVI.setVisibility(8);
        }
    }

    public RelativeLayout afg() {
        return this.bVJ;
    }

    public RelativeLayout afh() {
        return this.bVO;
    }

    public View getRootView() {
        return this.mRootView;
    }
}
