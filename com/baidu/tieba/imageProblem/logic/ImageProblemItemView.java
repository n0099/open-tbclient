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
    protected LinearLayout axX;
    protected TextView axY;
    protected TextView axZ;
    protected ImageView ayd;
    protected LinearLayout edk;
    protected TextView edl;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Bx();
        b(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        Bx();
    }

    public void displayTip() {
        if (this.axZ != null) {
            this.axZ.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.axZ != null) {
            this.axZ.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.axZ != null) {
            this.axZ.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.ayd.setVisibility(8);
    }

    public void displayArrow() {
        this.ayd.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.ayd.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.edk.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(d.e.ds26);
            this.edk.setLayoutParams(layoutParams);
            this.edl.setText("");
            this.edl.setVisibility(8);
            return;
        }
        this.edk.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.edk.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(d.e.ds10);
        this.edk.setLayoutParams(layoutParams2);
        this.edl.setText(str);
        this.edl.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.axY.setTextColor(getResources().getColor(d.C0096d.cp_cont_b));
        } else if (i == 2) {
            this.axY.setTextColor(getResources().getColor(d.C0096d.cp_link_tip_d));
        } else if (i == 3) {
            this.axY.setTextColor(getResources().getColor(d.C0096d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.axY.setText(str);
    }

    public void setText(int i) {
        this.axY.setText(i);
    }

    public void setTip(String str) {
        this.axZ.setText(str);
    }

    public CharSequence getTip() {
        return this.axZ.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.axZ.setBackgroundDrawable(drawable);
    }

    protected void Bx() {
        LayoutInflater.from(this.mContext).inflate(d.h.image_problem_item_view, (ViewGroup) this, true);
        this.axX = (LinearLayout) findViewById(d.g.container);
        this.axY = (TextView) findViewById(d.g.text);
        this.axZ = (TextView) findViewById(d.g.tip);
        this.ayd = (ImageView) findViewById(d.g.arrow2);
        this.edk = (LinearLayout) findViewById(d.g.ll_container);
        this.edl = (TextView) findViewById(d.g.tv_help);
    }

    protected void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.axY.setText(string);
        }
        if (color > -1) {
            this.axY.setTextColor(color);
        }
        if (string2 != null) {
            this.axZ.setText(string2);
        }
        if (color2 > -1) {
            this.axZ.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.axX.setClickable(false);
        this.axX.setFocusable(false);
        this.ayd.setVisibility(4);
    }
}
