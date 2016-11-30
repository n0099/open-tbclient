package com.baidu.tieba.imageProblem.logic;

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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ImageProblemItemView extends FrameLayout {
    protected LinearLayout arj;
    protected TextView ark;
    protected TextView arl;
    protected ImageView arp;
    protected LinearLayout dCH;
    protected TextView dCI;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Bn();
        d(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        Bn();
    }

    public void displayTip() {
        if (this.arl != null) {
            this.arl.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.arl != null) {
            this.arl.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.arl != null) {
            this.arl.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.arp.setVisibility(8);
    }

    public void displayArrow() {
        this.arp.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.arp.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dCH.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(r.e.ds26);
            this.dCH.setLayoutParams(layoutParams);
            this.dCI.setText("");
            this.dCI.setVisibility(8);
            return;
        }
        this.dCH.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dCH.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(r.e.ds10);
        this.dCH.setLayoutParams(layoutParams2);
        this.dCI.setText(str);
        this.dCI.setVisibility(0);
    }

    public void setStatus(int i) {
        if (i == 1) {
            this.ark.setTextColor(getResources().getColor(r.d.cp_cont_b));
        } else if (i == 2) {
            this.ark.setTextColor(getResources().getColor(r.d.cp_link_tip_d));
        } else if (i == 3) {
            this.ark.setTextColor(getResources().getColor(r.d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.ark.setText(str);
    }

    public void setText(int i) {
        this.ark.setText(i);
    }

    public void setTip(String str) {
        this.arl.setText(str);
    }

    public CharSequence getTip() {
        return this.arl.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.arl.setBackgroundDrawable(drawable);
    }

    protected void Bn() {
        LayoutInflater.from(this.mContext).inflate(r.h.image_problem_item_view, (ViewGroup) this, true);
        this.arj = (LinearLayout) findViewById(r.g.container);
        this.ark = (TextView) findViewById(r.g.text);
        this.arl = (TextView) findViewById(r.g.tip);
        this.arp = (ImageView) findViewById(r.g.arrow2);
        this.dCH = (LinearLayout) findViewById(r.g.ll_container);
        this.dCI = (TextView) findViewById(r.g.tv_help);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, r.l.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.ark.setText(string);
        }
        if (color > -1) {
            this.ark.setTextColor(color);
        }
        if (string2 != null) {
            this.arl.setText(string2);
        }
        if (color2 > -1) {
            this.arl.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.arj.setClickable(false);
        this.arj.setFocusable(false);
        this.arp.setVisibility(4);
    }
}
