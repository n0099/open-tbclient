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
    protected LinearLayout aqa;
    protected TextView aqb;
    protected TextView aqc;
    protected ImageView aqf;
    protected LinearLayout cqa;
    protected TextView cqb;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Bl();
        d(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        Bl();
    }

    public void displayTip() {
        if (this.aqc != null) {
            this.aqc.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.aqc != null) {
            this.aqc.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.aqc != null) {
            this.aqc.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.aqf.setVisibility(8);
    }

    public void displayArrow() {
        this.aqf.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.aqf.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cqa.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(t.e.ds26);
            this.cqa.setLayoutParams(layoutParams);
            this.cqb.setText("");
            this.cqb.setVisibility(8);
            return;
        }
        this.cqa.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cqa.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(t.e.ds10);
        this.cqa.setLayoutParams(layoutParams2);
        this.cqb.setText(str);
        this.cqb.setVisibility(0);
    }

    public void setStatus(int i) {
        if (i == 1) {
            this.aqb.setTextColor(getResources().getColor(t.d.cp_cont_b));
        } else if (i == 2) {
            this.aqb.setTextColor(getResources().getColor(t.d.cp_link_tip_d));
        } else if (i == 3) {
            this.aqb.setTextColor(getResources().getColor(t.d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.aqb.setText(str);
    }

    public void setText(int i) {
        this.aqb.setText(i);
    }

    public void setTip(String str) {
        this.aqc.setText(str);
    }

    public CharSequence getTip() {
        return this.aqc.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.aqc.setBackgroundDrawable(drawable);
    }

    protected void Bl() {
        LayoutInflater.from(this.mContext).inflate(t.h.image_problem_item_view, (ViewGroup) this, true);
        this.aqa = (LinearLayout) findViewById(t.g.container);
        this.aqb = (TextView) findViewById(t.g.text);
        this.aqc = (TextView) findViewById(t.g.tip);
        this.aqf = (ImageView) findViewById(t.g.arrow2);
        this.cqa = (LinearLayout) findViewById(t.g.ll_container);
        this.cqb = (TextView) findViewById(t.g.tv_help);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, t.l.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.aqb.setText(string);
        }
        if (color > -1) {
            this.aqb.setTextColor(color);
        }
        if (string2 != null) {
            this.aqc.setText(string2);
        }
        if (color2 > -1) {
            this.aqc.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.aqa.setClickable(false);
        this.aqa.setFocusable(false);
        this.aqf.setVisibility(4);
    }
}
