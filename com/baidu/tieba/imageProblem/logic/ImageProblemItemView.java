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
    protected TextView alM;
    protected TextView alN;
    protected ImageView alQ;
    protected LinearLayout bMs;
    protected TextView bMt;
    protected LinearLayout container;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        zm();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        zm();
    }

    public void displayTip() {
        if (this.alN != null) {
            this.alN.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.alN != null) {
            this.alN.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.alN != null) {
            this.alN.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.alQ.setVisibility(8);
    }

    public void displayArrow() {
        this.alQ.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.alQ.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bMs.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(i.d.ds26);
            this.bMs.setLayoutParams(layoutParams);
            this.bMt.setText("");
            this.bMt.setVisibility(8);
            return;
        }
        this.bMs.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bMs.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(i.d.ds10);
        this.bMs.setLayoutParams(layoutParams2);
        this.bMt.setText(str);
        this.bMt.setVisibility(0);
    }

    public void setStatus(int i) {
        if (i == 1) {
            this.alM.setTextColor(getResources().getColor(i.c.cp_cont_b));
        } else if (i == 2) {
            this.alM.setTextColor(getResources().getColor(i.c.cp_link_tip_d));
        } else if (i == 3) {
            this.alM.setTextColor(getResources().getColor(i.c.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.alM.setText(str);
    }

    public void setText(int i) {
        this.alM.setText(i);
    }

    public void setTip(String str) {
        this.alN.setText(str);
    }

    public CharSequence getTip() {
        return this.alN.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.alN.setBackgroundDrawable(drawable);
    }

    protected void zm() {
        LayoutInflater.from(this.mContext).inflate(i.g.image_problem_item_view, (ViewGroup) this, true);
        this.container = (LinearLayout) findViewById(i.f.container);
        this.alM = (TextView) findViewById(i.f.text);
        this.alN = (TextView) findViewById(i.f.tip);
        this.alQ = (ImageView) findViewById(i.f.arrow2);
        this.bMs = (LinearLayout) findViewById(i.f.ll_container);
        this.bMt = (TextView) findViewById(i.f.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, i.k.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.alM.setText(string);
        }
        if (color > -1) {
            this.alM.setTextColor(color);
        }
        if (string2 != null) {
            this.alN.setText(string2);
        }
        if (color2 > -1) {
            this.alN.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.container.setClickable(false);
        this.container.setFocusable(false);
        this.alQ.setVisibility(4);
    }
}
