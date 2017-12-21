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
    protected LinearLayout aya;
    protected TextView ayb;
    protected TextView ayc;
    protected ImageView ayg;
    protected LinearLayout edo;
    protected TextView edp;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Bx();
        b(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        Bx();
    }

    public void displayTip() {
        if (this.ayc != null) {
            this.ayc.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.ayc != null) {
            this.ayc.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.ayc != null) {
            this.ayc.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.ayg.setVisibility(8);
    }

    public void displayArrow() {
        this.ayg.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.ayg.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.edo.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(d.e.ds26);
            this.edo.setLayoutParams(layoutParams);
            this.edp.setText("");
            this.edp.setVisibility(8);
            return;
        }
        this.edo.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.edo.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(d.e.ds10);
        this.edo.setLayoutParams(layoutParams2);
        this.edp.setText(str);
        this.edp.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.ayb.setTextColor(getResources().getColor(d.C0095d.cp_cont_b));
        } else if (i == 2) {
            this.ayb.setTextColor(getResources().getColor(d.C0095d.cp_link_tip_d));
        } else if (i == 3) {
            this.ayb.setTextColor(getResources().getColor(d.C0095d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.ayb.setText(str);
    }

    public void setText(int i) {
        this.ayb.setText(i);
    }

    public void setTip(String str) {
        this.ayc.setText(str);
    }

    public CharSequence getTip() {
        return this.ayc.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.ayc.setBackgroundDrawable(drawable);
    }

    protected void Bx() {
        LayoutInflater.from(this.mContext).inflate(d.h.image_problem_item_view, (ViewGroup) this, true);
        this.aya = (LinearLayout) findViewById(d.g.container);
        this.ayb = (TextView) findViewById(d.g.text);
        this.ayc = (TextView) findViewById(d.g.tip);
        this.ayg = (ImageView) findViewById(d.g.arrow2);
        this.edo = (LinearLayout) findViewById(d.g.ll_container);
        this.edp = (TextView) findViewById(d.g.tv_help);
    }

    protected void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.ayb.setText(string);
        }
        if (color > -1) {
            this.ayb.setTextColor(color);
        }
        if (string2 != null) {
            this.ayc.setText(string2);
        }
        if (color2 > -1) {
            this.ayc.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.aya.setClickable(false);
        this.aya.setFocusable(false);
        this.ayg.setVisibility(4);
    }
}
