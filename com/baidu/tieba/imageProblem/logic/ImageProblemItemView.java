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
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ImageProblemItemView extends FrameLayout {
    protected LinearLayout bmf;
    protected TextView bmg;
    protected TextView bmh;
    protected ImageView bml;
    protected LinearLayout ePu;
    protected TextView ePv;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        IZ();
        d(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        IZ();
    }

    public void displayTip() {
        if (this.bmh != null) {
            this.bmh.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.bmh != null) {
            this.bmh.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.bmh != null) {
            this.bmh.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.bml.setVisibility(8);
    }

    public void displayArrow() {
        this.bml.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.bml.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ePu.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(d.e.ds26);
            this.ePu.setLayoutParams(layoutParams);
            this.ePv.setText("");
            this.ePv.setVisibility(8);
            return;
        }
        this.ePu.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ePu.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(d.e.ds10);
        this.ePu.setLayoutParams(layoutParams2);
        this.ePv.setText(str);
        this.ePv.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.bmg.setTextColor(getResources().getColor(d.C0108d.cp_cont_b));
        } else if (i == 2) {
            this.bmg.setTextColor(getResources().getColor(d.C0108d.cp_link_tip_d));
        } else if (i == 3) {
            this.bmg.setTextColor(getResources().getColor(d.C0108d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.bmg.setText(str);
    }

    public void setText(int i) {
        this.bmg.setText(i);
    }

    public void setTip(String str) {
        this.bmh.setText(str);
    }

    public CharSequence getTip() {
        return this.bmh.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.bmh.setBackgroundDrawable(drawable);
    }

    protected void IZ() {
        LayoutInflater.from(this.mContext).inflate(d.h.image_problem_item_view, (ViewGroup) this, true);
        this.bmf = (LinearLayout) findViewById(d.g.container);
        this.bmg = (TextView) findViewById(d.g.text);
        this.bmh = (TextView) findViewById(d.g.tip);
        this.bml = (ImageView) findViewById(d.g.arrow2);
        this.ePu = (LinearLayout) findViewById(d.g.ll_container);
        this.ePv = (TextView) findViewById(d.g.tv_help);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.bmg.setText(string);
        }
        if (color > -1) {
            this.bmg.setTextColor(color);
        }
        if (string2 != null) {
            this.bmh.setText(string2);
        }
        if (color2 > -1) {
            this.bmh.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.bmf.setClickable(false);
        this.bmf.setFocusable(false);
        this.bml.setVisibility(4);
    }
}
