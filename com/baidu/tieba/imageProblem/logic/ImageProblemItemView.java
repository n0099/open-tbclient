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
    protected ImageView agD;
    protected TextView ahH;
    protected LinearLayout ceE;
    protected TextView ceF;
    protected LinearLayout gCF;
    protected TextView gCG;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        aks();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        aks();
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
        this.agD.setVisibility(8);
    }

    public void displayArrow() {
        this.agD.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.agD.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gCF.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(d.e.ds26);
            this.gCF.setLayoutParams(layoutParams);
            this.gCG.setText("");
            this.gCG.setVisibility(8);
            return;
        }
        this.gCF.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gCF.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(d.e.ds10);
        this.gCF.setLayoutParams(layoutParams2);
        this.gCG.setText(str);
        this.gCG.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.ahH.setTextColor(getResources().getColor(d.C0236d.cp_cont_b));
        } else if (i == 2) {
            this.ahH.setTextColor(getResources().getColor(d.C0236d.cp_link_tip_d));
        } else if (i == 3) {
            this.ahH.setTextColor(getResources().getColor(d.C0236d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.ahH.setText(str);
    }

    public void setText(int i) {
        this.ahH.setText(i);
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

    protected void aks() {
        LayoutInflater.from(this.mContext).inflate(d.h.image_problem_item_view, (ViewGroup) this, true);
        this.ceE = (LinearLayout) findViewById(d.g.container);
        this.ahH = (TextView) findViewById(d.g.text);
        this.ceF = (TextView) findViewById(d.g.tip);
        this.agD = (ImageView) findViewById(d.g.arrow2);
        this.gCF = (LinearLayout) findViewById(d.g.ll_container);
        this.gCG = (TextView) findViewById(d.g.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.ahH.setText(string);
        }
        if (color > -1) {
            this.ahH.setTextColor(color);
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
        this.agD.setVisibility(4);
    }
}
