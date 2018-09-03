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
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class ImageProblemItemView extends FrameLayout {
    protected LinearLayout aIq;
    protected TextView aIr;
    protected TextView aIs;
    protected ImageView aIv;
    protected LinearLayout eLx;
    protected TextView eLy;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        FR();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        FR();
    }

    public void displayTip() {
        if (this.aIs != null) {
            this.aIs.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.aIs != null) {
            this.aIs.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.aIs != null) {
            this.aIs.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.aIv.setVisibility(8);
    }

    public void displayArrow() {
        this.aIv.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.aIv.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eLx.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(f.e.ds26);
            this.eLx.setLayoutParams(layoutParams);
            this.eLy.setText("");
            this.eLy.setVisibility(8);
            return;
        }
        this.eLx.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eLx.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(f.e.ds10);
        this.eLx.setLayoutParams(layoutParams2);
        this.eLy.setText(str);
        this.eLy.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.aIr.setTextColor(getResources().getColor(f.d.cp_cont_b));
        } else if (i == 2) {
            this.aIr.setTextColor(getResources().getColor(f.d.cp_link_tip_d));
        } else if (i == 3) {
            this.aIr.setTextColor(getResources().getColor(f.d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.aIr.setText(str);
    }

    public void setText(int i) {
        this.aIr.setText(i);
    }

    public void setTip(String str) {
        this.aIs.setText(str);
    }

    public CharSequence getTip() {
        return this.aIs.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.aIs.setBackgroundDrawable(drawable);
    }

    protected void FR() {
        LayoutInflater.from(this.mContext).inflate(f.h.image_problem_item_view, (ViewGroup) this, true);
        this.aIq = (LinearLayout) findViewById(f.g.container);
        this.aIr = (TextView) findViewById(f.g.text);
        this.aIs = (TextView) findViewById(f.g.tip);
        this.aIv = (ImageView) findViewById(f.g.arrow2);
        this.eLx = (LinearLayout) findViewById(f.g.ll_container);
        this.eLy = (TextView) findViewById(f.g.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, f.l.TbSettingView);
        String string = obtainStyledAttributes.getString(f.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(f.l.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(f.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(f.l.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.aIr.setText(string);
        }
        if (color > -1) {
            this.aIr.setTextColor(color);
        }
        if (string2 != null) {
            this.aIs.setText(string2);
        }
        if (color2 > -1) {
            this.aIs.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.aIq.setClickable(false);
        this.aIq.setFocusable(false);
        this.aIv.setVisibility(4);
    }
}
