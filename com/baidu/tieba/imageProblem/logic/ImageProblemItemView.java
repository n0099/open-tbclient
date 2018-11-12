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
    protected LinearLayout aQY;
    protected TextView aQZ;
    protected TextView aRa;
    protected ImageView aRd;
    protected LinearLayout fbV;
    protected TextView fbW;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Ju();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        Ju();
    }

    public void displayTip() {
        if (this.aRa != null) {
            this.aRa.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.aRa != null) {
            this.aRa.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.aRa != null) {
            this.aRa.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.aRd.setVisibility(8);
    }

    public void displayArrow() {
        this.aRd.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.aRd.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fbV.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(e.C0200e.ds26);
            this.fbV.setLayoutParams(layoutParams);
            this.fbW.setText("");
            this.fbW.setVisibility(8);
            return;
        }
        this.fbV.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fbV.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(e.C0200e.ds10);
        this.fbV.setLayoutParams(layoutParams2);
        this.fbW.setText(str);
        this.fbW.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.aQZ.setTextColor(getResources().getColor(e.d.cp_cont_b));
        } else if (i == 2) {
            this.aQZ.setTextColor(getResources().getColor(e.d.cp_link_tip_d));
        } else if (i == 3) {
            this.aQZ.setTextColor(getResources().getColor(e.d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.aQZ.setText(str);
    }

    public void setText(int i) {
        this.aQZ.setText(i);
    }

    public void setTip(String str) {
        this.aRa.setText(str);
    }

    public CharSequence getTip() {
        return this.aRa.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.aRa.setBackgroundDrawable(drawable);
    }

    protected void Ju() {
        LayoutInflater.from(this.mContext).inflate(e.h.image_problem_item_view, (ViewGroup) this, true);
        this.aQY = (LinearLayout) findViewById(e.g.container);
        this.aQZ = (TextView) findViewById(e.g.text);
        this.aRa = (TextView) findViewById(e.g.tip);
        this.aRd = (ImageView) findViewById(e.g.arrow2);
        this.fbV = (LinearLayout) findViewById(e.g.ll_container);
        this.fbW = (TextView) findViewById(e.g.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, e.l.TbSettingView);
        String string = obtainStyledAttributes.getString(e.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(e.l.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(e.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(e.l.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.aQZ.setText(string);
        }
        if (color > -1) {
            this.aQZ.setTextColor(color);
        }
        if (string2 != null) {
            this.aRa.setText(string2);
        }
        if (color2 > -1) {
            this.aRa.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.aQY.setClickable(false);
        this.aQY.setFocusable(false);
        this.aRd.setVisibility(4);
    }
}
