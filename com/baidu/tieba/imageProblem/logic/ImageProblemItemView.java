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
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ImageProblemItemView extends FrameLayout {
    protected ImageView ahO;
    protected TextView ajd;
    protected LinearLayout cpd;
    protected TextView cpe;
    protected LinearLayout hcL;
    protected TextView hcM;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        aqK();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        aqK();
    }

    public void displayTip() {
        if (this.cpe != null) {
            this.cpe.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.cpe != null) {
            this.cpe.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.cpe != null) {
            this.cpe.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.ahO.setVisibility(8);
    }

    public void displayArrow() {
        this.ahO.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.ahO.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hcL.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.ds26);
            this.hcL.setLayoutParams(layoutParams);
            this.hcM.setText("");
            this.hcM.setVisibility(8);
            return;
        }
        this.hcL.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hcL.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.ds10);
        this.hcL.setLayoutParams(layoutParams2);
        this.hcM.setText(str);
        this.hcM.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.ajd.setTextColor(getResources().getColor(R.color.cp_cont_b));
        } else if (i == 2) {
            this.ajd.setTextColor(getResources().getColor(R.color.cp_link_tip_d));
        } else if (i == 3) {
            this.ajd.setTextColor(getResources().getColor(R.color.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.ajd.setText(str);
    }

    public void setText(int i) {
        this.ajd.setText(i);
    }

    public void setTip(String str) {
        this.cpe.setText(str);
    }

    public CharSequence getTip() {
        return this.cpe.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.cpe.setBackgroundDrawable(drawable);
    }

    protected void aqK() {
        LayoutInflater.from(this.mContext).inflate(R.layout.image_problem_item_view, (ViewGroup) this, true);
        this.cpd = (LinearLayout) findViewById(R.id.container);
        this.ajd = (TextView) findViewById(R.id.text);
        this.cpe = (TextView) findViewById(R.id.tip);
        this.ahO = (ImageView) findViewById(R.id.arrow2);
        this.hcL = (LinearLayout) findViewById(R.id.ll_container);
        this.hcM = (TextView) findViewById(R.id.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.a.TbSettingView);
        String string = obtainStyledAttributes.getString(5);
        int color = obtainStyledAttributes.getColor(3, -1);
        String string2 = obtainStyledAttributes.getString(1);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.ajd.setText(string);
        }
        if (color > -1) {
            this.ajd.setTextColor(color);
        }
        if (string2 != null) {
            this.cpe.setText(string2);
        }
        if (color2 > -1) {
            this.cpe.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.cpd.setClickable(false);
        this.cpd.setFocusable(false);
        this.ahO.setVisibility(4);
    }
}
