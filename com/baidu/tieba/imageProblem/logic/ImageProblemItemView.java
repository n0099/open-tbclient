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
    protected LinearLayout axj;
    protected TextView axk;
    protected TextView axl;
    protected ImageView axp;
    protected LinearLayout dUl;
    protected TextView dUm;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Ba();
        b(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        Ba();
    }

    public void displayTip() {
        if (this.axl != null) {
            this.axl.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.axl != null) {
            this.axl.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.axl != null) {
            this.axl.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.axp.setVisibility(8);
    }

    public void displayArrow() {
        this.axp.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.axp.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dUl.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(d.e.ds26);
            this.dUl.setLayoutParams(layoutParams);
            this.dUm.setText("");
            this.dUm.setVisibility(8);
            return;
        }
        this.dUl.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dUl.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(d.e.ds10);
        this.dUl.setLayoutParams(layoutParams2);
        this.dUm.setText(str);
        this.dUm.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.axk.setTextColor(getResources().getColor(d.C0080d.cp_cont_b));
        } else if (i == 2) {
            this.axk.setTextColor(getResources().getColor(d.C0080d.cp_link_tip_d));
        } else if (i == 3) {
            this.axk.setTextColor(getResources().getColor(d.C0080d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.axk.setText(str);
    }

    public void setText(int i) {
        this.axk.setText(i);
    }

    public void setTip(String str) {
        this.axl.setText(str);
    }

    public CharSequence getTip() {
        return this.axl.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.axl.setBackgroundDrawable(drawable);
    }

    protected void Ba() {
        LayoutInflater.from(this.mContext).inflate(d.h.image_problem_item_view, (ViewGroup) this, true);
        this.axj = (LinearLayout) findViewById(d.g.container);
        this.axk = (TextView) findViewById(d.g.text);
        this.axl = (TextView) findViewById(d.g.tip);
        this.axp = (ImageView) findViewById(d.g.arrow2);
        this.dUl = (LinearLayout) findViewById(d.g.ll_container);
        this.dUm = (TextView) findViewById(d.g.tv_help);
    }

    protected void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.axk.setText(string);
        }
        if (color > -1) {
            this.axk.setTextColor(color);
        }
        if (string2 != null) {
            this.axl.setText(string2);
        }
        if (color2 > -1) {
            this.axl.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.axj.setClickable(false);
        this.axj.setFocusable(false);
        this.axp.setVisibility(4);
    }
}
