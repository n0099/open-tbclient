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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ImageProblemItemView extends FrameLayout {
    protected LinearLayout aqH;
    protected TextView aqI;
    protected TextView aqJ;
    protected ImageView aqM;
    protected LinearLayout dvD;
    protected TextView dvE;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Bd();
        d(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        Bd();
    }

    public void displayTip() {
        if (this.aqJ != null) {
            this.aqJ.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.aqJ != null) {
            this.aqJ.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.aqJ != null) {
            this.aqJ.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.aqM.setVisibility(8);
    }

    public void displayArrow() {
        this.aqM.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.aqM.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dvD.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(t.e.ds26);
            this.dvD.setLayoutParams(layoutParams);
            this.dvE.setText("");
            this.dvE.setVisibility(8);
            return;
        }
        this.dvD.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dvD.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(t.e.ds10);
        this.dvD.setLayoutParams(layoutParams2);
        this.dvE.setText(str);
        this.dvE.setVisibility(0);
    }

    public void setStatus(int i) {
        if (i == 1) {
            this.aqI.setTextColor(getResources().getColor(t.d.cp_cont_b));
        } else if (i == 2) {
            this.aqI.setTextColor(getResources().getColor(t.d.cp_link_tip_d));
        } else if (i == 3) {
            this.aqI.setTextColor(getResources().getColor(t.d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.aqI.setText(str);
    }

    public void setText(int i) {
        this.aqI.setText(i);
    }

    public void setTip(String str) {
        this.aqJ.setText(str);
    }

    public CharSequence getTip() {
        return this.aqJ.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.aqJ.setBackgroundDrawable(drawable);
    }

    protected void Bd() {
        LayoutInflater.from(this.mContext).inflate(t.h.image_problem_item_view, (ViewGroup) this, true);
        this.aqH = (LinearLayout) findViewById(t.g.container);
        this.aqI = (TextView) findViewById(t.g.text);
        this.aqJ = (TextView) findViewById(t.g.tip);
        this.aqM = (ImageView) findViewById(t.g.arrow2);
        this.dvD = (LinearLayout) findViewById(t.g.ll_container);
        this.dvE = (TextView) findViewById(t.g.tv_help);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, t.l.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.aqI.setText(string);
        }
        if (color > -1) {
            this.aqI.setTextColor(color);
        }
        if (string2 != null) {
            this.aqJ.setText(string2);
        }
        if (color2 > -1) {
            this.aqJ.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.aqH.setClickable(false);
        this.aqH.setFocusable(false);
        this.aqM.setVisibility(4);
    }
}
