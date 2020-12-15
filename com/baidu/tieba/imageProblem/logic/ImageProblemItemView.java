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
    protected LinearLayout bXF;
    protected LinearLayout fqI;
    protected TextView fqJ;
    protected ImageView fqN;
    protected TextView kOb;
    protected Context mContext;
    protected TextView textView;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        bAM();
        e(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        bAM();
    }

    public void displayTip() {
        if (this.fqJ != null) {
            this.fqJ.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.fqJ != null) {
            this.fqJ.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.fqJ != null) {
            this.fqJ.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.fqN.setVisibility(8);
    }

    public void displayArrow() {
        this.fqN.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.fqN.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bXF.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.ds26);
            this.bXF.setLayoutParams(layoutParams);
            this.kOb.setText("");
            this.kOb.setVisibility(8);
            return;
        }
        this.bXF.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bXF.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.ds10);
        this.bXF.setLayoutParams(layoutParams2);
        this.kOb.setText(str);
        this.kOb.setVisibility(0);
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
        this.fqJ.setText(str);
    }

    public CharSequence getTip() {
        return this.fqJ.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.fqJ.setBackgroundDrawable(drawable);
    }

    protected void bAM() {
        LayoutInflater.from(this.mContext).inflate(R.layout.image_problem_item_view, (ViewGroup) this, true);
        this.fqI = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.fqJ = (TextView) findViewById(R.id.tip);
        this.fqN = (ImageView) findViewById(R.id.arrow2);
        this.bXF = (LinearLayout) findViewById(R.id.ll_container);
        this.kOb = (TextView) findViewById(R.id.tv_help);
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
            this.fqJ.setText(string2);
        }
        if (color2 > -1) {
            this.fqJ.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.fqI.setClickable(false);
        this.fqI.setFocusable(false);
        this.fqN.setVisibility(4);
    }
}
