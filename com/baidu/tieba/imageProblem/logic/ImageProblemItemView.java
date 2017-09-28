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
    protected LinearLayout awY;
    protected TextView awZ;
    protected TextView axa;
    protected ImageView axe;
    protected LinearLayout dMM;
    protected TextView dMN;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        AX();
        b(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        AX();
    }

    public void displayTip() {
        if (this.axa != null) {
            this.axa.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.axa != null) {
            this.axa.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.axa != null) {
            this.axa.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.axe.setVisibility(8);
    }

    public void displayArrow() {
        this.axe.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.axe.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dMM.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(d.f.ds26);
            this.dMM.setLayoutParams(layoutParams);
            this.dMN.setText("");
            this.dMN.setVisibility(8);
            return;
        }
        this.dMM.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dMM.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(d.f.ds10);
        this.dMM.setLayoutParams(layoutParams2);
        this.dMN.setText(str);
        this.dMN.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.awZ.setTextColor(getResources().getColor(d.e.cp_cont_b));
        } else if (i == 2) {
            this.awZ.setTextColor(getResources().getColor(d.e.cp_link_tip_d));
        } else if (i == 3) {
            this.awZ.setTextColor(getResources().getColor(d.e.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.awZ.setText(str);
    }

    public void setText(int i) {
        this.awZ.setText(i);
    }

    public void setTip(String str) {
        this.axa.setText(str);
    }

    public CharSequence getTip() {
        return this.axa.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.axa.setBackgroundDrawable(drawable);
    }

    protected void AX() {
        LayoutInflater.from(this.mContext).inflate(d.j.image_problem_item_view, (ViewGroup) this, true);
        this.awY = (LinearLayout) findViewById(d.h.container);
        this.awZ = (TextView) findViewById(d.h.text);
        this.axa = (TextView) findViewById(d.h.tip);
        this.axe = (ImageView) findViewById(d.h.arrow2);
        this.dMM = (LinearLayout) findViewById(d.h.ll_container);
        this.dMN = (TextView) findViewById(d.h.tv_help);
    }

    protected void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.n.TbSettingView);
        String string = obtainStyledAttributes.getString(d.n.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.n.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(d.n.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.n.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.awZ.setText(string);
        }
        if (color > -1) {
            this.awZ.setTextColor(color);
        }
        if (string2 != null) {
            this.axa.setText(string2);
        }
        if (color2 > -1) {
            this.axa.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.awY.setClickable(false);
        this.awY.setFocusable(false);
        this.axe.setVisibility(4);
    }
}
