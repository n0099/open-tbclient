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
/* loaded from: classes8.dex */
public class ImageProblemItemView extends FrameLayout {
    protected LinearLayout fxX;
    protected TextView fxY;
    protected ImageView fyc;
    protected LinearLayout kXq;
    protected TextView kXr;
    protected Context mContext;
    protected TextView textView;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        bzF();
        h(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        bzF();
    }

    public void displayTip() {
        if (this.fxY != null) {
            this.fxY.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.fxY != null) {
            this.fxY.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.fxY != null) {
            this.fxY.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.fyc.setVisibility(8);
    }

    public void displayArrow() {
        this.fyc.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.fyc.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kXq.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.ds26);
            this.kXq.setLayoutParams(layoutParams);
            this.kXr.setText("");
            this.kXr.setVisibility(8);
            return;
        }
        this.kXq.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kXq.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.ds10);
        this.kXq.setLayoutParams(layoutParams2);
        this.kXr.setText(str);
        this.kXr.setVisibility(0);
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
        this.fxY.setText(str);
    }

    public CharSequence getTip() {
        return this.fxY.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.fxY.setBackgroundDrawable(drawable);
    }

    protected void bzF() {
        LayoutInflater.from(this.mContext).inflate(R.layout.image_problem_item_view, (ViewGroup) this, true);
        this.fxX = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.fxY = (TextView) findViewById(R.id.tip);
        this.fyc = (ImageView) findViewById(R.id.arrow2);
        this.kXq = (LinearLayout) findViewById(R.id.ll_container);
        this.kXr = (TextView) findViewById(R.id.tv_help);
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
            this.fxY.setText(string2);
        }
        if (color2 > -1) {
            this.fxY.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.fxX.setClickable(false);
        this.fxX.setFocusable(false);
        this.fyc.setVisibility(4);
    }
}
