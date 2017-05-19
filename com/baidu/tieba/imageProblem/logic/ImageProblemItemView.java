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
    protected LinearLayout avI;
    protected TextView avJ;
    protected TextView avK;
    protected ImageView avP;
    protected LinearLayout dkc;
    protected TextView dkd;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        AX();
        d(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        AX();
    }

    public void displayTip() {
        if (this.avK != null) {
            this.avK.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.avK != null) {
            this.avK.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.avK != null) {
            this.avK.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.avP.setVisibility(8);
    }

    public void displayArrow() {
        this.avP.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.avP.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dkc.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(w.f.ds26);
            this.dkc.setLayoutParams(layoutParams);
            this.dkd.setText("");
            this.dkd.setVisibility(8);
            return;
        }
        this.dkc.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dkc.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(w.f.ds10);
        this.dkc.setLayoutParams(layoutParams2);
        this.dkd.setText(str);
        this.dkd.setVisibility(0);
    }

    public void setStatus(int i) {
        if (i == 1) {
            this.avJ.setTextColor(getResources().getColor(w.e.cp_cont_b));
        } else if (i == 2) {
            this.avJ.setTextColor(getResources().getColor(w.e.cp_link_tip_d));
        } else if (i == 3) {
            this.avJ.setTextColor(getResources().getColor(w.e.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.avJ.setText(str);
    }

    public void setText(int i) {
        this.avJ.setText(i);
    }

    public void setTip(String str) {
        this.avK.setText(str);
    }

    public CharSequence getTip() {
        return this.avK.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.avK.setBackgroundDrawable(drawable);
    }

    protected void AX() {
        LayoutInflater.from(this.mContext).inflate(w.j.image_problem_item_view, (ViewGroup) this, true);
        this.avI = (LinearLayout) findViewById(w.h.container);
        this.avJ = (TextView) findViewById(w.h.text);
        this.avK = (TextView) findViewById(w.h.tip);
        this.avP = (ImageView) findViewById(w.h.arrow2);
        this.dkc = (LinearLayout) findViewById(w.h.ll_container);
        this.dkd = (TextView) findViewById(w.h.tv_help);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, w.n.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.avJ.setText(string);
        }
        if (color > -1) {
            this.avJ.setTextColor(color);
        }
        if (string2 != null) {
            this.avK.setText(string2);
        }
        if (color2 > -1) {
            this.avK.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.avI.setClickable(false);
        this.avI.setFocusable(false);
        this.avP.setVisibility(4);
    }
}
