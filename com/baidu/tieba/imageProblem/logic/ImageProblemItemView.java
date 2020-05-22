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
    protected LinearLayout ehT;
    protected TextView ehU;
    protected ImageView ehX;
    protected LinearLayout iUq;
    protected TextView iUr;
    protected Context mContext;
    protected TextView textView;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        bbB();
        e(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        bbB();
    }

    public void displayTip() {
        if (this.ehU != null) {
            this.ehU.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.ehU != null) {
            this.ehU.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.ehU != null) {
            this.ehU.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.ehX.setVisibility(8);
    }

    public void displayArrow() {
        this.ehX.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.ehX.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iUq.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.ds26);
            this.iUq.setLayoutParams(layoutParams);
            this.iUr.setText("");
            this.iUr.setVisibility(8);
            return;
        }
        this.iUq.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iUq.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.ds10);
        this.iUq.setLayoutParams(layoutParams2);
        this.iUr.setText(str);
        this.iUr.setVisibility(0);
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
        this.ehU.setText(str);
    }

    public CharSequence getTip() {
        return this.ehU.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.ehU.setBackgroundDrawable(drawable);
    }

    protected void bbB() {
        LayoutInflater.from(this.mContext).inflate(R.layout.image_problem_item_view, (ViewGroup) this, true);
        this.ehT = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.ehU = (TextView) findViewById(R.id.tip);
        this.ehX = (ImageView) findViewById(R.id.arrow2);
        this.iUq = (LinearLayout) findViewById(R.id.ll_container);
        this.iUr = (TextView) findViewById(R.id.tv_help);
    }

    protected void e(AttributeSet attributeSet) {
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
            this.ehU.setText(string2);
        }
        if (color2 > -1) {
            this.ehU.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.ehT.setClickable(false);
        this.ehT.setFocusable(false);
        this.ehX.setVisibility(4);
    }
}
