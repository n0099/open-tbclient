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
    protected LinearLayout dtj;
    protected TextView dtk;
    protected ImageView dtn;
    protected LinearLayout hTG;
    protected TextView hTH;
    protected Context mContext;
    protected TextView textView;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        aMQ();
        d(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        aMQ();
    }

    public void displayTip() {
        if (this.dtk != null) {
            this.dtk.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.dtk != null) {
            this.dtk.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.dtk != null) {
            this.dtk.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.dtn.setVisibility(8);
    }

    public void displayArrow() {
        this.dtn.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.dtn.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hTG.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.ds26);
            this.hTG.setLayoutParams(layoutParams);
            this.hTH.setText("");
            this.hTH.setVisibility(8);
            return;
        }
        this.hTG.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hTG.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.ds10);
        this.hTG.setLayoutParams(layoutParams2);
        this.hTH.setText(str);
        this.hTH.setVisibility(0);
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
        this.dtk.setText(str);
    }

    public CharSequence getTip() {
        return this.dtk.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.dtk.setBackgroundDrawable(drawable);
    }

    protected void aMQ() {
        LayoutInflater.from(this.mContext).inflate(R.layout.image_problem_item_view, (ViewGroup) this, true);
        this.dtj = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.dtk = (TextView) findViewById(R.id.tip);
        this.dtn = (ImageView) findViewById(R.id.arrow2);
        this.hTG = (LinearLayout) findViewById(R.id.ll_container);
        this.hTH = (TextView) findViewById(R.id.tv_help);
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
            this.dtk.setText(string2);
        }
        if (color2 > -1) {
            this.dtk.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.dtj.setClickable(false);
        this.dtj.setFocusable(false);
        this.dtn.setVisibility(4);
    }
}
