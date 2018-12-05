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
    protected LinearLayout aUx;
    protected TextView aUy;
    protected ImageView ahQ;
    protected TextView aiY;
    protected LinearLayout fiN;
    protected TextView fiO;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Ky();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        Ky();
    }

    public void displayTip() {
        if (this.aUy != null) {
            this.aUy.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.aUy != null) {
            this.aUy.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.aUy != null) {
            this.aUy.setTextColor(i);
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
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fiN.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(e.C0210e.ds26);
            this.fiN.setLayoutParams(layoutParams);
            this.fiO.setText("");
            this.fiO.setVisibility(8);
            return;
        }
        this.fiN.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fiN.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(e.C0210e.ds10);
        this.fiN.setLayoutParams(layoutParams2);
        this.fiO.setText(str);
        this.fiO.setVisibility(0);
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
        this.aUy.setText(str);
    }

    public CharSequence getTip() {
        return this.aUy.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.aUy.setBackgroundDrawable(drawable);
    }

    protected void Ky() {
        LayoutInflater.from(this.mContext).inflate(e.h.image_problem_item_view, (ViewGroup) this, true);
        this.aUx = (LinearLayout) findViewById(e.g.container);
        this.aiY = (TextView) findViewById(e.g.text);
        this.aUy = (TextView) findViewById(e.g.tip);
        this.ahQ = (ImageView) findViewById(e.g.arrow2);
        this.fiN = (LinearLayout) findViewById(e.g.ll_container);
        this.fiO = (TextView) findViewById(e.g.tv_help);
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
            this.aUy.setText(string2);
        }
        if (color2 > -1) {
            this.aUy.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.aUx.setClickable(false);
        this.aUx.setFocusable(false);
        this.ahQ.setVisibility(4);
    }
}
