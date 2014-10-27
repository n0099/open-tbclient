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
    protected LinearLayout Pc;
    protected TextView Pd;
    protected TextView Pe;
    protected ImageView Ph;
    protected LinearLayout bqO;
    protected TextView bqP;
    protected Context mContext;

    public v(Context context) {
        super(context);
        this.mContext = context;
        qm();
    }

    public void setTipColor(int i) {
        if (this.Pe != null) {
            this.Pe.setTextColor(i);
        }
    }

    public void ql() {
        this.Ph.setVisibility(8);
    }

    public void UJ() {
        this.Ph.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.Ph.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bqO.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(com.baidu.tieba.t.ds26);
            this.bqO.setLayoutParams(layoutParams);
            this.bqP.setText("");
            this.bqP.setVisibility(8);
            return;
        }
        this.bqO.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bqO.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(com.baidu.tieba.t.ds10);
        this.bqO.setLayoutParams(layoutParams2);
        this.bqP.setText(str);
        this.bqP.setVisibility(0);
    }

    public void setStatus(int i) {
        if (i == 1) {
            this.Pd.setTextColor(getResources().getColor(com.baidu.tieba.s.cp_cont_b));
        } else if (i == 2) {
            this.Pd.setTextColor(getResources().getColor(com.baidu.tieba.s.cp_link_tip_d));
        } else if (i == 3) {
            this.Pd.setTextColor(getResources().getColor(com.baidu.tieba.s.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.Pd.setText(str);
    }

    public void setText(int i) {
        this.Pd.setText(i);
    }

    public void setTip(String str) {
        this.Pe.setText(str);
    }

    public CharSequence getTip() {
        return this.Pe.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.Pe.setBackgroundDrawable(drawable);
    }

    protected void qm() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.image_problem_item_view, this, true);
        this.Pc = (LinearLayout) findViewById(com.baidu.tieba.v.container);
        this.Pd = (TextView) findViewById(com.baidu.tieba.v.text);
        this.Pe = (TextView) findViewById(com.baidu.tieba.v.tip);
        this.Ph = (ImageView) findViewById(com.baidu.tieba.v.arrow2);
        this.bqO = (LinearLayout) findViewById(com.baidu.tieba.v.ll_container);
        this.bqP = (TextView) findViewById(com.baidu.tieba.v.tv_help);
    }
}
