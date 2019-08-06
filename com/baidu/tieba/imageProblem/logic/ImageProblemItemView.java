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
import com.baidu.tieba.R;
import com.baidu.tieba.c;
/* loaded from: classes2.dex */
public class ImageProblemItemView extends FrameLayout {
    protected ImageView ahs;
    protected LinearLayout coi;
    protected TextView coj;
    protected LinearLayout haR;
    protected TextView haS;
    protected Context mContext;
    protected TextView textView;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        aqy();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        aqy();
    }

    public void displayTip() {
        if (this.coj != null) {
            this.coj.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.coj != null) {
            this.coj.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.coj != null) {
            this.coj.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.ahs.setVisibility(8);
    }

    public void displayArrow() {
        this.ahs.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.ahs.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.haR.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.ds26);
            this.haR.setLayoutParams(layoutParams);
            this.haS.setText("");
            this.haS.setVisibility(8);
            return;
        }
        this.haR.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.haR.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.ds10);
        this.haR.setLayoutParams(layoutParams2);
        this.haS.setText(str);
        this.haS.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.textView.setTextColor(getResources().getColor(R.color.cp_cont_b));
        } else if (i == 2) {
            this.textView.setTextColor(getResources().getColor(R.color.cp_link_tip_d));
        } else if (i == 3) {
            this.textView.setTextColor(getResources().getColor(R.color.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setText(int i) {
        this.textView.setText(i);
    }

    public void setTip(String str) {
        this.coj.setText(str);
    }

    public CharSequence getTip() {
        return this.coj.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.coj.setBackgroundDrawable(drawable);
    }

    protected void aqy() {
        LayoutInflater.from(this.mContext).inflate(R.layout.image_problem_item_view, (ViewGroup) this, true);
        this.coi = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.coj = (TextView) findViewById(R.id.tip);
        this.ahs = (ImageView) findViewById(R.id.arrow2);
        this.haR = (LinearLayout) findViewById(R.id.ll_container);
        this.haS = (TextView) findViewById(R.id.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, c.a.TbSettingView);
        String string = obtainStyledAttributes.getString(5);
        int color = obtainStyledAttributes.getColor(3, -1);
        String string2 = obtainStyledAttributes.getString(1);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.textView.setText(string);
        }
        if (color > -1) {
            this.textView.setTextColor(color);
        }
        if (string2 != null) {
            this.coj.setText(string2);
        }
        if (color2 > -1) {
            this.coj.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.coi.setClickable(false);
        this.coi.setFocusable(false);
        this.ahs.setVisibility(4);
    }
}
