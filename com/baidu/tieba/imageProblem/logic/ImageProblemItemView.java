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
    protected ImageView aBm;
    protected LinearLayout cBY;
    protected TextView cBZ;
    protected LinearLayout haO;
    protected TextView haP;
    protected Context mContext;
    protected TextView textView;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        asE();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        asE();
    }

    public void displayTip() {
        if (this.cBZ != null) {
            this.cBZ.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.cBZ != null) {
            this.cBZ.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.cBZ != null) {
            this.cBZ.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.aBm.setVisibility(8);
    }

    public void displayArrow() {
        this.aBm.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.aBm.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.haO.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.ds26);
            this.haO.setLayoutParams(layoutParams);
            this.haP.setText("");
            this.haP.setVisibility(8);
            return;
        }
        this.haO.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.haO.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.ds10);
        this.haO.setLayoutParams(layoutParams2);
        this.haP.setText(str);
        this.haP.setVisibility(0);
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
        this.cBZ.setText(str);
    }

    public CharSequence getTip() {
        return this.cBZ.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.cBZ.setBackgroundDrawable(drawable);
    }

    protected void asE() {
        LayoutInflater.from(this.mContext).inflate(R.layout.image_problem_item_view, (ViewGroup) this, true);
        this.cBY = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.cBZ = (TextView) findViewById(R.id.tip);
        this.aBm = (ImageView) findViewById(R.id.arrow2);
        this.haO = (LinearLayout) findViewById(R.id.ll_container);
        this.haP = (TextView) findViewById(R.id.tv_help);
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
            this.cBZ.setText(string2);
        }
        if (color2 > -1) {
            this.cBZ.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.cBY.setClickable(false);
        this.cBY.setFocusable(false);
        this.aBm.setVisibility(4);
    }
}
