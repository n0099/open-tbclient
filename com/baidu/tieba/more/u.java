package com.baidu.tieba.more;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class u extends FrameLayout {
    protected ImageView VC;
    protected LinearLayout Vx;
    protected TextView Vy;
    protected TextView Vz;
    protected LinearLayout bvN;
    protected TextView bvO;
    protected Context mContext;

    public u(Context context) {
        super(context);
        this.mContext = context;
        tY();
    }

    public void setTipColor(int i) {
        if (this.Vz != null) {
            this.Vz.setTextColor(i);
        }
    }

    public void tX() {
        this.VC.setVisibility(8);
    }

    public void Vw() {
        this.VC.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.VC.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvN.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(com.baidu.tieba.u.ds26);
            this.bvN.setLayoutParams(layoutParams);
            this.bvO.setText("");
            this.bvO.setVisibility(8);
            return;
        }
        this.bvN.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bvN.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(com.baidu.tieba.u.ds10);
        this.bvN.setLayoutParams(layoutParams2);
        this.bvO.setText(str);
        this.bvO.setVisibility(0);
    }

    public void setStatus(int i) {
        if (i == 1) {
            this.Vy.setTextColor(getResources().getColor(com.baidu.tieba.t.cp_cont_b));
        } else if (i == 2) {
            this.Vy.setTextColor(getResources().getColor(com.baidu.tieba.t.cp_link_tip_d));
        } else if (i == 3) {
            this.Vy.setTextColor(getResources().getColor(com.baidu.tieba.t.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.Vy.setText(str);
    }

    public void setText(int i) {
        this.Vy.setText(i);
    }

    public void setTip(String str) {
        this.Vz.setText(str);
    }

    public CharSequence getTip() {
        return this.Vz.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.Vz.setBackgroundDrawable(drawable);
    }

    protected void tY() {
        com.baidu.adp.lib.g.b.ei().a(this.mContext, com.baidu.tieba.x.image_problem_item_view, this, true);
        this.Vx = (LinearLayout) findViewById(com.baidu.tieba.w.container);
        this.Vy = (TextView) findViewById(com.baidu.tieba.w.text);
        this.Vz = (TextView) findViewById(com.baidu.tieba.w.tip);
        this.VC = (ImageView) findViewById(com.baidu.tieba.w.arrow2);
        this.bvN = (LinearLayout) findViewById(com.baidu.tieba.w.ll_container);
        this.bvO = (TextView) findViewById(com.baidu.tieba.w.tv_help);
    }
}
