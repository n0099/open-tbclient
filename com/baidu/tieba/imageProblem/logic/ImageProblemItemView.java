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
    protected LinearLayout fej;
    protected TextView fek;
    protected ImageView feo;
    protected LinearLayout kuw;
    protected TextView kux;
    protected Context mContext;
    protected TextView textView;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        bvx();
        e(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        bvx();
    }

    public void displayTip() {
        if (this.fek != null) {
            this.fek.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.fek != null) {
            this.fek.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.fek != null) {
            this.fek.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.feo.setVisibility(8);
    }

    public void displayArrow() {
        this.feo.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.feo.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kuw.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.ds26);
            this.kuw.setLayoutParams(layoutParams);
            this.kux.setText("");
            this.kux.setVisibility(8);
            return;
        }
        this.kuw.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kuw.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.ds10);
        this.kuw.setLayoutParams(layoutParams2);
        this.kux.setText(str);
        this.kux.setVisibility(0);
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
        this.fek.setText(str);
    }

    public CharSequence getTip() {
        return this.fek.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.fek.setBackgroundDrawable(drawable);
    }

    protected void bvx() {
        LayoutInflater.from(this.mContext).inflate(R.layout.image_problem_item_view, (ViewGroup) this, true);
        this.fej = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.fek = (TextView) findViewById(R.id.tip);
        this.feo = (ImageView) findViewById(R.id.arrow2);
        this.kuw = (LinearLayout) findViewById(R.id.ll_container);
        this.kux = (TextView) findViewById(R.id.tv_help);
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
            this.fek.setText(string2);
        }
        if (color2 > -1) {
            this.fek.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.fej.setClickable(false);
        this.fej.setFocusable(false);
        this.feo.setVisibility(4);
    }
}
