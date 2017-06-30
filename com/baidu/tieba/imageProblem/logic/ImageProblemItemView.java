package com.baidu.tieba.imageProblem.logic;

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
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class ImageProblemItemView extends FrameLayout {
    protected ImageView awC;
    protected LinearLayout awv;
    protected TextView aww;
    protected TextView awx;
    protected LinearLayout dxr;
    protected TextView dxs;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Bl();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        Bl();
    }

    public void displayTip() {
        if (this.awx != null) {
            this.awx.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.awx != null) {
            this.awx.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.awx != null) {
            this.awx.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.awC.setVisibility(8);
    }

    public void displayArrow() {
        this.awC.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.awC.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dxr.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(w.f.ds26);
            this.dxr.setLayoutParams(layoutParams);
            this.dxs.setText("");
            this.dxs.setVisibility(8);
            return;
        }
        this.dxr.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dxr.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(w.f.ds10);
        this.dxr.setLayoutParams(layoutParams2);
        this.dxs.setText(str);
        this.dxs.setVisibility(0);
    }

    public void setStatus(int i) {
        if (i == 1) {
            this.aww.setTextColor(getResources().getColor(w.e.cp_cont_b));
        } else if (i == 2) {
            this.aww.setTextColor(getResources().getColor(w.e.cp_link_tip_d));
        } else if (i == 3) {
            this.aww.setTextColor(getResources().getColor(w.e.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.aww.setText(str);
    }

    public void setText(int i) {
        this.aww.setText(i);
    }

    public void setTip(String str) {
        this.awx.setText(str);
    }

    public CharSequence getTip() {
        return this.awx.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.awx.setBackgroundDrawable(drawable);
    }

    protected void Bl() {
        LayoutInflater.from(this.mContext).inflate(w.j.image_problem_item_view, (ViewGroup) this, true);
        this.awv = (LinearLayout) findViewById(w.h.container);
        this.aww = (TextView) findViewById(w.h.text);
        this.awx = (TextView) findViewById(w.h.tip);
        this.awC = (ImageView) findViewById(w.h.arrow2);
        this.dxr = (LinearLayout) findViewById(w.h.ll_container);
        this.dxs = (TextView) findViewById(w.h.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, w.n.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.aww.setText(string);
        }
        if (color > -1) {
            this.aww.setTextColor(color);
        }
        if (string2 != null) {
            this.awx.setText(string2);
        }
        if (color2 > -1) {
            this.awx.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.awv.setClickable(false);
        this.awv.setFocusable(false);
        this.awC.setVisibility(4);
    }
}
