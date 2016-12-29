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
    protected LinearLayout aqM;
    protected TextView aqN;
    protected TextView aqO;
    protected ImageView aqS;
    protected LinearLayout dfF;
    protected TextView dfG;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Ba();
        d(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        Ba();
    }

    public void displayTip() {
        if (this.aqO != null) {
            this.aqO.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.aqO != null) {
            this.aqO.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.aqO != null) {
            this.aqO.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.aqS.setVisibility(8);
    }

    public void displayArrow() {
        this.aqS.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.aqS.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dfF.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(r.e.ds26);
            this.dfF.setLayoutParams(layoutParams);
            this.dfG.setText("");
            this.dfG.setVisibility(8);
            return;
        }
        this.dfF.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dfF.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(r.e.ds10);
        this.dfF.setLayoutParams(layoutParams2);
        this.dfG.setText(str);
        this.dfG.setVisibility(0);
    }

    public void setStatus(int i) {
        if (i == 1) {
            this.aqN.setTextColor(getResources().getColor(r.d.cp_cont_b));
        } else if (i == 2) {
            this.aqN.setTextColor(getResources().getColor(r.d.cp_link_tip_d));
        } else if (i == 3) {
            this.aqN.setTextColor(getResources().getColor(r.d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.aqN.setText(str);
    }

    public void setText(int i) {
        this.aqN.setText(i);
    }

    public void setTip(String str) {
        this.aqO.setText(str);
    }

    public CharSequence getTip() {
        return this.aqO.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.aqO.setBackgroundDrawable(drawable);
    }

    protected void Ba() {
        LayoutInflater.from(this.mContext).inflate(r.h.image_problem_item_view, (ViewGroup) this, true);
        this.aqM = (LinearLayout) findViewById(r.g.container);
        this.aqN = (TextView) findViewById(r.g.text);
        this.aqO = (TextView) findViewById(r.g.tip);
        this.aqS = (ImageView) findViewById(r.g.arrow2);
        this.dfF = (LinearLayout) findViewById(r.g.ll_container);
        this.dfG = (TextView) findViewById(r.g.tv_help);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, r.l.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.aqN.setText(string);
        }
        if (color > -1) {
            this.aqN.setTextColor(color);
        }
        if (string2 != null) {
            this.aqO.setText(string2);
        }
        if (color2 > -1) {
            this.aqO.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.aqM.setClickable(false);
        this.aqM.setFocusable(false);
        this.aqS.setVisibility(4);
    }
}
