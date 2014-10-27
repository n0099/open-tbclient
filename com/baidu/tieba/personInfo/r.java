package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.data.MyGift;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    private View HS;
    private PersonInfoActivity bEE;
    private View bEK;
    private ImageView bEO;
    private ImageView bET;
    private ImageView bEY;
    private RelativeLayout bEZ;
    private TextView bFa;
    private TextView bFb;
    private TextView bFc;
    private GridView bFd;
    private TextView bFe;
    private TextView bFf;
    private View bFg;
    private RelativeLayout bFh;
    private TextView bFi;
    private ImageView bFj;
    private TextView bFk;
    private View bFl;
    private RelativeLayout bFm;
    private TextView bFn;
    private TextView bFo;
    private int bFp;
    private boolean mIsHost;

    public r(PersonInfoActivity personInfoActivity, boolean z) {
        this.bEE = personInfoActivity;
        this.mIsHost = z;
        this.HS = com.baidu.adp.lib.g.b.ek().inflate(this.bEE, com.baidu.tieba.w.personinfo_gift_view, null);
        nu();
    }

    private void nu() {
        this.bEK = this.HS.findViewById(com.baidu.tieba.v.root_next);
        this.bEZ = (RelativeLayout) this.HS.findViewById(com.baidu.tieba.v.gift);
        this.bEZ.setOnClickListener(this.bEE);
        this.bFa = (TextView) this.HS.findViewById(com.baidu.tieba.v.gift_num);
        this.bFb = (TextView) this.HS.findViewById(com.baidu.tieba.v.new_gift_num);
        this.bFc = (TextView) this.HS.findViewById(com.baidu.tieba.v.gift_num_text);
        this.bFd = (GridView) this.HS.findViewById(com.baidu.tieba.v.gift_grid);
        this.bFe = (TextView) this.HS.findViewById(com.baidu.tieba.v.no_gift_text);
        this.bEO = (ImageView) this.HS.findViewById(com.baidu.tieba.v.arrow_top);
        this.bFf = (TextView) this.HS.findViewById(com.baidu.tieba.v.give_gift);
        this.bFf.setOnClickListener(this.bEE);
        this.bFg = this.HS.findViewById(com.baidu.tieba.v.gift_fans);
        this.bFh = (RelativeLayout) this.HS.findViewById(com.baidu.tieba.v.fans);
        this.bFi = (TextView) this.HS.findViewById(com.baidu.tieba.v.fans_him);
        this.bFj = (ImageView) this.HS.findViewById(com.baidu.tieba.v.fans_icon);
        this.bFk = (TextView) this.HS.findViewById(com.baidu.tieba.v.fans_num);
        this.bET = (ImageView) this.HS.findViewById(com.baidu.tieba.v.arrow_middle);
        this.bFh.setOnClickListener(this.bEE);
        this.bFl = this.HS.findViewById(com.baidu.tieba.v.fans_attention);
        this.bFm = (RelativeLayout) this.HS.findViewById(com.baidu.tieba.v.attention);
        this.bFn = (TextView) this.HS.findViewById(com.baidu.tieba.v.attention_other);
        this.bFo = (TextView) this.HS.findViewById(com.baidu.tieba.v.attention_num);
        this.bEY = (ImageView) this.HS.findViewById(com.baidu.tieba.v.arrow_bottom);
        this.bFm.setOnClickListener(this.bEE);
        pS();
    }

    public void ey(boolean z) {
        aw.h(this.bFj, com.baidu.tieba.u.icon_news_down_bar_one);
        if (z) {
            this.bFj.setVisibility(0);
        } else {
            this.bFj.setVisibility(8);
        }
    }

    public void hc(int i) {
        if (i <= 0) {
            this.bFb.setVisibility(8);
            return;
        }
        this.bFb.setVisibility(0);
        aw.b(this.bFb, com.baidu.tieba.s.top_msg_num_day, 1);
        if (i < 10) {
            this.bFb.setText(String.valueOf(i));
            this.bFp = com.baidu.tieba.u.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.bFb.setText(String.valueOf(i));
            this.bFp = com.baidu.tieba.u.icon_news_head_prompt_two;
        } else {
            this.bFb.setText("");
            this.bFp = com.baidu.tieba.u.icon_news_head_prompt_more;
        }
        aw.h((View) this.bFb, this.bFp);
    }

    public void Hu() {
        UserData userData = this.bEE.aap().getUserData();
        c(userData);
        d(userData);
        e(userData);
    }

    private void c(UserData userData) {
        if (userData != null) {
            int giftNum = userData.getGiftNum();
            if (giftNum <= 0) {
                this.bFa.setText("0");
                if (this.mIsHost || !TbadkApplication.m251getInst().isGiftSwitchOn()) {
                    this.bFf.setVisibility(8);
                } else {
                    this.bFf.setVisibility(0);
                }
                this.bEO.setVisibility(8);
                this.bFd.setVisibility(8);
                this.bFe.setVisibility(0);
                if (this.mIsHost) {
                    this.bFe.setText(com.baidu.tieba.y.no_gift_tip_host);
                    return;
                } else {
                    this.bFe.setText(com.baidu.tieba.y.no_gift_tip);
                    return;
                }
            }
            String bB = ay.bB(giftNum);
            if (bB.contains("w") && bB.length() > 3) {
                this.bFa.setTextSize(0, this.bEE.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds48));
            }
            this.bFa.setText(bB);
            this.bFf.setVisibility(8);
            this.bEO.setVisibility(0);
            this.bFd.setVisibility(0);
            this.bFe.setVisibility(8);
            List<MyGift> gift = userData.getGift();
            if (gift == null || gift.size() <= 0) {
                this.bFf.setVisibility(8);
                this.bEO.setVisibility(0);
                this.bFd.setVisibility(0);
                this.bFe.setVisibility(8);
                return;
            }
            this.bFd.setAdapter((ListAdapter) new s(this, gift));
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v3 int)] */
    private void d(UserData userData) {
        if (userData != null) {
            if (userData.getSex() == 2) {
                this.bFi.setText(com.baidu.tieba.y.user_info_center_head_fans_name_text_g);
            } else {
                this.bFi.setText(com.baidu.tieba.y.user_info_center_head_fans_name_text_b);
            }
            if (this.mIsHost) {
                this.bFi.setText(com.baidu.tieba.y.user_info_center_head_fans_name_text);
            }
            int fansNum = userData.getFansNum();
            if (fansNum <= 0) {
                this.bFk.setText("0");
                this.bET.setVisibility(8);
                aw.b(this.bFk, com.baidu.tieba.s.cp_cont_e, 1);
                return;
            }
            this.bFk.setText(new StringBuilder().append(fansNum).toString());
            this.bET.setVisibility(0);
            aw.b(this.bFk, com.baidu.tieba.s.cp_cont_b, 1);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v0 int)] */
    private void e(UserData userData) {
        if (userData != null) {
            int concern_num = userData.getConcern_num();
            if (concern_num <= 0) {
                this.bFo.setText("0");
                this.bEY.setVisibility(8);
                aw.b(this.bFo, com.baidu.tieba.s.cp_cont_e, 1);
                return;
            }
            this.bFo.setText(new StringBuilder().append(concern_num).toString());
            this.bEY.setVisibility(0);
            aw.b(this.bFo, com.baidu.tieba.s.cp_cont_b, 1);
        }
    }

    public void pS() {
        aw.i(this.bEK, com.baidu.tieba.s.cp_bg_line_d);
        aw.h(this.bEZ, com.baidu.tieba.u.personinfo_select_bg);
        aw.b(this.bFa, com.baidu.tieba.s.cp_cont_f, 1);
        aw.b(this.bFb, com.baidu.tieba.s.cp_cont_i, 1);
        aw.b(this.bFc, com.baidu.tieba.s.cp_cont_d, 1);
        aw.b(this.bFe, com.baidu.tieba.s.cp_cont_e, 1);
        aw.h(this.bEO, com.baidu.tieba.u.icon_dredge_arrow_r_n);
        aw.h((View) this.bFf, com.baidu.tieba.u.btn_blue_bg);
        aw.b(this.bFf, com.baidu.tieba.s.cp_cont_i, 1);
        aw.i(this.bFg, com.baidu.tieba.s.cp_bg_line_b);
        aw.h(this.bFh, com.baidu.tieba.u.personinfo_select_bg);
        aw.b(this.bFi, com.baidu.tieba.s.cp_cont_d, 1);
        aw.h(this.bET, com.baidu.tieba.u.icon_dredge_arrow_r_n);
        aw.i(this.bFl, com.baidu.tieba.s.cp_bg_line_b);
        aw.h(this.bFm, com.baidu.tieba.u.personinfo_select_bg);
        aw.b(this.bFn, com.baidu.tieba.s.cp_cont_d, 1);
        aw.h(this.bEY, com.baidu.tieba.u.icon_dredge_arrow_r_n);
    }

    public TextView aaz() {
        return this.bFf;
    }

    public RelativeLayout aaw() {
        return this.bEZ;
    }

    public RelativeLayout aaB() {
        return this.bFh;
    }

    public RelativeLayout aaC() {
        return this.bFm;
    }

    public View getRootView() {
        return this.HS;
    }
}
