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
    private int aiq = -1;
    private ImageView bSC;
    private RelativeLayout bSD;
    private TextView bSE;
    private TextView bSF;
    private TextView bSG;
    private GridView bSH;
    private TextView bSI;
    private TextView bSJ;
    private View bSK;
    private RelativeLayout bSL;
    private TextView bSM;
    private ImageView bSN;
    private TextView bSO;
    private View bSP;
    private RelativeLayout bSQ;
    private TextView bSR;
    private TextView bSS;
    private int bST;
    private PersonInfoActivity bSi;
    private View bSo;
    private ImageView bSs;
    private ImageView bSx;
    private boolean mIsHost;
    private View mRootView;

    public r(PersonInfoActivity personInfoActivity, boolean z) {
        this.bSi = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.hH().inflate(this.bSi.getPageContext().getPageActivity(), com.baidu.tieba.w.personinfo_gift_view, null);
        initView();
    }

    private void initView() {
        this.bSo = this.mRootView.findViewById(com.baidu.tieba.v.root_next);
        this.bSD = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.v.gift);
        this.bSD.setOnClickListener(this.bSi);
        this.bSE = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.gift_num);
        this.bSF = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.new_gift_num);
        this.bSG = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.gift_num_text);
        this.bSH = (GridView) this.mRootView.findViewById(com.baidu.tieba.v.gift_grid);
        this.bSI = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.no_gift_text);
        this.bSs = (ImageView) this.mRootView.findViewById(com.baidu.tieba.v.arrow_top);
        this.bSJ = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.give_gift);
        this.bSJ.setOnClickListener(this.bSi);
        this.bSK = this.mRootView.findViewById(com.baidu.tieba.v.gift_fans);
        this.bSL = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.v.fans);
        this.bSM = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.fans_him);
        this.bSN = (ImageView) this.mRootView.findViewById(com.baidu.tieba.v.fans_icon);
        this.bSO = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.fans_num);
        this.bSx = (ImageView) this.mRootView.findViewById(com.baidu.tieba.v.arrow_middle);
        this.bSL.setOnClickListener(this.bSi);
        this.bSP = this.mRootView.findViewById(com.baidu.tieba.v.fans_attention);
        this.bSQ = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.v.attention);
        this.bSR = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.attention_other);
        this.bSS = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.attention_num);
        this.bSC = (ImageView) this.mRootView.findViewById(com.baidu.tieba.v.arrow_bottom);
        this.bSQ.setOnClickListener(this.bSi);
        if (TbadkCoreApplication.m411getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.bSD.setVisibility(8);
        }
        oq();
    }

    public void eh(boolean z) {
        ba.i(this.bSN, com.baidu.tieba.u.icon_news_down_bar_one);
        if (z) {
            this.bSN.setVisibility(0);
        } else {
            this.bSN.setVisibility(8);
        }
    }

    public void hD(int i) {
        if (i <= 0) {
            this.bSF.setVisibility(8);
            return;
        }
        this.bSF.setVisibility(0);
        ba.b(this.bSF, com.baidu.tieba.s.top_msg_num_day, 1);
        if (i < 10) {
            this.bSF.setText(String.valueOf(i));
            this.bST = com.baidu.tieba.u.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.bSF.setText(String.valueOf(i));
            this.bST = com.baidu.tieba.u.icon_news_head_prompt_two;
        } else {
            this.bSF.setText("");
            this.bST = com.baidu.tieba.u.icon_news_head_prompt_more;
        }
        ba.i((View) this.bSF, this.bST);
    }

    public void adR() {
        UserData userData = this.bSi.ady().getUserData();
        e(userData);
        f(userData);
        g(userData);
        oq();
    }

    private void e(UserData userData) {
        if (userData != null) {
            int giftNum = userData.getGiftNum();
            if (giftNum <= 0) {
                this.bSE.setText(GameInfoData.NOT_FROM_DETAIL);
                if (this.mIsHost || !TbadkCoreApplication.m411getInst().isGiftSwitchOn()) {
                    this.bSJ.setVisibility(8);
                } else {
                    this.bSJ.setVisibility(0);
                }
                this.bSs.setVisibility(8);
                this.bSH.setVisibility(8);
                this.bSI.setVisibility(0);
                if (this.mIsHost) {
                    this.bSI.setText(com.baidu.tieba.y.no_gift_tip_host);
                    return;
                } else {
                    this.bSI.setText(com.baidu.tieba.y.no_gift_tip);
                    return;
                }
            }
            String ch = bd.ch(giftNum);
            if (ch.contains("w") && ch.length() > 3) {
                this.bSE.setTextSize(0, this.bSi.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds48));
            }
            this.bSE.setText(ch);
            this.bSJ.setVisibility(8);
            this.bSs.setVisibility(0);
            this.bSH.setVisibility(0);
            this.bSI.setVisibility(8);
            List<MyGift> gift = userData.getGift();
            if (gift == null || gift.size() <= 0) {
                this.bSJ.setVisibility(8);
                this.bSs.setVisibility(0);
                this.bSH.setVisibility(0);
                this.bSI.setVisibility(8);
                return;
            }
            this.bSH.setAdapter((ListAdapter) new s(this, gift));
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v3 int)] */
    private void f(UserData userData) {
        if (userData != null) {
            if (userData.getSex() == 2) {
                this.bSM.setText(com.baidu.tieba.y.user_info_center_head_fans_name_text_g);
            } else {
                this.bSM.setText(com.baidu.tieba.y.user_info_center_head_fans_name_text_b);
            }
            if (this.mIsHost) {
                this.bSM.setText(com.baidu.tieba.y.user_info_center_head_fans_name_text);
            }
            int fansNum = userData.getFansNum();
            if (fansNum <= 0) {
                this.bSO.setText(GameInfoData.NOT_FROM_DETAIL);
                this.bSx.setVisibility(8);
                ba.b(this.bSO, com.baidu.tieba.s.cp_cont_e, 1);
                return;
            }
            this.bSO.setText(new StringBuilder().append(fansNum).toString());
            this.bSx.setVisibility(0);
            ba.b(this.bSO, com.baidu.tieba.s.cp_cont_b, 1);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v0 int)] */
    private void g(UserData userData) {
        if (userData != null) {
            int concern_num = userData.getConcern_num();
            if (concern_num <= 0) {
                this.bSS.setText(GameInfoData.NOT_FROM_DETAIL);
                this.bSC.setVisibility(8);
                ba.b(this.bSS, com.baidu.tieba.s.cp_cont_e, 1);
                return;
            }
            this.bSS.setText(new StringBuilder().append(concern_num).toString());
            this.bSC.setVisibility(0);
            ba.b(this.bSS, com.baidu.tieba.s.cp_cont_b, 1);
        }
    }

    public void oq() {
        if (this.aiq != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.aiq = TbadkCoreApplication.m411getInst().getSkinType();
            ba.j(this.bSo, com.baidu.tieba.s.cp_bg_line_d);
            ba.i(this.bSD, com.baidu.tieba.u.personinfo_select_bg);
            ba.b(this.bSE, com.baidu.tieba.s.cp_cont_f, 1);
            ba.b(this.bSF, com.baidu.tieba.s.cp_cont_i, 1);
            ba.b(this.bSG, com.baidu.tieba.s.cp_cont_d, 1);
            ba.b(this.bSI, com.baidu.tieba.s.cp_cont_e, 1);
            ba.i(this.bSs, com.baidu.tieba.u.icon_dredge_arrow_r_n);
            ba.i((View) this.bSJ, com.baidu.tieba.u.btn_blue_bg);
            ba.b(this.bSJ, com.baidu.tieba.s.cp_cont_i, 1);
            ba.j(this.bSK, com.baidu.tieba.s.cp_bg_line_b);
            ba.i(this.bSL, com.baidu.tieba.u.personinfo_select_bg);
            ba.b(this.bSM, com.baidu.tieba.s.cp_cont_d, 1);
            ba.i(this.bSx, com.baidu.tieba.u.icon_dredge_arrow_r_n);
            ba.j(this.bSP, com.baidu.tieba.s.cp_bg_line_b);
            ba.i(this.bSQ, com.baidu.tieba.u.personinfo_select_bg);
            ba.b(this.bSR, com.baidu.tieba.s.cp_cont_d, 1);
            ba.i(this.bSC, com.baidu.tieba.u.icon_dredge_arrow_r_n);
        }
    }

    public TextView adJ() {
        return this.bSJ;
    }

    public RelativeLayout adF() {
        return this.bSD;
    }

    public void adG() {
        if (this.bSD != null) {
            this.bSD.setVisibility(8);
        }
        if (this.bSK != null) {
            this.bSK.setVisibility(8);
        }
    }

    public RelativeLayout adL() {
        return this.bSL;
    }

    public RelativeLayout adM() {
        return this.bSQ;
    }

    public View getRootView() {
        return this.mRootView;
    }
}
