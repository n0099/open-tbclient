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
    protected LinearLayout axr;
    protected TextView axs;
    protected TextView axt;
    protected ImageView axx;
    protected LinearLayout dUp;
    protected TextView dUq;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Bm();
        b(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        Bm();
    }

    public void displayTip() {
        if (this.axt != null) {
            this.axt.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.axt != null) {
            this.axt.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.axt != null) {
            this.axt.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.axx.setVisibility(8);
    }

    public void displayArrow() {
        this.axx.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.axx.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dUp.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(d.e.ds26);
            this.dUp.setLayoutParams(layoutParams);
            this.dUq.setText("");
            this.dUq.setVisibility(8);
            return;
        }
        this.dUp.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dUp.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(d.e.ds10);
        this.dUp.setLayoutParams(layoutParams2);
        this.dUq.setText(str);
        this.dUq.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.axs.setTextColor(getResources().getColor(d.C0080d.cp_cont_b));
        } else if (i == 2) {
            this.axs.setTextColor(getResources().getColor(d.C0080d.cp_link_tip_d));
        } else if (i == 3) {
            this.axs.setTextColor(getResources().getColor(d.C0080d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.axs.setText(str);
    }

    public void setText(int i) {
        this.axs.setText(i);
    }

    public void setTip(String str) {
        this.axt.setText(str);
    }

    public CharSequence getTip() {
        return this.axt.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.axt.setBackgroundDrawable(drawable);
    }

    protected void Bm() {
        LayoutInflater.from(this.mContext).inflate(d.h.image_problem_item_view, (ViewGroup) this, true);
        this.axr = (LinearLayout) findViewById(d.g.container);
        this.axs = (TextView) findViewById(d.g.text);
        this.axt = (TextView) findViewById(d.g.tip);
        this.axx = (ImageView) findViewById(d.g.arrow2);
        this.dUp = (LinearLayout) findViewById(d.g.ll_container);
        this.dUq = (TextView) findViewById(d.g.tv_help);
    }

    protected void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.axs.setText(string);
        }
        if (color > -1) {
            this.axs.setTextColor(color);
        }
        if (string2 != null) {
            this.axt.setText(string2);
        }
        if (color2 > -1) {
            this.axt.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.axr.setClickable(false);
        this.axr.setFocusable(false);
        this.axx.setVisibility(4);
    }
}
