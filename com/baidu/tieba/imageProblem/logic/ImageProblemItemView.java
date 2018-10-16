package com.baidu.tieba.imageProblem.logic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class ImageProblemItemView extends FrameLayout {
    protected LinearLayout aQi;
    protected TextView aQj;
    protected TextView aQk;
    protected ImageView aQn;
    protected LinearLayout faA;
    protected TextView faB;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Ji();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        Ji();
    }

    public void displayTip() {
        if (this.aQk != null) {
            this.aQk.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.aQk != null) {
            this.aQk.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.aQk != null) {
            this.aQk.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.aQn.setVisibility(8);
    }

    public void displayArrow() {
        this.aQn.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.aQn.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.faA.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(e.C0175e.ds26);
            this.faA.setLayoutParams(layoutParams);
            this.faB.setText("");
            this.faB.setVisibility(8);
            return;
        }
        this.faA.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.faA.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(e.C0175e.ds10);
        this.faA.setLayoutParams(layoutParams2);
        this.faB.setText(str);
        this.faB.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.aQj.setTextColor(getResources().getColor(e.d.cp_cont_b));
        } else if (i == 2) {
            this.aQj.setTextColor(getResources().getColor(e.d.cp_link_tip_d));
        } else if (i == 3) {
            this.aQj.setTextColor(getResources().getColor(e.d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.aQj.setText(str);
    }

    public void setText(int i) {
        this.aQj.setText(i);
    }

    public void setTip(String str) {
        this.aQk.setText(str);
    }

    public CharSequence getTip() {
        return this.aQk.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.aQk.setBackgroundDrawable(drawable);
    }

    protected void Ji() {
        LayoutInflater.from(this.mContext).inflate(e.h.image_problem_item_view, (ViewGroup) this, true);
        this.aQi = (LinearLayout) findViewById(e.g.container);
        this.aQj = (TextView) findViewById(e.g.text);
        this.aQk = (TextView) findViewById(e.g.tip);
        this.aQn = (ImageView) findViewById(e.g.arrow2);
        this.faA = (LinearLayout) findViewById(e.g.ll_container);
        this.faB = (TextView) findViewById(e.g.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, e.l.TbSettingView);
        String string = obtainStyledAttributes.getString(e.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(e.l.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(e.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(e.l.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.aQj.setText(string);
        }
        if (color > -1) {
            this.aQj.setTextColor(color);
        }
        if (string2 != null) {
            this.aQk.setText(string2);
        }
        if (color2 > -1) {
            this.aQk.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.aQi.setClickable(false);
        this.aQi.setFocusable(false);
        this.aQn.setVisibility(4);
    }
}
