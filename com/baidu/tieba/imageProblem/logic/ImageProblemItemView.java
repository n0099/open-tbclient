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
    protected LinearLayout avm;
    protected TextView avn;
    protected TextView avo;
    protected ImageView avt;
    protected LinearLayout dpi;
    protected TextView dpj;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Bo();
        d(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        Bo();
    }

    public void displayTip() {
        if (this.avo != null) {
            this.avo.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.avo != null) {
            this.avo.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.avo != null) {
            this.avo.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.avt.setVisibility(8);
    }

    public void displayArrow() {
        this.avt.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.avt.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dpi.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(w.f.ds26);
            this.dpi.setLayoutParams(layoutParams);
            this.dpj.setText("");
            this.dpj.setVisibility(8);
            return;
        }
        this.dpi.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dpi.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(w.f.ds10);
        this.dpi.setLayoutParams(layoutParams2);
        this.dpj.setText(str);
        this.dpj.setVisibility(0);
    }

    public void setStatus(int i) {
        if (i == 1) {
            this.avn.setTextColor(getResources().getColor(w.e.cp_cont_b));
        } else if (i == 2) {
            this.avn.setTextColor(getResources().getColor(w.e.cp_link_tip_d));
        } else if (i == 3) {
            this.avn.setTextColor(getResources().getColor(w.e.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.avn.setText(str);
    }

    public void setText(int i) {
        this.avn.setText(i);
    }

    public void setTip(String str) {
        this.avo.setText(str);
    }

    public CharSequence getTip() {
        return this.avo.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.avo.setBackgroundDrawable(drawable);
    }

    protected void Bo() {
        LayoutInflater.from(this.mContext).inflate(w.j.image_problem_item_view, (ViewGroup) this, true);
        this.avm = (LinearLayout) findViewById(w.h.container);
        this.avn = (TextView) findViewById(w.h.text);
        this.avo = (TextView) findViewById(w.h.tip);
        this.avt = (ImageView) findViewById(w.h.arrow2);
        this.dpi = (LinearLayout) findViewById(w.h.ll_container);
        this.dpj = (TextView) findViewById(w.h.tv_help);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, w.n.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.avn.setText(string);
        }
        if (color > -1) {
            this.avn.setTextColor(color);
        }
        if (string2 != null) {
            this.avo.setText(string2);
        }
        if (color2 > -1) {
            this.avo.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.avm.setClickable(false);
        this.avm.setFocusable(false);
        this.avt.setVisibility(4);
    }
}
