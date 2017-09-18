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
    protected LinearLayout axO;
    protected TextView axP;
    protected TextView axQ;
    protected ImageView axV;
    protected LinearLayout dQF;
    protected TextView dQG;
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
        if (this.axQ != null) {
            this.axQ.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.axQ != null) {
            this.axQ.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.axQ != null) {
            this.axQ.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.axV.setVisibility(8);
    }

    public void displayArrow() {
        this.axV.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.axV.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dQF.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(d.f.ds26);
            this.dQF.setLayoutParams(layoutParams);
            this.dQG.setText("");
            this.dQG.setVisibility(8);
            return;
        }
        this.dQF.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dQF.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(d.f.ds10);
        this.dQF.setLayoutParams(layoutParams2);
        this.dQG.setText(str);
        this.dQG.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.axP.setTextColor(getResources().getColor(d.e.cp_cont_b));
        } else if (i == 2) {
            this.axP.setTextColor(getResources().getColor(d.e.cp_link_tip_d));
        } else if (i == 3) {
            this.axP.setTextColor(getResources().getColor(d.e.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.axP.setText(str);
    }

    public void setText(int i) {
        this.axP.setText(i);
    }

    public void setTip(String str) {
        this.axQ.setText(str);
    }

    public CharSequence getTip() {
        return this.axQ.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.axQ.setBackgroundDrawable(drawable);
    }

    protected void Bz() {
        LayoutInflater.from(this.mContext).inflate(d.j.image_problem_item_view, (ViewGroup) this, true);
        this.axO = (LinearLayout) findViewById(d.h.container);
        this.axP = (TextView) findViewById(d.h.text);
        this.axQ = (TextView) findViewById(d.h.tip);
        this.axV = (ImageView) findViewById(d.h.arrow2);
        this.dQF = (LinearLayout) findViewById(d.h.ll_container);
        this.dQG = (TextView) findViewById(d.h.tv_help);
    }

    protected void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.n.TbSettingView);
        String string = obtainStyledAttributes.getString(d.n.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.n.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(d.n.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.n.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.axP.setText(string);
        }
        if (color > -1) {
            this.axP.setTextColor(color);
        }
        if (string2 != null) {
            this.axQ.setText(string2);
        }
        if (color2 > -1) {
            this.axQ.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.axO.setClickable(false);
        this.axO.setFocusable(false);
        this.axV.setVisibility(4);
    }
}
