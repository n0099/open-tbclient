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
    protected LinearLayout US;
    protected TextView UT;
    protected TextView UU;
    protected ImageView UX;
    protected LinearLayout bur;
    protected TextView bus;
    protected Context mContext;

    public u(Context context) {
        super(context);
        this.mContext = context;
        tH();
    }

    public void setTipColor(int i) {
        if (this.UU != null) {
            this.UU.setTextColor(i);
        }
    }

    public void tG() {
        this.UX.setVisibility(8);
    }

    public void UY() {
        this.UX.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.UX.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bur.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(com.baidu.tieba.u.ds26);
            this.bur.setLayoutParams(layoutParams);
            this.bus.setText("");
            this.bus.setVisibility(8);
            return;
        }
        this.bur.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bur.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(com.baidu.tieba.u.ds10);
        this.bur.setLayoutParams(layoutParams2);
        this.bus.setText(str);
        this.bus.setVisibility(0);
    }

    public void setStatus(int i) {
        if (i == 1) {
            this.UT.setTextColor(getResources().getColor(com.baidu.tieba.t.cp_cont_b));
        } else if (i == 2) {
            this.UT.setTextColor(getResources().getColor(com.baidu.tieba.t.cp_link_tip_d));
        } else if (i == 3) {
            this.UT.setTextColor(getResources().getColor(com.baidu.tieba.t.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.UT.setText(str);
    }

    public void setText(int i) {
        this.UT.setText(i);
    }

    public void setTip(String str) {
        this.UU.setText(str);
    }

    public CharSequence getTip() {
        return this.UU.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.UU.setBackgroundDrawable(drawable);
    }

    protected void tH() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.x.image_problem_item_view, this, true);
        this.US = (LinearLayout) findViewById(com.baidu.tieba.w.container);
        this.UT = (TextView) findViewById(com.baidu.tieba.w.text);
        this.UU = (TextView) findViewById(com.baidu.tieba.w.tip);
        this.UX = (ImageView) findViewById(com.baidu.tieba.w.arrow2);
        this.bur = (LinearLayout) findViewById(com.baidu.tieba.w.ll_container);
        this.bus = (TextView) findViewById(com.baidu.tieba.w.tv_help);
    }
}
