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
    protected LinearLayout eJG;
    protected TextView eJH;
    protected ImageView eJL;
    protected LinearLayout jSZ;
    protected TextView jTa;
    protected Context mContext;
    protected TextView textView;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        bqU();
        e(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        bqU();
    }

    public void displayTip() {
        if (this.eJH != null) {
            this.eJH.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.eJH != null) {
            this.eJH.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.eJH != null) {
            this.eJH.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.eJL.setVisibility(8);
    }

    public void displayArrow() {
        this.eJL.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.eJL.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jSZ.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.ds26);
            this.jSZ.setLayoutParams(layoutParams);
            this.jTa.setText("");
            this.jTa.setVisibility(8);
            return;
        }
        this.jSZ.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jSZ.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.ds10);
        this.jSZ.setLayoutParams(layoutParams2);
        this.jTa.setText(str);
        this.jTa.setVisibility(0);
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
        this.eJH.setText(str);
    }

    public CharSequence getTip() {
        return this.eJH.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.eJH.setBackgroundDrawable(drawable);
    }

    protected void bqU() {
        LayoutInflater.from(this.mContext).inflate(R.layout.image_problem_item_view, (ViewGroup) this, true);
        this.eJG = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.eJH = (TextView) findViewById(R.id.tip);
        this.eJL = (ImageView) findViewById(R.id.arrow2);
        this.jSZ = (LinearLayout) findViewById(R.id.ll_container);
        this.jTa = (TextView) findViewById(R.id.tv_help);
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
            this.eJH.setText(string2);
        }
        if (color2 > -1) {
            this.eJH.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.eJG.setClickable(false);
        this.eJG.setFocusable(false);
        this.eJL.setVisibility(4);
    }
}
