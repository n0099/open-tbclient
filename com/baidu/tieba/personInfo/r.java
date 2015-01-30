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
    private PersonInfoActivity bJZ;
    private TextView bKA;
    private View bKB;
    private RelativeLayout bKC;
    private TextView bKD;
    private ImageView bKE;
    private TextView bKF;
    private View bKG;
    private RelativeLayout bKH;
    private TextView bKI;
    private TextView bKJ;
    private int bKK;
    private View bKf;
    private ImageView bKj;
    private ImageView bKo;
    private ImageView bKt;
    private RelativeLayout bKu;
    private TextView bKv;
    private TextView bKw;
    private TextView bKx;
    private GridView bKy;
    private TextView bKz;
    private boolean mIsHost;
    private View mRootView;

    public r(PersonInfoActivity personInfoActivity, boolean z) {
        this.bJZ = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.ei().inflate(this.bJZ.getPageContext().getPageActivity(), com.baidu.tieba.x.personinfo_gift_view, null);
        initView();
    }

    private void initView() {
        this.bKf = this.mRootView.findViewById(com.baidu.tieba.w.root_next);
        this.bKu = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.w.gift);
        this.bKu.setOnClickListener(this.bJZ);
        this.bKv = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.gift_num);
        this.bKw = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.new_gift_num);
        this.bKx = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.gift_num_text);
        this.bKy = (GridView) this.mRootView.findViewById(com.baidu.tieba.w.gift_grid);
        this.bKz = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.no_gift_text);
        this.bKj = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.arrow_top);
        this.bKA = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.give_gift);
        this.bKA.setOnClickListener(this.bJZ);
        this.bKB = this.mRootView.findViewById(com.baidu.tieba.w.gift_fans);
        this.bKC = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.w.fans);
        this.bKD = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.fans_him);
        this.bKE = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.fans_icon);
        this.bKF = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.fans_num);
        this.bKo = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.arrow_middle);
        this.bKC.setOnClickListener(this.bJZ);
        this.bKG = this.mRootView.findViewById(com.baidu.tieba.w.fans_attention);
        this.bKH = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.w.attention);
        this.bKI = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.attention_other);
        this.bKJ = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.attention_num);
        this.bKt = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.arrow_bottom);
        this.bKH.setOnClickListener(this.bJZ);
        if (TbadkCoreApplication.m255getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.bKu.setVisibility(8);
        }
        kE();
    }

    public void ek(boolean z) {
        bc.i(this.bKE, com.baidu.tieba.v.icon_news_down_bar_one);
        if (z) {
            this.bKE.setVisibility(0);
        } else {
            this.bKE.setVisibility(8);
        }
    }

    public void hu(int i) {
        if (i <= 0) {
            this.bKw.setVisibility(8);
            return;
        }
        this.bKw.setVisibility(0);
        bc.b(this.bKw, com.baidu.tieba.t.top_msg_num_day, 1);
        if (i < 10) {
            this.bKw.setText(String.valueOf(i));
            this.bKK = com.baidu.tieba.v.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.bKw.setText(String.valueOf(i));
            this.bKK = com.baidu.tieba.v.icon_news_head_prompt_two;
        } else {
            this.bKw.setText("");
            this.bKK = com.baidu.tieba.v.icon_news_head_prompt_more;
        }
        bc.i((View) this.bKw, this.bKK);
    }

    public void abI() {
        UserData userData = this.bJZ.abq().getUserData();
        f(userData);
        g(userData);
        h(userData);
    }

    private void f(UserData userData) {
        if (userData != null) {
            int giftNum = userData.getGiftNum();
            if (giftNum <= 0) {
                this.bKv.setText("0");
                if (this.mIsHost || !TbadkCoreApplication.m255getInst().isGiftSwitchOn()) {
                    this.bKA.setVisibility(8);
                } else {
                    this.bKA.setVisibility(0);
                }
                this.bKj.setVisibility(8);
                this.bKy.setVisibility(8);
                this.bKz.setVisibility(0);
                if (this.mIsHost) {
                    this.bKz.setText(com.baidu.tieba.z.no_gift_tip_host);
                    return;
                } else {
                    this.bKz.setText(com.baidu.tieba.z.no_gift_tip);
                    return;
                }
            }
            String cf = bf.cf(giftNum);
            if (cf.contains("w") && cf.length() > 3) {
                this.bKv.setTextSize(0, this.bJZ.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds48));
            }
            this.bKv.setText(cf);
            this.bKA.setVisibility(8);
            this.bKj.setVisibility(0);
            this.bKy.setVisibility(0);
            this.bKz.setVisibility(8);
            List<MyGift> gift = userData.getGift();
            if (gift == null || gift.size() <= 0) {
                this.bKA.setVisibility(8);
                this.bKj.setVisibility(0);
                this.bKy.setVisibility(0);
                this.bKz.setVisibility(8);
                return;
            }
            this.bKy.setAdapter((ListAdapter) new s(this, gift));
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v3 int)] */
    private void g(UserData userData) {
        if (userData != null) {
            if (userData.getSex() == 2) {
                this.bKD.setText(com.baidu.tieba.z.user_info_center_head_fans_name_text_g);
            } else {
                this.bKD.setText(com.baidu.tieba.z.user_info_center_head_fans_name_text_b);
            }
            if (this.mIsHost) {
                this.bKD.setText(com.baidu.tieba.z.user_info_center_head_fans_name_text);
            }
            int fansNum = userData.getFansNum();
            if (fansNum <= 0) {
                this.bKF.setText("0");
                this.bKo.setVisibility(8);
                bc.b(this.bKF, com.baidu.tieba.t.cp_cont_e, 1);
                return;
            }
            this.bKF.setText(new StringBuilder().append(fansNum).toString());
            this.bKo.setVisibility(0);
            bc.b(this.bKF, com.baidu.tieba.t.cp_cont_b, 1);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v0 int)] */
    private void h(UserData userData) {
        if (userData != null) {
            int concern_num = userData.getConcern_num();
            if (concern_num <= 0) {
                this.bKJ.setText("0");
                this.bKt.setVisibility(8);
                bc.b(this.bKJ, com.baidu.tieba.t.cp_cont_e, 1);
                return;
            }
            this.bKJ.setText(new StringBuilder().append(concern_num).toString());
            this.bKt.setVisibility(0);
            bc.b(this.bKJ, com.baidu.tieba.t.cp_cont_b, 1);
        }
    }

    public void kE() {
        bc.j(this.bKf, com.baidu.tieba.t.cp_bg_line_d);
        bc.i(this.bKu, com.baidu.tieba.v.personinfo_select_bg);
        bc.b(this.bKv, com.baidu.tieba.t.cp_cont_f, 1);
        bc.b(this.bKw, com.baidu.tieba.t.cp_cont_i, 1);
        bc.b(this.bKx, com.baidu.tieba.t.cp_cont_d, 1);
        bc.b(this.bKz, com.baidu.tieba.t.cp_cont_e, 1);
        bc.i(this.bKj, com.baidu.tieba.v.icon_dredge_arrow_r_n);
        bc.i((View) this.bKA, com.baidu.tieba.v.btn_blue_bg);
        bc.b(this.bKA, com.baidu.tieba.t.cp_cont_i, 1);
        bc.j(this.bKB, com.baidu.tieba.t.cp_bg_line_b);
        bc.i(this.bKC, com.baidu.tieba.v.personinfo_select_bg);
        bc.b(this.bKD, com.baidu.tieba.t.cp_cont_d, 1);
        bc.i(this.bKo, com.baidu.tieba.v.icon_dredge_arrow_r_n);
        bc.j(this.bKG, com.baidu.tieba.t.cp_bg_line_b);
        bc.i(this.bKH, com.baidu.tieba.v.personinfo_select_bg);
        bc.b(this.bKI, com.baidu.tieba.t.cp_cont_d, 1);
        bc.i(this.bKt, com.baidu.tieba.v.icon_dredge_arrow_r_n);
    }

    public TextView abA() {
        return this.bKA;
    }

    public RelativeLayout abw() {
        return this.bKu;
    }

    public void abx() {
        if (this.bKu != null) {
            this.bKu.setVisibility(8);
        }
        if (this.bKB != null) {
            this.bKB.setVisibility(8);
        }
    }

    public RelativeLayout abC() {
        return this.bKC;
    }

    public RelativeLayout abD() {
        return this.bKH;
    }

    public View getRootView() {
        return this.mRootView;
    }
}
