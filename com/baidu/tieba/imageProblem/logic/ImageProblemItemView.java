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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ImageProblemItemView extends FrameLayout {
    protected LinearLayout amf;
    protected TextView amg;
    protected TextView amh;
    protected ImageView amk;
    protected LinearLayout cBA;
    protected TextView cBB;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        zI();
        d(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        zI();
    }

    public void displayTip() {
        if (this.amh != null) {
            this.amh.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.amh != null) {
            this.amh.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.amh != null) {
            this.amh.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.amk.setVisibility(8);
    }

    public void displayArrow() {
        this.amk.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.amk.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cBA.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(t.e.ds26);
            this.cBA.setLayoutParams(layoutParams);
            this.cBB.setText("");
            this.cBB.setVisibility(8);
            return;
        }
        this.cBA.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cBA.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(t.e.ds10);
        this.cBA.setLayoutParams(layoutParams2);
        this.cBB.setText(str);
        this.cBB.setVisibility(0);
    }

    public void setStatus(int i) {
        if (i == 1) {
            this.amg.setTextColor(getResources().getColor(t.d.cp_cont_b));
        } else if (i == 2) {
            this.amg.setTextColor(getResources().getColor(t.d.cp_link_tip_d));
        } else if (i == 3) {
            this.amg.setTextColor(getResources().getColor(t.d.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.amg.setText(str);
    }

    public void setText(int i) {
        this.amg.setText(i);
    }

    public void setTip(String str) {
        this.amh.setText(str);
    }

    public CharSequence getTip() {
        return this.amh.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.amh.setBackgroundDrawable(drawable);
    }

    protected void zI() {
        LayoutInflater.from(this.mContext).inflate(t.h.image_problem_item_view, (ViewGroup) this, true);
        this.amf = (LinearLayout) findViewById(t.g.container);
        this.amg = (TextView) findViewById(t.g.text);
        this.amh = (TextView) findViewById(t.g.tip);
        this.amk = (ImageView) findViewById(t.g.arrow2);
        this.cBA = (LinearLayout) findViewById(t.g.ll_container);
        this.cBB = (TextView) findViewById(t.g.tv_help);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, t.l.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.amg.setText(string);
        }
        if (color > -1) {
            this.amg.setTextColor(color);
        }
        if (string2 != null) {
            this.amh.setText(string2);
        }
        if (color2 > -1) {
            this.amh.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.amf.setClickable(false);
        this.amf.setFocusable(false);
        this.amk.setVisibility(4);
    }
}
