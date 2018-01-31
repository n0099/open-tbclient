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
    protected ImageView bmC;
    protected LinearLayout bmw;
    protected TextView bmx;
    protected TextView bmy;
    protected LinearLayout eRp;
    protected TextView eRq;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        IQ();
        d(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        IQ();
    }

    public void displayTip() {
        if (this.bmy != null) {
            this.bmy.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.bmy != null) {
            this.bmy.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.bmy != null) {
            this.bmy.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.bmC.setVisibility(8);
    }

    public void displayArrow() {
        this.bmC.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.bmC.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eRp.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(d.e.ds26);
            this.eRp.setLayoutParams(layoutParams);
            this.eRq.setText("");
            this.eRq.setVisibility(8);
            return;
        }
        this.eRp.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eRp.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(d.e.ds10);
        this.eRp.setLayoutParams(layoutParams2);
        this.eRq.setText(str);
        this.eRq.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.bmx.setTextColor(getResources().getColor(d.C0108d.cp_cont_b));
        } else if (i == 2) {
            this.bmx.setTextColor(getResources().getColor(d.C0108d.cp_link_tip_d));
        } else if (i == 3) {
            this.bmx.setTextColor(getResources().getColor(d.C0108d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.bmx.setText(str);
    }

    public void setText(int i) {
        this.bmx.setText(i);
    }

    public void setTip(String str) {
        this.bmy.setText(str);
    }

    public CharSequence getTip() {
        return this.bmy.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.bmy.setBackgroundDrawable(drawable);
    }

    protected void IQ() {
        LayoutInflater.from(this.mContext).inflate(d.h.image_problem_item_view, (ViewGroup) this, true);
        this.bmw = (LinearLayout) findViewById(d.g.container);
        this.bmx = (TextView) findViewById(d.g.text);
        this.bmy = (TextView) findViewById(d.g.tip);
        this.bmC = (ImageView) findViewById(d.g.arrow2);
        this.eRp = (LinearLayout) findViewById(d.g.ll_container);
        this.eRq = (TextView) findViewById(d.g.tv_help);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.bmx.setText(string);
        }
        if (color > -1) {
            this.bmx.setTextColor(color);
        }
        if (string2 != null) {
            this.bmy.setText(string2);
        }
        if (color2 > -1) {
            this.bmy.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.bmw.setClickable(false);
        this.bmw.setFocusable(false);
        this.bmC.setVisibility(4);
    }
}
