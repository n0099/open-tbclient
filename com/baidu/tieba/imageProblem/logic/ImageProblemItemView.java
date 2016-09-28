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
    protected LinearLayout aqp;
    protected TextView aqq;
    protected TextView aqr;
    protected ImageView aqv;
    protected LinearLayout dxd;
    protected TextView dxe;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Bg();
        d(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        Bg();
    }

    public void displayTip() {
        if (this.aqr != null) {
            this.aqr.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.aqr != null) {
            this.aqr.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.aqr != null) {
            this.aqr.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.aqv.setVisibility(8);
    }

    public void displayArrow() {
        this.aqv.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.aqv.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dxd.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(r.e.ds26);
            this.dxd.setLayoutParams(layoutParams);
            this.dxe.setText("");
            this.dxe.setVisibility(8);
            return;
        }
        this.dxd.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dxd.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(r.e.ds10);
        this.dxd.setLayoutParams(layoutParams2);
        this.dxe.setText(str);
        this.dxe.setVisibility(0);
    }

    public void setStatus(int i) {
        if (i == 1) {
            this.aqq.setTextColor(getResources().getColor(r.d.cp_cont_b));
        } else if (i == 2) {
            this.aqq.setTextColor(getResources().getColor(r.d.cp_link_tip_d));
        } else if (i == 3) {
            this.aqq.setTextColor(getResources().getColor(r.d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.aqq.setText(str);
    }

    public void setText(int i) {
        this.aqq.setText(i);
    }

    public void setTip(String str) {
        this.aqr.setText(str);
    }

    public CharSequence getTip() {
        return this.aqr.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.aqr.setBackgroundDrawable(drawable);
    }

    protected void Bg() {
        LayoutInflater.from(this.mContext).inflate(r.h.image_problem_item_view, (ViewGroup) this, true);
        this.aqp = (LinearLayout) findViewById(r.g.container);
        this.aqq = (TextView) findViewById(r.g.text);
        this.aqr = (TextView) findViewById(r.g.tip);
        this.aqv = (ImageView) findViewById(r.g.arrow2);
        this.dxd = (LinearLayout) findViewById(r.g.ll_container);
        this.dxe = (TextView) findViewById(r.g.tv_help);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, r.l.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.aqq.setText(string);
        }
        if (color > -1) {
            this.aqq.setTextColor(color);
        }
        if (string2 != null) {
            this.aqr.setText(string2);
        }
        if (color2 > -1) {
            this.aqr.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.aqp.setClickable(false);
        this.aqp.setFocusable(false);
        this.aqv.setVisibility(4);
    }
}
