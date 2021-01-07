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
/* loaded from: classes8.dex */
public class ImageProblemItemView extends FrameLayout {
    protected LinearLayout fAp;
    protected TextView fAq;
    protected ImageView fAu;
    protected LinearLayout kTF;
    protected TextView kTG;
    protected Context mContext;
    protected TextView textView;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        bDh();
        i(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        bDh();
    }

    public void displayTip() {
        if (this.fAq != null) {
            this.fAq.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.fAq != null) {
            this.fAq.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.fAq != null) {
            this.fAq.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.fAu.setVisibility(8);
    }

    public void displayArrow() {
        this.fAu.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.fAu.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kTF.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.ds26);
            this.kTF.setLayoutParams(layoutParams);
            this.kTG.setText("");
            this.kTG.setVisibility(8);
            return;
        }
        this.kTF.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kTF.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.ds10);
        this.kTF.setLayoutParams(layoutParams2);
        this.kTG.setText(str);
        this.kTG.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.textView.setTextColor(getResources().getColor(R.color.CAM_X0105));
        } else if (i == 2) {
            this.textView.setTextColor(getResources().getColor(R.color.CAM_X0305));
        } else if (i == 3) {
            this.textView.setTextColor(getResources().getColor(R.color.CAM_X0110));
        }
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setText(int i) {
        this.textView.setText(i);
    }

    public void setTip(String str) {
        this.fAq.setText(str);
    }

    public CharSequence getTip() {
        return this.fAq.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.fAq.setBackgroundDrawable(drawable);
    }

    protected void bDh() {
        LayoutInflater.from(this.mContext).inflate(R.layout.image_problem_item_view, (ViewGroup) this, true);
        this.fAp = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.fAq = (TextView) findViewById(R.id.tip);
        this.fAu = (ImageView) findViewById(R.id.arrow2);
        this.kTF = (LinearLayout) findViewById(R.id.ll_container);
        this.kTG = (TextView) findViewById(R.id.tv_help);
    }

    protected void i(AttributeSet attributeSet) {
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
            this.fAq.setText(string2);
        }
        if (color2 > -1) {
            this.fAq.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.fAp.setClickable(false);
        this.fAp.setFocusable(false);
        this.fAu.setVisibility(4);
    }
}
