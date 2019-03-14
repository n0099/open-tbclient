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
    protected ImageView agE;
    protected TextView ahI;
    protected LinearLayout ceE;
    protected TextView ceF;
    protected LinearLayout gCE;
    protected TextView gCF;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        akr();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        akr();
    }

    public void displayTip() {
        if (this.ceF != null) {
            this.ceF.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.ceF != null) {
            this.ceF.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.ceF != null) {
            this.ceF.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.agE.setVisibility(8);
    }

    public void displayArrow() {
        this.agE.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.agE.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gCE.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(d.e.ds26);
            this.gCE.setLayoutParams(layoutParams);
            this.gCF.setText("");
            this.gCF.setVisibility(8);
            return;
        }
        this.gCE.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gCE.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(d.e.ds10);
        this.gCE.setLayoutParams(layoutParams2);
        this.gCF.setText(str);
        this.gCF.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.ahI.setTextColor(getResources().getColor(d.C0277d.cp_cont_b));
        } else if (i == 2) {
            this.ahI.setTextColor(getResources().getColor(d.C0277d.cp_link_tip_d));
        } else if (i == 3) {
            this.ahI.setTextColor(getResources().getColor(d.C0277d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.ahI.setText(str);
    }

    public void setText(int i) {
        this.ahI.setText(i);
    }

    public void setTip(String str) {
        this.ceF.setText(str);
    }

    public CharSequence getTip() {
        return this.ceF.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.ceF.setBackgroundDrawable(drawable);
    }

    protected void akr() {
        LayoutInflater.from(this.mContext).inflate(d.h.image_problem_item_view, (ViewGroup) this, true);
        this.ceE = (LinearLayout) findViewById(d.g.container);
        this.ahI = (TextView) findViewById(d.g.text);
        this.ceF = (TextView) findViewById(d.g.tip);
        this.agE = (ImageView) findViewById(d.g.arrow2);
        this.gCE = (LinearLayout) findViewById(d.g.ll_container);
        this.gCF = (TextView) findViewById(d.g.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.ahI.setText(string);
        }
        if (color > -1) {
            this.ahI.setTextColor(color);
        }
        if (string2 != null) {
            this.ceF.setText(string2);
        }
        if (color2 > -1) {
            this.ceF.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.ceE.setClickable(false);
        this.ceE.setFocusable(false);
        this.agE.setVisibility(4);
    }
}
