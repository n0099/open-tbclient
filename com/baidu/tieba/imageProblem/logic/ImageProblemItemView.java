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
    protected LinearLayout aVj;
    protected TextView aVk;
    protected ImageView ahZ;
    protected TextView ajh;
    protected TextView fmA;
    protected LinearLayout fmz;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        KO();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        KO();
    }

    public void displayTip() {
        if (this.aVk != null) {
            this.aVk.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.aVk != null) {
            this.aVk.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.aVk != null) {
            this.aVk.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.ahZ.setVisibility(8);
    }

    public void displayArrow() {
        this.ahZ.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.ahZ.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fmz.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(e.C0210e.ds26);
            this.fmz.setLayoutParams(layoutParams);
            this.fmA.setText("");
            this.fmA.setVisibility(8);
            return;
        }
        this.fmz.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fmz.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(e.C0210e.ds10);
        this.fmz.setLayoutParams(layoutParams2);
        this.fmA.setText(str);
        this.fmA.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.ajh.setTextColor(getResources().getColor(e.d.cp_cont_b));
        } else if (i == 2) {
            this.ajh.setTextColor(getResources().getColor(e.d.cp_link_tip_d));
        } else if (i == 3) {
            this.ajh.setTextColor(getResources().getColor(e.d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.ajh.setText(str);
    }

    public void setText(int i) {
        this.ajh.setText(i);
    }

    public void setTip(String str) {
        this.aVk.setText(str);
    }

    public CharSequence getTip() {
        return this.aVk.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.aVk.setBackgroundDrawable(drawable);
    }

    protected void KO() {
        LayoutInflater.from(this.mContext).inflate(e.h.image_problem_item_view, (ViewGroup) this, true);
        this.aVj = (LinearLayout) findViewById(e.g.container);
        this.ajh = (TextView) findViewById(e.g.text);
        this.aVk = (TextView) findViewById(e.g.tip);
        this.ahZ = (ImageView) findViewById(e.g.arrow2);
        this.fmz = (LinearLayout) findViewById(e.g.ll_container);
        this.fmA = (TextView) findViewById(e.g.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, e.l.TbSettingView);
        String string = obtainStyledAttributes.getString(e.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(e.l.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(e.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(e.l.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.ajh.setText(string);
        }
        if (color > -1) {
            this.ajh.setTextColor(color);
        }
        if (string2 != null) {
            this.aVk.setText(string2);
        }
        if (color2 > -1) {
            this.aVk.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.aVj.setClickable(false);
        this.aVj.setFocusable(false);
        this.ahZ.setVisibility(4);
    }
}
