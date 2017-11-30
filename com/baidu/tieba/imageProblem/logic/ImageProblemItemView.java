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
    protected LinearLayout axS;
    protected TextView axT;
    protected TextView axU;
    protected ImageView axY;
    protected LinearLayout ecf;
    protected TextView ecg;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Bw();
        b(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        Bw();
    }

    public void displayTip() {
        if (this.axU != null) {
            this.axU.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.axU != null) {
            this.axU.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.axU != null) {
            this.axU.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.axY.setVisibility(8);
    }

    public void displayArrow() {
        this.axY.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.axY.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ecf.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(d.e.ds26);
            this.ecf.setLayoutParams(layoutParams);
            this.ecg.setText("");
            this.ecg.setVisibility(8);
            return;
        }
        this.ecf.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ecf.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(d.e.ds10);
        this.ecf.setLayoutParams(layoutParams2);
        this.ecg.setText(str);
        this.ecg.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.axT.setTextColor(getResources().getColor(d.C0082d.cp_cont_b));
        } else if (i == 2) {
            this.axT.setTextColor(getResources().getColor(d.C0082d.cp_link_tip_d));
        } else if (i == 3) {
            this.axT.setTextColor(getResources().getColor(d.C0082d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.axT.setText(str);
    }

    public void setText(int i) {
        this.axT.setText(i);
    }

    public void setTip(String str) {
        this.axU.setText(str);
    }

    public CharSequence getTip() {
        return this.axU.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.axU.setBackgroundDrawable(drawable);
    }

    protected void Bw() {
        LayoutInflater.from(this.mContext).inflate(d.h.image_problem_item_view, (ViewGroup) this, true);
        this.axS = (LinearLayout) findViewById(d.g.container);
        this.axT = (TextView) findViewById(d.g.text);
        this.axU = (TextView) findViewById(d.g.tip);
        this.axY = (ImageView) findViewById(d.g.arrow2);
        this.ecf = (LinearLayout) findViewById(d.g.ll_container);
        this.ecg = (TextView) findViewById(d.g.tv_help);
    }

    protected void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.axT.setText(string);
        }
        if (color > -1) {
            this.axT.setTextColor(color);
        }
        if (string2 != null) {
            this.axU.setText(string2);
        }
        if (color2 > -1) {
            this.axU.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.axS.setClickable(false);
        this.axS.setFocusable(false);
        this.axY.setVisibility(4);
    }
}
