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
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class ImageProblemItemView extends FrameLayout {
    protected LinearLayout aLG;
    protected TextView aLH;
    protected TextView aLI;
    protected ImageView aLL;
    protected LinearLayout eSS;
    protected TextView eST;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Hh();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        Hh();
    }

    public void displayTip() {
        if (this.aLI != null) {
            this.aLI.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.aLI != null) {
            this.aLI.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.aLI != null) {
            this.aLI.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.aLL.setVisibility(8);
    }

    public void displayArrow() {
        this.aLL.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.aLL.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eSS.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(e.C0141e.ds26);
            this.eSS.setLayoutParams(layoutParams);
            this.eST.setText("");
            this.eST.setVisibility(8);
            return;
        }
        this.eSS.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eSS.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(e.C0141e.ds10);
        this.eSS.setLayoutParams(layoutParams2);
        this.eST.setText(str);
        this.eST.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.aLH.setTextColor(getResources().getColor(e.d.cp_cont_b));
        } else if (i == 2) {
            this.aLH.setTextColor(getResources().getColor(e.d.cp_link_tip_d));
        } else if (i == 3) {
            this.aLH.setTextColor(getResources().getColor(e.d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.aLH.setText(str);
    }

    public void setText(int i) {
        this.aLH.setText(i);
    }

    public void setTip(String str) {
        this.aLI.setText(str);
    }

    public CharSequence getTip() {
        return this.aLI.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.aLI.setBackgroundDrawable(drawable);
    }

    protected void Hh() {
        LayoutInflater.from(this.mContext).inflate(e.h.image_problem_item_view, (ViewGroup) this, true);
        this.aLG = (LinearLayout) findViewById(e.g.container);
        this.aLH = (TextView) findViewById(e.g.text);
        this.aLI = (TextView) findViewById(e.g.tip);
        this.aLL = (ImageView) findViewById(e.g.arrow2);
        this.eSS = (LinearLayout) findViewById(e.g.ll_container);
        this.eST = (TextView) findViewById(e.g.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, e.l.TbSettingView);
        String string = obtainStyledAttributes.getString(e.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(e.l.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(e.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(e.l.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.aLH.setText(string);
        }
        if (color > -1) {
            this.aLH.setTextColor(color);
        }
        if (string2 != null) {
            this.aLI.setText(string2);
        }
        if (color2 > -1) {
            this.aLI.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.aLG.setClickable(false);
        this.aLG.setFocusable(false);
        this.aLL.setVisibility(4);
    }
}
