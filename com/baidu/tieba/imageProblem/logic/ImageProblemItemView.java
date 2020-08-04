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
/* loaded from: classes13.dex */
public class ImageProblemItemView extends FrameLayout {
    protected LinearLayout ewV;
    protected TextView ewW;
    protected ImageView ewZ;
    protected LinearLayout juW;
    protected TextView juX;
    protected Context mContext;
    protected TextView textView;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        bhn();
        e(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        bhn();
    }

    public void displayTip() {
        if (this.ewW != null) {
            this.ewW.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.ewW != null) {
            this.ewW.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.ewW != null) {
            this.ewW.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.ewZ.setVisibility(8);
    }

    public void displayArrow() {
        this.ewZ.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.ewZ.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.juW.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.ds26);
            this.juW.setLayoutParams(layoutParams);
            this.juX.setText("");
            this.juX.setVisibility(8);
            return;
        }
        this.juW.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.juW.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.ds10);
        this.juW.setLayoutParams(layoutParams2);
        this.juX.setText(str);
        this.juX.setVisibility(0);
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
        this.ewW.setText(str);
    }

    public CharSequence getTip() {
        return this.ewW.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.ewW.setBackgroundDrawable(drawable);
    }

    protected void bhn() {
        LayoutInflater.from(this.mContext).inflate(R.layout.image_problem_item_view, (ViewGroup) this, true);
        this.ewV = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.ewW = (TextView) findViewById(R.id.tip);
        this.ewZ = (ImageView) findViewById(R.id.arrow2);
        this.juW = (LinearLayout) findViewById(R.id.ll_container);
        this.juX = (TextView) findViewById(R.id.tv_help);
    }

    protected void e(AttributeSet attributeSet) {
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
            this.ewW.setText(string2);
        }
        if (color2 > -1) {
            this.ewW.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.ewV.setClickable(false);
        this.ewV.setFocusable(false);
        this.ewZ.setVisibility(4);
    }
}
