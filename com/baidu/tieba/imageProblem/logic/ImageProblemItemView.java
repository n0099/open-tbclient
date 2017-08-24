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
    protected LinearLayout ayG;
    protected TextView ayH;
    protected TextView ayI;
    protected ImageView ayN;
    protected LinearLayout dJg;
    protected TextView dJh;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        BE();
        b(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        BE();
    }

    public void displayTip() {
        if (this.ayI != null) {
            this.ayI.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.ayI != null) {
            this.ayI.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.ayI != null) {
            this.ayI.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.ayN.setVisibility(8);
    }

    public void displayArrow() {
        this.ayN.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.ayN.setImageResource(i);
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
            this.ayH.setTextColor(getResources().getColor(d.e.cp_cont_b));
        } else if (i == 2) {
            this.ayH.setTextColor(getResources().getColor(d.e.cp_link_tip_d));
        } else if (i == 3) {
            this.ayH.setTextColor(getResources().getColor(d.e.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.ayH.setText(str);
    }

    public void setText(int i) {
        this.ayH.setText(i);
    }

    public void setTip(String str) {
        this.ayI.setText(str);
    }

    public CharSequence getTip() {
        return this.ayI.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.ayI.setBackgroundDrawable(drawable);
    }

    protected void BE() {
        LayoutInflater.from(this.mContext).inflate(d.j.image_problem_item_view, (ViewGroup) this, true);
        this.ayG = (LinearLayout) findViewById(d.h.container);
        this.ayH = (TextView) findViewById(d.h.text);
        this.ayI = (TextView) findViewById(d.h.tip);
        this.ayN = (ImageView) findViewById(d.h.arrow2);
        this.dJg = (LinearLayout) findViewById(d.h.ll_container);
        this.dJh = (TextView) findViewById(d.h.tv_help);
    }

    protected void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.n.TbSettingView);
        String string = obtainStyledAttributes.getString(d.n.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.n.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(d.n.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.n.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.ayH.setText(string);
        }
        if (color > -1) {
            this.ayH.setTextColor(color);
        }
        if (string2 != null) {
            this.ayI.setText(string2);
        }
        if (color2 > -1) {
            this.ayI.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.ayG.setClickable(false);
        this.ayG.setFocusable(false);
        this.ayN.setVisibility(4);
    }
}
