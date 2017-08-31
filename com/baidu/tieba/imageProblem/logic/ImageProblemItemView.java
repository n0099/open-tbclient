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
    protected LinearLayout axR;
    protected TextView axS;
    protected TextView axT;
    protected ImageView axY;
    protected LinearLayout dPL;
    protected TextView dPM;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Bz();
        b(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        Bz();
    }

    public void displayTip() {
        if (this.axT != null) {
            this.axT.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.axT != null) {
            this.axT.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.axT != null) {
            this.axT.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.axY.setVisibility(8);
    }

    public void displayArrow() {
        this.axY.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.axY.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dPL.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(d.f.ds26);
            this.dPL.setLayoutParams(layoutParams);
            this.dPM.setText("");
            this.dPM.setVisibility(8);
            return;
        }
        this.dPL.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dPL.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(d.f.ds10);
        this.dPL.setLayoutParams(layoutParams2);
        this.dPM.setText(str);
        this.dPM.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.axS.setTextColor(getResources().getColor(d.e.cp_cont_b));
        } else if (i == 2) {
            this.axS.setTextColor(getResources().getColor(d.e.cp_link_tip_d));
        } else if (i == 3) {
            this.axS.setTextColor(getResources().getColor(d.e.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.axS.setText(str);
    }

    public void setText(int i) {
        this.axS.setText(i);
    }

    public void setTip(String str) {
        this.axT.setText(str);
    }

    public CharSequence getTip() {
        return this.axT.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.axT.setBackgroundDrawable(drawable);
    }

    protected void Bz() {
        LayoutInflater.from(this.mContext).inflate(d.j.image_problem_item_view, (ViewGroup) this, true);
        this.axR = (LinearLayout) findViewById(d.h.container);
        this.axS = (TextView) findViewById(d.h.text);
        this.axT = (TextView) findViewById(d.h.tip);
        this.axY = (ImageView) findViewById(d.h.arrow2);
        this.dPL = (LinearLayout) findViewById(d.h.ll_container);
        this.dPM = (TextView) findViewById(d.h.tv_help);
    }

    protected void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.n.TbSettingView);
        String string = obtainStyledAttributes.getString(d.n.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.n.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(d.n.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.n.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.axS.setText(string);
        }
        if (color > -1) {
            this.axS.setTextColor(color);
        }
        if (string2 != null) {
            this.axT.setText(string2);
        }
        if (color2 > -1) {
            this.axT.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.axR.setClickable(false);
        this.axR.setFocusable(false);
        this.axY.setVisibility(4);
    }
}
