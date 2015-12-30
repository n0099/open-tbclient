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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class ImageProblemItemView extends FrameLayout {
    protected TextView api;
    protected TextView apj;
    protected ImageView apm;
    protected TextView clA;
    protected LinearLayout clz;
    protected LinearLayout container;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        zV();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        zV();
    }

    public void displayTip() {
        if (this.apj != null) {
            this.apj.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.apj != null) {
            this.apj.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.apj != null) {
            this.apj.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.apm.setVisibility(8);
    }

    public void displayArrow() {
        this.apm.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.apm.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.clz.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(n.e.ds26);
            this.clz.setLayoutParams(layoutParams);
            this.clA.setText("");
            this.clA.setVisibility(8);
            return;
        }
        this.clz.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.clz.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(n.e.ds10);
        this.clz.setLayoutParams(layoutParams2);
        this.clA.setText(str);
        this.clA.setVisibility(0);
    }

    public void setStatus(int i) {
        if (i == 1) {
            this.api.setTextColor(getResources().getColor(n.d.cp_cont_b));
        } else if (i == 2) {
            this.api.setTextColor(getResources().getColor(n.d.cp_link_tip_d));
        } else if (i == 3) {
            this.api.setTextColor(getResources().getColor(n.d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.api.setText(str);
    }

    public void setText(int i) {
        this.api.setText(i);
    }

    public void setTip(String str) {
        this.apj.setText(str);
    }

    public CharSequence getTip() {
        return this.apj.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.apj.setBackgroundDrawable(drawable);
    }

    protected void zV() {
        LayoutInflater.from(this.mContext).inflate(n.h.image_problem_item_view, (ViewGroup) this, true);
        this.container = (LinearLayout) findViewById(n.g.container);
        this.api = (TextView) findViewById(n.g.text);
        this.apj = (TextView) findViewById(n.g.tip);
        this.apm = (ImageView) findViewById(n.g.arrow2);
        this.clz = (LinearLayout) findViewById(n.g.ll_container);
        this.clA = (TextView) findViewById(n.g.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, n.l.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.api.setText(string);
        }
        if (color > -1) {
            this.api.setTextColor(color);
        }
        if (string2 != null) {
            this.apj.setText(string2);
        }
        if (color2 > -1) {
            this.apj.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.container.setClickable(false);
        this.container.setFocusable(false);
        this.apm.setVisibility(4);
    }
}
