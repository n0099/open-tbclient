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
    protected LinearLayout amL;
    protected TextView amM;
    protected TextView amN;
    protected ImageView amQ;
    protected LinearLayout dgX;
    protected TextView dgY;
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
        if (this.amN != null) {
            this.amN.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.amN != null) {
            this.amN.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.amN != null) {
            this.amN.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.amQ.setVisibility(8);
    }

    public void displayArrow() {
        this.amQ.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.amQ.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dgX.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(u.e.ds26);
            this.dgX.setLayoutParams(layoutParams);
            this.dgY.setText("");
            this.dgY.setVisibility(8);
            return;
        }
        this.dgX.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dgX.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(u.e.ds10);
        this.dgX.setLayoutParams(layoutParams2);
        this.dgY.setText(str);
        this.dgY.setVisibility(0);
    }

    public void setStatus(int i) {
        if (i == 1) {
            this.amM.setTextColor(getResources().getColor(u.d.cp_cont_b));
        } else if (i == 2) {
            this.amM.setTextColor(getResources().getColor(u.d.cp_link_tip_d));
        } else if (i == 3) {
            this.amM.setTextColor(getResources().getColor(u.d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.amM.setText(str);
    }

    public void setText(int i) {
        this.amM.setText(i);
    }

    public void setTip(String str) {
        this.amN.setText(str);
    }

    public CharSequence getTip() {
        return this.amN.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.amN.setBackgroundDrawable(drawable);
    }

    protected void zO() {
        LayoutInflater.from(this.mContext).inflate(u.h.image_problem_item_view, (ViewGroup) this, true);
        this.amL = (LinearLayout) findViewById(u.g.container);
        this.amM = (TextView) findViewById(u.g.text);
        this.amN = (TextView) findViewById(u.g.tip);
        this.amQ = (ImageView) findViewById(u.g.arrow2);
        this.dgX = (LinearLayout) findViewById(u.g.ll_container);
        this.dgY = (TextView) findViewById(u.g.tv_help);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, u.l.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.amM.setText(string);
        }
        if (color > -1) {
            this.amM.setTextColor(color);
        }
        if (string2 != null) {
            this.amN.setText(string2);
        }
        if (color2 > -1) {
            this.amN.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.amL.setClickable(false);
        this.amL.setFocusable(false);
        this.amQ.setVisibility(4);
    }
}
