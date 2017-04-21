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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ImageProblemItemView extends FrameLayout {
    protected LinearLayout avE;
    protected TextView avF;
    protected TextView avG;
    protected ImageView avL;
    protected LinearLayout dpY;
    protected TextView dpZ;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        BM();
        d(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        BM();
    }

    public void displayTip() {
        if (this.avG != null) {
            this.avG.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.avG != null) {
            this.avG.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.avG != null) {
            this.avG.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.avL.setVisibility(8);
    }

    public void displayArrow() {
        this.avL.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.avL.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dpY.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(w.f.ds26);
            this.dpY.setLayoutParams(layoutParams);
            this.dpZ.setText("");
            this.dpZ.setVisibility(8);
            return;
        }
        this.dpY.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dpY.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(w.f.ds10);
        this.dpY.setLayoutParams(layoutParams2);
        this.dpZ.setText(str);
        this.dpZ.setVisibility(0);
    }

    public void setStatus(int i) {
        if (i == 1) {
            this.avF.setTextColor(getResources().getColor(w.e.cp_cont_b));
        } else if (i == 2) {
            this.avF.setTextColor(getResources().getColor(w.e.cp_link_tip_d));
        } else if (i == 3) {
            this.avF.setTextColor(getResources().getColor(w.e.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.avF.setText(str);
    }

    public void setText(int i) {
        this.avF.setText(i);
    }

    public void setTip(String str) {
        this.avG.setText(str);
    }

    public CharSequence getTip() {
        return this.avG.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.avG.setBackgroundDrawable(drawable);
    }

    protected void BM() {
        LayoutInflater.from(this.mContext).inflate(w.j.image_problem_item_view, (ViewGroup) this, true);
        this.avE = (LinearLayout) findViewById(w.h.container);
        this.avF = (TextView) findViewById(w.h.text);
        this.avG = (TextView) findViewById(w.h.tip);
        this.avL = (ImageView) findViewById(w.h.arrow2);
        this.dpY = (LinearLayout) findViewById(w.h.ll_container);
        this.dpZ = (TextView) findViewById(w.h.tv_help);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, w.n.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.avF.setText(string);
        }
        if (color > -1) {
            this.avF.setTextColor(color);
        }
        if (string2 != null) {
            this.avG.setText(string2);
        }
        if (color2 > -1) {
            this.avG.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.avE.setClickable(false);
        this.avE.setFocusable(false);
        this.avL.setVisibility(4);
    }
}
