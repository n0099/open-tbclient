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
/* loaded from: classes2.dex */
public class ImageProblemItemView extends FrameLayout {
    protected ImageView aAU;
    protected LinearLayout cBh;
    protected TextView cBi;
    protected LinearLayout gZX;
    protected TextView gZY;
    protected Context mContext;
    protected TextView textView;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        asC();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        asC();
    }

    public void displayTip() {
        if (this.cBi != null) {
            this.cBi.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.cBi != null) {
            this.cBi.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.cBi != null) {
            this.cBi.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.aAU.setVisibility(8);
    }

    public void displayArrow() {
        this.aAU.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.aAU.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gZX.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.ds26);
            this.gZX.setLayoutParams(layoutParams);
            this.gZY.setText("");
            this.gZY.setVisibility(8);
            return;
        }
        this.gZX.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gZX.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.ds10);
        this.gZX.setLayoutParams(layoutParams2);
        this.gZY.setText(str);
        this.gZY.setVisibility(0);
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
        this.cBi.setText(str);
    }

    public CharSequence getTip() {
        return this.cBi.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.cBi.setBackgroundDrawable(drawable);
    }

    protected void asC() {
        LayoutInflater.from(this.mContext).inflate(R.layout.image_problem_item_view, (ViewGroup) this, true);
        this.cBh = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.cBi = (TextView) findViewById(R.id.tip);
        this.aAU = (ImageView) findViewById(R.id.arrow2);
        this.gZX = (LinearLayout) findViewById(R.id.ll_container);
        this.gZY = (TextView) findViewById(R.id.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
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
            this.cBi.setText(string2);
        }
        if (color2 > -1) {
            this.cBi.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.cBh.setClickable(false);
        this.cBh.setFocusable(false);
        this.aAU.setVisibility(4);
    }
}
