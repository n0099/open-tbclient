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
/* loaded from: classes5.dex */
public class ImageProblemItemView extends FrameLayout {
    protected LinearLayout dpb;
    protected TextView dpc;
    protected ImageView dpf;
    protected LinearLayout hRI;
    protected TextView hRJ;
    protected Context mContext;
    protected TextView textView;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        aKu();
        d(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        aKu();
    }

    public void displayTip() {
        if (this.dpc != null) {
            this.dpc.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.dpc != null) {
            this.dpc.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.dpc != null) {
            this.dpc.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.dpf.setVisibility(8);
    }

    public void displayArrow() {
        this.dpf.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.dpf.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hRI.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.ds26);
            this.hRI.setLayoutParams(layoutParams);
            this.hRJ.setText("");
            this.hRJ.setVisibility(8);
            return;
        }
        this.hRI.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hRI.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.ds10);
        this.hRI.setLayoutParams(layoutParams2);
        this.hRJ.setText(str);
        this.hRJ.setVisibility(0);
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
        this.dpc.setText(str);
    }

    public CharSequence getTip() {
        return this.dpc.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.dpc.setBackgroundDrawable(drawable);
    }

    protected void aKu() {
        LayoutInflater.from(this.mContext).inflate(R.layout.image_problem_item_view, (ViewGroup) this, true);
        this.dpb = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.dpc = (TextView) findViewById(R.id.tip);
        this.dpf = (ImageView) findViewById(R.id.arrow2);
        this.hRI = (LinearLayout) findViewById(R.id.ll_container);
        this.hRJ = (TextView) findViewById(R.id.tv_help);
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
            this.dpc.setText(string2);
        }
        if (color2 > -1) {
            this.dpc.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.dpb.setClickable(false);
        this.dpb.setFocusable(false);
        this.dpf.setVisibility(4);
    }
}
