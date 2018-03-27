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
    protected LinearLayout boA;
    protected TextView boB;
    protected TextView boC;
    protected ImageView boG;
    protected LinearLayout eWO;
    protected TextView eWP;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Jw();
        d(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        Jw();
    }

    public void displayTip() {
        if (this.boC != null) {
            this.boC.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.boC != null) {
            this.boC.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.boC != null) {
            this.boC.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.boG.setVisibility(8);
    }

    public void displayArrow() {
        this.boG.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.boG.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eWO.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(d.e.ds26);
            this.eWO.setLayoutParams(layoutParams);
            this.eWP.setText("");
            this.eWP.setVisibility(8);
            return;
        }
        this.eWO.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eWO.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(d.e.ds10);
        this.eWO.setLayoutParams(layoutParams2);
        this.eWP.setText(str);
        this.eWP.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.boB.setTextColor(getResources().getColor(d.C0141d.cp_cont_b));
        } else if (i == 2) {
            this.boB.setTextColor(getResources().getColor(d.C0141d.cp_link_tip_d));
        } else if (i == 3) {
            this.boB.setTextColor(getResources().getColor(d.C0141d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.boB.setText(str);
    }

    public void setText(int i) {
        this.boB.setText(i);
    }

    public void setTip(String str) {
        this.boC.setText(str);
    }

    public CharSequence getTip() {
        return this.boC.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.boC.setBackgroundDrawable(drawable);
    }

    protected void Jw() {
        LayoutInflater.from(this.mContext).inflate(d.h.image_problem_item_view, (ViewGroup) this, true);
        this.boA = (LinearLayout) findViewById(d.g.container);
        this.boB = (TextView) findViewById(d.g.text);
        this.boC = (TextView) findViewById(d.g.tip);
        this.boG = (ImageView) findViewById(d.g.arrow2);
        this.eWO = (LinearLayout) findViewById(d.g.ll_container);
        this.eWP = (TextView) findViewById(d.g.tv_help);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.boB.setText(string);
        }
        if (color > -1) {
            this.boB.setTextColor(color);
        }
        if (string2 != null) {
            this.boC.setText(string2);
        }
        if (color2 > -1) {
            this.boC.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.boA.setClickable(false);
        this.boA.setFocusable(false);
        this.boG.setVisibility(4);
    }
}
