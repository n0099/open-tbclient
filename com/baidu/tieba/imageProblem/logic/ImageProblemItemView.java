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
    protected LinearLayout afE;
    protected TextView afF;
    protected TextView afG;
    protected ImageView afJ;
    protected LinearLayout bvV;
    protected TextView bvW;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        xp();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        xp();
    }

    public void displayTip() {
        if (this.afG != null) {
            this.afG.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.afG != null) {
            this.afG.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.afG != null) {
            this.afG.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.afJ.setVisibility(8);
    }

    public void displayArrow() {
        this.afJ.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.afJ.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvV.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(t.ds26);
            this.bvV.setLayoutParams(layoutParams);
            this.bvW.setText("");
            this.bvW.setVisibility(8);
            return;
        }
        this.bvV.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bvV.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(t.ds10);
        this.bvV.setLayoutParams(layoutParams2);
        this.bvW.setText(str);
        this.bvW.setVisibility(0);
    }

    public void setStatus(int i) {
        if (i == 1) {
            this.afF.setTextColor(getResources().getColor(s.cp_cont_b));
        } else if (i == 2) {
            this.afF.setTextColor(getResources().getColor(s.cp_link_tip_d));
        } else if (i == 3) {
            this.afF.setTextColor(getResources().getColor(s.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.afF.setText(str);
    }

    public void setText(int i) {
        this.afF.setText(i);
    }

    public void setTip(String str) {
        this.afG.setText(str);
    }

    public CharSequence getTip() {
        return this.afG.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.afG.setBackgroundDrawable(drawable);
    }

    protected void xp() {
        b.hH().a(this.mContext, w.image_problem_item_view, this, true);
        this.afE = (LinearLayout) findViewById(v.container);
        this.afF = (TextView) findViewById(v.text);
        this.afG = (TextView) findViewById(v.tip);
        this.afJ = (ImageView) findViewById(v.arrow2);
        this.bvV = (LinearLayout) findViewById(v.ll_container);
        this.bvW = (TextView) findViewById(v.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, aa.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.afF.setText(string);
        }
        if (color > -1) {
            this.afF.setTextColor(color);
        }
        if (string2 != null) {
            this.afG.setText(string2);
        }
        if (color2 > -1) {
            this.afG.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.afE.setClickable(false);
        this.afE.setFocusable(false);
        this.afJ.setVisibility(4);
    }
}
