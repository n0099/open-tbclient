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
/* loaded from: classes.dex */
public class ImageProblemItemView extends FrameLayout {
    protected LinearLayout avC;
    protected TextView avD;
    protected TextView avE;
    protected ImageView avJ;
    protected LinearLayout dnG;
    protected TextView dnH;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        BM();
        d(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        BM();
    }

    public void displayTip() {
        if (this.avE != null) {
            this.avE.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.avE != null) {
            this.avE.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.avE != null) {
            this.avE.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.avJ.setVisibility(8);
    }

    public void displayArrow() {
        this.avJ.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.avJ.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dnG.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(w.f.ds26);
            this.dnG.setLayoutParams(layoutParams);
            this.dnH.setText("");
            this.dnH.setVisibility(8);
            return;
        }
        this.dnG.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dnG.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(w.f.ds10);
        this.dnG.setLayoutParams(layoutParams2);
        this.dnH.setText(str);
        this.dnH.setVisibility(0);
    }

    public void setStatus(int i) {
        if (i == 1) {
            this.avD.setTextColor(getResources().getColor(w.e.cp_cont_b));
        } else if (i == 2) {
            this.avD.setTextColor(getResources().getColor(w.e.cp_link_tip_d));
        } else if (i == 3) {
            this.avD.setTextColor(getResources().getColor(w.e.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.avD.setText(str);
    }

    public void setText(int i) {
        this.avD.setText(i);
    }

    public void setTip(String str) {
        this.avE.setText(str);
    }

    public CharSequence getTip() {
        return this.avE.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.avE.setBackgroundDrawable(drawable);
    }

    protected void BM() {
        LayoutInflater.from(this.mContext).inflate(w.j.image_problem_item_view, (ViewGroup) this, true);
        this.avC = (LinearLayout) findViewById(w.h.container);
        this.avD = (TextView) findViewById(w.h.text);
        this.avE = (TextView) findViewById(w.h.tip);
        this.avJ = (ImageView) findViewById(w.h.arrow2);
        this.dnG = (LinearLayout) findViewById(w.h.ll_container);
        this.dnH = (TextView) findViewById(w.h.tv_help);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, w.n.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.avD.setText(string);
        }
        if (color > -1) {
            this.avD.setTextColor(color);
        }
        if (string2 != null) {
            this.avE.setText(string2);
        }
        if (color2 > -1) {
            this.avE.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.avC.setClickable(false);
        this.avC.setFocusable(false);
        this.avJ.setVisibility(4);
    }
}
