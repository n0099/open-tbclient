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
import com.baidu.tieba.R;
import com.baidu.tieba.c;
/* loaded from: classes2.dex */
public class ImageProblemItemView extends FrameLayout {
    protected ImageView agT;
    protected TextView aif;
    protected LinearLayout cmN;
    protected TextView cmO;
    protected LinearLayout gTN;
    protected TextView gTO;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        apr();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        apr();
    }

    public void displayTip() {
        if (this.cmO != null) {
            this.cmO.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.cmO != null) {
            this.cmO.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.cmO != null) {
            this.cmO.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.agT.setVisibility(8);
    }

    public void displayArrow() {
        this.agT.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.agT.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gTN.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.ds26);
            this.gTN.setLayoutParams(layoutParams);
            this.gTO.setText("");
            this.gTO.setVisibility(8);
            return;
        }
        this.gTN.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gTN.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.ds10);
        this.gTN.setLayoutParams(layoutParams2);
        this.gTO.setText(str);
        this.gTO.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.aif.setTextColor(getResources().getColor(R.color.cp_cont_b));
        } else if (i == 2) {
            this.aif.setTextColor(getResources().getColor(R.color.cp_link_tip_d));
        } else if (i == 3) {
            this.aif.setTextColor(getResources().getColor(R.color.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.aif.setText(str);
    }

    public void setText(int i) {
        this.aif.setText(i);
    }

    public void setTip(String str) {
        this.cmO.setText(str);
    }

    public CharSequence getTip() {
        return this.cmO.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.cmO.setBackgroundDrawable(drawable);
    }

    protected void apr() {
        LayoutInflater.from(this.mContext).inflate(R.layout.image_problem_item_view, (ViewGroup) this, true);
        this.cmN = (LinearLayout) findViewById(R.id.container);
        this.aif = (TextView) findViewById(R.id.text);
        this.cmO = (TextView) findViewById(R.id.tip);
        this.agT = (ImageView) findViewById(R.id.arrow2);
        this.gTN = (LinearLayout) findViewById(R.id.ll_container);
        this.gTO = (TextView) findViewById(R.id.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, c.a.TbSettingView);
        String string = obtainStyledAttributes.getString(5);
        int color = obtainStyledAttributes.getColor(3, -1);
        String string2 = obtainStyledAttributes.getString(1);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.aif.setText(string);
        }
        if (color > -1) {
            this.aif.setTextColor(color);
        }
        if (string2 != null) {
            this.cmO.setText(string2);
        }
        if (color2 > -1) {
            this.cmO.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.cmN.setClickable(false);
        this.cmN.setFocusable(false);
        this.agT.setVisibility(4);
    }
}
