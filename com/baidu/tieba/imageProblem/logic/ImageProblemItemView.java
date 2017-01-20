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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ImageProblemItemView extends FrameLayout {
    protected LinearLayout apS;
    protected TextView apT;
    protected TextView apU;
    protected ImageView apY;
    protected LinearLayout dmO;
    protected TextView dmP;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        AV();
        d(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        AV();
    }

    public void displayTip() {
        if (this.apU != null) {
            this.apU.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.apU != null) {
            this.apU.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.apU != null) {
            this.apU.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.apY.setVisibility(8);
    }

    public void displayArrow() {
        this.apY.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.apY.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dmO.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(r.f.ds26);
            this.dmO.setLayoutParams(layoutParams);
            this.dmP.setText("");
            this.dmP.setVisibility(8);
            return;
        }
        this.dmO.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dmO.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(r.f.ds10);
        this.dmO.setLayoutParams(layoutParams2);
        this.dmP.setText(str);
        this.dmP.setVisibility(0);
    }

    public void setStatus(int i) {
        if (i == 1) {
            this.apT.setTextColor(getResources().getColor(r.e.cp_cont_b));
        } else if (i == 2) {
            this.apT.setTextColor(getResources().getColor(r.e.cp_link_tip_d));
        } else if (i == 3) {
            this.apT.setTextColor(getResources().getColor(r.e.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.apT.setText(str);
    }

    public void setText(int i) {
        this.apT.setText(i);
    }

    public void setTip(String str) {
        this.apU.setText(str);
    }

    public CharSequence getTip() {
        return this.apU.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.apU.setBackgroundDrawable(drawable);
    }

    protected void AV() {
        LayoutInflater.from(this.mContext).inflate(r.j.image_problem_item_view, (ViewGroup) this, true);
        this.apS = (LinearLayout) findViewById(r.h.container);
        this.apT = (TextView) findViewById(r.h.text);
        this.apU = (TextView) findViewById(r.h.tip);
        this.apY = (ImageView) findViewById(r.h.arrow2);
        this.dmO = (LinearLayout) findViewById(r.h.ll_container);
        this.dmP = (TextView) findViewById(r.h.tv_help);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, r.n.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.apT.setText(string);
        }
        if (color > -1) {
            this.apT.setTextColor(color);
        }
        if (string2 != null) {
            this.apU.setText(string2);
        }
        if (color2 > -1) {
            this.apU.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.apS.setClickable(false);
        this.apS.setFocusable(false);
        this.apY.setVisibility(4);
    }
}
