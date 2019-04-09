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
    protected ImageView agK;
    protected TextView ahO;
    protected LinearLayout ceH;
    protected TextView ceI;
    protected LinearLayout gCt;
    protected TextView gCu;
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
        if (this.ceI != null) {
            this.ceI.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.ceI != null) {
            this.ceI.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.ceI != null) {
            this.ceI.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.agK.setVisibility(8);
    }

    public void displayArrow() {
        this.agK.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.agK.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gCt.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(d.e.ds26);
            this.gCt.setLayoutParams(layoutParams);
            this.gCu.setText("");
            this.gCu.setVisibility(8);
            return;
        }
        this.gCt.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gCt.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(d.e.ds10);
        this.gCt.setLayoutParams(layoutParams2);
        this.gCu.setText(str);
        this.gCu.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.ahO.setTextColor(getResources().getColor(d.C0277d.cp_cont_b));
        } else if (i == 2) {
            this.ahO.setTextColor(getResources().getColor(d.C0277d.cp_link_tip_d));
        } else if (i == 3) {
            this.ahO.setTextColor(getResources().getColor(d.C0277d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.ahO.setText(str);
    }

    public void setText(int i) {
        this.ahO.setText(i);
    }

    public void setTip(String str) {
        this.ceI.setText(str);
    }

    public CharSequence getTip() {
        return this.ceI.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.ceI.setBackgroundDrawable(drawable);
    }

    protected void ako() {
        LayoutInflater.from(this.mContext).inflate(d.h.image_problem_item_view, (ViewGroup) this, true);
        this.ceH = (LinearLayout) findViewById(d.g.container);
        this.ahO = (TextView) findViewById(d.g.text);
        this.ceI = (TextView) findViewById(d.g.tip);
        this.agK = (ImageView) findViewById(d.g.arrow2);
        this.gCt = (LinearLayout) findViewById(d.g.ll_container);
        this.gCu = (TextView) findViewById(d.g.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.ahO.setText(string);
        }
        if (color > -1) {
            this.ahO.setTextColor(color);
        }
        if (string2 != null) {
            this.ceI.setText(string2);
        }
        if (color2 > -1) {
            this.ceI.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.ceH.setClickable(false);
        this.ceH.setFocusable(false);
        this.agK.setVisibility(4);
    }
}
