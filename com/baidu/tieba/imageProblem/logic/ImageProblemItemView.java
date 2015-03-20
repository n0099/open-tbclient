package com.baidu.tieba.imageProblem.logic;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.g.b;
import com.baidu.tieba.aa;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ImageProblemItemView extends FrameLayout {
    protected ImageView afB;
    protected LinearLayout afw;
    protected TextView afx;
    protected TextView afy;
    protected LinearLayout bvF;
    protected TextView bvG;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        xj();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        xj();
    }

    public void displayTip() {
        if (this.afy != null) {
            this.afy.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.afy != null) {
            this.afy.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.afy != null) {
            this.afy.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.afB.setVisibility(8);
    }

    public void displayArrow() {
        this.afB.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.afB.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvF.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(t.ds26);
            this.bvF.setLayoutParams(layoutParams);
            this.bvG.setText("");
            this.bvG.setVisibility(8);
            return;
        }
        this.bvF.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bvF.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(t.ds10);
        this.bvF.setLayoutParams(layoutParams2);
        this.bvG.setText(str);
        this.bvG.setVisibility(0);
    }

    public void setStatus(int i) {
        if (i == 1) {
            this.afx.setTextColor(getResources().getColor(s.cp_cont_b));
        } else if (i == 2) {
            this.afx.setTextColor(getResources().getColor(s.cp_link_tip_d));
        } else if (i == 3) {
            this.afx.setTextColor(getResources().getColor(s.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.afx.setText(str);
    }

    public void setText(int i) {
        this.afx.setText(i);
    }

    public void setTip(String str) {
        this.afy.setText(str);
    }

    public CharSequence getTip() {
        return this.afy.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.afy.setBackgroundDrawable(drawable);
    }

    protected void xj() {
        b.hH().a(this.mContext, w.image_problem_item_view, this, true);
        this.afw = (LinearLayout) findViewById(v.container);
        this.afx = (TextView) findViewById(v.text);
        this.afy = (TextView) findViewById(v.tip);
        this.afB = (ImageView) findViewById(v.arrow2);
        this.bvF = (LinearLayout) findViewById(v.ll_container);
        this.bvG = (TextView) findViewById(v.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, aa.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.afx.setText(string);
        }
        if (color > -1) {
            this.afx.setTextColor(color);
        }
        if (string2 != null) {
            this.afy.setText(string2);
        }
        if (color2 > -1) {
            this.afy.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.afw.setClickable(false);
        this.afw.setFocusable(false);
        this.afB.setVisibility(4);
    }
}
