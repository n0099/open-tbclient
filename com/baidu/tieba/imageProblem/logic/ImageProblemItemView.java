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
    protected LinearLayout dTF;
    protected TextView dTG;
    protected ImageView dTJ;
    protected LinearLayout iFl;
    protected TextView iFm;
    protected Context mContext;
    protected TextView textView;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        aVu();
        e(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        aVu();
    }

    public void displayTip() {
        if (this.dTG != null) {
            this.dTG.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.dTG != null) {
            this.dTG.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.dTG != null) {
            this.dTG.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.dTJ.setVisibility(8);
    }

    public void displayArrow() {
        this.dTJ.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.dTJ.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iFl.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.ds26);
            this.iFl.setLayoutParams(layoutParams);
            this.iFm.setText("");
            this.iFm.setVisibility(8);
            return;
        }
        this.iFl.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iFl.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.ds10);
        this.iFl.setLayoutParams(layoutParams2);
        this.iFm.setText(str);
        this.iFm.setVisibility(0);
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
        this.dTG.setText(str);
    }

    public CharSequence getTip() {
        return this.dTG.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.dTG.setBackgroundDrawable(drawable);
    }

    protected void aVu() {
        LayoutInflater.from(this.mContext).inflate(R.layout.image_problem_item_view, (ViewGroup) this, true);
        this.dTF = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.dTG = (TextView) findViewById(R.id.tip);
        this.dTJ = (ImageView) findViewById(R.id.arrow2);
        this.iFl = (LinearLayout) findViewById(R.id.ll_container);
        this.iFm = (TextView) findViewById(R.id.tv_help);
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
            this.dTG.setText(string2);
        }
        if (color2 > -1) {
            this.dTG.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.dTF.setClickable(false);
        this.dTF.setFocusable(false);
        this.dTJ.setVisibility(4);
    }
}
