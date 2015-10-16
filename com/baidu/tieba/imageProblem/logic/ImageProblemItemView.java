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
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ImageProblemItemView extends FrameLayout {
    protected TextView alQ;
    protected TextView alR;
    protected ImageView alU;
    protected LinearLayout bQM;
    protected TextView bQN;
    protected LinearLayout container;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        zl();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        zl();
    }

    public void displayTip() {
        if (this.alR != null) {
            this.alR.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.alR != null) {
            this.alR.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.alR != null) {
            this.alR.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.alU.setVisibility(8);
    }

    public void displayArrow() {
        this.alU.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.alU.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bQM.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(i.d.ds26);
            this.bQM.setLayoutParams(layoutParams);
            this.bQN.setText("");
            this.bQN.setVisibility(8);
            return;
        }
        this.bQM.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bQM.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(i.d.ds10);
        this.bQM.setLayoutParams(layoutParams2);
        this.bQN.setText(str);
        this.bQN.setVisibility(0);
    }

    public void setStatus(int i) {
        if (i == 1) {
            this.alQ.setTextColor(getResources().getColor(i.c.cp_cont_b));
        } else if (i == 2) {
            this.alQ.setTextColor(getResources().getColor(i.c.cp_link_tip_d));
        } else if (i == 3) {
            this.alQ.setTextColor(getResources().getColor(i.c.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.alQ.setText(str);
    }

    public void setText(int i) {
        this.alQ.setText(i);
    }

    public void setTip(String str) {
        this.alR.setText(str);
    }

    public CharSequence getTip() {
        return this.alR.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.alR.setBackgroundDrawable(drawable);
    }

    protected void zl() {
        LayoutInflater.from(this.mContext).inflate(i.g.image_problem_item_view, (ViewGroup) this, true);
        this.container = (LinearLayout) findViewById(i.f.container);
        this.alQ = (TextView) findViewById(i.f.text);
        this.alR = (TextView) findViewById(i.f.tip);
        this.alU = (ImageView) findViewById(i.f.arrow2);
        this.bQM = (LinearLayout) findViewById(i.f.ll_container);
        this.bQN = (TextView) findViewById(i.f.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, i.j.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.alQ.setText(string);
        }
        if (color > -1) {
            this.alQ.setTextColor(color);
        }
        if (string2 != null) {
            this.alR.setText(string2);
        }
        if (color2 > -1) {
            this.alR.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.container.setClickable(false);
        this.container.setFocusable(false);
        this.alU.setVisibility(4);
    }
}
