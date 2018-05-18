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
    protected LinearLayout aza;
    protected TextView azb;
    protected TextView azc;
    protected ImageView azg;
    protected LinearLayout esB;
    protected TextView esC;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Ca();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        Ca();
    }

    public void displayTip() {
        if (this.azc != null) {
            this.azc.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.azc != null) {
            this.azc.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.azc != null) {
            this.azc.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.azg.setVisibility(8);
    }

    public void displayArrow() {
        this.azg.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.azg.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.esB.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(d.e.ds26);
            this.esB.setLayoutParams(layoutParams);
            this.esC.setText("");
            this.esC.setVisibility(8);
            return;
        }
        this.esB.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.esB.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(d.e.ds10);
        this.esB.setLayoutParams(layoutParams2);
        this.esC.setText(str);
        this.esC.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.azb.setTextColor(getResources().getColor(d.C0126d.cp_cont_b));
        } else if (i == 2) {
            this.azb.setTextColor(getResources().getColor(d.C0126d.cp_link_tip_d));
        } else if (i == 3) {
            this.azb.setTextColor(getResources().getColor(d.C0126d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.azb.setText(str);
    }

    public void setText(int i) {
        this.azb.setText(i);
    }

    public void setTip(String str) {
        this.azc.setText(str);
    }

    public CharSequence getTip() {
        return this.azc.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.azc.setBackgroundDrawable(drawable);
    }

    protected void Ca() {
        LayoutInflater.from(this.mContext).inflate(d.i.image_problem_item_view, (ViewGroup) this, true);
        this.aza = (LinearLayout) findViewById(d.g.container);
        this.azb = (TextView) findViewById(d.g.text);
        this.azc = (TextView) findViewById(d.g.tip);
        this.azg = (ImageView) findViewById(d.g.arrow2);
        this.esB = (LinearLayout) findViewById(d.g.ll_container);
        this.esC = (TextView) findViewById(d.g.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.m.TbSettingView);
        String string = obtainStyledAttributes.getString(d.m.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.m.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(d.m.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.m.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.azb.setText(string);
        }
        if (color > -1) {
            this.azb.setTextColor(color);
        }
        if (string2 != null) {
            this.azc.setText(string2);
        }
        if (color2 > -1) {
            this.azc.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.aza.setClickable(false);
        this.aza.setFocusable(false);
        this.azg.setVisibility(4);
    }
}
