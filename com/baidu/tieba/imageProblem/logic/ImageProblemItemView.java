package com.baidu.tieba.imageProblem.logic;

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
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ImageProblemItemView extends FrameLayout {
    protected TextView alV;
    protected TextView alW;
    protected ImageView alZ;
    protected LinearLayout bRh;
    protected TextView bRi;
    protected LinearLayout container;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        zn();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        zn();
    }

    public void displayTip() {
        if (this.alW != null) {
            this.alW.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.alW != null) {
            this.alW.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.alW != null) {
            this.alW.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.alZ.setVisibility(8);
    }

    public void displayArrow() {
        this.alZ.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.alZ.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bRh.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(i.d.ds26);
            this.bRh.setLayoutParams(layoutParams);
            this.bRi.setText("");
            this.bRi.setVisibility(8);
            return;
        }
        this.bRh.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bRh.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(i.d.ds10);
        this.bRh.setLayoutParams(layoutParams2);
        this.bRi.setText(str);
        this.bRi.setVisibility(0);
    }

    public void setStatus(int i) {
        if (i == 1) {
            this.alV.setTextColor(getResources().getColor(i.c.cp_cont_b));
        } else if (i == 2) {
            this.alV.setTextColor(getResources().getColor(i.c.cp_link_tip_d));
        } else if (i == 3) {
            this.alV.setTextColor(getResources().getColor(i.c.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.alV.setText(str);
    }

    public void setText(int i) {
        this.alV.setText(i);
    }

    public void setTip(String str) {
        this.alW.setText(str);
    }

    public CharSequence getTip() {
        return this.alW.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.alW.setBackgroundDrawable(drawable);
    }

    protected void zn() {
        LayoutInflater.from(this.mContext).inflate(i.g.image_problem_item_view, (ViewGroup) this, true);
        this.container = (LinearLayout) findViewById(i.f.container);
        this.alV = (TextView) findViewById(i.f.text);
        this.alW = (TextView) findViewById(i.f.tip);
        this.alZ = (ImageView) findViewById(i.f.arrow2);
        this.bRh = (LinearLayout) findViewById(i.f.ll_container);
        this.bRi = (TextView) findViewById(i.f.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, i.j.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.alV.setText(string);
        }
        if (color > -1) {
            this.alV.setTextColor(color);
        }
        if (string2 != null) {
            this.alW.setText(string2);
        }
        if (color2 > -1) {
            this.alW.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.container.setClickable(false);
        this.container.setFocusable(false);
        this.alZ.setVisibility(4);
    }
}
