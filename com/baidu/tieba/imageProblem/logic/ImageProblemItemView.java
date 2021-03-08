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
/* loaded from: classes7.dex */
public class ImageProblemItemView extends FrameLayout {
    protected ImageView fzB;
    protected LinearLayout fzw;
    protected TextView fzx;
    protected LinearLayout kZs;
    protected TextView kZt;
    protected Context mContext;
    protected TextView textView;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        bzI();
        h(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        bzI();
    }

    public void displayTip() {
        if (this.fzx != null) {
            this.fzx.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.fzx != null) {
            this.fzx.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.fzx != null) {
            this.fzx.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.fzB.setVisibility(8);
    }

    public void displayArrow() {
        this.fzB.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.fzB.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kZs.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.ds26);
            this.kZs.setLayoutParams(layoutParams);
            this.kZt.setText("");
            this.kZt.setVisibility(8);
            return;
        }
        this.kZs.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kZs.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.ds10);
        this.kZs.setLayoutParams(layoutParams2);
        this.kZt.setText(str);
        this.kZt.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.textView.setTextColor(getResources().getColor(R.color.CAM_X0105));
        } else if (i == 2) {
            this.textView.setTextColor(getResources().getColor(R.color.CAM_X0305));
        } else if (i == 3) {
            this.textView.setTextColor(getResources().getColor(R.color.CAM_X0110));
        }
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setText(int i) {
        this.textView.setText(i);
    }

    public void setTip(String str) {
        this.fzx.setText(str);
    }

    public CharSequence getTip() {
        return this.fzx.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.fzx.setBackgroundDrawable(drawable);
    }

    protected void bzI() {
        LayoutInflater.from(this.mContext).inflate(R.layout.image_problem_item_view, (ViewGroup) this, true);
        this.fzw = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.fzx = (TextView) findViewById(R.id.tip);
        this.fzB = (ImageView) findViewById(R.id.arrow2);
        this.kZs = (LinearLayout) findViewById(R.id.ll_container);
        this.kZt = (TextView) findViewById(R.id.tv_help);
    }

    protected void h(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.TbSettingView);
        String string = obtainStyledAttributes.getString(R.styleable.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(R.styleable.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(R.styleable.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(R.styleable.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.textView.setText(string);
        }
        if (color > -1) {
            this.textView.setTextColor(color);
        }
        if (string2 != null) {
            this.fzx.setText(string2);
        }
        if (color2 > -1) {
            this.fzx.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.fzw.setClickable(false);
        this.fzw.setFocusable(false);
        this.fzB.setVisibility(4);
    }
}
