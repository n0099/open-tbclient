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
    protected ImageView anC;
    protected TextView any;
    protected TextView anz;
    protected LinearLayout bMZ;
    protected TextView bNa;
    protected LinearLayout container;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        zz();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        zz();
    }

    public void displayTip() {
        if (this.anz != null) {
            this.anz.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.anz != null) {
            this.anz.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.anz != null) {
            this.anz.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.anC.setVisibility(8);
    }

    public void displayArrow() {
        this.anC.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.anC.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bMZ.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(i.d.ds26);
            this.bMZ.setLayoutParams(layoutParams);
            this.bNa.setText("");
            this.bNa.setVisibility(8);
            return;
        }
        this.bMZ.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bMZ.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(i.d.ds10);
        this.bMZ.setLayoutParams(layoutParams2);
        this.bNa.setText(str);
        this.bNa.setVisibility(0);
    }

    public void setStatus(int i) {
        if (i == 1) {
            this.any.setTextColor(getResources().getColor(i.c.cp_cont_b));
        } else if (i == 2) {
            this.any.setTextColor(getResources().getColor(i.c.cp_link_tip_d));
        } else if (i == 3) {
            this.any.setTextColor(getResources().getColor(i.c.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.any.setText(str);
    }

    public void setText(int i) {
        this.any.setText(i);
    }

    public void setTip(String str) {
        this.anz.setText(str);
    }

    public CharSequence getTip() {
        return this.anz.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.anz.setBackgroundDrawable(drawable);
    }

    protected void zz() {
        LayoutInflater.from(this.mContext).inflate(i.g.image_problem_item_view, (ViewGroup) this, true);
        this.container = (LinearLayout) findViewById(i.f.container);
        this.any = (TextView) findViewById(i.f.text);
        this.anz = (TextView) findViewById(i.f.tip);
        this.anC = (ImageView) findViewById(i.f.arrow2);
        this.bMZ = (LinearLayout) findViewById(i.f.ll_container);
        this.bNa = (TextView) findViewById(i.f.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, i.j.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.any.setText(string);
        }
        if (color > -1) {
            this.any.setTextColor(color);
        }
        if (string2 != null) {
            this.anz.setText(string2);
        }
        if (color2 > -1) {
            this.anz.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.container.setClickable(false);
        this.container.setFocusable(false);
        this.anC.setVisibility(4);
    }
}
