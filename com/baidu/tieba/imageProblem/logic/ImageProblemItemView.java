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
/* loaded from: classes6.dex */
public class ImageProblemItemView extends FrameLayout {
    protected ImageView dtB;
    protected LinearLayout dtx;
    protected TextView dty;
    protected LinearLayout hTU;
    protected TextView hTV;
    protected Context mContext;
    protected TextView textView;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        aMT();
        d(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        aMT();
    }

    public void displayTip() {
        if (this.dty != null) {
            this.dty.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.dty != null) {
            this.dty.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.dty != null) {
            this.dty.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.dtB.setVisibility(8);
    }

    public void displayArrow() {
        this.dtB.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.dtB.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hTU.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.ds26);
            this.hTU.setLayoutParams(layoutParams);
            this.hTV.setText("");
            this.hTV.setVisibility(8);
            return;
        }
        this.hTU.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hTU.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.ds10);
        this.hTU.setLayoutParams(layoutParams2);
        this.hTV.setText(str);
        this.hTV.setVisibility(0);
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
        this.dty.setText(str);
    }

    public CharSequence getTip() {
        return this.dty.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.dty.setBackgroundDrawable(drawable);
    }

    protected void aMT() {
        LayoutInflater.from(this.mContext).inflate(R.layout.image_problem_item_view, (ViewGroup) this, true);
        this.dtx = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.dty = (TextView) findViewById(R.id.tip);
        this.dtB = (ImageView) findViewById(R.id.arrow2);
        this.hTU = (LinearLayout) findViewById(R.id.ll_container);
        this.hTV = (TextView) findViewById(R.id.tv_help);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.TbSettingView);
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
            this.dty.setText(string2);
        }
        if (color2 > -1) {
            this.dty.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.dtx.setClickable(false);
        this.dtx.setFocusable(false);
        this.dtB.setVisibility(4);
    }
}
