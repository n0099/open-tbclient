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
    protected ImageView agJ;
    protected TextView ahN;
    protected LinearLayout ceG;
    protected TextView ceH;
    protected LinearLayout gCs;
    protected TextView gCt;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        ako();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        ako();
    }

    public void displayTip() {
        if (this.ceH != null) {
            this.ceH.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.ceH != null) {
            this.ceH.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.ceH != null) {
            this.ceH.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.agJ.setVisibility(8);
    }

    public void displayArrow() {
        this.agJ.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.agJ.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gCs.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(d.e.ds26);
            this.gCs.setLayoutParams(layoutParams);
            this.gCt.setText("");
            this.gCt.setVisibility(8);
            return;
        }
        this.gCs.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gCs.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(d.e.ds10);
        this.gCs.setLayoutParams(layoutParams2);
        this.gCt.setText(str);
        this.gCt.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.ahN.setTextColor(getResources().getColor(d.C0277d.cp_cont_b));
        } else if (i == 2) {
            this.ahN.setTextColor(getResources().getColor(d.C0277d.cp_link_tip_d));
        } else if (i == 3) {
            this.ahN.setTextColor(getResources().getColor(d.C0277d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.ahN.setText(str);
    }

    public void setText(int i) {
        this.ahN.setText(i);
    }

    public void setTip(String str) {
        this.ceH.setText(str);
    }

    public CharSequence getTip() {
        return this.ceH.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.ceH.setBackgroundDrawable(drawable);
    }

    protected void ako() {
        LayoutInflater.from(this.mContext).inflate(d.h.image_problem_item_view, (ViewGroup) this, true);
        this.ceG = (LinearLayout) findViewById(d.g.container);
        this.ahN = (TextView) findViewById(d.g.text);
        this.ceH = (TextView) findViewById(d.g.tip);
        this.agJ = (ImageView) findViewById(d.g.arrow2);
        this.gCs = (LinearLayout) findViewById(d.g.ll_container);
        this.gCt = (TextView) findViewById(d.g.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.ahN.setText(string);
        }
        if (color > -1) {
            this.ahN.setTextColor(color);
        }
        if (string2 != null) {
            this.ceH.setText(string2);
        }
        if (color2 > -1) {
            this.ceH.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.ceG.setClickable(false);
        this.ceG.setFocusable(false);
        this.agJ.setVisibility(4);
    }
}
