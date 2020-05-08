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
    protected LinearLayout dTK;
    protected TextView dTL;
    protected ImageView dTO;
    protected LinearLayout iFr;
    protected TextView iFs;
    protected Context mContext;
    protected TextView textView;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        aVs();
        e(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        aVs();
    }

    public void displayTip() {
        if (this.dTL != null) {
            this.dTL.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.dTL != null) {
            this.dTL.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.dTL != null) {
            this.dTL.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.dTO.setVisibility(8);
    }

    public void displayArrow() {
        this.dTO.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.dTO.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iFr.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.ds26);
            this.iFr.setLayoutParams(layoutParams);
            this.iFs.setText("");
            this.iFs.setVisibility(8);
            return;
        }
        this.iFr.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iFr.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.ds10);
        this.iFr.setLayoutParams(layoutParams2);
        this.iFs.setText(str);
        this.iFs.setVisibility(0);
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
        this.dTL.setText(str);
    }

    public CharSequence getTip() {
        return this.dTL.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.dTL.setBackgroundDrawable(drawable);
    }

    protected void aVs() {
        LayoutInflater.from(this.mContext).inflate(R.layout.image_problem_item_view, (ViewGroup) this, true);
        this.dTK = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.dTL = (TextView) findViewById(R.id.tip);
        this.dTO = (ImageView) findViewById(R.id.arrow2);
        this.iFr = (LinearLayout) findViewById(R.id.ll_container);
        this.iFs = (TextView) findViewById(R.id.tv_help);
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
            this.dTL.setText(string2);
        }
        if (color2 > -1) {
            this.dTL.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.dTK.setClickable(false);
        this.dTK.setFocusable(false);
        this.dTO.setVisibility(4);
    }
}
