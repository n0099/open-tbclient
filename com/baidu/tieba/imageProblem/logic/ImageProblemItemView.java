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
    protected LinearLayout boK;
    protected TextView boL;
    protected TextView boM;
    protected ImageView boQ;
    protected LinearLayout eWM;
    protected TextView eWN;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Jw();
        d(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        Jw();
    }

    public void displayTip() {
        if (this.boM != null) {
            this.boM.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.boM != null) {
            this.boM.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.boM != null) {
            this.boM.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.boQ.setVisibility(8);
    }

    public void displayArrow() {
        this.boQ.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.boQ.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eWM.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(d.e.ds26);
            this.eWM.setLayoutParams(layoutParams);
            this.eWN.setText("");
            this.eWN.setVisibility(8);
            return;
        }
        this.eWM.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eWM.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(d.e.ds10);
        this.eWM.setLayoutParams(layoutParams2);
        this.eWN.setText(str);
        this.eWN.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.boL.setTextColor(getResources().getColor(d.C0140d.cp_cont_b));
        } else if (i == 2) {
            this.boL.setTextColor(getResources().getColor(d.C0140d.cp_link_tip_d));
        } else if (i == 3) {
            this.boL.setTextColor(getResources().getColor(d.C0140d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.boL.setText(str);
    }

    public void setText(int i) {
        this.boL.setText(i);
    }

    public void setTip(String str) {
        this.boM.setText(str);
    }

    public CharSequence getTip() {
        return this.boM.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.boM.setBackgroundDrawable(drawable);
    }

    protected void Jw() {
        LayoutInflater.from(this.mContext).inflate(d.h.image_problem_item_view, (ViewGroup) this, true);
        this.boK = (LinearLayout) findViewById(d.g.container);
        this.boL = (TextView) findViewById(d.g.text);
        this.boM = (TextView) findViewById(d.g.tip);
        this.boQ = (ImageView) findViewById(d.g.arrow2);
        this.eWM = (LinearLayout) findViewById(d.g.ll_container);
        this.eWN = (TextView) findViewById(d.g.tv_help);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.boL.setText(string);
        }
        if (color > -1) {
            this.boL.setTextColor(color);
        }
        if (string2 != null) {
            this.boM.setText(string2);
        }
        if (color2 > -1) {
            this.boM.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.boK.setClickable(false);
        this.boK.setFocusable(false);
        this.boQ.setVisibility(4);
    }
}
