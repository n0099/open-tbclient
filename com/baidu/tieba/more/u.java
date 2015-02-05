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
    protected LinearLayout Vu;
    protected TextView Vv;
    protected TextView Vw;
    protected ImageView Vz;
    protected LinearLayout bvM;
    protected TextView bvN;
    protected Context mContext;

    public u(Context context) {
        super(context);
        this.mContext = context;
        tS();
    }

    public void setTipColor(int i) {
        if (this.Vw != null) {
            this.Vw.setTextColor(i);
        }
    }

    public void tR() {
        this.Vz.setVisibility(8);
    }

    public void Vr() {
        this.Vz.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.Vz.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvM.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(com.baidu.tieba.u.ds26);
            this.bvM.setLayoutParams(layoutParams);
            this.bvN.setText("");
            this.bvN.setVisibility(8);
            return;
        }
        this.bvM.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bvM.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(com.baidu.tieba.u.ds10);
        this.bvM.setLayoutParams(layoutParams2);
        this.bvN.setText(str);
        this.bvN.setVisibility(0);
    }

    public void setStatus(int i) {
        if (i == 1) {
            this.Vv.setTextColor(getResources().getColor(com.baidu.tieba.t.cp_cont_b));
        } else if (i == 2) {
            this.Vv.setTextColor(getResources().getColor(com.baidu.tieba.t.cp_link_tip_d));
        } else if (i == 3) {
            this.Vv.setTextColor(getResources().getColor(com.baidu.tieba.t.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.Vv.setText(str);
    }

    public void setText(int i) {
        this.Vv.setText(i);
    }

    public void setTip(String str) {
        this.Vw.setText(str);
    }

    public CharSequence getTip() {
        return this.Vw.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.Vw.setBackgroundDrawable(drawable);
    }

    protected void tS() {
        com.baidu.adp.lib.g.b.ei().a(this.mContext, com.baidu.tieba.x.image_problem_item_view, this, true);
        this.Vu = (LinearLayout) findViewById(com.baidu.tieba.w.container);
        this.Vv = (TextView) findViewById(com.baidu.tieba.w.text);
        this.Vw = (TextView) findViewById(com.baidu.tieba.w.tip);
        this.Vz = (ImageView) findViewById(com.baidu.tieba.w.arrow2);
        this.bvM = (LinearLayout) findViewById(com.baidu.tieba.w.ll_container);
        this.bvN = (TextView) findViewById(com.baidu.tieba.w.tv_help);
    }
}
