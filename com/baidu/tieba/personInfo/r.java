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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.data.MyGift;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    private ImageView bIC;
    private ImageView bIH;
    private RelativeLayout bII;
    private TextView bIJ;
    private TextView bIK;
    private TextView bIL;
    private GridView bIM;
    private TextView bIN;
    private TextView bIO;
    private View bIP;
    private RelativeLayout bIQ;
    private TextView bIR;
    private ImageView bIS;
    private TextView bIT;
    private View bIU;
    private RelativeLayout bIV;
    private TextView bIW;
    private TextView bIX;
    private int bIY;
    private PersonInfoActivity bIn;
    private View bIt;
    private ImageView bIx;
    private boolean mIsHost;
    private View mRootView;

    public r(PersonInfoActivity personInfoActivity, boolean z) {
        this.bIn = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.ek().inflate(this.bIn.getPageContext().getPageActivity(), com.baidu.tieba.x.personinfo_gift_view, null);
        initView();
    }

    private void initView() {
        this.bIt = this.mRootView.findViewById(com.baidu.tieba.w.root_next);
        this.bII = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.w.gift);
        this.bII.setOnClickListener(this.bIn);
        this.bIJ = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.gift_num);
        this.bIK = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.new_gift_num);
        this.bIL = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.gift_num_text);
        this.bIM = (GridView) this.mRootView.findViewById(com.baidu.tieba.w.gift_grid);
        this.bIN = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.no_gift_text);
        this.bIx = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.arrow_top);
        this.bIO = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.give_gift);
        this.bIO.setOnClickListener(this.bIn);
        this.bIP = this.mRootView.findViewById(com.baidu.tieba.w.gift_fans);
        this.bIQ = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.w.fans);
        this.bIR = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.fans_him);
        this.bIS = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.fans_icon);
        this.bIT = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.fans_num);
        this.bIC = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.arrow_middle);
        this.bIQ.setOnClickListener(this.bIn);
        this.bIU = this.mRootView.findViewById(com.baidu.tieba.w.fans_attention);
        this.bIV = (RelativeLayout) this.mRootView.findViewById(com.baidu.tieba.w.attention);
        this.bIW = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.attention_other);
        this.bIX = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.attention_num);
        this.bIH = (ImageView) this.mRootView.findViewById(com.baidu.tieba.w.arrow_bottom);
        this.bIV.setOnClickListener(this.bIn);
        if (TbadkCoreApplication.m255getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.bII.setVisibility(8);
        }
        kE();
    }

    public void ee(boolean z) {
        ax.i(this.bIS, com.baidu.tieba.v.icon_news_down_bar_one);
        if (z) {
            this.bIS.setVisibility(0);
        } else {
            this.bIS.setVisibility(8);
        }
    }

    public void hl(int i) {
        if (i <= 0) {
            this.bIK.setVisibility(8);
            return;
        }
        this.bIK.setVisibility(0);
        ax.b(this.bIK, com.baidu.tieba.t.top_msg_num_day, 1);
        if (i < 10) {
            this.bIK.setText(String.valueOf(i));
            this.bIY = com.baidu.tieba.v.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.bIK.setText(String.valueOf(i));
            this.bIY = com.baidu.tieba.v.icon_news_head_prompt_two;
        } else {
            this.bIK.setText("");
            this.bIY = com.baidu.tieba.v.icon_news_head_prompt_more;
        }
        ax.i((View) this.bIK, this.bIY);
    }

    public void abe() {
        UserData userData = this.bIn.aaL().getUserData();
        f(userData);
        g(userData);
        h(userData);
    }

    private void f(UserData userData) {
        if (userData != null) {
            int giftNum = userData.getGiftNum();
            if (giftNum <= 0) {
                this.bIJ.setText("0");
                if (this.mIsHost || !TbadkCoreApplication.m255getInst().isGiftSwitchOn()) {
                    this.bIO.setVisibility(8);
                } else {
                    this.bIO.setVisibility(0);
                }
                this.bIx.setVisibility(8);
                this.bIM.setVisibility(8);
                this.bIN.setVisibility(0);
                if (this.mIsHost) {
                    this.bIN.setText(com.baidu.tieba.z.no_gift_tip_host);
                    return;
                } else {
                    this.bIN.setText(com.baidu.tieba.z.no_gift_tip);
                    return;
                }
            }
            String bY = ba.bY(giftNum);
            if (bY.contains("w") && bY.length() > 3) {
                this.bIJ.setTextSize(0, this.bIn.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds48));
            }
            this.bIJ.setText(bY);
            this.bIO.setVisibility(8);
            this.bIx.setVisibility(0);
            this.bIM.setVisibility(0);
            this.bIN.setVisibility(8);
            List<MyGift> gift = userData.getGift();
            if (gift == null || gift.size() <= 0) {
                this.bIO.setVisibility(8);
                this.bIx.setVisibility(0);
                this.bIM.setVisibility(0);
                this.bIN.setVisibility(8);
                return;
            }
            this.bIM.setAdapter((ListAdapter) new s(this, gift));
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v3 int)] */
    private void g(UserData userData) {
        if (userData != null) {
            if (userData.getSex() == 2) {
                this.bIR.setText(com.baidu.tieba.z.user_info_center_head_fans_name_text_g);
            } else {
                this.bIR.setText(com.baidu.tieba.z.user_info_center_head_fans_name_text_b);
            }
            if (this.mIsHost) {
                this.bIR.setText(com.baidu.tieba.z.user_info_center_head_fans_name_text);
            }
            int fansNum = userData.getFansNum();
            if (fansNum <= 0) {
                this.bIT.setText("0");
                this.bIC.setVisibility(8);
                ax.b(this.bIT, com.baidu.tieba.t.cp_cont_e, 1);
                return;
            }
            this.bIT.setText(new StringBuilder().append(fansNum).toString());
            this.bIC.setVisibility(0);
            ax.b(this.bIT, com.baidu.tieba.t.cp_cont_b, 1);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v0 int)] */
    private void h(UserData userData) {
        if (userData != null) {
            int concern_num = userData.getConcern_num();
            if (concern_num <= 0) {
                this.bIX.setText("0");
                this.bIH.setVisibility(8);
                ax.b(this.bIX, com.baidu.tieba.t.cp_cont_e, 1);
                return;
            }
            this.bIX.setText(new StringBuilder().append(concern_num).toString());
            this.bIH.setVisibility(0);
            ax.b(this.bIX, com.baidu.tieba.t.cp_cont_b, 1);
        }
    }

    public void kE() {
        ax.j(this.bIt, com.baidu.tieba.t.cp_bg_line_d);
        ax.i(this.bII, com.baidu.tieba.v.personinfo_select_bg);
        ax.b(this.bIJ, com.baidu.tieba.t.cp_cont_f, 1);
        ax.b(this.bIK, com.baidu.tieba.t.cp_cont_i, 1);
        ax.b(this.bIL, com.baidu.tieba.t.cp_cont_d, 1);
        ax.b(this.bIN, com.baidu.tieba.t.cp_cont_e, 1);
        ax.i(this.bIx, com.baidu.tieba.v.icon_dredge_arrow_r_n);
        ax.i((View) this.bIO, com.baidu.tieba.v.btn_blue_bg);
        ax.b(this.bIO, com.baidu.tieba.t.cp_cont_i, 1);
        ax.j(this.bIP, com.baidu.tieba.t.cp_bg_line_b);
        ax.i(this.bIQ, com.baidu.tieba.v.personinfo_select_bg);
        ax.b(this.bIR, com.baidu.tieba.t.cp_cont_d, 1);
        ax.i(this.bIC, com.baidu.tieba.v.icon_dredge_arrow_r_n);
        ax.j(this.bIU, com.baidu.tieba.t.cp_bg_line_b);
        ax.i(this.bIV, com.baidu.tieba.v.personinfo_select_bg);
        ax.b(this.bIW, com.baidu.tieba.t.cp_cont_d, 1);
        ax.i(this.bIH, com.baidu.tieba.v.icon_dredge_arrow_r_n);
    }

    public TextView aaW() {
        return this.bIO;
    }

    public RelativeLayout aaS() {
        return this.bII;
    }

    public void aaT() {
        if (this.bII != null) {
            this.bII.setVisibility(8);
        }
        if (this.bIP != null) {
            this.bIP.setVisibility(8);
        }
    }

    public RelativeLayout aaY() {
        return this.bIQ;
    }

    public RelativeLayout aaZ() {
        return this.bIV;
    }

    public View getRootView() {
        return this.mRootView;
    }
}
