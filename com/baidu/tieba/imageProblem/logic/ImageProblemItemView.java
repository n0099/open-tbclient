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
    protected LinearLayout bTZ;
    protected LinearLayout fkc;
    protected TextView fkd;
    protected ImageView fkh;
    protected TextView kAs;
    protected Context mContext;
    protected TextView textView;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        bxW();
        e(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        bxW();
    }

    public void displayTip() {
        if (this.fkd != null) {
            this.fkd.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.fkd != null) {
            this.fkd.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.fkd != null) {
            this.fkd.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.fkh.setVisibility(8);
    }

    public void displayArrow() {
        this.fkh.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.fkh.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bTZ.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.ds26);
            this.bTZ.setLayoutParams(layoutParams);
            this.kAs.setText("");
            this.kAs.setVisibility(8);
            return;
        }
        this.bTZ.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bTZ.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.ds10);
        this.bTZ.setLayoutParams(layoutParams2);
        this.kAs.setText(str);
        this.kAs.setVisibility(0);
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
        this.fkd.setText(str);
    }

    public CharSequence getTip() {
        return this.fkd.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.fkd.setBackgroundDrawable(drawable);
    }

    protected void bxW() {
        LayoutInflater.from(this.mContext).inflate(R.layout.image_problem_item_view, (ViewGroup) this, true);
        this.fkc = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.fkd = (TextView) findViewById(R.id.tip);
        this.fkh = (ImageView) findViewById(R.id.arrow2);
        this.bTZ = (LinearLayout) findViewById(R.id.ll_container);
        this.kAs = (TextView) findViewById(R.id.tv_help);
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
            this.fkd.setText(string2);
        }
        if (color2 > -1) {
            this.fkd.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.fkc.setClickable(false);
        this.fkc.setFocusable(false);
        this.fkh.setVisibility(4);
    }
}
