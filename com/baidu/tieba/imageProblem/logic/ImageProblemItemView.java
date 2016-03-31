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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ImageProblemItemView extends FrameLayout {
    protected LinearLayout aqr;
    protected TextView aqs;
    protected TextView aqt;
    protected ImageView aqw;
    protected LinearLayout cAA;
    protected TextView cAB;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        BO();
        d(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        BO();
    }

    public void displayTip() {
        if (this.aqt != null) {
            this.aqt.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.aqt != null) {
            this.aqt.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.aqt != null) {
            this.aqt.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.aqw.setVisibility(8);
    }

    public void displayArrow() {
        this.aqw.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.aqw.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cAA.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(t.e.ds26);
            this.cAA.setLayoutParams(layoutParams);
            this.cAB.setText("");
            this.cAB.setVisibility(8);
            return;
        }
        this.cAA.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cAA.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(t.e.ds10);
        this.cAA.setLayoutParams(layoutParams2);
        this.cAB.setText(str);
        this.cAB.setVisibility(0);
    }

    public void setStatus(int i) {
        if (i == 1) {
            this.aqs.setTextColor(getResources().getColor(t.d.cp_cont_b));
        } else if (i == 2) {
            this.aqs.setTextColor(getResources().getColor(t.d.cp_link_tip_d));
        } else if (i == 3) {
            this.aqs.setTextColor(getResources().getColor(t.d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.aqs.setText(str);
    }

    public void setText(int i) {
        this.aqs.setText(i);
    }

    public void setTip(String str) {
        this.aqt.setText(str);
    }

    public CharSequence getTip() {
        return this.aqt.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.aqt.setBackgroundDrawable(drawable);
    }

    protected void BO() {
        LayoutInflater.from(this.mContext).inflate(t.h.image_problem_item_view, (ViewGroup) this, true);
        this.aqr = (LinearLayout) findViewById(t.g.container);
        this.aqs = (TextView) findViewById(t.g.text);
        this.aqt = (TextView) findViewById(t.g.tip);
        this.aqw = (ImageView) findViewById(t.g.arrow2);
        this.cAA = (LinearLayout) findViewById(t.g.ll_container);
        this.cAB = (TextView) findViewById(t.g.tv_help);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, t.l.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.aqs.setText(string);
        }
        if (color > -1) {
            this.aqs.setTextColor(color);
        }
        if (string2 != null) {
            this.aqt.setText(string2);
        }
        if (color2 > -1) {
            this.aqt.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.aqr.setClickable(false);
        this.aqr.setFocusable(false);
        this.aqw.setVisibility(4);
    }
}
