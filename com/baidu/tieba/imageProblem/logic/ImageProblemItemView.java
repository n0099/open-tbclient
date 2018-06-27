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
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ImageProblemItemView extends FrameLayout {
    protected LinearLayout aIs;
    protected TextView aIt;
    protected TextView aIu;
    protected ImageView aIy;
    protected LinearLayout eHI;
    protected TextView eHJ;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        FV();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        FV();
    }

    public void displayTip() {
        if (this.aIu != null) {
            this.aIu.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.aIu != null) {
            this.aIu.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.aIu != null) {
            this.aIu.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.aIy.setVisibility(8);
    }

    public void displayArrow() {
        this.aIy.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.aIy.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eHI.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(d.e.ds26);
            this.eHI.setLayoutParams(layoutParams);
            this.eHJ.setText("");
            this.eHJ.setVisibility(8);
            return;
        }
        this.eHI.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eHI.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(d.e.ds10);
        this.eHI.setLayoutParams(layoutParams2);
        this.eHJ.setText(str);
        this.eHJ.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.aIt.setTextColor(getResources().getColor(d.C0142d.cp_cont_b));
        } else if (i == 2) {
            this.aIt.setTextColor(getResources().getColor(d.C0142d.cp_link_tip_d));
        } else if (i == 3) {
            this.aIt.setTextColor(getResources().getColor(d.C0142d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.aIt.setText(str);
    }

    public void setText(int i) {
        this.aIt.setText(i);
    }

    public void setTip(String str) {
        this.aIu.setText(str);
    }

    public CharSequence getTip() {
        return this.aIu.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.aIu.setBackgroundDrawable(drawable);
    }

    protected void FV() {
        LayoutInflater.from(this.mContext).inflate(d.i.image_problem_item_view, (ViewGroup) this, true);
        this.aIs = (LinearLayout) findViewById(d.g.container);
        this.aIt = (TextView) findViewById(d.g.text);
        this.aIu = (TextView) findViewById(d.g.tip);
        this.aIy = (ImageView) findViewById(d.g.arrow2);
        this.eHI = (LinearLayout) findViewById(d.g.ll_container);
        this.eHJ = (TextView) findViewById(d.g.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.m.TbSettingView);
        String string = obtainStyledAttributes.getString(d.m.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.m.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(d.m.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.m.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.aIt.setText(string);
        }
        if (color > -1) {
            this.aIt.setTextColor(color);
        }
        if (string2 != null) {
            this.aIu.setText(string2);
        }
        if (color2 > -1) {
            this.aIu.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.aIs.setClickable(false);
        this.aIs.setFocusable(false);
        this.aIy.setVisibility(4);
    }
}
