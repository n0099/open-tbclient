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
    protected LinearLayout fvH;
    protected TextView fvI;
    protected ImageView fvM;
    protected LinearLayout kPa;
    protected TextView kPb;
    protected Context mContext;
    protected TextView textView;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        bzn();
        i(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        bzn();
    }

    public void displayTip() {
        if (this.fvI != null) {
            this.fvI.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.fvI != null) {
            this.fvI.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.fvI != null) {
            this.fvI.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.fvM.setVisibility(8);
    }

    public void displayArrow() {
        this.fvM.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.fvM.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kPa.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.ds26);
            this.kPa.setLayoutParams(layoutParams);
            this.kPb.setText("");
            this.kPb.setVisibility(8);
            return;
        }
        this.kPa.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kPa.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.ds10);
        this.kPa.setLayoutParams(layoutParams2);
        this.kPb.setText(str);
        this.kPb.setVisibility(0);
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
        this.fvI.setText(str);
    }

    public CharSequence getTip() {
        return this.fvI.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.fvI.setBackgroundDrawable(drawable);
    }

    protected void bzn() {
        LayoutInflater.from(this.mContext).inflate(R.layout.image_problem_item_view, (ViewGroup) this, true);
        this.fvH = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.fvI = (TextView) findViewById(R.id.tip);
        this.fvM = (ImageView) findViewById(R.id.arrow2);
        this.kPa = (LinearLayout) findViewById(R.id.ll_container);
        this.kPb = (TextView) findViewById(R.id.tv_help);
    }

    protected void i(AttributeSet attributeSet) {
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
            this.fvI.setText(string2);
        }
        if (color2 > -1) {
            this.fvI.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.fvH.setClickable(false);
        this.fvH.setFocusable(false);
        this.fvM.setVisibility(4);
    }
}
