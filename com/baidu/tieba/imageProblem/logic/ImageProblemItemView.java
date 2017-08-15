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
    protected LinearLayout ayF;
    protected TextView ayG;
    protected TextView ayH;
    protected ImageView ayM;
    protected LinearLayout dJg;
    protected TextView dJh;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        BE();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        BE();
    }

    public void displayTip() {
        if (this.ayH != null) {
            this.ayH.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.ayH != null) {
            this.ayH.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.ayH != null) {
            this.ayH.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.ayM.setVisibility(8);
    }

    public void displayArrow() {
        this.ayM.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.ayM.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dJg.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(d.f.ds26);
            this.dJg.setLayoutParams(layoutParams);
            this.dJh.setText("");
            this.dJh.setVisibility(8);
            return;
        }
        this.dJg.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dJg.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(d.f.ds10);
        this.dJg.setLayoutParams(layoutParams2);
        this.dJh.setText(str);
        this.dJh.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.ayG.setTextColor(getResources().getColor(d.e.cp_cont_b));
        } else if (i == 2) {
            this.ayG.setTextColor(getResources().getColor(d.e.cp_link_tip_d));
        } else if (i == 3) {
            this.ayG.setTextColor(getResources().getColor(d.e.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.ayG.setText(str);
    }

    public void setText(int i) {
        this.ayG.setText(i);
    }

    public void setTip(String str) {
        this.ayH.setText(str);
    }

    public CharSequence getTip() {
        return this.ayH.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.ayH.setBackgroundDrawable(drawable);
    }

    protected void BE() {
        LayoutInflater.from(this.mContext).inflate(d.j.image_problem_item_view, (ViewGroup) this, true);
        this.ayF = (LinearLayout) findViewById(d.h.container);
        this.ayG = (TextView) findViewById(d.h.text);
        this.ayH = (TextView) findViewById(d.h.tip);
        this.ayM = (ImageView) findViewById(d.h.arrow2);
        this.dJg = (LinearLayout) findViewById(d.h.ll_container);
        this.dJh = (TextView) findViewById(d.h.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.n.TbSettingView);
        String string = obtainStyledAttributes.getString(d.n.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.n.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(d.n.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.n.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.ayG.setText(string);
        }
        if (color > -1) {
            this.ayG.setTextColor(color);
        }
        if (string2 != null) {
            this.ayH.setText(string2);
        }
        if (color2 > -1) {
            this.ayH.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.ayF.setClickable(false);
        this.ayF.setFocusable(false);
        this.ayM.setVisibility(4);
    }
}
