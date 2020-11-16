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
    protected LinearLayout bSp;
    protected LinearLayout fjk;
    protected TextView fjl;
    protected ImageView fjp;
    protected TextView kAH;
    protected Context mContext;
    protected TextView textView;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        bxm();
        e(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        bxm();
    }

    public void displayTip() {
        if (this.fjl != null) {
            this.fjl.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.fjl != null) {
            this.fjl.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.fjl != null) {
            this.fjl.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.fjp.setVisibility(8);
    }

    public void displayArrow() {
        this.fjp.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.fjp.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSp.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.ds26);
            this.bSp.setLayoutParams(layoutParams);
            this.kAH.setText("");
            this.kAH.setVisibility(8);
            return;
        }
        this.bSp.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bSp.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.ds10);
        this.bSp.setLayoutParams(layoutParams2);
        this.kAH.setText(str);
        this.kAH.setVisibility(0);
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
        this.fjl.setText(str);
    }

    public CharSequence getTip() {
        return this.fjl.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.fjl.setBackgroundDrawable(drawable);
    }

    protected void bxm() {
        LayoutInflater.from(this.mContext).inflate(R.layout.image_problem_item_view, (ViewGroup) this, true);
        this.fjk = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.fjl = (TextView) findViewById(R.id.tip);
        this.fjp = (ImageView) findViewById(R.id.arrow2);
        this.bSp = (LinearLayout) findViewById(R.id.ll_container);
        this.kAH = (TextView) findViewById(R.id.tv_help);
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
            this.fjl.setText(string2);
        }
        if (color2 > -1) {
            this.fjl.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.fjk.setClickable(false);
        this.fjk.setFocusable(false);
        this.fjp.setVisibility(4);
    }
}
