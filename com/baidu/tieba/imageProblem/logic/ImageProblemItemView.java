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
    protected ImageView aHB;
    protected LinearLayout aHv;
    protected TextView aHw;
    protected TextView aHx;
    protected LinearLayout eDS;
    protected TextView eDT;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        FD();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        FD();
    }

    public void displayTip() {
        if (this.aHx != null) {
            this.aHx.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.aHx != null) {
            this.aHx.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.aHx != null) {
            this.aHx.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.aHB.setVisibility(8);
    }

    public void displayArrow() {
        this.aHB.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.aHB.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eDS.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(d.e.ds26);
            this.eDS.setLayoutParams(layoutParams);
            this.eDT.setText("");
            this.eDT.setVisibility(8);
            return;
        }
        this.eDS.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eDS.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(d.e.ds10);
        this.eDS.setLayoutParams(layoutParams2);
        this.eDT.setText(str);
        this.eDT.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.aHw.setTextColor(getResources().getColor(d.C0141d.cp_cont_b));
        } else if (i == 2) {
            this.aHw.setTextColor(getResources().getColor(d.C0141d.cp_link_tip_d));
        } else if (i == 3) {
            this.aHw.setTextColor(getResources().getColor(d.C0141d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.aHw.setText(str);
    }

    public void setText(int i) {
        this.aHw.setText(i);
    }

    public void setTip(String str) {
        this.aHx.setText(str);
    }

    public CharSequence getTip() {
        return this.aHx.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.aHx.setBackgroundDrawable(drawable);
    }

    protected void FD() {
        LayoutInflater.from(this.mContext).inflate(d.i.image_problem_item_view, (ViewGroup) this, true);
        this.aHv = (LinearLayout) findViewById(d.g.container);
        this.aHw = (TextView) findViewById(d.g.text);
        this.aHx = (TextView) findViewById(d.g.tip);
        this.aHB = (ImageView) findViewById(d.g.arrow2);
        this.eDS = (LinearLayout) findViewById(d.g.ll_container);
        this.eDT = (TextView) findViewById(d.g.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.m.TbSettingView);
        String string = obtainStyledAttributes.getString(d.m.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.m.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(d.m.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.m.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.aHw.setText(string);
        }
        if (color > -1) {
            this.aHw.setTextColor(color);
        }
        if (string2 != null) {
            this.aHx.setText(string2);
        }
        if (color2 > -1) {
            this.aHx.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.aHv.setClickable(false);
        this.aHv.setFocusable(false);
        this.aHB.setVisibility(4);
    }
}
