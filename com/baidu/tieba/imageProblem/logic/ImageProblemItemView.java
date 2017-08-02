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
    protected LinearLayout axn;
    protected TextView axo;
    protected TextView axp;
    protected ImageView axu;
    protected LinearLayout dFT;
    protected TextView dFU;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Bw();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        Bw();
    }

    public void displayTip() {
        if (this.axp != null) {
            this.axp.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.axp != null) {
            this.axp.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.axp != null) {
            this.axp.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.axu.setVisibility(8);
    }

    public void displayArrow() {
        this.axu.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.axu.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dFT.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(d.f.ds26);
            this.dFT.setLayoutParams(layoutParams);
            this.dFU.setText("");
            this.dFU.setVisibility(8);
            return;
        }
        this.dFT.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dFT.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(d.f.ds10);
        this.dFT.setLayoutParams(layoutParams2);
        this.dFU.setText(str);
        this.dFU.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.axo.setTextColor(getResources().getColor(d.e.cp_cont_b));
        } else if (i == 2) {
            this.axo.setTextColor(getResources().getColor(d.e.cp_link_tip_d));
        } else if (i == 3) {
            this.axo.setTextColor(getResources().getColor(d.e.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.axo.setText(str);
    }

    public void setText(int i) {
        this.axo.setText(i);
    }

    public void setTip(String str) {
        this.axp.setText(str);
    }

    public CharSequence getTip() {
        return this.axp.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.axp.setBackgroundDrawable(drawable);
    }

    protected void Bw() {
        LayoutInflater.from(this.mContext).inflate(d.j.image_problem_item_view, (ViewGroup) this, true);
        this.axn = (LinearLayout) findViewById(d.h.container);
        this.axo = (TextView) findViewById(d.h.text);
        this.axp = (TextView) findViewById(d.h.tip);
        this.axu = (ImageView) findViewById(d.h.arrow2);
        this.dFT = (LinearLayout) findViewById(d.h.ll_container);
        this.dFU = (TextView) findViewById(d.h.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.n.TbSettingView);
        String string = obtainStyledAttributes.getString(d.n.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.n.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(d.n.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.n.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.axo.setText(string);
        }
        if (color > -1) {
            this.axo.setTextColor(color);
        }
        if (string2 != null) {
            this.axp.setText(string2);
        }
        if (color2 > -1) {
            this.axp.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.axn.setClickable(false);
        this.axn.setFocusable(false);
        this.axu.setVisibility(4);
    }
}
