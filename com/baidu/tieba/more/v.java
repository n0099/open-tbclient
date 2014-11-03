package com.baidu.tieba.more;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class v extends FrameLayout {
    protected LinearLayout Pg;
    protected TextView Ph;
    protected TextView Pi;
    protected ImageView Pl;
    protected LinearLayout brc;
    protected TextView brd;
    protected Context mContext;

    public v(Context context) {
        super(context);
        this.mContext = context;
        qo();
    }

    public void setTipColor(int i) {
        if (this.Pi != null) {
            this.Pi.setTextColor(i);
        }
    }

    public void qn() {
        this.Pl.setVisibility(8);
    }

    public void UM() {
        this.Pl.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.Pl.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.brc.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(com.baidu.tieba.t.ds26);
            this.brc.setLayoutParams(layoutParams);
            this.brd.setText("");
            this.brd.setVisibility(8);
            return;
        }
        this.brc.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.brc.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(com.baidu.tieba.t.ds10);
        this.brc.setLayoutParams(layoutParams2);
        this.brd.setText(str);
        this.brd.setVisibility(0);
    }

    public void setStatus(int i) {
        if (i == 1) {
            this.Ph.setTextColor(getResources().getColor(com.baidu.tieba.s.cp_cont_b));
        } else if (i == 2) {
            this.Ph.setTextColor(getResources().getColor(com.baidu.tieba.s.cp_link_tip_d));
        } else if (i == 3) {
            this.Ph.setTextColor(getResources().getColor(com.baidu.tieba.s.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.Ph.setText(str);
    }

    public void setText(int i) {
        this.Ph.setText(i);
    }

    public void setTip(String str) {
        this.Pi.setText(str);
    }

    public CharSequence getTip() {
        return this.Pi.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.Pi.setBackgroundDrawable(drawable);
    }

    protected void qo() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.image_problem_item_view, this, true);
        this.Pg = (LinearLayout) findViewById(com.baidu.tieba.v.container);
        this.Ph = (TextView) findViewById(com.baidu.tieba.v.text);
        this.Pi = (TextView) findViewById(com.baidu.tieba.v.tip);
        this.Pl = (ImageView) findViewById(com.baidu.tieba.v.arrow2);
        this.brc = (LinearLayout) findViewById(com.baidu.tieba.v.ll_container);
        this.brd = (TextView) findViewById(com.baidu.tieba.v.tv_help);
    }
}
