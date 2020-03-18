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
    protected LinearLayout dtK;
    protected TextView dtL;
    protected ImageView dtO;
    protected LinearLayout hVu;
    protected TextView hVv;
    protected Context mContext;
    protected TextView textView;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        aMX();
        d(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        aMX();
    }

    public void displayTip() {
        if (this.dtL != null) {
            this.dtL.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.dtL != null) {
            this.dtL.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.dtL != null) {
            this.dtL.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.dtO.setVisibility(8);
    }

    public void displayArrow() {
        this.dtO.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.dtO.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hVu.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.ds26);
            this.hVu.setLayoutParams(layoutParams);
            this.hVv.setText("");
            this.hVv.setVisibility(8);
            return;
        }
        this.hVu.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hVu.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.ds10);
        this.hVu.setLayoutParams(layoutParams2);
        this.hVv.setText(str);
        this.hVv.setVisibility(0);
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
        this.dtL.setText(str);
    }

    public CharSequence getTip() {
        return this.dtL.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.dtL.setBackgroundDrawable(drawable);
    }

    protected void aMX() {
        LayoutInflater.from(this.mContext).inflate(R.layout.image_problem_item_view, (ViewGroup) this, true);
        this.dtK = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.dtL = (TextView) findViewById(R.id.tip);
        this.dtO = (ImageView) findViewById(R.id.arrow2);
        this.hVu = (LinearLayout) findViewById(R.id.ll_container);
        this.hVv = (TextView) findViewById(R.id.tv_help);
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
            this.dtL.setText(string2);
        }
        if (color2 > -1) {
            this.dtL.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.dtK.setClickable(false);
        this.dtK.setFocusable(false);
        this.dtO.setVisibility(4);
    }
}
