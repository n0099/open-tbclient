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
    protected LinearLayout ayE;
    protected TextView ayF;
    protected TextView ayG;
    protected ImageView ayL;
    protected LinearLayout dHk;
    protected TextView dHl;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        BE();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        BE();
    }

    public void displayTip() {
        if (this.ayG != null) {
            this.ayG.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.ayG != null) {
            this.ayG.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.ayG != null) {
            this.ayG.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.ayL.setVisibility(8);
    }

    public void displayArrow() {
        this.ayL.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.ayL.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dHk.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(d.f.ds26);
            this.dHk.setLayoutParams(layoutParams);
            this.dHl.setText("");
            this.dHl.setVisibility(8);
            return;
        }
        this.dHk.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dHk.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(d.f.ds10);
        this.dHk.setLayoutParams(layoutParams2);
        this.dHl.setText(str);
        this.dHl.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.ayF.setTextColor(getResources().getColor(d.e.cp_cont_b));
        } else if (i == 2) {
            this.ayF.setTextColor(getResources().getColor(d.e.cp_link_tip_d));
        } else if (i == 3) {
            this.ayF.setTextColor(getResources().getColor(d.e.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.ayF.setText(str);
    }

    public void setText(int i) {
        this.ayF.setText(i);
    }

    public void setTip(String str) {
        this.ayG.setText(str);
    }

    public CharSequence getTip() {
        return this.ayG.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.ayG.setBackgroundDrawable(drawable);
    }

    protected void BE() {
        LayoutInflater.from(this.mContext).inflate(d.j.image_problem_item_view, (ViewGroup) this, true);
        this.ayE = (LinearLayout) findViewById(d.h.container);
        this.ayF = (TextView) findViewById(d.h.text);
        this.ayG = (TextView) findViewById(d.h.tip);
        this.ayL = (ImageView) findViewById(d.h.arrow2);
        this.dHk = (LinearLayout) findViewById(d.h.ll_container);
        this.dHl = (TextView) findViewById(d.h.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.n.TbSettingView);
        String string = obtainStyledAttributes.getString(d.n.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.n.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(d.n.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.n.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.ayF.setText(string);
        }
        if (color > -1) {
            this.ayF.setTextColor(color);
        }
        if (string2 != null) {
            this.ayG.setText(string2);
        }
        if (color2 > -1) {
            this.ayG.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.ayE.setClickable(false);
        this.ayE.setFocusable(false);
        this.ayL.setVisibility(4);
    }
}
