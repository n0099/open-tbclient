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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ImageProblemItemView extends FrameLayout {
    protected LinearLayout anA;
    protected TextView anB;
    protected TextView anC;
    protected ImageView anF;
    protected LinearLayout djV;
    protected TextView djW;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        zO();
        d(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        zO();
    }

    public void displayTip() {
        if (this.anC != null) {
            this.anC.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.anC != null) {
            this.anC.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.anC != null) {
            this.anC.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.anF.setVisibility(8);
    }

    public void displayArrow() {
        this.anF.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.anF.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.djV.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(u.e.ds26);
            this.djV.setLayoutParams(layoutParams);
            this.djW.setText("");
            this.djW.setVisibility(8);
            return;
        }
        this.djV.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.djV.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(u.e.ds10);
        this.djV.setLayoutParams(layoutParams2);
        this.djW.setText(str);
        this.djW.setVisibility(0);
    }

    public void setStatus(int i) {
        if (i == 1) {
            this.anB.setTextColor(getResources().getColor(u.d.cp_cont_b));
        } else if (i == 2) {
            this.anB.setTextColor(getResources().getColor(u.d.cp_link_tip_d));
        } else if (i == 3) {
            this.anB.setTextColor(getResources().getColor(u.d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.anB.setText(str);
    }

    public void setText(int i) {
        this.anB.setText(i);
    }

    public void setTip(String str) {
        this.anC.setText(str);
    }

    public CharSequence getTip() {
        return this.anC.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.anC.setBackgroundDrawable(drawable);
    }

    protected void zO() {
        LayoutInflater.from(this.mContext).inflate(u.h.image_problem_item_view, (ViewGroup) this, true);
        this.anA = (LinearLayout) findViewById(u.g.container);
        this.anB = (TextView) findViewById(u.g.text);
        this.anC = (TextView) findViewById(u.g.tip);
        this.anF = (ImageView) findViewById(u.g.arrow2);
        this.djV = (LinearLayout) findViewById(u.g.ll_container);
        this.djW = (TextView) findViewById(u.g.tv_help);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, u.l.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.anB.setText(string);
        }
        if (color > -1) {
            this.anB.setTextColor(color);
        }
        if (string2 != null) {
            this.anC.setText(string2);
        }
        if (color2 > -1) {
            this.anC.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.anA.setClickable(false);
        this.anA.setFocusable(false);
        this.anF.setVisibility(4);
    }
}
