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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.data.MyGift;
import com.baidu.tbadk.game.GameInfoData;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    private int aiy = -1;
    private View bSE;
    private ImageView bSI;
    private ImageView bSN;
    private ImageView bSS;
    private RelativeLayout bST;
    private TextView bSU;
    private TextView bSV;
    private TextView bSW;
    private GridView bSX;
    private TextView bSY;
    private TextView bSZ;
    private PersonInfoActivity bSy;
    private View bTa;
    private RelativeLayout bTb;
    private TextView bTc;
    private ImageView bTd;
    private TextView bTe;
    private View bTf;
    private RelativeLayout bTg;
    private TextView bTh;
    private TextView bTi;
    private int bTj;
    private boolean mIsHost;
    private View mRootView;

    public r(PersonInfoActivity personInfoActivity, boolean z) {
        this.bSy = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.hH().inflate(this.bSy.getPageContext().getPageActivity(), com.baidu.tieba.w.personinfo_gift_view, null);
        initView();
    }

    private void initView() {
        this.bSE = this.mRootView.findViewById(com.baidu.tieba.v.root_next);
        this.bST = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.v.gift);
        this.bST.setOnClickListener(this.bSy);
        this.bSU = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.gift_num);
        this.bSV = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.new_gift_num);
        this.bSW = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.gift_num_text);
        this.bSX = (GridView) this.mRootView.findViewById(com.baidu.tieba.v.gift_grid);
        this.bSY = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.no_gift_text);
        this.bSI = (ImageView) this.mRootView.findViewById(com.baidu.tieba.v.arrow_top);
        this.bSZ = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.give_gift);
        this.bSZ.setOnClickListener(this.bSy);
        this.bTa = this.mRootView.findViewById(com.baidu.tieba.v.gift_fans);
        this.bTb = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.v.fans);
        this.bTc = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.fans_him);
        this.bTd = (ImageView) this.mRootView.findViewById(com.baidu.tieba.v.fans_icon);
        this.bTe = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.fans_num);
        this.bSN = (ImageView) this.mRootView.findViewById(com.baidu.tieba.v.arrow_middle);
        this.bTb.setOnClickListener(this.bSy);
        this.bTf = this.mRootView.findViewById(com.baidu.tieba.v.fans_attention);
        this.bTg = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.v.attention);
        this.bTh = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.attention_other);
        this.bTi = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.attention_num);
        this.bSS = (ImageView) this.mRootView.findViewById(com.baidu.tieba.v.arrow_bottom);
        this.bTg.setOnClickListener(this.bSy);
        if (TbadkCoreApplication.m411getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.bST.setVisibility(8);
        }
        oq();
    }

    public void ef(boolean z) {
        ba.i(this.bTd, com.baidu.tieba.u.icon_news_down_bar_one);
        if (z) {
            this.bTd.setVisibility(0);
        } else {
            this.bTd.setVisibility(8);
        }
    }

    public void hG(int i) {
        if (i <= 0) {
            this.bSV.setVisibility(8);
            return;
        }
        this.bSV.setVisibility(0);
        ba.b(this.bSV, com.baidu.tieba.s.top_msg_num_day, 1);
        if (i < 10) {
            this.bSV.setText(String.valueOf(i));
            this.bTj = com.baidu.tieba.u.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.bSV.setText(String.valueOf(i));
            this.bTj = com.baidu.tieba.u.icon_news_head_prompt_two;
        } else {
            this.bSV.setText("");
            this.bTj = com.baidu.tieba.u.icon_news_head_prompt_more;
        }
        ba.i((View) this.bSV, this.bTj);
    }

    public void aeg() {
        UserData userData = this.bSy.adN().getUserData();
        e(userData);
        f(userData);
        g(userData);
        oq();
    }

    private void e(UserData userData) {
        if (userData != null) {
            int giftNum = userData.getGiftNum();
            if (giftNum <= 0) {
                this.bSU.setText(GameInfoData.NOT_FROM_DETAIL);
                if (this.mIsHost || !TbadkCoreApplication.m411getInst().isGiftSwitchOn()) {
                    this.bSZ.setVisibility(8);
                } else {
                    this.bSZ.setVisibility(0);
                }
                this.bSI.setVisibility(8);
                this.bSX.setVisibility(8);
                this.bSY.setVisibility(0);
                if (this.mIsHost) {
                    this.bSY.setText(com.baidu.tieba.y.no_gift_tip_host);
                    return;
                } else {
                    this.bSY.setText(com.baidu.tieba.y.no_gift_tip);
                    return;
                }
            }
            String ch = bd.ch(giftNum);
            if (ch.contains("w") && ch.length() > 3) {
                this.bSU.setTextSize(0, this.bSy.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds48));
            }
            this.bSU.setText(ch);
            this.bSZ.setVisibility(8);
            this.bSI.setVisibility(0);
            this.bSX.setVisibility(0);
            this.bSY.setVisibility(8);
            List<MyGift> gift = userData.getGift();
            if (gift == null || gift.size() <= 0) {
                this.bSZ.setVisibility(8);
                this.bSI.setVisibility(0);
                this.bSX.setVisibility(0);
                this.bSY.setVisibility(8);
                return;
            }
            this.bSX.setAdapter((ListAdapter) new s(this, gift));
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v3 int)] */
    private void f(UserData userData) {
        if (userData != null) {
            if (userData.getSex() == 2) {
                this.bTc.setText(com.baidu.tieba.y.user_info_center_head_fans_name_text_g);
            } else {
                this.bTc.setText(com.baidu.tieba.y.user_info_center_head_fans_name_text_b);
            }
            if (this.mIsHost) {
                this.bTc.setText(com.baidu.tieba.y.user_info_center_head_fans_name_text);
            }
            int fansNum = userData.getFansNum();
            if (fansNum <= 0) {
                this.bTe.setText(GameInfoData.NOT_FROM_DETAIL);
                this.bSN.setVisibility(8);
                ba.b(this.bTe, com.baidu.tieba.s.cp_cont_e, 1);
                return;
            }
            this.bTe.setText(new StringBuilder().append(fansNum).toString());
            this.bSN.setVisibility(0);
            ba.b(this.bTe, com.baidu.tieba.s.cp_cont_b, 1);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v0 int)] */
    private void g(UserData userData) {
        if (userData != null) {
            int concern_num = userData.getConcern_num();
            if (concern_num <= 0) {
                this.bTi.setText(GameInfoData.NOT_FROM_DETAIL);
                this.bSS.setVisibility(8);
                ba.b(this.bTi, com.baidu.tieba.s.cp_cont_e, 1);
                return;
            }
            this.bTi.setText(new StringBuilder().append(concern_num).toString());
            this.bSS.setVisibility(0);
            ba.b(this.bTi, com.baidu.tieba.s.cp_cont_b, 1);
        }
    }

    public void oq() {
        if (this.aiy != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.aiy = TbadkCoreApplication.m411getInst().getSkinType();
            ba.j(this.bSE, com.baidu.tieba.s.cp_bg_line_d);
            ba.i(this.bST, com.baidu.tieba.u.personinfo_select_bg);
            ba.b(this.bSU, com.baidu.tieba.s.cp_cont_f, 1);
            ba.b(this.bSV, com.baidu.tieba.s.cp_cont_i, 1);
            ba.b(this.bSW, com.baidu.tieba.s.cp_cont_d, 1);
            ba.b(this.bSY, com.baidu.tieba.s.cp_cont_e, 1);
            ba.i(this.bSI, com.baidu.tieba.u.icon_dredge_arrow_r_n);
            ba.i((View) this.bSZ, com.baidu.tieba.u.btn_blue_bg);
            ba.b(this.bSZ, com.baidu.tieba.s.cp_cont_i, 1);
            ba.j(this.bTa, com.baidu.tieba.s.cp_bg_line_b);
            ba.i(this.bTb, com.baidu.tieba.u.personinfo_select_bg);
            ba.b(this.bTc, com.baidu.tieba.s.cp_cont_d, 1);
            ba.i(this.bSN, com.baidu.tieba.u.icon_dredge_arrow_r_n);
            ba.j(this.bTf, com.baidu.tieba.s.cp_bg_line_b);
            ba.i(this.bTg, com.baidu.tieba.u.personinfo_select_bg);
            ba.b(this.bTh, com.baidu.tieba.s.cp_cont_d, 1);
            ba.i(this.bSS, com.baidu.tieba.u.icon_dredge_arrow_r_n);
        }
    }

    public TextView adY() {
        return this.bSZ;
    }

    public RelativeLayout adU() {
        return this.bST;
    }

    public void adV() {
        if (this.bST != null) {
            this.bST.setVisibility(8);
        }
        if (this.bTa != null) {
            this.bTa.setVisibility(8);
        }
    }

    public RelativeLayout aea() {
        return this.bTb;
    }

    public RelativeLayout aeb() {
        return this.bTg;
    }

    public View getRootView() {
        return this.mRootView;
    }
}
