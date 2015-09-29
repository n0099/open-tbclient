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
    protected TextView alP;
    protected TextView alQ;
    protected ImageView alT;
    protected LinearLayout bQB;
    protected TextView bQC;
    protected LinearLayout container;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        zl();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        zl();
    }

    public void displayTip() {
        if (this.alQ != null) {
            this.alQ.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.alQ != null) {
            this.alQ.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.alQ != null) {
            this.alQ.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.alT.setVisibility(8);
    }

    public void displayArrow() {
        this.alT.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.alT.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bQB.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(i.d.ds26);
            this.bQB.setLayoutParams(layoutParams);
            this.bQC.setText("");
            this.bQC.setVisibility(8);
            return;
        }
        this.bQB.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bQB.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(i.d.ds10);
        this.bQB.setLayoutParams(layoutParams2);
        this.bQC.setText(str);
        this.bQC.setVisibility(0);
    }

    public void setStatus(int i) {
        if (i == 1) {
            this.alP.setTextColor(getResources().getColor(i.c.cp_cont_b));
        } else if (i == 2) {
            this.alP.setTextColor(getResources().getColor(i.c.cp_link_tip_d));
        } else if (i == 3) {
            this.alP.setTextColor(getResources().getColor(i.c.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.alP.setText(str);
    }

    public void setText(int i) {
        this.alP.setText(i);
    }

    public void setTip(String str) {
        this.alQ.setText(str);
    }

    public CharSequence getTip() {
        return this.alQ.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.alQ.setBackgroundDrawable(drawable);
    }

    protected void zl() {
        LayoutInflater.from(this.mContext).inflate(i.g.image_problem_item_view, (ViewGroup) this, true);
        this.container = (LinearLayout) findViewById(i.f.container);
        this.alP = (TextView) findViewById(i.f.text);
        this.alQ = (TextView) findViewById(i.f.tip);
        this.alT = (ImageView) findViewById(i.f.arrow2);
        this.bQB = (LinearLayout) findViewById(i.f.ll_container);
        this.bQC = (TextView) findViewById(i.f.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, i.j.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.alP.setText(string);
        }
        if (color > -1) {
            this.alP.setTextColor(color);
        }
        if (string2 != null) {
            this.alQ.setText(string2);
        }
        if (color2 > -1) {
            this.alQ.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.container.setClickable(false);
        this.container.setFocusable(false);
        this.alT.setVisibility(4);
    }
}
