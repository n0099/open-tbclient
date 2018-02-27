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
    protected ImageView boD;
    protected LinearLayout box;
    protected TextView boy;
    protected TextView boz;
    protected LinearLayout eWA;
    protected TextView eWB;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Jv();
        d(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        Jv();
    }

    public void displayTip() {
        if (this.boz != null) {
            this.boz.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.boz != null) {
            this.boz.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.boz != null) {
            this.boz.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.boD.setVisibility(8);
    }

    public void displayArrow() {
        this.boD.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.boD.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eWA.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(d.e.ds26);
            this.eWA.setLayoutParams(layoutParams);
            this.eWB.setText("");
            this.eWB.setVisibility(8);
            return;
        }
        this.eWA.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eWA.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(d.e.ds10);
        this.eWA.setLayoutParams(layoutParams2);
        this.eWB.setText(str);
        this.eWB.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.boy.setTextColor(getResources().getColor(d.C0141d.cp_cont_b));
        } else if (i == 2) {
            this.boy.setTextColor(getResources().getColor(d.C0141d.cp_link_tip_d));
        } else if (i == 3) {
            this.boy.setTextColor(getResources().getColor(d.C0141d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.boy.setText(str);
    }

    public void setText(int i) {
        this.boy.setText(i);
    }

    public void setTip(String str) {
        this.boz.setText(str);
    }

    public CharSequence getTip() {
        return this.boz.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.boz.setBackgroundDrawable(drawable);
    }

    protected void Jv() {
        LayoutInflater.from(this.mContext).inflate(d.h.image_problem_item_view, (ViewGroup) this, true);
        this.box = (LinearLayout) findViewById(d.g.container);
        this.boy = (TextView) findViewById(d.g.text);
        this.boz = (TextView) findViewById(d.g.tip);
        this.boD = (ImageView) findViewById(d.g.arrow2);
        this.eWA = (LinearLayout) findViewById(d.g.ll_container);
        this.eWB = (TextView) findViewById(d.g.tv_help);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.boy.setText(string);
        }
        if (color > -1) {
            this.boy.setTextColor(color);
        }
        if (string2 != null) {
            this.boz.setText(string2);
        }
        if (color2 > -1) {
            this.boz.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.box.setClickable(false);
        this.box.setFocusable(false);
        this.boD.setVisibility(4);
    }
}
