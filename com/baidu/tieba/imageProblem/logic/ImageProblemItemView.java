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
    protected TextView anI;
    protected TextView anJ;
    protected ImageView anM;
    protected LinearLayout chu;
    protected TextView chv;
    protected LinearLayout container;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Aj();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        Aj();
    }

    public void displayTip() {
        if (this.anJ != null) {
            this.anJ.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.anJ != null) {
            this.anJ.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.anJ != null) {
            this.anJ.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.anM.setVisibility(8);
    }

    public void displayArrow() {
        this.anM.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.anM.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.chu.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(n.d.ds26);
            this.chu.setLayoutParams(layoutParams);
            this.chv.setText("");
            this.chv.setVisibility(8);
            return;
        }
        this.chu.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.chu.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(n.d.ds10);
        this.chu.setLayoutParams(layoutParams2);
        this.chv.setText(str);
        this.chv.setVisibility(0);
    }

    public void setStatus(int i) {
        if (i == 1) {
            this.anI.setTextColor(getResources().getColor(n.c.cp_cont_b));
        } else if (i == 2) {
            this.anI.setTextColor(getResources().getColor(n.c.cp_link_tip_d));
        } else if (i == 3) {
            this.anI.setTextColor(getResources().getColor(n.c.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.anI.setText(str);
    }

    public void setText(int i) {
        this.anI.setText(i);
    }

    public void setTip(String str) {
        this.anJ.setText(str);
    }

    public CharSequence getTip() {
        return this.anJ.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.anJ.setBackgroundDrawable(drawable);
    }

    protected void Aj() {
        LayoutInflater.from(this.mContext).inflate(n.g.image_problem_item_view, (ViewGroup) this, true);
        this.container = (LinearLayout) findViewById(n.f.container);
        this.anI = (TextView) findViewById(n.f.text);
        this.anJ = (TextView) findViewById(n.f.tip);
        this.anM = (ImageView) findViewById(n.f.arrow2);
        this.chu = (LinearLayout) findViewById(n.f.ll_container);
        this.chv = (TextView) findViewById(n.f.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, n.k.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.anI.setText(string);
        }
        if (color > -1) {
            this.anI.setTextColor(color);
        }
        if (string2 != null) {
            this.anJ.setText(string2);
        }
        if (color2 > -1) {
            this.anJ.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.container.setClickable(false);
        this.container.setFocusable(false);
        this.anM.setVisibility(4);
    }
}
