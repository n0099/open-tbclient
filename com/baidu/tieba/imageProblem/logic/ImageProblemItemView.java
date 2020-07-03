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
    protected LinearLayout eqD;
    protected TextView eqE;
    protected ImageView eqH;
    protected LinearLayout jmq;
    protected TextView jmr;
    protected Context mContext;
    protected TextView textView;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        bdE();
        e(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        bdE();
    }

    public void displayTip() {
        if (this.eqE != null) {
            this.eqE.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.eqE != null) {
            this.eqE.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.eqE != null) {
            this.eqE.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.eqH.setVisibility(8);
    }

    public void displayArrow() {
        this.eqH.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.eqH.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jmq.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.ds26);
            this.jmq.setLayoutParams(layoutParams);
            this.jmr.setText("");
            this.jmr.setVisibility(8);
            return;
        }
        this.jmq.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jmq.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.ds10);
        this.jmq.setLayoutParams(layoutParams2);
        this.jmr.setText(str);
        this.jmr.setVisibility(0);
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
        this.eqE.setText(str);
    }

    public CharSequence getTip() {
        return this.eqE.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.eqE.setBackgroundDrawable(drawable);
    }

    protected void bdE() {
        LayoutInflater.from(this.mContext).inflate(R.layout.image_problem_item_view, (ViewGroup) this, true);
        this.eqD = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.eqE = (TextView) findViewById(R.id.tip);
        this.eqH = (ImageView) findViewById(R.id.arrow2);
        this.jmq = (LinearLayout) findViewById(R.id.ll_container);
        this.jmr = (TextView) findViewById(R.id.tv_help);
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
            this.eqE.setText(string2);
        }
        if (color2 > -1) {
            this.eqE.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.eqD.setClickable(false);
        this.eqD.setFocusable(false);
        this.eqH.setVisibility(4);
    }
}
