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
    protected LinearLayout avs;
    protected TextView avt;
    protected TextView avu;
    protected ImageView avz;
    protected LinearLayout dpw;
    protected TextView dpx;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        AQ();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        AQ();
    }

    public void displayTip() {
        if (this.avu != null) {
            this.avu.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.avu != null) {
            this.avu.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.avu != null) {
            this.avu.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.avz.setVisibility(8);
    }

    public void displayArrow() {
        this.avz.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.avz.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dpw.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(w.f.ds26);
            this.dpw.setLayoutParams(layoutParams);
            this.dpx.setText("");
            this.dpx.setVisibility(8);
            return;
        }
        this.dpw.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dpw.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(w.f.ds10);
        this.dpw.setLayoutParams(layoutParams2);
        this.dpx.setText(str);
        this.dpx.setVisibility(0);
    }

    public void setStatus(int i) {
        if (i == 1) {
            this.avt.setTextColor(getResources().getColor(w.e.cp_cont_b));
        } else if (i == 2) {
            this.avt.setTextColor(getResources().getColor(w.e.cp_link_tip_d));
        } else if (i == 3) {
            this.avt.setTextColor(getResources().getColor(w.e.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.avt.setText(str);
    }

    public void setText(int i) {
        this.avt.setText(i);
    }

    public void setTip(String str) {
        this.avu.setText(str);
    }

    public CharSequence getTip() {
        return this.avu.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.avu.setBackgroundDrawable(drawable);
    }

    protected void AQ() {
        LayoutInflater.from(this.mContext).inflate(w.j.image_problem_item_view, (ViewGroup) this, true);
        this.avs = (LinearLayout) findViewById(w.h.container);
        this.avt = (TextView) findViewById(w.h.text);
        this.avu = (TextView) findViewById(w.h.tip);
        this.avz = (ImageView) findViewById(w.h.arrow2);
        this.dpw = (LinearLayout) findViewById(w.h.ll_container);
        this.dpx = (TextView) findViewById(w.h.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, w.n.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.avt.setText(string);
        }
        if (color > -1) {
            this.avt.setTextColor(color);
        }
        if (string2 != null) {
            this.avu.setText(string2);
        }
        if (color2 > -1) {
            this.avu.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.avs.setClickable(false);
        this.avs.setFocusable(false);
        this.avz.setVisibility(4);
    }
}
