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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.data.MyGift;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    private View HT;
    private PersonInfoActivity bES;
    private View bEY;
    private RelativeLayout bFA;
    private TextView bFB;
    private TextView bFC;
    private int bFD;
    private ImageView bFc;
    private ImageView bFh;
    private ImageView bFm;
    private RelativeLayout bFn;
    private TextView bFo;
    private TextView bFp;
    private TextView bFq;
    private GridView bFr;
    private TextView bFs;
    private TextView bFt;
    private View bFu;
    private RelativeLayout bFv;
    private TextView bFw;
    private ImageView bFx;
    private TextView bFy;
    private View bFz;
    private boolean mIsHost;

    public r(PersonInfoActivity personInfoActivity, boolean z) {
        this.bES = personInfoActivity;
        this.mIsHost = z;
        this.HT = com.baidu.adp.lib.g.b.ek().inflate(this.bES, com.baidu.tieba.w.personinfo_gift_view, null);
        nu();
    }

    private void nu() {
        this.bEY = this.HT.findViewById(com.baidu.tieba.v.root_next);
        this.bFn = (RelativeLayout) this.HT.findViewById(com.baidu.tieba.v.gift);
        this.bFn.setOnClickListener(this.bES);
        this.bFo = (TextView) this.HT.findViewById(com.baidu.tieba.v.gift_num);
        this.bFp = (TextView) this.HT.findViewById(com.baidu.tieba.v.new_gift_num);
        this.bFq = (TextView) this.HT.findViewById(com.baidu.tieba.v.gift_num_text);
        this.bFr = (GridView) this.HT.findViewById(com.baidu.tieba.v.gift_grid);
        this.bFs = (TextView) this.HT.findViewById(com.baidu.tieba.v.no_gift_text);
        this.bFc = (ImageView) this.HT.findViewById(com.baidu.tieba.v.arrow_top);
        this.bFt = (TextView) this.HT.findViewById(com.baidu.tieba.v.give_gift);
        this.bFt.setOnClickListener(this.bES);
        this.bFu = this.HT.findViewById(com.baidu.tieba.v.gift_fans);
        this.bFv = (RelativeLayout) this.HT.findViewById(com.baidu.tieba.v.fans);
        this.bFw = (TextView) this.HT.findViewById(com.baidu.tieba.v.fans_him);
        this.bFx = (ImageView) this.HT.findViewById(com.baidu.tieba.v.fans_icon);
        this.bFy = (TextView) this.HT.findViewById(com.baidu.tieba.v.fans_num);
        this.bFh = (ImageView) this.HT.findViewById(com.baidu.tieba.v.arrow_middle);
        this.bFv.setOnClickListener(this.bES);
        this.bFz = this.HT.findViewById(com.baidu.tieba.v.fans_attention);
        this.bFA = (RelativeLayout) this.HT.findViewById(com.baidu.tieba.v.attention);
        this.bFB = (TextView) this.HT.findViewById(com.baidu.tieba.v.attention_other);
        this.bFC = (TextView) this.HT.findViewById(com.baidu.tieba.v.attention_num);
        this.bFm = (ImageView) this.HT.findViewById(com.baidu.tieba.v.arrow_bottom);
        this.bFA.setOnClickListener(this.bES);
        pU();
    }

    public void ey(boolean z) {
        aw.h(this.bFx, com.baidu.tieba.u.icon_news_down_bar_one);
        if (z) {
            this.bFx.setVisibility(0);
        } else {
            this.bFx.setVisibility(8);
        }
    }

    public void hc(int i) {
        if (i <= 0) {
            this.bFp.setVisibility(8);
            return;
        }
        this.bFp.setVisibility(0);
        aw.b(this.bFp, com.baidu.tieba.s.top_msg_num_day, 1);
        if (i < 10) {
            this.bFp.setText(String.valueOf(i));
            this.bFD = com.baidu.tieba.u.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.bFp.setText(String.valueOf(i));
            this.bFD = com.baidu.tieba.u.icon_news_head_prompt_two;
        } else {
            this.bFp.setText("");
            this.bFD = com.baidu.tieba.u.icon_news_head_prompt_more;
        }
        aw.h((View) this.bFp, this.bFD);
    }

    public void aaJ() {
        UserData userData = this.bES.aar().getUserData();
        c(userData);
        d(userData);
        e(userData);
    }

    private void c(UserData userData) {
        if (userData != null) {
            int giftNum = userData.getGiftNum();
            if (giftNum <= 0) {
                this.bFo.setText("0");
                if (this.mIsHost || !TbadkApplication.m251getInst().isGiftSwitchOn()) {
                    this.bFt.setVisibility(8);
                } else {
                    this.bFt.setVisibility(0);
                }
                this.bFc.setVisibility(8);
                this.bFr.setVisibility(8);
                this.bFs.setVisibility(0);
                if (this.mIsHost) {
                    this.bFs.setText(com.baidu.tieba.y.no_gift_tip_host);
                    return;
                } else {
                    this.bFs.setText(com.baidu.tieba.y.no_gift_tip);
                    return;
                }
            }
            String bB = az.bB(giftNum);
            if (bB.contains("w") && bB.length() > 3) {
                this.bFo.setTextSize(0, this.bES.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds48));
            }
            this.bFo.setText(bB);
            this.bFt.setVisibility(8);
            this.bFc.setVisibility(0);
            this.bFr.setVisibility(0);
            this.bFs.setVisibility(8);
            List<MyGift> gift = userData.getGift();
            if (gift == null || gift.size() <= 0) {
                this.bFt.setVisibility(8);
                this.bFc.setVisibility(0);
                this.bFr.setVisibility(0);
                this.bFs.setVisibility(8);
                return;
            }
            this.bFr.setAdapter((ListAdapter) new s(this, gift));
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v3 int)] */
    private void d(UserData userData) {
        if (userData != null) {
            if (userData.getSex() == 2) {
                this.bFw.setText(com.baidu.tieba.y.user_info_center_head_fans_name_text_g);
            } else {
                this.bFw.setText(com.baidu.tieba.y.user_info_center_head_fans_name_text_b);
            }
            if (this.mIsHost) {
                this.bFw.setText(com.baidu.tieba.y.user_info_center_head_fans_name_text);
            }
            int fansNum = userData.getFansNum();
            if (fansNum <= 0) {
                this.bFy.setText("0");
                this.bFh.setVisibility(8);
                aw.b(this.bFy, com.baidu.tieba.s.cp_cont_e, 1);
                return;
            }
            this.bFy.setText(new StringBuilder().append(fansNum).toString());
            this.bFh.setVisibility(0);
            aw.b(this.bFy, com.baidu.tieba.s.cp_cont_b, 1);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v0 int)] */
    private void e(UserData userData) {
        if (userData != null) {
            int concern_num = userData.getConcern_num();
            if (concern_num <= 0) {
                this.bFC.setText("0");
                this.bFm.setVisibility(8);
                aw.b(this.bFC, com.baidu.tieba.s.cp_cont_e, 1);
                return;
            }
            this.bFC.setText(new StringBuilder().append(concern_num).toString());
            this.bFm.setVisibility(0);
            aw.b(this.bFC, com.baidu.tieba.s.cp_cont_b, 1);
        }
    }

    public void pU() {
        aw.i(this.bEY, com.baidu.tieba.s.cp_bg_line_d);
        aw.h(this.bFn, com.baidu.tieba.u.personinfo_select_bg);
        aw.b(this.bFo, com.baidu.tieba.s.cp_cont_f, 1);
        aw.b(this.bFp, com.baidu.tieba.s.cp_cont_i, 1);
        aw.b(this.bFq, com.baidu.tieba.s.cp_cont_d, 1);
        aw.b(this.bFs, com.baidu.tieba.s.cp_cont_e, 1);
        aw.h(this.bFc, com.baidu.tieba.u.icon_dredge_arrow_r_n);
        aw.h((View) this.bFt, com.baidu.tieba.u.btn_blue_bg);
        aw.b(this.bFt, com.baidu.tieba.s.cp_cont_i, 1);
        aw.i(this.bFu, com.baidu.tieba.s.cp_bg_line_b);
        aw.h(this.bFv, com.baidu.tieba.u.personinfo_select_bg);
        aw.b(this.bFw, com.baidu.tieba.s.cp_cont_d, 1);
        aw.h(this.bFh, com.baidu.tieba.u.icon_dredge_arrow_r_n);
        aw.i(this.bFz, com.baidu.tieba.s.cp_bg_line_b);
        aw.h(this.bFA, com.baidu.tieba.u.personinfo_select_bg);
        aw.b(this.bFB, com.baidu.tieba.s.cp_cont_d, 1);
        aw.h(this.bFm, com.baidu.tieba.u.icon_dredge_arrow_r_n);
    }

    public TextView aaB() {
        return this.bFt;
    }

    public RelativeLayout aay() {
        return this.bFn;
    }

    public RelativeLayout aaD() {
        return this.bFv;
    }

    public RelativeLayout aaE() {
        return this.bFA;
    }

    public View getRootView() {
        return this.HT;
    }
}
