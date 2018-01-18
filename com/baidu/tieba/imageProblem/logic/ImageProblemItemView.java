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
    protected LinearLayout bmo;
    protected TextView bmp;
    protected TextView bmq;
    protected ImageView bmu;
    protected LinearLayout eQU;
    protected TextView eQV;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        IO();
        d(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        IO();
    }

    public void displayTip() {
        if (this.bmq != null) {
            this.bmq.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.bmq != null) {
            this.bmq.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.bmq != null) {
            this.bmq.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.bmu.setVisibility(8);
    }

    public void displayArrow() {
        this.bmu.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.bmu.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eQU.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(d.e.ds26);
            this.eQU.setLayoutParams(layoutParams);
            this.eQV.setText("");
            this.eQV.setVisibility(8);
            return;
        }
        this.eQU.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eQU.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(d.e.ds10);
        this.eQU.setLayoutParams(layoutParams2);
        this.eQV.setText(str);
        this.eQV.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.bmp.setTextColor(getResources().getColor(d.C0107d.cp_cont_b));
        } else if (i == 2) {
            this.bmp.setTextColor(getResources().getColor(d.C0107d.cp_link_tip_d));
        } else if (i == 3) {
            this.bmp.setTextColor(getResources().getColor(d.C0107d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.bmp.setText(str);
    }

    public void setText(int i) {
        this.bmp.setText(i);
    }

    public void setTip(String str) {
        this.bmq.setText(str);
    }

    public CharSequence getTip() {
        return this.bmq.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.bmq.setBackgroundDrawable(drawable);
    }

    protected void IO() {
        LayoutInflater.from(this.mContext).inflate(d.h.image_problem_item_view, (ViewGroup) this, true);
        this.bmo = (LinearLayout) findViewById(d.g.container);
        this.bmp = (TextView) findViewById(d.g.text);
        this.bmq = (TextView) findViewById(d.g.tip);
        this.bmu = (ImageView) findViewById(d.g.arrow2);
        this.eQU = (LinearLayout) findViewById(d.g.ll_container);
        this.eQV = (TextView) findViewById(d.g.tv_help);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.bmp.setText(string);
        }
        if (color > -1) {
            this.bmp.setTextColor(color);
        }
        if (string2 != null) {
            this.bmq.setText(string2);
        }
        if (color2 > -1) {
            this.bmq.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.bmo.setClickable(false);
        this.bmo.setFocusable(false);
        this.bmu.setVisibility(4);
    }
}
