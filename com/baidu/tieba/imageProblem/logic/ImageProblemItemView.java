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
/* loaded from: classes4.dex */
public class ImageProblemItemView extends FrameLayout {
    protected LinearLayout aUA;
    protected TextView aUB;
    protected ImageView ahQ;
    protected TextView aiY;
    protected LinearLayout flE;
    protected TextView flF;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Kz();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        Kz();
    }

    public void displayTip() {
        if (this.aUB != null) {
            this.aUB.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.aUB != null) {
            this.aUB.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.aUB != null) {
            this.aUB.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.ahQ.setVisibility(8);
    }

    public void displayArrow() {
        this.ahQ.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.ahQ.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.flE.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(e.C0210e.ds26);
            this.flE.setLayoutParams(layoutParams);
            this.flF.setText("");
            this.flF.setVisibility(8);
            return;
        }
        this.flE.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.flE.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(e.C0210e.ds10);
        this.flE.setLayoutParams(layoutParams2);
        this.flF.setText(str);
        this.flF.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.aiY.setTextColor(getResources().getColor(e.d.cp_cont_b));
        } else if (i == 2) {
            this.aiY.setTextColor(getResources().getColor(e.d.cp_link_tip_d));
        } else if (i == 3) {
            this.aiY.setTextColor(getResources().getColor(e.d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.aiY.setText(str);
    }

    public void setText(int i) {
        this.aiY.setText(i);
    }

    public void setTip(String str) {
        this.aUB.setText(str);
    }

    public CharSequence getTip() {
        return this.aUB.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.aUB.setBackgroundDrawable(drawable);
    }

    protected void Kz() {
        LayoutInflater.from(this.mContext).inflate(e.h.image_problem_item_view, (ViewGroup) this, true);
        this.aUA = (LinearLayout) findViewById(e.g.container);
        this.aiY = (TextView) findViewById(e.g.text);
        this.aUB = (TextView) findViewById(e.g.tip);
        this.ahQ = (ImageView) findViewById(e.g.arrow2);
        this.flE = (LinearLayout) findViewById(e.g.ll_container);
        this.flF = (TextView) findViewById(e.g.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, e.l.TbSettingView);
        String string = obtainStyledAttributes.getString(e.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(e.l.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(e.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(e.l.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.aiY.setText(string);
        }
        if (color > -1) {
            this.aiY.setTextColor(color);
        }
        if (string2 != null) {
            this.aUB.setText(string2);
        }
        if (color2 > -1) {
            this.aUB.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.aUA.setClickable(false);
        this.aUA.setFocusable(false);
        this.ahQ.setVisibility(4);
    }
}
