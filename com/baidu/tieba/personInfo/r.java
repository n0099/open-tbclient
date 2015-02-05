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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.data.MyGift;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    private PersonInfoActivity bJY;
    private View bKA;
    private RelativeLayout bKB;
    private TextView bKC;
    private ImageView bKD;
    private TextView bKE;
    private View bKF;
    private RelativeLayout bKG;
    private TextView bKH;
    private TextView bKI;
    private int bKJ;
    private View bKe;
    private ImageView bKi;
    private ImageView bKn;
    private ImageView bKs;
    private RelativeLayout bKt;
    private TextView bKu;
    private TextView bKv;
    private TextView bKw;
    private GridView bKx;
    private TextView bKy;
    private TextView bKz;
    private boolean mIsHost;
    private View mRootView;

    public r(PersonInfoActivity personInfoActivity, boolean z) {
        this.bJY = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.ei().inflate(this.bJY.getPageContext().getPageActivity(), com.baidu.tieba.x.personinfo_gift_view, null);
        initView();
    }

    private void initView() {
        this.bKe = this.mRootView.findViewById(com.baidu.tieba.w.root_next);
        this.bKt = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.w.gift);
        this.bKt.setOnClickListener(this.bJY);
        this.bKu = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.gift_num);
        this.bKv = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.new_gift_num);
        this.bKw = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.gift_num_text);
        this.bKx = (GridView) this.mRootView.findViewById(com.baidu.tieba.w.gift_grid);
        this.bKy = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.no_gift_text);
        this.bKi = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.arrow_top);
        this.bKz = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.give_gift);
        this.bKz.setOnClickListener(this.bJY);
        this.bKA = this.mRootView.findViewById(com.baidu.tieba.w.gift_fans);
        this.bKB = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.w.fans);
        this.bKC = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.fans_him);
        this.bKD = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.fans_icon);
        this.bKE = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.fans_num);
        this.bKn = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.arrow_middle);
        this.bKB.setOnClickListener(this.bJY);
        this.bKF = this.mRootView.findViewById(com.baidu.tieba.w.fans_attention);
        this.bKG = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.w.attention);
        this.bKH = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.attention_other);
        this.bKI = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.attention_num);
        this.bKs = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.arrow_bottom);
        this.bKG.setOnClickListener(this.bJY);
        if (TbadkCoreApplication.m255getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.bKt.setVisibility(8);
        }
        kx();
    }

    public void ek(boolean z) {
        bc.i(this.bKD, com.baidu.tieba.v.icon_news_down_bar_one);
        if (z) {
            this.bKD.setVisibility(0);
        } else {
            this.bKD.setVisibility(8);
        }
    }

    public void hu(int i) {
        if (i <= 0) {
            this.bKv.setVisibility(8);
            return;
        }
        this.bKv.setVisibility(0);
        bc.b(this.bKv, com.baidu.tieba.t.top_msg_num_day, 1);
        if (i < 10) {
            this.bKv.setText(String.valueOf(i));
            this.bKJ = com.baidu.tieba.v.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.bKv.setText(String.valueOf(i));
            this.bKJ = com.baidu.tieba.v.icon_news_head_prompt_two;
        } else {
            this.bKv.setText("");
            this.bKJ = com.baidu.tieba.v.icon_news_head_prompt_more;
        }
        bc.i((View) this.bKv, this.bKJ);
    }

    public void abD() {
        UserData userData = this.bJY.abl().getUserData();
        f(userData);
        g(userData);
        h(userData);
    }

    private void f(UserData userData) {
        if (userData != null) {
            int giftNum = userData.getGiftNum();
            if (giftNum <= 0) {
                this.bKu.setText("0");
                if (this.mIsHost || !TbadkCoreApplication.m255getInst().isGiftSwitchOn()) {
                    this.bKz.setVisibility(8);
                } else {
                    this.bKz.setVisibility(0);
                }
                this.bKi.setVisibility(8);
                this.bKx.setVisibility(8);
                this.bKy.setVisibility(0);
                if (this.mIsHost) {
                    this.bKy.setText(com.baidu.tieba.z.no_gift_tip_host);
                    return;
                } else {
                    this.bKy.setText(com.baidu.tieba.z.no_gift_tip);
                    return;
                }
            }
            String cf = bf.cf(giftNum);
            if (cf.contains("w") && cf.length() > 3) {
                this.bKu.setTextSize(0, this.bJY.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds48));
            }
            this.bKu.setText(cf);
            this.bKz.setVisibility(8);
            this.bKi.setVisibility(0);
            this.bKx.setVisibility(0);
            this.bKy.setVisibility(8);
            List<MyGift> gift = userData.getGift();
            if (gift == null || gift.size() <= 0) {
                this.bKz.setVisibility(8);
                this.bKi.setVisibility(0);
                this.bKx.setVisibility(0);
                this.bKy.setVisibility(8);
                return;
            }
            this.bKx.setAdapter((ListAdapter) new s(this, gift));
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v3 int)] */
    private void g(UserData userData) {
        if (userData != null) {
            if (userData.getSex() == 2) {
                this.bKC.setText(com.baidu.tieba.z.user_info_center_head_fans_name_text_g);
            } else {
                this.bKC.setText(com.baidu.tieba.z.user_info_center_head_fans_name_text_b);
            }
            if (this.mIsHost) {
                this.bKC.setText(com.baidu.tieba.z.user_info_center_head_fans_name_text);
            }
            int fansNum = userData.getFansNum();
            if (fansNum <= 0) {
                this.bKE.setText("0");
                this.bKn.setVisibility(8);
                bc.b(this.bKE, com.baidu.tieba.t.cp_cont_e, 1);
                return;
            }
            this.bKE.setText(new StringBuilder().append(fansNum).toString());
            this.bKn.setVisibility(0);
            bc.b(this.bKE, com.baidu.tieba.t.cp_cont_b, 1);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v0 int)] */
    private void h(UserData userData) {
        if (userData != null) {
            int concern_num = userData.getConcern_num();
            if (concern_num <= 0) {
                this.bKI.setText("0");
                this.bKs.setVisibility(8);
                bc.b(this.bKI, com.baidu.tieba.t.cp_cont_e, 1);
                return;
            }
            this.bKI.setText(new StringBuilder().append(concern_num).toString());
            this.bKs.setVisibility(0);
            bc.b(this.bKI, com.baidu.tieba.t.cp_cont_b, 1);
        }
    }

    public void kx() {
        bc.j(this.bKe, com.baidu.tieba.t.cp_bg_line_d);
        bc.i(this.bKt, com.baidu.tieba.v.personinfo_select_bg);
        bc.b(this.bKu, com.baidu.tieba.t.cp_cont_f, 1);
        bc.b(this.bKv, com.baidu.tieba.t.cp_cont_i, 1);
        bc.b(this.bKw, com.baidu.tieba.t.cp_cont_d, 1);
        bc.b(this.bKy, com.baidu.tieba.t.cp_cont_e, 1);
        bc.i(this.bKi, com.baidu.tieba.v.icon_dredge_arrow_r_n);
        bc.i((View) this.bKz, com.baidu.tieba.v.btn_blue_bg);
        bc.b(this.bKz, com.baidu.tieba.t.cp_cont_i, 1);
        bc.j(this.bKA, com.baidu.tieba.t.cp_bg_line_b);
        bc.i(this.bKB, com.baidu.tieba.v.personinfo_select_bg);
        bc.b(this.bKC, com.baidu.tieba.t.cp_cont_d, 1);
        bc.i(this.bKn, com.baidu.tieba.v.icon_dredge_arrow_r_n);
        bc.j(this.bKF, com.baidu.tieba.t.cp_bg_line_b);
        bc.i(this.bKG, com.baidu.tieba.v.personinfo_select_bg);
        bc.b(this.bKH, com.baidu.tieba.t.cp_cont_d, 1);
        bc.i(this.bKs, com.baidu.tieba.v.icon_dredge_arrow_r_n);
    }

    public TextView abv() {
        return this.bKz;
    }

    public RelativeLayout abr() {
        return this.bKt;
    }

    public void abs() {
        if (this.bKt != null) {
            this.bKt.setVisibility(8);
        }
        if (this.bKA != null) {
            this.bKA.setVisibility(8);
        }
    }

    public RelativeLayout abx() {
        return this.bKB;
    }

    public RelativeLayout aby() {
        return this.bKG;
    }

    public View getRootView() {
        return this.mRootView;
    }
}
