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
    protected LinearLayout ayZ;
    protected TextView aza;
    protected TextView azb;
    protected ImageView azf;
    protected LinearLayout erw;
    protected TextView erx;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Cc();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        Cc();
    }

    public void displayTip() {
        if (this.azb != null) {
            this.azb.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.azb != null) {
            this.azb.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.azb != null) {
            this.azb.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.azf.setVisibility(8);
    }

    public void displayArrow() {
        this.azf.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.azf.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.erw.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(d.e.ds26);
            this.erw.setLayoutParams(layoutParams);
            this.erx.setText("");
            this.erx.setVisibility(8);
            return;
        }
        this.erw.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.erw.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(d.e.ds10);
        this.erw.setLayoutParams(layoutParams2);
        this.erx.setText(str);
        this.erx.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.aza.setTextColor(getResources().getColor(d.C0126d.cp_cont_b));
        } else if (i == 2) {
            this.aza.setTextColor(getResources().getColor(d.C0126d.cp_link_tip_d));
        } else if (i == 3) {
            this.aza.setTextColor(getResources().getColor(d.C0126d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.aza.setText(str);
    }

    public void setText(int i) {
        this.aza.setText(i);
    }

    public void setTip(String str) {
        this.azb.setText(str);
    }

    public CharSequence getTip() {
        return this.azb.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.azb.setBackgroundDrawable(drawable);
    }

    protected void Cc() {
        LayoutInflater.from(this.mContext).inflate(d.i.image_problem_item_view, (ViewGroup) this, true);
        this.ayZ = (LinearLayout) findViewById(d.g.container);
        this.aza = (TextView) findViewById(d.g.text);
        this.azb = (TextView) findViewById(d.g.tip);
        this.azf = (ImageView) findViewById(d.g.arrow2);
        this.erw = (LinearLayout) findViewById(d.g.ll_container);
        this.erx = (TextView) findViewById(d.g.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.m.TbSettingView);
        String string = obtainStyledAttributes.getString(d.m.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.m.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(d.m.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.m.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.aza.setText(string);
        }
        if (color > -1) {
            this.aza.setTextColor(color);
        }
        if (string2 != null) {
            this.azb.setText(string2);
        }
        if (color2 > -1) {
            this.azb.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.ayZ.setClickable(false);
        this.ayZ.setFocusable(false);
        this.azf.setVisibility(4);
    }
}
